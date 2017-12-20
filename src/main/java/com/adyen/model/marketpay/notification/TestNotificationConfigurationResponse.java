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
package com.adyen.model.marketpay.notification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * TestNotificationConfigurationResponse
 */
public class TestNotificationConfigurationResponse {
    @SerializedName("errorMessages")
    private List<String> errorMessages = null;

    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("okMessages")
    private List<String> okMessages = null;

    @SerializedName("exchangeMessages")
    private List<ExchangeMessageContainer> exchangeMessageContainers = null;

    private transient List<ExchangeMessage> exchangeMessages = null;

    @SerializedName("notificationId")
    private Long notificationId = null;

    /**
     * Gets or Sets eventTypes
     */
    public enum EventTypesEnum {
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

        @SerializedName("PAYMENT_FAILURE")
        PAYMENT_FAILURE("PAYMENT_FAILURE"),

        @SerializedName("REPORT_AVAILABLE")
        REPORT_AVAILABLE("REPORT_AVAILABLE"),

        @SerializedName("SCHEDULED_REFUNDS")
        SCHEDULED_REFUNDS("SCHEDULED_REFUNDS"),

        @SerializedName("TRANSFER_FUNDS")
        TRANSFER_FUNDS("TRANSFER_FUNDS");

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

    @SerializedName("pspReference")
    private String pspReference = null;

    public TestNotificationConfigurationResponse errorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
        return this;
    }

    public TestNotificationConfigurationResponse addErrorMessagesItem(String errorMessagesItem) {
        if (this.errorMessages == null) {
            this.errorMessages = new ArrayList<String>();
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

    public TestNotificationConfigurationResponse submittedAsync(Boolean submittedAsync) {
        this.submittedAsync = submittedAsync;
        return this;
    }

    /**
     * Get submittedAsync
     *
     * @return submittedAsync
     **/
    public Boolean getSubmittedAsync() {
        return submittedAsync;
    }

    public void setSubmittedAsync(Boolean submittedAsync) {
        this.submittedAsync = submittedAsync;
    }

    public TestNotificationConfigurationResponse okMessages(List<String> okMessages) {
        this.okMessages = okMessages;
        return this;
    }

    public TestNotificationConfigurationResponse addOkMessagesItem(String okMessagesItem) {
        if (this.okMessages == null) {
            this.okMessages = new ArrayList<String>();
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


    /**
     * Populate the virtual exchangeMessages to bypass the exchangeMessageContainers list
     *
     * @return exchangeMessages
     **/
    public List<ExchangeMessage> getExchangeMessages() {

        if(exchangeMessages == null) {
            exchangeMessages = new ArrayList<ExchangeMessage>();

            if(exchangeMessageContainers != null && !exchangeMessageContainers.isEmpty()){
                for(ExchangeMessageContainer exchangeMessageContainer : exchangeMessageContainers) {
                    exchangeMessages.add(exchangeMessageContainer.getExchangeMessage());
                }
            }
        }
        return exchangeMessages;
    }

    public void setExchangeMessages(List<ExchangeMessage> exchangeMessages) {
        this.exchangeMessages = exchangeMessages;

        // set as well the container list this will be send in the API request
        this.exchangeMessageContainers = new ArrayList<ExchangeMessageContainer>();
        for (ExchangeMessage exchangeMessage : exchangeMessages) {
            ExchangeMessageContainer exchangeMessageContainer = createExchangeMessageContainerFromExchangeMessage(exchangeMessage);
            this.exchangeMessageContainers.add(exchangeMessageContainer);
        }

    }

    private ExchangeMessageContainer createExchangeMessageContainerFromExchangeMessage(ExchangeMessage exchangeMessage) {
        ExchangeMessageContainer exchangeMessageContainer = new ExchangeMessageContainer();
        exchangeMessageContainer.setExchangeMessage(exchangeMessage);
        return exchangeMessageContainer;
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
            this.eventTypes = new ArrayList<EventTypesEnum>();
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

    public TestNotificationConfigurationResponse pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * psp reference
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
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
                && Objects.equals(this.submittedAsync, testNotificationConfigurationResponse.submittedAsync)
                && Objects.equals(this.okMessages, testNotificationConfigurationResponse.okMessages)
                && Objects.equals(this.exchangeMessageContainers, testNotificationConfigurationResponse.exchangeMessageContainers)
                && Objects.equals(this.notificationId, testNotificationConfigurationResponse.notificationId)
                && Objects.equals(this.eventTypes, testNotificationConfigurationResponse.eventTypes)
                && Objects.equals(this.pspReference, testNotificationConfigurationResponse.pspReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorMessages, submittedAsync, okMessages, exchangeMessageContainers, notificationId, eventTypes, pspReference);
    }


    @Override
    public String toString() {
        // Populate the exchangeMessages list to provide back in the toString() method
        this.getExchangeMessages();

        StringBuilder sb = new StringBuilder();
        sb.append("class TestNotificationConfigurationResponse {\n");

        sb.append("    errorMessages: ").append(toIndentedString(errorMessages)).append("\n");
        sb.append("    submittedAsync: ").append(toIndentedString(submittedAsync)).append("\n");
        sb.append("    okMessages: ").append(toIndentedString(okMessages)).append("\n");
        sb.append("    exchangeMessages: ").append(toIndentedString(exchangeMessages)).append("\n");
        sb.append("    notificationId: ").append(toIndentedString(notificationId)).append("\n");
        sb.append("    eventTypes: ").append(toIndentedString(eventTypes)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
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

