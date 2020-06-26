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
package com.adyen.model.hpp;

import com.adyen.util.Util;

public class DirectoryLookupRequest {
    private String currencyCode;
    private String paymentAmount;
    private String sessionValidity;
    private String merchantReference;
    private String countryCode;
    private String skinCode;
    private String merchantAccount;
    private String hmacKey;
    private String shopperLocale;

    public DirectoryLookupRequest() {
        sessionValidity = Util.calculateSessionValidity();
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public DirectoryLookupRequest setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public DirectoryLookupRequest setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
        return this;
    }

    public String getSessionValidity() {
        return sessionValidity;
    }

    public DirectoryLookupRequest setSessionValidity(String sessionValidity) {
        this.sessionValidity = sessionValidity;
        return this;
    }

    public String getMerchantReference() {
        return merchantReference;
    }

    public DirectoryLookupRequest setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public DirectoryLookupRequest setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getSkinCode() {
        return skinCode;
    }

    public DirectoryLookupRequest setSkinCode(String skinCode) {
        this.skinCode = skinCode;
        return this;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public DirectoryLookupRequest setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    public String getHmacKey() {
        return hmacKey;
    }

    public DirectoryLookupRequest setHmacKey(String hmacKey) {
        this.hmacKey = hmacKey;
        return this;
    }

    public String getShopperLocale() {
        return shopperLocale;
    }

    public DirectoryLookupRequest setShopperLocale(String shopperLocale) {
        this.shopperLocale = shopperLocale;
        return this;
    }
}
