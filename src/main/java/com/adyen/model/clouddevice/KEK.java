package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/** Encryption key using previously distributed symmetric key. */
@JsonPropertyOrder({"KEKIdentifier", "KeyEncryptionAlgorithm", "Version", "EncryptedKey"})
public class KEK {

  @JsonProperty("KEKIdentifier")
  protected KEKIdentifier kekIdentifier;

  @JsonProperty("KeyEncryptionAlgorithm")
  protected AlgorithmIdentifier keyEncryptionAlgorithm;

  @JsonProperty("Version")
  protected VersionType version;

  @JsonProperty("EncryptedKey")
  protected byte[] encryptedKey;

  /**
   * Gets kek identifier.
   *
   * @return the kek identifier
   */
  public KEKIdentifier getKEKIdentifier() {
    return kekIdentifier;
  }

  /**
   * Sets kek identifier.
   *
   * @param kekIdentifier the kek identifier
   */
  public void setKEKIdentifier(KEKIdentifier kekIdentifier) {
    this.kekIdentifier = kekIdentifier;
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
      return VersionType.V_4;
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