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

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Objects;

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

        private String value;

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
        if (Objects.isNull(o) || getClass() != o.getClass()) {
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
        sb.append("class AccountEvent {").append(TextConstants.LINE_BREAK);

        sb.append("    reason: ").append(Util.toIndentedString(reason)).append(TextConstants.LINE_BREAK);
        sb.append("    resolvedByStateType: ").append(Util.toIndentedString(resolvedByStateType)).append(TextConstants.LINE_BREAK);
        sb.append("    executionDate: ").append(Util.toIndentedString(executionDate)).append(TextConstants.LINE_BREAK);
        sb.append("    event: ").append(Util.toIndentedString(event)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }



}

