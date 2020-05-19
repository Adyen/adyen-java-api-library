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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.checkout;

import com.adyen.model.Address;
import com.adyen.model.Amount;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * CreatePaymentLinkRequest
 */
public class CreatePaymentLinkRequest {
    @SerializedName("allowedPaymentMethods")
    private List<String> allowedPaymentMethods = null;

    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("billingAddress")
    private Address billingAddress = null;

    @SerializedName("blockedPaymentMethods")
    private List<String> blockedPaymentMethods = null;

    @SerializedName("countryCode")
    private String countryCode = null;

    @SerializedName("deliveryAddress")
    private Address deliveryAddress = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("expiresAt")
    private String expiresAt = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("reference")
    private String reference = null;

    @SerializedName("returnUrl")
    private String returnUrl = null;

    @SerializedName("shopperEmail")
    private String shopperEmail = null;

    @SerializedName("shopperLocale")
    private String shopperLocale = null;

    @SerializedName("shopperReference")
    private String shopperReference = null;

    @SerializedName("storePaymentMethod")
    private Boolean storePaymentMethod = null;

    public CreatePaymentLinkRequest allowedPaymentMethods(List<String> allowedPaymentMethods) {
        this.allowedPaymentMethods = allowedPaymentMethods;
        return this;
    }

    public CreatePaymentLinkRequest addAllowedPaymentMethodsItem(String allowedPaymentMethodsItem) {
        if (this.allowedPaymentMethods == null) {
            this.allowedPaymentMethods = new ArrayList<>();
        }
        this.allowedPaymentMethods.add(allowedPaymentMethodsItem);
        return this;
    }

    /**
     * List of payments methods to be presented to the shopper. To refer to payment methods, use their &#x60;brandCode&#x60; from [Payment methods overview](https://docs.adyen.com/payment-methods).
     *
     * @return allowedPaymentMethods
     **/
    public List<String> getAllowedPaymentMethods() {
        return allowedPaymentMethods;
    }

    public void setAllowedPaymentMethods(List<String> allowedPaymentMethods) {
        this.allowedPaymentMethods = allowedPaymentMethods;
    }

    public CreatePaymentLinkRequest amount(Amount amount) {
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

    public CreatePaymentLinkRequest billingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    /**
     * Get billingAddress
     *
     * @return billingAddress
     **/
    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public CreatePaymentLinkRequest blockedPaymentMethods(List<String> blockedPaymentMethods) {
        this.blockedPaymentMethods = blockedPaymentMethods;
        return this;
    }

    public CreatePaymentLinkRequest addBlockedPaymentMethodsItem(String blockedPaymentMethodsItem) {
        if (this.blockedPaymentMethods == null) {
            this.blockedPaymentMethods = new ArrayList<>();
        }
        this.blockedPaymentMethods.add(blockedPaymentMethodsItem);
        return this;
    }

    /**
     * List of payments methods to be hidden from the shopper. To refer to payment methods, use their &#x60;brandCode&#x60; from [Payment methods overview](https://docs.adyen.com/payment-methods).
     *
     * @return blockedPaymentMethods
     **/
    public List<String> getBlockedPaymentMethods() {
        return blockedPaymentMethods;
    }

    public void setBlockedPaymentMethods(List<String> blockedPaymentMethods) {
        this.blockedPaymentMethods = blockedPaymentMethods;
    }

    public CreatePaymentLinkRequest countryCode(String countryCode) {
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

    public CreatePaymentLinkRequest deliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }

    /**
     * Get deliveryAddress
     *
     * @return deliveryAddress
     **/
    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public CreatePaymentLinkRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A short description visible on the Pay By Link page. Maximum length: 280 characters.
     *
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CreatePaymentLinkRequest expiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
        return this;
    }

    /**
     * The date that the Pay By Link expires; e.g. 2019-03-23T12:25:28Z. If not provided, the default expiry duration is 1 day.
     *
     * @return expiresAt
     **/
    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public CreatePaymentLinkRequest merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    /**
     * The merchant account identifier, with which you want to process the transaction.
     *
     * @return merchantAccount
     **/
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public CreatePaymentLinkRequest reference(String reference) {
        this.reference = reference;
        return this;
    }

    /**
     * The reference to uniquely identify a payment. This reference is used in all communication with you about the payment status. We recommend using a unique value per payment; however, it is not a requirement. If you need to provide multiple references for a transaction, separate them with hyphens (\&quot;-\&quot;). Maximum length: 80 characters.
     *
     * @return reference
     **/
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public CreatePaymentLinkRequest returnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
        return this;
    }

    /**
     * Merchant URL used for redirection after payment is completed
     *
     * @return returnUrl
     **/
    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public CreatePaymentLinkRequest shopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
        return this;
    }

    /**
     * The shopper&#x27;s email address. We recommend that you provide this data, as it is used in velocity fraud checks. &gt; For 3D Secure 2 transactions, schemes require the &#x60;shopperEmail&#x60; for both &#x60;deviceChannel&#x60; **browser** and **app**.
     *
     * @return shopperEmail
     **/
    public String getShopperEmail() {
        return shopperEmail;
    }

    public void setShopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
    }

    public CreatePaymentLinkRequest shopperLocale(String shopperLocale) {
        this.shopperLocale = shopperLocale;
        return this;
    }

    /**
     * The combination of a language code and a country code to specify the language to be used in the payment.
     *
     * @return shopperLocale
     **/
    public String getShopperLocale() {
        return shopperLocale;
    }

    public void setShopperLocale(String shopperLocale) {
        this.shopperLocale = shopperLocale;
    }

    public CreatePaymentLinkRequest shopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
        return this;
    }

    /**
     * The shopper&#x27;s reference to uniquely identify this shopper (e.g. user ID or account ID). &gt; This field is required for recurring payments.
     *
     * @return shopperReference
     **/
    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    public CreatePaymentLinkRequest storePaymentMethod(Boolean storePaymentMethod) {
        this.storePaymentMethod = storePaymentMethod;
        return this;
    }

    /**
     * When true and &#x60;shopperReference&#x60; is provided, the payment details will be stored.
     *
     * @return storePaymentMethod
     **/
    public Boolean isStorePaymentMethod() {
        return storePaymentMethod;
    }

    public void setStorePaymentMethod(Boolean storePaymentMethod) {
        this.storePaymentMethod = storePaymentMethod;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreatePaymentLinkRequest createPaymentLinkRequest = (CreatePaymentLinkRequest) o;
        return Objects.equals(this.allowedPaymentMethods, createPaymentLinkRequest.allowedPaymentMethods) &&
                Objects.equals(this.amount, createPaymentLinkRequest.amount) &&
                Objects.equals(this.billingAddress, createPaymentLinkRequest.billingAddress) &&
                Objects.equals(this.blockedPaymentMethods, createPaymentLinkRequest.blockedPaymentMethods) &&
                Objects.equals(this.countryCode, createPaymentLinkRequest.countryCode) &&
                Objects.equals(this.deliveryAddress, createPaymentLinkRequest.deliveryAddress) &&
                Objects.equals(this.description, createPaymentLinkRequest.description) &&
                Objects.equals(this.expiresAt, createPaymentLinkRequest.expiresAt) &&
                Objects.equals(this.merchantAccount, createPaymentLinkRequest.merchantAccount) &&
                Objects.equals(this.reference, createPaymentLinkRequest.reference) &&
                Objects.equals(this.returnUrl, createPaymentLinkRequest.returnUrl) &&
                Objects.equals(this.shopperEmail, createPaymentLinkRequest.shopperEmail) &&
                Objects.equals(this.shopperLocale, createPaymentLinkRequest.shopperLocale) &&
                Objects.equals(this.shopperReference, createPaymentLinkRequest.shopperReference) &&
                Objects.equals(this.storePaymentMethod, createPaymentLinkRequest.storePaymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowedPaymentMethods, amount, billingAddress, blockedPaymentMethods, countryCode, deliveryAddress, description, expiresAt, merchantAccount, reference, returnUrl, shopperEmail, shopperLocale, shopperReference, storePaymentMethod);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreatePaymentLinkRequest {\n");

        sb.append("    allowedPaymentMethods: ").append(toIndentedString(allowedPaymentMethods)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
        sb.append("    blockedPaymentMethods: ").append(toIndentedString(blockedPaymentMethods)).append("\n");
        sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
        sb.append("    deliveryAddress: ").append(toIndentedString(deliveryAddress)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    returnUrl: ").append(toIndentedString(returnUrl)).append("\n");
        sb.append("    shopperEmail: ").append(toIndentedString(shopperEmail)).append("\n");
        sb.append("    shopperLocale: ").append(toIndentedString(shopperLocale)).append("\n");
        sb.append("    shopperReference: ").append(toIndentedString(shopperReference)).append("\n");
        sb.append("    storePaymentMethod: ").append(toIndentedString(storePaymentMethod)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
