
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: General Cryptographic Message Syntax (CMS) data structure -- Reference: RFC 3852: Cryptographic Message Syntax (CMS) -- Usage: This data structure contains two data elements:  The type of content of the CMS data structure   The content itself These CMS data structures could be nested to allow a sequence of cryptographic processings on a part of a messageType (e.g.
 *
 * <p>Java class for ContentInformation complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ContentInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="EnvelopedData" type="{}EnvelopedData"/>
 *           &lt;element name="AuthenticatedData" type="{}AuthenticatedData"/>
 *           &lt;element name="SignedData" type="{}SignedData"/>
 *           &lt;element name="DigestedData" type="{}DigestedData"/>
 *           &lt;element name="NamedKeyEncryptedData" type="{}NamedKeyEncryptedData"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="Content" use="required" type="{}ContentType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContentInformation", propOrder = {
    "envelopedData",
    "authenticatedData",
    "signedData",
    "digestedData",
    "namedKeyEncryptedData"
})
public class ContentInformation {

    @XmlElement(name = "EnvelopedData")
    protected EnvelopedData envelopedData;
    @XmlElement(name = "AuthenticatedData")
    protected AuthenticatedData authenticatedData;
    @XmlElement(name = "SignedData")
    protected SignedData signedData;
    @XmlElement(name = "DigestedData")
    protected DigestedData digestedData;
    @XmlElement(name = "NamedKeyEncryptedData")
    protected NamedKeyEncryptedData namedKeyEncryptedData;
    @XmlAttribute(name = "Content", required = true)
    protected ContentType content;

    /**
     * Gets the value of the envelopedData property.
     *
     * @return
     *     possible object is
     *     {@link EnvelopedData }
     *
     */
    public EnvelopedData getEnvelopedData() {
        return envelopedData;
    }

    /**
     * Sets the value of the envelopedData property.
     *
     * @param value
     *     allowed object is
     *     {@link EnvelopedData }
     *
     */
    public void setEnvelopedData(EnvelopedData value) {
        this.envelopedData = value;
    }

    /**
     * Gets the value of the authenticatedData property.
     *
     * @return
     *     possible object is
     *     {@link AuthenticatedData }
     *
     */
    public AuthenticatedData getAuthenticatedData() {
        return authenticatedData;
    }

    /**
     * Sets the value of the authenticatedData property.
     *
     * @param value
     *     allowed object is
     *     {@link AuthenticatedData }
     *
     */
    public void setAuthenticatedData(AuthenticatedData value) {
        this.authenticatedData = value;
    }

    /**
     * Gets the value of the signedData property.
     *
     * @return
     *     possible object is
     *     {@link SignedData }
     *
     */
    public SignedData getSignedData() {
        return signedData;
    }

    /**
     * Sets the value of the signedData property.
     *
     * @param value
     *     allowed object is
     *     {@link SignedData }
     *
     */
    public void setSignedData(SignedData value) {
        this.signedData = value;
    }

    /**
     * Gets the value of the digestedData property.
     *
     * @return
     *     possible object is
     *     {@link DigestedData }
     *
     */
    public DigestedData getDigestedData() {
        return digestedData;
    }

    /**
     * Sets the value of the digestedData property.
     *
     * @param value
     *     allowed object is
     *     {@link DigestedData }
     *
     */
    public void setDigestedData(DigestedData value) {
        this.digestedData = value;
    }

    /**
     * Gets the value of the namedKeyEncryptedData property.
     *
     * @return
     *     possible object is
     *     {@link NamedKeyEncryptedData }
     *
     */
    public NamedKeyEncryptedData getNamedKeyEncryptedData() {
        return namedKeyEncryptedData;
    }

    /**
     * Sets the value of the namedKeyEncryptedData property.
     *
     * @param value
     *     allowed object is
     *     {@link NamedKeyEncryptedData }
     *
     */
    public void setNamedKeyEncryptedData(NamedKeyEncryptedData value) {
        this.namedKeyEncryptedData = value;
    }

    /**
     * Gets the value of the content property.
     *
     * @return
     *     possible object is
     *     {@link ContentType }
     *
     */
    public ContentType getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     *
     * @param value
     *     allowed object is
     *     {@link ContentType }
     *
     */
    public void setContent(ContentType value) {
        this.content = value;
    }

}
