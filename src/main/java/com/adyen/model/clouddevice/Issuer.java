package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;

/** Certificate issuer name (see X.501-88). */
@JsonPropertyOrder({"RelativeDistinguishedName"})
public class Issuer {

  @JsonProperty("RelativeDistinguishedName")
  protected List<RelativeDistinguishedName> relativeDistinguishedName;

  /**
   * Gets relative distinguished name.
   *
   * @return the relative distinguished name
   */
  public List<RelativeDistinguishedName> getRelativeDistinguishedName() {
    if (relativeDistinguishedName == null) {
      relativeDistinguishedName = new ArrayList<>();
    }
    return this.relativeDistinguishedName;
  }

  /**
   * Sets relative distinguished name.
   *
   * @param relativeDistinguishedName the relative distinguished name
   */
  public void setRelativeDistinguishedName(
      List<RelativeDistinguishedName> relativeDistinguishedName) {
    this.relativeDistinguishedName = relativeDistinguishedName;
  }
}
