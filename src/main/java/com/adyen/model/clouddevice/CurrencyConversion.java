package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

/** Information related to a currency conversion. */
@JsonPropertyOrder({
    "ConvertedAmount",
    "Commission",
    "Declaration",
    "CustomerApprovedFlag",
    "Rate",
    "Markup"
})
public class CurrencyConversion {

  @JsonProperty("ConvertedAmount")
  @Schema(description = "Amount after a currency conversion.")
  protected Amount convertedAmount;

  @JsonProperty("Commission")
  @Schema(description = "Commission for a service. --Rule: Commission of the conversion.")
  protected BigDecimal commission;

  @JsonProperty("Declaration")
  @Schema(
      description =
          "Declaration to present to the customer or the cashier for validation. --Rule: If a declaration has to be presented to the customer")
  protected String declaration;

  @JsonProperty("CustomerApprovedFlag")
  @Schema(description = "Notify if the customer has approved something.")
  protected Boolean customerApprovedFlag;

  @JsonProperty("Rate")
  @Schema(
      description =
          "Rate of currency conversion. --Rule: Conversion rate of the target currency against the source currency.")
  protected BigDecimal rate;

  @JsonProperty("Markup")
  @Schema(description = "Markup of an amount in percentage. --Rule: Markup of the conversion.")
  protected BigDecimal markup;

  /**
   * Gets converted amount.
   *
   * @return the converted amount
   */
  public Amount getConvertedAmount() {
    return convertedAmount;
  }

  /**
   * Sets converted amount.
   *
   * @param convertedAmount the converted amount
   */
  public void setConvertedAmount(Amount convertedAmount) {
    this.convertedAmount = convertedAmount;
  }

  /**
   * Gets commission.
   *
   * @return the commission
   */
  public BigDecimal getCommission() {
    return commission;
  }

  /**
   * Sets commission.
   *
   * @param commission the commission
   */
  public void setCommission(BigDecimal commission) {
    this.commission = commission;
  }

  /**
   * Gets declaration.
   *
   * @return the declaration
   */
  public String getDeclaration() {
    return declaration;
  }

  /**
   * Sets declaration.
   *
   * @param declaration the declaration
   */
  public void setDeclaration(String declaration) {
    this.declaration = declaration;
  }

  /**
   * Is customer approved flag boolean.
   *
   * @return the boolean
   */
  public boolean isCustomerApprovedFlag() {
    if (customerApprovedFlag == null) {
      return true;
    } else {
      return customerApprovedFlag;
    }
  }

  /**
   * Sets customer approved flag.
   *
   * @param customerApprovedFlag the customer approved flag
   */
  public void setCustomerApprovedFlag(Boolean customerApprovedFlag) {
    this.customerApprovedFlag = customerApprovedFlag;
  }

  /**
   * Gets rate.
   *
   * @return the rate
   */
  public BigDecimal getRate() {
    return rate;
  }

  /**
   * Sets rate.
   *
   * @param rate the rate
   */
  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  /**
   * Gets markup.
   *
   * @return the markup
   */
  public BigDecimal getMarkup() {
    return markup;
  }

  /**
   * Sets markup.
   *
   * @param markup the markup
   */
  public void setMarkup(BigDecimal markup) {
    this.markup = markup;
  }
}