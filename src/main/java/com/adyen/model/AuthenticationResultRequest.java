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


import static com.adyen.util.Util.toIndentedString;

/**
 * AuthenticationResultRequest
 */
public class AuthenticationResultRequest {
  @SerializedName("merchantAccount")
  private String merchantAccount = null;

  @SerializedName("pspReference")
  private String pspReference = null;

  public AuthenticationResultRequest merchantAccount(String merchantAccount) {
    this.merchantAccount = merchantAccount;
    return this;
  }

   /**
   * The merchant account identifier, with which the authentication was processed.
   * @return merchantAccount
  **/
  public String getMerchantAccount() {
    return merchantAccount;
  }

  public void setMerchantAccount(String merchantAccount) {
    this.merchantAccount = merchantAccount;
  }

  public AuthenticationResultRequest pspReference(String pspReference) {
    this.pspReference = pspReference;
    return this;
  }

   /**
   * The pspReference identifier for the transaction.
   * @return pspReference
  **/
  public String getPspReference() {
    return pspReference;
  }

  public void setPspReference(String pspReference) {
    this.pspReference = pspReference;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthenticationResultRequest authenticationResultRequest = (AuthenticationResultRequest) o;
    return Objects.equals(this.merchantAccount, authenticationResultRequest.merchantAccount) &&
        Objects.equals(this.pspReference, authenticationResultRequest.pspReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantAccount, pspReference);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthenticationResultRequest {\n");

    sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
    sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
    sb.append("}");
    return sb.toString();
  }

}
