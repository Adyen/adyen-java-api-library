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

import com.adyen.model.Amount;
import com.google.gson.annotations.SerializedName;

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
        final StringBuilder sb = new StringBuilder("CompensateNegativeBalanceNotificationRecord{");
        sb.append("accountCode='").append(toIndentedString(accountCode)).append('\'');
        sb.append(", transferDate=").append(toIndentedString(transferDate));
        sb.append(", amount=").append(toIndentedString(amount));
        sb.append('}');
        return sb.toString();
    }
}
