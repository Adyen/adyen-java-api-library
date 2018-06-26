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

import com.adyen.model.*;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.*;

/**
 * PaymentSessionRequest
 */
public class PaymentSessionRequest {

    @SerializedName("additionalData")
    private Map<String, String> additionalData = null;

    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("billingAddress")
    private Address billingAddress = null;

    @SerializedName("captureDelayHours")
    private Integer captureDelayHours = null;
    @SerializedName("channel")
    private ChannelEnum channel = null;
    @SerializedName("company")
    private Company company = null;
    @SerializedName("configuration")
    private ModelConfiguration _configuration = null;
    @SerializedName("countryCode")
    private String countryCode = null;
    @SerializedName("dateOfBirth")
    private Date dateOfBirth = null;
    @SerializedName("dccQuote")
    private ForexQuote dccQuote = null;
    @SerializedName("deliveryAddress")
    private Address deliveryAddress = null;
    @SerializedName("deliveryDate")
    private Date deliveryDate = null;
    @SerializedName("enableOneClick")
    private Boolean enableOneClick = null;
    @SerializedName("enablePayOut")
    private Boolean enablePayOut = null;
    @SerializedName("enableRecurring")
    private Boolean enableRecurring = null;
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
    @SerializedName("metadata")
    private Map<String, String> metadata = null;
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
    @SerializedName("telephoneNumber")
    private String telephoneNumber = null;
    @SerializedName("token")
    private String token = null;

    public PaymentSessionRequest additionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
        return this;
    }

    public PaymentSessionRequest putAdditionalDataItem(String key, String additionalDataItem) {

        if (this.additionalData == null) {
            this.additionalData = null;
        }

        this.additionalData.put(key, additionalDataItem);
        return this;
    }

    /**
     * This field contains additional data, which may be required for a particular payment request.  The &#x60;additionalData&#x60; object consists of entries, each of which includes the key and value. For more information on possible key-value pairs, refer to the [additionalData section](https://docs.adyen.com/developers/api-reference/payments-api#paymentrequestadditionaldata).
     *
     * @return additionalData
     **/
    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    public PaymentSessionRequest amount(Amount amount) {
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

    public PaymentSessionRequest billingAddress(Address billingAddress) {
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

    public PaymentSessionRequest captureDelayHours(Integer captureDelayHours) {
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

    public PaymentSessionRequest channel(ChannelEnum channel) {
        this.channel = channel;
        return this;
    }

    /**
     * The platform where a payment transaction takes place. This field is optional for filtering out payment methods that are only available on specific platforms. If this value is not set, then we will try to infer it from the &#x60;sdkVersion&#x60; or token.  Possible values: * iOS * Android * Web
     *
     * @return channel
     **/
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

    public PaymentSessionRequest _configuration(ModelConfiguration _configuration) {
        this._configuration = _configuration;
        return this;
    }

    /**
     * Get _configuration
     *
     * @return _configuration
     **/
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

    /**
     * The shopper country.  Format: [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) Example: NL or DE
     *
     * @return countryCode
     **/
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

    public PaymentSessionRequest dccQuote(ForexQuote dccQuote) {
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

    public PaymentSessionRequest deliveryAddress(Address deliveryAddress) {
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

    public PaymentSessionRequest deliveryDate(Date deliveryDate) {
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

    public PaymentSessionRequest enableOneClick(Boolean enableOneClick) {
        this.enableOneClick = enableOneClick;
        return this;
    }

    /**
     * When true and &#x60;shopperReference&#x60; is provided, the shopper will be asked if the payment details should be stored for future one-click payments.
     *
     * @return enableOneClick
     **/
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

    /**
     * When true and &#x60;shopperReference&#x60; is provided, the payment details will be tokenized for payouts.
     *
     * @return enablePayOut
     **/
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

    /**
     * When true and &#x60;shopperReference&#x60; is provided, the payment details will be tokenized for recurring payments.
     *
     * @return enableRecurring
     **/
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

    public PaymentSessionRequest fraudOffset(Integer fraudOffset) {
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

    public PaymentSessionRequest html(Boolean html) {
        this.html = html;
        return this;
    }

    /**
     * Required for the Web integration.  Set this parameter to true to use the default Checkout UI from the SDK.
     *
     * @return html
     **/
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

    /**
     * Line items regarding the payment.
     *
     * @return lineItems
     **/
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

    public PaymentSessionRequest merchantAccount(String merchantAccount) {
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

    public PaymentSessionRequest merchantOrderReference(String merchantOrderReference) {
        this.merchantOrderReference = merchantOrderReference;
        return this;
    }

    /**
     * This reference allows linking multiple transactions to each other. &gt; When providing the &#x60;merchantOrderReference&#x60; value, we also recommend you submit &#x60;retry.orderAttemptNumber&#x60;, &#x60;retry.chainAttemptNumber&#x60;, and &#x60;retry.skipRetry&#x60; values.
     *
     * @return merchantOrderReference
     **/
    public String getMerchantOrderReference() {
        return merchantOrderReference;
    }

    public void setMerchantOrderReference(String merchantOrderReference) {
        this.merchantOrderReference = merchantOrderReference;
    }

    public PaymentSessionRequest metadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }

    public PaymentSessionRequest putMetadataItem(String key, String metadataItem) {

        if (this.metadata == null) {
            this.metadata = null;
        }

        this.metadata.put(key, metadataItem);
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

    public PaymentSessionRequest orderReference(String orderReference) {
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

    public PaymentSessionRequest origin(String origin) {
        this.origin = origin;
        return this;
    }

    /**
     * Required for the Web integration.  Set this parameter to the page URL, on which you are loading the SDK.
     *
     * @return origin
     **/
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

    public PaymentSessionRequest returnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
        return this;
    }

    /**
     * The URL to return to.
     *
     * @return returnUrl
     **/
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

    /**
     * The version of the Web SDK you are using (for web integrations only).
     *
     * @return sdkVersion
     **/
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

    /**
     * The maximum validity of the session.
     *
     * @return sessionValidity
     **/
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

    public PaymentSessionRequest shopperIP(String shopperIP) {
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

    public PaymentSessionRequest shopperInteraction(ShopperInteractionEnum shopperInteraction) {
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

    public PaymentSessionRequest shopperLocale(String shopperLocale) {
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

    public PaymentSessionRequest shopperName(Name shopperName) {
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

    public PaymentSessionRequest shopperReference(String shopperReference) {
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

    public PaymentSessionRequest shopperStatement(String shopperStatement) {
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

    public PaymentSessionRequest socialSecurityNumber(String socialSecurityNumber) {
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

    public PaymentSessionRequest telephoneNumber(String telephoneNumber) {
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

    public PaymentSessionRequest token(String token) {
        this.token = token;
        return this;
    }

    /**
     * The token obtained when initializing the SDK.  &gt; This parameter is required for iOS and Android; not required for Web.
     *
     * @return token
     **/
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentSessionRequest paymentSessionRequest = (PaymentSessionRequest) o;
        return Objects.equals(this.additionalData, paymentSessionRequest.additionalData) &&
                Objects.equals(this.amount, paymentSessionRequest.amount) &&
                Objects.equals(this.billingAddress, paymentSessionRequest.billingAddress) &&
                Objects.equals(this.captureDelayHours, paymentSessionRequest.captureDelayHours) &&
                Objects.equals(this.channel, paymentSessionRequest.channel) &&
                Objects.equals(this.company, paymentSessionRequest.company) &&
                Objects.equals(this._configuration, paymentSessionRequest._configuration) &&
                Objects.equals(this.countryCode, paymentSessionRequest.countryCode) &&
                Objects.equals(this.dateOfBirth, paymentSessionRequest.dateOfBirth) &&
                Objects.equals(this.dccQuote, paymentSessionRequest.dccQuote) &&
                Objects.equals(this.deliveryAddress, paymentSessionRequest.deliveryAddress) &&
                Objects.equals(this.deliveryDate, paymentSessionRequest.deliveryDate) &&
                Objects.equals(this.enableOneClick, paymentSessionRequest.enableOneClick) &&
                Objects.equals(this.enablePayOut, paymentSessionRequest.enablePayOut) &&
                Objects.equals(this.enableRecurring, paymentSessionRequest.enableRecurring) &&
                Objects.equals(this.entityType, paymentSessionRequest.entityType) &&
                Objects.equals(this.fraudOffset, paymentSessionRequest.fraudOffset) &&
                Objects.equals(this.html, paymentSessionRequest.html) &&
                Objects.equals(this.installments, paymentSessionRequest.installments) &&
                Objects.equals(this.lineItems, paymentSessionRequest.lineItems) &&
                Objects.equals(this.mcc, paymentSessionRequest.mcc) &&
                Objects.equals(this.merchantAccount, paymentSessionRequest.merchantAccount) &&
                Objects.equals(this.merchantOrderReference, paymentSessionRequest.merchantOrderReference) &&
                Objects.equals(this.metadata, paymentSessionRequest.metadata) &&
                Objects.equals(this.orderReference, paymentSessionRequest.orderReference) &&
                Objects.equals(this.origin, paymentSessionRequest.origin) &&
                Objects.equals(this.reference, paymentSessionRequest.reference) &&
                Objects.equals(this.returnUrl, paymentSessionRequest.returnUrl) &&
                Objects.equals(this.sdkVersion, paymentSessionRequest.sdkVersion) &&
                Objects.equals(this.sessionValidity, paymentSessionRequest.sessionValidity) &&
                Objects.equals(this.shopperEmail, paymentSessionRequest.shopperEmail) &&
                Objects.equals(this.shopperIP, paymentSessionRequest.shopperIP) &&
                Objects.equals(this.shopperInteraction, paymentSessionRequest.shopperInteraction) &&
                Objects.equals(this.shopperLocale, paymentSessionRequest.shopperLocale) &&
                Objects.equals(this.shopperName, paymentSessionRequest.shopperName) &&
                Objects.equals(this.shopperReference, paymentSessionRequest.shopperReference) &&
                Objects.equals(this.shopperStatement, paymentSessionRequest.shopperStatement) &&
                Objects.equals(this.socialSecurityNumber, paymentSessionRequest.socialSecurityNumber) &&
                Objects.equals(this.telephoneNumber, paymentSessionRequest.telephoneNumber) &&
                Objects.equals(this.token, paymentSessionRequest.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalData, amount, billingAddress, captureDelayHours, channel, company, _configuration, countryCode, dateOfBirth, dccQuote, deliveryAddress, deliveryDate, enableOneClick, enablePayOut, enableRecurring, entityType, fraudOffset, html, installments, lineItems, mcc, merchantAccount, merchantOrderReference, metadata, orderReference, origin, reference, returnUrl, sdkVersion, sessionValidity, shopperEmail, shopperIP, shopperInteraction, shopperLocale, shopperName, shopperReference, shopperStatement, socialSecurityNumber, telephoneNumber, token);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentSessionRequest {\n");

        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
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
        sb.append("    html: ").append(toIndentedString(html)).append("\n");
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
        sb.append("    telephoneNumber: ").append(toIndentedString(telephoneNumber)).append("\n");
        sb.append("    token: ").append(toIndentedString(token)).append("\n");
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

    /**
     * The platform where a payment transaction takes place. This field is optional for filtering out payment methods that are only available on specific platforms. If this value is not set, then we will try to infer it from the &#x60;sdkVersion&#x60; or token.  Possible values: * iOS * Android * Web
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

        public static ChannelEnum fromValue(String text) {
            for (ChannelEnum b : ChannelEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
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

        public static EntityTypeEnum fromValue(String text) {
            for (EntityTypeEnum b : EntityTypeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
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

        public static ShopperInteractionEnum fromValue(String text) {
            for (ShopperInteractionEnum b : ShopperInteractionEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
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


}



