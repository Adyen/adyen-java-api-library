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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * ThreeDS2Result
 */
public class ThreeDS2Result {
    @SerializedName("authenticationValue")
    private String authenticationValue = null;

    @SerializedName("cavvAlgorithm")
    private String cavvAlgorithm = null;

    @SerializedName("dsTransID")
    private String dsTransID = null;

    @SerializedName("eci")
    private String eci = null;

    @SerializedName("messageVersion")
    private String messageVersion = null;

    @SerializedName("threeDSServerTransID")
    private String threeDSServerTransID = null;

    @SerializedName("timestamp")
    private String timestamp = null;

    @SerializedName("transStatus")
    private String transStatus = null;

    @SerializedName("transStatusReason")
    private String transStatusReason = null;

    @SerializedName("whiteListStatus")
    private String whiteListStatus = null;

    @SerializedName("challengeCancel")
    private String challengeCancel;

    @SerializedName("challengeIndicator")
    private String challengeIndicator;

    @SerializedName("exemptionIndicator")
    private String exemptionIndicator;

    @SerializedName("riskScore")
    private String riskScore;

    public ThreeDS2Result authenticationValue(String authenticationValue) {
        this.authenticationValue = authenticationValue;
        return this;
    }

    /**
     * The &#x60;authenticationValue&#x60; value as defined in the 3D Secure 2 specification.
     * @return authenticationValue
     **/
    public String getAuthenticationValue() {
        return authenticationValue;
    }

    public void setAuthenticationValue(String authenticationValue) {
        this.authenticationValue = authenticationValue;
    }

    public ThreeDS2Result cavvAlgorithm(String cavvAlgorithm) {
        this.cavvAlgorithm = cavvAlgorithm;
        return this;
    }

    /**
     * The algorithm used by the ACS to calculate the authentication value, only for CartesBancaires integrations.
     * @return cavvAlgorithm
     **/
    public String getCavvAlgorithm() {
        return cavvAlgorithm;
    }

    public void setCavvAlgorithm(String cavvAlgorithm) {
        this.cavvAlgorithm = cavvAlgorithm;
    }

    public ThreeDS2Result dsTransID(String dsTransID) {
        this.dsTransID = dsTransID;
        return this;
    }

    /**
     * The &#x60;dsTransID&#x60; value as defined in the 3D Secure 2 specification.
     * @return dsTransID
     **/
    public String getDsTransID() {
        return dsTransID;
    }

    public void setDsTransID(String dsTransID) {
        this.dsTransID = dsTransID;
    }

    public ThreeDS2Result eci(String eci) {
        this.eci = eci;
        return this;
    }

    /**
     * The &#x60;eci&#x60; value as defined in the 3D Secure 2 specification.
     * @return eci
     **/
    public String getEci() {
        return eci;
    }

    public void setEci(String eci) {
        this.eci = eci;
    }

    public ThreeDS2Result messageVersion(String messageVersion) {
        this.messageVersion = messageVersion;
        return this;
    }

    /**
     * The &#x60;messageVersion&#x60; value as defined in the 3D Secure 2 specification.
     * @return messageVersion
     **/
    public String getMessageVersion() {
        return messageVersion;
    }

    public void setMessageVersion(String messageVersion) {
        this.messageVersion = messageVersion;
    }

    public ThreeDS2Result threeDSServerTransID(String threeDSServerTransID) {
        this.threeDSServerTransID = threeDSServerTransID;
        return this;
    }

    /**
     * The &#x60;threeDSServerTransID&#x60; value as defined in the 3D Secure 2 specification.
     * @return threeDSServerTransID
     **/
    public String getThreeDSServerTransID() {
        return threeDSServerTransID;
    }

    public void setThreeDSServerTransID(String threeDSServerTransID) {
        this.threeDSServerTransID = threeDSServerTransID;
    }

    public ThreeDS2Result timestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * The &#x60;timestamp&#x60; value of the 3D Secure 2 authentication.
     * @return timestamp
     **/
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public ThreeDS2Result transStatus(String transStatus) {
        this.transStatus = transStatus;
        return this;
    }

    /**
     * The &#x60;transStatus&#x60; value as defined in the 3D Secure 2 specification.
     * @return transStatus
     **/
    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }

    public ThreeDS2Result transStatusReason(String transStatusReason) {
        this.transStatusReason = transStatusReason;
        return this;
    }

    /**
     * The &#x60;transStatusReason&#x60; value as defined in the 3D Secure 2 specification.
     * @return transStatusReason
     **/
    public String getTransStatusReason() {
        return transStatusReason;
    }

    public void setTransStatusReason(String transStatusReason) {
        this.transStatusReason = transStatusReason;
    }

    public ThreeDS2Result whiteListStatus(String whiteListStatus) {
        this.whiteListStatus = whiteListStatus;
        return this;
    }

    /**
     * The &#x60;whiteListStatus&#x60; value as defined in the 3D Secure 2 specification.
     * @return whiteListStatus
     **/
    public String getWhiteListStatus() {
        return whiteListStatus;
    }

    public void setWhiteListStatus(String whiteListStatus) {
        this.whiteListStatus = whiteListStatus;
    }

    /**
     * Indicator informing the ACS and the DS that the authentication has been canceled
     *
     * @return challengeCancel
     */
    public String getChallengeCancel() { return challengeCancel; }

    public void setChallengeCancel(String challengeCancel) { this.challengeCancel = challengeCancel; }

    public ThreeDS2Result challengeCancel(String challengeCancel) {
        this.challengeCancel = challengeCancel;
        return this;
    }

    /**
     * Get challengeIndicator
     *
     * @return challenegeIndicator
     */
    public String getChallengeIndicator() { return challengeIndicator; }

    public void setChallengeIndicator(String challengeIndicator) { this.challengeIndicator = challengeIndicator; }

    public ThreeDS2Result challengeIndicator(String challengeIndicator) {
        this.challengeIndicator = challengeIndicator;
        return this;
    }

    /**
     * Get exemptionIndicator
     *
     * @return exemptionIndicator
     */
    public String getExemptionIndicator() { return exemptionIndicator; }

    public void setExemptionIndicator(String exemptionIndicator) { this.exemptionIndicator = exemptionIndicator; }

    public ThreeDS2Result exemptionIndicator(String exemptionIndicator) {
        this.exemptionIndicator = exemptionIndicator;
        return this;
    }

    /**
     * Get riskScore
     *
     * @return riskScore
     */
    public String getRiskScore() { return riskScore; }

    public void setRiskScore(String riskScore) { this.riskScore = riskScore; }

    public ThreeDS2Result riskScore(String riskScore) {
        this.riskScore = riskScore;
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
        ThreeDS2Result threeDS2Result = (ThreeDS2Result) o;
        return Objects.equals(this.authenticationValue, threeDS2Result.authenticationValue) &&
                Objects.equals(this.cavvAlgorithm, threeDS2Result.cavvAlgorithm) &&
                Objects.equals(this.dsTransID, threeDS2Result.dsTransID) &&
                Objects.equals(this.eci, threeDS2Result.eci) &&
                Objects.equals(this.messageVersion, threeDS2Result.messageVersion) &&
                Objects.equals(this.threeDSServerTransID, threeDS2Result.threeDSServerTransID) &&
                Objects.equals(this.timestamp, threeDS2Result.timestamp) &&
                Objects.equals(this.transStatus, threeDS2Result.transStatus) &&
                Objects.equals(this.transStatusReason, threeDS2Result.transStatusReason) &&
                Objects.equals(this.whiteListStatus, threeDS2Result.whiteListStatus) &&
                Objects.equals(this.challengeCancel, threeDS2Result.challengeCancel) &&
                Objects.equals(this.challengeIndicator, threeDS2Result.challengeIndicator) &&
                Objects.equals(this.exemptionIndicator, threeDS2Result.exemptionIndicator) &&
                Objects.equals(this.riskScore, threeDS2Result.riskScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authenticationValue, cavvAlgorithm, dsTransID, eci, messageVersion, threeDSServerTransID, timestamp, transStatus, transStatusReason, whiteListStatus, challengeCancel, challengeIndicator, exemptionIndicator, riskScore);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ThreeDS2Result {\n");

        sb.append("    authenticationValue: ").append(toIndentedString(authenticationValue)).append("\n");
        sb.append("    cavvAlgorithm: ").append(toIndentedString(cavvAlgorithm)).append("\n");
        sb.append("    dsTransID: ").append(toIndentedString(dsTransID)).append("\n");
        sb.append("    eci: ").append(toIndentedString(eci)).append("\n");
        sb.append("    messageVersion: ").append(toIndentedString(messageVersion)).append("\n");
        sb.append("    threeDSServerTransID: ").append(toIndentedString(threeDSServerTransID)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("    transStatus: ").append(toIndentedString(transStatus)).append("\n");
        sb.append("    transStatusReason: ").append(toIndentedString(transStatusReason)).append("\n");
        sb.append("    whiteListStatus: ").append(toIndentedString(whiteListStatus)).append("\n");
        sb.append("    challengeCancel: ").append(toIndentedString(challengeCancel)).append("\n");
        sb.append("    challengeIndicator: ").append(toIndentedString(challengeIndicator)).append("\n");
        sb.append("    exemptionIndicator: ").append(toIndentedString(exemptionIndicator)).append("\n");
        sb.append("    riskScore: ").append(toIndentedString(riskScore)).append("\n");
        sb.append("}");
        return sb.toString();
    }



}
