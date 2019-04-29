
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Card Reader Init Response messageType. -- Usage: It contains the result of the Card Reader by the POI Card Reader (magnetic stripe content, or chip initialisation data).
 *
 * <p>Java class for CardReaderInitResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CardReaderInitResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}Response"/>
 *         &lt;element name="TrackData" type="{}TrackData" maxOccurs="4" minOccurs="0"/>
 *         &lt;element name="ICCResetData" type="{}ICCResetData" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="EntryMode" type="{}EntryMode" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardReaderInitResponse", propOrder = {
    "response",
    "trackData",
    "iccResetData"
})
public class CardReaderInitResponse {

    @XmlElement(name = "Response", required = true)
    protected Response response;
    @XmlElement(name = "TrackData")
    protected List<TrackData> trackData;
    @XmlElement(name = "ICCResetData")
    protected ICCResetData iccResetData;
    @XmlAttribute(name = "EntryMode")
    protected List<EntryModeType> entryMode;

    /**
     * Gets the value of the response property.
     *
     * @return
     *     possible object is
     *     {@link Response }
     *
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     *
     * @param value
     *     allowed object is
     *     {@link Response }
     *
     */
    public void setResponse(Response value) {
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
     * {@link TrackData }
     *
     *
     */
    public List<TrackData> getTrackData() {
        if (trackData == null) {
            trackData = new ArrayList<TrackData>();
        }
        return this.trackData;
    }

    /**
     * Gets the value of the iccResetData property.
     *
     * @return
     *     possible object is
     *     {@link ICCResetData }
     *
     */
    public ICCResetData getICCResetData() {
        return iccResetData;
    }

    /**
     * Sets the value of the iccResetData property.
     *
     * @param value
     *     allowed object is
     *     {@link ICCResetData }
     *
     */
    public void setICCResetData(ICCResetData value) {
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
     * {@link EntryModeType }
     *
     *
     */
    public List<EntryModeType> getEntryMode() {
        if (entryMode == null) {
            entryMode = new ArrayList<EntryModeType>();
        }
        return this.entryMode;
    }

}
