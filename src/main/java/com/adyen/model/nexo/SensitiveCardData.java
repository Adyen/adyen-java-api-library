
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Sensitive information related to the payment card, entered or read by the Sale System. -- Usage: This data structure could be CMS protected (EnvelopedData). In this case the data structure SensitiveCardData is replaced by the data structure ProtectedCardData of type ContentInformationType. When this data is protected, the exact
 *
 * <p>Java class for SensitiveCardData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SensitiveCardData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TrackData" type="{}TrackData" maxOccurs="4" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="PAN" type="{}PAN" />
 *       &lt;attribute name="CardSeqNumb" type="{}CardSeqNumb" />
 *       &lt;attribute name="ExpiryDate" type="{}ExpiryDate" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SensitiveCardData", propOrder = {
    "trackData"
})
public class SensitiveCardData {

    @XmlElement(name = "TrackData")
    protected List<TrackData> trackData;
    @XmlAttribute(name = "PAN")
    protected String pan;
    @XmlAttribute(name = "CardSeqNumb")
    protected String cardSeqNumb;
    @XmlAttribute(name = "ExpiryDate")
    protected String expiryDate;

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
     * Gets the value of the pan property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPAN() {
        return pan;
    }

    /**
     * Sets the value of the pan property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPAN(String value) {
        this.pan = value;
    }

    /**
     * Gets the value of the cardSeqNumb property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCardSeqNumb() {
        return cardSeqNumb;
    }

    /**
     * Sets the value of the cardSeqNumb property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCardSeqNumb(String value) {
        this.cardSeqNumb = value;
    }

    /**
     * Gets the value of the expiryDate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the value of the expiryDate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setExpiryDate(String value) {
        this.expiryDate = value;
    }

}
