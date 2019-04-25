
package com.adyen.model.nexo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Definition: Customer order attached to a card, recorded in the POI system. -- Usage: Allows the management of customer orders by the POI, for instance in a multi-channel or a click and collect sale transaction.
 * 
 * <p>Java class for CustomerOrderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerOrderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AdditionalInformation" type="{}AdditionalInformationType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CustomerOrderID" use="required" type="{}CustomerOrderIDType" />
 *       &lt;attribute name="OpenOrderState" type="{}OpenOrderStateType" default="false" />
 *       &lt;attribute name="StartDate" use="required" type="{}StartDateType" />
 *       &lt;attribute name="EndDate" type="{}EndDateType" />
 *       &lt;attribute name="ForecastedAmount" use="required" type="{}SimpleAmountType" />
 *       &lt;attribute name="CurrentAmount" use="required" type="{}SimpleAmountType" />
 *       &lt;attribute name="Currency" type="{}ISOCurrency3A" />
 *       &lt;attribute name="AccessedBy" type="{}AccessedByType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerOrderType", propOrder = {
    "additionalInformation"
})
public class CustomerOrderType {

    @XmlElement(name = "AdditionalInformation")
    protected String additionalInformation;
    @XmlAttribute(name = "CustomerOrderID", required = true)
    protected String customerOrderID;
    @XmlAttribute(name = "OpenOrderState")
    protected Boolean openOrderState;
    @XmlAttribute(name = "StartDate", required = true)
    protected XMLGregorianCalendar startDate;
    @XmlAttribute(name = "EndDate")
    protected XMLGregorianCalendar endDate;
    @XmlAttribute(name = "ForecastedAmount", required = true)
    protected BigDecimal forecastedAmount;
    @XmlAttribute(name = "CurrentAmount", required = true)
    protected BigDecimal currentAmount;
    @XmlAttribute(name = "Currency")
    protected String currency;
    @XmlAttribute(name = "AccessedBy")
    protected String accessedBy;

    /**
     * Gets the value of the additionalInformation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * Sets the value of the additionalInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalInformation(String value) {
        this.additionalInformation = value;
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
     * Gets the value of the openOrderState property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isOpenOrderState() {
        if (openOrderState == null) {
            return false;
        } else {
            return openOrderState;
        }
    }

    /**
     * Sets the value of the openOrderState property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOpenOrderState(Boolean value) {
        this.openOrderState = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the forecastedAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getForecastedAmount() {
        return forecastedAmount;
    }

    /**
     * Sets the value of the forecastedAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setForecastedAmount(BigDecimal value) {
        this.forecastedAmount = value;
    }

    /**
     * Gets the value of the currentAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    /**
     * Sets the value of the currentAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCurrentAmount(BigDecimal value) {
        this.currentAmount = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the accessedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessedBy() {
        return accessedBy;
    }

    /**
     * Sets the value of the accessedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessedBy(String value) {
        this.accessedBy = value;
    }

}
