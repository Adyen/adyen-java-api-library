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

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.adyen.constants.TextConstants.LINE_BREAK;
import static com.adyen.util.Util.toIndentedString;

/**
 * KYCBankAccountCheckResult
 */
public class KYCBankAccountCheckResult {
    @SerializedName("bankAccountUUID")
    private String bankAccountUUID = null;

    @SerializedName("checks")
    private List<KYCCheckStatusData> checks = new ArrayList<>();

    public KYCBankAccountCheckResult bankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
        return this;
    }

    /**
     * Get bankAccountUUID
     *
     * @return bankAccountUUID
     **/
    public String getBankAccountUUID() {
        return bankAccountUUID;
    }

    public void setBankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
    }

    public KYCBankAccountCheckResult checkStatusData(List<KYCCheckStatusData> checkStatusData) {
        this.checks = checkStatusData;
        return this;
    }

    public KYCBankAccountCheckResult addCheckStatusDataItem(KYCCheckStatusData checkStatusDataItem) {
        this.checks.add(checkStatusDataItem);
        return this;
    }

    /**
     * Get checks
     *
     * @return checks
     **/
    public List<KYCCheckStatusData> getChecks() {
        return checks;
    }

    public void setChecks(List<KYCCheckStatusData> checks) {
        this.checks = checks;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        KYCBankAccountCheckResult kyCBankAccountCheckResult = (KYCBankAccountCheckResult) o;
        return Objects.equals(this.bankAccountUUID, kyCBankAccountCheckResult.bankAccountUUID) && Objects.equals(this.checks, kyCBankAccountCheckResult.checks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankAccountUUID, checks);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KYCBankAccountCheckResult {").append(LINE_BREAK);

        sb.append("    bankAccountUUID: ").append(toIndentedString(bankAccountUUID)).append(LINE_BREAK);
        sb.append("    checks: ").append(toIndentedString(checks)).append(LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }



}

