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
 * Copyright (c) 2025 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.clouddevice;

import java.util.Objects;

/**
 * Response of the /async endpoint. When successful the `results` contains `ok` In case of failure
 * the `saleToPOIRequest` contains the EventNotification details
 */
public class CloudDeviceApiAsyncResponse {

  private String result;

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

  @Override
  public int hashCode() {
    return Objects.hash(result, saleToPOIRequest);
  }

  @Override
  public String toString() {
    return "CloudDeviceApiResponse{"
        + "result="
        + result
        + ", saleToPOIRequest="
        + saleToPOIRequest
        + '}';
  }
}
