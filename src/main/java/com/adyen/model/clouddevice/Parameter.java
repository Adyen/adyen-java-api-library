package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/** Parameters associated to a cryptographic algorithm. */
@JsonPropertyOrder({"InitialisationVector"})
public class Parameter {

  @JsonProperty("InitialisationVector")
  protected byte[] initialisationVector;

  /**
   * Get initialisation vector.
   *
   * @return the byte [ ]
   */
  public byte[] getInitialisationVector() {
    return initialisationVector;
  }

  /**
   * Sets initialisation vector.
   *
   * @param initialisationVector the initialisation vector
   */
  public void setInitialisationVector(byte[] initialisationVector) {
    this.initialisationVector = initialisationVector;
  }
}