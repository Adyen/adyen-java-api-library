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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.marketpay.notification;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * RefundFundsTransferNotification
 */

public class RefundFundsTransferNotification extends GenericNotification {
    @SerializedName("content")
    private RefundFundsTransferNotificationContent content = null;

    @SerializedName("error")
    private NotificationErrorContainer error = null;

    public RefundFundsTransferNotification content(RefundFundsTransferNotificationContent content) {
        this.content = content;
        return this;
    }

    /**
     * Get content
     *
     * @return content
     **/
    public RefundFundsTransferNotificationContent getContent() {
        return content;
    }

    public void setContent(RefundFundsTransferNotificationContent content) {
        this.content = content;
    }

    public RefundFundsTransferNotification error(NotificationErrorContainer error) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RefundFundsTransferNotification refundFundsTransferNotification = (RefundFundsTransferNotification) o;
        return Objects.equals(this.content, refundFundsTransferNotification.content) &&
                Objects.equals(this.error, refundFundsTransferNotification.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, error);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RefundFundsTransferNotification {\n");

        sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("    error: ").append(toIndentedString(error)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
