package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Sensitive information related to the payment card, entered or read by the Sale System. */
@JsonPropertyOrder({"TrackData", "PAN", "CardSeqNumb", "ExpiryDate"})
public class SensitiveCardData {

  @JsonProperty("TrackData")
  @Schema(
      description =
          "Magnetic track or magnetic ink characters line. --Rule: if EntryMode is MagStripe or RFID ")
  protected List<TrackData> trackData;

  @JsonProperty("PAN")
  @Schema(description = "Primary Account Number --Rule:  ", minLength = 8, maxLength = 28)
  protected String pan;

  @JsonProperty("CardSeqNumb")
  @Schema(
      description = "Card Sequence Number --Rule: if EntryMode is File, Keyed or Manual",
      minLength = 2,
      maxLength = 3)
  protected String cardSeqNumb;

  @JsonProperty("ExpiryDate")
  @Schema(
      description = "Date after which the card cannot be used. --Rule: if EntryMode is File",
      minLength = 4,
      maxLength = 4)
  protected String expiryDate;

  /**
   * Gets track data.
   *
   * @return the track data
   */
  public List<TrackData> getTrackData() {
    if (trackData == null) {
      trackData = new ArrayList<>();
    }
    return this.trackData;
  }

  /**
   * Sets track data.
   *
   * @param trackData the track data
   */
  public void setTrackData(List<TrackData> trackData) {
    this.trackData = trackData;
  }

  /**
   * Gets pan.
   *
   * @return the pan
   */
  public String getPAN() {
    return pan;
  }

  /**
   * Sets pan.
   *
   * @param pan the pan
   */
  public void setPAN(String pan) {
    this.pan = pan;
  }

  /**
   * Gets card seq numb.
   *
   * @return the card seq numb
   */
  public String getCardSeqNumb() {
    return cardSeqNumb;
  }

  /**
   * Sets card seq numb.
   *
   * @param cardSeqNumb the card seq numb
   */
  public void setCardSeqNumb(String cardSeqNumb) {
    this.cardSeqNumb = cardSeqNumb;
  }

  /**
   * Gets expiry date.
   *
   * @return the expiry date
   */
  public String getExpiryDate() {
    return expiryDate;
  }

  /**
   * Sets expiry date.
   *
   * @param expiryDate the expiry date
   */
  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }
}
