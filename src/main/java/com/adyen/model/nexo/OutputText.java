package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of text message to display or print. -- Usage: It conveys Information related to the content of the text message and its format. All the data elements related to the format of the text to display or print are parameters valid for the whole Text content.
 *
 * <p>Java class for OutputText complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OutputText"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="Text" use="required" type="{}Text" /&gt;
 *       &lt;attribute name="CharacterSet" type="{}CharacterSet" /&gt;
 *       &lt;attribute name="Font" type="{}Font" /&gt;
 *       &lt;attribute name="StartRow" type="{}StartRow" /&gt;
 *       &lt;attribute name="StartColumn" type="{}StartColumn" /&gt;
 *       &lt;attribute name="Color" type="{}ColorType" /&gt;
 *       &lt;attribute name="CharacterWidth" type="{}CharacterWidthType" /&gt;
 *       &lt;attribute name="CharacterHeight" type="{}CharacterHeightType" /&gt;
 *       &lt;attribute name="CharacterStyle" type="{}CharacterStyleType" /&gt;
 *       &lt;attribute name="Alignment" type="{}AlignmentType" /&gt;
 *       &lt;attribute name="EndOfLineFlag" type="{}EndOfLineFlag" default="true" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputText")
public class OutputText {

    @XmlElement(name = "Text", required = true)
    @Schema(description = "Content of text message to display, print or play.")
    protected String text;

    @XmlElement(name = "CharacterSet")
    @Schema(description = "The character encoding of the text string. --Rule: If not present, the settings of thetarget system or device are used. ")
    protected Integer characterSet;
    @XmlElement(name = "Font")
    @Schema(description = "Name of the font. --Rule: If not present, the settings of the target system or deviceare used. ")
    protected String font;
    @XmlElement(name = "StartRow")
    @Schema(description = "Row from which the text string has to be displayed or printed. --Rule: If not present,the settings of the target system or device are used(e.g.current row position). ")
    protected Integer startRow;

    @XmlElement(name = "StartColumn")
    @Schema(description = "Column from which the text string has to be displayed or printed. --Rule: If notpresent, the settings of the target system or device are used(e.g.current column position). ")
    protected Integer startColumn;

    @XmlElement(name = "Color")
    @Schema(description = "Color of the text string to display or print. --Rule: If not present, default colourused ")
    protected ColorType color;

    @XmlElement(name = "CharacterWidth")
    @Schema(description = "Character width of the text string to display or print. --Rule: If not present, default width used")
    protected CharacterWidthType characterWidth;

    @XmlElement(name = "CharacterHeight")
    @Schema(description = "Character height of the text string to display or print. --Rule: If not present, default height used ")
    protected CharacterHeightType characterHeight;

    @XmlElement(name = "CharacterStyle")
    @Schema(description = "Typographic style of the sequence of characters to display or print. --Rule: If notpresent, default style used ")
    protected CharacterStyleType characterStyle;
    @XmlElement(name = "Alignment")
    @Schema(description = "Alignment of the text string on the display line or print line --Rule: If not present, default alignment used ")
    protected AlignmentType alignment;
    @XmlElement(name = "EndOfLineFlag")
    @Schema(description = "Text is at the end of a line.")
    protected Boolean endOfLineFlag;

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

    /**
     * Gets the value of the characterSet property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getCharacterSet() {
        return characterSet;
    }

    /**
     * Sets the value of the characterSet property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setCharacterSet(Integer value) {
        this.characterSet = value;
    }

    /**
     * Gets the value of the font property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFont() {
        return font;
    }

    /**
     * Sets the value of the font property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFont(String value) {
        this.font = value;
    }

    /**
     * Gets the value of the startRow property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getStartRow() {
        return startRow;
    }

    /**
     * Sets the value of the startRow property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setStartRow(Integer value) {
        this.startRow = value;
    }

    /**
     * Gets the value of the startColumn property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getStartColumn() {
        return startColumn;
    }

    /**
     * Sets the value of the startColumn property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setStartColumn(Integer value) {
        this.startColumn = value;
    }

    /**
     * Gets the value of the color property.
     *
     * @return possible object is
     * {@link ColorType }
     */
    public ColorType getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     *
     * @param value allowed object is
     *              {@link ColorType }
     */
    public void setColor(ColorType value) {
        this.color = value;
    }

    /**
     * Gets the value of the characterWidth property.
     *
     * @return possible object is
     * {@link CharacterWidthType }
     */
    public CharacterWidthType getCharacterWidth() {
        return characterWidth;
    }

    /**
     * Sets the value of the characterWidth property.
     *
     * @param value allowed object is
     *              {@link CharacterWidthType }
     */
    public void setCharacterWidth(CharacterWidthType value) {
        this.characterWidth = value;
    }

    /**
     * Gets the value of the characterHeight property.
     *
     * @return possible object is
     * {@link CharacterHeightType }
     */
    public CharacterHeightType getCharacterHeight() {
        return characterHeight;
    }

    /**
     * Sets the value of the characterHeight property.
     *
     * @param value allowed object is
     *              {@link CharacterHeightType }
     */
    public void setCharacterHeight(CharacterHeightType value) {
        this.characterHeight = value;
    }

    /**
     * Gets the value of the characterStyle property.
     *
     * @return possible object is
     * {@link CharacterStyleType }
     */
    public CharacterStyleType getCharacterStyle() {
        return characterStyle;
    }

    /**
     * Sets the value of the characterStyle property.
     *
     * @param value allowed object is
     *              {@link CharacterStyleType }
     */
    public void setCharacterStyle(CharacterStyleType value) {
        this.characterStyle = value;
    }

    /**
     * Gets the value of the alignment property.
     *
     * @return possible object is
     * {@link AlignmentType }
     */
    public AlignmentType getAlignment() {
        return alignment;
    }

    /**
     * Sets the value of the alignment property.
     *
     * @param value allowed object is
     *              {@link AlignmentType }
     */
    public void setAlignment(AlignmentType value) {
        this.alignment = value;
    }

    /**
     * Gets the value of the endOfLineFlag property.
     *
     * @return possible object is
     * {@link Boolean }
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
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setEndOfLineFlag(Boolean value) {
        this.endOfLineFlag = value;
    }

}
