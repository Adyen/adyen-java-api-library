/*
 * POS Terminal Management API
 *
 * The version of the OpenAPI document: 1
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.posterminalmanagement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/** FindTerminalRequest */
@JsonPropertyOrder({FindTerminalRequest.JSON_PROPERTY_TERMINAL})
public class FindTerminalRequest {
  public static final String JSON_PROPERTY_TERMINAL = "terminal";
  private String terminal;

  public FindTerminalRequest() {}

  /**
   * The unique terminal ID in the format &#x60;[Device model]-[Serial number]&#x60;. For example,
   * **V400m-324689776**.
   *
   * @param terminal
   * @return the current {@code FindTerminalRequest} instance, allowing for method chaining
   */
  public FindTerminalRequest terminal(String terminal) {
    this.terminal = terminal;
    return this;
  }

  /**
   * The unique terminal ID in the format &#x60;[Device model]-[Serial number]&#x60;. For example,
   * **V400m-324689776**.
   *
   * @return terminal
   */
  @ApiModelProperty(
      required = true,
      value =
          "The unique terminal ID in the format `[Device model]-[Serial number]`.   For example, **V400m-324689776**.")
  @JsonProperty(JSON_PROPERTY_TERMINAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getTerminal() {
    return terminal;
  }

  /**
   * The unique terminal ID in the format &#x60;[Device model]-[Serial number]&#x60;. For example,
   * **V400m-324689776**.
   *
   * @param terminal
   */
  @JsonProperty(JSON_PROPERTY_TERMINAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTerminal(String terminal) {
    this.terminal = terminal;
  }

  /** Return true if this FindTerminalRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FindTerminalRequest findTerminalRequest = (FindTerminalRequest) o;
    return Objects.equals(this.terminal, findTerminalRequest.terminal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(terminal);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FindTerminalRequest {\n");
    sb.append("    terminal: ").append(toIndentedString(terminal)).append("\n");
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
   * Create an instance of FindTerminalRequest given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of FindTerminalRequest
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     FindTerminalRequest
   */
  public static FindTerminalRequest fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, FindTerminalRequest.class);
  }

  /**
   * Convert an instance of FindTerminalRequest to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
