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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.checkout.details;

import com.adyen.model.checkout.PaymentMethodDetails;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * KlarnaDetails
 */

public class KlarnaDetails implements PaymentMethodDetails {

    /**
     * Possible types
     */
    public static String KLARNA = "klarna";
    public static String KLARNA_PAYMENTS = "klarnapayments";
    public static String KLARNA_PAYMENTS_ACCOUNT = "klarnapayments_account";
    public static String KLARNA_PAYMENTS_B2B = "klarnapayments_b2b";
    public static String KLARNA_PAY_NOW = "klarna_paynow";
    public static String KLARNA_ACCOUNT = "klarna_account";
    public static String KLARNA_B2B = "klarna_b2b";

    @SerializedName("bankAccount")
    private String bankAccount = null;

    @SerializedName("billingAddress")
    private String billingAddress = null;

    @SerializedName("deliveryAddress")
    private String deliveryAddress = null;

    @SerializedName("installmentConfigurationKey")
    private String installmentConfigurationKey = null;

    @SerializedName("personalDetails")
    private String personalDetails = null;

    @SerializedName("separateDeliveryAddress")
    private String separateDeliveryAddress = null;

    @SerializedName("storedPaymentMethodId")
    private String storedPaymentMethodId = null;

    @SerializedName("token")
    private String token = null;

    @SerializedName("type")
    private String type = null;

    public KlarnaDetails bankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    /**
     * Get bankAccount
     *
     * @return bankAccount
     **/
    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public KlarnaDetails billingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    /**
     * Get billingAddress
     *
     * @return billingAddress
     **/
    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public KlarnaDetails deliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }

    /**
     * Get deliveryAddress
     *
     * @return deliveryAddress
     **/
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public KlarnaDetails installmentConfigurationKey(String installmentConfigurationKey) {
        this.installmentConfigurationKey = installmentConfigurationKey;
        return this;
    }

    /**
     * Get installmentConfigurationKey
     *
     * @return installmentConfigurationKey
     **/
    public String getInstallmentConfigurationKey() {
        return installmentConfigurationKey;
    }

    public void setInstallmentConfigurationKey(String installmentConfigurationKey) {
        this.installmentConfigurationKey = installmentConfigurationKey;
    }

    public KlarnaDetails personalDetails(String personalDetails) {
        this.personalDetails = personalDetails;
        return this;
    }

    /**
     * Get personalDetails
     *
     * @return personalDetails
     **/
    public String getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(String personalDetails) {
        this.personalDetails = personalDetails;
    }

    public KlarnaDetails separateDeliveryAddress(String separateDeliveryAddress) {
        this.separateDeliveryAddress = separateDeliveryAddress;
        return this;
    }

    /**
     * Get separateDeliveryAddress
     *
     * @return separateDeliveryAddress
     **/
    public String getSeparateDeliveryAddress() {
        return separateDeliveryAddress;
    }

    public void setSeparateDeliveryAddress(String separateDeliveryAddress) {
        this.separateDeliveryAddress = separateDeliveryAddress;
    }

    public KlarnaDetails storedPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
        return this;
    }

    /**
     * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the token.
     *
     * @return storedPaymentMethodId
     **/
    public String getStoredPaymentMethodId() {
        return storedPaymentMethodId;
    }

    public void setStoredPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
    }

    public KlarnaDetails token(String token) {
        this.token = token;
        return this;
    }

    /**
     * Get token
     *
     * @return token
     **/
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public KlarnaDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The payment method type.
     *
     * @return type
     **/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KlarnaDetails klarnaDetails = (KlarnaDetails) o;
        return Objects.equals(this.bankAccount, klarnaDetails.bankAccount) &&
                Objects.equals(this.billingAddress, klarnaDetails.billingAddress) &&
                Objects.equals(this.deliveryAddress, klarnaDetails.deliveryAddress) &&
                Objects.equals(this.installmentConfigurationKey, klarnaDetails.installmentConfigurationKey) &&
                Objects.equals(this.personalDetails, klarnaDetails.personalDetails) &&
                Objects.equals(this.separateDeliveryAddress, klarnaDetails.separateDeliveryAddress) &&
                Objects.equals(this.storedPaymentMethodId, klarnaDetails.storedPaymentMethodId) &&
                Objects.equals(this.token, klarnaDetails.token) &&
                Objects.equals(this.type, klarnaDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankAccount, billingAddress, deliveryAddress, installmentConfigurationKey, personalDetails, separateDeliveryAddress, storedPaymentMethodId, token, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KlarnaDetails {\n");

        sb.append("    bankAccount: ").append(toIndentedString(bankAccount)).append("\n");
        sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
        sb.append("    deliveryAddress: ").append(toIndentedString(deliveryAddress)).append("\n");
        sb.append("    installmentConfigurationKey: ").append(toIndentedString(installmentConfigurationKey)).append("\n");
        sb.append("    personalDetails: ").append(toIndentedString(personalDetails)).append("\n");
        sb.append("    separateDeliveryAddress: ").append(toIndentedString(separateDeliveryAddress)).append("\n");
        sb.append("    storedPaymentMethodId: ").append(toIndentedString(storedPaymentMethodId)).append("\n");
        sb.append("    token: ").append(toIndentedString(token)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
