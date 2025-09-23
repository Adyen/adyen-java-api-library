package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Status of cash handling device. */
@JsonPropertyOrder({"CoinsOrBills", "CashHandlingOKFlag", "Currency"})
public class CashHandlingDevice {

  @JsonProperty("CoinsOrBills")
  @Schema(description = "Number of coins or bills of a given value.")
  protected List<CoinsOrBills> coinsOrBills;

  @JsonProperty("CashHandlingOKFlag")
  @Schema(description = "Indicates if the cash handling device is working and usable.")
  protected boolean cashHandlingOKFlag;

  @JsonProperty("Currency")
  @Schema(description = "Currency of a monetary amount.")
  protected String currency;

  /**
   * Gets coins or bills.
   *
   * @return the coins or bills
   */
  public List<CoinsOrBills> getCoinsOrBills() {
    if (coinsOrBills == null) {
      coinsOrBills = new ArrayList<>();
    }
    return this.coinsOrBills;
  }

  /**
   * Sets coins or bills.
   *
   * @param coinsOrBills the coins or bills
   */
  public void setCoinsOrBills(List<CoinsOrBills> coinsOrBills) {
    this.coinsOrBills = coinsOrBills;
  }

  /**
   * Is cash handling ok flag boolean.
   *
   * @return the boolean
   */
  public boolean isCashHandlingOKFlag() {
    return cashHandlingOKFlag;
  }

  /**
   * Sets cash handling ok flag.
   *
   * @param cashHandlingOKFlag the cash handling ok flag
   */
  public void setCashHandlingOKFlag(boolean cashHandlingOKFlag) {
    this.cashHandlingOKFlag = cashHandlingOKFlag;
  }

  /**
   * Gets currency.
   *
   * @return the currency
   */
  public String getCurrency() {
    return currency;
  }

  /**
   * Sets currency.
   *
   * @param currency the currency
   */
  public void setCurrency(String currency) {
    this.currency = currency;
  }
}