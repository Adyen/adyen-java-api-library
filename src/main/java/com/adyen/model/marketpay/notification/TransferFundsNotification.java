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

import com.google.gson.annotations.SerializedName;

public class TransferFundsNotification extends GenericNotification {
    @SerializedName("content")
    private TransferFundsNotificationContent content;

    public TransferFundsNotificationContent getContent() {
        return content;
    }

    public void setContent(TransferFundsNotificationContent content) {
        this.content = content;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TransferFundsNotification{");
        sb.append("content=").append(content);
        sb.append('}');
        return sb.toString();
    }
}
