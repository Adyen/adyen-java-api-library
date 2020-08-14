/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.httpclient;

import com.adyen.Client;
import com.adyen.Config;
import com.adyen.enums.Environment;
import com.adyen.model.RequestOptions;
import com.adyen.terminal.security.TerminalCommonNameValidator;
import org.apache.commons.codec.binary.Base64;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import static com.adyen.constants.ApiConstants.RequestProperty.ACCEPT_CHARSET;
import static com.adyen.constants.ApiConstants.RequestProperty.API_KEY;
import static com.adyen.constants.ApiConstants.RequestProperty.APPLICATION_JSON_TYPE;
import static com.adyen.constants.ApiConstants.RequestProperty.CONTENT_TYPE;
import static com.adyen.constants.ApiConstants.RequestProperty.IDEMPOTENCY_KEY;
import static com.adyen.constants.ApiConstants.RequestProperty.METHOD_POST;
import static com.adyen.constants.ApiConstants.RequestProperty.USER_AGENT;

public class HttpURLConnectionClient implements ClientInterface {
    private static final String CHARSET = "UTF-8";

    private Proxy proxy;

    /**
     * Does a POST request.
     * config is used to obtain basic auth username, password and User-Agent
     */
    /**
     * Does a POST request.
     * config is used to obtain basic auth username, password and User-Agent
     */
    @Override
    public String request(String requestUrl, String requestBody, Config config) throws IOException, HTTPClientException {
        return request(requestUrl, requestBody, config, false);
    }

    @Override
    public String request(String endpoint, String json, Config config, boolean isApiKeyRequired) throws IOException, HTTPClientException {
        return request(endpoint, json, config, isApiKeyRequired, null);
    }

    @Override
    public String request(String requestUrl, String requestBody, Config config, boolean isApiKeyRequired, RequestOptions requestOptions) throws IOException, HTTPClientException {
        HttpURLConnection httpConnection = createRequest(requestUrl, config.getApplicationName(), requestOptions);

        if ((config.getTerminalCertificatePath() != null && !config.getTerminalCertificatePath().isEmpty()) || (config.getTerminalCertificateStream() != null)) {
            Environment environment = getEnvironment(config);
            InputStream terminalCertificateStream = config.getTerminalCertificateStream() != null ? config.getTerminalCertificateStream() : this.loadCertificateInputStream(config.getTerminalCertificatePath());
            installCertificateVerifier(httpConnection, terminalCertificateStream);
            installCertificateCommonNameValidator(httpConnection, environment);
        }

        String apiKey = config.getApiKey();
        // Use Api key if required or if provided
        if (isApiKeyRequired || (apiKey != null && !apiKey.isEmpty())) {
            setApiKey(httpConnection, apiKey);
        } else {
            setBasicAuthentication(httpConnection, config.getUsername(), config.getPassword());
        }

        httpConnection.setConnectTimeout(config.getConnectionTimeoutMillis());
        httpConnection.setReadTimeout(config.getReadTimeoutMillis());

        setContentType(httpConnection, APPLICATION_JSON_TYPE);

        return doPostRequest(httpConnection, requestBody);
    }

    private Environment getEnvironment(Config config) {
        //Assume TEST if no environment was set
        return config.getEnvironment() != null ? config.getEnvironment() : Environment.TEST;
    }

    private static String getResponseBody(InputStream responseStream) throws IOException {
        //\A is the beginning of the stream boundary
        Scanner scanner = new Scanner(responseStream, CHARSET).useDelimiter("\\A");

        String rBody = null;
        if (scanner.hasNext()) {
            rBody = scanner.next();
        }

        scanner.close();
        responseStream.close();

        return rBody;
    }

    /**
     * Does a POST request with HTTP key-value pairs
     */
    @Override
    public String post(String requestUrl, Map<String, String> params, Config config) throws IOException, HTTPClientException {
        String postQuery = getQuery(params);
        HttpURLConnection httpConnection = createRequest(requestUrl, config.getApplicationName());
        return doPostRequest(httpConnection, postQuery);
    }

    /**
     * Get HTTP querystring from Map<String,String>
     */
    private String getQuery(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (first) {
                first = false;
            } else {
                result.append("&");
            }

            result.append(URLEncoder.encode(pair.getKey(), CHARSET));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(), CHARSET));
        }

        return result.toString();
    }

    /**
     * Initialize the httpConnection
     */
    private HttpURLConnection createRequest(String requestUrl, String applicationName) throws IOException {
        return createRequest(requestUrl, applicationName, null);
    }

    /**
     * Initialize the httpConnection
     */
    private HttpURLConnection createRequest(String requestUrl, String applicationName, RequestOptions requestOptions) throws IOException {
        URL targetUrl = new URL(requestUrl);
        HttpURLConnection httpConnection;

        // Set proxy if configured
        if (proxy != null) {
            httpConnection = (HttpURLConnection) targetUrl.openConnection(proxy);
        } else {
            httpConnection = (HttpURLConnection) targetUrl.openConnection();
        }
        httpConnection.setUseCaches(false);
        httpConnection.setDoOutput(true);
        httpConnection.setRequestMethod(METHOD_POST);

        httpConnection.setRequestProperty(ACCEPT_CHARSET, CHARSET);
        httpConnection.setRequestProperty(USER_AGENT, String.format("%s %s/%s", applicationName, Client.LIB_NAME, Client.LIB_VERSION));
        if (requestOptions != null && requestOptions.getIdempotencyKey() != null) {
            httpConnection.setRequestProperty(IDEMPOTENCY_KEY, requestOptions.getIdempotencyKey());
        }
        return httpConnection;
    }

    /**
     * Adds Basic Authentication headers
     */
    private HttpURLConnection setBasicAuthentication(HttpURLConnection httpConnection, String username, String password) {
        // set basic authentication
        String authString = username + ":" + password;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);

        httpConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
        return httpConnection;
    }

    /**
     * Sets content type
     */
    private HttpURLConnection setContentType(HttpURLConnection httpConnection, String contentType) {
        httpConnection.setRequestProperty(CONTENT_TYPE, contentType);
        return httpConnection;
    }

    /**
     * Sets api key
     */
    private HttpURLConnection setApiKey(HttpURLConnection httpConnection, String apiKey) {
        if (apiKey != null && !apiKey.isEmpty()) {
            httpConnection.setRequestProperty(API_KEY, apiKey);
        }
        return httpConnection;
    }

    /**
     * Does a POST request with raw body
     */
    private String doPostRequest(HttpURLConnection httpConnection, String requestBody) throws IOException, HTTPClientException {
        String response = null;

        OutputStream outputStream = httpConnection.getOutputStream();
        outputStream.write(requestBody.getBytes());
        outputStream.flush();

        int responseCode = httpConnection.getResponseCode();
        Integer[] resultOKHttpStatusCodes = {HttpURLConnection.HTTP_OK, HttpURLConnection.HTTP_ACCEPTED, HttpURLConnection.HTTP_NO_CONTENT, HttpURLConnection.HTTP_CREATED};
        if (!Arrays.asList(resultOKHttpStatusCodes).contains(responseCode)) {
            //Read the response from the error stream
            if (httpConnection.getErrorStream() != null) {
                response = getResponseBody(httpConnection.getErrorStream());
            }

            throw new HTTPClientException(responseCode, "HTTP Exception", httpConnection.getHeaderFields(), response);
        }

        //InputStream is only available on successful requests >= 200 <400
        response = getResponseBody(httpConnection.getInputStream());

        // close the connection
        httpConnection.disconnect();

        return response;
    }

    public Proxy getProxy() {
        return proxy;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    private void installCertificateVerifier(URLConnection connection, InputStream terminalCertificateStream) throws HTTPClientException {
        if (connection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsConnection = (HttpsURLConnection) connection;

            try {
                // Create new KeyStore for the terminal certificate
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                terminalCertificateStream.reset();
                X509Certificate cert = (X509Certificate) certificateFactory.generateCertificate(terminalCertificateStream);

                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null, null);
                keyStore.setCertificateEntry("TerminalCertificate", cert);

                TrustManagerFactory trustFactory =
                        TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustFactory.init(keyStore);
                TrustManager[] trustManagers = trustFactory.getTrustManagers();

                // Install the terminal certificate trust manager
                SSLContext sc = SSLContext.getInstance("SSL");

                sc.init(null, trustManagers, new java.security.SecureRandom());
                httpsConnection.setSSLSocketFactory(sc.getSocketFactory());
            } catch (GeneralSecurityException | IOException e) {
                throw new HTTPClientException("Error installing certificate verifier", e);
            }
        }
    }

    private InputStream loadCertificateInputStream(String terminalCertificatePath) throws HTTPClientException {
        try {
            InputStream certificateInput = new FileInputStream(terminalCertificatePath);
            return certificateInput;
        } catch (IOException e) {
            throw new HTTPClientException("Error loading certificate from path", e);
        }
    }


    private void installCertificateCommonNameValidator(HttpURLConnection connection, final Environment environment) {
        if (connection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsConnection = (HttpsURLConnection) connection;

            HostnameVerifier terminalHostsValid = (host, session) -> {
                try {
                    if (session.getPeerCertificates() != null && session.getPeerCertificates().length > 0) {
                        // Assume the first certificate is the leaf, since chain will be ordered, according to Java documentation:
                        // https://docs.oracle.com/javase/7/docs/api/javax/net/ssl/SSLSession.html#getPeerCertificates()
                        X509Certificate certificate = (X509Certificate) session.getPeerCertificates()[0];
                        return TerminalCommonNameValidator.validateCertificate(certificate, environment);
                    }
                    return false;
                } catch (SSLPeerUnverifiedException e) {
                    e.printStackTrace();
                    return false;
                }
            };
            // Install the terminal-trusting host verifier
            httpsConnection.setHostnameVerifier(terminalHostsValid);
        }
    }
}
