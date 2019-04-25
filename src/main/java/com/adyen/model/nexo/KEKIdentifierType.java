
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Identification of a key encryption key (key management using previously distributed symmetric key) -- Reference: RFC 3852: Cryptographic Message Syntax (CMS) -- Usage: This data structure contains:  the identification of the key  the date of the key
 * 
 * <p>Java class for KEKIdentifierType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KEKIdentifierType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="KeyIdentifier" use="required" type="{}KeyIdentifierType" />
 *       &lt;attribute name="KeyVersion" use="required" type="{}KeyVersionType" />
 *       &lt;attribute name="DerivationIdentifier" type="{}DerivationIdentifierType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KEKIdentifierType")
public class KEKIdentifierType {

    @XmlAttribute(name = "KeyIdentifier", required = true)
    protected String keyIdentifier;
    @XmlAttribute(name = "KeyVersion", required = true)
    protected String keyVersion;
    @XmlAttribute(name = "DerivationIdentifier")
    protected byte[] derivationIdentifier;

    /**
     * Gets the value of the keyIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyIdentifier() {
        return keyIdentifier;
    }

    /**
     * Sets the value of the keyIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyIdentifier(String value) {
        this.keyIdentifier = value;
    }

    /**
     * Gets the value of the keyVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyVersion() {
        return keyVersion;
    }

    /**
     * Sets the value of the keyVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyVersion(String value) {
        this.keyVersion = value;
    }

    /**
     * Gets the value of the derivationIdentifier property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getDerivationIdentifier() {
        return derivationIdentifier;
    }

    /**
     * Sets the value of the derivationIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setDerivationIdentifier(byte[] value) {
        this.derivationIdentifier = value;
    }

}
