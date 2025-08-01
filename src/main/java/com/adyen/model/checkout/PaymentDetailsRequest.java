/*
 * Adyen Checkout API
 *
 * The version of the OpenAPI document: 71
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.checkout;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** PaymentDetailsRequest */
@JsonPropertyOrder({
  PaymentDetailsRequest.JSON_PROPERTY_AUTHENTICATION_DATA,
  PaymentDetailsRequest.JSON_PROPERTY_DETAILS,
  PaymentDetailsRequest.JSON_PROPERTY_PAYMENT_DATA,
  PaymentDetailsRequest.JSON_PROPERTY_THREE_D_S_AUTHENTICATION_ONLY
})
public class PaymentDetailsRequest {
  public static final String JSON_PROPERTY_AUTHENTICATION_DATA = "authenticationData";
  private DetailsRequestAuthenticationData authenticationData;

  public static final String JSON_PROPERTY_DETAILS = "details";
  private PaymentCompletionDetails details;

  public static final String JSON_PROPERTY_PAYMENT_DATA = "paymentData";
  private String paymentData;

  public static final String JSON_PROPERTY_THREE_D_S_AUTHENTICATION_ONLY =
      "threeDSAuthenticationOnly";
  @Deprecated // deprecated since Adyen Checkout API v69: Use
  // `authenticationData.authenticationOnly` instead.
  private Boolean threeDSAuthenticationOnly;

  public PaymentDetailsRequest() {}

  /**
   * authenticationData
   *
   * @param authenticationData
   * @return the current {@code PaymentDetailsRequest} instance, allowing for method chaining
   */
  public PaymentDetailsRequest authenticationData(
      DetailsRequestAuthenticationData authenticationData) {
    this.authenticationData = authenticationData;
    return this;
  }

  /**
   * Get authenticationData
   *
   * @return authenticationData
   */
  @JsonProperty(JSON_PROPERTY_AUTHENTICATION_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public DetailsRequestAuthenticationData getAuthenticationData() {
    return authenticationData;
  }

  /**
   * authenticationData
   *
   * @param authenticationData
   */
  @JsonProperty(JSON_PROPERTY_AUTHENTICATION_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAuthenticationData(DetailsRequestAuthenticationData authenticationData) {
    this.authenticationData = authenticationData;
  }

  /**
   * details
   *
   * @param details
   * @return the current {@code PaymentDetailsRequest} instance, allowing for method chaining
   */
  public PaymentDetailsRequest details(PaymentCompletionDetails details) {
    this.details = details;
    return this;
  }

  /**
   * Get details
   *
   * @return details
   */
  @JsonProperty(JSON_PROPERTY_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public PaymentCompletionDetails getDetails() {
    return details;
  }

  /**
   * details
   *
   * @param details
   */
  @JsonProperty(JSON_PROPERTY_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDetails(PaymentCompletionDetails details) {
    this.details = details;
  }

  /**
   * Encoded payment data. For [authorizing a payment after using 3D Secure 2
   * Authentication-only](https://docs.adyen.com/online-payments/3d-secure/other-3ds-flows/authentication-only/#authorise-the-payment-with-adyen):
   * If you received &#x60;resultCode&#x60;: **AuthenticationNotRequired** in the
   * &#x60;/payments&#x60; response, use the &#x60;threeDSPaymentData&#x60; from the same response.
   * If you received &#x60;resultCode&#x60;: **AuthenticationFinished** in the &#x60;/payments&#x60;
   * response, use the &#x60;action.paymentData&#x60; from the same response.
   *
   * @param paymentData Encoded payment data. For [authorizing a payment after using 3D Secure 2
   *     Authentication-only](https://docs.adyen.com/online-payments/3d-secure/other-3ds-flows/authentication-only/#authorise-the-payment-with-adyen):
   *     If you received &#x60;resultCode&#x60;: **AuthenticationNotRequired** in the
   *     &#x60;/payments&#x60; response, use the &#x60;threeDSPaymentData&#x60; from the same
   *     response. If you received &#x60;resultCode&#x60;: **AuthenticationFinished** in the
   *     &#x60;/payments&#x60; response, use the &#x60;action.paymentData&#x60; from the same
   *     response.
   * @return the current {@code PaymentDetailsRequest} instance, allowing for method chaining
   */
  public PaymentDetailsRequest paymentData(String paymentData) {
    this.paymentData = paymentData;
    return this;
  }

  /**
   * Encoded payment data. For [authorizing a payment after using 3D Secure 2
   * Authentication-only](https://docs.adyen.com/online-payments/3d-secure/other-3ds-flows/authentication-only/#authorise-the-payment-with-adyen):
   * If you received &#x60;resultCode&#x60;: **AuthenticationNotRequired** in the
   * &#x60;/payments&#x60; response, use the &#x60;threeDSPaymentData&#x60; from the same response.
   * If you received &#x60;resultCode&#x60;: **AuthenticationFinished** in the &#x60;/payments&#x60;
   * response, use the &#x60;action.paymentData&#x60; from the same response.
   *
   * @return paymentData Encoded payment data. For [authorizing a payment after using 3D Secure 2
   *     Authentication-only](https://docs.adyen.com/online-payments/3d-secure/other-3ds-flows/authentication-only/#authorise-the-payment-with-adyen):
   *     If you received &#x60;resultCode&#x60;: **AuthenticationNotRequired** in the
   *     &#x60;/payments&#x60; response, use the &#x60;threeDSPaymentData&#x60; from the same
   *     response. If you received &#x60;resultCode&#x60;: **AuthenticationFinished** in the
   *     &#x60;/payments&#x60; response, use the &#x60;action.paymentData&#x60; from the same
   *     response.
   */
  @JsonProperty(JSON_PROPERTY_PAYMENT_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPaymentData() {
    return paymentData;
  }

  /**
   * Encoded payment data. For [authorizing a payment after using 3D Secure 2
   * Authentication-only](https://docs.adyen.com/online-payments/3d-secure/other-3ds-flows/authentication-only/#authorise-the-payment-with-adyen):
   * If you received &#x60;resultCode&#x60;: **AuthenticationNotRequired** in the
   * &#x60;/payments&#x60; response, use the &#x60;threeDSPaymentData&#x60; from the same response.
   * If you received &#x60;resultCode&#x60;: **AuthenticationFinished** in the &#x60;/payments&#x60;
   * response, use the &#x60;action.paymentData&#x60; from the same response.
   *
   * @param paymentData Encoded payment data. For [authorizing a payment after using 3D Secure 2
   *     Authentication-only](https://docs.adyen.com/online-payments/3d-secure/other-3ds-flows/authentication-only/#authorise-the-payment-with-adyen):
   *     If you received &#x60;resultCode&#x60;: **AuthenticationNotRequired** in the
   *     &#x60;/payments&#x60; response, use the &#x60;threeDSPaymentData&#x60; from the same
   *     response. If you received &#x60;resultCode&#x60;: **AuthenticationFinished** in the
   *     &#x60;/payments&#x60; response, use the &#x60;action.paymentData&#x60; from the same
   *     response.
   */
  @JsonProperty(JSON_PROPERTY_PAYMENT_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPaymentData(String paymentData) {
    this.paymentData = paymentData;
  }

  /**
   * Change the &#x60;authenticationOnly&#x60; indicator originally set in the &#x60;/payments&#x60;
   * request. Only needs to be set if you want to modify the value set previously.
   *
   * @param threeDSAuthenticationOnly Change the &#x60;authenticationOnly&#x60; indicator originally
   *     set in the &#x60;/payments&#x60; request. Only needs to be set if you want to modify the
   *     value set previously.
   * @return the current {@code PaymentDetailsRequest} instance, allowing for method chaining
   * @deprecated since Adyen Checkout API v69 Use &#x60;authenticationData.authenticationOnly&#x60;
   *     instead.
   */
  @Deprecated // deprecated since Adyen Checkout API v69: Use
  // `authenticationData.authenticationOnly` instead.
  public PaymentDetailsRequest threeDSAuthenticationOnly(Boolean threeDSAuthenticationOnly) {
    this.threeDSAuthenticationOnly = threeDSAuthenticationOnly;
    return this;
  }

  /**
   * Change the &#x60;authenticationOnly&#x60; indicator originally set in the &#x60;/payments&#x60;
   * request. Only needs to be set if you want to modify the value set previously.
   *
   * @return threeDSAuthenticationOnly Change the &#x60;authenticationOnly&#x60; indicator
   *     originally set in the &#x60;/payments&#x60; request. Only needs to be set if you want to
   *     modify the value set previously.
   * @deprecated // deprecated since Adyen Checkout API v69: Use
   *     `authenticationData.authenticationOnly` instead.
   */
  @Deprecated // deprecated since Adyen Checkout API v69: Use
  // `authenticationData.authenticationOnly` instead.
  @JsonProperty(JSON_PROPERTY_THREE_D_S_AUTHENTICATION_ONLY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getThreeDSAuthenticationOnly() {
    return threeDSAuthenticationOnly;
  }

  /**
   * Change the &#x60;authenticationOnly&#x60; indicator originally set in the &#x60;/payments&#x60;
   * request. Only needs to be set if you want to modify the value set previously.
   *
   * @param threeDSAuthenticationOnly Change the &#x60;authenticationOnly&#x60; indicator originally
   *     set in the &#x60;/payments&#x60; request. Only needs to be set if you want to modify the
   *     value set previously.
   * @deprecated since Adyen Checkout API v69 Use &#x60;authenticationData.authenticationOnly&#x60;
   *     instead.
   */
  @Deprecated // deprecated since Adyen Checkout API v69: Use
  // `authenticationData.authenticationOnly` instead.
  @JsonProperty(JSON_PROPERTY_THREE_D_S_AUTHENTICATION_ONLY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setThreeDSAuthenticationOnly(Boolean threeDSAuthenticationOnly) {
    this.threeDSAuthenticationOnly = threeDSAuthenticationOnly;
  }

  /** Return true if this PaymentDetailsRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentDetailsRequest paymentDetailsRequest = (PaymentDetailsRequest) o;
    return Objects.equals(this.authenticationData, paymentDetailsRequest.authenticationData)
        && Objects.equals(this.details, paymentDetailsRequest.details)
        && Objects.equals(this.paymentData, paymentDetailsRequest.paymentData)
        && Objects.equals(
            this.threeDSAuthenticationOnly, paymentDetailsRequest.threeDSAuthenticationOnly);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authenticationData, details, paymentData, threeDSAuthenticationOnly);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentDetailsRequest {\n");
    sb.append("    authenticationData: ").append(toIndentedString(authenticationData)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    paymentData: ").append(toIndentedString(paymentData)).append("\n");
    sb.append("    threeDSAuthenticationOnly: ")
        .append(toIndentedString(threeDSAuthenticationOnly))
        .append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * Create an instance of PaymentDetailsRequest given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of PaymentDetailsRequest
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     PaymentDetailsRequest
   */
  public static PaymentDetailsRequest fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, PaymentDetailsRequest.class);
  }

  /**
   * Convert an instance of PaymentDetailsRequest to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
