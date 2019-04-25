
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Cryptographic Message Syntax (CMS) data structure containing digested data -- Reference: RFC 3852: Cryptographic Message Syntax (CMS) -- Usage: This data structure contains:  the version of the data structure  the identifiers of the message digest algorithms  the encapsulated content  the digested data
 * 
 * <p>Java class for DigestedDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DigestedDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DigestAlgorithm" type="{}AlgorithmIdentifier"/>
 *         &lt;element name="EncapsulatedContent" type="{}EncapsulatedContentType"/>
 *         &lt;element name="Digest" type="{}DigestType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Version" type="{}VersionTypeCode" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DigestedDataType", propOrder = {
    "digestAlgorithm",
    "encapsulatedContent",
    "digest"
})
public class DigestedDataType {

    @XmlElement(name = "DigestAlgorithm", required = true)
    protected AlgorithmIdentifier digestAlgorithm;
    @XmlElement(name = "EncapsulatedContent", required = true)
    protected EncapsulatedContentType encapsulatedContent;
    @XmlElement(name = "Digest", required = true)
    protected byte[] digest;
    @XmlAttribute(name = "Version")
    protected String version;

    /**
     * Gets the value of the digestAlgorithm property.
     * 
     * @return
     *     possible object is
     *     {@link AlgorithmIdentifier }
     *     
     */
    public AlgorithmIdentifier getDigestAlgorithm() {
        return digestAlgorithm;
    }

    /**
     * Sets the value of the digestAlgorithm property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlgorithmIdentifier }
     *     
     */
    public void setDigestAlgorithm(AlgorithmIdentifier value) {
        this.digestAlgorithm = value;
    }

    /**
     * Gets the value of the encapsulatedContent property.
     * 
     * @return
     *     possible object is
     *     {@link EncapsulatedContentType }
     *     
     */
    public EncapsulatedContentType getEncapsulatedContent() {
        return encapsulatedContent;
    }

    /**
     * Sets the value of the encapsulatedContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link EncapsulatedContentType }
     *     
     */
    public void setEncapsulatedContent(EncapsulatedContentType value) {
        this.encapsulatedContent = value;
    }

    /**
     * Gets the value of the digest property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getDigest() {
        return digest;
    }

    /**
     * Sets the value of the digest property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setDigest(byte[] value) {
        this.digest = value;
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
        return version;
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
