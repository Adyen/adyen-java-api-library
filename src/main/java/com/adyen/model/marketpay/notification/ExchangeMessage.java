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

import java.util.Objects;

import static com.adyen.constants.TextConstants.LINE_BREAK;
import static com.adyen.util.Util.toIndentedString;

/**
 * ExchangeMessage
 */
public class ExchangeMessage {
    @SerializedName("messageCode")
    private String messageCode = null;

    @SerializedName("messageDescription")
    private String messageDescription = null;

    public ExchangeMessage messageCode(String messageCode) {
        this.messageCode = messageCode;
        return this;
    }

    /**
     * Get messageCode
     *
     * @return messageCode
     **/
    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public ExchangeMessage messageDescription(String messageDescription) {
        this.messageDescription = messageDescription;
        return this;
    }

    /**
     * Get messageDescription
     *
     * @return messageDescription
     **/
    public String getMessageDescription() {
        return messageDescription;
    }

    public void setMessageDescription(String messageDescription) {
        this.messageDescription = messageDescription;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        ExchangeMessage exchangeMessage = (ExchangeMessage) o;
        return Objects.equals(this.messageCode, exchangeMessage.messageCode) && Objects.equals(this.messageDescription, exchangeMessage.messageDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageCode, messageDescription);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExchangeMessage {").append(LINE_BREAK);

        sb.append("    messageCode: ").append(toIndentedString(messageCode)).append(LINE_BREAK);
        sb.append("    messageDescription: ").append(toIndentedString(messageDescription)).append(LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }

}

