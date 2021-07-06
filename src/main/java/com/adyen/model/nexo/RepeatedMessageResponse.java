package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Definition: Content of the requested Message Response. -- Usage: Allow the knowledge of the last Payment, Loyalty or Reversal transaction
 *
 * <p>Java class for RepeatedMessageResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="RepeatedMessageResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MessageHeader" type="{}MessageHeader"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="LoyaltyResponse" type="{}LoyaltyResponse"/&gt;
 *           &lt;element name="PaymentResponse" type="{}PaymentResponse"/&gt;
 *           &lt;element name="ReversalResponse" type="{}ReversalResponse"/&gt;
 *           &lt;element name="StoredValueResponse" type="{}StoredValueResponse"/&gt;
 *           &lt;element name="CardAcquisitionResponse" type="{}CardAcquisitionResponse"/&gt;
 *           &lt;element name="CardReaderAPDUResponse" type="{}CardReaderAPDUResponse"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RepeatedMessageResponse", propOrder = {
        "repeatedResponseMessageBody",
        "messageHeader"
})
public class RepeatedMessageResponse {

    /**
     * The Repeated message response body.
     */
    @XmlElement(name = "RepeatedResponseMessageBody", required = true)
    protected RepeatedResponseMessageBody repeatedResponseMessageBody;
    /**
     * The Message header.
     */
    @XmlElement(name = "MessageHeader", required = true)
    @Schema(description = "Message header of the Sale to POI protocol message.")
    protected MessageHeader messageHeader;

    /**
     * Gets the value of the repeatedResponseMessageBody property.
     *
     * @return possible      object is     {@link RepeatedResponseMessageBody }
     */
    public RepeatedResponseMessageBody getRepeatedResponseMessageBody() {
        return repeatedResponseMessageBody;
    }

    /**
     * Sets the value of the repeatedResponseMessageBody property.
     *
     * @param value allowed object is     {@link RepeatedResponseMessageBody }
     */
    public void setRepeatedResponseMessageBody(RepeatedResponseMessageBody value) {
        this.repeatedResponseMessageBody = value;
    }

    /**
     * Gets the value of the messageHeader property.
     *
     * @return possible      object is     {@link MessageHeader }
     */
    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    /**
     * Sets the value of the messageHeader property.
     *
     * @param value allowed object is     {@link MessageHeader }
     */
    public void setMessageHeader(MessageHeader value) {
        this.messageHeader = value;
    }
}
