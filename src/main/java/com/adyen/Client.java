package com.adyen;

import com.adyen.enums.Environment;
import com.adyen.httpclient.ClientInterface;
import com.adyen.httpclient.HttpURLConnectionClient;

public class Client {

    private ClientInterface httpClient;
    private Config config;

    public static final String ENDPOINT_TEST = "https://pal-test.adyen.com";
    public static final String ENDPOINT_LIVE = "https://pal-live.adyen.com";
    public static final String HPP_TEST = "https://test.adyen.com/hpp";
    public static final String HPP_LIVE = "https://live.adyen.com/hpp";
    public static final String API_VERSION = "v18";
    public static final String USER_AGENT_SUFFIX = "adyen-java-api-library/";
    public static final String LIB_VERSION = "0.1.0";

    public Client() {
        this.config = new Config();
    }

    public Client(Config config) {
        this.config = config;
    }

    public Client(String username, String password, Environment environment, String applicationName) {

        this.config = new Config();
        this.config.setUsername(username);
        this.config.setPassword(password);
        this.setEnvironment(environment);
        this.config.setApplicationName(applicationName);
    }

    public void setEnvironment(Environment environment) {

        if (environment.equals(Environment.TEST)) {
            this.config.setEnvironment(environment);
            this.config.setEndpoint(ENDPOINT_TEST);
            this.config.setHppEndpoint(HPP_TEST);
        } else if (environment.equals(Environment.LIVE)) {
            this.config.setEnvironment(environment);
            this.config.setEndpoint(ENDPOINT_LIVE);
            this.config.setHppEndpoint(HPP_LIVE);
        } else {
            // throw exception
        }
    }

    @Override
    public String toString() {
        return "Client [webServiceUser=" + this.config.username + ", webServicePassword=" + this.config.password
                + ", environment=" + this.config.environment + "]";
    }

    public ClientInterface getHttpClient() {

        if (this.httpClient == null) {
            this.httpClient = new HttpURLConnectionClient();
        }
        return this.httpClient;
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

    public String getApiVersion() {
        return API_VERSION;
    }

    public String getLibraryVersion() {
        return LIB_VERSION;
    }

    public void setApplicationName(String applicationName) {
        this.config.setApplicationName(applicationName);
    }

}
