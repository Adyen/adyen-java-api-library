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

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class ExchangeMessageContainer {

    @SerializedName("ExchangeMessage")
    private ExchangeMessage exchangeMessage = null;

    public ExchangeMessage getExchangeMessage() {
        return exchangeMessage;
    }

    public void setExchangeMessage(ExchangeMessage exchangeMessage) {
        this.exchangeMessage = exchangeMessage;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExchangeMessageContainer {").append(TextConstants.LINE_BREAK);

        sb.append("    exchangeMessage: ").append(Util.toIndentedString(exchangeMessage)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }

        ExchangeMessageContainer that = (ExchangeMessageContainer) o;

        return Objects.equals(exchangeMessage, that.exchangeMessage);
    }

    @Override
    public int hashCode() {
        return exchangeMessage != null ? exchangeMessage.hashCode() : 0;
    }
}
