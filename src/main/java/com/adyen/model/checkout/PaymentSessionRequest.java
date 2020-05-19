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
import com.adyen.model.applicationinfo.ApplicationInfo;
import com.adyen.model.recurring.Recurring;
import com.adyen.serializer.DateSerializer;
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
import java.util.Objects;

/**
 * PaymentSessionRequest
 */


public class PaymentSessionRequest {

    @SerializedName("accountInfo")
    private AccountInfo accountInfo = null;

    @SerializedName("additionalAmount")
    private Amount additionalAmount = null;

    @SerializedName("additionalData")
    private Object additionalData = null;

    @SerializedName("allowedPaymentMethods")
    private List<String> allowedPaymentMethods = null;

    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("applicationInfo")
    private ApplicationInfo applicationInfo = null;

    @SerializedName("bankAccount")
    private BankAccount bankAccount = null;

    @SerializedName("billingAddress")
    private Address billingAddress = null;

    @SerializedName("blockedPaymentMethods")
    private List<String> blockedPaymentMethods = null;

    @SerializedName("browserInfo")
    private BrowserInfo browserInfo = null;

    @SerializedName("captureDelayHours")
    private Integer captureDelayHours = null;

    @SerializedName("card")
    private Card card = null;


    /**
     * The platform where a payment transaction takes place. This field is optional for filtering out payment methods that are only available on specific platforms. If this value is not set, then we
     * will try to infer it from the &#x60;sdkVersion&#x60; or &#x60;token&#x60;.  Possible values: * iOS * Android * Web
     */
    @JsonAdapter(ChannelEnum.Adapter.class)
    public enum ChannelEnum {

        IOS("iOS"),
        ANDROID("Android"),
        WEB("Web");

        private String value;

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

        public static ChannelEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<ChannelEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ChannelEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public ChannelEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return ChannelEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("channel")
    private ChannelEnum channel = null;

    @SerializedName("company")
    private Company company = null;

    @SerializedName("configId")
    private String configId = null;

    @SerializedName("configuration")
    private ModelConfiguration configuration = null;

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
    private Date deliveryDate = null;

    @SerializedName("deviceFingerprint")
    private String deviceFingerprint = null;

    @SerializedName("enableOneClick")
    private Boolean enableOneClick = null;

    @SerializedName("enablePayOut")
    private Boolean enablePayOut = null;

    @SerializedName("enableRealTimeUpdate")
    private Boolean enableRealTimeUpdate = null;

    @SerializedName("enableRecurring")
    private Boolean enableRecurring = null;

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

    @SerializedName("html")
    private Boolean html = null;

    @SerializedName("installments")
    private Installments installments = null;

    @SerializedName("lineItems")
    private List<LineItem> lineItems = null;

    @SerializedName("mcc")
    private String mcc = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("merchantOrderReference")
    private String merchantOrderReference = null;

    @SerializedName("merchantRiskIndicator")
    private MerchantRiskIndicator merchantRiskIndicator = null;

    @SerializedName("metadata")
    private Object metadata = null;

    @SerializedName("mpiData")
    private ThreeDSecureData mpiData = null;

    @SerializedName("nationality")
    private String nationality = null;

    @SerializedName("orderReference")
    private String orderReference = null;

    @SerializedName("origin")
    private String origin = null;

    @SerializedName("recurring")
    private Recurring recurring = null;

    /**
     * Defines a recurring payment type. Allowed values: * &#x60;Subscription&#x60; – A transaction for a fixed or variable amount, which follows a fixed schedule. * &#x60;CardOnFile&#x60; – Card
     * details are stored to enable one-click or omnichannel journeys, or simply to streamline the checkout process. Any subscription not following a fixed schedule is also considered a card-on-file
     * transaction.
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

    @SerializedName("recurringExpiry")
    private String recurringExpiry = null;

    @SerializedName("recurringFrequency")
    private String recurringFrequency = null;

    @SerializedName("recurringProcessingModel")
    private RecurringProcessingModelEnum recurringProcessingModel = null;

    @SerializedName("reference")
    private String reference = null;

    @SerializedName("returnUrl")
    private String returnUrl = null;

    @SerializedName("sdkVersion")
    private String sdkVersion = null;

    @SerializedName("selectedBrand")
    private String selectedBrand = null;

    @SerializedName("selectedRecurringDetailReference")
    private String selectedRecurringDetailReference = null;

    @SerializedName("sessionId")
    private String sessionId = null;

    @SerializedName("sessionValidity")
    private String sessionValidity = null;

    @SerializedName("shopperEmail")
    private String shopperEmail = null;

    @SerializedName("shopperIP")
    private String shopperIP = null;

    /**
     * Specifies the sales channel, through which the shopper gives their card details, and whether the shopper is a returning customer. For the web service API, Adyen assumes Ecommerce shopper
     * interaction by default.  This field has the following possible values: * &#x60;Ecommerce&#x60; - Online transactions where the cardholder is present (online). For better authorisation rates, we
     * recommend sending the card security code (CSC) along with the request. * &#x60;ContAuth&#x60; - Card on file and/or subscription transactions, where the cardholder is known to the merchant
     * (returning customer). If the shopper is present (online), you can supply also the CSC to improve authorisation (one-click payment). * &#x60;Moto&#x60; - Mail-order and telephone-order
     * transactions where the shopper is in contact with the merchant via email or telephone. * &#x60;POS&#x60; - Point-of-sale transactions where the shopper is physically present to make a payment
     * using a secure payment terminal.
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

    @SerializedName("storePaymentMethod")
    private Boolean storePaymentMethod = null;

    @SerializedName("telephoneNumber")
    private String telephoneNumber = null;

    @SerializedName("threeDS2RequestData")
    private ThreeDS2RequestData threeDS2RequestData = null;

    @SerializedName("threeDSAuthenticationOnly")
    private Boolean threeDSAuthenticationOnly = null;

    @SerializedName("token")
    private String token = null;

    @SerializedName("totalsGroup")
    private String totalsGroup = null;

    @SerializedName("trustedShopper")
    private Boolean trustedShopper = null;

    @SerializedName("uniqueTerminalId")
    private String uniqueTerminalId = null;

    public PaymentSessionRequest accountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
        return this;
    }


    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public PaymentSessionRequest additionalAmount(Amount additionalAmount) {
        this.additionalAmount = additionalAmount;
        return this;
    }


    public Amount getAdditionalAmount() {
        return additionalAmount;
    }

    public void setAdditionalAmount(Amount additionalAmount) {
        this.additionalAmount = additionalAmount;
    }

    public PaymentSessionRequest additionalData(Object additionalData) {
        this.additionalData = additionalData;
        return this;
    }


    public Object getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Object additionalData) {
        this.additionalData = additionalData;
    }

    public PaymentSessionRequest allowedPaymentMethods(List<String> allowedPaymentMethods) {
        this.allowedPaymentMethods = allowedPaymentMethods;
        return this;
    }

    public PaymentSessionRequest addAllowedPaymentMethodsItem(String allowedPaymentMethodsItem) {

        if (this.allowedPaymentMethods == null) {
            this.allowedPaymentMethods = new ArrayList<>();
        }

        this.allowedPaymentMethods.add(allowedPaymentMethodsItem);
        return this;
    }


    public List<String> getAllowedPaymentMethods() {
        return allowedPaymentMethods;
    }

    public void setAllowedPaymentMethods(List<String> allowedPaymentMethods) {
        this.allowedPaymentMethods = allowedPaymentMethods;
    }

    public PaymentSessionRequest amount(Amount amount) {
        this.amount = amount;
        return this;
    }


    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public PaymentSessionRequest applicationInfo(ApplicationInfo applicationInfo) {
        this.applicationInfo = applicationInfo;
        return this;
    }

    public ApplicationInfo getApplicationInfo() {
        return applicationInfo;
    }

    public void setApplicationInfo(ApplicationInfo applicationInfo) {
        this.applicationInfo = applicationInfo;
    }

    public PaymentSessionRequest bankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }


    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public PaymentSessionRequest billingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }


    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public PaymentSessionRequest blockedPaymentMethods(List<String> blockedPaymentMethods) {
        this.blockedPaymentMethods = blockedPaymentMethods;
        return this;
    }

    public PaymentSessionRequest addBlockedPaymentMethodsItem(String blockedPaymentMethodsItem) {

        if (this.blockedPaymentMethods == null) {
            this.blockedPaymentMethods = new ArrayList<>();
        }

        this.blockedPaymentMethods.add(blockedPaymentMethodsItem);
        return this;
    }


    public List<String> getBlockedPaymentMethods() {
        return blockedPaymentMethods;
    }

    public void setBlockedPaymentMethods(List<String> blockedPaymentMethods) {
        this.blockedPaymentMethods = blockedPaymentMethods;
    }

    public PaymentSessionRequest browserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
        return this;
    }

    public BrowserInfo getBrowserInfo() {
        return browserInfo;
    }

    public void setBrowserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
    }

    public PaymentSessionRequest captureDelayHours(Integer captureDelayHours) {
        this.captureDelayHours = captureDelayHours;
        return this;
    }


    public Integer getCaptureDelayHours() {
        return captureDelayHours;
    }

    public void setCaptureDelayHours(Integer captureDelayHours) {
        this.captureDelayHours = captureDelayHours;
    }

    public PaymentSessionRequest card(Card card) {
        this.card = card;
        return this;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public PaymentSessionRequest channel(ChannelEnum channel) {
        this.channel = channel;
        return this;
    }


    public ChannelEnum getChannel() {
        return channel;
    }

    public void setChannel(ChannelEnum channel) {
        this.channel = channel;
    }

    public PaymentSessionRequest company(Company company) {
        this.company = company;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public PaymentSessionRequest configId(String configId) {
        this.configId = configId;
        return this;
    }


    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    public PaymentSessionRequest configuration(ModelConfiguration configuration) {
        this.configuration = configuration;
        return this;
    }

    public ModelConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(ModelConfiguration configuration) {
        this.configuration = configuration;
    }

    public PaymentSessionRequest countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public PaymentSessionRequest dateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public PaymentSessionRequest dccQuote(ForexQuote dccQuote) {
        this.dccQuote = dccQuote;
        return this;
    }

    public ForexQuote getDccQuote() {
        return dccQuote;
    }

    public void setDccQuote(ForexQuote dccQuote) {
        this.dccQuote = dccQuote;
    }

    public PaymentSessionRequest deliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }


    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public PaymentSessionRequest deliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public PaymentSessionRequest deviceFingerprint(String deviceFingerprint) {
        this.deviceFingerprint = deviceFingerprint;
        return this;
    }

    public String getDeviceFingerprint() {
        return deviceFingerprint;
    }

    public void setDeviceFingerprint(String deviceFingerprint) {
        this.deviceFingerprint = deviceFingerprint;
    }

    public PaymentSessionRequest enableOneClick(Boolean enableOneClick) {
        this.enableOneClick = enableOneClick;
        return this;
    }

    public Boolean isEnableOneClick() {
        return enableOneClick;
    }

    public void setEnableOneClick(Boolean enableOneClick) {
        this.enableOneClick = enableOneClick;
    }

    public PaymentSessionRequest enablePayOut(Boolean enablePayOut) {
        this.enablePayOut = enablePayOut;
        return this;
    }


    public Boolean isEnablePayOut() {
        return enablePayOut;
    }

    public void setEnablePayOut(Boolean enablePayOut) {
        this.enablePayOut = enablePayOut;
    }

    public PaymentSessionRequest enableRealTimeUpdate(Boolean enableRealTimeUpdate) {
        this.enableRealTimeUpdate = enableRealTimeUpdate;
        return this;
    }

    /**
     * Choose if a specific transaction should use the Real-time Account Updater, regardless of other settings.
     *
     * @return enableRealTimeUpdate
     **/
    public Boolean isEnableRealTimeUpdate() {
        return enableRealTimeUpdate;
    }

    public void setEnableRealTimeUpdate(Boolean enableRealTimeUpdate) {
        this.enableRealTimeUpdate = enableRealTimeUpdate;
    }

    public PaymentSessionRequest enableRecurring(Boolean enableRecurring) {
        this.enableRecurring = enableRecurring;
        return this;
    }

    public Boolean isEnableRecurring() {
        return enableRecurring;
    }

    public void setEnableRecurring(Boolean enableRecurring) {
        this.enableRecurring = enableRecurring;
    }

    public PaymentSessionRequest entityType(EntityTypeEnum entityType) {
        this.entityType = entityType;
        return this;
    }


    public EntityTypeEnum getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityTypeEnum entityType) {
        this.entityType = entityType;
    }

    public PaymentSessionRequest fraudOffset(Integer fraudOffset) {
        this.fraudOffset = fraudOffset;
        return this;
    }


    public Integer getFraudOffset() {
        return fraudOffset;
    }

    public void setFraudOffset(Integer fraudOffset) {
        this.fraudOffset = fraudOffset;
    }

    public PaymentSessionRequest html(Boolean html) {
        this.html = html;
        return this;
    }

    public Boolean isHtml() {
        return html;
    }

    public void setHtml(Boolean html) {
        this.html = html;
    }

    public PaymentSessionRequest installments(Installments installments) {
        this.installments = installments;
        return this;
    }


    public Installments getInstallments() {
        return installments;
    }

    public void setInstallments(Installments installments) {
        this.installments = installments;
    }

    public PaymentSessionRequest lineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
        return this;
    }

    public PaymentSessionRequest addLineItemsItem(LineItem lineItemsItem) {

        if (this.lineItems == null) {
            this.lineItems = new ArrayList<>();
        }

        this.lineItems.add(lineItemsItem);
        return this;
    }


    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public PaymentSessionRequest mcc(String mcc) {
        this.mcc = mcc;
        return this;
    }


    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public PaymentSessionRequest merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }


    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public PaymentSessionRequest merchantOrderReference(String merchantOrderReference) {
        this.merchantOrderReference = merchantOrderReference;
        return this;
    }


    public String getMerchantOrderReference() {
        return merchantOrderReference;
    }

    public void setMerchantOrderReference(String merchantOrderReference) {
        this.merchantOrderReference = merchantOrderReference;
    }

    public PaymentSessionRequest merchantRiskIndicator(MerchantRiskIndicator merchantRiskIndicator) {
        this.merchantRiskIndicator = merchantRiskIndicator;
        return this;
    }


    public MerchantRiskIndicator getMerchantRiskIndicator() {
        return merchantRiskIndicator;
    }

    public void setMerchantRiskIndicator(MerchantRiskIndicator merchantRiskIndicator) {
        this.merchantRiskIndicator = merchantRiskIndicator;
    }

    public PaymentSessionRequest metadata(Object metadata) {
        this.metadata = metadata;
        return this;
    }


    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public PaymentSessionRequest mpiData(ThreeDSecureData mpiData) {
        this.mpiData = mpiData;
        return this;
    }


    public ThreeDSecureData getMpiData() {
        return mpiData;
    }

    public void setMpiData(ThreeDSecureData mpiData) {
        this.mpiData = mpiData;
    }

    public PaymentSessionRequest nationality(String nationality) {
        this.nationality = nationality;
        return this;
    }


    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public PaymentSessionRequest orderReference(String orderReference) {
        this.orderReference = orderReference;
        return this;
    }


    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public PaymentSessionRequest origin(String origin) {
        this.origin = origin;
        return this;
    }


    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public PaymentSessionRequest recurring(Recurring recurring) {
        this.recurring = recurring;
        return this;
    }


    public Recurring getRecurring() {
        return recurring;
    }

    public void setRecurring(Recurring recurring) {
        this.recurring = recurring;
    }

    public PaymentSessionRequest recurringExpiry(String recurringExpiry) {
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

    public PaymentSessionRequest recurringFrequency(String recurringFrequency) {
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

    public PaymentSessionRequest recurringProcessingModel(RecurringProcessingModelEnum recurringProcessingModel) {
        this.recurringProcessingModel = recurringProcessingModel;
        return this;
    }


    public RecurringProcessingModelEnum getRecurringProcessingModel() {
        return recurringProcessingModel;
    }

    public void setRecurringProcessingModel(RecurringProcessingModelEnum recurringProcessingModel) {
        this.recurringProcessingModel = recurringProcessingModel;
    }

    public PaymentSessionRequest reference(String reference) {
        this.reference = reference;
        return this;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public PaymentSessionRequest returnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
        return this;
    }


    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public PaymentSessionRequest sdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
        return this;
    }


    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public PaymentSessionRequest selectedBrand(String selectedBrand) {
        this.selectedBrand = selectedBrand;
        return this;
    }

    public String getSelectedBrand() {
        return selectedBrand;
    }

    public void setSelectedBrand(String selectedBrand) {
        this.selectedBrand = selectedBrand;
    }

    public PaymentSessionRequest selectedRecurringDetailReference(String selectedRecurringDetailReference) {
        this.selectedRecurringDetailReference = selectedRecurringDetailReference;
        return this;
    }


    public String getSelectedRecurringDetailReference() {
        return selectedRecurringDetailReference;
    }

    public void setSelectedRecurringDetailReference(String selectedRecurringDetailReference) {
        this.selectedRecurringDetailReference = selectedRecurringDetailReference;
    }

    public PaymentSessionRequest sessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }


    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public PaymentSessionRequest sessionValidity(String sessionValidity) {
        this.sessionValidity = sessionValidity;
        return this;
    }

    public String getSessionValidity() {
        return sessionValidity;
    }

    public void setSessionValidity(String sessionValidity) {
        this.sessionValidity = sessionValidity;
    }

    public PaymentSessionRequest shopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
        return this;
    }


    public String getShopperEmail() {
        return shopperEmail;
    }

    public void setShopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
    }

    public PaymentSessionRequest shopperIP(String shopperIP) {
        this.shopperIP = shopperIP;
        return this;
    }


    public String getShopperIP() {
        return shopperIP;
    }

    public void setShopperIP(String shopperIP) {
        this.shopperIP = shopperIP;
    }

    public PaymentSessionRequest shopperInteraction(ShopperInteractionEnum shopperInteraction) {
        this.shopperInteraction = shopperInteraction;
        return this;
    }


    public ShopperInteractionEnum getShopperInteraction() {
        return shopperInteraction;
    }

    public void setShopperInteraction(ShopperInteractionEnum shopperInteraction) {
        this.shopperInteraction = shopperInteraction;
    }

    public PaymentSessionRequest shopperLocale(String shopperLocale) {
        this.shopperLocale = shopperLocale;
        return this;
    }


    public String getShopperLocale() {
        return shopperLocale;
    }

    public void setShopperLocale(String shopperLocale) {
        this.shopperLocale = shopperLocale;
    }

    public PaymentSessionRequest shopperName(Name shopperName) {
        this.shopperName = shopperName;
        return this;
    }

    public Name getShopperName() {
        return shopperName;
    }

    public void setShopperName(Name shopperName) {
        this.shopperName = shopperName;
    }

    public PaymentSessionRequest shopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
        return this;
    }


    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    public PaymentSessionRequest shopperStatement(String shopperStatement) {
        this.shopperStatement = shopperStatement;
        return this;
    }

    public String getShopperStatement() {
        return shopperStatement;
    }

    public void setShopperStatement(String shopperStatement) {
        this.shopperStatement = shopperStatement;
    }

    public PaymentSessionRequest socialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
        return this;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public PaymentSessionRequest splits(List<Split> splits) {
        this.splits = splits;
        return this;
    }

    public PaymentSessionRequest addSplitsItem(Split splitsItem) {

        if (this.splits == null) {
            this.splits = new ArrayList<>();
        }

        this.splits.add(splitsItem);
        return this;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public PaymentSessionRequest storePaymentMethod(Boolean storePaymentMethod) {
        this.storePaymentMethod = storePaymentMethod;
        return this;
    }

    public Boolean getStorePaymentMethod() {
        return storePaymentMethod;
    }

    public void setStorePaymentMethod(Boolean storePaymentMethod) {
        this.storePaymentMethod = storePaymentMethod;
    }

    public PaymentSessionRequest store(String store) {
        this.store = store;
        return this;
    }


    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public PaymentSessionRequest telephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public PaymentSessionRequest threeDSAuthenticationOnly(Boolean threeDSAuthenticationOnly) {
        this.threeDSAuthenticationOnly = threeDSAuthenticationOnly;
        return this;
    }

    /**
     * If set to true, you will only perform the [3D Secure 2 authentication](https://docs.adyen.com/checkout/3d-secure/native-3ds2/authentication-only), and not the payment authorisation.
     *
     * @return threeDSAuthenticationOnly
     **/
    public Boolean isThreeDSAuthenticationOnly() {
        return threeDSAuthenticationOnly;
    }

    public void setThreeDSAuthenticationOnly(Boolean threeDSAuthenticationOnly) {
        this.threeDSAuthenticationOnly = threeDSAuthenticationOnly;
    }

    public PaymentSessionRequest threeDS2RequestData(ThreeDS2RequestData threeDS2RequestData) {
        this.threeDS2RequestData = threeDS2RequestData;
        return this;
    }


    public ThreeDS2RequestData getThreeDS2RequestData() {
        return threeDS2RequestData;
    }

    public void setThreeDS2RequestData(ThreeDS2RequestData threeDS2RequestData) {
        this.threeDS2RequestData = threeDS2RequestData;
    }

    public PaymentSessionRequest token(String token) {
        this.token = token;
        return this;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public PaymentSessionRequest totalsGroup(String totalsGroup) {
        this.totalsGroup = totalsGroup;
        return this;
    }


    public void setTotalsGroup(String totalsGroup) {
        this.totalsGroup = totalsGroup;
    }

    public PaymentSessionRequest trustedShopper(Boolean trustedShopper) {
        this.trustedShopper = trustedShopper;
        return this;
    }


    public Boolean isTrustedShopper() {
        return trustedShopper;
    }

    public void setTrustedShopper(Boolean trustedShopper) {
        this.trustedShopper = trustedShopper;
    }

    public PaymentSessionRequest uniqueTerminalId(String uniqueTerminalId) {
        this.uniqueTerminalId = uniqueTerminalId;
        return this;
    }


    public String getUniqueTerminalId() {
        return uniqueTerminalId;
    }

    public void setUniqueTerminalId(String uniqueTerminalId) {
        this.uniqueTerminalId = uniqueTerminalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PaymentSessionRequest)) {
            return false;
        }
        PaymentSessionRequest that = (PaymentSessionRequest) o;
        return Objects.equals(accountInfo, that.accountInfo)
                && Objects.equals(additionalAmount, that.additionalAmount)
                && Objects.equals(additionalData, that.additionalData)
                && Objects.equals(allowedPaymentMethods, that.allowedPaymentMethods)
                && Objects.equals(amount, that.amount)
                && Objects.equals(applicationInfo, that.applicationInfo)
                && Objects.equals(bankAccount, that.bankAccount)
                && Objects.equals(billingAddress, that.billingAddress)
                && Objects.equals(blockedPaymentMethods, that.blockedPaymentMethods)
                && Objects.equals(browserInfo, that.browserInfo)
                && Objects.equals(captureDelayHours, that.captureDelayHours)
                && Objects.equals(card, that.card)
                && Objects.equals(channel, that.channel)
                && Objects.equals(company, that.company)
                && Objects.equals(configId, that.configId)
                && Objects.equals(configuration, that.configuration)
                && Objects.equals(countryCode, that.countryCode)
                && Objects.equals(dateOfBirth, that.dateOfBirth)
                && Objects.equals(dccQuote, that.dccQuote)
                && Objects.equals(deliveryAddress, that.deliveryAddress)
                && Objects.equals(deliveryDate, that.deliveryDate)
                && Objects.equals(deviceFingerprint, that.deviceFingerprint)
                && Objects.equals(enableOneClick, that.enableOneClick)
                && Objects.equals(enablePayOut, that.enablePayOut)
                && Objects.equals(enableRealTimeUpdate, that.enableRealTimeUpdate)
                && Objects.equals(enableRecurring, that.enableRecurring)
                && Objects.equals(entityType, that.entityType)
                && Objects.equals(fraudOffset, that.fraudOffset)
                && Objects.equals(html, that.html)
                && Objects.equals(installments, that.installments)
                && Objects.equals(lineItems, that.lineItems)
                && Objects.equals(mcc, that.mcc)
                && Objects.equals(merchantAccount, that.merchantAccount)
                && Objects.equals(merchantOrderReference, that.merchantOrderReference)
                && Objects.equals(merchantRiskIndicator, that.merchantRiskIndicator)
                && Objects.equals(metadata, that.metadata)
                && Objects.equals(mpiData, that.mpiData)
                && Objects.equals(nationality, that.nationality)
                && Objects.equals(orderReference, that.orderReference)
                && Objects.equals(origin, that.origin)
                && Objects.equals(recurring, that.recurring)
                && Objects.equals(recurringExpiry, that.recurringExpiry)
                && Objects.equals(recurringFrequency, that.recurringFrequency)
                && Objects.equals(recurringProcessingModel, that.recurringProcessingModel)
                && Objects.equals(reference, that.reference)
                && Objects.equals(returnUrl, that.returnUrl)
                && Objects.equals(sdkVersion, that.sdkVersion)
                && Objects.equals(selectedBrand, that.selectedBrand)
                && Objects.equals(selectedRecurringDetailReference, that.selectedRecurringDetailReference)
                && Objects.equals(sessionId, that.sessionId)
                && Objects.equals(sessionValidity, that.sessionValidity)
                && Objects.equals(shopperEmail, that.shopperEmail)
                && Objects.equals(shopperIP, that.shopperIP)
                && Objects.equals(shopperInteraction, that.shopperInteraction)
                && Objects.equals(shopperLocale, that.shopperLocale)
                && Objects.equals(shopperName, that.shopperName)
                && Objects.equals(shopperReference, that.shopperReference)
                && Objects.equals(shopperStatement, that.shopperStatement)
                && Objects.equals(socialSecurityNumber, that.socialSecurityNumber)
                && Objects.equals(splits, that.splits)
                && Objects.equals(store, that.store)
                && Objects.equals(storePaymentMethod, that.storePaymentMethod)
                && Objects.equals(telephoneNumber, that.telephoneNumber)
                && Objects.equals(threeDS2RequestData, that.threeDS2RequestData)
                && Objects.equals(threeDSAuthenticationOnly, that.threeDSAuthenticationOnly)
                && Objects.equals(token, that.token)
                && Objects.equals(totalsGroup, that.totalsGroup)
                && Objects.equals(trustedShopper, that.trustedShopper)
                && Objects.equals(uniqueTerminalId, that.uniqueTerminalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountInfo, additionalAmount, additionalData, allowedPaymentMethods, amount, applicationInfo, bankAccount, billingAddress, blockedPaymentMethods, browserInfo, captureDelayHours, card, channel, company, configId, configuration, countryCode, dateOfBirth, dccQuote, deliveryAddress, deliveryDate, deviceFingerprint, enableOneClick, enablePayOut, enableRealTimeUpdate, enableRecurring, entityType, fraudOffset, html, installments, lineItems, mcc, merchantAccount, merchantOrderReference, merchantRiskIndicator, metadata, mpiData, nationality, orderReference, origin, recurring, recurringExpiry, recurringFrequency, recurringProcessingModel, reference, returnUrl, sdkVersion, selectedBrand, selectedRecurringDetailReference, sessionId, sessionValidity, shopperEmail, shopperIP, shopperInteraction, shopperLocale, shopperName, shopperReference, shopperStatement, socialSecurityNumber, splits, store, storePaymentMethod, telephoneNumber, threeDS2RequestData, threeDSAuthenticationOnly, token, totalsGroup, trustedShopper, uniqueTerminalId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentSessionRequest {\n");

        sb.append("    accountInfo: ").append(toIndentedString(accountInfo)).append("\n");
        sb.append("    additionalAmount: ").append(toIndentedString(additionalAmount)).append("\n");
        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
        sb.append("    allowedPaymentMethods: ").append(toIndentedString(allowedPaymentMethods)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    applicationInfo: ").append(toIndentedString(applicationInfo)).append("\n");
        sb.append("    bankAccount: ").append(toIndentedString(bankAccount)).append("\n");
        sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
        sb.append("    blockedPaymentMethods: ").append(toIndentedString(blockedPaymentMethods)).append("\n");
        sb.append("    browserInfo: ").append(toIndentedString(browserInfo)).append("\n");
        sb.append("    captureDelayHours: ").append(toIndentedString(captureDelayHours)).append("\n");
        sb.append("    card: ").append(toIndentedString(card)).append("\n");
        sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
        sb.append("    company: ").append(toIndentedString(company)).append("\n");
        sb.append("    configId: ").append(toIndentedString(configId)).append("\n");
        sb.append("    configuration: ").append(toIndentedString(configuration)).append("\n");
        sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
        sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
        sb.append("    dccQuote: ").append(toIndentedString(dccQuote)).append("\n");
        sb.append("    deliveryAddress: ").append(toIndentedString(deliveryAddress)).append("\n");
        sb.append("    deliveryDate: ").append(toIndentedString(deliveryDate)).append("\n");
        sb.append("    deviceFingerprint: ").append(toIndentedString(deviceFingerprint)).append("\n");
        sb.append("    enableOneClick: ").append(toIndentedString(enableOneClick)).append("\n");
        sb.append("    enablePayOut: ").append(toIndentedString(enablePayOut)).append("\n");
        sb.append("    enableRealTimeUpdate: ").append(toIndentedString(enableRealTimeUpdate)).append("\n");
        sb.append("    enableRecurring: ").append(toIndentedString(enableRecurring)).append("\n");
        sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
        sb.append("    fraudOffset: ").append(toIndentedString(fraudOffset)).append("\n");
        sb.append("    html: ").append(toIndentedString(html)).append("\n");
        sb.append("    installments: ").append(toIndentedString(installments)).append("\n");
        sb.append("    lineItems: ").append(toIndentedString(lineItems)).append("\n");
        sb.append("    mcc: ").append(toIndentedString(mcc)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    merchantOrderReference: ").append(toIndentedString(merchantOrderReference)).append("\n");
        sb.append("    merchantRiskIndicator: ").append(toIndentedString(merchantRiskIndicator)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    mpiData: ").append(toIndentedString(mpiData)).append("\n");
        sb.append("    nationality: ").append(toIndentedString(nationality)).append("\n");
        sb.append("    orderReference: ").append(toIndentedString(orderReference)).append("\n");
        sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
        sb.append("    recurring: ").append(toIndentedString(recurring)).append("\n");
        sb.append("    recurringExpiry: ").append(toIndentedString(recurringExpiry)).append("\n");
        sb.append("    recurringFrequency: ").append(toIndentedString(recurringFrequency)).append("\n");
        sb.append("    recurringProcessingModel: ").append(toIndentedString(recurringProcessingModel)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    returnUrl: ").append(toIndentedString(returnUrl)).append("\n");
        sb.append("    sdkVersion: ").append(toIndentedString(sdkVersion)).append("\n");
        sb.append("    selectedBrand: ").append(toIndentedString(selectedBrand)).append("\n");
        sb.append("    selectedRecurringDetailReference: ").append(toIndentedString(selectedRecurringDetailReference)).append("\n");
        sb.append("    sessionId: ").append(toIndentedString(sessionId)).append("\n");
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
        sb.append("    token: ").append(toIndentedString(token)).append("\n");
        sb.append("    totalsGroup: ").append(toIndentedString(totalsGroup)).append("\n");
        sb.append("    trustedShopper: ").append(toIndentedString(trustedShopper)).append("\n");
        sb.append("    uniqueTerminalId: ").append(toIndentedString(uniqueTerminalId)).append("\n");
        sb.append('}');
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
