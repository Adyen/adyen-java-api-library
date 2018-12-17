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
import java.util.Map;
import java.util.Objects;
import com.adyen.model.FraudResult;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * PaymentResultResponse
 */
public class PaymentResultResponse {

    @SerializedName("additionalData")
    private Map<String, String> additionalData = null;

    @SerializedName("authResponse")
    private String authResponse = null;

    @SerializedName("fraudResult")
    private FraudResult fraudResult = null;

    @SerializedName("merchantReference")
    private String merchantReference = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("refusalReason")
    private String refusalReason = null;

    @SerializedName("resultCode")
    private ResultCodeEnum resultCode = null;


    @SerializedName("refusalReasonCode")
    private String refusalReasonCode = null;

    public String getRefusalReasonCode() {
        return refusalReasonCode;
    }

    public void setRefusalReasonCode(String refusalReasonCode) {
        this.refusalReasonCode = refusalReasonCode;
    }

    public PaymentResultResponse additionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
        return this;
    }

    public PaymentResultResponse putAdditionalDataItem(String key, String additionalDataItem) {

        if (this.additionalData == null) {
            this.additionalData = null;
        }

        this.additionalData.put(key, additionalDataItem);
        return this;
    }

    /**
     * This field contains additional data, which may be required to return in a particular payment response. To choose data fields to be returned, go to **Customer Area** &gt; **Settings** &gt; **API
     * and Response**.
     *
     * @return additionalData
     **/
    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    public PaymentResultResponse authResponse(String authResponse) {
        this.authResponse = authResponse;
        return this;
    }

    /**
     * The authorisation code representing the authentication result.  Possible values: * Received * Authorised * Error * Refused * Cancelled * Unknown
     *
     * @return authResponse
     **/
    public String getAuthResponse() {
        return authResponse;
    }

    public void setAuthResponse(String authResponse) {
        this.authResponse = authResponse;
    }

    /**
     * Get fraudResult
     *
     * @return fraudResult
     **/
    public FraudResult getFraudResult() {
        return fraudResult;
    }

    public void setFraudResult(FraudResult fraudResult) {
        this.fraudResult = fraudResult;
    }

    public PaymentResultResponse merchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
        return this;
    }

    /**
     * A unique value that you provided in the initial &#x60;/paymentSession&#x60; request as a &#x60;reference&#x60; field.
     *
     * @return merchantReference
     **/
    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }

    public PaymentResultResponse pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * Adyen&#x27;s 16-digit unique reference associated with the transaction/the request. This value is globally unique; quote it when communicating with us about this request.  &gt;
     * &#x60;pspReference&#x60; is returned only for non-redirect payment methods.
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public PaymentResultResponse refusalReason(String refusalReason) {
        this.refusalReason = refusalReason;
        return this;
    }

    /**
     * If the payment&#x27;s authorisation is refused or an error occurs during authorisation, this field holds Adyen&#x27;s mapped reason for the refusal or a description of the error.  When a
     * transaction fails, the authorisation response includes &#x60;resultCode&#x60; and &#x60;refusalReason&#x60; values.
     *
     * @return refusalReason
     **/
    public String getRefusalReason() {
        return refusalReason;
    }

    public void setRefusalReason(String refusalReason) {
        this.refusalReason = refusalReason;
    }

    public PaymentResultResponse resultCode(ResultCodeEnum resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    /**
     * The result of the payment. Possible values:  * **Authorised** – Indicates the payment authorisation was successfully completed. This state serves as an indicator to proceed with the delivery of
     * goods and services. This is a final state. * **Refused** – Indicates the payment was refused. The reason is given in the &#x60;refusalReason&#x60; field. This is a final state. *
     * **RedirectShopper** – Indicates the shopper should be redirected to an external web page or app to complete the authorisation. For more information on handling a redirect, refer to [Handling a
     * redirect](https://docs.adyen.com/developers/checkout/api-integration/payments#handlingaredirect). * **Received** – Indicates the payment has successfully been received by Adyen, and will be
     * processed. This is the initial state for all payments. * **Cancelled** – Indicates the payment has been cancelled (either by the shopper or the merchant) before processing was completed. This
     * is a final state. * **Pending** – Indicates that it is not possible to obtain the final status of the payment. This can happen if the systems providing final status information for the payment
     * are unavailable, or if the shopper needs to take further action to complete the payment. For more information on handling a pending payment, refer to [Payments with pending
     * status](https://docs.adyen.com/developers/development-resources/payments-with-pending-status). * **Error** – Indicates an error occurred during processing of the payment. The reason is given in
     * the &#x60;refusalReason&#x60; field. This is a final state.
     *
     * @return resultCode
     **/
    public ResultCodeEnum getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCodeEnum resultCode) {
        this.resultCode = resultCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentResultResponse paymentVerificationResponse = (PaymentResultResponse) o;
        return Objects.equals(this.additionalData, paymentVerificationResponse.additionalData)
                && Objects.equals(this.authResponse, paymentVerificationResponse.authResponse)
                && Objects.equals(this.fraudResult, paymentVerificationResponse.fraudResult)
                && Objects.equals(this.merchantReference, paymentVerificationResponse.merchantReference)
                && Objects.equals(this.pspReference, paymentVerificationResponse.pspReference)
                && Objects.equals(this.refusalReason, paymentVerificationResponse.refusalReason)
                && Objects.equals(this.refusalReasonCode, paymentVerificationResponse.refusalReasonCode)
                && Objects.equals(this.resultCode, paymentVerificationResponse.resultCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalData, authResponse, fraudResult, merchantReference, pspReference, refusalReason, refusalReasonCode, resultCode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentResultResponse {\n");

        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
        sb.append("    authResponse: ").append(toIndentedString(authResponse)).append("\n");
        sb.append("    fraudResult: ").append(toIndentedString(fraudResult)).append("\n");
        sb.append("    merchantReference: ").append(toIndentedString(merchantReference)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    refusalReason: ").append(toIndentedString(refusalReason)).append("\n");
        sb.append("    refusalReasonCode: ").append(toIndentedString(refusalReasonCode)).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
        sb.append("}");
        return sb.toString();
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

    /**
     * The result of the payment. Possible values:  * **Authorised** – Indicates the payment authorisation was successfully completed. This state serves as an indicator to proceed with the delivery of
     * goods and services. This is a final state. * **Refused** – Indicates the payment was refused. The reason is given in the &#x60;refusalReason&#x60; field. This is a final state. *
     * **RedirectShopper** – Indicates the shopper should be redirected to an external web page or app to complete the authorisation. For more information on handling a redirect, refer to [Handling a
     * redirect](https://docs.adyen.com/developers/checkout/api-integration/payments#handlingaredirect). * **Received** – Indicates the payment has successfully been received by Adyen, and will be
     * processed. This is the initial state for all payments. * **Cancelled** – Indicates the payment has been cancelled (either by the shopper or the merchant) before processing was completed. This
     * is a final state. * **Pending** – Indicates that it is not possible to obtain the final status of the payment. This can happen if the systems providing final status information for the payment
     * are unavailable, or if the shopper needs to take further action to complete the payment. For more information on handling a pending payment, refer to [Payments with pending
     * status](https://docs.adyen.com/developers/development-resources/payments-with-pending-status). * **Error** – Indicates an error occurred during processing of the payment. The reason is given in
     * the &#x60;refusalReason&#x60; field. This is a final state.
     */
    @JsonAdapter(ResultCodeEnum.Adapter.class)
    public enum ResultCodeEnum {

        AUTHORISED("Authorised"),
        PARTIALLYAUTHORISED("PartiallyAuthorised"),
        REFUSED("Refused"),
        ERROR("Error"),
        CANCELLED("Cancelled"),
        RECEIVED("Received"),
        REDIRECTSHOPPER("RedirectShopper");

        private String value;

        ResultCodeEnum(String value) {
            this.value = value;
        }

        public static ResultCodeEnum fromValue(String text) {
            for (ResultCodeEnum b : ResultCodeEnum.values()) {
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

        public static class Adapter extends TypeAdapter<ResultCodeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ResultCodeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public ResultCodeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return ResultCodeEnum.fromValue(String.valueOf(value));
            }
        }
    }


}



