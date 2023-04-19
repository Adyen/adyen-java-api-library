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
package com.adyen.model.marketpay;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * KYCSignatoryCheckResult
 */
public class KYCSignatoryCheckResult {
    @SerializedName("checks")
    private List<KYCCheckStatusData> checks = new ArrayList<>();

    @SerializedName("signatoryCode")
    private String signatoryCode = null;

    public KYCSignatoryCheckResult checkStatusData(List<KYCCheckStatusData> checkStatusData) {
        this.checks = checkStatusData;
        return this;
    }

    public KYCSignatoryCheckResult addCheckStatusDataItem(KYCCheckStatusData checkStatusDataItem) {
        this.checks.add(checkStatusDataItem);
        return this;
    }

    /**
     * A list of the checks and their statuses.
     *
     * @return checks
     **/
    public List<KYCCheckStatusData> getChecks() {
        return checks;
    }

    public void setChecks(List<KYCCheckStatusData> checks) {
        this.checks = checks;
    }

    public KYCSignatoryCheckResult signatoryCode(String signatoryCode) {
        this.signatoryCode = signatoryCode;
        return this;
    }

    /**
     * The code of the signatory to which the check applies.
     *
     * @return signatoryCode
     **/
    public String getSignatoryCode() {
        return signatoryCode;
    }

    public void setSignatoryCode(String signatoryCode) {
        this.signatoryCode = signatoryCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KYCSignatoryCheckResult kyCShareholderCheckResult = (KYCSignatoryCheckResult) o;
        return Objects.equals(this.checks, kyCShareholderCheckResult.checks) && Objects.equals(this.signatoryCode, kyCShareholderCheckResult.signatoryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checks, signatoryCode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KYCSignatoryCheckResult {\n");
        sb.append("    checks: ").append(toIndentedString(checks)).append("\n");
        sb.append("    signatoryCode: ").append(toIndentedString(signatoryCode)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}

