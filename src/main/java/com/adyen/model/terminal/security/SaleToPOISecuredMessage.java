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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.terminal.security;

import com.adyen.model.nexo.MessageHeader;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class SaleToPOISecuredMessage {
    @SerializedName("MessageHeader")
    private MessageHeader messageHeader;

    @SerializedName("NexoBlob")
    private String nexoBlob;

    @SerializedName("SecurityTrailer")
    private SecurityTrailer securityTrailer;

    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(MessageHeader messageHeader) {
        this.messageHeader = messageHeader;
    }

    public String getNexoBlob() {
        return nexoBlob;
    }

    public void setNexoBlob(String nexoBlob) {
        this.nexoBlob = nexoBlob;
    }

    public SecurityTrailer getSecurityTrailer() {
        return securityTrailer;
    }

    public void setSecurityTrailer(SecurityTrailer securityTrailer) {
        this.securityTrailer = securityTrailer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SaleToPOISecuredMessage that = (SaleToPOISecuredMessage) o;
        return messageHeader.equals(that.messageHeader) &&
                nexoBlob.equals(that.nexoBlob) &&
                securityTrailer.equals(that.securityTrailer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageHeader, nexoBlob, securityTrailer);
    }

    @Override
    public String toString() {
        return "SaleToPOISecuredMessage{" +
                "messageHeader=" + messageHeader +
                ", nexoBlob='" + nexoBlob + '\'' +
                ", securityTrailer=" + securityTrailer +
                '}';
    }
}
