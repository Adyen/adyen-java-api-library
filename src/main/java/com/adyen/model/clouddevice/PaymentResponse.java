package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Content of the Payment Response message. */
@JsonPropertyOrder({
    "Response",
    "SaleData",
    "POIData",
    "PaymentResult",
    "LoyaltyResult",
    "PaymentReceipt",
    "CustomerOrder"
})
public class PaymentResponse {

  @JsonProperty("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  @JsonProperty("SaleData")
  @Schema(description = "Data related to the Sale System. --Rule: Copy")
  protected SaleData saleData;

  @JsonProperty("POIData")
  @Schema(description = "Data related to the POI System.")
  protected POIData poiData;

  @JsonProperty("PaymentResult")
  @Schema(
      description =
          "Data related to the result of a processed payment transaction. --Rule: If one data element is present")
  protected PaymentResult paymentResult;

  @JsonProperty("LoyaltyResult")
  @Schema(
      description =
          "Data related to the result of a processed loyalty transaction. --Rule: Loyalty cards used with the payment transaction")
  protected List<LoyaltyResult> loyaltyResult;

  @JsonProperty("PaymentReceipt")
  @Schema(
      description =
          "Customer or Merchant payment receipt. --Rule: If Basic profile implementation with no printer on the POI.")
  protected List<PaymentReceipt> paymentReceipt;

  @JsonProperty("CustomerOrder")
  @Schema(
      description =
          "Customer order attached to a card, recorded in the POI system. --Rule: If the list of customer orders has been requested.")
  protected List<CustomerOrder> customerOrder;

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
   * Gets poi data.
   *
   * @return the poi data
   */
  public POIData getPOIData() {
    return poiData;
  }

  /**
   * Sets poi data.
   *
   * @param poiData the poi data
   */
  public void setPOIData(POIData poiData) {
    this.poiData = poiData;
  }

  /**
   * Gets payment result.
   *
   * @return the payment result
   */
  public PaymentResult getPaymentResult() {
    return paymentResult;
  }

  /**
   * Sets payment result.
   *
   * @param paymentResult the payment result
   */
  public void setPaymentResult(PaymentResult paymentResult) {
    this.paymentResult = paymentResult;
  }

  /**
   * Gets loyalty result.
   *
   * @return the loyalty result
   */
  public List<LoyaltyResult> getLoyaltyResult() {
    if (loyaltyResult == null) {
      loyaltyResult = new ArrayList<>();
    }
    return this.loyaltyResult;
  }

  /**
   * Sets loyalty result.
   *
   * @param loyaltyResult the loyalty result
   */
  public void setLoyaltyResult(List<LoyaltyResult> loyaltyResult) {
    this.loyaltyResult = loyaltyResult;
  }

  /**
   * Gets payment receipt.
   *
   * @return the payment receipt
   */
  public List<PaymentReceipt> getPaymentReceipt() {
    if (paymentReceipt == null) {
      paymentReceipt = new ArrayList<>();
    }
    return this.paymentReceipt;
  }

  /**
   * Sets payment receipt.
   *
   * @param paymentReceipt the payment receipt
   */
  public void setPaymentReceipt(List<PaymentReceipt> paymentReceipt) {
    this.paymentReceipt = paymentReceipt;
  }

  /**
   * Gets customer order.
   *
   * @return the customer order
   */
  public List<CustomerOrder> getCustomerOrder() {
    if (customerOrder == null) {
      customerOrder = new ArrayList<>();
    }
    return this.customerOrder;
  }

  /**
   * Sets customer order.
   *
   * @param customerOrder the customer order
   */
  public void setCustomerOrder(List<CustomerOrder> customerOrder) {
    this.customerOrder = customerOrder;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentResponse {\n");
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
    sb.append("    saleData: ").append(toIndentedString(saleData)).append("\n");
    sb.append("    poiData: ").append(toIndentedString(poiData)).append("\n");
    sb.append("    paymentResult: ").append(toIndentedString(paymentResult)).append("\n");
    sb.append("    loyaltyResult: ").append(toIndentedString(loyaltyResult)).append("\n");
    sb.append("    paymentReceipt: ").append(toIndentedString(paymentReceipt)).append("\n");
    sb.append("    customerOrder: ").append(toIndentedString(customerOrder)).append("\n");
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