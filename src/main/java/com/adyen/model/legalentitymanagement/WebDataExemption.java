/*
 * Legal Entity Management API
 *
 * The version of the OpenAPI document: 3
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.legalentitymanagement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.util.Arrays;
import java.util.logging.Logger;

/** WebDataExemption */
@JsonPropertyOrder({WebDataExemption.JSON_PROPERTY_REASON})
public class WebDataExemption {
  /** The reason why the web data was not provided. Possible value: **noOnlinePresence**. */
  public enum ReasonEnum {
    NOONLINEPRESENCE(String.valueOf("noOnlinePresence")),

    NOTCOLLECTEDDURINGONBOARDING(String.valueOf("notCollectedDuringOnboarding"));

    private static final Logger LOG = Logger.getLogger(ReasonEnum.class.getName());

    private String value;

    ReasonEnum(String value) {
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
    public static ReasonEnum fromValue(String value) {
      for (ReasonEnum b : ReasonEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      // handling unexpected value
      LOG.warning(
          "ReasonEnum: unexpected enum value '"
              + value
              + "' - Supported values are "
              + Arrays.toString(ReasonEnum.values()));
      return null;
    }
  }

  public static final String JSON_PROPERTY_REASON = "reason";
  private ReasonEnum reason;

  public WebDataExemption() {}

  /**
   * The reason why the web data was not provided. Possible value: **noOnlinePresence**.
   *
   * @param reason The reason why the web data was not provided. Possible value:
   *     **noOnlinePresence**.
   * @return the current {@code WebDataExemption} instance, allowing for method chaining
   */
  public WebDataExemption reason(ReasonEnum reason) {
    this.reason = reason;
    return this;
  }

  /**
   * The reason why the web data was not provided. Possible value: **noOnlinePresence**.
   *
   * @return reason The reason why the web data was not provided. Possible value:
   *     **noOnlinePresence**.
   */
  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ReasonEnum getReason() {
    return reason;
  }

  /**
   * The reason why the web data was not provided. Possible value: **noOnlinePresence**.
   *
   * @param reason The reason why the web data was not provided. Possible value:
   *     **noOnlinePresence**.
   */
  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReason(ReasonEnum reason) {
    this.reason = reason;
  }

  /** Return true if this WebDataExemption object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebDataExemption webDataExemption = (WebDataExemption) o;
    return Objects.equals(this.reason, webDataExemption.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebDataExemption {\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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
   * Create an instance of WebDataExemption given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of WebDataExemption
   * @throws JsonProcessingException if the JSON string is invalid with respect to WebDataExemption
   */
  public static WebDataExemption fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, WebDataExemption.class);
  }

  /**
   * Convert an instance of WebDataExemption to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
