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
 * KYCShareholderCheckResult
 */
public class KYCShareholderCheckResult {
    @SerializedName("checks")
    private List<KYCCheckStatusData> checks = new ArrayList<>();

    @SerializedName("shareholderCode")
    private String shareholderCode = null;

    public KYCShareholderCheckResult checkStatusData(List<KYCCheckStatusData> checkStatusData) {
        this.checks = checkStatusData;
        return this;
    }

    public KYCShareholderCheckResult addCheckStatusDataItem(KYCCheckStatusData checkStatusDataItem) {
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

    public KYCShareholderCheckResult shareholderCode(String shareholderCode) {
        this.shareholderCode = shareholderCode;
        return this;
    }

    /**
     * Get shareholderCode
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KYCShareholderCheckResult kyCShareholderCheckResult = (KYCShareholderCheckResult) o;
        return Objects.equals(this.checks, kyCShareholderCheckResult.checks) && Objects.equals(this.shareholderCode, kyCShareholderCheckResult.shareholderCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checks, shareholderCode);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KYCShareholderCheckResult {\n");

        sb.append("    checks: ").append(toIndentedString(checks)).append("\n");
        sb.append("    shareholderCode: ").append(toIndentedString(shareholderCode)).append("\n");
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

