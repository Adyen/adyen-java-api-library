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

import com.adyen.Client;
import com.adyen.Config;
import com.adyen.constants.ApiConstants;
import com.adyen.enums.Environment;
import com.adyen.model.RequestOptions;
import com.adyen.terminal.security.TerminalCommonNameValidator;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.Map;

import static com.adyen.constants.ApiConstants.HttpMethod.POST;
import static com.adyen.constants.ApiConstants.RequestProperty.*;

public class AdyenHttpClient implements ClientInterface {

    private static final String CHARSET = "UTF-8";
    private static final String TERMINAL_CERTIFICATE_ALIAS = "TerminalCertificate";
    private static final String JAVA_KEYSTORE = "JKS";
    private static final String SSL = "SSL";
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
        return request(endpoint, requestBody, config, isApiKeyRequired, requestOptions, POST);
    }

    @Override
    public String request(String endpoint, String requestBody, Config config, boolean isApiKeyRequired, RequestOptions requestOptions, ApiConstants.HttpMethod httpMethod) throws IOException, HTTPClientException {
        return request(endpoint, requestBody, config, isApiKeyRequired, requestOptions, httpMethod, null);
    }

    @Override
    public String request(String endpoint, String requestBody, Config config, boolean isApiKeyRequired, RequestOptions requestOptions, ApiConstants.HttpMethod httpMethod, Map<String, String> params) throws IOException, HTTPClientException {
        try (CloseableHttpClient httpclient = createCloseableHttpClient(config)) {
            HttpRequestBase httpRequest = createRequest(endpoint, requestBody, config, isApiKeyRequired, requestOptions, httpMethod, params);

            // Execute request with a custom response handler
            AdyenResponse response = httpclient.execute(httpRequest, new AdyenResponseHandler());

            if (response.getStatus() < 200 || response.getStatus() >= 300) {
                throw new HTTPClientException(response.getStatus(), "HTTP Exception", response.getHeaders(), response.getBody());
            }
            return response.getBody();
        }
    }

    private HttpRequestBase createRequest(String endpoint, String requestBody, Config config, boolean isApiKeyRequired, RequestOptions requestOptions, ApiConstants.HttpMethod httpMethod, Map<String, String> params) throws HTTPClientException {
        HttpRequestBase httpRequest = createHttpRequestBase(createUri(endpoint, params), requestBody, httpMethod);

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
        httpRequest.setConfig(builder.build());

        setAuthentication(httpRequest, isApiKeyRequired, config);
        setHeaders(config, requestOptions, httpRequest);

        return httpRequest;
    }

    private void setHeaders(Config config, RequestOptions requestOptions, HttpRequestBase httpUriRequest) {

        setContentType(httpUriRequest, APPLICATION_JSON_TYPE);
        httpUriRequest.addHeader(ACCEPT_CHARSET, CHARSET);
        httpUriRequest.addHeader(USER_AGENT, String.format("%s %s/%s", config.getApplicationName(), Client.LIB_NAME, Client.LIB_VERSION));

        if (requestOptions != null && requestOptions.getIdempotencyKey() != null) {
            httpUriRequest.addHeader(IDEMPOTENCY_KEY, requestOptions.getIdempotencyKey());
        }
    }

    private HttpRequestBase createHttpRequestBase(URI endpoint, String requestBody, ApiConstants.HttpMethod httpMethod) {
        switch (httpMethod) {
            case GET:
                return new HttpGet(endpoint);
            case PATCH:
                HttpPatch httpPatch = new HttpPatch(endpoint);
                httpPatch.setEntity(new StringEntity(requestBody, CHARSET));
                return httpPatch;
            case DELETE:
                return new HttpDelete(endpoint);
            default:
                // Default to POST if httpMethod is not provided
                HttpPost httpPost = new HttpPost(endpoint);
                httpPost.setEntity(new StringEntity(requestBody, CHARSET));
                return httpPost;
        }
    }

    private URI createUri(String endpoint, Map<String, String> params) throws HTTPClientException {
        try {
            URIBuilder uriBuilder = new URIBuilder(endpoint);
            if (params != null && !params.isEmpty()) {
                for (String key: params.keySet()) {
                    uriBuilder.addParameter(key, params.get(key));
                }
            }
            return uriBuilder.build();
        } catch (URISyntaxException e) {
            throw new HTTPClientException("Invalid URI", e);
        }
    }

    private CloseableHttpClient createCloseableHttpClient(Config config) throws HTTPClientException {
        CloseableHttpClient httpclient;

        if (config.getTerminalCertificate() != null) {
            HttpClientBuilder httpClientBuilder = HttpClients.custom();
            // Create new KeyStore for the terminal certificate
            try {
                KeyStore keyStore = KeyStore.getInstance(JAVA_KEYSTORE);
                keyStore.load(null, null);
                keyStore.setCertificateEntry(TERMINAL_CERTIFICATE_ALIAS, config.getTerminalCertificate());

                TrustManagerFactory trustFactory =
                        TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustFactory.init(keyStore);
                TrustManager[] trustManagers = trustFactory.getTrustManagers();

                // Install the terminal certificate trust manager
                SSLContext sc = SSLContext.getInstance(SSL);
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
}