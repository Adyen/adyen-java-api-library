package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Message header of the Sale to POI protocol messageType. -- Usage: It conveys Information related to the Sale to POI protocol management
 *
 * <p>Java class for MessageHeader complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="MessageHeader"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="ProtocolVersion" type="{}ProtocolVersion" /&gt;
 *       &lt;attribute name="MessageClass" use="required" type="{}MessageClassType" /&gt;
 *       &lt;attribute name="MessageCategory" use="required" type="{}MessageCategoryType" /&gt;
 *       &lt;attribute name="Message" use="required" type="{}MessageType" /&gt;
 *       &lt;attribute name="ServiceID" type="{}ServiceID" /&gt;
 *       &lt;attribute name="DeviceID" type="{}DeviceID" /&gt;
 *       &lt;attribute name="SaleID" use="required" type="{}SaleID" /&gt;
 *       &lt;attribute name="POIID" use="required" type="{}POIID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageHeader")
public class MessageHeader {

    /**
     * The Protocol version.
     */
    @XmlElement(name = "ProtocolVersion")
    @Schema(description = ">--Rule:If MessageCategory is Login or Diagnosis")
    protected String protocolVersion;
    /**
     * The Message class.
     */
    @XmlElement(name = "MessageClass", required = true)
    @Schema(description = "Class of the message")
    protected MessageClassType messageClass;
    /**
     * The Message category.
     */
    @XmlElement(name = "MessageCategory", required = true)
    @Schema(description = "Category of message.")
    protected MessageCategoryType messageCategory;
    /**
     * The Message type.
     */
    @XmlElement(name = "MessageType", required = true)
    @Schema(description = "Type of message of the Sale to POI protocol")
    protected MessageType messageType;
    /**
     * The Service id.
     */
    @XmlElement(name = "ServiceID")
    @Schema(description = "Identification of a message pair, which processes a transaction --Rule: If \"Service\" or \"Event\" MessageClass message. If \"Device\" MessageClass, and request from POI or response from Sale.", minLength = 1, maxLength = 10)
    protected String serviceID;
    /**
     * The Device id.
     */
    @XmlElement(name = "DeviceID")
    @Schema(description = "Identification of a device message pair --Rule: If \"Device\" MessageClass")
    protected String deviceID;
    /**
     * The Sale id.
     */
    @XmlElement(name = "SaleID", required = true)
    @Schema(description = "Identification of a Sale System or a Sale Terminal for the Sale to POI protocol")
    protected String saleID;
    /**
     * The Poiid.
     */
    @XmlElement(name = "POIID", required = true)
    @Schema(description = "Identification of a POI System or a POI Terminal for the Sale to POI protocol")
    protected String poiid;

    /**
     * Gets the value of the protocolVersion property.
     *
     * @return possible      object is     {@link String }
     */
    public String getProtocolVersion() {
        return protocolVersion;
    }

    /**
     * Sets the value of the protocolVersion property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setProtocolVersion(String value) {
        this.protocolVersion = value;
    }

    /**
     * Gets the value of the messageClass property.
     *
     * @return possible      object is     {@link MessageClassType }
     */
    public MessageClassType getMessageClass() {
        return messageClass;
    }

    /**
     * Sets the value of the messageClass property.
     *
     * @param value allowed object is     {@link MessageClassType }
     */
    public void setMessageClass(MessageClassType value) {
        this.messageClass = value;
    }

    /**
     * Gets the value of the messageCategory property.
     *
     * @return possible      object is     {@link MessageCategoryType }
     */
    public MessageCategoryType getMessageCategory() {
        return messageCategory;
    }

    /**
     * Sets the value of the messageCategory property.
     *
     * @param value allowed object is     {@link MessageCategoryType }
     */
    public void setMessageCategory(MessageCategoryType value) {
        this.messageCategory = value;
    }

    /**
     * Gets the value of the messageType property.
     *
     * @return possible      object is     {@link MessageType }
     */
    public MessageType getMessageType() {
        return messageType;
    }

    /**
     * Sets the value of the messageType property.
     *
     * @param value allowed object is     {@link MessageType }
     */
    public void setMessageType(MessageType value) {
        this.messageType = value;
    }

    /**
     * Gets the value of the serviceID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getServiceID() {
        return serviceID;
    }

    /**
     * Sets the value of the serviceID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setServiceID(String value) {
        this.serviceID = value;
    }

    /**
     * Gets the value of the deviceID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getDeviceID() {
        return deviceID;
    }

    /**
     * Sets the value of the deviceID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setDeviceID(String value) {
        this.deviceID = value;
    }

    /**
     * Gets the value of the saleID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getSaleID() {
        return saleID;
    }

    /**
     * Sets the value of the saleID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setSaleID(String value) {
        this.saleID = value;
    }

    /**
     * Gets the value of the poiid property.
     *
     * @return possible      object is     {@link String }
     */
    public String getPOIID() {
        return poiid;
    }

    /**
     * Sets the value of the poiid property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setPOIID(String value) {
        this.poiid = value;
    }

}
