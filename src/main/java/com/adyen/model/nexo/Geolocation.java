package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Geographic location specified by geographic or UTM coordinates. -- Usage: Identifies the geographic location of a mobile phone.
 *
 * <p>Java class for Geolocation complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Geolocation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GeographicCoordinates" type="{}GeographicCoordinates" minOccurs="0"/&gt;
 *         &lt;element name="UTMCoordinates" type="{}UTMCoordinates" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Geolocation", propOrder = {
        "geographicCoordinates",
        "utmCoordinates"
})
public class Geolocation {

    /**
     * The Geographic coordinates.
     */
    @XmlElement(name = "GeographicCoordinates")
    @Schema(description = "Location on the Earth specified by two numbers representing vertical and horizontal position.")
    protected GeographicCoordinates geographicCoordinates;
    /**
     * The Utm coordinates.
     */
    @XmlElement(name = "UTMCoordinates")
    @Schema(description = "Location on the Earth specified by the Universal Transverse Mercator coordinate system.")
    protected UTMCoordinates utmCoordinates;

    /**
     * Gets the value of the geographicCoordinates property.
     *
     * @return possible      object is     {@link GeographicCoordinates }
     */
    public GeographicCoordinates getGeographicCoordinates() {
        return geographicCoordinates;
    }

    /**
     * Sets the value of the geographicCoordinates property.
     *
     * @param value allowed object is     {@link GeographicCoordinates }
     */
    public void setGeographicCoordinates(GeographicCoordinates value) {
        this.geographicCoordinates = value;
    }

    /**
     * Gets the value of the utmCoordinates property.
     *
     * @return possible      object is     {@link UTMCoordinates }
     */
    public UTMCoordinates getUTMCoordinates() {
        return utmCoordinates;
    }

    /**
     * Sets the value of the utmCoordinates property.
     *
     * @param value allowed object is     {@link UTMCoordinates }
     */
    public void setUTMCoordinates(UTMCoordinates value) {
        this.utmCoordinates = value;
    }

}
