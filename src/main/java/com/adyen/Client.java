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
package com.adyen;

import com.adyen.enums.Environment;
import com.adyen.enums.Region;
import com.adyen.httpclient.AdyenHttpClient;
import com.adyen.httpclient.ClientInterface;

import java.security.KeyStore;

public class Client {
    private ClientInterface httpClient;
    private Config config;

    public static final String ENDPOINT_TEST = "https://pal-test.adyen.com";
    public static final String ENDPOINT_LIVE = "https://pal-live.adyen.com";
    public static final String ENDPOINT_CERT_LIVE = "https://palcert-live.adyen.com";
    public static final String ENDPOINT_LIVE_SUFFIX = "-pal-live.adyenpayments.com";
    public static final String HPP_TEST = "https://test.adyen.com/hpp";
    public static final String HPP_LIVE = "https://live.adyen.com/hpp";
    public static final String MARKETPAY_ENDPOINT_TEST = "https://cal-test.adyen.com/cal/services";
    public static final String MARKETPAY_ENDPOINT_LIVE = "https://cal-live.adyen.com/cal/services";
    public static final String API_VERSION = "v52";
    public static final String PAYOUT_API_VERSION = "v51";
    public static final String RECURRING_API_VERSION = "v49";
    public static final String MARKETPAY_ACCOUNT_API_VERSION = "v6";
    public static final String MARKETPAY_FUND_API_VERSION = "v6";
    public static final String MARKETPAY_NOTIFICATION_API_VERSION = "v6";
    public static final String MARKETPAY_HOP_API_VERSION = "v6";
    public static final String LIB_NAME = "adyen-java-api-library";
    public static final String LIB_VERSION = "17.0.0";
    public static final String CHECKOUT_ENDPOINT_TEST = "https://checkout-test.adyen.com/checkout";
    public static final String CHECKOUT_ENDPOINT_LIVE_SUFFIX = "-checkout-live.adyenpayments.com/checkout";
    public static final String CHECKOUT_ENDPOINT_CERT_LIVE = "https://checkoutcert-live-%s.adyen.com/checkout";
    public static final String CHECKOUT_API_VERSION = "v67";
    public static final String DISPUTE_API_VERSION = "v30";
    public static final String CHECKOUT_STORED_PAYMENT_METHODS_VERSION = "v65";
    public static final String BIN_LOOKUP_PAL_SUFFIX = "/pal/servlet/BinLookup/";
    public static final String BIN_LOOKUP_API_VERSION = "v50";
    public static final String CHECKOUT_UTILITY_API_VERSION = "v1";
    public static final String TERMINAL_API_ENDPOINT_TEST = "https://terminal-api-test.adyen.com";
    public static final String TERMINAL_API_ENDPOINT_LIVE = "https://terminal-api-live.adyen.com";
    public static final String STORED_VALUE_PAL_SUFFIX = "/pal/servlet/StoredValue/";
    public static final String STORED_VALUE_API_VERSION = "v46";
    public static final String ENDPOINT_PROTOCOL = "https://";
    public static final String POS_TERMINAL_MANAGEMENT_ENDPOINT_TEST = "https://postfmapi-test.adyen.com/postfmapi/terminal";
    public static final String POS_TERMINAL_MANAGEMENT_ENDPOINT_LIVE = "https://postfmapi-live.adyen.com/postfmapi/terminal";
    public static final String DATA_PROTECTION_ENDPOINT_TEST = "https://ca-test.adyen.com/ca/services/DataProtectionService";
    public static final String DATA_PROTECTION_ENDPOINT_LIVE = "https://ca-live.adyen.com/ca/services/DataProtectionService";
    public static final String POS_TERMINAL_MANAGEMENT_VERSION = "v1";
    public static final String DATA_PROTECTION_VERSION = "v1";

    public Client() {
        this.config = new Config();
    }

    public Client(Config config) {
        this.config = config;
    }

    public Client(String username, String password, Environment environment, String applicationName) {
        this(username, password, environment, null, applicationName);
    }

    /**
     * Use this constructor to create client for client certificate authentication along with API key.
     * Note: Client certificate authentication is only applicable for PAL and Checkout services in LIVE,
     * Other services will just use API key for authentication.
     * @param trustStore Trust store containing server certificate
     * @param clientKeyStore Client Key store containing client certificate and key
     * @param clientKeyStorePassword Password for client key store
     * @param apiKey Adyen API Key
     * @param region Data center region (EU/US/AU), default EU if not provided
     */
    public Client(KeyStore trustStore, KeyStore clientKeyStore, String clientKeyStorePassword, String apiKey, Region region) {
        this(apiKey, Environment.LIVE);
        this.config.setClientKeyStorePassword(clientKeyStorePassword);
        this.config.setClientKeyStore(clientKeyStore);
        this.config.setTrustKeyStore(trustStore);
        this.config.setEndpoint(ENDPOINT_CERT_LIVE);

        if (region != null) {
            this.config.setCheckoutEndpoint(String.format(CHECKOUT_ENDPOINT_CERT_LIVE, region.name().toLowerCase()));
        } else {
            // default to EU if not provided
            this.config.setCheckoutEndpoint(String.format(CHECKOUT_ENDPOINT_CERT_LIVE, Region.EU.name().toLowerCase()));
        }
    }

    public Client(String username, String password, Environment environment, String liveEndpointUrlPrefix, String applicationName) {
        this.config = new Config();
        this.config.setUsername(username);
        this.config.setPassword(password);
        this.setEnvironment(environment, liveEndpointUrlPrefix);
        this.config.setApplicationName(applicationName);
    }

    /**
     * @param username your merchant account Username
     * @param password your merchant accont Password
     * @param environment This defines the payment environment live or test
     * @param connectionTimeoutMillis Provide the time to time out
     * @deprecated As of library version 1.6.1, timeouts should be set by {@link #setTimeouts(int connectionTimeoutMillis, int readTimeoutMillis)} or directly by {@link
     * com.adyen.Config#setConnectionTimeoutMillis(int connectionTimeoutMillis)}.
     */
    @Deprecated
    public Client(String username, String password, Environment environment, int connectionTimeoutMillis) {
        this(username, password, environment, null);
        this.config.setConnectionTimeoutMillis(connectionTimeoutMillis);
    }

    /**
     * @param username your merchant account Username
     * @param password your merchant accont Password
     * @param environment This defines the payment environment live or test
     * @param connectionTimeoutMillis Provide the time to time out
     * @param liveEndpointUrlPrefix provide the merchant specific url
     * @deprecated As of library version 1.6.1, timeouts should be set by {@link #setTimeouts(int connectionTimeoutMillis, int readTimeoutMillis)} or directly by {@link
     * com.adyen.Config#setConnectionTimeoutMillis(int connectionTimeoutMillis)}.
     */
    @Deprecated
    public Client(String username, String password, Environment environment, int connectionTimeoutMillis, String liveEndpointUrlPrefix) {
        this(username, password, environment, liveEndpointUrlPrefix, null);
        this.config.setConnectionTimeoutMillis(connectionTimeoutMillis);
    }

    public Client(String apiKey, Environment environment) {
        this(apiKey, environment, null);
    }

    public Client(String apiKey, Environment environment, String liveEndpointUrlPrefix) {
        this.config = new Config();
        this.config.setApiKey(apiKey);
        this.setEnvironment(environment, liveEndpointUrlPrefix);
    }

    /**
     * @param apiKey Defines the api key that can be retrieved by back office
     * @param environment This defines the payment environment live or test
     * @param connectionTimeoutMillis Provide the time to time out
     * @deprecated As of library version 1.6.1, timeouts should be set by {@link #setTimeouts(int connectionTimeoutMillis, int readTimeoutMillis)} or directly by {@link
     * com.adyen.Config#setConnectionTimeoutMillis(int connectionTimeoutMillis)}.
     */
    @Deprecated
    public Client(String apiKey, Environment environment, int connectionTimeoutMillis) {
        this(apiKey, environment);
        this.config.setConnectionTimeoutMillis(connectionTimeoutMillis);
    }

    /**
     * @param apiKey Defines the api key that can be retrieved by back office
     * @param environment This defines the payment environment live or test
     * @param connectionTimeoutMillis Provide the time to time out
     * @param liveEndpointUrlPrefix provide the merchant specific url
     * @deprecated As of library version 1.6.1, timeouts should be set by {@link #setTimeouts(int connectionTimeoutMillis, int readTimeoutMillis)} or directly by {@link
     * com.adyen.Config#setConnectionTimeoutMillis(int connectionTimeoutMillis)}.
     */
    @Deprecated
    public Client(String apiKey, Environment environment, int connectionTimeoutMillis, String liveEndpointUrlPrefix) {
        this(apiKey, environment, liveEndpointUrlPrefix);
        this.config.setConnectionTimeoutMillis(connectionTimeoutMillis);
    }

    /**
     * @param environment This defines the payment environment live or test
     * @deprecated As of library version 1.5.4, replaced by {@link #setEnvironment(Environment environment, String liveEndpointUrlPrefix)}.
     */
    @Deprecated
    public void setEnvironment(Environment environment) {
        this.setEnvironment(environment, null);
    }

    /**
     * @param environment           This defines the payment environment live or test
     * @param liveEndpointUrlPrefix Provide the unique live url prefix from the "API URLs and Response" menu in the Adyen Customer Area
     */
    public void setEnvironment(Environment environment, String liveEndpointUrlPrefix) {
        if (Environment.TEST.equals(environment)) {
            this.config.setEnvironment(environment);
            this.config.setEndpoint(ENDPOINT_TEST);
            this.config.setMarketPayEndpoint(MARKETPAY_ENDPOINT_TEST);
            this.config.setHppEndpoint(HPP_TEST);
            this.config.setCheckoutEndpoint(CHECKOUT_ENDPOINT_TEST);
            this.config.setTerminalApiCloudEndpoint(TERMINAL_API_ENDPOINT_TEST);
            this.config.setPosTerminalManagementApiEndpoint(POS_TERMINAL_MANAGEMENT_ENDPOINT_TEST);
            this.config.setDataProtectionEndpoint(DATA_PROTECTION_ENDPOINT_TEST);
        } else if (Environment.LIVE.equals(environment)) {
            this.config.setEnvironment(environment);
            this.config.setMarketPayEndpoint(MARKETPAY_ENDPOINT_LIVE);
            this.config.setHppEndpoint(HPP_LIVE);
            if (liveEndpointUrlPrefix != null && !liveEndpointUrlPrefix.isEmpty()) {
                this.config.setEndpoint(ENDPOINT_PROTOCOL + liveEndpointUrlPrefix + ENDPOINT_LIVE_SUFFIX);
                this.config.setCheckoutEndpoint(ENDPOINT_PROTOCOL + liveEndpointUrlPrefix + CHECKOUT_ENDPOINT_LIVE_SUFFIX);
            } else {
                this.config.setEndpoint(ENDPOINT_LIVE);
                this.config.setCheckoutEndpoint(null);
            }
            this.config.setTerminalApiCloudEndpoint(TERMINAL_API_ENDPOINT_LIVE);
            this.config.setPosTerminalManagementApiEndpoint(POS_TERMINAL_MANAGEMENT_ENDPOINT_LIVE);
            this.config.setDataProtectionEndpoint(DATA_PROTECTION_ENDPOINT_LIVE);
        }
    }

    @Override
    public String toString() {
        return "Client [webServiceUser=" + this.config.username + ", environment=" + this.config.environment + "]";
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
