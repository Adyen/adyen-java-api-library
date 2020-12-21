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

package com.adyen.model.checkout.details;

import com.adyen.model.checkout.PaymentMethodDetails;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * PayPalDetails
 */

public class PayPalDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String PAYPAL = "paypal";

    @SerializedName("orderID")
    private String orderID = null;

    @SerializedName("payerID")
    private String payerID = null;

    @SerializedName("type")
    private String type = PAYPAL;

    @SerializedName("storedPaymentMethodId")
    private String storedPaymentMethodId = null;

    @JsonAdapter(SubtypeEnum.Adapter.class)
    public enum SubtypeEnum {
        SDK("sdk"),
        REDIRECT("redirect");

        @JsonValue
        private String value;

        SubtypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static SubtypeEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<SubtypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final SubtypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public SubtypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return SubtypeEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("subtype")
    private SubtypeEnum subtype = null;

    public PayPalDetails orderID(String orderID) {
        this.orderID = orderID;
        return this;
    }

    /**
     * Get orderID
     *
     * @return orderID
     **/
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public PayPalDetails payerID(String payerID) {
        this.payerID = payerID;
        return this;
    }

    /**
     * Get payerID
     *
     * @return payerID
     **/
    public String getPayerID() {
        return payerID;
    }

    public void setPayerID(String payerID) {
        this.payerID = payerID;
    }

    public PayPalDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * **paypal**
     *
     * @return type
     **/
    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    public PayPalDetails subtype(SubtypeEnum subtype) {
        this.subtype = subtype;
        return this;
    }

    public SubtypeEnum getSubtype() {
        return subtype;
    }

    public void setSubtype(SubtypeEnum subtype) {
        this.subtype = subtype;
    }

    public String getStoredPaymentMethodId() {
        return storedPaymentMethodId;
    }

    public void setStoredPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PayPalDetails payPalDetails = (PayPalDetails) o;
        return Objects.equals(this.orderID, payPalDetails.orderID) &&
                Objects.equals(this.payerID, payPalDetails.payerID) &&
                Objects.equals(this.storedPaymentMethodId, payPalDetails.storedPaymentMethodId) &&
                Objects.equals(this.subtype, payPalDetails.subtype) &&
                Objects.equals(this.type, payPalDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, payerID, storedPaymentMethodId, subtype, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PayPalDetails {\n");

        sb.append("    orderID: ").append(toIndentedString(orderID)).append("\n");
        sb.append("    payerID: ").append(toIndentedString(payerID)).append("\n");
        sb.append("    storedPaymentMethodId: ").append(toIndentedString(storedPaymentMethodId)).append("\n");
        sb.append("    subtype: ").append(toIndentedString(subtype)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
