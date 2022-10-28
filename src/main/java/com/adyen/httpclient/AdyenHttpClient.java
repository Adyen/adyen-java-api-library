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
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPatch;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.net.URIBuilder;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.adyen.constants.ApiConstants.HttpMethod.POST;
import static com.adyen.constants.ApiConstants.RequestProperty.ACCEPT_CHARSET;
import static com.adyen.constants.ApiConstants.RequestProperty.API_KEY;
import static com.adyen.constants.ApiConstants.RequestProperty.APPLICATION_JSON_TYPE;
import static com.adyen.constants.ApiConstants.RequestProperty.CONTENT_TYPE;
import static com.adyen.constants.ApiConstants.RequestProperty.IDEMPOTENCY_KEY;
import static com.adyen.constants.ApiConstants.RequestProperty.USER_AGENT;

public class AdyenHttpClient implements ClientInterface {

    private static final String CHARSET = "UTF-8";
    private static final String TERMINAL_CERTIFICATE_ALIAS = "TerminalCertificate";
    private static final String SSL = "SSL";
    private static final String TLSV1_2 = "TLSv1.2";
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
            HttpUriRequestBase httpRequest = createRequest(endpoint, requestBody, config, isApiKeyRequired, requestOptions, httpMethod, params);

            // Execute request with a custom response handler
            AdyenResponse response = httpclient.execute(httpRequest, new AdyenResponseHandler());

            if (response.getStatus() < 200 || response.getStatus() >= 300) {
                throw new HTTPClientException(response.getStatus(), "HTTP Exception", response.getHeaders(), response.getBody());
            }
            return response.getBody();
        }
    }

    private HttpUriRequestBase createRequest(String endpoint, String requestBody, Config config, boolean isApiKeyRequired, RequestOptions requestOptions, ApiConstants.HttpMethod httpMethod, Map<String, String> params) throws HTTPClientException {
        HttpUriRequestBase httpRequest = createHttpRequestBase(createUri(endpoint, params), requestBody, httpMethod);

        RequestConfig.Builder builder = RequestConfig.custom();
        if (config.getReadTimeoutMillis() > 0) {
            builder.setResponseTimeout(config.getReadTimeoutMillis(), TimeUnit.MILLISECONDS);
        }
        if (config.getConnectionTimeoutMillis() > 0) {
            builder.setConnectTimeout(config.getConnectionTimeoutMillis(), TimeUnit.MILLISECONDS);
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

    private void setHeaders(Config config, RequestOptions requestOptions, HttpUriRequestBase httpUriRequest) {

        setContentType(httpUriRequest, APPLICATION_JSON_TYPE);
        httpUriRequest.addHeader(ACCEPT_CHARSET, CHARSET);
        httpUriRequest.addHeader(USER_AGENT, String.format("%s %s/%s", config.getApplicationName(), Client.LIB_NAME, Client.LIB_VERSION));

        if (requestOptions != null && requestOptions.getIdempotencyKey() != null) {
            httpUriRequest.addHeader(IDEMPOTENCY_KEY, requestOptions.getIdempotencyKey());
        }
    }

    private HttpUriRequestBase createHttpRequestBase(URI endpoint, String requestBody, ApiConstants.HttpMethod httpMethod) {
        StringEntity requestEntity = null;
        if (requestBody != null && !requestBody.isEmpty()) {
            requestEntity = new StringEntity(requestBody, Charset.forName(CHARSET));
        }

        switch (httpMethod) {
            case GET:
                return new HttpGet(endpoint);
            case PATCH:
                HttpPatch httpPatch = new HttpPatch(endpoint);
                httpPatch.setEntity(requestEntity);
                return httpPatch;
            case DELETE:
                return new HttpDelete(endpoint);
            default:
                // Default to POST if httpMethod is not provided
                HttpPost httpPost = new HttpPost(endpoint);
                httpPost.setEntity(requestEntity);
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
        if (config.getClientKeyStore() != null && config.getTrustKeyStore() != null) {
            return createHttpClientWithSocketFactory(getClientCertificateAuthSSLContext(config));
        }
        if (config.getTerminalCertificate() != null) {
            return createHttpClientWithSocketFactory(getTerminalCertificateSocketFactory(config));
        }
        return HttpClients.createSystem();
    }

    private CloseableHttpClient createHttpClientWithSocketFactory(SSLConnectionSocketFactory socketFactory) {
        return HttpClients.custom()
                .setConnectionManager(PoolingHttpClientConnectionManagerBuilder.create()
                        .setSSLSocketFactory(socketFactory)
                        .build())
                .build();
    }

    private SSLConnectionSocketFactory getTerminalCertificateSocketFactory(Config config) throws HTTPClientException {
        try {
            // Create new KeyStore for the terminal certificate
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry(TERMINAL_CERTIFICATE_ALIAS, config.getTerminalCertificate());

            TrustManagerFactory trustFactory =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustFactory.init(keyStore);
            TrustManager[] trustManagers = trustFactory.getTrustManagers();

            // Install the terminal certificate trust manager
            SSLContext sc = SSLContext.getInstance(SSL);
            sc.init(null, trustManagers, new java.security.SecureRandom());

            return new SSLConnectionSocketFactory(sc, createHostnameVerifier(config.getEnvironment()));
        } catch (GeneralSecurityException | IOException e) {
            throw new HTTPClientException("Error loading certificate from path", e);
        }
    }

    private SSLConnectionSocketFactory getClientCertificateAuthSSLContext(Config config) throws HTTPClientException {
        try {
            char[] password = null;
            if (config.getClientKeyStorePassword() != null && !config.getClientKeyStorePassword().isEmpty()) {
                password = config.getClientKeyStorePassword().toCharArray();
            }

            // Create a TrustManager that trusts the CAs in our Trust KeyStore
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(config.getTrustKeyStore());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(config.getClientKeyStore(), password);

            // Create an SSLContext that uses our TrustManager
            SSLContext context = SSLContext.getInstance(TLSV1_2);
            context.init(keyManagerFactory.getKeyManagers(), tmf.getTrustManagers(), null);
            return new SSLConnectionSocketFactory(context);
        } catch (Exception e) {
            throw new HTTPClientException("Error creating SSL Context", e);
        }
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
