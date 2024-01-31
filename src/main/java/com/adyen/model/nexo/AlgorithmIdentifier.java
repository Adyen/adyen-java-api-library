package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Identification of a cryptographic algorithm -- Reference: RFC 3880: Internet X.509 Public Key Infrastructure Certificate and Certificate -- Usage: This data structure contains:  the algorithm identifier  associated parameters
 *
 * <p>Java class for AlgorithmIdentifier complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AlgorithmIdentifier"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Parameter" type="{}Parameter" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Algorithm" use="required" type="{}AlgorithmType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlgorithmIdentifier", propOrder = {
        "parameter"
})
public class AlgorithmIdentifier {

    /**
     * The Parameter.
     */
    @XmlElement(name = "Parameter")
    protected Parameter parameter;
    /**
     * The Algorithm.
     */
    @XmlElement(name = "Algorithm", required = true)
    protected AlgorithmType algorithm;

    /**
     * Gets the value of the parameter property.
     *
     * @return possible      object is     {@link Parameter }
     */
    public Parameter getParameter() {
        return parameter;
    }

    /**
     * Sets the value of the parameter property.
     *
     * @param value allowed object is     {@link Parameter }
     */
    public void setParameter(Parameter value) {
        this.parameter = value;
    }

    /**
     * Gets the value of the algorithm property.
     *
     * @return possible      object is     {@link AlgorithmType }
     */
    public AlgorithmType getAlgorithm() {
        return algorithm;
    }

    /**
     * Sets the value of the algorithm property.
     *
     * @param value allowed object is     {@link AlgorithmType }
     */
    public void setAlgorithm(AlgorithmType value) {
        this.algorithm = value;
    }

}
