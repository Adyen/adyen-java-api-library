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

/** PayToDetails */
@JsonPropertyOrder({
  PayToDetails.JSON_PROPERTY_CHECKOUT_ATTEMPT_ID,
  PayToDetails.JSON_PROPERTY_RECURRING_DETAIL_REFERENCE,
  PayToDetails.JSON_PROPERTY_SHOPPER_ACCOUNT_IDENTIFIER,
  PayToDetails.JSON_PROPERTY_STORED_PAYMENT_METHOD_ID,
  PayToDetails.JSON_PROPERTY_TYPE
})
public class PayToDetails {
  public static final String JSON_PROPERTY_CHECKOUT_ATTEMPT_ID = "checkoutAttemptId";
  private String checkoutAttemptId;

  public static final String JSON_PROPERTY_RECURRING_DETAIL_REFERENCE = "recurringDetailReference";
  @Deprecated // deprecated since Adyen Checkout API v49: Use `storedPaymentMethodId` instead.
  private String recurringDetailReference;

  public static final String JSON_PROPERTY_SHOPPER_ACCOUNT_IDENTIFIER = "shopperAccountIdentifier";
  private String shopperAccountIdentifier;

  public static final String JSON_PROPERTY_STORED_PAYMENT_METHOD_ID = "storedPaymentMethodId";
  private String storedPaymentMethodId;

  /** **payto** */
  public enum TypeEnum {
    PAYTO(String.valueOf("payto"));

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

  public PayToDetails() {}

  /**
   * The checkout attempt identifier.
   *
   * @param checkoutAttemptId The checkout attempt identifier.
   * @return the current {@code PayToDetails} instance, allowing for method chaining
   */
  public PayToDetails checkoutAttemptId(String checkoutAttemptId) {
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
   * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the
   * token.
   *
   * @param recurringDetailReference This is the &#x60;recurringDetailReference&#x60; returned in
   *     the response when you created the token.
   * @return the current {@code PayToDetails} instance, allowing for method chaining
   * @deprecated since Adyen Checkout API v49 Use &#x60;storedPaymentMethodId&#x60; instead.
   */
  @Deprecated // deprecated since Adyen Checkout API v49: Use `storedPaymentMethodId` instead.
  public PayToDetails recurringDetailReference(String recurringDetailReference) {
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
   * The shopper&#39;s banking details or payId reference, used to complete payment.
   *
   * @param shopperAccountIdentifier The shopper&#39;s banking details or payId reference, used to
   *     complete payment.
   * @return the current {@code PayToDetails} instance, allowing for method chaining
   */
  public PayToDetails shopperAccountIdentifier(String shopperAccountIdentifier) {
    this.shopperAccountIdentifier = shopperAccountIdentifier;
    return this;
  }

  /**
   * The shopper&#39;s banking details or payId reference, used to complete payment.
   *
   * @return shopperAccountIdentifier The shopper&#39;s banking details or payId reference, used to
   *     complete payment.
   */
  @JsonProperty(JSON_PROPERTY_SHOPPER_ACCOUNT_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getShopperAccountIdentifier() {
    return shopperAccountIdentifier;
  }

  /**
   * The shopper&#39;s banking details or payId reference, used to complete payment.
   *
   * @param shopperAccountIdentifier The shopper&#39;s banking details or payId reference, used to
   *     complete payment.
   */
  @JsonProperty(JSON_PROPERTY_SHOPPER_ACCOUNT_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setShopperAccountIdentifier(String shopperAccountIdentifier) {
    this.shopperAccountIdentifier = shopperAccountIdentifier;
  }

  /**
   * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the
   * token.
   *
   * @param storedPaymentMethodId This is the &#x60;recurringDetailReference&#x60; returned in the
   *     response when you created the token.
   * @return the current {@code PayToDetails} instance, allowing for method chaining
   */
  public PayToDetails storedPaymentMethodId(String storedPaymentMethodId) {
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
   * **payto**
   *
   * @param type **payto**
   * @return the current {@code PayToDetails} instance, allowing for method chaining
   */
  public PayToDetails type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * **payto**
   *
   * @return type **payto**
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public TypeEnum getType() {
    return type;
  }

  /**
   * **payto**
   *
   * @param type **payto**
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(TypeEnum type) {
    this.type = type;
  }

  /** Return true if this PayToDetails object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PayToDetails payToDetails = (PayToDetails) o;
    return Objects.equals(this.checkoutAttemptId, payToDetails.checkoutAttemptId)
        && Objects.equals(this.recurringDetailReference, payToDetails.recurringDetailReference)
        && Objects.equals(this.shopperAccountIdentifier, payToDetails.shopperAccountIdentifier)
        && Objects.equals(this.storedPaymentMethodId, payToDetails.storedPaymentMethodId)
        && Objects.equals(this.type, payToDetails.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        checkoutAttemptId,
        recurringDetailReference,
        shopperAccountIdentifier,
        storedPaymentMethodId,
        type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PayToDetails {\n");
    sb.append("    checkoutAttemptId: ").append(toIndentedString(checkoutAttemptId)).append("\n");
    sb.append("    recurringDetailReference: ")
        .append(toIndentedString(recurringDetailReference))
        .append("\n");
    sb.append("    shopperAccountIdentifier: ")
        .append(toIndentedString(shopperAccountIdentifier))
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
   * Create an instance of PayToDetails given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of PayToDetails
   * @throws JsonProcessingException if the JSON string is invalid with respect to PayToDetails
   */
  public static PayToDetails fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, PayToDetails.class);
  }

  /**
   * Convert an instance of PayToDetails to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
