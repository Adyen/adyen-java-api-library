package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Definition: Content of the Custom Admin Request messageType. -- Usage: Empty
 *
 * <p>Java class for AdminRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AdminRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ServiceIdentification" type="{}ServiceIdentification" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class AdminRequest {

  /** The Service identification. */
  @JsonProperty("ServiceIdentification")
  @Schema(description = "Identification of the administrative service to process.")
  protected String serviceIdentification;

  /**
   * Gets the value of the serviceIdentification property.
   *
   * @return possible object is {@link String }
   */
  public String getServiceIdentification() {
    return serviceIdentification;
  }

  /**
   * Sets the value of the serviceIdentification property.
   *
   * @param value allowed object is {@link String }
   */
  public void setServiceIdentification(String value) {
    this.serviceIdentification = value;
  }
}
