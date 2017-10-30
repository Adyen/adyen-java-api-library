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
package com.adyen.model.marketpay;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Account
 */
public class Account {
    @SerializedName("accountCode")
    private String accountCode = null;

    @SerializedName("beneficiaryAccount")
    private String beneficiaryAccount = null;

    @SerializedName("beneficiaryMerchantReference")
    private String beneficiaryMerchantReference = null;

    @SerializedName("payoutSchedule")
    private PayoutScheduleResponse payoutSchedule = null;

    public Account accountCode(String accountCode) {
        this.accountCode = accountCode;
        return this;
    }

    /**
     * account code
     *
     * @return accountCode
     **/
    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public Account beneficiaryAccount(String beneficiaryAccount) {
        this.beneficiaryAccount = beneficiaryAccount;
        return this;
    }

    /**
     * Account's beneficiary account
     *
     * @return beneficiaryAccount
     **/
    public String getBeneficiaryAccount() {
        return beneficiaryAccount;
    }

    public void setBeneficiaryAccount(String beneficiaryAccount) {
        this.beneficiaryAccount = beneficiaryAccount;
    }

    public Account beneficiaryMerchantReference(String beneficiaryMerchantReference) {
        this.beneficiaryMerchantReference = beneficiaryMerchantReference;
        return this;
    }

    /**
     * Reason beneficiary was setup
     *
     * @return beneficiaryMerchantReference
     **/
    public String getBeneficiaryMerchantReference() {
        return beneficiaryMerchantReference;
    }

    public void setBeneficiaryMerchantReference(String beneficiaryMerchantReference) {
        this.beneficiaryMerchantReference = beneficiaryMerchantReference;
    }

    public Account payoutSchedule(PayoutScheduleResponse payoutSchedule) {
        this.payoutSchedule = payoutSchedule;
        return this;
    }

    /**
     * account's payout schedule
     *
     * @return payoutSchedule
     **/
    public PayoutScheduleResponse getPayoutSchedule() {
        return payoutSchedule;
    }

    public void setPayoutSchedule(PayoutScheduleResponse payoutSchedule) {
        this.payoutSchedule = payoutSchedule;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(this.accountCode, account.accountCode)
                && Objects.equals(this.beneficiaryAccount, account.beneficiaryAccount)
                && Objects.equals(this.beneficiaryMerchantReference,
                                  account.beneficiaryMerchantReference)
                && Objects.equals(this.payoutSchedule, account.payoutSchedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountCode, beneficiaryAccount, beneficiaryMerchantReference, payoutSchedule);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Account {\n");

        sb.append("    accountCode: ").append(toIndentedString(accountCode)).append("\n");
        sb.append("    beneficiaryAccount: ").append(toIndentedString(beneficiaryAccount)).append("\n");
        sb.append("    beneficiaryMerchantReference: ").append(toIndentedString(beneficiaryMerchantReference)).append("\n");
        sb.append("    payoutSchedule: ").append(toIndentedString(payoutSchedule)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

