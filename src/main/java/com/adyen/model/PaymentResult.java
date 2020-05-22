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

import com.adyen.constants.TextConstants;
import com.adyen.util.DateUtil;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

import static com.adyen.constants.ApiConstants.AdditionalData.AVS_RESULT;
import static com.adyen.constants.ApiConstants.AdditionalData.BOLETO_BARCODE_REFERENCE;
import static com.adyen.constants.ApiConstants.AdditionalData.BOLETO_DATA;
import static com.adyen.constants.ApiConstants.AdditionalData.BOLETO_DUE_DATE;
import static com.adyen.constants.ApiConstants.AdditionalData.BOLETO_EXPIRATION_DATE;
import static com.adyen.constants.ApiConstants.AdditionalData.BOLETO_URL;
import static com.adyen.constants.ApiConstants.AdditionalData.CARD_BIN;
import static com.adyen.constants.ApiConstants.AdditionalData.CARD_HOLDER_NAME;
import static com.adyen.constants.ApiConstants.AdditionalData.CARD_SUMMARY;
import static com.adyen.constants.ApiConstants.AdditionalData.EXPIRY_DATE;
import static com.adyen.constants.ApiConstants.AdditionalData.PAYMENT_METHOD;
import static com.adyen.constants.ApiConstants.AdditionalData.THREE_D_AUTHENTICATED;
import static com.adyen.constants.ApiConstants.AdditionalData.THREE_D_OFFERERED;

/**
 * PaymentResult
 */
public class PaymentResult {
    @SerializedName("authCode")
    private String authCode = null;

    @SerializedName("paRequest")
    private String paRequest = null;

    @SerializedName("issuerUrl")
    private String issuerUrl = null;

    @SerializedName("md")
    private String md = null;

    @SerializedName("dccAmount")
    private Amount dccAmount = null;

    @SerializedName("dccSignature")
    private String dccSignature = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    /**
     * the result of the payment
     */
    public enum ResultCodeEnum {
        @SerializedName("AuthenticationFinished")
        AUTHENTICATIONFINISHED("AuthenticationFinished"),
        @SerializedName("Authorised")
        AUTHORISED("Authorised"),
        @SerializedName("Cancelled")
        CANCELLED("Cancelled"),
        @SerializedName("ChallengeShopper")
        CHALLENGESHOPPER("ChallengeShopper"),
        @SerializedName("Error")
        ERROR("Error"),
        @SerializedName("IdentifyShopper")
        IDENTIFYSHOPPER("IdentifyShopper"),
        @SerializedName("Pending")
        PENDING("Pending"),
        @SerializedName("PresentToShopper")
        PRESENTTOSHOPPER("PresentToShopper"),
        @SerializedName("Received")
        RECEIVED("Received"),
        @SerializedName("RedirectShopper")
        REDIRECTSHOPPER("RedirectShopper"),
        @SerializedName("Refused")
        REFUSED("Refused");

        private String value;

        ResultCodeEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("resultCode")
    private ResultCodeEnum resultCode = null;

    @SerializedName("additionalData")
    private Map<String, String> additionalData = null;

    @SerializedName("refusalReason")
    private String refusalReason = null;

    @SerializedName("fraudResult")
    private FraudResult fraudResult = null;

    public PaymentResult authCode(String authCode) {
        this.authCode = authCode;
        return this;
    }

    /**
     * the authorisation code if the payment was successful
     *
     * @return authCode
     **/
    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public PaymentResult paRequest(String paRequest) {
        this.paRequest = paRequest;
        return this;
    }

    /**
     * the 3D request data for the issuer
     *
     * @return paRequest
     **/
    public String getPaRequest() {
        return paRequest;
    }

    public void setPaRequest(String paRequest) {
        this.paRequest = paRequest;
    }

    public PaymentResult issuerUrl(String issuerUrl) {
        this.issuerUrl = issuerUrl;
        return this;
    }

    /**
     * the URL to direct the shopper to
     *
     * @return issuerUrl
     **/
    public String getIssuerUrl() {
        return issuerUrl;
    }

    public void setIssuerUrl(String issuerUrl) {
        this.issuerUrl = issuerUrl;
    }

    public PaymentResult md(String md) {
        this.md = md;
        return this;
    }

    /**
     * the payment session
     *
     * @return md
     **/
    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public PaymentResult dccAmount(Amount dccAmount) {
        this.dccAmount = dccAmount;
        return this;
    }

    /**
     * Get dccAmount
     *
     * @return dccAmount
     **/
    public Amount getDccAmount() {
        return dccAmount;
    }

    public void setDccAmount(Amount dccAmount) {
        this.dccAmount = dccAmount;
    }

    public PaymentResult dccSignature(String dccSignature) {
        this.dccSignature = dccSignature;
        return this;
    }

    /**
     * Get dccSignature
     *
     * @return dccSignature
     **/
    public String getDccSignature() {
        return dccSignature;
    }

    public void setDccSignature(String dccSignature) {
        this.dccSignature = dccSignature;
    }

    public PaymentResult pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * the unique reference that is associated with the payment
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public PaymentResult resultCode(ResultCodeEnum resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    /**
     * the result of the payment
     *
     * @return resultCode
     **/
    public ResultCodeEnum getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCodeEnum resultCode) {
        this.resultCode = resultCode;
    }

    public PaymentResult additionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
        return this;
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

    public PaymentResult refusalReason(String refusalReason) {
        this.refusalReason = refusalReason;
        return this;
    }

    /**
     * the mapped refusal reason
     *
     * @return refusalReason
     **/
    public String getRefusalReason() {
        return refusalReason;
    }

    public void setRefusalReason(String refusalReason) {
        this.refusalReason = refusalReason;
    }

    public PaymentResult fraudResult(FraudResult fraudResult) {
        this.fraudResult = fraudResult;
        return this;
    }

    /**
     * the fraud result properties of the payment
     *
     * @return fraudResult
     **/
    public FraudResult getFraudResult() {
        return fraudResult;
    }

    public void setFraudResult(FraudResult fraudResult) {
        this.fraudResult = fraudResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        PaymentResult paymentResult = (PaymentResult) o;
        return Objects.equals(this.authCode, paymentResult.authCode)
                && Objects.equals(this.paRequest, paymentResult.paRequest)
                && Objects.equals(this.issuerUrl, paymentResult.issuerUrl)
                && Objects.equals(this.md, paymentResult.md)
                && Objects.equals(this.dccAmount, paymentResult.dccAmount)
                && Objects.equals(this.dccSignature, paymentResult.dccSignature)
                && Objects.equals(this.pspReference, paymentResult.pspReference)
                && Objects.equals(this.resultCode, paymentResult.resultCode)
                && Objects.equals(this.additionalData, paymentResult.additionalData)
                && Objects.equals(this.refusalReason, paymentResult.refusalReason)
                && Objects.equals(this.fraudResult, paymentResult.fraudResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authCode, paRequest, issuerUrl, md, dccAmount, dccSignature, pspReference, resultCode, additionalData, refusalReason, fraudResult);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentResult {").append(TextConstants.LINE_BREAK);

        sb.append("    authCode: ").append(Util.toIndentedString(authCode)).append(TextConstants.LINE_BREAK);
        sb.append("    paRequest: ").append(Util.toIndentedString(paRequest)).append(TextConstants.LINE_BREAK);
        sb.append("    issuerUrl: ").append(Util.toIndentedString(issuerUrl)).append(TextConstants.LINE_BREAK);
        sb.append("    md: ").append(Util.toIndentedString(md)).append(TextConstants.LINE_BREAK);
        sb.append("    dccAmount: ").append(Util.toIndentedString(dccAmount)).append(TextConstants.LINE_BREAK);
        sb.append("    dccSignature: ").append(Util.toIndentedString(dccSignature)).append(TextConstants.LINE_BREAK);
        sb.append("    pspReference: ").append(Util.toIndentedString(pspReference)).append(TextConstants.LINE_BREAK);
        sb.append("    resultCode: ").append(Util.toIndentedString(resultCode)).append(TextConstants.LINE_BREAK);
        sb.append("    additionalData: ").append(Util.toIndentedString(additionalData)).append(TextConstants.LINE_BREAK);
        sb.append("    refusalReason: ").append(Util.toIndentedString(refusalReason)).append(TextConstants.LINE_BREAK);
        sb.append("    fraudResult: ").append(Util.toIndentedString(fraudResult)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }



    public boolean isAuthorised() {
        return this.resultCode.equals(ResultCodeEnum.AUTHORISED);
    }

    public boolean isRedirectShopper() {
        return this.resultCode.equals(ResultCodeEnum.REDIRECTSHOPPER);
    }

    public boolean isRefused() {
        return this.resultCode.equals(ResultCodeEnum.REFUSED);
    }

    public boolean isReceived() {
        return this.resultCode.equals(ResultCodeEnum.RECEIVED);
    }

    public String getAdditionalDataByKey(String key) {
        if (Objects.isNull(additionalData)) {
            return null;
        }

        return additionalData.get(key);
    }

    public Date getExpiryDate() {
        String expiryDate = getAdditionalDataByKey(EXPIRY_DATE);
        return DateUtil.parseMYDate(expiryDate);
    }

    public String getCardBin() {
        return getAdditionalDataByKey(CARD_BIN);
    }

    public String getCardHolderName() {
        return getAdditionalDataByKey(CARD_HOLDER_NAME);
    }

    public String getCardSummary() {
        return getAdditionalDataByKey(CARD_SUMMARY);
    }

    public String getPaymentMethod() {
        return getAdditionalDataByKey(PAYMENT_METHOD);
    }

    public String getAvsResult() {
        return getAdditionalDataByKey(AVS_RESULT);
    }

    public boolean get3DOffered() {
        return "true".equals(getAdditionalDataByKey(THREE_D_OFFERERED));
    }

    public boolean get3DAuthenticated() {
        return "true".equals(getAdditionalDataByKey(THREE_D_AUTHENTICATED));
    }

    public String getBoletoBarCodeReference() {
        return getAdditionalDataByKey(BOLETO_BARCODE_REFERENCE);
    }

    public String getBoletoData() {

        return getAdditionalDataByKey(BOLETO_DATA);
    }

    public Date getBoletoDueDate() {
        String date = getAdditionalDataByKey(BOLETO_DUE_DATE);
        return DateUtil.parseYmdDate(date);
    }

    public Date getBoletoExpirationDate() {
        String date = getAdditionalDataByKey(BOLETO_EXPIRATION_DATE);
        return DateUtil.parseYmdDate(date);
    }

    public String getBoletoUrl() {
        return getAdditionalDataByKey(BOLETO_URL);
    }
}

