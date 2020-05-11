package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Content of the Diagnosis Request messageType. -- Usage: It conveys Information related to the target POI for which the diagnosis is requested
 *
 * <p>Java class for DiagnosisRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DiagnosisRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AcquirerID" type="{}AcquirerID" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="POIID" type="{}POIID" /&gt;
 *       &lt;attribute name="HostDiagnosisFlag" type="{}HostDiagnosisFlag" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DiagnosisRequest", propOrder = {
        "acquirerID"
})
public class DiagnosisRequest {

    /**
     * The Acquirer id.
     */
    @XmlElement(name = "AcquirerID")
    protected List<String> acquirerID;
    /**
     * The Poiid.
     */
    @XmlAttribute(name = "POIID")
    protected String poiid;
    /**
     * The Host diagnosis flag.
     */
    @XmlAttribute(name = "HostDiagnosisFlag")
    protected Boolean hostDiagnosisFlag;

    /**
     * Gets the value of the acquirerID property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acquirerID property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcquirerID().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     * @return the acquirer id
     */
    public List<String> getAcquirerID() {
        if (acquirerID == null) {
            acquirerID = new ArrayList<>();
        }
        return this.acquirerID;
    }

    /**
     * Gets the value of the poiid property.
     *
     * @return possible      object is     {@link String }
     */
    public String getPOIID() {
        return poiid;
    }

    /**
     * Sets the value of the poiid property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setPOIID(String value) {
        this.poiid = value;
    }

    /**
     * Gets the value of the hostDiagnosisFlag property.
     *
     * @return possible      object is     {@link Boolean }
     */
    public boolean isHostDiagnosisFlag() {
        if (hostDiagnosisFlag == null) {
            return false;
        } else {
            return hostDiagnosisFlag;
        }
    }

    /**
     * Sets the value of the hostDiagnosisFlag property.
     *
     * @param value allowed object is     {@link Boolean }
     */
    public void setHostDiagnosisFlag(Boolean value) {
        this.hostDiagnosisFlag = value;
    }

}
