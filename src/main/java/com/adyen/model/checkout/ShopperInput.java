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
 * ShopperInput
 */
public class ShopperInput {

    /**
     * Specifies visibility of billing address fields.  Permitted values: * editable * hidden * readOnly
     */
    @JsonAdapter(BillingAddressEnum.Adapter.class)
    public enum BillingAddressEnum {

        EDITABLE("editable"),
        HIDDEN("hidden"),
        READONLY("readOnly");

        private String value;

        BillingAddressEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static BillingAddressEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<BillingAddressEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final BillingAddressEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public BillingAddressEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return BillingAddressEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("billingAddress")
    private BillingAddressEnum billingAddress = null;

    /**
     * Specifies visibility of delivery address fields.  Permitted values: * editable * hidden * readOnly
     */
    @JsonAdapter(DeliveryAddressEnum.Adapter.class)
    public enum DeliveryAddressEnum {

        EDITABLE("editable"),
        HIDDEN("hidden"),
        READONLY("readOnly");

        private String value;

        DeliveryAddressEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static DeliveryAddressEnum fromValue(String text) {
            return Arrays.stream(DeliveryAddressEnum.values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<DeliveryAddressEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final DeliveryAddressEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public DeliveryAddressEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return DeliveryAddressEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("deliveryAddress")
    private DeliveryAddressEnum deliveryAddress = null;

    /**
     * Specifies visibility of personal details.  Permitted values: * editable * hidden * readOnly
     */
    @JsonAdapter(PersonalDetailsEnum.Adapter.class)
    public enum PersonalDetailsEnum {

        EDITABLE("editable"),
        HIDDEN("hidden"),
        READONLY("readOnly");

        private String value;

        PersonalDetailsEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static PersonalDetailsEnum fromValue(String text) {
            return Arrays.stream(PersonalDetailsEnum.values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<PersonalDetailsEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final PersonalDetailsEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public PersonalDetailsEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return PersonalDetailsEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("personalDetails")
    private PersonalDetailsEnum personalDetails = null;

    public ShopperInput billingAddress(BillingAddressEnum billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }


    public BillingAddressEnum getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddressEnum billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShopperInput deliveryAddress(DeliveryAddressEnum deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }


    public DeliveryAddressEnum getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddressEnum deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public ShopperInput personalDetails(PersonalDetailsEnum personalDetails) {
        this.personalDetails = personalDetails;
        return this;
    }


    public PersonalDetailsEnum getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetailsEnum personalDetails) {
        this.personalDetails = personalDetails;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShopperInput shopperInput = (ShopperInput) o;
        return Objects.equals(this.billingAddress, shopperInput.billingAddress) &&
                Objects.equals(this.deliveryAddress, shopperInput.deliveryAddress) &&
                Objects.equals(this.personalDetails, shopperInput.personalDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billingAddress, deliveryAddress, personalDetails);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ShopperInput {\n");

        sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
        sb.append("    deliveryAddress: ").append(toIndentedString(deliveryAddress)).append("\n");
        sb.append("    personalDetails: ").append(toIndentedString(personalDetails)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }


}



