package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Cryptographic Message Syntax (CMS) data structure containing encrypted data with encryption key.
 */
@JsonPropertyOrder({"ContentEncryptionAlgorithm", "EncryptedData", "ContentType"})
public class EncryptedContent {

  @JsonProperty("ContentEncryptionAlgorithm")
  protected AlgorithmIdentifier contentEncryptionAlgorithm;

  @JsonProperty("EncryptedData")
  protected byte[] encryptedData;

  @JsonProperty("ContentType")
  protected ContentType contentType;

  /**
   * Gets content encryption algorithm.
   *
   * @return the content encryption algorithm
   */
  public AlgorithmIdentifier getContentEncryptionAlgorithm() {
    return contentEncryptionAlgorithm;
  }

  /**
   * Sets content encryption algorithm.
   *
   * @param contentEncryptionAlgorithm the content encryption algorithm
   */
  public void setContentEncryptionAlgorithm(AlgorithmIdentifier contentEncryptionAlgorithm) {
    this.contentEncryptionAlgorithm = contentEncryptionAlgorithm;
  }

  /**
   * Get encrypted data.
   *
   * @return the byte [ ]
   */
  public byte[] getEncryptedData() {
    return encryptedData;
  }

  /**
   * Sets encrypted data.
   *
   * @param encryptedData the encrypted data
   */
  public void setEncryptedData(byte[] encryptedData) {
    this.encryptedData = encryptedData;
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