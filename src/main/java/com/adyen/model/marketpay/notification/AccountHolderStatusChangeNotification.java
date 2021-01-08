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

public class AccountHolderStatusChangeNotification extends GenericNotification {
    @SerializedName("content")
    private AccountHolderStatusChangeNotificationContent content;

    public AccountHolderStatusChangeNotificationContent getContent() {
        return content;
    }

    public void setContent(AccountHolderStatusChangeNotificationContent content) {
        this.content = content;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountHolderStatusChangeNotification{");
        sb.append("content=").append(content);
        sb.append('}');
        return sb.toString();
    }
}
