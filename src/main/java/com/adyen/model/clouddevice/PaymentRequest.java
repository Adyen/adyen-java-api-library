package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Content of the Payment Request message. */
@JsonPropertyOrder({"SaleData", "PaymentTransaction", "PaymentData", "LoyaltyData"})
public class PaymentRequest {

  @JsonProperty("SaleData")
  @Schema(description = "Data related to the Sale System.")
  protected SaleData saleData;

  @JsonProperty("PaymentTransaction")
  @Schema(description = "Data related to the payment and loyalty transaction.")
  protected PaymentTransaction paymentTransaction;

  @JsonProperty("PaymentData")
  @Schema(
      description =
          "Data related to the payment transaction. --Rule: If one data element is present")
  protected PaymentData paymentData;

  @JsonProperty("LoyaltyData")
  @Schema(
      description =
          "Data related to a Loyalty program or account. --Rule: Loyalty cards used with the payment transaction and read by the Sale System")
  protected List<LoyaltyData> loyaltyData;

  /**
   * Gets sale data.
   *
   * @return the sale data
   */
  public SaleData getSaleData() {
    return saleData;
  }

  /**
   * Sets sale data.
   *
   * @param saleData the sale data
   */
  public void setSaleData(SaleData saleData) {
    this.saleData = saleData;
  }

  /**
   * Gets payment transaction.
   *
   * @return the payment transaction
   */
  public PaymentTransaction getPaymentTransaction() {
    return paymentTransaction;
  }

  /**
   * Sets payment transaction.
   *
   * @param paymentTransaction the payment transaction
   */
  public void setPaymentTransaction(PaymentTransaction paymentTransaction) {
    this.paymentTransaction = paymentTransaction;
  }

  /**
   * Gets payment data.
   *
   * @return the payment data
   */
  public PaymentData getPaymentData() {
    return paymentData;
  }

  /**
   * Sets payment data.
   *
   * @param paymentData the payment data
   */
  public void setPaymentData(PaymentData paymentData) {
    this.paymentData = paymentData;
  }

  /**
   * Gets loyalty data.
   *
   * @return the loyalty data
   */
  public List<LoyaltyData> getLoyaltyData() {
    if (loyaltyData == null) {
      loyaltyData = new ArrayList<>();
    }
    return this.loyaltyData;
  }

  /**
   * Sets loyalty data.
   *
   * @param loyaltyData the loyalty data
   */
  public void setLoyaltyData(List<LoyaltyData> loyaltyData) {
    this.loyaltyData = loyaltyData;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentRequest {\n");
    sb.append("    saleData: ").append(toIndentedString(saleData)).append("\n");
    sb.append("    paymentTransaction: ").append(toIndentedString(paymentTransaction)).append("\n");
    sb.append("    paymentData: ").append(toIndentedString(paymentData)).append("\n");
    sb.append("    loyaltyData: ").append(toIndentedString(loyaltyData)).append("\n");
    sb.append("}\n");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}