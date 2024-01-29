package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Certificate distinguished name (DN) -- Reference: RFC 3880: Internet X.509 Public Key Infrastructure Certificate and Certificate -- Usage: Identifies the issuer or the subject of a X.509 certificate.
 *
 * <p>Java class for RelativeDistinguishedName complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="RelativeDistinguishedName"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Attribute" type="{}AttributeTypeCodeZ"/&gt;
 *         &lt;element name="AttributeValue" type="{}AttributeValue"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RelativeDistinguishedName", propOrder = {
        "attribute",
        "attributeValue"
})
public class RelativeDistinguishedName {

    /**
     * The Attribute.
     */
    @XmlElement(name = "Attribute", required = true)
    protected String attribute;
    /**
     * The Attribute value.
     */
    @XmlElement(name = "AttributeValue", required = true)
    protected String attributeValue;

    /**
     * Gets the value of the attribute property.
     *
     * @return possible      object is     {@link String }
     */
    public String getAttribute() {
        return attribute;
    }

    /**
     * Sets the value of the attribute property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setAttribute(String value) {
        this.attribute = value;
    }

    /**
     * Gets the value of the attributeValue property.
     *
     * @return possible      object is     {@link String }
     */
    public String getAttributeValue() {
        return attributeValue;
    }

    /**
     * Sets the value of the attributeValue property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setAttributeValue(String value) {
        this.attributeValue = value;
    }

}
