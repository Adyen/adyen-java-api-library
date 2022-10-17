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
package com.adyen.model;

import com.adyen.serializer.ByteArrayToStringAdapter;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/**
 * ThreeDSecureData
 */
public class ThreeDSecureData {
    /**
     * In 3D Secure 1, the authentication response if the shopper was redirected.  In 3D Secure 2, this is the &#x60;transStatus&#x60; from the challenge result. If the transaction was frictionless, omit this parameter.
     */
    @JsonAdapter(AuthenticationResponseEnum.Adapter.class)
    public enum AuthenticationResponseEnum {
        Y("Y"),
        N("N"),
        U("U"),
        A("A");

        @JsonValue
        private final String value;

        AuthenticationResponseEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static AuthenticationResponseEnum fromValue(String input) {
            for (AuthenticationResponseEnum b : AuthenticationResponseEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<AuthenticationResponseEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final AuthenticationResponseEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public AuthenticationResponseEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return AuthenticationResponseEnum.fromValue((String) (value));
            }
        }
    }  @SerializedName("authenticationResponse")
    private AuthenticationResponseEnum authenticationResponse = null;

    @SerializedName("cavv")
    @JsonAdapter(ByteArrayToStringAdapter.class)
    private byte[] cavv = null;

    @SerializedName("cavvAlgorithm")
    private String cavvAlgorithm = null;

    /**
     * Indicator informing the Access Control Server (ACS) and the Directory Server (DS) that the authentication has been cancelled. For possible values, refer to [3D Secure API reference](https://docs.adyen.com/online-payments/3d-secure/api-reference#mpidata).
     */
    @JsonAdapter(ChallengeCancelEnum.Adapter.class)
    public enum ChallengeCancelEnum {
        _01("01"),
        _02("02"),
        _03("03"),
        _04("04"),
        _05("05"),
        _06("06"),
        _07("07");

        @JsonValue
        private final String value;

        ChallengeCancelEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static ChallengeCancelEnum fromValue(String input) {
            for (ChallengeCancelEnum b : ChallengeCancelEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<ChallengeCancelEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ChallengeCancelEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public ChallengeCancelEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return ChallengeCancelEnum.fromValue((String) (value));
            }
        }
    }  @SerializedName("challengeCancel")
    private ChallengeCancelEnum challengeCancel = null;

    /**
     * In 3D Secure 1, this is the enrollment response from the 3D directory server.  In 3D Secure 2, this is the &#x60;transStatus&#x60; from the &#x60;ARes&#x60;.
     */
    @JsonAdapter(DirectoryResponseEnum.Adapter.class)
    public enum DirectoryResponseEnum {
        A("A"),
        C("C"),
        D("D"),
        I("I"),
        N("N"),
        R("R"),
        U("U"),
        Y("Y");

        @JsonValue
        private final String value;

        DirectoryResponseEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static DirectoryResponseEnum fromValue(String input) {
            for (DirectoryResponseEnum b : DirectoryResponseEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<DirectoryResponseEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final DirectoryResponseEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public DirectoryResponseEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return DirectoryResponseEnum.fromValue((String) (value));
            }
        }
    }  @SerializedName("directoryResponse")
    private DirectoryResponseEnum directoryResponse = null;

    @SerializedName("dsTransID")
    private String dsTransID = null;

    @SerializedName("eci")
    private String eci = null;

    @SerializedName("riskScore")
    private String riskScore = null;

    @SerializedName("threeDSVersion")
    private String threeDSVersion = null;

    @SerializedName("tokenAuthenticationVerificationValue")
    private byte[] tokenAuthenticationVerificationValue = null;

    @SerializedName("transStatusReason")
    private String transStatusReason = null;

    @SerializedName("xid")
    private byte[] xid = null;

    public ThreeDSecureData authenticationResponse(AuthenticationResponseEnum authenticationResponse) {
        this.authenticationResponse = authenticationResponse;
        return this;
    }

    /**
     * In 3D Secure 1, the authentication response if the shopper was redirected.  In 3D Secure 2, this is the &#x60;transStatus&#x60; from the challenge result. If the transaction was frictionless, omit this parameter.
     * @return authenticationResponse
     **/
    @Schema(description = "In 3D Secure 1, the authentication response if the shopper was redirected.  In 3D Secure 2, this is the `transStatus` from the challenge result. If the transaction was frictionless, omit this parameter.")
    public AuthenticationResponseEnum getAuthenticationResponse() {
        return authenticationResponse;
    }

    public void setAuthenticationResponse(AuthenticationResponseEnum authenticationResponse) {
        this.authenticationResponse = authenticationResponse;
    }

    public ThreeDSecureData cavv(byte[] cavv) {
        this.cavv = cavv;
        return this;
    }

    /**
     * The cardholder authentication value (base64 encoded, 20 bytes in a decoded form).
     * @return cavv
     **/
    @Schema(description = "The cardholder authentication value (base64 encoded, 20 bytes in a decoded form).")
    public byte[] getCavv() {
        return cavv;
    }

    public void setCavv(byte[] cavv) {
        this.cavv = cavv;
    }

    public ThreeDSecureData cavvAlgorithm(String cavvAlgorithm) {
        this.cavvAlgorithm = cavvAlgorithm;
        return this;
    }

    /**
     * The CAVV algorithm used. Include this only for 3D Secure 1.
     * @return cavvAlgorithm
     **/
    @Schema(description = "The CAVV algorithm used. Include this only for 3D Secure 1.")
    public String getCavvAlgorithm() {
        return cavvAlgorithm;
    }

    public void setCavvAlgorithm(String cavvAlgorithm) {
        this.cavvAlgorithm = cavvAlgorithm;
    }

    public ThreeDSecureData challengeCancel(ChallengeCancelEnum challengeCancel) {
        this.challengeCancel = challengeCancel;
        return this;
    }

    /**
     * Indicator informing the Access Control Server (ACS) and the Directory Server (DS) that the authentication has been cancelled. For possible values, refer to [3D Secure API reference](https://docs.adyen.com/online-payments/3d-secure/api-reference#mpidata).
     * @return challengeCancel
     **/
    @Schema(description = "Indicator informing the Access Control Server (ACS) and the Directory Server (DS) that the authentication has been cancelled. For possible values, refer to [3D Secure API reference](https://docs.adyen.com/online-payments/3d-secure/api-reference#mpidata).")
    public ChallengeCancelEnum getChallengeCancel() {
        return challengeCancel;
    }

    public void setChallengeCancel(ChallengeCancelEnum challengeCancel) {
        this.challengeCancel = challengeCancel;
    }

    public ThreeDSecureData directoryResponse(DirectoryResponseEnum directoryResponse) {
        this.directoryResponse = directoryResponse;
        return this;
    }

    /**
     * In 3D Secure 1, this is the enrollment response from the 3D directory server.  In 3D Secure 2, this is the &#x60;transStatus&#x60; from the &#x60;ARes&#x60;.
     * @return directoryResponse
     **/
    @Schema(description = "In 3D Secure 1, this is the enrollment response from the 3D directory server.  In 3D Secure 2, this is the `transStatus` from the `ARes`.")
    public DirectoryResponseEnum getDirectoryResponse() {
        return directoryResponse;
    }

    public void setDirectoryResponse(DirectoryResponseEnum directoryResponse) {
        this.directoryResponse = directoryResponse;
    }

    public ThreeDSecureData dsTransID(String dsTransID) {
        this.dsTransID = dsTransID;
        return this;
    }

    /**
     * Supported for 3D Secure 2. The unique transaction identifier assigned by the Directory Server (DS) to identify a single transaction.
     * @return dsTransID
     **/
    @Schema(description = "Supported for 3D Secure 2. The unique transaction identifier assigned by the Directory Server (DS) to identify a single transaction.")
    public String getDsTransID() {
        return dsTransID;
    }

    public void setDsTransID(String dsTransID) {
        this.dsTransID = dsTransID;
    }

    public ThreeDSecureData eci(String eci) {
        this.eci = eci;
        return this;
    }

    /**
     * The electronic commerce indicator.
     * @return eci
     **/
    @Schema(description = "The electronic commerce indicator.")
    public String getEci() {
        return eci;
    }

    public void setEci(String eci) {
        this.eci = eci;
    }

    public ThreeDSecureData riskScore(String riskScore) {
        this.riskScore = riskScore;
        return this;
    }

    /**
     * Risk score calculated by Directory Server (DS). Required for Cartes Bancaires integrations.
     * @return riskScore
     **/
    @Schema(description = "Risk score calculated by Directory Server (DS). Required for Cartes Bancaires integrations.")
    public String getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(String riskScore) {
        this.riskScore = riskScore;
    }

    public ThreeDSecureData threeDSVersion(String threeDSVersion) {
        this.threeDSVersion = threeDSVersion;
        return this;
    }

    /**
     * The version of the 3D Secure protocol.
     * @return threeDSVersion
     **/
    @Schema(description = "The version of the 3D Secure protocol.")
    public String getThreeDSVersion() {
        return threeDSVersion;
    }

    public void setThreeDSVersion(String threeDSVersion) {
        this.threeDSVersion = threeDSVersion;
    }

    public ThreeDSecureData tokenAuthenticationVerificationValue(byte[] tokenAuthenticationVerificationValue) {
        this.tokenAuthenticationVerificationValue = tokenAuthenticationVerificationValue;
        return this;
    }

    /**
     * Network token authentication verification value (TAVV). The network token cryptogram.
     * @return tokenAuthenticationVerificationValue
     **/
    @Schema(description = "Network token authentication verification value (TAVV). The network token cryptogram.")
    public byte[] getTokenAuthenticationVerificationValue() {
        return tokenAuthenticationVerificationValue;
    }

    public void setTokenAuthenticationVerificationValue(byte[] tokenAuthenticationVerificationValue) {
        this.tokenAuthenticationVerificationValue = tokenAuthenticationVerificationValue;
    }

    public ThreeDSecureData transStatusReason(String transStatusReason) {
        this.transStatusReason = transStatusReason;
        return this;
    }

    /**
     * Provides information on why the &#x60;transStatus&#x60; field has the specified value. For possible values, refer to [our docs](https://docs.adyen.com/online-payments/3d-secure/api-reference#possible-transstatusreason-values).
     * @return transStatusReason
     **/
    @Schema(description = "Provides information on why the `transStatus` field has the specified value. For possible values, refer to [our docs](https://docs.adyen.com/online-payments/3d-secure/api-reference#possible-transstatusreason-values).")
    public String getTransStatusReason() {
        return transStatusReason;
    }

    public void setTransStatusReason(String transStatusReason) {
        this.transStatusReason = transStatusReason;
    }

    public ThreeDSecureData xid(byte[] xid) {
        this.xid = xid;
        return this;
    }

    /**
     * Supported for 3D Secure 1. The transaction identifier (Base64-encoded, 20 bytes in a decoded form).
     * @return xid
     **/
    @Schema(description = "Supported for 3D Secure 1. The transaction identifier (Base64-encoded, 20 bytes in a decoded form).")
    public byte[] getXid() {
        return xid;
    }

    public void setXid(byte[] xid) {
        this.xid = xid;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ThreeDSecureData threeDSecureData = (ThreeDSecureData) o;
        return Objects.equals(this.authenticationResponse, threeDSecureData.authenticationResponse) &&
                Arrays.equals(this.cavv, threeDSecureData.cavv) &&
                Objects.equals(this.cavvAlgorithm, threeDSecureData.cavvAlgorithm) &&
                Objects.equals(this.challengeCancel, threeDSecureData.challengeCancel) &&
                Objects.equals(this.directoryResponse, threeDSecureData.directoryResponse) &&
                Objects.equals(this.dsTransID, threeDSecureData.dsTransID) &&
                Objects.equals(this.eci, threeDSecureData.eci) &&
                Objects.equals(this.riskScore, threeDSecureData.riskScore) &&
                Objects.equals(this.threeDSVersion, threeDSecureData.threeDSVersion) &&
                Arrays.equals(this.tokenAuthenticationVerificationValue, threeDSecureData.tokenAuthenticationVerificationValue) &&
                Objects.equals(this.transStatusReason, threeDSecureData.transStatusReason) &&
                Arrays.equals(this.xid, threeDSecureData.xid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authenticationResponse, Arrays.hashCode(cavv), cavvAlgorithm, challengeCancel, directoryResponse, dsTransID, eci, riskScore, threeDSVersion, Arrays.hashCode(tokenAuthenticationVerificationValue), transStatusReason, Arrays.hashCode(xid));
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ThreeDSecureData {\n");

        sb.append("    authenticationResponse: ").append(toIndentedString(authenticationResponse)).append("\n");
        sb.append("    cavv: ").append(toIndentedString(cavv)).append("\n");
        sb.append("    cavvAlgorithm: ").append(toIndentedString(cavvAlgorithm)).append("\n");
        sb.append("    challengeCancel: ").append(toIndentedString(challengeCancel)).append("\n");
        sb.append("    directoryResponse: ").append(toIndentedString(directoryResponse)).append("\n");
        sb.append("    dsTransID: ").append(toIndentedString(dsTransID)).append("\n");
        sb.append("    eci: ").append(toIndentedString(eci)).append("\n");
        sb.append("    riskScore: ").append(toIndentedString(riskScore)).append("\n");
        sb.append("    threeDSVersion: ").append(toIndentedString(threeDSVersion)).append("\n");
        sb.append("    tokenAuthenticationVerificationValue: ").append(toIndentedString(tokenAuthenticationVerificationValue)).append("\n");
        sb.append("    transStatusReason: ").append(toIndentedString(transStatusReason)).append("\n");
        sb.append("    xid: ").append(toIndentedString(xid)).append("\n");
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
