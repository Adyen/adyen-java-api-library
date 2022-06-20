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

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * AccountEvent
 */
public class AccountEvent {
    @SerializedName("reason")
    private String reason = null;

    @SerializedName("resolvedByStateType")
    private String resolvedByStateType = null;

    @SerializedName("executionDate")
    private Date executionDate = null;

    /**
     * Gets or Sets event
     */
    public enum EventEnum {
        @SerializedName("InactivateAccount")
        INACTIVATEACCOUNT("InactivateAccount"),

        @SerializedName("RefundNotPaidOutTransfers")
        REFUNDNOTPAIDOUTTRANSFERS("RefundNotPaidOutTransfers");

        @JsonValue
        private final String value;

        EventEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("event")
    private EventEnum event = null;

    public AccountEvent reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Get reason
     *
     * @return reason
     **/
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public AccountEvent resolvedByStateType(String resolvedByStateType) {
        this.resolvedByStateType = resolvedByStateType;
        return this;
    }

    /**
     * Get resolvedByStateType
     *
     * @return resolvedByStateType
     **/
    public String getResolvedByStateType() {
        return resolvedByStateType;
    }

    public void setResolvedByStateType(String resolvedByStateType) {
        this.resolvedByStateType = resolvedByStateType;
    }

    public AccountEvent executionDate(Date executionDate) {
        this.executionDate = executionDate;
        return this;
    }

    /**
     * Get executionDate
     *
     * @return executionDate
     **/
    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    public AccountEvent event(EventEnum event) {
        this.event = event;
        return this;
    }

    /**
     * Get event
     *
     * @return event
     **/
    public EventEnum getEvent() {
        return event;
    }

    public void setEvent(EventEnum event) {
        this.event = event;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountEvent accountEvent = (AccountEvent) o;
        return Objects.equals(this.reason, accountEvent.reason)
                && Objects.equals(this.resolvedByStateType, accountEvent.resolvedByStateType)
                && Objects.equals(this.executionDate,
                                  accountEvent.executionDate)
                && Objects.equals(this.event, accountEvent.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reason, resolvedByStateType, executionDate, event);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountEvent {\n");

        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    resolvedByStateType: ").append(toIndentedString(resolvedByStateType)).append("\n");
        sb.append("    executionDate: ").append(toIndentedString(executionDate)).append("\n");
        sb.append("    event: ").append(toIndentedString(event)).append("\n");
        sb.append("}");
        return sb.toString();
    }



}

