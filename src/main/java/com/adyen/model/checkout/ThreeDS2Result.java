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

package com.adyen.model.checkout;


import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class ThreeDS2Result {

    @SerializedName("transStatusReason")
    private String transStatusReason;

    @SerializedName("transStatus")
    private String transStatus;

    @SerializedName("authenticationValue")
    private String authenticationValue;

    @SerializedName("eci")
    private String eci;

    @SerializedName("timestamp")
    private String timestamp;

    @SerializedName("threeDSServerTransID")
    private String threeDSServerTransID;

    @SerializedName("dsTransID")
    private String dsTransID;

    @SerializedName("messageVersion")
    private String messageVersion;

    /**
     * The transStatusReason value as defined in the 3D Secure 2 specification.
     *
     * @return transStatusReason
     **/
    public String getTransStatusReason() {
        return transStatusReason;
    }

    public void setTransStatusReason(String transStatusReason) {
        this.transStatusReason = transStatusReason;
    }

    public ThreeDS2Result transStatusReason(String transStatusReason) {
        this.transStatusReason = transStatusReason;
        return this;
    }

    /**
     * The transStatus value as defined in the 3D Secure 2 specification.
     *
     * @return transStatus
     **/
    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }

    public ThreeDS2Result transStatus(String transStatus) {
        this.transStatus = transStatus;
        return this;
    }

    /**
     * The authenticationValue value as defined in the 3D Secure 2 specification.
     *
     * @return authenticationValue
     **/
    public String getAuthenticationValue() {
        return authenticationValue;
    }

    public void setAuthenticationValue(String authenticationValue) {
        this.authenticationValue = authenticationValue;
    }

    public ThreeDS2Result authenticationValue(String authenticationValue) {
        this.authenticationValue = authenticationValue;
        return this;
    }

    /**
     * The eci value as defined in the 3D Secure 2 specification.
     *
     * @return eci
     **/
    public String getEci() {
        return eci;
    }

    public void setEci(String eci) {
        this.eci = eci;
    }

    public ThreeDS2Result eci(String eci) {
        this.eci = eci;
        return this;
    }

    /**
     * The timestamp value as defined in the 3D Secure 2 specification.
     *
     * @return timestamp
     **/
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public ThreeDS2Result timestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * The threeDSServerTransID value as defined in the 3D Secure 2 specification.
     *
     * @return threeDSServerTransID
     **/
    public String getThreeDSServerTransID() {
        return threeDSServerTransID;
    }

    public void setThreeDSServerTransID(String threeDSServerTransID) {
        this.threeDSServerTransID = threeDSServerTransID;
    }

    public ThreeDS2Result threeDSServerTransID(String threeDSServerTransID) {
        this.threeDSServerTransID = threeDSServerTransID;
        return this;
    }

    /**
     * The dsTransID value as defined in the 3D Secure 2 specification.
     *
     * @return dsTransID
     **/
    public String getDsTransID() {
        return dsTransID;
    }

    public void setDsTransID(String dsTransID) {
        this.dsTransID = dsTransID;
    }

    public ThreeDS2Result dsTransID(String dsTransID) {
        this.dsTransID = dsTransID;
        return this;
    }

    public String getMessageVersion() {
        return messageVersion;
    }

    public void setMessageVersion(String messageVersion) {
        this.messageVersion = messageVersion;
    }

    public ThreeDS2Result messageVersion(String messageVersion) {
        this.messageVersion = messageVersion;
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
        ThreeDS2Result that = (ThreeDS2Result) o;
        return Objects.equals(transStatusReason, that.transStatusReason) &&
                Objects.equals(transStatus, that.transStatus) &&
                Objects.equals(authenticationValue, that.authenticationValue) &&
                Objects.equals(eci, that.eci) &&
                Objects.equals(timestamp, that.timestamp) &&
                Objects.equals(threeDSServerTransID, that.threeDSServerTransID) &&
                Objects.equals(dsTransID, that.dsTransID) &&
                Objects.equals(messageVersion, that.messageVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transStatusReason, transStatus, authenticationValue, eci, timestamp, threeDSServerTransID, dsTransID);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ThreeDS2Result {\n");
        sb.append("    transStatusReason: ").append(toIndentedString(transStatusReason)).append("\n");
        sb.append("    transStatus: ").append(toIndentedString(transStatus)).append("\n");
        sb.append("    authenticationValue: ").append(toIndentedString(authenticationValue)).append("\n");
        sb.append("    eci: ").append(toIndentedString(eci)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("    threeDSServerTransID: ").append(toIndentedString(threeDSServerTransID)).append("\n");
        sb.append("    dsTransID: ").append(toIndentedString(dsTransID)).append("\n");
        sb.append("    messageVersion: ").append(toIndentedString(messageVersion)).append("\n");
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
