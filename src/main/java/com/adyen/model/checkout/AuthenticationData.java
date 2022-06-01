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
 *
 */

package com.adyen.model.checkout;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import com.adyen.model.ThreeDSRequestData;

import java.io.IOException;
import java.util.Objects;

public class AuthenticationData {
    /**
     * Indicates when 3D Secure authentication should be attempted. This overrides all other rules, including [Dynamic 3D Secure settings](https://docs.adyen.com/risk-management/dynamic-3d-secure).  Possible values:  * **always**: Perform 3D Secure authentication. * **never**: Don&#x27;t perform 3D Secure authentication. If PSD2 SCA or other national regulations require authentication, the transaction gets declined. * **preferNo**: Do not perform 3D Secure authentication if not required by PSD2 SCA or other national regulations.
     */
    @JsonAdapter(AttemptAuthenticationEnum.Adapter.class)
    public enum AttemptAuthenticationEnum {
        ALWAYS("always"),
        NEVER("never"),
        PREFERNO("preferNo");

        @JsonValue
        private final String value;

        AttemptAuthenticationEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static AttemptAuthenticationEnum fromValue(String input) {
            for (AttemptAuthenticationEnum b : AttemptAuthenticationEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<AttemptAuthenticationEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final AttemptAuthenticationEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public AttemptAuthenticationEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return AttemptAuthenticationEnum.fromValue((String) (value));
            }
        }
    }  @SerializedName("attemptAuthentication")
    private AttemptAuthenticationEnum attemptAuthentication = null;

    @SerializedName("authenticationOnly")
    private Boolean authenticationOnly = false;

    @SerializedName("threeDSRequestData")
    private ThreeDSRequestData threeDSRequestData = null;

    public AuthenticationData attemptAuthentication(AttemptAuthenticationEnum attemptAuthentication) {
        this.attemptAuthentication = attemptAuthentication;
        return this;
    }

    /**
     * Indicates when 3D Secure authentication should be attempted. This overrides all other rules, including [Dynamic 3D Secure settings](https://docs.adyen.com/risk-management/dynamic-3d-secure).  Possible values:  * **always**: Perform 3D Secure authentication. * **never**: Don&#x27;t perform 3D Secure authentication. If PSD2 SCA or other national regulations require authentication, the transaction gets declined. * **preferNo**: Do not perform 3D Secure authentication if not required by PSD2 SCA or other national regulations.
     * @return attemptAuthentication
     **/
    @Schema(description = "Indicates when 3D Secure authentication should be attempted. This overrides all other rules, including [Dynamic 3D Secure settings](https://docs.adyen.com/risk-management/dynamic-3d-secure).  Possible values:  * **always**: Perform 3D Secure authentication. * **never**: Don't perform 3D Secure authentication. If PSD2 SCA or other national regulations require authentication, the transaction gets declined. * **preferNo**: Do not perform 3D Secure authentication if not required by PSD2 SCA or other national regulations.")
    public AttemptAuthenticationEnum getAttemptAuthentication() {
        return attemptAuthentication;
    }

    public void setAttemptAuthentication(AttemptAuthenticationEnum attemptAuthentication) {
        this.attemptAuthentication = attemptAuthentication;
    }

    public AuthenticationData authenticationOnly(Boolean authenticationOnly) {
        this.authenticationOnly = authenticationOnly;
        return this;
    }

    /**
     * If set to true, you will only perform the [3D Secure 2 authentication](https://docs.adyen.com/online-payments/3d-secure/other-3ds-flows/authentication-only), and not the payment authorisation. Default: *false**.
     * @return authenticationOnly
     **/
    @Schema(description = "If set to true, you will only perform the [3D Secure 2 authentication](https://docs.adyen.com/online-payments/3d-secure/other-3ds-flows/authentication-only), and not the payment authorisation. Default: *false**.")
    public Boolean isAuthenticationOnly() {
        return authenticationOnly;
    }

    public void setAuthenticationOnly(Boolean authenticationOnly) {
        this.authenticationOnly = authenticationOnly;
    }

    public AuthenticationData threeDSRequestData(ThreeDSRequestData threeDSRequestData) {
        this.threeDSRequestData = threeDSRequestData;
        return this;
    }

    /**
     * Get threeDSRequestData
     * @return threeDSRequestData
     **/
    @Schema(description = "")
    public ThreeDSRequestData getThreeDSRequestData() {
        return threeDSRequestData;
    }

    public void setThreeDSRequestData(ThreeDSRequestData threeDSRequestData) {
        this.threeDSRequestData = threeDSRequestData;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AuthenticationData authenticationData = (AuthenticationData) o;
        return Objects.equals(this.attemptAuthentication, authenticationData.attemptAuthentication) &&
                Objects.equals(this.authenticationOnly, authenticationData.authenticationOnly) &&
                Objects.equals(this.threeDSRequestData, authenticationData.threeDSRequestData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attemptAuthentication, authenticationOnly, threeDSRequestData);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AuthenticationData {\n");

        sb.append("    attemptAuthentication: ").append(toIndentedString(attemptAuthentication)).append("\n");
        sb.append("    authenticationOnly: ").append(toIndentedString(authenticationOnly)).append("\n");
        sb.append("    threeDSRequestData: ").append(toIndentedString(threeDSRequestData)).append("\n");
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
