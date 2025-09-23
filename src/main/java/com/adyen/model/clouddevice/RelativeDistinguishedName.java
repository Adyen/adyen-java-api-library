package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/** Certificate distinguished name (DN). */
@JsonPropertyOrder({"Attribute", "AttributeValue"})
public class RelativeDistinguishedName {

  @JsonProperty("Attribute")
  protected String attribute;

  @JsonProperty("AttributeValue")
  protected String attributeValue;

  /**
   * Gets attribute.
   *
   * @return the attribute
   */
  public String getAttribute() {
    return attribute;
  }

  /**
   * Sets attribute.
   *
   * @param attribute the attribute
   */
  public void setAttribute(String attribute) {
    this.attribute = attribute;
  }

  /**
   * Gets attribute value.
   *
   * @return the attribute value
   */
  public String getAttributeValue() {
    return attributeValue;
  }

  /**
   * Sets attribute value.
   *
   * @param attributeValue the attribute value
   */
  public void setAttributeValue(String attributeValue) {
    this.attributeValue = attributeValue;
  }
}