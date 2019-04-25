
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Cryptographic Message Syntax (CMS) data structure containing signer information  -- Reference: RFC 3852: Cryptographic Message Syntax (CMS) -- Usage: This data structure contains:  the version of the data structure (which is v1 in EPAS protocol context)  the identifiers of the message digest algorithms  the encapsulated content  the information about the signer
 * 
 * <p>Java class for SignerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SignerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SignerIdentifier" type="{}SignerIdentifierType"/>
 *         &lt;element name="DigestAlgorithm" type="{}AlgorithmIdentifier"/>
 *         &lt;element name="SignatureAlgorithm" type="{}AlgorithmIdentifier"/>
 *         &lt;element name="Signature" type="{}SignatureType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Version" type="{}VersionTypeCode" default="v1" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignerType", propOrder = {
    "signerIdentifier",
    "digestAlgorithm",
    "signatureAlgorithm",
    "signature"
})
public class SignerType {

    @XmlElement(name = "SignerIdentifier", required = true)
    protected SignerIdentifierType signerIdentifier;
    @XmlElement(name = "DigestAlgorithm", required = true)
    protected AlgorithmIdentifier digestAlgorithm;
    @XmlElement(name = "SignatureAlgorithm", required = true)
    protected AlgorithmIdentifier signatureAlgorithm;
    @XmlElement(name = "Signature", required = true)
    protected byte[] signature;
    @XmlAttribute(name = "Version")
    protected String version;

    /**
     * Gets the value of the signerIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link SignerIdentifierType }
     *     
     */
    public SignerIdentifierType getSignerIdentifier() {
        return signerIdentifier;
    }

    /**
     * Sets the value of the signerIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignerIdentifierType }
     *     
     */
    public void setSignerIdentifier(SignerIdentifierType value) {
        this.signerIdentifier = value;
    }

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
     * Gets the value of the signatureAlgorithm property.
     * 
     * @return
     *     possible object is
     *     {@link AlgorithmIdentifier }
     *     
     */
    public AlgorithmIdentifier getSignatureAlgorithm() {
        return signatureAlgorithm;
    }

    /**
     * Sets the value of the signatureAlgorithm property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlgorithmIdentifier }
     *     
     */
    public void setSignatureAlgorithm(AlgorithmIdentifier value) {
        this.signatureAlgorithm = value;
    }

    /**
     * Gets the value of the signature property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setSignature(byte[] value) {
        this.signature = value;
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
            return "v1";
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
