/*
 * Classic Platforms - Notifications
 *
 * The version of the OpenAPI document: 6
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.marketpaywebhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** CompensateNegativeBalanceNotificationContent */
@JsonPropertyOrder({CompensateNegativeBalanceNotificationContent.JSON_PROPERTY_RECORDS})
public class CompensateNegativeBalanceNotificationContent {
  public static final String JSON_PROPERTY_RECORDS = "records";
  private List<CompensateNegativeBalanceNotificationRecord> records = null;

  public CompensateNegativeBalanceNotificationContent() {}

  public CompensateNegativeBalanceNotificationContent records(
      List<CompensateNegativeBalanceNotificationRecord> records) {
    this.records = records;
    return this;
  }

  public CompensateNegativeBalanceNotificationContent addRecordsItem(
      CompensateNegativeBalanceNotificationRecord recordsItem) {
    if (this.records == null) {
      this.records = new ArrayList<>();
    }
    this.records.add(recordsItem);
    return this;
  }

  /**
   * A list of the negative balances compensated.
   *
   * @return records
   */
  @ApiModelProperty(value = "A list of the negative balances compensated.")
  @JsonProperty(JSON_PROPERTY_RECORDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<CompensateNegativeBalanceNotificationRecord> getRecords() {
    return records;
  }

  @JsonProperty(JSON_PROPERTY_RECORDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRecords(List<CompensateNegativeBalanceNotificationRecord> records) {
    this.records = records;
  }

  /** Return true if this CompensateNegativeBalanceNotificationContent object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompensateNegativeBalanceNotificationContent compensateNegativeBalanceNotificationContent =
        (CompensateNegativeBalanceNotificationContent) o;
    return Objects.equals(this.records, compensateNegativeBalanceNotificationContent.records);
  }

  @Override
  public int hashCode() {
    return Objects.hash(records);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CompensateNegativeBalanceNotificationContent {\n");
    sb.append("    records: ").append(toIndentedString(records)).append("\n");
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
   * Create an instance of CompensateNegativeBalanceNotificationContent given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of CompensateNegativeBalanceNotificationContent
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     CompensateNegativeBalanceNotificationContent
   */
  public static CompensateNegativeBalanceNotificationContent fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper()
        .readValue(jsonString, CompensateNegativeBalanceNotificationContent.class);
  }

  /**
   * Convert an instance of CompensateNegativeBalanceNotificationContent to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
