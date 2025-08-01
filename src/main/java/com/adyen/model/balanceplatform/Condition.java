/*
 * Configuration API
 *
 * The version of the OpenAPI document: 2
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.balanceplatform;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.util.Arrays;
import java.util.logging.Logger;

/** Condition */
@JsonPropertyOrder({
  Condition.JSON_PROPERTY_BALANCE_TYPE,
  Condition.JSON_PROPERTY_CONDITION_TYPE,
  Condition.JSON_PROPERTY_VALUE
})
public class Condition {
  /**
   * Define the type of balance about which you want to get notified. Possible values: *
   * **available**: the balance available for use. * **balance**: the sum of transactions that have
   * already been settled. * **pending**: the sum of transactions that will be settled in the
   * future. * **reserved**: the balance currently held in reserve.
   */
  public enum BalanceTypeEnum {
    BALANCE(String.valueOf("balance")),

    AVAILABLE(String.valueOf("available")),

    PENDING(String.valueOf("pending")),

    RESERVED(String.valueOf("reserved"));

    private static final Logger LOG = Logger.getLogger(BalanceTypeEnum.class.getName());

    private String value;

    BalanceTypeEnum(String value) {
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
    public static BalanceTypeEnum fromValue(String value) {
      for (BalanceTypeEnum b : BalanceTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      // handling unexpected value
      LOG.warning(
          "BalanceTypeEnum: unexpected enum value '"
              + value
              + "' - Supported values are "
              + Arrays.toString(BalanceTypeEnum.values()));
      return null;
    }
  }

  public static final String JSON_PROPERTY_BALANCE_TYPE = "balanceType";
  private BalanceTypeEnum balanceType;

  /**
   * Define when you want to get notified about a balance change. Possible values: *
   * **greaterThan**: the balance in the account(s) exceeds the specified &#x60;value&#x60;. *
   * **greaterThanOrEqual**: the balance in the account(s) reaches or exceeds the specified
   * &#x60;value&#x60;. * **lessThan**: the balance in the account(s) drops below the specified
   * &#x60;value&#x60;. * **lessThanOrEqual**: the balance in the account(s) reaches to drops below
   * the specified &#x60;value&#x60;.
   */
  public enum ConditionTypeEnum {
    GREATERTHAN(String.valueOf("greaterThan")),

    GREATERTHANOREQUAL(String.valueOf("greaterThanOrEqual")),

    LESSTHAN(String.valueOf("lessThan")),

    LESSTHANOREQUAL(String.valueOf("lessThanOrEqual"));

    private static final Logger LOG = Logger.getLogger(ConditionTypeEnum.class.getName());

    private String value;

    ConditionTypeEnum(String value) {
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
    public static ConditionTypeEnum fromValue(String value) {
      for (ConditionTypeEnum b : ConditionTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      // handling unexpected value
      LOG.warning(
          "ConditionTypeEnum: unexpected enum value '"
              + value
              + "' - Supported values are "
              + Arrays.toString(ConditionTypeEnum.values()));
      return null;
    }
  }

  public static final String JSON_PROPERTY_CONDITION_TYPE = "conditionType";
  private ConditionTypeEnum conditionType;

  public static final String JSON_PROPERTY_VALUE = "value";
  private Long value;

  public Condition() {}

  /**
   * Define the type of balance about which you want to get notified. Possible values: *
   * **available**: the balance available for use. * **balance**: the sum of transactions that have
   * already been settled. * **pending**: the sum of transactions that will be settled in the
   * future. * **reserved**: the balance currently held in reserve.
   *
   * @param balanceType Define the type of balance about which you want to get notified. Possible
   *     values: * **available**: the balance available for use. * **balance**: the sum of
   *     transactions that have already been settled. * **pending**: the sum of transactions that
   *     will be settled in the future. * **reserved**: the balance currently held in reserve.
   * @return the current {@code Condition} instance, allowing for method chaining
   */
  public Condition balanceType(BalanceTypeEnum balanceType) {
    this.balanceType = balanceType;
    return this;
  }

  /**
   * Define the type of balance about which you want to get notified. Possible values: *
   * **available**: the balance available for use. * **balance**: the sum of transactions that have
   * already been settled. * **pending**: the sum of transactions that will be settled in the
   * future. * **reserved**: the balance currently held in reserve.
   *
   * @return balanceType Define the type of balance about which you want to get notified. Possible
   *     values: * **available**: the balance available for use. * **balance**: the sum of
   *     transactions that have already been settled. * **pending**: the sum of transactions that
   *     will be settled in the future. * **reserved**: the balance currently held in reserve.
   */
  @JsonProperty(JSON_PROPERTY_BALANCE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public BalanceTypeEnum getBalanceType() {
    return balanceType;
  }

  /**
   * Define the type of balance about which you want to get notified. Possible values: *
   * **available**: the balance available for use. * **balance**: the sum of transactions that have
   * already been settled. * **pending**: the sum of transactions that will be settled in the
   * future. * **reserved**: the balance currently held in reserve.
   *
   * @param balanceType Define the type of balance about which you want to get notified. Possible
   *     values: * **available**: the balance available for use. * **balance**: the sum of
   *     transactions that have already been settled. * **pending**: the sum of transactions that
   *     will be settled in the future. * **reserved**: the balance currently held in reserve.
   */
  @JsonProperty(JSON_PROPERTY_BALANCE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBalanceType(BalanceTypeEnum balanceType) {
    this.balanceType = balanceType;
  }

  /**
   * Define when you want to get notified about a balance change. Possible values: *
   * **greaterThan**: the balance in the account(s) exceeds the specified &#x60;value&#x60;. *
   * **greaterThanOrEqual**: the balance in the account(s) reaches or exceeds the specified
   * &#x60;value&#x60;. * **lessThan**: the balance in the account(s) drops below the specified
   * &#x60;value&#x60;. * **lessThanOrEqual**: the balance in the account(s) reaches to drops below
   * the specified &#x60;value&#x60;.
   *
   * @param conditionType Define when you want to get notified about a balance change. Possible
   *     values: * **greaterThan**: the balance in the account(s) exceeds the specified
   *     &#x60;value&#x60;. * **greaterThanOrEqual**: the balance in the account(s) reaches or
   *     exceeds the specified &#x60;value&#x60;. * **lessThan**: the balance in the account(s)
   *     drops below the specified &#x60;value&#x60;. * **lessThanOrEqual**: the balance in the
   *     account(s) reaches to drops below the specified &#x60;value&#x60;.
   * @return the current {@code Condition} instance, allowing for method chaining
   */
  public Condition conditionType(ConditionTypeEnum conditionType) {
    this.conditionType = conditionType;
    return this;
  }

  /**
   * Define when you want to get notified about a balance change. Possible values: *
   * **greaterThan**: the balance in the account(s) exceeds the specified &#x60;value&#x60;. *
   * **greaterThanOrEqual**: the balance in the account(s) reaches or exceeds the specified
   * &#x60;value&#x60;. * **lessThan**: the balance in the account(s) drops below the specified
   * &#x60;value&#x60;. * **lessThanOrEqual**: the balance in the account(s) reaches to drops below
   * the specified &#x60;value&#x60;.
   *
   * @return conditionType Define when you want to get notified about a balance change. Possible
   *     values: * **greaterThan**: the balance in the account(s) exceeds the specified
   *     &#x60;value&#x60;. * **greaterThanOrEqual**: the balance in the account(s) reaches or
   *     exceeds the specified &#x60;value&#x60;. * **lessThan**: the balance in the account(s)
   *     drops below the specified &#x60;value&#x60;. * **lessThanOrEqual**: the balance in the
   *     account(s) reaches to drops below the specified &#x60;value&#x60;.
   */
  @JsonProperty(JSON_PROPERTY_CONDITION_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ConditionTypeEnum getConditionType() {
    return conditionType;
  }

  /**
   * Define when you want to get notified about a balance change. Possible values: *
   * **greaterThan**: the balance in the account(s) exceeds the specified &#x60;value&#x60;. *
   * **greaterThanOrEqual**: the balance in the account(s) reaches or exceeds the specified
   * &#x60;value&#x60;. * **lessThan**: the balance in the account(s) drops below the specified
   * &#x60;value&#x60;. * **lessThanOrEqual**: the balance in the account(s) reaches to drops below
   * the specified &#x60;value&#x60;.
   *
   * @param conditionType Define when you want to get notified about a balance change. Possible
   *     values: * **greaterThan**: the balance in the account(s) exceeds the specified
   *     &#x60;value&#x60;. * **greaterThanOrEqual**: the balance in the account(s) reaches or
   *     exceeds the specified &#x60;value&#x60;. * **lessThan**: the balance in the account(s)
   *     drops below the specified &#x60;value&#x60;. * **lessThanOrEqual**: the balance in the
   *     account(s) reaches to drops below the specified &#x60;value&#x60;.
   */
  @JsonProperty(JSON_PROPERTY_CONDITION_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setConditionType(ConditionTypeEnum conditionType) {
    this.conditionType = conditionType;
  }

  /**
   * The value limit in the specified balance type and currency, in minor units.
   *
   * @param value The value limit in the specified balance type and currency, in minor units.
   * @return the current {@code Condition} instance, allowing for method chaining
   */
  public Condition value(Long value) {
    this.value = value;
    return this;
  }

  /**
   * The value limit in the specified balance type and currency, in minor units.
   *
   * @return value The value limit in the specified balance type and currency, in minor units.
   */
  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Long getValue() {
    return value;
  }

  /**
   * The value limit in the specified balance type and currency, in minor units.
   *
   * @param value The value limit in the specified balance type and currency, in minor units.
   */
  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setValue(Long value) {
    this.value = value;
  }

  /** Return true if this Condition object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Condition condition = (Condition) o;
    return Objects.equals(this.balanceType, condition.balanceType)
        && Objects.equals(this.conditionType, condition.conditionType)
        && Objects.equals(this.value, condition.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(balanceType, conditionType, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Condition {\n");
    sb.append("    balanceType: ").append(toIndentedString(balanceType)).append("\n");
    sb.append("    conditionType: ").append(toIndentedString(conditionType)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
   * Create an instance of Condition given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of Condition
   * @throws JsonProcessingException if the JSON string is invalid with respect to Condition
   */
  public static Condition fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, Condition.class);
  }

  /**
   * Convert an instance of Condition to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
