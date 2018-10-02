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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
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
    public static final String MARKETPAY_ENDPOINT_TEST = "https://cal-test.adyen.com/cal/services";
    public static final String MARKETPAY_ENDPOINT_LIVE = "https://cal-live.adyen.com/cal/services";
    public static final String API_VERSION = "v30";
    public static final String RECURRING_API_VERSION = "v25";
    public static final String MARKETPAY_ACCOUNT_API_VERSION = "v4";
    public static final String MARKETPAY_FUND_API_VERSION = "v3";
    public static final String MARKETPAY_NOTIFICATION_API_VERSION = "v1";
    public static final String USER_AGENT_SUFFIX = "adyen-java-api-library/";
    public static final String LIB_VERSION = "1.5.3";
    public static final String CHECKOUT_ENDPOINT_TEST = "https://checkout-test.adyen.com";
    public static final String CHECKOUT_ENDPOINT_LIVE_SUFFIX = "-checkout-live.adyenpayments.com";
    public static final String CHECKOUT_API_VERSION = "v32";
    public static final String CHECKOUT_UTILITY_API_VERSION = "v1";

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

    public Client(String username, String password, Environment environment, int connectionTimeoutMillis) {

        this.config = new Config();
        this.config.setUsername(username);
        this.config.setPassword(password);
        this.setEnvironment(environment);
        this.config.setConnectionTimeoutMillis(connectionTimeoutMillis);
    }

    public Client(String apiKey, Environment environment) {

        this.config = new Config();
        this.config.setApiKey(apiKey);
        this.setEnvironment(environment);
    }

    public Client(String apiKey, Environment environment, int connectionTimeoutMillis) {

        this.config = new Config();
        this.config.setApiKey(apiKey);
        this.setEnvironment(environment);
        this.config.setConnectionTimeoutMillis(connectionTimeoutMillis);
    }

    public Client(String username, String password, Environment environment, String applicationName, String liveEndpointUrlPrefix) {

        this.config = new Config();
        this.config.setUsername(username);
        this.config.setPassword(password);
        this.setEnvironment(environment, liveEndpointUrlPrefix);
        this.config.setApplicationName(applicationName);
    }

    public Client(String username, String password, Environment environment, int connectionTimeoutMillis, String liveEndpointUrlPrefix) {

        this.config = new Config();
        this.config.setUsername(username);
        this.config.setPassword(password);
        this.setEnvironment(environment, liveEndpointUrlPrefix);
        this.config.setConnectionTimeoutMillis(connectionTimeoutMillis);
    }

    public Client(String apiKey, Environment environment, int connectionTimeoutMillis, String liveEndpointUrlPrefix) {

        this.config = new Config();
        this.config.setApiKey(apiKey);
        this.setEnvironment(environment, liveEndpointUrlPrefix);
        this.config.setConnectionTimeoutMillis(connectionTimeoutMillis);
    }

    /**
     * @deprecated As of library version 1.5.4, replaced by {@link #setEnvironment(Environment environment, String liveEndpointUrlPrefix)}.
     */
    public void setEnvironment(Environment environment) {

        if (environment.equals(Environment.TEST)) {
            this.config.setEnvironment(environment);
            this.config.setEndpoint(ENDPOINT_TEST);
            this.config.setMarketPayEndpoint(MARKETPAY_ENDPOINT_TEST);
            this.config.setHppEndpoint(HPP_TEST);
            this.config.setCheckoutEndpoint(CHECKOUT_ENDPOINT_TEST);

        } else if (environment.equals(Environment.LIVE)) {
            this.config.setEnvironment(environment);
            this.config.setEndpoint(ENDPOINT_LIVE);
            this.config.setMarketPayEndpoint(MARKETPAY_ENDPOINT_LIVE);
            this.config.setHppEndpoint(HPP_LIVE);
        } else {
            // throw exception
        }
    }

    /**
     * @param environment
     * @param liveEndpointUrlPrefix - Provide the [random]-[company name] combination from the "API URLs and Response" menu in the Adyen Customer Area
     */
    public void setEnvironment(Environment environment, String liveEndpointUrlPrefix) {

        if (environment.equals(Environment.TEST)) {
            this.config.setEnvironment(environment);
            this.config.setEndpoint(ENDPOINT_TEST);
            this.config.setMarketPayEndpoint(MARKETPAY_ENDPOINT_TEST);
            this.config.setHppEndpoint(HPP_TEST);
            this.config.setCheckoutEndpoint(CHECKOUT_ENDPOINT_TEST);

        } else if (environment.equals(Environment.LIVE)) {
            this.config.setEnvironment(environment);
            this.config.setEndpoint(ENDPOINT_LIVE);
            this.config.setMarketPayEndpoint(MARKETPAY_ENDPOINT_LIVE);
            this.config.setHppEndpoint(HPP_LIVE);
            this.config.setCheckoutEndpoint("https://" + liveEndpointUrlPrefix + CHECKOUT_ENDPOINT_LIVE_SUFFIX);
        } else {
            // throw exception
        }
    }

    @Override
    public String toString() {
        return "Client [webServiceUser=" + this.config.username + ", webServicePassword=" + this.config.password + ", environment=" + this.config.environment + "]";
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

    public void setApplicationName(String applicationName) {
        this.config.setApplicationName(applicationName);
    }

}
