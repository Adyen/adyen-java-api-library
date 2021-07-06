package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Cryptographic Message Syntax (CMS) data structure containing signer information  -- Reference: RFC 3852: Cryptographic Message Syntax (CMS) -- Usage: This data structure contains:  the version of the data structure (which is v1 in EPAS protocol context)  the identifiers of the messageType digest algorithms  the encapsulated content  the information about the signer
 *
 * <p>Java class for Signer complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Signer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SignerIdentifier" type="{}SignerIdentifier"/&gt;
 *         &lt;element name="DigestAlgorithm" type="{}AlgorithmIdentifier"/&gt;
 *         &lt;element name="SignatureAlgorithm" type="{}AlgorithmIdentifier"/&gt;
 *         &lt;element name="Signature" type="{}Signature"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Version" type="{}VersionType" default="v1" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Signer", propOrder = {
        "signerIdentifier",
        "digestAlgorithm",
        "signatureAlgorithm",
        "signature"
})
public class Signer {

    /**
     * The Signer identifier.
     */
    @XmlElement(name = "SignerIdentifier", required = true)
    protected SignerIdentifier signerIdentifier;
    /**
     * The Digest algorithm.
     */
    @XmlElement(name = "DigestAlgorithm", required = true)
    protected AlgorithmIdentifier digestAlgorithm;
    /**
     * The Signature algorithm.
     */
    @XmlElement(name = "SignatureAlgorithm", required = true)
    protected AlgorithmIdentifier signatureAlgorithm;
    /**
     * The Signature.
     */
    @XmlElement(name = "Signature", required = true)
    protected byte[] signature;
    /**
     * The Version.
     */
    @XmlElement(name = "Version")
    protected VersionType version;

    /**
     * Gets the value of the signerIdentifier property.
     *
     * @return possible      object is     {@link SignerIdentifier }
     */
    public SignerIdentifier getSignerIdentifier() {
        return signerIdentifier;
    }

    /**
     * Sets the value of the signerIdentifier property.
     *
     * @param value allowed object is     {@link SignerIdentifier }
     */
    public void setSignerIdentifier(SignerIdentifier value) {
        this.signerIdentifier = value;
    }

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
     * Gets the value of the signatureAlgorithm property.
     *
     * @return possible      object is     {@link AlgorithmIdentifier }
     */
    public AlgorithmIdentifier getSignatureAlgorithm() {
        return signatureAlgorithm;
    }

    /**
     * Sets the value of the signatureAlgorithm property.
     *
     * @param value allowed object is     {@link AlgorithmIdentifier }
     */
    public void setSignatureAlgorithm(AlgorithmIdentifier value) {
        this.signatureAlgorithm = value;
    }

    /**
     * Gets the value of the signature property.
     *
     * @return possible      object is     byte[]
     */
    public byte[] getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     *
     * @param value allowed object is     byte[]
     */
    public void setSignature(byte[] value) {
        this.signature = value;
    }

    /**
     * Gets the value of the version property.
     *
     * @return possible      object is     {@link VersionType }
     */
    public VersionType getVersion() {
        if (version == null) {
            return VersionType.V_1;
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
