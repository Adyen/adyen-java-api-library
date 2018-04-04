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

import com.adyen.model.marketpay.AccountHolderStatus;

public class AccountHolderStatusChangeContent {
    private String accountHolderCode;
    private AccountHolderStatus oldStatus;
    private AccountHolderStatus newStatus;
    private String reason;

    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public AccountHolderStatus getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(AccountHolderStatus oldStatus) {
        this.oldStatus = oldStatus;
    }

    public AccountHolderStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(AccountHolderStatus newStatus) {
        this.newStatus = newStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "AccountHolderStatusChangeContent{" + "accountHolderCode='" + accountHolderCode + '\'' + ", oldStatus=" + oldStatus + ", newStatus=" + newStatus + ", reason='" + reason + '\'' + '}';
    }
}
