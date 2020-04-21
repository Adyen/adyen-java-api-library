package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Sound to play.
 *
 * <p>Java class for SoundContent complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SoundContent"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="SoundFormat" type="{}SoundFormatType" /&gt;
 *       &lt;attribute name="Language" type="{}ISOLanguage2A" /&gt;
 *       &lt;attribute name="ReferenceID" type="{}ReferenceID" /&gt;
 *       &lt;attribute name="Text" type="{}Text" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoundContent")
public class SoundContent {

    @XmlAttribute(name = "SoundFormat")
    protected SoundFormatType soundFormat;
    @XmlAttribute(name = "Language")
    protected String language;
    @XmlAttribute(name = "ReferenceID")
    protected String referenceID;
    @XmlAttribute(name = "Text")
    protected String text;

    /**
     * Gets the value of the soundFormat property.
     *
     * @return possible object is
     * {@link SoundFormatType }
     */
    public SoundFormatType getSoundFormat() {
        return soundFormat;
    }

    /**
     * Sets the value of the soundFormat property.
     *
     * @param value allowed object is
     *              {@link SoundFormatType }
     */
    public void setSoundFormat(SoundFormatType value) {
        this.soundFormat = value;
    }

    /**
     * Gets the value of the language property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the referenceID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getReferenceID() {
        return referenceID;
    }

    /**
     * Sets the value of the referenceID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setReferenceID(String value) {
        this.referenceID = value;
    }

    /**
     * Gets the value of the text property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setText(String value) {
        this.text = value;
    }

}
