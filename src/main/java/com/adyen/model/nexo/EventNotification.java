
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Definition: Content of the EventNotification messageType. -- Usage: It conveys Information related to the event, and possible action (maintenance, messageType to display).
 *
 * <p>Java class for EventNotification complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="EventNotification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EventDetails" type="{}EventDetails" minOccurs="0"/>
 *         &lt;element name="RejectedMessage" type="{}RejectedMessage" minOccurs="0"/>
 *         &lt;element name="DisplayOutput" type="{}DisplayOutput" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="TimeStamp" use="required" type="{}TimeStamp" />
 *       &lt;attribute name="EventToNotify" use="required" type="{}EventToNotifyType" />
 *       &lt;attribute name="MaintenanceRequiredFlag" type="{}MaintenanceRequiredFlag" default="false" />
 *       &lt;attribute name="CustomerLanguage" type="{}ISOLanguage2A" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventNotification", propOrder = {
    "eventDetails",
    "rejectedMessage",
    "displayOutput"
})
public class EventNotification {

    @XmlElement(name = "EventDetails")
    protected String eventDetails;
    @XmlElement(name = "RejectedMessage")
    protected byte[] rejectedMessage;
    @XmlElement(name = "DisplayOutput")
    protected DisplayOutput displayOutput;
    @XmlAttribute(name = "TimeStamp", required = true)
    protected XMLGregorianCalendar timeStamp;
    @XmlAttribute(name = "EventToNotify", required = true)
    protected EventToNotifyType eventToNotify;
    @XmlAttribute(name = "MaintenanceRequiredFlag")
    protected Boolean maintenanceRequiredFlag;
    @XmlAttribute(name = "CustomerLanguage")
    protected String customerLanguage;

    /**
     * Gets the value of the eventDetails property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEventDetails() {
        return eventDetails;
    }

    /**
     * Sets the value of the eventDetails property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEventDetails(String value) {
        this.eventDetails = value;
    }

    /**
     * Gets the value of the rejectedMessage property.
     *
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getRejectedMessage() {
        return rejectedMessage;
    }

    /**
     * Sets the value of the rejectedMessage property.
     *
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setRejectedMessage(byte[] value) {
        this.rejectedMessage = value;
    }

    /**
     * Gets the value of the displayOutput property.
     *
     * @return
     *     possible object is
     *     {@link DisplayOutput }
     *
     */
    public DisplayOutput getDisplayOutput() {
        return displayOutput;
    }

    /**
     * Sets the value of the displayOutput property.
     *
     * @param value
     *     allowed object is
     *     {@link DisplayOutput }
     *
     */
    public void setDisplayOutput(DisplayOutput value) {
        this.displayOutput = value;
    }

    /**
     * Gets the value of the timeStamp property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the value of the timeStamp property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setTimeStamp(XMLGregorianCalendar value) {
        this.timeStamp = value;
    }

    /**
     * Gets the value of the eventToNotify property.
     *
     * @return
     *     possible object is
     *     {@link EventToNotifyType }
     *
     */
    public EventToNotifyType getEventToNotify() {
        return eventToNotify;
    }

    /**
     * Sets the value of the eventToNotify property.
     *
     * @param value
     *     allowed object is
     *     {@link EventToNotifyType }
     *
     */
    public void setEventToNotify(EventToNotifyType value) {
        this.eventToNotify = value;
    }

    /**
     * Gets the value of the maintenanceRequiredFlag property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public boolean isMaintenanceRequiredFlag() {
        if (maintenanceRequiredFlag == null) {
            return false;
        } else {
            return maintenanceRequiredFlag;
        }
    }

    /**
     * Sets the value of the maintenanceRequiredFlag property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setMaintenanceRequiredFlag(Boolean value) {
        this.maintenanceRequiredFlag = value;
    }

    /**
     * Gets the value of the customerLanguage property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCustomerLanguage() {
        return customerLanguage;
    }

    /**
     * Sets the value of the customerLanguage property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCustomerLanguage(String value) {
        this.customerLanguage = value;
    }

}
