package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Reference of a predefined message to display or print. */
@JsonPropertyOrder({"ReferenceID", "Language"})
public class PredefinedContent {

  @JsonProperty("ReferenceID")
  @Schema(description = "Identification of a predefined message to display, print or play.")
  protected String referenceID;

  @JsonProperty("Language")
  @Schema(description = "Identification of a language.")
  protected String language;

  /**
   * Gets reference id.
   *
   * @return the reference id
   */
  public String getReferenceID() {
    return referenceID;
  }

  /**
   * Sets reference id.
   *
   * @param referenceID the reference id
   */
  public void setReferenceID(String referenceID) {
    this.referenceID = referenceID;
  }

  /**
   * Gets language.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Sets language.
   *
   * @param language the language
   */
  public void setLanguage(String language) {
    this.language = language;
  }
}