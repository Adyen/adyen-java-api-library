package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Content of the Login Request messageType. -- Usage: It conveys Information related to the session (period between a Login and the following Logout) to process
 *
 * <p>Java class for LoginRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LoginRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DateTime" type="{}DateTime"/&gt;
 *         &lt;element name="SaleSoftware" type="{}SaleSoftware"/&gt;
 *         &lt;element name="SaleTerminalData" type="{}SaleTerminalData" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="TrainingModeFlag" type="{}TrainingModeFlag" default="false" /&gt;
 *       &lt;attribute name="OperatorLanguage" use="required" type="{}ISOLanguage2A" /&gt;
 *       &lt;attribute name="OperatorID" type="{}OperatorID" /&gt;
 *       &lt;attribute name="ShiftNumber" type="{}ShiftNumber" /&gt;
 *       &lt;attribute name="TokenRequested" type="{}TokenRequestedType" /&gt;
 *       &lt;attribute name="CustomerOrderReq" type="{}CustomerOrderReq" /&gt;
 *       &lt;attribute name="POISerialNumber" type="{}POISerialNumber" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoginRequest", propOrder = {
        "dateTime",
        "saleSoftware",
        "saleTerminalData"
})
public class LoginRequest {

    /**
     * The Date time.
     */
    @XmlElement(name = "DateTime", required = true)
    @Schema(description = "Date and Time")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTime;
    /**
     * The Sale software.
     */
    @XmlElement(name = "SaleSoftware", required = true)
    @Schema(description = "Information related to the software of the Sale System which manages the Sale to POI protocol.")
    protected SaleSoftware saleSoftware;
    /**
     * The Sale terminal data.
     */
    @XmlElement(name = "SaleTerminalData")
    @Schema(description = "Information related to the software and hardware feature of the Sale Terminal. --Rule: Present if the login involve a Sale Terminal")
    protected SaleTerminalData saleTerminalData;
    /**
     * The Training mode flag.
     */
    @XmlElement(name = "TrainingModeFlag")
    @Schema(description = "Training mode --Rule: The POI does not realise the transaction with the Acquirer")
    protected Boolean trainingModeFlag;
    /**
     * The Operator language.
     */
    @XmlElement(name = "OperatorLanguage", required = true)
    @Schema(description = "Language of the Cashier or Operator. --Rule: Default value for Device type displays")
    protected String operatorLanguage;
    /**
     * The Operator id.
     */
    @XmlElement(name = "OperatorID")
    @Schema(description = "Identification of the Cashier or Operator. --Rule: 4 conditions to send it: a) the Sale System wants the POI log it in the transaction log b) because of reconciliation")
    protected String operatorID;
    /**
     * The Shift number.
     */
    @XmlElement(name = "ShiftNumber")
    @Schema(description = "Shift number. --Rule: Same as OperatorID")
    protected String shiftNumber;
    /**
     * The Token requested.
     */
    @XmlElement(name = "TokenRequestedType")
    @Schema(description = "Type of token replacing the PAN of a payment card to identify the payment mean of the customer. --Rule: If a token is requested during the the session.")
    protected TokenRequestedType tokenRequestedType;
    /**
     * The Customer order req.
     */
    @XmlElement(name = "CustomerOrderReq")
    @Schema(description = "List of customer orders must be sent in response message. --Rule: If customer orders must be listed in Card Acquisition and Payment response messages during the session.")
    protected List<CustomerOrderReqType> customerOrderReq;
    /**
     * The Poi serial number.
     */
    @XmlElement(name = "POISerialNumber")
    @Schema(description = "Serial number of a POI Terminal --Rule: If the login involve a POI Terminal and not the first Login to the POI System")
    protected String poiSerialNumber;

    /**
     * Gets the value of the dateTime property.
     *
     * @return possible      object is     {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     *
     * @param value allowed object is     {@link XMLGregorianCalendar }
     */
    public void setDateTime(XMLGregorianCalendar value) {
        this.dateTime = value;
    }

    /**
     * Gets the value of the saleSoftware property.
     *
     * @return possible      object is     {@link SaleSoftware }
     */
    public SaleSoftware getSaleSoftware() {
        return saleSoftware;
    }

    /**
     * Sets the value of the saleSoftware property.
     *
     * @param value allowed object is     {@link SaleSoftware }
     */
    public void setSaleSoftware(SaleSoftware value) {
        this.saleSoftware = value;
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
        this.saleTerminalData = value;
    }

    /**
     * Gets the value of the trainingModeFlag property.
     *
     * @return possible      object is     {@link Boolean }
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
     * @param value allowed object is     {@link Boolean }
     */
    public void setTrainingModeFlag(Boolean value) {
        this.trainingModeFlag = value;
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
        this.operatorLanguage = value;
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
        this.operatorID = value;
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
        this.shiftNumber = value;
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
        this.tokenRequestedType = value;
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
        return this.customerOrderReq;
    }

    /**
     * Gets the value of the poiSerialNumber property.
     *
     * @return possible      object is     {@link String }
     */
    public String getPOISerialNumber() {
        return poiSerialNumber;
    }

    /**
     * Sets the value of the poiSerialNumber property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setPOISerialNumber(String value) {
        this.poiSerialNumber = value;
    }

}
