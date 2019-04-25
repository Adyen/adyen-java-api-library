
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Definition: Content of the Login Request message. -- Usage: It conveys Information related to the session (period between a Login and the following Logout) to process
 * 
 * <p>Java class for LoginRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoginRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DateTime" type="{}DateTimeType"/>
 *         &lt;element name="SaleSoftware" type="{}SaleSoftwareType"/>
 *         &lt;element name="SaleTerminalData" type="{}SaleTerminalDataType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="TrainingModeFlag" type="{}TrainingModeFlagType" default="false" />
 *       &lt;attribute name="OperatorLanguage" use="required" type="{}ISOLanguage2A" />
 *       &lt;attribute name="OperatorID" type="{}OperatorIDType" />
 *       &lt;attribute name="ShiftNumber" type="{}ShiftNumberType" />
 *       &lt;attribute name="TokenRequestedType" type="{}TokenRequestedTypeTypeCode" />
 *       &lt;attribute name="CustomerOrderReq" type="{}CustomerOrderReqType" />
 *       &lt;attribute name="POISerialNumber" type="{}POISerialNumberType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoginRequestType", propOrder = {
    "dateTime",
    "saleSoftware",
    "saleTerminalData"
})
public class LoginRequestType {

    @XmlElement(name = "DateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTime;
    @XmlElement(name = "SaleSoftware", required = true)
    protected SaleSoftwareType saleSoftware;
    @XmlElement(name = "SaleTerminalData")
    protected SaleTerminalDataType saleTerminalData;
    @XmlAttribute(name = "TrainingModeFlag")
    protected Boolean trainingModeFlag;
    @XmlAttribute(name = "OperatorLanguage", required = true)
    protected String operatorLanguage;
    @XmlAttribute(name = "OperatorID")
    protected String operatorID;
    @XmlAttribute(name = "ShiftNumber")
    protected String shiftNumber;
    @XmlAttribute(name = "TokenRequestedType")
    protected String tokenRequestedType;
    @XmlAttribute(name = "CustomerOrderReq")
    protected List<String> customerOrderReq;
    @XmlAttribute(name = "POISerialNumber")
    protected String poiSerialNumber;

    /**
     * Gets the value of the dateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateTime(XMLGregorianCalendar value) {
        this.dateTime = value;
    }

    /**
     * Gets the value of the saleSoftware property.
     * 
     * @return
     *     possible object is
     *     {@link SaleSoftwareType }
     *     
     */
    public SaleSoftwareType getSaleSoftware() {
        return saleSoftware;
    }

    /**
     * Sets the value of the saleSoftware property.
     * 
     * @param value
     *     allowed object is
     *     {@link SaleSoftwareType }
     *     
     */
    public void setSaleSoftware(SaleSoftwareType value) {
        this.saleSoftware = value;
    }

    /**
     * Gets the value of the saleTerminalData property.
     * 
     * @return
     *     possible object is
     *     {@link SaleTerminalDataType }
     *     
     */
    public SaleTerminalDataType getSaleTerminalData() {
        return saleTerminalData;
    }

    /**
     * Sets the value of the saleTerminalData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SaleTerminalDataType }
     *     
     */
    public void setSaleTerminalData(SaleTerminalDataType value) {
        this.saleTerminalData = value;
    }

    /**
     * Gets the value of the trainingModeFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isTrainingModeFlag() {
        if (trainingModeFlag == null) {
            return false;
        } else {
            return trainingModeFlag;
        }
    }

    /**
     * Sets the value of the trainingModeFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTrainingModeFlag(Boolean value) {
        this.trainingModeFlag = value;
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
     * Gets the value of the tokenRequestedType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTokenRequestedType() {
        return tokenRequestedType;
    }

    /**
     * Sets the value of the tokenRequestedType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTokenRequestedType(String value) {
        this.tokenRequestedType = value;
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
     * {@link String }
     * 
     * 
     */
    public List<String> getCustomerOrderReq() {
        if (customerOrderReq == null) {
            customerOrderReq = new ArrayList<String>();
        }
        return this.customerOrderReq;
    }

    /**
     * Gets the value of the poiSerialNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOISerialNumber() {
        return poiSerialNumber;
    }

    /**
     * Sets the value of the poiSerialNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOISerialNumber(String value) {
        this.poiSerialNumber = value;
    }

}
