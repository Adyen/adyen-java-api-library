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

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * UpdateAccountRequest
 */
public class UpdateAccountRequest {
    @SerializedName("accountCode")
    private String accountCode = null;

    @SerializedName("payoutSchedule")
    private UpdatePayoutScheduleRequest payoutSchedule = null;

    public UpdateAccountRequest accountCode(String accountCode) {
        this.accountCode = accountCode;
        return this;
    }

    /**
     * code of virtual account
     *
     * @return accountCode
     **/
    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public UpdateAccountRequest payoutSchedule(UpdatePayoutScheduleRequest payoutSchedule) {
        this.payoutSchedule = payoutSchedule;
        return this;
    }

    /**
     * parameters of the desired payout schedule
     *
     * @return payoutSchedule
     **/
    public UpdatePayoutScheduleRequest getPayoutSchedule() {
        return payoutSchedule;
    }

    public void setPayoutSchedule(UpdatePayoutScheduleRequest payoutSchedule) {
        this.payoutSchedule = payoutSchedule;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateAccountRequest updateAccountRequest = (UpdateAccountRequest) o;
        return Objects.equals(this.accountCode, updateAccountRequest.accountCode) && Objects.equals(this.payoutSchedule, updateAccountRequest.payoutSchedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountCode, payoutSchedule);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateAccountRequest {\n");

        sb.append("    accountCode: ").append(toIndentedString(accountCode)).append("\n");
        sb.append("    payoutSchedule: ").append(toIndentedString(payoutSchedule)).append("\n");
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

