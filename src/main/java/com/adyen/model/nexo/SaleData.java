package com.adyen.model.nexo;

import com.adyen.model.terminal.SaleToAcquirerData;
import com.adyen.serializer.SaleToAcquirerDataSerializer;
import com.google.gson.annotations.JsonAdapter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Data related to the Sale System. -- Usage: Data associated to the Sale System, with a particular value during the processing of the payment by the POI, including the cards acquisition.
 *
 * <p>Java class for SaleData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SaleData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SaleTransactionID" type="{}TransactionIdentification"/&gt;
 *         &lt;element name="SaleTerminalData" type="{}SaleTerminalData" minOccurs="0"/&gt;
 *         &lt;element name="SponsoredMerchant" type="{}SponsoredMerchant" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="SaleToPOIData" type="{}SaleToPOIData" minOccurs="0"/&gt;
 *         &lt;element name="SaleToAcquirerData" type="{}SaleToAcquirerData" minOccurs="0"/&gt;
 *         &lt;element name="SaleToIssuerData" type="{}SaleToIssuerData" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="OperatorID" type="{}OperatorID" /&gt;
 *       &lt;attribute name="OperatorLanguage" type="{}ISOLanguage2A" /&gt;
 *       &lt;attribute name="ShiftNumber" type="{}ShiftNumber" /&gt;
 *       &lt;attribute name="SaleReferenceID" type="{}SaleReferenceID" /&gt;
 *       &lt;attribute name="TokenRequested" type="{}TokenRequestedType" /&gt;
 *       &lt;attribute name="CustomerOrderID" type="{}CustomerOrderID" /&gt;
 *       &lt;attribute name="CustomerOrderReq" type="{}CustomerOrderReq" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaleData", propOrder = {
        "saleTransactionID",
        "saleTerminalData",
        "sponsoredMerchant",
        "saleToPOIData",
        "saleToAcquirerData",
        "saleToIssuerData"
})
public class SaleData {

    /**
     * The Sale transaction id.
     */
    @XmlElement(name = "SaleTransactionID", required = true)
    @Schema(description = "Unique identification of a Sale transaction")
    protected TransactionIdentification saleTransactionID;
    /**
     * The Sale terminal data.
     */
    @XmlElement(name = "SaleTerminalData")
    @Schema(description = "Information related to the software and hardware feature of the Sale Terminal. --Rule: If content is not empty")
    protected SaleTerminalData saleTerminalData;
    /**
     * The Sponsored merchant.
     */
    @XmlElement(name = "SponsoredMerchant")
    @Schema(description = "Merchant using the payment services of a payment facilitator, acting as a card acceptor. --Rule: If the merchant is a payment facilitator providing services to sponsored merchants.")
    protected List<SponsoredMerchant> sponsoredMerchant;
    /**
     * The Sale to poi data.
     */
    @XmlElement(name = "SaleToPOIData")
    @Schema(description = "Sale information intended for the POI. --Rule: Stored with the transaction")
    protected String saleToPOIData;
    /**
     * The Sale to acquirer data.
     */
    @XmlElement(name = "SaleToAcquirerData")
    @Schema(description = "Sale information intended for the Acquirer. --Rule: Send to the Acquirer if present")
    @JsonAdapter(SaleToAcquirerDataSerializer.class)
    protected SaleToAcquirerData saleToAcquirerData;
    /**
     * The Sale to issuer data.
     */
    @XmlElement(name = "SaleToIssuerData")
    @Schema(description = "Sale information intended for the Issuer. --Rule: Send to the Acquirer if present")
    protected SaleToIssuerData saleToIssuerData;
    /**
     * The Operator id.
     */
    @XmlElement(name = "OperatorID")
    @Schema(description = "Identification of the Cashier or Operator. --Rule: if different from the Login and  see Login .SaleData")
    protected String operatorID;
    /**
     * The Operator language.
     */
    @XmlElement(name = "OperatorLanguage")
    @Schema(description = "Language of the Cashier or Operator. --Rule: if different from the Login")
    protected String operatorLanguage;
    /**
     * The Shift number.
     */
    @XmlElement(name = "ShiftNumber")
    @Schema(description = "Shift number. --Rule: if different from the Login and  see Login .SaleData")
    protected String shiftNumber;
    /**
     * The Sale reference id.
     */
    @XmlElement(name = "SaleReferenceID")
    @Schema(description = "Identification of a Sale global transaction for a sequence of related POI transactions --Rule: If payment reservation")
    protected String saleReferenceID;
    /**
     * The Token requested.
     */
    @XmlElement(name = "TokenRequestedType")
    @Schema(description = "Type of token replacing the PAN of a payment card to identify the payment mean of the customer. --Rule: In a Payment or CardAcquisition request, if a token is requested.")
    protected TokenRequestedType tokenRequestedType;
    /**
     * The Customer order id.
     */
    @XmlElement(name = "CustomerOrderID")
    @Schema(description = "Identification of a customer order. --Rule: If the payment is related to an open customer order.")
    protected String customerOrderID;
    /**
     * The Customer order req.
     */
    @XmlElement(name = "CustomerOrderReq")
    @Schema(description = "List of customer orders must be sent in response message. --Rule: If customer orders must be listed in the response message.")
    protected List<CustomerOrderReqType> customerOrderReq;

    public SaleData() {
        saleToAcquirerData = new SaleToAcquirerData();
    }

    /**
     * Gets the value of the saleTransactionID property.
     *
     * @return possible      object is     {@link TransactionIdentification }
     */
    public TransactionIdentification getSaleTransactionID() {
        return saleTransactionID;
    }

    /**
     * Sets the value of the saleTransactionID property.
     *
     * @param value allowed object is     {@link TransactionIdentification }
     */
    public void setSaleTransactionID(TransactionIdentification value) {
        saleTransactionID = value;
    }

    /**
     * Gets the value of the saleTerminalData property.
     *
     * @return possible      object is     {@link SaleTerminalData }
     */
    public SaleTerminalData getSaleTerminalData() {
        return saleTerminalData;
    }

    /**
     * Sets the value of the saleTerminalData property.
     *
     * @param value allowed object is     {@link SaleTerminalData }
     */
    public void setSaleTerminalData(SaleTerminalData value) {
        saleTerminalData = value;
    }

    /**
     * Gets the value of the sponsoredMerchant property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sponsoredMerchant property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSponsoredMerchant().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SponsoredMerchant }
     *
     * @return the sponsored merchant
     */
    public List<SponsoredMerchant> getSponsoredMerchant() {
        if (sponsoredMerchant == null) {
            sponsoredMerchant = new ArrayList<>();
        }
        return sponsoredMerchant;
    }

    /**
     * Gets the value of the saleToPOIData property.
     *
     * @return possible      object is     {@link String }
     */
    public String getSaleToPOIData() {
        return saleToPOIData;
    }

    /**
     * Sets the value of the saleToPOIData property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setSaleToPOIData(String value) {
        saleToPOIData = value;
    }

    /**
     * Gets the value of the saleToAcquirerData property.
     *
     * @return possible      object is     {@link String }
     */
    public SaleToAcquirerData getSaleToAcquirerData() {
        return saleToAcquirerData;
    }

    /**
     * Sets the value of the saleToAcquirerData property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setSaleToAcquirerData(SaleToAcquirerData value) {
        saleToAcquirerData = value;
    }

    /**
     * Gets the value of the saleToIssuerData property.
     *
     * @return possible      object is     {@link SaleToIssuerData }
     */
    public SaleToIssuerData getSaleToIssuerData() {
        return saleToIssuerData;
    }

    /**
     * Sets the value of the saleToIssuerData property.
     *
     * @param value allowed object is     {@link SaleToIssuerData }
     */
    public void setSaleToIssuerData(SaleToIssuerData value) {
        saleToIssuerData = value;
    }

    /**
     * Gets the value of the operatorID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getOperatorID() {
        return operatorID;
    }

    /**
     * Sets the value of the operatorID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setOperatorID(String value) {
        operatorID = value;
    }

    /**
     * Gets the value of the operatorLanguage property.
     *
     * @return possible      object is     {@link String }
     */
    public String getOperatorLanguage() {
        return operatorLanguage;
    }

    /**
     * Sets the value of the operatorLanguage property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setOperatorLanguage(String value) {
        operatorLanguage = value;
    }

    /**
     * Gets the value of the shiftNumber property.
     *
     * @return possible      object is     {@link String }
     */
    public String getShiftNumber() {
        return shiftNumber;
    }

    /**
     * Sets the value of the shiftNumber property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setShiftNumber(String value) {
        shiftNumber = value;
    }

    /**
     * Gets the value of the saleReferenceID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getSaleReferenceID() {
        return saleReferenceID;
    }

    /**
     * Sets the value of the saleReferenceID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setSaleReferenceID(String value) {
        saleReferenceID = value;
    }

    /**
     * Gets the value of the tokenRequestedType property.
     *
     * @return possible      object is     {@link TokenRequestedType }
     */
    public TokenRequestedType getTokenRequestedType() {
        return tokenRequestedType;
    }

    /**
     * Sets the value of the tokenRequestedType property.
     *
     * @param value allowed object is     {@link TokenRequestedType }
     */
    public void setTokenRequestedType(TokenRequestedType value) {
        tokenRequestedType = value;
    }

    /**
     * Gets the value of the customerOrderID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getCustomerOrderID() {
        return customerOrderID;
    }

    /**
     * Sets the value of the customerOrderID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setCustomerOrderID(String value) {
        customerOrderID = value;
    }

    /**
     * Gets the value of the customerOrderReq property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customerOrderReq property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomerOrderReq().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomerOrderReqType }
     *
     * @return the customer order req
     */
    public List<CustomerOrderReqType> getCustomerOrderReq() {
        if (customerOrderReq == null) {
            customerOrderReq = new ArrayList<>();
        }
        return customerOrderReq;
    }

}
