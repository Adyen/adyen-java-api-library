package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Content of the Sale to POI Response message. */
@JsonPropertyOrder({
    "MessageHeader",
    "BalanceInquiryResponse",
    "BatchResponse",
    "CardAcquisitionResponse",
    "AdminResponse",
    "DiagnosisResponse",
    "DisplayResponse",
    "EnableServiceResponse",
    "GetTotalsResponse",
    "InputResponse",
    "LoginResponse",
    "LogoutResponse",
    "LoyaltyResponse",
    "PaymentResponse",
    "PINResponse",
    "PrintResponse",
    "CardReaderInitResponse",
    "CardReaderAPDUResponse",
    "CardReaderPowerOffResponse",
    "ReconciliationResponse",
    "ReversalResponse",
    "SoundResponse",
    "StoredValueResponse",
    "TransactionStatusResponse",
    "TransmitResponse",
    "SecurityTrailer"
})
public class SaleToPOIResponse {

  @JsonProperty("MessageHeader")
  protected MessageHeader messageHeader;

  @JsonProperty("BalanceInquiryResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Balance Inquiry Response message.")
  protected BalanceInquiryResponse balanceInquiryResponse;

  @JsonProperty("BatchResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Batch Response message.")
  protected BatchResponse batchResponse;

  @JsonProperty("CardAcquisitionResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Card Acquisition Response message.")
  protected CardAcquisitionResponse cardAcquisitionResponse;

  @JsonProperty("AdminResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Custom Admin Response message.")
  protected AdminResponse adminResponse;

  @JsonProperty("DiagnosisResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Diagnosis Response message.")
  protected DiagnosisResponse diagnosisResponse;

  @JsonProperty("DisplayResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Display Response message.")
  protected DisplayResponse displayResponse;

  @JsonProperty("EnableServiceResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Enable Service Response message.")
  protected EnableServiceResponse enableServiceResponse;

  @JsonProperty("GetTotalsResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Reconciliation Response message.")
  protected GetTotalsResponse getTotalsResponse;

  @JsonProperty("InputResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Input Response message.")
  protected InputResponse inputResponse;

  @JsonProperty("LoginResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Login Response message.")
  protected LoginResponse loginResponse;

  @JsonProperty("LogoutResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Logout Response message.")
  protected LogoutResponse logoutResponse;

  @JsonProperty("LoyaltyResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Loyalty Response message.")
  protected LoyaltyResponse loyaltyResponse;

  @JsonProperty("PaymentResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Payment Response message.")
  protected PaymentResponse paymentResponse;

  @JsonProperty("PINResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the PIN Response message.")
  protected PINResponse pinResponse;

  @JsonProperty("PrintResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Print Response message.")
  protected PrintResponse printResponse;

  @JsonProperty("CardReaderInitResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Card Reader Init Response message.")
  protected CardReaderInitResponse cardReaderInitResponse;

  @JsonProperty("CardReaderAPDUResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Card Reader APDU Response message.")
  protected CardReaderAPDUResponse cardReaderAPDUResponse;

  @JsonProperty("CardReaderPowerOffResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Card Reader Power-Off Response message.")
  protected CardReaderPowerOffResponse cardReaderPowerOffResponse;

  @JsonProperty("ReconciliationResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Reconciliation Response message.")
  protected ReconciliationResponse reconciliationResponse;

  @JsonProperty("ReversalResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Reversal Response message.")
  protected ReversalResponse reversalResponse;

  @JsonProperty("SoundResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Sound Response message.")
  protected SoundResponse soundResponse;

  @JsonProperty("StoredValueResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Stored Value Response message.")
  protected StoredValueResponse storedValueResponse;

  @JsonProperty("TransactionStatusResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the TransactionStatus Response message.")
  protected TransactionStatusResponse transactionStatusResponse;

  @JsonProperty("TransmitResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Content of the Transmit Response message.")
  protected TransmitResponse transmitResponse;

  @JsonProperty("SecurityTrailer")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(description = "Protection of the whole message")
  protected ContentInformation securityTrailer;

  /**
   * Gets message header.
   *
   * @return the message header
   */
  public MessageHeader getMessageHeader() {
    return messageHeader;
  }

  /**
   * Sets message header.
   *
   * @param messageHeader the message header
   */
  public void setMessageHeader(MessageHeader messageHeader) {
    this.messageHeader = messageHeader;
  }

  /**
   * Gets balance inquiry response.
   *
   * @return the balance inquiry response
   */
  public BalanceInquiryResponse getBalanceInquiryResponse() {
    return balanceInquiryResponse;
  }

  /**
   * Sets balance inquiry response.
   *
   * @param balanceInquiryResponse the balance inquiry response
   */
  public void setBalanceInquiryResponse(BalanceInquiryResponse balanceInquiryResponse) {
    this.balanceInquiryResponse = balanceInquiryResponse;
  }

  /**
   * Gets batch response.
   *
   * @return the batch response
   */
  public BatchResponse getBatchResponse() {
    return batchResponse;
  }

  /**
   * Sets batch response.
   *
   * @param batchResponse the batch response
   */
  public void setBatchResponse(BatchResponse batchResponse) {
    this.batchResponse = batchResponse;
  }

  /**
   * Gets card acquisition response.
   *
   * @return the card acquisition response
   */
  public CardAcquisitionResponse getCardAcquisitionResponse() {
    return cardAcquisitionResponse;
  }

  /**
   * Sets card acquisition response.
   *
   * @param cardAcquisitionResponse the card acquisition response
   */
  public void setCardAcquisitionResponse(CardAcquisitionResponse cardAcquisitionResponse) {
    this.cardAcquisitionResponse = cardAcquisitionResponse;
  }

  /**
   * Gets admin response.
   *
   * @return the admin response
   */
  public AdminResponse getAdminResponse() {
    return adminResponse;
  }

  /**
   * Sets admin response.
   *
   * @param adminResponse the admin response
   */
  public void setAdminResponse(AdminResponse adminResponse) {
    this.adminResponse = adminResponse;
  }

  /**
   * Gets diagnosis response.
   *
   * @return the diagnosis response
   */
  public DiagnosisResponse getDiagnosisResponse() {
    return diagnosisResponse;
  }

  /**
   * Sets diagnosis response.
   *
   * @param diagnosisResponse the diagnosis response
   */
  public void setDiagnosisResponse(DiagnosisResponse diagnosisResponse) {
    this.diagnosisResponse = diagnosisResponse;
  }

  /**
   * Gets display response.
   *
   * @return the display response
   */
  public DisplayResponse getDisplayResponse() {
    return displayResponse;
  }

  /**
   * Sets display response.
   *
   * @param displayResponse the display response
   */
  public void setDisplayResponse(DisplayResponse displayResponse) {
    this.displayResponse = displayResponse;
  }

  /**
   * Gets enable service response.
   *
   * @return the enable service response
   */
  public EnableServiceResponse getEnableServiceResponse() {
    return enableServiceResponse;
  }

  /**
   * Sets enable service response.
   *
   * @param enableServiceResponse the enable service response
   */
  public void setEnableServiceResponse(EnableServiceResponse enableServiceResponse) {
    this.enableServiceResponse = enableServiceResponse;
  }

  /**
   * Gets get totals response.
   *
   * @return the get totals response
   */
  public GetTotalsResponse getGetTotalsResponse() {
    return getTotalsResponse;
  }

  /**
   * Sets get totals response.
   *
   * @param getTotalsResponse the get totals response
   */
  public void setGetTotalsResponse(GetTotalsResponse getTotalsResponse) {
    this.getTotalsResponse = getTotalsResponse;
  }

  /**
   * Gets input response.
   *
   * @return the input response
   */
  public InputResponse getInputResponse() {
    return inputResponse;
  }

  /**
   * Sets input response.
   *
   * @param inputResponse the input response
   */
  public void setInputResponse(InputResponse inputResponse) {
    this.inputResponse = inputResponse;
  }

  /**
   * Gets login response.
   *
   * @return the login response
   */
  public LoginResponse getLoginResponse() {
    return loginResponse;
  }

  /**
   * Sets login response.
   *
   * @param loginResponse the login response
   */
  public void setLoginResponse(LoginResponse loginResponse) {
    this.loginResponse = loginResponse;
  }

  /**
   * Gets logout response.
   *
   * @return the logout response
   */
  public LogoutResponse getLogoutResponse() {
    return logoutResponse;
  }

  /**
   * Sets logout response.
   *
   * @param logoutResponse the logout response
   */
  public void setLogoutResponse(LogoutResponse logoutResponse) {
    this.logoutResponse = logoutResponse;
  }

  /**
   * Gets loyalty response.
   *
   * @return the loyalty response
   */
  public LoyaltyResponse getLoyaltyResponse() {
    return loyaltyResponse;
  }

  /**
   * Sets loyalty response.
   *
   * @param loyaltyResponse the loyalty response
   */
  public void setLoyaltyResponse(LoyaltyResponse loyaltyResponse) {
    this.loyaltyResponse = loyaltyResponse;
  }

  /**
   * Gets payment response.
   *
   * @return the payment response
   */
  public PaymentResponse getPaymentResponse() {
    return paymentResponse;
  }

  /**
   * Sets payment response.
   *
   * @param paymentResponse the payment response
   */
  public void setPaymentResponse(PaymentResponse paymentResponse) {
    this.paymentResponse = paymentResponse;
  }

  /**
   * Gets pin response.
   *
   * @return the pin response
   */
  public PINResponse getPINResponse() {
    return pinResponse;
  }

  /**
   * Sets pin response.
   *
   * @param pinResponse the pin response
   */
  public void setPINResponse(PINResponse pinResponse) {
    this.pinResponse = pinResponse;
  }

  /**
   * Gets print response.
   *
   * @return the print response
   */
  public PrintResponse getPrintResponse() {
    return printResponse;
  }

  /**
   * Sets print response.
   *
   * @param printResponse the print response
   */
  public void setPrintResponse(PrintResponse printResponse) {
    this.printResponse = printResponse;
  }

  /**
   * Gets card reader init response.
   *
   * @return the card reader init response
   */
  public CardReaderInitResponse getCardReaderInitResponse() {
    return cardReaderInitResponse;
  }

  /**
   * Sets card reader init response.
   *
   * @param cardReaderInitResponse the card reader init response
   */
  public void setCardReaderInitResponse(CardReaderInitResponse cardReaderInitResponse) {
    this.cardReaderInitResponse = cardReaderInitResponse;
  }

  /**
   * Gets card reader apdu response.
   *
   * @return the card reader apdu response
   */
  public CardReaderAPDUResponse getCardReaderAPDUResponse() {
    return cardReaderAPDUResponse;
  }

  /**
   * Sets card reader apdu response.
   *
   * @param cardReaderAPDUResponse the card reader apdu response
   */
  public void setCardReaderAPDUResponse(CardReaderAPDUResponse cardReaderAPDUResponse) {
    this.cardReaderAPDUResponse = cardReaderAPDUResponse;
  }

  /**
   * Gets card reader power off response.
   *
   * @return the card reader power off response
   */
  public CardReaderPowerOffResponse getCardReaderPowerOffResponse() {
    return cardReaderPowerOffResponse;
  }

  /**
   * Sets card reader power off response.
   *
   * @param cardReaderPowerOffResponse the card reader power off response
   */
  public void setCardReaderPowerOffResponse(CardReaderPowerOffResponse cardReaderPowerOffResponse) {
    this.cardReaderPowerOffResponse = cardReaderPowerOffResponse;
  }

  /**
   * Gets reconciliation response.
   *
   * @return the reconciliation response
   */
  public ReconciliationResponse getReconciliationResponse() {
    return reconciliationResponse;
  }

  /**
   * Sets reconciliation response.
   *
   * @param reconciliationResponse the reconciliation response
   */
  public void setReconciliationResponse(ReconciliationResponse reconciliationResponse) {
    this.reconciliationResponse = reconciliationResponse;
  }

  /**
   * Gets reversal response.
   *
   * @return the reversal response
   */
  public ReversalResponse getReversalResponse() {
    return reversalResponse;
  }

  /**
   * Sets reversal response.
   *
   * @param reversalResponse the reversal response
   */
  public void setReversalResponse(ReversalResponse reversalResponse) {
    this.reversalResponse = reversalResponse;
  }

  /**
   * Gets sound response.
   *
   * @return the sound response
   */
  public SoundResponse getSoundResponse() {
    return soundResponse;
  }

  /**
   * Sets sound response.
   *
   * @param soundResponse the sound response
   */
  public void setSoundResponse(SoundResponse soundResponse) {
    this.soundResponse = soundResponse;
  }

  /**
   * Gets stored value response.
   *
   * @return the stored value response
   */
  public StoredValueResponse getStoredValueResponse() {
    return storedValueResponse;
  }

  /**
   * Sets stored value response.
   *
   * @param storedValueResponse the stored value response
   */
  public void setStoredValueResponse(StoredValueResponse storedValueResponse) {
    this.storedValueResponse = storedValueResponse;
  }

  /**
   * Gets transaction status response.
   *
   * @return the transaction status response
   */
  public TransactionStatusResponse getTransactionStatusResponse() {
    return transactionStatusResponse;
  }

  /**
   * Sets transaction status response.
   *
   * @param transactionStatusResponse the transaction status response
   */
  public void setTransactionStatusResponse(TransactionStatusResponse transactionStatusResponse) {
    this.transactionStatusResponse = transactionStatusResponse;
  }

  /**
   * Gets transmit response.
   *
   * @return the transmit response
   */
  public TransmitResponse getTransmitResponse() {
    return transmitResponse;
  }

  /**
   * Sets transmit response.
   *
   * @param transmitResponse the transmit response
   */
  public void setTransmitResponse(TransmitResponse transmitResponse) {
    this.transmitResponse = transmitResponse;
  }

  /**
   * Gets security trailer.
   *
   * @return the security trailer
   */
  public ContentInformation getSecurityTrailer() {
    return securityTrailer;
  }

  /**
   * Sets security trailer.
   *
   * @param securityTrailer the security trailer
   */
  public void setSecurityTrailer(ContentInformation securityTrailer) {
    this.securityTrailer = securityTrailer;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SaleToPOIResponse {\n");
    sb.append("    messageHeader: ").append(toIndentedString(messageHeader)).append("\n");
    sb.append("    balanceInquiryResponse: ").append(toIndentedString(balanceInquiryResponse)).append("\n");
    sb.append("    batchResponse: ").append(toIndentedString(batchResponse)).append("\n");
    sb.append("    cardAcquisitionResponse: ").append(toIndentedString(cardAcquisitionResponse)).append("\n");
    sb.append("    adminResponse: ").append(toIndentedString(adminResponse)).append("\n");
    sb.append("    diagnosisResponse: ").append(toIndentedString(diagnosisResponse)).append("\n");
    sb.append("    displayResponse: ").append(toIndentedString(displayResponse)).append("\n");
    sb.append("    enableServiceResponse: ").append(toIndentedString(enableServiceResponse)).append("\n");
    sb.append("    getTotalsResponse: ").append(toIndentedString(getTotalsResponse)).append("\n");
    sb.append("    inputResponse: ").append(toIndentedString(inputResponse)).append("\n");
    sb.append("    loginResponse: ").append(toIndentedString(loginResponse)).append("\n");
    sb.append("    logoutResponse: ").append(toIndentedString(logoutResponse)).append("\n");
    sb.append("    loyaltyResponse: ").append(toIndentedString(loyaltyResponse)).append("\n");
    sb.append("    paymentResponse: ").append(toIndentedString(paymentResponse)).append("\n");
    sb.append("    pinResponse: ").append(toIndentedString(pinResponse)).append("\n");
    sb.append("    printResponse: ").append(toIndentedString(printResponse)).append("\n");
    sb.append("    cardReaderInitResponse: ").append(toIndentedString(cardReaderInitResponse)).append("\n");
    sb.append("    cardReaderAPDUResponse: ").append(toIndentedString(cardReaderAPDUResponse)).append("\n");
    sb.append("    cardReaderPowerOffResponse: ").append(toIndentedString(cardReaderPowerOffResponse)).append("\n");
    sb.append("    reconciliationResponse: ").append(toIndentedString(reconciliationResponse)).append("\n");
    sb.append("    reversalResponse: ").append(toIndentedString(reversalResponse)).append("\n");
    sb.append("    soundResponse: ").append(toIndentedString(soundResponse)).append("\n");
    sb.append("    storedValueResponse: ").append(toIndentedString(storedValueResponse)).append("\n");
    sb.append("    transactionStatusResponse: ").append(toIndentedString(transactionStatusResponse)).append("\n");
    sb.append("    transmitResponse: ").append(toIndentedString(transmitResponse)).append("\n");
    sb.append("    securityTrailer: ").append(toIndentedString(securityTrailer)).append("\n");
    sb.append("}\n");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}