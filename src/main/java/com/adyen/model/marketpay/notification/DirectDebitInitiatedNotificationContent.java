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
import com.adyen.model.marketpay.Split;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    @SerializedName("invalidFields")
    private List<ErrorFieldType> invalidFields = null;

    @SerializedName("merchantAccountCode")
    private String merchantAccountCode = null;

    @SerializedName("splits")
    private List<Split> splits = null;

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

    public DirectDebitInitiatedNotificationContent invalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
        return this;
    }

    public DirectDebitInitiatedNotificationContent addInvalidFieldsItem(ErrorFieldType invalidFieldsItem) {
        if (this.invalidFields == null) {
            this.invalidFields = new ArrayList<ErrorFieldType>();
        }
        this.invalidFields.add(invalidFieldsItem);
        return this;
    }

    /**
     * Invalid fields list.
     *
     * @return invalidFields
     **/
    public List<ErrorFieldType> getInvalidFields() {
        return invalidFields;
    }

    public void setInvalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
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

    public DirectDebitInitiatedNotificationContent splits(List<Split> splits) {
        this.splits = splits;
        return this;
    }

    public DirectDebitInitiatedNotificationContent addSplitsItem(Split splitsItem) {
        if (this.splits == null) {
            this.splits = new ArrayList<Split>();
        }
        this.splits.add(splitsItem);
        return this;
    }

    /**
     * The split data for the debit request
     *
     * @return splits
     **/
    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
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
    public boolean equals(java.lang.Object o) {
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
                Objects.equals(this.invalidFields, directDebitInitiatedNotificationContent.invalidFields) &&
                Objects.equals(this.merchantAccountCode, directDebitInitiatedNotificationContent.merchantAccountCode) &&
                Objects.equals(this.splits, directDebitInitiatedNotificationContent.splits) &&
                Objects.equals(this.status, directDebitInitiatedNotificationContent.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountCode, amount, debitInitiationDate, invalidFields, merchantAccountCode, splits, status);
    }


    @Override
    public String toString() {

        String sb = "class DirectDebitInitiatedNotificationContent {\n" +
                "    accountCode: " + toIndentedString(accountCode) + "\n" +
                "    amount: " + toIndentedString(amount) + "\n" +
                "    debitInitiationDate: " + toIndentedString(debitInitiationDate) + "\n" +
                "    invalidFields: " + toIndentedString(invalidFields) + "\n" +
                "    merchantAccountCode: " + toIndentedString(merchantAccountCode) + "\n" +
                "    splits: " + toIndentedString(splits) + "\n" +
                "    status: " + toIndentedString(status) + "\n" +
                "}";
        return sb;
    }

}
