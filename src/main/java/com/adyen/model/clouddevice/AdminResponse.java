package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Content of the Custom Admin Response message. -- Usage: It conveys the result of the Custom
 * Admin.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"Response"})
public class AdminResponse {

  /** The Response. */
  @JsonProperty("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  /**
   * Gets the value of the response property.
   *
   * @return possible object is {@link Response }
   */
  public Response getResponse() {
    return response;
  }

  /**
   * Sets the value of the response property.
   *
   * @param value allowed object is {@link Response }
   */
  public void setResponse(Response value) {
    this.response = value;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdminResponse {\n");
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
    sb.append("}\n");
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
}
