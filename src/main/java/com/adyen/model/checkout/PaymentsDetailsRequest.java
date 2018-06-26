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

import com.google.gson.annotations.SerializedName;

import java.util.Map;
import java.util.Objects;

/**
 * PaymentsDetailsRequest
 */
public class PaymentsDetailsRequest {

  @SerializedName("details")
  private Map<String, String> details = null;
  
  @SerializedName("paymentData")
  private String paymentData = null;

  public PaymentsDetailsRequest details(Map<String, String> details) {
    this.details = details;
    return this;
  }

  public PaymentsDetailsRequest putDetailsItem(String key, String detailsItem) {
    
    this.details.put(key, detailsItem);
    return this;
  }
  /**
  * Use this collection to submit the details that were returned as a result of the &#x60;/payments&#x60; call.
  * @return details
  **/
    public Map<String, String> getDetails() {
    return details;
  }
  public void setDetails(Map<String, String> details) {
    this.details = details;
  }

  public PaymentsDetailsRequest paymentData(String paymentData) {
    this.paymentData = paymentData;
    return this;
  }

  
  /**
  * The &#x60;paymentData&#x60; value that you received in the response to the &#x60;/payments&#x60; call.
  * @return paymentData
  **/
    public String getPaymentData() {
    return paymentData;
  }
  public void setPaymentData(String paymentData) {
    this.paymentData = paymentData;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentsDetailsRequest paymentsDetailsRequest = (PaymentsDetailsRequest) o;
    return Objects.equals(this.details, paymentsDetailsRequest.details) &&
            Objects.equals(this.paymentData, paymentsDetailsRequest.paymentData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(details, paymentData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentsDetailsRequest {\n");

    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    paymentData: ").append(toIndentedString(paymentData)).append("\n");
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



