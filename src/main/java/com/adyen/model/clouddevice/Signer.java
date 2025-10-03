package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Signer {

  /** The Signer identifier. */
  @JsonProperty("SignerIdentifier")
  protected SignerIdentifier signerIdentifier;

  /** The Digest algorithm. */
  @JsonProperty("DigestAlgorithm")
  protected AlgorithmIdentifier digestAlgorithm;

  /** The Signature algorithm. */
  @JsonProperty("SignatureAlgorithm")
  protected AlgorithmIdentifier signatureAlgorithm;

  /** The Signature. */
  @JsonProperty("Signature")
  protected byte[] signature;

  /** The Version. */
  @JsonProperty("Version")
  protected VersionType version;

  /**
   * Gets the value of the signerIdentifier property.
   *
   * @return possible object is {@link SignerIdentifier }
   */
  public SignerIdentifier getSignerIdentifier() {
    return signerIdentifier;
  }

  /**
   * Sets the value of the signerIdentifier property.
   *
   * @param value allowed object is {@link SignerIdentifier }
   */
  public void setSignerIdentifier(SignerIdentifier value) {
    this.signerIdentifier = value;
  }

  /**
   * Gets the value of the digestAlgorithm property.
   *
   * @return possible object is {@link AlgorithmIdentifier }
   */
  public AlgorithmIdentifier getDigestAlgorithm() {
    return digestAlgorithm;
  }

  /**
   * Sets the value of the digestAlgorithm property.
   *
   * @param value allowed object is {@link AlgorithmIdentifier }
   */
  public void setDigestAlgorithm(AlgorithmIdentifier value) {
    this.digestAlgorithm = value;
  }

  /**
   * Gets the value of the signatureAlgorithm property.
   *
   * @return possible object is {@link AlgorithmIdentifier }
   */
  public AlgorithmIdentifier getSignatureAlgorithm() {
    return signatureAlgorithm;
  }

  /**
   * Sets the value of the signatureAlgorithm property.
   *
   * @param value allowed object is {@link AlgorithmIdentifier }
   */
  public void setSignatureAlgorithm(AlgorithmIdentifier value) {
    this.signatureAlgorithm = value;
  }

  /**
   * Gets the value of the signature property.
   *
   * @return possible object is byte[]
   */
  public byte[] getSignature() {
    return signature;
  }

  /**
   * Sets the value of the signature property.
   *
   * @param value allowed object is byte[]
   */
  public void setSignature(byte[] value) {
    this.signature = value;
  }

  /**
   * Gets the value of the version property.
   *
   * @return possible object is {@link VersionType }
   */
  public VersionType getVersion() {
    if (version == null) {
      return VersionType.V_1;
    } else {
      return version;
    }
  }

  /**
   * Sets the value of the version property.
   *
   * @param value allowed object is {@link VersionType }
   */
  public void setVersion(VersionType value) {
    this.version = value;
  }
}
