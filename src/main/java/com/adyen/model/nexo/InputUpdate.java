package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Content of the Input Update messageType. -- Usage: It conveys update of the display of an Input request in progress.
 *
 * <p>Java class for InputUpdate complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="InputUpdate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MessageReference" type="{}MessageReference"/&gt;
 *         &lt;element name="OutputContent" type="{}OutputContent"/&gt;
 *         &lt;element name="MenuEntry" type="{}MenuEntry" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="OutputSignature" type="{}OutputSignature" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="MinLength" type="{}MinLength" /&gt;
 *       &lt;attribute name="MaxLength" type="{}MaxLength" /&gt;
 *       &lt;attribute name="MaxDecimalLength" type="{}MaxDecimalLength" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputUpdate", propOrder = {
        "messageReference",
        "outputContent",
        "menuEntry",
        "outputSignature"
})
public class InputUpdate {

    /**
     * The Message reference.
     */
    @XmlElement(name = "MessageReference", required = true)
    protected MessageReference messageReference;
    /**
     * The Output content.
     */
    @XmlElement(name = "OutputContent", required = true)
    protected OutputContent outputContent;
    /**
     * The Menu entry.
     */
    @XmlElement(name = "MenuEntry")
    protected List<MenuEntry> menuEntry;
    /**
     * The Output signature.
     */
    @XmlElement(name = "OutputSignature")
    protected byte[] outputSignature;
    /**
     * The Min length.
     */
    @XmlAttribute(name = "MinLength")
    protected BigInteger minLength;
    /**
     * The Max length.
     */
    @XmlAttribute(name = "MaxLength")
    protected BigInteger maxLength;
    /**
     * The Max decimal length.
     */
    @XmlAttribute(name = "MaxDecimalLength")
    protected BigInteger maxDecimalLength;

    /**
     * Gets the value of the messageReference property.
     *
     * @return possible      object is     {@link MessageReference }
     */
    public MessageReference getMessageReference() {
        return messageReference;
    }

    /**
     * Sets the value of the messageReference property.
     *
     * @param value allowed object is     {@link MessageReference }
     */
    public void setMessageReference(MessageReference value) {
        this.messageReference = value;
    }

    /**
     * Gets the value of the outputContent property.
     *
     * @return possible      object is     {@link OutputContent }
     */
    public OutputContent getOutputContent() {
        return outputContent;
    }

    /**
     * Sets the value of the outputContent property.
     *
     * @param value allowed object is     {@link OutputContent }
     */
    public void setOutputContent(OutputContent value) {
        this.outputContent = value;
    }

    /**
     * Gets the value of the menuEntry property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the menuEntry property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMenuEntry().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link MenuEntry }
     *
     * @return the menu entry
     */
    public List<MenuEntry> getMenuEntry() {
        if (menuEntry == null) {
            menuEntry = new ArrayList<>();
        }
        return this.menuEntry;
    }

    /**
     * Gets the value of the outputSignature property.
     *
     * @return possible      object is     byte[]
     */
    public byte[] getOutputSignature() {
        return outputSignature;
    }

    /**
     * Sets the value of the outputSignature property.
     *
     * @param value allowed object is     byte[]
     */
    public void setOutputSignature(byte[] value) {
        this.outputSignature = value;
    }

    /**
     * Gets the value of the minLength property.
     *
     * @return possible      object is     {@link BigInteger }
     */
    public BigInteger getMinLength() {
        return minLength;
    }

    /**
     * Sets the value of the minLength property.
     *
     * @param value allowed object is     {@link BigInteger }
     */
    public void setMinLength(BigInteger value) {
        this.minLength = value;
    }

    /**
     * Gets the value of the maxLength property.
     *
     * @return possible      object is     {@link BigInteger }
     */
    public BigInteger getMaxLength() {
        return maxLength;
    }

    /**
     * Sets the value of the maxLength property.
     *
     * @param value allowed object is     {@link BigInteger }
     */
    public void setMaxLength(BigInteger value) {
        this.maxLength = value;
    }

    /**
     * Gets the value of the maxDecimalLength property.
     *
     * @return possible      object is     {@link BigInteger }
     */
    public BigInteger getMaxDecimalLength() {
        return maxDecimalLength;
    }

    /**
     * Sets the value of the maxDecimalLength property.
     *
     * @param value allowed object is     {@link BigInteger }
     */
    public void setMaxDecimalLength(BigInteger value) {
        this.maxDecimalLength = value;
    }

}
