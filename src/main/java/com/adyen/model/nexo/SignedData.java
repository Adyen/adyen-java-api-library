package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Cryptographic Message Syntax (CMS) data structure containing signed data  -- Reference: RFC 3852: Cryptographic Message Syntax (CMS) -- Usage: This data structure contains:  the version of the data structure (which is v1 in EPAS protocol context)  the identifiers of the messageType digest algorithms  the encapsulated content  the certificates for the verification of the signature
 *
 * <p>Java class for SignedData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SignedData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DigestAlgorithm" type="{}AlgorithmIdentifier" maxOccurs="unbounded"/&gt;
 *         &lt;element name="EncapsulatedContent" type="{}EncapsulatedContent"/&gt;
 *         &lt;element name="Certificate" type="{}Certificate" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Signer" type="{}Signer" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Version" type="{}VersionType" default="v1" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignedData", propOrder = {
        "digestAlgorithm",
        "encapsulatedContent",
        "certificate",
        "signer"
})
public class SignedData {

    /**
     * The Digest algorithm.
     */
    @XmlElement(name = "DigestAlgorithm", required = true)
    protected List<AlgorithmIdentifier> digestAlgorithm;
    /**
     * The Encapsulated content.
     */
    @XmlElement(name = "EncapsulatedContent", required = true)
    protected EncapsulatedContent encapsulatedContent;
    /**
     * The Certificate.
     */
    @XmlElement(name = "Certificate")
    protected List<byte[]> certificate;
    /**
     * The Signer.
     */
    @XmlElement(name = "Signer", required = true)
    protected List<Signer> signer;
    /**
     * The Version.
     */
    @XmlElement(name = "Version")
    protected VersionType version;

    /**
     * Gets the value of the digestAlgorithm property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the digestAlgorithm property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDigestAlgorithm().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AlgorithmIdentifier }
     *
     * @return the digest algorithm
     */
    public List<AlgorithmIdentifier> getDigestAlgorithm() {
        if (digestAlgorithm == null) {
            digestAlgorithm = new ArrayList<>();
        }
        return this.digestAlgorithm;
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
     * Gets the value of the certificate property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the certificate property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCertificate().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * byte[]
     *
     * @return the certificate
     */
    public List<byte[]> getCertificate() {
        if (certificate == null) {
            certificate = new ArrayList<>();
        }
        return this.certificate;
    }

    /**
     * Gets the value of the signer property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signer property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSigner().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Signer }
     *
     * @return the signer
     */
    public List<Signer> getSigner() {
        if (signer == null) {
            signer = new ArrayList<>();
        }
        return this.signer;
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
