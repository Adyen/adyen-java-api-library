package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Parameters associated to a cryptographic algorithm -- Reference: RFC 3880: Internet X.509 Public Key Infrastructure Certificate and Certificate
 *
 * <p>Java class for Parameter complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Parameter"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="InitialisationVector" type="{}InitialisationVector" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Parameter")
public class Parameter {

    /**
     * The Initialisation vector.
     */
    @XmlElement(name = "InitialisationVector")
    protected byte[] initialisationVector;

    /**
     * Gets the value of the initialisationVector property.
     *
     * @return possible      object is     byte[]
     */
    public byte[] getInitialisationVector() {
        return initialisationVector;
    }

    /**
     * Sets the value of the initialisationVector property.
     *
     * @param value allowed object is     byte[]
     */
    public void setInitialisationVector(byte[] value) {
        this.initialisationVector = value;
    }

}
