package com.adyen;

import com.adyen.enums.Environment;
import com.adyen.httpclient.AdyenHttpClient;
import com.adyen.httpclient.ClientInterface;

import javax.net.ssl.SSLContext;

public class Client {
    private ClientInterface httpClient;
    private Config config;
    private EnvironmentConfig environmentConfig;
    private TimeoutConfig timeoutConfig;

    public static final String LIB_NAME = "adyen-java-api-library";
    public static final String LIB_VERSION = "27.0.0";

    public Client() {
        this.config = new Config();
    }

    public Client(Config config) {
        this.config = config;
        this.environmentConfig = new EnvironmentConfig(config.environment, config.liveEndpointUrlPrefix);
    }

    public Client(String username, String password, Environment environment, String applicationName) {
        this(username, password, environment, null, applicationName);
    }

    public Client(SSLContext sslContext, String apiKey) {
        this.config = new Config();
        this.config.setSSLContext(sslContext);
        this.config.setApiKey(apiKey);
        this.environmentConfig = new EnvironmentConfig(Environment.LIVE, null);
    }

    public Client(String username, String password, Environment environment, String liveEndpointUrlPrefix, String applicationName) {
        this.config = new Config();
        this.config.setUsername(username);
        this.config.setPassword(password);
        this.environmentConfig = new EnvironmentConfig(environment, liveEndpointUrlPrefix);
        this.config.setApplicationName(applicationName);
    }

    public Client(String apiKey, Environment environment) {
        this(apiKey, environment, null);
    }

    public Client(String apiKey, Environment environment, String liveEndpointUrlPrefix) {
        this.config = new Config();
        this.config.setApiKey(apiKey);
        this.environmentConfig = new EnvironmentConfig(environment, liveEndpointUrlPrefix);
    }

    public void setEnvironment(Environment environment, String liveEndpointUrlPrefix) {
        this.environmentConfig = new EnvironmentConfig(environment, liveEndpointUrlPrefix);
        this.config.setEnvironment(environment);
        if (liveEndpointUrlPrefix != null) {
            this.config.setLiveEndpointUrlPrefix(liveEndpointUrlPrefix);
        }
    }

    @Override
    public String toString() {
        return "Client [webServiceUser=" + this.config.username + ", environment=" + this.environmentConfig.getEnvironment() + "]";
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
        this.timeoutConfig = new TimeoutConfig(connectionTimeoutMillis, readTimeoutMillis);
        this.config.setConnectionTimeoutMillis(connectionTimeoutMillis);
        this.config.setReadTimeoutMillis(readTimeoutMillis);
    }
}
