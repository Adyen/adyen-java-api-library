
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Diagnosis Request message. -- Usage: It conveys Information related to the target POI for which the diagnosis is requested
 * 
 * <p>Java class for DiagnosisRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DiagnosisRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AcquirerID" type="{}AcquirerIDType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="POIID" type="{}POIIDType" />
 *       &lt;attribute name="HostDiagnosisFlag" type="{}HostDiagnosisFlagType" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DiagnosisRequestType", propOrder = {
    "acquirerID"
})
public class DiagnosisRequestType {

    @XmlElement(name = "AcquirerID")
    protected List<String> acquirerID;
    @XmlAttribute(name = "POIID")
    protected String poiid;
    @XmlAttribute(name = "HostDiagnosisFlag")
    protected Boolean hostDiagnosisFlag;

    /**
     * Gets the value of the acquirerID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acquirerID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcquirerID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAcquirerID() {
        if (acquirerID == null) {
            acquirerID = new ArrayList<String>();
        }
        return this.acquirerID;
    }

    /**
     * Gets the value of the poiid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOIID() {
        return poiid;
    }

    /**
     * Sets the value of the poiid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOIID(String value) {
        this.poiid = value;
    }

    /**
     * Gets the value of the hostDiagnosisFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
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
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHostDiagnosisFlag(Boolean value) {
        this.hostDiagnosisFlag = value;
    }

}
