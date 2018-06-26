/*
 * Adyen Checkout Service
 * Adyen Checkout API provides a simple and flexible way to initiate and authorise online payments. You can use the same integration for payments made with cards (including One-Click and 3D Secure), mobile wallets, and local payment methods (e.g. iDEAL and Sofort).  This API reference provides information on available endpoints and how to interact with them. To learn more about the API, visit [Checkout documentation](https://docs.adyen.com/developers/checkout).  ## Authentication Each request to the Checkout API must be signed with an API key. For this, obtain an API Key from your Customer Area, as described in [How to get the Checkout API key](https://docs.adyen.com/developers/user-management/how-to-get-the-checkout-api-key). Then set this key to the `X-API-Key` header value, for example:  ``` curl -H \"Content-Type: application/json\" \\ -H \"X-API-Key: Your_Checkout_API_key\" \\ ... ``` Note that when going live, you need to generate a new API Key to access the [live endpoints](https://docs.adyen.com/developers/api-reference/live-endpoints).  ## Versioning Checkout API supports versioning of its endpoints through a version suffix in the endpoint URL. This suffix has the following format: \"vXX\", where XX is the version number.  For example: ``` https://checkout-test.adyen.com/v32/payments ```
 *
 * OpenAPI spec version: 32
 * Contact: support@adyen.com
 *
 * Do not edit the class manually.
 */


package com.adyen.model.checkout;

import com.adyen.model.Installments;
import com.google.gson.annotations.SerializedName;


import java.util.Objects;

/**
 * ModelConfiguration
 */
public class ModelConfiguration {

  @SerializedName("avs")
  private Avs avs = null;
  
  @SerializedName("cardHolderNameRequired")
  private Boolean cardHolderNameRequired = null;
  
  @SerializedName("installments")
  private Installments installments = null;
  
  public ModelConfiguration avs(Avs avs) {
    this.avs = avs;
    return this;
  }

  
  /**
  * Get avs
  * @return avs
  **/
  public Avs getAvs() {
    return avs;
  }
  public void setAvs(Avs avs) {
    this.avs = avs;
  }
  
  public ModelConfiguration cardHolderNameRequired(Boolean cardHolderNameRequired) {
    this.cardHolderNameRequired = cardHolderNameRequired;
    return this;
  }

  
  /**
  * When set to true, the shopper has to provide the cardholder name for card payments.
  * @return cardHolderNameRequired
  **/
  public Boolean isCardHolderNameRequired() {
    return cardHolderNameRequired;
  }
  public void setCardHolderNameRequired(Boolean cardHolderNameRequired) {
    this.cardHolderNameRequired = cardHolderNameRequired;
  }
  
  public ModelConfiguration installments(Installments installments) {
    this.installments = installments;
    return this;
  }

  
  /**
  * Get installments
  * @return installments
  **/
  public Installments getInstallments() {
    return installments;
  }
  public void setInstallments(Installments installments) {
    this.installments = installments;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelConfiguration _configuration = (ModelConfiguration) o;
    return Objects.equals(this.avs, _configuration.avs) &&
        Objects.equals(this.cardHolderNameRequired, _configuration.cardHolderNameRequired) &&
        Objects.equals(this.installments, _configuration.installments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(avs, cardHolderNameRequired, installments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelConfiguration {\n");

    sb.append("    avs: ").append(toIndentedString(avs)).append("\n");
    sb.append("    cardHolderNameRequired: ").append(toIndentedString(cardHolderNameRequired)).append("\n");
    sb.append("    installments: ").append(toIndentedString(installments)).append("\n");
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



