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


import java.util.Objects;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * ThreeDS2Result
 */
public class ThreeDS2Result {

    @SerializedName("authenticationValue")
    private String authenticationValue = null;

    @SerializedName("eci")
    private String eci = null;

    @SerializedName("threeDSServerTransID")
    private String threeDSServerTransID = null;

    @SerializedName("timestamp")
    private String timestamp = null;

    @SerializedName("transStatus")
    private String transStatus = null;

    @SerializedName("transStatusReason")
    private String transStatusReason = null;

    public ThreeDS2Result authenticationValue(String authenticationValue) {
        this.authenticationValue = authenticationValue;
        return this;
    }

    public String getAuthenticationValue() {
        return authenticationValue;
    }

    public void setAuthenticationValue(String authenticationValue) {
        this.authenticationValue = authenticationValue;
    }

    public ThreeDS2Result eci(String eci) {
        this.eci = eci;
        return this;
    }

    public String getEci() {
        return eci;
    }

    public void setEci(String eci) {
        this.eci = eci;
    }

    public ThreeDS2Result threeDSServerTransID(String threeDSServerTransID) {
        this.threeDSServerTransID = threeDSServerTransID;
        return this;
    }

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
        ThreeDS2Result threeDS2Result = (ThreeDS2Result) o;
        return Objects.equals(this.authenticationValue, threeDS2Result.authenticationValue) &&
                Objects.equals(this.eci, threeDS2Result.eci) &&
                Objects.equals(this.threeDSServerTransID, threeDS2Result.threeDSServerTransID) &&
                Objects.equals(this.timestamp, threeDS2Result.timestamp) &&
                Objects.equals(this.transStatus, threeDS2Result.transStatus) &&
                Objects.equals(this.transStatusReason, threeDS2Result.transStatusReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authenticationValue, eci, threeDSServerTransID, timestamp, transStatus, transStatusReason);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ThreeDS2Result {\n");

        sb.append("    authenticationValue: ").append(toIndentedString(authenticationValue)).append("\n");
        sb.append("    eci: ").append(toIndentedString(eci)).append("\n");
        sb.append("    threeDSServerTransID: ").append(toIndentedString(threeDSServerTransID)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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



