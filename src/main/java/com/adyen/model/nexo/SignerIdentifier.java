package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Cryptographic Message Syntax (CMS) data structure containing the Signer Identifier -- Reference: RFC 3852: Cryptographic Message Syntax (CMS) -- Usage: This data structure contains:  the issuer name (see X.501-88)  the certificate serial number (see X.509-97)
 *
 * <p>Java class for SignerIdentifier complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SignerIdentifier"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IssuerAndSerialNumber" type="{}IssuerAndSerialNumber"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignerIdentifier", propOrder = {
        "issuerAndSerialNumber"
})
public class SignerIdentifier {

    /**
     * The Issuer and serial number.
     */
    @XmlElement(name = "IssuerAndSerialNumber", required = true)
    protected IssuerAndSerialNumber issuerAndSerialNumber;

    /**
     * Gets the value of the issuerAndSerialNumber property.
     *
     * @return possible      object is     {@link IssuerAndSerialNumber }
     */
    public IssuerAndSerialNumber getIssuerAndSerialNumber() {
        return issuerAndSerialNumber;
    }

    /**
     * Sets the value of the issuerAndSerialNumber property.
     *
     * @param value allowed object is     {@link IssuerAndSerialNumber }
     */
    public void setIssuerAndSerialNumber(IssuerAndSerialNumber value) {
        this.issuerAndSerialNumber = value;
    }

}
