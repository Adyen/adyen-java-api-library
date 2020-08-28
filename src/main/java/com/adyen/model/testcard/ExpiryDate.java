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
package com.adyen.model.testcard;

import com.google.gson.annotations.SerializedName;

import java.time.Month;

public class ExpiryDate {
    @SerializedName("expiryMonth")
    private Month expiryMonth = null;
    @SerializedName("expiryYear")
    private String expiryYear = null;

    public Month getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(Month expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    @Override
    public String toString() {
        return "ExpiryDate{" +
                "expiryMonth=" + expiryMonth +
                ", expiryYear='" + expiryYear + '\'' +
                '}';
    }
}
