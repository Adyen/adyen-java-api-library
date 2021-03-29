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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.marketpay.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

public class ExchangeMessageContainer {

    @SerializedName("ExchangeMessage")
    @JsonProperty("ExchangeMessage")
    private ExchangeMessage exchangeMessage = null;

    public ExchangeMessage getExchangeMessage() {
        return exchangeMessage;
    }

    public void setExchangeMessage(ExchangeMessage exchangeMessage) {
        this.exchangeMessage = exchangeMessage;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExchangeMessageContainer {\n");

        sb.append("    exchangeMessage: ").append(toIndentedString(exchangeMessage)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
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
