
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Message header of the Sale to POI protocol message. -- Usage: It conveys Information related to the Sale to POI protocol management
 * 
 * <p>Java class for MessageHeaderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MessageHeaderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="ProtocolVersion" type="{}ProtocolVersionType" />
 *       &lt;attribute name="MessageClass" use="required" type="{}MessageClassTypeCode" />
 *       &lt;attribute name="MessageCategory" use="required" type="{}MessageCategoryTypeCode" />
 *       &lt;attribute name="MessageType" use="required" type="{}MessageTypeTypeCode" />
 *       &lt;attribute name="ServiceID" type="{}ServiceIDType" />
 *       &lt;attribute name="DeviceID" type="{}DeviceIDType" />
 *       &lt;attribute name="SaleID" use="required" type="{}SaleIDType" />
 *       &lt;attribute name="POIID" use="required" type="{}POIIDType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageHeaderType")
public class MessageHeaderType {

    @XmlAttribute(name = "ProtocolVersion")
    protected String protocolVersion;
    @XmlAttribute(name = "MessageClass", required = true)
    protected String messageClass;
    @XmlAttribute(name = "MessageCategory", required = true)
    protected String messageCategory;
    @XmlAttribute(name = "MessageType", required = true)
    protected String messageType;
    @XmlAttribute(name = "ServiceID")
    protected String serviceID;
    @XmlAttribute(name = "DeviceID")
    protected String deviceID;
    @XmlAttribute(name = "SaleID", required = true)
    protected String saleID;
    @XmlAttribute(name = "POIID", required = true)
    protected String poiid;

    /**
     * Gets the value of the protocolVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtocolVersion() {
        return protocolVersion;
    }

    /**
     * Sets the value of the protocolVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtocolVersion(String value) {
        this.protocolVersion = value;
    }

    /**
     * Gets the value of the messageClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageClass() {
        return messageClass;
    }

    /**
     * Sets the value of the messageClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageClass(String value) {
        this.messageClass = value;
    }

    /**
     * Gets the value of the messageCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageCategory() {
        return messageCategory;
    }

    /**
     * Sets the value of the messageCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageCategory(String value) {
        this.messageCategory = value;
    }

    /**
     * Gets the value of the messageType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageType() {
        return messageType;
    }

    /**
     * Sets the value of the messageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageType(String value) {
        this.messageType = value;
    }

    /**
     * Gets the value of the serviceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceID() {
        return serviceID;
    }

    /**
     * Sets the value of the serviceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceID(String value) {
        this.serviceID = value;
    }

    /**
     * Gets the value of the deviceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceID() {
        return deviceID;
    }

    /**
     * Sets the value of the deviceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceID(String value) {
        this.deviceID = value;
    }

    /**
     * Gets the value of the saleID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaleID() {
        return saleID;
    }

    /**
     * Sets the value of the saleID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaleID(String value) {
        this.saleID = value;
    }

    /**
     * Gets the value of the poiid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOIID() {
        return poiid;
    }

    /**
     * Sets the value of the poiid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOIID(String value) {
        this.poiid = value;
    }

}
