/**
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
package com.adyen.model.recurring;

import com.google.gson.annotations.SerializedName;

import static com.adyen.constants.TextConstants.LINE_BREAK;
import static com.adyen.util.Util.toIndentedString;

/**
 * Container for RecurringDetail
 */
public class RecurringDetailContainer {
    @SerializedName("RecurringDetail")
    private RecurringDetail recurringDetail = null;

    public RecurringDetail getRecurringDetail() {
        return recurringDetail;
    }

    public void setRecurringDetail(RecurringDetail recurringDetail) {
        this.recurringDetail = recurringDetail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RecurringDetailContainer {").append(LINE_BREAK);

        sb.append("    recurringDetail: ").append(toIndentedString(recurringDetail)).append(LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }


}
