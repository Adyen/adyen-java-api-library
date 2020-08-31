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
package com.adyen.model.testcard;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateTestCardRangesRequest {
    @SerializedName("accountCode")
    private String accountCode = null;

    @SerializedName("accountTypeCode")
    private AccountTypeCode accountTypeCode = null;

    @SerializedName("testCardRanges")
    private List<TestCardRange> testCardRanges = null;

    public enum AccountTypeCode {
        Company,
        MerchantAccount
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public AccountTypeCode getAccountTypeCode() {
        return accountTypeCode;
    }

    public void setAccountTypeCode(AccountTypeCode accountTypeCode) {
        this.accountTypeCode = accountTypeCode;
    }

    public List<TestCardRange> getTestCardRanges() {
        return testCardRanges;
    }

    public void setTestCardRanges(List<TestCardRange> testCardRanges) {
        this.testCardRanges = testCardRanges;
    }

    @Override
    public String toString() {
        return "CreateTestCardRangesRequest{" +
                "accountCode='" + accountCode + '\'' +
                ", accountTypeCode=" + accountTypeCode +
                ", testCardRanges=" + testCardRanges +
                '}';
    }
}
