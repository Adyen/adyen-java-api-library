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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


import static com.adyen.util.Util.toIndentedString;

/**
 * TestNotificationConfigurationResponse
 */
public class TestNotificationConfigurationResponse extends GenericResponse {
    @SerializedName("errorMessages")
    private List<String> errorMessages = null;

    @SerializedName("okMessages")
    private List<String> okMessages = null;

    @SerializedName("exchangeMessages")
    private List<ExchangeMessage> exchangeMessages = null;

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

        private String value;

        EventTypesEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("eventTypes")
    private List<EventTypesEnum> eventTypes = null;

    public TestNotificationConfigurationResponse errorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
        return this;
    }

    public TestNotificationConfigurationResponse addErrorMessagesItem(String errorMessagesItem) {
        if (this.errorMessages == null) {
            this.errorMessages = new ArrayList<>();
        }
        this.errorMessages.add(errorMessagesItem);
        return this;
    }

    /**
     * Error message. Populated if sending notification resulted into an error
     *
     * @return errorMessages
     **/
    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public TestNotificationConfigurationResponse okMessages(List<String> okMessages) {
        this.okMessages = okMessages;
        return this;
    }

    public TestNotificationConfigurationResponse addOkMessagesItem(String okMessagesItem) {
        if (this.okMessages == null) {
            this.okMessages = new ArrayList<>();
        }
        this.okMessages.add(okMessagesItem);
        return this;
    }

    /**
     * List of messages, describing the testing steps
     *
     * @return okMessages
     **/
    public List<String> getOkMessages() {
        return okMessages;
    }

    public void setOkMessages(List<String> okMessages) {
        this.okMessages = okMessages;
    }

    public TestNotificationConfigurationResponse exchangeMessages(List<ExchangeMessage> exchangeMessages) {
        this.exchangeMessages = exchangeMessages;
        return this;
    }

    /**
     * Populate the virtual exchangeMessages to bypass the exchangeMessageContainers list
     *
     * @return exchangeMessages
     **/
    public List<ExchangeMessage> getExchangeMessages() {
        return exchangeMessages;
    }

    public void setExchangeMessages(List<ExchangeMessage> exchangeMessages) {
        this.exchangeMessages = exchangeMessages;
    }


    public TestNotificationConfigurationResponse notificationId(Long notificationId) {
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

    public TestNotificationConfigurationResponse eventTypes(List<EventTypesEnum> eventTypes) {
        this.eventTypes = eventTypes;
        return this;
    }

    public TestNotificationConfigurationResponse addEventTypesItem(EventTypesEnum eventTypesItem) {
        if (this.eventTypes == null) {
            this.eventTypes = new ArrayList<>();
        }
        this.eventTypes.add(eventTypesItem);
        return this;
    }

    /**
     * Tested event types
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
        TestNotificationConfigurationResponse testNotificationConfigurationResponse = (TestNotificationConfigurationResponse) o;
        return Objects.equals(this.errorMessages, testNotificationConfigurationResponse.errorMessages)
                && Objects.equals(this.okMessages, testNotificationConfigurationResponse.okMessages)
                && Objects.equals(this.exchangeMessages, testNotificationConfigurationResponse.exchangeMessages)
                && Objects.equals(this.notificationId, testNotificationConfigurationResponse.notificationId)
                && Objects.equals(this.eventTypes, testNotificationConfigurationResponse.eventTypes)
                && Objects.equals(this.getPspReference(), testNotificationConfigurationResponse.getPspReference())
                && Objects.equals(this.getInvalidFields(), testNotificationConfigurationResponse.getInvalidFields())
                && Objects.equals(this.getResultCode(), testNotificationConfigurationResponse.getResultCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorMessages, okMessages, exchangeMessages, notificationId, eventTypes, getPspReference(), getInvalidFields(), getResultCode());
    }


    @Override
    public String toString() {
        // Populate the exchangeMessages list to provide back in the toString() method
        StringBuilder sb = new StringBuilder();
        sb.append("class TestNotificationConfigurationResponse {\n");

        sb.append("    errorMessages: ").append(toIndentedString(errorMessages)).append("\n");
        sb.append("    eventTypes: ").append(toIndentedString(eventTypes)).append("\n");
        sb.append("    exchangeMessages: ").append(toIndentedString(exchangeMessages)).append("\n");
        sb.append("    invalidFields: ").append(toIndentedString(getInvalidFields())).append("\n");
        sb.append("    notificationId: ").append(toIndentedString(notificationId)).append("\n");
        sb.append("    okMessages: ").append(toIndentedString(okMessages)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(getPspReference())).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(getResultCode())).append("\n");

        sb.append("}");
        return sb.toString();
    }

}

