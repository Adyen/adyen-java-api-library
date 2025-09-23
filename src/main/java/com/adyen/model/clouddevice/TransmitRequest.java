package com.adyen.model.clouddevice;

import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigInteger;

public class TransmitRequest {

  /** The Message. */
  @JsonProperty("Message")
  @Schema(description = "Content of a transmitted message.")
  protected byte[] message;

  /** The Wait response flag. */
  @JsonProperty("WaitResponseFlag")
  @Schema(description = "Indicates that a response message has to be received.")
  protected Boolean waitResponseFlag;

  /** The Maximum transmit time. */
  @JsonProperty("MaximumTransmitTime")
  @Schema(description = "Maximum time in seconds of transmission.")
  protected BigInteger maximumTransmitTime;

  /** The Destination address. */
  @JsonProperty("DestinationAddress")
  @Schema(
      description =
          "Transport address containing the IP address or the DNS (Domain Name Server) address, followed by the character ':' and")
  protected String destinationAddress;

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

  /**
   * Gets the value of the waitResponseFlag property.
   *
   * @return possible object is {@link Boolean }
   */
  public boolean isWaitResponseFlag() {
    if (waitResponseFlag == null) {
      return false;
    } else {
      return waitResponseFlag;
    }
  }

  /**
   * Sets the value of the waitResponseFlag property.
   *
   * @param value allowed object is {@link Boolean }
   */
  public void setWaitResponseFlag(Boolean value) {
    this.waitResponseFlag = value;
  }

  /**
   * Gets the value of the maximumTransmitTime property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getMaximumTransmitTime() {
    return maximumTransmitTime;
  }

  /**
   * Sets the value of the maximumTransmitTime property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setMaximumTransmitTime(BigInteger value) {
    this.maximumTransmitTime = value;
  }

  /**
   * Gets the value of the destinationAddress property.
   *
   * @return possible object is {@link String }
   */
  public String getDestinationAddress() {
    return destinationAddress;
  }

  /**
   * Sets the value of the destinationAddress property.
   *
   * @param value allowed object is {@link String }
   */
  public void setDestinationAddress(String value) {
    this.destinationAddress = value;
  }
}
