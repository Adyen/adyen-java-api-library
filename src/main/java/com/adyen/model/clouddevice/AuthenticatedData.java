package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Cryptographic Message Syntax (CMS) data structure containing MACed data with encryption key.
 */
public class AuthenticatedData {

  @JsonProperty("KeyTransport")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  protected List<KeyTransport> keyTransport;

  @JsonProperty("KEK")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  protected List<KEK> kek;

  @JsonProperty("MACAlgorithm")
  protected AlgorithmIdentifier macAlgorithm;

  @JsonProperty("EncapsulatedContent")
  protected EncapsulatedContent encapsulatedContent;

  @JsonProperty("Version")
  protected VersionType version;

  @JsonProperty("MAC")
  protected byte[] mac;

  public List<KeyTransport> getKeyTransport() {
    if (keyTransport == null) {
      keyTransport = new ArrayList<>();
    }
    return keyTransport;
  }

  public void setKeyTransport(List<KeyTransport> keyTransport) {
    this.keyTransport = keyTransport;
  }

  public List<KEK> getKEK() {
    if (kek == null) {
      kek = new ArrayList<>();
    }
    return kek;
  }

  public void setKEK(List<KEK> kek) {
    this.kek = kek;
  }

  /**
   * Gets the value of the macAlgorithm property.
   *
   * @return possible object is {@link AlgorithmIdentifier }
   */
  public AlgorithmIdentifier getMACAlgorithm() {
    return macAlgorithm;
  }

  /**
   * Sets the value of the macAlgorithm property.
   *
   * @param value allowed object is {@link AlgorithmIdentifier }
   */
  public void setMACAlgorithm(AlgorithmIdentifier value) {
    this.macAlgorithm = value;
  }

  /**
   * Gets the value of the encapsulatedContent property.
   *
   * @return possible object is {@link EncapsulatedContent }
   */
  public EncapsulatedContent getEncapsulatedContent() {
    return encapsulatedContent;
  }

  /**
   * Sets the value of the encapsulatedContent property.
   *
   * @param value allowed object is {@link EncapsulatedContent }
   */
  public void setEncapsulatedContent(EncapsulatedContent value) {
    this.encapsulatedContent = value;
  }

  /**
   * Gets the value of the version property.
   *
   * @return possible object is {@link VersionType }
   */
  public VersionType getVersion() {
    if (version == null) {
      return VersionType.V_0;
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

  /**
   * Gets the value of the mac property.
   *
   * @return possible object is byte[]
   */
  public byte[] getMAC() {
    return mac;
  }

  /**
   * Sets the value of the mac property.
   *
   * @param value allowed object is byte[]
   */
  public void setMAC(byte[] value) {
    this.mac = value;
  }
}