package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Definition: Content of the Sound Response messageType. -- Usage: It conveys the result of the
 * Sound request. The response may be absent, at the beginning of the processing, or at the end of
 * the processing.
 *
 * <p>Java class for SoundResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SoundResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response" type="{}Response"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "SoundResponse",
    propOrder = {"response"})
public class SoundResponse {

  /** The Response. */
  @XmlElement(name = "Response", required = true)
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  /**
   * Gets the value of the response property.
   *
   * @return possible object is {@link Response }
   */
  public Response getResponse() {
    return response;
  }

  /**
   * Sets the value of the response property.
   *
   * @param value allowed object is {@link Response }
   */
  public void setResponse(Response value) {
    this.response = value;
  }
}
