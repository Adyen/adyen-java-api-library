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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * TestNotificationConfigurationRequest
 */
public class TestNotificationConfigurationRequest {
    @SerializedName("notificationId")
    private Long notificationId = null;

    /**
     * Gets or Sets eventTypes
     */
    public enum EventTypesEnum {
        @SerializedName("ACCOUNT_CLOSED")
        ACCOUNT_CLOSED("ACCOUNT_CLOSED"),

        @SerializedName("ACCOUNT_CREATED")
        ACCOUNT_CREATED("ACCOUNT_CREATED"),

        @SerializedName("ACCOUNT_FUNDS_BELOW_THRESHOLD")
        ACCOUNT_FUNDS_BELOW_THRESHOLD("ACCOUNT_FUNDS_BELOW_THRESHOLD"),

        @SerializedName("ACCOUNT_HOLDER_CREATED")
        ACCOUNT_HOLDER_CREATED("ACCOUNT_HOLDER_CREATED"),

        @SerializedName("ACCOUNT_HOLDER_LIMIT_REACHED")
        ACCOUNT_HOLDER_LIMIT_REACHED("ACCOUNT_HOLDER_LIMIT_REACHED"),

        @SerializedName("ACCOUNT_HOLDER_PAYOUT")
        ACCOUNT_HOLDER_PAYOUT("ACCOUNT_HOLDER_PAYOUT"),

        @SerializedName("ACCOUNT_HOLDER_STATUS_CHANGE")
        ACCOUNT_HOLDER_STATUS_CHANGE("ACCOUNT_HOLDER_STATUS_CHANGE"),

        @SerializedName("ACCOUNT_HOLDER_STORE_STATUS_CHANGE")
        ACCOUNT_HOLDER_STORE_STATUS_CHANGE("ACCOUNT_HOLDER_STORE_STATUS_CHANGE"),

        @SerializedName("ACCOUNT_HOLDER_UPCOMING_DEADLINE")
        ACCOUNT_HOLDER_UPCOMING_DEADLINE("ACCOUNT_HOLDER_UPCOMING_DEADLINE"),

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

        EventTypesEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("eventTypes")
    private List<EventTypesEnum> eventTypes = new ArrayList<>();

    public TestNotificationConfigurationRequest notificationId(Long notificationId) {
        this.notificationId = notificationId;
        return this;
    }

    /**
     * Id of the notification configuration
     *
     * @return notificationId
     **/
    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public TestNotificationConfigurationRequest eventTypes(List<EventTypesEnum> eventTypes) {
        this.eventTypes = eventTypes;
        return this;
    }

    public TestNotificationConfigurationRequest addEventTypesItem(EventTypesEnum eventTypesItem) {
        this.eventTypes.add(eventTypesItem);
        return this;
    }

    /**
     * Event types to test. If not specified, then all the configured event types will be tested
     *
     * @return eventTypes
     **/
    public List<EventTypesEnum> getEventTypes() {
        return eventTypes;
    }

    public void setEventTypes(List<EventTypesEnum> eventTypes) {
        this.eventTypes = eventTypes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TestNotificationConfigurationRequest testNotificationConfigurationRequest = (TestNotificationConfigurationRequest) o;
        return Objects.equals(this.notificationId, testNotificationConfigurationRequest.notificationId) && Objects.equals(this.eventTypes, testNotificationConfigurationRequest.eventTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationId, eventTypes);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TestNotificationConfigurationRequest {\n");

        sb.append("    notificationId: ").append(toIndentedString(notificationId)).append("\n");
        sb.append("    eventTypes: ").append(toIndentedString(eventTypes)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}

