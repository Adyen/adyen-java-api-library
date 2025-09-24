package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Content of the Enable Service Request message. */
@JsonPropertyOrder({"ServicesEnabled", "DisplayOutput", "TransactionAction"})
public class EnableServiceRequest {

  @JsonProperty("ServicesEnabled")
  @Schema(
      description =
          "Services which are enabled before the start-up of a transaction --Rule: Mandatory if TransactionAction is \"StartTransaction\", absent if not.")
  protected List<ServicesEnabledType> servicesEnabled;

  @JsonProperty("DisplayOutput")
  @Schema(description = "Information to display and the way to process the display.")
  protected DisplayOutput displayOutput;

  @JsonProperty("TransactionAction")
  @Schema(description = "Action to realise on a transaction.")
  protected TransactionActionType transactionAction;

  /**
   * Gets services enabled.
   *
   * @return the services enabled
   */
  public List<ServicesEnabledType> getServicesEnabled() {
    if (servicesEnabled == null) {
      servicesEnabled = new ArrayList<>();
    }
    return this.servicesEnabled;
  }

  /**
   * Sets services enabled.
   *
   * @param servicesEnabled the services enabled
   */
  public void setServicesEnabled(List<ServicesEnabledType> servicesEnabled) {
    this.servicesEnabled = servicesEnabled;
  }

  /**
   * Gets display output.
   *
   * @return the display output
   */
  public DisplayOutput getDisplayOutput() {
    return displayOutput;
  }

  /**
   * Sets display output.
   *
   * @param displayOutput the display output
   */
  public void setDisplayOutput(DisplayOutput displayOutput) {
    this.displayOutput = displayOutput;
  }

  /**
   * Gets transaction action.
   *
   * @return the transaction action
   */
  public TransactionActionType getTransactionAction() {
    return transactionAction;
  }

  /**
   * Sets transaction action.
   *
   * @param transactionAction the transaction action
   */
  public void setTransactionAction(TransactionActionType transactionAction) {
    this.transactionAction = transactionAction;
  }
}
