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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.checkout.details;

import com.adyen.model.checkout.PaymentMethodDetails;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;
/**
 * WeChatPayDetails
 */

public class WeChatPayDetails implements PaymentMethodDetails {
  @SerializedName("appId")
  private String appId = null;

  @SerializedName("openid")
  private String openid = null;

  @SerializedName("type")
  private String type = null;

  public WeChatPayDetails appId(String appId) {
    this.appId = appId;
    return this;
  }

   /**
   * Get appId
   * @return appId
  **/
  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public WeChatPayDetails openid(String openid) {
    this.openid = openid;
    return this;
  }

   /**
   * Get openid
   * @return openid
  **/
  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public WeChatPayDetails type(String type) {
    this.type = type;
    return this;
  }

   /**
   * The payment method type.
   * @return type
  **/
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WeChatPayDetails weChatPayDetails = (WeChatPayDetails) o;
    return Objects.equals(this.appId, weChatPayDetails.appId) &&
        Objects.equals(this.openid, weChatPayDetails.openid) &&
        Objects.equals(this.type, weChatPayDetails.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appId, openid, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WeChatPayDetails {\n");

    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    openid: ").append(toIndentedString(openid)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
