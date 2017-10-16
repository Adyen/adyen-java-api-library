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
 * TestNotificationConfigurationRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-10-11T12:23:08.541Z")
public class TestNotificationConfigurationRequest {
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
        if (this.eventTypes == null) {
            this.eventTypes = new ArrayList<EventTypesEnum>();
        }
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
    public boolean equals(java.lang.Object o) {
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

