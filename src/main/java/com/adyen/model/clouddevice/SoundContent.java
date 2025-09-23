package com.adyen.model.clouddevice;

import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SoundContent {

  @JsonProperty("SoundFormat")
  @Schema(description = "Type of sound to play.")
  protected SoundFormatType soundFormat;

  @JsonProperty("Language")
  @Schema(description = "Identification of a language.")
  protected String language;

  @JsonProperty("ReferenceID")
  @Schema(
      description =
          "Identification of a predefined message to display, print or play. --Rule: Mandatory if SoundFormat is SoundRef or MessageRef.")
  protected String referenceID;

  @JsonProperty("Text")
  @Schema(description = "Content of text message to display, print or play.")
  protected String text;

  /**
   * Gets the value of the soundFormat property.
   *
   * @return possible object is {@link SoundFormatType }
   */
  public SoundFormatType getSoundFormat() {
    return soundFormat;
  }

  /**
   * Sets the value of the soundFormat property.
   *
   * @param value allowed object is {@link SoundFormatType }
   */
  public void setSoundFormat(SoundFormatType value) {
    this.soundFormat = value;
  }

  /**
   * Gets the value of the language property.
   *
   * @return possible object is {@link String }
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Sets the value of the language property.
   *
   * @param value allowed object is {@link String }
   */
  public void setLanguage(String value) {
    this.language = value;
  }

  /**
   * Gets the value of the referenceID property.
   *
   * @return possible object is {@link String }
   */
  public String getReferenceID() {
    return referenceID;
  }

  /**
   * Sets the value of the referenceID property.
   *
   * @param value allowed object is {@link String }
   */
  public void setReferenceID(String value) {
    this.referenceID = value;
  }

  /**
   * Gets the value of the text property.
   *
   * @return possible object is {@link String }
   */
  public String getText() {
    return text;
  }

  /**
   * Sets the value of the text property.
   *
   * @param value allowed object is {@link String }
   */
  public void setText(String value) {
    this.text = value;
  }
}
