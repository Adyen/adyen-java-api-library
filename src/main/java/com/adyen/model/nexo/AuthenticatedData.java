
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
 * Definition: Cryptographic Message Syntax (CMS) data structure containing MACed data with encryption key -- Reference: RFC 3852: Cryptographic Message Syntax (CMS) -- Usage: This data structure contains:  the version of the data structure (which is v0 in EPAS protocol context)  the protected encrytion key for every adressee (recipient)  the encrypted data
 *
 * <p>Java class for AuthenticatedData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AuthenticatedData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element name="KeyTransport" type="{}KeyTransport"/>
 *           &lt;element name="KEK" type="{}KEK"/>
 *         &lt;/choice>
 *         &lt;element name="MACAlgorithm" type="{}AlgorithmIdentifier"/>
 *         &lt;element name="EncapsulatedContent" type="{}EncapsulatedContent"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Version" type="{}VersionType" default="v0" />
 *       &lt;attribute name="MAC" use="required" type="{}MAC" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthenticatedData", propOrder = {
    "keyTransportOrKEK",
    "macAlgorithm",
    "encapsulatedContent"
})
public class AuthenticatedData {

    @XmlElements({
        @XmlElement(name = "KeyTransport", type = KeyTransport.class),
        @XmlElement(name = "KEK", type = KEK.class)
    })
    protected List<Object> keyTransportOrKEK;
    @XmlElement(name = "MACAlgorithm", required = true)
    protected AlgorithmIdentifier macAlgorithm;
    @XmlElement(name = "EncapsulatedContent", required = true)
    protected EncapsulatedContent encapsulatedContent;
    @XmlAttribute(name = "Version")
    protected VersionType version;
    @XmlAttribute(name = "MAC", required = true)
    protected byte[] mac;

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
     * {@link KeyTransport }
     * {@link KEK }
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
     * Gets the value of the macAlgorithm property.
     *
     * @return
     *     possible object is
     *     {@link AlgorithmIdentifier }
     *
     */
    public AlgorithmIdentifier getMACAlgorithm() {
        return macAlgorithm;
    }

    /**
     * Sets the value of the macAlgorithm property.
     *
     * @param value
     *     allowed object is
     *     {@link AlgorithmIdentifier }
     *
     */
    public void setMACAlgorithm(AlgorithmIdentifier value) {
        this.macAlgorithm = value;
    }

    /**
     * Gets the value of the encapsulatedContent property.
     *
     * @return
     *     possible object is
     *     {@link EncapsulatedContent }
     *
     */
    public EncapsulatedContent getEncapsulatedContent() {
        return encapsulatedContent;
    }

    /**
     * Sets the value of the encapsulatedContent property.
     *
     * @param value
     *     allowed object is
     *     {@link EncapsulatedContent }
     *
     */
    public void setEncapsulatedContent(EncapsulatedContent value) {
        this.encapsulatedContent = value;
    }

    /**
     * Gets the value of the version property.
     *
     * @return
     *     possible object is
     *     {@link VersionType }
     *
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
     * @param value
     *     allowed object is
     *     {@link VersionType }
     *
     */
    public void setVersion(VersionType value) {
        this.version = value;
    }

    /**
     * Gets the value of the mac property.
     *
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getMAC() {
        return mac;
    }

    /**
     * Sets the value of the mac property.
     *
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setMAC(byte[] value) {
        this.mac = value;
    }

}
