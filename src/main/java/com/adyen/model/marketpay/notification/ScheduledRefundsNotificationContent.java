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

import java.util.List;

import com.adyen.model.marketpay.Transaction;
import com.google.gson.annotations.SerializedName;

public class ScheduledRefundsNotificationContent {
    @SerializedName("accountHolderCode")
    private String accountHolderCode;

    @SerializedName("accountCode")
    private String accountCode;

    @SerializedName("refundResults")
    private List<RefundResultContainer> refundResults;

    @SerializedName("lastPayout")
    private Transaction lastPayout;

    @SerializedName("invalidFields")
    private List<ErrorFieldType> invalidFields = null;

    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public List<RefundResultContainer> getRefundResults() {
        return refundResults;
    }

    public void setRefundResults(List<RefundResultContainer> refundResults) {
        this.refundResults = refundResults;
    }

    public Transaction getLastPayout() {
        return lastPayout;
    }

    public void setLastPayout(Transaction lastPayout) {
        this.lastPayout = lastPayout;
    }

    public List<ErrorFieldType> getInvalidFields() {
        return invalidFields;
    }

    public void setInvalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ScheduledRefundsContent{");
        sb.append("accountHolderCode='").append(accountHolderCode).append('\'');
        sb.append(", accountCode='").append(accountCode).append('\'');
        sb.append(", refundResults=").append(refundResults);
        sb.append(", lastPayout=").append(lastPayout);
        sb.append(", invalidFields=").append(invalidFields);
        sb.append('}');
        return sb.toString();
    }
}
