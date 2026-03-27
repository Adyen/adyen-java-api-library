package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Definition: Content of the Transmit Response messageType. -- Usage: It conveys the response of
 * the transmission.
 *
 * <p>Java class for TransmitResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TransmitResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response" type="{}Response"/&gt;
 *         &lt;element name="Message" type="{}Message" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class TransmitResponse {

  /** The Response. */
  @SerializedName("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  /** The Message. */
  @SerializedName("Message")
  @Schema(description = "Content of a transmitted message.")
  protected byte[] message;

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

  /**
   * Gets the value of the messageType property.
   *
   * @return possible object is byte[]
   */
  public byte[] getMessage() {
    return message;
  }

  /**
   * Sets the value of the messageType property.
   *
   * @param value allowed object is byte[]
   */
  public void setMessage(byte[] value) {
    this.message = value;
  }
}
