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

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

public class ThreeDS2ResponseData {
    @SerializedName("acsChallengeMandated")
    private String acsChallengeMandated = null;

    @SerializedName("acsOperatorID")
    private String acsOperatorID = null;

    @SerializedName("acsReferenceNumber")
    private String acsReferenceNumber = null;

    @SerializedName("acsSignedContent")
    private String acsSignedContent = null;

    @SerializedName("acsTransID")
    private String acsTransID = null;

    @SerializedName("acsURL")
    private String acsURL = null;

    @SerializedName("authenticationType")
    private String authenticationType = null;

    @SerializedName("cardHolderInfo")
    private String cardHolderInfo = null;

    @SerializedName("cavvAlgorithm")
    private String cavvAlgorithm = null;

    @SerializedName("challengeIndicator")
    private String challengeIndicator = null;

    @SerializedName("dsReferenceNumber")
    private String dsReferenceNumber = null;

    @SerializedName("dsTransID")
    private String dsTransID = null;

    @SerializedName("exemptionIndicator")
    private String exemptionIndicator = null;

    @SerializedName("messageVersion")
    private String messageVersion = null;

    @SerializedName("riskScore")
    private String riskScore = null;

    @SerializedName("sdkEphemPubKey")
    private String sdkEphemPubKey = null;

    @SerializedName("threeDSServerTransID")
    private String threeDSServerTransID = null;

    @SerializedName("transStatus")
    private String transStatus = null;

    @SerializedName("transStatusReason")
    private String transStatusReason = null;

    public ThreeDS2ResponseData acsChallengeMandated(String acsChallengeMandated) {
        this.acsChallengeMandated = acsChallengeMandated;
        return this;
    }

    /**
     * Get acsChallengeMandated
     * @return acsChallengeMandated
     **/
    @Schema(description = "")
    public String getAcsChallengeMandated() {
        return acsChallengeMandated;
    }

    public void setAcsChallengeMandated(String acsChallengeMandated) {
        this.acsChallengeMandated = acsChallengeMandated;
    }

    public ThreeDS2ResponseData acsOperatorID(String acsOperatorID) {
        this.acsOperatorID = acsOperatorID;
        return this;
    }

    /**
     * Get acsOperatorID
     * @return acsOperatorID
     **/
    @Schema(description = "")
    public String getAcsOperatorID() {
        return acsOperatorID;
    }

    public void setAcsOperatorID(String acsOperatorID) {
        this.acsOperatorID = acsOperatorID;
    }

    public ThreeDS2ResponseData acsReferenceNumber(String acsReferenceNumber) {
        this.acsReferenceNumber = acsReferenceNumber;
        return this;
    }

    /**
     * Get acsReferenceNumber
     * @return acsReferenceNumber
     **/
    @Schema(description = "")
    public String getAcsReferenceNumber() {
        return acsReferenceNumber;
    }

    public void setAcsReferenceNumber(String acsReferenceNumber) {
        this.acsReferenceNumber = acsReferenceNumber;
    }

    public ThreeDS2ResponseData acsSignedContent(String acsSignedContent) {
        this.acsSignedContent = acsSignedContent;
        return this;
    }

    /**
     * Get acsSignedContent
     * @return acsSignedContent
     **/
    @Schema(description = "")
    public String getAcsSignedContent() {
        return acsSignedContent;
    }

    public void setAcsSignedContent(String acsSignedContent) {
        this.acsSignedContent = acsSignedContent;
    }

    public ThreeDS2ResponseData acsTransID(String acsTransID) {
        this.acsTransID = acsTransID;
        return this;
    }

    /**
     * Get acsTransID
     * @return acsTransID
     **/
    @Schema(description = "")
    public String getAcsTransID() {
        return acsTransID;
    }

    public void setAcsTransID(String acsTransID) {
        this.acsTransID = acsTransID;
    }

    public ThreeDS2ResponseData acsURL(String acsURL) {
        this.acsURL = acsURL;
        return this;
    }

    /**
     * Get acsURL
     * @return acsURL
     **/
    @Schema(description = "")
    public String getAcsURL() {
        return acsURL;
    }

    public void setAcsURL(String acsURL) {
        this.acsURL = acsURL;
    }

    public ThreeDS2ResponseData authenticationType(String authenticationType) {
        this.authenticationType = authenticationType;
        return this;
    }

    /**
     * Get authenticationType
     * @return authenticationType
     **/
    @Schema(description = "")
    public String getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(String authenticationType) {
        this.authenticationType = authenticationType;
    }

    public ThreeDS2ResponseData cardHolderInfo(String cardHolderInfo) {
        this.cardHolderInfo = cardHolderInfo;
        return this;
    }

    /**
     * Get cardHolderInfo
     * @return cardHolderInfo
     **/
    @Schema(description = "")
    public String getCardHolderInfo() {
        return cardHolderInfo;
    }

    public void setCardHolderInfo(String cardHolderInfo) {
        this.cardHolderInfo = cardHolderInfo;
    }

    public ThreeDS2ResponseData cavvAlgorithm(String cavvAlgorithm) {
        this.cavvAlgorithm = cavvAlgorithm;
        return this;
    }

    /**
     * Get cavvAlgorithm
     * @return cavvAlgorithm
     **/
    @Schema(description = "")
    public String getCavvAlgorithm() {
        return cavvAlgorithm;
    }

    public void setCavvAlgorithm(String cavvAlgorithm) {
        this.cavvAlgorithm = cavvAlgorithm;
    }

    public ThreeDS2ResponseData challengeIndicator(String challengeIndicator) {
        this.challengeIndicator = challengeIndicator;
        return this;
    }

    /**
     * Get challengeIndicator
     * @return challengeIndicator
     **/
    @Schema(description = "")
    public String getChallengeIndicator() {
        return challengeIndicator;
    }

    public void setChallengeIndicator(String challengeIndicator) {
        this.challengeIndicator = challengeIndicator;
    }

    public ThreeDS2ResponseData dsReferenceNumber(String dsReferenceNumber) {
        this.dsReferenceNumber = dsReferenceNumber;
        return this;
    }

    /**
     * Get dsReferenceNumber
     * @return dsReferenceNumber
     **/
    @Schema(description = "")
    public String getDsReferenceNumber() {
        return dsReferenceNumber;
    }

    public void setDsReferenceNumber(String dsReferenceNumber) {
        this.dsReferenceNumber = dsReferenceNumber;
    }

    public ThreeDS2ResponseData dsTransID(String dsTransID) {
        this.dsTransID = dsTransID;
        return this;
    }

    /**
     * Get dsTransID
     * @return dsTransID
     **/
    @Schema(description = "")
    public String getDsTransID() {
        return dsTransID;
    }

    public void setDsTransID(String dsTransID) {
        this.dsTransID = dsTransID;
    }

    public ThreeDS2ResponseData exemptionIndicator(String exemptionIndicator) {
        this.exemptionIndicator = exemptionIndicator;
        return this;
    }

    /**
     * Get exemptionIndicator
     * @return exemptionIndicator
     **/
    @Schema(description = "")
    public String getExemptionIndicator() {
        return exemptionIndicator;
    }

    public void setExemptionIndicator(String exemptionIndicator) {
        this.exemptionIndicator = exemptionIndicator;
    }

    public ThreeDS2ResponseData messageVersion(String messageVersion) {
        this.messageVersion = messageVersion;
        return this;
    }

    /**
     * Get messageVersion
     * @return messageVersion
     **/
    @Schema(description = "")
    public String getMessageVersion() {
        return messageVersion;
    }

    public void setMessageVersion(String messageVersion) {
        this.messageVersion = messageVersion;
    }

    public ThreeDS2ResponseData riskScore(String riskScore) {
        this.riskScore = riskScore;
        return this;
    }

    /**
     * Get riskScore
     * @return riskScore
     **/
    @Schema(description = "")
    public String getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(String riskScore) {
        this.riskScore = riskScore;
    }

    public ThreeDS2ResponseData sdkEphemPubKey(String sdkEphemPubKey) {
        this.sdkEphemPubKey = sdkEphemPubKey;
        return this;
    }

    /**
     * Get sdkEphemPubKey
     * @return sdkEphemPubKey
     **/
    @Schema(description = "")
    public String getSdkEphemPubKey() {
        return sdkEphemPubKey;
    }

    public void setSdkEphemPubKey(String sdkEphemPubKey) {
        this.sdkEphemPubKey = sdkEphemPubKey;
    }

    public ThreeDS2ResponseData threeDSServerTransID(String threeDSServerTransID) {
        this.threeDSServerTransID = threeDSServerTransID;
        return this;
    }

    /**
     * Get threeDSServerTransID
     * @return threeDSServerTransID
     **/
    @Schema(description = "")
    public String getThreeDSServerTransID() {
        return threeDSServerTransID;
    }

    public void setThreeDSServerTransID(String threeDSServerTransID) {
        this.threeDSServerTransID = threeDSServerTransID;
    }

    public ThreeDS2ResponseData transStatus(String transStatus) {
        this.transStatus = transStatus;
        return this;
    }

    /**
     * Get transStatus
     * @return transStatus
     **/
    @Schema(description = "")
    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }

    public ThreeDS2ResponseData transStatusReason(String transStatusReason) {
        this.transStatusReason = transStatusReason;
        return this;
    }

    /**
     * Get transStatusReason
     * @return transStatusReason
     **/
    @Schema(description = "")
    public String getTransStatusReason() {
        return transStatusReason;
    }

    public void setTransStatusReason(String transStatusReason) {
        this.transStatusReason = transStatusReason;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ThreeDS2ResponseData threeDS2ResponseData = (ThreeDS2ResponseData) o;
        return Objects.equals(this.acsChallengeMandated, threeDS2ResponseData.acsChallengeMandated) &&
                Objects.equals(this.acsOperatorID, threeDS2ResponseData.acsOperatorID) &&
                Objects.equals(this.acsReferenceNumber, threeDS2ResponseData.acsReferenceNumber) &&
                Objects.equals(this.acsSignedContent, threeDS2ResponseData.acsSignedContent) &&
                Objects.equals(this.acsTransID, threeDS2ResponseData.acsTransID) &&
                Objects.equals(this.acsURL, threeDS2ResponseData.acsURL) &&
                Objects.equals(this.authenticationType, threeDS2ResponseData.authenticationType) &&
                Objects.equals(this.cardHolderInfo, threeDS2ResponseData.cardHolderInfo) &&
                Objects.equals(this.cavvAlgorithm, threeDS2ResponseData.cavvAlgorithm) &&
                Objects.equals(this.challengeIndicator, threeDS2ResponseData.challengeIndicator) &&
                Objects.equals(this.dsReferenceNumber, threeDS2ResponseData.dsReferenceNumber) &&
                Objects.equals(this.dsTransID, threeDS2ResponseData.dsTransID) &&
                Objects.equals(this.exemptionIndicator, threeDS2ResponseData.exemptionIndicator) &&
                Objects.equals(this.messageVersion, threeDS2ResponseData.messageVersion) &&
                Objects.equals(this.riskScore, threeDS2ResponseData.riskScore) &&
                Objects.equals(this.sdkEphemPubKey, threeDS2ResponseData.sdkEphemPubKey) &&
                Objects.equals(this.threeDSServerTransID, threeDS2ResponseData.threeDSServerTransID) &&
                Objects.equals(this.transStatus, threeDS2ResponseData.transStatus) &&
                Objects.equals(this.transStatusReason, threeDS2ResponseData.transStatusReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acsChallengeMandated, acsOperatorID, acsReferenceNumber, acsSignedContent, acsTransID, acsURL, authenticationType, cardHolderInfo, cavvAlgorithm, challengeIndicator, dsReferenceNumber, dsTransID, exemptionIndicator, messageVersion, riskScore, sdkEphemPubKey, threeDSServerTransID, transStatus, transStatusReason);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ThreeDS2ResponseData {\n");

        sb.append("    acsChallengeMandated: ").append(toIndentedString(acsChallengeMandated)).append("\n");
        sb.append("    acsOperatorID: ").append(toIndentedString(acsOperatorID)).append("\n");
        sb.append("    acsReferenceNumber: ").append(toIndentedString(acsReferenceNumber)).append("\n");
        sb.append("    acsSignedContent: ").append(toIndentedString(acsSignedContent)).append("\n");
        sb.append("    acsTransID: ").append(toIndentedString(acsTransID)).append("\n");
        sb.append("    acsURL: ").append(toIndentedString(acsURL)).append("\n");
        sb.append("    authenticationType: ").append(toIndentedString(authenticationType)).append("\n");
        sb.append("    cardHolderInfo: ").append(toIndentedString(cardHolderInfo)).append("\n");
        sb.append("    cavvAlgorithm: ").append(toIndentedString(cavvAlgorithm)).append("\n");
        sb.append("    challengeIndicator: ").append(toIndentedString(challengeIndicator)).append("\n");
        sb.append("    dsReferenceNumber: ").append(toIndentedString(dsReferenceNumber)).append("\n");
        sb.append("    dsTransID: ").append(toIndentedString(dsTransID)).append("\n");
        sb.append("    exemptionIndicator: ").append(toIndentedString(exemptionIndicator)).append("\n");
        sb.append("    messageVersion: ").append(toIndentedString(messageVersion)).append("\n");
        sb.append("    riskScore: ").append(toIndentedString(riskScore)).append("\n");
        sb.append("    sdkEphemPubKey: ").append(toIndentedString(sdkEphemPubKey)).append("\n");
        sb.append("    threeDSServerTransID: ").append(toIndentedString(threeDSServerTransID)).append("\n");
        sb.append("    transStatus: ").append(toIndentedString(transStatus)).append("\n");
        sb.append("    transStatusReason: ").append(toIndentedString(transStatusReason)).append("\n");
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

