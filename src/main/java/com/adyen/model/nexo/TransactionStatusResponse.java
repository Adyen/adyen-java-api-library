
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the TransactionStatus Response message. -- Usage: It conveys Information related to the status of the last or current Payment, Loyalty or Reversal transaction.
 *
 * <p>Java class for TransactionStatusResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TransactionStatusResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}Response"/>
 *         &lt;element name="MessageReference" type="{}MessageReference" minOccurs="0"/>
 *         &lt;element name="RepeatedMessageResponse" type="{}RepeatedMessageResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionStatusResponse", propOrder = {
    "response",
    "messageReference",
    "repeatedMessageResponse"
})
public class TransactionStatusResponse {

    @XmlElement(name = "Response", required = true)
    protected Response response;
    @XmlElement(name = "MessageReference")
    protected MessageReference messageReference;
    @XmlElement(name = "RepeatedMessageResponse")
    protected RepeatedMessageResponse repeatedMessageResponse;

    /**
     * Gets the value of the response property.
     *
     * @return
     *     possible object is
     *     {@link Response }
     *
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     *
     * @param value
     *     allowed object is
     *     {@link Response }
     *
     */
    public void setResponse(Response value) {
        this.response = value;
    }

    /**
     * Gets the value of the messageReference property.
     *
     * @return
     *     possible object is
     *     {@link MessageReference }
     *
     */
    public MessageReference getMessageReference() {
        return messageReference;
    }

    /**
     * Sets the value of the messageReference property.
     *
     * @param value
     *     allowed object is
     *     {@link MessageReference }
     *
     */
    public void setMessageReference(MessageReference value) {
        this.messageReference = value;
    }

    /**
     * Gets the value of the repeatedMessageResponse property.
     *
     * @return
     *     possible object is
     *     {@link RepeatedMessageResponse }
     *
     */
    public RepeatedMessageResponse getRepeatedMessageResponse() {
        return repeatedMessageResponse;
    }

    /**
     * Sets the value of the repeatedMessageResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link RepeatedMessageResponse }
     *
     */
    public void setRepeatedMessageResponse(RepeatedMessageResponse value) {
        this.repeatedMessageResponse = value;
    }

}
