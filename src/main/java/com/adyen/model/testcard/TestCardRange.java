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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.testcard;

import com.adyen.model.ThreeDSecureData;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TestCardRange {
    @SerializedName("address")
    private AvsAddress address = null;

    @SerializedName("cardHolderName")
    private String cardHolderName = null;

    @SerializedName("cvc")
    private String cvc = null;

    @SerializedName("expiryDates")
    private List<ExpiryDate> expiryDates = null;

    @SerializedName("rangeEnd")
    private String rangeEnd = null;

    @SerializedName("rangeStart")
    private String rangeStart = null;

    @SerializedName("threeDUserName")
    private String threeDUserName = null;

    @SerializedName("threeDPassword")
    private String threeDPassword = null;

    @SerializedName("threeDDirectoryServerResponse")
    private ThreeDSecureData.DirectoryResponseEnum threeDDirectoryServerResponse = null;

    public AvsAddress getAddress() {
        return address;
    }

    public void setAddress(AvsAddress address) {
        this.address = address;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public List<ExpiryDate> getExpiryDates() {
        return expiryDates;
    }

    public void setExpiryDates(List<ExpiryDate> expiryDates) {
        this.expiryDates = expiryDates;
    }

    public String getRangeEnd() {
        return rangeEnd;
    }

    public void setRangeEnd(String rangeEnd) {
        this.rangeEnd = rangeEnd;
    }

    public String getRangeStart() {
        return rangeStart;
    }

    public void setRangeStart(String rangeStart) {
        this.rangeStart = rangeStart;
    }

    public String getThreeDUserName() {
        return threeDUserName;
    }

    public void setThreeDUserName(String threeDUserName) {
        this.threeDUserName = threeDUserName;
    }

    public String getThreeDPassword() {
        return threeDPassword;
    }

    public void setThreeDPassword(String threeDPassword) {
        this.threeDPassword = threeDPassword;
    }

    public ThreeDSecureData.DirectoryResponseEnum getThreeDDirectoryServerResponse() {
        return threeDDirectoryServerResponse;
    }

    public void setThreeDDirectoryServerResponse(ThreeDSecureData.DirectoryResponseEnum threeDDirectoryServerResponse) {
        this.threeDDirectoryServerResponse = threeDDirectoryServerResponse;
    }

    @Override
    public String toString() {
        return "TestCardRange{" +
                "address=" + address +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", cvc='" + cvc + '\'' +
                ", expiryDates=" + expiryDates +
                ", rangeEnd='" + rangeEnd + '\'' +
                ", rangeStart='" + rangeStart + '\'' +
                ", threeDUserName='" + threeDUserName + '\'' +
                ", threeDPassword='" + threeDPassword + '\'' +
                ", threeDDirectoryServerResponse=" + threeDDirectoryServerResponse +
                '}';
    }
}
