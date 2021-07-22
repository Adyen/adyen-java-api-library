package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Encryption key using previously distributed asymmetric key -- Reference: RFC 3852: Cryptographic Message Syntax (CMS) -- Usage: This data structure contains:  the version of the data structure (v0)  the recipient identifier  the key encryption algorithm  the encrypted key
 *
 * <p>Java class for KeyTransport complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="KeyTransport"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RecipientIdentifier" type="{}RecipientIdentifier"/&gt;
 *         &lt;element name="KeyEncryptionAlgorithm" type="{}AlgorithmIdentifier"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Version" type="{}VersionType" default="v0" /&gt;
 *       &lt;attribute name="EncryptedKey" use="required" type="{}EncryptedKey" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeyTransport", propOrder = {
        "recipientIdentifier",
        "keyEncryptionAlgorithm"
})
public class KeyTransport {

    /**
     * The Recipient identifier.
     */
    @XmlElement(name = "RecipientIdentifier", required = true)
    protected RecipientIdentifier recipientIdentifier;
    /**
     * The Key encryption algorithm.
     */
    @XmlElement(name = "KeyEncryptionAlgorithm", required = true)
    protected AlgorithmIdentifier keyEncryptionAlgorithm;
    /**
     * The Version.
     */
    @XmlElement(name = "Version")
    protected VersionType version;
    /**
     * The Encrypted key.
     */
    @XmlElement(name = "EncryptedKey", required = true)
    protected byte[] encryptedKey;

    /**
     * Gets the value of the recipientIdentifier property.
     *
     * @return possible      object is     {@link RecipientIdentifier }
     */
    public RecipientIdentifier getRecipientIdentifier() {
        return recipientIdentifier;
    }

    /**
     * Sets the value of the recipientIdentifier property.
     *
     * @param value allowed object is     {@link RecipientIdentifier }
     */
    public void setRecipientIdentifier(RecipientIdentifier value) {
        this.recipientIdentifier = value;
    }

    /**
     * Gets the value of the keyEncryptionAlgorithm property.
     *
     * @return possible      object is     {@link AlgorithmIdentifier }
     */
    public AlgorithmIdentifier getKeyEncryptionAlgorithm() {
        return keyEncryptionAlgorithm;
    }

    /**
     * Sets the value of the keyEncryptionAlgorithm property.
     *
     * @param value allowed object is     {@link AlgorithmIdentifier }
     */
    public void setKeyEncryptionAlgorithm(AlgorithmIdentifier value) {
        this.keyEncryptionAlgorithm = value;
    }

    /**
     * Gets the value of the version property.
     *
     * @return possible      object is     {@link VersionType }
     */
    public VersionType getVersion() {
        if (version == null) {
            return VersionType.V_0;
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     *
     * @param value allowed object is     {@link VersionType }
     */
    public void setVersion(VersionType value) {
        this.version = value;
    }

    /**
     * Gets the value of the encryptedKey property.
     *
     * @return possible      object is     byte[]
     */
    public byte[] getEncryptedKey() {
        return encryptedKey;
    }

    /**
     * Sets the value of the encryptedKey property.
     *
     * @param value allowed object is     byte[]
     */
    public void setEncryptedKey(byte[] value) {
        this.encryptedKey = value;
    }

}
