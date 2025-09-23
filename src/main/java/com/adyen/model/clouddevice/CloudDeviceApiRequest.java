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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * CloudDeviceApiRequest
 */
public class CloudDeviceApiRequest {
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
    CloudDeviceApiRequest that = (CloudDeviceApiRequest) o;
    return saleToPOIRequest.equals(that.saleToPOIRequest);
  }

  /**
   * Create an instance of CloudDeviceApiRequest given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of CloudDeviceApiRequest
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     CloudDeviceApiRequest
   */
  public static CloudDeviceApiRequest fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, CloudDeviceApiRequest.class);
  }

  /**
   * Convert an instance of CloudDeviceApiRequest to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(saleToPOIRequest);
  }

  @Override
  public String toString() {
    return "CloudDeviceApiRequest{" + "saleToPOIRequest=" + saleToPOIRequest + '}';
  }
}
