
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Numeric value of a handwritten signature. -- Usage: Contain the value of a handwritten signature, e.g. the signature of a cardholder on the merchant payment receipt. Only one format of the signature is allowed, it contains:  The size of the pad area where the signature is written, given
 * 
 * <p>Java class for CapturedSignatureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CapturedSignatureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AreaSize" type="{}AreaSizeType" minOccurs="0"/>
 *         &lt;element name="SignaturePoint" type="{}SignaturePointType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CapturedSignatureType", propOrder = {
    "areaSize",
    "signaturePoint"
})
public class CapturedSignatureType {

    @XmlElement(name = "AreaSize")
    protected AreaSizeType areaSize;
    @XmlElement(name = "SignaturePoint", required = true)
    protected List<SignaturePointType> signaturePoint;

    /**
     * Gets the value of the areaSize property.
     * 
     * @return
     *     possible object is
     *     {@link AreaSizeType }
     *     
     */
    public AreaSizeType getAreaSize() {
        return areaSize;
    }

    /**
     * Sets the value of the areaSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link AreaSizeType }
     *     
     */
    public void setAreaSize(AreaSizeType value) {
        this.areaSize = value;
    }

    /**
     * Gets the value of the signaturePoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signaturePoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignaturePoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SignaturePointType }
     * 
     * 
     */
    public List<SignaturePointType> getSignaturePoint() {
        if (signaturePoint == null) {
            signaturePoint = new ArrayList<SignaturePointType>();
        }
        return this.signaturePoint;
    }

}
