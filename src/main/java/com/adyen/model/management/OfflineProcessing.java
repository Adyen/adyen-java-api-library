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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

/** OfflineProcessing */
@JsonPropertyOrder({
  OfflineProcessing.JSON_PROPERTY_CHIP_FLOOR_LIMIT,
  OfflineProcessing.JSON_PROPERTY_OFFLINE_SWIPE_LIMITS
})
public class OfflineProcessing {
  public static final String JSON_PROPERTY_CHIP_FLOOR_LIMIT = "chipFloorLimit";
  private Integer chipFloorLimit;

  public static final String JSON_PROPERTY_OFFLINE_SWIPE_LIMITS = "offlineSwipeLimits";
  private List<MinorUnitsMonetaryValue> offlineSwipeLimits;

  public OfflineProcessing() {}

  /**
   * The maximum offline transaction amount for chip cards, in the processing currency and specified
   * in [minor units](https://docs.adyen.com/development-resources/currency-codes).
   *
   * @param chipFloorLimit The maximum offline transaction amount for chip cards, in the processing
   *     currency and specified in [minor
   *     units](https://docs.adyen.com/development-resources/currency-codes).
   * @return the current {@code OfflineProcessing} instance, allowing for method chaining
   */
  public OfflineProcessing chipFloorLimit(Integer chipFloorLimit) {
    this.chipFloorLimit = chipFloorLimit;
    return this;
  }

  /**
   * The maximum offline transaction amount for chip cards, in the processing currency and specified
   * in [minor units](https://docs.adyen.com/development-resources/currency-codes).
   *
   * @return chipFloorLimit The maximum offline transaction amount for chip cards, in the processing
   *     currency and specified in [minor
   *     units](https://docs.adyen.com/development-resources/currency-codes).
   */
  @JsonProperty(JSON_PROPERTY_CHIP_FLOOR_LIMIT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getChipFloorLimit() {
    return chipFloorLimit;
  }

  /**
   * The maximum offline transaction amount for chip cards, in the processing currency and specified
   * in [minor units](https://docs.adyen.com/development-resources/currency-codes).
   *
   * @param chipFloorLimit The maximum offline transaction amount for chip cards, in the processing
   *     currency and specified in [minor
   *     units](https://docs.adyen.com/development-resources/currency-codes).
   */
  @JsonProperty(JSON_PROPERTY_CHIP_FLOOR_LIMIT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setChipFloorLimit(Integer chipFloorLimit) {
    this.chipFloorLimit = chipFloorLimit;
  }

  /**
   * The maximum offline transaction amount for swiped cards, in the specified currency.
   *
   * @param offlineSwipeLimits The maximum offline transaction amount for swiped cards, in the
   *     specified currency.
   * @return the current {@code OfflineProcessing} instance, allowing for method chaining
   */
  public OfflineProcessing offlineSwipeLimits(List<MinorUnitsMonetaryValue> offlineSwipeLimits) {
    this.offlineSwipeLimits = offlineSwipeLimits;
    return this;
  }

  public OfflineProcessing addOfflineSwipeLimitsItem(
      MinorUnitsMonetaryValue offlineSwipeLimitsItem) {
    if (this.offlineSwipeLimits == null) {
      this.offlineSwipeLimits = new ArrayList<>();
    }
    this.offlineSwipeLimits.add(offlineSwipeLimitsItem);
    return this;
  }

  /**
   * The maximum offline transaction amount for swiped cards, in the specified currency.
   *
   * @return offlineSwipeLimits The maximum offline transaction amount for swiped cards, in the
   *     specified currency.
   */
  @JsonProperty(JSON_PROPERTY_OFFLINE_SWIPE_LIMITS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<MinorUnitsMonetaryValue> getOfflineSwipeLimits() {
    return offlineSwipeLimits;
  }

  /**
   * The maximum offline transaction amount for swiped cards, in the specified currency.
   *
   * @param offlineSwipeLimits The maximum offline transaction amount for swiped cards, in the
   *     specified currency.
   */
  @JsonProperty(JSON_PROPERTY_OFFLINE_SWIPE_LIMITS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOfflineSwipeLimits(List<MinorUnitsMonetaryValue> offlineSwipeLimits) {
    this.offlineSwipeLimits = offlineSwipeLimits;
  }

  /** Return true if this OfflineProcessing object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OfflineProcessing offlineProcessing = (OfflineProcessing) o;
    return Objects.equals(this.chipFloorLimit, offlineProcessing.chipFloorLimit)
        && Objects.equals(this.offlineSwipeLimits, offlineProcessing.offlineSwipeLimits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(chipFloorLimit, offlineSwipeLimits);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OfflineProcessing {\n");
    sb.append("    chipFloorLimit: ").append(toIndentedString(chipFloorLimit)).append("\n");
    sb.append("    offlineSwipeLimits: ").append(toIndentedString(offlineSwipeLimits)).append("\n");
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
   * Create an instance of OfflineProcessing given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of OfflineProcessing
   * @throws JsonProcessingException if the JSON string is invalid with respect to OfflineProcessing
   */
  public static OfflineProcessing fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, OfflineProcessing.class);
  }

  /**
   * Convert an instance of OfflineProcessing to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
