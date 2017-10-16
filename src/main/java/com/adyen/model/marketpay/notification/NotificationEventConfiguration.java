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
import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * NotificationEventConfiguration
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-10-11T12:23:08.541Z")
public class NotificationEventConfiguration {
    /**
     * specifies if the notification has to be sent in case an event of the mentioned type has occurred, or of events other than event of the mentioned type have occurred
     */
    @JsonAdapter(IncludeModeEnum.Adapter.class)
    public enum IncludeModeEnum {
        EXCLUDE("EXCLUDE"),

        INCLUDE("INCLUDE");

        private String value;

        IncludeModeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static IncludeModeEnum fromValue(String text) {
            for (IncludeModeEnum b : IncludeModeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<IncludeModeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final IncludeModeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public IncludeModeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return IncludeModeEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("includeMode")
    private IncludeModeEnum includeMode = null;

    /**
     * type of the events triggering the notification
     */
    @JsonAdapter(EventTypeEnum.Adapter.class)
    public enum EventTypeEnum {
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

        EventTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static EventTypeEnum fromValue(String text) {
            for (EventTypeEnum b : EventTypeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<EventTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final EventTypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public EventTypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return EventTypeEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("eventType")
    private EventTypeEnum eventType = null;

    public NotificationEventConfiguration includeMode(IncludeModeEnum includeMode) {
        this.includeMode = includeMode;
        return this;
    }

    /**
     * specifies if the notification has to be sent in case an event of the mentioned type has occurred, or of events other than event of the mentioned type have occurred
     *
     * @return includeMode
     **/
    public IncludeModeEnum getIncludeMode() {
        return includeMode;
    }

    public void setIncludeMode(IncludeModeEnum includeMode) {
        this.includeMode = includeMode;
    }

    public NotificationEventConfiguration eventType(EventTypeEnum eventType) {
        this.eventType = eventType;
        return this;
    }

    /**
     * type of the events triggering the notification
     *
     * @return eventType
     **/
    public EventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(EventTypeEnum eventType) {
        this.eventType = eventType;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NotificationEventConfiguration notificationEventConfiguration = (NotificationEventConfiguration) o;
        return Objects.equals(this.includeMode, notificationEventConfiguration.includeMode) && Objects.equals(this.eventType, notificationEventConfiguration.eventType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(includeMode, eventType);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NotificationEventConfiguration {\n");

        sb.append("    includeMode: ").append(toIndentedString(includeMode)).append("\n");
        sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
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

