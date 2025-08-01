/*
 * Management API
 *
 * The version of the OpenAPI document: 3
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.management;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.util.Arrays;
import java.util.logging.Logger;

/** AmexInfo */
@JsonPropertyOrder({
  AmexInfo.JSON_PROPERTY_MID_NUMBER,
  AmexInfo.JSON_PROPERTY_REUSE_MID_NUMBER,
  AmexInfo.JSON_PROPERTY_SERVICE_LEVEL
})
public class AmexInfo {
  public static final String JSON_PROPERTY_MID_NUMBER = "midNumber";
  private String midNumber;

  public static final String JSON_PROPERTY_REUSE_MID_NUMBER = "reuseMidNumber";
  private Boolean reuseMidNumber;

  /**
   * Specifies the service level (settlement type) of this payment method. Possible values: *
   * **noContract**: Adyen holds the contract with American Express. * **gatewayContract**: American
   * Express receives the settlement and handles disputes, then pays out to you or your sub-merchant
   * directly. * **paymentDesignatorContract**: Adyen receives the settlement, and handles disputes
   * and payouts.
   */
  public enum ServiceLevelEnum {
    NOCONTRACT(String.valueOf("noContract")),

    GATEWAYCONTRACT(String.valueOf("gatewayContract")),

    PAYMENTDESIGNATORCONTRACT(String.valueOf("paymentDesignatorContract"));

    private static final Logger LOG = Logger.getLogger(ServiceLevelEnum.class.getName());

    private String value;

    ServiceLevelEnum(String value) {
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
    public static ServiceLevelEnum fromValue(String value) {
      for (ServiceLevelEnum b : ServiceLevelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      // handling unexpected value
      LOG.warning(
          "ServiceLevelEnum: unexpected enum value '"
              + value
              + "' - Supported values are "
              + Arrays.toString(ServiceLevelEnum.values()));
      return null;
    }
  }

  public static final String JSON_PROPERTY_SERVICE_LEVEL = "serviceLevel";
  private ServiceLevelEnum serviceLevel;

  public AmexInfo() {}

  /**
   * Merchant ID (MID) number. Format: 10 numeric characters. You must provide this field when you
   * request &#x60;gatewayContract&#x60; or &#x60;paymentDesignatorContract&#x60; service levels.
   *
   * @param midNumber Merchant ID (MID) number. Format: 10 numeric characters. You must provide this
   *     field when you request &#x60;gatewayContract&#x60; or &#x60;paymentDesignatorContract&#x60;
   *     service levels.
   * @return the current {@code AmexInfo} instance, allowing for method chaining
   */
  public AmexInfo midNumber(String midNumber) {
    this.midNumber = midNumber;
    return this;
  }

  /**
   * Merchant ID (MID) number. Format: 10 numeric characters. You must provide this field when you
   * request &#x60;gatewayContract&#x60; or &#x60;paymentDesignatorContract&#x60; service levels.
   *
   * @return midNumber Merchant ID (MID) number. Format: 10 numeric characters. You must provide
   *     this field when you request &#x60;gatewayContract&#x60; or
   *     &#x60;paymentDesignatorContract&#x60; service levels.
   */
  @JsonProperty(JSON_PROPERTY_MID_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getMidNumber() {
    return midNumber;
  }

  /**
   * Merchant ID (MID) number. Format: 10 numeric characters. You must provide this field when you
   * request &#x60;gatewayContract&#x60; or &#x60;paymentDesignatorContract&#x60; service levels.
   *
   * @param midNumber Merchant ID (MID) number. Format: 10 numeric characters. You must provide this
   *     field when you request &#x60;gatewayContract&#x60; or &#x60;paymentDesignatorContract&#x60;
   *     service levels.
   */
  @JsonProperty(JSON_PROPERTY_MID_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMidNumber(String midNumber) {
    this.midNumber = midNumber;
  }

  /**
   * Indicates whether the Amex Merchant ID is reused from a previously setup Amex payment method.
   * This is only applicable for &#x60;gatewayContract&#x60; and
   * &#x60;paymentDesignatorContract&#x60; service levels. The default value is **false**.
   *
   * @param reuseMidNumber Indicates whether the Amex Merchant ID is reused from a previously setup
   *     Amex payment method. This is only applicable for &#x60;gatewayContract&#x60; and
   *     &#x60;paymentDesignatorContract&#x60; service levels. The default value is **false**.
   * @return the current {@code AmexInfo} instance, allowing for method chaining
   */
  public AmexInfo reuseMidNumber(Boolean reuseMidNumber) {
    this.reuseMidNumber = reuseMidNumber;
    return this;
  }

  /**
   * Indicates whether the Amex Merchant ID is reused from a previously setup Amex payment method.
   * This is only applicable for &#x60;gatewayContract&#x60; and
   * &#x60;paymentDesignatorContract&#x60; service levels. The default value is **false**.
   *
   * @return reuseMidNumber Indicates whether the Amex Merchant ID is reused from a previously setup
   *     Amex payment method. This is only applicable for &#x60;gatewayContract&#x60; and
   *     &#x60;paymentDesignatorContract&#x60; service levels. The default value is **false**.
   */
  @JsonProperty(JSON_PROPERTY_REUSE_MID_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getReuseMidNumber() {
    return reuseMidNumber;
  }

  /**
   * Indicates whether the Amex Merchant ID is reused from a previously setup Amex payment method.
   * This is only applicable for &#x60;gatewayContract&#x60; and
   * &#x60;paymentDesignatorContract&#x60; service levels. The default value is **false**.
   *
   * @param reuseMidNumber Indicates whether the Amex Merchant ID is reused from a previously setup
   *     Amex payment method. This is only applicable for &#x60;gatewayContract&#x60; and
   *     &#x60;paymentDesignatorContract&#x60; service levels. The default value is **false**.
   */
  @JsonProperty(JSON_PROPERTY_REUSE_MID_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReuseMidNumber(Boolean reuseMidNumber) {
    this.reuseMidNumber = reuseMidNumber;
  }

  /**
   * Specifies the service level (settlement type) of this payment method. Possible values: *
   * **noContract**: Adyen holds the contract with American Express. * **gatewayContract**: American
   * Express receives the settlement and handles disputes, then pays out to you or your sub-merchant
   * directly. * **paymentDesignatorContract**: Adyen receives the settlement, and handles disputes
   * and payouts.
   *
   * @param serviceLevel Specifies the service level (settlement type) of this payment method.
   *     Possible values: * **noContract**: Adyen holds the contract with American Express. *
   *     **gatewayContract**: American Express receives the settlement and handles disputes, then
   *     pays out to you or your sub-merchant directly. * **paymentDesignatorContract**: Adyen
   *     receives the settlement, and handles disputes and payouts.
   * @return the current {@code AmexInfo} instance, allowing for method chaining
   */
  public AmexInfo serviceLevel(ServiceLevelEnum serviceLevel) {
    this.serviceLevel = serviceLevel;
    return this;
  }

  /**
   * Specifies the service level (settlement type) of this payment method. Possible values: *
   * **noContract**: Adyen holds the contract with American Express. * **gatewayContract**: American
   * Express receives the settlement and handles disputes, then pays out to you or your sub-merchant
   * directly. * **paymentDesignatorContract**: Adyen receives the settlement, and handles disputes
   * and payouts.
   *
   * @return serviceLevel Specifies the service level (settlement type) of this payment method.
   *     Possible values: * **noContract**: Adyen holds the contract with American Express. *
   *     **gatewayContract**: American Express receives the settlement and handles disputes, then
   *     pays out to you or your sub-merchant directly. * **paymentDesignatorContract**: Adyen
   *     receives the settlement, and handles disputes and payouts.
   */
  @JsonProperty(JSON_PROPERTY_SERVICE_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ServiceLevelEnum getServiceLevel() {
    return serviceLevel;
  }

  /**
   * Specifies the service level (settlement type) of this payment method. Possible values: *
   * **noContract**: Adyen holds the contract with American Express. * **gatewayContract**: American
   * Express receives the settlement and handles disputes, then pays out to you or your sub-merchant
   * directly. * **paymentDesignatorContract**: Adyen receives the settlement, and handles disputes
   * and payouts.
   *
   * @param serviceLevel Specifies the service level (settlement type) of this payment method.
   *     Possible values: * **noContract**: Adyen holds the contract with American Express. *
   *     **gatewayContract**: American Express receives the settlement and handles disputes, then
   *     pays out to you or your sub-merchant directly. * **paymentDesignatorContract**: Adyen
   *     receives the settlement, and handles disputes and payouts.
   */
  @JsonProperty(JSON_PROPERTY_SERVICE_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setServiceLevel(ServiceLevelEnum serviceLevel) {
    this.serviceLevel = serviceLevel;
  }

  /** Return true if this AmexInfo object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AmexInfo amexInfo = (AmexInfo) o;
    return Objects.equals(this.midNumber, amexInfo.midNumber)
        && Objects.equals(this.reuseMidNumber, amexInfo.reuseMidNumber)
        && Objects.equals(this.serviceLevel, amexInfo.serviceLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(midNumber, reuseMidNumber, serviceLevel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AmexInfo {\n");
    sb.append("    midNumber: ").append(toIndentedString(midNumber)).append("\n");
    sb.append("    reuseMidNumber: ").append(toIndentedString(reuseMidNumber)).append("\n");
    sb.append("    serviceLevel: ").append(toIndentedString(serviceLevel)).append("\n");
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
   * Create an instance of AmexInfo given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of AmexInfo
   * @throws JsonProcessingException if the JSON string is invalid with respect to AmexInfo
   */
  public static AmexInfo fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, AmexInfo.class);
  }

  /**
   * Convert an instance of AmexInfo to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
