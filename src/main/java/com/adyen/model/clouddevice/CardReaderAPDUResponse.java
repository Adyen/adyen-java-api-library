package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Content of the Card Reader APDU Response message. */
@JsonPropertyOrder({"Response", "APDUData", "CardStatusWords"})
public class CardReaderAPDUResponse {

  @JsonProperty("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  @JsonProperty("APDUData")
  @Schema(description = "Data field of the APDU command (Lc + Data)")
  protected byte[] apduData;

  @JsonProperty("CardStatusWords")
  @Schema(description = "Status of a smartcard response to a command (SW1-SW2)")
  protected byte[] cardStatusWords;

  /**
   * Gets response.
   *
   * @return the response
   */
  public Response getResponse() {
    return response;
  }

  /**
   * Sets response.
   *
   * @param response the response
   */
  public void setResponse(Response response) {
    this.response = response;
  }

  /**
   * Get apdu data.
   *
   * @return the byte [ ]
   */
  public byte[] getAPDUData() {
    return apduData;
  }

  /**
   * Sets apdu data.
   *
   * @param apduData the apdu data
   */
  public void setAPDUData(byte[] apduData) {
    this.apduData = apduData;
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