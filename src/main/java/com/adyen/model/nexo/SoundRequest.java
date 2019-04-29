
package com.adyen.model.nexo;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Sound Request messageType. -- Usage: It conveys the data to start a sound,  stop a sound, or modify the default sound volume. The sound to play may be a preloaded sound or a text to play.
 *
 * <p>Java class for SoundRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SoundRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SoundContent" type="{}SoundContent"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ResponseMode" type="{}ResponseModeType" default="NotRequired" />
 *       &lt;attribute name="SoundAction" use="required" type="{}SoundActionType" />
 *       &lt;attribute name="SoundVolume" type="{}SoundVolume" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoundRequest", propOrder = {
    "soundContent"
})
public class SoundRequest {

    @XmlElement(name = "SoundContent", required = true)
    protected SoundContent soundContent;
    @XmlAttribute(name = "ResponseMode")
    protected ResponseModeType responseMode;
    @XmlAttribute(name = "SoundAction", required = true)
    protected SoundActionType soundAction;
    @XmlAttribute(name = "SoundVolume")
    protected BigInteger soundVolume;

    /**
     * Gets the value of the soundContent property.
     *
     * @return
     *     possible object is
     *     {@link SoundContent }
     *
     */
    public SoundContent getSoundContent() {
        return soundContent;
    }

    /**
     * Sets the value of the soundContent property.
     *
     * @param value
     *     allowed object is
     *     {@link SoundContent }
     *
     */
    public void setSoundContent(SoundContent value) {
        this.soundContent = value;
    }

    /**
     * Gets the value of the responseMode property.
     *
     * @return
     *     possible object is
     *     {@link ResponseModeType }
     *
     */
    public ResponseModeType getResponseMode() {
        if (responseMode == null) {
            return ResponseModeType.NOT_REQUIRED;
        } else {
            return responseMode;
        }
    }

    /**
     * Sets the value of the responseMode property.
     *
     * @param value
     *     allowed object is
     *     {@link ResponseModeType }
     *
     */
    public void setResponseMode(ResponseModeType value) {
        this.responseMode = value;
    }

    /**
     * Gets the value of the soundAction property.
     *
     * @return
     *     possible object is
     *     {@link SoundActionType }
     *
     */
    public SoundActionType getSoundAction() {
        return soundAction;
    }

    /**
     * Sets the value of the soundAction property.
     *
     * @param value
     *     allowed object is
     *     {@link SoundActionType }
     *
     */
    public void setSoundAction(SoundActionType value) {
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
