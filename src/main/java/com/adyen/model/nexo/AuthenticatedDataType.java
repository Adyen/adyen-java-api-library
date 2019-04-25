
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
 * <p>Java class for AuthenticatedDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuthenticatedDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element name="KeyTransport" type="{}KeyTransportType"/>
 *           &lt;element name="KEK" type="{}KEKType"/>
 *         &lt;/choice>
 *         &lt;element name="MACAlgorithm" type="{}AlgorithmIdentifier"/>
 *         &lt;element name="EncapsulatedContent" type="{}EncapsulatedContentType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Version" type="{}VersionTypeCode" default="v0" />
 *       &lt;attribute name="MAC" use="required" type="{}MACType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthenticatedDataType", propOrder = {
    "keyTransportOrKEK",
    "macAlgorithm",
    "encapsulatedContent"
})
public class AuthenticatedDataType {

    @XmlElements({
        @XmlElement(name = "KeyTransport", type = KeyTransportType.class),
        @XmlElement(name = "KEK", type = KEKType.class)
    })
    protected List<Object> keyTransportOrKEK;
    @XmlElement(name = "MACAlgorithm", required = true)
    protected AlgorithmIdentifier macAlgorithm;
    @XmlElement(name = "EncapsulatedContent", required = true)
    protected EncapsulatedContentType encapsulatedContent;
    @XmlAttribute(name = "Version")
    protected String version;
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
