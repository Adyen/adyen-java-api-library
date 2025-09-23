package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Data of a Chip Card related to the reset of the chip. */
@JsonPropertyOrder({"ATRValue", "CardStatusWords"})
public class ICCResetData {

  @JsonProperty("ATRValue")
  @Schema(
      description = "Value of the Answer To Reset of a chip card --Rule: if available",
      minLength = 1,
      maxLength = 100)
  protected byte[] atrValue;

  @JsonProperty("CardStatusWords")
  @Schema(
      description = "Status of a smartcard response to a command (SW1-SW2) --Rule: if available",
      minLength = 2,
      maxLength = 2)
  protected byte[] cardStatusWords;

  /**
   * Get atr value.
   *
   * @return the byte [ ]
   */
  public byte[] getATRValue() {
    return atrValue;
  }

  /**
   * Sets atr value.
   *
   * @param atrValue the atr value
   */
  public void setATRValue(byte[] atrValue) {
    this.atrValue = atrValue;
  }

  /**
   * Get card status words.
   *
   * @return the byte [ ]
   */
  public byte[] getCardStatusWords() {
    return cardStatusWords;
  }

  /**
   * Sets card status words.
   *
   * @param cardStatusWords the card status words
   */
  public void setCardStatusWords(byte[] cardStatusWords) {
    this.cardStatusWords = cardStatusWords;
  }
}