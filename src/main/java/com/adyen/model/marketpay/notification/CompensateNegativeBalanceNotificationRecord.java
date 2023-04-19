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

import com.adyen.model.marketpay.Amount;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

import static com.adyen.util.Util.toIndentedString;

public class CompensateNegativeBalanceNotificationRecord {
    @SerializedName("accountCode")
    private String accountCode;

    @SerializedName("transferDate")
    private Date transferDate;

    @SerializedName("amount")
    private Amount amount;

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        String sb = "CompensateNegativeBalanceNotificationRecord{" + "accountCode='" + toIndentedString(accountCode) + '\'' +
                ", transferDate=" + toIndentedString(transferDate) +
                ", amount=" + toIndentedString(amount) +
                '}';
        return sb;
    }
}
