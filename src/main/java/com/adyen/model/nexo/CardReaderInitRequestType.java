
package com.adyen.model.nexo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Card Reader Init Request message. -- Usage: It contains possible restrictions for the type of card reader to use, and a possible invitation message to display on the CashierInterface or the CustomerInterface.
 * 
 * <p>Java class for CardReaderInitRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardReaderInitRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ForceEntryMode" type="{}ForceEntryModeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DisplayOutput" type="{}DisplayOutputType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="WarmResetFlag" type="{}WarmResetFlagType" />
 *       &lt;attribute name="LeaveCardFlag" type="{}LeaveCardFlagType" default="true" />
 *       &lt;attribute name="MaxWaitingTime" type="{}MaxWaitingTimeType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardReaderInitRequestType", propOrder = {
    "forceEntryMode",
    "displayOutput"
})
public class CardReaderInitRequestType {

    @XmlElementRef(name = "ForceEntryMode", type = JAXBElement.class, required = false)
    protected List<JAXBElement<List<String>>> forceEntryMode;
    @XmlElement(name = "DisplayOutput")
    protected DisplayOutputType displayOutput;
    @XmlAttribute(name = "WarmResetFlag")
    protected Boolean warmResetFlag;
    @XmlAttribute(name = "LeaveCardFlag")
    protected Boolean leaveCardFlag;
    @XmlAttribute(name = "MaxWaitingTime")
    protected BigInteger maxWaitingTime;

    /**
     * Gets the value of the forceEntryMode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the forceEntryMode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getForceEntryMode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     * 
     * 
     */
    public List<JAXBElement<List<String>>> getForceEntryMode() {
        if (forceEntryMode == null) {
            forceEntryMode = new ArrayList<JAXBElement<List<String>>>();
        }
        return this.forceEntryMode;
    }

    /**
     * Gets the value of the displayOutput property.
     * 
     * @return
     *     possible object is
     *     {@link DisplayOutputType }
     *     
     */
    public DisplayOutputType getDisplayOutput() {
        return displayOutput;
    }

    /**
     * Sets the value of the displayOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayOutputType }
     *     
     */
    public void setDisplayOutput(DisplayOutputType value) {
        this.displayOutput = value;
    }

    /**
     * Gets the value of the warmResetFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWarmResetFlag() {
        return warmResetFlag;
    }

    /**
     * Sets the value of the warmResetFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWarmResetFlag(Boolean value) {
        this.warmResetFlag = value;
    }

    /**
     * Gets the value of the leaveCardFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isLeaveCardFlag() {
        if (leaveCardFlag == null) {
            return true;
        } else {
            return leaveCardFlag;
        }
    }

    /**
     * Sets the value of the leaveCardFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLeaveCardFlag(Boolean value) {
        this.leaveCardFlag = value;
    }

    /**
     * Gets the value of the maxWaitingTime property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxWaitingTime() {
        return maxWaitingTime;
    }

    /**
     * Sets the value of the maxWaitingTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxWaitingTime(BigInteger value) {
        this.maxWaitingTime = value;
    }

}
