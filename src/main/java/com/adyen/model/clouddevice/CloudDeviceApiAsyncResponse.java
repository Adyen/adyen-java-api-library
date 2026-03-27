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
 * Copyright (c) 2026 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.clouddevice;

import com.adyen.model.tapi.JSON;
import com.adyen.model.tapi.SaleToPOIRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Objects;

/**
 * Response of the /async endpoint. When successful the `results` contains `ok` In case of failure
 * the `saleToPOIRequest` contains the EventNotification details
 */
public class CloudDeviceApiAsyncResponse {
  @JsonProperty("Result")
  private String result;

  @JsonProperty("SaleToPOIRequest")
  private SaleToPOIRequest saleToPOIRequest;

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CloudDeviceApiAsyncResponse response = (CloudDeviceApiAsyncResponse) o;
    return Objects.equals(result, response.result)
        && Objects.equals(saleToPOIRequest, response.saleToPOIRequest);
  }

  /**
   * Create an instance of CloudDeviceApiAsyncResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of CloudDeviceApiAsyncResponse
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     CloudDeviceApiAsyncResponse
   */
  public static CloudDeviceApiAsyncResponse fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, CloudDeviceApiAsyncResponse.class);
  }

  /**
   * Convert an instance of CloudDeviceApiAsyncResponse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, saleToPOIRequest);
  }

  @Override
  public String toString() {
    return "CloudDeviceApiAsyncResponse{"
        + "result="
        + result
        + ", saleToPOIRequest="
        + saleToPOIRequest
        + '}';
  }
}
