package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class SignedData {

  /** The Digest algorithm. */
  @JsonProperty("DigestAlgorithm")
  protected List<AlgorithmIdentifier> digestAlgorithm;

  /** The Encapsulated content. */
  @JsonProperty("EncapsulatedContent")
  protected EncapsulatedContent encapsulatedContent;

  /** The Certificate. */
  @JsonProperty("Certificate")
  protected List<byte[]> certificate;

  /** The Signer. */
  @JsonProperty("Signer")
  protected List<Signer> signer;

  /** The Version. */
  @JsonProperty("Version")
  protected VersionType version;

  /**
   * Gets the value of the digestAlgorithm property.
   *
   * <p>
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the digestAlgorithm property.
   *
   * <p>
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getDigestAlgorithm().add(newItem);
   * </pre>
   *
   * <p>
   *
   * <p>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link AlgorithmIdentifier }
   *
   * @return the digest algorithm
   */
  public List<AlgorithmIdentifier> getDigestAlgorithm() {
    if (digestAlgorithm == null) {
      digestAlgorithm = new ArrayList<>();
    }
    return this.digestAlgorithm;
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
   * Gets the value of the certificate property.
   *
   * <p>
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the certificate property.
   *
   * <p>
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getCertificate().add(newItem);
   * </pre>
   *
   * <p>
   *
   * <p>
   *
   * <p>Objects of the following type(s) are allowed in the list byte[]
   *
   * @return the certificate
   */
  public List<byte[]> getCertificate() {
    if (certificate == null) {
      certificate = new ArrayList<>();
    }
    return this.certificate;
  }

  /**
   * Gets the value of the signer property.
   *
   * <p>
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the signer property.
   *
   * <p>
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getSigner().add(newItem);
   * </pre>
   *
   * <p>
   *
   * <p>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Signer }
   *
   * @return the signer
   */
  public List<Signer> getSigner() {
    if (signer == null) {
      signer = new ArrayList<>();
    }
    return this.signer;
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
