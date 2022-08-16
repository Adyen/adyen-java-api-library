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
        public static RecurringProcessingModelEnum fromValue(String input) {
            for (RecurringProcessingModelEnum b : RecurringProcessingModelEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<RecurringProcessingModelEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final RecurringProcessingModelEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public RecurringProcessingModelEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return RecurringProcessingModelEnum.fromValue((String)(value));
            }
        }
    }  @SerializedName("recurringProcessingModel")
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
        public static RequiredShopperFieldsEnum fromValue(String input) {
            for (RequiredShopperFieldsEnum b : RequiredShopperFieldsEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<RequiredShopperFieldsEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final RequiredShopperFieldsEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public RequiredShopperFieldsEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return RequiredShopperFieldsEnum.fromValue(value);
            }
        }
    }  @SerializedName("requiredShopperFields")
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

    @SerializedName("shopperStatement")
    private String shopperStatement = null;

    @SerializedName("socialSecurityNumber")
    private String socialSecurityNumber = null;

    @SerializedName("splitCardFundingSources")
    private Boolean splitCardFundingSources = false;

    @SerializedName("splits")
    private List<Split> splits = null;

    @SerializedName("store")
    private String store = null;

    /**
     * Indicates if the details of the payment method will be stored for the shopper. Possible values: * **disabled** – No details will be stored (default). * **askForConsent** – If the &#x60;shopperReference&#x60; is provided, the UI lets the shopper choose if they want their payment details to be stored. * **enabled** – If the &#x60;shopperReference&#x60; is provided, the details will be stored without asking the shopper for consent.
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
        public static StorePaymentMethodModeEnum fromValue(String input) {
            for (StorePaymentMethodModeEnum b : StorePaymentMethodModeEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<StorePaymentMethodModeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final StorePaymentMethodModeEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public StorePaymentMethodModeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return StorePaymentMethodModeEnum.fromValue(value);
            }
        }
    }  @SerializedName("storePaymentMethodMode")
    private StorePaymentMethodModeEnum storePaymentMethodMode = null;

    @SerializedName("telephoneNumber")
    private String telephoneNumber = null;

    @SerializedName("themeId")
    private String themeId = null;

    public CreatePaymentLinkRequest allowedPaymentMethods(List<String> allowedPaymentMethods) {
        this.allowedPaymentMethods = allowedPaymentMethods;
        return this;
    }

    public CreatePaymentLinkRequest addAllowedPaymentMethodsItem(String allowedPaymentMethodsItem) {
        if (this.allowedPaymentMethods == null) {
            this.allowedPaymentMethods = new ArrayList<String>();
        }
        this.allowedPaymentMethods.add(allowedPaymentMethodsItem);
        return this;
    }

    /**
     * List of payment methods to be presented to the shopper. To refer to payment methods, use their &#x60;paymentMethod.type&#x60; from [Payment methods overview](https://docs.adyen.com/payment-methods).  Example: &#x60;\&quot;allowedPaymentMethods\&quot;:[\&quot;ideal\&quot;,\&quot;giropay\&quot;]&#x60;
     * @return allowedPaymentMethods
     **/
    @Schema(description = "List of payment methods to be presented to the shopper. To refer to payment methods, use their `paymentMethod.type` from [Payment methods overview](https://docs.adyen.com/payment-methods).  Example: `\"allowedPaymentMethods\":[\"ideal\",\"giropay\"]`")
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
    @Schema(required = true, description = "")
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
    @Schema(description = "")
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
    @Schema(description = "")
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
            this.blockedPaymentMethods = new ArrayList<String>();
        }
        this.blockedPaymentMethods.add(blockedPaymentMethodsItem);
        return this;
    }

    /**
     * List of payment methods to be hidden from the shopper. To refer to payment methods, use their &#x60;paymentMethod.type&#x60; from [Payment methods overview](https://docs.adyen.com/payment-methods).  Example: &#x60;\&quot;blockedPaymentMethods\&quot;:[\&quot;ideal\&quot;,\&quot;giropay\&quot;]&#x60;
     * @return blockedPaymentMethods
     **/
    @Schema(description = "List of payment methods to be hidden from the shopper. To refer to payment methods, use their `paymentMethod.type` from [Payment methods overview](https://docs.adyen.com/payment-methods).  Example: `\"blockedPaymentMethods\":[\"ideal\",\"giropay\"]`")
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
    @Schema(description = "The shopper's two-letter country code.")
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
     * The date and time when the purchased goods should be delivered.  [ISO 8601](https://www.w3.org/TR/NOTE-datetime) format: YYYY-MM-DDThh:mm:ss+TZD, for example, **2020-12-18T10:15:30+01:00**.
     * @return deliverAt
     **/
    @Schema(description = "The date and time when the purchased goods should be delivered.  [ISO 8601](https://www.w3.org/TR/NOTE-datetime) format: YYYY-MM-DDThh:mm:ss+TZD, for example, **2020-12-18T10:15:30+01:00**.")
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
    @Schema(description = "")
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
    @Schema(description = "A short description visible on the payment page. Maximum length: 280 characters.")
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
     * The date when the payment link expires.  [ISO 8601](https://www.w3.org/TR/NOTE-datetime) format: YYYY-MM-DDThh:mm:ss+TZD, for example, **2020-12-18T10:15:30+01:00**.  The maximum expiry date is 70 days after the payment link is created.  If not provided, the payment link expires 24 hours after it was created.
     * @return expiresAt
     **/
    @Schema(description = "The date when the payment link expires.  [ISO 8601](https://www.w3.org/TR/NOTE-datetime) format: YYYY-MM-DDThh:mm:ss+TZD, for example, **2020-12-18T10:15:30+01:00**.  The maximum expiry date is 70 days after the payment link is created.  If not provided, the payment link expires 24 hours after it was created.")
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
            this.installmentOptions = new HashMap<String, InstallmentOption>();
        }
        this.installmentOptions.put(key, installmentOptionsItem);
        return this;
    }

    /**
     * A set of key-value pairs that specifies the installment options available per payment method. The key must be a payment method name in lowercase. For example, **card** to specify installment options for all cards, or **visa** or **mc**. The value must be an object containing the installment options.
     * @return installmentOptions
     **/
    @Schema(description = "A set of key-value pairs that specifies the installment options available per payment method. The key must be a payment method name in lowercase. For example, **card** to specify installment options for all cards, or **visa** or **mc**. The value must be an object containing the installment options.")
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
            this.lineItems = new ArrayList<LineItem>();
        }
        this.lineItems.add(lineItemsItem);
        return this;
    }

    /**
     * Price and product information about the purchased items, to be included on the invoice sent to the shopper. This parameter is required for open invoice (_buy now, pay later_) payment methods such Afterpay, Clearpay, Klarna, RatePay, and Zip.
     * @return lineItems
     **/
    @Schema(description = "Price and product information about the purchased items, to be included on the invoice sent to the shopper. This parameter is required for open invoice (_buy now, pay later_) payment methods such Afterpay, Clearpay, Klarna, RatePay, and Zip.")
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
    @Schema(required = true, description = "The merchant account identifier for which the payment link is created.")
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
    @Schema(description = "This reference allows linking multiple transactions to each other for reporting purposes (for example, order auth-rate). The reference should be unique per billing cycle.")
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
            this.metadata = new HashMap<String, String>();
        }
        this.metadata.put(key, metadataItem);
        return this;
    }

    /**
     * Metadata consists of entries, each of which includes a key and a value. Limitations: * Maximum 20 key-value pairs per request. Otherwise, error \&quot;177\&quot; occurs: \&quot;Metadata size exceeds limit\&quot; * Maximum 20 characters per key. Otherwise, error \&quot;178\&quot; occurs: \&quot;Metadata key size exceeds limit\&quot; * A key cannot have the name &#x60;checkout.linkId&#x60;. Any value that you provide with this key is going to be replaced by the real payment link ID.
     * @return metadata
     **/
    @Schema(description = "Metadata consists of entries, each of which includes a key and a value. Limitations: * Maximum 20 key-value pairs per request. Otherwise, error \"177\" occurs: \"Metadata size exceeds limit\" * Maximum 20 characters per key. Otherwise, error \"178\" occurs: \"Metadata key size exceeds limit\" * A key cannot have the name `checkout.linkId`. Any value that you provide with this key is going to be replaced by the real payment link ID.")
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
    @Schema(description = "Defines a recurring payment type. Possible values: * **Subscription** – A transaction for a fixed or variable amount, which follows a fixed schedule. * **CardOnFile** – With a card-on-file (CoF) transaction, card details are stored to enable one-click or omnichannel journeys, or simply to streamline the checkout process. Any subscription not following a fixed schedule is also considered a card-on-file transaction. * **UnscheduledCardOnFile** – An unscheduled card-on-file (UCoF) transaction is a transaction that occurs on a non-fixed schedule and/or has variable amounts. For example, automatic top-ups when a cardholder's balance drops below a certain amount. ")
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
    @Schema(required = true, description = "A reference that is used to uniquely identify the payment in future communications about the payment status.")
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
            this.requiredShopperFields = new ArrayList<RequiredShopperFieldsEnum>();
        }
        this.requiredShopperFields.add(requiredShopperFieldsItem);
        return this;
    }

    /**
     * List of fields that the shopper has to provide on the payment page before completing the payment. For more information, refer to [Provide shopper information](https://docs.adyen.com/unified-commerce/pay-by-link/payment-links/api#shopper-information).  Possible values: * **billingAddress** – The address where to send the invoice. * **deliveryAddress** – The address where the purchased goods should be delivered. * **shopperEmail** – The shopper&#x27;s email address. * **shopperName** – The shopper&#x27;s full name. * **telephoneNumber** – The shopper&#x27;s phone number.
     * @return requiredShopperFields
     **/
    @Schema(description = "List of fields that the shopper has to provide on the payment page before completing the payment. For more information, refer to [Provide shopper information](https://docs.adyen.com/unified-commerce/pay-by-link/payment-links/api#shopper-information).  Possible values: * **billingAddress** – The address where to send the invoice. * **deliveryAddress** – The address where the purchased goods should be delivered. * **shopperEmail** – The shopper's email address. * **shopperName** – The shopper's full name. * **telephoneNumber** – The shopper's phone number. ")
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
    @Schema(description = "Website URL used for redirection after payment is completed. If provided, a **Continue** button will be shown on the payment page. If shoppers select the button, they are redirected to the specified URL.")
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
    @Schema(description = "Indicates whether the payment link can be reused for multiple payments. If not provided, this defaults to **false** which means the link can be used for one successful payment only.")
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
    @Schema(description = "")
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
    @Schema(description = "The shopper's email address.")
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
    @Schema(description = "The language to be used in the payment page, specified by a combination of a language and country code. For example, `en-US`.  For a list of shopper locales that Pay by Link supports, refer to [Language and localization](https://docs.adyen.com/online-payments/pay-by-link#language-and-localization).")
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
    @Schema(description = "")
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
     * Your reference to uniquely identify this shopper, for example user ID or account ID. Minimum length: 3 characters. &gt; Your reference must not include personally identifiable information (PII), for example name or email address.
     * @return shopperReference
     **/
    @Schema(description = "Your reference to uniquely identify this shopper, for example user ID or account ID. Minimum length: 3 characters. > Your reference must not include personally identifiable information (PII), for example name or email address.")
    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    public CreatePaymentLinkRequest shopperStatement(String shopperStatement) {
        this.shopperStatement = shopperStatement;
        return this;
    }

    /**
     * The text to be shown on the shopper&#x27;s bank statement.  We recommend sending a maximum of 22 characters, otherwise banks might truncate the string.  Allowed characters: **a-z**, **A-Z**, **0-9**, spaces, and special characters **. , &#x27; _ - ? + * /_**.
     * @return shopperStatement
     **/
    @Schema(description = "The text to be shown on the shopper's bank statement.  We recommend sending a maximum of 22 characters, otherwise banks might truncate the string.  Allowed characters: **a-z**, **A-Z**, **0-9**, spaces, and special characters **. , ' _ - ? + * /_**.")
    public String getShopperStatement() {
        return shopperStatement;
    }

    public void setShopperStatement(String shopperStatement) {
        this.shopperStatement = shopperStatement;
    }

    public CreatePaymentLinkRequest socialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
        return this;
    }

    /**
     * The shopper&#x27;s social security number.
     * @return socialSecurityNumber
     **/
    @Schema(description = "The shopper's social security number.")
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public CreatePaymentLinkRequest splitCardFundingSources(Boolean splitCardFundingSources) {
        this.splitCardFundingSources = splitCardFundingSources;
        return this;
    }

    /**
     * Boolean value indicating whether the card payment method should be split into separate debit and credit options.
     * @return splitCardFundingSources
     **/
    @Schema(description = "Boolean value indicating whether the card payment method should be split into separate debit and credit options.")
    public Boolean isSplitCardFundingSources() {
        return splitCardFundingSources;
    }

    public void setSplitCardFundingSources(Boolean splitCardFundingSources) {
        this.splitCardFundingSources = splitCardFundingSources;
    }

    public CreatePaymentLinkRequest splits(List<Split> splits) {
        this.splits = splits;
        return this;
    }

    public CreatePaymentLinkRequest addSplitsItem(Split splitsItem) {
        if (this.splits == null) {
            this.splits = new ArrayList<Split>();
        }
        this.splits.add(splitsItem);
        return this;
    }

    /**
     * An array of objects specifying how the payment should be split between accounts when using Adyen for Platforms. For details, refer to [Providing split information](https://docs.adyen.com/platforms/processing-payments#providing-split-information).
     * @return splits
     **/
    @Schema(description = "An array of objects specifying how the payment should be split between accounts when using Adyen for Platforms. For details, refer to [Providing split information](https://docs.adyen.com/platforms/processing-payments#providing-split-information).")
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
    @Schema(description = "The physical store, for which this payment is processed.")
    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public CreatePaymentLinkRequest storePaymentMethodMode(StorePaymentMethodModeEnum storePaymentMethodMode) {
        this.storePaymentMethodMode = storePaymentMethodMode;
        return this;
    }

    /**
     * Indicates if the details of the payment method will be stored for the shopper. Possible values: * **disabled** – No details will be stored (default). * **askForConsent** – If the &#x60;shopperReference&#x60; is provided, the UI lets the shopper choose if they want their payment details to be stored. * **enabled** – If the &#x60;shopperReference&#x60; is provided, the details will be stored without asking the shopper for consent.
     * @return storePaymentMethodMode
     **/
    @Schema(description = "Indicates if the details of the payment method will be stored for the shopper. Possible values: * **disabled** – No details will be stored (default). * **askForConsent** – If the `shopperReference` is provided, the UI lets the shopper choose if they want their payment details to be stored. * **enabled** – If the `shopperReference` is provided, the details will be stored without asking the shopper for consent.")
    public StorePaymentMethodModeEnum getStorePaymentMethodMode() {
        return storePaymentMethodMode;
    }

    public void setStorePaymentMethodMode(StorePaymentMethodModeEnum storePaymentMethodMode) {
        this.storePaymentMethodMode = storePaymentMethodMode;
    }

    public CreatePaymentLinkRequest telephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    /**
     * The shopper&#x27;s telephone number.
     * @return telephoneNumber
     **/
    @Schema(description = "The shopper's telephone number.")
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public CreatePaymentLinkRequest themeId(String themeId) {
        this.themeId = themeId;
        return this;
    }

    /**
     * A [theme](https://docs.adyen.com/unified-commerce/pay-by-link/api#themes) to customize the appearance of the payment page. If not specified, the payment page is rendered according to the theme set as default in your Customer Area.
     * @return themeId
     **/
    @Schema(description = "A [theme](https://docs.adyen.com/unified-commerce/pay-by-link/api#themes) to customize the appearance of the payment page. If not specified, the payment page is rendered according to the theme set as default in your Customer Area.")
    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
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
                Objects.equals(this.shopperStatement, createPaymentLinkRequest.shopperStatement) &&
                Objects.equals(this.socialSecurityNumber, createPaymentLinkRequest.socialSecurityNumber) &&
                Objects.equals(this.splitCardFundingSources, createPaymentLinkRequest.splitCardFundingSources) &&
                Objects.equals(this.splits, createPaymentLinkRequest.splits) &&
                Objects.equals(this.store, createPaymentLinkRequest.store) &&
                Objects.equals(this.storePaymentMethodMode, createPaymentLinkRequest.storePaymentMethodMode) &&
                Objects.equals(this.telephoneNumber, createPaymentLinkRequest.telephoneNumber) &&
                Objects.equals(this.themeId, createPaymentLinkRequest.themeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowedPaymentMethods, amount, applicationInfo, billingAddress, blockedPaymentMethods, captureDelayHours, countryCode, dateOfBirth, deliverAt, deliveryAddress, description, expiresAt, installmentOptions, lineItems, mcc, merchantAccount, merchantOrderReference, metadata, recurringProcessingModel, reference, requiredShopperFields, returnUrl, reusable, riskData, shopperEmail, shopperLocale, shopperName, shopperReference, shopperStatement, socialSecurityNumber, splitCardFundingSources, splits, store, storePaymentMethodMode, telephoneNumber, themeId);
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
        sb.append("    captureDelayHours: ").append(toIndentedString(captureDelayHours)).append("\n");
        sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
        sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
        sb.append("    deliverAt: ").append(toIndentedString(deliverAt)).append("\n");
        sb.append("    deliveryAddress: ").append(toIndentedString(deliveryAddress)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
        sb.append("    installmentOptions: ").append(toIndentedString(installmentOptions)).append("\n");
        sb.append("    lineItems: ").append(toIndentedString(lineItems)).append("\n");
        sb.append("    mcc: ").append(toIndentedString(mcc)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    merchantOrderReference: ").append(toIndentedString(merchantOrderReference)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    recurringProcessingModel: ").append(toIndentedString(recurringProcessingModel)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    requiredShopperFields: ").append(toIndentedString(requiredShopperFields)).append("\n");
        sb.append("    returnUrl: ").append(toIndentedString(returnUrl)).append("\n");
        sb.append("    reusable: ").append(toIndentedString(reusable)).append("\n");
        sb.append("    riskData: ").append(toIndentedString(riskData)).append("\n");
        sb.append("    shopperEmail: ").append(toIndentedString(shopperEmail)).append("\n");
        sb.append("    shopperLocale: ").append(toIndentedString(shopperLocale)).append("\n");
        sb.append("    shopperName: ").append(toIndentedString(shopperName)).append("\n");
        sb.append("    shopperReference: ").append(toIndentedString(shopperReference)).append("\n");
        sb.append("    shopperStatement: ").append(toIndentedString(shopperStatement)).append("\n");
        sb.append("    socialSecurityNumber: ").append(toIndentedString(socialSecurityNumber)).append("\n");
        sb.append("    splitCardFundingSources: ").append(toIndentedString(splitCardFundingSources)).append("\n");
        sb.append("    splits: ").append(toIndentedString(splits)).append("\n");
        sb.append("    store: ").append(toIndentedString(store)).append("\n");
        sb.append("    storePaymentMethodMode: ").append(toIndentedString(storePaymentMethodMode)).append("\n");
        sb.append("    telephoneNumber: ").append(toIndentedString(telephoneNumber)).append("\n");
        sb.append("    themeId: ").append(toIndentedString(themeId)).append("\n");
        sb.append("}");
        return sb.toString();
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
