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
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * KYCCheckResult
 */
public class KYCCheckResult {
    @SerializedName("checks")
    private List<KYCCheckStatusData> checks = new ArrayList<>();

    public KYCCheckResult checkStatusData(List<KYCCheckStatusData> checkStatusData) {
        this.checks = checkStatusData;
        return this;
    }

    public KYCCheckResult addCheckStatusDataItem(KYCCheckStatusData checkStatusDataItem) {
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
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KYCCheckResult kyCCheckResult = (KYCCheckResult) o;
        return Objects.equals(this.checks, kyCCheckResult.checks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checks);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KYCCheckResult {\n");

        sb.append("    checks: ").append(toIndentedString(checks)).append("\n");
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

