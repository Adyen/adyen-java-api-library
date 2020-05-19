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

import com.adyen.serializer.ByteArrayToStringAdapter;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/**
 * ThreeDSecureData
 */
public class ThreeDSecureData {

    @SerializedName("authenticationResponse")
    private AuthenticationResponseEnum authenticationResponse = null;
    @SerializedName("cavv")
    @JsonAdapter(ByteArrayToStringAdapter.class)
    private byte[] cavv = null;
    @SerializedName("cavvAlgorithm")
    private String cavvAlgorithm = null;
    @SerializedName("directoryResponse")
    private DirectoryResponseEnum directoryResponse = null;
    @SerializedName("eci")
    private String eci = null;
    @SerializedName("threeDSVersion")
    private String threeDSVersion = null;
    @SerializedName("xid")
    @JsonAdapter(ByteArrayToStringAdapter.class)
    private byte[] xid = null;
    @SerializedName("dsTransID")
    private String dsTransID = null;

    public ThreeDSecureData authenticationResponse(AuthenticationResponseEnum authenticationResponse) {
        this.authenticationResponse = authenticationResponse;
        return this;
    }

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

    public String getCavvAlgorithm() {
        return cavvAlgorithm;
    }

    public void setCavvAlgorithm(String cavvAlgorithm) {
        this.cavvAlgorithm = cavvAlgorithm;
    }

    public ThreeDSecureData directoryResponse(DirectoryResponseEnum directoryResponse) {
        this.directoryResponse = directoryResponse;
        return this;
    }

    public DirectoryResponseEnum getDirectoryResponse() {
        return directoryResponse;
    }

    public void setDirectoryResponse(DirectoryResponseEnum directoryResponse) {
        this.directoryResponse = directoryResponse;
    }

    public ThreeDSecureData eci(String eci) {
        this.eci = eci;
        return this;
    }

    public String getEci() {
        return eci;
    }

    public void setEci(String eci) {
        this.eci = eci;
    }

    public ThreeDSecureData threeDSVersion(String threeDSVersion) {
        this.threeDSVersion = threeDSVersion;
        return this;
    }

    public String getThreeDSVersion() {
        return threeDSVersion;
    }

    public void setThreeDSVersion(String threeDSVersion) {
        this.threeDSVersion = threeDSVersion;
    }

    public ThreeDSecureData xid(byte[] xid) {
        this.xid = xid;
        return this;
    }

    public byte[] getXid() {
        return xid;
    }

    public void setXid(byte[] xid) {
        this.xid = xid;
    }

    /**
     * Supported for 3D Secure 2. The unique transaction identifier assigned by the Directory Server (DS) to identify a single transaction.
     *
     * @return dsTransID
     */
    public String getDsTransID() {
        return dsTransID;
    }

    public void setDsTransID(String dsTransID) {
        this.dsTransID = dsTransID;
    }

    public ThreeDSecureData dsTransID(String dsTransID) {
        this.dsTransID = dsTransID;
        return this;
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
        return Objects.equals(this.authenticationResponse, threeDSecureData.authenticationResponse)
                && Arrays.equals(this.cavv, threeDSecureData.cavv)
                && Objects.equals(this.cavvAlgorithm,
                threeDSecureData.cavvAlgorithm)
                && Objects.equals(this.directoryResponse, threeDSecureData.directoryResponse)
                && Objects.equals(this.eci, threeDSecureData.eci)
                && Objects.equals(this.threeDSVersion, threeDSecureData.threeDSVersion)
                && Arrays.equals(this.xid, threeDSecureData.xid)
                && Objects.equals(this.dsTransID, threeDSecureData.dsTransID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authenticationResponse, cavv, cavvAlgorithm, directoryResponse, eci, threeDSVersion, xid, dsTransID);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ThreeDSecureData {\n");

        sb.append("    authenticationResponse: ").append(toIndentedString(authenticationResponse)).append("\n");
        sb.append("    cavv: ").append(toIndentedString(cavv)).append("\n");
        sb.append("    cavvAlgorithm: ").append(toIndentedString(cavvAlgorithm)).append("\n");
        sb.append("    directoryResponse: ").append(toIndentedString(directoryResponse)).append("\n");
        sb.append("    eci: ").append(toIndentedString(eci)).append("\n");
        sb.append("    threeDSVersion: ").append(toIndentedString(threeDSVersion)).append("\n");
        sb.append("    xid: ").append(toIndentedString(xid)).append("\n");
        sb.append("    dsTransID: ").append(toIndentedString(dsTransID)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    /**
     * The authentication response if the shopper was redirected.
     */
    @JsonAdapter(AuthenticationResponseEnum.Adapter.class)
    public enum AuthenticationResponseEnum {

        Y("Y"),
        N("N"),
        U("U"),
        A("A");

        private String value;

        AuthenticationResponseEnum(String value) {
            this.value = value;
        }

        public static AuthenticationResponseEnum fromValue(String text) {
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

        public static class Adapter extends TypeAdapter<AuthenticationResponseEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final AuthenticationResponseEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public AuthenticationResponseEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return AuthenticationResponseEnum.fromValue(String.valueOf(value));
            }
        }
    }

    /**
     * In 3D Secure 1, this is the enrollment response from the 3D directory server.
     * In 3D Secure 2, this is the `transStatus` from the `ARes`.
     * The possible values are **A** or **Y** for a frictionless flow, or **C** for a challenge flow."
     */
    @JsonAdapter(DirectoryResponseEnum.Adapter.class)
    public enum DirectoryResponseEnum {

        Y("Y"),
        U("U"),
        N("N"),
        A("A"),
        C("C"),
        D("D"),
        R("R"),
        I("I"),
        E("E");

        private String value;

        DirectoryResponseEnum(String value) {
            this.value = value;
        }

        public static DirectoryResponseEnum fromValue(String text) {
            return Arrays.stream(DirectoryResponseEnum .values()).
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

        public static class Adapter extends TypeAdapter<DirectoryResponseEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final DirectoryResponseEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public DirectoryResponseEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return DirectoryResponseEnum.fromValue(String.valueOf(value));
            }
        }
    }


}



