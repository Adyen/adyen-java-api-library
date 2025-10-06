package com.adyen;

import com.adyen.enums.Environment;
import com.adyen.enums.Region;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

public class Config {
  // API key authentication
  protected String apiKey;
  // Basic authentication
  protected String username;
  protected String password;
  // Environment: Test or Live
  protected Environment environment;

  // Application name: used as HTTP client User-Agent
  protected String applicationName;

  // HTTP Client options
  protected int connectionTimeoutMillis = 60 * 1000; // default 60 sec
  protected int readTimeoutMillis = 60 * 1000; // default 60 sec
  protected int connectionRequestTimeoutMillis = 60 * 1000; // default 60 sec
  protected int defaultKeepAliveMillis = 60 * 1000; // default 60 sec
  protected Boolean protocolUpgradeEnabled;

  // Terminal API configuration
  protected String terminalApiCloudEndpoint;
  protected String terminalApiLocalEndpoint;
  protected String liveEndpointUrlPrefix;
  protected Region terminalApiRegion;
  protected SSLContext sslContext;
  protected HostnameVerifier hostnameVerifier;

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

  public int getConnectionTimeoutMillis() {
    return connectionTimeoutMillis;
  }

  public void setConnectionTimeoutMillis(int connectionTimeoutMillis) {
    this.connectionTimeoutMillis = connectionTimeoutMillis;
  }

  public Config connectionTimeoutMillis(int connectionTimeoutMillis) {
    this.connectionTimeoutMillis = connectionTimeoutMillis;
    return this;
  }

  public int getReadTimeoutMillis() {
    return readTimeoutMillis;
  }

  public void setReadTimeoutMillis(int readTimeoutMillis) {
    this.readTimeoutMillis = readTimeoutMillis;
  }

  public Config readTimeoutMillis(int readTimeoutMillis) {
    this.readTimeoutMillis = readTimeoutMillis;
    return this;
  }

  public int getDefaultKeepAliveMillis() {
    return defaultKeepAliveMillis;
  }

  public void setDefaultKeepAliveMillis(int defaultKeepAliveMillis) {
    this.defaultKeepAliveMillis = defaultKeepAliveMillis;
  }

  public Config defaultKeepAliveMillis(int defaultKeepAliveMillis) {
    this.defaultKeepAliveMillis = defaultKeepAliveMillis;
    return this;
  }

  public int getConnectionRequestTimeoutMillis() {
    return connectionRequestTimeoutMillis;
  }

  public void setConnectionRequestTimeoutMillis(int connectionRequestTimeoutMillis) {
    this.connectionRequestTimeoutMillis = connectionRequestTimeoutMillis;
  }

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
