
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Parameters associated to a cryptographic algorithm -- Reference: RFC 3880: Internet X.509 Public Key Infrastructure Certificate and Certificate
 * 
 * <p>Java class for ParameterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParameterType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="InitialisationVector" type="{}InitialisationVectorType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParameterType")
public class ParameterType {

    @XmlAttribute(name = "InitialisationVector")
    protected byte[] initialisationVector;

    /**
     * Gets the value of the initialisationVector property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getInitialisationVector() {
        return initialisationVector;
    }

    /**
     * Sets the value of the initialisationVector property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setInitialisationVector(byte[] value) {
        this.initialisationVector = value;
    }

}
