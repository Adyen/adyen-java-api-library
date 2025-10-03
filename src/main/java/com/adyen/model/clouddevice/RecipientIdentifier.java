package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/** Cryptographic Message Syntax (CMS) data structure containing the Recipient Identifier. */
@JsonPropertyOrder({"IssuerAndSerialNumber"})
public class RecipientIdentifier {

  @JsonProperty("IssuerAndSerialNumber")
  protected IssuerAndSerialNumber issuerAndSerialNumber;

  /**
   * Gets issuer and serial number.
   *
   * @return the issuer and serial number
   */
  public IssuerAndSerialNumber getIssuerAndSerialNumber() {
    return issuerAndSerialNumber;
  }

  /**
   * Sets issuer and serial number.
   *
   * @param issuerAndSerialNumber the issuer and serial number
   */
  public void setIssuerAndSerialNumber(IssuerAndSerialNumber issuerAndSerialNumber) {
    this.issuerAndSerialNumber = issuerAndSerialNumber;
  }
}
