
package com.adyen.model.nexo;

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
 * &lt;complexType name="RepeatedMessageResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageHeader" type="{}MessageHeader"/>
 *         &lt;choice>
 *           &lt;element name="LoyaltyResponse" type="{}LoyaltyResponse"/>
 *           &lt;element name="PaymentResponse" type="{}PaymentResponse"/>
 *           &lt;element name="ReversalResponse" type="{}ReversalResponse"/>
 *           &lt;element name="StoredValueResponse" type="{}StoredValueResponse"/>
 *           &lt;element name="CardAcquisitionResponse" type="{}CardAcquisitionResponse"/>
 *           &lt;element name="CardReaderAPDUResponse" type="{}CardReaderAPDUResponse"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RepeatedMessageResponse", propOrder = {
    "repeatedMessageResponseBody",
    "messageHeader"
})
public class RepeatedMessageResponse {

    @XmlElement(name = "RepeatedMessageResponseBody", required = true)
    protected RepeatedMessageResponseBody repeatedMessageResponseBody;
    @XmlElement(name = "MessageHeader", required = true)
    protected MessageHeader messageHeader;

    /**
     * Gets the value of the repeatedMessageResponseBody property.
     *
     * @return
     *     possible object is
     *     {@link RepeatedMessageResponseBody }
     *
     */
    public RepeatedMessageResponseBody getRepeatedMessageResponseBody() {
        return repeatedMessageResponseBody;
    }

    /**
     * Sets the value of the repeatedMessageResponseBody property.
     *
     * @param value
     *     allowed object is
     *     {@link RepeatedMessageResponseBody }
     *
     */
    public void setRepeatedMessageResponseBody(RepeatedMessageResponseBody value) {
        this.repeatedMessageResponseBody = value;
    }

    /**
     * Gets the value of the messageHeader property.
     *
     * @return
     *     possible object is
     *     {@link MessageHeader }
     *
     */
    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    /**
     * Sets the value of the messageHeader property.
     *
     * @param value
     *     allowed object is
     *     {@link MessageHeader }
     *
     */
    public void setMessageHeader(MessageHeader value) {
        this.messageHeader = value;
    }
}
