
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Definition: Content of text message to display or print. -- Usage: It conveys Information related to the content of the text message and its format. All the data elements related to the format of the text to display or print are parameters valid for the whole Text content.
 * 
 * <p>Java class for OutputTextType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OutputTextType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;>TextString">
 *       &lt;attribute name="CharacterSet" type="{}CharacterSetType" />
 *       &lt;attribute name="Font" type="{}FontType" />
 *       &lt;attribute name="StartRow" type="{}StartRowType" />
 *       &lt;attribute name="StartColumn" type="{}StartColumnType" />
 *       &lt;attribute name="Color" type="{}ColorTypeCode" />
 *       &lt;attribute name="CharacterWidth" type="{}CharacterWidthTypeCode" />
 *       &lt;attribute name="CharacterHeight" type="{}CharacterHeightTypeCode" />
 *       &lt;attribute name="CharacterStyle" type="{}CharacterStyleTypeCode" />
 *       &lt;attribute name="Alignment" type="{}AlignmentTypeCode" />
 *       &lt;attribute name="EndOfLineFlag" type="{}EndOfLineFlagType" default="true" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputTextType", propOrder = {
    "value"
})
public class OutputTextType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "CharacterSet")
    protected Integer characterSet;
    @XmlAttribute(name = "Font")
    protected String font;
    @XmlAttribute(name = "StartRow")
    protected Integer startRow;
    @XmlAttribute(name = "StartColumn")
    protected Integer startColumn;
    @XmlAttribute(name = "Color")
    protected String color;
    @XmlAttribute(name = "CharacterWidth")
    protected String characterWidth;
    @XmlAttribute(name = "CharacterHeight")
    protected String characterHeight;
    @XmlAttribute(name = "CharacterStyle")
    protected String characterStyle;
    @XmlAttribute(name = "Alignment")
    protected String alignment;
    @XmlAttribute(name = "EndOfLineFlag")
    protected Boolean endOfLineFlag;

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
     * Gets the value of the characterSet property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCharacterSet() {
        return characterSet;
    }

    /**
     * Sets the value of the characterSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCharacterSet(Integer value) {
        this.characterSet = value;
    }

    /**
     * Gets the value of the font property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFont() {
        return font;
    }

    /**
     * Sets the value of the font property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFont(String value) {
        this.font = value;
    }

    /**
     * Gets the value of the startRow property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStartRow() {
        return startRow;
    }

    /**
     * Sets the value of the startRow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStartRow(Integer value) {
        this.startRow = value;
    }

    /**
     * Gets the value of the startColumn property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStartColumn() {
        return startColumn;
    }

    /**
     * Sets the value of the startColumn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStartColumn(Integer value) {
        this.startColumn = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColor(String value) {
        this.color = value;
    }

    /**
     * Gets the value of the characterWidth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharacterWidth() {
        return characterWidth;
    }

    /**
     * Sets the value of the characterWidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharacterWidth(String value) {
        this.characterWidth = value;
    }

    /**
     * Gets the value of the characterHeight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharacterHeight() {
        return characterHeight;
    }

    /**
     * Sets the value of the characterHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharacterHeight(String value) {
        this.characterHeight = value;
    }

    /**
     * Gets the value of the characterStyle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharacterStyle() {
        return characterStyle;
    }

    /**
     * Sets the value of the characterStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharacterStyle(String value) {
        this.characterStyle = value;
    }

    /**
     * Gets the value of the alignment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlignment() {
        return alignment;
    }

    /**
     * Sets the value of the alignment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlignment(String value) {
        this.alignment = value;
    }

    /**
     * Gets the value of the endOfLineFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isEndOfLineFlag() {
        if (endOfLineFlag == null) {
            return true;
        } else {
            return endOfLineFlag;
        }
    }

    /**
     * Sets the value of the endOfLineFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEndOfLineFlag(Boolean value) {
        this.endOfLineFlag = value;
    }

}
