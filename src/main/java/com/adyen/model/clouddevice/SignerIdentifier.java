package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SignerIdentifier {

  /** The Issuer and serial number. */
  @JsonProperty("IssuerAndSerialNumber")
  protected IssuerAndSerialNumber issuerAndSerialNumber;

  /**
   * Gets the value of the issuerAndSerialNumber property.
   *
   * @return possible object is {@link IssuerAndSerialNumber }
   */
  public IssuerAndSerialNumber getIssuerAndSerialNumber() {
    return issuerAndSerialNumber;
  }

  /**
   * Sets the value of the issuerAndSerialNumber property.
   *
   * @param value allowed object is {@link IssuerAndSerialNumber }
   */
  public void setIssuerAndSerialNumber(IssuerAndSerialNumber value) {
    this.issuerAndSerialNumber = value;
  }
}
