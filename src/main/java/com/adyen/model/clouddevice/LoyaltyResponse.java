package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Content of the Loyalty Response message. */
@JsonPropertyOrder({"Response", "SaleData", "POIData", "LoyaltyResult", "PaymentReceipt"})
public class LoyaltyResponse {

  @JsonProperty("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  @JsonProperty("SaleData")
  @Schema(description = "Data related to the Sale System.")
  protected SaleData saleData;

  @JsonProperty("POIData")
  @Schema(description = "Data related to the POI System.")
  protected POIData poiData;

  @JsonProperty("LoyaltyResult")
  @Schema(
      description =
          "Data related to the result of a processed loyalty transaction. --Rule: if loyalty account identified")
  protected List<LoyaltyResult> loyaltyResult;

  @JsonProperty("PaymentReceipt")
  @Schema(
      description =
          "Customer or Merchant payment receipt. --Rule: If Basic profile implementation with no printer on the POI.")
  protected List<PaymentReceipt> paymentReceipt;

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
}