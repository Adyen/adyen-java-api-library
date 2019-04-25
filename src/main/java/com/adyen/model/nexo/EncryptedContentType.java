
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Cryptographic Message Syntax (CMS) data structure containing encrypted data with encryption key -- Reference: RFC 3852: Cryptographic Message Syntax (CMS) -- Usage: This data structure contains: the type of the encrypted content, which is id-data for an application data or another CMS data structure the protected encryption key for every recipient the encrypted data
 * 
 * <p>Java class for EncryptedContentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EncryptedContentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ContentEncryptionAlgorithm" type="{}AlgorithmIdentifier"/>
 *         &lt;element name="EncryptedData" type="{}EncryptedDataType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ContentType" use="required" type="{}ContentTypeTypeCode" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EncryptedContentType", propOrder = {
    "contentEncryptionAlgorithm",
    "encryptedData"
})
public class EncryptedContentType {

    @XmlElement(name = "ContentEncryptionAlgorithm", required = true)
    protected AlgorithmIdentifier contentEncryptionAlgorithm;
    @XmlElement(name = "EncryptedData", required = true)
    protected byte[] encryptedData;
    @XmlAttribute(name = "ContentType", required = true)
    protected String contentType;

    /**
     * Gets the value of the contentEncryptionAlgorithm property.
     * 
     * @return
     *     possible object is
     *     {@link AlgorithmIdentifier }
     *     
     */
    public AlgorithmIdentifier getContentEncryptionAlgorithm() {
        return contentEncryptionAlgorithm;
    }

    /**
     * Sets the value of the contentEncryptionAlgorithm property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlgorithmIdentifier }
     *     
     */
    public void setContentEncryptionAlgorithm(AlgorithmIdentifier value) {
        this.contentEncryptionAlgorithm = value;
    }

    /**
     * Gets the value of the encryptedData property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getEncryptedData() {
        return encryptedData;
    }

    /**
     * Sets the value of the encryptedData property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setEncryptedData(byte[] value) {
        this.encryptedData = value;
    }

    /**
     * Gets the value of the contentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets the value of the contentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentType(String value) {
        this.contentType = value;
    }

}
