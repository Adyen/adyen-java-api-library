
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Encryption key using previously distributed asymmetric key -- Reference: RFC 3852: Cryptographic Message Syntax (CMS) -- Usage: This data structure contains:  the version of the data structure (v0)  the recipient identifier  the key encryption algorithm  the encrypted key
 * 
 * <p>Java class for KeyTransportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KeyTransportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RecipientIdentifier" type="{}RecipientIdentifierType"/>
 *         &lt;element name="KeyEncryptionAlgorithm" type="{}AlgorithmIdentifier"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Version" type="{}VersionTypeCode" default="v0" />
 *       &lt;attribute name="EncryptedKey" use="required" type="{}EncryptedKeyType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeyTransportType", propOrder = {
    "recipientIdentifier",
    "keyEncryptionAlgorithm"
})
public class KeyTransportType {

    @XmlElement(name = "RecipientIdentifier", required = true)
    protected RecipientIdentifierType recipientIdentifier;
    @XmlElement(name = "KeyEncryptionAlgorithm", required = true)
    protected AlgorithmIdentifier keyEncryptionAlgorithm;
    @XmlAttribute(name = "Version")
    protected String version;
    @XmlAttribute(name = "EncryptedKey", required = true)
    protected byte[] encryptedKey;

    /**
     * Gets the value of the recipientIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link RecipientIdentifierType }
     *     
     */
    public RecipientIdentifierType getRecipientIdentifier() {
        return recipientIdentifier;
    }

    /**
     * Sets the value of the recipientIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecipientIdentifierType }
     *     
     */
    public void setRecipientIdentifier(RecipientIdentifierType value) {
        this.recipientIdentifier = value;
    }

    /**
     * Gets the value of the keyEncryptionAlgorithm property.
     * 
     * @return
     *     possible object is
     *     {@link AlgorithmIdentifier }
     *     
     */
    public AlgorithmIdentifier getKeyEncryptionAlgorithm() {
        return keyEncryptionAlgorithm;
    }

    /**
     * Sets the value of the keyEncryptionAlgorithm property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlgorithmIdentifier }
     *     
     */
    public void setKeyEncryptionAlgorithm(AlgorithmIdentifier value) {
        this.keyEncryptionAlgorithm = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        if (version == null) {
            return "v0";
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the encryptedKey property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getEncryptedKey() {
        return encryptedKey;
    }

    /**
     * Sets the value of the encryptedKey property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setEncryptedKey(byte[] value) {
        this.encryptedKey = value;
    }

}
