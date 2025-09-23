package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Content of the Batch Request message. */
@JsonPropertyOrder({"TransactionToPerform", "RemoveAllFlag"})
public class BatchRequest {

  @JsonProperty("TransactionToPerform")
  @Schema(description = "Content of the Batch Request message")
  protected List<TransactionToPerform> transactionToPerform;

  @JsonProperty("RemoveAllFlag")
  @Schema(
      description =
          "A flag requesting to remove the transactions stored and not yet performed. default False.")
  protected Boolean removeAllFlag;

  /**
   * Gets transaction to perform.
   *
   * @return the transaction to perform
   */
  public List<TransactionToPerform> getTransactionToPerform() {
    if (transactionToPerform == null) {
      transactionToPerform = new ArrayList<>();
    }
    return this.transactionToPerform;
  }

  /**
   * Sets transaction to perform.
   *
   * @param transactionToPerform the transaction to perform
   */
  public void setTransactionToPerform(List<TransactionToPerform> transactionToPerform) {
    this.transactionToPerform = transactionToPerform;
  }

  /**
   * Is remove all flag boolean.
   *
   * @return the boolean
   */
  public Boolean isRemoveAllFlag() {
    return removeAllFlag;
  }

  /**
   * Sets remove all flag.
   *
   * @param removeAllFlag the remove all flag
   */
  public void setRemoveAllFlag(Boolean removeAllFlag) {
    this.removeAllFlag = removeAllFlag;
  }
}