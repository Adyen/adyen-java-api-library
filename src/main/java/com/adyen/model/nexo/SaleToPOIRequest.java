package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MessageHeader" type="{}MessageHeader"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="AbortRequest" type="{}AbortRequest"/&gt;
 *           &lt;element name="BalanceInquiryRequest" type="{}BalanceInquiryRequest"/&gt;
 *           &lt;element name="BatchRequest" type="{}BatchRequest"/&gt;
 *           &lt;element name="CardAcquisitionRequest" type="{}CardAcquisitionRequest"/&gt;
 *           &lt;element name="AdminRequest" type="{}AdminRequest"/&gt;
 *           &lt;element name="DiagnosisRequest" type="{}DiagnosisRequest"/&gt;
 *           &lt;element name="DisplayRequest" type="{}DisplayRequest"/&gt;
 *           &lt;element name="EnableServiceRequest" type="{}EnableServiceRequest"/&gt;
 *           &lt;element name="EventNotification" type="{}EventNotification"/&gt;
 *           &lt;element name="GetTotalsRequest" type="{}GetTotalsRequest"/&gt;
 *           &lt;element name="InputRequest" type="{}InputRequest"/&gt;
 *           &lt;element name="InputUpdate" type="{}InputUpdate"/&gt;
 *           &lt;element name="LoginRequest" type="{}LoginRequest"/&gt;
 *           &lt;element name="LogoutRequest" type="{}LogoutRequest"/&gt;
 *           &lt;element name="LoyaltyRequest" type="{}LoyaltyRequest"/&gt;
 *           &lt;element name="PaymentRequest" type="{}PaymentRequest"/&gt;
 *           &lt;element name="PINRequest" type="{}PINRequest"/&gt;
 *           &lt;element name="PrintRequest" type="{}PrintRequest"/&gt;
 *           &lt;element name="CardReaderInitRequest" type="{}CardReaderInitRequest"/&gt;
 *           &lt;element name="CardReaderAPDURequest" type="{}CardReaderAPDURequest"/&gt;
 *           &lt;element name="CardReaderPowerOffRequest" type="{}CardReaderPowerOffRequest"/&gt;
 *           &lt;element name="ReconciliationRequest" type="{}ReconciliationRequest"/&gt;
 *           &lt;element name="ReversalRequest" type="{}ReversalRequest"/&gt;
 *           &lt;element name="SoundRequest" type="{}SoundRequest"/&gt;
 *           &lt;element name="StoredValueRequest" type="{}StoredValueRequest"/&gt;
 *           &lt;element name="TransactionStatusRequest" type="{}TransactionStatusRequest"/&gt;
 *           &lt;element name="TransmitRequest" type="{}TransmitRequest"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="SecurityTrailer" type="{}ContentInformation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "messageHeader",
        "abortRequest",
        "balanceInquiryRequest",
        "batchRequest",
        "cardAcquisitionRequest",
        "adminRequest",
        "diagnosisRequest",
        "displayRequest",
        "enableServiceRequest",
        "eventNotification",
        "getTotalsRequest",
        "inputRequest",
        "inputUpdate",
        "loginRequest",
        "logoutRequest",
        "loyaltyRequest",
        "paymentRequest",
        "pinRequest",
        "printRequest",
        "cardReaderInitRequest",
        "cardReaderAPDURequest",
        "cardReaderPowerOffRequest",
        "reconciliationRequest",
        "reversalRequest",
        "soundRequest",
        "storedValueRequest",
        "transactionStatusRequest",
        "transmitRequest",
        "securityTrailer"
})
@XmlRootElement(name = "SaleToPOIRequest")
public class SaleToPOIRequest {

    /**
     * The Message header.
     */
    @XmlElement(name = "MessageHeader", required = true)
    protected MessageHeader messageHeader;
    /**
     * The Abort request.
     */
    @XmlElement(name = "AbortRequest")
    @Schema(description = "Body of the Abort Request message.")
    protected AbortRequest abortRequest;
    /**
     * The Balance inquiry request.
     */
    @XmlElement(name = "BalanceInquiryRequest")
    @Schema(description = "Content of the Balance Inquiry Request message.")
    protected BalanceInquiryRequest balanceInquiryRequest;
    /**
     * The Batch request.
     */
    @XmlElement(name = "BatchRequest")
    @Schema(description = "Content of the Batch Request message.")
    protected BatchRequest batchRequest;
    /**
     * The Card acquisition request.
     */
    @XmlElement(name = "CardAcquisitionRequest")
    @Schema(description = "Content of the Card Acquisition Request message.")
    protected CardAcquisitionRequest cardAcquisitionRequest;
    /**
     * The Admin request.
     */
    @XmlElement(name = "AdminRequest")
    @Schema(description = "Content of the Custom Admin Request message.")
    protected AdminRequest adminRequest;
    /**
     * The Diagnosis request.
     */
    @XmlElement(name = "DiagnosisRequest")
    @Schema(description = "Content of the Diagnosis Request message.")
    protected DiagnosisRequest diagnosisRequest;
    /**
     * The Display request.
     */
    @XmlElement(name = "DisplayRequest")
    @Schema(description = "Content of the Display Request message.")
    protected DisplayRequest displayRequest;
    /**
     * The Enable service request.
     */
    @XmlElement(name = "EnableServiceRequest")
    @Schema(description = "Content of the Enable Service Request message.")
    protected EnableServiceRequest enableServiceRequest;
    /**
     * The Event notification.
     */
    @XmlElement(name = "EventNotification")
    @Schema(description = "Content of the EventNotification message.")
    protected EventNotification eventNotification;
    /**
     * The Get totals request.
     */
    @XmlElement(name = "GetTotalsRequest")
    @Schema(description = "Content of the Get Totals Request message.")
    protected GetTotalsRequest getTotalsRequest;
    /**
     * The Input request.
     */
    @XmlElement(name = "InputRequest")
    @Schema(description = "Content of the Input Request message.")
    protected InputRequest inputRequest;
    /**
     * The Input update.
     */
    @XmlElement(name = "InputUpdate")
    @Schema(description = "Content of the Input Update message.")
    protected InputUpdate inputUpdate;
    /**
     * The Login request.
     */
    @XmlElement(name = "LoginRequest")
    @Schema(description = "Content of the Login Request message.")
    protected LoginRequest loginRequest;
    /**
     * The Logout request.
     */
    @XmlElement(name = "LogoutRequest")
    @Schema(description = "Content of the Logout Request message.")
    protected LogoutRequest logoutRequest;
    /**
     * The Loyalty request.
     */
    @XmlElement(name = "LoyaltyRequest")
    @Schema(description = "Content of the Loyalty Request message.")
    protected LoyaltyRequest loyaltyRequest;
    /**
     * The Payment request.
     */
    @XmlElement(name = "PaymentRequest")
    @Schema(description = "Content of the Payment Request message.")
    protected PaymentRequest paymentRequest;
    /**
     * The Pin request.
     */
    @XmlElement(name = "PINRequest")
    @Schema(description = "Content of the PIN Request message.")
    protected PINRequest pinRequest;
    /**
     * The Print request.
     */
    @XmlElement(name = "PrintRequest")
    @Schema(description = "Content of the Print Request message.")
    protected PrintRequest printRequest;
    /**
     * The Card reader init request.
     */
    @XmlElement(name = "CardReaderInitRequest")
    @Schema(description = "Content of the Card Reader Init Request message.")
    protected CardReaderInitRequest cardReaderInitRequest;
    /**
     * The Card reader apdu request.
     */
    @XmlElement(name = "CardReaderAPDURequest")
    @Schema(description = "Content of the Card Reader APDU Request message.")
    protected CardReaderAPDURequest cardReaderAPDURequest;
    /**
     * The Card reader power off request.
     */
    @XmlElement(name = "CardReaderPowerOffRequest")
    @Schema(description = "Content of the Card Reader Power-Off Request message.")
    protected CardReaderPowerOffRequest cardReaderPowerOffRequest;
    /**
     * The Reconciliation request.
     */
    @XmlElement(name = "ReconciliationRequest")
    @Schema(description = "Content of the Reconciliation Request message.")
    protected ReconciliationRequest reconciliationRequest;
    /**
     * The Reversal request.
     */
    @XmlElement(name = "ReversalRequest")
    @Schema(description = "Content of the Reversal Request message.")
    protected ReversalRequest reversalRequest;
    /**
     * The Sound request.
     */
    @XmlElement(name = "SoundRequest")
    @Schema(description = "Content of the Sound Request message.")
    protected SoundRequest soundRequest;
    /**
     * The Stored value request.
     */
    @XmlElement(name = "StoredValueRequest")
    @Schema(description = "Content of the Stored Value Request message.")
    protected StoredValueRequest storedValueRequest;
    /**
     * The Transaction status request.
     */
    @XmlElement(name = "TransactionStatusRequest")
    @Schema(description = "Content of the TransactionStatus Request message.")
    protected TransactionStatusRequest transactionStatusRequest;
    /**
     * The Transmit request.
     */
    @XmlElement(name = "TransmitRequest")
    @Schema(description = "Content of the Transmit Request message.")
    protected TransmitRequest transmitRequest;
    /**
     * The Security trailer.
     */
    @XmlElement(name = "SecurityTrailer")
    @Schema(description = "Protection of the whole message")
    protected ContentInformation securityTrailer;

    /**
     * Gets the value of the messageHeader property.
     *
     * @return possible      object is     {@link MessageHeader }
     */
    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    /**
     * Sets the value of the messageHeader property.
     *
     * @param value allowed object is     {@link MessageHeader }
     */
    public void setMessageHeader(MessageHeader value) {
        this.messageHeader = value;
    }

    /**
     * Gets the value of the abortRequest property.
     *
     * @return possible      object is     {@link AbortRequest }
     */
    public AbortRequest getAbortRequest() {
        return abortRequest;
    }

    /**
     * Sets the value of the abortRequest property.
     *
     * @param value allowed object is     {@link AbortRequest }
     */
    public void setAbortRequest(AbortRequest value) {
        this.abortRequest = value;
    }

    /**
     * Gets the value of the balanceInquiryRequest property.
     *
     * @return possible      object is     {@link BalanceInquiryRequest }
     */
    public BalanceInquiryRequest getBalanceInquiryRequest() {
        return balanceInquiryRequest;
    }

    /**
     * Sets the value of the balanceInquiryRequest property.
     *
     * @param value allowed object is     {@link BalanceInquiryRequest }
     */
    public void setBalanceInquiryRequest(BalanceInquiryRequest value) {
        this.balanceInquiryRequest = value;
    }

    /**
     * Gets the value of the batchRequest property.
     *
     * @return possible      object is     {@link BatchRequest }
     */
    public BatchRequest getBatchRequest() {
        return batchRequest;
    }

    /**
     * Sets the value of the batchRequest property.
     *
     * @param value allowed object is     {@link BatchRequest }
     */
    public void setBatchRequest(BatchRequest value) {
        this.batchRequest = value;
    }

    /**
     * Gets the value of the cardAcquisitionRequest property.
     *
     * @return possible      object is     {@link CardAcquisitionRequest }
     */
    public CardAcquisitionRequest getCardAcquisitionRequest() {
        return cardAcquisitionRequest;
    }

    /**
     * Sets the value of the cardAcquisitionRequest property.
     *
     * @param value allowed object is     {@link CardAcquisitionRequest }
     */
    public void setCardAcquisitionRequest(CardAcquisitionRequest value) {
        this.cardAcquisitionRequest = value;
    }

    /**
     * Gets the value of the adminRequest property.
     *
     * @return possible      object is     {@link AdminRequest }
     */
    public AdminRequest getAdminRequest() {
        return adminRequest;
    }

    /**
     * Sets the value of the adminRequest property.
     *
     * @param value allowed object is     {@link AdminRequest }
     */
    public void setAdminRequest(AdminRequest value) {
        this.adminRequest = value;
    }

    /**
     * Gets the value of the diagnosisRequest property.
     *
     * @return possible      object is     {@link DiagnosisRequest }
     */
    public DiagnosisRequest getDiagnosisRequest() {
        return diagnosisRequest;
    }

    /**
     * Sets the value of the diagnosisRequest property.
     *
     * @param value allowed object is     {@link DiagnosisRequest }
     */
    public void setDiagnosisRequest(DiagnosisRequest value) {
        this.diagnosisRequest = value;
    }

    /**
     * Gets the value of the displayRequest property.
     *
     * @return possible      object is     {@link DisplayRequest }
     */
    public DisplayRequest getDisplayRequest() {
        return displayRequest;
    }

    /**
     * Sets the value of the displayRequest property.
     *
     * @param value allowed object is     {@link DisplayRequest }
     */
    public void setDisplayRequest(DisplayRequest value) {
        this.displayRequest = value;
    }

    /**
     * Gets the value of the enableServiceRequest property.
     *
     * @return possible      object is     {@link EnableServiceRequest }
     */
    public EnableServiceRequest getEnableServiceRequest() {
        return enableServiceRequest;
    }

    /**
     * Sets the value of the enableServiceRequest property.
     *
     * @param value allowed object is     {@link EnableServiceRequest }
     */
    public void setEnableServiceRequest(EnableServiceRequest value) {
        this.enableServiceRequest = value;
    }

    /**
     * Gets the value of the eventNotification property.
     *
     * @return possible      object is     {@link EventNotification }
     */
    public EventNotification getEventNotification() {
        return eventNotification;
    }

    /**
     * Sets the value of the eventNotification property.
     *
     * @param value allowed object is     {@link EventNotification }
     */
    public void setEventNotification(EventNotification value) {
        this.eventNotification = value;
    }

    /**
     * Gets the value of the getTotalsRequest property.
     *
     * @return possible      object is     {@link GetTotalsRequest }
     */
    public GetTotalsRequest getGetTotalsRequest() {
        return getTotalsRequest;
    }

    /**
     * Sets the value of the getTotalsRequest property.
     *
     * @param value allowed object is     {@link GetTotalsRequest }
     */
    public void setGetTotalsRequest(GetTotalsRequest value) {
        this.getTotalsRequest = value;
    }

    /**
     * Gets the value of the inputRequest property.
     *
     * @return possible      object is     {@link InputRequest }
     */
    public InputRequest getInputRequest() {
        return inputRequest;
    }

    /**
     * Sets the value of the inputRequest property.
     *
     * @param value allowed object is     {@link InputRequest }
     */
    public void setInputRequest(InputRequest value) {
        this.inputRequest = value;
    }

    /**
     * Gets the value of the inputUpdate property.
     *
     * @return possible      object is     {@link InputUpdate }
     */
    public InputUpdate getInputUpdate() {
        return inputUpdate;
    }

    /**
     * Sets the value of the inputUpdate property.
     *
     * @param value allowed object is     {@link InputUpdate }
     */
    public void setInputUpdate(InputUpdate value) {
        this.inputUpdate = value;
    }

    /**
     * Gets the value of the loginRequest property.
     *
     * @return possible      object is     {@link LoginRequest }
     */
    public LoginRequest getLoginRequest() {
        return loginRequest;
    }

    /**
     * Sets the value of the loginRequest property.
     *
     * @param value allowed object is     {@link LoginRequest }
     */
    public void setLoginRequest(LoginRequest value) {
        this.loginRequest = value;
    }

    /**
     * Gets the value of the logoutRequest property.
     *
     * @return possible      object is     {@link LogoutRequest }
     */
    public LogoutRequest getLogoutRequest() {
        return logoutRequest;
    }

    /**
     * Sets the value of the logoutRequest property.
     *
     * @param value allowed object is     {@link LogoutRequest }
     */
    public void setLogoutRequest(LogoutRequest value) {
        this.logoutRequest = value;
    }

    /**
     * Gets the value of the loyaltyRequest property.
     *
     * @return possible      object is     {@link LoyaltyRequest }
     */
    public LoyaltyRequest getLoyaltyRequest() {
        return loyaltyRequest;
    }

    /**
     * Sets the value of the loyaltyRequest property.
     *
     * @param value allowed object is     {@link LoyaltyRequest }
     */
    public void setLoyaltyRequest(LoyaltyRequest value) {
        this.loyaltyRequest = value;
    }

    /**
     * Gets the value of the paymentRequest property.
     *
     * @return possible      object is     {@link PaymentRequest }
     */
    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }

    /**
     * Sets the value of the paymentRequest property.
     *
     * @param value allowed object is     {@link PaymentRequest }
     */
    public void setPaymentRequest(PaymentRequest value) {
        this.paymentRequest = value;
    }

    /**
     * Gets the value of the pinRequest property.
     *
     * @return possible      object is     {@link PINRequest }
     */
    public PINRequest getPINRequest() {
        return pinRequest;
    }

    /**
     * Sets the value of the pinRequest property.
     *
     * @param value allowed object is     {@link PINRequest }
     */
    public void setPINRequest(PINRequest value) {
        this.pinRequest = value;
    }

    /**
     * Gets the value of the printRequest property.
     *
     * @return possible      object is     {@link PrintRequest }
     */
    public PrintRequest getPrintRequest() {
        return printRequest;
    }

    /**
     * Sets the value of the printRequest property.
     *
     * @param value allowed object is     {@link PrintRequest }
     */
    public void setPrintRequest(PrintRequest value) {
        this.printRequest = value;
    }

    /**
     * Gets the value of the cardReaderInitRequest property.
     *
     * @return possible      object is     {@link CardReaderInitRequest }
     */
    public CardReaderInitRequest getCardReaderInitRequest() {
        return cardReaderInitRequest;
    }

    /**
     * Sets the value of the cardReaderInitRequest property.
     *
     * @param value allowed object is     {@link CardReaderInitRequest }
     */
    public void setCardReaderInitRequest(CardReaderInitRequest value) {
        this.cardReaderInitRequest = value;
    }

    /**
     * Gets the value of the cardReaderAPDURequest property.
     *
     * @return possible      object is     {@link CardReaderAPDURequest }
     */
    public CardReaderAPDURequest getCardReaderAPDURequest() {
        return cardReaderAPDURequest;
    }

    /**
     * Sets the value of the cardReaderAPDURequest property.
     *
     * @param value allowed object is     {@link CardReaderAPDURequest }
     */
    public void setCardReaderAPDURequest(CardReaderAPDURequest value) {
        this.cardReaderAPDURequest = value;
    }

    /**
     * Gets the value of the cardReaderPowerOffRequest property.
     *
     * @return possible      object is     {@link CardReaderPowerOffRequest }
     */
    public CardReaderPowerOffRequest getCardReaderPowerOffRequest() {
        return cardReaderPowerOffRequest;
    }

    /**
     * Sets the value of the cardReaderPowerOffRequest property.
     *
     * @param value allowed object is     {@link CardReaderPowerOffRequest }
     */
    public void setCardReaderPowerOffRequest(CardReaderPowerOffRequest value) {
        this.cardReaderPowerOffRequest = value;
    }

    /**
     * Gets the value of the reconciliationRequest property.
     *
     * @return possible      object is     {@link ReconciliationRequest }
     */
    public ReconciliationRequest getReconciliationRequest() {
        return reconciliationRequest;
    }

    /**
     * Sets the value of the reconciliationRequest property.
     *
     * @param value allowed object is     {@link ReconciliationRequest }
     */
    public void setReconciliationRequest(ReconciliationRequest value) {
        this.reconciliationRequest = value;
    }

    /**
     * Gets the value of the reversalRequest property.
     *
     * @return possible      object is     {@link ReversalRequest }
     */
    public ReversalRequest getReversalRequest() {
        return reversalRequest;
    }

    /**
     * Sets the value of the reversalRequest property.
     *
     * @param value allowed object is     {@link ReversalRequest }
     */
    public void setReversalRequest(ReversalRequest value) {
        this.reversalRequest = value;
    }

    /**
     * Gets the value of the soundRequest property.
     *
     * @return possible      object is     {@link SoundRequest }
     */
    public SoundRequest getSoundRequest() {
        return soundRequest;
    }

    /**
     * Sets the value of the soundRequest property.
     *
     * @param value allowed object is     {@link SoundRequest }
     */
    public void setSoundRequest(SoundRequest value) {
        this.soundRequest = value;
    }

    /**
     * Gets the value of the storedValueRequest property.
     *
     * @return possible      object is     {@link StoredValueRequest }
     */
    public StoredValueRequest getStoredValueRequest() {
        return storedValueRequest;
    }

    /**
     * Sets the value of the storedValueRequest property.
     *
     * @param value allowed object is     {@link StoredValueRequest }
     */
    public void setStoredValueRequest(StoredValueRequest value) {
        this.storedValueRequest = value;
    }

    /**
     * Gets the value of the transactionStatusRequest property.
     *
     * @return possible      object is     {@link TransactionStatusRequest }
     */
    public TransactionStatusRequest getTransactionStatusRequest() {
        return transactionStatusRequest;
    }

    /**
     * Sets the value of the transactionStatusRequest property.
     *
     * @param value allowed object is     {@link TransactionStatusRequest }
     */
    public void setTransactionStatusRequest(TransactionStatusRequest value) {
        this.transactionStatusRequest = value;
    }

    /**
     * Gets the value of the transmitRequest property.
     *
     * @return possible      object is     {@link TransmitRequest }
     */
    public TransmitRequest getTransmitRequest() {
        return transmitRequest;
    }

    /**
     * Sets the value of the transmitRequest property.
     *
     * @param value allowed object is     {@link TransmitRequest }
     */
    public void setTransmitRequest(TransmitRequest value) {
        this.transmitRequest = value;
    }

    /**
     * Gets the value of the securityTrailer property.
     *
     * @return possible      object is     {@link ContentInformation }
     */
    public ContentInformation getSecurityTrailer() {
        return securityTrailer;
    }

    /**
     * Sets the value of the securityTrailer property.
     *
     * @param value allowed object is     {@link ContentInformation }
     */
    public void setSecurityTrailer(ContentInformation value) {
        this.securityTrailer = value;
    }

}
