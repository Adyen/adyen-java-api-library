package com.adyen.terminal;

import com.adyen.model.terminal.AdminResponse;
import com.adyen.model.terminal.BalanceInquiryResponse;
import com.adyen.model.terminal.CardAcquisitionResponse;
import com.adyen.model.terminal.CardReaderAPDUResponse;
import com.adyen.model.terminal.DiagnosisResponse;
import com.adyen.model.terminal.DisplayResponse;
import com.adyen.model.terminal.EnableServiceResponse;
import com.adyen.model.terminal.EventNotification;
import com.adyen.model.terminal.GetTotalsResponse;
import com.adyen.model.terminal.InputResponse;
import com.adyen.model.terminal.InputUpdate;
import com.adyen.model.terminal.JSON;
import com.adyen.model.terminal.LoginResponse;
import com.adyen.model.terminal.LogoutResponse;
import com.adyen.model.terminal.LoyaltyResponse;
import com.adyen.model.terminal.MessageHeader;

import com.adyen.model.terminal.PaymentResponse;
import com.adyen.model.terminal.PrintResponse;
import com.adyen.model.terminal.ReconciliationResponse;
import com.adyen.model.terminal.ReversalResponse;
import com.adyen.model.terminal.SecurityTrailer;
import com.adyen.model.terminal.StoredValueResponse;
import com.adyen.model.terminal.TransactionStatusResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "SaleToPoiResponse")
@JsonPropertyOrder({
        SaleToPOIResponse.JSON_PROPERTY_MESSAGE_HEADER,
        SaleToPOIResponse.JSON_PROPERTY_BALANCE_INQUIRY_RESPONSE,
        SaleToPOIResponse.JSON_PROPERTY_CARD_INQUISITION_RESPONSE,
        SaleToPOIResponse.JSON_PROPERTY_ADMIN_RESPONSE,
        SaleToPOIResponse.JSON_PROPERTY_DIAGNOSIS_RESPONSE,
        SaleToPOIResponse.JSON_PROPERTY_DISPLAY_RESPONSE,
        SaleToPOIResponse.JSON_PROPERTY_ENABLE_SERVICE_RESPONSE,
        SaleToPOIResponse.JSON_PROPERTY_EVENT_NOTIFICATION,
        SaleToPOIResponse.JSON_PROPERTY_GET_TOTALS_RESPONSE,
        SaleToPOIResponse.JSON_PROPERTY_INPUT_RESPONSE,
        SaleToPOIResponse.JSON_PROPERTY_INPUT_UPDATE,
        SaleToPOIResponse.JSON_PROPERTY_LOGIN_RESPONSE,
        SaleToPOIResponse.JSON_PROPERTY_LOGOUT_RESPONSE,
        SaleToPOIResponse.JSON_PROPERTY_LOYALTY_RESPONSE,
        SaleToPOIResponse.JSON_PROPERTY_PAYMENT_RESPONSE,
        SaleToPOIResponse.JSON_PROPERTY_PRINT_RESPONSE,
        SaleToPOIResponse.JSON_PROPERTY_CARD_READER_APDU_RESPONSE,
        SaleToPOIResponse.JSON_PROPERTY_RECONCILIATION_RESPONSE,
        SaleToPOIResponse.JSON_PROPERTY_REVERSAL_RESPONSE,
        SaleToPOIResponse.JSON_PROPERTY_SOTRED_VALUE_RESPONSE,
        SaleToPOIResponse.JSON_PROPERTY_TRANSACTION_STATUS_RESPONSE,
        SaleToPOIResponse.JSON_PROPERTY_SECURITY_TRAILER
})
public class SaleToPOIResponse {

    /**
     * The Message header.
     */
    public static final String JSON_PROPERTY_MESSAGE_HEADER = "MessageHeader";
    protected MessageHeader messageHeader;
    /**
     * The Balance inquiry Response.
     */
    public static final String JSON_PROPERTY_BALANCE_INQUIRY_RESPONSE = "BalanceInquiryResponse";
    protected BalanceInquiryResponse balanceInquiryResponse;
    /**
     * The Card acquisition Response.
     */
    public static final String JSON_PROPERTY_CARD_INQUISITION_RESPONSE = "CardAcquisitionResponse";
    protected CardAcquisitionResponse cardAcquisitionResponse;
    /**
     * The Admin Response.
     */
    public static final String JSON_PROPERTY_ADMIN_RESPONSE = "AdminResponse";
    protected AdminResponse adminResponse;
    /**
     * The Diagnosis Response.
     */
    public static final String JSON_PROPERTY_DIAGNOSIS_RESPONSE = "DiagnosisResponse";
    protected DiagnosisResponse diagnosisResponse;
    /**
     * The Display Response.
     */
    public static final String JSON_PROPERTY_DISPLAY_RESPONSE = "DisplayResponse";
    protected DisplayResponse displayResponse;
    /**
     * The Enable service Response.
     */
    public static final String JSON_PROPERTY_ENABLE_SERVICE_RESPONSE = "EnableServiceResponse";
    protected EnableServiceResponse enableServiceResponse;
    /**
     * The Event notification.
     */
    public static final String JSON_PROPERTY_EVENT_NOTIFICATION = "EventNotification";
    protected EventNotification eventNotification;
    /**
     * The Get totals Response.
     */
    public static final String JSON_PROPERTY_GET_TOTALS_RESPONSE = "GetTotalsResponse";
    protected GetTotalsResponse getTotalsResponse;
    /**
     * The Input Response.
     */
    public static final String JSON_PROPERTY_INPUT_RESPONSE = "InputResponse";
    protected InputResponse inputResponse;
    /**
     * The Input update.
     */
    public static final String JSON_PROPERTY_INPUT_UPDATE = "InputUpdate";
    protected InputUpdate inputUpdate;
    /**
     * The Login Response.
     */
    public static final String JSON_PROPERTY_LOGIN_RESPONSE = "LoginResponse";
    protected LoginResponse loginResponse;
    /**
     * The Logout Response.
     */
    public static final String JSON_PROPERTY_LOGOUT_RESPONSE = "LogoutResponse";
    protected LogoutResponse logoutResponse;
    /**
     * The Loyalty Response.
     */
    public static final String JSON_PROPERTY_LOYALTY_RESPONSE = "LoyaltyResponse";
    protected LoyaltyResponse loyaltyResponse;
    /**
     * The Payment Response.
     */
    public static final String JSON_PROPERTY_PAYMENT_RESPONSE = "PaymentResponse";
    protected PaymentResponse paymentResponse;
    /**
     * The Print Response.
     */
    public static final String JSON_PROPERTY_PRINT_RESPONSE = "PrintResponse";
    protected PrintResponse printResponse;
    /**
     * The Card reader apdu Response.
     */
    public static final String JSON_PROPERTY_CARD_READER_APDU_RESPONSE = "CardReaderAPDUResponse";
    protected CardReaderAPDUResponse cardReaderAPDUResponse;
    /**
     * The Reconciliation Response.
     */
    public static final String JSON_PROPERTY_RECONCILIATION_RESPONSE = "ReconciliationResponse";
    protected ReconciliationResponse reconciliationResponse;
    /**
     * The Reversal Response.
     */
    public static final String JSON_PROPERTY_REVERSAL_RESPONSE = "ReversalResponse";
    protected ReversalResponse reversalResponse;
    /**
     * The Stored value Response.
     */
    public static final String JSON_PROPERTY_SOTRED_VALUE_RESPONSE = "StoredValueResponse";
    protected StoredValueResponse storedValueResponse;
    /**
     * The Transaction status Response.
     */
    public static final String JSON_PROPERTY_TRANSACTION_STATUS_RESPONSE = "TransactionStatusResponse";
    protected TransactionStatusResponse transactionStatusResponse;
    /**
     * The Security trailer.
     */
    public static final String JSON_PROPERTY_SECURITY_TRAILER = "SecurityTrailer";
    protected SecurityTrailer securityTrailer;

    /**
     * Gets the value of the messageHeader property.
     *
     * @return possible      object is     {@link MessageHeader }
     */
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_MESSAGE_HEADER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    /**
     * Sets the value of the messageHeader property.
     *
     * @param value allowed object is     {@link MessageHeader }
     */
    @JsonProperty(JSON_PROPERTY_MESSAGE_HEADER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMessageHeader(MessageHeader value) {
        this.messageHeader = value;
    }

    /**
     * Gets the value of the balanceInquiryResponse property.
     *
     * @return possible      object is     {@link BalanceInquiryResponse }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_BALANCE_INQUIRY_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public BalanceInquiryResponse getBalanceInquiryResponse() {
        return balanceInquiryResponse;
    }

    /**
     * Sets the value of the balanceInquiryResponse property.
     *
     * @param value allowed object is     {@link BalanceInquiryResponse }
     */
    @JsonProperty(JSON_PROPERTY_BALANCE_INQUIRY_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBalanceInquiryResponse(BalanceInquiryResponse value) {
        this.balanceInquiryResponse = value;
    }

    /**
     * Gets the value of the cardAcquisitionResponse property.
     *
     * @return possible      object is     {@link CardAcquisitionResponse }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_CARD_INQUISITION_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public CardAcquisitionResponse getCardAcquisitionResponse() {
        return cardAcquisitionResponse;
    }

    /**
     * Sets the value of the cardAcquisitionResponse property.
     *
     * @param value allowed object is     {@link CardAcquisitionResponse }
     */
    @JsonProperty(JSON_PROPERTY_CARD_INQUISITION_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCardAcquisitionResponse(CardAcquisitionResponse value) {
        this.cardAcquisitionResponse = value;
    }

    /**
     * Gets the value of the adminResponse property.
     *
     * @return possible      object is     {@link AdminResponse }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_ADMIN_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public AdminResponse getAdminResponse() {
        return adminResponse;
    }

    /**
     * Sets the value of the adminResponse property.
     *
     * @param value allowed object is     {@link AdminResponse }
     */
    @JsonProperty(JSON_PROPERTY_ADMIN_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAdminResponse(AdminResponse value) {
        this.adminResponse = value;
    }

    /**
     * Gets the value of the diagnosisResponse property.
     *
     * @return possible      object is     {@link DiagnosisResponse }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_DIAGNOSIS_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public DiagnosisResponse getDiagnosisResponse() {
        return diagnosisResponse;
    }

    /**
     * Sets the value of the diagnosisResponse property.
     *
     * @param value allowed object is     {@link DiagnosisResponse }
     */
    @JsonProperty(JSON_PROPERTY_DIAGNOSIS_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDiagnosisResponse(DiagnosisResponse value) {
        this.diagnosisResponse = value;
    }

    /**
     * Gets the value of the displayResponse property.
     *
     * @return possible      object is     {@link DisplayResponse }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_DISPLAY_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public DisplayResponse getDisplayResponse() {
        return displayResponse;
    }

    /**
     * Sets the value of the displayResponse property.
     *
     * @param value allowed object is     {@link DisplayResponse }
     */
    @JsonProperty(JSON_PROPERTY_DISPLAY_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDisplayResponse(DisplayResponse value) {
        this.displayResponse = value;
    }

    /**
     * Gets the value of the enableServiceResponse property.
     *
     * @return possible      object is     {@link EnableServiceResponse }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_ENABLE_SERVICE_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public EnableServiceResponse getEnableServiceResponse() {
        return enableServiceResponse;
    }

    /**
     * Sets the value of the enableServiceResponse property.
     *
     * @param value allowed object is     {@link EnableServiceResponse }
     */
    @JsonProperty(JSON_PROPERTY_ENABLE_SERVICE_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEnableServiceResponse(EnableServiceResponse value) {
        this.enableServiceResponse = value;
    }

    /**
     * Gets the value of the eventNotification property.
     *
     * @return possible      object is     {@link EventNotification }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_EVENT_NOTIFICATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public EventNotification getEventNotification() {
        return eventNotification;
    }

    /**
     * Sets the value of the eventNotification property.
     *
     * @param value allowed object is     {@link EventNotification }
     */
    @JsonProperty(JSON_PROPERTY_EVENT_NOTIFICATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEventNotification(EventNotification value) {
        this.eventNotification = value;
    }

    /**
     * Gets the value of the getTotalsResponse property.
     *
     * @return possible      object is     {@link GetTotalsResponse }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_GET_TOTALS_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public GetTotalsResponse getGetTotalsResponse() {
        return getTotalsResponse;
    }

    /**
     * Sets the value of the getTotalsResponse property.
     *
     * @param value allowed object is     {@link GetTotalsResponse }
     */
    @JsonProperty(JSON_PROPERTY_GET_TOTALS_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setGetTotalsResponse(GetTotalsResponse value) {
        this.getTotalsResponse = value;
    }

    /**
     * Gets the value of the inputResponse property.
     *
     * @return possible      object is     {@link InputResponse }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_INPUT_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public InputResponse getInputResponse() {
        return inputResponse;
    }

    /**
     * Sets the value of the inputResponse property.
     *
     * @param value allowed object is     {@link InputResponse }
     */
    @JsonProperty(JSON_PROPERTY_INPUT_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInputResponse(InputResponse value) {
        this.inputResponse = value;
    }

    /**
     * Gets the value of the inputUpdate property.
     *
     * @return possible      object is     {@link InputUpdate }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_INPUT_UPDATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public InputUpdate getInputUpdate() {
        return inputUpdate;
    }

    /**
     * Sets the value of the inputUpdate property.
     *
     * @param value allowed object is     {@link InputUpdate }
     */
    @JsonProperty(JSON_PROPERTY_INPUT_UPDATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInputUpdate(InputUpdate value) {
        this.inputUpdate = value;
    }

    /**
     * Gets the value of the loginResponse property.
     *
     * @return possible      object is     {@link LoginResponse }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_LOGIN_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public LoginResponse getLoginResponse() {
        return loginResponse;
    }

    /**
     * Sets the value of the loginResponse property.
     *
     * @param value allowed object is     {@link LoginResponse }
     */
    @JsonProperty(JSON_PROPERTY_LOGIN_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLoginResponse(LoginResponse value) {
        this.loginResponse = value;
    }

    /**
     * Gets the value of the logoutResponse property.
     *
     * @return possible      object is     {@link LogoutResponse }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_LOGOUT_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public LogoutResponse getLogoutResponse() {
        return logoutResponse;
    }

    /**
     * Sets the value of the logoutResponse property.
     *
     * @param value allowed object is     {@link LogoutResponse }
     */
    @JsonProperty(JSON_PROPERTY_LOGOUT_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLogoutResponse(LogoutResponse value) {
        this.logoutResponse = value;
    }

    /**
     * Gets the value of the loyaltyResponse property.
     *
     * @return possible      object is     {@link LoyaltyResponse }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_LOYALTY_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public LoyaltyResponse getLoyaltyResponse() {
        return loyaltyResponse;
    }

    /**
     * Sets the value of the loyaltyResponse property.
     *
     * @param value allowed object is     {@link LoyaltyResponse }
     */
    @JsonProperty(JSON_PROPERTY_LOYALTY_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLoyaltyResponse(LoyaltyResponse value) {
        this.loyaltyResponse = value;
    }

    /**
     * Gets the value of the paymentResponse property.
     *
     * @return possible      object is     {@link PaymentResponse }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_PAYMENT_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public PaymentResponse getPaymentResponse() {
        return paymentResponse;
    }

    /**
     * Sets the value of the paymentResponse property.
     *
     * @param value allowed object is     {@link PaymentResponse }
     */
    @JsonProperty(JSON_PROPERTY_PAYMENT_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPaymentResponse(PaymentResponse value) {
        this.paymentResponse = value;
    }

    /**
     * Gets the value of the printResponse property.
     *
     * @return possible      object is     {@link PrintResponse }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_PRINT_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public PrintResponse getPrintResponse() {
        return printResponse;
    }

    /**
     * Sets the value of the printResponse property.
     *
     * @param value allowed object is     {@link PrintResponse }
     */
    @JsonProperty(JSON_PROPERTY_PRINT_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPrintResponse(PrintResponse value) {
        this.printResponse = value;
    }

    /**
     * Gets the value of the cardReaderAPDUResponse property.
     *
     * @return possible      object is     {@link CardReaderAPDUResponse }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_CARD_READER_APDU_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public CardReaderAPDUResponse getCardReaderAPDUResponse() {
        return cardReaderAPDUResponse;
    }

    /**
     * Sets the value of the cardReaderAPDUResponse property.
     *
     * @param value allowed object is     {@link CardReaderAPDUResponse }
     */
    @JsonProperty(JSON_PROPERTY_CARD_READER_APDU_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCardReaderAPDUResponse(CardReaderAPDUResponse value) {
        this.cardReaderAPDUResponse = value;
    }

    /**
     * Gets the value of the reconciliationResponse property.
     *
     * @return possible      object is     {@link ReconciliationResponse }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_RECONCILIATION_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public ReconciliationResponse getReconciliationResponse() {
        return reconciliationResponse;
    }

    /**
     * Sets the value of the reconciliationResponse property.
     *
     * @param value allowed object is     {@link ReconciliationResponse }
     */
    @JsonProperty(JSON_PROPERTY_RECONCILIATION_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReconciliationResponse(ReconciliationResponse value) {
        this.reconciliationResponse = value;
    }

    /**
     * Gets the value of the reversalResponse property.
     *
     * @return possible      object is     {@link ReversalResponse }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_REVERSAL_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public ReversalResponse getReversalResponse() {
        return reversalResponse;
    }

    /**
     * Sets the value of the reversalResponse property.
     *
     * @param value allowed object is     {@link ReversalResponse }
     */
    @JsonProperty(JSON_PROPERTY_REVERSAL_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReversalResponse(ReversalResponse value) {
        this.reversalResponse = value;
    }

    /**
     * Gets the value of the storedValueResponse property.
     *
     * @return possible      object is     {@link StoredValueResponse }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_SOTRED_VALUE_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public StoredValueResponse getStoredValueResponse() {
        return storedValueResponse;
    }

    /**
     * Sets the value of the storedValueResponse property.
     *
     * @param value allowed object is     {@link StoredValueResponse }
     */
    @JsonProperty(JSON_PROPERTY_SOTRED_VALUE_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStoredValueResponse(StoredValueResponse value) {
        this.storedValueResponse = value;
    }

    /**
     * Gets the value of the transactionStatusResponse property.
     *
     * @return possible      object is     {@link TransactionStatusResponse }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_TRANSACTION_STATUS_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public TransactionStatusResponse getTransactionStatusResponse() {
        return transactionStatusResponse;
    }

    /**
     * Sets the value of the transactionStatusResponse property.
     *
     * @param value allowed object is     {@link TransactionStatusResponse }
     */
    @JsonProperty(JSON_PROPERTY_TRANSACTION_STATUS_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTransactionStatusResponse(TransactionStatusResponse value) {
        this.transactionStatusResponse = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SaleToPOIResponse {\n");
        try {
            sb.append("    saleToPOIResponse: ").append(toIndentedString(this.toJson())).append("\n");
        } catch (JsonProcessingException e) {
            sb.append("Error: Could not serialize saleToPOIResponse");
        }
        sb.append("}");
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

    /**
     * Create an instance of SaleToPOIResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of SaleToPOIResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to SaleToPOIResponse
     */
    public static SaleToPOIResponse fromJson(String jsonString) throws JsonProcessingException {
        return JSON.getMapper().readValue(jsonString, SaleToPOIResponse.class);
    }

    /**
     * Convert an instance of SaleToPOIResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return JSON.getMapper().writeValueAsString(this);
    }
}
