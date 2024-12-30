package com.adyen;

import com.adyen.enums.Environment;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

public class Config {
    protected String username;
    protected String password;
    protected Environment environment;

    /**
     * Application name: used as HTTP client User-Agent
     */
    protected String applicationName;
    protected String apiKey;
    protected int connectionTimeoutMillis;
    protected int readTimeoutMillis;

    //Terminal API Specific
    protected String terminalApiCloudEndpoint;
    protected String terminalApiLocalEndpoint;
    protected String liveEndpointUrlPrefix;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getTerminalApiCloudEndpoint() {
        return terminalApiCloudEndpoint;
    }

    public void setTerminalApiCloudEndpoint(String terminalApiCloudEndpoint) {
        this.terminalApiCloudEndpoint = terminalApiCloudEndpoint;
    }

    public String getTerminalApiLocalEndpoint() {
        return terminalApiLocalEndpoint;
    }

    public void setTerminalApiLocalEndpoint(String terminalApiLocalEndpoint) {
        this.terminalApiLocalEndpoint = terminalApiLocalEndpoint;
    }

    public int getConnectionTimeoutMillis() {
        return connectionTimeoutMillis;
    }

    public void setConnectionTimeoutMillis(int connectionTimeoutMillis) {
        this.connectionTimeoutMillis = connectionTimeoutMillis;
    }

    public int getReadTimeoutMillis() {
        return readTimeoutMillis;
    }

    public void setReadTimeoutMillis(int readTimeoutMillis) {
        this.readTimeoutMillis = readTimeoutMillis;
    }

    public String getLiveEndpointUrlPrefix() {
        return this.liveEndpointUrlPrefix;
    }
    public void setLiveEndpointUrlPrefix(String liveEndpointUrlPrefix) {
        this.liveEndpointUrlPrefix = liveEndpointUrlPrefix;
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
}
