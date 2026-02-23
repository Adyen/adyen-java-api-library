package com.adyen;

import com.adyen.enums.Environment;
import com.adyen.enums.Region;
import com.adyen.httpclient.AdyenHttpClient;
import com.adyen.httpclient.ClientInterface;
import javax.net.ssl.SSLContext;

public class Client {
  private ClientInterface httpClient;
  private Config config;
  public static final String LIB_NAME = "adyen-java-api-library";
  public static final String LIB_VERSION = "41.0.0";
  public static final String TERMINAL_API_ENDPOINT_TEST = "https://terminal-api-test.adyen.com";
  public static final String TERMINAL_API_ENDPOINT_LIVE = "https://terminal-api-live.adyen.com";
  public static final String TERMINAL_API_ENDPOINT_US = "https://terminal-api-live-us.adyen.com";
  public static final String TERMINAL_API_ENDPOINT_AU = "https://terminal-api-live-au.adyen.com";
  public static final String TERMINAL_API_ENDPOINT_APSE =
      "https://terminal-api-live-apse.adyen.com";

  /** Create Client instance (empty config) */
  public Client() {
    this.config = new Config();
  }

  /**
   * Create Client instance with the given configuration
   *
   * @param config Configuration
   */
  public Client(Config config) {
    this.config = config;
    this.setEnvironment(config.environment, config.liveEndpointUrlPrefix);
  }

  /**
   * Use this constructor to create client for client certificate authentication along with API key.
   * Note: Client certificate authentication is only applicable for PAL and Checkout services in
   * LIVE, Other services will just use API key for authentication.
   *
   * @param sslContext {@link SSLContext} for client certificate authentication
   * @param apiKey Adyen API Key
   */
  public Client(SSLContext sslContext, String apiKey) {
    this(apiKey, Environment.LIVE);
    this.config.setSSLContext(sslContext);
  }

  /**
   * Create Client instance
   *
   * @param username HTTP basic username
   * @param password HTTP basic password
   * @param environment Environment (Test or Live)
   * @param liveEndpointUrlPrefix Prefix required for Live integrations
   */
  public Client(
      String username, String password, Environment environment, String liveEndpointUrlPrefix) {
    this(username, password, environment, liveEndpointUrlPrefix, null);
  }

  /**
   * Create Client instance
   *
   * @param username HTTP basic username
   * @param password HTTP basic password
   * @param environment Environment (Test or Live)
   * @param liveEndpointUrlPrefix Prefix required for Live integrations
   * @param applicationName Application name (additional name/tag passed in HTTP requests)
   */
  public Client(
      String username,
      String password,
      Environment environment,
      String liveEndpointUrlPrefix,
      String applicationName) {
    this.config = new Config();
    this.config.setUsername(username);
    this.config.setPassword(password);
    this.setEnvironment(environment, liveEndpointUrlPrefix);
    this.config.setApplicationName(applicationName);
  }

  /**
   * Create Client instance
   *
   * @param apiKey API Key
   * @param environment Environment (Test or Live)
   */
  public Client(String apiKey, Environment environment) {
    this(apiKey, environment, null);
  }

  /**
   * Create Client instance
   *
   * @param apiKey API Key
   * @param environment Environment (Test or Live)
   * @param liveEndpointUrlPrefix Prefix required for the live integrations
   */
  public Client(String apiKey, Environment environment, String liveEndpointUrlPrefix) {
    this.config = new Config();
    this.config.setApiKey(apiKey);
    this.setEnvironment(environment, liveEndpointUrlPrefix);
  }

  /**
   * Set Environment, together with the live endpoint url prefix.
   *
   * @param environment Environment (Test or Live)
   * @param liveEndpointUrlPrefix The unique live url prefix (required for live integrations)
   */
  public void setEnvironment(Environment environment, String liveEndpointUrlPrefix) {
    config.setEnvironment(environment);
    config.setLiveEndpointUrlPrefix(liveEndpointUrlPrefix);

    String endpoint = retrieveCloudEndpoint(config.getTerminalApiRegion(), environment);
    config.setTerminalApiCloudEndpoint(endpoint);
  }

  /**
   * Retrieve the Terminal Cloud endpoint based on Region and Environment
   *
   * @param region The region for which the endpoint is requested. If null or the region is not
   *     found, defaults to default EU endpoint.
   * @param environment Environment (Test or Live)
   */
  public String retrieveCloudEndpoint(Region region, Environment environment) {
    // Check the environment for TEST and get the endpoint
    if (environment.equals(Environment.TEST)) {
      return Client.TERMINAL_API_ENDPOINT_TEST;
    }

    // For LIVE environment, lookup the endpoint using the map
    if (environment.equals(Environment.LIVE)) {
      if (region == null) {
        return Region.TERMINAL_API_ENDPOINTS_MAPPING.get(Region.EU);
      }
      if (!Region.TERMINAL_API_ENDPOINTS_MAPPING.containsKey(region)) {
        throw new IllegalArgumentException(
            "TerminalAPI endpoint for " + region + " is not supported yet");
      }
      return Region.TERMINAL_API_ENDPOINTS_MAPPING.getOrDefault(region, TERMINAL_API_ENDPOINT_LIVE);
    }

    // Default to TEST if no environment or region is specified
    return Client.TERMINAL_API_ENDPOINT_TEST;
  }

  @Override
  public String toString() {
    return "Client [webServiceUser="
        + this.config.username
        + ", environment="
        + this.config.environment
        + "]";
  }

  public ClientInterface getHttpClient() {
    return this.httpClient == null ? new AdyenHttpClient() : this.httpClient;
  }

  public void setHttpClient(ClientInterface httpClient) {
    this.httpClient = httpClient;
  }

  public Config getConfig() {
    return config;
  }

  public void setConfig(Config config) {
    this.config = config;
  }

  public void setApplicationName(String applicationName) {
    this.config.setApplicationName(applicationName);
  }

  public void setTimeouts(int connectionTimeoutMillis, int readTimeoutMillis) {
    this.config.setConnectionTimeoutMillis(connectionTimeoutMillis);
    this.config.setReadTimeoutMillis(readTimeoutMillis);
  }
}
