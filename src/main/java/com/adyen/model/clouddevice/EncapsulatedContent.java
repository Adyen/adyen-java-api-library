package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/** Cryptographic Message Syntax (CMS) data structure containing content to authenticate. */
@JsonPropertyOrder({"Content", "ContentType"})
public class EncapsulatedContent {

  @JsonProperty("Content")
  protected byte[] content;

  @JsonProperty("ContentType")
  protected ContentType contentType;

  /**
   * Get content.
   *
   * @return the byte [ ]
   */
  public byte[] getContent() {
    return content;
  }

  /**
   * Sets content.
   *
   * @param content the content
   */
  public void setContent(byte[] content) {
    this.content = content;
  }

  /**
   * Gets content type.
   *
   * @return the content type
   */
  public ContentType getContentType() {
    return contentType;
  }

  /**
   * Sets content type.
   *
   * @param contentType the content type
   */
  public void setContentType(ContentType contentType) {
    this.contentType = contentType;
  }
}