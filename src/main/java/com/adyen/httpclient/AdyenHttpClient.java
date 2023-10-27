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
import com.adyen.model.RequestOptions;
import java.util.Base64;
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
import org.apache.hc.core5.ssl.SSLContexts;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.adyen.constants.ApiConstants.HttpMethod.POST;
import static com.adyen.constants.ApiConstants.RequestProperty.ACCEPT_CHARSET;
import static com.adyen.constants.ApiConstants.RequestProperty.ADYEN_LIBRARY_NAME;
import static com.adyen.constants.ApiConstants.RequestProperty.ADYEN_LIBRARY_VERSION;
import static com.adyen.constants.ApiConstants.RequestProperty.API_KEY;
import static com.adyen.constants.ApiConstants.RequestProperty.APPLICATION_JSON_TYPE;
import static com.adyen.constants.ApiConstants.RequestProperty.CONTENT_TYPE;
import static com.adyen.constants.ApiConstants.RequestProperty.IDEMPOTENCY_KEY;
import static com.adyen.constants.ApiConstants.RequestProperty.REQUESTED_VERIFICATION_CODE_HEADER;
import static com.adyen.constants.ApiConstants.RequestProperty.USER_AGENT;

public class AdyenHttpClient implements ClientInterface {

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
        httpUriRequest.addHeader(ADYEN_LIBRARY_NAME, Client.LIB_NAME);
        httpUriRequest.addHeader(ADYEN_LIBRARY_VERSION, Client.LIB_VERSION);

        if (requestOptions != null) {
            if (requestOptions.getIdempotencyKey() != null) {
                httpUriRequest.addHeader(IDEMPOTENCY_KEY, requestOptions.getIdempotencyKey());
            }
            if (requestOptions.getRequestedVerificationCodeHeader() != null) {
                httpUriRequest.addHeader(REQUESTED_VERIFICATION_CODE_HEADER, requestOptions.getRequestedVerificationCodeHeader());
            }

            if (requestOptions.getAdditionalServiceHeaders() != null) {
                requestOptions.getAdditionalServiceHeaders().forEach(httpUriRequest::addHeader);
            }
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

    private CloseableHttpClient createCloseableHttpClient(Config config) {
        SSLContext sslContext = config.getSSLContext();
        if (sslContext == null) {
            sslContext = SSLContexts.createDefault();
        }
        HostnameVerifier hostnameVerifier = config.getHostnameVerifier();
        return createHttpClientWithSocketFactory(new SSLConnectionSocketFactory(sslContext, hostnameVerifier));
    }

    private CloseableHttpClient createHttpClientWithSocketFactory(SSLConnectionSocketFactory socketFactory) {
        return HttpClients.custom()
                .setConnectionManager(PoolingHttpClientConnectionManagerBuilder.create()
                        .setSSLSocketFactory(socketFactory)
                        .build())
                .build();
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
        byte[] authEncBytes = Base64.getEncoder().encode(authString.getBytes());
        String authStringEnc = new String(authEncBytes);

        httpUriRequest.addHeader("Authorization", "Basic " + authStringEnc);
    }
}
