package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Content of the Login Response message. */
@JsonPropertyOrder({"Response", "POISystemData"})
public class LoginResponse {

  @JsonProperty("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  @JsonProperty("POISystemData")
  @Schema(
      description = "Information related to the POI System --Rule: if Response.Result is Success")
  protected POISystemData poiSystemData;

  /**
   * Gets response.
   *
   * @return the response
   */
  public Response getResponse() {
    return response;
  }

  /**
   * Sets response.
   *
   * @param response the response
   */
  public void setResponse(Response response) {
    this.response = response;
  }

  /**
   * Gets poi system data.
   *
   * @return the poi system data
   */
  public POISystemData getPOISystemData() {
    return poiSystemData;
  }

  /**
   * Sets poi system data.
   *
   * @param poiSystemData the poi system data
   */
  public void setPOISystemData(POISystemData poiSystemData) {
    this.poiSystemData = poiSystemData;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginResponse {\n");
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
    sb.append("    poiSystemData: ").append(toIndentedString(poiSystemData)).append("\n");
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
