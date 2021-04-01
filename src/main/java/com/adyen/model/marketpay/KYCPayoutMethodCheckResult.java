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

public class KYCPayoutMethodCheckResult {
    @SerializedName("checks")
    private List<KYCCheckStatusData> checks = new ArrayList<>();

    @SerializedName("payoutMethodCode")
    private String payoutMethodCode = null;

    /**
     * A list of the checks and their statuses.
     *
     * @return checks
     */
    public List<KYCCheckStatusData> getChecks() {
        return checks;
    }

    public void setChecks(List<KYCCheckStatusData> checks) {
        this.checks = checks;
    }

    public KYCPayoutMethodCheckResult addChecksItem(KYCCheckStatusData checkItem) {
        if (this.checks == null) {
            this.checks = new ArrayList<>();
        }
        this.checks.add(checkItem);
        return this;
    }

    /**
     * The unique ID of the payout method to which the check applies.
     *
     * @return payoutMethodCode
     */
    public String getPayoutMethodCode() {
        return payoutMethodCode;
    }

    public void setPayoutMethodCode(String payoutMethodCode) {
        this.payoutMethodCode = payoutMethodCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        KYCPayoutMethodCheckResult kycPayoutMethodCheckResult = (KYCPayoutMethodCheckResult) o;
        return Objects.equals(this.checks, kycPayoutMethodCheckResult.checks) &&
                Objects.equals(this.payoutMethodCode, kycPayoutMethodCheckResult.payoutMethodCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checks, payoutMethodCode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KYCPayoutMethodCheckResult {\n");

        sb.append("    checks: ").append(toIndentedString(checks)).append("\n");
        sb.append("    payoutMethodCode: ").append(toIndentedString(payoutMethodCode)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
