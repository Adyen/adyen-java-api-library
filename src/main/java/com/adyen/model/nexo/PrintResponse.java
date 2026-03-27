package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Definition: Content of the Print Response messageType. -- Usage: It conveys the result of the
 * print, parallel to the messageType request, except if response not required and absent.
 *
 * <p>Java class for PrintResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PrintResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response" type="{}Response"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="DocumentQualifier" use="required" type="{}DocumentQualifierType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class PrintResponse {

  /** The Response. */
  @SerializedName("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  /** The Document qualifier. */
  @SerializedName("DocumentQualifier")
  @Schema(
      description =
          "Qualification of the document to print to the Cashier or the Customer. --Rule: Copy")
  protected DocumentQualifierType documentQualifier;

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
   * Gets the value of the documentQualifier property.
   *
   * @return possible object is {@link DocumentQualifierType }
   */
  public DocumentQualifierType getDocumentQualifier() {
    return documentQualifier;
  }

  /**
   * Sets the value of the documentQualifier property.
   *
   * @param value allowed object is {@link DocumentQualifierType }
   */
  public void setDocumentQualifier(DocumentQualifierType value) {
    this.documentQualifier = value;
  }
}
