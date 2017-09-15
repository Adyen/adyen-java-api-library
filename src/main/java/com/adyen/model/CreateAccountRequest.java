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
 * CreateAccountRequest
 */
public class CreateAccountRequest {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("payoutScheduleReason")
    private String payoutScheduleReason = null;

    /**
     * interval of the desired payout schedule
     */
    public enum PayoutScheduleEnum {
        @SerializedName("DAILY")
        DAILY("DAILY"),

        @SerializedName("DEFAULT")
        DEFAULT("DEFAULT"),

        @SerializedName("HOLD")
        HOLD("HOLD"),

        @SerializedName("MONTHLY")
        MONTHLY("MONTHLY"),

        @SerializedName("WEEKLY")
        WEEKLY("WEEKLY");

        private String value;

        PayoutScheduleEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("payoutSchedule")
    private PayoutScheduleEnum payoutSchedule = null;

    public CreateAccountRequest accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * code of the account holder, whose account has to be created
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public CreateAccountRequest payoutScheduleReason(String payoutScheduleReason) {
        this.payoutScheduleReason = payoutScheduleReason;
        return this;
    }

    /**
     * reason for creating the schedule
     *
     * @return payoutScheduleReason
     **/
    public String getPayoutScheduleReason() {
        return payoutScheduleReason;
    }

    public void setPayoutScheduleReason(String payoutScheduleReason) {
        this.payoutScheduleReason = payoutScheduleReason;
    }

    public CreateAccountRequest payoutSchedule(PayoutScheduleEnum payoutSchedule) {
        this.payoutSchedule = payoutSchedule;
        return this;
    }

    /**
     * interval of the desired payout schedule
     *
     * @return payoutSchedule
     **/
    public PayoutScheduleEnum getPayoutSchedule() {
        return payoutSchedule;
    }

    public void setPayoutSchedule(PayoutScheduleEnum payoutSchedule) {
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
        CreateAccountRequest createAccountRequest = (CreateAccountRequest) o;
        return Objects.equals(this.accountHolderCode, createAccountRequest.accountHolderCode) && Objects.equals(this.payoutScheduleReason, createAccountRequest.payoutScheduleReason) && Objects.equals(
                this.payoutSchedule,
                createAccountRequest.payoutSchedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, payoutScheduleReason, payoutSchedule);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateAccountRequest {\n");

        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    payoutScheduleReason: ").append(toIndentedString(payoutScheduleReason)).append("\n");
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

