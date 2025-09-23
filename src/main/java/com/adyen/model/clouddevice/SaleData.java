package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Data related to the Sale System. */
@JsonPropertyOrder({
    "SaleTransactionID",
    "SaleTerminalData",
    "SponsoredMerchant",
    "SaleToPOIData",
    "SaleToAcquirerData",
    "SaleToIssuerData",
    "OperatorID",
    "OperatorLanguage",
    "ShiftNumber",
    "SaleReferenceID",
    "TokenRequestedType",
    "CustomerOrderID",
    "CustomerOrderReq"
})
public class SaleData {

  @JsonProperty("SaleTransactionID")
  @Schema(description = "Unique identification of a Sale transaction")
  protected TransactionIdentification saleTransactionID;

  @JsonProperty("SaleTerminalData")
  @Schema(
      description =
          "Information related to the software and hardware feature of the Sale Terminal. --Rule: If content is not empty")
  protected SaleTerminalData saleTerminalData;

  @JsonProperty("SponsoredMerchant")
  @Schema(
      description =
          "Merchant using the payment services of a payment facilitator, acting as a card acceptor. --Rule: If the merchant is a payment facilitator providing services to sponsored merchants.")
  protected List<SponsoredMerchant> sponsoredMerchant;

  @JsonProperty("SaleToPOIData")
  @Schema(description = "Sale information intended for the POI. --Rule: Stored with the transaction")
  protected String saleToPOIData;

  @JsonProperty("SaleToAcquirerData")
  @Schema(
      description =
          "Sale information intended for the Acquirer. --Rule: Send to the Acquirer if present")
  protected SaleToAcquirerData saleToAcquirerData;

  @JsonProperty("SaleToIssuerData")
  @Schema(
      description =
          "Sale information intended for the Issuer. --Rule: Send to the Acquirer if present")
  protected SaleToIssuerData saleToIssuerData;

  @JsonProperty("OperatorID")
  @Schema(
      description =
          "Identification of the Cashier or Operator. --Rule: if different from the Login and  see Login .SaleData")
  protected String operatorID;

  @JsonProperty("OperatorLanguage")
  @Schema(description = "Language of the Cashier or Operator. --Rule: if different from the Login")
  protected String operatorLanguage;

  @JsonProperty("ShiftNumber")
  @Schema(
      description = "Shift number. --Rule: if different from the Login and  see Login .SaleData")
  protected String shiftNumber;

  @JsonProperty("SaleReferenceID")
  @Schema(
      description =
          "Identification of a Sale global transaction for a sequence of related POI transactions --Rule: If payment reservation")
  protected String saleReferenceID;

  @JsonProperty("TokenRequestedType")
  @Schema(
      description =
          "Type of token replacing the PAN of a payment card to identify the payment mean of the customer. --Rule: In a Payment or CardAcquisition request, if a token is requested.")
  protected TokenRequestedType tokenRequestedType;

  @JsonProperty("CustomerOrderID")
  @Schema(
      description =
          "Identification of a customer order. --Rule: If the payment is related to an open customer order.")
  protected String customerOrderID;

  @JsonProperty("CustomerOrderReq")
  @Schema(
      description =
          "List of customer orders must be sent in response message. --Rule: If customer orders must be listed in the response message.")
  protected List<CustomerOrderReqType> customerOrderReq;

  /**
   * Gets sale transaction id.
   *
   * @return the sale transaction id
   */
  public TransactionIdentification getSaleTransactionID() {
    return saleTransactionID;
  }

  /**
   * Sets sale transaction id.
   *
   * @param saleTransactionID the sale transaction id
   */
  public void setSaleTransactionID(TransactionIdentification saleTransactionID) {
    this.saleTransactionID = saleTransactionID;
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
   * Gets sponsored merchant.
   *
   * @return the sponsored merchant
   */
  public List<SponsoredMerchant> getSponsoredMerchant() {
    if (sponsoredMerchant == null) {
      sponsoredMerchant = new ArrayList<>();
    }
    return this.sponsoredMerchant;
  }

  /**
   * Sets sponsored merchant.
   *
   * @param sponsoredMerchant the sponsored merchant
   */
  public void setSponsoredMerchant(List<SponsoredMerchant> sponsoredMerchant) {
    this.sponsoredMerchant = sponsoredMerchant;
  }

  /**
   * Gets sale to poi data.
   *
   * @return the sale to poi data
   */
  public String getSaleToPOIData() {
    return saleToPOIData;
  }

  /**
   * Sets sale to poi data.
   *
   * @param saleToPOIData the sale to poi data
   */
  public void setSaleToPOIData(String saleToPOIData) {
    this.saleToPOIData = saleToPOIData;
  }

  /**
   * Gets sale to acquirer data.
   *
   * @return the sale to acquirer data
   */
  public SaleToAcquirerData getSaleToAcquirerData() {
    return saleToAcquirerData;
  }

  /**
   * Sets sale to acquirer data.
   *
   * @param saleToAcquirerData the sale to acquirer data
   */
  public void setSaleToAcquirerData(SaleToAcquirerData saleToAcquirerData) {
    this.saleToAcquirerData = saleToAcquirerData;
  }

  /**
   * Gets sale to issuer data.
   *
   * @return the sale to issuer data
   */
  public SaleToIssuerData getSaleToIssuerData() {
    return saleToIssuerData;
  }

  /**
   * Sets sale to issuer data.
   *
   * @param saleToIssuerData the sale to issuer data
   */
  public void setSaleToIssuerData(SaleToIssuerData saleToIssuerData) {
    this.saleToIssuerData = saleToIssuerData;
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
   * Gets sale reference id.
   *
   * @return the sale reference id
   */
  public String getSaleReferenceID() {
    return saleReferenceID;
  }

  /**
   * Sets sale reference id.
   *
   * @param saleReferenceID the sale reference id
   */
  public void setSaleReferenceID(String saleReferenceID) {
    this.saleReferenceID = saleReferenceID;
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
   * Gets customer order id.
   *
   * @return the customer order id
   */
  public String getCustomerOrderID() {
    return customerOrderID;
  }

  /**
   * Sets customer order id.
   *
   * @param customerOrderID the customer order id
   */
  public void setCustomerOrderID(String customerOrderID) {
    this.customerOrderID = customerOrderID;
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
}