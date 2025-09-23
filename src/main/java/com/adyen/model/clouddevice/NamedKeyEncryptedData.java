package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Cryptographic Message Syntax (CMS) data structure containing encrypted data and integrated
 * optional data filed keyName.
 */
@JsonPropertyOrder({"KeyName", "EncryptedContent", "Version"})
public class NamedKeyEncryptedData {

  @JsonProperty("KeyName")
  protected String keyName;

  @JsonProperty("EncryptedContent")
  protected EncryptedContent encryptedContent;

  @JsonProperty("Version")
  protected VersionType version;

  /**
   * Gets key name.
   *
   * @return the key name
   */
  public String getKeyName() {
    return keyName;
  }

  /**
   * Sets key name.
   *
   * @param keyName the key name
   */
  public void setKeyName(String keyName) {
    this.keyName = keyName;
  }

  /**
   * Gets encrypted content.
   *
   * @return the encrypted content
   */
  public EncryptedContent getEncryptedContent() {
    return encryptedContent;
  }

  /**
   * Sets encrypted content.
   *
   * @param encryptedContent the encrypted content
   */
  public void setEncryptedContent(EncryptedContent encryptedContent) {
    this.encryptedContent = encryptedContent;
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
}