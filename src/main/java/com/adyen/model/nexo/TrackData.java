package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Magnetic track or magnetic ink characters line. -- Reference: ISO 7813 - ISO 4909 -- Usage: Generic data structure for a card track, used when the magstripe card reader is located on the Sale Terminal, or for magstripe Card Reader device request. The data structure is also used to store the line at the bottom of a bank check
 *
 * <p>Java class for TrackData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TrackData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="TrackValue" type="{}TrackValue" /&gt;
 *       &lt;attribute name="TrackNumb" type="{}TrackNumb" default="2" /&gt;
 *       &lt;attribute name="TrackFormat" type="{}TrackFormatType" default="ISO" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackData")
public class TrackData {

    @XmlElement(name = "TrackValue")
    @Schema(description = "Card track content", minLength = 1, maxLength = 104)
    protected String trackValue;
    @XmlElement(name = "TrackNumb")
    @Schema(description = "Card track number")
    protected Integer trackNumb;
    @XmlElement(name = "TrackFormat")
    @Schema(description = "Card track format")
    protected TrackFormatType trackFormat;

    /**
     * Gets the value of the trackValue property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTrackValue() {
        return trackValue;
    }

    /**
     * Sets the value of the trackValue property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTrackValue(String value) {
        this.trackValue = value;
    }

    /**
     * Gets the value of the trackNumb property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public int getTrackNumb() {
        if (trackNumb == null) {
            return 2;
        } else {
            return trackNumb;
        }
    }

    /**
     * Sets the value of the trackNumb property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setTrackNumb(Integer value) {
        this.trackNumb = value;
    }

    /**
     * Gets the value of the trackFormat property.
     *
     * @return possible object is
     * {@link TrackFormatType }
     */
    public TrackFormatType getTrackFormat() {
        if (trackFormat == null) {
            return TrackFormatType.ISO;
        } else {
            return trackFormat;
        }
    }

    /**
     * Sets the value of the trackFormat property.
     *
     * @param value allowed object is
     *              {@link TrackFormatType }
     */
    public void setTrackFormat(TrackFormatType value) {
        this.trackFormat = value;
    }

}
