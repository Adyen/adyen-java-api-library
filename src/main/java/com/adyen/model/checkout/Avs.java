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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/**
 * Avs
 */
public class Avs {

    @SerializedName("addressEditable")
    private Boolean addressEditable = null;
    @SerializedName("enabled")
    private EnabledEnum enabled = null;

    public Avs addressEditable(Boolean addressEditable) {
        this.addressEditable = addressEditable;
        return this;
    }

    /**
     * Indicates whether the shopper is allowed to modify the billing address for the current payment request.
     *
     * @return addressEditable
     **/
    public Boolean isAddressEditable() {
        return addressEditable;
    }

    public void setAddressEditable(Boolean addressEditable) {
        this.addressEditable = addressEditable;
    }

    public Avs enabled(EnabledEnum enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Specifies whether the shopper should enter their billing address during checkout.  Allowed values: * yes — Perform AVS checks for every card payment. * automatic — Perform AVS checks only when required to optimize the conversion rate. * no — Do not perform AVS checks.
     *
     * @return enabled
     **/
    public EnabledEnum getEnabled() {
        return enabled;
    }

    public void setEnabled(EnabledEnum enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Avs avs = (Avs) o;
        return Objects.equals(this.addressEditable, avs.addressEditable) &&
                Objects.equals(this.enabled, avs.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressEditable, enabled);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Avs {\n");

        sb.append("    addressEditable: ").append(toIndentedString(addressEditable)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
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

    /**
     * Specifies whether the shopper should enter their billing address during checkout.  Allowed values: * yes — Perform AVS checks for every card payment. * automatic — Perform AVS checks only when required to optimize the conversion rate. * no — Do not perform AVS checks.
     */
    @JsonAdapter(EnabledEnum.Adapter.class)
    public enum EnabledEnum {

        YES("yes"),
        NO("no"),
        AUTOMATIC("automatic");

        private String value;

        EnabledEnum(String value) {
            this.value = value;
        }

        public static EnabledEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static class Adapter extends TypeAdapter<EnabledEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final EnabledEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public EnabledEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return EnabledEnum.fromValue(String.valueOf(value));
            }
        }
    }


}



