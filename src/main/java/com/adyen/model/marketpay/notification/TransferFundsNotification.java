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

public class TransferFundsNotification extends GenericWebhook {
    @SerializedName("content")
    private TransferFundsNotificationContent content = null;

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

    public TransferFundsNotification content(TransferFundsNotificationContent content) {
        this.content = content;
        return this;
    }

    /**
     * Get content
     *
     * @return content
     **/
    public TransferFundsNotificationContent getContent() {
        return content;
    }

    public void setContent(TransferFundsNotificationContent content) {
        this.content = content;
    }

    public TransferFundsNotification error(NotificationErrorContainer error) {
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

    public TransferFundsNotification eventDate(Date eventDate) {
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

    public TransferFundsNotification executingUserKey(String executingUserKey) {
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

    public TransferFundsNotification live(Boolean live) {
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

    public TransferFundsNotification pspReference(String pspReference) {
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
        TransferFundsNotification transferFundsNotification = (TransferFundsNotification) o;
        return Objects.equals(this.content, transferFundsNotification.content) &&
                Objects.equals(this.error, transferFundsNotification.error) &&
                Objects.equals(this.eventDate, transferFundsNotification.eventDate) &&
                Objects.equals(this.executingUserKey, transferFundsNotification.executingUserKey) &&
                Objects.equals(this.live, transferFundsNotification.live) &&
                Objects.equals(this.pspReference, transferFundsNotification.pspReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, error, eventDate, executingUserKey, live, pspReference);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TransferFundsNotification {\n");

        sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("    error: ").append(toIndentedString(error)).append("\n");
        sb.append("    eventDate: ").append(toIndentedString(eventDate)).append("\n");
        sb.append("    executingUserKey: ").append(toIndentedString(executingUserKey)).append("\n");
        sb.append("    live: ").append(toIndentedString(live)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
