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

/** PayByBankDetails */
@JsonPropertyOrder({
  PayByBankDetails.JSON_PROPERTY_CHECKOUT_ATTEMPT_ID,
  PayByBankDetails.JSON_PROPERTY_ISSUER,
  PayByBankDetails.JSON_PROPERTY_TYPE
})
public class PayByBankDetails {
  public static final String JSON_PROPERTY_CHECKOUT_ATTEMPT_ID = "checkoutAttemptId";
  private String checkoutAttemptId;

  public static final String JSON_PROPERTY_ISSUER = "issuer";
  private String issuer;

  /** **paybybank** */
  public enum TypeEnum {
    PAYBYBANK(String.valueOf("paybybank"));

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

  public PayByBankDetails() {}

  /**
   * The checkout attempt identifier.
   *
   * @param checkoutAttemptId The checkout attempt identifier.
   * @return the current {@code PayByBankDetails} instance, allowing for method chaining
   */
  public PayByBankDetails checkoutAttemptId(String checkoutAttemptId) {
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
   * The PayByBank issuer value of the shopper&#39;s selected bank.
   *
   * @param issuer The PayByBank issuer value of the shopper&#39;s selected bank.
   * @return the current {@code PayByBankDetails} instance, allowing for method chaining
   */
  public PayByBankDetails issuer(String issuer) {
    this.issuer = issuer;
    return this;
  }

  /**
   * The PayByBank issuer value of the shopper&#39;s selected bank.
   *
   * @return issuer The PayByBank issuer value of the shopper&#39;s selected bank.
   */
  @JsonProperty(JSON_PROPERTY_ISSUER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getIssuer() {
    return issuer;
  }

  /**
   * The PayByBank issuer value of the shopper&#39;s selected bank.
   *
   * @param issuer The PayByBank issuer value of the shopper&#39;s selected bank.
   */
  @JsonProperty(JSON_PROPERTY_ISSUER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIssuer(String issuer) {
    this.issuer = issuer;
  }

  /**
   * **paybybank**
   *
   * @param type **paybybank**
   * @return the current {@code PayByBankDetails} instance, allowing for method chaining
   */
  public PayByBankDetails type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * **paybybank**
   *
   * @return type **paybybank**
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public TypeEnum getType() {
    return type;
  }

  /**
   * **paybybank**
   *
   * @param type **paybybank**
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(TypeEnum type) {
    this.type = type;
  }

  /** Return true if this PayByBankDetails object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PayByBankDetails payByBankDetails = (PayByBankDetails) o;
    return Objects.equals(this.checkoutAttemptId, payByBankDetails.checkoutAttemptId)
        && Objects.equals(this.issuer, payByBankDetails.issuer)
        && Objects.equals(this.type, payByBankDetails.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(checkoutAttemptId, issuer, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PayByBankDetails {\n");
    sb.append("    checkoutAttemptId: ").append(toIndentedString(checkoutAttemptId)).append("\n");
    sb.append("    issuer: ").append(toIndentedString(issuer)).append("\n");
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
   * Create an instance of PayByBankDetails given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of PayByBankDetails
   * @throws JsonProcessingException if the JSON string is invalid with respect to PayByBankDetails
   */
  public static PayByBankDetails fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, PayByBankDetails.class);
  }

  /**
   * Convert an instance of PayByBankDetails to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
