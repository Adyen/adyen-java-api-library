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

import com.adyen.deserializer.PaymentMethodDetailsDeserializerJackson;
import com.adyen.deserializer.PaymentMethodDetailsTypeAdapter;
import com.adyen.model.AccountInfo;
import com.adyen.model.Address;
import com.adyen.model.Amount;
import com.adyen.model.BrowserInfo;
import com.adyen.model.ForexQuote;
import com.adyen.model.Installments;
import com.adyen.model.MerchantRiskIndicator;
import com.adyen.model.Name;
import com.adyen.model.Split;
import com.adyen.model.ThreeDS2RequestData;
import com.adyen.model.applicationinfo.ApplicationInfo;
import com.adyen.serializer.DateSerializer;
import com.adyen.serializer.DateTimeGMTSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * PaymentsRequest
 */
public class PaymentsRequest {
    @SerializedName("accountInfo")
    private AccountInfo accountInfo = null;

    @SerializedName("additionalData")
    private Map<String, String> additionalData = null;

    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("authenticationData")
    private AuthenticationData authenticationData = null;

    @SerializedName("billingAddress")
    private Address billingAddress = null;

    @SerializedName("browserInfo")
    private BrowserInfo browserInfo = null;

    @SerializedName("captureDelayHours")
    private Integer captureDelayHours = null;

    /**
     * The platform where a payment transaction takes place. This field is optional for filtering out payment methods that are only available on specific platforms. If this value is not set, then we will try to infer it from the &#x60;sdkVersion&#x60; or &#x60;token&#x60;.  Possible values: * iOS * Android * Web
     */
    @JsonAdapter(ChannelEnum.Adapter.class)
    public enum ChannelEnum {
        IOS("iOS"),
        ANDROID("Android"),
        WEB("Web");

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
        public static ChannelEnum fromValue(String input) {
            for (ChannelEnum b : ChannelEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<ChannelEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ChannelEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public ChannelEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return ChannelEnum.fromValue((String) (value));
            }
        }
    }  @SerializedName("channel")
    private ChannelEnum channel = null;

    @SerializedName("checkoutAttemptId")
    private String checkoutAttemptId = null;

    @SerializedName("company")
    private Company company = null;

    @SerializedName("conversionId")
    private String conversionId = null;

    @SerializedName("countryCode")
    private String countryCode = null;

    @SerializedName("dateOfBirth")
    @JsonAdapter(DateSerializer.class)
    private Date dateOfBirth = null;

    @SerializedName("dccQuote")
    private ForexQuote dccQuote = null;

    @SerializedName("deliveryAddress")
    private Address deliveryAddress = null;

    @SerializedName("deliveryDate")
    @JsonAdapter(DateTimeGMTSerializer.class)
    private Date deliveryDate = null;

    @SerializedName("deviceFingerprint")
    private String deviceFingerprint = null;

    @SerializedName("enableOneClick")
    private Boolean enableOneClick = null;

    @SerializedName("enablePayOut")
    private Boolean enablePayOut = null;

    @SerializedName("enableRecurring")
    private Boolean enableRecurring = null;

    /**
     * The type of the entity the payment is processed for.
     */
    @JsonAdapter(EntityTypeEnum.Adapter.class)
    public enum EntityTypeEnum {
        NATURALPERSON("NaturalPerson"),
        COMPANYNAME("CompanyName");

        private final String value;

        EntityTypeEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static EntityTypeEnum fromValue(String input) {
            for (EntityTypeEnum b : EntityTypeEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<EntityTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final EntityTypeEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public EntityTypeEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return EntityTypeEnum.fromValue((String) (value));
            }
        }
    }  @SerializedName("entityType")
    private EntityTypeEnum entityType = null;

    @SerializedName("fraudOffset")
    private Integer fraudOffset = null;

    @SerializedName("installments")
    private Installments installments = null;

    @SerializedName("lineItems")
    private List<LineItem> lineItems = null;

    @SerializedName("mandate")
    private Mandate mandate = null;

    @SerializedName("mcc")
    private String mcc = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("merchantOrderReference")
    private String merchantOrderReference = null;

    @SerializedName("merchantRiskIndicator")
    private MerchantRiskIndicator merchantRiskIndicator = null;

    @SerializedName("metadata")
    private Map<String, String> metadata = null;

    @SerializedName("mpiData")
    private ThreeDSecureData mpiData = null;

    @SerializedName("order")
    private CheckoutOrder order = null;

    @SerializedName("orderReference")
    private String orderReference = null;

    @SerializedName("origin")
    private String origin = null;

    @SerializedName("paymentMethod")
    @JsonAdapter(PaymentMethodDetailsTypeAdapter.class)
    @JsonDeserialize(using = PaymentMethodDetailsDeserializerJackson.class)
    private PaymentMethodDetails paymentMethod = null;

    @SerializedName("recurringExpiry")
    private String recurringExpiry = null;

    @SerializedName("recurringFrequency")
    private String recurringFrequency = null;

    /**
     * Defines a recurring payment type. Allowed values: * &#x60;Subscription&#x60; – A transaction for a fixed or variable amount, which follows a fixed schedule. * &#x60;CardOnFile&#x60; – With a card-on-file (CoF) transaction, card details are stored to enable one-click or omnichannel journeys, or simply to streamline the checkout process. Any subscription not following a fixed schedule is also considered a card-on-file transaction. * &#x60;UnscheduledCardOnFile&#x60; – An unscheduled card-on-file (UCoF) transaction is a transaction that occurs on a non-fixed schedule and/or have variable amounts. For example, automatic top-ups when a cardholder&#x27;s balance drops below a certain amount.
     */
    @JsonAdapter(RecurringProcessingModelEnum.Adapter.class)
    public enum RecurringProcessingModelEnum {
        CARDONFILE("CardOnFile"),
        SUBSCRIPTION("Subscription"),
        UNSCHEDULEDCARDONFILE("UnscheduledCardOnFile");

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
                return RecurringProcessingModelEnum.fromValue((String) (value));
            }
        }
    }  @SerializedName("recurringProcessingModel")
    private RecurringProcessingModelEnum recurringProcessingModel = null;

    @SerializedName("redirectFromIssuerMethod")
    private String redirectFromIssuerMethod = null;

    @SerializedName("redirectToIssuerMethod")
    private String redirectToIssuerMethod = null;

    @SerializedName("reference")
    private String reference = null;

    @SerializedName("returnUrl")
    private String returnUrl = null;

    @SerializedName("riskData")
    private RiskData riskData = null;

    @SerializedName("sessionValidity")
    private String sessionValidity = null;

    @SerializedName("shopperEmail")
    private String shopperEmail = null;

    @SerializedName("shopperIP")
    private String shopperIP = null;

    /**
     * Specifies the sales channel, through which the shopper gives their card details, and whether the shopper is a returning customer. For the web service API, Adyen assumes Ecommerce shopper interaction by default.  This field has the following possible values: * &#x60;Ecommerce&#x60; - Online transactions where the cardholder is present (online). For better authorisation rates, we recommend sending the card security code (CSC) along with the request. * &#x60;ContAuth&#x60; - Card on file and/or subscription transactions, where the cardholder is known to the merchant (returning customer). If the shopper is present (online), you can supply also the CSC to improve authorisation (one-click payment). * &#x60;Moto&#x60; - Mail-order and telephone-order transactions where the shopper is in contact with the merchant via email or telephone. * &#x60;POS&#x60; - Point-of-sale transactions where the shopper is physically present to make a payment using a secure payment terminal.
     */
    @JsonAdapter(ShopperInteractionEnum.Adapter.class)
    public enum ShopperInteractionEnum {
        ECOMMERCE("Ecommerce"),
        CONTAUTH("ContAuth"),
        MOTO("Moto"),
        POS("POS");

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
        public static ShopperInteractionEnum fromValue(String input) {
            for (ShopperInteractionEnum b : ShopperInteractionEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<ShopperInteractionEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ShopperInteractionEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public ShopperInteractionEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return ShopperInteractionEnum.fromValue((String) (value));
            }
        }
    }  @SerializedName("shopperInteraction")
    private ShopperInteractionEnum shopperInteraction = null;

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

    @SerializedName("splits")
    private List<Split> splits = null;

    @SerializedName("store")
    private String store = null;

    @SerializedName("storePaymentMethod")
    private Boolean storePaymentMethod = null;

    @SerializedName("telephoneNumber")
    private String telephoneNumber = null;

    @SerializedName("applicationInfo")
    private ApplicationInfo applicationInfo = null;

    @SerializedName("threeDS2RequestData")
    private ThreeDS2RequestData threeDS2RequestData = null;

    @SerializedName("threeDSAuthenticationOnly")
    private Boolean threeDSAuthenticationOnly = null;

    @SerializedName("trustedShopper")
    private Boolean trustedShopper = null;

    public PaymentsRequest() {
        applicationInfo = new ApplicationInfo();
    }

    public PaymentsRequest accountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
        return this;
    }

    /**
     * Get accountInfo
     * @return accountInfo
     **/
    @Schema(description = "")
    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public PaymentsRequest additionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
        return this;
    }

    public PaymentsRequest putAdditionalDataItem(String key, String additionalDataItem) {
        if (this.additionalData == null) {
            this.additionalData = new HashMap<String, String>();
        }
        this.additionalData.put(key, additionalDataItem);
        return this;
    }

    /**
     * This field contains additional data, which may be required for a particular payment request.  The &#x60;additionalData&#x60; object consists of entries, each of which includes the key and value.
     * @return additionalData
     **/
    @Schema(description = "This field contains additional data, which may be required for a particular payment request.  The `additionalData` object consists of entries, each of which includes the key and value.")
    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    public PaymentsRequest amount(Amount amount) {
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

    public PaymentsRequest applicationInfo(ApplicationInfo applicationInfo) {
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

    public PaymentsRequest authenticationData(AuthenticationData authenticationData) {
        this.authenticationData = authenticationData;
        return this;
    }

    /**
     * Get authenticationData
     * @return authenticationData
     **/
    @Schema(description = "")
    public AuthenticationData getAuthenticationData() {
        return authenticationData;
    }

    public void setAuthenticationData(AuthenticationData authenticationData) {
        this.authenticationData = authenticationData;
    }

    public PaymentsRequest billingAddress(Address billingAddress) {
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

    public PaymentsRequest browserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
        return this;
    }

    /**
     * Get browserInfo
     * @return browserInfo
     **/
    @Schema(description = "")
    public BrowserInfo getBrowserInfo() {
        return browserInfo;
    }

    public void setBrowserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
    }

    public PaymentsRequest captureDelayHours(Integer captureDelayHours) {
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

    public PaymentsRequest channel(ChannelEnum channel) {
        this.channel = channel;
        return this;
    }

    /**
     * The platform where a payment transaction takes place. This field is optional for filtering out payment methods that are only available on specific platforms. If this value is not set, then we will try to infer it from the &#x60;sdkVersion&#x60; or &#x60;token&#x60;.  Possible values: * iOS * Android * Web
     * @return channel
     **/
    @Schema(description = "The platform where a payment transaction takes place. This field is optional for filtering out payment methods that are only available on specific platforms. If this value is not set, then we will try to infer it from the `sdkVersion` or `token`.  Possible values: * iOS * Android * Web")
    public ChannelEnum getChannel() {
        return channel;
    }

    public void setChannel(ChannelEnum channel) {
        this.channel = channel;
    }

    public PaymentsRequest checkoutAttemptId(String checkoutAttemptId) {
        this.checkoutAttemptId = checkoutAttemptId;
        return this;
    }

    /**
     * Checkout attempt ID that corresponds to the Id generated for tracking user payment journey.
     * @return checkoutAttemptId
     **/
    @Schema(description = "Checkout attempt ID that corresponds to the Id generated for tracking user payment journey.")
    public String getCheckoutAttemptId() {
        return checkoutAttemptId;
    }

    public void setCheckoutAttemptId(String checkoutAttemptId) {
        this.checkoutAttemptId = checkoutAttemptId;
    }

    public PaymentsRequest company(Company company) {
        this.company = company;
        return this;
    }

    /**
     * Get company
     * @return company
     **/
    @Schema(description = "")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public PaymentsRequest conversionId(String conversionId) {
        this.conversionId = conversionId;
        return this;
    }

    /**
     * Conversion ID that corresponds to the Id generated for tracking user payment journey.
     * @return conversionId
     **/
    @Schema(description = "Conversion ID that corresponds to the Id generated for tracking user payment journey.")
    public String getConversionId() {
        return conversionId;
    }

    public void setConversionId(String conversionId) {
        this.conversionId = conversionId;
    }

    public PaymentsRequest countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    /**
     * The shopper country.  Format: [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) Example: NL or DE
     * @return countryCode
     **/
    @Schema(description = "The shopper country.  Format: [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) Example: NL or DE")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public PaymentsRequest dateOfBirth(Date dateOfBirth) {
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

    public PaymentsRequest dccQuote(ForexQuote dccQuote) {
        this.dccQuote = dccQuote;
        return this;
    }

    /**
     * Get dccQuote
     * @return dccQuote
     **/
    @Schema(description = "")
    public ForexQuote getDccQuote() {
        return dccQuote;
    }

    public void setDccQuote(ForexQuote dccQuote) {
        this.dccQuote = dccQuote;
    }

    public PaymentsRequest deliveryAddress(Address deliveryAddress) {
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

    public PaymentsRequest deliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }

    /**
     * The date and time the purchased goods should be delivered.  Format [ISO 8601](https://www.w3.org/TR/NOTE-datetime): YYYY-MM-DDThh:mm:ss.sssTZD  Example: 2017-07-17T13:42:40.428+01:00
     * @return deliveryDate
     **/
    @Schema(description = "The date and time the purchased goods should be delivered.  Format [ISO 8601](https://www.w3.org/TR/NOTE-datetime): YYYY-MM-DDThh:mm:ss.sssTZD  Example: 2017-07-17T13:42:40.428+01:00")
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public PaymentsRequest deviceFingerprint(String deviceFingerprint) {
        this.deviceFingerprint = deviceFingerprint;
        return this;
    }

    /**
     * A string containing the shopper&#x27;s device fingerprint. For more information, refer to [Device fingerprinting](https://docs.adyen.com/risk-management/device-fingerprinting).
     * @return deviceFingerprint
     **/
    @Schema(description = "A string containing the shopper's device fingerprint. For more information, refer to [Device fingerprinting](https://docs.adyen.com/risk-management/device-fingerprinting).")
    public String getDeviceFingerprint() {
        return deviceFingerprint;
    }

    public void setDeviceFingerprint(String deviceFingerprint) {
        this.deviceFingerprint = deviceFingerprint;
    }

    public PaymentsRequest enableOneClick(Boolean enableOneClick) {
        this.enableOneClick = enableOneClick;
        return this;
    }

    /**
     * When true and &#x60;shopperReference&#x60; is provided, the shopper will be asked if the payment details should be stored for future one-click payments.
     * @return enableOneClick
     **/
    @Schema(description = "When true and `shopperReference` is provided, the shopper will be asked if the payment details should be stored for future one-click payments.")
    public Boolean isEnableOneClick() {
        return enableOneClick;
    }

    public void setEnableOneClick(Boolean enableOneClick) {
        this.enableOneClick = enableOneClick;
    }

    public PaymentsRequest enablePayOut(Boolean enablePayOut) {
        this.enablePayOut = enablePayOut;
        return this;
    }

    /**
     * When true and &#x60;shopperReference&#x60; is provided, the payment details will be tokenized for payouts.
     * @return enablePayOut
     **/
    @Schema(description = "When true and `shopperReference` is provided, the payment details will be tokenized for payouts.")
    public Boolean isEnablePayOut() {
        return enablePayOut;
    }

    public void setEnablePayOut(Boolean enablePayOut) {
        this.enablePayOut = enablePayOut;
    }

    public PaymentsRequest enableRecurring(Boolean enableRecurring) {
        this.enableRecurring = enableRecurring;
        return this;
    }

    /**
     * When true and &#x60;shopperReference&#x60; is provided, the payment details will be tokenized for recurring payments.
     * @return enableRecurring
     **/
    @Schema(description = "When true and `shopperReference` is provided, the payment details will be tokenized for recurring payments.")
    public Boolean isEnableRecurring() {
        return enableRecurring;
    }

    public void setEnableRecurring(Boolean enableRecurring) {
        this.enableRecurring = enableRecurring;
    }

    public PaymentsRequest entityType(EntityTypeEnum entityType) {
        this.entityType = entityType;
        return this;
    }

    /**
     * The type of the entity the payment is processed for.
     * @return entityType
     **/
    @Schema(description = "The type of the entity the payment is processed for.")
    public EntityTypeEnum getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityTypeEnum entityType) {
        this.entityType = entityType;
    }

    public PaymentsRequest fraudOffset(Integer fraudOffset) {
        this.fraudOffset = fraudOffset;
        return this;
    }

    /**
     * An integer value that is added to the normal fraud score. The value can be either positive or negative.
     * @return fraudOffset
     **/
    @Schema(description = "An integer value that is added to the normal fraud score. The value can be either positive or negative.")
    public Integer getFraudOffset() {
        return fraudOffset;
    }

    public void setFraudOffset(Integer fraudOffset) {
        this.fraudOffset = fraudOffset;
    }

    public PaymentsRequest installments(Installments installments) {
        this.installments = installments;
        return this;
    }

    /**
     * Get installments
     * @return installments
     **/
    @Schema(description = "")
    public Installments getInstallments() {
        return installments;
    }

    public void setInstallments(Installments installments) {
        this.installments = installments;
    }

    public PaymentsRequest lineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
        return this;
    }

    public PaymentsRequest addLineItemsItem(LineItem lineItemsItem) {
        if (this.lineItems == null) {
            this.lineItems = new ArrayList<LineItem>();
        }
        this.lineItems.add(lineItemsItem);
        return this;
    }

    /**
     * Price and product information about the purchased items, to be included on the invoice sent to the shopper. &gt; This field is required for 3x 4x Oney, Affirm, Afterpay, Clearpay, Klarna, Ratepay, Zip and Atome.
     * @return lineItems
     **/
    @Schema(description = "Price and product information about the purchased items, to be included on the invoice sent to the shopper. > This field is required for 3x 4x Oney, Affirm, Afterpay, Clearpay, Klarna, Ratepay, Zip and Atome.")
    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public PaymentsRequest mandate(Mandate mandate) {
        this.mandate = mandate;
        return this;
    }

    /**
     * Get mandate
     * @return mandate
     **/
    @Schema(description = "")
    public Mandate getMandate() {
        return mandate;
    }

    public void setMandate(Mandate mandate) {
        this.mandate = mandate;
    }

    public PaymentsRequest mcc(String mcc) {
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

    public PaymentsRequest merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    /**
     * The merchant account identifier, with which you want to process the transaction.
     * @return merchantAccount
     **/
    @Schema(required = true, description = "The merchant account identifier, with which you want to process the transaction.")
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public PaymentsRequest merchantOrderReference(String merchantOrderReference) {
        this.merchantOrderReference = merchantOrderReference;
        return this;
    }

    /**
     * This reference allows linking multiple transactions to each other for reporting purposes (i.e. order auth-rate). The reference should be unique per billing cycle. The same merchant order reference should never be reused after the first authorised attempt. If used, this field should be supplied for all incoming authorisations. &gt; We strongly recommend you send the &#x60;merchantOrderReference&#x60; value to benefit from linking payment requests when authorisation retries take place. In addition, we recommend you provide &#x60;retry.orderAttemptNumber&#x60;, &#x60;retry.chainAttemptNumber&#x60;, and &#x60;retry.skipRetry&#x60; values in &#x60;paymentsRequest.additionalData&#x60;.
     * @return merchantOrderReference
     **/
    @Schema(description = "This reference allows linking multiple transactions to each other for reporting purposes (i.e. order auth-rate). The reference should be unique per billing cycle. The same merchant order reference should never be reused after the first authorised attempt. If used, this field should be supplied for all incoming authorisations. > We strongly recommend you send the `merchantOrderReference` value to benefit from linking payment requests when authorisation retries take place. In addition, we recommend you provide `retry.orderAttemptNumber`, `retry.chainAttemptNumber`, and `retry.skipRetry` values in `paymentsRequest.additionalData`.")
    public String getMerchantOrderReference() {
        return merchantOrderReference;
    }

    public void setMerchantOrderReference(String merchantOrderReference) {
        this.merchantOrderReference = merchantOrderReference;
    }

    public PaymentsRequest merchantRiskIndicator(MerchantRiskIndicator merchantRiskIndicator) {
        this.merchantRiskIndicator = merchantRiskIndicator;
        return this;
    }

    /**
     * Get merchantRiskIndicator
     * @return merchantRiskIndicator
     **/
    @Schema(description = "")
    public MerchantRiskIndicator getMerchantRiskIndicator() {
        return merchantRiskIndicator;
    }

    public void setMerchantRiskIndicator(MerchantRiskIndicator merchantRiskIndicator) {
        this.merchantRiskIndicator = merchantRiskIndicator;
    }

    public PaymentsRequest metadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }

    public PaymentsRequest putMetadataItem(String key, String metadataItem) {
        if (this.metadata == null) {
            this.metadata = new HashMap<String, String>();
        }
        this.metadata.put(key, metadataItem);
        return this;
    }

    /**
     * Metadata consists of entries, each of which includes a key and a value. Limits: * Maximum 20 key-value pairs per request. When exceeding, the \&quot;177\&quot; error occurs: \&quot;Metadata size exceeds limit\&quot;. * Maximum 20 characters per key. * Maximum 80 characters per value.
     * @return metadata
     **/
    @Schema(description = "Metadata consists of entries, each of which includes a key and a value. Limits: * Maximum 20 key-value pairs per request. When exceeding, the \"177\" error occurs: \"Metadata size exceeds limit\". * Maximum 20 characters per key. * Maximum 80 characters per value. ")
    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public PaymentsRequest mpiData(ThreeDSecureData mpiData) {
        this.mpiData = mpiData;
        return this;
    }

    /**
     * Get mpiData
     * @return mpiData
     **/
    @Schema(description = "")
    public ThreeDSecureData getMpiData() {
        return mpiData;
    }

    public void setMpiData(ThreeDSecureData mpiData) {
        this.mpiData = mpiData;
    }

    public PaymentsRequest order(CheckoutOrder order) {
        this.order = order;
        return this;
    }

    /**
     * Get order
     * @return order
     **/
    @Schema(description = "")
    public CheckoutOrder getOrder() {
        return order;
    }

    public void setOrder(CheckoutOrder order) {
        this.order = order;
    }

    public PaymentsRequest orderReference(String orderReference) {
        this.orderReference = orderReference;
        return this;
    }

    /**
     * When you are doing multiple partial (gift card) payments, this is the &#x60;pspReference&#x60; of the first payment. We use this to link the multiple payments to each other. As your own reference for linking multiple payments, use the &#x60;merchantOrderReference&#x60;instead.
     * @return orderReference
     **/
    @Schema(description = "When you are doing multiple partial (gift card) payments, this is the `pspReference` of the first payment. We use this to link the multiple payments to each other. As your own reference for linking multiple payments, use the `merchantOrderReference`instead.")
    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public PaymentsRequest origin(String origin) {
        this.origin = origin;
        return this;
    }

    /**
     * Required for the 3D Secure 2 &#x60;channel&#x60; **Web** integration.  Set this parameter to the origin URL of the page that you are loading the 3D Secure Component from.
     * @return origin
     **/
    @Schema(description = "Required for the 3D Secure 2 `channel` **Web** integration.  Set this parameter to the origin URL of the page that you are loading the 3D Secure Component from.")
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public PaymentsRequest paymentMethod(PaymentMethodDetails paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    /**
     * The type and required details of a payment method to use.
     * @return paymentMethod
     **/
    @Schema(required = true, description = "The type and required details of a payment method to use.")
    public PaymentMethodDetails getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodDetails paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentsRequest recurringExpiry(String recurringExpiry) {
        this.recurringExpiry = recurringExpiry;
        return this;
    }

    /**
     * Date after which no further authorisations shall be performed. Only for 3D Secure 2.
     * @return recurringExpiry
     **/
    @Schema(description = "Date after which no further authorisations shall be performed. Only for 3D Secure 2.")
    public String getRecurringExpiry() {
        return recurringExpiry;
    }

    public void setRecurringExpiry(String recurringExpiry) {
        this.recurringExpiry = recurringExpiry;
    }

    public PaymentsRequest recurringFrequency(String recurringFrequency) {
        this.recurringFrequency = recurringFrequency;
        return this;
    }

    /**
     * Minimum number of days between authorisations. Only for 3D Secure 2.
     * @return recurringFrequency
     **/
    @Schema(description = "Minimum number of days between authorisations. Only for 3D Secure 2.")
    public String getRecurringFrequency() {
        return recurringFrequency;
    }

    public void setRecurringFrequency(String recurringFrequency) {
        this.recurringFrequency = recurringFrequency;
    }

    public PaymentsRequest recurringProcessingModel(RecurringProcessingModelEnum recurringProcessingModel) {
        this.recurringProcessingModel = recurringProcessingModel;
        return this;
    }

    /**
     * Defines a recurring payment type. Allowed values: * &#x60;Subscription&#x60; – A transaction for a fixed or variable amount, which follows a fixed schedule. * &#x60;CardOnFile&#x60; – With a card-on-file (CoF) transaction, card details are stored to enable one-click or omnichannel journeys, or simply to streamline the checkout process. Any subscription not following a fixed schedule is also considered a card-on-file transaction. * &#x60;UnscheduledCardOnFile&#x60; – An unscheduled card-on-file (UCoF) transaction is a transaction that occurs on a non-fixed schedule and/or have variable amounts. For example, automatic top-ups when a cardholder&#x27;s balance drops below a certain amount.
     * @return recurringProcessingModel
     **/
    @Schema(description = "Defines a recurring payment type. Allowed values: * `Subscription` – A transaction for a fixed or variable amount, which follows a fixed schedule. * `CardOnFile` – With a card-on-file (CoF) transaction, card details are stored to enable one-click or omnichannel journeys, or simply to streamline the checkout process. Any subscription not following a fixed schedule is also considered a card-on-file transaction. * `UnscheduledCardOnFile` – An unscheduled card-on-file (UCoF) transaction is a transaction that occurs on a non-fixed schedule and/or have variable amounts. For example, automatic top-ups when a cardholder's balance drops below a certain amount. ")
    public RecurringProcessingModelEnum getRecurringProcessingModel() {
        return recurringProcessingModel;
    }

    public void setRecurringProcessingModel(RecurringProcessingModelEnum recurringProcessingModel) {
        this.recurringProcessingModel = recurringProcessingModel;
    }

    public PaymentsRequest redirectFromIssuerMethod(String redirectFromIssuerMethod) {
        this.redirectFromIssuerMethod = redirectFromIssuerMethod;
        return this;
    }

    /**
     * Specifies the redirect method (GET or POST) when redirecting back from the issuer.
     * @return redirectFromIssuerMethod
     **/
    @Schema(description = "Specifies the redirect method (GET or POST) when redirecting back from the issuer.")
    public String getRedirectFromIssuerMethod() {
        return redirectFromIssuerMethod;
    }

    public void setRedirectFromIssuerMethod(String redirectFromIssuerMethod) {
        this.redirectFromIssuerMethod = redirectFromIssuerMethod;
    }

    public PaymentsRequest redirectToIssuerMethod(String redirectToIssuerMethod) {
        this.redirectToIssuerMethod = redirectToIssuerMethod;
        return this;
    }

    /**
     * Specifies the redirect method (GET or POST) when redirecting to the issuer.
     * @return redirectToIssuerMethod
     **/
    @Schema(description = "Specifies the redirect method (GET or POST) when redirecting to the issuer.")
    public String getRedirectToIssuerMethod() {
        return redirectToIssuerMethod;
    }

    public void setRedirectToIssuerMethod(String redirectToIssuerMethod) {
        this.redirectToIssuerMethod = redirectToIssuerMethod;
    }

    public PaymentsRequest reference(String reference) {
        this.reference = reference;
        return this;
    }

    /**
     * The reference to uniquely identify a payment. This reference is used in all communication with you about the payment status. We recommend using a unique value per payment; however, it is not a requirement. If you need to provide multiple references for a transaction, separate them with hyphens (\&quot;-\&quot;). Maximum length: 80 characters.
     * @return reference
     **/
    @Schema(required = true, description = "The reference to uniquely identify a payment. This reference is used in all communication with you about the payment status. We recommend using a unique value per payment; however, it is not a requirement. If you need to provide multiple references for a transaction, separate them with hyphens (\"-\"). Maximum length: 80 characters.")
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public PaymentsRequest returnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
        return this;
    }

    /**
     * The URL to return to in case of a redirection. The format depends on the channel. This URL can have a maximum of 1024 characters. * For web, include the protocol &#x60;http://&#x60; or &#x60;https://&#x60;. You can also include your own additional query parameters, for example, shopper ID or order reference number. Example: &#x60;https://your-company.com/checkout?shopperOrder&#x3D;12xy&#x60; * For iOS, use the custom URL for your app. To know more about setting custom URL schemes, refer to the [Apple Developer documentation](https://developer.apple.com/documentation/uikit/inter-process_communication/allowing_apps_and_websites_to_link_to_your_content/defining_a_custom_url_scheme_for_your_app). Example: &#x60;my-app://&#x60; * For Android, use a custom URL handled by an Activity on your app. You can configure it with an [intent filter](https://developer.android.com/guide/components/intents-filters). Example: &#x60;my-app://your.package.name&#x60;
     * @return returnUrl
     **/
    @Schema(required = true, description = "The URL to return to in case of a redirection. The format depends on the channel. This URL can have a maximum of 1024 characters. * For web, include the protocol `http://` or `https://`. You can also include your own additional query parameters, for example, shopper ID or order reference number. Example: `https://your-company.com/checkout?shopperOrder=12xy` * For iOS, use the custom URL for your app. To know more about setting custom URL schemes, refer to the [Apple Developer documentation](https://developer.apple.com/documentation/uikit/inter-process_communication/allowing_apps_and_websites_to_link_to_your_content/defining_a_custom_url_scheme_for_your_app). Example: `my-app://` * For Android, use a custom URL handled by an Activity on your app. You can configure it with an [intent filter](https://developer.android.com/guide/components/intents-filters). Example: `my-app://your.package.name`")
    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public PaymentsRequest riskData(RiskData riskData) {
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

    public PaymentsRequest sessionValidity(String sessionValidity) {
        this.sessionValidity = sessionValidity;
        return this;
    }

    /**
     * The date and time until when the session remains valid, in [ISO 8601](https://www.w3.org/TR/NOTE-datetime) format.  For example: 2020-07-18T15:42:40.428+01:00
     * @return sessionValidity
     **/
    @Schema(description = "The date and time until when the session remains valid, in [ISO 8601](https://www.w3.org/TR/NOTE-datetime) format.  For example: 2020-07-18T15:42:40.428+01:00")
    public String getSessionValidity() {
        return sessionValidity;
    }

    public void setSessionValidity(String sessionValidity) {
        this.sessionValidity = sessionValidity;
    }

    public PaymentsRequest shopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
        return this;
    }

    /**
     * The shopper&#x27;s email address. We recommend that you provide this data, as it is used in velocity fraud checks. &gt; For 3D Secure 2 transactions, schemes require &#x60;shopperEmail&#x60; for all browser-based and mobile implementations.
     * @return shopperEmail
     **/
    @Schema(description = "The shopper's email address. We recommend that you provide this data, as it is used in velocity fraud checks. > For 3D Secure 2 transactions, schemes require `shopperEmail` for all browser-based and mobile implementations.")
    public String getShopperEmail() {
        return shopperEmail;
    }

    public void setShopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
    }

    public PaymentsRequest shopperIP(String shopperIP) {
        this.shopperIP = shopperIP;
        return this;
    }

    /**
     * The shopper&#x27;s IP address. In general, we recommend that you provide this data, as it is used in a number of risk checks (for instance, number of payment attempts or location-based checks). &gt; For 3D Secure 2 transactions, schemes require &#x60;shopperIP&#x60; for all browser-based implementations. This field is also mandatory for some merchants depending on your business model. For more information, [contact Support](https://support.adyen.com/hc/en-us/requests/new).
     * @return shopperIP
     **/
    @Schema(description = "The shopper's IP address. In general, we recommend that you provide this data, as it is used in a number of risk checks (for instance, number of payment attempts or location-based checks). > For 3D Secure 2 transactions, schemes require `shopperIP` for all browser-based implementations. This field is also mandatory for some merchants depending on your business model. For more information, [contact Support](https://support.adyen.com/hc/en-us/requests/new).")
    public String getShopperIP() {
        return shopperIP;
    }

    public void setShopperIP(String shopperIP) {
        this.shopperIP = shopperIP;
    }

    public PaymentsRequest shopperInteraction(ShopperInteractionEnum shopperInteraction) {
        this.shopperInteraction = shopperInteraction;
        return this;
    }

    /**
     * Specifies the sales channel, through which the shopper gives their card details, and whether the shopper is a returning customer. For the web service API, Adyen assumes Ecommerce shopper interaction by default.  This field has the following possible values: * &#x60;Ecommerce&#x60; - Online transactions where the cardholder is present (online). For better authorisation rates, we recommend sending the card security code (CSC) along with the request. * &#x60;ContAuth&#x60; - Card on file and/or subscription transactions, where the cardholder is known to the merchant (returning customer). If the shopper is present (online), you can supply also the CSC to improve authorisation (one-click payment). * &#x60;Moto&#x60; - Mail-order and telephone-order transactions where the shopper is in contact with the merchant via email or telephone. * &#x60;POS&#x60; - Point-of-sale transactions where the shopper is physically present to make a payment using a secure payment terminal.
     * @return shopperInteraction
     **/
    @Schema(description = "Specifies the sales channel, through which the shopper gives their card details, and whether the shopper is a returning customer. For the web service API, Adyen assumes Ecommerce shopper interaction by default.  This field has the following possible values: * `Ecommerce` - Online transactions where the cardholder is present (online). For better authorisation rates, we recommend sending the card security code (CSC) along with the request. * `ContAuth` - Card on file and/or subscription transactions, where the cardholder is known to the merchant (returning customer). If the shopper is present (online), you can supply also the CSC to improve authorisation (one-click payment). * `Moto` - Mail-order and telephone-order transactions where the shopper is in contact with the merchant via email or telephone. * `POS` - Point-of-sale transactions where the shopper is physically present to make a payment using a secure payment terminal.")
    public ShopperInteractionEnum getShopperInteraction() {
        return shopperInteraction;
    }

    public void setShopperInteraction(ShopperInteractionEnum shopperInteraction) {
        this.shopperInteraction = shopperInteraction;
    }

    public PaymentsRequest shopperLocale(String shopperLocale) {
        this.shopperLocale = shopperLocale;
        return this;
    }

    /**
     * The combination of a language code and a country code to specify the language to be used in the payment.
     * @return shopperLocale
     **/
    @Schema(description = "The combination of a language code and a country code to specify the language to be used in the payment.")
    public String getShopperLocale() {
        return shopperLocale;
    }

    public void setShopperLocale(String shopperLocale) {
        this.shopperLocale = shopperLocale;
    }

    public PaymentsRequest shopperName(Name shopperName) {
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

    public PaymentsRequest shopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
        return this;
    }

    /**
     * Required for recurring payments.  Your reference to uniquely identify this shopper, for example user ID or account ID. Minimum length: 3 characters. &gt; Your reference must not include personally identifiable information (PII), for example name or email address.
     * @return shopperReference
     **/
    @Schema(description = "Required for recurring payments.  Your reference to uniquely identify this shopper, for example user ID or account ID. Minimum length: 3 characters. > Your reference must not include personally identifiable information (PII), for example name or email address.")
    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    public PaymentsRequest shopperStatement(String shopperStatement) {
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

    public PaymentsRequest socialSecurityNumber(String socialSecurityNumber) {
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

    public PaymentsRequest splits(List<Split> splits) {
        this.splits = splits;
        return this;
    }

    public PaymentsRequest addSplitsItem(Split splitsItem) {
        if (this.splits == null) {
            this.splits = new ArrayList<Split>();
        }
        this.splits.add(splitsItem);
        return this;
    }

    /**
     * An array of objects specifying how the payment should be split when using [Adyen for Platforms](https://docs.adyen.com/platforms/processing-payments#providing-split-information) or [Issuing](https://docs.adyen.com/issuing/manage-funds#split).
     * @return splits
     **/
    @Schema(description = "An array of objects specifying how the payment should be split when using [Adyen for Platforms](https://docs.adyen.com/platforms/processing-payments#providing-split-information) or [Issuing](https://docs.adyen.com/issuing/manage-funds#split).")
    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public PaymentsRequest store(String store) {
        this.store = store;
        return this;
    }

    /**
     * The ecommerce or point-of-sale store that is processing the payment. Used in [partner arrangement integrations](https://docs.adyen.com/platforms/platforms-for-partners#route-payments) for Adyen for Platforms.
     * @return store
     **/
    @Schema(description = "The ecommerce or point-of-sale store that is processing the payment. Used in [partner arrangement integrations](https://docs.adyen.com/platforms/platforms-for-partners#route-payments) for Adyen for Platforms.")
    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public PaymentsRequest storePaymentMethod(Boolean storePaymentMethod) {
        this.storePaymentMethod = storePaymentMethod;
        return this;
    }

    /**
     * When true and &#x60;shopperReference&#x60; is provided, the payment details will be stored.
     * @return storePaymentMethod
     **/
    @Schema(description = "When true and `shopperReference` is provided, the payment details will be stored.")
    public Boolean isStorePaymentMethod() {
        return storePaymentMethod;
    }

    public void setStorePaymentMethod(Boolean storePaymentMethod) {
        this.storePaymentMethod = storePaymentMethod;
    }

    public PaymentsRequest telephoneNumber(String telephoneNumber) {
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

    public PaymentsRequest threeDS2RequestData(ThreeDS2RequestData threeDS2RequestData) {
        this.threeDS2RequestData = threeDS2RequestData;
        return this;
    }

    /**
     * Get threeDS2RequestData
     * @return threeDS2RequestData
     **/
    @Schema(description = "")
    public ThreeDS2RequestData getThreeDS2RequestData() {
        return threeDS2RequestData;
    }

    public void setThreeDS2RequestData(ThreeDS2RequestData threeDS2RequestData) {
        this.threeDS2RequestData = threeDS2RequestData;
    }

    public PaymentsRequest threeDSAuthenticationOnly(Boolean threeDSAuthenticationOnly) {
        this.threeDSAuthenticationOnly = threeDSAuthenticationOnly;
        return this;
    }

    /**
     * If set to true, you will only perform the [3D Secure 2 authentication](https://docs.adyen.com/online-payments/3d-secure/other-3ds-flows/authentication-only), and not the payment authorisation.
     * @return threeDSAuthenticationOnly
     **/
    @Schema(description = "If set to true, you will only perform the [3D Secure 2 authentication](https://docs.adyen.com/online-payments/3d-secure/other-3ds-flows/authentication-only), and not the payment authorisation.")
    public Boolean isThreeDSAuthenticationOnly() {
        return threeDSAuthenticationOnly;
    }

    public void setThreeDSAuthenticationOnly(Boolean threeDSAuthenticationOnly) {
        this.threeDSAuthenticationOnly = threeDSAuthenticationOnly;
    }

    public PaymentsRequest trustedShopper(Boolean trustedShopper) {
        this.trustedShopper = trustedShopper;
        return this;
    }

    /**
     * Set to true if the payment should be routed to a trusted MID.
     * @return trustedShopper
     **/
    @Schema(description = "Set to true if the payment should be routed to a trusted MID.")
    public Boolean isTrustedShopper() {
        return trustedShopper;
    }

    public void setTrustedShopper(Boolean trustedShopper) {
        this.trustedShopper = trustedShopper;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentsRequest paymentsRequest = (PaymentsRequest) o;
        return Objects.equals(this.accountInfo, paymentsRequest.accountInfo) &&
                Objects.equals(this.additionalData, paymentsRequest.additionalData) &&
                Objects.equals(this.amount, paymentsRequest.amount) &&
                Objects.equals(this.applicationInfo, paymentsRequest.applicationInfo) &&
                Objects.equals(this.authenticationData, paymentsRequest.authenticationData) &&
                Objects.equals(this.billingAddress, paymentsRequest.billingAddress) &&
                Objects.equals(this.browserInfo, paymentsRequest.browserInfo) &&
                Objects.equals(this.captureDelayHours, paymentsRequest.captureDelayHours) &&
                Objects.equals(this.channel, paymentsRequest.channel) &&
                Objects.equals(this.checkoutAttemptId, paymentsRequest.checkoutAttemptId) &&
                Objects.equals(this.company, paymentsRequest.company) &&
                Objects.equals(this.conversionId, paymentsRequest.conversionId) &&
                Objects.equals(this.countryCode, paymentsRequest.countryCode) &&
                Objects.equals(this.dateOfBirth, paymentsRequest.dateOfBirth) &&
                Objects.equals(this.dccQuote, paymentsRequest.dccQuote) &&
                Objects.equals(this.deliveryAddress, paymentsRequest.deliveryAddress) &&
                Objects.equals(this.deliveryDate, paymentsRequest.deliveryDate) &&
                Objects.equals(this.deviceFingerprint, paymentsRequest.deviceFingerprint) &&
                Objects.equals(this.enableOneClick, paymentsRequest.enableOneClick) &&
                Objects.equals(this.enablePayOut, paymentsRequest.enablePayOut) &&
                Objects.equals(this.enableRecurring, paymentsRequest.enableRecurring) &&
                Objects.equals(this.entityType, paymentsRequest.entityType) &&
                Objects.equals(this.fraudOffset, paymentsRequest.fraudOffset) &&
                Objects.equals(this.installments, paymentsRequest.installments) &&
                Objects.equals(this.lineItems, paymentsRequest.lineItems) &&
                Objects.equals(this.mandate, paymentsRequest.mandate) &&
                Objects.equals(this.mcc, paymentsRequest.mcc) &&
                Objects.equals(this.merchantAccount, paymentsRequest.merchantAccount) &&
                Objects.equals(this.merchantOrderReference, paymentsRequest.merchantOrderReference) &&
                Objects.equals(this.merchantRiskIndicator, paymentsRequest.merchantRiskIndicator) &&
                Objects.equals(this.metadata, paymentsRequest.metadata) &&
                Objects.equals(this.mpiData, paymentsRequest.mpiData) &&
                Objects.equals(this.order, paymentsRequest.order) &&
                Objects.equals(this.orderReference, paymentsRequest.orderReference) &&
                Objects.equals(this.origin, paymentsRequest.origin) &&
                Objects.equals(this.paymentMethod, paymentsRequest.paymentMethod) &&
                Objects.equals(this.recurringExpiry, paymentsRequest.recurringExpiry) &&
                Objects.equals(this.recurringFrequency, paymentsRequest.recurringFrequency) &&
                Objects.equals(this.recurringProcessingModel, paymentsRequest.recurringProcessingModel) &&
                Objects.equals(this.redirectFromIssuerMethod, paymentsRequest.redirectFromIssuerMethod) &&
                Objects.equals(this.redirectToIssuerMethod, paymentsRequest.redirectToIssuerMethod) &&
                Objects.equals(this.reference, paymentsRequest.reference) &&
                Objects.equals(this.returnUrl, paymentsRequest.returnUrl) &&
                Objects.equals(this.riskData, paymentsRequest.riskData) &&
                Objects.equals(this.sessionValidity, paymentsRequest.sessionValidity) &&
                Objects.equals(this.shopperEmail, paymentsRequest.shopperEmail) &&
                Objects.equals(this.shopperIP, paymentsRequest.shopperIP) &&
                Objects.equals(this.shopperInteraction, paymentsRequest.shopperInteraction) &&
                Objects.equals(this.shopperLocale, paymentsRequest.shopperLocale) &&
                Objects.equals(this.shopperName, paymentsRequest.shopperName) &&
                Objects.equals(this.shopperReference, paymentsRequest.shopperReference) &&
                Objects.equals(this.shopperStatement, paymentsRequest.shopperStatement) &&
                Objects.equals(this.socialSecurityNumber, paymentsRequest.socialSecurityNumber) &&
                Objects.equals(this.splits, paymentsRequest.splits) &&
                Objects.equals(this.store, paymentsRequest.store) &&
                Objects.equals(this.storePaymentMethod, paymentsRequest.storePaymentMethod) &&
                Objects.equals(this.telephoneNumber, paymentsRequest.telephoneNumber) &&
                Objects.equals(this.threeDS2RequestData, paymentsRequest.threeDS2RequestData) &&
                Objects.equals(this.threeDSAuthenticationOnly, paymentsRequest.threeDSAuthenticationOnly) &&
                Objects.equals(this.trustedShopper, paymentsRequest.trustedShopper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountInfo, additionalData, amount, applicationInfo, authenticationData, billingAddress, browserInfo, captureDelayHours, channel, checkoutAttemptId, company, conversionId, countryCode, dateOfBirth, dccQuote, deliveryAddress, deliveryDate, deviceFingerprint, enableOneClick, enablePayOut, enableRecurring, entityType, fraudOffset, installments, lineItems, mandate, mcc, merchantAccount, merchantOrderReference, merchantRiskIndicator, metadata, mpiData, order, orderReference, origin, paymentMethod, recurringExpiry, recurringFrequency, recurringProcessingModel, redirectFromIssuerMethod, redirectToIssuerMethod, reference, returnUrl, riskData, sessionValidity, shopperEmail, shopperIP, shopperInteraction, shopperLocale, shopperName, shopperReference, shopperStatement, socialSecurityNumber, splits, store, storePaymentMethod, telephoneNumber, threeDS2RequestData, threeDSAuthenticationOnly, trustedShopper);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentRequest {\n");

        sb.append("    accountInfo: ").append(toIndentedString(accountInfo)).append("\n");
        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    applicationInfo: ").append(toIndentedString(applicationInfo)).append("\n");
        sb.append("    authenticationData: ").append(toIndentedString(authenticationData)).append("\n");
        sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
        sb.append("    browserInfo: ").append(toIndentedString(browserInfo)).append("\n");
        sb.append("    captureDelayHours: ").append(toIndentedString(captureDelayHours)).append("\n");
        sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
        sb.append("    checkoutAttemptId: ").append(toIndentedString(checkoutAttemptId)).append("\n");
        sb.append("    company: ").append(toIndentedString(company)).append("\n");
        sb.append("    conversionId: ").append(toIndentedString(conversionId)).append("\n");
        sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
        sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
        sb.append("    dccQuote: ").append(toIndentedString(dccQuote)).append("\n");
        sb.append("    deliveryAddress: ").append(toIndentedString(deliveryAddress)).append("\n");
        sb.append("    deliveryDate: ").append(toIndentedString(deliveryDate)).append("\n");
        sb.append("    deviceFingerprint: ").append(toIndentedString(deviceFingerprint)).append("\n");
        sb.append("    enableOneClick: ").append(toIndentedString(enableOneClick)).append("\n");
        sb.append("    enablePayOut: ").append(toIndentedString(enablePayOut)).append("\n");
        sb.append("    enableRecurring: ").append(toIndentedString(enableRecurring)).append("\n");
        sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
        sb.append("    fraudOffset: ").append(toIndentedString(fraudOffset)).append("\n");
        sb.append("    installments: ").append(toIndentedString(installments)).append("\n");
        sb.append("    lineItems: ").append(toIndentedString(lineItems)).append("\n");
        sb.append("    mandate: ").append(toIndentedString(mandate)).append("\n");
        sb.append("    mcc: ").append(toIndentedString(mcc)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    merchantOrderReference: ").append(toIndentedString(merchantOrderReference)).append("\n");
        sb.append("    merchantRiskIndicator: ").append(toIndentedString(merchantRiskIndicator)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    mpiData: ").append(toIndentedString(mpiData)).append("\n");
        sb.append("    order: ").append(toIndentedString(order)).append("\n");
        sb.append("    orderReference: ").append(toIndentedString(orderReference)).append("\n");
        sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
        sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
        sb.append("    recurringExpiry: ").append(toIndentedString(recurringExpiry)).append("\n");
        sb.append("    recurringFrequency: ").append(toIndentedString(recurringFrequency)).append("\n");
        sb.append("    recurringProcessingModel: ").append(toIndentedString(recurringProcessingModel)).append("\n");
        sb.append("    redirectFromIssuerMethod: ").append(toIndentedString(redirectFromIssuerMethod)).append("\n");
        sb.append("    redirectToIssuerMethod: ").append(toIndentedString(redirectToIssuerMethod)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    returnUrl: ").append(toIndentedString(returnUrl)).append("\n");
        sb.append("    riskData: ").append(toIndentedString(riskData)).append("\n");
        sb.append("    sessionValidity: ").append(toIndentedString(sessionValidity)).append("\n");
        sb.append("    shopperEmail: ").append(toIndentedString(shopperEmail)).append("\n");
        sb.append("    shopperIP: ").append(toIndentedString(shopperIP)).append("\n");
        sb.append("    shopperInteraction: ").append(toIndentedString(shopperInteraction)).append("\n");
        sb.append("    shopperLocale: ").append(toIndentedString(shopperLocale)).append("\n");
        sb.append("    shopperName: ").append(toIndentedString(shopperName)).append("\n");
        sb.append("    shopperReference: ").append(toIndentedString(shopperReference)).append("\n");
        sb.append("    shopperStatement: ").append(toIndentedString(shopperStatement)).append("\n");
        sb.append("    socialSecurityNumber: ").append(toIndentedString(socialSecurityNumber)).append("\n");
        sb.append("    splits: ").append(toIndentedString(splits)).append("\n");
        sb.append("    store: ").append(toIndentedString(store)).append("\n");
        sb.append("    storePaymentMethod: ").append(toIndentedString(storePaymentMethod)).append("\n");
        sb.append("    telephoneNumber: ").append(toIndentedString(telephoneNumber)).append("\n");
        sb.append("    threeDS2RequestData: ").append(toIndentedString(threeDS2RequestData)).append("\n");
        sb.append("    threeDSAuthenticationOnly: ").append(toIndentedString(threeDSAuthenticationOnly)).append("\n");
        sb.append("    trustedShopper: ").append(toIndentedString(trustedShopper)).append("\n");
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


