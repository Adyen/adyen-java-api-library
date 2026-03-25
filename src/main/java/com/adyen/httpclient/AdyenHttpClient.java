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
import static com.adyen.constants.ApiConstants.RequestProperty.WWW_AUTHENTICATE_HEADER;

import com.adyen.Client;
import com.adyen.Config;
import com.adyen.constants.ApiConstants;
import com.adyen.model.RequestOptions;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import org.apache.commons.codec.binary.Base64;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPatch;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.hc.core5.ssl.SSLContexts;

/**
 * HTTP client implementation to invoke the Adyen APIs.
 *
 * <p>This client maintains a shared {@link CloseableHttpClient} instance that is lazily initialized
 * on the first request and reused for all subsequent requests. This enables connection pooling, TCP
 * and TLS session reuse, and natural backpressure under high concurrency.
 *
 * <p>Timeout values from {@link Config} are applied at two levels:
 *
 * <ul>
 *   <li><b>Connection manager level</b> ({@link ConnectionConfig}): {@code connectTimeout} and
 *       {@code socketTimeout} enforce hard OS-level timeouts on TCP/TLS handshake and socket reads.
 *   <li><b>Request level</b> ({@link RequestConfig}): {@code responseTimeout}, {@code
 *       connectionRequestTimeout}, and {@code defaultKeepAlive} are set per request.
 * </ul>
 *
 * <p>The shared HTTP client is created from the {@link Config} provided on the first request.
 * Subsequent changes to {@link Config} timeout values will not affect the already-created client.
 * Configuration must be finalized before the first API call.
 **
 * @see ClientInterface
 * @see Config
 */
public class AdyenHttpClient implements ClientInterface {

  private static final String CHARSET = "UTF-8";
  private Proxy proxy;
  private volatile CloseableHttpClient sharedHttpClient;
  private final Object lock = new Object();

  /**
   * Returns the proxy configured for this HTTP client.
   *
   * @return the proxy, or null if no proxy is set
   */
  public Proxy getProxy() {
    return proxy;
  }

  /**
   * Sets a proxy to use for all HTTP requests made by this client.
   *
   * @param proxy the proxy (e.g. {@code new Proxy(Proxy.Type.HTTP, new InetSocketAddress("host",
   *     port))})
   */
  public void setProxy(Proxy proxy) {
    // Note: only HTTP proxies are supported; SOCKS proxies are silently ignored.
    this.proxy = proxy;
  }

  /**
   * Closes the shared HTTP client and releases all pooled connections. This method is idempotent
   * and thread-safe; calling it multiple times has no additional effect.
   *
   * @throws IOException if an I/O error occurs while closing the underlying client
   */
  @Override
  public void close() throws IOException {
    synchronized (lock) {
      if (sharedHttpClient != null) {
        sharedHttpClient.close();
        sharedHttpClient = null;
      }
    }
  }

  /**
   * Returns the shared {@link CloseableHttpClient}, creating it on first access using the provided
   * {@link Config}. Uses double-checked locking for thread safety.
   *
   * @param config the configuration used to build the HTTP client on first invocation
   * @return the shared HTTP client instance
   */
  private CloseableHttpClient getOrCreateHttpClient(Config config) {
    CloseableHttpClient client = sharedHttpClient;
    if (client != null) {
      return client;
    }
    synchronized (lock) {
      if (sharedHttpClient == null) {
        sharedHttpClient = createCloseableHttpClient(config);
      }
      return sharedHttpClient;
    }
  }

  @Override
  public String request(String endpoint, String requestBody, Config config)
      throws IOException, HTTPClientException {
    return request(endpoint, requestBody, config, false);
  }

  @Override
  public String request(
      String endpoint, String requestBody, Config config, boolean isApiKeyRequired)
      throws IOException, HTTPClientException {
    return request(endpoint, requestBody, config, isApiKeyRequired, null);
  }

  @Override
  public String request(
      String endpoint,
      String requestBody,
      Config config,
      boolean isApiKeyRequired,
      RequestOptions requestOptions)
      throws IOException, HTTPClientException {
    return request(endpoint, requestBody, config, isApiKeyRequired, requestOptions, POST);
  }

  @Override
  public String request(
      String endpoint,
      String requestBody,
      Config config,
      boolean isApiKeyRequired,
      RequestOptions requestOptions,
      ApiConstants.HttpMethod httpMethod)
      throws IOException, HTTPClientException {
    return request(
        endpoint, requestBody, config, isApiKeyRequired, requestOptions, httpMethod, null);
  }

  @Override
  public String request(
      String endpoint,
      String requestBody,
      Config config,
      boolean isApiKeyRequired,
      RequestOptions requestOptions,
      ApiConstants.HttpMethod httpMethod,
      Map<String, String> params)
      throws IOException, HTTPClientException {
    CloseableHttpClient httpclient = getOrCreateHttpClient(config);
    HttpUriRequestBase httpRequest =
        createRequest(
            endpoint, requestBody, config, isApiKeyRequired, requestOptions, httpMethod, params);

    // Execute request with a custom response handler
    AdyenResponse response = httpclient.execute(httpRequest, new AdyenResponseHandler());

    if (response.getStatus() < 200 || response.getStatus() >= 300) {
      throw new HTTPClientException(
          response.getStatus(), "HTTP Exception", response.getHeaders(), response.getBody());
    }
    return response.getBody();
  }

  /**
   * Builds an {@link HttpUriRequestBase} with the appropriate HTTP method, headers, authentication,
   * and per-request timeout configuration from {@link Config}.
   *
   * @param endpoint the full URL of the API endpoint
   * @param requestBody the JSON request body (may be null for GET/DELETE)
   * @param config the client configuration containing timeout and authentication settings
   * @param isApiKeyRequired whether API key authentication is mandatory
   * @param requestOptions additional request options (idempotency key, custom headers)
   * @param httpMethod the HTTP method (GET, POST, PATCH, DELETE)
   * @param params query string parameters appended to the URL
   * @return the fully configured HTTP request
   * @throws HTTPClientException if the endpoint URI is invalid
   */
  HttpUriRequestBase createRequest(
      String endpoint,
      String requestBody,
      Config config,
      boolean isApiKeyRequired,
      RequestOptions requestOptions,
      ApiConstants.HttpMethod httpMethod,
      Map<String, String> params)
      throws HTTPClientException {
    HttpUriRequestBase httpRequest =
        createHttpRequestBase(createUri(endpoint, params), requestBody, httpMethod);

    RequestConfig.Builder builder = RequestConfig.custom();

    builder.setResponseTimeout(config.getReadTimeoutMillis(), TimeUnit.MILLISECONDS);
    builder.setConnectTimeout(config.getConnectionTimeoutMillis(), TimeUnit.MILLISECONDS);
    builder.setDefaultKeepAlive(config.getDefaultKeepAliveMillis(), TimeUnit.MILLISECONDS);
    builder.setConnectionRequestTimeout(
        config.getConnectionRequestTimeoutMillis(), TimeUnit.MILLISECONDS);

    if (config.getProtocolUpgradeEnabled() != null) {
      builder.setProtocolUpgradeEnabled(config.getProtocolUpgradeEnabled());
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

  private void setHeaders(
      Config config, RequestOptions requestOptions, HttpUriRequestBase httpUriRequest) {

    setContentType(httpUriRequest, APPLICATION_JSON_TYPE);
    httpUriRequest.addHeader(ACCEPT_CHARSET, CHARSET);

    String applicationName = config.getApplicationName();
    String userAgent =
        (applicationName != null && !applicationName.isBlank())
            ? String.format("%s %s/%s", applicationName, Client.LIB_NAME, Client.LIB_VERSION)
            : String.format("%s/%s", Client.LIB_NAME, Client.LIB_VERSION);
    httpUriRequest.addHeader(USER_AGENT, userAgent);

    httpUriRequest.addHeader(ADYEN_LIBRARY_NAME, Client.LIB_NAME);
    httpUriRequest.addHeader(ADYEN_LIBRARY_VERSION, Client.LIB_VERSION);

    if (requestOptions != null) {
      if (requestOptions.getIdempotencyKey() != null) {
        httpUriRequest.addHeader(IDEMPOTENCY_KEY, requestOptions.getIdempotencyKey());
      }
      if (requestOptions.getRequestedVerificationCodeHeader() != null) {
        httpUriRequest.addHeader(
            REQUESTED_VERIFICATION_CODE_HEADER,
            requestOptions.getRequestedVerificationCodeHeader());
      }
      if (requestOptions.getWwwAuthenticateHeader() != null) {
        httpUriRequest.addHeader(
            WWW_AUTHENTICATE_HEADER, requestOptions.getWwwAuthenticateHeader());
      }

      if (requestOptions.getAdditionalServiceHeaders() != null) {
        requestOptions.getAdditionalServiceHeaders().forEach(httpUriRequest::addHeader);
      }
    }
  }

  private HttpUriRequestBase createHttpRequestBase(
      URI endpoint, String requestBody, ApiConstants.HttpMethod httpMethod) {
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
        for (String key : params.keySet()) {
          uriBuilder.addParameter(key, params.get(key));
        }
      }
      return uriBuilder.build();
    } catch (URISyntaxException e) {
      throw new HTTPClientException("Invalid URI", e);
    }
  }

  /**
   * Creates a new {@link CloseableHttpClient} configured with SSL, connection-level timeouts, and
   * request-level defaults from the given {@link Config}. This method is package-private to allow
   * testing.
   *
   * @param config the configuration used to set up SSL context, hostname verifier, and timeouts
   * @return a configured HTTP client instance
   */
  CloseableHttpClient createCloseableHttpClient(Config config) {
    SSLContext sslContext = config.getSSLContext();
    if (sslContext == null) {
      sslContext = SSLContexts.createDefault();
    }
    HostnameVerifier hostnameVerifier = config.getHostnameVerifier();
    return createHttpClientWithSocketFactory(
        new SSLConnectionSocketFactory(sslContext, hostnameVerifier), config);
  }

  /**
   * Creates a {@link CloseableHttpClient} with the given SSL socket factory and timeout
   * configuration. Sets up both connection-level timeouts ({@link ConnectionConfig} with {@code
   * connectTimeout} and {@code socketTimeout}) and request-level defaults ({@link RequestConfig}
   * with {@code responseTimeout}, {@code connectionRequestTimeout}, and {@code defaultKeepAlive}).
   *
   * @param socketFactory the SSL socket factory for HTTPS connections
   * @param config the configuration containing timeout values
   * @return a configured HTTP client instance
   */
  private CloseableHttpClient createHttpClientWithSocketFactory(
      SSLConnectionSocketFactory socketFactory, Config config) {
    RequestConfig defaultRequestConfig =
        RequestConfig.custom()
            .setResponseTimeout(config.getReadTimeoutMillis(), TimeUnit.MILLISECONDS)
            .setConnectionRequestTimeout(
                config.getConnectionRequestTimeoutMillis(), TimeUnit.MILLISECONDS)
            .setDefaultKeepAlive(config.getDefaultKeepAliveMillis(), TimeUnit.MILLISECONDS)
            .build();
    ConnectionConfig connectionConfig =
        ConnectionConfig.custom()
            .setConnectTimeout(config.getConnectionTimeoutMillis(), TimeUnit.MILLISECONDS)
            // socketTimeout acts as an OS-level safety net for stalled reads;
            // responseTimeout (in RequestConfig) is the HTTP-level equivalent.
            // Both are set to readTimeoutMillis so the request is bounded regardless of which layer fires first.
            .setSocketTimeout(config.getReadTimeoutMillis(), TimeUnit.MILLISECONDS)
            .build();
    return HttpClients.custom()
        .setConnectionManager(
            PoolingHttpClientConnectionManagerBuilder.create()
                .setSSLSocketFactory(socketFactory)
                .setDefaultConnectionConfig(connectionConfig)
                .build())
        .setDefaultRequestConfig(defaultRequestConfig)
        .setRedirectStrategy(new AdyenCustomRedirectStrategy())
        .build();
  }

  /** Sets authentication headers (API key or basic auth) based on the configuration. */
  private void setAuthentication(
      HttpUriRequest httpUriRequest, boolean isApiKeyRequired, Config config) {
    String apiKey = config.getApiKey();
    // Use Api key if required or if provided
    if (isApiKeyRequired || (apiKey != null && !apiKey.isEmpty())) {
      setApiKey(httpUriRequest, apiKey);
    } else {
      setBasicAuthentication(httpUriRequest, config.getUsername(), config.getPassword());
    }
  }

  /** Sets the Content-Type header on the request. */
  private void setContentType(HttpUriRequest httpUriRequest, String contentType) {
    httpUriRequest.addHeader(CONTENT_TYPE, contentType);
  }

  /** Sets the X-API-Key header on the request. */
  private void setApiKey(HttpUriRequest httpUriRequest, String apiKey) {
    if (apiKey != null && !apiKey.isEmpty()) {
      httpUriRequest.addHeader(API_KEY, apiKey);
    }
  }

  /** Adds Basic Authentication headers */
  private void setBasicAuthentication(
      HttpUriRequest httpUriRequest, String username, String password) {
    // set basic authentication
    String authString = username + ":" + password;
    byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
    String authStringEnc = new String(authEncBytes);

    httpUriRequest.addHeader("Authorization", "Basic " + authStringEnc);
  }
}
