package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Content of the Card Reader Init Request messageType. -- Usage: It contains possible restrictions for the type of card reader to use, and a possible invitation messageType to display on the CashierInterface or the CustomerInterface.
 *
 * <p>Java class for CardReaderInitRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CardReaderInitRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ForceEntryMode" type="{}ForceEntryMode" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="DisplayOutput" type="{}DisplayOutput" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="WarmResetFlag" type="{}WarmResetFlag" /&gt;
 *       &lt;attribute name="LeaveCardFlag" type="{}LeaveCardFlag" default="true" /&gt;
 *       &lt;attribute name="MaxWaitingTime" type="{}MaxWaitingTime" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardReaderInitRequest", propOrder = {
        "forceEntryMode",
        "displayOutput"
})
public class CardReaderInitRequest {

    /**
     * The Force entry mode.
     */
    @XmlElement(name = "ForceEntryMode")
    protected List<ForceEntryModeType> forceEntryMode;
    /**
     * The Display output.
     */
    @XmlElement(name = "DisplayOutput")
    protected DisplayOutput displayOutput;
    /**
     * The Warm reset flag.
     */
    @XmlAttribute(name = "WarmResetFlag")
    protected Boolean warmResetFlag;
    /**
     * The Leave card flag.
     */
    @XmlAttribute(name = "LeaveCardFlag")
    protected Boolean leaveCardFlag;
    /**
     * The Max waiting time.
     */
    @XmlAttribute(name = "MaxWaitingTime")
    protected BigInteger maxWaitingTime;

    /**
     * Gets the value of the forceEntryMode property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the forceEntryMode property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getForceEntryMode().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link ForceEntryModeType }
     *
     * @return the force entry mode
     */
    public List<ForceEntryModeType> getForceEntryMode() {
        if (forceEntryMode == null) {
            forceEntryMode = new ArrayList<>();
        }
        return this.forceEntryMode;
    }

    /**
     * Gets the value of the displayOutput property.
     *
     * @return possible      object is     {@link DisplayOutput }
     */
    public DisplayOutput getDisplayOutput() {
        return displayOutput;
    }

    /**
     * Sets the value of the displayOutput property.
     *
     * @param value allowed object is     {@link DisplayOutput }
     */
    public void setDisplayOutput(DisplayOutput value) {
        this.displayOutput = value;
    }

    /**
     * Gets the value of the warmResetFlag property.
     *
     * @return possible      object is     {@link Boolean }
     */
    public Boolean isWarmResetFlag() {
        return warmResetFlag;
    }

    /**
     * Sets the value of the warmResetFlag property.
     *
     * @param value allowed object is     {@link Boolean }
     */
    public void setWarmResetFlag(Boolean value) {
        this.warmResetFlag = value;
    }

    /**
     * Gets the value of the leaveCardFlag property.
     *
     * @return possible      object is     {@link Boolean }
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
     * @param value allowed object is     {@link Boolean }
     */
    public void setLeaveCardFlag(Boolean value) {
        this.leaveCardFlag = value;
    }

    /**
     * Gets the value of the maxWaitingTime property.
     *
     * @return possible      object is     {@link BigInteger }
     */
    public BigInteger getMaxWaitingTime() {
        return maxWaitingTime;
    }

    /**
     * Sets the value of the maxWaitingTime property.
     *
     * @param value allowed object is     {@link BigInteger }
     */
    public void setMaxWaitingTime(BigInteger value) {
        this.maxWaitingTime = value;
    }

}
