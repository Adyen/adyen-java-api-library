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

import com.adyen.model.Amount;
import com.google.gson.annotations.SerializedName;


import java.util.Objects;

/**
 * PaymentDetails
 */
public class PaymentDetails {

  @SerializedName("additionalAmount")
  private Amount additionalAmount = null;
  
  @SerializedName("amount")
  private Amount amount = null;
  
  @SerializedName("countryCode")
  private String countryCode = null;
  
  @SerializedName("reference")
  private String reference = null;
  
  @SerializedName("sessionValidity")
  private String sessionValidity = null;
  
  @SerializedName("shopperLocale")
  private String shopperLocale = null;
  
  @SerializedName("shopperReference")
  private String shopperReference = null;
  
  public PaymentDetails additionalAmount(Amount additionalAmount) {
    this.additionalAmount = additionalAmount;
    return this;
  }

  
  /**
  * Get additionalAmount
  * @return additionalAmount
  **/
  public Amount getAdditionalAmount() {
    return additionalAmount;
  }
  public void setAdditionalAmount(Amount additionalAmount) {
    this.additionalAmount = additionalAmount;
  }
  
  public PaymentDetails amount(Amount amount) {
    this.amount = amount;
    return this;
  }

  
  /**
  * Get amount
  * @return amount
  **/
  public Amount getAmount() {
    return amount;
  }
  public void setAmount(Amount amount) {
    this.amount = amount;
  }
  
  public PaymentDetails countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  
  /**
  * The shopper&#x27;s country code.
  * @return countryCode
  **/
  public String getCountryCode() {
    return countryCode;
  }
  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }
  
  public PaymentDetails reference(String reference) {
    this.reference = reference;
    return this;
  }

  
  /**
  * The reference assigned to the payment.
  * @return reference
  **/
  public String getReference() {
    return reference;
  }
  public void setReference(String reference) {
    this.reference = reference;
  }
  
  public PaymentDetails sessionValidity(String sessionValidity) {
    this.sessionValidity = sessionValidity;
    return this;
  }

  
  /**
  * The maximum validity of the session.
  * @return sessionValidity
  **/
  public String getSessionValidity() {
    return sessionValidity;
  }
  public void setSessionValidity(String sessionValidity) {
    this.sessionValidity = sessionValidity;
  }
  
  public PaymentDetails shopperLocale(String shopperLocale) {
    this.shopperLocale = shopperLocale;
    return this;
  }

  
  /**
  * The shopper&#x27;s locale.
  * @return shopperLocale
  **/
  public String getShopperLocale() {
    return shopperLocale;
  }
  public void setShopperLocale(String shopperLocale) {
    this.shopperLocale = shopperLocale;
  }
  
  public PaymentDetails shopperReference(String shopperReference) {
    this.shopperReference = shopperReference;
    return this;
  }

  
  /**
  * The reference used to uniquely identify the shopper (e.g. user ID or account ID).
  * @return shopperReference
  **/
  public String getShopperReference() {
    return shopperReference;
  }
  public void setShopperReference(String shopperReference) {
    this.shopperReference = shopperReference;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentDetails paymentDetails = (PaymentDetails) o;
    return Objects.equals(this.additionalAmount, paymentDetails.additionalAmount) &&
        Objects.equals(this.amount, paymentDetails.amount) &&
        Objects.equals(this.countryCode, paymentDetails.countryCode) &&
        Objects.equals(this.reference, paymentDetails.reference) &&
        Objects.equals(this.sessionValidity, paymentDetails.sessionValidity) &&
        Objects.equals(this.shopperLocale, paymentDetails.shopperLocale) &&
        Objects.equals(this.shopperReference, paymentDetails.shopperReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalAmount, amount, countryCode, reference, sessionValidity, shopperLocale, shopperReference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentDetails {\n");

    sb.append("    additionalAmount: ").append(toIndentedString(additionalAmount)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    sessionValidity: ").append(toIndentedString(sessionValidity)).append("\n");
    sb.append("    shopperLocale: ").append(toIndentedString(shopperLocale)).append("\n");
    sb.append("    shopperReference: ").append(toIndentedString(shopperReference)).append("\n");
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



