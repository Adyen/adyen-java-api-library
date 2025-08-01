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

/** ReleaseUpdateDetails */
@JsonPropertyOrder({
  ReleaseUpdateDetails.JSON_PROPERTY_TYPE,
  ReleaseUpdateDetails.JSON_PROPERTY_UPDATE_AT_FIRST_MAINTENANCE_CALL
})
public class ReleaseUpdateDetails {
  /** Type of terminal action: Update Release. */
  public enum TypeEnum {
    RELEASEUPDATE(String.valueOf("ReleaseUpdate"));

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

  public static final String JSON_PROPERTY_UPDATE_AT_FIRST_MAINTENANCE_CALL =
      "updateAtFirstMaintenanceCall";
  private Boolean updateAtFirstMaintenanceCall;

  public ReleaseUpdateDetails() {}

  /**
   * Type of terminal action: Update Release.
   *
   * @param type Type of terminal action: Update Release.
   * @return the current {@code ReleaseUpdateDetails} instance, allowing for method chaining
   */
  public ReleaseUpdateDetails type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Type of terminal action: Update Release.
   *
   * @return type Type of terminal action: Update Release.
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public TypeEnum getType() {
    return type;
  }

  /**
   * Type of terminal action: Update Release.
   *
   * @param type Type of terminal action: Update Release.
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(TypeEnum type) {
    this.type = type;
  }

  /**
   * Boolean flag that tells if the terminal should update at the first next maintenance call. If
   * false, terminal will update on its configured reboot time.
   *
   * @param updateAtFirstMaintenanceCall Boolean flag that tells if the terminal should update at
   *     the first next maintenance call. If false, terminal will update on its configured reboot
   *     time.
   * @return the current {@code ReleaseUpdateDetails} instance, allowing for method chaining
   */
  public ReleaseUpdateDetails updateAtFirstMaintenanceCall(Boolean updateAtFirstMaintenanceCall) {
    this.updateAtFirstMaintenanceCall = updateAtFirstMaintenanceCall;
    return this;
  }

  /**
   * Boolean flag that tells if the terminal should update at the first next maintenance call. If
   * false, terminal will update on its configured reboot time.
   *
   * @return updateAtFirstMaintenanceCall Boolean flag that tells if the terminal should update at
   *     the first next maintenance call. If false, terminal will update on its configured reboot
   *     time.
   */
  @JsonProperty(JSON_PROPERTY_UPDATE_AT_FIRST_MAINTENANCE_CALL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getUpdateAtFirstMaintenanceCall() {
    return updateAtFirstMaintenanceCall;
  }

  /**
   * Boolean flag that tells if the terminal should update at the first next maintenance call. If
   * false, terminal will update on its configured reboot time.
   *
   * @param updateAtFirstMaintenanceCall Boolean flag that tells if the terminal should update at
   *     the first next maintenance call. If false, terminal will update on its configured reboot
   *     time.
   */
  @JsonProperty(JSON_PROPERTY_UPDATE_AT_FIRST_MAINTENANCE_CALL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUpdateAtFirstMaintenanceCall(Boolean updateAtFirstMaintenanceCall) {
    this.updateAtFirstMaintenanceCall = updateAtFirstMaintenanceCall;
  }

  /** Return true if this ReleaseUpdateDetails object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReleaseUpdateDetails releaseUpdateDetails = (ReleaseUpdateDetails) o;
    return Objects.equals(this.type, releaseUpdateDetails.type)
        && Objects.equals(
            this.updateAtFirstMaintenanceCall, releaseUpdateDetails.updateAtFirstMaintenanceCall);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, updateAtFirstMaintenanceCall);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReleaseUpdateDetails {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    updateAtFirstMaintenanceCall: ")
        .append(toIndentedString(updateAtFirstMaintenanceCall))
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
   * Create an instance of ReleaseUpdateDetails given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ReleaseUpdateDetails
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     ReleaseUpdateDetails
   */
  public static ReleaseUpdateDetails fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, ReleaseUpdateDetails.class);
  }

  /**
   * Convert an instance of ReleaseUpdateDetails to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
