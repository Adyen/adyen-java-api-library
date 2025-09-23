package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Customer or Merchant payment receipt. */
@JsonPropertyOrder({
    "OutputContent",
    "DocumentQualifier",
    "IntegratedPrintFlag",
    "RequiredSignatureFlag"
})
public class PaymentReceipt {

  @JsonProperty("OutputContent")
  @Schema(description = "Content to display or print.")
  protected OutputContent outputContent;

  @JsonProperty("DocumentQualifier")
  @Schema(
      description =
          "Qualification of the document to print to the Cashier or the Customer. --Rule: SaleReceipt or CashierReceipt")
  protected DocumentQualifierType documentQualifier;

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