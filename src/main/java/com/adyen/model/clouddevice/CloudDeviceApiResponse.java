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

/** CloudDeviceApiResponse */
public class CloudDeviceApiResponse {
  @JsonProperty("SaleToPOIResponse")
  private SaleToPOIResponse saleToPOIResponse;

  @JsonProperty("SaleToPOIRequest")
  private SaleToPOIRequest saleToPOIRequest;

  /**
   * Gets sale to POI request.
   *
   * @return the sale to POI request
   */
  public SaleToPOIRequest getSaleToPOIRequest() {
    return saleToPOIRequest;
  }

  /**
   * Sets sale to POI request.
   *
   * @param saleToPOIRequest the sale to POI request
   */
  public void setSaleToPOIRequest(SaleToPOIRequest saleToPOIRequest) {
    this.saleToPOIRequest = saleToPOIRequest;
  }

  /**
   * Gets sale to POI response.
   *
   * @return the sale to POI response
   */
  public SaleToPOIResponse getSaleToPOIResponse() {
    return saleToPOIResponse;
  }

  /**
   * Sets sale to POI response.
   *
   * @param saleToPOIResponse the sale to POI response
   */
  public void setSaleToPOIResponse(SaleToPOIResponse saleToPOIResponse) {
    this.saleToPOIResponse = saleToPOIResponse;
  }

  /**
   * Create an instance of CloudDeviceApiResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of CloudDeviceApiResponse
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     CloudDeviceApiResponse
   */
  public static CloudDeviceApiResponse fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, CloudDeviceApiResponse.class);
  }

  /**
   * Convert an instance of CloudDeviceApiResponse to an JSON string
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
    CloudDeviceApiResponse response = (CloudDeviceApiResponse) o;
    return Objects.equals(saleToPOIResponse, response.saleToPOIResponse)
        && Objects.equals(saleToPOIRequest, response.saleToPOIRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(saleToPOIResponse, saleToPOIRequest);
  }

  @Override
  public String toString() {
    return "CloudDeviceApiResponse{"
        + "saleToPOIResponse="
        + saleToPOIResponse
        + ", saleToPOIRequest="
        + saleToPOIRequest
        + '}';
  }
}