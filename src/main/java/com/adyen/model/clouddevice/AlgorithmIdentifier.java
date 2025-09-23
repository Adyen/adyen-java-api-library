package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Definition: Identification of a cryptographic algorithm -- Reference: RFC 3880: Internet X.509
 * Public Key Infrastructure Certificate and Certificate -- Usage: This data structure contains: the
 * algorithm identifier associated parameters
 */
public class AlgorithmIdentifier {

  @JsonProperty("Parameter")
  protected Parameter parameter;

  @JsonProperty("Algorithm")
  protected AlgorithmType algorithm;

  /**
   * Gets the value of the parameter property.
   *
   * @return possible object is {@link Parameter }
   */
  public Parameter getParameter() {
    return parameter;
  }

  /**
   * Sets the value of the parameter property.
   *
   * @param value allowed object is {@link Parameter }
   */
  public void setParameter(Parameter value) {
    this.parameter = value;
  }

  /**
   * Gets the value of the algorithm property.
   *
   * @return possible object is {@link AlgorithmType }
   */
  public AlgorithmType getAlgorithm() {
    return algorithm;
  }

  /**
   * Sets the value of the algorithm property.
   *
   * @param value allowed object is {@link AlgorithmType }
   */
  public void setAlgorithm(AlgorithmType value) {
    this.algorithm = value;
  }
}