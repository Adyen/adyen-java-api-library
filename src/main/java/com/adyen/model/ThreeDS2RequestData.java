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
 * Copyright (c) 2022 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import com.adyen.model.checkout.Phone;

import java.io.IOException;
import java.util.Objects;


/**
 * ThreeDS2RequestData
 */
public class ThreeDS2RequestData {
    @SerializedName("acctInfo")
    private AcctInfo acctInfo = null;

    /**
     * Indicates the type of account. For example, for a multi-account card product. Length: 2 characters. Allowed values: * **01** — Not applicable * **02** — Credit * **03** — Debit
     */
    @JsonAdapter(AcctTypeEnum.Adapter.class)
    public enum AcctTypeEnum {
        _01("01"),
        _02("02"),
        _03("03");

        @JsonValue
        private final String value;

        AcctTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static AcctTypeEnum fromValue(String input) {
            for (AcctTypeEnum b : AcctTypeEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<AcctTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final AcctTypeEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public AcctTypeEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return AcctTypeEnum.fromValue((String) (value));
            }
        }
    }

    @SerializedName("acctType")
    private AcctTypeEnum acctType = null;

    @SerializedName("acquirerBIN")
    private String acquirerBIN = null;

    @SerializedName("acquirerMerchantID")
    private String acquirerMerchantID = null;

    /**
     * Indicates whether the Cardholder Shipping Address and Cardholder Billing Address are the same. Allowed values: * **Y** — Shipping Address matches Billing Address. * **N** — Shipping Address does not match Billing Address.
     */
    @JsonAdapter(AddrMatchEnum.Adapter.class)
    public enum AddrMatchEnum {
        Y("Y"),
        N("N");

        @JsonValue
        private final String value;

        AddrMatchEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static AddrMatchEnum fromValue(String input) {
            for (AddrMatchEnum b : AddrMatchEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<AddrMatchEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final AddrMatchEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public AddrMatchEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return AddrMatchEnum.fromValue((String) (value));
            }
        }
    }

    @SerializedName("addrMatch")
    private AddrMatchEnum addrMatch = null;

    @SerializedName("authenticationOnly")
    private Boolean authenticationOnly = false;

    /**
     * Possibility to specify a preference for receiving a challenge from the issuer. Allowed values: * &#x60;noPreference&#x60; * &#x60;requestNoChallenge&#x60; * &#x60;requestChallenge&#x60; * &#x60;requestChallengeAsMandate&#x60;
     */
    @JsonAdapter(ChallengeIndicatorEnum.Adapter.class)
    public enum ChallengeIndicatorEnum {
        NOPREFERENCE("noPreference"),
        REQUESTNOCHALLENGE("requestNoChallenge"),
        REQUESTCHALLENGE("requestChallenge"),
        REQUESTCHALLENGEASMANDATE("requestChallengeAsMandate");

        @JsonValue
        private final String value;

        ChallengeIndicatorEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static ChallengeIndicatorEnum fromValue(String input) {
            for (ChallengeIndicatorEnum b : ChallengeIndicatorEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<ChallengeIndicatorEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ChallengeIndicatorEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public ChallengeIndicatorEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return ChallengeIndicatorEnum.fromValue((String) (value));
            }
        }
    }

    @SerializedName("challengeIndicator")
    private ChallengeIndicatorEnum challengeIndicator = null;

    @SerializedName("deviceChannel")
    private String deviceChannel = null;

    @SerializedName("deviceRenderOptions")
    private DeviceRenderOptions deviceRenderOptions = null;

    @SerializedName("homePhone")
    private Phone homePhone = null;

    @SerializedName("mcc")
    private String mcc = null;

    @SerializedName("merchantName")
    private String merchantName = null;

    @SerializedName("messageVersion")
    private String messageVersion = "2.1.0";

    @SerializedName("mobilePhone")
    private Phone mobilePhone = null;

    @SerializedName("notificationURL")
    private String notificationURL = null;

    @SerializedName("payTokenInd")
    private Boolean payTokenInd = null;

    @SerializedName("paymentAuthenticationUseCase")
    private String paymentAuthenticationUseCase = null;

    @SerializedName("purchaseInstalData")
    private String purchaseInstalData = null;

    @SerializedName("recurringExpiry")
    private String recurringExpiry = null;

    @SerializedName("recurringFrequency")
    private String recurringFrequency = null;

    @SerializedName("sdkAppID")
    private String sdkAppID = null;

    @SerializedName("sdkEncData")
    private String sdkEncData = null;

    @SerializedName("sdkEphemPubKey")
    private SDKEphemPubKey sdkEphemPubKey = null;

    @SerializedName("sdkMaxTimeout")
    private Integer sdkMaxTimeout = 60;

    @SerializedName("sdkReferenceNumber")
    private String sdkReferenceNumber = null;

    @SerializedName("sdkTransID")
    private String sdkTransID = null;

    @SerializedName("sdkVersion")
    private String sdkVersion = null;

    @SerializedName("threeDSCompInd")
    private String threeDSCompInd = null;

    @SerializedName("threeDSRequestorAuthenticationInd")
    private String threeDSRequestorAuthenticationInd = null;

    @SerializedName("threeDSRequestorAuthenticationInfo")
    private ThreeDSRequestorAuthenticationInfo threeDSRequestorAuthenticationInfo = null;

    /**
     * Indicates whether a challenge is requested for this transaction. Possible values: * **01** — No preference * **02** — No challenge requested * **03** — Challenge requested (3DS Requestor preference) * **04** — Challenge requested (Mandate) * **05** — No challenge (transactional risk analysis is already performed)
     */
    @JsonAdapter(ThreeDSRequestorChallengeIndEnum.Adapter.class)
    public enum ThreeDSRequestorChallengeIndEnum {
        _01("01"),
        _02("02"),
        _03("03"),
        _04("04"),
        _05("05");

        @JsonValue
        private final String value;

        ThreeDSRequestorChallengeIndEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static ThreeDSRequestorChallengeIndEnum fromValue(String input) {
            for (ThreeDSRequestorChallengeIndEnum b : ThreeDSRequestorChallengeIndEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<ThreeDSRequestorChallengeIndEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ThreeDSRequestorChallengeIndEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public ThreeDSRequestorChallengeIndEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return ThreeDSRequestorChallengeIndEnum.fromValue((String) (value));
            }
        }
    }

    @SerializedName("threeDSRequestorChallengeInd")
    private ThreeDSRequestorChallengeIndEnum threeDSRequestorChallengeInd = null;

    @SerializedName("threeDSRequestorID")
    private String threeDSRequestorID = null;

    @SerializedName("threeDSRequestorName")
    private String threeDSRequestorName = null;

    @SerializedName("threeDSRequestorPriorAuthenticationInfo")
    private ThreeDSRequestorPriorAuthenticationInfo threeDSRequestorPriorAuthenticationInfo = null;

    @SerializedName("threeDSRequestorURL")
    private String threeDSRequestorURL = null;

    /**
     * Identifies the type of transaction being authenticated. Length: 2 characters. Allowed values: * **01** — Goods/Service Purchase * **03** — Check Acceptance * **10** — Account Funding * **11** — Quasi-Cash Transaction * **28** — Prepaid Activation and Load
     */
    @JsonAdapter(TransTypeEnum.Adapter.class)
    public enum TransTypeEnum {
        _01("01"),
        _03("03"),
        _10("10"),
        _11("11"),
        _28("28");

        @JsonValue
        private final String value;

        TransTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static TransTypeEnum fromValue(String input) {
            for (TransTypeEnum b : TransTypeEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<TransTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TransTypeEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public TransTypeEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return TransTypeEnum.fromValue((String) (value));
            }
        }
    }

    @SerializedName("transType")
    private TransTypeEnum transType = null;

    /**
     * Identify the type of the transaction being authenticated.
     */
    @JsonAdapter(TransactionTypeEnum.Adapter.class)
    public enum TransactionTypeEnum {
        GOODSORSERVICEPURCHASE("goodsOrServicePurchase"),
        CHECKACCEPTANCE("checkAcceptance"),
        ACCOUNTFUNDING("accountFunding"),
        QUASICASHTRANSACTION("quasiCashTransaction"),
        PREPAIDACTIVATIONANDLOAD("prepaidActivationAndLoad");

        @JsonValue
        private final String value;

        TransactionTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static TransactionTypeEnum fromValue(String input) {
            for (TransactionTypeEnum b : TransactionTypeEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<TransactionTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TransactionTypeEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public TransactionTypeEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return TransactionTypeEnum.fromValue((String) (value));
            }
        }
    }

    @SerializedName("transactionType")
    private TransactionTypeEnum transactionType = null;

    @SerializedName("whiteListStatus")
    private String whiteListStatus = null;

    @SerializedName("workPhone")
    private Phone workPhone = null;

    public ThreeDS2RequestData acctInfo(AcctInfo acctInfo) {
        this.acctInfo = acctInfo;
        return this;
    }

    /**
     * Get acctInfo
     *
     * @return acctInfo
     **/
    public AcctInfo getAcctInfo() {
        return acctInfo;
    }

    public void setAcctInfo(AcctInfo acctInfo) {
        this.acctInfo = acctInfo;
    }

    public ThreeDS2RequestData acctType(AcctTypeEnum acctType) {
        this.acctType = acctType;
        return this;
    }

    /**
     * Indicates the type of account. For example, for a multi-account card product. Length: 2 characters. Allowed values: * **01** — Not applicable * **02** — Credit * **03** — Debit
     *
     * @return acctType
     **/
    public AcctTypeEnum getAcctType() {
        return acctType;
    }

    public void setAcctType(AcctTypeEnum acctType) {
        this.acctType = acctType;
    }

    public ThreeDS2RequestData acquirerBIN(String acquirerBIN) {
        this.acquirerBIN = acquirerBIN;
        return this;
    }

    /**
     * Required for [authentication-only integration](https://docs.adyen.com/online-payments/3d-secure/other-3ds-flows/authentication-only). The acquiring BIN enrolled for 3D Secure 2. This string should match the value that you will use in the authorisation. Use 123456 on the Test platform.
     *
     * @return acquirerBIN
     **/
    public String getAcquirerBIN() {
        return acquirerBIN;
    }

    public void setAcquirerBIN(String acquirerBIN) {
        this.acquirerBIN = acquirerBIN;
    }

    public ThreeDS2RequestData acquirerMerchantID(String acquirerMerchantID) {
        this.acquirerMerchantID = acquirerMerchantID;
        return this;
    }

    /**
     * Required for [authentication-only integration](https://docs.adyen.com/online-payments/3d-secure/other-3ds-flows/authentication-only). The merchantId that is enrolled for 3D Secure 2 by the merchant&#x27;s acquirer. This string should match the value that you will use in the authorisation. Use 123456 on the Test platform.
     *
     * @return acquirerMerchantID
     **/
    public String getAcquirerMerchantID() {
        return acquirerMerchantID;
    }

    public void setAcquirerMerchantID(String acquirerMerchantID) {
        this.acquirerMerchantID = acquirerMerchantID;
    }

    public ThreeDS2RequestData addrMatch(AddrMatchEnum addrMatch) {
        this.addrMatch = addrMatch;
        return this;
    }

    /**
     * Indicates whether the Cardholder Shipping Address and Cardholder Billing Address are the same. Allowed values: * **Y** — Shipping Address matches Billing Address. * **N** — Shipping Address does not match Billing Address.
     *
     * @return addrMatch
     **/
    public AddrMatchEnum getAddrMatch() {
        return addrMatch;
    }

    public void setAddrMatch(AddrMatchEnum addrMatch) {
        this.addrMatch = addrMatch;
    }

    public ThreeDS2RequestData authenticationOnly(Boolean authenticationOnly) {
        this.authenticationOnly = authenticationOnly;
        return this;
    }

    /**
     * If set to true, you will only perform the [3D Secure 2 authentication](https://docs.adyen.com/online-payments/3d-secure/other-3ds-flows/authentication-only), and not the payment authorisation.
     *
     * @return authenticationOnly
     **/
    public Boolean isAuthenticationOnly() {
        return authenticationOnly;
    }

    public void setAuthenticationOnly(Boolean authenticationOnly) {
        this.authenticationOnly = authenticationOnly;
    }

    public ThreeDS2RequestData challengeIndicator(ChallengeIndicatorEnum challengeIndicator) {
        this.challengeIndicator = challengeIndicator;
        return this;
    }

    /**
     * Possibility to specify a preference for receiving a challenge from the issuer. Allowed values: * &#x60;noPreference&#x60; * &#x60;requestNoChallenge&#x60; * &#x60;requestChallenge&#x60; * &#x60;requestChallengeAsMandate&#x60;
     *
     * @return challengeIndicator
     **/
    public ChallengeIndicatorEnum getChallengeIndicator() {
        return challengeIndicator;
    }

    public void setChallengeIndicator(ChallengeIndicatorEnum challengeIndicator) {
        this.challengeIndicator = challengeIndicator;
    }

    public ThreeDS2RequestData deviceChannel(String deviceChannel) {
        this.deviceChannel = deviceChannel;
        return this;
    }

    /**
     * The environment of the shopper. Allowed values: * &#x60;app&#x60; * &#x60;browser&#x60;
     *
     * @return deviceChannel
     **/
    public String getDeviceChannel() {
        return deviceChannel;
    }

    public void setDeviceChannel(String deviceChannel) {
        this.deviceChannel = deviceChannel;
    }

    public ThreeDS2RequestData deviceRenderOptions(DeviceRenderOptions deviceRenderOptions) {
        this.deviceRenderOptions = deviceRenderOptions;
        return this;
    }

    /**
     * Get deviceRenderOptions
     *
     * @return deviceRenderOptions
     **/
    public DeviceRenderOptions getDeviceRenderOptions() {
        return deviceRenderOptions;
    }

    public void setDeviceRenderOptions(DeviceRenderOptions deviceRenderOptions) {
        this.deviceRenderOptions = deviceRenderOptions;
    }

    public ThreeDS2RequestData homePhone(Phone homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    /**
     * Get homePhone
     *
     * @return homePhone
     **/
    public Phone getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(Phone homePhone) {
        this.homePhone = homePhone;
    }

    public ThreeDS2RequestData mcc(String mcc) {
        this.mcc = mcc;
        return this;
    }

    /**
     * Required for merchants that have been enrolled for 3D Secure 2 by another party than Adyen, mostly [authentication-only integrations](https://docs.adyen.com/online-payments/3d-secure/other-3ds-flows/authentication-only). The &#x60;mcc&#x60; is a four-digit code with which the previously given &#x60;acquirerMerchantID&#x60; is registered at the scheme.
     *
     * @return mcc
     **/
    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public ThreeDS2RequestData merchantName(String merchantName) {
        this.merchantName = merchantName;
        return this;
    }

    /**
     * Required for [authentication-only integration](https://docs.adyen.com/online-payments/3d-secure/other-3ds-flows/authentication-only). The merchant name that the issuer presents to the shopper if they get a challenge. We recommend to use the same value that you will use in the authorization. Maximum length is 40 characters. &gt; Optional for a [full 3D Secure 2 integration](https://docs.adyen.com/online-payments/3d-secure/native-3ds2/api-integration). Use this field if you are enrolled for 3D Secure 2 with us and want to override the merchant name already configured on your account.
     *
     * @return merchantName
     **/
    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public ThreeDS2RequestData messageVersion(String messageVersion) {
        this.messageVersion = messageVersion;
        return this;
    }

    /**
     * The &#x60;messageVersion&#x60; value indicating the 3D Secure 2 protocol version.
     *
     * @return messageVersion
     **/
    public String getMessageVersion() {
        return messageVersion;
    }

    public void setMessageVersion(String messageVersion) {
        this.messageVersion = messageVersion;
    }

    public ThreeDS2RequestData mobilePhone(Phone mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    /**
     * Get mobilePhone
     *
     * @return mobilePhone
     **/
    public Phone getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(Phone mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public ThreeDS2RequestData notificationURL(String notificationURL) {
        this.notificationURL = notificationURL;
        return this;
    }

    /**
     * URL to where the issuer should send the &#x60;CRes&#x60;. Required if you are not using components for &#x60;channel&#x60; **Web** or if you are using classic integration &#x60;deviceChannel&#x60; **browser**.
     *
     * @return notificationURL
     **/
    public String getNotificationURL() {
        return notificationURL;
    }

    public void setNotificationURL(String notificationURL) {
        this.notificationURL = notificationURL;
    }

    public ThreeDS2RequestData payTokenInd(Boolean payTokenInd) {
        this.payTokenInd = payTokenInd;
        return this;
    }

    /**
     * Value **true** indicates that the transaction was de-tokenised prior to being received by the ACS.
     *
     * @return payTokenInd
     **/
    public Boolean isPayTokenInd() {
        return payTokenInd;
    }

    public void setPayTokenInd(Boolean payTokenInd) {
        this.payTokenInd = payTokenInd;
    }

    public ThreeDS2RequestData paymentAuthenticationUseCase(String paymentAuthenticationUseCase) {
        this.paymentAuthenticationUseCase = paymentAuthenticationUseCase;
        return this;
    }

    /**
     * Indicates the type of payment for which an authentication is requested (message extension)
     *
     * @return paymentAuthenticationUseCase
     **/
    public String getPaymentAuthenticationUseCase() {
        return paymentAuthenticationUseCase;
    }

    public void setPaymentAuthenticationUseCase(String paymentAuthenticationUseCase) {
        this.paymentAuthenticationUseCase = paymentAuthenticationUseCase;
    }

    public ThreeDS2RequestData purchaseInstalData(String purchaseInstalData) {
        this.purchaseInstalData = purchaseInstalData;
        return this;
    }

    /**
     * Indicates the maximum number of authorisations permitted for instalment payments. Length: 1–3 characters.
     *
     * @return purchaseInstalData
     **/
    public String getPurchaseInstalData() {
        return purchaseInstalData;
    }

    public void setPurchaseInstalData(String purchaseInstalData) {
        this.purchaseInstalData = purchaseInstalData;
    }

    public ThreeDS2RequestData recurringExpiry(String recurringExpiry) {
        this.recurringExpiry = recurringExpiry;
        return this;
    }

    /**
     * Date after which no further authorisations shall be performed. Format: YYYYMMDD
     *
     * @return recurringExpiry
     **/
    public String getRecurringExpiry() {
        return recurringExpiry;
    }

    public void setRecurringExpiry(String recurringExpiry) {
        this.recurringExpiry = recurringExpiry;
    }

    public ThreeDS2RequestData recurringFrequency(String recurringFrequency) {
        this.recurringFrequency = recurringFrequency;
        return this;
    }

    /**
     * Indicates the minimum number of days between authorisations. Maximum length: 4 characters.
     *
     * @return recurringFrequency
     **/
    public String getRecurringFrequency() {
        return recurringFrequency;
    }

    public void setRecurringFrequency(String recurringFrequency) {
        this.recurringFrequency = recurringFrequency;
    }

    public ThreeDS2RequestData sdkAppID(String sdkAppID) {
        this.sdkAppID = sdkAppID;
        return this;
    }

    /**
     * The &#x60;sdkAppID&#x60; value as received from the 3D Secure 2 SDK. Required for &#x60;deviceChannel&#x60; set to **app**.
     *
     * @return sdkAppID
     **/
    public String getSdkAppID() {
        return sdkAppID;
    }

    public void setSdkAppID(String sdkAppID) {
        this.sdkAppID = sdkAppID;
    }

    public ThreeDS2RequestData sdkEncData(String sdkEncData) {
        this.sdkEncData = sdkEncData;
        return this;
    }

    /**
     * The &#x60;sdkEncData&#x60; value as received from the 3D Secure 2 SDK. Required for &#x60;deviceChannel&#x60; set to **app**.
     *
     * @return sdkEncData
     **/
    public String getSdkEncData() {
        return sdkEncData;
    }

    public void setSdkEncData(String sdkEncData) {
        this.sdkEncData = sdkEncData;
    }

    public ThreeDS2RequestData sdkEphemPubKey(SDKEphemPubKey sdkEphemPubKey) {
        this.sdkEphemPubKey = sdkEphemPubKey;
        return this;
    }

    /**
     * Get sdkEphemPubKey
     *
     * @return sdkEphemPubKey
     **/
    public SDKEphemPubKey getSdkEphemPubKey() {
        return sdkEphemPubKey;
    }

    public void setSdkEphemPubKey(SDKEphemPubKey sdkEphemPubKey) {
        this.sdkEphemPubKey = sdkEphemPubKey;
    }

    public ThreeDS2RequestData sdkMaxTimeout(Integer sdkMaxTimeout) {
        this.sdkMaxTimeout = sdkMaxTimeout;
        return this;
    }

    /**
     * The maximum amount of time in minutes for the 3D Secure 2 authentication process. Optional and only for &#x60;deviceChannel&#x60; set to **app**. Defaults to **60** minutes.
     *
     * @return sdkMaxTimeout
     **/
    public Integer getSdkMaxTimeout() {
        return sdkMaxTimeout;
    }

    public void setSdkMaxTimeout(Integer sdkMaxTimeout) {
        this.sdkMaxTimeout = sdkMaxTimeout;
    }

    public ThreeDS2RequestData sdkReferenceNumber(String sdkReferenceNumber) {
        this.sdkReferenceNumber = sdkReferenceNumber;
        return this;
    }

    /**
     * The &#x60;sdkReferenceNumber&#x60; value as received from the 3D Secure 2 SDK. Only for &#x60;deviceChannel&#x60; set to **app**.
     *
     * @return sdkReferenceNumber
     **/
    public String getSdkReferenceNumber() {
        return sdkReferenceNumber;
    }

    public void setSdkReferenceNumber(String sdkReferenceNumber) {
        this.sdkReferenceNumber = sdkReferenceNumber;
    }

    public ThreeDS2RequestData sdkTransID(String sdkTransID) {
        this.sdkTransID = sdkTransID;
        return this;
    }

    /**
     * The &#x60;sdkTransID&#x60; value as received from the 3D Secure 2 SDK. Only for &#x60;deviceChannel&#x60; set to **app**.
     *
     * @return sdkTransID
     **/
    public String getSdkTransID() {
        return sdkTransID;
    }

    public void setSdkTransID(String sdkTransID) {
        this.sdkTransID = sdkTransID;
    }

    public ThreeDS2RequestData sdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
        return this;
    }

    /**
     * Version of the 3D Secure 2 mobile SDK.  Only for &#x60;deviceChannel&#x60; set to **app**.
     *
     * @return sdkVersion
     **/
    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public ThreeDS2RequestData threeDSCompInd(String threeDSCompInd) {
        this.threeDSCompInd = threeDSCompInd;
        return this;
    }

    /**
     * Completion indicator for the device fingerprinting.
     *
     * @return threeDSCompInd
     **/
    public String getThreeDSCompInd() {
        return threeDSCompInd;
    }

    public void setThreeDSCompInd(String threeDSCompInd) {
        this.threeDSCompInd = threeDSCompInd;
    }

    public ThreeDS2RequestData threeDSRequestorAuthenticationInd(String threeDSRequestorAuthenticationInd) {
        this.threeDSRequestorAuthenticationInd = threeDSRequestorAuthenticationInd;
        return this;
    }

    /**
     * Indicates the type of Authentication request.
     *
     * @return threeDSRequestorAuthenticationInd
     **/
    public String getThreeDSRequestorAuthenticationInd() {
        return threeDSRequestorAuthenticationInd;
    }

    public void setThreeDSRequestorAuthenticationInd(String threeDSRequestorAuthenticationInd) {
        this.threeDSRequestorAuthenticationInd = threeDSRequestorAuthenticationInd;
    }

    public ThreeDS2RequestData threeDSRequestorAuthenticationInfo(ThreeDSRequestorAuthenticationInfo threeDSRequestorAuthenticationInfo) {
        this.threeDSRequestorAuthenticationInfo = threeDSRequestorAuthenticationInfo;
        return this;
    }

    /**
     * Get threeDSRequestorAuthenticationInfo
     *
     * @return threeDSRequestorAuthenticationInfo
     **/
    public ThreeDSRequestorAuthenticationInfo getThreeDSRequestorAuthenticationInfo() {
        return threeDSRequestorAuthenticationInfo;
    }

    public void setThreeDSRequestorAuthenticationInfo(ThreeDSRequestorAuthenticationInfo threeDSRequestorAuthenticationInfo) {
        this.threeDSRequestorAuthenticationInfo = threeDSRequestorAuthenticationInfo;
    }

    public ThreeDS2RequestData threeDSRequestorChallengeInd(ThreeDSRequestorChallengeIndEnum threeDSRequestorChallengeInd) {
        this.threeDSRequestorChallengeInd = threeDSRequestorChallengeInd;
        return this;
    }

    /**
     * Indicates whether a challenge is requested for this transaction. Possible values: * **01** — No preference * **02** — No challenge requested * **03** — Challenge requested (3DS Requestor preference) * **04** — Challenge requested (Mandate) * **05** — No challenge (transactional risk analysis is already performed)
     *
     * @return threeDSRequestorChallengeInd
     **/
    public ThreeDSRequestorChallengeIndEnum getThreeDSRequestorChallengeInd() {
        return threeDSRequestorChallengeInd;
    }

    public void setThreeDSRequestorChallengeInd(ThreeDSRequestorChallengeIndEnum threeDSRequestorChallengeInd) {
        this.threeDSRequestorChallengeInd = threeDSRequestorChallengeInd;
    }

    public ThreeDS2RequestData threeDSRequestorID(String threeDSRequestorID) {
        this.threeDSRequestorID = threeDSRequestorID;
        return this;
    }

    /**
     * Required for [authentication-only integration](https://docs.adyen.com/online-payments/3d-secure/other-3ds-flows/authentication-only) for Visa. Unique 3D Secure requestor identifier assigned by the Directory Server when you enrol for 3D Secure 2.
     *
     * @return threeDSRequestorID
     **/
    public String getThreeDSRequestorID() {
        return threeDSRequestorID;
    }

    public void setThreeDSRequestorID(String threeDSRequestorID) {
        this.threeDSRequestorID = threeDSRequestorID;
    }

    public ThreeDS2RequestData threeDSRequestorName(String threeDSRequestorName) {
        this.threeDSRequestorName = threeDSRequestorName;
        return this;
    }

    /**
     * Required for [authentication-only integration](https://docs.adyen.com/online-payments/3d-secure/other-3ds-flows/authentication-only) for Visa. Unique 3D Secure requestor name assigned by the Directory Server when you enrol for 3D Secure 2.
     *
     * @return threeDSRequestorName
     **/
    public String getThreeDSRequestorName() {
        return threeDSRequestorName;
    }

    public void setThreeDSRequestorName(String threeDSRequestorName) {
        this.threeDSRequestorName = threeDSRequestorName;
    }

    public ThreeDS2RequestData threeDSRequestorPriorAuthenticationInfo(ThreeDSRequestorPriorAuthenticationInfo threeDSRequestorPriorAuthenticationInfo) {
        this.threeDSRequestorPriorAuthenticationInfo = threeDSRequestorPriorAuthenticationInfo;
        return this;
    }

    /**
     * Get threeDSRequestorPriorAuthenticationInfo
     *
     * @return threeDSRequestorPriorAuthenticationInfo
     **/
    public ThreeDSRequestorPriorAuthenticationInfo getThreeDSRequestorPriorAuthenticationInfo() {
        return threeDSRequestorPriorAuthenticationInfo;
    }

    public void setThreeDSRequestorPriorAuthenticationInfo(ThreeDSRequestorPriorAuthenticationInfo threeDSRequestorPriorAuthenticationInfo) {
        this.threeDSRequestorPriorAuthenticationInfo = threeDSRequestorPriorAuthenticationInfo;
    }

    public ThreeDS2RequestData threeDSRequestorURL(String threeDSRequestorURL) {
        this.threeDSRequestorURL = threeDSRequestorURL;
        return this;
    }

    /**
     * URL of the (customer service) website that will be shown to the shopper in case of technical errors during the 3D Secure 2 process.
     *
     * @return threeDSRequestorURL
     **/
    public String getThreeDSRequestorURL() {
        return threeDSRequestorURL;
    }

    public void setThreeDSRequestorURL(String threeDSRequestorURL) {
        this.threeDSRequestorURL = threeDSRequestorURL;
    }

    public ThreeDS2RequestData transType(TransTypeEnum transType) {
        this.transType = transType;
        return this;
    }

    /**
     * Identifies the type of transaction being authenticated. Length: 2 characters. Allowed values: * **01** — Goods/Service Purchase * **03** — Check Acceptance * **10** — Account Funding * **11** — Quasi-Cash Transaction * **28** — Prepaid Activation and Load
     *
     * @return transType
     **/
    public TransTypeEnum getTransType() {
        return transType;
    }

    public void setTransType(TransTypeEnum transType) {
        this.transType = transType;
    }

    public ThreeDS2RequestData transactionType(TransactionTypeEnum transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    /**
     * Identify the type of the transaction being authenticated.
     *
     * @return transactionType
     **/
    public TransactionTypeEnum getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionTypeEnum transactionType) {
        this.transactionType = transactionType;
    }

    public ThreeDS2RequestData whiteListStatus(String whiteListStatus) {
        this.whiteListStatus = whiteListStatus;
        return this;
    }

    /**
     * The &#x60;whiteListStatus&#x60; value returned from a previous 3D Secure 2 transaction, only applicable for 3D Secure 2 protocol version 2.2.0.
     *
     * @return whiteListStatus
     **/
    public String getWhiteListStatus() {
        return whiteListStatus;
    }

    public void setWhiteListStatus(String whiteListStatus) {
        this.whiteListStatus = whiteListStatus;
    }

    public ThreeDS2RequestData workPhone(Phone workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    /**
     * Get workPhone
     *
     * @return workPhone
     **/
    public Phone getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(Phone workPhone) {
        this.workPhone = workPhone;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ThreeDS2RequestData threeDS2RequestData = (ThreeDS2RequestData) o;
        return Objects.equals(this.acctInfo, threeDS2RequestData.acctInfo) &&
                Objects.equals(this.acctType, threeDS2RequestData.acctType) &&
                Objects.equals(this.acquirerBIN, threeDS2RequestData.acquirerBIN) &&
                Objects.equals(this.acquirerMerchantID, threeDS2RequestData.acquirerMerchantID) &&
                Objects.equals(this.addrMatch, threeDS2RequestData.addrMatch) &&
                Objects.equals(this.authenticationOnly, threeDS2RequestData.authenticationOnly) &&
                Objects.equals(this.challengeIndicator, threeDS2RequestData.challengeIndicator) &&
                Objects.equals(this.deviceChannel, threeDS2RequestData.deviceChannel) &&
                Objects.equals(this.deviceRenderOptions, threeDS2RequestData.deviceRenderOptions) &&
                Objects.equals(this.homePhone, threeDS2RequestData.homePhone) &&
                Objects.equals(this.mcc, threeDS2RequestData.mcc) &&
                Objects.equals(this.merchantName, threeDS2RequestData.merchantName) &&
                Objects.equals(this.messageVersion, threeDS2RequestData.messageVersion) &&
                Objects.equals(this.mobilePhone, threeDS2RequestData.mobilePhone) &&
                Objects.equals(this.notificationURL, threeDS2RequestData.notificationURL) &&
                Objects.equals(this.payTokenInd, threeDS2RequestData.payTokenInd) &&
                Objects.equals(this.paymentAuthenticationUseCase, threeDS2RequestData.paymentAuthenticationUseCase) &&
                Objects.equals(this.purchaseInstalData, threeDS2RequestData.purchaseInstalData) &&
                Objects.equals(this.recurringExpiry, threeDS2RequestData.recurringExpiry) &&
                Objects.equals(this.recurringFrequency, threeDS2RequestData.recurringFrequency) &&
                Objects.equals(this.sdkAppID, threeDS2RequestData.sdkAppID) &&
                Objects.equals(this.sdkEncData, threeDS2RequestData.sdkEncData) &&
                Objects.equals(this.sdkEphemPubKey, threeDS2RequestData.sdkEphemPubKey) &&
                Objects.equals(this.sdkMaxTimeout, threeDS2RequestData.sdkMaxTimeout) &&
                Objects.equals(this.sdkReferenceNumber, threeDS2RequestData.sdkReferenceNumber) &&
                Objects.equals(this.sdkTransID, threeDS2RequestData.sdkTransID) &&
                Objects.equals(this.sdkVersion, threeDS2RequestData.sdkVersion) &&
                Objects.equals(this.threeDSCompInd, threeDS2RequestData.threeDSCompInd) &&
                Objects.equals(this.threeDSRequestorAuthenticationInd, threeDS2RequestData.threeDSRequestorAuthenticationInd) &&
                Objects.equals(this.threeDSRequestorAuthenticationInfo, threeDS2RequestData.threeDSRequestorAuthenticationInfo) &&
                Objects.equals(this.threeDSRequestorChallengeInd, threeDS2RequestData.threeDSRequestorChallengeInd) &&
                Objects.equals(this.threeDSRequestorID, threeDS2RequestData.threeDSRequestorID) &&
                Objects.equals(this.threeDSRequestorName, threeDS2RequestData.threeDSRequestorName) &&
                Objects.equals(this.threeDSRequestorPriorAuthenticationInfo, threeDS2RequestData.threeDSRequestorPriorAuthenticationInfo) &&
                Objects.equals(this.threeDSRequestorURL, threeDS2RequestData.threeDSRequestorURL) &&
                Objects.equals(this.transType, threeDS2RequestData.transType) &&
                Objects.equals(this.transactionType, threeDS2RequestData.transactionType) &&
                Objects.equals(this.whiteListStatus, threeDS2RequestData.whiteListStatus) &&
                Objects.equals(this.workPhone, threeDS2RequestData.workPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acctInfo, acctType, acquirerBIN, acquirerMerchantID, addrMatch, authenticationOnly, challengeIndicator, deviceChannel, deviceRenderOptions, homePhone, mcc, merchantName, messageVersion, mobilePhone, notificationURL, payTokenInd, paymentAuthenticationUseCase, purchaseInstalData, recurringExpiry, recurringFrequency, sdkAppID, sdkEncData, sdkEphemPubKey, sdkMaxTimeout, sdkReferenceNumber, sdkTransID, sdkVersion, threeDSCompInd, threeDSRequestorAuthenticationInd, threeDSRequestorAuthenticationInfo, threeDSRequestorChallengeInd, threeDSRequestorID, threeDSRequestorName, threeDSRequestorPriorAuthenticationInfo, threeDSRequestorURL, transType, transactionType, whiteListStatus, workPhone);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ThreeDS2RequestData {\n");

        sb.append("    acctInfo: ").append(toIndentedString(acctInfo)).append("\n");
        sb.append("    acctType: ").append(toIndentedString(acctType)).append("\n");
        sb.append("    acquirerBIN: ").append(toIndentedString(acquirerBIN)).append("\n");
        sb.append("    acquirerMerchantID: ").append(toIndentedString(acquirerMerchantID)).append("\n");
        sb.append("    addrMatch: ").append(toIndentedString(addrMatch)).append("\n");
        sb.append("    authenticationOnly: ").append(toIndentedString(authenticationOnly)).append("\n");
        sb.append("    challengeIndicator: ").append(toIndentedString(challengeIndicator)).append("\n");
        sb.append("    deviceChannel: ").append(toIndentedString(deviceChannel)).append("\n");
        sb.append("    deviceRenderOptions: ").append(toIndentedString(deviceRenderOptions)).append("\n");
        sb.append("    homePhone: ").append(toIndentedString(homePhone)).append("\n");
        sb.append("    mcc: ").append(toIndentedString(mcc)).append("\n");
        sb.append("    merchantName: ").append(toIndentedString(merchantName)).append("\n");
        sb.append("    messageVersion: ").append(toIndentedString(messageVersion)).append("\n");
        sb.append("    mobilePhone: ").append(toIndentedString(mobilePhone)).append("\n");
        sb.append("    notificationURL: ").append(toIndentedString(notificationURL)).append("\n");
        sb.append("    payTokenInd: ").append(toIndentedString(payTokenInd)).append("\n");
        sb.append("    paymentAuthenticationUseCase: ").append(toIndentedString(paymentAuthenticationUseCase)).append("\n");
        sb.append("    purchaseInstalData: ").append(toIndentedString(purchaseInstalData)).append("\n");
        sb.append("    recurringExpiry: ").append(toIndentedString(recurringExpiry)).append("\n");
        sb.append("    recurringFrequency: ").append(toIndentedString(recurringFrequency)).append("\n");
        sb.append("    sdkAppID: ").append(toIndentedString(sdkAppID)).append("\n");
        sb.append("    sdkEncData: ").append(toIndentedString(sdkEncData)).append("\n");
        sb.append("    sdkEphemPubKey: ").append(toIndentedString(sdkEphemPubKey)).append("\n");
        sb.append("    sdkMaxTimeout: ").append(toIndentedString(sdkMaxTimeout)).append("\n");
        sb.append("    sdkReferenceNumber: ").append(toIndentedString(sdkReferenceNumber)).append("\n");
        sb.append("    sdkTransID: ").append(toIndentedString(sdkTransID)).append("\n");
        sb.append("    sdkVersion: ").append(toIndentedString(sdkVersion)).append("\n");
        sb.append("    threeDSCompInd: ").append(toIndentedString(threeDSCompInd)).append("\n");
        sb.append("    threeDSRequestorAuthenticationInd: ").append(toIndentedString(threeDSRequestorAuthenticationInd)).append("\n");
        sb.append("    threeDSRequestorAuthenticationInfo: ").append(toIndentedString(threeDSRequestorAuthenticationInfo)).append("\n");
        sb.append("    threeDSRequestorChallengeInd: ").append(toIndentedString(threeDSRequestorChallengeInd)).append("\n");
        sb.append("    threeDSRequestorID: ").append(toIndentedString(threeDSRequestorID)).append("\n");
        sb.append("    threeDSRequestorName: ").append(toIndentedString(threeDSRequestorName)).append("\n");
        sb.append("    threeDSRequestorPriorAuthenticationInfo: ").append(toIndentedString(threeDSRequestorPriorAuthenticationInfo)).append("\n");
        sb.append("    threeDSRequestorURL: ").append(toIndentedString(threeDSRequestorURL)).append("\n");
        sb.append("    transType: ").append(toIndentedString(transType)).append("\n");
        sb.append("    transactionType: ").append(toIndentedString(transactionType)).append("\n");
        sb.append("    whiteListStatus: ").append(toIndentedString(whiteListStatus)).append("\n");
        sb.append("    workPhone: ").append(toIndentedString(workPhone)).append("\n");
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
