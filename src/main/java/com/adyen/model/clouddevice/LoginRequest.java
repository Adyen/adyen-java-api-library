package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

/** Content of the Login Request message. */
@JsonPropertyOrder({
    "DateTime",
    "SaleSoftware",
    "SaleTerminalData",
    "TrainingModeFlag",
    "OperatorLanguage",
    "OperatorID",
    "ShiftNumber",
    "TokenRequestedType",
    "CustomerOrderReq",
    "POISerialNumber"
})
public class LoginRequest {

  @JsonProperty("DateTime")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
  @Schema(description = "Date and Time")
  protected OffsetDateTime dateTime;

  @JsonProperty("SaleSoftware")
  @Schema(
      description =
          "Information related to the software of the Sale System which manages the Sale to POI protocol.")
  protected SaleSoftware saleSoftware;

  @JsonProperty("SaleTerminalData")
  @Schema(
      description =
          "Information related to the software and hardware feature of the Sale Terminal. --Rule: Present if the login involve a Sale Terminal")
  protected SaleTerminalData saleTerminalData;

  @JsonProperty("TrainingModeFlag")
  @Schema(
      description =
          "Training mode --Rule: The POI does not realise the transaction with the Acquirer")
  protected Boolean trainingModeFlag;

  @JsonProperty("OperatorLanguage")
  @Schema(
      description =
          "Language of the Cashier or Operator. --Rule: Default value for Device type displays")
  protected String operatorLanguage;

  @JsonProperty("OperatorID")
  @Schema(
      description =
          "Identification of the Cashier or Operator. --Rule: 4 conditions to send it: a) the Sale System wants the POI log it in the transaction log b) because of reconciliation")
  protected String operatorID;

  @JsonProperty("ShiftNumber")
  @Schema(description = "Shift number. --Rule: Same as OperatorID")
  protected String shiftNumber;

  @JsonProperty("TokenRequestedType")
  @Schema(
      description =
          "Type of token replacing the PAN of a payment card to identify the payment mean of the customer. --Rule: If a token is requested during the the session.")
  protected TokenRequestedType tokenRequestedType;

  @JsonProperty("CustomerOrderReq")
  @Schema(
      description =
          "List of customer orders must be sent in response message. --Rule: If customer orders must be listed in Card Acquisition and Payment response messages during the session.")
  protected List<CustomerOrderReqType> customerOrderReq;

  @JsonProperty("POISerialNumber")
  @Schema(
      description =
          "Serial number of a POI Terminal --Rule: If the login involve a POI Terminal and not the first Login to the POI System")
  protected String poiSerialNumber;

  /**
   * Gets date time.
   *
   * @return the date time
   */
  public OffsetDateTime getDateTime() {
    return dateTime;
  }

  /**
   * Sets date time.
   *
   * @param dateTime the date time
   */
  public void setDateTime(OffsetDateTime dateTime) {
    this.dateTime = dateTime;
  }

  /**
   * Gets sale software.
   *
   * @return the sale software
   */
  public SaleSoftware getSaleSoftware() {
    return saleSoftware;
  }

  /**
   * Sets sale software.
   *
   * @param saleSoftware the sale software
   */
  public void setSaleSoftware(SaleSoftware saleSoftware) {
    this.saleSoftware = saleSoftware;
  }

  /**
   * Gets sale terminal data.
   *
   * @return the sale terminal data
   */
  public SaleTerminalData getSaleTerminalData() {
    return saleTerminalData;
  }

  /**
   * Sets sale terminal data.
   *
   * @param saleTerminalData the sale terminal data
   */
  public void setSaleTerminalData(SaleTerminalData saleTerminalData) {
    this.saleTerminalData = saleTerminalData;
  }

  /**
   * Is training mode flag boolean.
   *
   * @return the boolean
   */
  public boolean isTrainingModeFlag() {
    if (trainingModeFlag == null) {
      return false;
    } else {
      return trainingModeFlag;
    }
  }

  /**
   * Sets training mode flag.
   *
   * @param trainingModeFlag the training mode flag
   */
  public void setTrainingModeFlag(Boolean trainingModeFlag) {
    this.trainingModeFlag = trainingModeFlag;
  }

  /**
   * Gets operator language.
   *
   * @return the operator language
   */
  public String getOperatorLanguage() {
    return operatorLanguage;
  }

  /**
   * Sets operator language.
   *
   * @param operatorLanguage the operator language
   */
  public void setOperatorLanguage(String operatorLanguage) {
    this.operatorLanguage = operatorLanguage;
  }

  /**
   * Gets operator id.
   *
   * @return the operator id
   */
  public String getOperatorID() {
    return operatorID;
  }

  /**
   * Sets operator id.
   *
   * @param operatorID the operator id
   */
  public void setOperatorID(String operatorID) {
    this.operatorID = operatorID;
  }

  /**
   * Gets shift number.
   *
   * @return the shift number
   */
  public String getShiftNumber() {
    return shiftNumber;
  }

  /**
   * Sets shift number.
   *
   * @param shiftNumber the shift number
   */
  public void setShiftNumber(String shiftNumber) {
    this.shiftNumber = shiftNumber;
  }

  /**
   * Gets token requested type.
   *
   * @return the token requested type
   */
  public TokenRequestedType getTokenRequestedType() {
    return tokenRequestedType;
  }

  /**
   * Sets token requested type.
   *
   * @param tokenRequestedType the token requested type
   */
  public void setTokenRequestedType(TokenRequestedType tokenRequestedType) {
    this.tokenRequestedType = tokenRequestedType;
  }

  /**
   * Gets customer order req.
   *
   * @return the customer order req
   */
  public List<CustomerOrderReqType> getCustomerOrderReq() {
    if (customerOrderReq == null) {
      customerOrderReq = new ArrayList<>();
    }
    return this.customerOrderReq;
  }

  /**
   * Sets customer order req.
   *
   * @param customerOrderReq the customer order req
   */
  public void setCustomerOrderReq(List<CustomerOrderReqType> customerOrderReq) {
    this.customerOrderReq = customerOrderReq;
  }

  /**
   * Gets poi serial number.
   *
   * @return the poi serial number
   */
  public String getPOISerialNumber() {
    return poiSerialNumber;
  }

  /**
   * Sets poi serial number.
   *
   * @param poiSerialNumber the poi serial number
   */
  public void setPOISerialNumber(String poiSerialNumber) {
    this.poiSerialNumber = poiSerialNumber;
  }
}