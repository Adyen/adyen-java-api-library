
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Definition: Content of the Sound to play.
 *
 * <p>Java class for SoundContent complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SoundContent">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;>TextString">
 *       &lt;attribute name="SoundFormat" type="{}SoundFormatType" />
 *       &lt;attribute name="Language" type="{}ISOLanguage2A" />
 *       &lt;attribute name="ReferenceID" type="{}ReferenceID" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoundContent", propOrder = {
    "value"
})
public class SoundContent {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "SoundFormat")
    protected SoundFormatType soundFormat;
    @XmlAttribute(name = "Language")
    protected String language;
    @XmlAttribute(name = "ReferenceID")
    protected String referenceID;

    /**
     * Gets the value of the value property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the soundFormat property.
     *
     * @return
     *     possible object is
     *     {@link SoundFormatType }
     *
     */
    public SoundFormatType getSoundFormat() {
        return soundFormat;
    }

    /**
     * Sets the value of the soundFormat property.
     *
     * @param value
     *     allowed object is
     *     {@link SoundFormatType }
     *
     */
    public void setSoundFormat(SoundFormatType value) {
        this.soundFormat = value;
    }

    /**
     * Gets the value of the language property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the referenceID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReferenceID() {
        return referenceID;
    }

    /**
     * Sets the value of the referenceID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReferenceID(String value) {
        this.referenceID = value;
    }

}
