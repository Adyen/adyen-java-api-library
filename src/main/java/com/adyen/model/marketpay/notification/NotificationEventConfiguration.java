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
import com.google.gson.annotations.SerializedName;

import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * NotificationEventConfiguration
 */
public class NotificationEventConfiguration {
    /**
     * specifies if the notification has to be sent in case an event of the mentioned type has occurred, or of events other than event of the mentioned type have occurred
     */
    public enum IncludeModeEnum {
        @SerializedName("EXCLUDE")
        EXCLUDE("EXCLUDE"),

        @SerializedName("INCLUDE")
        INCLUDE("INCLUDE");

        @JsonValue
        private final String value;

        IncludeModeEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("includeMode")
    private IncludeModeEnum includeMode = null;

    /**
     * type of the events triggering the notification
     */
    public enum EventTypeEnum {
        @SerializedName("ACCOUNT_CLOSED")
        ACCOUNT_CLOSED("ACCOUNT_CLOSED"),

        @SerializedName("ACCOUNT_FUNDS_BELOW_THRESHOLD")
        ACCOUNT_FUNDS_BELOW_THRESHOLD("ACCOUNT_FUNDS_BELOW_THRESHOLD"),

        @SerializedName("ACCOUNT_HOLDER_STORE_STATUS_CHANGE")
        ACCOUNT_HOLDER_STORE_STATUS_CHANGE("ACCOUNT_HOLDER_STORE_STATUS_CHANGE"),

        @SerializedName("ACCOUNT_HOLDER_UPCOMING_DEADLINE")
        ACCOUNT_HOLDER_UPCOMING_DEADLINE("ACCOUNT_HOLDER_UPCOMING_DEADLINE"),

        @SerializedName("ACCOUNT_CREATED")
        ACCOUNT_CREATED("ACCOUNT_CREATED"),

        @SerializedName("ACCOUNT_HOLDER_CREATED")
        ACCOUNT_HOLDER_CREATED("ACCOUNT_HOLDER_CREATED"),

        @SerializedName("ACCOUNT_HOLDER_LIMIT_REACHED")
        ACCOUNT_HOLDER_LIMIT_REACHED("ACCOUNT_HOLDER_LIMIT_REACHED"),

        @SerializedName("ACCOUNT_HOLDER_PAYOUT")
        ACCOUNT_HOLDER_PAYOUT("ACCOUNT_HOLDER_PAYOUT"),

        @SerializedName("ACCOUNT_HOLDER_STATUS_CHANGE")
        ACCOUNT_HOLDER_STATUS_CHANGE("ACCOUNT_HOLDER_STATUS_CHANGE"),

        @SerializedName("ACCOUNT_HOLDER_UPDATED")
        ACCOUNT_HOLDER_UPDATED("ACCOUNT_HOLDER_UPDATED"),

        @SerializedName("ACCOUNT_HOLDER_VERIFICATION")
        ACCOUNT_HOLDER_VERIFICATION("ACCOUNT_HOLDER_VERIFICATION"),

        @SerializedName("ACCOUNT_UPDATED")
        ACCOUNT_UPDATED("ACCOUNT_UPDATED"),

        @SerializedName("BENEFICIARY_SETUP")
        BENEFICIARY_SETUP("BENEFICIARY_SETUP"),

        @SerializedName("COMPENSATE_NEGATIVE_BALANCE")
        COMPENSATE_NEGATIVE_BALANCE("COMPENSATE_NEGATIVE_BALANCE"),

        @SerializedName("DIRECT_DEBIT_INITIATED")
        DIRECT_DEBIT_INITIATED("DIRECT_DEBIT_INITIATED"),

        @SerializedName("PAYMENT_FAILURE")
        PAYMENT_FAILURE("PAYMENT_FAILURE"),

        @SerializedName("REFUND_FUNDS_TRANSFER")
        REFUND_FUNDS_TRANSFER("REFUND_FUNDS_TRANSFER"),

        @SerializedName("REPORT_AVAILABLE")
        REPORT_AVAILABLE("REPORT_AVAILABLE"),

        @SerializedName("SCHEDULED_REFUNDS")
        SCHEDULED_REFUNDS("SCHEDULED_REFUNDS"),

        @SerializedName("TRANSFER_FUNDS")
        TRANSFER_FUNDS("TRANSFER_FUNDS"),

        @SerializedName("TRANSFER_NOT_PAIDOUT_TRANSFERS")
        TRANSFER_NOT_PAIDOUT_TRANSFERS("TRANSFER_NOT_PAIDOUT_TRANSFERS");

        @JsonValue
        private final String value;

        EventTypeEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("eventType")
    private EventTypeEnum eventType = null;

    public NotificationEventConfiguration includeMode(IncludeModeEnum includeMode) {
        this.includeMode = includeMode;
        return this;
    }

    /**
     * specifies if the notification has to be sent in case an event of the mentioned type has occurred, or of events other than event of the mentioned type have occurred
     *
     * @return includeMode
     **/
    public IncludeModeEnum getIncludeMode() {
        return includeMode;
    }

    public void setIncludeMode(IncludeModeEnum includeMode) {
        this.includeMode = includeMode;
    }

    public NotificationEventConfiguration eventType(EventTypeEnum eventType) {
        this.eventType = eventType;
        return this;
    }

    /**
     * type of the events triggering the notification
     *
     * @return eventType
     **/
    public EventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(EventTypeEnum eventType) {
        this.eventType = eventType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NotificationEventConfiguration notificationEventConfiguration = (NotificationEventConfiguration) o;
        return Objects.equals(this.includeMode, notificationEventConfiguration.includeMode) && Objects.equals(this.eventType, notificationEventConfiguration.eventType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(includeMode, eventType);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NotificationEventConfiguration {\n");

        sb.append("    includeMode: ").append(toIndentedString(includeMode)).append("\n");
        sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}

