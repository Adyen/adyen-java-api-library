package com.adyen.model.clouddevice;

import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class StoredValueRequest {

  /** The Sale data. */
  @JsonProperty("SaleData")
  @Schema(description = "Data related to the Sale System.")
  protected SaleData saleData;

  /** The Stored value data. */
  @JsonProperty("StoredValueData")
  @Schema(description = "Data related to the stored value card.")
  protected List<StoredValueData> storedValueData;

  /** The Customer language. */
  @JsonProperty("CustomerLanguage")
  @Schema(
      description =
          "Language of the Customer --Rule: If the language is selected by the Sale System before the request to the POI.")
  protected String customerLanguage;

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
   * Gets the value of the storedValueData property.
   *
   * <p>
   *
   * <p>
   *
   * <p>
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the storedValueData property.
   *
   * <p>
   *
   * <p>
   *
   * <p>
   *
   * <p>
   *
   * <p>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link StoredValueData }
   *
   * @return the stored value data
   */
  public List<StoredValueData> getStoredValueData() {
    if (storedValueData == null) {
      storedValueData = new ArrayList<>();
    }
    return this.storedValueData;
  }

  /**
   * Gets the value of the customerLanguage property.
   *
   * @return possible object is {@link String }
   */
  public String getCustomerLanguage() {
    return customerLanguage;
  }

  /**
   * Sets the value of the customerLanguage property.
   *
   * @param value allowed object is {@link String }
   */
  public void setCustomerLanguage(String value) {
    this.customerLanguage = value;
  }
}
