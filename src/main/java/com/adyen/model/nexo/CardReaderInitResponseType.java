
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Card Reader Init Response message. -- Usage: It contains the result of the Card Reader by the POI Card Reader (magnetic stripe content, or chip initialisation data).
 * 
 * <p>Java class for CardReaderInitResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardReaderInitResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}ResponseType"/>
 *         &lt;element name="TrackData" type="{}TrackDataType" maxOccurs="4" minOccurs="0"/>
 *         &lt;element name="ICCResetData" type="{}ICCResetDataType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="EntryMode" type="{}EntryModeType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardReaderInitResponseType", propOrder = {
    "response",
    "trackData",
    "iccResetData"
})
public class CardReaderInitResponseType {

    @XmlElement(name = "Response", required = true)
    protected ResponseType response;
    @XmlElement(name = "TrackData")
    protected List<TrackDataType> trackData;
    @XmlElement(name = "ICCResetData")
    protected ICCResetDataType iccResetData;
    @XmlAttribute(name = "EntryMode")
    protected List<String> entryMode;

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
     * Gets the value of the trackData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trackData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrackData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrackDataType }
     * 
     * 
     */
    public List<TrackDataType> getTrackData() {
        if (trackData == null) {
            trackData = new ArrayList<TrackDataType>();
        }
        return this.trackData;
    }

    /**
     * Gets the value of the iccResetData property.
     * 
     * @return
     *     possible object is
     *     {@link ICCResetDataType }
     *     
     */
    public ICCResetDataType getICCResetData() {
        return iccResetData;
    }

    /**
     * Sets the value of the iccResetData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ICCResetDataType }
     *     
     */
    public void setICCResetData(ICCResetDataType value) {
        this.iccResetData = value;
    }

    /**
     * Gets the value of the entryMode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entryMode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntryMode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getEntryMode() {
        if (entryMode == null) {
            entryMode = new ArrayList<String>();
        }
        return this.entryMode;
    }

}
