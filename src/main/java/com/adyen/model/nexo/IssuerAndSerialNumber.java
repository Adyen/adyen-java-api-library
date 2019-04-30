package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;


/**
 * Definition: Cryptographic Message Syntax (CMS) data structure containing the issuer name and certificate serial number  -- Reference: RFC 3852: Cryptographic Message Syntax (CMS) -- Usage: This data structure contains:  the issuer name (see X.501-88)  the certificate serial number (see X.509-97) This the value of input parameter sid.
 *
 * <p>Java class for IssuerAndSerialNumber complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="IssuerAndSerialNumber"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Issuer" type="{}Issuer"/&gt;
 *         &lt;element name="SerialNumber" type="{}SerialNumber"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IssuerAndSerialNumber", propOrder = {
        "issuer",
        "serialNumber"
})
public class IssuerAndSerialNumber {

    /**
     * The Issuer.
     */
    @XmlElement(name = "Issuer", required = true)
    protected Issuer issuer;
    /**
     * The Serial number.
     */
    @XmlElement(name = "SerialNumber", required = true)
    protected BigInteger serialNumber;

    /**
     * Gets the value of the issuer property.
     *
     * @return possible      object is     {@link Issuer }
     */
    public Issuer getIssuer() {
        return issuer;
    }

    /**
     * Sets the value of the issuer property.
     *
     * @param value allowed object is     {@link Issuer }
     */
    public void setIssuer(Issuer value) {
        this.issuer = value;
    }

    /**
     * Gets the value of the serialNumber property.
     *
     * @return possible      object is     {@link BigInteger }
     */
    public BigInteger getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the value of the serialNumber property.
     *
     * @param value allowed object is     {@link BigInteger }
     */
    public void setSerialNumber(BigInteger value) {
        this.serialNumber = value;
    }

}
