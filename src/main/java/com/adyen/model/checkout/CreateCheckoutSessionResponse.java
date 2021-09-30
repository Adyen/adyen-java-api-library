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

import java.util.Objects;

import com.adyen.model.AccountInfo;
import com.adyen.model.Address;
import com.adyen.model.Amount;
import com.adyen.model.applicationinfo.ApplicationInfo;
import com.adyen.model.Name;
import com.adyen.model.Split;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import static com.adyen.util.Util.toIndentedString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CreateCheckoutSessionResponse
 */
public class CreateCheckoutSessionResponse {
    public static final String SERIALIZED_NAME_ACCOUNT_INFO = "accountInfo";
    @SerializedName(SERIALIZED_NAME_ACCOUNT_INFO)
    private AccountInfo accountInfo;

    public static final String SERIALIZED_NAME_ADDITIONAL_AMOUNT = "additionalAmount";
    @SerializedName(SERIALIZED_NAME_ADDITIONAL_AMOUNT)
    private Amount additionalAmount;

    public static final String SERIALIZED_NAME_ADDITIONAL_DATA = "additionalData";
    @SerializedName(SERIALIZED_NAME_ADDITIONAL_DATA)
    private Map<String, String> additionalData = null;

    public static final String SERIALIZED_NAME_ALLOWED_PAYMENT_METHODS = "allowedPaymentMethods";
    @SerializedName(SERIALIZED_NAME_ALLOWED_PAYMENT_METHODS)
    private List<String> allowedPaymentMethods = null;

    public static final String SERIALIZED_NAME_AMOUNT = "amount";
    @SerializedName(SERIALIZED_NAME_AMOUNT)
    private Amount amount;

    public static final String SERIALIZED_NAME_APPLICATION_INFO = "applicationInfo";
    @SerializedName(SERIALIZED_NAME_APPLICATION_INFO)
    private ApplicationInfo applicationInfo;

    public static final String SERIALIZED_NAME_BILLING_ADDRESS = "billingAddress";
    @SerializedName(SERIALIZED_NAME_BILLING_ADDRESS)
    private Address billingAddress;

    public static final String SERIALIZED_NAME_BLOCKED_PAYMENT_METHODS = "blockedPaymentMethods";
    @SerializedName(SERIALIZED_NAME_BLOCKED_PAYMENT_METHODS)
    private List<String> blockedPaymentMethods = null;

    public static final String SERIALIZED_NAME_CAPTURE_DELAY_HOURS = "captureDelayHours";
    @SerializedName(SERIALIZED_NAME_CAPTURE_DELAY_HOURS)
    private Integer captureDelayHours;

    /**
     * The platform where a payment transaction takes place. This field is optional for filtering out payment methods that are only available on specific platforms. If this value is not set, then we will try to infer it from the &#x60;sdkVersion&#x60; or &#x60;token&#x60;.  Possible values: * iOS * Android * Web
     */
    @JsonAdapter(ChannelEnum.Adapter.class)
    public enum ChannelEnum {
        IOS("iOS"),
        ANDROID("Android"),
        WEB("Web");

        @JsonValue
        private final String value;

        ChannelEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static ChannelEnum fromValue(String value) {
            for (ChannelEnum b : ChannelEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<ChannelEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ChannelEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public ChannelEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return ChannelEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_CHANNEL = "channel";
    @SerializedName(SERIALIZED_NAME_CHANNEL)
    private ChannelEnum channel;

    public static final String SERIALIZED_NAME_COMPANY = "company";
    @SerializedName(SERIALIZED_NAME_COMPANY)
    private Company company;

    public static final String SERIALIZED_NAME_COUNTRY_CODE = "countryCode";
    @SerializedName(SERIALIZED_NAME_COUNTRY_CODE)
    private String countryCode;

    public static final String SERIALIZED_NAME_DATE_OF_BIRTH = "dateOfBirth";
    @SerializedName(SERIALIZED_NAME_DATE_OF_BIRTH)
    private String dateOfBirth;

    public static final String SERIALIZED_NAME_DELIVERY_ADDRESS = "deliveryAddress";
    @SerializedName(SERIALIZED_NAME_DELIVERY_ADDRESS)
    private Address deliveryAddress;

    public static final String SERIALIZED_NAME_ENABLE_ONE_CLICK = "enableOneClick";
    @SerializedName(SERIALIZED_NAME_ENABLE_ONE_CLICK)
    private Boolean enableOneClick;

    public static final String SERIALIZED_NAME_ENABLE_PAY_OUT = "enablePayOut";
    @SerializedName(SERIALIZED_NAME_ENABLE_PAY_OUT)
    private Boolean enablePayOut;

    public static final String SERIALIZED_NAME_ENABLE_RECURRING = "enableRecurring";
    @SerializedName(SERIALIZED_NAME_ENABLE_RECURRING)
    private Boolean enableRecurring;

    public static final String SERIALIZED_NAME_EXPIRES_AT = "expiresAt";
    @SerializedName(SERIALIZED_NAME_EXPIRES_AT)
    private String expiresAt;

    public static final String SERIALIZED_NAME_ID = "id";
    @SerializedName(SERIALIZED_NAME_ID)
    private String id;

    public static final String SERIALIZED_NAME_LINE_ITEMS = "lineItems";
    @SerializedName(SERIALIZED_NAME_LINE_ITEMS)
    private List<LineItem> lineItems = null;

    public static final String SERIALIZED_NAME_MANDATE = "mandate";
    @SerializedName(SERIALIZED_NAME_MANDATE)
    private Mandate mandate;

    public static final String SERIALIZED_NAME_MCC = "mcc";
    @SerializedName(SERIALIZED_NAME_MCC)
    private String mcc;

    public static final String SERIALIZED_NAME_MERCHANT_ACCOUNT = "merchantAccount";
    @SerializedName(SERIALIZED_NAME_MERCHANT_ACCOUNT)
    private String merchantAccount;

    public static final String SERIALIZED_NAME_MERCHANT_ORDER_REFERENCE = "merchantOrderReference";
    @SerializedName(SERIALIZED_NAME_MERCHANT_ORDER_REFERENCE)
    private String merchantOrderReference;

    public static final String SERIALIZED_NAME_METADATA = "metadata";
    @SerializedName(SERIALIZED_NAME_METADATA)
    private Map<String, String> metadata = null;

    public static final String SERIALIZED_NAME_MPI_DATA = "mpiData";
    @SerializedName(SERIALIZED_NAME_MPI_DATA)
    private ThreeDSecureData mpiData;

    public static final String SERIALIZED_NAME_RECURRING_EXPIRY = "recurringExpiry";
    @SerializedName(SERIALIZED_NAME_RECURRING_EXPIRY)
    private String recurringExpiry;

    public static final String SERIALIZED_NAME_RECURRING_FREQUENCY = "recurringFrequency";
    @SerializedName(SERIALIZED_NAME_RECURRING_FREQUENCY)
    private String recurringFrequency;

    /**
     * Defines a recurring payment type. Allowed values: * &#x60;Subscription&#x60; – A transaction for a fixed or variable amount, which follows a fixed schedule. * &#x60;CardOnFile&#x60; – With a card-on-file (CoF) transaction, card details are stored to enable one-click or omnichannel journeys, or simply to streamline the checkout process. Any subscription not following a fixed schedule is also considered a card-on-file transaction. * &#x60;UnscheduledCardOnFile&#x60; – An unscheduled card-on-file (UCoF) transaction is a transaction that occurs on a non-fixed schedule and/or have variable amounts. For example, automatic top-ups when a cardholder&#39;s balance drops below a certain amount.
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

        public static RecurringProcessingModelEnum fromValue(String value) {
            for (RecurringProcessingModelEnum b : RecurringProcessingModelEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<RecurringProcessingModelEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final RecurringProcessingModelEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public RecurringProcessingModelEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return RecurringProcessingModelEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_RECURRING_PROCESSING_MODEL = "recurringProcessingModel";
    @SerializedName(SERIALIZED_NAME_RECURRING_PROCESSING_MODEL)
    private RecurringProcessingModelEnum recurringProcessingModel;

    public static final String SERIALIZED_NAME_REDIRECT_FROM_ISSUER_METHOD = "redirectFromIssuerMethod";
    @SerializedName(SERIALIZED_NAME_REDIRECT_FROM_ISSUER_METHOD)
    private String redirectFromIssuerMethod;

    public static final String SERIALIZED_NAME_REDIRECT_TO_ISSUER_METHOD = "redirectToIssuerMethod";
    @SerializedName(SERIALIZED_NAME_REDIRECT_TO_ISSUER_METHOD)
    private String redirectToIssuerMethod;

    public static final String SERIALIZED_NAME_REFERENCE = "reference";
    @SerializedName(SERIALIZED_NAME_REFERENCE)
    private String reference;

    public static final String SERIALIZED_NAME_RETURN_URL = "returnUrl";
    @SerializedName(SERIALIZED_NAME_RETURN_URL)
    private String returnUrl;

    public static final String SERIALIZED_NAME_RISK_DATA = "riskData";
    @SerializedName(SERIALIZED_NAME_RISK_DATA)
    private RiskData riskData;

    public static final String SERIALIZED_NAME_SESSION_DATA = "sessionData";
    @SerializedName(SERIALIZED_NAME_SESSION_DATA)
    private String sessionData;

    public static final String SERIALIZED_NAME_SHOPPER_EMAIL = "shopperEmail";
    @SerializedName(SERIALIZED_NAME_SHOPPER_EMAIL)
    private String shopperEmail;

    public static final String SERIALIZED_NAME_SHOPPER_I_P = "shopperIP";
    @SerializedName(SERIALIZED_NAME_SHOPPER_I_P)
    private String shopperIP;

    /**
     * Specifies the sales channel, through which the shopper gives their card details, and whether the shopper is a returning customer. For the web service API, Adyen assumes Ecommerce shopper interaction by default.  This field has the following possible values: * &#x60;Ecommerce&#x60; - Online transactions where the cardholder is present (online). For better authorisation rates, we recommend sending the card security code (CSC) along with the request. * &#x60;ContAuth&#x60; - Card on file and/or subscription transactions, where the cardholder is known to the merchant (returning customer). If the shopper is present (online), you can supply also the CSC to improve authorisation (one-click payment). * &#x60;Moto&#x60; - Mail-order and telephone-order transactions where the shopper is in contact with the merchant via email or telephone. * &#x60;POS&#x60; - Point-of-sale transactions where the shopper is physically present to make a payment using a secure payment terminal.
     */
    @JsonAdapter(ShopperInteractionEnum.Adapter.class)
    public enum ShopperInteractionEnum {
        ECOMMERCE("Ecommerce"),
        CONTAUTH("ContAuth"),
        MOTO("Moto"),
        POS("POS");

        @JsonValue
        private final String value;

        ShopperInteractionEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static ShopperInteractionEnum fromValue(String value) {
            for (ShopperInteractionEnum b : ShopperInteractionEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<ShopperInteractionEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ShopperInteractionEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public ShopperInteractionEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return ShopperInteractionEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_SHOPPER_INTERACTION = "shopperInteraction";
    @SerializedName(SERIALIZED_NAME_SHOPPER_INTERACTION)
    private ShopperInteractionEnum shopperInteraction;

    public static final String SERIALIZED_NAME_SHOPPER_LOCALE = "shopperLocale";
    @SerializedName(SERIALIZED_NAME_SHOPPER_LOCALE)
    private String shopperLocale;

    public static final String SERIALIZED_NAME_SHOPPER_NAME = "shopperName";
    @SerializedName(SERIALIZED_NAME_SHOPPER_NAME)
    private Name shopperName;

    public static final String SERIALIZED_NAME_SHOPPER_REFERENCE = "shopperReference";
    @SerializedName(SERIALIZED_NAME_SHOPPER_REFERENCE)
    private String shopperReference;

    public static final String SERIALIZED_NAME_SHOPPER_STATEMENT = "shopperStatement";
    @SerializedName(SERIALIZED_NAME_SHOPPER_STATEMENT)
    private String shopperStatement;

    public static final String SERIALIZED_NAME_SOCIAL_SECURITY_NUMBER = "socialSecurityNumber";
    @SerializedName(SERIALIZED_NAME_SOCIAL_SECURITY_NUMBER)
    private String socialSecurityNumber;

    public static final String SERIALIZED_NAME_SPLIT_CARD_FUNDING_SOURCES = "splitCardFundingSources";
    @SerializedName(SERIALIZED_NAME_SPLIT_CARD_FUNDING_SOURCES)
    private Boolean splitCardFundingSources = false;

    public static final String SERIALIZED_NAME_SPLITS = "splits";
    @SerializedName(SERIALIZED_NAME_SPLITS)
    private List<Split> splits = null;

    public static final String SERIALIZED_NAME_STORE_PAYMENT_METHOD = "storePaymentMethod";
    @SerializedName(SERIALIZED_NAME_STORE_PAYMENT_METHOD)
    private Boolean storePaymentMethod;

    public static final String SERIALIZED_NAME_TELEPHONE_NUMBER = "telephoneNumber";
    @SerializedName(SERIALIZED_NAME_TELEPHONE_NUMBER)
    private String telephoneNumber;

    public static final String SERIALIZED_NAME_THREE_D_S_AUTHENTICATION_ONLY = "threeDSAuthenticationOnly";
    @SerializedName(SERIALIZED_NAME_THREE_D_S_AUTHENTICATION_ONLY)
    private Boolean threeDSAuthenticationOnly = false;

    public static final String SERIALIZED_NAME_TRUSTED_SHOPPER = "trustedShopper";
    @SerializedName(SERIALIZED_NAME_TRUSTED_SHOPPER)
    private Boolean trustedShopper;


    public CreateCheckoutSessionResponse accountInfo(AccountInfo accountInfo) {

        this.accountInfo = accountInfo;
        this.applicationInfo = new ApplicationInfo();
        return this;
    }

    /**
     * Get accountInfo
     *
     * @return accountInfo
     **/
    public AccountInfo getAccountInfo() {
        return accountInfo;
    }


    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }


    public CreateCheckoutSessionResponse additionalAmount(Amount additionalAmount) {

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


    public CreateCheckoutSessionResponse additionalData(Map<String, String> additionalData) {

        this.additionalData = additionalData;
        return this;
    }

    public CreateCheckoutSessionResponse putAdditionalDataItem(String key, String additionalDataItem) {
        if (this.additionalData == null) {
            this.additionalData = new HashMap<String, String>();
        }
        this.additionalData.put(key, additionalDataItem);
        return this;
    }

    /**
     * This field contains additional data, which may be required for a particular payment request.  The &#x60;additionalData&#x60; object consists of entries, each of which includes the key and value.
     *
     * @return additionalData
     **/
    public Map<String, String> getAdditionalData() {
        return additionalData;
    }


    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }


    public CreateCheckoutSessionResponse allowedPaymentMethods(List<String> allowedPaymentMethods) {

        this.allowedPaymentMethods = allowedPaymentMethods;
        return this;
    }

    public CreateCheckoutSessionResponse addAllowedPaymentMethodsItem(String allowedPaymentMethodsItem) {
        if (this.allowedPaymentMethods == null) {
            this.allowedPaymentMethods = new ArrayList<String>();
        }
        this.allowedPaymentMethods.add(allowedPaymentMethodsItem);
        return this;
    }

    /**
     * List of payment methods to be presented to the shopper. To refer to payment methods, use their &#x60;paymentMethod.type&#x60;from [Payment methods overview](https://docs.adyen.com/payment-methods).  Example: &#x60;\&quot;allowedPaymentMethods\&quot;:[\&quot;ideal\&quot;,\&quot;giropay\&quot;]&#x60;
     *
     * @return allowedPaymentMethods
     **/
    public List<String> getAllowedPaymentMethods() {
        return allowedPaymentMethods;
    }


    public void setAllowedPaymentMethods(List<String> allowedPaymentMethods) {
        this.allowedPaymentMethods = allowedPaymentMethods;
    }


    public CreateCheckoutSessionResponse amount(Amount amount) {

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


    public CreateCheckoutSessionResponse applicationInfo(ApplicationInfo applicationInfo) {

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


    public CreateCheckoutSessionResponse billingAddress(Address billingAddress) {

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


    public CreateCheckoutSessionResponse blockedPaymentMethods(List<String> blockedPaymentMethods) {

        this.blockedPaymentMethods = blockedPaymentMethods;
        return this;
    }

    public CreateCheckoutSessionResponse addBlockedPaymentMethodsItem(String blockedPaymentMethodsItem) {
        if (this.blockedPaymentMethods == null) {
            this.blockedPaymentMethods = new ArrayList<String>();
        }
        this.blockedPaymentMethods.add(blockedPaymentMethodsItem);
        return this;
    }

    /**
     * List of payment methods to be hidden from the shopper. To refer to payment methods, use their &#x60;paymentMethod.type&#x60;from [Payment methods overview](https://docs.adyen.com/payment-methods).  Example: &#x60;\&quot;blockedPaymentMethods\&quot;:[\&quot;ideal\&quot;,\&quot;giropay\&quot;]&#x60;
     *
     * @return blockedPaymentMethods
     **/
    public List<String> getBlockedPaymentMethods() {
        return blockedPaymentMethods;
    }


    public void setBlockedPaymentMethods(List<String> blockedPaymentMethods) {
        this.blockedPaymentMethods = blockedPaymentMethods;
    }


    public CreateCheckoutSessionResponse captureDelayHours(Integer captureDelayHours) {

        this.captureDelayHours = captureDelayHours;
        return this;
    }

    /**
     * The delay between the authorisation and scheduled auto-capture, specified in hours.
     *
     * @return captureDelayHours
     **/
    public Integer getCaptureDelayHours() {
        return captureDelayHours;
    }


    public void setCaptureDelayHours(Integer captureDelayHours) {
        this.captureDelayHours = captureDelayHours;
    }


    public CreateCheckoutSessionResponse channel(ChannelEnum channel) {

        this.channel = channel;
        return this;
    }

    /**
     * The platform where a payment transaction takes place. This field is optional for filtering out payment methods that are only available on specific platforms. If this value is not set, then we will try to infer it from the &#x60;sdkVersion&#x60; or &#x60;token&#x60;.  Possible values: * iOS * Android * Web
     *
     * @return channel
     **/
    public ChannelEnum getChannel() {
        return channel;
    }


    public void setChannel(ChannelEnum channel) {
        this.channel = channel;
    }


    public CreateCheckoutSessionResponse company(Company company) {

        this.company = company;
        return this;
    }

    /**
     * Get company
     *
     * @return company
     **/
    public Company getCompany() {
        return company;
    }


    public void setCompany(Company company) {
        this.company = company;
    }


    public CreateCheckoutSessionResponse countryCode(String countryCode) {

        this.countryCode = countryCode;
        return this;
    }

    /**
     * The shopper&#39;s two-letter country code.
     *
     * @return countryCode
     **/
    public String getCountryCode() {
        return countryCode;
    }


    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


    public CreateCheckoutSessionResponse dateOfBirth(String dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
        return this;
    }

    /**
     * The shopper&#39;s date of birth.  Format [ISO-8601](https://www.w3.org/TR/NOTE-datetime): YYYY-MM-DD
     *
     * @return dateOfBirth
     **/
    public String getDateOfBirth() {
        return dateOfBirth;
    }


    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public CreateCheckoutSessionResponse deliveryAddress(Address deliveryAddress) {

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


    public CreateCheckoutSessionResponse enableOneClick(Boolean enableOneClick) {

        this.enableOneClick = enableOneClick;
        return this;
    }

    /**
     * When true and &#x60;shopperReference&#x60; is provided, the shopper will be asked if the payment details should be stored for future one-click payments.
     *
     * @return enableOneClick
     **/
    public Boolean getEnableOneClick() {
        return enableOneClick;
    }


    public void setEnableOneClick(Boolean enableOneClick) {
        this.enableOneClick = enableOneClick;
    }


    public CreateCheckoutSessionResponse enablePayOut(Boolean enablePayOut) {

        this.enablePayOut = enablePayOut;
        return this;
    }

    /**
     * When true and &#x60;shopperReference&#x60; is provided, the payment details will be tokenized for payouts.
     *
     * @return enablePayOut
     **/
    public Boolean getEnablePayOut() {
        return enablePayOut;
    }


    public void setEnablePayOut(Boolean enablePayOut) {
        this.enablePayOut = enablePayOut;
    }


    public CreateCheckoutSessionResponse enableRecurring(Boolean enableRecurring) {

        this.enableRecurring = enableRecurring;
        return this;
    }

    /**
     * When true and &#x60;shopperReference&#x60; is provided, the payment details will be tokenized for recurring payments.
     *
     * @return enableRecurring
     **/
    public Boolean getEnableRecurring() {
        return enableRecurring;
    }


    public void setEnableRecurring(Boolean enableRecurring) {
        this.enableRecurring = enableRecurring;
    }


    public CreateCheckoutSessionResponse expiresAt(String expiresAt) {

        this.expiresAt = expiresAt;
        return this;
    }

    /**
     * The date the session expires in ISO8601 format. When not specified, it defaults to 1h after creation.
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
     * A unique identifier of the session.
     *
     * @return id
     **/
    public String getId() {
        return id;
    }


    public CreateCheckoutSessionResponse lineItems(List<LineItem> lineItems) {

        this.lineItems = lineItems;
        return this;
    }

    public CreateCheckoutSessionResponse addLineItemsItem(LineItem lineItemsItem) {
        if (this.lineItems == null) {
            this.lineItems = new ArrayList<LineItem>();
        }
        this.lineItems.add(lineItemsItem);
        return this;
    }

    /**
     * Price and product information about the purchased items, to be included on the invoice sent to the shopper. &gt; This field is required for 3x 4x Oney, Affirm, Afterpay, Clearpay, Klarna, Ratepay, and Zip.
     *
     * @return lineItems
     **/
    public List<LineItem> getLineItems() {
        return lineItems;
    }


    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }


    public CreateCheckoutSessionResponse mandate(Mandate mandate) {

        this.mandate = mandate;
        return this;
    }

    /**
     * Get mandate
     *
     * @return mandate
     **/
    public Mandate getMandate() {
        return mandate;
    }


    public void setMandate(Mandate mandate) {
        this.mandate = mandate;
    }


    public CreateCheckoutSessionResponse mcc(String mcc) {

        this.mcc = mcc;
        return this;
    }

    /**
     * The [merchant category code](https://en.wikipedia.org/wiki/Merchant_category_code) (MCC) is a four-digit number, which relates to a particular market segment. This code reflects the predominant activity that is conducted by the merchant.
     *
     * @return mcc
     **/
    public String getMcc() {
        return mcc;
    }


    public void setMcc(String mcc) {
        this.mcc = mcc;
    }


    public CreateCheckoutSessionResponse merchantAccount(String merchantAccount) {

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


    public CreateCheckoutSessionResponse merchantOrderReference(String merchantOrderReference) {

        this.merchantOrderReference = merchantOrderReference;
        return this;
    }

    /**
     * This reference allows linking multiple transactions to each other for reporting purposes (i.e. order auth-rate). The reference should be unique per billing cycle. The same merchant order reference should never be reused after the first authorised attempt. If used, this field should be supplied for all incoming authorisations. &gt; We strongly recommend you send the &#x60;merchantOrderReference&#x60; value to benefit from linking payment requests when authorisation retries take place. In addition, we recommend you provide &#x60;retry.orderAttemptNumber&#x60;, &#x60;retry.chainAttemptNumber&#x60;, and &#x60;retry.skipRetry&#x60; values in &#x60;PaymentRequest.additionalData&#x60;.
     *
     * @return merchantOrderReference
     **/
    public String getMerchantOrderReference() {
        return merchantOrderReference;
    }


    public void setMerchantOrderReference(String merchantOrderReference) {
        this.merchantOrderReference = merchantOrderReference;
    }


    public CreateCheckoutSessionResponse metadata(Map<String, String> metadata) {

        this.metadata = metadata;
        return this;
    }

    public CreateCheckoutSessionResponse putMetadataItem(String key, String metadataItem) {
        if (this.metadata == null) {
            this.metadata = new HashMap<String, String>();
        }
        this.metadata.put(key, metadataItem);
        return this;
    }

    /**
     * Metadata consists of entries, each of which includes a key and a value. Limits: * Maximum 20 key-value pairs per request.* Maximum 20 characters per key. * Maximum 80 characters per value.
     *
     * @return metadata
     **/
    public Map<String, String> getMetadata() {
        return metadata;
    }


    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }


    public CreateCheckoutSessionResponse mpiData(ThreeDSecureData mpiData) {

        this.mpiData = mpiData;
        return this;
    }

    /**
     * Get mpiData
     *
     * @return mpiData
     **/
    public ThreeDSecureData getMpiData() {
        return mpiData;
    }


    public void setMpiData(ThreeDSecureData mpiData) {
        this.mpiData = mpiData;
    }


    public CreateCheckoutSessionResponse recurringExpiry(String recurringExpiry) {

        this.recurringExpiry = recurringExpiry;
        return this;
    }

    /**
     * Date after which no further authorisations shall be performed. Only for 3D Secure 2.
     *
     * @return recurringExpiry
     **/
    public String getRecurringExpiry() {
        return recurringExpiry;
    }


    public void setRecurringExpiry(String recurringExpiry) {
        this.recurringExpiry = recurringExpiry;
    }


    public CreateCheckoutSessionResponse recurringFrequency(String recurringFrequency) {

        this.recurringFrequency = recurringFrequency;
        return this;
    }

    /**
     * Minimum number of days between authorisations. Only for 3D Secure 2.
     *
     * @return recurringFrequency
     **/
    public String getRecurringFrequency() {
        return recurringFrequency;
    }


    public void setRecurringFrequency(String recurringFrequency) {
        this.recurringFrequency = recurringFrequency;
    }


    public CreateCheckoutSessionResponse recurringProcessingModel(RecurringProcessingModelEnum recurringProcessingModel) {

        this.recurringProcessingModel = recurringProcessingModel;
        return this;
    }

    /**
     * Defines a recurring payment type. Allowed values: * &#x60;Subscription&#x60; – A transaction for a fixed or variable amount, which follows a fixed schedule. * &#x60;CardOnFile&#x60; – With a card-on-file (CoF) transaction, card details are stored to enable one-click or omnichannel journeys, or simply to streamline the checkout process. Any subscription not following a fixed schedule is also considered a card-on-file transaction. * &#x60;UnscheduledCardOnFile&#x60; – An unscheduled card-on-file (UCoF) transaction is a transaction that occurs on a non-fixed schedule and/or have variable amounts. For example, automatic top-ups when a cardholder&#39;s balance drops below a certain amount.
     *
     * @return recurringProcessingModel
     **/
    public RecurringProcessingModelEnum getRecurringProcessingModel() {
        return recurringProcessingModel;
    }


    public void setRecurringProcessingModel(RecurringProcessingModelEnum recurringProcessingModel) {
        this.recurringProcessingModel = recurringProcessingModel;
    }


    public CreateCheckoutSessionResponse redirectFromIssuerMethod(String redirectFromIssuerMethod) {

        this.redirectFromIssuerMethod = redirectFromIssuerMethod;
        return this;
    }

    /**
     * Specifies the redirect method (GET or POST) when redirecting back from the issuer.
     *
     * @return redirectFromIssuerMethod
     **/
    public String getRedirectFromIssuerMethod() {
        return redirectFromIssuerMethod;
    }


    public void setRedirectFromIssuerMethod(String redirectFromIssuerMethod) {
        this.redirectFromIssuerMethod = redirectFromIssuerMethod;
    }


    public CreateCheckoutSessionResponse redirectToIssuerMethod(String redirectToIssuerMethod) {

        this.redirectToIssuerMethod = redirectToIssuerMethod;
        return this;
    }

    /**
     * Specifies the redirect method (GET or POST) when redirecting to the issuer.
     *
     * @return redirectToIssuerMethod
     **/
    public String getRedirectToIssuerMethod() {
        return redirectToIssuerMethod;
    }


    public void setRedirectToIssuerMethod(String redirectToIssuerMethod) {
        this.redirectToIssuerMethod = redirectToIssuerMethod;
    }


    public CreateCheckoutSessionResponse reference(String reference) {

        this.reference = reference;
        return this;
    }

    /**
     * The reference to uniquely identify a payment.
     *
     * @return reference
     **/
    public String getReference() {
        return reference;
    }


    public void setReference(String reference) {
        this.reference = reference;
    }


    public CreateCheckoutSessionResponse returnUrl(String returnUrl) {

        this.returnUrl = returnUrl;
        return this;
    }

    /**
     * The URL to return to when a redirect payment is completed.
     *
     * @return returnUrl
     **/
    public String getReturnUrl() {
        return returnUrl;
    }


    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }


    public CreateCheckoutSessionResponse riskData(RiskData riskData) {

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


    public CreateCheckoutSessionResponse sessionData(String sessionData) {

        this.sessionData = sessionData;
        return this;
    }

    /**
     * Get sessionData
     *
     * @return sessionData
     **/
    public String getSessionData() {
        return sessionData;
    }


    public void setSessionData(String sessionData) {
        this.sessionData = sessionData;
    }


    public CreateCheckoutSessionResponse shopperEmail(String shopperEmail) {

        this.shopperEmail = shopperEmail;
        return this;
    }

    /**
     * The shopper&#39;s email address.
     *
     * @return shopperEmail
     **/
    public String getShopperEmail() {
        return shopperEmail;
    }


    public void setShopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
    }


    public CreateCheckoutSessionResponse shopperIP(String shopperIP) {

        this.shopperIP = shopperIP;
        return this;
    }

    /**
     * The shopper&#39;s IP address. In general, we recommend that you provide this data, as it is used in a number of risk checks (for instance, number of payment attempts or location-based checks). &gt; For 3D Secure 2 transactions, schemes require &#x60;shopperIP&#x60; for all browser-based implementations. This field is also mandatory for some merchants depending on your business model. For more information, [contact Support](https://support.adyen.com/hc/en-us/requests/new).
     *
     * @return shopperIP
     **/
    public String getShopperIP() {
        return shopperIP;
    }


    public void setShopperIP(String shopperIP) {
        this.shopperIP = shopperIP;
    }


    public CreateCheckoutSessionResponse shopperInteraction(ShopperInteractionEnum shopperInteraction) {

        this.shopperInteraction = shopperInteraction;
        return this;
    }

    /**
     * Specifies the sales channel, through which the shopper gives their card details, and whether the shopper is a returning customer. For the web service API, Adyen assumes Ecommerce shopper interaction by default.  This field has the following possible values: * &#x60;Ecommerce&#x60; - Online transactions where the cardholder is present (online). For better authorisation rates, we recommend sending the card security code (CSC) along with the request. * &#x60;ContAuth&#x60; - Card on file and/or subscription transactions, where the cardholder is known to the merchant (returning customer). If the shopper is present (online), you can supply also the CSC to improve authorisation (one-click payment). * &#x60;Moto&#x60; - Mail-order and telephone-order transactions where the shopper is in contact with the merchant via email or telephone. * &#x60;POS&#x60; - Point-of-sale transactions where the shopper is physically present to make a payment using a secure payment terminal.
     *
     * @return shopperInteraction
     **/
    public ShopperInteractionEnum getShopperInteraction() {
        return shopperInteraction;
    }


    public void setShopperInteraction(ShopperInteractionEnum shopperInteraction) {
        this.shopperInteraction = shopperInteraction;
    }


    public CreateCheckoutSessionResponse shopperLocale(String shopperLocale) {

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


    public CreateCheckoutSessionResponse shopperName(Name shopperName) {

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


    public CreateCheckoutSessionResponse shopperReference(String shopperReference) {

        this.shopperReference = shopperReference;
        return this;
    }

    /**
     * Your reference to uniquely identify this shopper, for example user ID or account ID. Minimum length: 3 characters. &gt; Your reference must not include personally identifiable information (PII), for example name or email address.
     *
     * @return shopperReference
     **/
    public String getShopperReference() {
        return shopperReference;
    }


    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }


    public CreateCheckoutSessionResponse shopperStatement(String shopperStatement) {

        this.shopperStatement = shopperStatement;
        return this;
    }

    /**
     * The text to be shown on the shopper&#39;s bank statement. To enable this field, contact our [Support Team](https://support.adyen.com/hc/en-us/requests/new).  We recommend sending a maximum of 22 characters, otherwise banks might truncate the string.
     *
     * @return shopperStatement
     **/
    public String getShopperStatement() {
        return shopperStatement;
    }


    public void setShopperStatement(String shopperStatement) {
        this.shopperStatement = shopperStatement;
    }


    public CreateCheckoutSessionResponse socialSecurityNumber(String socialSecurityNumber) {

        this.socialSecurityNumber = socialSecurityNumber;
        return this;
    }

    /**
     * The shopper&#39;s social security number.
     *
     * @return socialSecurityNumber
     **/
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }


    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }


    public CreateCheckoutSessionResponse splitCardFundingSources(Boolean splitCardFundingSources) {

        this.splitCardFundingSources = splitCardFundingSources;
        return this;
    }

    /**
     * Boolean value indicating whether the card payment method should be split into separate debit and credit options.
     *
     * @return splitCardFundingSources
     **/
    public Boolean getSplitCardFundingSources() {
        return splitCardFundingSources;
    }


    public void setSplitCardFundingSources(Boolean splitCardFundingSources) {
        this.splitCardFundingSources = splitCardFundingSources;
    }


    public CreateCheckoutSessionResponse splits(List<Split> splits) {

        this.splits = splits;
        return this;
    }

    public CreateCheckoutSessionResponse addSplitsItem(Split splitsItem) {
        if (this.splits == null) {
            this.splits = new ArrayList<Split>();
        }
        this.splits.add(splitsItem);
        return this;
    }

    /**
     * An array of objects specifying how the payment should be split when using [Adyen for Platforms](https://docs.adyen.com/platforms/processing-payments#providing-split-information) or [Issuing](https://docs.adyen.com/issuing/manage-funds#split).
     *
     * @return splits
     **/
    public List<Split> getSplits() {
        return splits;
    }


    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }


    public CreateCheckoutSessionResponse storePaymentMethod(Boolean storePaymentMethod) {

        this.storePaymentMethod = storePaymentMethod;
        return this;
    }

    /**
     * When this is set to **true** and the &#x60;shopperReference&#x60; is provided, the payment details will be stored.
     *
     * @return storePaymentMethod
     **/
    public Boolean getStorePaymentMethod() {
        return storePaymentMethod;
    }


    public void setStorePaymentMethod(Boolean storePaymentMethod) {
        this.storePaymentMethod = storePaymentMethod;
    }


    public CreateCheckoutSessionResponse telephoneNumber(String telephoneNumber) {

        this.telephoneNumber = telephoneNumber;
        return this;
    }

    /**
     * The shopper&#39;s telephone number.
     *
     * @return telephoneNumber
     **/
    public String getTelephoneNumber() {
        return telephoneNumber;
    }


    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }


    public CreateCheckoutSessionResponse threeDSAuthenticationOnly(Boolean threeDSAuthenticationOnly) {

        this.threeDSAuthenticationOnly = threeDSAuthenticationOnly;
        return this;
    }

    /**
     * If set to true, you will only perform the [3D Secure 2 authentication](https://docs.adyen.com/online-payments/3d-secure/other-3ds-flows/authentication-only), and not the payment authorisation.
     *
     * @return threeDSAuthenticationOnly
     **/
    public Boolean getThreeDSAuthenticationOnly() {
        return threeDSAuthenticationOnly;
    }


    public void setThreeDSAuthenticationOnly(Boolean threeDSAuthenticationOnly) {
        this.threeDSAuthenticationOnly = threeDSAuthenticationOnly;
    }


    public CreateCheckoutSessionResponse trustedShopper(Boolean trustedShopper) {

        this.trustedShopper = trustedShopper;
        return this;
    }

    /**
     * Set to true if the payment should be routed to a trusted MID.
     *
     * @return trustedShopper
     **/
    public Boolean getTrustedShopper() {
        return trustedShopper;
    }


    public void setTrustedShopper(Boolean trustedShopper) {
        this.trustedShopper = trustedShopper;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateCheckoutSessionResponse createCheckoutSessionResponse = (CreateCheckoutSessionResponse) o;
        return Objects.equals(this.accountInfo, createCheckoutSessionResponse.accountInfo) &&
                Objects.equals(this.additionalAmount, createCheckoutSessionResponse.additionalAmount) &&
                Objects.equals(this.additionalData, createCheckoutSessionResponse.additionalData) &&
                Objects.equals(this.allowedPaymentMethods, createCheckoutSessionResponse.allowedPaymentMethods) &&
                Objects.equals(this.amount, createCheckoutSessionResponse.amount) &&
                Objects.equals(this.applicationInfo, createCheckoutSessionResponse.applicationInfo) &&
                Objects.equals(this.billingAddress, createCheckoutSessionResponse.billingAddress) &&
                Objects.equals(this.blockedPaymentMethods, createCheckoutSessionResponse.blockedPaymentMethods) &&
                Objects.equals(this.captureDelayHours, createCheckoutSessionResponse.captureDelayHours) &&
                Objects.equals(this.channel, createCheckoutSessionResponse.channel) &&
                Objects.equals(this.company, createCheckoutSessionResponse.company) &&
                Objects.equals(this.countryCode, createCheckoutSessionResponse.countryCode) &&
                Objects.equals(this.dateOfBirth, createCheckoutSessionResponse.dateOfBirth) &&
                Objects.equals(this.deliveryAddress, createCheckoutSessionResponse.deliveryAddress) &&
                Objects.equals(this.enableOneClick, createCheckoutSessionResponse.enableOneClick) &&
                Objects.equals(this.enablePayOut, createCheckoutSessionResponse.enablePayOut) &&
                Objects.equals(this.enableRecurring, createCheckoutSessionResponse.enableRecurring) &&
                Objects.equals(this.expiresAt, createCheckoutSessionResponse.expiresAt) &&
                Objects.equals(this.id, createCheckoutSessionResponse.id) &&
                Objects.equals(this.lineItems, createCheckoutSessionResponse.lineItems) &&
                Objects.equals(this.mandate, createCheckoutSessionResponse.mandate) &&
                Objects.equals(this.mcc, createCheckoutSessionResponse.mcc) &&
                Objects.equals(this.merchantAccount, createCheckoutSessionResponse.merchantAccount) &&
                Objects.equals(this.merchantOrderReference, createCheckoutSessionResponse.merchantOrderReference) &&
                Objects.equals(this.metadata, createCheckoutSessionResponse.metadata) &&
                Objects.equals(this.mpiData, createCheckoutSessionResponse.mpiData) &&
                Objects.equals(this.recurringExpiry, createCheckoutSessionResponse.recurringExpiry) &&
                Objects.equals(this.recurringFrequency, createCheckoutSessionResponse.recurringFrequency) &&
                Objects.equals(this.recurringProcessingModel, createCheckoutSessionResponse.recurringProcessingModel) &&
                Objects.equals(this.redirectFromIssuerMethod, createCheckoutSessionResponse.redirectFromIssuerMethod) &&
                Objects.equals(this.redirectToIssuerMethod, createCheckoutSessionResponse.redirectToIssuerMethod) &&
                Objects.equals(this.reference, createCheckoutSessionResponse.reference) &&
                Objects.equals(this.returnUrl, createCheckoutSessionResponse.returnUrl) &&
                Objects.equals(this.riskData, createCheckoutSessionResponse.riskData) &&
                Objects.equals(this.sessionData, createCheckoutSessionResponse.sessionData) &&
                Objects.equals(this.shopperEmail, createCheckoutSessionResponse.shopperEmail) &&
                Objects.equals(this.shopperIP, createCheckoutSessionResponse.shopperIP) &&
                Objects.equals(this.shopperInteraction, createCheckoutSessionResponse.shopperInteraction) &&
                Objects.equals(this.shopperLocale, createCheckoutSessionResponse.shopperLocale) &&
                Objects.equals(this.shopperName, createCheckoutSessionResponse.shopperName) &&
                Objects.equals(this.shopperReference, createCheckoutSessionResponse.shopperReference) &&
                Objects.equals(this.shopperStatement, createCheckoutSessionResponse.shopperStatement) &&
                Objects.equals(this.socialSecurityNumber, createCheckoutSessionResponse.socialSecurityNumber) &&
                Objects.equals(this.splitCardFundingSources, createCheckoutSessionResponse.splitCardFundingSources) &&
                Objects.equals(this.splits, createCheckoutSessionResponse.splits) &&
                Objects.equals(this.storePaymentMethod, createCheckoutSessionResponse.storePaymentMethod) &&
                Objects.equals(this.telephoneNumber, createCheckoutSessionResponse.telephoneNumber) &&
                Objects.equals(this.threeDSAuthenticationOnly, createCheckoutSessionResponse.threeDSAuthenticationOnly) &&
                Objects.equals(this.trustedShopper, createCheckoutSessionResponse.trustedShopper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountInfo, additionalAmount, additionalData, allowedPaymentMethods, amount, applicationInfo, billingAddress, blockedPaymentMethods, captureDelayHours, channel, company, countryCode, dateOfBirth, deliveryAddress, enableOneClick, enablePayOut, enableRecurring, expiresAt, id, lineItems, mandate, mcc, merchantAccount, merchantOrderReference, metadata, mpiData, recurringExpiry, recurringFrequency, recurringProcessingModel, redirectFromIssuerMethod, redirectToIssuerMethod, reference, returnUrl, riskData, sessionData, shopperEmail, shopperIP, shopperInteraction, shopperLocale, shopperName, shopperReference, shopperStatement, socialSecurityNumber, splitCardFundingSources, splits, storePaymentMethod, telephoneNumber, threeDSAuthenticationOnly, trustedShopper);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateCheckoutSessionResponse {\n");
        sb.append("    accountInfo: ").append(toIndentedString(accountInfo)).append("\n");
        sb.append("    additionalAmount: ").append(toIndentedString(additionalAmount)).append("\n");
        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
        sb.append("    allowedPaymentMethods: ").append(toIndentedString(allowedPaymentMethods)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    applicationInfo: ").append(toIndentedString(applicationInfo)).append("\n");
        sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
        sb.append("    blockedPaymentMethods: ").append(toIndentedString(blockedPaymentMethods)).append("\n");
        sb.append("    captureDelayHours: ").append(toIndentedString(captureDelayHours)).append("\n");
        sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
        sb.append("    company: ").append(toIndentedString(company)).append("\n");
        sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
        sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
        sb.append("    deliveryAddress: ").append(toIndentedString(deliveryAddress)).append("\n");
        sb.append("    enableOneClick: ").append(toIndentedString(enableOneClick)).append("\n");
        sb.append("    enablePayOut: ").append(toIndentedString(enablePayOut)).append("\n");
        sb.append("    enableRecurring: ").append(toIndentedString(enableRecurring)).append("\n");
        sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    lineItems: ").append(toIndentedString(lineItems)).append("\n");
        sb.append("    mandate: ").append(toIndentedString(mandate)).append("\n");
        sb.append("    mcc: ").append(toIndentedString(mcc)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    merchantOrderReference: ").append(toIndentedString(merchantOrderReference)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    mpiData: ").append(toIndentedString(mpiData)).append("\n");
        sb.append("    recurringExpiry: ").append(toIndentedString(recurringExpiry)).append("\n");
        sb.append("    recurringFrequency: ").append(toIndentedString(recurringFrequency)).append("\n");
        sb.append("    recurringProcessingModel: ").append(toIndentedString(recurringProcessingModel)).append("\n");
        sb.append("    redirectFromIssuerMethod: ").append(toIndentedString(redirectFromIssuerMethod)).append("\n");
        sb.append("    redirectToIssuerMethod: ").append(toIndentedString(redirectToIssuerMethod)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    returnUrl: ").append(toIndentedString(returnUrl)).append("\n");
        sb.append("    riskData: ").append(toIndentedString(riskData)).append("\n");
        sb.append("    sessionData: ").append(toIndentedString(sessionData)).append("\n");
        sb.append("    shopperEmail: ").append(toIndentedString(shopperEmail)).append("\n");
        sb.append("    shopperIP: ").append(toIndentedString(shopperIP)).append("\n");
        sb.append("    shopperInteraction: ").append(toIndentedString(shopperInteraction)).append("\n");
        sb.append("    shopperLocale: ").append(toIndentedString(shopperLocale)).append("\n");
        sb.append("    shopperName: ").append(toIndentedString(shopperName)).append("\n");
        sb.append("    shopperReference: ").append(toIndentedString(shopperReference)).append("\n");
        sb.append("    shopperStatement: ").append(toIndentedString(shopperStatement)).append("\n");
        sb.append("    socialSecurityNumber: ").append(toIndentedString(socialSecurityNumber)).append("\n");
        sb.append("    splitCardFundingSources: ").append(toIndentedString(splitCardFundingSources)).append("\n");
        sb.append("    splits: ").append(toIndentedString(splits)).append("\n");
        sb.append("    storePaymentMethod: ").append(toIndentedString(storePaymentMethod)).append("\n");
        sb.append("    telephoneNumber: ").append(toIndentedString(telephoneNumber)).append("\n");
        sb.append("    threeDSAuthenticationOnly: ").append(toIndentedString(threeDSAuthenticationOnly)).append("\n");
        sb.append("    trustedShopper: ").append(toIndentedString(trustedShopper)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}

