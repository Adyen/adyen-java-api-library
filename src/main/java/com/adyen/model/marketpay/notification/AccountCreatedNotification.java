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

import com.adyen.model.marketpay.CreateAccountResponse;
import com.google.gson.annotations.SerializedName;

public class AccountCreatedNotification extends GenericNotification {
    @SerializedName("content")
    private CreateAccountResponse content;

    public CreateAccountResponse getContent() {
        return content;
    }

    public void setContent(CreateAccountResponse content) {
        this.content = content;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountCreatedNotification{");
        sb.append("content=").append(content);
        sb.append('}');
        return sb.toString();
    }
}
