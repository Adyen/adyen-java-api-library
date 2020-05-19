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

package com.adyen.model.payout;

import com.adyen.model.AccountInfo;
import com.adyen.model.Address;
import com.adyen.model.Amount;
import com.adyen.model.BankAccount;
import com.adyen.model.BrowserInfo;
import com.adyen.model.Card;
import com.adyen.model.ForexQuote;
import com.adyen.model.Installments;
import com.adyen.model.MerchantRiskIndicator;
import com.adyen.model.Name;
import com.adyen.model.Split;
import com.adyen.model.ThreeDS2RequestData;
import com.adyen.model.ThreeDSecureData;
import com.adyen.model.applicationinfo.ApplicationInfo;
import com.adyen.model.recurring.Recurring;
import com.adyen.serializer.DateSerializer;
import com.adyen.serializer.DateTimeGMTSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * PayoutRequest
 */

public class PayoutRequest {
    @SerializedName("accountInfo")
    private AccountInfo accountInfo = null;

    @SerializedName("additionalAmount")
    private Amount additionalAmount = null;

    @SerializedName("additionalData")
    private Map<String, String> additionalData = null;

    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("applicationInfo")
    private ApplicationInfo applicationInfo = null;

    @SerializedName("bankAccount")
    private BankAccount bankAccount = null;

    @SerializedName("billingAddress")
    private Address billingAddress = null;

    @SerializedName("browserInfo")
    private BrowserInfo browserInfo = null;

    @SerializedName("captureDelayHours")
    private Integer captureDelayHours = null;

    @SerializedName("card")
    private Card card = null;

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

    @SerializedName("enableRealTimeUpdate")
    private Boolean enableRealTimeUpdate = null;

    /**
     * The type of the entity the payment is processed for.
     */
    @JsonAdapter(EntityTypeEnum.Adapter.class)
    public enum EntityTypeEnum {
        NATURALPERSON("NaturalPerson"),
        COMPANYNAME("CompanyName");

        private String value;

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

        public static EntityTypeEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<EntityTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final EntityTypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public EntityTypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return EntityTypeEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("entityType")
    private EntityTypeEnum entityType = null;

    @SerializedName("fraudOffset")
    private Integer fraudOffset = null;

    @SerializedName("fundSource")
    private FundSource fundSource = null;

    @SerializedName("installments")
    private Installments installments = null;

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

    @SerializedName("nationality")
    private String nationality = null;

    @SerializedName("orderReference")
    private String orderReference = null;

    @SerializedName("recurring")
    private Recurring recurring = null;

    /**
     * Defines a recurring payment type. Allowed values: * &#x60;Subscription&#x60; – A transaction for a fixed or variable amount, which follows a fixed schedule. * &#x60;CardOnFile&#x60; – Card details are stored to enable one-click or omnichannel journeys, or simply to streamline the checkout process. Any subscription not following a fixed schedule is also considered a card-on-file transaction.
     */
    @JsonAdapter(RecurringProcessingModelEnum.Adapter.class)
    public enum RecurringProcessingModelEnum {
        CARDONFILE("CardOnFile"),
        SUBSCRIPTION("Subscription");

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
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
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

    @SerializedName("selectedBrand")
    private String selectedBrand = null;

    @SerializedName("selectedRecurringDetailReference")
    private String selectedRecurringDetailReference = null;

    @SerializedName("sessionId")
    private String sessionId = null;

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

        private String value;

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

        public static ShopperInteractionEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<ShopperInteractionEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ShopperInteractionEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public ShopperInteractionEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return ShopperInteractionEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("shopperInteraction")
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

    @SerializedName("telephoneNumber")
    private String telephoneNumber = null;

    @SerializedName("threeDS2RequestData")
    private ThreeDS2RequestData threeDS2RequestData = null;

    @SerializedName("threeDSAuthenticationOnly")
    private Boolean threeDSAuthenticationOnly = null;

    @SerializedName("totalsGroup")
    private String totalsGroup = null;

    @SerializedName("trustedShopper")
    private Boolean trustedShopper = null;

    public PayoutRequest accountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
        return this;
    }

    /**
     * Get accountInfo
     * @return accountInfo
     **/
    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public PayoutRequest additionalAmount(Amount additionalAmount) {
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

    public PayoutRequest additionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
        return this;
    }

    /**
     * This field contains additional data, which may be required for a particular payment request.  The &#x60;additionalData&#x60; object consists of entries, each of which includes the key and value. For more information on possible key-value pairs, refer to the [additionalData section](https://docs.adyen.com/api-reference/payments-api#paymentrequestadditionaldata).
     *
     * @return additionalData
     **/
    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    public PayoutRequest amount(Amount amount) {
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

    public PayoutRequest applicationInfo(ApplicationInfo applicationInfo) {
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

    public PayoutRequest bankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    /**
     * Get bankAccount
     *
     * @return bankAccount
     **/
    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public PayoutRequest billingAddress(Address billingAddress) {
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

    public PayoutRequest browserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
        return this;
    }

    /**
     * Get browserInfo
     *
     * @return browserInfo
     **/
    public BrowserInfo getBrowserInfo() {
        return browserInfo;
    }

    public void setBrowserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
    }

    public PayoutRequest captureDelayHours(Integer captureDelayHours) {
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

    public PayoutRequest card(Card card) {
        this.card = card;
        return this;
    }

    /**
     * Get card
     *
     * @return card
     **/
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public PayoutRequest dateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    /**
     * The shopper&#x27;s date of birth.  Format [ISO-8601](https://www.w3.org/TR/NOTE-datetime): YYYY-MM-DD
     *
     * @return dateOfBirth
     **/
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public PayoutRequest dccQuote(ForexQuote dccQuote) {
        this.dccQuote = dccQuote;
        return this;
    }

    /**
     * Get dccQuote
     *
     * @return dccQuote
     **/
    public ForexQuote getDccQuote() {
        return dccQuote;
    }

    public void setDccQuote(ForexQuote dccQuote) {
        this.dccQuote = dccQuote;
    }

    public PayoutRequest deliveryAddress(Address deliveryAddress) {
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

    public PayoutRequest deliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }

    /**
     * The date and time the purchased goods should be delivered.  Format [ISO 8601](https://www.w3.org/TR/NOTE-datetime): YYYY-MM-DDThh:mm:ss.sssTZD  Example: 2017-07-17T13:42:40.428+01:00
     *
     * @return deliveryDate
     **/
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public PayoutRequest deviceFingerprint(String deviceFingerprint) {
        this.deviceFingerprint = deviceFingerprint;
        return this;
    }

    /**
     * A string containing the shopper&#x27;s device fingerprint. For more information, refer to [Device fingerprinting](https://docs.adyen.com/risk-management/device-fingerprinting).
     *
     * @return deviceFingerprint
     **/
    public String getDeviceFingerprint() {
        return deviceFingerprint;
    }

    public void setDeviceFingerprint(String deviceFingerprint) {
        this.deviceFingerprint = deviceFingerprint;
    }

    public PayoutRequest enableRealTimeUpdate(Boolean enableRealTimeUpdate) {
        this.enableRealTimeUpdate = enableRealTimeUpdate;
        return this;
    }

    /**
     * Choose if a specific transaction should use the Real-time Account Updater, regardless of other settings.
     * @return enableRealTimeUpdate
     **/
    public Boolean isEnableRealTimeUpdate() {
        return enableRealTimeUpdate;
    }

    public void setEnableRealTimeUpdate(Boolean enableRealTimeUpdate) {
        this.enableRealTimeUpdate = enableRealTimeUpdate;
    }

    public PayoutRequest entityType(EntityTypeEnum entityType) {
        this.entityType = entityType;
        return this;
    }

    /**
     * The type of the entity the payment is processed for.
     *
     * @return entityType
     **/
    public EntityTypeEnum getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityTypeEnum entityType) {
        this.entityType = entityType;
    }

    public PayoutRequest fraudOffset(Integer fraudOffset) {
        this.fraudOffset = fraudOffset;
        return this;
    }

    /**
     * An integer value that is added to the normal fraud score. The value can be either positive or negative.
     *
     * @return fraudOffset
     **/
    public Integer getFraudOffset() {
        return fraudOffset;
    }

    public void setFraudOffset(Integer fraudOffset) {
        this.fraudOffset = fraudOffset;
    }

    public PayoutRequest fundSource(FundSource fundSource) {
        this.fundSource = fundSource;
        return this;
    }

    /**
     * Get fundSource
     *
     * @return fundSource
     **/
    public FundSource getFundSource() {
        return fundSource;
    }

    public void setFundSource(FundSource fundSource) {
        this.fundSource = fundSource;
    }

    public PayoutRequest installments(Installments installments) {
        this.installments = installments;
        return this;
    }

    /**
     * Get installments
     *
     * @return installments
     **/
    public Installments getInstallments() {
        return installments;
    }

    public void setInstallments(Installments installments) {
        this.installments = installments;
    }

    public PayoutRequest mcc(String mcc) {
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

    public PayoutRequest merchantAccount(String merchantAccount) {
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

    public PayoutRequest merchantOrderReference(String merchantOrderReference) {
        this.merchantOrderReference = merchantOrderReference;
        return this;
    }

    /**
     * This reference allows linking multiple transactions to each other. &gt; We strongly recommend you send the &#x60;merchantOrderReference&#x60; value to benefit from linking payment requests when authorisation retries take place. In addition, we recommend you provide &#x60;retry.orderAttemptNumber&#x60;, &#x60;retry.chainAttemptNumber&#x60;, and &#x60;retry.skipRetry&#x60; values in &#x60;PaymentRequest.additionalData&#x60;.
     *
     * @return merchantOrderReference
     **/
    public String getMerchantOrderReference() {
        return merchantOrderReference;
    }

    public void setMerchantOrderReference(String merchantOrderReference) {
        this.merchantOrderReference = merchantOrderReference;
    }

    public PayoutRequest merchantRiskIndicator(MerchantRiskIndicator merchantRiskIndicator) {
        this.merchantRiskIndicator = merchantRiskIndicator;
        return this;
    }

    /**
     * Get merchantRiskIndicator
     * @return merchantRiskIndicator
     **/
    public MerchantRiskIndicator getMerchantRiskIndicator() {
        return merchantRiskIndicator;
    }

    public void setMerchantRiskIndicator(MerchantRiskIndicator merchantRiskIndicator) {
        this.merchantRiskIndicator = merchantRiskIndicator;
    }

    public PayoutRequest metadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Metadata consists of entries, each of which includes a key and a value. Limitations: Error \&quot;177\&quot;, \&quot;Metadata size exceeds limit\&quot;
     *
     * @return metadata
     **/
    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public PayoutRequest mpiData(ThreeDSecureData mpiData) {
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

    public PayoutRequest nationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    /**
     * The two-character country code of the shopper&#x27;s nationality.
     *
     * @return nationality
     **/
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public PayoutRequest orderReference(String orderReference) {
        this.orderReference = orderReference;
        return this;
    }

    /**
     * The order reference to link multiple partial payments.
     *
     * @return orderReference
     **/
    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public PayoutRequest recurring(Recurring recurring) {
        this.recurring = recurring;
        return this;
    }

    /**
     * Get recurring
     *
     * @return recurring
     **/
    public Recurring getRecurring() {
        return recurring;
    }

    public void setRecurring(Recurring recurring) {
        this.recurring = recurring;
    }

    public PayoutRequest recurringProcessingModel(RecurringProcessingModelEnum recurringProcessingModel) {
        this.recurringProcessingModel = recurringProcessingModel;
        return this;
    }

    /**
     * Defines a recurring payment type. Allowed values: * &#x60;Subscription&#x60; – A transaction for a fixed or variable amount, which follows a fixed schedule. * &#x60;CardOnFile&#x60; – Card details are stored to enable one-click or omnichannel journeys, or simply to streamline the checkout process. Any subscription not following a fixed schedule is also considered a card-on-file transaction.
     *
     * @return recurringProcessingModel
     **/
    public RecurringProcessingModelEnum getRecurringProcessingModel() {
        return recurringProcessingModel;
    }

    public void setRecurringProcessingModel(RecurringProcessingModelEnum recurringProcessingModel) {
        this.recurringProcessingModel = recurringProcessingModel;
    }

    public PayoutRequest reference(String reference) {
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

    public PayoutRequest selectedBrand(String selectedBrand) {
        this.selectedBrand = selectedBrand;
        return this;
    }

    /**
     * Some payment methods require defining a value for this field to specify how to process the transaction.  For the Bancontact payment method, it can be set to: * &#x60;maestro&#x60; (default), to be processed like a Maestro card, or * &#x60;bcmc&#x60;, to be processed like a Bancontact card.
     *
     * @return selectedBrand
     **/
    public String getSelectedBrand() {
        return selectedBrand;
    }

    public void setSelectedBrand(String selectedBrand) {
        this.selectedBrand = selectedBrand;
    }

    public PayoutRequest selectedRecurringDetailReference(String selectedRecurringDetailReference) {
        this.selectedRecurringDetailReference = selectedRecurringDetailReference;
        return this;
    }

    /**
     * The &#x60;recurringDetailReference&#x60; you want to use for this payment. The value &#x60;LATEST&#x60; can be used to select the most recently stored recurring detail.
     *
     * @return selectedRecurringDetailReference
     **/
    public String getSelectedRecurringDetailReference() {
        return selectedRecurringDetailReference;
    }

    public void setSelectedRecurringDetailReference(String selectedRecurringDetailReference) {
        this.selectedRecurringDetailReference = selectedRecurringDetailReference;
    }

    public PayoutRequest sessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    /**
     * A session ID used to identify a payment session.
     *
     * @return sessionId
     **/
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public PayoutRequest shopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
        return this;
    }

    /**
     * The shopper&#x27;s email address. We recommend that you provide this data, as it is used in velocity fraud checks.
     *
     * @return shopperEmail
     **/
    public String getShopperEmail() {
        return shopperEmail;
    }

    public void setShopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
    }

    public PayoutRequest shopperIP(String shopperIP) {
        this.shopperIP = shopperIP;
        return this;
    }

    /**
     * The shopper&#x27;s IP address. We recommend that you provide this data, as it is used in a number of risk checks (for instance, number of payment attempts or location-based checks). &gt; This field is mandatory for some merchants depending on your business model. For more information, [contact Support](https://support.adyen.com/hc/en-us/requests/new).
     *
     * @return shopperIP
     **/
    public String getShopperIP() {
        return shopperIP;
    }

    public void setShopperIP(String shopperIP) {
        this.shopperIP = shopperIP;
    }

    public PayoutRequest shopperInteraction(ShopperInteractionEnum shopperInteraction) {
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

    public PayoutRequest shopperLocale(String shopperLocale) {
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

    public PayoutRequest shopperName(Name shopperName) {
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

    public PayoutRequest shopperReference(String shopperReference) {
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

    public PayoutRequest shopperStatement(String shopperStatement) {
        this.shopperStatement = shopperStatement;
        return this;
    }

    /**
     * The text to appear on the shopper&#x27;s bank statement.
     *
     * @return shopperStatement
     **/
    public String getShopperStatement() {
        return shopperStatement;
    }

    public void setShopperStatement(String shopperStatement) {
        this.shopperStatement = shopperStatement;
    }

    public PayoutRequest socialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
        return this;
    }

    /**
     * The shopper&#x27;s social security number.
     *
     * @return socialSecurityNumber
     **/
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public PayoutRequest splits(List<Split> splits) {
        this.splits = splits;
        return this;
    }

    public PayoutRequest addSplitsItem(Split splitsItem) {
        if (this.splits == null) {
            this.splits = new ArrayList<>();
        }
        this.splits.add(splitsItem);
        return this;
    }

    /**
     * The details of how the payment should be split when distributing a payment to a MarketPay Marketplace and its Accounts.
     * @return splits
     **/
    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public PayoutRequest store(String store) {
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

    public PayoutRequest telephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    /**
     * The shopper&#x27;s telephone number.
     *
     * @return telephoneNumber
     **/
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public PayoutRequest threeDS2RequestData(ThreeDS2RequestData threeDS2RequestData) {
        this.threeDS2RequestData = threeDS2RequestData;
        return this;
    }

    /**
     * Get threeDS2RequestData
     * @return threeDS2RequestData
     **/
    public ThreeDS2RequestData getThreeDS2RequestData() {
        return threeDS2RequestData;
    }

    public void setThreeDS2RequestData(ThreeDS2RequestData threeDS2RequestData) {
        this.threeDS2RequestData = threeDS2RequestData;
    }

    public PayoutRequest threeDSAuthenticationOnly(Boolean threeDSAuthenticationOnly) {
        this.threeDSAuthenticationOnly = threeDSAuthenticationOnly;
        return this;
    }

    /**
     * If set to true, you will only perform the [3D Secure 2 authentication](https://docs.adyen.com/checkout/3d-secure/native-3ds2/authentication-only), and not the payment authorisation.
     * @return threeDSAuthenticationOnly
     **/
    public Boolean isThreeDSAuthenticationOnly() {
        return threeDSAuthenticationOnly;
    }

    public void setThreeDSAuthenticationOnly(Boolean threeDSAuthenticationOnly) {
        this.threeDSAuthenticationOnly = threeDSAuthenticationOnly;
    }

    public PayoutRequest totalsGroup(String totalsGroup) {
        this.totalsGroup = totalsGroup;
        return this;
    }

    /**
     * The reference value to aggregate sales totals in reporting. When not specified, the store field is used (if available).
     *
     * @return totalsGroup
     **/
    public String getTotalsGroup() {
        return totalsGroup;
    }

    public void setTotalsGroup(String totalsGroup) {
        this.totalsGroup = totalsGroup;
    }


    public PayoutRequest trustedShopper(Boolean trustedShopper) {
        this.trustedShopper = trustedShopper;
        return this;
    }

    /**
     * Set to true if the payment should be routed to a trusted MID.
     * @return trustedShopper
     **/
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
        PayoutRequest payoutRequest = (PayoutRequest) o;
        return Objects.equals(this.accountInfo, payoutRequest.accountInfo) &&
                Objects.equals(this.additionalAmount, payoutRequest.additionalAmount) &&
                Objects.equals(this.additionalData, payoutRequest.additionalData) &&
                Objects.equals(this.amount, payoutRequest.amount) &&
                Objects.equals(this.applicationInfo, payoutRequest.applicationInfo) &&
                Objects.equals(this.bankAccount, payoutRequest.bankAccount) &&
                Objects.equals(this.billingAddress, payoutRequest.billingAddress) &&
                Objects.equals(this.browserInfo, payoutRequest.browserInfo) &&
                Objects.equals(this.captureDelayHours, payoutRequest.captureDelayHours) &&
                Objects.equals(this.card, payoutRequest.card) &&
                Objects.equals(this.dateOfBirth, payoutRequest.dateOfBirth) &&
                Objects.equals(this.dccQuote, payoutRequest.dccQuote) &&
                Objects.equals(this.deliveryAddress, payoutRequest.deliveryAddress) &&
                Objects.equals(this.deliveryDate, payoutRequest.deliveryDate) &&
                Objects.equals(this.deviceFingerprint, payoutRequest.deviceFingerprint) &&
                Objects.equals(this.enableRealTimeUpdate, payoutRequest.enableRealTimeUpdate) &&
                Objects.equals(this.entityType, payoutRequest.entityType) &&
                Objects.equals(this.fraudOffset, payoutRequest.fraudOffset) &&
                Objects.equals(this.fundSource, payoutRequest.fundSource) &&
                Objects.equals(this.installments, payoutRequest.installments) &&
                Objects.equals(this.mcc, payoutRequest.mcc) &&
                Objects.equals(this.merchantAccount, payoutRequest.merchantAccount) &&
                Objects.equals(this.merchantOrderReference, payoutRequest.merchantOrderReference) &&
                Objects.equals(this.merchantRiskIndicator, payoutRequest.merchantRiskIndicator) &&
                Objects.equals(this.metadata, payoutRequest.metadata) &&
                Objects.equals(this.mpiData, payoutRequest.mpiData) &&
                Objects.equals(this.nationality, payoutRequest.nationality) &&
                Objects.equals(this.orderReference, payoutRequest.orderReference) &&
                Objects.equals(this.recurring, payoutRequest.recurring) &&
                Objects.equals(this.recurringProcessingModel, payoutRequest.recurringProcessingModel) &&
                Objects.equals(this.reference, payoutRequest.reference) &&
                Objects.equals(this.selectedBrand, payoutRequest.selectedBrand) &&
                Objects.equals(this.selectedRecurringDetailReference, payoutRequest.selectedRecurringDetailReference) &&
                Objects.equals(this.sessionId, payoutRequest.sessionId) &&
                Objects.equals(this.shopperEmail, payoutRequest.shopperEmail) &&
                Objects.equals(this.shopperIP, payoutRequest.shopperIP) &&
                Objects.equals(this.shopperInteraction, payoutRequest.shopperInteraction) &&
                Objects.equals(this.shopperLocale, payoutRequest.shopperLocale) &&
                Objects.equals(this.shopperName, payoutRequest.shopperName) &&
                Objects.equals(this.shopperReference, payoutRequest.shopperReference) &&
                Objects.equals(this.shopperStatement, payoutRequest.shopperStatement) &&
                Objects.equals(this.socialSecurityNumber, payoutRequest.socialSecurityNumber) &&
                Objects.equals(this.splits, payoutRequest.splits) &&
                Objects.equals(this.store, payoutRequest.store) &&
                Objects.equals(this.telephoneNumber, payoutRequest.telephoneNumber) &&
                Objects.equals(this.threeDS2RequestData, payoutRequest.threeDS2RequestData) &&
                Objects.equals(this.threeDSAuthenticationOnly, payoutRequest.threeDSAuthenticationOnly) &&
                Objects.equals(this.totalsGroup, payoutRequest.totalsGroup) &&
                Objects.equals(this.trustedShopper, payoutRequest.trustedShopper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountInfo, additionalAmount, additionalData, amount, applicationInfo, bankAccount, billingAddress, browserInfo, captureDelayHours, card, dateOfBirth, dccQuote, deliveryAddress, deliveryDate, deviceFingerprint, enableRealTimeUpdate, entityType, fraudOffset, fundSource, installments, mcc, merchantAccount, merchantOrderReference, merchantRiskIndicator, metadata, mpiData, nationality, orderReference, recurring, recurringProcessingModel, reference, selectedBrand, selectedRecurringDetailReference, sessionId, shopperEmail, shopperIP, shopperInteraction, shopperLocale, shopperName, shopperReference, shopperStatement, socialSecurityNumber, splits, store, telephoneNumber, threeDS2RequestData, threeDSAuthenticationOnly, totalsGroup, trustedShopper);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PayoutRequest {\n");

        sb.append("    accountInfo: ").append(toIndentedString(accountInfo)).append("\n");
        sb.append("    additionalAmount: ").append(toIndentedString(additionalAmount)).append("\n");
        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    applicationInfo: ").append(toIndentedString(applicationInfo)).append("\n");
        sb.append("    bankAccount: ").append(toIndentedString(bankAccount)).append("\n");
        sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
        sb.append("    browserInfo: ").append(toIndentedString(browserInfo)).append("\n");
        sb.append("    captureDelayHours: ").append(toIndentedString(captureDelayHours)).append("\n");
        sb.append("    card: ").append(toIndentedString(card)).append("\n");
        sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
        sb.append("    dccQuote: ").append(toIndentedString(dccQuote)).append("\n");
        sb.append("    deliveryAddress: ").append(toIndentedString(deliveryAddress)).append("\n");
        sb.append("    deliveryDate: ").append(toIndentedString(deliveryDate)).append("\n");
        sb.append("    deviceFingerprint: ").append(toIndentedString(deviceFingerprint)).append("\n");
        sb.append("    enableRealTimeUpdate: ").append(toIndentedString(enableRealTimeUpdate)).append("\n");
        sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
        sb.append("    fraudOffset: ").append(toIndentedString(fraudOffset)).append("\n");
        sb.append("    fundSource: ").append(toIndentedString(fundSource)).append("\n");
        sb.append("    installments: ").append(toIndentedString(installments)).append("\n");
        sb.append("    mcc: ").append(toIndentedString(mcc)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    merchantOrderReference: ").append(toIndentedString(merchantOrderReference)).append("\n");
        sb.append("    merchantRiskIndicator: ").append(toIndentedString(merchantRiskIndicator)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    mpiData: ").append(toIndentedString(mpiData)).append("\n");
        sb.append("    nationality: ").append(toIndentedString(nationality)).append("\n");
        sb.append("    orderReference: ").append(toIndentedString(orderReference)).append("\n");
        sb.append("    recurring: ").append(toIndentedString(recurring)).append("\n");
        sb.append("    recurringProcessingModel: ").append(toIndentedString(recurringProcessingModel)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    selectedBrand: ").append(toIndentedString(selectedBrand)).append("\n");
        sb.append("    selectedRecurringDetailReference: ").append(toIndentedString(selectedRecurringDetailReference)).append("\n");
        sb.append("    sessionId: ").append(toIndentedString(sessionId)).append("\n");
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
        sb.append("    telephoneNumber: ").append(toIndentedString(telephoneNumber)).append("\n");
        sb.append("    threeDS2RequestData: ").append(toIndentedString(threeDS2RequestData)).append("\n");
        sb.append("    threeDSAuthenticationOnly: ").append(toIndentedString(threeDSAuthenticationOnly)).append("\n");
        sb.append("    totalsGroup: ").append(toIndentedString(totalsGroup)).append("\n");
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
