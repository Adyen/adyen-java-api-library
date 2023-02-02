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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.notification;

import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * Amount
 */
public class Amount {
    @SerializedName("value")
    private Long value = null;

    @SerializedName("currency")
    private String currency = null;

    public BigDecimal getDecimalValue() {
        return BigDecimal.valueOf(getValue(), Util.getDecimalPlaces(getCurrency()));
    }

    public Amount value(Long value) {
        this.value = value;
        return this;
    }

    /**
     * the amount's value in minor units
     *
     * @return value
     **/
    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Amount currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * the amount's three letter currency code (ISO 4217)
     *
     * @return currency
     **/
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Amount amount = (Amount) o;
        return Objects.equals(this.value, amount.value) &&
                Objects.equals(this.currency, amount.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Amount {\n");

        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("}");
        return sb.toString();
    }



}

