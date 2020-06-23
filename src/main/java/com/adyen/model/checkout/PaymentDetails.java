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


package com.adyen.model.checkout;

import com.adyen.model.Amount;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.constants.TextConstants.LINE_BREAK;
import static com.adyen.util.Util.toIndentedString;

/**
 * PaymentDetails
 */
public class PaymentDetails {

    @SerializedName("additionalAmount")
    private Amount additionalAmount = null;

    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("countryCode")
    private String countryCode = null;

    @SerializedName("reference")
    private String reference = null;

    @SerializedName("sessionValidity")
    private String sessionValidity = null;

    @SerializedName("shopperLocale")
    private String shopperLocale = null;

    @SerializedName("shopperReference")
    private String shopperReference = null;

    public PaymentDetails additionalAmount(Amount additionalAmount) {
        this.additionalAmount = additionalAmount;
        return this;
    }


    /**
     * Get additionalAmount
     *
     * @return additionalAmount
     **/
    public Amount getAdditionalAmount() {
        return additionalAmount;
    }

    public void setAdditionalAmount(Amount additionalAmount) {
        this.additionalAmount = additionalAmount;
    }

    public PaymentDetails amount(Amount amount) {
        this.amount = amount;
        return this;
    }


    /**
     * Get amount
     *
     * @return amount
     **/
    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public PaymentDetails countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }


    /**
     * The shopper&#x27;s country code.
     *
     * @return countryCode
     **/
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public PaymentDetails reference(String reference) {
        this.reference = reference;
        return this;
    }


    /**
     * The reference assigned to the payment.
     *
     * @return reference
     **/
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public PaymentDetails sessionValidity(String sessionValidity) {
        this.sessionValidity = sessionValidity;
        return this;
    }


    /**
     * The maximum validity of the session.
     *
     * @return sessionValidity
     **/
    public String getSessionValidity() {
        return sessionValidity;
    }

    public void setSessionValidity(String sessionValidity) {
        this.sessionValidity = sessionValidity;
    }

    public PaymentDetails shopperLocale(String shopperLocale) {
        this.shopperLocale = shopperLocale;
        return this;
    }


    /**
     * The shopper&#x27;s locale.
     *
     * @return shopperLocale
     **/
    public String getShopperLocale() {
        return shopperLocale;
    }

    public void setShopperLocale(String shopperLocale) {
        this.shopperLocale = shopperLocale;
    }

    public PaymentDetails shopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
        return this;
    }


    /**
     * The reference used to uniquely identify the shopper (e.g. user ID or account ID).
     *
     * @return shopperReference
     **/
    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentDetails paymentDetails = (PaymentDetails) o;
        return Objects.equals(this.additionalAmount, paymentDetails.additionalAmount) &&
                Objects.equals(this.amount, paymentDetails.amount) &&
                Objects.equals(this.countryCode, paymentDetails.countryCode) &&
                Objects.equals(this.reference, paymentDetails.reference) &&
                Objects.equals(this.sessionValidity, paymentDetails.sessionValidity) &&
                Objects.equals(this.shopperLocale, paymentDetails.shopperLocale) &&
                Objects.equals(this.shopperReference, paymentDetails.shopperReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalAmount, amount, countryCode, reference, sessionValidity, shopperLocale, shopperReference);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentDetails {").append(LINE_BREAK);

        sb.append("    additionalAmount: ").append(toIndentedString(additionalAmount)).append(LINE_BREAK);
        sb.append("    amount: ").append(toIndentedString(amount)).append(LINE_BREAK);
        sb.append("    countryCode: ").append(toIndentedString(countryCode)).append(LINE_BREAK);
        sb.append("    reference: ").append(toIndentedString(reference)).append(LINE_BREAK);
        sb.append("    sessionValidity: ").append(toIndentedString(sessionValidity)).append(LINE_BREAK);
        sb.append("    shopperLocale: ").append(toIndentedString(shopperLocale)).append(LINE_BREAK);
        sb.append("    shopperReference: ").append(toIndentedString(shopperReference)).append(LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }




}



