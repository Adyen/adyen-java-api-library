package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Location on the Earth specified by two numbers representing vertical and horizontal position. -- Usage: Identifies the geographic location of a mobile phone.
 *
 * <p>Java class for GeographicCoordinates complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GeographicCoordinates"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Latitude" type="{}Latitude"/&gt;
 *         &lt;element name="Longitude" type="{}Longitude"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeographicCoordinates", propOrder = {
        "latitude",
        "longitude"
})
public class GeographicCoordinates {

    /**
     * The Latitude.
     */
    @XmlElement(name = "Latitude", required = true)
    @Schema(description = "Angular distance of a location on the earth south or north of the equator.")
    protected String latitude;
    /**
     * The Longitude.
     */
    @XmlElement(name = "Longitude", required = true)
    @Schema(description = "Angular measurement of the distance of a location on the earth east or west of the Greenwich observatory.")
    protected String longitude;

    /**
     * Gets the value of the latitude property.
     *
     * @return possible      object is     {@link String }
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setLatitude(String value) {
        this.latitude = value;
    }

    /**
     * Gets the value of the longitude property.
     *
     * @return possible      object is     {@link String }
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setLongitude(String value) {
        this.longitude = value;
    }

}
