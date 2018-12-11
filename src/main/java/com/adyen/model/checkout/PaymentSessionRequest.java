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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.adyen.model.Address;
import com.adyen.model.Amount;
import com.adyen.model.ForexQuote;
import com.adyen.model.Installments;
import com.adyen.model.Name;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.threeten.bp.OffsetDateTime;

/**
 * PaymentSessionRequest
 */
public class PaymentSessionRequest {


    @SerializedName("additionalData")
    private Object additionalData = null;

    @SerializedName("allowedPaymentMethods")
    private List<String> allowedPaymentMethods = null;

    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("billingAddress")
    private Address billingAddress = null;

    @SerializedName("blockedPaymentMethods")
    private List<String> blockedPaymentMethods = null;

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
            for (ChannelEnum b : ChannelEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
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

    @SerializedName("configuration")
    private ModelConfiguration _configuration = null;

    @SerializedName("countryCode")
    private String countryCode = null;

    @SerializedName("dateOfBirth")
    private OffsetDateTime dateOfBirth = null;

    @SerializedName("dccQuote")
    private ForexQuote dccQuote = null;

    @SerializedName("deliveryAddress")
    private Address deliveryAddress = null;

    @SerializedName("deliveryDate")
    private OffsetDateTime deliveryDate = null;

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
            for (EntityTypeEnum b : EntityTypeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
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

    @SerializedName("metadata")
    private Object metadata = null;

    @SerializedName("orderReference")
    private String orderReference = null;

    @SerializedName("origin")
    private String origin = null;

    @SerializedName("reference")
    private String reference = null;

    @SerializedName("returnUrl")
    private String returnUrl = null;

    @SerializedName("sdkVersion")
    private String sdkVersion = null;

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
            for (ShopperInteractionEnum b : ShopperInteractionEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
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

    @SerializedName("telephoneNumber")
    private String telephoneNumber = null;

    @SerializedName("token")
    private String token = null;

    @SerializedName("trustedShopper")
    private Boolean trustedShopper = null;

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
            this.allowedPaymentMethods = new ArrayList<String>();
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
            this.blockedPaymentMethods = new ArrayList<String>();
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

    public PaymentSessionRequest _configuration(ModelConfiguration _configuration) {
        this._configuration = _configuration;
        return this;
    }


    public ModelConfiguration getConfiguration() {
        return _configuration;
    }

    public void setConfiguration(ModelConfiguration _configuration) {
        this._configuration = _configuration;
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

    public PaymentSessionRequest dateOfBirth(OffsetDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }


    public OffsetDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(OffsetDateTime dateOfBirth) {
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

    public PaymentSessionRequest deliveryDate(OffsetDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }

    public OffsetDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(OffsetDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
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
            this.lineItems = new ArrayList<LineItem>();
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
            this.splits = new ArrayList<Split>();
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentSessionRequest paymentSetupRequest = (PaymentSessionRequest) o;
        return Objects.equals(this.additionalData, paymentSetupRequest.additionalData) &&
                Objects.equals(this.allowedPaymentMethods, paymentSetupRequest.allowedPaymentMethods) &&
                Objects.equals(this.amount, paymentSetupRequest.amount) &&
                Objects.equals(this.billingAddress, paymentSetupRequest.billingAddress) &&
                Objects.equals(this.blockedPaymentMethods, paymentSetupRequest.blockedPaymentMethods) &&
                Objects.equals(this.captureDelayHours, paymentSetupRequest.captureDelayHours) &&
                Objects.equals(this.channel, paymentSetupRequest.channel) &&
                Objects.equals(this.company, paymentSetupRequest.company) &&
                Objects.equals(this._configuration, paymentSetupRequest._configuration) &&
                Objects.equals(this.countryCode, paymentSetupRequest.countryCode) &&
                Objects.equals(this.dateOfBirth, paymentSetupRequest.dateOfBirth) &&
                Objects.equals(this.dccQuote, paymentSetupRequest.dccQuote) &&
                Objects.equals(this.deliveryAddress, paymentSetupRequest.deliveryAddress) &&
                Objects.equals(this.deliveryDate, paymentSetupRequest.deliveryDate) &&
                Objects.equals(this.enableOneClick, paymentSetupRequest.enableOneClick) &&
                Objects.equals(this.enablePayOut, paymentSetupRequest.enablePayOut) &&
                Objects.equals(this.enableRecurring, paymentSetupRequest.enableRecurring) &&
                Objects.equals(this.entityType, paymentSetupRequest.entityType) &&
                Objects.equals(this.fraudOffset, paymentSetupRequest.fraudOffset) &&
                Objects.equals(this.installments, paymentSetupRequest.installments) &&
                Objects.equals(this.lineItems, paymentSetupRequest.lineItems) &&
                Objects.equals(this.mcc, paymentSetupRequest.mcc) &&
                Objects.equals(this.merchantAccount, paymentSetupRequest.merchantAccount) &&
                Objects.equals(this.merchantOrderReference, paymentSetupRequest.merchantOrderReference) &&
                Objects.equals(this.metadata, paymentSetupRequest.metadata) &&
                Objects.equals(this.orderReference, paymentSetupRequest.orderReference) &&
                Objects.equals(this.origin, paymentSetupRequest.origin) &&
                Objects.equals(this.reference, paymentSetupRequest.reference) &&
                Objects.equals(this.returnUrl, paymentSetupRequest.returnUrl) &&
                Objects.equals(this.sdkVersion, paymentSetupRequest.sdkVersion) &&
                Objects.equals(this.sessionValidity, paymentSetupRequest.sessionValidity) &&
                Objects.equals(this.shopperEmail, paymentSetupRequest.shopperEmail) &&
                Objects.equals(this.shopperIP, paymentSetupRequest.shopperIP) &&
                Objects.equals(this.shopperInteraction, paymentSetupRequest.shopperInteraction) &&
                Objects.equals(this.shopperLocale, paymentSetupRequest.shopperLocale) &&
                Objects.equals(this.shopperName, paymentSetupRequest.shopperName) &&
                Objects.equals(this.shopperReference, paymentSetupRequest.shopperReference) &&
                Objects.equals(this.shopperStatement, paymentSetupRequest.shopperStatement) &&
                Objects.equals(this.socialSecurityNumber, paymentSetupRequest.socialSecurityNumber) &&
                Objects.equals(this.splits, paymentSetupRequest.splits) &&
                Objects.equals(this.telephoneNumber, paymentSetupRequest.telephoneNumber) &&
                Objects.equals(this.token, paymentSetupRequest.token) &&
                Objects.equals(this.trustedShopper, paymentSetupRequest.trustedShopper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalData, allowedPaymentMethods, amount, billingAddress, blockedPaymentMethods, captureDelayHours, channel, company, _configuration, countryCode, dateOfBirth, dccQuote, deliveryAddress, deliveryDate, enableOneClick, enablePayOut, enableRecurring, entityType, fraudOffset, installments, lineItems, mcc, merchantAccount, merchantOrderReference, metadata, orderReference, origin, reference, returnUrl, sdkVersion, sessionValidity, shopperEmail, shopperIP, shopperInteraction, shopperLocale, shopperName, shopperReference, shopperStatement, socialSecurityNumber, splits, telephoneNumber, token, trustedShopper);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentSetupRequest {\n");

        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
        sb.append("    allowedPaymentMethods: ").append(toIndentedString(allowedPaymentMethods)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
        sb.append("    blockedPaymentMethods: ").append(toIndentedString(blockedPaymentMethods)).append("\n");
        sb.append("    captureDelayHours: ").append(toIndentedString(captureDelayHours)).append("\n");
        sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
        sb.append("    company: ").append(toIndentedString(company)).append("\n");
        sb.append("    _configuration: ").append(toIndentedString(_configuration)).append("\n");
        sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
        sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
        sb.append("    dccQuote: ").append(toIndentedString(dccQuote)).append("\n");
        sb.append("    deliveryAddress: ").append(toIndentedString(deliveryAddress)).append("\n");
        sb.append("    deliveryDate: ").append(toIndentedString(deliveryDate)).append("\n");
        sb.append("    enableOneClick: ").append(toIndentedString(enableOneClick)).append("\n");
        sb.append("    enablePayOut: ").append(toIndentedString(enablePayOut)).append("\n");
        sb.append("    enableRecurring: ").append(toIndentedString(enableRecurring)).append("\n");
        sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
        sb.append("    fraudOffset: ").append(toIndentedString(fraudOffset)).append("\n");
        sb.append("    installments: ").append(toIndentedString(installments)).append("\n");
        sb.append("    lineItems: ").append(toIndentedString(lineItems)).append("\n");
        sb.append("    mcc: ").append(toIndentedString(mcc)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    merchantOrderReference: ").append(toIndentedString(merchantOrderReference)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    orderReference: ").append(toIndentedString(orderReference)).append("\n");
        sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    returnUrl: ").append(toIndentedString(returnUrl)).append("\n");
        sb.append("    sdkVersion: ").append(toIndentedString(sdkVersion)).append("\n");
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
        sb.append("    telephoneNumber: ").append(toIndentedString(telephoneNumber)).append("\n");
        sb.append("    token: ").append(toIndentedString(token)).append("\n");
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
