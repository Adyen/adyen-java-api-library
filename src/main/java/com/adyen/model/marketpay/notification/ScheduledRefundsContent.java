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

package com.adyen.model.marketpay.notification;

import java.util.List;
import com.adyen.model.marketpay.Transaction;
import com.google.gson.annotations.SerializedName;

public class ScheduledRefundsContent {
    @SerializedName("accountHolderCode")
    private String accountHolderCode;

    @SerializedName("accountCode")
    private String accountCode;

    @SerializedName("refundResults")
    private List<RefundResultContainer> refundResults;

    @SerializedName("lastPayout")
    private Transaction lastPayout;

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

    @Override
    public String toString() {
        return "ScheduledRefundsContent{"
                + "accountHolderCode='"
                + accountHolderCode
                + '\''
                + ", accountCode='"
                + accountCode
                + '\''
                + ", refundResults="
                + refundResults
                + ", lastPayout="
                + lastPayout
                + '}';
    }
}
