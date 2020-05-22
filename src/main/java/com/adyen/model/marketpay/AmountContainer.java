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

package com.adyen.model.marketpay;

import com.adyen.constants.TextConstants;
import com.adyen.model.Amount;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * AmountContainer
 */
public class AmountContainer {
    @SerializedName("Amount")
    private Amount amount = null;

    /**
     * amount
     *
     * @return amount
     */
    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        AmountContainer amountContainer = (AmountContainer) o;
        return Objects.equals(this.amount, amountContainer.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AmountContainer {").append(TextConstants.LINE_BREAK);

        sb.append("    amount: ").append(Util.toIndentedString(amount)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }
}
