package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Content of the Batch Response message. */
@JsonPropertyOrder({"Response", "PerformedTransaction"})
public class BatchResponse {

  @JsonProperty("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  @JsonProperty("PerformedTransaction")
  @Schema(description = "Result of performed transactions.")
  protected List<PerformedTransaction> performedTransaction;

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
   * Gets performed transaction.
   *
   * @return the performed transaction
   */
  public List<PerformedTransaction> getPerformedTransaction() {
    if (performedTransaction == null) {
      performedTransaction = new ArrayList<>();
    }
    return this.performedTransaction;
  }

  /**
   * Sets performed transaction.
   *
   * @param performedTransaction the performed transaction
   */
  public void setPerformedTransaction(List<PerformedTransaction> performedTransaction) {
    this.performedTransaction = performedTransaction;
  }
}