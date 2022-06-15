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

import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * UpdatePayoutScheduleRequest
 */
public class UpdatePayoutScheduleRequest {
    /**
     * schedule interval
     */
    public enum ScheduleEnum {
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

        private final String value;

        ScheduleEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("schedule")
    private ScheduleEnum schedule = null;

    @SerializedName("reason")
    private String reason = null;

    /**
     * behavior for the current payout period (relevant if the schedule already exists)
     */
    public enum ActionEnum {
        @SerializedName("CLOSE")
        CLOSE("CLOSE"),

        @SerializedName("NOTHING")
        NOTHING("NOTHING"),

        @SerializedName("UPDATE")
        UPDATE("UPDATE");

        private final String value;

        ActionEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("action")
    private ActionEnum action = null;

    public UpdatePayoutScheduleRequest schedule(ScheduleEnum schedule) {
        this.schedule = schedule;
        return this;
    }

    /**
     * schedule interval
     *
     * @return schedule
     **/
    public ScheduleEnum getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleEnum schedule) {
        this.schedule = schedule;
    }

    public UpdatePayoutScheduleRequest reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * reason of updating the schedule
     *
     * @return reason
     **/
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public UpdatePayoutScheduleRequest action(ActionEnum action) {
        this.action = action;
        return this;
    }

    /**
     * behavior for the current payout period (relevant if the schedule already exists)
     *
     * @return action
     **/
    public ActionEnum getAction() {
        return action;
    }

    public void setAction(ActionEnum action) {
        this.action = action;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdatePayoutScheduleRequest updatePayoutScheduleRequest = (UpdatePayoutScheduleRequest) o;
        return Objects.equals(this.schedule, updatePayoutScheduleRequest.schedule) && Objects.equals(this.reason, updatePayoutScheduleRequest.reason) && Objects.equals(this.action,
                                                                                                                                                                        updatePayoutScheduleRequest.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schedule, reason, action);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdatePayoutScheduleRequest {\n");

        sb.append("    schedule: ").append(toIndentedString(schedule)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}

