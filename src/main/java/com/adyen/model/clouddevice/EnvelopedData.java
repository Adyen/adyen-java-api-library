package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Cryptographic Message Syntax (CMS) data structure containing encrypted data with encryption key.
 */
public class EnvelopedData {

  @JsonProperty("KeyTransport")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  protected List<KeyTransport> keyTransport;

  @JsonProperty("KEK")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  protected List<KEK> kek;

  @JsonProperty("EncryptedContent")
  protected EncryptedContent encryptedContent;

  @JsonProperty("Version")
  protected VersionType version;

  /**
   * Gets key transport.
   *
   * @return the key transport
   */
  public List<KeyTransport> getKeyTransport() {
    if (keyTransport == null) {
      keyTransport = new ArrayList<>();
    }
    return keyTransport;
  }

  /**
   * Sets key transport.
   *
   * @param keyTransport the key transport
   */
  public void setKeyTransport(List<KeyTransport> keyTransport) {
    this.keyTransport = keyTransport;
  }

  /**
   * Gets kek.
   *
   * @return the kek
   */
  public List<KEK> getKEK() {
    if (kek == null) {
      kek = new ArrayList<>();
    }
    return kek;
  }

  /**
   * Sets kek.
   *
   * @param kek the kek
   */
  public void setKEK(List<KEK> kek) {
    this.kek = kek;
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
