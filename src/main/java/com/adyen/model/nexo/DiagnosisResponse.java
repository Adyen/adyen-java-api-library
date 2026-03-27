package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition: Content of the Diagnosis Response messageType. -- Usage: It conveys the result of the
 * requested diagnosis and a possible messageType to display on a logical device.
 *
 * <p>Java class for DiagnosisResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DiagnosisResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response" type="{}Response"/&gt;
 *         &lt;element name="LoggedSaleID" type="{}LoggedSaleID" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="POIStatus" type="{}POIStatus" minOccurs="0"/&gt;
 *         &lt;element name="HostStatus" type="{}HostStatus" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class DiagnosisResponse {

  /** The Response. */
  @SerializedName("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  /** The Logged sale id. */
  @SerializedName("LoggedSaleID")
  @Schema(
      description = "Sale Terminal logged to. --Rule: If Sale Terminal logged to this POI Terminal")
  protected List<String> loggedSaleID;

  /** The Poi status. */
  @SerializedName("POIStatus")
  @Schema(description = "State of a POI Terminal. --Rule: if Response.Result is Success")
  protected POIStatus poiStatus;

  /** The Host status. */
  @SerializedName("HostStatus")
  @Schema(description = "State of a Host.")
  protected List<HostStatus> hostStatus;

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
   * Gets the value of the loggedSaleID property.
   *
   * <p>
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the loggedSaleID property.
   *
   * <p>
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getLoggedSaleID().add(newItem);
   * </pre>
   *
   * <p>
   *
   * <p>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link String }
   *
   * @return the logged sale id
   */
  public List<String> getLoggedSaleID() {
    if (loggedSaleID == null) {
      loggedSaleID = new ArrayList<>();
    }
    return this.loggedSaleID;
  }

  /**
   * Gets the value of the poiStatus property.
   *
   * @return possible object is {@link POIStatus }
   */
  public POIStatus getPOIStatus() {
    return poiStatus;
  }

  /**
   * Sets the value of the poiStatus property.
   *
   * @param value allowed object is {@link POIStatus }
   */
  public void setPOIStatus(POIStatus value) {
    this.poiStatus = value;
  }

  /**
   * Gets the value of the hostStatus property.
   *
   * <p>
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the hostStatus property.
   *
   * <p>
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getHostStatus().add(newItem);
   * </pre>
   *
   * <p>
   *
   * <p>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link HostStatus }
   *
   * @return the host status
   */
  public List<HostStatus> getHostStatus() {
    if (hostStatus == null) {
      hostStatus = new ArrayList<>();
    }
    return this.hostStatus;
  }
}
