package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
    @Schema(description = "Identification of the Acquirer --Rule: Present if requesting the diagnosis of these hosts only.")
    protected List<String> acquirerID;
    /**
     * The Poiid.
     */
    @XmlElement(name = "POIID")
    @Schema(description = "Identification of a POI System or a POI Terminal for the Sale to POI protocol --Rule: MessageHeader.POIID")
    protected String poiid;
    /**
     * The Host diagnosis flag.
     */
    @XmlElement(name = "HostDiagnosisFlag")
    @Schema(description = "Indicates if Host Diagnosis are required")
    protected Boolean hostDiagnosisFlag;

    /**
     * Gets the value of the acquirerID property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acquirerID property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcquirerID().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
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
