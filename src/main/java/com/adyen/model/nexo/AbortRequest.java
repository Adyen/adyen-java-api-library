
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Body of the Abort Request message. -- Usage: It conveys Information requested for identification of the message request carrying the transaction to abort. A message to display on the CustomerError Device could be sent by the Sale System (DisplayOutput).
 *
 * <p>Java class for AbortRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AbortRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageReference" type="{}MessageReference"/>
 *         &lt;element name="AbortReason" type="{}AbortReason"/>
 *         &lt;element name="DisplayOutput" type="{}DisplayOutput" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbortRequest", propOrder = {
    "messageReference",
    "abortReason",
    "displayOutput"
})
public class AbortRequest {

    @XmlElement(name = "MessageReference", required = true)
    protected MessageReference messageReference;
    @XmlElement(name = "AbortReason", required = true)
    protected String abortReason;
    @XmlElement(name = "DisplayOutput")
    protected DisplayOutput displayOutput;

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
     * Gets the value of the abortReason property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAbortReason() {
        return abortReason;
    }

    /**
     * Sets the value of the abortReason property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAbortReason(String value) {
        this.abortReason = value;
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

}
