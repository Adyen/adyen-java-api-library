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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Objects;

/** Terminal API Secured Request */
public class CloudDeviceApiSecuredRequest {
  @JsonProperty("SaleToPOIRequest")
  private SaleToPOISecuredMessage saleToPOIRequest;

  /**
   * Gets sale to POI request.
   *
   * @return the sale to POI request
   */
  public SaleToPOISecuredMessage getSaleToPOIRequest() {
    return saleToPOIRequest;
  }

  /**
   * Sets sale to POI request.
   *
   * @param saleToPOIRequest the sale to POI request
   */
  public void setSaleToPOIRequest(SaleToPOISecuredMessage saleToPOIRequest) {
    this.saleToPOIRequest = saleToPOIRequest;
  }

  /**
   * Create an instance of CloudDeviceApiSecuredRequest given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of CloudDeviceApiSecuredRequest
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     CloudDeviceApiSecuredRequest
   */
  public static CloudDeviceApiSecuredRequest fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, CloudDeviceApiSecuredRequest.class);
  }

  /**
   * Convert an instance of CloudDeviceApiSecuredRequest to an JSON string
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
    CloudDeviceApiSecuredRequest that = (CloudDeviceApiSecuredRequest) o;
    return saleToPOIRequest.equals(that.saleToPOIRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(saleToPOIRequest);
  }

  @Override
  public String toString() {
    return "CloudDeviceApiSecuredRequest{" + "saleToPOIRequest=" + saleToPOIRequest + '}';
  }
}
