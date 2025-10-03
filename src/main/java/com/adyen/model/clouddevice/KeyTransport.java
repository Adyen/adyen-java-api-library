package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/** Encryption key using previously distributed asymmetric key. */
@JsonPropertyOrder({"RecipientIdentifier", "KeyEncryptionAlgorithm", "Version", "EncryptedKey"})
public class KeyTransport {

  @JsonProperty("RecipientIdentifier")
  protected RecipientIdentifier recipientIdentifier;

  @JsonProperty("KeyEncryptionAlgorithm")
  protected AlgorithmIdentifier keyEncryptionAlgorithm;

  @JsonProperty("Version")
  protected VersionType version;

  @JsonProperty("EncryptedKey")
  protected byte[] encryptedKey;

  /**
   * Gets recipient identifier.
   *
   * @return the recipient identifier
   */
  public RecipientIdentifier getRecipientIdentifier() {
    return recipientIdentifier;
  }

  /**
   * Sets recipient identifier.
   *
   * @param recipientIdentifier the recipient identifier
   */
  public void setRecipientIdentifier(RecipientIdentifier recipientIdentifier) {
    this.recipientIdentifier = recipientIdentifier;
  }

  /**
   * Gets key encryption algorithm.
   *
   * @return the key encryption algorithm
   */
  public AlgorithmIdentifier getKeyEncryptionAlgorithm() {
    return keyEncryptionAlgorithm;
  }

  /**
   * Sets key encryption algorithm.
   *
   * @param keyEncryptionAlgorithm the key encryption algorithm
   */
  public void setKeyEncryptionAlgorithm(AlgorithmIdentifier keyEncryptionAlgorithm) {
    this.keyEncryptionAlgorithm = keyEncryptionAlgorithm;
  }

  /**
   * Gets version.
   *
   * @return the version
   */
  public VersionType getVersion() {
    if (version == null) {
      return VersionType.V_0;
    } else {
      return version;
    }
  }

  /**
   * Sets version.
   *
   * @param version the version
   */
  public void setVersion(VersionType version) {
    this.version = version;
  }

  /**
   * Get encrypted key.
   *
   * @return the byte [ ]
   */
  public byte[] getEncryptedKey() {
    return encryptedKey;
  }

  /**
   * Sets encrypted key.
   *
   * @param encryptedKey the encrypted key
   */
  public void setEncryptedKey(byte[] encryptedKey) {
    this.encryptedKey = encryptedKey;
  }
}
