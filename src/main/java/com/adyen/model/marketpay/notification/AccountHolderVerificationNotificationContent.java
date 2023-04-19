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


import com.adyen.model.marketpay.KYCCheckStatusData;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;


public class AccountHolderVerificationNotificationContent {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("kycCheckStatusData")
    private KYCCheckStatusData kycCheckStatusData = null;

    @SerializedName("payoutMethodCode")
    private String payoutMethodCode = null;

    @SerializedName("shareholderCode")
    private String shareholderCode = null;

    public AccountHolderVerificationNotificationContent accountHolderCode(String accountHolderCode) {
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

    public AccountHolderVerificationNotificationContent kycCheckStatusData(KYCCheckStatusData kycCheckStatusData) {
        this.kycCheckStatusData = kycCheckStatusData;
        return this;
    }

    /**
     * Get kycCheckStatusData
     *
     * @return kycCheckStatusData
     **/
    public KYCCheckStatusData getKycCheckStatusData() {
        return kycCheckStatusData;
    }

    public void setKycCheckStatusData(KYCCheckStatusData kycCheckStatusData) {
        this.kycCheckStatusData = kycCheckStatusData;
    }

    public AccountHolderVerificationNotificationContent payoutMethodCode(String payoutMethodCode) {
        this.payoutMethodCode = payoutMethodCode;
        return this;
    }

    /**
     * The unique code of the payout method that has been verified.
     *
     * @return payoutMethodCode
     **/
    public String getPayoutMethodCode() {
        return payoutMethodCode;
    }

    public void setPayoutMethodCode(String payoutMethodCode) {
        this.payoutMethodCode = payoutMethodCode;
    }

    public AccountHolderVerificationNotificationContent shareholderCode(String shareholderCode) {
        this.shareholderCode = shareholderCode;
        return this;
    }

    /**
     * The code of the shareholder that has been verified.
     *
     * @return shareholderCode
     **/
    public String getShareholderCode() {
        return shareholderCode;
    }

    public void setShareholderCode(String shareholderCode) {
        this.shareholderCode = shareholderCode;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountHolderVerificationNotificationContent accountHolderVerificationNotificationContent = (AccountHolderVerificationNotificationContent) o;
        return Objects.equals(this.accountHolderCode, accountHolderVerificationNotificationContent.accountHolderCode) &&
                Objects.equals(this.kycCheckStatusData, accountHolderVerificationNotificationContent.kycCheckStatusData) &&
                Objects.equals(this.payoutMethodCode, accountHolderVerificationNotificationContent.payoutMethodCode) &&
                Objects.equals(this.shareholderCode, accountHolderVerificationNotificationContent.shareholderCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, kycCheckStatusData, payoutMethodCode, shareholderCode);
    }


    @Override
    public String toString() {

        String sb = "class AccountHolderVerificationNotificationContent {\n" +
                "    accountHolderCode: " + toIndentedString(accountHolderCode) + "\n" +
                "    kycCheckStatusData: " + toIndentedString(kycCheckStatusData) + "\n" +
                "    payoutMethodCode: " + toIndentedString(payoutMethodCode) + "\n" +
                "    shareholderCode: " + toIndentedString(shareholderCode) + "\n" +
                "}";
        return sb;
    }

}
