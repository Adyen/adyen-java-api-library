package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

/** Customer order attached to a card, recorded in the POI system. */
@JsonPropertyOrder({
  "AdditionalInformation",
  "CustomerOrderID",
  "SaleReferenceID",
  "OpenOrderState",
  "StartDate",
  "EndDate",
  "ForecastedAmount",
  "CurrentAmount",
  "Currency",
  "AccessedBy"
})
public class CustomerOrder {

  @JsonProperty("AdditionalInformation")
  @Schema(description = "Unqualified information. --Rule: If order process in progress.")
  protected String additionalInformation;

  @JsonProperty("CustomerOrderID")
  @Schema(description = "Identification of a customer order.")
  protected String customerOrderID;

  @JsonProperty("SaleReferenceID")
  @Schema(
      description =
          "Identification of a Sale global transaction for a sequence of related POI transactions.")
  protected String saleReferenceID;

  @JsonProperty("OpenOrderState")
  @Schema(description = "State of a customer order.")
  protected Boolean openOrderState;

  @JsonProperty("StartDate")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
  @Schema(description = "Date time of the beginning of an operation.")
  protected OffsetDateTime startDate;

  @JsonProperty("EndDate")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
  @Schema(
      description = "Date time of the end of an operation. --Rule: If ClosedOrderFlag = \"True\".")
  protected OffsetDateTime endDate;

  @JsonProperty("ForecastedAmount")
  @Schema(description = "Amount of a transaction.")
  protected BigDecimal forecastedAmount;

  @JsonProperty("CurrentAmount")
  @Schema(description = "Remaining amount to pay in a transaction.")
  protected BigDecimal currentAmount;

  @JsonProperty("Currency")
  @Schema(description = "Currency of a monetary amount.")
  protected String currency;

  @JsonProperty("AccessedBy")
  @Schema(
      description =
          "Identification of an entity accessing data to perform an operation. --Rule: If multiple currencies are allowed.")
  protected String accessedBy;

  /**
   * Gets additional information.
   *
   * @return the additional information
   */
  public String getAdditionalInformation() {
    return additionalInformation;
  }

  /**
   * Sets additional information.
   *
   * @param additionalInformation the additional information
   */
  public void setAdditionalInformation(String additionalInformation) {
    this.additionalInformation = additionalInformation;
  }

  /**
   * Gets customer order id.
   *
   * @return the customer order id
   */
  public String getCustomerOrderID() {
    return customerOrderID;
  }

  /**
   * Sets customer order id.
   *
   * @param customerOrderID the customer order id
   */
  public void setCustomerOrderID(String customerOrderID) {
    this.customerOrderID = customerOrderID;
  }

  /**
   * Gets sale reference id.
   *
   * @return the sale reference id
   */
  public String getSaleReferenceID() {
    return saleReferenceID;
  }

  /**
   * Sets sale reference id.
   *
   * @param saleReferenceID the sale reference id
   */
  public void setSaleReferenceID(String saleReferenceID) {
    this.saleReferenceID = saleReferenceID;
  }

  /**
   * Is open order state boolean.
   *
   * @return the boolean
   */
  public boolean isOpenOrderState() {
    if (openOrderState == null) {
      return false;
    } else {
      return openOrderState;
    }
  }

  /**
   * Sets open order state.
   *
   * @param openOrderState the open order state
   */
  public void setOpenOrderState(Boolean openOrderState) {
    this.openOrderState = openOrderState;
  }

  /**
   * Gets start date.
   *
   * @return the start date
   */
  public OffsetDateTime getStartDate() {
    return startDate;
  }

  /**
   * Sets start date.
   *
   * @param startDate the start date
   */
  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  /**
   * Gets end date.
   *
   * @return the end date
   */
  public OffsetDateTime getEndDate() {
    return endDate;
  }

  /**
   * Sets end date.
   *
   * @param endDate the end date
   */
  public void setEndDate(OffsetDateTime endDate) {
    this.endDate = endDate;
  }

  /**
   * Gets forecasted amount.
   *
   * @return the forecasted amount
   */
  public BigDecimal getForecastedAmount() {
    return forecastedAmount;
  }

  /**
   * Sets forecasted amount.
   *
   * @param forecastedAmount the forecasted amount
   */
  public void setForecastedAmount(BigDecimal forecastedAmount) {
    this.forecastedAmount = forecastedAmount;
  }

  /**
   * Gets current amount.
   *
   * @return the current amount
   */
  public BigDecimal getCurrentAmount() {
    return currentAmount;
  }

  /**
   * Sets current amount.
   *
   * @param currentAmount the current amount
   */
  public void setCurrentAmount(BigDecimal currentAmount) {
    this.currentAmount = currentAmount;
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

  /**
   * Gets accessed by.
   *
   * @return the accessed by
   */
  public String getAccessedBy() {
    return accessedBy;
  }

  /**
   * Sets accessed by.
   *
   * @param accessedBy the accessed by
   */
  public void setAccessedBy(String accessedBy) {
    this.accessedBy = accessedBy;
  }
}
