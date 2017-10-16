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

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * InlineResponse2002ExchangeMessages
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-10-11T12:23:08.541Z")
public class InlineResponse2002ExchangeMessages {
    @SerializedName("messageCode")
    private String messageCode = null;

    @SerializedName("messageDescription")
    private String messageDescription = null;

    public InlineResponse2002ExchangeMessages messageCode(String messageCode) {
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

    public InlineResponse2002ExchangeMessages messageDescription(String messageDescription) {
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
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InlineResponse2002ExchangeMessages inlineResponse2002ExchangeMessages = (InlineResponse2002ExchangeMessages) o;
        return Objects.equals(this.messageCode, inlineResponse2002ExchangeMessages.messageCode) && Objects.equals(this.messageDescription, inlineResponse2002ExchangeMessages.messageDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageCode, messageDescription);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InlineResponse2002ExchangeMessages {\n");

        sb.append("    messageCode: ").append(toIndentedString(messageCode)).append("\n");
        sb.append("    messageDescription: ").append(toIndentedString(messageDescription)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

