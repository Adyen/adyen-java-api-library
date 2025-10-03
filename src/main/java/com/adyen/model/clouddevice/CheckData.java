package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Information related to the paper check used for the transaction. */
@JsonPropertyOrder({
  "BankID",
  "AccountNumber",
  "CheckNumber",
  "TrackData",
  "CheckCardNumber",
  "TypeCode",
  "Country"
})
public class CheckData {

  @JsonProperty("BankID")
  @Schema(description = "Identification of the bank. --Rule: Mandatory if TrackData absent")
  protected String bankID;

  @JsonProperty("AccountNumber")
  @Schema(
      description = "Identification of the customer account. --Rule: Mandatory if TrackData absent")
  protected String accountNumber;

  @JsonProperty("CheckNumber")
  @Schema(description = "Identification of the bank check. --Rule: Mandatory if TrackData absent")
  protected String checkNumber;

  @JsonProperty("TrackData")
  @Schema(
      description =
          "Magnetic track or magnetic ink characters line. --Rule: Mandatory if CheckNumber absent")
  protected TrackData trackData;

  @JsonProperty("CheckCardNumber")
  @Schema(description = "Check guarantee card number. --Rule: If provided by the customer")
  protected String checkCardNumber;

  @JsonProperty("TypeCode")
  @Schema(description = "Type of bank check.")
  protected CheckTypeCodeType typeCode;

  @JsonProperty("Country")
  @Schema(description = "Country of the bank check. --Rule: Absent if country of the Sale system")
  protected String country;

  /**
   * Gets bank id.
   *
   * @return the bank id
   */
  public String getBankID() {
    return bankID;
  }

  /**
   * Sets bank id.
   *
   * @param bankID the bank id
   */
  public void setBankID(String bankID) {
    this.bankID = bankID;
  }

  /**
   * Gets account number.
   *
   * @return the account number
   */
  public String getAccountNumber() {
    return accountNumber;
  }

  /**
   * Sets account number.
   *
   * @param accountNumber the account number
   */
  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  /**
   * Gets check number.
   *
   * @return the check number
   */
  public String getCheckNumber() {
    return checkNumber;
  }

  /**
   * Sets check number.
   *
   * @param checkNumber the check number
   */
  public void setCheckNumber(String checkNumber) {
    this.checkNumber = checkNumber;
  }

  /**
   * Gets track data.
   *
   * @return the track data
   */
  public TrackData getTrackData() {
    return trackData;
  }

  /**
   * Sets track data.
   *
   * @param trackData the track data
   */
  public void setTrackData(TrackData trackData) {
    this.trackData = trackData;
  }

  /**
   * Gets check card number.
   *
   * @return the check card number
   */
  public String getCheckCardNumber() {
    return checkCardNumber;
  }

  /**
   * Sets check card number.
   *
   * @param checkCardNumber the check card number
   */
  public void setCheckCardNumber(String checkCardNumber) {
    this.checkCardNumber = checkCardNumber;
  }

  /**
   * Gets type code.
   *
   * @return the type code
   */
  public CheckTypeCodeType getTypeCode() {
    if (typeCode == null) {
      return CheckTypeCodeType.PERSONAL;
    } else {
      return typeCode;
    }
  }

  /**
   * Sets type code.
   *
   * @param typeCode the type code
   */
  public void setTypeCode(CheckTypeCodeType typeCode) {
    this.typeCode = typeCode;
  }

  /**
   * Gets country.
   *
   * @return the country
   */
  public String getCountry() {
    return country;
  }

  /**
   * Sets country.
   *
   * @param country the country
   */
  public void setCountry(String country) {
    this.country = country;
  }
}
