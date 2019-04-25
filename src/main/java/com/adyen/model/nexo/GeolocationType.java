
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Geographic location specified by geographic or UTM coordinates. -- Usage: Identifies the geographic location of a mobile phone.
 * 
 * <p>Java class for GeolocationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeolocationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GeographicCoordinates" type="{}GeographicCoordinatesType" minOccurs="0"/>
 *         &lt;element name="UTMCoordinates" type="{}UTMCoordinatesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeolocationType", propOrder = {
    "geographicCoordinates",
    "utmCoordinates"
})
public class GeolocationType {

    @XmlElement(name = "GeographicCoordinates")
    protected GeographicCoordinatesType geographicCoordinates;
    @XmlElement(name = "UTMCoordinates")
    protected UTMCoordinatesType utmCoordinates;

    /**
     * Gets the value of the geographicCoordinates property.
     * 
     * @return
     *     possible object is
     *     {@link GeographicCoordinatesType }
     *     
     */
    public GeographicCoordinatesType getGeographicCoordinates() {
        return geographicCoordinates;
    }

    /**
     * Sets the value of the geographicCoordinates property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeographicCoordinatesType }
     *     
     */
    public void setGeographicCoordinates(GeographicCoordinatesType value) {
        this.geographicCoordinates = value;
    }

    /**
     * Gets the value of the utmCoordinates property.
     * 
     * @return
     *     possible object is
     *     {@link UTMCoordinatesType }
     *     
     */
    public UTMCoordinatesType getUTMCoordinates() {
        return utmCoordinates;
    }

    /**
     * Sets the value of the utmCoordinates property.
     * 
     * @param value
     *     allowed object is
     *     {@link UTMCoordinatesType }
     *     
     */
    public void setUTMCoordinates(UTMCoordinatesType value) {
        this.utmCoordinates = value;
    }

}
