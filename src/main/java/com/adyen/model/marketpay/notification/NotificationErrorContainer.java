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

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * NotificationErrorContainer
 */

public class NotificationErrorContainer {
    @SerializedName("errorCode")
    private String errorCode = null;

    @SerializedName("message")
    private String message = null;

    public NotificationErrorContainer errorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    /**
     * The Adyen code that is mapped to the error message.
     *
     * @return errorCode
     **/
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public NotificationErrorContainer message(String message) {
        this.message = message;
        return this;
    }

    /**
     * A short explanation of the issue.
     *
     * @return message
     **/
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NotificationErrorContainer notificationErrorContainer = (NotificationErrorContainer) o;
        return Objects.equals(this.errorCode, notificationErrorContainer.errorCode) &&
                Objects.equals(this.message, notificationErrorContainer.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorCode, message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NotificationErrorContainer {\n");

        sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
