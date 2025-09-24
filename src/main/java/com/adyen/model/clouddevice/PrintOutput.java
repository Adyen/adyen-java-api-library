package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Information to print and the way to process the print. */
@JsonPropertyOrder({
  "OutputContent",
  "OutputSignature",
  "DocumentQualifier",
  "ResponseMode",
  "IntegratedPrintFlag",
  "RequiredSignatureFlag"
})
public class PrintOutput {

  @JsonProperty("OutputContent")
  @Schema(description = "Content to display or print.")
  protected OutputContent outputContent;

  @JsonProperty("OutputSignature")
  @Schema(
      description =
          "Vendor specific signature of text message to display or print. --Rule: If protection has to be provided to the vendor on the text to display or print.")
  protected byte[] outputSignature;

  @JsonProperty("DocumentQualifier")
  @Schema(description = "Qualification of the document to print to the Cashier or the Customer.")
  protected DocumentQualifierType documentQualifier;

  @JsonProperty("ResponseMode")
  @Schema(description = "Message response awaited by the initiator of the Request")
  protected ResponseModeType responseMode;

  @JsonProperty("IntegratedPrintFlag")
  @Schema(description = "Type of the print integrated to other prints.")
  protected Boolean integratedPrintFlag;

  @JsonProperty("RequiredSignatureFlag")
  @Schema(
      description =
          "Indicate that the cardholder payment receipt requires a physical signature by the Customer.")
  protected Boolean requiredSignatureFlag;

  /**
   * Gets output content.
   *
   * @return the output content
   */
  public OutputContent getOutputContent() {
    return outputContent;
  }

  /**
   * Sets output content.
   *
   * @param outputContent the output content
   */
  public void setOutputContent(OutputContent outputContent) {
    this.outputContent = outputContent;
  }

  /**
   * Get output signature.
   *
   * @return the byte [ ]
   */
  public byte[] getOutputSignature() {
    return outputSignature;
  }

  /**
   * Sets output signature.
   *
   * @param outputSignature the output signature
   */
  public void setOutputSignature(byte[] outputSignature) {
    this.outputSignature = outputSignature;
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

  /**
   * Gets response mode.
   *
   * @return the response mode
   */
  public ResponseModeType getResponseMode() {
    return responseMode;
  }

  /**
   * Sets response mode.
   *
   * @param responseMode the response mode
   */
  public void setResponseMode(ResponseModeType responseMode) {
    this.responseMode = responseMode;
  }

  /**
   * Is integrated print flag boolean.
   *
   * @return the boolean
   */
  public boolean isIntegratedPrintFlag() {
    if (integratedPrintFlag == null) {
      return false;
    } else {
      return integratedPrintFlag;
    }
  }

  /**
   * Sets integrated print flag.
   *
   * @param integratedPrintFlag the integrated print flag
   */
  public void setIntegratedPrintFlag(Boolean integratedPrintFlag) {
    this.integratedPrintFlag = integratedPrintFlag;
  }

  /**
   * Is required signature flag boolean.
   *
   * @return the boolean
   */
  public boolean isRequiredSignatureFlag() {
    if (requiredSignatureFlag == null) {
      return false;
    } else {
      return requiredSignatureFlag;
    }
  }

  /**
   * Sets required signature flag.
   *
   * @param requiredSignatureFlag the required signature flag
   */
  public void setRequiredSignatureFlag(Boolean requiredSignatureFlag) {
    this.requiredSignatureFlag = requiredSignatureFlag;
  }
}
