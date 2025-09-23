package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Content of the PIN Response message. */
@JsonPropertyOrder({"Response", "CardholderPIN"})
public class PINResponse {

  @JsonProperty("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  @JsonProperty("CardholderPIN")
  @Schema(description = "Encrypted PIN and related information")
  protected CardholderPIN cardholderPIN;

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
}