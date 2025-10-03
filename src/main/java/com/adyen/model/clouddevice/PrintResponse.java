package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Content of the Print Response message. */
@JsonPropertyOrder({"Response", "DocumentQualifier"})
public class PrintResponse {

  @JsonProperty("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  @JsonProperty("DocumentQualifier")
  @Schema(
      description =
          "Qualification of the document to print to the Cashier or the Customer. --Rule: Copy")
  protected DocumentQualifierType documentQualifier;

  /**
   * Gets response.
   *
   * @return the response
   */
  public Response getResponse() {
    return response;
  }

  /**
   * Sets response.
   *
   * @param response the response
   */
  public void setResponse(Response response) {
    this.response = response;
  }

  /**
   * Gets document qualifier.
   *
   * @return the document qualifier
   */
  public DocumentQualifierType getDocumentQualifier() {
    return documentQualifier;
  }

  /**
   * Sets document qualifier.
   *
   * @param documentQualifier the document qualifier
   */
  public void setDocumentQualifier(DocumentQualifierType documentQualifier) {
    this.documentQualifier = documentQualifier;
  }
}
