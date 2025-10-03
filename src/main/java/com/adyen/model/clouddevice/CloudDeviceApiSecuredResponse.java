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

/** Terminal API Secured Response */
public class CloudDeviceApiSecuredResponse {
  @JsonProperty("SaleToPOIResponse")
  private SaleToPOISecuredMessage saleToPOIResponse;

  /**
   * Gets sale to POI response.
   *
   * @return the sale to POI response
   */
  public SaleToPOISecuredMessage getSaleToPOIResponse() {
    return saleToPOIResponse;
  }

  /**
   * Sets sale to POI response.
   *
   * @param saleToPOIResponse the sale to POI response
   */
  public void setSaleToPOIResponse(SaleToPOISecuredMessage saleToPOIResponse) {
    this.saleToPOIResponse = saleToPOIResponse;
  }

  /**
   * Create an instance of CloudDeviceApiSecuredResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of CloudDeviceApiSecuredResponse
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     CloudDeviceApiSecuredResponse
   */
  public static CloudDeviceApiSecuredResponse fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, CloudDeviceApiSecuredResponse.class);
  }

  /**
   * Convert an instance of CloudDeviceApiSecuredResponse to an JSON string
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
    CloudDeviceApiSecuredResponse that = (CloudDeviceApiSecuredResponse) o;
    return Objects.equals(saleToPOIResponse, that.saleToPOIResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(saleToPOIResponse);
  }

  @Override
  public String toString() {
    return "CloudDeviceApiSecuredResponse{" + "saleToPOIResponse=" + saleToPOIResponse + '}';
  }
}
