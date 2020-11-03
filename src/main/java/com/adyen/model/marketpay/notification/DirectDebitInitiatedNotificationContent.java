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

package com.adyen.model.marketpay.notification;

import com.adyen.model.Amount;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * DirectDebitInitiatedNotificationContent
 */

public class DirectDebitInitiatedNotificationContent {
    @SerializedName("accountCode")
    private String accountCode = null;

    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("debitInitiationDate")
    private Date debitInitiationDate = null;

    @SerializedName("merchantAccountCode")
    private String merchantAccountCode = null;

    @SerializedName("status")
    private OperationStatus status = null;

    public DirectDebitInitiatedNotificationContent accountCode(String accountCode) {
        this.accountCode = accountCode;
        return this;
    }

    /**
     * The code of the account.
     *
     * @return accountCode
     **/
    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public DirectDebitInitiatedNotificationContent amount(Amount amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Get amount
     *
     * @return amount
     **/
    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public DirectDebitInitiatedNotificationContent debitInitiationDate(Date debitInitiationDate) {
        this.debitInitiationDate = debitInitiationDate;
        return this;
    }

    /**
     * Get debitInitiationDate
     *
     * @return debitInitiationDate
     **/
    public Date getDebitInitiationDate() {
        return debitInitiationDate;
    }

    public void setDebitInitiationDate(Date debitInitiationDate) {
        this.debitInitiationDate = debitInitiationDate;
    }

    public DirectDebitInitiatedNotificationContent merchantAccountCode(String merchantAccountCode) {
        this.merchantAccountCode = merchantAccountCode;
        return this;
    }

    /**
     * The code of the merchant account.
     *
     * @return merchantAccountCode
     **/
    public String getMerchantAccountCode() {
        return merchantAccountCode;
    }

    public void setMerchantAccountCode(String merchantAccountCode) {
        this.merchantAccountCode = merchantAccountCode;
    }

    public DirectDebitInitiatedNotificationContent status(OperationStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     **/
    public OperationStatus getStatus() {
        return status;
    }

    public void setStatus(OperationStatus status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DirectDebitInitiatedNotificationContent directDebitInitiatedNotificationContent = (DirectDebitInitiatedNotificationContent) o;
        return Objects.equals(this.accountCode, directDebitInitiatedNotificationContent.accountCode) &&
                Objects.equals(this.amount, directDebitInitiatedNotificationContent.amount) &&
                Objects.equals(this.debitInitiationDate, directDebitInitiatedNotificationContent.debitInitiationDate) &&
                Objects.equals(this.merchantAccountCode, directDebitInitiatedNotificationContent.merchantAccountCode) &&
                Objects.equals(this.status, directDebitInitiatedNotificationContent.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountCode, amount, debitInitiationDate, merchantAccountCode, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DirectDebitInitiatedNotificationContent {\n");

        sb.append("    accountCode: ").append(toIndentedString(accountCode)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    debitInitiationDate: ").append(toIndentedString(debitInitiationDate)).append("\n");
        sb.append("    merchantAccountCode: ").append(toIndentedString(merchantAccountCode)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
