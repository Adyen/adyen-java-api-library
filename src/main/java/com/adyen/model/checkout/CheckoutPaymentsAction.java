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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Objects;

public class CheckoutPaymentsAction {

    @JsonAdapter(CheckoutActionType.Adapter.class)
    public enum CheckoutActionType {
        QRCODE("qrCode"),
        THREEDS2FINGERPRINT("threeDS2Fingerprint"),
        THREEDS2CHALLENGE("threeDS2Challenge"),
        VOUCHER("voucher"),
        REDIRECT("redirect");

        private String value;

        CheckoutActionType(String value) {
            this.value = value;
        }

        public static CheckoutActionType fromValue(String text) {
            for (CheckoutActionType b : CheckoutActionType.values()) {
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
    private CheckoutActionType type;
    @SerializedName("paymentMethodType")
    private String paymentMethodType;

    //redirect action specific fields
    @SerializedName("url")
    private String url;
    @SerializedName("method")
    private String method;

    //threeDS2Fingerprint/threeDS2Challenge action specific fields
    @SerializedName("token")
    private String token;

    //qrCode action specific fields
    @SerializedName("qrCodeData")
    private String qrCodeData;

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
     * Specifies the HTTP method; e.g. GET, POST
     *
     * @return method
     **/
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CheckoutPaymentsAction that = (CheckoutPaymentsAction) o;
        return type == that.type &&
                Objects.equals(paymentMethodType, that.paymentMethodType) &&
                Objects.equals(url, that.url) &&
                Objects.equals(method, that.method) &&
                Objects.equals(token, that.token) &&
                Objects.equals(qrCodeData, that.qrCodeData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, paymentMethodType, url, method, token, qrCodeData);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CheckoutPaymentsAction {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    paymentMethodType: ").append(toIndentedString(paymentMethodType)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    method: ").append(toIndentedString(method)).append("\n");
        sb.append("    token: ").append(toIndentedString(token)).append("\n");
        sb.append("    qrCodeData: ").append(toIndentedString(qrCodeData)).append("\n");
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
