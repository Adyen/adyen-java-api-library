package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Identification of a previous POI transaction. */
@JsonPropertyOrder({"MessageCategory", "ServiceID", "DeviceID", "SaleID", "POIID"})
public class MessageReference {

  @JsonProperty("MessageCategory")
  @Schema(
      description =
          "Category of message. --Rule: Payment, Loyalty, StoredValue, CardAcquisition, Batch, Reconciliation, Display, Input, Print, CardReaderAPDU,")
  protected MessageCategoryType messageCategory;

  @JsonProperty("ServiceID")
  @Schema(description = "Identification of a message pair, which processes a transaction")
  protected String serviceID;

  @JsonProperty("DeviceID")
  @Schema(description = "Identification of a device message pair", minLength = 1, maxLength = 10)
  protected String deviceID;

  @JsonProperty("SaleID")
  @Schema(
      description =
          "Identification of a Sale System or a Sale Terminal for the Sale to POI protocol --Rule: default MessageHeader.SaleID")
  protected String saleID;

  @JsonProperty("POIID")
  @Schema(
      description =
          "Identification of a POI System or a POI Terminal for the Sale to POI protocol --Rule: default MessageHeader.POIID")
  protected String poiid;

  /**
   * Gets message category.
   *
   * @return the message category
   */
  public MessageCategoryType getMessageCategory() {
    return messageCategory;
  }

  /**
   * Sets message category.
   *
   * @param messageCategory the message category
   */
  public void setMessageCategory(MessageCategoryType messageCategory) {
    this.messageCategory = messageCategory;
  }

  /**
   * Gets service id.
   *
   * @return the service id
   */
  public String getServiceID() {
    return serviceID;
  }

  /**
   * Sets service id.
   *
   * @param serviceID the service id
   */
  public void setServiceID(String serviceID) {
    this.serviceID = serviceID;
  }

  /**
   * Gets device id.
   *
   * @return the device id
   */
  public String getDeviceID() {
    return deviceID;
  }

  /**
   * Sets device id.
   *
   * @param deviceID the device id
   */
  public void setDeviceID(String deviceID) {
    this.deviceID = deviceID;
  }

  /**
   * Gets sale id.
   *
   * @return the sale id
   */
  public String getSaleID() {
    return saleID;
  }

  /**
   * Sets sale id.
   *
   * @param saleID the sale id
   */
  public void setSaleID(String saleID) {
    this.saleID = saleID;
  }

  /**
   * Gets poiid.
   *
   * @return the poiid
   */
  public String getPOIID() {
    return poiid;
  }

  /**
   * Sets poiid.
   *
   * @param poiid the poiid
   */
  public void setPOIID(String poiid) {
    this.poiid = poiid;
  }
}