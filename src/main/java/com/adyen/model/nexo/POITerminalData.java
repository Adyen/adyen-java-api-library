package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Information related to the software and hardware feature of the POI Terminal -- Usage: Allows in a session to identify the features of the POI Terminal attached to a Sale Terminal per a Login Request messageType.
 *
 * <p>Java class for POITerminalData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="POITerminalData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="POICapabilities" type="{}POICapabilities"/&gt;
 *         &lt;element name="POIProfile" type="{}POIProfile" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="TerminalEnvironment" use="required" type="{}TerminalEnvironmentType" /&gt;
 *       &lt;attribute name="POISerialNumber" use="required" type="{}POISerialNumber" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POITerminalData", propOrder = {
        "poiCapabilities",
        "poiProfile"
})
public class POITerminalData {

    /**
     * The Poi capabilities.
     */
    @XmlList
    @XmlElement(name = "POICapabilities", required = true)
    @Schema(description = "Hardware capabilities of the POI Terminal.")
    protected List<POICapabilitiesType> poiCapabilities;
    /**
     * The Poi profile.
     */
    @XmlElement(name = "POIProfile")
    @Schema(description = "Functional profile of the POI Terminal. --Rule: If at least one element is present. The Sale System decides if it can continue or not.")
    protected POIProfile poiProfile;
    /**
     * The Terminal environment.
     */
    @XmlElement(name = "TerminalEnvironment", required = true)
    @Schema(description = "Environment of the Terminal.")
    protected TerminalEnvironmentType terminalEnvironment;
    /**
     * The Poi serial number.
     */
    @XmlElement(name = "POISerialNumber", required = true)
    @Schema(description = "Serial number of a POI Terminal")
    protected String poiSerialNumber;

    /**
     * Gets the value of the poiCapabilities property.
     * <p>
     * <p>
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the poiCapabilities property.
     * <p>
     * <p>
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPOICapabilities().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POICapabilitiesType }
     *
     * @return the poi capabilities
     */
    public List<POICapabilitiesType> getPOICapabilities() {
        if (poiCapabilities == null) {
            poiCapabilities = new ArrayList<>();
        }
        return this.poiCapabilities;
    }

    /**
     * Gets the value of the poiProfile property.
     *
     * @return possible      object is     {@link POIProfile }
     */
    public POIProfile getPOIProfile() {
        return poiProfile;
    }

    /**
     * Sets the value of the poiProfile property.
     *
     * @param value allowed object is     {@link POIProfile }
     */
    public void setPOIProfile(POIProfile value) {
        this.poiProfile = value;
    }

    /**
     * Gets the value of the terminalEnvironment property.
     *
     * @return possible      object is     {@link TerminalEnvironmentType }
     */
    public TerminalEnvironmentType getTerminalEnvironment() {
        return terminalEnvironment;
    }

    /**
     * Sets the value of the terminalEnvironment property.
     *
     * @param value allowed object is     {@link TerminalEnvironmentType }
     */
    public void setTerminalEnvironment(TerminalEnvironmentType value) {
        this.terminalEnvironment = value;
    }

    /**
     * Gets the value of the poiSerialNumber property.
     *
     * @return possible      object is     {@link String }
     */
    public String getPOISerialNumber() {
        return poiSerialNumber;
    }

    /**
     * Sets the value of the poiSerialNumber property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setPOISerialNumber(String value) {
        this.poiSerialNumber = value;
    }

}
