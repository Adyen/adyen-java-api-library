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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * AccountHolderStatus
 */
public class AccountHolderStatus {
    @SerializedName("processingState")
    private AccountProcessingState processingState = null;

    @SerializedName("statusReason")
    private String statusReason = null;

    @SerializedName("payoutState")
    private AccountPayoutState payoutState = null;

    /**
     * status
     */
    public enum StatusEnum {
        @SerializedName("Active")
        ACTIVE("Active"),

        @SerializedName("Closed")
        CLOSED("Closed"),

        @SerializedName("Inactive")
        INACTIVE("Inactive"),

        @SerializedName("Suspended")
        SUSPENDED("Suspended");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("status")
    private StatusEnum status = null;

    @SerializedName("accountEvents")
    private List<AccountEvent> accountEvents = new ArrayList<>();

    public AccountHolderStatus processingState(AccountProcessingState processingState) {
        this.processingState = processingState;
        return this;
    }

    /**
     * current processing tier
     *
     * @return processingState
     **/
    public AccountProcessingState getProcessingState() {
        return processingState;
    }

    public void setProcessingState(AccountProcessingState processingState) {
        this.processingState = processingState;
    }

    public AccountHolderStatus statusReason(String statusReason) {
        this.statusReason = statusReason;
        return this;
    }

    /**
     * status reason
     *
     * @return statusReason
     **/
    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public AccountHolderStatus payoutState(AccountPayoutState payoutState) {
        this.payoutState = payoutState;
        return this;
    }

    /**
     * payout state
     *
     * @return payoutState
     **/
    public AccountPayoutState getPayoutState() {
        return payoutState;
    }

    public void setPayoutState(AccountPayoutState payoutState) {
        this.payoutState = payoutState;
    }

    public AccountHolderStatus status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * status
     *
     * @return status
     **/
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public AccountHolderStatus accountEvents(List<AccountEvent> accountEvents) {
        this.accountEvents = accountEvents;
        return this;
    }

    public AccountHolderStatus addAccountEventsItem(AccountEvent accountEventsItem) {
        this.accountEvents.add(accountEventsItem);
        return this;
    }

    /**
     * scheduled events
     *
     * @return accountEvents
     **/
    public List<AccountEvent> getAccountEvents() {
        return accountEvents;
    }

    public void setAccountEvents(List<AccountEvent> accountEvents) {
        this.accountEvents = accountEvents;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountHolderStatus accountHolderStatus = (AccountHolderStatus) o;
        return Objects.equals(this.processingState, accountHolderStatus.processingState)
                && Objects.equals(this.statusReason, accountHolderStatus.statusReason)
                && Objects.equals(this.payoutState,
                                  accountHolderStatus.payoutState)
                && Objects.equals(this.status, accountHolderStatus.status)
                && Objects.equals(this.accountEvents, accountHolderStatus.accountEvents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(processingState, statusReason, payoutState, status, accountEvents);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountHolderStatus {\n");

        sb.append("    processingState: ").append(toIndentedString(processingState)).append("\n");
        sb.append("    statusReason: ").append(toIndentedString(statusReason)).append("\n");
        sb.append("    payoutState: ").append(toIndentedString(payoutState)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    accountEvents: ").append(toIndentedString(accountEvents)).append("\n");
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

