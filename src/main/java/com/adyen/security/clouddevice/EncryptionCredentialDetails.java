package com.adyen.security.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/** Details of the encryption credential used for encrypting the request payload (nexoBlob) */
public class EncryptionCredentialDetails {

  /** The passphrase used to derive the encryption key. */
  @JsonProperty("Passphrase")
  private String passphrase;

  /** The unique identifier of the key. */
  @JsonProperty("KeyIdentifier")
  private String keyIdentifier;

  /** The version of the key. */
  @JsonProperty("KeyVersion")
  private Integer keyVersion;

  /** The version of the Adyen-specific crypto implementation. */
  @JsonProperty("AdyenCryptoVersion")
  private Integer adyenCryptoVersion;

  public String getPassphrase() {
    return passphrase;
  }

  public void setPassphrase(String passphrase) {
    this.passphrase = passphrase;
  }

  public String getKeyIdentifier() {
    return keyIdentifier;
  }

  public void setKeyIdentifier(String keyIdentifier) {
    this.keyIdentifier = keyIdentifier;
  }

  public Integer getKeyVersion() {
    return keyVersion;
  }

  public void setKeyVersion(Integer keyVersion) {
    this.keyVersion = keyVersion;
  }

  public Integer getAdyenCryptoVersion() {
    return adyenCryptoVersion;
  }

  public void setAdyenCryptoVersion(Integer adyenCryptoVersion) {
    this.adyenCryptoVersion = adyenCryptoVersion;
  }

  public EncryptionCredentialDetails passphrase(String passphrase) {
    this.passphrase = passphrase;
    return this;
  }

  public EncryptionCredentialDetails keyIdentifier(String keyIdentifier) {
    this.keyIdentifier = keyIdentifier;
    return this;
  }

  public EncryptionCredentialDetails keyVersion(Integer keyVersion) {
    this.keyVersion = keyVersion;
    return this;
  }

  public EncryptionCredentialDetails adyenCryptoVersion(Integer adyenCryptoVersion) {
    this.adyenCryptoVersion = adyenCryptoVersion;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EncryptionCredentialDetails that = (EncryptionCredentialDetails) o;
    return Objects.equals(passphrase, that.passphrase)
        && Objects.equals(keyIdentifier, that.keyIdentifier)
        && Objects.equals(keyVersion, that.keyVersion)
        && Objects.equals(adyenCryptoVersion, that.adyenCryptoVersion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(passphrase, keyIdentifier, keyVersion, adyenCryptoVersion);
  }

  @Override
  public String toString() {
    return "EncryptionCredentialDetails{"
        + "passphrase='"
        + passphrase
        + '\''
        + ", keyIdentifier='"
        + keyIdentifier
        + '\''
        + ", keyVersion="
        + keyVersion
        + ", adyenCryptoVersion="
        + adyenCryptoVersion
        + '}';
  }
}
