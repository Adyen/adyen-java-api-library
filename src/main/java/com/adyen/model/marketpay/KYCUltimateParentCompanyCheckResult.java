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
 * KYCUltimateParentCompanyCheckResult
 */
public class KYCUltimateParentCompanyCheckResult {
    @SerializedName("checks")
    private List<KYCCheckStatusData> checks = new ArrayList<>();

    @SerializedName("ultimateParentCompanyCode")
    private String ultimateParentCompanyCode = null;

    public KYCUltimateParentCompanyCheckResult checkStatusData(List<KYCCheckStatusData> checkStatusData) {
        this.checks = checkStatusData;
        return this;
    }

    public KYCUltimateParentCompanyCheckResult addCheckStatusDataItem(KYCCheckStatusData checkStatusDataItem) {
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

    public KYCUltimateParentCompanyCheckResult ultimateParentCompanyCode(String ultimateParentCompanyCode) {
        this.ultimateParentCompanyCode = ultimateParentCompanyCode;
        return this;
    }

    /**
     * The code of the Ultimate Parent Company to which the check applies.
     *
     * @return ultimateParentCompanyCode
     **/
    public String getUltimateParentCompanyCode() {
        return ultimateParentCompanyCode;
    }

    public void setUltimateParentCompanyCode(String ultimateParentCompanyCode) {
        this.ultimateParentCompanyCode = ultimateParentCompanyCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KYCUltimateParentCompanyCheckResult kYCUltimateParentCompanyCheckResult = (KYCUltimateParentCompanyCheckResult) o;
        return Objects.equals(this.checks, kYCUltimateParentCompanyCheckResult.checks) &&
                Objects.equals(this.ultimateParentCompanyCode, kYCUltimateParentCompanyCheckResult.ultimateParentCompanyCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checks, ultimateParentCompanyCode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KYCUltimateParentCompanyCheckResult {\n");

        sb.append("    checks: ").append(toIndentedString(checks)).append("\n");
        sb.append("    ultimateParentCompanyCode: ").append(toIndentedString(ultimateParentCompanyCode)).append("\n");
        sb.append("}");
        return sb.toString();
    }



}

