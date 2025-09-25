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

package com.adyen.model.clouddevice;

import com.adyen.model.clouddevice.security.SecurityTrailer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Objects;

public class SaleToPOISecuredMessage {
  @JsonProperty("MessageHeader")
  private MessageHeader messageHeader;

  @JsonProperty("NexoBlob")
  private String nexoBlob;

  @JsonProperty("SecurityTrailer")
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

  /**
   * Create an instance of SaleToPOISecuredMessage given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of SaleToPOISecuredMessage
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     SaleToPOISecuredMessage
   */
  public static SaleToPOISecuredMessage fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, SaleToPOISecuredMessage.class);
  }

  /**
   * Convert an instance of SaleToPOISecuredMessage to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
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
    return messageHeader.equals(that.messageHeader)
        && nexoBlob.equals(that.nexoBlob)
        && securityTrailer.equals(that.securityTrailer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messageHeader, nexoBlob, securityTrailer);
  }

  @Override
  public String toString() {
    return "SaleToPOISecuredMessage{"
        + "messageHeader="
        + messageHeader
        + ", nexoBlob='"
        + nexoBlob
        + '\''
        + ", securityTrailer="
        + securityTrailer
        + '}';
  }
}
