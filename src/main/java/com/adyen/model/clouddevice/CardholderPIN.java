package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Encrypted PIN and related information. */
@JsonPropertyOrder({"EncrPINBlock", "PINFormat", "AdditionalInput"})
public class CardholderPIN {

  @JsonProperty("EncrPINBlock")
  @Schema(description = "Encrypted PIN")
  protected ContentInformation encrPINBlock;

  @JsonProperty("PINFormat")
  @Schema(description = "Identify the format of the PIN before encryption.")
  protected PINFormatType pinFormat;

  @JsonProperty("AdditionalInput")
  @Schema(
      description =
          "Additional information required to verify the PIN like part of the PAN, or driver ID.")
  protected String additionalInput;

  /**
   * Gets encr pin block.
   *
   * @return the encr pin block
   */
  public ContentInformation getEncrPINBlock() {
    return encrPINBlock;
  }

  /**
   * Sets encr pin block.
   *
   * @param encrPINBlock the encr pin block
   */
  public void setEncrPINBlock(ContentInformation encrPINBlock) {
    this.encrPINBlock = encrPINBlock;
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
}
