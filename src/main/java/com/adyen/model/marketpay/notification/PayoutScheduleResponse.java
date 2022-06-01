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

package com.adyen.model.marketpay.notification;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * PayoutScheduleResponse
 */

public class PayoutScheduleResponse {
    @SerializedName("nextScheduledPayout")
    private Date nextScheduledPayout = null;

    /**
     * The payout schedule of the account. &gt;Permitted values: &#x60;DEFAULT&#x60;, &#x60;HOLD&#x60;, &#x60;DAILY&#x60;, &#x60;WEEKLY&#x60;, &#x60;MONTHLY&#x60;.
     */
    @JsonAdapter(ScheduleEnum.Adapter.class)
    public enum ScheduleEnum {
        BIWEEKLY_ON_1ST_AND_15TH_AT_MIDNIGHT("BIWEEKLY_ON_1ST_AND_15TH_AT_MIDNIGHT"),
        BIWEEKLY_ON_1ST_AND_15TH_AT_NOON("BIWEEKLY_ON_1ST_AND_15TH_AT_NOON"),
        DAILY("DAILY"),
        DAILY_6PM("DAILY_6PM"),
        DAILY_AU("DAILY_AU"),
        DAILY_EU("DAILY_EU"),
        DAILY_US("DAILY_US"),
        DEFAULT("DEFAULT"),
        EVERY_6_HOURS_FROM_MIDNIGHT("EVERY_6_HOURS_FROM_MIDNIGHT"),
        HOLD("HOLD"),
        MONTHLY("MONTHLY"),
        WEEKLY("WEEKLY"),
        WEEKLY_ON_TUE_FRI_MIDNIGHT("WEEKLY_ON_TUE_FRI_MIDNIGHT"),
        YEARLY("YEARLY");

        @JsonValue
        private final String value;

        ScheduleEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static ScheduleEnum fromValue(String text) {
            for (ScheduleEnum b : ScheduleEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<ScheduleEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ScheduleEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public ScheduleEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return ScheduleEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("schedule")
    private ScheduleEnum schedule = null;

    public PayoutScheduleResponse nextScheduledPayout(Date nextScheduledPayout) {
        this.nextScheduledPayout = nextScheduledPayout;
        return this;
    }

    /**
     * The date of the next scheduled payout.
     *
     * @return nextScheduledPayout
     **/
    public Date getNextScheduledPayout() {
        return nextScheduledPayout;
    }

    public void setNextScheduledPayout(Date nextScheduledPayout) {
        this.nextScheduledPayout = nextScheduledPayout;
    }

    public PayoutScheduleResponse schedule(ScheduleEnum schedule) {
        this.schedule = schedule;
        return this;
    }

    /**
     * The payout schedule of the account. &gt;Permitted values: &#x60;DEFAULT&#x60;, &#x60;HOLD&#x60;, &#x60;DAILY&#x60;, &#x60;WEEKLY&#x60;, &#x60;MONTHLY&#x60;.
     *
     * @return schedule
     **/
    public ScheduleEnum getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleEnum schedule) {
        this.schedule = schedule;
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
        return Objects.equals(this.nextScheduledPayout, payoutScheduleResponse.nextScheduledPayout) &&
                Objects.equals(this.schedule, payoutScheduleResponse.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nextScheduledPayout, schedule);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PayoutScheduleResponse {\n");

        sb.append("    nextScheduledPayout: ").append(toIndentedString(nextScheduledPayout)).append("\n");
        sb.append("    schedule: ").append(toIndentedString(schedule)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
