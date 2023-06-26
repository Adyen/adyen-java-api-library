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
 * Copyright (c) 2018 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.adyen.enums.Environment;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

public class Config {
    protected String username;
    protected String password;
    protected String merchantAccount;
    protected Environment environment;
    protected String endpoint;
    protected String marketPayEndpoint;
    protected String balancePlatformEndpoint;
    /**
     * Application name: used as HTTP client User-Agent
     */
    protected String applicationName;
    protected String apiKey;
    protected int connectionTimeoutMillis;
    protected int readTimeoutMillis;

    //Checkout Specific
    protected String checkoutEndpoint;

    //Terminal API Specific
    protected String terminalApiCloudEndpoint;
    protected String terminalApiLocalEndpoint;

    //Terminal Management API specific
    protected String posTerminalManagementApiEndpoint;

    protected String dataProtectionEndpoint;

    protected String legalEntityManagementEndpoint;
    protected String managementEndpoint;
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

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getMarketPayEndpoint() {
        return marketPayEndpoint;
    }

    public void setMarketPayEndpoint(String marketPayEndpoint) {
        this.marketPayEndpoint = marketPayEndpoint;
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

    public String getCheckoutEndpoint() {
        if (checkoutEndpoint == null || checkoutEndpoint.isEmpty()) {
            String message = "Please provide your unique live url prefix on the setEnvironment() call on the Client or provide checkoutEndpoint in your config object.";
            throw new IllegalArgumentException(message);
        }
        return checkoutEndpoint;
    }

    public void setCheckoutEndpoint(String checkoutEndpoint) {
        this.checkoutEndpoint = checkoutEndpoint;
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

    public String getPosTerminalManagementApiEndpoint() {
        return posTerminalManagementApiEndpoint;
    }

    public void setPosTerminalManagementApiEndpoint(String posTerminalManagementApiEndpoint) {
        this.posTerminalManagementApiEndpoint = posTerminalManagementApiEndpoint;
    }

    public String getDataProtectionEndpoint() {
        return dataProtectionEndpoint;
    }

    public void setDataProtectionEndpoint(String dataProtectionEndpoint) {
        this.dataProtectionEndpoint = dataProtectionEndpoint;
    }

    public String getBalancePlatformEndpoint() {
        return balancePlatformEndpoint;
    }

    public void setBalancePlatformEndpoint(String balancePlatformEndpoint) {
        this.balancePlatformEndpoint = balancePlatformEndpoint;
    }

    public String getLegalManagementEndpoint() {
        return legalEntityManagementEndpoint;
    }

    public void setLegalEntityManagementEndpoint(String legalEntityManagementEndpoint) {
        this.legalEntityManagementEndpoint = legalEntityManagementEndpoint;
    }

    public String getManagementEndpoint() {
        return managementEndpoint;
    }

    public void setManagementEndpoint(String managementEndpoint) {
        this.managementEndpoint = managementEndpoint;
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
