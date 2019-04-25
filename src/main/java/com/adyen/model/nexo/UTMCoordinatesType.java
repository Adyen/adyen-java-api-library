
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Location on the Earth specified by the Universal Transverse Mercator coordinate system. -- Usage: Identifies the geographic location of a mobile phone by GPS using the WGS84 ellipsoid spatial reference system.
 * 
 * <p>Java class for UTMCoordinatesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UTMCoordinatesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UTMZone" type="{}UTMZoneType"/>
 *         &lt;element name="UTMEastward" type="{}UTMEastwardType"/>
 *         &lt;element name="UTMNorthward" type="{}UTMNorthwardType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UTMCoordinatesType", propOrder = {
    "utmZone",
    "utmEastward",
    "utmNorthward"
})
public class UTMCoordinatesType {

    @XmlElement(name = "UTMZone", required = true)
    protected String utmZone;
    @XmlElement(name = "UTMEastward", required = true)
    protected String utmEastward;
    @XmlElement(name = "UTMNorthward", required = true)
    protected String utmNorthward;

    /**
     * Gets the value of the utmZone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUTMZone() {
        return utmZone;
    }

    /**
     * Sets the value of the utmZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUTMZone(String value) {
        this.utmZone = value;
    }

    /**
     * Gets the value of the utmEastward property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUTMEastward() {
        return utmEastward;
    }

    /**
     * Sets the value of the utmEastward property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUTMEastward(String value) {
        this.utmEastward = value;
    }

    /**
     * Gets the value of the utmNorthward property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUTMNorthward() {
        return utmNorthward;
    }

    /**
     * Sets the value of the utmNorthward property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUTMNorthward(String value) {
        this.utmNorthward = value;
    }

}
