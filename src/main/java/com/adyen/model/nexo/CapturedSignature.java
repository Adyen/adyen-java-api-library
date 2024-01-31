package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Numeric value of a handwritten signature. -- Usage: Contain the value of a handwritten signature, e.g. the signature of a cardholder on the merchant payment receipt. Only one format of the signature is allowed, it contains:  The size of the pad area where the signature is written, given
 *
 * <p>Java class for CapturedSignature complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CapturedSignature"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AreaSize" type="{}AreaSize" minOccurs="0"/&gt;
 *         &lt;element name="SignaturePoint" type="{}SignaturePoint" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CapturedSignature", propOrder = {
        "areaSize",
        "signaturePoint"
})
public class CapturedSignature {

    /**
     * The Area size.
     */
    @XmlElement(name = "AreaSize")
    @Schema(description = "Size of an area")
    protected AreaSize areaSize;
    /**
     * The Signature point.
     */
    @XmlElement(name = "SignaturePoint", required = true)
    @Schema(description = "Coordinates of a point where the pen changes direction or lift.")
    protected List<SignaturePoint> signaturePoint;

    /**
     * Gets the value of the areaSize property.
     *
     * @return possible      object is     {@link AreaSize }
     */
    public AreaSize getAreaSize() {
        return areaSize;
    }

    /**
     * Sets the value of the areaSize property.
     *
     * @param value allowed object is     {@link AreaSize }
     */
    public void setAreaSize(AreaSize value) {
        this.areaSize = value;
    }

    /**
     * Gets the value of the signaturePoint property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signaturePoint property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignaturePoint().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SignaturePoint }
     *
     * @return the signature point
     */
    public List<SignaturePoint> getSignaturePoint() {
        if (signaturePoint == null) {
            signaturePoint = new ArrayList<>();
        }
        return this.signaturePoint;
    }

}
