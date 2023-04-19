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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * AccountHolderUpcomingDeadlineNotificationContent
 */

public class AccountHolderUpcomingDeadlineNotificationContent {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    /**
     * The event name that will be trigger if no action is taken.
     */
    @JsonAdapter(EventEnum.Adapter.class)
    public enum EventEnum {
        ACCESSPII("AccessPii"),
        APITIERUPDATE("ApiTierUpdate"),
        CLOSEACCOUNT("CloseAccount"),
        CLOSESTORES("CloseStores"),
        DELETEBANKACCOUNTS("DeleteBankAccounts"),
        DELETEPAYOUTMETHODS("DeletePayoutMethods"),
        DELETESHAREHOLDERS("DeleteShareholders"),
        INACTIVATEACCOUNT("InactivateAccount"),
        KYCDEADLINEEXTENSION("KYCDeadlineExtension"),
        RECALCULATEACCOUNTSTATUSANDPROCESSINGTIER("RecalculateAccountStatusAndProcessingTier"),
        REFUNDNOTPAIDOUTTRANSFERS("RefundNotPaidOutTransfers"),
        RESOLVEEVENTS("ResolveEvents"),
        SAVEACCOUNTHOLDER("SaveAccountHolder"),
        SAVECRIMINALITYANDPEPCHECKS("SaveCriminalityAndPEPChecks"),
        SAVEKYCCHECKSTATUS("SaveKYCCheckStatus"),
        SUSPENDACCOUNT("SuspendAccount"),
        UNSUSPENDACCOUNT("UnSuspendAccount"),
        UPDATEACCOUNTHOLDERSTATE("UpdateAccountHolderState"),
        VERIFICATION("Verification");


        private final String value;

        EventEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static EventEnum fromValue(String text) {
            for (EventEnum b : EventEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<EventEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final EventEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public EventEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return EventEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("event")
    private EventEnum event = null;

    @SerializedName("executionDate")
    private Date executionDate = null;

    @SerializedName("reason")
    private String reason = null;

    public AccountHolderUpcomingDeadlineNotificationContent accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * The code of the account holder whom the event refers to.
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public AccountHolderUpcomingDeadlineNotificationContent event(EventEnum event) {
        this.event = event;
        return this;
    }

    /**
     * The event name that will be trigger if no action is taken.
     *
     * @return event
     **/
    public EventEnum getEvent() {
        return event;
    }

    public void setEvent(EventEnum event) {
        this.event = event;
    }

    public AccountHolderUpcomingDeadlineNotificationContent executionDate(Date executionDate) {
        this.executionDate = executionDate;
        return this;
    }

    /**
     * The execution date scheduled for the event.
     *
     * @return executionDate
     **/
    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    public AccountHolderUpcomingDeadlineNotificationContent reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * The reason that leads to scheduling of the event.
     *
     * @return reason
     **/
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountHolderUpcomingDeadlineNotificationContent accountHolderUpcomingDeadlineNotificationContent = (AccountHolderUpcomingDeadlineNotificationContent) o;
        return Objects.equals(this.accountHolderCode, accountHolderUpcomingDeadlineNotificationContent.accountHolderCode) &&
                Objects.equals(this.event, accountHolderUpcomingDeadlineNotificationContent.event) &&
                Objects.equals(this.executionDate, accountHolderUpcomingDeadlineNotificationContent.executionDate) &&
                Objects.equals(this.reason, accountHolderUpcomingDeadlineNotificationContent.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, event, executionDate, reason);
    }


    @Override
    public String toString() {

        String sb = "class AccountHolderUpcomingDeadlineNotificationContent {\n" +
                "    accountHolderCode: " + toIndentedString(accountHolderCode) + "\n" +
                "    event: " + toIndentedString(event) + "\n" +
                "    executionDate: " + toIndentedString(executionDate) + "\n" +
                "    reason: " + toIndentedString(reason) + "\n" +
                "}";
        return sb;
    }

}
