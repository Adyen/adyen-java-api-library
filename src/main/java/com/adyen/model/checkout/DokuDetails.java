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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * DokuDetails
 */

public class DokuDetails implements PaymentMethodDetails {
    @SerializedName("firstName")
    private String firstName = null;

    @SerializedName("lastName")
    private String lastName = null;

    @SerializedName("shopperEmail")
    private String shopperEmail = null;

    /**
     * **doku**
     */
    @JsonAdapter(TypeEnum.Adapter.class)
    public enum TypeEnum {
        MANDIRI_VA("doku_mandiri_va"),
        CIMB_VA("doku_cimb_va"),
        DANAMON_VA("doku_danamon_va"),
        BNI_VA("doku_bni_va"),
        PERMATA_LITE_ATM("doku_permata_lite_atm"),
        BRI_VA("doku_bri_va"),
        BCA_VA("doku_bca_va"),
        ALFAMART("doku_alfamart"),
        INDOMARET("doku_indomaret");

        private String value;

        TypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static TypeEnum fromValue(String text) {
            for (TypeEnum b : TypeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<TypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return TypeEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("type")
    private TypeEnum type = null;

    public DokuDetails firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * The shopper&#x27;s first name.
     *
     * @return firstName
     **/
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public DokuDetails lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * The shopper&#x27;s last name.
     *
     * @return lastName
     **/
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DokuDetails shopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
        return this;
    }

    /**
     * The shopper&#x27;s email.
     *
     * @return shopperEmail
     **/
    public String getShopperEmail() {
        return shopperEmail;
    }

    public void setShopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
    }

    public DokuDetails type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * **doku**
     *
     * @return type
     **/
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DokuDetails dokuDetails = (DokuDetails) o;
        return Objects.equals(this.firstName, dokuDetails.firstName) &&
                Objects.equals(this.lastName, dokuDetails.lastName) &&
                Objects.equals(this.shopperEmail, dokuDetails.shopperEmail) &&
                Objects.equals(this.type, dokuDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, shopperEmail, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DokuDetails {\n");

        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    shopperEmail: ").append(toIndentedString(shopperEmail)).append("\n");
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
