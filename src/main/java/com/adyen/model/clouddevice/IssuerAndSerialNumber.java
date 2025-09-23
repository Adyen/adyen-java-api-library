package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.math.BigInteger;

/**
 * Cryptographic Message Syntax (CMS) data structure containing the issuer name and certificate
 * serial number.
 */
@JsonPropertyOrder({"Issuer", "SerialNumber"})
public class IssuerAndSerialNumber {

  @JsonProperty("Issuer")
  protected Issuer issuer;

  @JsonProperty("SerialNumber")
  protected BigInteger serialNumber;

  /**
   * Gets issuer.
   *
   * @return the issuer
   */
  public Issuer getIssuer() {
    return issuer;
  }

  /**
   * Sets issuer.
   *
   * @param issuer the issuer
   */
  public void setIssuer(Issuer issuer) {
    this.issuer = issuer;
  }

  /**
   * Gets serial number.
   *
   * @return the serial number
   */
  public BigInteger getSerialNumber() {
    return serialNumber;
  }

  /**
   * Sets serial number.
   *
   * @param serialNumber the serial number
   */
  public void setSerialNumber(BigInteger serialNumber) {
    this.serialNumber = serialNumber;
  }
}