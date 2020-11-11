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
package com.adyen.model.checkout;

import com.adyen.model.Address;
import com.adyen.model.Amount;
import com.adyen.model.Name;
import com.adyen.model.Split;
import com.adyen.model.applicationinfo.ApplicationInfo;
import com.adyen.serializer.DateSerializer;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * CreatePaymentLinkRequest
 */

public class CreatePaymentLinkRequest {
    @SerializedName("allowedPaymentMethods")
    private List<String> allowedPaymentMethods = null;

    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("applicationInfo")
    private ApplicationInfo applicationInfo = null;

    @SerializedName("billingAddress")
    private Address billingAddress = null;

    @SerializedName("blockedPaymentMethods")
    private List<String> blockedPaymentMethods = null;

    @SerializedName("countryCode")
    private String countryCode = null;

    @SerializedName("deliverAt")
    @JsonAdapter(DateSerializer.class)
    private Date deliverAt = null;

    @SerializedName("deliveryAddress")
    private Address deliveryAddress = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("expiresAt")
    private String expiresAt = null;

    @SerializedName("lineItems")
    private List<LineItem> lineItems = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("merchantOrderReference")
    private String merchantOrderReference = null;

    @SerializedName("metadata")
    private Map<String, String> metadata = null;

    /**
     * Defines a recurring payment type. Allowed values: * &#x60;Subscription&#x60; – A transaction for a fixed or variable amount, which follows a fixed schedule. * &#x60;CardOnFile&#x60; – With a card-on-file (CoF) transaction, card details are stored to enable one-click or omnichannel journeys, or simply to streamline the checkout process. Any subscription not following a fixed schedule is also considered a card-on-file transaction. * &#x60;UnscheduledCardOnFile&#x60; – An unscheduled card-on-file (UCoF) transaction is a transaction that occurs on a non-fixed schedule and/or has variable amounts. For example, automatic top-ups when a cardholder&#x27;s balance drops below a certain amount.
     */
    @JsonAdapter(RecurringProcessingModelEnum.Adapter.class)
    public enum RecurringProcessingModelEnum {
        CARDONFILE("CardOnFile"),
        SUBSCRIPTION("Subscription"),
        UNSCHEDULEDCARDONFILE("UnscheduledCardOnFile");

        @JsonValue
        private String value;

        RecurringProcessingModelEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static RecurringProcessingModelEnum fromValue(String text) {
            for (RecurringProcessingModelEnum b : RecurringProcessingModelEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<RecurringProcessingModelEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final RecurringProcessingModelEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public RecurringProcessingModelEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return RecurringProcessingModelEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("recurringProcessingModel")
    private RecurringProcessingModelEnum recurringProcessingModel = null;

    @SerializedName("reference")
    private String reference = null;

    @SerializedName("returnUrl")
    private String returnUrl = null;

    @SerializedName("reusable")
    private Boolean reusable = null;

    @SerializedName("riskData")
    private RiskData riskData = null;

    @SerializedName("shopperEmail")
    private String shopperEmail = null;

    @SerializedName("shopperLocale")
    private String shopperLocale = null;

    @SerializedName("shopperName")
    private Name shopperName = null;

    @SerializedName("shopperReference")
    private String shopperReference = null;

    @SerializedName("splits")
    private List<Split> splits = null;

    @SerializedName("store")
    private String store = null;

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
     * List of payments methods to be presented to the shopper. To refer to payment methods, use their &#x60;paymentMethod.type&#x60; from [Payment methods overview](https://docs.adyen.com/payment-methods).  Example: &#x60;\&quot;allowedPaymentMethods\&quot;:[\&quot;ideal\&quot;,\&quot;giropay\&quot;]&#x60;
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

    public CreatePaymentLinkRequest applicationInfo(ApplicationInfo applicationInfo) {
        this.applicationInfo = applicationInfo;
        return this;
    }

    /**
     * Get applicationInfo
     *
     * @return applicationInfo
     **/
    public ApplicationInfo getApplicationInfo() {
        return applicationInfo;
    }

    public void setApplicationInfo(ApplicationInfo applicationInfo) {
        this.applicationInfo = applicationInfo;
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
     * List of payments methods to be hidden from the shopper. To refer to payment methods, use their &#x60;paymentMethod.type&#x60; from [Payment methods overview](https://docs.adyen.com/payment-methods).  Example: &#x60;\&quot;blockedPaymentMethods\&quot;:[\&quot;ideal\&quot;,\&quot;giropay\&quot;]&#x60;
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
     * The shopper&#x27;s two-letter country code.
     *
     * @return countryCode
     **/
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public CreatePaymentLinkRequest deliverAt(Date deliverAt) {
        this.deliverAt = deliverAt;
        return this;
    }

    /**
     * The date and time the purchased goods should be delivered.
     *
     * @return deliverAt
     **/
    public Date getDeliverAt() {
        return deliverAt;
    }

    public void setDeliverAt(Date deliverAt) {
        this.deliverAt = deliverAt;
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
     * A short description visible on the payment page. Maximum length: 280 characters.
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
     * The date that the payment link expires, in ISO 8601 format. For example &#x60;2019-11-23T12:25:28Z&#x60;, or &#x60;2020-05-27T20:25:28+08:00&#x60;. Maximum expiry date should be 30 days from when the payment link is created. If not provided, the default expiry is set to 24 hours after the payment link is created.
     *
     * @return expiresAt
     **/
    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public CreatePaymentLinkRequest lineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
        return this;
    }

    public CreatePaymentLinkRequest addLineItemsItem(LineItem lineItemsItem) {
        if (this.lineItems == null) {
            this.lineItems = new ArrayList<>();
        }
        this.lineItems.add(lineItemsItem);
        return this;
    }

    /**
     * Price and product information about the purchased items, to be included on the invoice sent to the shopper. This parameter is required for open invoice (_buy now, pay later_) payment methods such AfterPay, Klarna, RatePay, and Zip.
     *
     * @return lineItems
     **/
    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public CreatePaymentLinkRequest merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    /**
     * The merchant account identifier for which the payment link is created.
     *
     * @return merchantAccount
     **/
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public CreatePaymentLinkRequest merchantOrderReference(String merchantOrderReference) {
        this.merchantOrderReference = merchantOrderReference;
        return this;
    }

    /**
     * This reference allows linking multiple transactions to each other for reporting purposes (for example, order auth-rate). The reference should be unique per billing cycle.
     *
     * @return merchantOrderReference
     **/
    public String getMerchantOrderReference() {
        return merchantOrderReference;
    }

    public void setMerchantOrderReference(String merchantOrderReference) {
        this.merchantOrderReference = merchantOrderReference;
    }

    public CreatePaymentLinkRequest metadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }

    public CreatePaymentLinkRequest putMetadataItem(String key, String metadataItem) {
        if (this.metadata == null) {
            this.metadata = new HashMap<>();
        }
        this.metadata.put(key, metadataItem);
        return this;
    }

    /**
     * Metadata consists of entries, each of which includes a key and a value. Limitations: * Maximum 20 key-value pairs per request. When exceeding, the \&quot;177\&quot; error occurs: \&quot;Metadata size exceeds limit\&quot; * Maximum 20 characters per key. When exceeding, the \&quot;178\&quot; error occurs: \&quot;Metadata key size exceeds limit\&quot; * A key cannot have the name &#x60;checkout.linkId&#x60;. Whatever value is present under that key is going to be replaced by the real link id
     *
     * @return metadata
     **/
    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public CreatePaymentLinkRequest recurringProcessingModel(RecurringProcessingModelEnum recurringProcessingModel) {
        this.recurringProcessingModel = recurringProcessingModel;
        return this;
    }

    /**
     * Defines a recurring payment type. Allowed values: * &#x60;Subscription&#x60; – A transaction for a fixed or variable amount, which follows a fixed schedule. * &#x60;CardOnFile&#x60; – With a card-on-file (CoF) transaction, card details are stored to enable one-click or omnichannel journeys, or simply to streamline the checkout process. Any subscription not following a fixed schedule is also considered a card-on-file transaction. * &#x60;UnscheduledCardOnFile&#x60; – An unscheduled card-on-file (UCoF) transaction is a transaction that occurs on a non-fixed schedule and/or has variable amounts. For example, automatic top-ups when a cardholder&#x27;s balance drops below a certain amount.
     *
     * @return recurringProcessingModel
     **/
    public RecurringProcessingModelEnum getRecurringProcessingModel() {
        return recurringProcessingModel;
    }

    public void setRecurringProcessingModel(RecurringProcessingModelEnum recurringProcessingModel) {
        this.recurringProcessingModel = recurringProcessingModel;
    }

    public CreatePaymentLinkRequest reference(String reference) {
        this.reference = reference;
        return this;
    }

    /**
     * A reference that is used to uniquely identify the payment in future communications about the payment status.
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
     * Website URL used for redirection after payment is completed. If provided, a **Continue** button will be shown on the payment page. If shoppers select the button, they are redirected to the specified URL.
     *
     * @return returnUrl
     **/
    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public CreatePaymentLinkRequest reusable(Boolean reusable) {
        this.reusable = reusable;
        return this;
    }

    /**
     * Indicates whether the payment link can be reused for multiple payments. If not provided, this defaults to **false** which means the link can be used for one successful payment only.
     *
     * @return reusable
     **/
    public Boolean isReusable() {
        return reusable;
    }

    public void setReusable(Boolean reusable) {
        this.reusable = reusable;
    }

    public CreatePaymentLinkRequest riskData(RiskData riskData) {
        this.riskData = riskData;
        return this;
    }

    /**
     * Get riskData
     *
     * @return riskData
     **/
    public RiskData getRiskData() {
        return riskData;
    }

    public void setRiskData(RiskData riskData) {
        this.riskData = riskData;
    }

    public CreatePaymentLinkRequest shopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
        return this;
    }

    /**
     * The shopper&#x27;s email address.
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
     * The language to be used in the payment page, specified by a combination of a language and country code. For example, &#x60;en-US&#x60;.  For a list of shopper locales that Pay by Link supports, refer to [Language and localization](https://docs.adyen.com/checkout/pay-by-link#language-and-localization).
     *
     * @return shopperLocale
     **/
    public String getShopperLocale() {
        return shopperLocale;
    }

    public void setShopperLocale(String shopperLocale) {
        this.shopperLocale = shopperLocale;
    }

    public CreatePaymentLinkRequest shopperName(Name shopperName) {
        this.shopperName = shopperName;
        return this;
    }

    /**
     * Get shopperName
     *
     * @return shopperName
     **/
    public Name getShopperName() {
        return shopperName;
    }

    public void setShopperName(Name shopperName) {
        this.shopperName = shopperName;
    }

    public CreatePaymentLinkRequest shopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
        return this;
    }

    /**
     * A unique identifier for the shopper (for example, user ID or account ID).
     *
     * @return shopperReference
     **/
    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    public CreatePaymentLinkRequest splits(List<Split> splits) {
        this.splits = splits;
        return this;
    }

    public CreatePaymentLinkRequest addSplitsItem(Split splitsItem) {
        if (this.splits == null) {
            this.splits = new ArrayList<>();
        }
        this.splits.add(splitsItem);
        return this;
    }

    /**
     * Information on how the payment should be split between accounts when using [Adyen for Platforms](https://docs.adyen.com/platforms/processing-payments#providing-split-information).
     *
     * @return splits
     **/
    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public CreatePaymentLinkRequest store(String store) {
        this.store = store;
        return this;
    }

    /**
     * The physical store, for which this payment is processed.
     *
     * @return store
     **/
    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public CreatePaymentLinkRequest storePaymentMethod(Boolean storePaymentMethod) {
        this.storePaymentMethod = storePaymentMethod;
        return this;
    }

    /**
     * When this is set to **true** and the &#x60;shopperReference&#x60; is provided, the payment details will be stored.
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
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreatePaymentLinkRequest createPaymentLinkRequest = (CreatePaymentLinkRequest) o;
        return Objects.equals(this.allowedPaymentMethods, createPaymentLinkRequest.allowedPaymentMethods) &&
                Objects.equals(this.amount, createPaymentLinkRequest.amount) &&
                Objects.equals(this.applicationInfo, createPaymentLinkRequest.applicationInfo) &&
                Objects.equals(this.billingAddress, createPaymentLinkRequest.billingAddress) &&
                Objects.equals(this.blockedPaymentMethods, createPaymentLinkRequest.blockedPaymentMethods) &&
                Objects.equals(this.countryCode, createPaymentLinkRequest.countryCode) &&
                Objects.equals(this.deliverAt, createPaymentLinkRequest.deliverAt) &&
                Objects.equals(this.deliveryAddress, createPaymentLinkRequest.deliveryAddress) &&
                Objects.equals(this.description, createPaymentLinkRequest.description) &&
                Objects.equals(this.expiresAt, createPaymentLinkRequest.expiresAt) &&
                Objects.equals(this.lineItems, createPaymentLinkRequest.lineItems) &&
                Objects.equals(this.merchantAccount, createPaymentLinkRequest.merchantAccount) &&
                Objects.equals(this.merchantOrderReference, createPaymentLinkRequest.merchantOrderReference) &&
                Objects.equals(this.metadata, createPaymentLinkRequest.metadata) &&
                Objects.equals(this.recurringProcessingModel, createPaymentLinkRequest.recurringProcessingModel) &&
                Objects.equals(this.reference, createPaymentLinkRequest.reference) &&
                Objects.equals(this.returnUrl, createPaymentLinkRequest.returnUrl) &&
                Objects.equals(this.reusable, createPaymentLinkRequest.reusable) &&
                Objects.equals(this.riskData, createPaymentLinkRequest.riskData) &&
                Objects.equals(this.shopperEmail, createPaymentLinkRequest.shopperEmail) &&
                Objects.equals(this.shopperLocale, createPaymentLinkRequest.shopperLocale) &&
                Objects.equals(this.shopperName, createPaymentLinkRequest.shopperName) &&
                Objects.equals(this.shopperReference, createPaymentLinkRequest.shopperReference) &&
                Objects.equals(this.splits, createPaymentLinkRequest.splits) &&
                Objects.equals(this.store, createPaymentLinkRequest.store) &&
                Objects.equals(this.storePaymentMethod, createPaymentLinkRequest.storePaymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowedPaymentMethods, amount, applicationInfo, billingAddress, blockedPaymentMethods, countryCode, deliverAt, deliveryAddress, description, expiresAt, lineItems, merchantAccount, merchantOrderReference, metadata, recurringProcessingModel, reference, returnUrl, reusable, riskData, shopperEmail, shopperLocale, shopperName, shopperReference, splits, store, storePaymentMethod);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreatePaymentLinkRequest {\n");

        sb.append("    allowedPaymentMethods: ").append(toIndentedString(allowedPaymentMethods)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    applicationInfo: ").append(toIndentedString(applicationInfo)).append("\n");
        sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
        sb.append("    blockedPaymentMethods: ").append(toIndentedString(blockedPaymentMethods)).append("\n");
        sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
        sb.append("    deliverAt: ").append(toIndentedString(deliverAt)).append("\n");
        sb.append("    deliveryAddress: ").append(toIndentedString(deliveryAddress)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
        sb.append("    lineItems: ").append(toIndentedString(lineItems)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    merchantOrderReference: ").append(toIndentedString(merchantOrderReference)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    recurringProcessingModel: ").append(toIndentedString(recurringProcessingModel)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    returnUrl: ").append(toIndentedString(returnUrl)).append("\n");
        sb.append("    reusable: ").append(toIndentedString(reusable)).append("\n");
        sb.append("    riskData: ").append(toIndentedString(riskData)).append("\n");
        sb.append("    shopperEmail: ").append(toIndentedString(shopperEmail)).append("\n");
        sb.append("    shopperLocale: ").append(toIndentedString(shopperLocale)).append("\n");
        sb.append("    shopperName: ").append(toIndentedString(shopperName)).append("\n");
        sb.append("    shopperReference: ").append(toIndentedString(shopperReference)).append("\n");
        sb.append("    splits: ").append(toIndentedString(splits)).append("\n");
        sb.append("    store: ").append(toIndentedString(store)).append("\n");
        sb.append("    storePaymentMethod: ").append(toIndentedString(storePaymentMethod)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
