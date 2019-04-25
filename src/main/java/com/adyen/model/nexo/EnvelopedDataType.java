
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Cryptographic Message Syntax (CMS) data structure containing encrypted data with encryption key -- Reference: RFC 3852: Cryptographic Message Syntax (CMS) -- Usage: This data structure contains:  the version of the data structure (which is v0 in EPAS protocol context)  the protected encrytion key for every adressee (recipient)  the encrypted data
 * 
 * <p>Java class for EnvelopedDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EnvelopedDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element name="KeyTransport" type="{}KeyTransportType"/>
 *           &lt;element name="KEK" type="{}KEKType"/>
 *         &lt;/choice>
 *         &lt;element name="EncryptedContent" type="{}EncryptedContentType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Version" type="{}VersionTypeCode" default="v0" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnvelopedDataType", propOrder = {
    "keyTransportOrKEK",
    "encryptedContent"
})
public class EnvelopedDataType {

    @XmlElements({
        @XmlElement(name = "KeyTransport", type = KeyTransportType.class),
        @XmlElement(name = "KEK", type = KEKType.class)
    })
    protected List<Object> keyTransportOrKEK;
    @XmlElement(name = "EncryptedContent", required = true)
    protected EncryptedContentType encryptedContent;
    @XmlAttribute(name = "Version")
    protected String version;

    /**
     * Gets the value of the keyTransportOrKEK property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyTransportOrKEK property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyTransportOrKEK().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyTransportType }
     * {@link KEKType }
     * 
     * 
     */
    public List<Object> getKeyTransportOrKEK() {
        if (keyTransportOrKEK == null) {
            keyTransportOrKEK = new ArrayList<Object>();
        }
        return this.keyTransportOrKEK;
    }

    /**
     * Gets the value of the encryptedContent property.
     * 
     * @return
     *     possible object is
     *     {@link EncryptedContentType }
     *     
     */
    public EncryptedContentType getEncryptedContent() {
        return encryptedContent;
    }

    /**
     * Sets the value of the encryptedContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link EncryptedContentType }
     *     
     */
    public void setEncryptedContent(EncryptedContentType value) {
        this.encryptedContent = value;
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

}
