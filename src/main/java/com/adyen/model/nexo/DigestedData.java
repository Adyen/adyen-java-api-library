package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Cryptographic Message Syntax (CMS) data structure containing digested data -- Reference: RFC 3852: Cryptographic Message Syntax (CMS) -- Usage: This data structure contains:  the version of the data structure  the identifiers of the messageType digest algorithms  the encapsulated content  the digested data
 *
 * <p>Java class for DigestedData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DigestedData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DigestAlgorithm" type="{}AlgorithmIdentifier"/&gt;
 *         &lt;element name="EncapsulatedContent" type="{}EncapsulatedContent"/&gt;
 *         &lt;element name="Digest" type="{}Digest"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Version" type="{}VersionType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DigestedData", propOrder = {
        "digestAlgorithm",
        "encapsulatedContent",
        "digest"
})
public class DigestedData {

    /**
     * The Digest algorithm.
     */
    @XmlElement(name = "DigestAlgorithm", required = true)
    protected AlgorithmIdentifier digestAlgorithm;
    /**
     * The Encapsulated content.
     */
    @XmlElement(name = "EncapsulatedContent", required = true)
    protected EncapsulatedContent encapsulatedContent;
    /**
     * The Digest.
     */
    @XmlElement(name = "Digest", required = true)
    protected byte[] digest;
    /**
     * The Version.
     */
    @XmlElement(name = "Version")
    protected VersionType version;

    /**
     * Gets the value of the digestAlgorithm property.
     *
     * @return possible      object is     {@link AlgorithmIdentifier }
     */
    public AlgorithmIdentifier getDigestAlgorithm() {
        return digestAlgorithm;
    }

    /**
     * Sets the value of the digestAlgorithm property.
     *
     * @param value allowed object is     {@link AlgorithmIdentifier }
     */
    public void setDigestAlgorithm(AlgorithmIdentifier value) {
        this.digestAlgorithm = value;
    }

    /**
     * Gets the value of the encapsulatedContent property.
     *
     * @return possible      object is     {@link EncapsulatedContent }
     */
    public EncapsulatedContent getEncapsulatedContent() {
        return encapsulatedContent;
    }

    /**
     * Sets the value of the encapsulatedContent property.
     *
     * @param value allowed object is     {@link EncapsulatedContent }
     */
    public void setEncapsulatedContent(EncapsulatedContent value) {
        this.encapsulatedContent = value;
    }

    /**
     * Gets the value of the digest property.
     *
     * @return possible      object is     byte[]
     */
    public byte[] getDigest() {
        return digest;
    }

    /**
     * Sets the value of the digest property.
     *
     * @param value allowed object is     byte[]
     */
    public void setDigest(byte[] value) {
        this.digest = value;
    }

    /**
     * Gets the value of the version property.
     *
     * @return possible      object is     {@link VersionType }
     */
    public VersionType getVersion() {
        return version;
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
