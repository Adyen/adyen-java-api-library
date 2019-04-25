
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: General Cryptographic Message Syntax (CMS) data structure -- Reference: RFC 3852: Cryptographic Message Syntax (CMS) -- Usage: This data structure contains two data elements:  The type of content of the CMS data structure   The content itself These CMS data structures could be nested to allow a sequence of cryptographic processings on a part of a message (e.g.
 * 
 * <p>Java class for ContentInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContentInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="EnvelopedData" type="{}EnvelopedDataType"/>
 *           &lt;element name="AuthenticatedData" type="{}AuthenticatedDataType"/>
 *           &lt;element name="SignedData" type="{}SignedDataType"/>
 *           &lt;element name="DigestedData" type="{}DigestedDataType"/>
 *           &lt;element name="NamedKeyEncryptedData" type="{}NamedKeyEncryptedDataType"/>
 *         &lt;/choice>
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
@XmlType(name = "ContentInformationType", propOrder = {
    "envelopedData",
    "authenticatedData",
    "signedData",
    "digestedData",
    "namedKeyEncryptedData"
})
public class ContentInformationType {

    @XmlElement(name = "EnvelopedData")
    protected EnvelopedDataType envelopedData;
    @XmlElement(name = "AuthenticatedData")
    protected AuthenticatedDataType authenticatedData;
    @XmlElement(name = "SignedData")
    protected SignedDataType signedData;
    @XmlElement(name = "DigestedData")
    protected DigestedDataType digestedData;
    @XmlElement(name = "NamedKeyEncryptedData")
    protected NamedKeyEncryptedDataType namedKeyEncryptedData;
    @XmlAttribute(name = "ContentType", required = true)
    protected String contentType;

    /**
     * Gets the value of the envelopedData property.
     * 
     * @return
     *     possible object is
     *     {@link EnvelopedDataType }
     *     
     */
    public EnvelopedDataType getEnvelopedData() {
        return envelopedData;
    }

    /**
     * Sets the value of the envelopedData property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnvelopedDataType }
     *     
     */
    public void setEnvelopedData(EnvelopedDataType value) {
        this.envelopedData = value;
    }

    /**
     * Gets the value of the authenticatedData property.
     * 
     * @return
     *     possible object is
     *     {@link AuthenticatedDataType }
     *     
     */
    public AuthenticatedDataType getAuthenticatedData() {
        return authenticatedData;
    }

    /**
     * Sets the value of the authenticatedData property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthenticatedDataType }
     *     
     */
    public void setAuthenticatedData(AuthenticatedDataType value) {
        this.authenticatedData = value;
    }

    /**
     * Gets the value of the signedData property.
     * 
     * @return
     *     possible object is
     *     {@link SignedDataType }
     *     
     */
    public SignedDataType getSignedData() {
        return signedData;
    }

    /**
     * Sets the value of the signedData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignedDataType }
     *     
     */
    public void setSignedData(SignedDataType value) {
        this.signedData = value;
    }

    /**
     * Gets the value of the digestedData property.
     * 
     * @return
     *     possible object is
     *     {@link DigestedDataType }
     *     
     */
    public DigestedDataType getDigestedData() {
        return digestedData;
    }

    /**
     * Sets the value of the digestedData property.
     * 
     * @param value
     *     allowed object is
     *     {@link DigestedDataType }
     *     
     */
    public void setDigestedData(DigestedDataType value) {
        this.digestedData = value;
    }

    /**
     * Gets the value of the namedKeyEncryptedData property.
     * 
     * @return
     *     possible object is
     *     {@link NamedKeyEncryptedDataType }
     *     
     */
    public NamedKeyEncryptedDataType getNamedKeyEncryptedData() {
        return namedKeyEncryptedData;
    }

    /**
     * Sets the value of the namedKeyEncryptedData property.
     * 
     * @param value
     *     allowed object is
     *     {@link NamedKeyEncryptedDataType }
     *     
     */
    public void setNamedKeyEncryptedData(NamedKeyEncryptedDataType value) {
        this.namedKeyEncryptedData = value;
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
