package com.adyen.model;


import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;


/**
 * RREQ
 */
public class Rreq {

    @SerializedName("acsTransID")
    private String acsTransID;

    @SerializedName("authenticationType")
    private String authenticationType;

    @SerializedName("authenticationValue")
    private String authenticationValue;

    @SerializedName("dsTransID")
    private String dsTransID;

    @SerializedName("eci")
    private String eci;

    @SerializedName("interactionCounter")
    private int interactionCounter;

    @SerializedName("messageCategory")
    private String messageCategory;

    @SerializedName("messageType")
    private String messageType;

    @SerializedName("messageVersion")
    private String messageVersion;

    @SerializedName("threeDSServerTransID")
    private String threeDSServerTransID;

    @SerializedName("transStatus")
    private String transStatus;

    @SerializedName("whiteListStatus")
    private String whiteListStatus;

    @SerializedName("whiteListStatusSource")
    private String whiteListStatusSource;

    public String getAcsTransID() {
        return acsTransID;
    }

    public Rreq setAcsTransID(String acsTransID) {
        this.acsTransID = acsTransID;
        return this;
    }

    public String getAuthenticationType() {
        return authenticationType;
    }

    public Rreq setAuthenticationType(String authenticationType) {
        this.authenticationType = authenticationType;
        return this;
    }

    public String getAuthenticationValue() {
        return authenticationValue;
    }

    public Rreq setAuthenticationValue(String authenticationValue) {
        this.authenticationValue = authenticationValue;
        return this;
    }

    public String getDsTransID() {
        return dsTransID;
    }

    public Rreq setDsTransID(String dsTransID) {
        this.dsTransID = dsTransID;
        return this;
    }

    public String getEci() {
        return eci;
    }

    public Rreq setEci(String eci) {
        this.eci = eci;
        return this;
    }

    public int getInteractionCounter() {
        return interactionCounter;
    }

    public Rreq setInteractionCounter(int interactionCounter) {
        this.interactionCounter = interactionCounter;
        return this;
    }

    public String getMessageCategory() {
        return messageCategory;
    }

    public Rreq setMessageCategory(String messageCategory) {
        this.messageCategory = messageCategory;
        return this;
    }

    public String getMessageType() {
        return messageType;
    }

    public Rreq setMessageType(String messageType) {
        this.messageType = messageType;
        return this;
    }

    public String getMessageVersion() {
        return messageVersion;
    }

    public Rreq setMessageVersion(String messageVersion) {
        this.messageVersion = messageVersion;
        return this;
    }

    public String getThreeDSServerTransID() {
        return threeDSServerTransID;
    }

    public Rreq setThreeDSServerTransID(String threeDSServerTransID) {
        this.threeDSServerTransID = threeDSServerTransID;
        return this;
    }

    public String getTransStatus() {
        return transStatus;
    }

    public Rreq setTransStatus(String transStatus) {
        this.transStatus = transStatus;
        return this;
    }

    public String getWhiteListStatus() {
        return whiteListStatus;
    }

    public Rreq setWhiteListStatus(String whiteListStatus) {
        this.whiteListStatus = whiteListStatus;
        return this;
    }

    public String getWhiteListStatusSource() {
        return whiteListStatusSource;
    }

    public Rreq setWhiteListStatusSource(String whiteListStatusSource) {
        this.whiteListStatusSource = whiteListStatusSource;
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
        Rreq rreq = (Rreq) o;

        return Objects.equals(this.acsTransID, rreq.acsTransID) &&
                Objects.equals(this.authenticationType, rreq.authenticationType) &&
                Objects.equals(this.authenticationValue, rreq.authenticationValue) &&
                Objects.equals(this.dsTransID, rreq.dsTransID) &&
                Objects.equals(this.eci, rreq.eci) &&
                Objects.equals(this.interactionCounter, rreq.interactionCounter) &&
                Objects.equals(this.messageCategory, rreq.messageCategory) &&
                Objects.equals(this.messageType, rreq.messageType) &&
                Objects.equals(this.messageVersion, rreq.messageVersion) &&
                Objects.equals(this.threeDSServerTransID, rreq.threeDSServerTransID) &&
                Objects.equals(this.transStatus, rreq.transStatus) &&
                Objects.equals(this.whiteListStatus, rreq.whiteListStatus) &&
                Objects.equals(this.whiteListStatusSource, rreq.whiteListStatusSource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acsTransID, authenticationType, authenticationValue, dsTransID, eci, interactionCounter,
                messageCategory, messageType, messageVersion, threeDSServerTransID, transStatus, whiteListStatus,
                whiteListStatusSource);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Rreq {\n");

        sb.append("    acsTransID: ").append(toIndentedString(acsTransID)).append("\n");
        sb.append("    authenticationType: ").append(toIndentedString(authenticationType)).append("\n");
        sb.append("    authenticationValue: ").append(toIndentedString(authenticationValue)).append("\n");
        sb.append("    dsTransID: ").append(toIndentedString(dsTransID)).append("\n");
        sb.append("    eci: ").append(toIndentedString(eci)).append("\n");
        sb.append("    interactionCounter: ").append(toIndentedString(interactionCounter)).append("\n");
        sb.append("    messageCategory: ").append(toIndentedString(messageCategory)).append("\n");
        sb.append("    messageType: ").append(toIndentedString(messageType)).append("\n");
        sb.append("    messageVersion: ").append(toIndentedString(messageVersion)).append("\n");
        sb.append("    threeDSServerTransID: ").append(toIndentedString(threeDSServerTransID)).append("\n");
        sb.append("    transStatus: ").append(toIndentedString(transStatus)).append("\n");
        sb.append("    whiteListStatus: ").append(toIndentedString(whiteListStatus)).append("\n");
        sb.append("    whiteListStatusSource: ").append(toIndentedString(whiteListStatusSource)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
