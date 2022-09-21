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

import com.adyen.util.MaskUtil;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * PaymentSessionResponse
 */
public class PaymentSessionResponse {

    @SerializedName("company")
    private Company company = null;

    @SerializedName("disableRecurringDetailUrl")
    private String disableRecurringDetailUrl = null;

    @SerializedName("generationtime")
    private String generationtime = null;

    @SerializedName("html")
    private String html = null;

    @SerializedName("initiationUrl")
    private String initiationUrl = null;

    @SerializedName("lineItems")
    private List<LineItem> lineItems = null;

    @SerializedName("logoBaseUrl")
    private String logoBaseUrl = null;

    @SerializedName("oneClickPaymentMethods")
    private List<RecurringDetail> oneClickPaymentMethods = null;

    @SerializedName("origin")
    private String origin = null;

    @SerializedName("originKey")
    private String originKey = null;

    @SerializedName("payment")
    private PaymentDetails payment = null;

    @SerializedName("paymentData")
    private String paymentData = null;

    @SerializedName("paymentMethods")
    private List<PaymentMethod> paymentMethods = null;

    @SerializedName("paymentSession")
    private String paymentSession = null;

    @SerializedName("publicKey")
    private String publicKey = null;

    @SerializedName("publicKeyToken")
    private String publicKeyToken = null;

    @SerializedName("sdkVersion")
    private String sdkVersion = null;

    public PaymentSessionResponse company(Company company) {
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

    public PaymentSessionResponse disableRecurringDetailUrl(String disableRecurringDetailUrl) {
        this.disableRecurringDetailUrl = disableRecurringDetailUrl;
        return this;
    }


    /**
     * The URL to disable recurring details.
     *
     * @return disableRecurringDetailUrl
     **/
    public String getDisableRecurringDetailUrl() {
        return disableRecurringDetailUrl;
    }

    public void setDisableRecurringDetailUrl(String disableRecurringDetailUrl) {
        this.disableRecurringDetailUrl = disableRecurringDetailUrl;
    }

    public PaymentSessionResponse generationtime(String generationtime) {
        this.generationtime = generationtime;
        return this;
    }


    /**
     * The generationtime of this request, required for encryption.
     *
     * @return generationtime
     **/
    public String getGenerationtime() {
        return generationtime;
    }

    public void setGenerationtime(String generationtime) {
        this.generationtime = generationtime;
    }

    public PaymentSessionResponse html(String html) {
        this.html = html;
        return this;
    }


    /**
     * The stream with html logic, if the html flag was set in the request.
     *
     * @return html
     **/
    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public PaymentSessionResponse initiationUrl(String initiationUrl) {
        this.initiationUrl = initiationUrl;
        return this;
    }


    /**
     * The URL for the initiation call.
     *
     * @return initiationUrl
     **/
    public String getInitiationUrl() {
        return initiationUrl;
    }

    public void setInitiationUrl(String initiationUrl) {
        this.initiationUrl = initiationUrl;
    }

    public PaymentSessionResponse lineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
        return this;
    }

    public PaymentSessionResponse addLineItemsItem(LineItem lineItemsItem) {

        if (this.lineItems == null) {
            this.lineItems = new ArrayList<>();
        }

        this.lineItems.add(lineItemsItem);
        return this;
    }

    /**
     * Line items that are required for some payment methods.
     *
     * @return lineItems
     **/
    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public PaymentSessionResponse logoBaseUrl(String logoBaseUrl) {
        this.logoBaseUrl = logoBaseUrl;
        return this;
    }


    /**
     * The base URL for payment method logos.
     *
     * @return logoBaseUrl
     **/
    public String getLogoBaseUrl() {
        return logoBaseUrl;
    }

    public void setLogoBaseUrl(String logoBaseUrl) {
        this.logoBaseUrl = logoBaseUrl;
    }

    public PaymentSessionResponse oneClickPaymentMethods(List<RecurringDetail> oneClickPaymentMethods) {
        this.oneClickPaymentMethods = oneClickPaymentMethods;
        return this;
    }

    public PaymentSessionResponse addOneClickPaymentMethodsItem(RecurringDetail oneClickPaymentMethodsItem) {

        if (this.oneClickPaymentMethods == null) {
            this.oneClickPaymentMethods = new ArrayList<>();
        }

        this.oneClickPaymentMethods.add(oneClickPaymentMethodsItem);
        return this;
    }

    /**
     * The detailed list of stored payment details required to generate payment forms. Will be empty if &#x60;enableOneClick&#x60; is set to false in the request.
     *
     * @return oneClickPaymentMethods
     **/
    public List<RecurringDetail> getOneClickPaymentMethods() {
        return oneClickPaymentMethods;
    }

    public void setOneClickPaymentMethods(List<RecurringDetail> oneClickPaymentMethods) {
        this.oneClickPaymentMethods = oneClickPaymentMethods;
    }

    public PaymentSessionResponse origin(String origin) {
        this.origin = origin;
        return this;
    }


    /**
     * The user origin.
     *
     * @return origin
     **/
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public PaymentSessionResponse originKey(String originKey) {
        this.originKey = originKey;
        return this;
    }


    /**
     * The encrypted user origin.
     *
     * @return originKey
     **/
    public String getOriginKey() {
        return originKey;
    }

    public void setOriginKey(String originKey) {
        this.originKey = originKey;
    }

    public PaymentSessionResponse payment(PaymentDetails payment) {
        this.payment = payment;
        return this;
    }


    /**
     * Get payment
     *
     * @return payment
     **/
    public PaymentDetails getPayment() {
        return payment;
    }

    public void setPayment(PaymentDetails payment) {
        this.payment = payment;
    }

    public PaymentSessionResponse paymentData(String paymentData) {
        this.paymentData = paymentData;
        return this;
    }


    /**
     * The data blob required to be sent in every future session call.
     *
     * @return paymentData
     **/
    public String getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(String paymentData) {
        this.paymentData = paymentData;
    }

    public PaymentSessionResponse paymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
        return this;
    }

    public PaymentSessionResponse addPaymentMethodsItem(PaymentMethod paymentMethodsItem) {

        if (this.paymentMethods == null) {
            this.paymentMethods = new ArrayList<>();
        }

        this.paymentMethods.add(paymentMethodsItem);
        return this;
    }

    /**
     * The detailed list of payment methods required to generate payment forms.
     *
     * @return paymentMethods
     **/
    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public PaymentSessionResponse paymentSession(String paymentSession) {
        this.paymentSession = paymentSession;
        return this;
    }


    /**
     * Base64-encoded version of this response.
     *
     * @return paymentSession
     **/
    public String getPaymentSession() {
        return paymentSession;
    }

    public void setPaymentSession(String paymentSession) {
        this.paymentSession = paymentSession;
    }

    public PaymentSessionResponse publicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }


    /**
     * The public key required to encrypt sensitive data.
     *
     * @return publicKey
     **/
    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public PaymentSessionResponse publicKeyToken(String publicKeyToken) {
        this.publicKeyToken = publicKeyToken;
        return this;
    }


    /**
     * The public key token.
     *
     * @return publicKeyToken
     **/
    public String getPublicKeyToken() {
        return publicKeyToken;
    }

    public void setPublicKeyToken(String publicKeyToken) {
        this.publicKeyToken = publicKeyToken;
    }

    public PaymentSessionResponse sdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
        return this;
    }


    /**
     * SDK version for the Web SDK. The value will be used for validation on Web SDK.
     *
     * @return sdkVersion
     **/
    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentSessionResponse paymentSessionResponse = (PaymentSessionResponse) o;
        return Objects.equals(this.company, paymentSessionResponse.company) &&
                Objects.equals(this.disableRecurringDetailUrl, paymentSessionResponse.disableRecurringDetailUrl) &&
                Objects.equals(this.generationtime, paymentSessionResponse.generationtime) &&
                Objects.equals(this.html, paymentSessionResponse.html) &&
                Objects.equals(this.initiationUrl, paymentSessionResponse.initiationUrl) &&
                Objects.equals(this.lineItems, paymentSessionResponse.lineItems) &&
                Objects.equals(this.logoBaseUrl, paymentSessionResponse.logoBaseUrl) &&
                Objects.equals(this.oneClickPaymentMethods, paymentSessionResponse.oneClickPaymentMethods) &&
                Objects.equals(this.origin, paymentSessionResponse.origin) &&
                Objects.equals(this.originKey, paymentSessionResponse.originKey) &&
                Objects.equals(this.payment, paymentSessionResponse.payment) &&
                Objects.equals(this.paymentData, paymentSessionResponse.paymentData) &&
                Objects.equals(this.paymentMethods, paymentSessionResponse.paymentMethods) &&
                Objects.equals(this.paymentSession, paymentSessionResponse.paymentSession) &&
                Objects.equals(this.publicKey, paymentSessionResponse.publicKey) &&
                Objects.equals(this.publicKeyToken, paymentSessionResponse.publicKeyToken) &&
                Objects.equals(this.sdkVersion, paymentSessionResponse.sdkVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, disableRecurringDetailUrl, generationtime, html, initiationUrl, lineItems, logoBaseUrl, oneClickPaymentMethods, origin, originKey, payment, paymentData, paymentMethods, paymentSession, publicKey, publicKeyToken, sdkVersion);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentSessionResponse {\n");

        sb.append("    company: ").append(toIndentedString(company)).append("\n");
        sb.append("    disableRecurringDetailUrl: ").append(toIndentedString(disableRecurringDetailUrl)).append("\n");
        sb.append("    generationtime: ").append(toIndentedString(generationtime)).append("\n");
        sb.append("    html: ").append(toIndentedString(html)).append("\n");
        sb.append("    initiationUrl: ").append(toIndentedString(initiationUrl)).append("\n");
        sb.append("    lineItems: ").append(toIndentedString(lineItems)).append("\n");
        sb.append("    logoBaseUrl: ").append(toIndentedString(logoBaseUrl)).append("\n");
        sb.append("    oneClickPaymentMethods: ").append(toIndentedString(oneClickPaymentMethods)).append("\n");
        sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
        sb.append("    originKey: ").append(toIndentedString(originKey)).append("\n");
        sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
        sb.append("    paymentData: ").append(toIndentedString(MaskUtil.mask(paymentData))).append("\n");
        sb.append("    paymentMethods: ").append(toIndentedString(paymentMethods)).append("\n");
        sb.append("    paymentSession: ").append(toIndentedString(paymentSession)).append("\n");
        sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
        sb.append("    publicKeyToken: ").append(toIndentedString(publicKeyToken)).append("\n");
        sb.append("    sdkVersion: ").append(toIndentedString(sdkVersion)).append("\n");
        sb.append("}");
        return sb.toString();
    }


}



