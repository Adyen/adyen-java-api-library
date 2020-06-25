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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.checkout;

import java.util.Objects;

import com.adyen.model.FraudResult;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.adyen.model.Amount;

/**
 * CheckoutCreateOrderResponse
 */

public class CheckoutCreateOrderResponse {
    @SerializedName("additionalData")
    private Map<String, String> additionalData = null;

    @SerializedName("expiresAt")
    private String expiresAt = null;

    @SerializedName("fraudResult")
    private FraudResult fraudResult = null;

    @SerializedName("orderData")
    private String orderData = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("refusalReason")
    private String refusalReason = null;

    @SerializedName("remainingAmount")
    private Amount remainingAmount = null;

    @SerializedName("reference")
    private String reference = null;

    /**
     * The result of the payment. For more information, see [Result codes](https://docs.adyen.com/checkout/payment-result-codes).  Possible values:  * **AuthenticationFinished** – The payment has been successfully authenticated with 3D Secure 2. Returned for 3D Secure 2 authentication-only transactions. * **Authorised** – The payment was successfully authorised. This state serves as an indicator to proceed with the delivery of goods and services. This is a final state. * **Cancelled** – Indicates the payment has been cancelled (either by the shopper or the merchant) before processing was completed. This is a final state. * **ChallengeShopper** – The issuer requires further shopper interaction before the payment can be authenticated. Returned for 3D Secure 2 transactions. * **Error** – There was an error when the payment was being processed. The reason is given in the &#x60;refusalReason&#x60; field. This is a final state. * **IdentifyShopper** – The issuer requires the shopper&#x27;s device fingerprint before the payment can be authenticated. Returned for 3D Secure 2 transactions. * **Pending** – Indicates that it is not possible to obtain the final status of the payment. This can happen if the systems providing final status information for the payment are unavailable, or if the shopper needs to take further action to complete the payment. * **PresentToShopper** – Indicates that the response contains additional information that you need to present to a shopper, so that they can use it to complete a payment. * **Received** – Indicates the payment has successfully been received by Adyen, and will be processed. This is the initial state for all payments. * **RedirectShopper** – Indicates the shopper should be redirected to an external web page or app to complete the authorisation. * **Refused** – Indicates the payment was refused. The reason is given in the &#x60;refusalReason&#x60; field. This is a final state.
     */
    @JsonAdapter(ResultCodeEnum.Adapter.class)
    public enum ResultCodeEnum {
        SUCCESS("Success");

        private String value;

        ResultCodeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static ResultCodeEnum fromValue(String text) {
            for (ResultCodeEnum b : ResultCodeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
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

    @SerializedName("resultCode")
    private ResultCodeEnum resultCode = null;

    public CheckoutCreateOrderResponse additionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
        return this;
    }

    public CheckoutCreateOrderResponse putAdditionalDataItem(String key, String additionalDataItem) {
        if (this.additionalData == null) {
            this.additionalData = new HashMap<String, String>();
        }
        this.additionalData.put(key, additionalDataItem);
        return this;
    }

    /**
     * This field contains additional data, which may be required to return in a particular payment response. To choose data fields to be returned, go to **Customer Area** &gt; **Account** &gt; **API URLs** &gt; **Additional data settings**.
     *
     * @return additionalData
     **/
    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    public CheckoutCreateOrderResponse expiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
        return this;
    }

    /**
     * The date that the order will expire.
     *
     * @return expiresAt
     **/
    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public CheckoutCreateOrderResponse fraudResult(FraudResult fraudResult) {
        this.fraudResult = fraudResult;
        return this;
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

    public CheckoutCreateOrderResponse orderData(String orderData) {
        this.orderData = orderData;
        return this;
    }

    /**
     * The encrypted data that will be used by merchant for adding payments to the order.
     *
     * @return orderData
     **/
    public String getOrderData() {
        return orderData;
    }

    public void setOrderData(String orderData) {
        this.orderData = orderData;
    }

    public CheckoutCreateOrderResponse pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * Adyen&#x27;s 16-character string reference associated with the transaction/request. This value is globally unique; quote it when communicating with us about this request.  &gt; &#x60;pspReference&#x60; is returned only for non-redirect payment methods.
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public CheckoutCreateOrderResponse refusalReason(String refusalReason) {
        this.refusalReason = refusalReason;
        return this;
    }

    /**
     * If the payment&#x27;s authorisation is refused or an error occurs during authorisation, this field holds Adyen&#x27;s mapped reason for the refusal or a description of the error. When a transaction fails, the authorisation response includes &#x60;resultCode&#x60; and &#x60;refusalReason&#x60; values.  For more information, see [Refusal reasons](https://docs.adyen.com/development-resources/refusal-reasons).
     *
     * @return refusalReason
     **/
    public String getRefusalReason() {
        return refusalReason;
    }

    public void setRefusalReason(String refusalReason) {
        this.refusalReason = refusalReason;
    }

    public CheckoutCreateOrderResponse remainingAmount(Amount remainingAmount) {
        this.remainingAmount = remainingAmount;
        return this;
    }

    /**
     * Get remainingAmount
     *
     * @return remainingAmount
     **/
    public Amount getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(Amount remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public CheckoutCreateOrderResponse resultCode(ResultCodeEnum resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    /**
     * The result of the payment. For more information, see [Result codes](https://docs.adyen.com/checkout/payment-result-codes).  Possible values:  * **AuthenticationFinished** – The payment has been successfully authenticated with 3D Secure 2. Returned for 3D Secure 2 authentication-only transactions. * **Authorised** – The payment was successfully authorised. This state serves as an indicator to proceed with the delivery of goods and services. This is a final state. * **Cancelled** – Indicates the payment has been cancelled (either by the shopper or the merchant) before processing was completed. This is a final state. * **ChallengeShopper** – The issuer requires further shopper interaction before the payment can be authenticated. Returned for 3D Secure 2 transactions. * **Error** – There was an error when the payment was being processed. The reason is given in the &#x60;refusalReason&#x60; field. This is a final state. * **IdentifyShopper** – The issuer requires the shopper&#x27;s device fingerprint before the payment can be authenticated. Returned for 3D Secure 2 transactions. * **Pending** – Indicates that it is not possible to obtain the final status of the payment. This can happen if the systems providing final status information for the payment are unavailable, or if the shopper needs to take further action to complete the payment. * **PresentToShopper** – Indicates that the response contains additional information that you need to present to a shopper, so that they can use it to complete a payment. * **Received** – Indicates the payment has successfully been received by Adyen, and will be processed. This is the initial state for all payments. * **RedirectShopper** – Indicates the shopper should be redirected to an external web page or app to complete the authorisation. * **Refused** – Indicates the payment was refused. The reason is given in the &#x60;refusalReason&#x60; field. This is a final state.
     *
     * @return resultCode
     **/
    public ResultCodeEnum getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCodeEnum resultCode) {
        this.resultCode = resultCode;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public CheckoutCreateOrderResponse reference(String reference) {
        this.reference = reference;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CheckoutCreateOrderResponse checkoutCreateOrderResponse = (CheckoutCreateOrderResponse) o;
        return Objects.equals(this.additionalData, checkoutCreateOrderResponse.additionalData) &&
                Objects.equals(this.expiresAt, checkoutCreateOrderResponse.expiresAt) &&
                Objects.equals(this.fraudResult, checkoutCreateOrderResponse.fraudResult) &&
                Objects.equals(this.orderData, checkoutCreateOrderResponse.orderData) &&
                Objects.equals(this.pspReference, checkoutCreateOrderResponse.pspReference) &&
                Objects.equals(this.refusalReason, checkoutCreateOrderResponse.refusalReason) &&
                Objects.equals(this.remainingAmount, checkoutCreateOrderResponse.remainingAmount) &&
                Objects.equals(this.reference, checkoutCreateOrderResponse.reference) &&
                Objects.equals(this.resultCode, checkoutCreateOrderResponse.resultCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalData, expiresAt, fraudResult, orderData, pspReference, refusalReason, remainingAmount, reference, resultCode);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CheckoutCreateOrderResponse {\n");

        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
        sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
        sb.append("    fraudResult: ").append(toIndentedString(fraudResult)).append("\n");
        sb.append("    orderData: ").append(toIndentedString(orderData)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    refusalReason: ").append(toIndentedString(refusalReason)).append("\n");
        sb.append("    remainingAmount: ").append(toIndentedString(remainingAmount)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
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
