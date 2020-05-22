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
package com.adyen.model;

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * SplitAmount
 */
public class SplitAmount {

    @SerializedName("currency")
    private String currency = null;

    @SerializedName("value")
    private Long value = null;

    public SplitAmount currency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public SplitAmount value(Long value) {
        this.value = value;
        return this;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        SplitAmount splitAmount = (SplitAmount) o;
        return Objects.equals(this.currency, splitAmount.currency) && Objects.equals(this.value, splitAmount.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SplitAmount {").append(TextConstants.LINE_BREAK);

        sb.append("    currency: ").append(Util.toIndentedString(currency)).append(TextConstants.LINE_BREAK);
        sb.append("    value: ").append(Util.toIndentedString(value)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }


}



