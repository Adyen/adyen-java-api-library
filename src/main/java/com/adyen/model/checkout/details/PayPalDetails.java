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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/**
 * PayPalDetails
 */

public class PayPalDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String PAYPAL = "paypal";

    @SerializedName("type")
    private String type = PAYPAL;

    @JsonAdapter(SubtypeEnum.Adapter.class)
    public enum SubtypeEnum {
        SDK("sdk"),
        REDIRECT("redirect");

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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PayPalDetails paypalDetails = (PayPalDetails) o;
        return Objects.equals(this.subtype, paypalDetails.subtype) &&
                Objects.equals(this.type, paypalDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subtype, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PayPalDetails {\n");

        sb.append("    subtype: ").append(toIndentedString(subtype)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
