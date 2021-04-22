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
package com.adyen.model.checkout;

import com.adyen.model.Address;
import com.adyen.model.Amount;
import com.adyen.model.Name;
import com.adyen.model.Split;
import com.adyen.model.applicationinfo.ApplicationInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PaymentLinkResource
 */

public class PaymentLinkResource {
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
    private OffsetDateTime deliverAt = null;

    @SerializedName("deliveryAddress")
    private Address deliveryAddress = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("expiresAt")
    private String expiresAt = null;

    @SerializedName("id")
    private String id = null;

    @SerializedName("lineItems")
    private List<LineItem> lineItems = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("merchantOrderReference")
    private String merchantOrderReference = null;

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
                Object value = jsonReader.nextString();
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

    /**
     * Status of the payment link. Possible values: * **active**  * **expired** * **completed** (v66 and above)  * **paid** (v65 and below)
     */
    @JsonAdapter(StatusEnum.Adapter.class)
    public enum StatusEnum {
        ACTIVE("active"),
        COMPLETED("completed"),
        EXPIRED("expired"),
        PAYMENTPENDING("paymentPending");

        @JsonValue
        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static StatusEnum fromValue(String text) {
            for (StatusEnum b : StatusEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<StatusEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public StatusEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return StatusEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("status")
    private StatusEnum status = null;

    @SerializedName("store")
    private String store = null;

    @SerializedName("storePaymentMethod")
    private Boolean storePaymentMethod = null;

    @SerializedName("url")
    private String url = null;

    public PaymentLinkResource allowedPaymentMethods(List<String> allowedPaymentMethods) {
        this.allowedPaymentMethods = allowedPaymentMethods;
        return this;
    }

    public PaymentLinkResource addAllowedPaymentMethodsItem(String allowedPaymentMethodsItem) {
        if (this.allowedPaymentMethods == null) {
            this.allowedPaymentMethods = new ArrayList<>();
        }
        this.allowedPaymentMethods.add(allowedPaymentMethodsItem);
        return this;
    }

    /**
     * List of payment methods to be presented to the shopper. To refer to payment methods, use their &#x60;paymentMethod.type&#x60; from [Payment methods overview](https://docs.adyen.com/payment-methods).  Example: &#x60;\&quot;allowedPaymentMethods\&quot;:[\&quot;ideal\&quot;,\&quot;giropay\&quot;]&#x60;
     *
     * @return allowedPaymentMethods
     **/
    public List<String> getAllowedPaymentMethods() {
        return allowedPaymentMethods;
    }

    public void setAllowedPaymentMethods(List<String> allowedPaymentMethods) {
        this.allowedPaymentMethods = allowedPaymentMethods;
    }

    public PaymentLinkResource amount(Amount amount) {
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

    public PaymentLinkResource applicationInfo(ApplicationInfo applicationInfo) {
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

    public PaymentLinkResource billingAddress(Address billingAddress) {
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

    public PaymentLinkResource blockedPaymentMethods(List<String> blockedPaymentMethods) {
        this.blockedPaymentMethods = blockedPaymentMethods;
        return this;
    }

    public PaymentLinkResource addBlockedPaymentMethodsItem(String blockedPaymentMethodsItem) {
        if (this.blockedPaymentMethods == null) {
            this.blockedPaymentMethods = new ArrayList<>();
        }
        this.blockedPaymentMethods.add(blockedPaymentMethodsItem);
        return this;
    }

    /**
     * List of payment methods to be hidden from the shopper. To refer to payment methods, use their &#x60;paymentMethod.type&#x60; from [Payment methods overview](https://docs.adyen.com/payment-methods).  Example: &#x60;\&quot;blockedPaymentMethods\&quot;:[\&quot;ideal\&quot;,\&quot;giropay\&quot;]&#x60;
     *
     * @return blockedPaymentMethods
     **/
    public List<String> getBlockedPaymentMethods() {
        return blockedPaymentMethods;
    }

    public void setBlockedPaymentMethods(List<String> blockedPaymentMethods) {
        this.blockedPaymentMethods = blockedPaymentMethods;
    }

    public PaymentLinkResource countryCode(String countryCode) {
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

    public PaymentLinkResource deliverAt(OffsetDateTime deliverAt) {
        this.deliverAt = deliverAt;
        return this;
    }

    /**
     * The date and time the purchased goods should be delivered. In ISO 8601 format. For example &#x60;2019-11-23T12:25:28Z&#x60;, or &#x60;2020-05-27T20:25:28+08:00&#x60;.
     *
     * @return deliverAt
     **/
    public OffsetDateTime getDeliverAt() {
        return deliverAt;
    }

    public void setDeliverAt(OffsetDateTime deliverAt) {
        this.deliverAt = deliverAt;
    }

    public PaymentLinkResource deliveryAddress(Address deliveryAddress) {
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

    public PaymentLinkResource description(String description) {
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

    public PaymentLinkResource expiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
        return this;
    }

    /**
     * The date that the payment link expires, in ISO 8601 format. For example &#x60;2019-11-23T12:25:28Z&#x60;, or &#x60;2020-05-27T20:25:28+08:00&#x60;. Maximum expiry date should be 70 days from when the payment link is created. If not provided, the default expiry is set to 24 hours after the payment link is created.
     *
     * @return expiresAt
     **/
    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    /**
     * A unique identifier of the payment link.
     *
     * @return id
     **/
    public String getId() {
        return id;
    }

    public PaymentLinkResource lineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
        return this;
    }

    public PaymentLinkResource addLineItemsItem(LineItem lineItemsItem) {
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

    public PaymentLinkResource merchantAccount(String merchantAccount) {
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

    public PaymentLinkResource merchantOrderReference(String merchantOrderReference) {
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

    public PaymentLinkResource recurringProcessingModel(RecurringProcessingModelEnum recurringProcessingModel) {
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

    public PaymentLinkResource reference(String reference) {
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

    public PaymentLinkResource returnUrl(String returnUrl) {
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

    public PaymentLinkResource reusable(Boolean reusable) {
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

    public PaymentLinkResource riskData(RiskData riskData) {
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

    public PaymentLinkResource shopperEmail(String shopperEmail) {
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

    public PaymentLinkResource shopperLocale(String shopperLocale) {
        this.shopperLocale = shopperLocale;
        return this;
    }

    /**
     * The language to be used in the payment page, specified by a combination of a language and country code. For example, &#x60;en-US&#x60;.  For a list of shopper locales that Pay by Link supports, refer to [Language and localization](https://docs.adyen.com/online-payments/pay-by-link#language-and-localization).
     *
     * @return shopperLocale
     **/
    public String getShopperLocale() {
        return shopperLocale;
    }

    public void setShopperLocale(String shopperLocale) {
        this.shopperLocale = shopperLocale;
    }

    public PaymentLinkResource shopperName(Name shopperName) {
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

    public PaymentLinkResource shopperReference(String shopperReference) {
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

    public PaymentLinkResource splits(List<Split> splits) {
        this.splits = splits;
        return this;
    }

    public PaymentLinkResource addSplitsItem(Split splitsItem) {
        if (this.splits == null) {
            this.splits = new ArrayList<>();
        }
        this.splits.add(splitsItem);
        return this;
    }

    /**
     * An array of objects specifying how the payment should be split between accounts when using Adyen for Platforms. For details, refer to [Providing split information](https://docs.adyen.com/platforms/processing-payments#providing-split-information).
     *
     * @return splits
     **/
    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public PaymentLinkResource status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * Status of the payment link. Possible values: * **active**  * **expired** * **completed** (v66 and above)  * **paid** (v65 and below)
     *
     * @return status
     **/
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public PaymentLinkResource store(String store) {
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

    public PaymentLinkResource storePaymentMethod(Boolean storePaymentMethod) {
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

    /**
     * The URL at which the shopper can complete the payment.
     *
     * @return url
     **/
    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentLinkResource paymentLinkResource = (PaymentLinkResource) o;
        return Objects.equals(this.allowedPaymentMethods, paymentLinkResource.allowedPaymentMethods) &&
                Objects.equals(this.amount, paymentLinkResource.amount) &&
                Objects.equals(this.applicationInfo, paymentLinkResource.applicationInfo) &&
                Objects.equals(this.billingAddress, paymentLinkResource.billingAddress) &&
                Objects.equals(this.blockedPaymentMethods, paymentLinkResource.blockedPaymentMethods) &&
                Objects.equals(this.countryCode, paymentLinkResource.countryCode) &&
                Objects.equals(this.deliverAt, paymentLinkResource.deliverAt) &&
                Objects.equals(this.deliveryAddress, paymentLinkResource.deliveryAddress) &&
                Objects.equals(this.description, paymentLinkResource.description) &&
                Objects.equals(this.expiresAt, paymentLinkResource.expiresAt) &&
                Objects.equals(this.id, paymentLinkResource.id) &&
                Objects.equals(this.lineItems, paymentLinkResource.lineItems) &&
                Objects.equals(this.merchantAccount, paymentLinkResource.merchantAccount) &&
                Objects.equals(this.merchantOrderReference, paymentLinkResource.merchantOrderReference) &&
                Objects.equals(this.recurringProcessingModel, paymentLinkResource.recurringProcessingModel) &&
                Objects.equals(this.reference, paymentLinkResource.reference) &&
                Objects.equals(this.returnUrl, paymentLinkResource.returnUrl) &&
                Objects.equals(this.reusable, paymentLinkResource.reusable) &&
                Objects.equals(this.riskData, paymentLinkResource.riskData) &&
                Objects.equals(this.shopperEmail, paymentLinkResource.shopperEmail) &&
                Objects.equals(this.shopperLocale, paymentLinkResource.shopperLocale) &&
                Objects.equals(this.shopperName, paymentLinkResource.shopperName) &&
                Objects.equals(this.shopperReference, paymentLinkResource.shopperReference) &&
                Objects.equals(this.splits, paymentLinkResource.splits) &&
                Objects.equals(this.status, paymentLinkResource.status) &&
                Objects.equals(this.store, paymentLinkResource.store) &&
                Objects.equals(this.storePaymentMethod, paymentLinkResource.storePaymentMethod) &&
                Objects.equals(this.url, paymentLinkResource.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowedPaymentMethods, amount, applicationInfo, billingAddress, blockedPaymentMethods, countryCode, deliverAt, deliveryAddress, description, expiresAt, id, lineItems, merchantAccount, merchantOrderReference, recurringProcessingModel, reference, returnUrl, reusable, riskData, shopperEmail, shopperLocale, shopperName, shopperReference, splits, status, store, storePaymentMethod, url);
    }

    @Override
    public String toString() {
        return "class PaymentLinkResource {\n" +
                "    allowedPaymentMethods: " + toIndentedString(allowedPaymentMethods) + "\n" +
                "    amount: " + toIndentedString(amount) + "\n" +
                "    applicationInfo: " + toIndentedString(applicationInfo) + "\n" +
                "    billingAddress: " + toIndentedString(billingAddress) + "\n" +
                "    blockedPaymentMethods: " + toIndentedString(blockedPaymentMethods) + "\n" +
                "    countryCode: " + toIndentedString(countryCode) + "\n" +
                "    deliverAt: " + toIndentedString(deliverAt) + "\n" +
                "    deliveryAddress: " + toIndentedString(deliveryAddress) + "\n" +
                "    description: " + toIndentedString(description) + "\n" +
                "    expiresAt: " + toIndentedString(expiresAt) + "\n" +
                "    id: " + toIndentedString(id) + "\n" +
                "    lineItems: " + toIndentedString(lineItems) + "\n" +
                "    merchantAccount: " + toIndentedString(merchantAccount) + "\n" +
                "    merchantOrderReference: " + toIndentedString(merchantOrderReference) + "\n" +
                "    recurringProcessingModel: " + toIndentedString(recurringProcessingModel) + "\n" +
                "    reference: " + toIndentedString(reference) + "\n" +
                "    returnUrl: " + toIndentedString(returnUrl) + "\n" +
                "    reusable: " + toIndentedString(reusable) + "\n" +
                "    riskData: " + toIndentedString(riskData) + "\n" +
                "    shopperEmail: " + toIndentedString(shopperEmail) + "\n" +
                "    shopperLocale: " + toIndentedString(shopperLocale) + "\n" +
                "    shopperName: " + toIndentedString(shopperName) + "\n" +
                "    shopperReference: " + toIndentedString(shopperReference) + "\n" +
                "    splits: " + toIndentedString(splits) + "\n" +
                "    status: " + toIndentedString(status) + "\n" +
                "    store: " + toIndentedString(store) + "\n" +
                "    storePaymentMethod: " + toIndentedString(storePaymentMethod) + "\n" +
                "    url: " + toIndentedString(url) + "\n" +
                "}";
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
