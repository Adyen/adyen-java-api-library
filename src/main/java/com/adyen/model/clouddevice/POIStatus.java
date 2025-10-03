package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** State of a POI Terminal. */
@JsonPropertyOrder({
  "CashHandlingDevice",
  "GlobalStatus",
  "SecurityOKFlag",
  "PEDOKFlag",
  "CardReaderOKFlag",
  "PrinterStatus",
  "CommunicationOKFlag",
  "FraudPreventionFlag"
})
public class POIStatus {

  @JsonProperty("CashHandlingDevice")
  @Schema(description = "Status of cash handling device. --Rule: If cash handling devices present.")
  protected List<CashHandlingDevice> cashHandlingDevice;

  @JsonProperty("GlobalStatus")
  @Schema(description = "Global status of a POI Server or POI Terminal.")
  protected GlobalStatusType globalStatus;

  @JsonProperty("SecurityOKFlag")
  @Schema(
      description =
          "Indicates if the security module of the POI is working and usable. --Rule: If security module present")
  protected Boolean securityOKFlag;

  @JsonProperty("PEDOKFlag")
  @Schema(description = "Indicates if the PED is working and usable. --Rule: If PED present")
  protected Boolean pedokFlag;

  @JsonProperty("CardReaderOKFlag")
  @Schema(
      description =
          "Indicates if the card readers are working and usable. --Rule: If card reader device present")
  protected Boolean cardReaderOKFlag;

  @JsonProperty("PrinterStatus")
  @Schema(
      description =
          "Indicates if the printer is working and usable. --Rule: If printer device present")
  protected PrinterStatusType printerStatus;

  @JsonProperty("CommunicationOKFlag")
  @Schema(
      description =
          "Indicates if the communication infrastructure is working and usable. --Rule: If communication infrastructure present")
  protected Boolean communicationOKFlag;

  @JsonProperty("FraudPreventionFlag")
  @Schema(description = "Indicate a suspicion of fraud by the POI System. --Rule: default False")
  protected Boolean fraudPreventionFlag;

  /**
   * Gets cash handling device.
   *
   * @return the cash handling device
   */
  public List<CashHandlingDevice> getCashHandlingDevice() {
    if (cashHandlingDevice == null) {
      cashHandlingDevice = new ArrayList<>();
    }
    return this.cashHandlingDevice;
  }

  /**
   * Sets cash handling device.
   *
   * @param cashHandlingDevice the cash handling device
   */
  public void setCashHandlingDevice(List<CashHandlingDevice> cashHandlingDevice) {
    this.cashHandlingDevice = cashHandlingDevice;
  }

  /**
   * Gets global status.
   *
   * @return the global status
   */
  public GlobalStatusType getGlobalStatus() {
    return globalStatus;
  }

  /**
   * Sets global status.
   *
   * @param globalStatus the global status
   */
  public void setGlobalStatus(GlobalStatusType globalStatus) {
    this.globalStatus = globalStatus;
  }

  /**
   * Is security ok flag boolean.
   *
   * @return the boolean
   */
  public Boolean isSecurityOKFlag() {
    return securityOKFlag;
  }

  /**
   * Sets security ok flag.
   *
   * @param securityOKFlag the security ok flag
   */
  public void setSecurityOKFlag(Boolean securityOKFlag) {
    this.securityOKFlag = securityOKFlag;
  }

  /**
   * Is pedok flag boolean.
   *
   * @return the boolean
   */
  public Boolean isPEDOKFlag() {
    return pedokFlag;
  }

  /**
   * Sets pedok flag.
   *
   * @param pedokFlag the pedok flag
   */
  public void setPEDOKFlag(Boolean pedokFlag) {
    this.pedokFlag = pedokFlag;
  }

  /**
   * Is card reader ok flag boolean.
   *
   * @return the boolean
   */
  public Boolean isCardReaderOKFlag() {
    return cardReaderOKFlag;
  }

  /**
   * Sets card reader ok flag.
   *
   * @param cardReaderOKFlag the card reader ok flag
   */
  public void setCardReaderOKFlag(Boolean cardReaderOKFlag) {
    this.cardReaderOKFlag = cardReaderOKFlag;
  }

  /**
   * Gets printer status.
   *
   * @return the printer status
   */
  public PrinterStatusType getPrinterStatus() {
    return printerStatus;
  }

  /**
   * Sets printer status.
   *
   * @param printerStatus the printer status
   */
  public void setPrinterStatus(PrinterStatusType printerStatus) {
    this.printerStatus = printerStatus;
  }

  /**
   * Is communication ok flag boolean.
   *
   * @return the boolean
   */
  public Boolean isCommunicationOKFlag() {
    return communicationOKFlag;
  }

  /**
   * Sets communication ok flag.
   *
   * @param communicationOKFlag the communication ok flag
   */
  public void setCommunicationOKFlag(Boolean communicationOKFlag) {
    this.communicationOKFlag = communicationOKFlag;
  }

  /**
   * Is fraud prevention flag boolean.
   *
   * @return the boolean
   */
  public Boolean isFraudPreventionFlag() {
    return fraudPreventionFlag;
  }

  /**
   * Sets fraud prevention flag.
   *
   * @param fraudPreventionFlag the fraud prevention flag
   */
  public void setFraudPreventionFlag(Boolean fraudPreventionFlag) {
    this.fraudPreventionFlag = fraudPreventionFlag;
  }
}
