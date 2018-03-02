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

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CompensateNegativeBalanceContent {
    @SerializedName("records")
    private List<CompensateNegativeBalanceNotificationRecordContainer> records;

    public List<CompensateNegativeBalanceNotificationRecordContainer> getRecords() {
        return records;
    }

    public void setRecords(List<CompensateNegativeBalanceNotificationRecordContainer> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "CompensateNegativeBalanceContent{" + "records=" + records + '}';
    }
}
