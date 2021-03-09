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

import com.google.gson.annotations.SerializedName;

import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * ThreeDSecureData
 */
public class ThreeDSecureData {
    @SerializedName("cavvAlgorithm")
    private String cavvAlgorithm = null;

    @SerializedName("threeDSVersion")
    private String threeDSVersion = null;

    /**
     * the enrollment response from the 3D directory server
     */
    public enum DirectoryResponseEnum {
        @SerializedName("Y")
        Y("Y"),

        @SerializedName("U")
        U("U"),

        @SerializedName("N")
        N("N"),

        @SerializedName("A")
        A("A"),

        @SerializedName("C")
        C("C"),

        @SerializedName("D")
        D("D"),

        @SerializedName("R")
        R("R"),

        @SerializedName("I")
        I("I"),

        @SerializedName("E")
        E("E");

        private String value;

        DirectoryResponseEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("directoryResponse")
    private DirectoryResponseEnum directoryResponse = null;

    /**
     * the authentication response if the shopper was redirected
     */
    public enum AuthenticationResponseEnum {
        @SerializedName("Y")
        Y("Y"),

        @SerializedName("N")
        N("N"),

        @SerializedName("U")
        U("U"),

        @SerializedName("A")
        A("A");

        private String value;

        AuthenticationResponseEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("authenticationResponse")
    private AuthenticationResponseEnum authenticationResponse = null;

    @SerializedName("xid")
    private String xid = null;

    @SerializedName("cavv")
    private String cavv = null;

    @SerializedName("eci")
    private String eci = null;

    @SerializedName("dsTransID")
    private String dsTransID = null;

    @SerializedName("challengeCancel")
    private String challengeCancel = null;

    @SerializedName("riskScore")
    private String riskScore = null;

    @SerializedName("transStatusReason")
    private String transStatusReason = null;

    public ThreeDSecureData cavvAlgorithm(String cavvAlgorithm) {
        this.cavvAlgorithm = cavvAlgorithm;
        return this;
    }

    /**
     * the CAVV algorithm used
     *
     * @return cavvAlgorithm
     **/
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

    /**
     * the enrollment response from the 3D directory server
     *
     * @return directoryResponse
     **/
    public DirectoryResponseEnum getDirectoryResponse() {
        return directoryResponse;
    }

    public void setDirectoryResponse(DirectoryResponseEnum directoryResponse) {
        this.directoryResponse = directoryResponse;
    }

    public ThreeDSecureData authenticationResponse(AuthenticationResponseEnum authenticationResponse) {
        this.authenticationResponse = authenticationResponse;
        return this;
    }

    public String getThreeDSVersion() {
        return threeDSVersion;
    }

    public void setThreeDSVersion(String threeDSVersion) {
        this.threeDSVersion = threeDSVersion;
    }

    /**
     * the authentication response if the shopper was redirected
     *
     * @return authenticationResponse
     **/
    public AuthenticationResponseEnum getAuthenticationResponse() {
        return authenticationResponse;
    }

    public void setAuthenticationResponse(AuthenticationResponseEnum authenticationResponse) {
        this.authenticationResponse = authenticationResponse;
    }

    public ThreeDSecureData xid(String xid) {
        this.xid = xid;
        return this;
    }

    /**
     * the transaction identifier (base64 encoded, 20 bytes in decoded form)
     *
     * @return xid
     **/
    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public ThreeDSecureData cavv(String cavv) {
        this.cavv = cavv;
        return this;
    }

    /**
     * the cardholder authentication value (base64 encoded, 20 bytes in decoded form)
     *
     * @return cavv
     **/
    public String getCavv() {
        return cavv;
    }

    public void setCavv(String cavv) {
        this.cavv = cavv;
    }

    public ThreeDSecureData eci(String eci) {
        this.eci = eci;
        return this;
    }

    /**
     * the electronic commerce indicator
     *
     * @return eci
     **/
    public String getEci() {
        return eci;
    }

    public void setEci(String eci) {
        this.eci = eci;
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

    /**
     * Get challengeCancel
     *
     * @return challengeCancel
     */
    public String getChallengeCancel() { return challengeCancel; }

    public void setChallengeCancel(String challengeCancel) { this.challengeCancel = challengeCancel; }

    public ThreeDSecureData challengeCancel(String challengeCancel) {
        this.challengeCancel = challengeCancel;
        return this;
    }

    /**
     * Get riskScore
     *
     * @return riskScore
     */
    public String getRiskScore() { return riskScore; }

    public void setRiskScore(String riskScore) { this.riskScore = riskScore; }

    public ThreeDSecureData riskScore(String riskScore) {
        this.riskScore = riskScore;
        return this;
    }

    /**
     * Get transStatusReason
     * @return transStatusReason
     **/
    public String getTransStatusReason() {
        return transStatusReason;
    }

    public void setTransStatusReason(String transStatusReason) {
        this.transStatusReason = transStatusReason;
    }

    public ThreeDSecureData transStatusReason(String transStatusReason) {
        this.transStatusReason = transStatusReason;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ThreeDSecureData threeDSecureData = (ThreeDSecureData) o;
        return Objects.equals(this.cavvAlgorithm, threeDSecureData.cavvAlgorithm)
                && Objects.equals(this.directoryResponse, threeDSecureData.directoryResponse)
                && Objects.equals(this.authenticationResponse, threeDSecureData.authenticationResponse)
                && Objects.equals(this.xid, threeDSecureData.xid)
                && Objects.equals(this.cavv, threeDSecureData.cavv)
                && Objects.equals(this.eci, threeDSecureData.eci)
                && Objects.equals(this.dsTransID, threeDSecureData.dsTransID)
                && Objects.equals(this.challengeCancel, threeDSecureData.challengeCancel)
                && Objects.equals(this.riskScore, threeDSecureData.riskScore)
                && Objects.equals(this.transStatusReason, threeDSecureData.transStatusReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cavvAlgorithm, directoryResponse, authenticationResponse, xid, cavv, eci, dsTransID, challengeCancel, riskScore, transStatusReason);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ThreeDSecureData {\n");

        sb.append("    cavvAlgorithm: ").append(toIndentedString(cavvAlgorithm)).append("\n");
        sb.append("    directoryResponse: ").append(toIndentedString(directoryResponse)).append("\n");
        sb.append("    authenticationResponse: ").append(toIndentedString(authenticationResponse)).append("\n");
        sb.append("    xid: ").append(toIndentedString(xid)).append("\n");
        sb.append("    cavv: ").append(toIndentedString(cavv)).append("\n");
        sb.append("    eci: ").append(toIndentedString(eci)).append("\n");
        sb.append("    dsTransID: ").append(toIndentedString(dsTransID)).append("\n");
        sb.append("    challengeCancel").append(toIndentedString(challengeCancel)).append("\n");
        sb.append("    riskScore").append(toIndentedString(riskScore)).append("\n");
        sb.append("    transStatusReason").append(toIndentedString(transStatusReason)).append("\n");
        sb.append("}");
        return sb.toString();
    }



}

