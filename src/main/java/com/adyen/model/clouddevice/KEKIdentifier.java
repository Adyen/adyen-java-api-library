package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Identification of a key encryption key (key management using previously distributed symmetric
 * key).
 */
@JsonPropertyOrder({"KeyIdentifier", "KeyVersion", "DerivationIdentifier"})
public class KEKIdentifier {

  @JsonProperty("KeyIdentifier")
  protected String keyIdentifier;

  @JsonProperty("KeyVersion")
  protected String keyVersion;

  @JsonProperty("DerivationIdentifier")
  protected byte[] derivationIdentifier;

  /**
   * Gets key identifier.
   *
   * @return the key identifier
   */
  public String getKeyIdentifier() {
    return keyIdentifier;
  }

  /**
   * Sets key identifier.
   *
   * @param keyIdentifier the key identifier
   */
  public void setKeyIdentifier(String keyIdentifier) {
    this.keyIdentifier = keyIdentifier;
  }

  /**
   * Gets key version.
   *
   * @return the key version
   */
  public String getKeyVersion() {
    return keyVersion;
  }

  /**
   * Sets key version.
   *
   * @param keyVersion the key version
   */
  public void setKeyVersion(String keyVersion) {
    this.keyVersion = keyVersion;
  }

  /**
   * Get derivation identifier.
   *
   * @return the byte [ ]
   */
  public byte[] getDerivationIdentifier() {
    return derivationIdentifier;
  }

  /**
   * Sets derivation identifier.
   *
   * @param derivationIdentifier the derivation identifier
   */
  public void setDerivationIdentifier(byte[] derivationIdentifier) {
    this.derivationIdentifier = derivationIdentifier;
  }
}
