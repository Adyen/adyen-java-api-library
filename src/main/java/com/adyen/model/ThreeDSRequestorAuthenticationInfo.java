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
 * Copyright (c) 2022 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.IOException;
import java.util.Objects;

public class ThreeDSRequestorAuthenticationInfo {
    @SerializedName("threeDSReqAuthData")
    private String threeDSReqAuthData = null;

    /**
     * Mechanism used by the Cardholder to authenticate to the 3DS Requestor. Allowed values: * **01** — No 3DS Requestor authentication occurred (for example, cardholder “logged in” as guest). * **02** — Login to the cardholder account at the 3DS Requestor system using 3DS Requestor’s own credentials. * **03** — Login to the cardholder account at the 3DS Requestor system using federated ID. * **04** — Login to the cardholder account at the 3DS Requestor system using issuer credentials. * **05** — Login to the cardholder account at the 3DS Requestor system using third-party authentication. * **06** — Login to the cardholder account at the 3DS Requestor system using FIDO Authenticator.
     */
    @JsonAdapter(ThreeDSReqAuthMethodEnum.Adapter.class)
    public enum ThreeDSReqAuthMethodEnum {
        _01("01"),
        _02("02"),
        _03("03"),
        _04("04"),
        _05("05"),
        _06("06");

        @JsonValue
        private final String value;

        ThreeDSReqAuthMethodEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static ThreeDSReqAuthMethodEnum fromValue(String input) {
            for (ThreeDSReqAuthMethodEnum b : ThreeDSReqAuthMethodEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<ThreeDSReqAuthMethodEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ThreeDSReqAuthMethodEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public ThreeDSReqAuthMethodEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return ThreeDSReqAuthMethodEnum.fromValue((String) (value));
            }
        }
    }  @SerializedName("threeDSReqAuthMethod")
    private ThreeDSReqAuthMethodEnum threeDSReqAuthMethod = null;

    @SerializedName("threeDSReqAuthTimestamp")
    private String threeDSReqAuthTimestamp = null;

    public ThreeDSRequestorAuthenticationInfo threeDSReqAuthData(String threeDSReqAuthData) {
        this.threeDSReqAuthData = threeDSReqAuthData;
        return this;
    }

    /**
     * Data that documents and supports a specific authentication process. Maximum length: 2048 bytes.
     * @return threeDSReqAuthData
     **/
    @Schema(description = "Data that documents and supports a specific authentication process. Maximum length: 2048 bytes.")
    public String getThreeDSReqAuthData() {
        return threeDSReqAuthData;
    }

    public void setThreeDSReqAuthData(String threeDSReqAuthData) {
        this.threeDSReqAuthData = threeDSReqAuthData;
    }

    public ThreeDSRequestorAuthenticationInfo threeDSReqAuthMethod(ThreeDSReqAuthMethodEnum threeDSReqAuthMethod) {
        this.threeDSReqAuthMethod = threeDSReqAuthMethod;
        return this;
    }

    /**
     * Mechanism used by the Cardholder to authenticate to the 3DS Requestor. Allowed values: * **01** — No 3DS Requestor authentication occurred (for example, cardholder “logged in” as guest). * **02** — Login to the cardholder account at the 3DS Requestor system using 3DS Requestor’s own credentials. * **03** — Login to the cardholder account at the 3DS Requestor system using federated ID. * **04** — Login to the cardholder account at the 3DS Requestor system using issuer credentials. * **05** — Login to the cardholder account at the 3DS Requestor system using third-party authentication. * **06** — Login to the cardholder account at the 3DS Requestor system using FIDO Authenticator.
     * @return threeDSReqAuthMethod
     **/
    @Schema(description = "Mechanism used by the Cardholder to authenticate to the 3DS Requestor. Allowed values: * **01** — No 3DS Requestor authentication occurred (for example, cardholder “logged in” as guest). * **02** — Login to the cardholder account at the 3DS Requestor system using 3DS Requestor’s own credentials. * **03** — Login to the cardholder account at the 3DS Requestor system using federated ID. * **04** — Login to the cardholder account at the 3DS Requestor system using issuer credentials. * **05** — Login to the cardholder account at the 3DS Requestor system using third-party authentication. * **06** — Login to the cardholder account at the 3DS Requestor system using FIDO Authenticator.")
    public ThreeDSReqAuthMethodEnum getThreeDSReqAuthMethod() {
        return threeDSReqAuthMethod;
    }

    public void setThreeDSReqAuthMethod(ThreeDSReqAuthMethodEnum threeDSReqAuthMethod) {
        this.threeDSReqAuthMethod = threeDSReqAuthMethod;
    }

    public ThreeDSRequestorAuthenticationInfo threeDSReqAuthTimestamp(String threeDSReqAuthTimestamp) {
        this.threeDSReqAuthTimestamp = threeDSReqAuthTimestamp;
        return this;
    }

    /**
     * Date and time in UTC of the cardholder authentication. Format: YYYYMMDDHHMM
     * @return threeDSReqAuthTimestamp
     **/
    @Schema(description = "Date and time in UTC of the cardholder authentication. Format: YYYYMMDDHHMM")
    public String getThreeDSReqAuthTimestamp() {
        return threeDSReqAuthTimestamp;
    }

    public void setThreeDSReqAuthTimestamp(String threeDSReqAuthTimestamp) {
        this.threeDSReqAuthTimestamp = threeDSReqAuthTimestamp;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ThreeDSRequestorAuthenticationInfo threeDSRequestorAuthenticationInfo = (ThreeDSRequestorAuthenticationInfo) o;
        return Objects.equals(this.threeDSReqAuthData, threeDSRequestorAuthenticationInfo.threeDSReqAuthData) &&
                Objects.equals(this.threeDSReqAuthMethod, threeDSRequestorAuthenticationInfo.threeDSReqAuthMethod) &&
                Objects.equals(this.threeDSReqAuthTimestamp, threeDSRequestorAuthenticationInfo.threeDSReqAuthTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(threeDSReqAuthData, threeDSReqAuthMethod, threeDSReqAuthTimestamp);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ThreeDSRequestorAuthenticationInfo {\n");

        sb.append("    threeDSReqAuthData: ").append(toIndentedString(threeDSReqAuthData)).append("\n");
        sb.append("    threeDSReqAuthMethod: ").append(toIndentedString(threeDSReqAuthMethod)).append("\n");
        sb.append("    threeDSReqAuthTimestamp: ").append(toIndentedString(threeDSReqAuthTimestamp)).append("\n");
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
