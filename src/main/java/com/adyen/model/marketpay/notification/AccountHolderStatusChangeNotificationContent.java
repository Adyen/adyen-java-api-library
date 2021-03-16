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

import java.util.Objects;

import com.adyen.model.marketpay.AccountHolderStatus;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * AccountHolderStatusChangeNotificationContent
 */

public class AccountHolderStatusChangeNotificationContent {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("invalidFields")
    private List<ErrorFieldType> invalidFields = null;

    @SerializedName("newStatus")
    private AccountHolderStatus newStatus = null;

    @SerializedName("oldStatus")
    private AccountHolderStatus oldStatus = null;

    @SerializedName("reason")
    private String reason = null;

    public AccountHolderStatusChangeNotificationContent accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * The code of the account holder.
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public AccountHolderStatusChangeNotificationContent invalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
        return this;
    }

    public AccountHolderStatusChangeNotificationContent addInvalidFieldsItem(ErrorFieldType invalidFieldsItem) {
        if (this.invalidFields == null) {
            this.invalidFields = new ArrayList<ErrorFieldType>();
        }
        this.invalidFields.add(invalidFieldsItem);
        return this;
    }

    /**
     * in case the account holder has not been updated, contains account holder fields, that did not pass the validation.
     *
     * @return invalidFields
     **/
    public List<ErrorFieldType> getInvalidFields() {
        return invalidFields;
    }

    public void setInvalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
    }

    public AccountHolderStatusChangeNotificationContent newStatus(AccountHolderStatus newStatus) {
        this.newStatus = newStatus;
        return this;
    }

    /**
     * Get newStatus
     *
     * @return newStatus
     **/
    public AccountHolderStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(AccountHolderStatus newStatus) {
        this.newStatus = newStatus;
    }

    public AccountHolderStatusChangeNotificationContent oldStatus(AccountHolderStatus oldStatus) {
        this.oldStatus = oldStatus;
        return this;
    }

    /**
     * Get oldStatus
     *
     * @return oldStatus
     **/
    public AccountHolderStatus getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(AccountHolderStatus oldStatus) {
        this.oldStatus = oldStatus;
    }

    public AccountHolderStatusChangeNotificationContent reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * The reason for the status change.
     *
     * @return reason
     **/
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountHolderStatusChangeNotificationContent accountHolderStatusChangeNotificationContent = (AccountHolderStatusChangeNotificationContent) o;
        return Objects.equals(this.accountHolderCode, accountHolderStatusChangeNotificationContent.accountHolderCode) &&
                Objects.equals(this.invalidFields, accountHolderStatusChangeNotificationContent.invalidFields) &&
                Objects.equals(this.newStatus, accountHolderStatusChangeNotificationContent.newStatus) &&
                Objects.equals(this.oldStatus, accountHolderStatusChangeNotificationContent.oldStatus) &&
                Objects.equals(this.reason, accountHolderStatusChangeNotificationContent.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, invalidFields, newStatus, oldStatus, reason);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountHolderStatusChangeNotificationContent {\n");

        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    invalidFields: ").append(toIndentedString(invalidFields)).append("\n");
        sb.append("    newStatus: ").append(toIndentedString(newStatus)).append("\n");
        sb.append("    oldStatus: ").append(toIndentedString(oldStatus)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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
