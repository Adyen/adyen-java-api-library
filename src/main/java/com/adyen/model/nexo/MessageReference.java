package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Identification of a previous POI transaction. -- Usage: To abort a transaction in progress or to request the status of a transaction from which no response has been received.  It identifies the messageType header of the messageType request to abort or request the status. The Abort or TransactionStatus
 *
 * <p>Java class for MessageReference complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="MessageReference"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="MessageCategory" type="{}MessageCategoryType" /&gt;
 *       &lt;attribute name="ServiceID" type="{}ServiceID" /&gt;
 *       &lt;attribute name="DeviceID" type="{}DeviceID" /&gt;
 *       &lt;attribute name="SaleID" type="{}SaleID" /&gt;
 *       &lt;attribute name="POIID" type="{}POIID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageReference")
public class MessageReference {

    /**
     * The Message category.
     */
    @XmlElement(name = "MessageCategory")
    @Schema(description = "Category of message. --Rule: Payment, Loyalty, StoredValue, CardAcquisition, Batch, Reconciliation, Display, Input, Print, CardReaderAPDU,")
    protected MessageCategoryType messageCategory;
    /**
     * The Service id.
     */
    @XmlElement(name = "ServiceID")
    @Schema(description = "Identification of a message pair, which processes a transaction")
    protected String serviceID;
    /**
     * The Device id.
     */
    @XmlElement(name = "DeviceID")
    @Schema(description = "Identification of a device message pair", minLength = 1, maxLength = 10)
    protected String deviceID;
    /**
     * The Sale id.
     */
    @XmlElement(name = "SaleID")
    @Schema(description = "Identification of a Sale System or a Sale Terminal for the Sale to POI protocol --Rule: default MessageHeader.SaleID")
    protected String saleID;
    /**
     * The Poiid.
     */
    @XmlElement(name = "POIID")
    @Schema(description = "Identification of a POI System or a POI Terminal for the Sale to POI protocol --Rule: default MessageHeader.POIID")
    protected String poiid;

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
