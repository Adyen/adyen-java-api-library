package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Result of a message request processing. */
@JsonPropertyOrder({"AdditionalResponse", "Result", "ErrorCondition"})
public class Response {

  @JsonProperty("AdditionalResponse")
  @Schema(
      description =
          "Additional information related to processing status of a message request . --Rule: If present, the POI logs it for further examination")
  protected String additionalResponse;

  @JsonProperty("Result")
  @Schema(description = "Result of the processing of the message")
  protected ResultType result;

  @JsonProperty("ErrorCondition")
  @Schema(
      description =
          "Condition that has produced  an error on the processing of a message request --Rule: If Result is not Success")
  protected ErrorConditionType errorCondition;

  /**
   * Gets additional response.
   *
   * @return the additional response
   */
  public String getAdditionalResponse() {
    return additionalResponse;
  }

  /**
   * Sets additional response.
   *
   * @param additionalResponse the additional response
   */
  public void setAdditionalResponse(String additionalResponse) {
    this.additionalResponse = additionalResponse;
  }

  /**
   * Gets result.
   *
   * @return the result
   */
  public ResultType getResult() {
    return result;
  }

  /**
   * Sets result.
   *
   * @param result the result
   */
  public void setResult(ResultType result) {
    this.result = result;
  }

  /**
   * Gets error condition.
   *
   * @return the error condition
   */
  public ErrorConditionType getErrorCondition() {
    return errorCondition;
  }

  /**
   * Sets error condition.
   *
   * @param errorCondition the error condition
   */
  public void setErrorCondition(ErrorConditionType errorCondition) {
    this.errorCondition = errorCondition;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Response{");
    sb.append("additionalResponse='").append(additionalResponse).append('\'');
    sb.append(", result=").append(result);
    sb.append(", errorCondition=").append(errorCondition);
    sb.append('}');
    return sb.toString();
  }
}
