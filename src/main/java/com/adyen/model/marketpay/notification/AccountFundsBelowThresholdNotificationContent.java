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

import com.adyen.model.Amount;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * AccountFundsBelowThresholdNotificationContent
 */

public class AccountFundsBelowThresholdNotificationContent {
    @SerializedName("accountCode")
    private String accountCode = null;

    @SerializedName("balanceDate")
    private Date balanceDate = null;

    @SerializedName("currentFunds")
    private Amount currentFunds = null;

    @SerializedName("fundThreshold")
    private Amount fundThreshold = null;

    @SerializedName("merchantAccountCode")
    private String merchantAccountCode = null;

    public AccountFundsBelowThresholdNotificationContent accountCode(String accountCode) {
        this.accountCode = accountCode;
        return this;
    }

    /**
     * The code of the account with funds under threshold
     *
     * @return accountCode
     **/
    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public AccountFundsBelowThresholdNotificationContent balanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
        return this;
    }

    /**
     * Get balanceDate
     *
     * @return balanceDate
     **/
    public Date getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
    }

    public AccountFundsBelowThresholdNotificationContent currentFunds(Amount currentFunds) {
        this.currentFunds = currentFunds;
        return this;
    }

    /**
     * Get currentFunds
     *
     * @return currentFunds
     **/
    public Amount getCurrentFunds() {
        return currentFunds;
    }

    public void setCurrentFunds(Amount currentFunds) {
        this.currentFunds = currentFunds;
    }

    public AccountFundsBelowThresholdNotificationContent fundThreshold(Amount fundThreshold) {
        this.fundThreshold = fundThreshold;
        return this;
    }

    /**
     * Get fundThreshold
     *
     * @return fundThreshold
     **/
    public Amount getFundThreshold() {
        return fundThreshold;
    }

    public void setFundThreshold(Amount fundThreshold) {
        this.fundThreshold = fundThreshold;
    }

    public AccountFundsBelowThresholdNotificationContent merchantAccountCode(String merchantAccountCode) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountFundsBelowThresholdNotificationContent accountFundsBelowThresholdNotificationContent = (AccountFundsBelowThresholdNotificationContent) o;
        return Objects.equals(this.accountCode, accountFundsBelowThresholdNotificationContent.accountCode) &&
                Objects.equals(this.balanceDate, accountFundsBelowThresholdNotificationContent.balanceDate) &&
                Objects.equals(this.currentFunds, accountFundsBelowThresholdNotificationContent.currentFunds) &&
                Objects.equals(this.fundThreshold, accountFundsBelowThresholdNotificationContent.fundThreshold) &&
                Objects.equals(this.merchantAccountCode, accountFundsBelowThresholdNotificationContent.merchantAccountCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountCode, balanceDate, currentFunds, fundThreshold, merchantAccountCode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountFundsBelowThresholdNotificationContent {\n");

        sb.append("    accountCode: ").append(toIndentedString(accountCode)).append("\n");
        sb.append("    balanceDate: ").append(toIndentedString(balanceDate)).append("\n");
        sb.append("    currentFunds: ").append(toIndentedString(currentFunds)).append("\n");
        sb.append("    fundThreshold: ").append(toIndentedString(fundThreshold)).append("\n");
        sb.append("    merchantAccountCode: ").append(toIndentedString(merchantAccountCode)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
