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

public class CompensateNegativeBalanceNotification extends GenericNotification {
    @SerializedName("content")
    private CompensateNegativeBalanceContent content;

    public CompensateNegativeBalanceContent getContent() {
        return content;
    }

    public void setContent(CompensateNegativeBalanceContent content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CompensateNegativeBalanceNotification{" + "content=" + content + '}';
    }
}
