package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigInteger;

/** Content of the PIN Request message. */
@JsonPropertyOrder({
  "CardholderPIN",
  "PINRequestType",
  "PINVerifMethod",
  "AdditionalInput",
  "PINEncAlgorithm",
  "PINFormat",
  "KeyReference",
  "MaxWaitingTime"
})
public class PINRequest {

  @JsonProperty("CardholderPIN")
  @Schema(
      description =
          "Encrypted PIN and related information --Rule: PINRequestTypeConformed to EPAS Acquirer protocol.")
  protected CardholderPIN cardholderPIN;

  @JsonProperty("PINRequestType")
  @Schema(description = "Type of PIN Service.")
  protected PINRequestType pinRequestType;

  @JsonProperty("PINVerifMethod")
  @Schema(description = "Identify the PIN verification method and keys. --Rule: PINRequestType")
  protected String pinVerifMethod;

  @JsonProperty("AdditionalInput")
  @Schema(
      description =
          "Additional information required to verify the PIN like part of the PAN, or driver ID. --Rule: PINRequestType")
  protected String additionalInput;

  @JsonProperty("PINEncAlgorithm")
  @Schema(description = "Identify the encrypted PIN block algorithm. --Rule: PINRequestType")
  protected String pinEncAlgorithm;

  @JsonProperty("PINFormat")
  @Schema(description = "Identify the format of the PIN before encryption. --Rule: PINRequestType")
  protected PINFormatType pinFormat;

  @JsonProperty("KeyReference")
  @Schema(description = "Identify the key to use to encrypt the PIN block. --Rule: PINRequestType")
  protected String keyReference;

  @JsonProperty("MaxWaitingTime")
  @Schema(
      description =
          "Maximum time to wait for the request processing in seconds. --Rule: PINRequestTypePINRequestType")
  protected BigInteger maxWaitingTime;

  /**
   * Gets cardholder pin.
   *
   * @return the cardholder pin
   */
  public CardholderPIN getCardholderPIN() {
    return cardholderPIN;
  }

  /**
   * Sets cardholder pin.
   *
   * @param cardholderPIN the cardholder pin
   */
  public void setCardholderPIN(CardholderPIN cardholderPIN) {
    this.cardholderPIN = cardholderPIN;
  }

  /**
   * Gets pin request type.
   *
   * @return the pin request type
   */
  public PINRequestType getPINRequestType() {
    return pinRequestType;
  }

  /**
   * Sets pin request type.
   *
   * @param pinRequestType the pin request type
   */
  public void setPINRequestType(PINRequestType pinRequestType) {
    this.pinRequestType = pinRequestType;
  }

  /**
   * Gets pin verif method.
   *
   * @return the pin verif method
   */
  public String getPINVerifMethod() {
    return pinVerifMethod;
  }

  /**
   * Sets pin verif method.
   *
   * @param pinVerifMethod the pin verif method
   */
  public void setPINVerifMethod(String pinVerifMethod) {
    this.pinVerifMethod = pinVerifMethod;
  }

  /**
   * Gets additional input.
   *
   * @return the additional input
   */
  public String getAdditionalInput() {
    return additionalInput;
  }

  /**
   * Sets additional input.
   *
   * @param additionalInput the additional input
   */
  public void setAdditionalInput(String additionalInput) {
    this.additionalInput = additionalInput;
  }

  /**
   * Gets pin enc algorithm.
   *
   * @return the pin enc algorithm
   */
  public String getPINEncAlgorithm() {
    return pinEncAlgorithm;
  }

  /**
   * Sets pin enc algorithm.
   *
   * @param pinEncAlgorithm the pin enc algorithm
   */
  public void setPINEncAlgorithm(String pinEncAlgorithm) {
    this.pinEncAlgorithm = pinEncAlgorithm;
  }

  /**
   * Gets pin format.
   *
   * @return the pin format
   */
  public PINFormatType getPINFormat() {
    return pinFormat;
  }

  /**
   * Sets pin format.
   *
   * @param pinFormat the pin format
   */
  public void setPINFormat(PINFormatType pinFormat) {
    this.pinFormat = pinFormat;
  }

  /**
   * Gets key reference.
   *
   * @return the key reference
   */
  public String getKeyReference() {
    return keyReference;
  }

  /**
   * Sets key reference.
   *
   * @param keyReference the key reference
   */
  public void setKeyReference(String keyReference) {
    this.keyReference = keyReference;
  }

  /**
   * Gets max waiting time.
   *
   * @return the max waiting time
   */
  public BigInteger getMaxWaitingTime() {
    return maxWaitingTime;
  }

  /**
   * Sets max waiting time.
   *
   * @param maxWaitingTime the max waiting time
   */
  public void setMaxWaitingTime(BigInteger maxWaitingTime) {
    this.maxWaitingTime = maxWaitingTime;
  }
}
