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

import java.util.Date;
import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * PayoutScheduleResponse
 */
public class PayoutScheduleResponse {
    /**
     * Gets or Sets schedule
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

    @SerializedName("nextScheduledPayout")
    private Date nextScheduledPayout = null;

    public PayoutScheduleResponse schedule(ScheduleEnum schedule) {
        this.schedule = schedule;
        return this;
    }

    /**
     * Get schedule
     *
     * @return schedule
     **/
    public ScheduleEnum getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleEnum schedule) {
        this.schedule = schedule;
    }

    public PayoutScheduleResponse nextScheduledPayout(Date nextScheduledPayout) {
        this.nextScheduledPayout = nextScheduledPayout;
        return this;
    }

    /**
     * Get nextScheduledPayout
     *
     * @return nextScheduledPayout
     **/
    public Date getNextScheduledPayout() {
        return nextScheduledPayout;
    }

    public void setNextScheduledPayout(Date nextScheduledPayout) {
        this.nextScheduledPayout = nextScheduledPayout;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PayoutScheduleResponse payoutScheduleResponse = (PayoutScheduleResponse) o;
        return Objects.equals(this.schedule, payoutScheduleResponse.schedule) && Objects.equals(this.nextScheduledPayout, payoutScheduleResponse.nextScheduledPayout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schedule, nextScheduledPayout);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PayoutScheduleResponse {\n");

        sb.append("    schedule: ").append(toIndentedString(schedule)).append("\n");
        sb.append("    nextScheduledPayout: ").append(toIndentedString(nextScheduledPayout)).append("\n");
        sb.append("}");
        return sb.toString();
    }



}

