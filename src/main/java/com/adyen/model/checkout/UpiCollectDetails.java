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

/** UpiCollectDetails */
@JsonPropertyOrder({
  UpiCollectDetails.JSON_PROPERTY_BILLING_SEQUENCE_NUMBER,
  UpiCollectDetails.JSON_PROPERTY_CHECKOUT_ATTEMPT_ID,
  UpiCollectDetails.JSON_PROPERTY_RECURRING_DETAIL_REFERENCE,
  UpiCollectDetails.JSON_PROPERTY_SHOPPER_NOTIFICATION_REFERENCE,
  UpiCollectDetails.JSON_PROPERTY_STORED_PAYMENT_METHOD_ID,
  UpiCollectDetails.JSON_PROPERTY_TYPE,
  UpiCollectDetails.JSON_PROPERTY_VIRTUAL_PAYMENT_ADDRESS
})
public class UpiCollectDetails {
  public static final String JSON_PROPERTY_BILLING_SEQUENCE_NUMBER = "billingSequenceNumber";
  private String billingSequenceNumber;

  public static final String JSON_PROPERTY_CHECKOUT_ATTEMPT_ID = "checkoutAttemptId";
  private String checkoutAttemptId;

  public static final String JSON_PROPERTY_RECURRING_DETAIL_REFERENCE = "recurringDetailReference";
  @Deprecated // deprecated since Adyen Checkout API v49: Use `storedPaymentMethodId` instead.
  private String recurringDetailReference;

  public static final String JSON_PROPERTY_SHOPPER_NOTIFICATION_REFERENCE =
      "shopperNotificationReference";
  private String shopperNotificationReference;

  public static final String JSON_PROPERTY_STORED_PAYMENT_METHOD_ID = "storedPaymentMethodId";
  private String storedPaymentMethodId;

  /** **upi_collect** */
  public enum TypeEnum {
    UPI_COLLECT(String.valueOf("upi_collect"));

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

  public static final String JSON_PROPERTY_VIRTUAL_PAYMENT_ADDRESS = "virtualPaymentAddress";
  private String virtualPaymentAddress;

  public UpiCollectDetails() {}

  /**
   * The sequence number for the debit. For example, send **2** if this is the second debit for the
   * subscription. The sequence number is included in the notification sent to the shopper.
   *
   * @param billingSequenceNumber The sequence number for the debit. For example, send **2** if this
   *     is the second debit for the subscription. The sequence number is included in the
   *     notification sent to the shopper.
   * @return the current {@code UpiCollectDetails} instance, allowing for method chaining
   */
  public UpiCollectDetails billingSequenceNumber(String billingSequenceNumber) {
    this.billingSequenceNumber = billingSequenceNumber;
    return this;
  }

  /**
   * The sequence number for the debit. For example, send **2** if this is the second debit for the
   * subscription. The sequence number is included in the notification sent to the shopper.
   *
   * @return billingSequenceNumber The sequence number for the debit. For example, send **2** if
   *     this is the second debit for the subscription. The sequence number is included in the
   *     notification sent to the shopper.
   */
  @JsonProperty(JSON_PROPERTY_BILLING_SEQUENCE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getBillingSequenceNumber() {
    return billingSequenceNumber;
  }

  /**
   * The sequence number for the debit. For example, send **2** if this is the second debit for the
   * subscription. The sequence number is included in the notification sent to the shopper.
   *
   * @param billingSequenceNumber The sequence number for the debit. For example, send **2** if this
   *     is the second debit for the subscription. The sequence number is included in the
   *     notification sent to the shopper.
   */
  @JsonProperty(JSON_PROPERTY_BILLING_SEQUENCE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBillingSequenceNumber(String billingSequenceNumber) {
    this.billingSequenceNumber = billingSequenceNumber;
  }

  /**
   * The checkout attempt identifier.
   *
   * @param checkoutAttemptId The checkout attempt identifier.
   * @return the current {@code UpiCollectDetails} instance, allowing for method chaining
   */
  public UpiCollectDetails checkoutAttemptId(String checkoutAttemptId) {
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
   * @return the current {@code UpiCollectDetails} instance, allowing for method chaining
   * @deprecated since Adyen Checkout API v49 Use &#x60;storedPaymentMethodId&#x60; instead.
   */
  @Deprecated // deprecated since Adyen Checkout API v49: Use `storedPaymentMethodId` instead.
  public UpiCollectDetails recurringDetailReference(String recurringDetailReference) {
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
   * The &#x60;shopperNotificationReference&#x60; returned in the response when you requested to
   * notify the shopper. Used for recurring payment only.
   *
   * @param shopperNotificationReference The &#x60;shopperNotificationReference&#x60; returned in
   *     the response when you requested to notify the shopper. Used for recurring payment only.
   * @return the current {@code UpiCollectDetails} instance, allowing for method chaining
   */
  public UpiCollectDetails shopperNotificationReference(String shopperNotificationReference) {
    this.shopperNotificationReference = shopperNotificationReference;
    return this;
  }

  /**
   * The &#x60;shopperNotificationReference&#x60; returned in the response when you requested to
   * notify the shopper. Used for recurring payment only.
   *
   * @return shopperNotificationReference The &#x60;shopperNotificationReference&#x60; returned in
   *     the response when you requested to notify the shopper. Used for recurring payment only.
   */
  @JsonProperty(JSON_PROPERTY_SHOPPER_NOTIFICATION_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getShopperNotificationReference() {
    return shopperNotificationReference;
  }

  /**
   * The &#x60;shopperNotificationReference&#x60; returned in the response when you requested to
   * notify the shopper. Used for recurring payment only.
   *
   * @param shopperNotificationReference The &#x60;shopperNotificationReference&#x60; returned in
   *     the response when you requested to notify the shopper. Used for recurring payment only.
   */
  @JsonProperty(JSON_PROPERTY_SHOPPER_NOTIFICATION_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setShopperNotificationReference(String shopperNotificationReference) {
    this.shopperNotificationReference = shopperNotificationReference;
  }

  /**
   * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the
   * token.
   *
   * @param storedPaymentMethodId This is the &#x60;recurringDetailReference&#x60; returned in the
   *     response when you created the token.
   * @return the current {@code UpiCollectDetails} instance, allowing for method chaining
   */
  public UpiCollectDetails storedPaymentMethodId(String storedPaymentMethodId) {
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
   * **upi_collect**
   *
   * @param type **upi_collect**
   * @return the current {@code UpiCollectDetails} instance, allowing for method chaining
   */
  public UpiCollectDetails type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * **upi_collect**
   *
   * @return type **upi_collect**
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public TypeEnum getType() {
    return type;
  }

  /**
   * **upi_collect**
   *
   * @param type **upi_collect**
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(TypeEnum type) {
    this.type = type;
  }

  /**
   * The virtual payment address for UPI.
   *
   * @param virtualPaymentAddress The virtual payment address for UPI.
   * @return the current {@code UpiCollectDetails} instance, allowing for method chaining
   */
  public UpiCollectDetails virtualPaymentAddress(String virtualPaymentAddress) {
    this.virtualPaymentAddress = virtualPaymentAddress;
    return this;
  }

  /**
   * The virtual payment address for UPI.
   *
   * @return virtualPaymentAddress The virtual payment address for UPI.
   */
  @JsonProperty(JSON_PROPERTY_VIRTUAL_PAYMENT_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getVirtualPaymentAddress() {
    return virtualPaymentAddress;
  }

  /**
   * The virtual payment address for UPI.
   *
   * @param virtualPaymentAddress The virtual payment address for UPI.
   */
  @JsonProperty(JSON_PROPERTY_VIRTUAL_PAYMENT_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVirtualPaymentAddress(String virtualPaymentAddress) {
    this.virtualPaymentAddress = virtualPaymentAddress;
  }

  /** Return true if this UpiCollectDetails object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpiCollectDetails upiCollectDetails = (UpiCollectDetails) o;
    return Objects.equals(this.billingSequenceNumber, upiCollectDetails.billingSequenceNumber)
        && Objects.equals(this.checkoutAttemptId, upiCollectDetails.checkoutAttemptId)
        && Objects.equals(this.recurringDetailReference, upiCollectDetails.recurringDetailReference)
        && Objects.equals(
            this.shopperNotificationReference, upiCollectDetails.shopperNotificationReference)
        && Objects.equals(this.storedPaymentMethodId, upiCollectDetails.storedPaymentMethodId)
        && Objects.equals(this.type, upiCollectDetails.type)
        && Objects.equals(this.virtualPaymentAddress, upiCollectDetails.virtualPaymentAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        billingSequenceNumber,
        checkoutAttemptId,
        recurringDetailReference,
        shopperNotificationReference,
        storedPaymentMethodId,
        type,
        virtualPaymentAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpiCollectDetails {\n");
    sb.append("    billingSequenceNumber: ")
        .append(toIndentedString(billingSequenceNumber))
        .append("\n");
    sb.append("    checkoutAttemptId: ").append(toIndentedString(checkoutAttemptId)).append("\n");
    sb.append("    recurringDetailReference: ")
        .append(toIndentedString(recurringDetailReference))
        .append("\n");
    sb.append("    shopperNotificationReference: ")
        .append(toIndentedString(shopperNotificationReference))
        .append("\n");
    sb.append("    storedPaymentMethodId: ")
        .append(toIndentedString(storedPaymentMethodId))
        .append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    virtualPaymentAddress: ")
        .append(toIndentedString(virtualPaymentAddress))
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
   * Create an instance of UpiCollectDetails given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of UpiCollectDetails
   * @throws JsonProcessingException if the JSON string is invalid with respect to UpiCollectDetails
   */
  public static UpiCollectDetails fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, UpiCollectDetails.class);
  }

  /**
   * Convert an instance of UpiCollectDetails to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
