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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.util.Arrays;
import java.util.logging.Logger;

/** RatepayDetails */
@JsonPropertyOrder({
  RatepayDetails.JSON_PROPERTY_BILLING_ADDRESS,
  RatepayDetails.JSON_PROPERTY_CHECKOUT_ATTEMPT_ID,
  RatepayDetails.JSON_PROPERTY_DELIVERY_ADDRESS,
  RatepayDetails.JSON_PROPERTY_PERSONAL_DETAILS,
  RatepayDetails.JSON_PROPERTY_RECURRING_DETAIL_REFERENCE,
  RatepayDetails.JSON_PROPERTY_STORED_PAYMENT_METHOD_ID,
  RatepayDetails.JSON_PROPERTY_TYPE
})
public class RatepayDetails {
  public static final String JSON_PROPERTY_BILLING_ADDRESS = "billingAddress";
  private String billingAddress;

  public static final String JSON_PROPERTY_CHECKOUT_ATTEMPT_ID = "checkoutAttemptId";
  private String checkoutAttemptId;

  public static final String JSON_PROPERTY_DELIVERY_ADDRESS = "deliveryAddress";
  private String deliveryAddress;

  public static final String JSON_PROPERTY_PERSONAL_DETAILS = "personalDetails";
  private String personalDetails;

  public static final String JSON_PROPERTY_RECURRING_DETAIL_REFERENCE = "recurringDetailReference";
  @Deprecated // deprecated since Adyen Checkout API v49: Use `storedPaymentMethodId` instead.
  private String recurringDetailReference;

  public static final String JSON_PROPERTY_STORED_PAYMENT_METHOD_ID = "storedPaymentMethodId";
  private String storedPaymentMethodId;

  /** **ratepay** */
  public enum TypeEnum {
    RATEPAY(String.valueOf("ratepay")),

    RATEPAY_DIRECTDEBIT(String.valueOf("ratepay_directdebit"));

    private static final Logger LOG = Logger.getLogger(TypeEnum.class.getName());

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      // handling unexpected value
      LOG.warning(
          "TypeEnum: unexpected enum value '"
              + value
              + "' - Supported values are "
              + Arrays.toString(TypeEnum.values()));
      return null;
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  private TypeEnum type;

  public RatepayDetails() {}

  /**
   * The address where to send the invoice.
   *
   * @param billingAddress The address where to send the invoice.
   * @return the current {@code RatepayDetails} instance, allowing for method chaining
   */
  public RatepayDetails billingAddress(String billingAddress) {
    this.billingAddress = billingAddress;
    return this;
  }

  /**
   * The address where to send the invoice.
   *
   * @return billingAddress The address where to send the invoice.
   */
  @JsonProperty(JSON_PROPERTY_BILLING_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getBillingAddress() {
    return billingAddress;
  }

  /**
   * The address where to send the invoice.
   *
   * @param billingAddress The address where to send the invoice.
   */
  @JsonProperty(JSON_PROPERTY_BILLING_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBillingAddress(String billingAddress) {
    this.billingAddress = billingAddress;
  }

  /**
   * The checkout attempt identifier.
   *
   * @param checkoutAttemptId The checkout attempt identifier.
   * @return the current {@code RatepayDetails} instance, allowing for method chaining
   */
  public RatepayDetails checkoutAttemptId(String checkoutAttemptId) {
    this.checkoutAttemptId = checkoutAttemptId;
    return this;
  }

  /**
   * The checkout attempt identifier.
   *
   * @return checkoutAttemptId The checkout attempt identifier.
   */
  @JsonProperty(JSON_PROPERTY_CHECKOUT_ATTEMPT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCheckoutAttemptId() {
    return checkoutAttemptId;
  }

  /**
   * The checkout attempt identifier.
   *
   * @param checkoutAttemptId The checkout attempt identifier.
   */
  @JsonProperty(JSON_PROPERTY_CHECKOUT_ATTEMPT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCheckoutAttemptId(String checkoutAttemptId) {
    this.checkoutAttemptId = checkoutAttemptId;
  }

  /**
   * The address where the goods should be delivered.
   *
   * @param deliveryAddress The address where the goods should be delivered.
   * @return the current {@code RatepayDetails} instance, allowing for method chaining
   */
  public RatepayDetails deliveryAddress(String deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
    return this;
  }

  /**
   * The address where the goods should be delivered.
   *
   * @return deliveryAddress The address where the goods should be delivered.
   */
  @JsonProperty(JSON_PROPERTY_DELIVERY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDeliveryAddress() {
    return deliveryAddress;
  }

  /**
   * The address where the goods should be delivered.
   *
   * @param deliveryAddress The address where the goods should be delivered.
   */
  @JsonProperty(JSON_PROPERTY_DELIVERY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDeliveryAddress(String deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
  }

  /**
   * Shopper name, date of birth, phone number, and email address.
   *
   * @param personalDetails Shopper name, date of birth, phone number, and email address.
   * @return the current {@code RatepayDetails} instance, allowing for method chaining
   */
  public RatepayDetails personalDetails(String personalDetails) {
    this.personalDetails = personalDetails;
    return this;
  }

  /**
   * Shopper name, date of birth, phone number, and email address.
   *
   * @return personalDetails Shopper name, date of birth, phone number, and email address.
   */
  @JsonProperty(JSON_PROPERTY_PERSONAL_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPersonalDetails() {
    return personalDetails;
  }

  /**
   * Shopper name, date of birth, phone number, and email address.
   *
   * @param personalDetails Shopper name, date of birth, phone number, and email address.
   */
  @JsonProperty(JSON_PROPERTY_PERSONAL_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPersonalDetails(String personalDetails) {
    this.personalDetails = personalDetails;
  }

  /**
   * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the
   * token.
   *
   * @param recurringDetailReference This is the &#x60;recurringDetailReference&#x60; returned in
   *     the response when you created the token.
   * @return the current {@code RatepayDetails} instance, allowing for method chaining
   * @deprecated since Adyen Checkout API v49 Use &#x60;storedPaymentMethodId&#x60; instead.
   */
  @Deprecated // deprecated since Adyen Checkout API v49: Use `storedPaymentMethodId` instead.
  public RatepayDetails recurringDetailReference(String recurringDetailReference) {
    this.recurringDetailReference = recurringDetailReference;
    return this;
  }

  /**
   * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the
   * token.
   *
   * @return recurringDetailReference This is the &#x60;recurringDetailReference&#x60; returned in
   *     the response when you created the token.
   * @deprecated // deprecated since Adyen Checkout API v49: Use `storedPaymentMethodId` instead.
   */
  @Deprecated // deprecated since Adyen Checkout API v49: Use `storedPaymentMethodId` instead.
  @JsonProperty(JSON_PROPERTY_RECURRING_DETAIL_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getRecurringDetailReference() {
    return recurringDetailReference;
  }

  /**
   * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the
   * token.
   *
   * @param recurringDetailReference This is the &#x60;recurringDetailReference&#x60; returned in
   *     the response when you created the token.
   * @deprecated since Adyen Checkout API v49 Use &#x60;storedPaymentMethodId&#x60; instead.
   */
  @Deprecated // deprecated since Adyen Checkout API v49: Use `storedPaymentMethodId` instead.
  @JsonProperty(JSON_PROPERTY_RECURRING_DETAIL_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRecurringDetailReference(String recurringDetailReference) {
    this.recurringDetailReference = recurringDetailReference;
  }

  /**
   * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the
   * token.
   *
   * @param storedPaymentMethodId This is the &#x60;recurringDetailReference&#x60; returned in the
   *     response when you created the token.
   * @return the current {@code RatepayDetails} instance, allowing for method chaining
   */
  public RatepayDetails storedPaymentMethodId(String storedPaymentMethodId) {
    this.storedPaymentMethodId = storedPaymentMethodId;
    return this;
  }

  /**
   * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the
   * token.
   *
   * @return storedPaymentMethodId This is the &#x60;recurringDetailReference&#x60; returned in the
   *     response when you created the token.
   */
  @JsonProperty(JSON_PROPERTY_STORED_PAYMENT_METHOD_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getStoredPaymentMethodId() {
    return storedPaymentMethodId;
  }

  /**
   * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the
   * token.
   *
   * @param storedPaymentMethodId This is the &#x60;recurringDetailReference&#x60; returned in the
   *     response when you created the token.
   */
  @JsonProperty(JSON_PROPERTY_STORED_PAYMENT_METHOD_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStoredPaymentMethodId(String storedPaymentMethodId) {
    this.storedPaymentMethodId = storedPaymentMethodId;
  }

  /**
   * **ratepay**
   *
   * @param type **ratepay**
   * @return the current {@code RatepayDetails} instance, allowing for method chaining
   */
  public RatepayDetails type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * **ratepay**
   *
   * @return type **ratepay**
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public TypeEnum getType() {
    return type;
  }

  /**
   * **ratepay**
   *
   * @param type **ratepay**
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(TypeEnum type) {
    this.type = type;
  }

  /** Return true if this RatepayDetails object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RatepayDetails ratepayDetails = (RatepayDetails) o;
    return Objects.equals(this.billingAddress, ratepayDetails.billingAddress)
        && Objects.equals(this.checkoutAttemptId, ratepayDetails.checkoutAttemptId)
        && Objects.equals(this.deliveryAddress, ratepayDetails.deliveryAddress)
        && Objects.equals(this.personalDetails, ratepayDetails.personalDetails)
        && Objects.equals(this.recurringDetailReference, ratepayDetails.recurringDetailReference)
        && Objects.equals(this.storedPaymentMethodId, ratepayDetails.storedPaymentMethodId)
        && Objects.equals(this.type, ratepayDetails.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        billingAddress,
        checkoutAttemptId,
        deliveryAddress,
        personalDetails,
        recurringDetailReference,
        storedPaymentMethodId,
        type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RatepayDetails {\n");
    sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
    sb.append("    checkoutAttemptId: ").append(toIndentedString(checkoutAttemptId)).append("\n");
    sb.append("    deliveryAddress: ").append(toIndentedString(deliveryAddress)).append("\n");
    sb.append("    personalDetails: ").append(toIndentedString(personalDetails)).append("\n");
    sb.append("    recurringDetailReference: ")
        .append(toIndentedString(recurringDetailReference))
        .append("\n");
    sb.append("    storedPaymentMethodId: ")
        .append(toIndentedString(storedPaymentMethodId))
        .append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
   * Create an instance of RatepayDetails given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of RatepayDetails
   * @throws JsonProcessingException if the JSON string is invalid with respect to RatepayDetails
   */
  public static RatepayDetails fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, RatepayDetails.class);
  }

  /**
   * Convert an instance of RatepayDetails to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
