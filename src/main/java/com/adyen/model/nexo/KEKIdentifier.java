package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Identification of a key encryption key (key management using previously distributed symmetric key) -- Reference: RFC 3852: Cryptographic Message Syntax (CMS) -- Usage: This data structure contains:  the identification of the key  the date of the key
 *
 * <p>Java class for KEKIdentifier complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="KEKIdentifier"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="KeyIdentifier" use="required" type="{}KeyIdentifier" /&gt;
 *       &lt;attribute name="KeyVersion" use="required" type="{}KeyVersion" /&gt;
 *       &lt;attribute name="DerivationIdentifier" type="{}DerivationIdentifier" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KEKIdentifier")
public class KEKIdentifier {

    /**
     * The Key identifier.
     */
    @XmlElement(name = "KeyIdentifier", required = true)
    protected String keyIdentifier;
    /**
     * The Key version.
     */
    @XmlElement(name = "KeyVersion", required = true)
    protected String keyVersion;
    /**
     * The Derivation identifier.
     */
    @XmlElement(name = "DerivationIdentifier")
    protected byte[] derivationIdentifier;

    /**
     * Gets the value of the keyIdentifier property.
     *
     * @return possible      object is     {@link String }
     */
    public String getKeyIdentifier() {
        return keyIdentifier;
    }

    /**
     * Sets the value of the keyIdentifier property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setKeyIdentifier(String value) {
        this.keyIdentifier = value;
    }

    /**
     * Gets the value of the keyVersion property.
     *
     * @return possible      object is     {@link String }
     */
    public String getKeyVersion() {
        return keyVersion;
    }

    /**
     * Sets the value of the keyVersion property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setKeyVersion(String value) {
        this.keyVersion = value;
    }

    /**
     * Gets the value of the derivationIdentifier property.
     *
     * @return possible      object is     byte[]
     */
    public byte[] getDerivationIdentifier() {
        return derivationIdentifier;
    }

    /**
     * Sets the value of the derivationIdentifier property.
     *
     * @param value allowed object is     byte[]
     */
    public void setDerivationIdentifier(byte[] value) {
        this.derivationIdentifier = value;
    }

}
