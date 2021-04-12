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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.marketpay.notification;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class ReportAvailableNotificationContent {
    @SerializedName("accountCode")
    private String accountCode;

    @SerializedName("accountType")
    private String accountType;

    @SerializedName("eventDate")
    private Date eventDate;

    @SerializedName("success")
    private String success;

    @SerializedName("remoteAccessUrl")
    private String remoteAccessUrl;

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getRemoteAccessUrl() {
        return remoteAccessUrl;
    }

    public void setRemoteAccessUrl(String remoteAccessUrl) {
        this.remoteAccessUrl = remoteAccessUrl;
    }

    @Override
    public String toString() {
        return "ReportAvailableContent{"
                + "accountCode='"
                + accountCode
                + '\''
                + ", accountType='"
                + accountType
                + '\''
                + ", eventDate="
                + eventDate
                + ", success='"
                + success
                + '\''
                + ", remoteAccessUrl='"
                + remoteAccessUrl
                + '\''
                + '}';
    }
}
