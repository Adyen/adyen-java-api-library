package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Sensitive information related to the payment card, entered or read by the Sale System. -- Usage: This data structure could be CMS protected (EnvelopedData). In this case the data structure SensitiveCardData is replaced by the data structure ProtectedCardData of type ContentInformationType. When this data is protected, the exact
 *
 * <p>Java class for SensitiveCardData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SensitiveCardData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TrackData" type="{}TrackData" maxOccurs="4" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="PAN" type="{}PAN" /&gt;
 *       &lt;attribute name="CardSeqNumb" type="{}CardSeqNumb" /&gt;
 *       &lt;attribute name="ExpiryDate" type="{}ExpiryDate" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SensitiveCardData", propOrder = {
        "trackData"
})
public class SensitiveCardData {

    /**
     * The Track data.
     */
    @XmlElement(name = "TrackData")
    @Schema(description = "Magnetic track or magnetic ink characters line. --Rule: if EntryMode is MagStripe or RFID ")
    protected List<TrackData> trackData;
    /**
     * The Pan.
     */
    @XmlElement(name = "PAN")
    @Schema(description = "Primary Account Number --Rule:  ", minLength = 8, maxLength = 28)
    protected String pan;
    /**
     * The Card seq numb.
     */
    @XmlElement(name = "CardSeqNumb")
    @Schema(description = "Card Sequence Number --Rule: if EntryMode is File, Keyed or Manual", minLength = 2, maxLength = 3)
    protected String cardSeqNumb;
    /**
     * The Expiry date.
     */
    @XmlElement(name = "ExpiryDate")
    @Schema(description = "Date after which the card cannot be used. --Rule: if EntryMode is File", minLength = 4, maxLength = 4)
    protected String expiryDate;

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
     * Gets the value of the pan property.
     *
     * @return possible      object is     {@link String }
     */
    public String getPAN() {
        return pan;
    }

    /**
     * Sets the value of the pan property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setPAN(String value) {
        this.pan = value;
    }

    /**
     * Gets the value of the cardSeqNumb property.
     *
     * @return possible      object is     {@link String }
     */
    public String getCardSeqNumb() {
        return cardSeqNumb;
    }

    /**
     * Sets the value of the cardSeqNumb property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setCardSeqNumb(String value) {
        this.cardSeqNumb = value;
    }

    /**
     * Gets the value of the expiryDate property.
     *
     * @return possible      object is     {@link String }
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the value of the expiryDate property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setExpiryDate(String value) {
        this.expiryDate = value;
    }

}
