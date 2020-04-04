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

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * KYCVerificationResult
 */
public class KYCVerificationResult {
    @SerializedName("shareholders")
    private List<KYCShareholderCheckResult> shareholders = new ArrayList<>();

    @SerializedName("accountHolder")
    private KYCCheckResult accountHolder;

    @SerializedName("bankAccounts")
    private List<KYCBankAccountCheckResult> bankAccounts = new ArrayList<>();

    public List<KYCShareholderCheckResult> getShareholders() {
        return shareholders;
    }

    public void setShareholders(List<KYCShareholderCheckResult> shareholders) {
        this.shareholders = shareholders;
    }

    public KYCCheckResult getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(KYCCheckResult accountHolder) {
        this.accountHolder = accountHolder;
    }

    public List<KYCBankAccountCheckResult> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<KYCBankAccountCheckResult> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    @Override
    public String toString() {
        return "KYCVerificationResult{" + "shareholders=" + shareholders + ", accountHolder=" + accountHolder + ", bankAccounts=" + bankAccounts + '}';
    }
}
