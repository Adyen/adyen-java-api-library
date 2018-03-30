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

package com.adyen.model.marketpay.v2;

import java.util.ArrayList;
import java.util.List;
import com.adyen.model.marketpay.KYCBankAccountCheckResult;
import com.adyen.model.marketpay.KYCCheckResult;
import com.adyen.model.marketpay.KYCShareholderCheckResult;
import com.google.gson.annotations.SerializedName;

/**
 * KYCVerificationResult
 */
public class KYCVerificationResult {
    @SerializedName("shareholders")
    private List<KYCShareholderCheckResult> shareholderCheckResult = new ArrayList<KYCShareholderCheckResult>();

    @SerializedName("accountHolder")
    private KYCCheckResult accountHolder;

    @SerializedName("bankAccounts")
    private List<KYCBankAccountCheckResult> bankAccountCheckResult = new ArrayList<KYCBankAccountCheckResult>();

    public List<KYCShareholderCheckResult> getShareholderCheckResult() {
        return shareholderCheckResult;
    }

    public void setShareholderCheckResult(List<KYCShareholderCheckResult> shareholderCheckResult) {
        this.shareholderCheckResult = shareholderCheckResult;
    }

    public KYCCheckResult getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(KYCCheckResult accountHolder) {
        this.accountHolder = accountHolder;
    }

    public List<KYCBankAccountCheckResult> getBankAccountCheckResult() {
        return bankAccountCheckResult;
    }

    public void setBankAccountCheckResult(List<KYCBankAccountCheckResult> bankAccountCheckResult) {
        this.bankAccountCheckResult = bankAccountCheckResult;
    }
}

