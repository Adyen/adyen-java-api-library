package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Sale information intended for the Issuer. */
@JsonPropertyOrder({"StatementReference"})
public class SaleToIssuerData {

  @JsonProperty("StatementReference")
  @Schema(
      description =
          "Label to print on the bank statement. --Rule: Information to print on the bank statement")
  protected String statementReference;

  /**
   * Gets statement reference.
   *
   * @return the statement reference
   */
  public String getStatementReference() {
    return statementReference;
  }

  /**
   * Sets statement reference.
   *
   * @param statementReference the statement reference
   */
  public void setStatementReference(String statementReference) {
    this.statementReference = statementReference;
  }
}
