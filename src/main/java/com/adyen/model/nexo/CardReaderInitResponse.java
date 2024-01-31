package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Content of the Card Reader Init Response messageType. -- Usage: It contains the result of the Card Reader by the POI Card Reader (magnetic stripe content, or chip initialisation data).
 *
 * <p>Java class for CardReaderInitResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CardReaderInitResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response" type="{}Response"/&gt;
 *         &lt;element name="TrackData" type="{}TrackData" maxOccurs="4" minOccurs="0"/&gt;
 *         &lt;element name="ICCResetData" type="{}ICCResetData" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="EntryMode" type="{}EntryMode" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardReaderInitResponse", propOrder = {
        "response",
        "trackData",
        "iccResetData"
})
public class CardReaderInitResponse {

    /**
     * The Response.
     */
    @XmlElement(name = "Response", required = true)
    @Schema(description = "Result of a message request processing.")
    protected Response response;
    /**
     * The Track data.
     */
    @XmlElement(name = "TrackData")
    @Schema(description = "Magnetic track or magnetic ink characters line. --Rule: if EntryMode is RFID or MagStripe")
    protected List<TrackData> trackData;
    /**
     * The Icc reset data.
     */
    @XmlElement(name = "ICCResetData")
    @Schema(description = "Data of a Chip Card related to the reset of the chip. --Rule: if EntryMode is ICC, EMVContactless or SynchronousICC")
    protected ICCResetData iccResetData;
    /**
     * The Entry mode.
     */
    @XmlElement(name = "EntryMode")
    @Schema(description = "Entry mode of the payment instrument information --Rule: RFID, MagStripe, ICC, EMVContactless or SynchronousICC")
    protected List<EntryModeType> entryMode;

    /**
     * Gets the value of the response property.
     *
     * @return possible      object is     {@link Response }
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     *
     * @param value allowed object is     {@link Response }
     */
    public void setResponse(Response value) {
        this.response = value;
    }

    /**
     * Gets the value of the trackData property.
     * <p>
     * <p>
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trackData property.
     * <p>
     * <p>
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrackData().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrackData }
     *
     * @return the track data
     */
    public List<TrackData> getTrackData() {
        if (trackData == null) {
            trackData = new ArrayList<>();
        }
        return this.trackData;
    }

    /**
     * Gets the value of the iccResetData property.
     *
     * @return possible      object is     {@link ICCResetData }
     */
    public ICCResetData getICCResetData() {
        return iccResetData;
    }

    /**
     * Sets the value of the iccResetData property.
     *
     * @param value allowed object is     {@link ICCResetData }
     */
    public void setICCResetData(ICCResetData value) {
        this.iccResetData = value;
    }

    /**
     * Gets the value of the entryMode property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entryMode property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntryMode().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntryModeType }
     *
     * @return the entry mode
     */
    public List<EntryModeType> getEntryMode() {
        if (entryMode == null) {
            entryMode = new ArrayList<>();
        }
        return this.entryMode;
    }

}
