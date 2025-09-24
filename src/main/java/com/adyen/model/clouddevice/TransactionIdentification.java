package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.OffsetDateTime;

public class TransactionIdentification {

  /** The Transaction id. */
  @JsonProperty("TransactionID")
  @Schema(description = "Unique identification of a transaction")
  protected String transactionID;

  /** The Time stamp. */
  @JsonProperty("TimeStamp")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  @Schema(
      description =
          "Date and time of a transaction for the Sale System, the POI System or the Acquirer.")
  protected OffsetDateTime timeStamp;

  /**
   * Gets the value of the transactionID property.
   *
   * @return possible object is {@link String }
   */
  public String getTransactionID() {
    return transactionID;
  }

  /**
   * Sets the value of the transactionID property.
   *
   * @param value allowed object is {@link String }
   */
  public void setTransactionID(String value) {
    this.transactionID = value;
  }

  /**
   * Gets the value of the timeStamp property.
   *
   * @return instance of OffsetDateTime
   */
  public OffsetDateTime getTimeStamp() {
    return timeStamp;
  }

  /**
   * Sets the value of the timeStamp property.
   *
   * @param value instance of OffsetDateTime
   */
  public void setTimeStamp(OffsetDateTime value) {
    this.timeStamp = value;
  }
}
