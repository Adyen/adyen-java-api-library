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

public class Config {
    protected String username;
    protected String password;
    protected String merchantAccount;
    protected Environment environment;
    protected String endpoint;
    protected String marketPayEndpoint;
    protected String applicationName;
    protected String apiKey;

    //HPP specific
    protected String hppEndpoint;
    protected String skinCode;
    protected String hmacKey;

    //Checkout Specific
    protected String checkoutEndpoint;
    
    protected Integer connectionTimeoutMillis;


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

    public String getHppEndpoint() {
        return hppEndpoint;
    }

    public void setHppEndpoint(String hppEndpoint) {
        this.hppEndpoint = hppEndpoint;
    }

    public String getSkinCode() {
        return skinCode;
    }

    public void setSkinCode(String skinCode) {
        this.skinCode = skinCode;
    }

    public String getHmacKey() {
        return hmacKey;
    }

    public void setHmacKey(String hmacKey) {
        this.hmacKey = hmacKey;
    }

    public String getCheckoutEndpoint() {
        return checkoutEndpoint;
    }

    public void setCheckoutEndpoint(String checkoutEndpoint) {
        this.checkoutEndpoint = checkoutEndpoint;
    }
    
    public Integer getConnectionTimeoutMillis() {
		return connectionTimeoutMillis;
    	
    }
    
    public void setConnectionTimeoutMillis(Integer connectionTimeoutMillis) {
		this.connectionTimeoutMillis = connectionTimeoutMillis;
    }


}
