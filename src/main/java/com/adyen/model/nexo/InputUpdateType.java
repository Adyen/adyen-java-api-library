
package com.adyen.model.nexo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Input Update message. -- Usage: It conveys update of the display of an Input request in progress.
 * 
 * <p>Java class for InputUpdateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InputUpdateType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageReference" type="{}MessageReferenceType"/>
 *         &lt;element name="OutputContent" type="{}OutputContentType"/>
 *         &lt;element name="MenuEntry" type="{}MenuEntryType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OutputSignature" type="{}OutputSignatureType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="MinLength" type="{}MinLengthType" />
 *       &lt;attribute name="MaxLength" type="{}MaxLengthType" />
 *       &lt;attribute name="MaxDecimalLength" type="{}MaxDecimalLengthType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputUpdateType", propOrder = {
    "messageReference",
    "outputContent",
    "menuEntry",
    "outputSignature"
})
public class InputUpdateType {

    @XmlElement(name = "MessageReference", required = true)
    protected MessageReferenceType messageReference;
    @XmlElement(name = "OutputContent", required = true)
    protected OutputContentType outputContent;
    @XmlElement(name = "MenuEntry")
    protected List<MenuEntryType> menuEntry;
    @XmlElement(name = "OutputSignature")
    protected byte[] outputSignature;
    @XmlAttribute(name = "MinLength")
    protected BigInteger minLength;
    @XmlAttribute(name = "MaxLength")
    protected BigInteger maxLength;
    @XmlAttribute(name = "MaxDecimalLength")
    protected BigInteger maxDecimalLength;

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
     * Gets the value of the outputContent property.
     * 
     * @return
     *     possible object is
     *     {@link OutputContentType }
     *     
     */
    public OutputContentType getOutputContent() {
        return outputContent;
    }

    /**
     * Sets the value of the outputContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputContentType }
     *     
     */
    public void setOutputContent(OutputContentType value) {
        this.outputContent = value;
    }

    /**
     * Gets the value of the menuEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the menuEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMenuEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MenuEntryType }
     * 
     * 
     */
    public List<MenuEntryType> getMenuEntry() {
        if (menuEntry == null) {
            menuEntry = new ArrayList<MenuEntryType>();
        }
        return this.menuEntry;
    }

    /**
     * Gets the value of the outputSignature property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getOutputSignature() {
        return outputSignature;
    }

    /**
     * Sets the value of the outputSignature property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setOutputSignature(byte[] value) {
        this.outputSignature = value;
    }

    /**
     * Gets the value of the minLength property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMinLength() {
        return minLength;
    }

    /**
     * Sets the value of the minLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMinLength(BigInteger value) {
        this.minLength = value;
    }

    /**
     * Gets the value of the maxLength property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxLength() {
        return maxLength;
    }

    /**
     * Sets the value of the maxLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxLength(BigInteger value) {
        this.maxLength = value;
    }

    /**
     * Gets the value of the maxDecimalLength property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxDecimalLength() {
        return maxDecimalLength;
    }

    /**
     * Sets the value of the maxDecimalLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxDecimalLength(BigInteger value) {
        this.maxDecimalLength = value;
    }

}
