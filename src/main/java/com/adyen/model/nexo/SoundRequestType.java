
package com.adyen.model.nexo;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Sound Request message. -- Usage: It conveys the data to start a sound,  stop a sound, or modify the default sound volume. The sound to play may be a preloaded sound or a text to play.
 * 
 * <p>Java class for SoundRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoundRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SoundContent" type="{}SoundContentType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ResponseMode" type="{}ResponseModeTypeCode" default="NotRequired" />
 *       &lt;attribute name="SoundAction" use="required" type="{}SoundActionTypeCode" />
 *       &lt;attribute name="SoundVolume" type="{}SoundVolumeType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoundRequestType", propOrder = {
    "soundContent"
})
public class SoundRequestType {

    @XmlElement(name = "SoundContent", required = true)
    protected SoundContentType soundContent;
    @XmlAttribute(name = "ResponseMode")
    protected String responseMode;
    @XmlAttribute(name = "SoundAction", required = true)
    protected String soundAction;
    @XmlAttribute(name = "SoundVolume")
    protected BigInteger soundVolume;

    /**
     * Gets the value of the soundContent property.
     * 
     * @return
     *     possible object is
     *     {@link SoundContentType }
     *     
     */
    public SoundContentType getSoundContent() {
        return soundContent;
    }

    /**
     * Sets the value of the soundContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoundContentType }
     *     
     */
    public void setSoundContent(SoundContentType value) {
        this.soundContent = value;
    }

    /**
     * Gets the value of the responseMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseMode() {
        if (responseMode == null) {
            return "NotRequired";
        } else {
            return responseMode;
        }
    }

    /**
     * Sets the value of the responseMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseMode(String value) {
        this.responseMode = value;
    }

    /**
     * Gets the value of the soundAction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoundAction() {
        return soundAction;
    }

    /**
     * Sets the value of the soundAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoundAction(String value) {
        this.soundAction = value;
    }

    /**
     * Gets the value of the soundVolume property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSoundVolume() {
        return soundVolume;
    }

    /**
     * Sets the value of the soundVolume property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSoundVolume(BigInteger value) {
        this.soundVolume = value;
    }

}
