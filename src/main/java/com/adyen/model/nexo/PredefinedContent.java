package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Reference of a predefined messageType to display or print. -- Usage: It conveys Information related to the predefined messageType
 *
 * <p>Java class for PredefinedContent complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PredefinedContent"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="ReferenceID" use="required" type="{}ReferenceID" /&gt;
 *       &lt;attribute name="Language" type="{}ISOLanguage2A" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PredefinedContent")
public class PredefinedContent {

    /**
     * The Reference id.
     */
    @XmlElement(name = "ReferenceID", required = true)
    @Schema(description = "Identification of a predefined message to display, print or play.")
    protected String referenceID;
    /**
     * The Language.
     */
    @XmlElement(name = "Language")
    @Schema(description = "Identification of a language.")
    protected String language;

    /**
     * Gets the value of the referenceID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getReferenceID() {
        return referenceID;
    }

    /**
     * Sets the value of the referenceID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setReferenceID(String value) {
        this.referenceID = value;
    }

    /**
     * Gets the value of the language property.
     *
     * @return possible      object is     {@link String }
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setLanguage(String value) {
        this.language = value;
    }

}
