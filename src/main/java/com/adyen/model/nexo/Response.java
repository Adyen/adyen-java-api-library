package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Definition: Result of a messageType request processing. -- Usage: If Result is Success,
 * ErrorCondition is absent or not used in the processing of the messageType. In the other cases,
 * the ErrorCondition has to be present and can refine the processing of the messageType response.
 * AdditionalResponse gives more
 *
 * <p>Java class for Response complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Response"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AdditionalResponse" type="{}AdditionalResponse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Result" use="required" type="{}ResultType" /&gt;
 *       &lt;attribute name="ErrorCondition" type="{}ErrorConditionType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class Response {

  /** The Additional response. */
  @SerializedName("AdditionalResponse")
  @Schema(
      description =
          "Additional information related to processing status of a message request . --Rule: If present, the POI logs it for further examination")
  protected String additionalResponse;

  /** The Result. */
  @SerializedName("Result")
  @Schema(description = "Result of the processing of the message")
  protected ResultType result;

  /** The Error condition. */
  @SerializedName("ErrorCondition")
  @Schema(
      description =
          "Condition that has produced  an error on the processing of a message request --Rule: If Result is not Success")
  protected ErrorConditionType errorCondition;

  /**
   * Gets the value of the additionalResponse property.
   *
   * @return possible object is {@link String }
   */
  public String getAdditionalResponse() {
    return additionalResponse;
  }

  /**
   * Sets the value of the additionalResponse property.
   *
   * @param value allowed object is {@link String }
   */
  public void setAdditionalResponse(String value) {
    this.additionalResponse = value;
  }

  /**
   * Gets the value of the result property.
   *
   * @return possible object is {@link ResultType }
   */
  public ResultType getResult() {
    return result;
  }

  /**
   * Sets the value of the result property.
   *
   * @param value allowed object is {@link ResultType }
   */
  public void setResult(ResultType value) {
    this.result = value;
  }

  /**
   * Gets the value of the errorCondition property.
   *
   * @return possible object is {@link ErrorConditionType }
   */
  public ErrorConditionType getErrorCondition() {
    return errorCondition;
  }

  /**
   * Sets the value of the errorCondition property.
   *
   * @param value allowed object is {@link ErrorConditionType }
   */
  public void setErrorCondition(ErrorConditionType value) {
    this.errorCondition = value;
  }
}
