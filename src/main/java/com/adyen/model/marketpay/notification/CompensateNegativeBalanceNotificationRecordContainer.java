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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class CompensateNegativeBalanceNotificationRecordContainer {
    @SerializedName("CompensateNegativeBalanceNotificationRecord")
    @JsonProperty("CompensateNegativeBalanceNotificationRecord")
    private CompensateNegativeBalanceNotificationRecord compensateNegativeBalanceNotificationRecord;

    public CompensateNegativeBalanceNotificationRecord getCompensateNegativeBalanceNotificationRecord() {
        return compensateNegativeBalanceNotificationRecord;
    }

    public void setCompensateNegativeBalanceNotificationRecord(CompensateNegativeBalanceNotificationRecord compensateNegativeBalanceNotificationRecord) {
        this.compensateNegativeBalanceNotificationRecord = compensateNegativeBalanceNotificationRecord;
    }

    @Override
    public String toString() {
        return "CompensateNegativeBalanceNotificationRecordContainer{" + "compensateNegativeBalanceNotificationRecord=" + compensateNegativeBalanceNotificationRecord + '}';
    }
}
