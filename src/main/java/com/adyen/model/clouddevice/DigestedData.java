package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/** Cryptographic Message Syntax (CMS) data structure containing digested data. */
@JsonPropertyOrder({"DigestAlgorithm", "EncapsulatedContent", "Digest", "Version"})
public class DigestedData {

  @JsonProperty("DigestAlgorithm")
  protected AlgorithmIdentifier digestAlgorithm;

  @JsonProperty("EncapsulatedContent")
  protected EncapsulatedContent encapsulatedContent;

  @JsonProperty("Digest")
  protected byte[] digest;

  @JsonProperty("Version")
  protected VersionType version;

  /**
   * Gets digest algorithm.
   *
   * @return the digest algorithm
   */
  public AlgorithmIdentifier getDigestAlgorithm() {
    return digestAlgorithm;
  }

  /**
   * Sets digest algorithm.
   *
   * @param digestAlgorithm the digest algorithm
   */
  public void setDigestAlgorithm(AlgorithmIdentifier digestAlgorithm) {
    this.digestAlgorithm = digestAlgorithm;
  }

  /**
   * Gets encapsulated content.
   *
   * @return the encapsulated content
   */
  public EncapsulatedContent getEncapsulatedContent() {
    return encapsulatedContent;
  }

  /**
   * Sets encapsulated content.
   *
   * @param encapsulatedContent the encapsulated content
   */
  public void setEncapsulatedContent(EncapsulatedContent encapsulatedContent) {
    this.encapsulatedContent = encapsulatedContent;
  }

  /**
   * Get digest.
   *
   * @return the byte [ ]
   */
  public byte[] getDigest() {
    return digest;
  }

  /**
   * Sets digest.
   *
   * @param digest the digest
   */
  public void setDigest(byte[] digest) {
    this.digest = digest;
  }

  /**
   * Gets version.
   *
   * @return the version
   */
  public VersionType getVersion() {
    return version;
  }

  /**
   * Sets version.
   *
   * @param version the version
   */
  public void setVersion(VersionType version) {
    this.version = version;
  }
}
