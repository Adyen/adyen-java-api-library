package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Definition: Content of the Enable Service Response messageType. -- Usage: It conveys the result
 * of the Enable Service processing.
 *
 * <p>Java class for EnableServiceResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="EnableServiceResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response" type="{}Response"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class EnableServiceResponse {

  /** The Response. */
  @SerializedName("Response")
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
}
