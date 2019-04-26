
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
 * <p>Java class for POITerminalData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="POITerminalData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="POICapabilities" type="{}POICapabilities"/>
 *         &lt;element name="POIProfile" type="{}POIProfile" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="TerminalEnvironment" use="required" type="{}TerminalEnvironmentType" />
 *       &lt;attribute name="POISerialNumber" use="required" type="{}POISerialNumber" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POITerminalData", propOrder = {
    "poiCapabilities",
    "poiProfile"
})
public class POITerminalData {

    @XmlList
    @XmlElement(name = "POICapabilities", required = true)
    protected List<POICapabilitiesType> poiCapabilities;
    @XmlElement(name = "POIProfile")
    protected POIProfile poiProfile;
    @XmlAttribute(name = "TerminalEnvironment", required = true)
    protected TerminalEnvironmentType terminalEnvironment;
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
     * {@link POICapabilitiesType }
     *
     *
     */
    public List<POICapabilitiesType> getPOICapabilities() {
        if (poiCapabilities == null) {
            poiCapabilities = new ArrayList<POICapabilitiesType>();
        }
        return this.poiCapabilities;
    }

    /**
     * Gets the value of the poiProfile property.
     *
     * @return
     *     possible object is
     *     {@link POIProfile }
     *
     */
    public POIProfile getPOIProfile() {
        return poiProfile;
    }

    /**
     * Sets the value of the poiProfile property.
     *
     * @param value
     *     allowed object is
     *     {@link POIProfile }
     *
     */
    public void setPOIProfile(POIProfile value) {
        this.poiProfile = value;
    }

    /**
     * Gets the value of the terminalEnvironment property.
     *
     * @return
     *     possible object is
     *     {@link TerminalEnvironmentType }
     *
     */
    public TerminalEnvironmentType getTerminalEnvironment() {
        return terminalEnvironment;
    }

    /**
     * Sets the value of the terminalEnvironment property.
     *
     * @param value
     *     allowed object is
     *     {@link TerminalEnvironmentType }
     *
     */
    public void setTerminalEnvironment(TerminalEnvironmentType value) {
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
