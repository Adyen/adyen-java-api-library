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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model;

import com.adyen.constants.ApiConstants;
import com.adyen.model.applicationinfo.ApplicationInfo;
import com.adyen.model.recurring.Recurring;
import com.adyen.serializer.DateSerializer;
import com.adyen.serializer.DateTimeGMTSerializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * AbstractPaymentRequest Base for PaymentRequest and PaymentRequest3D
 */
public abstract class AbstractPaymentRequest<T extends AbstractPaymentRequest<T>> {
    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("reference")
    private String reference = null;

    @SerializedName("billingAddress")
    private Address billingAddress = null;

    @SerializedName("shopperIP")
    private String shopperIP = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("browserInfo")
    private BrowserInfo browserInfo = null;

    /**
     * how the shopper interacts with the system
     */
    public enum ShopperInteractionEnum {
        @SerializedName("Ecommerce") ECOMMERCE("Ecommerce"),

        @SerializedName("ContAuth") CONTAUTH("ContAuth"),

        @SerializedName("Moto") MOTO("Moto");

        private String value;

        ShopperInteractionEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("shopperInteraction")
    private ShopperInteractionEnum shopperInteraction = null;

    @SerializedName("shopperEmail")
    private String shopperEmail = null;

    @SerializedName("shopperReference")
    private String shopperReference = null;

    @SerializedName("recurring")
    private Recurring recurring = null;

    @SerializedName("shopperStatement")
    private String shopperStatement = null;

    @SerializedName("fraudOffset")
    private Integer fraudOffset = null;

    /**
     * How to process a combo card (for some Brazilian cards only). Allowed values: * debit * credit
     */
    public enum FundingSourceEnum {

        @SerializedName("debit") DEBIT("debit"),
        @SerializedName("credit") CREDIT("credit");

        private String value;

        FundingSourceEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("fundingSource")
    private FundingSourceEnum fundingSource = null;

    @SerializedName("sessionId")
    private String sessionId = null;

    @SerializedName("additionalAmount")
    private Amount additionalAmount = null;

    @SerializedName("selectedRecurringDetailReference")
    private String selectedRecurringDetailReference = null;

    @SerializedName("orderReference")
    private String orderReference = null;

    @SerializedName("merchantOrderReference")
    private String merchantOrderReference = null;

    @SerializedName("dccQuote")
    private ForexQuote dccQuote = null;

    @SerializedName("additionalData")
    private Map<String, String> additionalData = null;

    @SerializedName("shopperName")
    private Name shopperName = null;

    @SerializedName("shopperLocale")
    private String shopperLocale = null;

    @SerializedName("selectedBrand")
    private String selectedBrand = null;

    @SerializedName("deliveryAddress")
    private Address deliveryAddress = null;

    @SerializedName("deliveryDate")
    @JsonAdapter(DateTimeGMTSerializer.class)
    private Date deliveryDate = null;

    @SerializedName("deviceFingerprint")
    private String deviceFingerprint = null;

    @SerializedName("installments")
    private Installments installments = null;

    @SerializedName("socialSecurityNumber")
    private String socialSecurityNumber = null;

    @SerializedName("captureDelayHours")
    private Integer captureDelayHours = null;

    @SerializedName("dateOfBirth")
    @JsonAdapter(DateSerializer.class)
    private Date dateOfBirth = null;

    @SerializedName("telephoneNumber")
    private String telephoneNumber = null;

    @SerializedName("mcc")
    private String mcc = null;

    @SerializedName("metadata")
    private Map<String, String> metadata = null;

    @SerializedName("applicationInfo")
    private ApplicationInfo applicationInfo;

    @SerializedName("enableRealTimeUpdate")
    private Boolean enableRealTimeUpdate = null;

    @SerializedName("threeDSAuthenticationOnly")
    private Boolean threeDSAuthenticationOnly = null;

    public AbstractPaymentRequest() {
        applicationInfo = new ApplicationInfo();
    }

    /**
     * Set browser data
     *
     * @param userAgent    http header
     * @param acceptHeader http header
     * @return browser data
     */
    public T setBrowserInfoData(String userAgent, String acceptHeader) {
        BrowserInfo browserInfo = new BrowserInfo();
        browserInfo.setAcceptHeader(acceptHeader);
        browserInfo.setUserAgent(userAgent);

        this.setBrowserInfo(browserInfo);
        return (T) this;
    }

    /**
     * get additionalData map Create the map if doesn't exists
     *
     * @return additional data
     */
    public Map<String, String> getOrCreateAdditionalData() {
        if (this.getAdditionalData() == null) {
            this.setAdditionalData(new HashMap<>());
        }

        return this.getAdditionalData();
    }

    /**
     * the amount to charge
     *
     * @return amount
     **/
    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public T reference(String reference) {
        this.reference = reference;
        return (T) this;
    }

    /**
     * the reference assigned to the payment
     *
     * @return reference
     **/
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public T billingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
        return (T) this;
    }

    /**
     * the address where to send the invoice
     *
     * @return billingAddress
     **/
    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public T shopperIP(String shopperIP) {
        this.shopperIP = shopperIP;
        return (T) this;
    }

    /**
     * the IP address of the shopper
     *
     * @return shopperIP
     **/
    public String getShopperIP() {
        return shopperIP;
    }

    public void setShopperIP(String shopperIP) {
        this.shopperIP = shopperIP;
    }

    public T merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return (T) this;
    }

    /**
     * the merchant account which will be used to process the payment
     *
     * @return merchantAccount
     **/
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public T browserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
        return (T) this;
    }

    /**
     * the browser info data
     *
     * @return browserInfo
     **/
    public BrowserInfo getBrowserInfo() {
        return browserInfo;
    }

    public void setBrowserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
    }

    public T shopperInteraction(ShopperInteractionEnum shopperInteraction) {
        this.shopperInteraction = shopperInteraction;
        return (T) this;
    }

    /**
     * how the shopper interacts with the system
     *
     * @return shopperInteraction
     **/
    public ShopperInteractionEnum getShopperInteraction() {
        return shopperInteraction;
    }

    public void setShopperInteraction(ShopperInteractionEnum shopperInteraction) {
        this.shopperInteraction = shopperInteraction;
    }

    public T shopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
        return (T) this;
    }

    /**
     * the email address of the shopper / customer
     *
     * @return shopperEmail
     **/
    public String getShopperEmail() {
        return shopperEmail;
    }

    public void setShopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
    }

    public T shopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
        return (T) this;
    }

    /**
     * a reference used to uniquely identify the shopper (e.g. user ID or account ID)
     *
     * @return shopperReference
     **/
    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    public T recurring(Recurring recurring) {
        this.recurring = recurring;
        return (T) this;
    }

    /**
     * the recurring properties of the payment
     *
     * @return recurring
     **/
    public Recurring getRecurring() {
        return recurring;
    }

    public void setRecurring(Recurring recurring) {
        this.recurring = recurring;
    }

    public T shopperStatement(String shopperStatement) {
        this.shopperStatement = shopperStatement;
        return (T) this;
    }

    /**
     * the text to appear on the shopper's statement
     *
     * @return shopperStatement
     **/
    public String getShopperStatement() {
        return shopperStatement;
    }

    public void setShopperStatement(String shopperStatement) {
        this.shopperStatement = shopperStatement;
    }

    public T fraudOffset(Integer fraudOffset) {
        this.fraudOffset = fraudOffset;
        return (T) this;
    }

    /**
     * the offset that is added to the normal fraud score (positive or negative)
     *
     * @return fraudOffset
     **/
    public Integer getFraudOffset() {
        return fraudOffset;
    }

    public void setFraudOffset(Integer fraudOffset) {
        this.fraudOffset = fraudOffset;
    }

    public T sessionId(String sessionId) {
        this.sessionId = sessionId;
        return (T) this;
    }

    public T fundingSource(FundingSourceEnum fundingSource) {
        this.fundingSource = fundingSource;
        return (T) this;
    }

    /**
     * How to process a combo card (for some Brazilian cards only). Allowed values: * debit * credit
     *
     * @return fundingSource
     **/
    public FundingSourceEnum getFundingSource() {
        return fundingSource;
    }

    public void setFundingSource(FundingSourceEnum fundingSource) {
        this.fundingSource = fundingSource;
    }


    /**
     * Get sessionId
     *
     * @return sessionId
     **/
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public T additionalAmount(Amount additionalAmount) {
        this.additionalAmount = additionalAmount;
        return (T) this;
    }

    /**
     * the portion of the \"amount\" which is additional/surcharged. Required to be in the same currency as the amount.
     *
     * @return additionalAmount
     **/
    public Amount getAdditionalAmount() {
        return additionalAmount;
    }

    public void setAdditionalAmount(Amount additionalAmount) {
        this.additionalAmount = additionalAmount;
    }

    public T selectedRecurringDetailReference(String selectedRecurringDetailReference) {
        this.selectedRecurringDetailReference = selectedRecurringDetailReference;
        return (T) this;
    }

    /**
     * the recurringDetailReference you want to use for this payment
     *
     * @return selectedRecurringDetailReference
     **/
    public String getSelectedRecurringDetailReference() {
        return selectedRecurringDetailReference;
    }

    public void setSelectedRecurringDetailReference(String selectedRecurringDetailReference) {
        this.selectedRecurringDetailReference = selectedRecurringDetailReference;
    }

    public T orderReference(String orderReference) {
        this.orderReference = orderReference;
        return (T) this;
    }

    /**
     * the order reference to link multiple partial payments
     *
     * @return orderReference
     **/
    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public T merchantOrderReference(String merchantOrderReference) {
        this.merchantOrderReference = merchantOrderReference;
        return (T) this;
    }

    /**
     * the reference to link multiple transactions to each other
     *
     * @return merchantOrderReference
     **/
    public String getMerchantOrderReference() {
        return merchantOrderReference;
    }

    public void setMerchantOrderReference(String merchantOrderReference) {
        this.merchantOrderReference = merchantOrderReference;
    }

    public T dccQuote(ForexQuote dccQuote) {
        this.dccQuote = dccQuote;
        return (T) this;
    }

    /**
     * the forex quote as returned in the response of the forex service
     *
     * @return dccQuote
     **/
    public ForexQuote getDccQuote() {
        return dccQuote;
    }

    public void setDccQuote(ForexQuote dccQuote) {
        this.dccQuote = dccQuote;
    }

    public T additionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
        return (T) this;
    }

    /**
     * a map of name/value pairs for passing in additional/industry-specific data
     *
     * @return additionalData
     **/
    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    public T shopperName(Name shopperName) {
        this.shopperName = shopperName;
        return (T) this;
    }

    /**
     * the name of the shopper
     *
     * @return shopperName
     **/
    public Name getShopperName() {
        return shopperName;
    }

    public void setShopperName(Name shopperName) {
        this.shopperName = shopperName;
    }

    public T shopperLocale(String shopperLocale) {
        this.shopperLocale = shopperLocale;
        return (T) this;
    }

    /**
     * the combination of language code and country code to specify the language to be used in the payment
     *
     * @return shopperLocale
     **/
    public String getShopperLocale() {
        return shopperLocale;
    }

    public void setShopperLocale(String shopperLocale) {
        this.shopperLocale = shopperLocale;
    }

    public T selectedBrand(String selectedBrand) {
        this.selectedBrand = selectedBrand;
        return (T) this;
    }

    /**
     * the selected brand how to process the payment for dual branded cards
     *
     * @return selectedBrand
     **/
    public String getSelectedBrand() {
        return selectedBrand;
    }

    public void setSelectedBrand(String selectedBrand) {
        this.selectedBrand = selectedBrand;
    }

    public T deliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return (T) this;
    }

    /**
     * the address where to deliver
     *
     * @return deliveryAddress
     **/
    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public T deliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
        return (T) this;
    }

    /**
     * the expected date of delivery or fulfillment
     *
     * @return deliveryDate
     **/
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public T deviceFingerprint(String deviceFingerprint) {
        this.deviceFingerprint = deviceFingerprint;
        return (T) this;
    }

    /**
     * Get deviceFingerprint
     *
     * @return deviceFingerprint
     **/
    public String getDeviceFingerprint() {
        return deviceFingerprint;
    }

    public void setDeviceFingerprint(String deviceFingerprint) {
        this.deviceFingerprint = deviceFingerprint;
    }

    public T installments(Installments installments) {
        this.installments = installments;
        return (T) this;
    }

    /**
     * the installment properties of the payment
     *
     * @return installments
     **/
    public Installments getInstallments() {
        return installments;
    }

    public void setInstallments(Installments installments) {
        this.installments = installments;
    }

    public T socialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
        return (T) this;
    }

    /**
     * the shopper's social security number
     *
     * @return socialSecurityNumber
     **/
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public T captureDelayHours(Integer captureDelayHours) {
        this.captureDelayHours = captureDelayHours;
        return (T) this;
    }

    /**
     * the number of hours delay between the authorisation and scheduled auto-capture
     *
     * @return captureDelayHours
     **/
    public Integer getCaptureDelayHours() {
        return captureDelayHours;
    }

    public void setCaptureDelayHours(Integer captureDelayHours) {
        this.captureDelayHours = captureDelayHours;
    }

    public T dateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return (T) this;
    }

    /**
     * the shopper's date of birth
     *
     * @return dateOfBirth
     **/
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public T telephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return (T) this;
    }

    /**
     * the shopper's telephone number
     *
     * @return telephoneNumber
     **/
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public T mcc(String mcc) {
        this.mcc = mcc;
        return (T) this;
    }

    /**
     * the mcc value that is required to process this payment
     *
     * @return mcc
     **/
    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public T metadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return (T) this;
    }

    public ApplicationInfo getApplicationInfo() {
        return applicationInfo;
    }

    /**
     * a map of key/value pairs of metadata sent by merchant
     *
     * @return metadata
     **/
    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public T enableRealTimeUpdate(Boolean enableRealTimeUpdate) {
        this.enableRealTimeUpdate = enableRealTimeUpdate;
        return (T) this;
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

    public T threeDSAuthenticationOnly(Boolean threeDSAuthenticationOnly) {
        this.threeDSAuthenticationOnly = threeDSAuthenticationOnly;
        return (T) this;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractPaymentRequest paymentRequest = (AbstractPaymentRequest) o;
        return Objects.equals(this.amount, paymentRequest.amount)
                && Objects.equals(this.reference, paymentRequest.reference)
                && Objects.equals(this.billingAddress, paymentRequest.billingAddress)
                && Objects.equals(this.shopperIP, paymentRequest.shopperIP)
                && Objects.equals(this.merchantAccount, paymentRequest.merchantAccount)
                && Objects.equals(this.browserInfo, paymentRequest.browserInfo)
                && Objects.equals(this.shopperInteraction, paymentRequest.shopperInteraction)
                && Objects.equals(this.shopperEmail, paymentRequest.shopperEmail)
                && Objects.equals(this.shopperReference, paymentRequest.shopperReference)
                && Objects.equals(this.recurring, paymentRequest.recurring)
                && Objects.equals(this.shopperStatement, paymentRequest.shopperStatement)
                && Objects.equals(this.fraudOffset, paymentRequest.fraudOffset)
                && Objects.equals(this.fundingSource, paymentRequest.fundingSource)
                && Objects.equals(this.sessionId, paymentRequest.sessionId)
                && Objects.equals(this.additionalAmount, paymentRequest.additionalAmount)
                && Objects.equals(this.selectedRecurringDetailReference, paymentRequest.selectedRecurringDetailReference)
                && Objects.equals(this.orderReference, paymentRequest.orderReference)
                && Objects.equals(this.merchantOrderReference, paymentRequest.merchantOrderReference)
                && Objects.equals(this.dccQuote, paymentRequest.dccQuote)
                && Objects.equals(this.additionalData, paymentRequest.additionalData)
                && Objects.equals(this.shopperName, paymentRequest.shopperName)
                && Objects.equals(this.shopperLocale, paymentRequest.shopperLocale)
                && Objects.equals(this.selectedBrand, paymentRequest.selectedBrand)
                && Objects.equals(this.deliveryAddress, paymentRequest.deliveryAddress)
                && Objects.equals(this.deliveryDate, paymentRequest.deliveryDate)
                && Objects.equals(this.deviceFingerprint, paymentRequest.deviceFingerprint)
                && Objects.equals(this.installments, paymentRequest.installments)
                && Objects.equals(this.socialSecurityNumber, paymentRequest.socialSecurityNumber)
                && Objects.equals(this.captureDelayHours, paymentRequest.captureDelayHours)
                && Objects.equals(this.dateOfBirth, paymentRequest.dateOfBirth)
                && Objects.equals(this.telephoneNumber, paymentRequest.telephoneNumber)
                && Objects.equals(this.mcc, paymentRequest.mcc)
                && Objects.equals(this.metadata, paymentRequest.metadata)
                && Objects.equals(this.applicationInfo, paymentRequest.applicationInfo)
                && Objects.equals(this.enableRealTimeUpdate, paymentRequest.enableRealTimeUpdate)
                && Objects.equals(this.threeDSAuthenticationOnly, paymentRequest.threeDSAuthenticationOnly);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount,
                reference,
                billingAddress,
                shopperIP,
                merchantAccount,
                browserInfo,
                shopperInteraction,
                shopperEmail,
                shopperReference,
                recurring,
                shopperStatement,
                fraudOffset,
                fundingSource,
                sessionId,
                additionalAmount,
                selectedRecurringDetailReference,
                orderReference,
                merchantOrderReference,
                dccQuote,
                additionalData,
                shopperName,
                shopperLocale,
                selectedBrand,
                deliveryAddress,
                deliveryDate,
                deviceFingerprint,
                installments,
                socialSecurityNumber,
                captureDelayHours,
                dateOfBirth,
                telephoneNumber,
                mcc,
                metadata,
                applicationInfo,
                enableRealTimeUpdate,
                threeDSAuthenticationOnly);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
        sb.append("    shopperIP: ").append(toIndentedString(shopperIP)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    browserInfo: ").append(toIndentedString(browserInfo)).append("\n");
        sb.append("    shopperInteraction: ").append(toIndentedString(shopperInteraction)).append("\n");
        sb.append("    shopperEmail: ").append(toIndentedString(shopperEmail)).append("\n");
        sb.append("    shopperReference: ").append(toIndentedString(shopperReference)).append("\n");
        sb.append("    recurring: ").append(toIndentedString(recurring)).append("\n");
        sb.append("    shopperStatement: ").append(toIndentedString(shopperStatement)).append("\n");
        sb.append("    fraudOffset: ").append(toIndentedString(fraudOffset)).append("\n");
        sb.append("    fundingSource: ").append(toIndentedString(fundingSource)).append("\n");
        sb.append("    sessionId: ").append(toIndentedString(sessionId)).append("\n");
        sb.append("    additionalAmount: ").append(toIndentedString(additionalAmount)).append("\n");
        sb.append("    selectedRecurringDetailReference: ").append(toIndentedString(selectedRecurringDetailReference)).append("\n");
        sb.append("    orderReference: ").append(toIndentedString(orderReference)).append("\n");
        sb.append("    merchantOrderReference: ").append(toIndentedString(merchantOrderReference)).append("\n");
        sb.append("    dccQuote: ").append(toIndentedString(dccQuote)).append("\n");
        sb.append("    additionalData: ").append(toIndentedString(stringifyAdditionalData())).append("\n");
        sb.append("    shopperName: ").append(toIndentedString(shopperName)).append("\n");
        sb.append("    shopperLocale: ").append(toIndentedString(shopperLocale)).append("\n");
        sb.append("    selectedBrand: ").append(toIndentedString(selectedBrand)).append("\n");
        sb.append("    deliveryAddress: ").append(toIndentedString(deliveryAddress)).append("\n");
        sb.append("    deliveryDate: ").append(toIndentedString(deliveryDate)).append("\n");
        sb.append("    deviceFingerprint: ").append(toIndentedString(deviceFingerprint)).append("\n");
        sb.append("    installments: ").append(toIndentedString(installments)).append("\n");
        sb.append("    socialSecurityNumber: ").append(toIndentedString(socialSecurityNumber)).append("\n");
        sb.append("    captureDelayHours: ").append(toIndentedString(captureDelayHours)).append("\n");
        sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
        sb.append("    telephoneNumber: ").append(toIndentedString(telephoneNumber)).append("\n");
        sb.append("    mcc: ").append(toIndentedString(mcc)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    applicationInfo: ").append(toIndentedString(applicationInfo)).append("\n");
        sb.append("    enableRealTimeUpdate: ").append(toIndentedString(enableRealTimeUpdate)).append("\n");
        sb.append("    threeDSAuthenticationOnly: ").append(toIndentedString(threeDSAuthenticationOnly)).append("\n");

        return sb.toString();
    }

    private String stringifyAdditionalData() {
        if (additionalData == null) {
            return null;
        }

        Map<String, String> nonSensitiveAdditionalData = new HashMap<>(additionalData);
        List<String> keys = Arrays.asList(ApiConstants.AdditionalData.Card.Encrypted.JSON,
                ApiConstants.AdditionalData.ENCRYPTED_CARD_NUMBER,
                ApiConstants.AdditionalData.ENCRYPTED_EXPIRY_MONTH,
                ApiConstants.AdditionalData.ENCRYPTED_EXPIRY_YEAR,
                ApiConstants.AdditionalData.ENCRYPTED_SECURITY_CODE);

        keys.stream().forEach(s -> nonSensitiveAdditionalData.computeIfPresent(s, (s1, s2) -> "***"));

        return nonSensitiveAdditionalData.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
