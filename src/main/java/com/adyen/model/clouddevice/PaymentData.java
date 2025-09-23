package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Data related to the payment transaction. */
@JsonPropertyOrder({
    "CardAcquisitionReference",
    "RequestedValidityDate",
    "Instalment",
    "CustomerOrder",
    "PaymentInstrumentData",
    "PaymentType",
    "SplitPaymentFlag"
})
public class PaymentData {

  @JsonProperty("CardAcquisitionReference")
  @Schema(
      description =
          "Reference to the last CardAcquisition, to use the same card. --Rule: if the card data comes from a previous CardAcquisition")
  protected TransactionIdentification cardAcquisitionReference;

  @JsonProperty("RequestedValidityDate")
  @Schema(
      description =
          "Requested validity date for the reservation. --Rule: If time period of the OneTimeReservation, FirstReservation or UpdateReservation is requested")
  protected String requestedValidityDate;

  @JsonProperty("Instalment")
  @Schema(
      description =
          "Information related an instalment transaction. --Rule: If PaymentType is \"Instalment\" or \"IssuerInstalment\"")
  protected Instalment instalment;

  @JsonProperty("CustomerOrder")
  @Schema(
      description =
          "Customer order attached to a card, recorded in the POI system. --Rule: If a customer orders has to be created.")
  protected CustomerOrder customerOrder;

  @JsonProperty("PaymentInstrumentData")
  @Schema(
      description =
          "Data related to the instrument of payment for the transaction. --Rule: If payment instrument data are read by the Sale System")
  protected PaymentInstrumentData paymentInstrumentData;

  @JsonProperty("PaymentType")
  @Schema(description = "Type of payment transaction.")
  protected PaymentType paymentType;

  @JsonProperty("SplitPaymentFlag")
  @Schema(description = "Indicates if the payment of the Sale transaction is split.")
  protected Boolean splitPaymentFlag;

  /**
   * Gets card acquisition reference.
   *
   * @return the card acquisition reference
   */
  public TransactionIdentification getCardAcquisitionReference() {
    return cardAcquisitionReference;
  }

  /**
   * Sets card acquisition reference.
   *
   * @param cardAcquisitionReference the card acquisition reference
   */
  public void setCardAcquisitionReference(TransactionIdentification cardAcquisitionReference) {
    this.cardAcquisitionReference = cardAcquisitionReference;
  }

  /**
   * Gets requested validity date.
   *
   * @return the requested validity date
   */
  public String getRequestedValidityDate() {
    return requestedValidityDate;
  }

  /**
   * Sets requested validity date.
   *
   * @param requestedValidityDate the requested validity date
   */
  public void setRequestedValidityDate(String requestedValidityDate) {
    this.requestedValidityDate = requestedValidityDate;
  }

  /**
   * Gets instalment.
   *
   * @return the instalment
   */
  public Instalment getInstalment() {
    return instalment;
  }

  /**
   * Sets instalment.
   *
   * @param instalment the instalment
   */
  public void setInstalment(Instalment instalment) {
    this.instalment = instalment;
  }

  /**
   * Gets customer order.
   *
   * @return the customer order
   */
  public CustomerOrder getCustomerOrder() {
    return customerOrder;
  }

  /**
   * Sets customer order.
   *
   * @param customerOrder the customer order
   */
  public void setCustomerOrder(CustomerOrder customerOrder) {
    this.customerOrder = customerOrder;
  }

  /**
   * Gets payment instrument data.
   *
   * @return the payment instrument data
   */
  public PaymentInstrumentData getPaymentInstrumentData() {
    return paymentInstrumentData;
  }

  /**
   * Sets payment instrument data.
   *
   * @param paymentInstrumentData the payment instrument data
   */
  public void setPaymentInstrumentData(PaymentInstrumentData paymentInstrumentData) {
    this.paymentInstrumentData = paymentInstrumentData;
  }

  /**
   * Gets payment type.
   *
   * @return the payment type
   */
  public PaymentType getPaymentType() {
    if (paymentType == null) {
      return PaymentType.NORMAL;
    } else {
      return paymentType;
    }
  }

  /**
   * Sets payment type.
   *
   * @param paymentType the payment type
   */
  public void setPaymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
  }

  /**
   * Is split payment flag boolean.
   *
   * @return the boolean
   */
  public boolean isSplitPaymentFlag() {
    if (splitPaymentFlag == null) {
      return false;
    } else {
      return splitPaymentFlag;
    }
  }

  /**
   * Sets split payment flag.
   *
   * @param splitPaymentFlag the split payment flag
   */
  public void setSplitPaymentFlag(Boolean splitPaymentFlag) {
    this.splitPaymentFlag = splitPaymentFlag;
  }
}