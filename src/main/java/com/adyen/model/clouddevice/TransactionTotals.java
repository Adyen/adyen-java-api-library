package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

public class TransactionTotals {

  /** The Payment totals. */
  @JsonProperty("PaymentTotals")
  @Schema(
      description =
          "Totals of the payment transaction during the reconciliation period. --Rule: If both TransactionCount and TransactionAmount are not equal to zero")
  protected List<PaymentTotals> paymentTotals;

  /** The Loyalty totals. */
  @JsonProperty("LoyaltyTotals")
  @Schema(
      description =
          "Totals of the loyalty transaction during the reconciliation period. --Rule: If both TransactionCount and TransactionAmount are not equal to zero")
  protected List<LoyaltyTotals> loyaltyTotals;

  /** The Payment instrument. */
  @JsonProperty("PaymentInstrumentType")
  @Schema(description = "Type of payment instrument.")
  protected PaymentInstrumentType paymentInstrumentType;

  /** The Acquirer id. */
  @JsonProperty("AcquirerID")
  @Schema(description = "Identification of the Acquirer --Rule: If available")
  protected String acquirerID;

  /** The Error condition. */
  @JsonProperty("ErrorCondition")
  @Schema(
      description =
          "Condition that has produced  an error on the processing of a message request --Rule: if Response.Result is Partial, and the reconciliation with this Acquirer failed.")
  protected ErrorConditionType errorCondition;

  /** The Host reconciliation id. */
  @JsonProperty("HostReconciliationID")
  @Schema(
      description =
          "Identifier of a reconciliation period with a payment or loyalty host. --Rule: If available")
  protected String hostReconciliationID;

  /** The Card brand. */
  @JsonProperty("CardBrand")
  @Schema(
      description =
          "Type of payment or loyalty card --Rule: If configured to present totals per card brand, and Response.Result is Success")
  protected String cardBrand;

  /** The Poiid. */
  @JsonProperty("POIID")
  @Schema(
      description =
          "Identification of a POI System or a POI Terminal for the Sale to POI protocol --Rule: If requested in the message request")
  protected String poiid;

  /** The Sale id. */
  @JsonProperty("SaleID")
  @Schema(
      description =
          "Identification of a Sale System or a Sale Terminal for the Sale to POI protocol --Rule: If requested in the message request")
  protected String saleID;

  /** The Operator id. */
  @JsonProperty("OperatorID")
  @Schema(
      description =
          "Identification of the Cashier or Operator. --Rule: If requested in the message request")
  protected String operatorID;

  /** The Shift number. */
  @JsonProperty("ShiftNumber")
  @Schema(description = "Shift number. --Rule: If requested in the message request")
  protected String shiftNumber;

  /** The Totals group id. */
  @JsonProperty("TotalsGroupID")
  @Schema(
      description =
          "Identification of a group of transaction on a POI Terminal, having the same Sale features. --Rule: If requested in the message request")
  protected String totalsGroupID;

  /** The Payment currency. */
  @JsonProperty("PaymentCurrency")
  @Schema(description = "Currency of a monetary amount.")
  protected String paymentCurrency;

  /** The Loyalty unit. */
  @JsonProperty("LoyaltyUnit")
  @Schema(description = "Unit of a loyalty amount.")
  protected LoyaltyUnitType loyaltyUnit;

  /** The Loyalty currency. */
  @JsonProperty("LoyaltyCurrency")
  @Schema(description = "Currency of a monetary amount. --Rule: If LoyaltyUnit is Monetary")
  protected String loyaltyCurrency;

  /**
   * Gets the value of the paymentTotals property.
   *
   * <p>
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the paymentTotals property.
   *
   * <p>
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getPaymentTotals().add(newItem);
   * </pre>
   *
   * <p>
   *
   * <p>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link PaymentTotals }
   *
   * @return the payment totals
   */
  public List<PaymentTotals> getPaymentTotals() {
    if (paymentTotals == null) {
      paymentTotals = new ArrayList<>();
    }
    return this.paymentTotals;
  }

  /**
   * Gets the value of the loyaltyTotals property.
   *
   * <p>
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the loyaltyTotals property.
   *
   * <p>
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getLoyaltyTotals().add(newItem);
   * </pre>
   *
   * <p>
   *
   * <p>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link LoyaltyTotals }
   *
   * @return the loyalty totals
   */
  public List<LoyaltyTotals> getLoyaltyTotals() {
    if (loyaltyTotals == null) {
      loyaltyTotals = new ArrayList<>();
    }
    return this.loyaltyTotals;
  }

  /**
   * Gets the value of the paymentInstrumentType property.
   *
   * @return possible object is {@link PaymentInstrumentType }
   */
  public PaymentInstrumentType getPaymentInstrumentType() {
    return paymentInstrumentType;
  }

  /**
   * Sets the value of the paymentInstrumentType property.
   *
   * @param value allowed object is {@link PaymentInstrumentType }
   */
  public void setPaymentInstrumentType(PaymentInstrumentType value) {
    this.paymentInstrumentType = value;
  }

  /**
   * Gets the value of the acquirerID property.
   *
   * @return possible object is {@link String }
   */
  public String getAcquirerID() {
    return acquirerID;
  }

  /**
   * Sets the value of the acquirerID property.
   *
   * @param value allowed object is {@link String }
   */
  public void setAcquirerID(String value) {
    this.acquirerID = value;
  }

  /**
   * Gets the value of the errorCondition property.
   *
   * @return possible object is {@link ErrorConditionType }
   */
  public ErrorConditionType getErrorCondition() {
    return errorCondition;
  }

  /**
   * Sets the value of the errorCondition property.
   *
   * @param value allowed object is {@link ErrorConditionType }
   */
  public void setErrorCondition(ErrorConditionType value) {
    this.errorCondition = value;
  }

  /**
   * Gets the value of the hostReconciliationID property.
   *
   * @return possible object is {@link String }
   */
  public String getHostReconciliationID() {
    return hostReconciliationID;
  }

  /**
   * Sets the value of the hostReconciliationID property.
   *
   * @param value allowed object is {@link String }
   */
  public void setHostReconciliationID(String value) {
    this.hostReconciliationID = value;
  }

  /**
   * Gets the value of the cardBrand property.
   *
   * @return possible object is {@link String }
   */
  public String getCardBrand() {
    return cardBrand;
  }

  /**
   * Sets the value of the cardBrand property.
   *
   * @param value allowed object is {@link String }
   */
  public void setCardBrand(String value) {
    this.cardBrand = value;
  }

  /**
   * Gets the value of the poiid property.
   *
   * @return possible object is {@link String }
   */
  public String getPOIID() {
    return poiid;
  }

  /**
   * Sets the value of the poiid property.
   *
   * @param value allowed object is {@link String }
   */
  public void setPOIID(String value) {
    this.poiid = value;
  }

  /**
   * Gets the value of the saleID property.
   *
   * @return possible object is {@link String }
   */
  public String getSaleID() {
    return saleID;
  }

  /**
   * Sets the value of the saleID property.
   *
   * @param value allowed object is {@link String }
   */
  public void setSaleID(String value) {
    this.saleID = value;
  }

  /**
   * Gets the value of the operatorID property.
   *
   * @return possible object is {@link String }
   */
  public String getOperatorID() {
    return operatorID;
  }

  /**
   * Sets the value of the operatorID property.
   *
   * @param value allowed object is {@link String }
   */
  public void setOperatorID(String value) {
    this.operatorID = value;
  }

  /**
   * Gets the value of the shiftNumber property.
   *
   * @return possible object is {@link String }
   */
  public String getShiftNumber() {
    return shiftNumber;
  }

  /**
   * Sets the value of the shiftNumber property.
   *
   * @param value allowed object is {@link String }
   */
  public void setShiftNumber(String value) {
    this.shiftNumber = value;
  }

  /**
   * Gets the value of the totalsGroupID property.
   *
   * @return possible object is {@link String }
   */
  public String getTotalsGroupID() {
    return totalsGroupID;
  }

  /**
   * Sets the value of the totalsGroupID property.
   *
   * @param value allowed object is {@link String }
   */
  public void setTotalsGroupID(String value) {
    this.totalsGroupID = value;
  }

  /**
   * Gets the value of the paymentCurrency property.
   *
   * @return possible object is {@link String }
   */
  public String getPaymentCurrency() {
    return paymentCurrency;
  }

  /**
   * Sets the value of the paymentCurrency property.
   *
   * @param value allowed object is {@link String }
   */
  public void setPaymentCurrency(String value) {
    this.paymentCurrency = value;
  }

  /**
   * Gets the value of the loyaltyUnit property.
   *
   * @return possible object is {@link LoyaltyUnitType }
   */
  public LoyaltyUnitType getLoyaltyUnit() {
    if (loyaltyUnit == null) {
      return LoyaltyUnitType.POINT;
    } else {
      return loyaltyUnit;
    }
  }

  /**
   * Sets the value of the loyaltyUnit property.
   *
   * @param value allowed object is {@link LoyaltyUnitType }
   */
  public void setLoyaltyUnit(LoyaltyUnitType value) {
    this.loyaltyUnit = value;
  }

  /**
   * Gets the value of the loyaltyCurrency property.
   *
   * @return possible object is {@link String }
   */
  public String getLoyaltyCurrency() {
    return loyaltyCurrency;
  }

  /**
   * Sets the value of the loyaltyCurrency property.
   *
   * @param value allowed object is {@link String }
   */
  public void setLoyaltyCurrency(String value) {
    this.loyaltyCurrency = value;
  }
}
