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
package com.adyen.model.terminal;

import com.adyen.model.nexo.SaleToPOIRequest;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/**
 * TerminalAPIRequest model class This class represents the payload of the Adyen webhooks related to
 * the Terminal API
 */
public class TerminalAPIRequest {
  @SerializedName("SaleToPOIRequest")
  private SaleToPOIRequest saleToPOIRequest;

  /**
   * Gets saleToPOIRequest.
   *
   * @return the sale to POI request
   */
  public SaleToPOIRequest getSaleToPOIRequest() {
    return saleToPOIRequest;
  }

  /**
   * Sets saleToPOIRequest.
   *
   * @param saleToPOIRequest the sale to POI request
   */
  public void setSaleToPOIRequest(SaleToPOIRequest saleToPOIRequest) {
    this.saleToPOIRequest = saleToPOIRequest;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TerminalAPIRequest that = (TerminalAPIRequest) o;
    return saleToPOIRequest.equals(that.saleToPOIRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(saleToPOIRequest);
  }

  @Override
  public String toString() {
    return "TerminalAPIRequest{" + "saleToPOIRequest=" + saleToPOIRequest + '}';
  }
}
