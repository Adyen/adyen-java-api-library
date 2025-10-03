package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

public class StoredValueResponse {

  /** The Response. */
  @JsonProperty("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  /** The Sale data. */
  @JsonProperty("SaleData")
  @Schema(description = "Data related to the Sale System.")
  protected SaleData saleData;

  /** The Poi data. */
  @JsonProperty("POIData")
  @Schema(description = "Data related to the POI System.")
  protected POIData poiData;

  /** The Stored value result. */
  @JsonProperty("StoredValueResult")
  @Schema(
      description =
          "Result of loading/reloading a stored value card.. --Rule: If StoredValueResponse.Result is \"Success\" or \"Partial\", one entry per StoredValueRequest.StoredValueData loaded or")
  protected List<StoredValueResult> storedValueResult;

  /** The Payment receipt. */
  @JsonProperty("PaymentReceipt")
  protected List<PaymentReceipt> paymentReceipt;

  /**
   * Gets the value of the response property.
   *
   * @return possible object is {@link Response }
   */
  public Response getResponse() {
    return response;
  }

  /**
   * Sets the value of the response property.
   *
   * @param value allowed object is {@link Response }
   */
  public void setResponse(Response value) {
    this.response = value;
  }

  /**
   * Gets the value of the saleData property.
   *
   * @return possible object is {@link SaleData }
   */
  public SaleData getSaleData() {
    return saleData;
  }

  /**
   * Sets the value of the saleData property.
   *
   * @param value allowed object is {@link SaleData }
   */
  public void setSaleData(SaleData value) {
    this.saleData = value;
  }

  /**
   * Gets the value of the poiData property.
   *
   * @return possible object is {@link POIData }
   */
  public POIData getPOIData() {
    return poiData;
  }

  /**
   * Sets the value of the poiData property.
   *
   * @param value allowed object is {@link POIData }
   */
  public void setPOIData(POIData value) {
    this.poiData = value;
  }

  /**
   * Gets the value of the storedValueResult property.
   *
   * <p>
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the storedValueResult property.
   *
   * <p>
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getStoredValueResult().add(newItem);
   * </pre>
   *
   * <p>
   *
   * <p>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link StoredValueResult }
   *
   * @return the stored value result
   */
  public List<StoredValueResult> getStoredValueResult() {
    if (storedValueResult == null) {
      storedValueResult = new ArrayList<>();
    }
    return this.storedValueResult;
  }

  public List<PaymentReceipt> getPaymentReceipt() {
    return paymentReceipt;
  }

  public void setPaymentReceipt(List<PaymentReceipt> paymentReceipt) {
    this.paymentReceipt = paymentReceipt;
  }
}
