
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the TransactionStatus Response message. -- Usage: It conveys Information related to the status of the last or current Payment, Loyalty or Reversal transaction.
 * 
 * <p>Java class for TransactionStatusResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionStatusResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}ResponseType"/>
 *         &lt;element name="MessageReference" type="{}MessageReferenceType" minOccurs="0"/>
 *         &lt;element name="RepeatedMessageResponse" type="{}RepeatedMessageResponseType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionStatusResponseType", propOrder = {
    "response",
    "messageReference",
    "repeatedMessageResponse"
})
public class TransactionStatusResponseType {

    @XmlElement(name = "Response", required = true)
    protected ResponseType response;
    @XmlElement(name = "MessageReference")
    protected MessageReferenceType messageReference;
    @XmlElement(name = "RepeatedMessageResponse")
    protected RepeatedMessageResponseType repeatedMessageResponse;

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseType }
     *     
     */
    public ResponseType getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseType }
     *     
     */
    public void setResponse(ResponseType value) {
        this.response = value;
    }

    /**
     * Gets the value of the messageReference property.
     * 
     * @return
     *     possible object is
     *     {@link MessageReferenceType }
     *     
     */
    public MessageReferenceType getMessageReference() {
        return messageReference;
    }

    /**
     * Sets the value of the messageReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageReferenceType }
     *     
     */
    public void setMessageReference(MessageReferenceType value) {
        this.messageReference = value;
    }

    /**
     * Gets the value of the repeatedMessageResponse property.
     * 
     * @return
     *     possible object is
     *     {@link RepeatedMessageResponseType }
     *     
     */
    public RepeatedMessageResponseType getRepeatedMessageResponse() {
        return repeatedMessageResponse;
    }

    /**
     * Sets the value of the repeatedMessageResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link RepeatedMessageResponseType }
     *     
     */
    public void setRepeatedMessageResponse(RepeatedMessageResponseType value) {
        this.repeatedMessageResponse = value;
    }

}
