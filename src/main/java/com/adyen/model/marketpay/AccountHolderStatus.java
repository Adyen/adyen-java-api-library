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

package com.adyen.model.marketpay;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * AccountHolderStatus
 */

public class AccountHolderStatus {
    @SerializedName("events")
    private List<AccountEvent> events = null;

    @SerializedName("payoutState")
    private AccountPayoutState payoutState = null;

    @SerializedName("processingState")
    private AccountProcessingState processingState = null;

    /**
     * The status of the account holder. &gt;Permitted values: &#x60;Active&#x60;, &#x60;Inactive&#x60;, &#x60;Suspended&#x60;, &#x60;Closed&#x60;.
     */
    @JsonAdapter(StatusEnum.Adapter.class)
    public enum StatusEnum {
        ACTIVE("Active"),
        CLOSED("Closed"),
        INACTIVE("Inactive"),
        SUSPENDED("Suspended");


        private final String value;

        StatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static StatusEnum fromValue(String text) {
            for (StatusEnum b : StatusEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<StatusEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public StatusEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return StatusEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("status")
    private StatusEnum status = null;

    @SerializedName("statusReason")
    private String statusReason = null;

    public AccountHolderStatus events(List<AccountEvent> events) {
        this.events = events;
        return this;
    }

    public AccountHolderStatus addEventsItem(AccountEvent eventsItem) {
        if (this.events == null) {
            this.events = new ArrayList<AccountEvent>();
        }
        this.events.add(eventsItem);
        return this;
    }

    /**
     * A list of events scheduled for the account holder.
     *
     * @return events
     **/
    public List<AccountEvent> getEvents() {
        return events;
    }

    public void setEvents(List<AccountEvent> events) {
        this.events = events;
    }

    public AccountHolderStatus payoutState(AccountPayoutState payoutState) {
        this.payoutState = payoutState;
        return this;
    }

    /**
     * Get payoutState
     *
     * @return payoutState
     **/
    public AccountPayoutState getPayoutState() {
        return payoutState;
    }

    public void setPayoutState(AccountPayoutState payoutState) {
        this.payoutState = payoutState;
    }

    public AccountHolderStatus processingState(AccountProcessingState processingState) {
        this.processingState = processingState;
        return this;
    }

    /**
     * Get processingState
     *
     * @return processingState
     **/
    public AccountProcessingState getProcessingState() {
        return processingState;
    }

    public void setProcessingState(AccountProcessingState processingState) {
        this.processingState = processingState;
    }

    public AccountHolderStatus status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * The status of the account holder. &gt;Permitted values: &#x60;Active&#x60;, &#x60;Inactive&#x60;, &#x60;Suspended&#x60;, &#x60;Closed&#x60;.
     *
     * @return status
     **/
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public AccountHolderStatus statusReason(String statusReason) {
        this.statusReason = statusReason;
        return this;
    }

    /**
     * The reason why the status was assigned to the account holder.
     *
     * @return statusReason
     **/
    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountHolderStatus accountHolderStatus = (AccountHolderStatus) o;
        return Objects.equals(this.events, accountHolderStatus.events) &&
                Objects.equals(this.payoutState, accountHolderStatus.payoutState) &&
                Objects.equals(this.processingState, accountHolderStatus.processingState) &&
                Objects.equals(this.status, accountHolderStatus.status) &&
                Objects.equals(this.statusReason, accountHolderStatus.statusReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(events, payoutState, processingState, status, statusReason);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountHolderStatus {\n");

        sb.append("    events: ").append(toIndentedString(events)).append("\n");
        sb.append("    payoutState: ").append(toIndentedString(payoutState)).append("\n");
        sb.append("    processingState: ").append(toIndentedString(processingState)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    statusReason: ").append(toIndentedString(statusReason)).append("\n");
        sb.append("}");
        return sb.toString();
    }



}
