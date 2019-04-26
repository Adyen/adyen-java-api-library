
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to the Sale System. -- Usage: Data associated to the Sale System, with a particular value during the processing of the payment by the POI, including the cards acquisition.
 *
 * <p>Java class for SaleData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SaleData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SaleTransactionID" type="{}TransactionIdentification"/>
 *         &lt;element name="SaleTerminalData" type="{}SaleTerminalData" minOccurs="0"/>
 *         &lt;element name="SponsoredMerchant" type="{}SponsoredMerchant" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SaleToPOIData" type="{}SaleToPOIData" minOccurs="0"/>
 *         &lt;element name="SaleToAcquirerData" type="{}SaleToAcquirerData" minOccurs="0"/>
 *         &lt;element name="SaleToIssuerData" type="{}SaleToIssuerData" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="OperatorID" type="{}OperatorID" />
 *       &lt;attribute name="OperatorLanguage" type="{}ISOLanguage2A" />
 *       &lt;attribute name="ShiftNumber" type="{}ShiftNumber" />
 *       &lt;attribute name="SaleReferenceID" type="{}SaleReferenceID" />
 *       &lt;attribute name="TokenRequested" type="{}TokenRequestedType" />
 *       &lt;attribute name="CustomerOrderID" type="{}CustomerOrderID" />
 *       &lt;attribute name="CustomerOrderReq" type="{}CustomerOrderReq" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
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

    @XmlElement(name = "SaleTransactionID", required = true)
    protected TransactionIdentification saleTransactionID;
    @XmlElement(name = "SaleTerminalData")
    protected SaleTerminalData saleTerminalData;
    @XmlElement(name = "SponsoredMerchant")
    protected List<SponsoredMerchant> sponsoredMerchant;
    @XmlElement(name = "SaleToPOIData")
    protected String saleToPOIData;
    @XmlElement(name = "SaleToAcquirerData")
    protected String saleToAcquirerData;
    @XmlElement(name = "SaleToIssuerData")
    protected SaleToIssuerData saleToIssuerData;
    @XmlAttribute(name = "OperatorID")
    protected String operatorID;
    @XmlAttribute(name = "OperatorLanguage")
    protected String operatorLanguage;
    @XmlAttribute(name = "ShiftNumber")
    protected String shiftNumber;
    @XmlAttribute(name = "SaleReferenceID")
    protected String saleReferenceID;
    @XmlAttribute(name = "TokenRequested")
    protected TokenRequestedType tokenRequested;
    @XmlAttribute(name = "CustomerOrderID")
    protected String customerOrderID;
    @XmlAttribute(name = "CustomerOrderReq")
    protected List<CustomerOrderReqType> customerOrderReq;

    /**
     * Gets the value of the saleTransactionID property.
     *
     * @return
     *     possible object is
     *     {@link TransactionIdentification }
     *
     */
    public TransactionIdentification getSaleTransactionID() {
        return saleTransactionID;
    }

    /**
     * Sets the value of the saleTransactionID property.
     *
     * @param value
     *     allowed object is
     *     {@link TransactionIdentification }
     *
     */
    public void setSaleTransactionID(TransactionIdentification value) {
        this.saleTransactionID = value;
    }

    /**
     * Gets the value of the saleTerminalData property.
     *
     * @return
     *     possible object is
     *     {@link SaleTerminalData }
     *
     */
    public SaleTerminalData getSaleTerminalData() {
        return saleTerminalData;
    }

    /**
     * Sets the value of the saleTerminalData property.
     *
     * @param value
     *     allowed object is
     *     {@link SaleTerminalData }
     *
     */
    public void setSaleTerminalData(SaleTerminalData value) {
        this.saleTerminalData = value;
    }

    /**
     * Gets the value of the sponsoredMerchant property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sponsoredMerchant property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSponsoredMerchant().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SponsoredMerchant }
     *
     *
     */
    public List<SponsoredMerchant> getSponsoredMerchant() {
        if (sponsoredMerchant == null) {
            sponsoredMerchant = new ArrayList<SponsoredMerchant>();
        }
        return this.sponsoredMerchant;
    }

    /**
     * Gets the value of the saleToPOIData property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSaleToPOIData() {
        return saleToPOIData;
    }

    /**
     * Sets the value of the saleToPOIData property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSaleToPOIData(String value) {
        this.saleToPOIData = value;
    }

    /**
     * Gets the value of the saleToAcquirerData property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSaleToAcquirerData() {
        return saleToAcquirerData;
    }

    /**
     * Sets the value of the saleToAcquirerData property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSaleToAcquirerData(String value) {
        this.saleToAcquirerData = value;
    }

    /**
     * Gets the value of the saleToIssuerData property.
     *
     * @return
     *     possible object is
     *     {@link SaleToIssuerData }
     *
     */
    public SaleToIssuerData getSaleToIssuerData() {
        return saleToIssuerData;
    }

    /**
     * Sets the value of the saleToIssuerData property.
     *
     * @param value
     *     allowed object is
     *     {@link SaleToIssuerData }
     *
     */
    public void setSaleToIssuerData(SaleToIssuerData value) {
        this.saleToIssuerData = value;
    }

    /**
     * Gets the value of the operatorID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOperatorID() {
        return operatorID;
    }

    /**
     * Sets the value of the operatorID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOperatorID(String value) {
        this.operatorID = value;
    }

    /**
     * Gets the value of the operatorLanguage property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOperatorLanguage() {
        return operatorLanguage;
    }

    /**
     * Sets the value of the operatorLanguage property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOperatorLanguage(String value) {
        this.operatorLanguage = value;
    }

    /**
     * Gets the value of the shiftNumber property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getShiftNumber() {
        return shiftNumber;
    }

    /**
     * Sets the value of the shiftNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setShiftNumber(String value) {
        this.shiftNumber = value;
    }

    /**
     * Gets the value of the saleReferenceID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSaleReferenceID() {
        return saleReferenceID;
    }

    /**
     * Sets the value of the saleReferenceID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSaleReferenceID(String value) {
        this.saleReferenceID = value;
    }

    /**
     * Gets the value of the tokenRequested property.
     *
     * @return
     *     possible object is
     *     {@link TokenRequestedType }
     *
     */
    public TokenRequestedType getTokenRequested() {
        return tokenRequested;
    }

    /**
     * Sets the value of the tokenRequested property.
     *
     * @param value
     *     allowed object is
     *     {@link TokenRequestedType }
     *
     */
    public void setTokenRequested(TokenRequestedType value) {
        this.tokenRequested = value;
    }

    /**
     * Gets the value of the customerOrderID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCustomerOrderID() {
        return customerOrderID;
    }

    /**
     * Sets the value of the customerOrderID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCustomerOrderID(String value) {
        this.customerOrderID = value;
    }

    /**
     * Gets the value of the customerOrderReq property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customerOrderReq property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomerOrderReq().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomerOrderReqType }
     *
     *
     */
    public List<CustomerOrderReqType> getCustomerOrderReq() {
        if (customerOrderReq == null) {
            customerOrderReq = new ArrayList<CustomerOrderReqType>();
        }
        return this.customerOrderReq;
    }

}
