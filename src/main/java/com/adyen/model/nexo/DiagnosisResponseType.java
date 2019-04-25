
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Diagnosis Response message. -- Usage: It conveys the result of the requested diagnosis and a possible message to display on a logical device.
 * 
 * <p>Java class for DiagnosisResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DiagnosisResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}ResponseType"/>
 *         &lt;element name="LoggedSaleID" type="{}LoggedSaleIDType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="POIStatus" type="{}POIStatusType" minOccurs="0"/>
 *         &lt;element name="HostStatus" type="{}HostStatusType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DiagnosisResponseType", propOrder = {
    "response",
    "loggedSaleID",
    "poiStatus",
    "hostStatus"
})
public class DiagnosisResponseType {

    @XmlElement(name = "Response", required = true)
    protected ResponseType response;
    @XmlElement(name = "LoggedSaleID")
    protected List<String> loggedSaleID;
    @XmlElement(name = "POIStatus")
    protected POIStatusType poiStatus;
    @XmlElement(name = "HostStatus")
    protected List<HostStatusType> hostStatus;

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseType }
     *     
     */
    public ResponseType getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseType }
     *     
     */
    public void setResponse(ResponseType value) {
        this.response = value;
    }

    /**
     * Gets the value of the loggedSaleID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loggedSaleID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoggedSaleID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLoggedSaleID() {
        if (loggedSaleID == null) {
            loggedSaleID = new ArrayList<String>();
        }
        return this.loggedSaleID;
    }

    /**
     * Gets the value of the poiStatus property.
     * 
     * @return
     *     possible object is
     *     {@link POIStatusType }
     *     
     */
    public POIStatusType getPOIStatus() {
        return poiStatus;
    }

    /**
     * Sets the value of the poiStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link POIStatusType }
     *     
     */
    public void setPOIStatus(POIStatusType value) {
        this.poiStatus = value;
    }

    /**
     * Gets the value of the hostStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostStatusType }
     * 
     * 
     */
    public List<HostStatusType> getHostStatus() {
        if (hostStatus == null) {
            hostStatus = new ArrayList<HostStatusType>();
        }
        return this.hostStatus;
    }

}
