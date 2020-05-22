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
package com.adyen.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * AuthenticationResultResponse
 */
public class AuthenticationResultResponse {
  @SerializedName("threeDS1Result")
  private ThreeDS1Result threeDS1Result = null;

  @SerializedName("threeDS2Result")
  private ThreeDS2Result threeDS2Result = null;

  public AuthenticationResultResponse threeDS1Result(ThreeDS1Result threeDS1Result) {
    this.threeDS1Result = threeDS1Result;
    return this;
  }

   /**
   * Get threeDS1Result
   * @return threeDS1Result
  **/
  public ThreeDS1Result getThreeDS1Result() {
    return threeDS1Result;
  }

  public void setThreeDS1Result(ThreeDS1Result threeDS1Result) {
    this.threeDS1Result = threeDS1Result;
  }

  public AuthenticationResultResponse threeDS2Result(ThreeDS2Result threeDS2Result) {
    this.threeDS2Result = threeDS2Result;
    return this;
  }

   /**
   * Get threeDS2Result
   * @return threeDS2Result
  **/
  public ThreeDS2Result getThreeDS2Result() {
    return threeDS2Result;
  }

  public void setThreeDS2Result(ThreeDS2Result threeDS2Result) {
    this.threeDS2Result = threeDS2Result;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (Objects.isNull(o) || getClass() != o.getClass()) {
      return false;
    }
    AuthenticationResultResponse authenticationResultResponse = (AuthenticationResultResponse) o;
    return Objects.equals(this.threeDS1Result, authenticationResultResponse.threeDS1Result) &&
        Objects.equals(this.threeDS2Result, authenticationResultResponse.threeDS2Result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(threeDS1Result, threeDS2Result);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthenticationResultResponse {\n");

    sb.append("    threeDS1Result: ").append(toIndentedString(threeDS1Result)).append("\n");
    sb.append("    threeDS2Result: ").append(toIndentedString(threeDS2Result)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (Objects.isNull(o)) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
