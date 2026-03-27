package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Definition: Content of the Login Response messageType. -- Usage: It conveys Information related
 * to the Login to process
 *
 * <p>Java class for LoginResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LoginResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response" type="{}Response"/&gt;
 *         &lt;element name="POISystemData" type="{}POISystemData" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class LoginResponse {

  /** The Response. */
  @SerializedName("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  /** The Poi system data. */
  @SerializedName("POISystemData")
  @Schema(
      description = "Information related to the POI System --Rule: if Response.Result is Success")
  protected POISystemData poiSystemData;

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

  /**
   * Gets the value of the poiSystemData property.
   *
   * @return possible object is {@link POISystemData }
   */
  public POISystemData getPOISystemData() {
    return poiSystemData;
  }

  /**
   * Sets the value of the poiSystemData property.
   *
   * @param value allowed object is {@link POISystemData }
   */
  public void setPOISystemData(POISystemData value) {
    this.poiSystemData = value;
  }
}
