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
package com.adyen.model.modification;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Abstract class for modification requests
 */
public class AbstractModificationRequest<T extends AbstractModificationRequest<T>> {
  @SerializedName("reference")
  private String reference = null;

  @SerializedName("authorisationCode")
  private String authorisationCode = null;

  @SerializedName("originalReference")
  private String originalReference = null;

  @SerializedName("merchantAccount")
  private String merchantAccount = null;

  @SerializedName("additionalData")
  private String additionalData = null;

  public T reference(String reference) {
    this.reference = reference;
    return (T)this;
  }

   /**
   * the reference assigned to this modification
   * @return reference
  **/
  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public T authorisationCode(String authorisationCode) {
    this.authorisationCode = authorisationCode;
    return (T)this;
  }

   /**
   * the authorisation code of the payment (only required for the \"authoriseReferral\" method)
   * @return authorisationCode
  **/
  public String getAuthorisationCode() {
    return authorisationCode;
  }

  public void setAuthorisationCode(String authorisationCode) {
    this.authorisationCode = authorisationCode;
  }

  public T originalReference(String originalReference) {
    this.originalReference = originalReference;
    return (T)this;
  }

   /**
   * the pspreference of the payment to modify
   * @return originalReference
  **/
  public String getOriginalReference() {
    return originalReference;
  }

  public void setOriginalReference(String originalReference) {
    this.originalReference = originalReference;
  }

  public T merchantAccount(String merchantAccount) {
    this.merchantAccount = merchantAccount;
    return (T)this;
  }

   /**
   * the merchant account which will be used to process the payment
   * @return merchantAccount
  **/
  public String getMerchantAccount() {
    return merchantAccount;
  }

  public void setMerchantAccount(String merchantAccount) {
    this.merchantAccount = merchantAccount;
  }

  public T additionalData(String additionalData) {
    this.additionalData = additionalData;
    return (T)this;
  }

   /**
   * a map of name/value pairs for passing in additional / industry-specific data
   * @return additionalData
  **/
  public String getAdditionalData() {
    return additionalData;
  }

  public void setAdditionalData(String additionalData) {
    this.additionalData = additionalData;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractModificationRequest modificationRequest = (AbstractModificationRequest) o;
    return Objects.equals(this.reference, modificationRequest.reference) &&
        Objects.equals(this.authorisationCode, modificationRequest.authorisationCode) &&
        Objects.equals(this.originalReference, modificationRequest.originalReference) &&
        Objects.equals(this.merchantAccount, modificationRequest.merchantAccount) &&
        Objects.equals(this.additionalData, modificationRequest.additionalData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reference, authorisationCode, originalReference, merchantAccount, additionalData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    authorisationCode: ").append(toIndentedString(authorisationCode)).append("\n");
    sb.append("    originalReference: ").append(toIndentedString(originalReference)).append("\n");
    sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
    sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");

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

