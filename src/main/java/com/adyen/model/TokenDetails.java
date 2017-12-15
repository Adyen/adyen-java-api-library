/**
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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model;

import java.util.Map;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * TokenDetails
 */
public class TokenDetails {
  @SerializedName("tokenDataType")
  private String tokenDataType = null;

  @SerializedName("tokenData")
  private Map<String, String> tokenData = null;

  public TokenDetails tokenDataType(String tokenDataType) {
    this.tokenDataType = tokenDataType;
    return this;
  }

   /**
   * Get tokenDataType
   * @return tokenDataType
  **/
  public String getTokenDataType() {
    return tokenDataType;
  }

  public void setTokenDataType(String tokenDataType) {
    this.tokenDataType = tokenDataType;
  }

  public TokenDetails tokenData(Map<String,String> tokenData) {
    this.tokenData = tokenData;
    return this;
  }

  /**
   * Get tokenData
   * @return tokenData
   */
  public Map<String, String> getTokenData() {
    return tokenData;
  }

  public void setTokenData(Map<String, String> tokenData) {
    this.tokenData = tokenData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenDetails tokenDetails = (TokenDetails) o;
    return Objects.equals(this.tokenDataType, tokenDetails.tokenDataType) &&
        Objects.equals(this.tokenData, tokenDetails.tokenData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tokenDataType, tokenData);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenDetails {\n");

    sb.append("    tokenDataType: ").append(toIndentedString(tokenDataType)).append("\n");
    sb.append("    tokenData: ").append(toIndentedString(tokenData)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}

