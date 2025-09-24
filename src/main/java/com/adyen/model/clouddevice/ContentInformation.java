package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/** General Cryptographic Message Syntax (CMS) data structure. */
public class ContentInformation {

  @JsonProperty("EnvelopedData")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  protected EnvelopedData envelopedData;

  @JsonProperty("AuthenticatedData")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  protected AuthenticatedData authenticatedData;

  @JsonProperty("SignedData")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  protected SignedData signedData;

  @JsonProperty("DigestedData")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  protected DigestedData digestedData;

  @JsonProperty("NamedKeyEncryptedData")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  protected NamedKeyEncryptedData namedKeyEncryptedData;

  @JsonProperty("ContentType")
  protected ContentType contentType;

  /**
   * Gets enveloped data.
   *
   * @return the enveloped data
   */
  public EnvelopedData getEnvelopedData() {
    return envelopedData;
  }

  /**
   * Sets enveloped data.
   *
   * @param envelopedData the enveloped data
   */
  public void setEnvelopedData(EnvelopedData envelopedData) {
    this.envelopedData = envelopedData;
  }

  /**
   * Gets authenticated data.
   *
   * @return the authenticated data
   */
  public AuthenticatedData getAuthenticatedData() {
    return authenticatedData;
  }

  /**
   * Sets authenticated data.
   *
   * @param authenticatedData the authenticated data
   */
  public void setAuthenticatedData(AuthenticatedData authenticatedData) {
    this.authenticatedData = authenticatedData;
  }

  /**
   * Gets signed data.
   *
   * @return the signed data
   */
  public SignedData getSignedData() {
    return signedData;
  }

  /**
   * Sets signed data.
   *
   * @param signedData the signed data
   */
  public void setSignedData(SignedData signedData) {
    this.signedData = signedData;
  }

  /**
   * Gets digested data.
   *
   * @return the digested data
   */
  public DigestedData getDigestedData() {
    return digestedData;
  }

  /**
   * Sets digested data.
   *
   * @param digestedData the digested data
   */
  public void setDigestedData(DigestedData digestedData) {
    this.digestedData = digestedData;
  }

  /**
   * Gets named key encrypted data.
   *
   * @return the named key encrypted data
   */
  public NamedKeyEncryptedData getNamedKeyEncryptedData() {
    return namedKeyEncryptedData;
  }

  /**
   * Sets named key encrypted data.
   *
   * @param namedKeyEncryptedData the named key encrypted data
   */
  public void setNamedKeyEncryptedData(NamedKeyEncryptedData namedKeyEncryptedData) {
    this.namedKeyEncryptedData = namedKeyEncryptedData;
  }

  /**
   * Gets content type.
   *
   * @return the content type
   */
  public ContentType getContentType() {
    return contentType;
  }

  /**
   * Sets content type.
   *
   * @param contentType the content type
   */
  public void setContentType(ContentType contentType) {
    this.contentType = contentType;
  }
}
