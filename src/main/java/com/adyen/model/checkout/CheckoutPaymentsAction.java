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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

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
        VOUCHER("voucher"),
        SDK("sdk"),
        WECHATPAYSDK("wechatpaySDK");

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CheckoutPaymentsAction checkoutPaymentsAction = (CheckoutPaymentsAction) o;
        return Objects.equals(this.alternativeReference, checkoutPaymentsAction.alternativeReference) &&
                Objects.equals(this.data, checkoutPaymentsAction.data) &&
                Objects.equals(this.downloadUrl, checkoutPaymentsAction.downloadUrl) &&
                Objects.equals(this.expiresAt, checkoutPaymentsAction.expiresAt) &&
                Objects.equals(this.initialAmount, checkoutPaymentsAction.initialAmount) &&
                Objects.equals(this.instructionsUrl, checkoutPaymentsAction.instructionsUrl) &&
                Objects.equals(this.issuer, checkoutPaymentsAction.issuer) &&
                Objects.equals(this.maskedTelephoneNumber, checkoutPaymentsAction.maskedTelephoneNumber) &&
                Objects.equals(this.merchantName, checkoutPaymentsAction.merchantName) &&
                Objects.equals(this.merchantReference, checkoutPaymentsAction.merchantReference) &&
                Objects.equals(this.method, checkoutPaymentsAction.method) &&
                Objects.equals(this.paymentData, checkoutPaymentsAction.paymentData) &&
                Objects.equals(this.paymentMethodType, checkoutPaymentsAction.paymentMethodType) &&
                Objects.equals(this.qrCodeData, checkoutPaymentsAction.qrCodeData) &&
                Objects.equals(this.reference, checkoutPaymentsAction.reference) &&
                Objects.equals(this.shopperEmail, checkoutPaymentsAction.shopperEmail) &&
                Objects.equals(this.shopperName, checkoutPaymentsAction.shopperName) &&
                Objects.equals(this.surcharge, checkoutPaymentsAction.surcharge) &&
                Objects.equals(this.token, checkoutPaymentsAction.token) &&
                Objects.equals(this.totalAmount, checkoutPaymentsAction.totalAmount) &&
                Objects.equals(this.type, checkoutPaymentsAction.type) &&
                Objects.equals(this.entity, checkoutPaymentsAction.entity) &&
                Objects.equals(this.sdkData, checkoutPaymentsAction.sdkData) &&
                Objects.equals(this.resendInterval, checkoutPaymentsAction.resendInterval) &&
                Objects.equals(this.resendMaxAttempts, checkoutPaymentsAction.resendMaxAttempts) &&
                Objects.equals(this.resendUrl, checkoutPaymentsAction.resendUrl) &&
                Objects.equals(this.redirect, checkoutPaymentsAction.redirect) &&
                Objects.equals(this.url, checkoutPaymentsAction.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alternativeReference, data, downloadUrl, expiresAt, initialAmount, instructionsUrl, issuer, maskedTelephoneNumber, merchantName, merchantReference, method, paymentData, paymentMethodType, qrCodeData, reference, shopperEmail, shopperName, surcharge, token, totalAmount, type, url, entity, sdkData, resendInterval, resendMaxAttempts, resendUrl, redirect);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CheckoutPaymentsAction {\n");

        sb.append("    alternativeReference: ").append(toIndentedString(alternativeReference)).append("\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    downloadUrl: ").append(toIndentedString(downloadUrl)).append("\n");
        sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
        sb.append("    entity: ").append(toIndentedString(entity)).append("\n");
        sb.append("    initialAmount: ").append(toIndentedString(initialAmount)).append("\n");
        sb.append("    instructionsUrl: ").append(toIndentedString(instructionsUrl)).append("\n");
        sb.append("    issuer: ").append(toIndentedString(issuer)).append("\n");
        sb.append("    maskedTelephoneNumber: ").append(toIndentedString(maskedTelephoneNumber)).append("\n");
        sb.append("    merchantName: ").append(toIndentedString(merchantName)).append("\n");
        sb.append("    merchantReference: ").append(toIndentedString(merchantReference)).append("\n");
        sb.append("    method: ").append(toIndentedString(method)).append("\n");
        sb.append("    paymentData: ").append(toIndentedString(paymentData)).append("\n");
        sb.append("    paymentMethodType: ").append(toIndentedString(paymentMethodType)).append("\n");
        sb.append("    qrCodeData: ").append(toIndentedString(qrCodeData)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    shopperEmail: ").append(toIndentedString(shopperEmail)).append("\n");
        sb.append("    shopperName: ").append(toIndentedString(shopperName)).append("\n");
        sb.append("    surcharge: ").append(toIndentedString(surcharge)).append("\n");
        sb.append("    token: ").append(toIndentedString(token)).append("\n");
        sb.append("    totalAmount: ").append(toIndentedString(totalAmount)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    sdkData: ").append(toIndentedString(sdkData)).append("\n");
        sb.append("    resendInterval: ").append(toIndentedString(resendInterval)).append("\n");
        sb.append("    resendMaxAttempts: ").append(toIndentedString(resendMaxAttempts)).append("\n");
        sb.append("    resendUrl: ").append(toIndentedString(resendUrl)).append("\n");
        sb.append("    redirect: ").append(toIndentedString(redirect)).append("\n");
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

}
