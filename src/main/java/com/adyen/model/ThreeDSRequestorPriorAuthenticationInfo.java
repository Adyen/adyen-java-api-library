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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.IOException;
import java.util.Objects;

public class ThreeDSRequestorPriorAuthenticationInfo {
    @SerializedName("threeDSReqPriorAuthData")
    private String threeDSReqPriorAuthData = null;

    /**
     * Mechanism used by the Cardholder to previously authenticate to the 3DS Requestor. Allowed values: * **01** — Frictionless authentication occurred by ACS. * **02** — Cardholder challenge occurred by ACS. * **03** — AVS verified. * **04** — Other issuer methods.
     */
    @JsonAdapter(ThreeDSReqPriorAuthMethodEnum.Adapter.class)
    public enum ThreeDSReqPriorAuthMethodEnum {
        _01("01"),
        _02("02"),
        _03("03"),
        _04("04");

        private final String value;

        ThreeDSReqPriorAuthMethodEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static ThreeDSReqPriorAuthMethodEnum fromValue(String input) {
            for (ThreeDSReqPriorAuthMethodEnum b : ThreeDSReqPriorAuthMethodEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<ThreeDSReqPriorAuthMethodEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ThreeDSReqPriorAuthMethodEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public ThreeDSReqPriorAuthMethodEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return ThreeDSReqPriorAuthMethodEnum.fromValue((String) (value));
            }
        }
    }  @SerializedName("threeDSReqPriorAuthMethod")
    private ThreeDSReqPriorAuthMethodEnum threeDSReqPriorAuthMethod = null;

    @SerializedName("threeDSReqPriorAuthTimestamp")
    private String threeDSReqPriorAuthTimestamp = null;

    @SerializedName("threeDSReqPriorRef")
    private String threeDSReqPriorRef = null;

    public ThreeDSRequestorPriorAuthenticationInfo threeDSReqPriorAuthData(String threeDSReqPriorAuthData) {
        this.threeDSReqPriorAuthData = threeDSReqPriorAuthData;
        return this;
    }

    /**
     * Data that documents and supports a specific authentication process. Maximum length: 2048 bytes.
     * @return threeDSReqPriorAuthData
     **/
    @Schema(description = "Data that documents and supports a specific authentication process. Maximum length: 2048 bytes.")
    public String getThreeDSReqPriorAuthData() {
        return threeDSReqPriorAuthData;
    }

    public void setThreeDSReqPriorAuthData(String threeDSReqPriorAuthData) {
        this.threeDSReqPriorAuthData = threeDSReqPriorAuthData;
    }

    public ThreeDSRequestorPriorAuthenticationInfo threeDSReqPriorAuthMethod(ThreeDSReqPriorAuthMethodEnum threeDSReqPriorAuthMethod) {
        this.threeDSReqPriorAuthMethod = threeDSReqPriorAuthMethod;
        return this;
    }

    /**
     * Mechanism used by the Cardholder to previously authenticate to the 3DS Requestor. Allowed values: * **01** — Frictionless authentication occurred by ACS. * **02** — Cardholder challenge occurred by ACS. * **03** — AVS verified. * **04** — Other issuer methods.
     * @return threeDSReqPriorAuthMethod
     **/
    @Schema(description = "Mechanism used by the Cardholder to previously authenticate to the 3DS Requestor. Allowed values: * **01** — Frictionless authentication occurred by ACS. * **02** — Cardholder challenge occurred by ACS. * **03** — AVS verified. * **04** — Other issuer methods.")
    public ThreeDSReqPriorAuthMethodEnum getThreeDSReqPriorAuthMethod() {
        return threeDSReqPriorAuthMethod;
    }

    public void setThreeDSReqPriorAuthMethod(ThreeDSReqPriorAuthMethodEnum threeDSReqPriorAuthMethod) {
        this.threeDSReqPriorAuthMethod = threeDSReqPriorAuthMethod;
    }

    public ThreeDSRequestorPriorAuthenticationInfo threeDSReqPriorAuthTimestamp(String threeDSReqPriorAuthTimestamp) {
        this.threeDSReqPriorAuthTimestamp = threeDSReqPriorAuthTimestamp;
        return this;
    }

    /**
     * Date and time in UTC of the prior cardholder authentication. Format: YYYYMMDDHHMM
     * @return threeDSReqPriorAuthTimestamp
     **/
    @Schema(description = "Date and time in UTC of the prior cardholder authentication. Format: YYYYMMDDHHMM")
    public String getThreeDSReqPriorAuthTimestamp() {
        return threeDSReqPriorAuthTimestamp;
    }

    public void setThreeDSReqPriorAuthTimestamp(String threeDSReqPriorAuthTimestamp) {
        this.threeDSReqPriorAuthTimestamp = threeDSReqPriorAuthTimestamp;
    }

    public ThreeDSRequestorPriorAuthenticationInfo threeDSReqPriorRef(String threeDSReqPriorRef) {
        this.threeDSReqPriorRef = threeDSReqPriorRef;
        return this;
    }

    /**
     * This data element provides additional information to the ACS to determine the best approach for handing a request. This data element contains an ACS Transaction ID for a prior authenticated transaction. For example, the first recurring transaction that was authenticated with the cardholder. Length: 30 characters.
     * @return threeDSReqPriorRef
     **/
    @Schema(description = "This data element provides additional information to the ACS to determine the best approach for handing a request. This data element contains an ACS Transaction ID for a prior authenticated transaction. For example, the first recurring transaction that was authenticated with the cardholder. Length: 30 characters.")
    public String getThreeDSReqPriorRef() {
        return threeDSReqPriorRef;
    }

    public void setThreeDSReqPriorRef(String threeDSReqPriorRef) {
        this.threeDSReqPriorRef = threeDSReqPriorRef;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ThreeDSRequestorPriorAuthenticationInfo threeDSRequestorPriorAuthenticationInfo = (ThreeDSRequestorPriorAuthenticationInfo) o;
        return Objects.equals(this.threeDSReqPriorAuthData, threeDSRequestorPriorAuthenticationInfo.threeDSReqPriorAuthData) &&
                Objects.equals(this.threeDSReqPriorAuthMethod, threeDSRequestorPriorAuthenticationInfo.threeDSReqPriorAuthMethod) &&
                Objects.equals(this.threeDSReqPriorAuthTimestamp, threeDSRequestorPriorAuthenticationInfo.threeDSReqPriorAuthTimestamp) &&
                Objects.equals(this.threeDSReqPriorRef, threeDSRequestorPriorAuthenticationInfo.threeDSReqPriorRef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(threeDSReqPriorAuthData, threeDSReqPriorAuthMethod, threeDSReqPriorAuthTimestamp, threeDSReqPriorRef);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ThreeDSRequestorPriorAuthenticationInfo {\n");

        sb.append("    threeDSReqPriorAuthData: ").append(toIndentedString(threeDSReqPriorAuthData)).append("\n");
        sb.append("    threeDSReqPriorAuthMethod: ").append(toIndentedString(threeDSReqPriorAuthMethod)).append("\n");
        sb.append("    threeDSReqPriorAuthTimestamp: ").append(toIndentedString(threeDSReqPriorAuthTimestamp)).append("\n");
        sb.append("    threeDSReqPriorRef: ").append(toIndentedString(threeDSReqPriorRef)).append("\n");
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

