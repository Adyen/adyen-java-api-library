package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Definition: Content of the TransactionStatus Response messageType. -- Usage: It conveys
 * Information related to the status of the last or current Payment, Loyalty or Reversal
 * transaction.
 *
 * <p>Java class for TransactionStatusResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TransactionStatusResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response" type="{}Response"/&gt;
 *         &lt;element name="MessageReference" type="{}MessageReference" minOccurs="0"/&gt;
 *         &lt;element name="RepeatedMessageResponse" type="{}RepeatedMessageResponse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class TransactionStatusResponse {

  /** The Response. */
  @SerializedName("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  /** The Message reference. */
  @SerializedName("MessageReference")
  @Schema(
      description =
          "Identification of a previous POI transaction. --Rule: if Response.Result is Success")
  protected MessageReference messageReference;

  /** The Repeated message response. */
  @SerializedName("RepeatedMessageResponse")
  @Schema(
      description =
          "Content of the requested Message Response. --Rule: If Result is Success (process completed)")
  protected RepeatedMessageResponse repeatedMessageResponse;

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
   * Gets the value of the messageReference property.
   *
   * @return possible object is {@link MessageReference }
   */
  public MessageReference getMessageReference() {
    return messageReference;
  }

  /**
   * Sets the value of the messageReference property.
   *
   * @param value allowed object is {@link MessageReference }
   */
  public void setMessageReference(MessageReference value) {
    this.messageReference = value;
  }

  /**
   * Gets the value of the repeatedMessageResponse property.
   *
   * @return possible object is {@link RepeatedMessageResponse }
   */
  public RepeatedMessageResponse getRepeatedMessageResponse() {
    return repeatedMessageResponse;
  }

  /**
   * Sets the value of the repeatedMessageResponse property.
   *
   * @param value allowed object is {@link RepeatedMessageResponse }
   */
  public void setRepeatedMessageResponse(RepeatedMessageResponse value) {
    this.repeatedMessageResponse = value;
  }
}
