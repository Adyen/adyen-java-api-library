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

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * AccountFundsBelowThresholdNotification
 */

public class AccountFundsBelowThresholdNotification extends GenericNotification {
    @SerializedName("content")
    private AccountFundsBelowThresholdNotificationContent content = null;

    @SerializedName("error")
    private NotificationErrorContainer error = null;

    @SerializedName("eventDate")
    private Date eventDate = null;

    @SerializedName("executingUserKey")
    private String executingUserKey = null;

    @SerializedName("live")
    private Boolean live = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    public AccountFundsBelowThresholdNotification content(AccountFundsBelowThresholdNotificationContent content) {
        this.content = content;
        return this;
    }

    /**
     * Get content
     *
     * @return content
     **/
    public AccountFundsBelowThresholdNotificationContent getContent() {
        return content;
    }

    public void setContent(AccountFundsBelowThresholdNotificationContent content) {
        this.content = content;
    }

    public AccountFundsBelowThresholdNotification error(NotificationErrorContainer error) {
        this.error = error;
        return this;
    }

    /**
     * Get error
     *
     * @return error
     **/
    public NotificationErrorContainer getError() {
        return error;
    }

    public void setError(NotificationErrorContainer error) {
        this.error = error;
    }

    public AccountFundsBelowThresholdNotification eventDate(Date eventDate) {
        this.eventDate = eventDate;
        return this;
    }

    /**
     * The date and time when an event has been completed.
     *
     * @return eventDate
     **/
    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public AccountFundsBelowThresholdNotification executingUserKey(String executingUserKey) {
        this.executingUserKey = executingUserKey;
        return this;
    }

    /**
     * The user or process that has triggered the notification.
     *
     * @return executingUserKey
     **/
    public String getExecutingUserKey() {
        return executingUserKey;
    }

    public void setExecutingUserKey(String executingUserKey) {
        this.executingUserKey = executingUserKey;
    }

    public AccountFundsBelowThresholdNotification live(Boolean live) {
        this.live = live;
        return this;
    }

    /**
     * Indicates whether the notification originated from the live environment or the test environment. If true, the notification originated from the live environment. If false, the notification originated from the test environment.
     *
     * @return live
     **/
    public Boolean isLive() {
        return live;
    }

    public void setLive(Boolean live) {
        this.live = live;
    }

    public AccountFundsBelowThresholdNotification pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * The PSP reference of the request from which the notification originates.
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
        AccountFundsBelowThresholdNotification accountFundsBelowThresholdNotification = (AccountFundsBelowThresholdNotification) o;
        return Objects.equals(this.content, accountFundsBelowThresholdNotification.content) &&
                Objects.equals(this.error, accountFundsBelowThresholdNotification.error) &&
                Objects.equals(this.eventDate, accountFundsBelowThresholdNotification.eventDate) &&
                Objects.equals(this.executingUserKey, accountFundsBelowThresholdNotification.executingUserKey) &&
                Objects.equals(this.live, accountFundsBelowThresholdNotification.live) &&
                Objects.equals(this.pspReference, accountFundsBelowThresholdNotification.pspReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, error, eventDate, executingUserKey, live, pspReference);
    }


    @Override
    public String toString() {

        String sb = "class AccountFundsBelowThresholdNotification {\n" +
                "    content: " + toIndentedString(content) + "\n" +
                "    error: " + toIndentedString(error) + "\n" +
                "    eventDate: " + toIndentedString(eventDate) + "\n" +
                "    executingUserKey: " + toIndentedString(executingUserKey) + "\n" +
                "    live: " + toIndentedString(live) + "\n" +
                "    pspReference: " + toIndentedString(pspReference) + "\n" +
                "}";
        return sb;
    }

}
