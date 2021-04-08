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
package com.adyen.model.checkout;

import com.adyen.model.Amount;
import com.fasterxml.jackson.annotation.JsonValue;
import com.adyen.util.MaskUtil;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * CheckoutPaymentsAction
 */

public class CheckoutPaymentsAction {
    @SerializedName("alternativeReference")
    private String alternativeReference = null;

    @SerializedName("data")
    private Map<String, String> data = null;

    @SerializedName("downloadUrl")
    private String downloadUrl = null;

    @SerializedName("expiresAt")
    private String expiresAt = null;

    @SerializedName("initialAmount")
    private Amount initialAmount = null;

    @SerializedName("instructionsUrl")
    private String instructionsUrl = null;

    @SerializedName("issuer")
    private String issuer = null;

    @SerializedName("maskedTelephoneNumber")
    private String maskedTelephoneNumber = null;

    @SerializedName("merchantName")
    private String merchantName = null;

    @SerializedName("merchantReference")
    private String merchantReference = null;

    @SerializedName("method")
    private String method = null;

    @SerializedName("paymentData")
    private String paymentData = null;

    @SerializedName("paymentMethodType")
    private String paymentMethodType = null;

    @SerializedName("qrCodeData")
    private String qrCodeData = null;

    @SerializedName("reference")
    private String reference = null;

    @SerializedName("shopperEmail")
    private String shopperEmail = null;

    @SerializedName("shopperName")
    private String shopperName = null;

    @SerializedName("surcharge")
    private Amount surcharge = null;

    @SerializedName("token")
    private String token = null;

    @SerializedName("totalAmount")
    private Amount totalAmount = null;

    @SerializedName("entity")
    private String entity;

    @SerializedName("sdkData")
    private Map<String, String> sdkData;

    @SerializedName("resendInterval")
    private int resendInterval;

    @SerializedName("resendMaxAttempts")
    private int resendMaxAttempts;

    @SerializedName("resendUrl")
    private String resendUrl;

    @SerializedName("redirect")
    private Redirect redirect;

    @SerializedName("authorisationToken")
    private String authorisationToken;

    @SerializedName("subtype")
    private String subtype;

    @SerializedName("beneficiary")
    private String beneficiary = null;

    @SerializedName("bic")
    private String bic = null;

    @SerializedName("iban")
    private String iban = null;

    @SerializedName("shopperStatement")
    private String shopperStatement = null;

    /**
     * Enum that specifies the action that needs to be taken by the client.
     */
    @JsonAdapter(CheckoutActionType.Adapter.class)
    public enum CheckoutActionType {
        AWAIT("await"),
        QRCODE("qrCode"),
        REDIRECT("redirect"),
        THREEDS2CHALLENGE("threeDS2Challenge"),
        THREEDS2FINGERPRINT("threeDS2Fingerprint"),
        THREEDS2("threeDS2"),
        VOUCHER("voucher"),
        SDK("sdk"),
        WECHATPAYSDK("wechatpaySDK"),
        BANKTRANSFER("bankTransfer");

        @JsonValue
        private String value;

        CheckoutActionType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static CheckoutActionType fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<CheckoutActionType> {
            @Override
            public void write(final JsonWriter jsonWriter, final CheckoutActionType enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public CheckoutActionType read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return CheckoutActionType.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("type")
    private CheckoutActionType type = null;

    @SerializedName("url")
    private String url = null;

    public CheckoutPaymentsAction alternativeReference(String alternativeReference) {
        this.alternativeReference = alternativeReference;
        return this;
    }

    /**
     * The voucher alternative reference code.
     *
     * @return alternativeReference
     **/
    public String getAlternativeReference() {
        return alternativeReference;
    }

    public void setAlternativeReference(String alternativeReference) {
        this.alternativeReference = alternativeReference;
    }

    public CheckoutPaymentsAction data(Map<String, String> data) {
        this.data = data;
        return this;
    }

    /**
     * When the redirect URL must be accessed via POST, use this data to post to the redirect URL.
     *
     * @return data
     **/
    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public CheckoutPaymentsAction downloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
        return this;
    }

    /**
     * The URL to download the voucher.
     *
     * @return downloadUrl
     **/
    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public CheckoutPaymentsAction expiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
        return this;
    }

    /**
     * The date time of the voucher expiry.
     *
     * @return expiresAt
     **/
    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public CheckoutPaymentsAction initialAmount(Amount initialAmount) {
        this.initialAmount = initialAmount;
        return this;
    }

    /**
     * Get initialAmount
     *
     * @return initialAmount
     **/
    public Amount getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(Amount initialAmount) {
        this.initialAmount = initialAmount;
    }

    public CheckoutPaymentsAction instructionsUrl(String instructionsUrl) {
        this.instructionsUrl = instructionsUrl;
        return this;
    }

    /**
     * The URL to the detailed instructions to make payment using the voucher.
     *
     * @return instructionsUrl
     **/
    public String getInstructionsUrl() {
        return instructionsUrl;
    }

    public void setInstructionsUrl(String instructionsUrl) {
        this.instructionsUrl = instructionsUrl;
    }

    public CheckoutPaymentsAction issuer(String issuer) {
        this.issuer = issuer;
        return this;
    }

    /**
     * The issuer of the voucher.
     *
     * @return issuer
     **/
    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public CheckoutPaymentsAction maskedTelephoneNumber(String maskedTelephoneNumber) {
        this.maskedTelephoneNumber = maskedTelephoneNumber;
        return this;
    }

    /**
     * The shopper telephone number (partially masked).
     *
     * @return maskedTelephoneNumber
     **/
    public String getMaskedTelephoneNumber() {
        return maskedTelephoneNumber;
    }

    public void setMaskedTelephoneNumber(String maskedTelephoneNumber) {
        this.maskedTelephoneNumber = maskedTelephoneNumber;
    }

    public CheckoutPaymentsAction merchantName(String merchantName) {
        this.merchantName = merchantName;
        return this;
    }

    /**
     * The merchant name.
     *
     * @return merchantName
     **/
    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public CheckoutPaymentsAction merchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
        return this;
    }

    /**
     * The merchant reference.
     *
     * @return merchantReference
     **/
    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }

    public CheckoutPaymentsAction method(String method) {
        this.method = method;
        return this;
    }

    /**
     * Specifies the HTTP method, for example GET or POST.
     *
     * @return method
     **/
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public CheckoutPaymentsAction paymentData(String paymentData) {
        this.paymentData = paymentData;
        return this;
    }

    /**
     * When non-empty, contains a value that you must submit to the &#x60;/payments/details&#x60; endpoint. In some cases, required for polling.
     *
     * @return paymentData
     **/
    public String getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(String paymentData) {
        this.paymentData = paymentData;
    }

    public CheckoutPaymentsAction paymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
        return this;
    }

    /**
     * Specifies the payment method.
     *
     * @return paymentMethodType
     **/
    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public CheckoutPaymentsAction qrCodeData(String qrCodeData) {
        this.qrCodeData = qrCodeData;
        return this;
    }

    /**
     * The contents of the QR code as a UTF8 string.
     *
     * @return qrCodeData
     **/
    public String getQrCodeData() {
        return qrCodeData;
    }

    public void setQrCodeData(String qrCodeData) {
        this.qrCodeData = qrCodeData;
    }

    public CheckoutPaymentsAction reference(String reference) {
        this.reference = reference;
        return this;
    }

    /**
     * The voucher reference code.
     *
     * @return reference
     **/
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public CheckoutPaymentsAction shopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
        return this;
    }

    /**
     * The shopper email.
     *
     * @return shopperEmail
     **/
    public String getShopperEmail() {
        return shopperEmail;
    }

    public void setShopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
    }

    public CheckoutPaymentsAction shopperName(String shopperName) {
        this.shopperName = shopperName;
        return this;
    }

    /**
     * The shopper name.
     *
     * @return shopperName
     **/
    public String getShopperName() {
        return shopperName;
    }

    public void setShopperName(String shopperName) {
        this.shopperName = shopperName;
    }

    public CheckoutPaymentsAction surcharge(Amount surcharge) {
        this.surcharge = surcharge;
        return this;
    }

    /**
     * Get surcharge
     *
     * @return surcharge
     **/
    public Amount getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(Amount surcharge) {
        this.surcharge = surcharge;
    }

    public CheckoutPaymentsAction token(String token) {
        this.token = token;
        return this;
    }

    /**
     * A token to pass to the 3DS2 Component to get the fingerprint/challenge.
     *
     * @return token
     **/
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public CheckoutPaymentsAction totalAmount(Amount totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    /**
     * Get totalAmount
     *
     * @return totalAmount
     **/
    public Amount getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Amount totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public CheckoutPaymentsAction entity(String entity) {
        this.entity = entity;
        return this;
    }

    public CheckoutPaymentsAction type(CheckoutActionType type) {
        this.type = type;
        return this;
    }

    /**
     * Enum that specifies the action that needs to be taken by the client.
     *
     * @return type
     **/
    public CheckoutActionType getType() {
        return type;
    }

    public void setType(CheckoutActionType type) {
        this.type = type;
    }

    public CheckoutPaymentsAction url(String url) {
        this.url = url;
        return this;
    }

    /**
     * Specifies the URL to redirect to.
     *
     * @return url
     **/
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Returns SDK data.
     *
     * @return sdkData
     */
    public Map<String, String> getSdkData() {
        return sdkData;
    }

    public void setSdkData(Map<String, String> sdkData) {
        this.sdkData = sdkData;
    }

    public int getResendInterval() {
        return resendInterval;
    }

    public int getResendMaxAttempts() {
        return resendMaxAttempts;
    }

    public String getResendUrl() {
        return resendUrl;
    }

    public Redirect getRedirect() {
        return redirect;
    }

    public String getAuthorisationToken() {
        return authorisationToken;
    }

    public void setAuthorisationToken(String authorisationToken) {
        this.authorisationToken = authorisationToken;
    }

    public CheckoutPaymentsAction authorisationToken(String authorisationToken) {
        this.authorisationToken = authorisationToken;
        return this;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public CheckoutPaymentsAction subtype(String subtype) {
        this.subtype = subtype;
        return this;
    }

    public void setResendInterval(int resendInterval) {
        this.resendInterval = resendInterval;
    }

    public void setResendMaxAttempts(int resendMaxAttempts) {
        this.resendMaxAttempts = resendMaxAttempts;
    }

    public void setResendUrl(String resendUrl) {
        this.resendUrl = resendUrl;
    }

    public void setRedirect(Redirect redirect) {
        this.redirect = redirect;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getShopperStatement() {
        return shopperStatement;
    }

    public void setShopperStatement(String shopperStatement) {
        this.shopperStatement = shopperStatement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckoutPaymentsAction checkoutPaymentsAction = (CheckoutPaymentsAction) o;
        return resendInterval == checkoutPaymentsAction.resendInterval &&
                resendMaxAttempts == checkoutPaymentsAction.resendMaxAttempts &&
                Objects.equals(alternativeReference, checkoutPaymentsAction.alternativeReference) &&
                Objects.equals(data, checkoutPaymentsAction.data) &&
                Objects.equals(downloadUrl, checkoutPaymentsAction.downloadUrl) &&
                Objects.equals(expiresAt, checkoutPaymentsAction.expiresAt) &&
                Objects.equals(initialAmount, checkoutPaymentsAction.initialAmount) &&
                Objects.equals(instructionsUrl, checkoutPaymentsAction.instructionsUrl) &&
                Objects.equals(issuer, checkoutPaymentsAction.issuer) &&
                Objects.equals(maskedTelephoneNumber, checkoutPaymentsAction.maskedTelephoneNumber) &&
                Objects.equals(merchantName, checkoutPaymentsAction.merchantName) &&
                Objects.equals(merchantReference, checkoutPaymentsAction.merchantReference) &&
                Objects.equals(method, checkoutPaymentsAction.method) &&
                Objects.equals(paymentData, checkoutPaymentsAction.paymentData) &&
                Objects.equals(paymentMethodType, checkoutPaymentsAction.paymentMethodType) &&
                Objects.equals(qrCodeData, checkoutPaymentsAction.qrCodeData) &&
                Objects.equals(reference, checkoutPaymentsAction.reference) &&
                Objects.equals(shopperEmail, checkoutPaymentsAction.shopperEmail) &&
                Objects.equals(shopperName, checkoutPaymentsAction.shopperName) &&
                Objects.equals(surcharge, checkoutPaymentsAction.surcharge) &&
                Objects.equals(token, checkoutPaymentsAction.token) &&
                Objects.equals(totalAmount, checkoutPaymentsAction.totalAmount) &&
                Objects.equals(entity, checkoutPaymentsAction.entity) &&
                Objects.equals(sdkData, checkoutPaymentsAction.sdkData) &&
                Objects.equals(resendUrl, checkoutPaymentsAction.resendUrl) &&
                Objects.equals(redirect, checkoutPaymentsAction.redirect) &&
                Objects.equals(authorisationToken, checkoutPaymentsAction.authorisationToken) &&
                Objects.equals(subtype, checkoutPaymentsAction.subtype) &&
                Objects.equals(beneficiary, checkoutPaymentsAction.beneficiary) &&
                Objects.equals(bic, checkoutPaymentsAction.bic) &&
                Objects.equals(iban, checkoutPaymentsAction.iban) &&
                Objects.equals(shopperStatement, checkoutPaymentsAction.shopperStatement) &&
                type == checkoutPaymentsAction.type &&
                Objects.equals(url, checkoutPaymentsAction.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alternativeReference, data, downloadUrl, expiresAt, initialAmount, instructionsUrl, issuer, maskedTelephoneNumber, merchantName, merchantReference, method, paymentData, paymentMethodType, qrCodeData, reference, shopperEmail, shopperName, surcharge, token, totalAmount, entity, sdkData, resendInterval, resendMaxAttempts, resendUrl, redirect, authorisationToken, subtype, beneficiary, bic, iban, shopperStatement, type, url);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CheckoutPaymentsAction{");
        sb.append("alternativeReference='").append(alternativeReference).append('\'');
        sb.append(", data=").append(data);
        sb.append(", downloadUrl='").append(downloadUrl).append('\'');
        sb.append(", expiresAt='").append(expiresAt).append('\'');
        sb.append(", initialAmount=").append(initialAmount);
        sb.append(", instructionsUrl='").append(instructionsUrl).append('\'');
        sb.append(", issuer='").append(issuer).append('\'');
        sb.append(", maskedTelephoneNumber='").append(maskedTelephoneNumber).append('\'');
        sb.append(", merchantName='").append(merchantName).append('\'');
        sb.append(", merchantReference='").append(merchantReference).append('\'');
        sb.append(", method='").append(method).append('\'');
        sb.append(", paymentData='").append(paymentData).append('\'');
        sb.append(", paymentMethodType='").append(paymentMethodType).append('\'');
        sb.append(", qrCodeData='").append(qrCodeData).append('\'');
        sb.append(", reference='").append(reference).append('\'');
        sb.append(", shopperEmail='").append(shopperEmail).append('\'');
        sb.append(", shopperName='").append(shopperName).append('\'');
        sb.append(", surcharge=").append(surcharge);
        sb.append(", token='").append(token).append('\'');
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", entity='").append(entity).append('\'');
        sb.append(", sdkData=").append(sdkData);
        sb.append(", resendInterval=").append(resendInterval);
        sb.append(", resendMaxAttempts=").append(resendMaxAttempts);
        sb.append(", resendUrl='").append(resendUrl).append('\'');
        sb.append(", redirect=").append(redirect);
        sb.append(", authorisationToken='").append(authorisationToken).append('\'');
        sb.append(", subtype='").append(subtype).append('\'');
        sb.append(", beneficiary='").append(beneficiary).append('\'');
        sb.append(", bic='").append(bic).append('\'');
        sb.append(", iban='").append(iban).append('\'');
        sb.append(", shopperStatement='").append(shopperStatement).append('\'');
        sb.append(", type=").append(type);
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
