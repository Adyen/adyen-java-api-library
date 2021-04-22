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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.httpclient;

import com.adyen.Config;
import com.adyen.enums.Environment;
import com.adyen.model.RequestOptions;
import com.adyen.terminal.security.TerminalCommonNameValidator;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Map;

import static com.adyen.constants.ApiConstants.HttpMethod.DELETE;
import static com.adyen.constants.ApiConstants.HttpMethod.GET;
import static com.adyen.constants.ApiConstants.HttpMethod.PATCH;
import static com.adyen.constants.ApiConstants.HttpMethod.POST;
import static com.adyen.constants.ApiConstants.RequestProperty.API_KEY;
import static com.adyen.constants.ApiConstants.RequestProperty.APPLICATION_JSON_TYPE;
import static com.adyen.constants.ApiConstants.RequestProperty.CONTENT_TYPE;
import static com.adyen.constants.ApiConstants.RequestProperty.IDEMPOTENCY_KEY;

public class ApacheHttpClient implements ClientInterface {

    private static final String CHARSET = "UTF-8";
    private Proxy proxy;

    public Proxy getProxy() {
        return proxy;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public String request(String endpoint, String requestBody, Config config) throws IOException, HTTPClientException {
        return request(endpoint, requestBody, config, false);
    }

    @Override
    public String request(String endpoint, String requestBody, Config config, boolean isApiKeyRequired) throws IOException, HTTPClientException {
        return request(endpoint, requestBody, config, isApiKeyRequired, null);
    }

    @Override
    public String request(String endpoint, String requestBody, Config config, boolean isApiKeyRequired, RequestOptions requestOptions) throws IOException, HTTPClientException {
        return request(endpoint, requestBody, config, isApiKeyRequired, null, POST);
    }

    @Override
    public String request(String endpoint, String requestBody, Config config, boolean isApiKeyRequired, RequestOptions requestOptions, String httpMethod) throws IOException, HTTPClientException {
        return request(endpoint, requestBody, config, isApiKeyRequired, null, httpMethod, null);
    }

    @Override
    public String request(String endpoint, String requestBody, Config config, boolean isApiKeyRequired, RequestOptions requestOptions, String httpMethod, Map<String, Object> params) throws IOException, HTTPClientException {
        if (params != null && !params.isEmpty()) {
            String queryParams = getQueryNew(params);
            endpoint = endpoint + "/" + queryParams;
        }

        ApacheResponse responseBody;

        try (CloseableHttpClient httpclient = createCloseableHttpClient(config)) {
            HttpRequestBase httpUriRequest;
            StringEntity requestEntity = null;

            if (requestBody != null && !requestBody.isEmpty()) {
                requestEntity = new StringEntity(requestBody);
            }
            if (GET.equals(httpMethod)) {
                httpUriRequest = new HttpGet(endpoint);
            } else if (PATCH.equals(httpMethod)) {
                HttpPatch httpPatch = new HttpPatch(endpoint);
                httpPatch.setEntity(requestEntity);
                httpUriRequest = httpPatch;
            } else if (DELETE.equals(httpMethod)) {
                httpUriRequest = new HttpDelete(endpoint);
            } else {
                HttpPost httpPost = new HttpPost(endpoint);
                httpPost.setEntity(requestEntity);
                httpUriRequest = httpPost;
            }

            RequestConfig.Builder builder = RequestConfig.custom();

            if (config.getReadTimeoutMillis() > 0) {
                builder.setSocketTimeout(config.getReadTimeoutMillis());
            }

            if (config.getConnectionTimeoutMillis() > 0) {
                builder.setConnectTimeout(config.getConnectionTimeoutMillis());
            }

            if (proxy != null && proxy.address() instanceof InetSocketAddress) {

                InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                builder.setProxy(new HttpHost(inetSocketAddress.getHostName(), inetSocketAddress.getPort()));
            }

            httpUriRequest.setConfig(builder.build());

            setContentType(httpUriRequest, APPLICATION_JSON_TYPE);
            setAuthentication(httpUriRequest, isApiKeyRequired, config);

            if (requestOptions != null && requestOptions.getIdempotencyKey() != null) {
                httpUriRequest.addHeader(IDEMPOTENCY_KEY, requestOptions.getIdempotencyKey());
            }

            // Execute request with a custom response handler
            responseBody = httpclient.execute(httpUriRequest, new ApacheResponseHandler());

            if (responseBody.getStatus() < 200 || responseBody.getStatus() >= 300) {
                throw new HTTPClientException(responseBody.getStatus(), "HTTP Exception", null, responseBody.getResponse());
            }
        }
        return responseBody.getResponse();
    }

    private CloseableHttpClient createCloseableHttpClient(Config config) throws HTTPClientException {
        CloseableHttpClient httpclient;

        if (config.getTerminalCertificatePath() != null && !config.getTerminalCertificatePath().isEmpty()) {
            HttpClientBuilder httpClientBuilder = HttpClients.custom();
            // Create new KeyStore for the terminal certificate
            try(InputStream certificateInput = new FileInputStream(config.getTerminalCertificatePath())) {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                X509Certificate cert = (X509Certificate) certificateFactory.generateCertificate(certificateInput);

                KeyStore keyStore = KeyStore.getInstance("JKS");
                keyStore.load(null, null);
                keyStore.setCertificateEntry("TerminalCertificate", cert);

                TrustManagerFactory trustFactory =
                        TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustFactory.init(keyStore);
                TrustManager[] trustManagers = trustFactory.getTrustManagers();

                // Install the terminal certificate trust manager
                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustManagers, new java.security.SecureRandom());

                SSLConnectionSocketFactory sslConSocFactory = new SSLConnectionSocketFactory(sc, createHostnameVerifier(config.getEnvironment()));
                httpClientBuilder.setSSLSocketFactory(sslConSocFactory);
            } catch (GeneralSecurityException | IOException e) {
                throw new HTTPClientException("Error loading certificate from path", e);
            }
            httpclient = httpClientBuilder.build();
        } else {
            httpclient = HttpClients.createDefault();
        }
        return httpclient;
    }

    private HostnameVerifier createHostnameVerifier(final Environment environment) {
        return (host, session) -> {
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
    }

    /**
     * Sets content type
     */
    private void setAuthentication(HttpUriRequest httpUriRequest, boolean isApiKeyRequired, Config config) {
        String apiKey = config.getApiKey();
        // Use Api key if required or if provided
        if (isApiKeyRequired || (apiKey != null && !apiKey.isEmpty())) {
            setApiKey(httpUriRequest, apiKey);
        } else {
            setBasicAuthentication(httpUriRequest, config.getUsername(), config.getPassword());
        }
    }

    /**
     * Sets content type
     */
    private void setContentType(HttpUriRequest httpUriRequest, String contentType) {
        httpUriRequest.addHeader(CONTENT_TYPE, contentType);
    }

    @Override
    public String post(String endpoint, Map<String, String> postParameters, Config config) throws IOException, HTTPClientException {
        String postQuery = getQuery(postParameters);
        return request(endpoint, postQuery, config, false, null);
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
     * Sets api key
     */
    private void setApiKey(HttpUriRequest httpUriRequest, String apiKey) {
        if (apiKey != null && !apiKey.isEmpty()) {
            httpUriRequest.addHeader(API_KEY, apiKey);
        }
    }

    /**
     * Adds Basic Authentication headers
     */
    private void setBasicAuthentication(HttpUriRequest httpUriRequest, String username, String password) {
        // set basic authentication
        String authString = username + ":" + password;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);

        httpUriRequest.addHeader("Authorization", "Basic " + authStringEnc);
    }

    private String getQueryNew(Map<String, Object> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (Map.Entry<String, Object> pair : params.entrySet()) {
            if (first) {
                first = false;
            } else {
                result.append("&");
            }

            result.append(URLEncoder.encode(pair.getKey(), CHARSET));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue().toString(), CHARSET));
        }
        return result.toString();
    }
}