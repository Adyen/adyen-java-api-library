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

import java.util.Date;
import java.util.Objects;

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
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @SerializedName("captureDelayHours")
    private Integer captureDelayHours = null;

    @SerializedName("countryCode")
    private String countryCode = null;

    @SerializedName("dateOfBirth")
    private Date dateOfBirth = null;

    @SerializedName("deliverAt")
    @JsonAdapter(DateSerializer.class)
    private Date deliverAt = null;

    @SerializedName("deliveryAddress")
    private Address deliveryAddress = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("expiresAt")
    private String expiresAt = null;

    @SerializedName("installmentOptions")
    private Map<String, InstallmentOption> installmentOptions = null;

    @SerializedName("lineItems")
    private List<LineItem> lineItems = null;

    @SerializedName("mcc")
    private String mcc = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("merchantOrderReference")
    private String merchantOrderReference = null;

    @SerializedName("metadata")
    private Map<String, String> metadata = null;

    /**
     * Defines a recurring payment type. Possible values: * **Subscription** – A transaction for a fixed or variable amount, which follows a fixed schedule. * **CardOnFile** – With a card-on-file (CoF) transaction, card details are stored to enable one-click or omnichannel journeys, or simply to streamline the checkout process. Any subscription not following a fixed schedule is also considered a card-on-file transaction. * **UnscheduledCardOnFile** – An unscheduled card-on-file (UCoF) transaction is a transaction that occurs on a non-fixed schedule and/or has variable amounts. For example, automatic top-ups when a cardholder&#x27;s balance drops below a certain amount.
     */
    @JsonAdapter(RecurringProcessingModelEnum.Adapter.class)
    public enum RecurringProcessingModelEnum {
        CARDONFILE("CardOnFile"),
        SUBSCRIPTION("Subscription"),
        UNSCHEDULEDCARDONFILE("UnscheduledCardOnFile");

        @JsonValue
        private final String value;

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

    /**
     * Gets or Sets requiredShopperFields
     */
    @JsonAdapter(RequiredShopperFieldsEnum.Adapter.class)
    public enum RequiredShopperFieldsEnum {
        BILLINGADDRESS("billingAddress"),
        DELIVERYADDRESS("deliveryAddress"),
        SHOPPEREMAIL("shopperEmail"),
        SHOPPERNAME("shopperName"),
        TELEPHONENUMBER("telephoneNumber");

        @JsonValue
        private final String value;

        RequiredShopperFieldsEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static RequiredShopperFieldsEnum fromValue(String text) {
            for (RequiredShopperFieldsEnum b : RequiredShopperFieldsEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<RequiredShopperFieldsEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final RequiredShopperFieldsEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public RequiredShopperFieldsEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return RequiredShopperFieldsEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("requiredShopperFields")
    private List<RequiredShopperFieldsEnum> requiredShopperFields = null;

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

    /**
     * Indicates if the details of the payment method will be stored for the shopper. Possible values:* **disabled** – No details will be stored.* **askForConsent** – If the &#x60;shopperReference&#x60; is provided the shopper can decide whether or not the details will be stored.* **enabled** – If the &#x60;shopperReference&#x60; is provided the details will be stored without asking consent to the shopper.
     */
    @JsonAdapter(StorePaymentMethodModeEnum.Adapter.class)
    public enum StorePaymentMethodModeEnum {
        ASKFORCONSENT("askForConsent"),
        DISABLED("disabled"),
        ENABLED("enabled");

        @JsonValue
        private final String value;

        StorePaymentMethodModeEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static StorePaymentMethodModeEnum fromValue(String value) {
            for (StorePaymentMethodModeEnum b : StorePaymentMethodModeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<StorePaymentMethodModeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final StorePaymentMethodModeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public StorePaymentMethodModeEnum read(final JsonReader jsonReader) throws IOException {
                String value =  jsonReader.nextString();
                return StorePaymentMethodModeEnum.fromValue(value);
            }
        }
    }

    @SerializedName("storePaymentMethodMode")
    private StorePaymentMethodModeEnum storePaymentMethodMode;

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
     * List of payment methods to be presented to the shopper. To refer to payment methods, use their &#x60;paymentMethod.type&#x60; from [Payment methods overview](https://docs.adyen.com/payment-methods).  Example: &#x60;\&quot;allowedPaymentMethods\&quot;:[\&quot;ideal\&quot;,\&quot;giropay\&quot;]&#x60;
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
     * List of payment methods to be hidden from the shopper. To refer to payment methods, use their &#x60;paymentMethod.type&#x60; from [Payment methods overview](https://docs.adyen.com/payment-methods).  Example: &#x60;\&quot;blockedPaymentMethods\&quot;:[\&quot;ideal\&quot;,\&quot;giropay\&quot;]&#x60;
     * @return blockedPaymentMethods
     **/
    public List<String> getBlockedPaymentMethods() {
        return blockedPaymentMethods;
    }

    public void setBlockedPaymentMethods(List<String> blockedPaymentMethods) {
        this.blockedPaymentMethods = blockedPaymentMethods;
    }

    public CreatePaymentLinkRequest captureDelayHours(Integer captureDelayHours) {
        this.captureDelayHours = captureDelayHours;
        return this;
    }

    /**
     * The delay between the authorisation and scheduled auto-capture, specified in hours.
     * @return captureDelayHours
     **/
    @Schema(description = "The delay between the authorisation and scheduled auto-capture, specified in hours.")
    public Integer getCaptureDelayHours() {
        return captureDelayHours;
    }

    public void setCaptureDelayHours(Integer captureDelayHours) {
        this.captureDelayHours = captureDelayHours;
    }


    public CreatePaymentLinkRequest countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    /**
     * The shopper&#x27;s two-letter country code.
     * @return countryCode
     **/
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public CreatePaymentLinkRequest dateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    /**
     * The shopper&#x27;s date of birth.  Format [ISO-8601](https://www.w3.org/TR/NOTE-datetime): YYYY-MM-DD
     * @return dateOfBirth
     **/
    @Schema(description = "The shopper's date of birth.  Format [ISO-8601](https://www.w3.org/TR/NOTE-datetime): YYYY-MM-DD")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public CreatePaymentLinkRequest deliverAt(Date deliverAt) {
        this.deliverAt = deliverAt;
        return this;
    }

    /**
     * The date and time the purchased goods should be delivered.
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
     * The date that the payment link expires, in ISO 8601 format. For example &#x60;2019-11-23T12:25:28Z&#x60;, or &#x60;2020-05-27T20:25:28+08:00&#x60;. Maximum expiry date should be 70 days from when the payment link is created. If not provided, the default expiry is set to 24 hours after the payment link is created.
     * @return expiresAt
     **/
    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public CreatePaymentLinkRequest installmentOptions(Map<String, InstallmentOption> installmentOptions) {
        this.installmentOptions = installmentOptions;
        return this;
    }

    public CreatePaymentLinkRequest putInstallmentOptionsItem(String key, InstallmentOption installmentOptionsItem) {
        if (this.installmentOptions == null) {
            this.installmentOptions = new HashMap<>();
        }
        this.installmentOptions.put(key, installmentOptionsItem);
        return this;
    }

    /**
     * A set of key-value pairs that specifies the installment options available per payment method. The key must be a payment method name in lowercase. For example, **card** to specify installment options for all cards, or **visa** or **mc**. The value must be an object containing the installment options.
     * @return installmentOptions
     **/
    public Map<String, InstallmentOption> getInstallmentOptions() {
        return installmentOptions;
    }

    public void setInstallmentOptions(Map<String, InstallmentOption> installmentOptions) {
        this.installmentOptions = installmentOptions;
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
     * @return lineItems
     **/
    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public CreatePaymentLinkRequest mcc(String mcc) {
        this.mcc = mcc;
        return this;
    }

    /**
     * The [merchant category code](https://en.wikipedia.org/wiki/Merchant_category_code) (MCC) is a four-digit number, which relates to a particular market segment. This code reflects the predominant activity that is conducted by the merchant.
     * @return mcc
     **/
    @Schema(description = "The [merchant category code](https://en.wikipedia.org/wiki/Merchant_category_code) (MCC) is a four-digit number, which relates to a particular market segment. This code reflects the predominant activity that is conducted by the merchant.")
    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public CreatePaymentLinkRequest merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    /**
     * The merchant account identifier for which the payment link is created.
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
     * Metadata consists of entries, each of which includes a key and a value. Limitations: * Maximum 20 key-value pairs per request. Otherwise, error \&quot;177\&quot; occurs: \&quot;Metadata size exceeds limit\&quot; * Maximum 20 characters per key. Otherwise, error \&quot;178\&quot; occurs: \&quot;Metadata key size exceeds limit\&quot; * A key cannot have the name &#x60;checkout.linkId&#x60;. Any value that you provide with this key is going to be replaced by the real payment link ID.
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
     * Defines a recurring payment type. Possible values: * **Subscription** – A transaction for a fixed or variable amount, which follows a fixed schedule. * **CardOnFile** – With a card-on-file (CoF) transaction, card details are stored to enable one-click or omnichannel journeys, or simply to streamline the checkout process. Any subscription not following a fixed schedule is also considered a card-on-file transaction. * **UnscheduledCardOnFile** – An unscheduled card-on-file (UCoF) transaction is a transaction that occurs on a non-fixed schedule and/or has variable amounts. For example, automatic top-ups when a cardholder&#x27;s balance drops below a certain amount.
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
     * @return reference
     **/
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public CreatePaymentLinkRequest requiredShopperFields(List<RequiredShopperFieldsEnum> requiredShopperFields) {
        this.requiredShopperFields = requiredShopperFields;
        return this;
    }

    public CreatePaymentLinkRequest addRequiredShopperFieldsItem(RequiredShopperFieldsEnum requiredShopperFieldsItem) {
        if (this.requiredShopperFields == null) {
            this.requiredShopperFields = new ArrayList<>();
        }
        this.requiredShopperFields.add(requiredShopperFieldsItem);
        return this;
    }

    /**
     * List of fields that the shopper has to provide on the payment page before completing the payment. For more information, refer to [Provide shopper information](https://docs.adyen.com/online-payments/pay-by-link/api#shopper-information).  Possible values: * **billingAddress** – The address where to send the invoice. * **deliveryAddress** – The address where the purchased goods should be delivered. * **shopperEmail** – The shopper&#x27;s email address. * **shopperName** – The shopper&#x27;s full name. * **telephoneNumber** – The shopper&#x27;s phone number.
     * @return requiredShopperFields
     **/
    public List<RequiredShopperFieldsEnum> getRequiredShopperFields() {
        return requiredShopperFields;
    }

    public void setRequiredShopperFields(List<RequiredShopperFieldsEnum> requiredShopperFields) {
        this.requiredShopperFields = requiredShopperFields;
    }

    public CreatePaymentLinkRequest returnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
        return this;
    }

    /**
     * Website URL used for redirection after payment is completed. If provided, a **Continue** button will be shown on the payment page. If shoppers select the button, they are redirected to the specified URL.
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
     * The language to be used in the payment page, specified by a combination of a language and country code. For example, &#x60;en-US&#x60;.  For a list of shopper locales that Pay by Link supports, refer to [Language and localization](https://docs.adyen.com/online-payments/pay-by-link#language-and-localization).
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
     * Your reference to uniquely identify this shopper (for example, user ID or account ID). Minimum length: 3 characters.
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
     * An array of objects specifying how the payment should be split between accounts when using Adyen for Platforms. For details, refer to [Providing split information](https://docs.adyen.com/platforms/processing-payments#providing-split-information).
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
     * @return storePaymentMethod
     **/
    public Boolean isStorePaymentMethod() {
        return storePaymentMethod;
    }

    public void setStorePaymentMethod(Boolean storePaymentMethod) {
        this.storePaymentMethod = storePaymentMethod;
    }

    public CreatePaymentLinkRequest storePaymentMethodMode(StorePaymentMethodModeEnum storePaymentMethodMode) {

        this.storePaymentMethodMode = storePaymentMethodMode;
        return this;
    }

    /**
     * Indicates if the details of the payment method will be stored for the shopper. Possible values:* **disabled** – No details will be stored.* **askForConsent** – If the &#x60;shopperReference&#x60; is provided the shopper can decide whether or not the details will be stored.* **enabled** – If the &#x60;shopperReference&#x60; is provided the details will be stored without asking consent to the shopper.
     * @return storePaymentMethodMode
     **/
    public StorePaymentMethodModeEnum getStorePaymentMethodMode() {
        return storePaymentMethodMode;
    }


    public void setStorePaymentMethodMode(StorePaymentMethodModeEnum storePaymentMethodMode) {
        this.storePaymentMethodMode = storePaymentMethodMode;
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
                Objects.equals(this.captureDelayHours, createPaymentLinkRequest.captureDelayHours) &&
                Objects.equals(this.countryCode, createPaymentLinkRequest.countryCode) &&
                Objects.equals(this.dateOfBirth, createPaymentLinkRequest.dateOfBirth) &&
                Objects.equals(this.deliverAt, createPaymentLinkRequest.deliverAt) &&
                Objects.equals(this.deliveryAddress, createPaymentLinkRequest.deliveryAddress) &&
                Objects.equals(this.description, createPaymentLinkRequest.description) &&
                Objects.equals(this.expiresAt, createPaymentLinkRequest.expiresAt) &&
                Objects.equals(this.installmentOptions, createPaymentLinkRequest.installmentOptions) &&
                Objects.equals(this.lineItems, createPaymentLinkRequest.lineItems) &&
                Objects.equals(this.mcc, createPaymentLinkRequest.mcc) &&
                Objects.equals(this.merchantAccount, createPaymentLinkRequest.merchantAccount) &&
                Objects.equals(this.merchantOrderReference, createPaymentLinkRequest.merchantOrderReference) &&
                Objects.equals(this.metadata, createPaymentLinkRequest.metadata) &&
                Objects.equals(this.recurringProcessingModel, createPaymentLinkRequest.recurringProcessingModel) &&
                Objects.equals(this.reference, createPaymentLinkRequest.reference) &&
                Objects.equals(this.requiredShopperFields, createPaymentLinkRequest.requiredShopperFields) &&
                Objects.equals(this.returnUrl, createPaymentLinkRequest.returnUrl) &&
                Objects.equals(this.reusable, createPaymentLinkRequest.reusable) &&
                Objects.equals(this.riskData, createPaymentLinkRequest.riskData) &&
                Objects.equals(this.shopperEmail, createPaymentLinkRequest.shopperEmail) &&
                Objects.equals(this.shopperLocale, createPaymentLinkRequest.shopperLocale) &&
                Objects.equals(this.shopperName, createPaymentLinkRequest.shopperName) &&
                Objects.equals(this.shopperReference, createPaymentLinkRequest.shopperReference) &&
                Objects.equals(this.splits, createPaymentLinkRequest.splits) &&
                Objects.equals(this.store, createPaymentLinkRequest.store) &&
                Objects.equals(this.storePaymentMethod, createPaymentLinkRequest.storePaymentMethod) &&
                Objects.equals(this.storePaymentMethodMode, createPaymentLinkRequest.storePaymentMethodMode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowedPaymentMethods, amount, applicationInfo, billingAddress, blockedPaymentMethods, countryCode, captureDelayHours, dateOfBirth, deliverAt, deliveryAddress, description, expiresAt, installmentOptions, lineItems, mcc, merchantAccount, merchantOrderReference, metadata, recurringProcessingModel, reference, requiredShopperFields, returnUrl, reusable, riskData, shopperEmail, shopperLocale, shopperName, shopperReference, splits, store, storePaymentMethod, storePaymentMethodMode);
    }


    @Override
    public String toString() {

        return "class CreatePaymentLinkRequest {\n" +
                "    allowedPaymentMethods: " + toIndentedString(allowedPaymentMethods) + "\n" +
                "    amount: " + toIndentedString(amount) + "\n" +
                "    applicationInfo: " + toIndentedString(applicationInfo) + "\n" +
                "    billingAddress: " + toIndentedString(billingAddress) + "\n" +
                "    blockedPaymentMethods: " + toIndentedString(blockedPaymentMethods) + "\n" +
                "    captureDelayHours: " + toIndentedString(captureDelayHours) + "\n" +
                "    countryCode: " + toIndentedString(countryCode) + "\n" +
                "    deliverAt: " + toIndentedString(deliverAt) + "\n" +
                "    dateOfBirth: " + toIndentedString(dateOfBirth) + "\n" +
                "    deliveryAddress: " + toIndentedString(deliveryAddress) + "\n" +
                "    description: " + toIndentedString(description) + "\n" +
                "    expiresAt: " + toIndentedString(expiresAt) + "\n" +
                "    installmentOptions: " + toIndentedString(installmentOptions) + "\n" +
                "    lineItems: " + toIndentedString(lineItems) + "\n" +
                "    mcc: " + toIndentedString(mcc) + "\n" +
                "    merchantAccount: " + toIndentedString(merchantAccount) + "\n" +
                "    merchantOrderReference: " + toIndentedString(merchantOrderReference) + "\n" +
                "    metadata: " + toIndentedString(metadata) + "\n" +
                "    recurringProcessingModel: " + toIndentedString(recurringProcessingModel) + "\n" +
                "    reference: " + toIndentedString(reference) + "\n" +
                "    requiredShopperFields: " + toIndentedString(requiredShopperFields) + "\n" +
                "    returnUrl: " + toIndentedString(returnUrl) + "\n" +
                "    reusable: " + toIndentedString(reusable) + "\n" +
                "    riskData: " + toIndentedString(riskData) + "\n" +
                "    shopperEmail: " + toIndentedString(shopperEmail) + "\n" +
                "    shopperLocale: " + toIndentedString(shopperLocale) + "\n" +
                "    shopperName: " + toIndentedString(shopperName) + "\n" +
                "    shopperReference: " + toIndentedString(shopperReference) + "\n" +
                "    splits: " + toIndentedString(splits) + "\n" +
                "    store: " + toIndentedString(store) + "\n" +
                "    storePaymentMethod: " + toIndentedString(storePaymentMethod) + "\n" +
                "    storePaymentMethodMode: " + toIndentedString(storePaymentMethodMode) + "\n" +
        "}";
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
