/**
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
package com.adyen.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * KYCVerificationResult
 */
public class KYCVerificationResult {
    @SerializedName("shareholderCheckResult")
    private List<KYCShareholderCheckResult> shareholderCheckResult = new ArrayList<KYCShareholderCheckResult>();

    @SerializedName("accountHolderCheckResult")
    private KYCCheckResult accountHolderCheckResult = null;

    @SerializedName("bankAccountCheckResult")
    private List<KYCBankAccountCheckResult> bankAccountCheckResult = new ArrayList<KYCBankAccountCheckResult>();

    public KYCVerificationResult shareholderCheckResult(List<KYCShareholderCheckResult> shareholderCheckResult) {
        this.shareholderCheckResult = shareholderCheckResult;
        return this;
    }

    public KYCVerificationResult addShareholderCheckResultItem(KYCShareholderCheckResult shareholderCheckResultItem) {
        this.shareholderCheckResult.add(shareholderCheckResultItem);
        return this;
    }

    /**
     * KYC check results for the shareholders
     *
     * @return shareholderCheckResult
     **/
    public List<KYCShareholderCheckResult> getShareholderCheckResult() {
        return shareholderCheckResult;
    }

    public void setShareholderCheckResult(List<KYCShareholderCheckResult> shareholderCheckResult) {
        this.shareholderCheckResult = shareholderCheckResult;
    }

    public KYCVerificationResult accountHolderCheckResult(KYCCheckResult accountHolderCheckResult) {
        this.accountHolderCheckResult = accountHolderCheckResult;
        return this;
    }

    /**
     * KYC check results for the account holder itself
     *
     * @return accountHolderCheckResult
     **/
    public KYCCheckResult getAccountHolderCheckResult() {
        return accountHolderCheckResult;
    }

    public void setAccountHolderCheckResult(KYCCheckResult accountHolderCheckResult) {
        this.accountHolderCheckResult = accountHolderCheckResult;
    }

    public KYCVerificationResult bankAccountCheckResult(List<KYCBankAccountCheckResult> bankAccountCheckResult) {
        this.bankAccountCheckResult = bankAccountCheckResult;
        return this;
    }

    public KYCVerificationResult addBankAccountCheckResultItem(KYCBankAccountCheckResult bankAccountCheckResultItem) {
        this.bankAccountCheckResult.add(bankAccountCheckResultItem);
        return this;
    }

    /**
     * KYC check results for the bank accounts
     *
     * @return bankAccountCheckResult
     **/
    public List<KYCBankAccountCheckResult> getBankAccountCheckResult() {
        return bankAccountCheckResult;
    }

    public void setBankAccountCheckResult(List<KYCBankAccountCheckResult> bankAccountCheckResult) {
        this.bankAccountCheckResult = bankAccountCheckResult;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KYCVerificationResult kyCVerificationResult = (KYCVerificationResult) o;
        return Objects.equals(this.shareholderCheckResult, kyCVerificationResult.shareholderCheckResult)
                && Objects.equals(this.accountHolderCheckResult,
                                  kyCVerificationResult.accountHolderCheckResult)
                && Objects.equals(this.bankAccountCheckResult, kyCVerificationResult.bankAccountCheckResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shareholderCheckResult, accountHolderCheckResult, bankAccountCheckResult);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KYCVerificationResult {\n");

        sb.append("    shareholderCheckResult: ").append(toIndentedString(shareholderCheckResult)).append("\n");
        sb.append("    accountHolderCheckResult: ").append(toIndentedString(accountHolderCheckResult)).append("\n");
        sb.append("    bankAccountCheckResult: ").append(toIndentedString(bankAccountCheckResult)).append("\n");
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

