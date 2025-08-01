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

/** CheckoutQrCodeAction */
@JsonPropertyOrder({
  CheckoutQrCodeAction.JSON_PROPERTY_EXPIRES_AT,
  CheckoutQrCodeAction.JSON_PROPERTY_PAYMENT_DATA,
  CheckoutQrCodeAction.JSON_PROPERTY_PAYMENT_METHOD_TYPE,
  CheckoutQrCodeAction.JSON_PROPERTY_QR_CODE_DATA,
  CheckoutQrCodeAction.JSON_PROPERTY_TYPE,
  CheckoutQrCodeAction.JSON_PROPERTY_URL
})
public class CheckoutQrCodeAction {
  public static final String JSON_PROPERTY_EXPIRES_AT = "expiresAt";
  private String expiresAt;

  public static final String JSON_PROPERTY_PAYMENT_DATA = "paymentData";
  private String paymentData;

  public static final String JSON_PROPERTY_PAYMENT_METHOD_TYPE = "paymentMethodType";
  private String paymentMethodType;

  public static final String JSON_PROPERTY_QR_CODE_DATA = "qrCodeData";
  private String qrCodeData;

  /** **qrCode** */
  public enum TypeEnum {
    QRCODE(String.valueOf("qrCode"));

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

  public static final String JSON_PROPERTY_URL = "url";
  private String url;

  public CheckoutQrCodeAction() {}

  /**
   * Expiry time of the QR code.
   *
   * @param expiresAt Expiry time of the QR code.
   * @return the current {@code CheckoutQrCodeAction} instance, allowing for method chaining
   */
  public CheckoutQrCodeAction expiresAt(String expiresAt) {
    this.expiresAt = expiresAt;
    return this;
  }

  /**
   * Expiry time of the QR code.
   *
   * @return expiresAt Expiry time of the QR code.
   */
  @JsonProperty(JSON_PROPERTY_EXPIRES_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getExpiresAt() {
    return expiresAt;
  }

  /**
   * Expiry time of the QR code.
   *
   * @param expiresAt Expiry time of the QR code.
   */
  @JsonProperty(JSON_PROPERTY_EXPIRES_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExpiresAt(String expiresAt) {
    this.expiresAt = expiresAt;
  }

  /**
   * Encoded payment data.
   *
   * @param paymentData Encoded payment data.
   * @return the current {@code CheckoutQrCodeAction} instance, allowing for method chaining
   */
  public CheckoutQrCodeAction paymentData(String paymentData) {
    this.paymentData = paymentData;
    return this;
  }

  /**
   * Encoded payment data.
   *
   * @return paymentData Encoded payment data.
   */
  @JsonProperty(JSON_PROPERTY_PAYMENT_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPaymentData() {
    return paymentData;
  }

  /**
   * Encoded payment data.
   *
   * @param paymentData Encoded payment data.
   */
  @JsonProperty(JSON_PROPERTY_PAYMENT_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPaymentData(String paymentData) {
    this.paymentData = paymentData;
  }

  /**
   * Specifies the payment method.
   *
   * @param paymentMethodType Specifies the payment method.
   * @return the current {@code CheckoutQrCodeAction} instance, allowing for method chaining
   */
  public CheckoutQrCodeAction paymentMethodType(String paymentMethodType) {
    this.paymentMethodType = paymentMethodType;
    return this;
  }

  /**
   * Specifies the payment method.
   *
   * @return paymentMethodType Specifies the payment method.
   */
  @JsonProperty(JSON_PROPERTY_PAYMENT_METHOD_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPaymentMethodType() {
    return paymentMethodType;
  }

  /**
   * Specifies the payment method.
   *
   * @param paymentMethodType Specifies the payment method.
   */
  @JsonProperty(JSON_PROPERTY_PAYMENT_METHOD_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPaymentMethodType(String paymentMethodType) {
    this.paymentMethodType = paymentMethodType;
  }

  /**
   * The contents of the QR code as a UTF8 string.
   *
   * @param qrCodeData The contents of the QR code as a UTF8 string.
   * @return the current {@code CheckoutQrCodeAction} instance, allowing for method chaining
   */
  public CheckoutQrCodeAction qrCodeData(String qrCodeData) {
    this.qrCodeData = qrCodeData;
    return this;
  }

  /**
   * The contents of the QR code as a UTF8 string.
   *
   * @return qrCodeData The contents of the QR code as a UTF8 string.
   */
  @JsonProperty(JSON_PROPERTY_QR_CODE_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getQrCodeData() {
    return qrCodeData;
  }

  /**
   * The contents of the QR code as a UTF8 string.
   *
   * @param qrCodeData The contents of the QR code as a UTF8 string.
   */
  @JsonProperty(JSON_PROPERTY_QR_CODE_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setQrCodeData(String qrCodeData) {
    this.qrCodeData = qrCodeData;
  }

  /**
   * **qrCode**
   *
   * @param type **qrCode**
   * @return the current {@code CheckoutQrCodeAction} instance, allowing for method chaining
   */
  public CheckoutQrCodeAction type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * **qrCode**
   *
   * @return type **qrCode**
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public TypeEnum getType() {
    return type;
  }

  /**
   * **qrCode**
   *
   * @param type **qrCode**
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(TypeEnum type) {
    this.type = type;
  }

  /**
   * Specifies the URL to redirect to.
   *
   * @param url Specifies the URL to redirect to.
   * @return the current {@code CheckoutQrCodeAction} instance, allowing for method chaining
   */
  public CheckoutQrCodeAction url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Specifies the URL to redirect to.
   *
   * @return url Specifies the URL to redirect to.
   */
  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getUrl() {
    return url;
  }

  /**
   * Specifies the URL to redirect to.
   *
   * @param url Specifies the URL to redirect to.
   */
  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUrl(String url) {
    this.url = url;
  }

  /** Return true if this CheckoutQrCodeAction object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckoutQrCodeAction checkoutQrCodeAction = (CheckoutQrCodeAction) o;
    return Objects.equals(this.expiresAt, checkoutQrCodeAction.expiresAt)
        && Objects.equals(this.paymentData, checkoutQrCodeAction.paymentData)
        && Objects.equals(this.paymentMethodType, checkoutQrCodeAction.paymentMethodType)
        && Objects.equals(this.qrCodeData, checkoutQrCodeAction.qrCodeData)
        && Objects.equals(this.type, checkoutQrCodeAction.type)
        && Objects.equals(this.url, checkoutQrCodeAction.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expiresAt, paymentData, paymentMethodType, qrCodeData, type, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckoutQrCodeAction {\n");
    sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
    sb.append("    paymentData: ").append(toIndentedString(paymentData)).append("\n");
    sb.append("    paymentMethodType: ").append(toIndentedString(paymentMethodType)).append("\n");
    sb.append("    qrCodeData: ").append(toIndentedString(qrCodeData)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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
   * Create an instance of CheckoutQrCodeAction given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of CheckoutQrCodeAction
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     CheckoutQrCodeAction
   */
  public static CheckoutQrCodeAction fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, CheckoutQrCodeAction.class);
  }

  /**
   * Convert an instance of CheckoutQrCodeAction to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
