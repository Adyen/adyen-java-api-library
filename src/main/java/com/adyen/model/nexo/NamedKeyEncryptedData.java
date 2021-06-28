package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Cryptographic Message Syntax (CMS) data structure containing encrypted data and integrated optional data filed keyName. -- Reference: RFC 3852: Cryptographic Message Syntax (CMS) -- Usage: This data structure contains:  the version of the data structure (which is v0 in EPAS protocol context)  the keyName  the encrypred content info including the encrypted data
 *
 * <p>Java class for NamedKeyEncryptedData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="NamedKeyEncryptedData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="KeyName" type="{}KeyName" minOccurs="0"/&gt;
 *         &lt;element name="EncryptedContent" type="{}EncryptedContent"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Version" type="{}VersionType" default="v0" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NamedKeyEncryptedData", propOrder = {
        "keyName",
        "encryptedContent"
})
public class NamedKeyEncryptedData {

    /**
     * The Key name.
     */
    @XmlElement(name = "KeyName")
    protected String keyName;
    /**
     * The Encrypted content.
     */
    @XmlElement(name = "EncryptedContent", required = true)
    protected EncryptedContent encryptedContent;
    /**
     * The Version.
     */
    @XmlElement(name = "Version")
    protected VersionType version;

    /**
     * Gets the value of the keyName property.
     *
     * @return possible      object is     {@link String }
     */
    public String getKeyName() {
        return keyName;
    }

    /**
     * Sets the value of the keyName property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setKeyName(String value) {
        this.keyName = value;
    }

    /**
     * Gets the value of the encryptedContent property.
     *
     * @return possible      object is     {@link EncryptedContent }
     */
    public EncryptedContent getEncryptedContent() {
        return encryptedContent;
    }

    /**
     * Sets the value of the encryptedContent property.
     *
     * @param value allowed object is     {@link EncryptedContent }
     */
    public void setEncryptedContent(EncryptedContent value) {
        this.encryptedContent = value;
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

}
