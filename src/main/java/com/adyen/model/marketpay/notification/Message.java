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

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * Message
 */

public class Message {
    @SerializedName("code")
    private String code = null;

    @SerializedName("text")
    private String text = null;

    public Message code(String code) {
        this.code = code;
        return this;
    }

    /**
     * The message code.
     *
     * @return code
     **/
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Message text(String text) {
        this.text = text;
        return this;
    }

    /**
     * The message text.
     *
     * @return text
     **/
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Message message = (Message) o;
        return Objects.equals(this.code, message.code) &&
                Objects.equals(this.text, message.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, text);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Message {\n");

        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    text: ").append(toIndentedString(text)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
