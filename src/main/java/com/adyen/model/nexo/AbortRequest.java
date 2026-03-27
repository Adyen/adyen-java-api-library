package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Definition: Body of the Abort Request messageType. -- Usage: It conveys Information requested for
 * identification of the messageType request carrying the transaction to abort. A messageType to
 * display on the CustomerError Device could be sent by the Sale System (DisplayOutput).
 *
 * <p>Java class for AbortRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AbortRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MessageReference" type="{}MessageReference"/&gt;
 *         &lt;element name="AbortReason" type="{}AbortReason"/&gt;
 *         &lt;element name="DisplayOutput" type="{}DisplayOutput" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class AbortRequest {

  /** The Message reference. */
  @SerializedName("MessageReference")
  @Schema(description = "Identification of a previous POI transaction.")
  protected MessageReference messageReference;

  /** The Abort reason. */
  @SerializedName("AbortReason")
  @Schema(description = "Reason of aborting a transaction")
  protected String abortReason;

  /** The Display output. */
  @SerializedName("DisplayOutput")
  @Schema(
      description =
          "Information to display and the way to process the display. --Rule: To display an abort message to the Customer")
  protected DisplayOutput displayOutput;

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
   * Gets the value of the abortReason property.
   *
   * @return possible object is {@link String }
   */
  public String getAbortReason() {
    return abortReason;
  }

  /**
   * Sets the value of the abortReason property.
   *
   * @param value allowed object is {@link String }
   */
  public void setAbortReason(String value) {
    this.abortReason = value;
  }

  /**
   * Gets the value of the displayOutput property.
   *
   * @return possible object is {@link DisplayOutput }
   */
  public DisplayOutput getDisplayOutput() {
    return displayOutput;
  }

  /**
   * Sets the value of the displayOutput property.
   *
   * @param value allowed object is {@link DisplayOutput }
   */
  public void setDisplayOutput(DisplayOutput value) {
    this.displayOutput = value;
  }
}
