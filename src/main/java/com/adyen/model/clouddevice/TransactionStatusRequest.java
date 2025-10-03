package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

public class TransactionStatusRequest {

  /** The Message reference. */
  @JsonProperty("MessageReference")
  @Schema(
      description =
          "Identification of a previous POI transaction. --Rule: Present if it contains any data")
  protected MessageReference messageReference;

  /** The Document qualifier. */
  @JsonProperty("DocumentQualifier")
  @Schema(
      description =
          "Qualification of the document to print to the Cashier or the Customer. --Rule: CustomerReceipt or CashierReceipt. Mandatory if ReceiptReprintFlag is True, otherwise absent.")
  protected List<DocumentQualifierType> documentQualifier;

  /** The Receipt reprint flag. */
  @JsonProperty("ReceiptReprintFlag")
  @Schema(description = "Request to reprint the POI receipt(s).")
  protected Boolean receiptReprintFlag;

  /**
   * Gets the value of the messageReference property.
   *
   * @return possible object is {@link MessageReference }
   */
  public MessageReference getMessageReference() {
    return messageReference;
  }

  /**
   * Sets the value of the messageReference property.
   *
   * @param value allowed object is {@link MessageReference }
   */
  public void setMessageReference(MessageReference value) {
    this.messageReference = value;
  }

  /**
   * Gets the value of the documentQualifier property.
   *
   * <p>
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the documentQualifier property.
   *
   * <p>
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getDocumentQualifier().add(newItem);
   * </pre>
   *
   * <p>
   *
   * <p>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link DocumentQualifierType }
   *
   * @return the document qualifier
   */
  public List<DocumentQualifierType> getDocumentQualifier() {
    if (documentQualifier == null) {
      documentQualifier = new ArrayList<>();
    }
    return this.documentQualifier;
  }

  /**
   * Gets the value of the receiptReprintFlag property.
   *
   * @return possible object is {@link Boolean }
   */
  public boolean isReceiptReprintFlag() {
    if (receiptReprintFlag == null) {
      return false;
    } else {
      return receiptReprintFlag;
    }
  }

  /**
   * Sets the value of the receiptReprintFlag property.
   *
   * @param value allowed object is {@link Boolean }
   */
  public void setReceiptReprintFlag(Boolean value) {
    this.receiptReprintFlag = value;
  }
}
