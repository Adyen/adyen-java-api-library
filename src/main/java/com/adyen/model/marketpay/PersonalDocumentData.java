
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

package com.adyen.model.marketpay;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/**
 * PersonalDocumentData
 */
public class PersonalDocumentData {
    @SerializedName("expirationDate")
    private String expirationDate = null;

    @SerializedName("issuerCountry")
    private String issuerCountry = null;

    @SerializedName("issuerState")
    private String issuerState = null;

    @SerializedName("number")
    private String number = null;

    /**
     * The type of the document. More then one item pert type does not allowed. Valid values: ID, PASSPORT, VISA, DRIVINGLICENSE
     */
    @JsonAdapter(TypeEnum.Adapter.class)
    public enum TypeEnum {
        DRIVINGLICENSE("DRIVINGLICENSE"),
        ID("ID"),
        PASSPORT("PASSPORT"),
        SOCIALSECURITY("SOCIALSECURITY"),
        VISA("VISA");

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
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
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

    public PersonalDocumentData expirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    /**
     * The expiration date of the document. The date should be in ISO-8601 format yyyy-mm-dd (e.g. 2000-01-31).
     *
     * @return expirationDate
     **/
    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public PersonalDocumentData issuerCountry(String issuerCountry) {
        this.issuerCountry = issuerCountry;
        return this;
    }

    /**
     * The two-character country code of the issuer. &gt;The permitted country codes are defined in ISO-3166-1 alpha-2 (e.g. &#x27;NL&#x27;).
     *
     * @return issuerCountry
     **/
    public String getIssuerCountry() {
        return issuerCountry;
    }

    public void setIssuerCountry(String issuerCountry) {
        this.issuerCountry = issuerCountry;
    }

    public PersonalDocumentData issuerState(String issuerState) {
        this.issuerState = issuerState;
        return this;
    }

    /**
     * The state issued the document (if applicable)
     *
     * @return issuerState
     **/
    public String getIssuerState() {
        return issuerState;
    }

    public void setIssuerState(String issuerState) {
        this.issuerState = issuerState;
    }

    public PersonalDocumentData number(String number) {
        this.number = number;
        return this;
    }

    /**
     * The number of the document. Delete the given type if the value empty.
     *
     * @return number
     **/
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PersonalDocumentData type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the document. More then one item pert type does not allowed. Valid values: ID, PASSPORT, VISA, DRIVINGLICENSE
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
        PersonalDocumentData personalDocumentData = (PersonalDocumentData) o;
        return Objects.equals(this.expirationDate, personalDocumentData.expirationDate) &&
                Objects.equals(this.issuerCountry, personalDocumentData.issuerCountry) &&
                Objects.equals(this.issuerState, personalDocumentData.issuerState) &&
                Objects.equals(this.number, personalDocumentData.number) &&
                Objects.equals(this.type, personalDocumentData.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expirationDate, issuerCountry, issuerState, number, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PersonalDocumentData {\n");

        sb.append("    expirationDate: ").append(toIndentedString(expirationDate)).append("\n");
        sb.append("    issuerCountry: ").append(toIndentedString(issuerCountry)).append("\n");
        sb.append("    issuerState: ").append(toIndentedString(issuerState)).append("\n");
        sb.append("    number: ").append(toIndentedString(number)).append("\n");
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
