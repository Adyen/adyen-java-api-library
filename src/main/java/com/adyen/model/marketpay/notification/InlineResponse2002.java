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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * InlineResponse2002
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-10-11T12:23:08.541Z")
public class InlineResponse2002 {
    @SerializedName("errorMessages")
    private List<String> errorMessages = null;

    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("okMessages")
    private List<String> okMessages = null;

    @SerializedName("exchangeMessages")
    private List<InlineResponse2002ExchangeMessages> exchangeMessages = null;

    @SerializedName("notificationId")
    private Long notificationId = null;

    /**
     * Gets or Sets eventTypes
     */
    @JsonAdapter(EventTypesEnum.Adapter.class)
    public enum EventTypesEnum {
        ACCOUNT_CREATED("ACCOUNT_CREATED"),

        ACCOUNT_HOLDER_CREATED("ACCOUNT_HOLDER_CREATED"),

        ACCOUNT_HOLDER_LIMIT_REACHED("ACCOUNT_HOLDER_LIMIT_REACHED"),

        ACCOUNT_HOLDER_PAYOUT("ACCOUNT_HOLDER_PAYOUT"),

        ACCOUNT_HOLDER_STATUS_CHANGE("ACCOUNT_HOLDER_STATUS_CHANGE"),

        ACCOUNT_HOLDER_UPDATED("ACCOUNT_HOLDER_UPDATED"),

        ACCOUNT_HOLDER_VERIFICATION("ACCOUNT_HOLDER_VERIFICATION"),

        ACCOUNT_UPDATED("ACCOUNT_UPDATED"),

        BENEFICIARY_SETUP("BENEFICIARY_SETUP"),

        COMPENSATE_NEGATIVE_BALANCE("COMPENSATE_NEGATIVE_BALANCE"),

        PAYMENT_FAILURE("PAYMENT_FAILURE"),

        REPORT_AVAILABLE("REPORT_AVAILABLE"),

        SCHEDULED_REFUNDS("SCHEDULED_REFUNDS"),

        TRANSFER_FUNDS("TRANSFER_FUNDS");

        private String value;

        EventTypesEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static EventTypesEnum fromValue(String text) {
            for (EventTypesEnum b : EventTypesEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<EventTypesEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final EventTypesEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public EventTypesEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return EventTypesEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("eventTypes")
    private List<EventTypesEnum> eventTypes = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    public InlineResponse2002 errorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
        return this;
    }

    public InlineResponse2002 addErrorMessagesItem(String errorMessagesItem) {
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

    public InlineResponse2002 submittedAsync(Boolean submittedAsync) {
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

    public InlineResponse2002 okMessages(List<String> okMessages) {
        this.okMessages = okMessages;
        return this;
    }

    public InlineResponse2002 addOkMessagesItem(String okMessagesItem) {
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

    public InlineResponse2002 exchangeMessages(List<InlineResponse2002ExchangeMessages> exchangeMessages) {
        this.exchangeMessages = exchangeMessages;
        return this;
    }

    public InlineResponse2002 addExchangeMessagesItem(InlineResponse2002ExchangeMessages exchangeMessagesItem) {
        if (this.exchangeMessages == null) {
            this.exchangeMessages = new ArrayList<InlineResponse2002ExchangeMessages>();
        }
        this.exchangeMessages.add(exchangeMessagesItem);
        return this;
    }

    /**
     * Notification request and response related messages
     *
     * @return exchangeMessages
     **/
    public List<InlineResponse2002ExchangeMessages> getExchangeMessages() {
        return exchangeMessages;
    }

    public void setExchangeMessages(List<InlineResponse2002ExchangeMessages> exchangeMessages) {
        this.exchangeMessages = exchangeMessages;
    }

    public InlineResponse2002 notificationId(Long notificationId) {
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

    public InlineResponse2002 eventTypes(List<EventTypesEnum> eventTypes) {
        this.eventTypes = eventTypes;
        return this;
    }

    public InlineResponse2002 addEventTypesItem(EventTypesEnum eventTypesItem) {
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

    public InlineResponse2002 pspReference(String pspReference) {
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
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InlineResponse2002 inlineResponse2002 = (InlineResponse2002) o;
        return Objects.equals(this.errorMessages, inlineResponse2002.errorMessages)
                && Objects.equals(this.submittedAsync, inlineResponse2002.submittedAsync)
                && Objects.equals(this.okMessages,
                                  inlineResponse2002.okMessages)
                && Objects.equals(this.exchangeMessages, inlineResponse2002.exchangeMessages)
                && Objects.equals(this.notificationId, inlineResponse2002.notificationId)
                && Objects.equals(this.eventTypes, inlineResponse2002.eventTypes)
                && Objects.equals(this.pspReference, inlineResponse2002.pspReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorMessages, submittedAsync, okMessages, exchangeMessages, notificationId, eventTypes, pspReference);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InlineResponse2002 {\n");

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
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

