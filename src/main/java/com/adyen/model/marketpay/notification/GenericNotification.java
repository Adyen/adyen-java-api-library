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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.marketpay.notification;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class GenericNotification {
    public enum EventTypeEnum {
        @SerializedName("ACCOUNT_CREATED")
        ACCOUNT_CREATED("ACCOUNT_CREATED"),

        @SerializedName("ACCOUNT_CLOSED")
        ACCOUNT_CLOSED("ACCOUNT_CLOSED"),

        @SerializedName("ACCOUNT_UPDATED")
        ACCOUNT_UPDATED("ACCOUNT_UPDATED"),

        @SerializedName("ACCOUNT_FUNDS_BELOW_THRESHOLD")
        ACCOUNT_FUNDS_BELOW_THRESHOLD("ACCOUNT_FUNDS_BELOW_THRESHOLD"),

        @SerializedName("ACCOUNT_HOLDER_CREATED")
        ACCOUNT_HOLDER_CREATED("ACCOUNT_HOLDER_CREATED"),

        @SerializedName("ACCOUNT_HOLDER_PAYOUT")
        ACCOUNT_HOLDER_PAYOUT("ACCOUNT_HOLDER_PAYOUT"),

        @SerializedName("ACCOUNT_HOLDER_STATUS_CHANGE")
        ACCOUNT_HOLDER_STATUS_CHANGE("ACCOUNT_HOLDER_STATUS_CHANGE"),

        @SerializedName("ACCOUNT_HOLDER_UPDATED")
        ACCOUNT_HOLDER_UPDATED("ACCOUNT_HOLDER_UPDATED"),

        @SerializedName("ACCOUNT_HOLDER_VERIFICATION")
        ACCOUNT_HOLDER_VERIFICATION("ACCOUNT_HOLDER_VERIFICATION"),

        @SerializedName("ACCOUNT_HOLDER_STORE_STATUS_CHANGE")
        ACCOUNT_HOLDER_STORE_STATUS_CHANGE("ACCOUNT_HOLDER_STORE_STATUS_CHANGE"),

        @SerializedName("ACCOUNT_HOLDER_UPCOMING_DEADLINE")
        ACCOUNT_HOLDER_UPCOMING_DEADLINE("ACCOUNT_HOLDER_UPCOMING_DEADLINE"),

        @SerializedName("BENEFICIARY_SETUP")
        BENEFICIARY_SETUP("BENEFICIARY_SETUP"),

        @SerializedName("COMPENSATE_NEGATIVE_BALANCE")
        COMPENSATE_NEGATIVE_BALANCE("COMPENSATE_NEGATIVE_BALANCE"),

        @SerializedName("PAYMENT_FAILURE")
        PAYMENT_FAILURE("PAYMENT_FAILURE"),

        @SerializedName("REPORT_AVAILABLE")
        REPORT_AVAILABLE("REPORT_AVAILABLE"),

        @SerializedName("SCHEDULED_REFUNDS")
        SCHEDULED_REFUNDS("SCHEDULED_REFUNDS"),

        @SerializedName("TRANSFER_FUNDS")
        TRANSFER_FUNDS("TRANSFER_FUNDS"),

        @SerializedName("DIRECT_DEBIT_INITIATED")
        DIRECT_DEBIT_INITIATED("DIRECT_DEBIT_INITIATED"),

        @SerializedName("PAYOUT_CONFIRMED")
        PAYOUT_CONFIRMED("PAYOUT_CONFIRMED"),

        @SerializedName("REFUND_FUNDS_TRANSFER")
        REFUND_FUNDS_TRANSFER("REFUND_FUNDS_TRANSFER");

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
    private EventTypeEnum eventType;

    @SerializedName("eventDate")
    private Date eventDate;

    @SerializedName("executingUserKey")
    private String executingUserKey;

    @SerializedName("live")
    private String live;

    @SerializedName("pspReference")
    private String pspReference;

    public EventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(EventTypeEnum eventType) {
        this.eventType = eventType;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getExecutingUserKey() {
        return executingUserKey;
    }

    public void setExecutingUserKey(String executingUserKey) {
        this.executingUserKey = executingUserKey;
    }

    public String getLive() {
        return live;
    }

    public void setLive(String live) {
        this.live = live;
    }

    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    @Override
    public String toString() {
        return "GenericNotification{" + "eventType=" + eventType + "eventDate=" + eventDate + ", executingUserKey='" + executingUserKey + '\'' + ", live='" + live + '\'' + ", pspReference='" + pspReference + '\'' + '}';
    }
}
