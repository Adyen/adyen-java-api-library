
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Information related to the software and hardware feature of the POI Terminal -- Usage: Allows in a session to identify the features of the POI Terminal attached to a Sale Terminal per a Login Request message.
 * 
 * <p>Java class for POITerminalDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="POITerminalDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="POICapabilities" type="{}POICapabilitiesType"/>
 *         &lt;element name="POIProfile" type="{}POIProfileType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="TerminalEnvironment" use="required" type="{}TerminalEnvironmentTypeCode" />
 *       &lt;attribute name="POISerialNumber" use="required" type="{}POISerialNumberType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POITerminalDataType", propOrder = {
    "poiCapabilities",
    "poiProfile"
})
public class POITerminalDataType {

    @XmlList
    @XmlElement(name = "POICapabilities", required = true)
    protected List<String> poiCapabilities;
    @XmlElement(name = "POIProfile")
    protected POIProfileType poiProfile;
    @XmlAttribute(name = "TerminalEnvironment", required = true)
    protected String terminalEnvironment;
    @XmlAttribute(name = "POISerialNumber", required = true)
    protected String poiSerialNumber;

    /**
     * Gets the value of the poiCapabilities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the poiCapabilities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPOICapabilities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPOICapabilities() {
        if (poiCapabilities == null) {
            poiCapabilities = new ArrayList<String>();
        }
        return this.poiCapabilities;
    }

    /**
     * Gets the value of the poiProfile property.
     * 
     * @return
     *     possible object is
     *     {@link POIProfileType }
     *     
     */
    public POIProfileType getPOIProfile() {
        return poiProfile;
    }

    /**
     * Sets the value of the poiProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link POIProfileType }
     *     
     */
    public void setPOIProfile(POIProfileType value) {
        this.poiProfile = value;
    }

    /**
     * Gets the value of the terminalEnvironment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalEnvironment() {
        return terminalEnvironment;
    }

    /**
     * Sets the value of the terminalEnvironment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalEnvironment(String value) {
        this.terminalEnvironment = value;
    }

    /**
     * Gets the value of the poiSerialNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOISerialNumber() {
        return poiSerialNumber;
    }

    /**
     * Sets the value of the poiSerialNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOISerialNumber(String value) {
        this.poiSerialNumber = value;
    }

}
