package com.adyen.terminal;

import com.adyen.model.terminal.AbortRequest;
import com.adyen.model.terminal.AdminRequest;
import com.adyen.model.terminal.BalanceInquiryRequest;
import com.adyen.model.terminal.CardAcquisitionRequest;
import com.adyen.model.terminal.CardReaderAPDURequest;
import com.adyen.model.terminal.DiagnosisRequest;
import com.adyen.model.terminal.DisplayRequest;
import com.adyen.model.terminal.EnableServiceRequest;
import com.adyen.model.terminal.EventNotification;
import com.adyen.model.terminal.GetTotalsRequest;
import com.adyen.model.terminal.InputRequest;
import com.adyen.model.terminal.JSON;
import com.adyen.model.terminal.LoginRequest;
import com.adyen.model.terminal.LogoutRequest;
import com.adyen.model.terminal.LoyaltyRequest;
import com.adyen.model.terminal.MessageHeader;

import com.adyen.model.terminal.PaymentRequest;
import com.adyen.model.terminal.PrintRequest;
import com.adyen.model.terminal.ReconciliationRequest;
import com.adyen.model.terminal.ReversalRequest;
import com.adyen.model.terminal.SecurityTrailer;
import com.adyen.model.terminal.StoredValueRequest;
import com.adyen.model.terminal.TransactionStatusRequest;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "SaleToPoiRequest")
@JsonPropertyOrder({
        SaleToPOIRequest.JSON_PROPERTY_MESSAGE_HEADER,
        SaleToPOIRequest.JSON_PROPERTY_ABORT_REQUEST,
        SaleToPOIRequest.JSON_PROPERTY_BALANCE_INQUIRY_REQUEST,
        SaleToPOIRequest.JSON_PROPERTY_CARD_ACQUISITION_REQUEST,
        SaleToPOIRequest.JSON_PROPERTY_ADMIN_REQUEST,
        SaleToPOIRequest.JSON_PROPERTY_DIAGNOSIS_REQUEST,
        SaleToPOIRequest.JSON_PROPERTY_DISPLAY_REQUEST,
        SaleToPOIRequest.JSON_PROPERTY_ENABLE_SERVICE_REQUEST,
        SaleToPOIRequest.JSON_PROPERTY_EVENT_NOTIFICATION,
        SaleToPOIRequest.JSON_PROPERTY_GET_TOTALS_REQUEST,
        SaleToPOIRequest.JSON_PROPERTY_INPUT_REQUEST,
        SaleToPOIRequest.JSON_PROPERTY_LOGIN_REQUEST,
        SaleToPOIRequest.JSON_PROPERTY_LOGOUT_REQUEST,
        SaleToPOIRequest.JSON_PROPERTY_LOYALTY_REQUEST,
        SaleToPOIRequest.JSON_PROPERTY_PAYMENT_REQUEST,
        SaleToPOIRequest.JSON_PROPERTY_PRINT_REQUEST,
        SaleToPOIRequest.JSON_PROPERTY_CARD_READER_APDU_REQUEST,
        SaleToPOIRequest.JSON_PROPERTY_RECONCILIATION_REQUEST,
        SaleToPOIRequest.JSON_PROPERTY_REVERSAL_REQUEST,
        SaleToPOIRequest.JSON_PROPERTY_STORED_VALUE_REQUEST,
        SaleToPOIRequest.JSON_PROPERTY_TRANSACTION_STATUS_REQUEST,
        SaleToPOIRequest.JSON_PROPERTY_SECURITY_TRAILER
})
public class SaleToPOIRequest {

    /**
     * The Message header.
     */
    public static final String JSON_PROPERTY_MESSAGE_HEADER = "MessageHeader";
    protected MessageHeader messageHeader;
    /**
     * The Abort request.
     */
    public static final String JSON_PROPERTY_ABORT_REQUEST = "AbortRequest";
    protected AbortRequest abortRequest;
    /**
     * The Balance inquiry request.
     */
    public static final String JSON_PROPERTY_BALANCE_INQUIRY_REQUEST = "BalanceInquiryRequest";
    protected BalanceInquiryRequest balanceInquiryRequest;
    /**
     * The Card acquisition request.
     */
    public static final String JSON_PROPERTY_CARD_ACQUISITION_REQUEST = "CardAcquisitionRequest";
    protected CardAcquisitionRequest cardAcquisitionRequest;
    /**
     * The Admin request.
     */
    public static final String JSON_PROPERTY_ADMIN_REQUEST = "AdminRequest";
    protected AdminRequest adminRequest;
    /**
     * The Diagnosis request.
     */
    public static final String JSON_PROPERTY_DIAGNOSIS_REQUEST = "DiagnosisRequest";
    protected DiagnosisRequest diagnosisRequest;
    /**
     * The Display request.
     */
    public static final String JSON_PROPERTY_DISPLAY_REQUEST = "DisplayRequest";
    protected DisplayRequest displayRequest;
    /**
     * The Enable service request.
     */
    public static final String JSON_PROPERTY_ENABLE_SERVICE_REQUEST = "EnableServiceRequest";
    protected EnableServiceRequest enableServiceRequest;
    /**
     * The Event notification.
     */
    public static final String JSON_PROPERTY_EVENT_NOTIFICATION = "EventNotification";
    protected EventNotification eventNotification;
    /**
     * The Get totals request.
     */
    public static final String JSON_PROPERTY_GET_TOTALS_REQUEST = "GetTotalsRequest";
    protected GetTotalsRequest getTotalsRequest;
    /**
     * The Input request.
     */
    public static final String JSON_PROPERTY_INPUT_REQUEST = "InputRequest";
    protected InputRequest inputRequest;
    /**
     * The Login request.
     */
    public static final String JSON_PROPERTY_LOGIN_REQUEST = "LoginRequest";
    protected LoginRequest loginRequest;
    /**
     * The Logout request.
     */
    public static final String JSON_PROPERTY_LOGOUT_REQUEST = "LogoutRequest";
    protected LogoutRequest logoutRequest;
    /**
     * The Loyalty request.
     */
    public static final String JSON_PROPERTY_LOYALTY_REQUEST = "LoyaltyRequest";
    protected LoyaltyRequest loyaltyRequest;
    /**
     * The Payment request.
     */
    public static final String JSON_PROPERTY_PAYMENT_REQUEST = "PaymentRequest";
    protected PaymentRequest paymentRequest;
    /**
     * The Print request.
     */
    public static final String JSON_PROPERTY_PRINT_REQUEST = "PrintRequest";
    protected PrintRequest printRequest;
    /**
     * The Card reader apdu request.
     */
    public static final String JSON_PROPERTY_CARD_READER_APDU_REQUEST = "CardReaderAPDURequest";
    protected CardReaderAPDURequest cardReaderAPDURequest;
    /**
     * The Reconciliation request.
     */
    public static final String JSON_PROPERTY_RECONCILIATION_REQUEST = "ReconciliationRequest";
    protected ReconciliationRequest reconciliationRequest;
    /**
     * The Reversal request.
     */
    public static final String JSON_PROPERTY_REVERSAL_REQUEST = "ReversalRequest";
    protected ReversalRequest reversalRequest;
    /**
     * The Stored value request.
     */
    public static final String JSON_PROPERTY_STORED_VALUE_REQUEST = "StoredValueRequest";
    protected StoredValueRequest storedValueRequest;
    /**
     * The Transaction status request.
     */
    public static final String JSON_PROPERTY_TRANSACTION_STATUS_REQUEST = "TransactionStatusRequest";
    protected TransactionStatusRequest transactionStatusRequest;
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
     * Gets the value of the abortRequest property.
     *
     * @return possible      object is     {@link AbortRequest }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_ABORT_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public AbortRequest getAbortRequest() {
        return abortRequest;
    }

    /**
     * Sets the value of the abortRequest property.
     *
     * @param value allowed object is     {@link AbortRequest }
     */
    @JsonProperty(JSON_PROPERTY_ABORT_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAbortRequest(AbortRequest value) {
        this.abortRequest = value;
    }

    /**
     * Gets the value of the balanceInquiryRequest property.
     *
     * @return possible      object is     {@link BalanceInquiryRequest }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_BALANCE_INQUIRY_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public BalanceInquiryRequest getBalanceInquiryRequest() {
        return balanceInquiryRequest;
    }

    /**
     * Sets the value of the balanceInquiryRequest property.
     *
     * @param value allowed object is     {@link BalanceInquiryRequest }
     */
    @JsonProperty(JSON_PROPERTY_BALANCE_INQUIRY_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBalanceInquiryRequest(BalanceInquiryRequest value) {
        this.balanceInquiryRequest = value;
    }

    /**
     * Gets the value of the cardAcquisitionRequest property.
     *
     * @return possible      object is     {@link CardAcquisitionRequest }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_CARD_ACQUISITION_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public CardAcquisitionRequest getCardAcquisitionRequest() {
        return cardAcquisitionRequest;
    }

    /**
     * Sets the value of the cardAcquisitionRequest property.
     *
     * @param value allowed object is     {@link CardAcquisitionRequest }
     */
    @JsonProperty(JSON_PROPERTY_CARD_ACQUISITION_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCardAcquisitionRequest(CardAcquisitionRequest value) {
        this.cardAcquisitionRequest = value;
    }

    /**
     * Gets the value of the adminRequest property.
     *
     * @return possible      object is     {@link AdminRequest }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_ADMIN_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public AdminRequest getAdminRequest() {
        return adminRequest;
    }

    /**
     * Sets the value of the adminRequest property.
     *
     * @param value allowed object is     {@link AdminRequest }
     */
    @JsonProperty(JSON_PROPERTY_ADMIN_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAdminRequest(AdminRequest value) {
        this.adminRequest = value;
    }

    /**
     * Gets the value of the diagnosisRequest property.
     *
     * @return possible      object is     {@link DiagnosisRequest }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_DIAGNOSIS_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public DiagnosisRequest getDiagnosisRequest() {
        return diagnosisRequest;
    }

    /**
     * Sets the value of the diagnosisRequest property.
     *
     * @param value allowed object is     {@link DiagnosisRequest }
     */
    @JsonProperty(JSON_PROPERTY_DIAGNOSIS_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDiagnosisRequest(DiagnosisRequest value) {
        this.diagnosisRequest = value;
    }

    /**
     * Gets the value of the displayRequest property.
     *
     * @return possible      object is     {@link DisplayRequest }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_DISPLAY_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public DisplayRequest getDisplayRequest() {
        return displayRequest;
    }

    /**
     * Sets the value of the displayRequest property.
     *
     * @param value allowed object is     {@link DisplayRequest }
     */
    @JsonProperty(JSON_PROPERTY_DISPLAY_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDisplayRequest(DisplayRequest value) {
        this.displayRequest = value;
    }

    /**
     * Gets the value of the enableServiceRequest property.
     *
     * @return possible      object is     {@link EnableServiceRequest }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_ENABLE_SERVICE_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public EnableServiceRequest getEnableServiceRequest() {
        return enableServiceRequest;
    }

    /**
     * Sets the value of the enableServiceRequest property.
     *
     * @param value allowed object is     {@link EnableServiceRequest }
     */
    @JsonProperty(JSON_PROPERTY_ENABLE_SERVICE_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEnableServiceRequest(EnableServiceRequest value) {
        this.enableServiceRequest = value;
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
     * Gets the value of the getTotalsRequest property.
     *
     * @return possible      object is     {@link GetTotalsRequest }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_GET_TOTALS_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public GetTotalsRequest getGetTotalsRequest() {
        return getTotalsRequest;
    }

    /**
     * Sets the value of the getTotalsRequest property.
     *
     * @param value allowed object is     {@link GetTotalsRequest }
     */
    @JsonProperty(JSON_PROPERTY_GET_TOTALS_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setGetTotalsRequest(GetTotalsRequest value) {
        this.getTotalsRequest = value;
    }

    /**
     * Gets the value of the inputRequest property.
     *
     * @return possible      object is     {@link InputRequest }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_INPUT_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public InputRequest getInputRequest() {
        return inputRequest;
    }

    /**
     * Sets the value of the inputRequest property.
     *
     * @param value allowed object is     {@link InputRequest }
     */
    @JsonProperty(JSON_PROPERTY_INPUT_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInputRequest(InputRequest value) {
        this.inputRequest = value;
    }

    /**
     * Gets the value of the loginRequest property.
     *
     * @return possible      object is     {@link LoginRequest }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_LOGIN_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public LoginRequest getLoginRequest() {
        return loginRequest;
    }

    /**
     * Sets the value of the loginRequest property.
     *
     * @param value allowed object is     {@link LoginRequest }
     */
    @JsonProperty(JSON_PROPERTY_LOGIN_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLoginRequest(LoginRequest value) {
        this.loginRequest = value;
    }

    /**
     * Gets the value of the logoutRequest property.
     *
     * @return possible      object is     {@link LogoutRequest }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_LOGOUT_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public LogoutRequest getLogoutRequest() {
        return logoutRequest;
    }

    /**
     * Sets the value of the logoutRequest property.
     *
     * @param value allowed object is     {@link LogoutRequest }
     */
    @JsonProperty(JSON_PROPERTY_LOGOUT_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLogoutRequest(LogoutRequest value) {
        this.logoutRequest = value;
    }

    /**
     * Gets the value of the loyaltyRequest property.
     *
     * @return possible      object is     {@link LoyaltyRequest }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_LOYALTY_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public LoyaltyRequest getLoyaltyRequest() {
        return loyaltyRequest;
    }

    /**
     * Sets the value of the loyaltyRequest property.
     *
     * @param value allowed object is     {@link LoyaltyRequest }
     */
    @JsonProperty(JSON_PROPERTY_LOYALTY_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLoyaltyRequest(LoyaltyRequest value) {
        this.loyaltyRequest = value;
    }

    /**
     * Gets the value of the paymentRequest property.
     *
     * @return possible      object is     {@link PaymentRequest }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_PAYMENT_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }

    /**
     * Sets the value of the paymentRequest property.
     *
     * @param value allowed object is     {@link PaymentRequest }
     */
    @JsonProperty(JSON_PROPERTY_PAYMENT_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPaymentRequest(PaymentRequest value) {
        this.paymentRequest = value;
    }

    /**
     * Gets the value of the printRequest property.
     *
     * @return possible      object is     {@link PrintRequest }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_PRINT_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public PrintRequest getPrintRequest() {
        return printRequest;
    }

    /**
     * Sets the value of the printRequest property.
     *
     * @param value allowed object is     {@link PrintRequest }
     */
    @JsonProperty(JSON_PROPERTY_PRINT_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPrintRequest(PrintRequest value) {
        this.printRequest = value;
    }

    /**
     * Gets the value of the cardReaderAPDURequest property.
     *
     * @return possible      object is     {@link CardReaderAPDURequest }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_CARD_READER_APDU_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public CardReaderAPDURequest getCardReaderAPDURequest() {
        return cardReaderAPDURequest;
    }

    /**
     * Sets the value of the cardReaderAPDURequest property.
     *
     * @param value allowed object is     {@link CardReaderAPDURequest }
     */
    @JsonProperty(JSON_PROPERTY_CARD_READER_APDU_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCardReaderAPDURequest(CardReaderAPDURequest value) {
        this.cardReaderAPDURequest = value;
    }

    /**
     * Gets the value of the reconciliationRequest property.
     *
     * @return possible      object is     {@link ReconciliationRequest }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_RECONCILIATION_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public ReconciliationRequest getReconciliationRequest() {
        return reconciliationRequest;
    }

    /**
     * Sets the value of the reconciliationRequest property.
     *
     * @param value allowed object is     {@link ReconciliationRequest }
     */
    @JsonProperty(JSON_PROPERTY_RECONCILIATION_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReconciliationRequest(ReconciliationRequest value) {
        this.reconciliationRequest = value;
    }

    /**
     * Gets the value of the reversalRequest property.
     *
     * @return possible      object is     {@link ReversalRequest }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_REVERSAL_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public ReversalRequest getReversalRequest() {
        return reversalRequest;
    }

    /**
     * Sets the value of the reversalRequest property.
     *
     * @param value allowed object is     {@link ReversalRequest }
     */
    @JsonProperty(JSON_PROPERTY_REVERSAL_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReversalRequest(ReversalRequest value) {
        this.reversalRequest = value;
    }

    /**
     * Gets the value of the storedValueRequest property.
     *
     * @return possible      object is     {@link StoredValueRequest }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_STORED_VALUE_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public StoredValueRequest getStoredValueRequest() {
        return storedValueRequest;
    }

    /**
     * Sets the value of the storedValueRequest property.
     *
     * @param value allowed object is     {@link StoredValueRequest }
     */
    @JsonProperty(JSON_PROPERTY_STORED_VALUE_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStoredValueRequest(StoredValueRequest value) {
        this.storedValueRequest = value;
    }

    /**
     * Gets the value of the transactionStatusRequest property.
     *
     * @return possible      object is     {@link TransactionStatusRequest }
     */
    @ApiModelProperty(required = false, value = "")
    @JsonProperty(JSON_PROPERTY_TRANSACTION_STATUS_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public TransactionStatusRequest getTransactionStatusRequest() {
        return transactionStatusRequest;
    }

    /**
     * Sets the value of the transactionStatusRequest property.
     *
     * @param value allowed object is     {@link TransactionStatusRequest }
     */
    @JsonProperty(JSON_PROPERTY_TRANSACTION_STATUS_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTransactionStatusRequest(TransactionStatusRequest value) {
        this.transactionStatusRequest = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SaleToPOIRequest {\n");
        try {
            sb.append("    saleToPOIRequest: ").append(toIndentedString(this.toJson())).append("\n");
        } catch (JsonProcessingException e) {
            sb.append("Error: Could not serialize saleToPOIRequest");
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
     * Create an instance of SaleToPOIRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of AbortRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to AbortRequest
     */
    public static SaleToPOIRequest fromJson(String jsonString) throws JsonProcessingException {
        return JSON.getMapper().readValue(jsonString, SaleToPOIRequest.class);
    }

    /**
     * Convert an instance of SaleToPOIRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return JSON.getMapper().writeValueAsString(this);
    }
}
