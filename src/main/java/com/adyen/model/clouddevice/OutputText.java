package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Content of text message to display or print. */
@JsonPropertyOrder({
  "Text",
  "CharacterSet",
  "Font",
  "StartRow",
  "StartColumn",
  "Color",
  "CharacterWidth",
  "CharacterHeight",
  "CharacterStyle",
  "Alignment",
  "EndOfLineFlag"
})
public class OutputText {

  @JsonProperty("Text")
  @Schema(description = "Content of text message to display, print or play.")
  protected String text;

  @JsonProperty("CharacterSet")
  @Schema(
      description =
          "The character encoding of the text string. --Rule: If not present, the settings of thetarget system or device are used. ")
  protected Integer characterSet;

  @JsonProperty("Font")
  @Schema(
      description =
          "Name of the font. --Rule: If not present, the settings of the target system or deviceare used. ")
  protected String font;

  @JsonProperty("StartRow")
  @Schema(
      description =
          "Row from which the text string has to be displayed or printed. --Rule: If not present,the settings of the target system or device are used(e.g.current row position). ")
  protected Integer startRow;

  @JsonProperty("StartColumn")
  @Schema(
      description =
          "Column from which the text string has to be displayed or printed. --Rule: If notpresent, the settings of the target system or device are used(e.g.current column position). ")
  protected Integer startColumn;

  @JsonProperty("Color")
  @Schema(
      description =
          "Color of the text string to display or print. --Rule: If not present, default colourused ")
  protected ColorType color;

  @JsonProperty("CharacterWidth")
  @Schema(
      description =
          "Character width of the text string to display or print. --Rule: If not present, default width used")
  protected CharacterWidthType characterWidth;

  @JsonProperty("CharacterHeight")
  @Schema(
      description =
          "Character height of the text string to display or print. --Rule: If not present, default height used ")
  protected CharacterHeightType characterHeight;

  @JsonProperty("CharacterStyle")
  @Schema(
      description =
          "Typographic style of the sequence of characters to display or print. --Rule: If notpresent, default style used ")
  protected CharacterStyleType characterStyle;

  @JsonProperty("Alignment")
  @Schema(
      description =
          "Alignment of the text string on the display line or print line --Rule: If not present, default alignment used ")
  protected AlignmentType alignment;

  @JsonProperty("EndOfLineFlag")
  @Schema(description = "Text is at the end of a line.")
  protected Boolean endOfLineFlag;

  /**
   * Gets text.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Sets text.
   *
   * @param text the text
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * Gets character set.
   *
   * @return the character set
   */
  public Integer getCharacterSet() {
    return characterSet;
  }

  /**
   * Sets character set.
   *
   * @param characterSet the character set
   */
  public void setCharacterSet(Integer characterSet) {
    this.characterSet = characterSet;
  }

  /**
   * Gets font.
   *
   * @return the font
   */
  public String getFont() {
    return font;
  }

  /**
   * Sets font.
   *
   * @param font the font
   */
  public void setFont(String font) {
    this.font = font;
  }

  /**
   * Gets start row.
   *
   * @return the start row
   */
  public Integer getStartRow() {
    return startRow;
  }

  /**
   * Sets start row.
   *
   * @param startRow the start row
   */
  public void setStartRow(Integer startRow) {
    this.startRow = startRow;
  }

  /**
   * Gets start column.
   *
   * @return the start column
   */
  public Integer getStartColumn() {
    return startColumn;
  }

  /**
   * Sets start column.
   *
   * @param startColumn the start column
   */
  public void setStartColumn(Integer startColumn) {
    this.startColumn = startColumn;
  }

  /**
   * Gets color.
   *
   * @return the color
   */
  public ColorType getColor() {
    return color;
  }

  /**
   * Sets color.
   *
   * @param color the color
   */
  public void setColor(ColorType color) {
    this.color = color;
  }

  /**
   * Gets character width.
   *
   * @return the character width
   */
  public CharacterWidthType getCharacterWidth() {
    return characterWidth;
  }

  /**
   * Sets character width.
   *
   * @param characterWidth the character width
   */
  public void setCharacterWidth(CharacterWidthType characterWidth) {
    this.characterWidth = characterWidth;
  }

  /**
   * Gets character height.
   *
   * @return the character height
   */
  public CharacterHeightType getCharacterHeight() {
    return characterHeight;
  }

  /**
   * Sets character height.
   *
   * @param characterHeight the character height
   */
  public void setCharacterHeight(CharacterHeightType characterHeight) {
    this.characterHeight = characterHeight;
  }

  /**
   * Gets character style.
   *
   * @return the character style
   */
  public CharacterStyleType getCharacterStyle() {
    return characterStyle;
  }

  /**
   * Sets character style.
   *
   * @param characterStyle the character style
   */
  public void setCharacterStyle(CharacterStyleType characterStyle) {
    this.characterStyle = characterStyle;
  }

  /**
   * Gets alignment.
   *
   * @return the alignment
   */
  public AlignmentType getAlignment() {
    return alignment;
  }

  /**
   * Sets alignment.
   *
   * @param alignment the alignment
   */
  public void setAlignment(AlignmentType alignment) {
    this.alignment = alignment;
  }

  /**
   * Is end of line flag boolean.
   *
   * @return the boolean
   */
  public boolean isEndOfLineFlag() {
    if (endOfLineFlag == null) {
      return true;
    } else {
      return endOfLineFlag;
    }
  }

  /**
   * Sets end of line flag.
   *
   * @param endOfLineFlag the end of line flag
   */
  public void setEndOfLineFlag(Boolean endOfLineFlag) {
    this.endOfLineFlag = endOfLineFlag;
  }
}
