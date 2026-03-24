package com.adyen;

import com.adyen.enums.Environment;
import com.adyen.enums.Region;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

    /**
 * Configuration for the Adyen API client (authentication credentials, environment settings,
 * HTTP timeout values, and Terminal API configuration, etc..).
 *
 * <p>Supports a fluent builder pattern for concise configuration:
 *
 * <pre>{@code
 * Config config = new Config()
 *     .environment(Environment.LIVE)
 *     .liveEndpointUrlPrefix("myCompany")
 *     .apiKey("YOUR_API_KEY")
 *     .connectionTimeoutMillis(10000)
 *     .readTimeoutMillis(15000);
 * }</pre>
 *
 * <p><b>Important:</b> Consider setting Timeout and SSL configuration.
 * The underlying HTTP client is created lazily on the first request and reuses the configuration
 * captured at that point. Changes made after the first request will not take effect.
 *
 * @see Client
 * @see com.adyen.httpclient.AdyenHttpClient
 */
public class Config {

  /** API key for authentication. */
  protected String apiKey;

  /** Username for HTTP basic authentication. */
  protected String username;

  /** Password for HTTP basic authentication. */
  protected String password;

  /** The target environment (Test or Live). */
  protected Environment environment;

  /** Application name included in the User-Agent header. */
  protected String applicationName;

  /**
   * Maximum time in milliseconds to wait for a TCP connection (and TLS handshake) to be
   * established. Default: 60000 (60 seconds).
   */
  protected int connectionTimeoutMillis = 60 * 1000;

  /**
   * Maximum time in milliseconds to wait for data on an already established connection (socket read
   * timeout). This is the hard upper bound on how long any single API call can take once connected.
   * Default: 60000 (60 seconds).
   */
  protected int readTimeoutMillis = 60 * 1000;

  /**
   * Maximum time in milliseconds to wait to lease a connection from the internal connection pool.
   * Relevant under high concurrency when the pool is saturated. Default: 60000 (60 seconds).
   */
  protected int connectionRequestTimeoutMillis = 60 * 1000;

  /**
   * Duration in milliseconds to keep idle connections alive for reuse. Default: 60000 (60 seconds).
   */
  protected int defaultKeepAliveMillis = 60 * 1000;

  /**
   * Whether HTTP requests should automatically attempt to upgrade to a newer protocol version. If
   * null, the Apache HttpClient default is used.
   */
  protected Boolean protocolUpgradeEnabled;

  /** The Cloud Terminal API endpoint URL. */
  protected String terminalApiCloudEndpoint;

  /** The Local Terminal API endpoint URL */
  protected String terminalApiLocalEndpoint;

  /** The unique live URL prefix for live environment endpoints. */
  protected String liveEndpointUrlPrefix;

  /** The region for the Terminal API Cloud endpoint. */
  protected Region terminalApiRegion;

  /** The SSL context for client certificate authentication or custom trust stores. */
  protected SSLContext sslContext;

  /** The hostname verifier for Terminal Local API connections. */
  protected HostnameVerifier hostnameVerifier;

  /** Creates a new Config with default values. */
  public Config() {
    // do nothing
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Config username(String username) {
    this.username = username;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Config password(String password) {
    this.password = password;
    return this;
  }

  public Environment getEnvironment() {
    return environment;
  }

  public void setEnvironment(Environment environment) {
    this.environment = environment;
  }

  public Config environment(Environment environment) {
    this.environment = environment;
    return this;
  }

  public String getApplicationName() {
    return applicationName;
  }

  public void setApplicationName(String applicationName) {
    this.applicationName = applicationName;
  }

  public Config applicationName(String applicationName) {
    this.applicationName = applicationName;
    return this;
  }

  public String getApiKey() {
    return apiKey;
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  public Config apiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }

  public String getTerminalApiCloudEndpoint() {
    return terminalApiCloudEndpoint;
  }

  public void setTerminalApiCloudEndpoint(String terminalApiCloudEndpoint) {
    this.terminalApiCloudEndpoint = terminalApiCloudEndpoint;
  }

  public Config terminalApiCloudEndpoint(String terminalApiCloudEndpoint) {
    this.terminalApiCloudEndpoint = terminalApiCloudEndpoint;
    return this;
  }

  public String getTerminalApiLocalEndpoint() {
    return terminalApiLocalEndpoint;
  }

  public void setTerminalApiLocalEndpoint(String terminalApiLocalEndpoint) {
    this.terminalApiLocalEndpoint = terminalApiLocalEndpoint;
  }

  public Config terminalApiLocalEndpoint(String terminalApiLocalEndpoint) {
    this.terminalApiLocalEndpoint = terminalApiLocalEndpoint;
    return this;
  }

  public Region getTerminalApiRegion() {
    return terminalApiRegion;
  }

  public void setTerminalApiRegion(Region terminalApiRegion) {
    this.terminalApiRegion = terminalApiRegion;
  }

  public Config terminalApiRegion(Region terminalApiRegion) {
    this.terminalApiRegion = terminalApiRegion;
    return this;
  }

  /**
   * Returns the connection timeout in milliseconds.
   *
   * @return the maximum time to wait for a TCP connection to be established
   */
  public int getConnectionTimeoutMillis() {
    return connectionTimeoutMillis;
  }

  /**
   * Sets the maximum time in milliseconds to wait for a TCP connection (and TLS handshake) to be
   * established. A lower value (e.g. 5000-15000) is recommended for production to fail fast when
   * the server is unreachable.
   *
   * @param connectionTimeoutMillis the connection timeout in milliseconds
   */
  public void setConnectionTimeoutMillis(int connectionTimeoutMillis) {
    this.connectionTimeoutMillis = connectionTimeoutMillis;
  }

  /**
   * Fluent setter for {@link #setConnectionTimeoutMillis(int)}.
   *
   * @param connectionTimeoutMillis the connection timeout in milliseconds
   * @return this Config instance
   */
  public Config connectionTimeoutMillis(int connectionTimeoutMillis) {
    this.connectionTimeoutMillis = connectionTimeoutMillis;
    return this;
  }

  /**
   * Returns the read timeout in milliseconds.
   *
   * @return the maximum time to wait for response data on an established connection
   */
  public int getReadTimeoutMillis() {
    return readTimeoutMillis;
  }

  /**
   * Sets the maximum time in milliseconds to wait for data on an already established connection.
   * This acts as both the HTTP response timeout and the socket-level read timeout, providing a hard
   * upper bound on API call duration. Set this to match your maximum acceptable response time.
   *
   * @param readTimeoutMillis the read timeout in milliseconds
   */
  public void setReadTimeoutMillis(int readTimeoutMillis) {
    this.readTimeoutMillis = readTimeoutMillis;
  }

  /**
   * Fluent setter for {@link #setReadTimeoutMillis(int)}.
   *
   * @param readTimeoutMillis the read timeout in milliseconds
   * @return this Config instance
   */
  public Config readTimeoutMillis(int readTimeoutMillis) {
    this.readTimeoutMillis = readTimeoutMillis;
    return this;
  }

  /**
   * Returns the default keep-alive duration in milliseconds.
   *
   * @return the duration to keep idle connections alive for reuse
   */
  public int getDefaultKeepAliveMillis() {
    return defaultKeepAliveMillis;
  }

  /**
   * Sets the duration in milliseconds to keep idle connections alive for reuse.
   *
   * @param defaultKeepAliveMillis the keep-alive duration in milliseconds
   */
  public void setDefaultKeepAliveMillis(int defaultKeepAliveMillis) {
    this.defaultKeepAliveMillis = defaultKeepAliveMillis;
  }

  /**
   * Fluent setter for {@link #setDefaultKeepAliveMillis(int)}.
   *
   * @param defaultKeepAliveMillis the keep-alive duration in milliseconds
   * @return this Config instance
   */
  public Config defaultKeepAliveMillis(int defaultKeepAliveMillis) {
    this.defaultKeepAliveMillis = defaultKeepAliveMillis;
    return this;
  }

  /**
   * Returns the connection request timeout in milliseconds.
   *
   * @return the maximum time to wait to lease a connection from the pool
   */
  public int getConnectionRequestTimeoutMillis() {
    return connectionRequestTimeoutMillis;
  }

  /**
   * Sets the maximum time in milliseconds to wait to lease a connection from the internal
   * connection pool. This timeout is relevant under high concurrency when all pooled connections
   * are in use.
   *
   * @param connectionRequestTimeoutMillis the connection request timeout in milliseconds
   */
  public void setConnectionRequestTimeoutMillis(int connectionRequestTimeoutMillis) {
    this.connectionRequestTimeoutMillis = connectionRequestTimeoutMillis;
  }

  /**
   * Fluent setter for {@link #setConnectionRequestTimeoutMillis(int)}.
   *
   * @param connectionRequestTimeoutMillis the connection request timeout in milliseconds
   * @return this Config instance
   */
  public Config connectionRequestTimeoutMillis(int connectionRequestTimeoutMillis) {
    this.connectionRequestTimeoutMillis = connectionRequestTimeoutMillis;
    return this;
  }

  public Boolean getProtocolUpgradeEnabled() {
    return protocolUpgradeEnabled;
  }

  /**
   * Whether the HTTP requests should automatically attempt to upgrade to a safer/newer version of
   * the protocol. See also AdyenHttpClient createRequest() method.
   */
  public void setProtocolUpgradeEnabled(Boolean protocolUpgradeEnabled) {
    this.protocolUpgradeEnabled = protocolUpgradeEnabled;
  }

  public Config protocolUpgradeEnabled(Boolean protocolUpgradeEnabled) {
    this.protocolUpgradeEnabled = protocolUpgradeEnabled;
    return this;
  }

  public String getLiveEndpointUrlPrefix() {
    return this.liveEndpointUrlPrefix;
  }

  public void setLiveEndpointUrlPrefix(String liveEndpointUrlPrefix) {
    this.liveEndpointUrlPrefix = liveEndpointUrlPrefix;
  }

  public Config liveEndpointUrlPrefix(String liveEndpointUrlPrefix) {
    this.liveEndpointUrlPrefix = liveEndpointUrlPrefix;
    return this;
  }

  public SSLContext getSSLContext() {
    return sslContext;
  }

  /**
   * Sets the {@link SSLContext} for the {@link com.adyen.httpclient.AdyenHttpClient}.
   *
   * @param sslContext The {@link SSLContext}
   */
  public void setSSLContext(SSLContext sslContext) {
    this.sslContext = sslContext;
  }

  public Config sslContext(SSLContext sslContext) {
    this.sslContext = sslContext;
    return this;
  }

  public HostnameVerifier getHostnameVerifier() {
    return hostnameVerifier;
  }

  /**
   * Sets the {@link HostnameVerifier} for the {@link com.adyen.httpclient.AdyenHttpClient}.
   *
   * @param hostnameVerifier The {@link HostnameVerifier}
   * @see com.adyen.httpclient.TerminalLocalAPIHostnameVerifier
   */
  public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
    this.hostnameVerifier = hostnameVerifier;
  }

  public Config hostnameVerifier(HostnameVerifier hostnameVerifier) {
    this.hostnameVerifier = hostnameVerifier;
    return this;
  }
}
