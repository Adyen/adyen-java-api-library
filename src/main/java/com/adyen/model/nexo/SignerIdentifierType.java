
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Cryptographic Message Syntax (CMS) data structure containing the Signer Identifier -- Reference: RFC 3852: Cryptographic Message Syntax (CMS) -- Usage: This data structure contains:  the issuer name (see X.501-88)  the certificate serial number (see X.509-97)
 * 
 * <p>Java class for SignerIdentifierType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SignerIdentifierType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IssuerAndSerialNumber" type="{}IssuerAndSerialNumberType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignerIdentifierType", propOrder = {
    "issuerAndSerialNumber"
})
public class SignerIdentifierType {

    @XmlElement(name = "IssuerAndSerialNumber", required = true)
    protected IssuerAndSerialNumberType issuerAndSerialNumber;

    /**
     * Gets the value of the issuerAndSerialNumber property.
     * 
     * @return
     *     possible object is
     *     {@link IssuerAndSerialNumberType }
     *     
     */
    public IssuerAndSerialNumberType getIssuerAndSerialNumber() {
        return issuerAndSerialNumber;
    }

    /**
     * Sets the value of the issuerAndSerialNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link IssuerAndSerialNumberType }
     *     
     */
    public void setIssuerAndSerialNumber(IssuerAndSerialNumberType value) {
        this.issuerAndSerialNumber = value;
    }

}
