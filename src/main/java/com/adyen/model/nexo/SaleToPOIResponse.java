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
 *           &lt;element name="BalanceInquiryResponse" type="{}BalanceInquiryResponse"/&gt;
 *           &lt;element name="BatchResponse" type="{}BatchResponse"/&gt;
 *           &lt;element name="CardAcquisitionResponse" type="{}CardAcquisitionResponse"/&gt;
 *           &lt;element name="AdminResponse" type="{}AdminResponse"/&gt;
 *           &lt;element name="DiagnosisResponse" type="{}DiagnosisResponse"/&gt;
 *           &lt;element name="DisplayResponse" type="{}DisplayResponse"/&gt;
 *           &lt;element name="EnableServiceResponse" type="{}EnableServiceResponse"/&gt;
 *           &lt;element name="GetTotalsResponse" type="{}GetTotalsResponse"/&gt;
 *           &lt;element name="InputResponse" type="{}InputResponse"/&gt;
 *           &lt;element name="LoginResponse" type="{}LoginResponse"/&gt;
 *           &lt;element name="LogoutResponse" type="{}LogoutResponse"/&gt;
 *           &lt;element name="LoyaltyResponse" type="{}LoyaltyResponse"/&gt;
 *           &lt;element name="PaymentResponse" type="{}PaymentResponse"/&gt;
 *           &lt;element name="PINResponse" type="{}PINResponse"/&gt;
 *           &lt;element name="PrintResponse" type="{}PrintResponse"/&gt;
 *           &lt;element name="CardReaderInitResponse" type="{}CardReaderInitResponse"/&gt;
 *           &lt;element name="CardReaderAPDUResponse" type="{}CardReaderAPDUResponse"/&gt;
 *           &lt;element name="CardReaderPowerOffResponse" type="{}CardReaderPowerOffResponse"/&gt;
 *           &lt;element name="ReconciliationResponse" type="{}ReconciliationResponse"/&gt;
 *           &lt;element name="ReversalResponse" type="{}ReversalResponse"/&gt;
 *           &lt;element name="SoundResponse" type="{}SoundResponse"/&gt;
 *           &lt;element name="StoredValueResponse" type="{}StoredValueResponse"/&gt;
 *           &lt;element name="TransactionStatusResponse" type="{}TransactionStatusResponse"/&gt;
 *           &lt;element name="TransmitResponse" type="{}TransmitResponse"/&gt;
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
        "balanceInquiryResponse",
        "batchResponse",
        "cardAcquisitionResponse",
        "adminResponse",
        "diagnosisResponse",
        "displayResponse",
        "enableServiceResponse",
        "getTotalsResponse",
        "inputResponse",
        "loginResponse",
        "logoutResponse",
        "loyaltyResponse",
        "paymentResponse",
        "pinResponse",
        "printResponse",
        "cardReaderInitResponse",
        "cardReaderAPDUResponse",
        "cardReaderPowerOffResponse",
        "reconciliationResponse",
        "reversalResponse",
        "soundResponse",
        "storedValueResponse",
        "transactionStatusResponse",
        "transmitResponse",
        "securityTrailer"
})
@XmlRootElement(name = "SaleToPOIResponse")
public class SaleToPOIResponse {

    /**
     * The Message header.
     */
    @XmlElement(name = "MessageHeader", required = true)
    protected MessageHeader messageHeader;
    /**
     * The Balance inquiry response.
     */
    @XmlElement(name = "BalanceInquiryResponse")
    @Schema(description = "Content of the Balance Inquiry Response message.")
    protected BalanceInquiryResponse balanceInquiryResponse;
    /**
     * The Batch response.
     */
    @XmlElement(name = "BatchResponse")
    @Schema(description = "Content of the Batch Response message.")
    protected BatchResponse batchResponse;
    /**
     * The Card acquisition response.
     */
    @XmlElement(name = "CardAcquisitionResponse")
    @Schema(description = "Content of the Card Acquisition Response message.")
    protected CardAcquisitionResponse cardAcquisitionResponse;
    /**
     * The Admin response.
     */
    @XmlElement(name = "AdminResponse")
    @Schema(description = "Content of the Custom Admin Response message.")
    protected AdminResponse adminResponse;
    /**
     * The Diagnosis response.
     */
    @XmlElement(name = "DiagnosisResponse")
    @Schema(description = "Content of the Diagnosis Response message.")
    protected DiagnosisResponse diagnosisResponse;
    /**
     * The Display response.
     */
    @XmlElement(name = "DisplayResponse")
    @Schema(description = "Content of the Display Response message.")
    protected DisplayResponse displayResponse;
    /**
     * The Enable service response.
     */
    @XmlElement(name = "EnableServiceResponse")
    @Schema(description = "Content of the Enable Service Response message.")
    protected EnableServiceResponse enableServiceResponse;
    /**
     * The Get totals response.
     */
    @XmlElement(name = "GetTotalsResponse")
    @Schema(description = "Content of the Reconciliation Response message.")
    protected GetTotalsResponse getTotalsResponse;
    /**
     * The Input response.
     */
    @XmlElement(name = "InputResponse")
    @Schema(description = "Content of the Input Response message.")
    protected InputResponse inputResponse;
    /**
     * The Login response.
     */
    @XmlElement(name = "LoginResponse")
    @Schema(description = "Content of the Login Response message.")
    protected LoginResponse loginResponse;
    /**
     * The Logout response.
     */
    @XmlElement(name = "LogoutResponse")
    @Schema(description = "Content of the Logout Response message.")
    protected LogoutResponse logoutResponse;
    /**
     * The Loyalty response.
     */
    @XmlElement(name = "LoyaltyResponse")
    @Schema(description = "Content of the Loyalty Response message.")
    protected LoyaltyResponse loyaltyResponse;
    /**
     * The Payment response.
     */
    @XmlElement(name = "PaymentResponse")
    @Schema(description = "Content of the Payment Response message.")
    protected PaymentResponse paymentResponse;
    /**
     * The Pin response.
     */
    @XmlElement(name = "PINResponse")
    @Schema(description = "Content of the PIN Response message.")
    protected PINResponse pinResponse;
    /**
     * The Print response.
     */
    @XmlElement(name = "PrintResponse")
    @Schema(description = "Content of the Print Response message.")
    protected PrintResponse printResponse;
    /**
     * The Card reader init response.
     */
    @XmlElement(name = "CardReaderInitResponse")
    @Schema(description = "Content of the Card Reader Init Response message.")
    protected CardReaderInitResponse cardReaderInitResponse;
    /**
     * The Card reader apdu response.
     */
    @XmlElement(name = "CardReaderAPDUResponse")
    @Schema(description = "Content of the Card Reader APDU Response message.")
    protected CardReaderAPDUResponse cardReaderAPDUResponse;
    /**
     * The Card reader power off response.
     */
    @XmlElement(name = "CardReaderPowerOffResponse")
    @Schema(description = "Content of the Card Reader Power-Off Response message.")
    protected CardReaderPowerOffResponse cardReaderPowerOffResponse;
    /**
     * The Reconciliation response.
     */
    @XmlElement(name = "ReconciliationResponse")
    @Schema(description = "Content of the Reconciliation Response message.")
    protected ReconciliationResponse reconciliationResponse;
    /**
     * The Reversal response.
     */
    @XmlElement(name = "ReversalResponse")
    @Schema(description = "Content of the Reversal Response message.")
    protected ReversalResponse reversalResponse;
    /**
     * The Sound response.
     */
    @XmlElement(name = "SoundResponse")
    @Schema(description = "Content of the Sound Response message.")
    protected SoundResponse soundResponse;
    /**
     * The Stored value response.
     */
    @XmlElement(name = "StoredValueResponse")
    @Schema(description = "Content of the Stored Value Response message.")
    protected StoredValueResponse storedValueResponse;
    /**
     * The Transaction status response.
     */
    @XmlElement(name = "TransactionStatusResponse")
    @Schema(description = "Content of the TransactionStatus Response message.")
    protected TransactionStatusResponse transactionStatusResponse;
    /**
     * The Transmit response.
     */
    @XmlElement(name = "TransmitResponse")
    @Schema(description = "Content of the Transmit Response message.")
    protected TransmitResponse transmitResponse;
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
     * Gets the value of the balanceInquiryResponse property.
     *
     * @return possible      object is     {@link BalanceInquiryResponse }
     */
    public BalanceInquiryResponse getBalanceInquiryResponse() {
        return balanceInquiryResponse;
    }

    /**
     * Sets the value of the balanceInquiryResponse property.
     *
     * @param value allowed object is     {@link BalanceInquiryResponse }
     */
    public void setBalanceInquiryResponse(BalanceInquiryResponse value) {
        this.balanceInquiryResponse = value;
    }

    /**
     * Gets the value of the batchResponse property.
     *
     * @return possible      object is     {@link BatchResponse }
     */
    public BatchResponse getBatchResponse() {
        return batchResponse;
    }

    /**
     * Sets the value of the batchResponse property.
     *
     * @param value allowed object is     {@link BatchResponse }
     */
    public void setBatchResponse(BatchResponse value) {
        this.batchResponse = value;
    }

    /**
     * Gets the value of the cardAcquisitionResponse property.
     *
     * @return possible      object is     {@link CardAcquisitionResponse }
     */
    public CardAcquisitionResponse getCardAcquisitionResponse() {
        return cardAcquisitionResponse;
    }

    /**
     * Sets the value of the cardAcquisitionResponse property.
     *
     * @param value allowed object is     {@link CardAcquisitionResponse }
     */
    public void setCardAcquisitionResponse(CardAcquisitionResponse value) {
        this.cardAcquisitionResponse = value;
    }

    /**
     * Gets the value of the adminResponse property.
     *
     * @return possible      object is     {@link AdminResponse }
     */
    public AdminResponse getAdminResponse() {
        return adminResponse;
    }

    /**
     * Sets the value of the adminResponse property.
     *
     * @param value allowed object is     {@link AdminResponse }
     */
    public void setAdminResponse(AdminResponse value) {
        this.adminResponse = value;
    }

    /**
     * Gets the value of the diagnosisResponse property.
     *
     * @return possible      object is     {@link DiagnosisResponse }
     */
    public DiagnosisResponse getDiagnosisResponse() {
        return diagnosisResponse;
    }

    /**
     * Sets the value of the diagnosisResponse property.
     *
     * @param value allowed object is     {@link DiagnosisResponse }
     */
    public void setDiagnosisResponse(DiagnosisResponse value) {
        this.diagnosisResponse = value;
    }

    /**
     * Gets the value of the displayResponse property.
     *
     * @return possible      object is     {@link DisplayResponse }
     */
    public DisplayResponse getDisplayResponse() {
        return displayResponse;
    }

    /**
     * Sets the value of the displayResponse property.
     *
     * @param value allowed object is     {@link DisplayResponse }
     */
    public void setDisplayResponse(DisplayResponse value) {
        this.displayResponse = value;
    }

    /**
     * Gets the value of the enableServiceResponse property.
     *
     * @return possible      object is     {@link EnableServiceResponse }
     */
    public EnableServiceResponse getEnableServiceResponse() {
        return enableServiceResponse;
    }

    /**
     * Sets the value of the enableServiceResponse property.
     *
     * @param value allowed object is     {@link EnableServiceResponse }
     */
    public void setEnableServiceResponse(EnableServiceResponse value) {
        this.enableServiceResponse = value;
    }

    /**
     * Gets the value of the getTotalsResponse property.
     *
     * @return possible      object is     {@link GetTotalsResponse }
     */
    public GetTotalsResponse getGetTotalsResponse() {
        return getTotalsResponse;
    }

    /**
     * Sets the value of the getTotalsResponse property.
     *
     * @param value allowed object is     {@link GetTotalsResponse }
     */
    public void setGetTotalsResponse(GetTotalsResponse value) {
        this.getTotalsResponse = value;
    }

    /**
     * Gets the value of the inputResponse property.
     *
     * @return possible      object is     {@link InputResponse }
     */
    public InputResponse getInputResponse() {
        return inputResponse;
    }

    /**
     * Sets the value of the inputResponse property.
     *
     * @param value allowed object is     {@link InputResponse }
     */
    public void setInputResponse(InputResponse value) {
        this.inputResponse = value;
    }

    /**
     * Gets the value of the loginResponse property.
     *
     * @return possible      object is     {@link LoginResponse }
     */
    public LoginResponse getLoginResponse() {
        return loginResponse;
    }

    /**
     * Sets the value of the loginResponse property.
     *
     * @param value allowed object is     {@link LoginResponse }
     */
    public void setLoginResponse(LoginResponse value) {
        this.loginResponse = value;
    }

    /**
     * Gets the value of the logoutResponse property.
     *
     * @return possible      object is     {@link LogoutResponse }
     */
    public LogoutResponse getLogoutResponse() {
        return logoutResponse;
    }

    /**
     * Sets the value of the logoutResponse property.
     *
     * @param value allowed object is     {@link LogoutResponse }
     */
    public void setLogoutResponse(LogoutResponse value) {
        this.logoutResponse = value;
    }

    /**
     * Gets the value of the loyaltyResponse property.
     *
     * @return possible      object is     {@link LoyaltyResponse }
     */
    public LoyaltyResponse getLoyaltyResponse() {
        return loyaltyResponse;
    }

    /**
     * Sets the value of the loyaltyResponse property.
     *
     * @param value allowed object is     {@link LoyaltyResponse }
     */
    public void setLoyaltyResponse(LoyaltyResponse value) {
        this.loyaltyResponse = value;
    }

    /**
     * Gets the value of the paymentResponse property.
     *
     * @return possible      object is     {@link PaymentResponse }
     */
    public PaymentResponse getPaymentResponse() {
        return paymentResponse;
    }

    /**
     * Sets the value of the paymentResponse property.
     *
     * @param value allowed object is     {@link PaymentResponse }
     */
    public void setPaymentResponse(PaymentResponse value) {
        this.paymentResponse = value;
    }

    /**
     * Gets the value of the pinResponse property.
     *
     * @return possible      object is     {@link PINResponse }
     */
    public PINResponse getPINResponse() {
        return pinResponse;
    }

    /**
     * Sets the value of the pinResponse property.
     *
     * @param value allowed object is     {@link PINResponse }
     */
    public void setPINResponse(PINResponse value) {
        this.pinResponse = value;
    }

    /**
     * Gets the value of the printResponse property.
     *
     * @return possible      object is     {@link PrintResponse }
     */
    public PrintResponse getPrintResponse() {
        return printResponse;
    }

    /**
     * Sets the value of the printResponse property.
     *
     * @param value allowed object is     {@link PrintResponse }
     */
    public void setPrintResponse(PrintResponse value) {
        this.printResponse = value;
    }

    /**
     * Gets the value of the cardReaderInitResponse property.
     *
     * @return possible      object is     {@link CardReaderInitResponse }
     */
    public CardReaderInitResponse getCardReaderInitResponse() {
        return cardReaderInitResponse;
    }

    /**
     * Sets the value of the cardReaderInitResponse property.
     *
     * @param value allowed object is     {@link CardReaderInitResponse }
     */
    public void setCardReaderInitResponse(CardReaderInitResponse value) {
        this.cardReaderInitResponse = value;
    }

    /**
     * Gets the value of the cardReaderAPDUResponse property.
     *
     * @return possible      object is     {@link CardReaderAPDUResponse }
     */
    public CardReaderAPDUResponse getCardReaderAPDUResponse() {
        return cardReaderAPDUResponse;
    }

    /**
     * Sets the value of the cardReaderAPDUResponse property.
     *
     * @param value allowed object is     {@link CardReaderAPDUResponse }
     */
    public void setCardReaderAPDUResponse(CardReaderAPDUResponse value) {
        this.cardReaderAPDUResponse = value;
    }

    /**
     * Gets the value of the cardReaderPowerOffResponse property.
     *
     * @return possible      object is     {@link CardReaderPowerOffResponse }
     */
    public CardReaderPowerOffResponse getCardReaderPowerOffResponse() {
        return cardReaderPowerOffResponse;
    }

    /**
     * Sets the value of the cardReaderPowerOffResponse property.
     *
     * @param value allowed object is     {@link CardReaderPowerOffResponse }
     */
    public void setCardReaderPowerOffResponse(CardReaderPowerOffResponse value) {
        this.cardReaderPowerOffResponse = value;
    }

    /**
     * Gets the value of the reconciliationResponse property.
     *
     * @return possible      object is     {@link ReconciliationResponse }
     */
    public ReconciliationResponse getReconciliationResponse() {
        return reconciliationResponse;
    }

    /**
     * Sets the value of the reconciliationResponse property.
     *
     * @param value allowed object is     {@link ReconciliationResponse }
     */
    public void setReconciliationResponse(ReconciliationResponse value) {
        this.reconciliationResponse = value;
    }

    /**
     * Gets the value of the reversalResponse property.
     *
     * @return possible      object is     {@link ReversalResponse }
     */
    public ReversalResponse getReversalResponse() {
        return reversalResponse;
    }

    /**
     * Sets the value of the reversalResponse property.
     *
     * @param value allowed object is     {@link ReversalResponse }
     */
    public void setReversalResponse(ReversalResponse value) {
        this.reversalResponse = value;
    }

    /**
     * Gets the value of the soundResponse property.
     *
     * @return possible      object is     {@link SoundResponse }
     */
    public SoundResponse getSoundResponse() {
        return soundResponse;
    }

    /**
     * Sets the value of the soundResponse property.
     *
     * @param value allowed object is     {@link SoundResponse }
     */
    public void setSoundResponse(SoundResponse value) {
        this.soundResponse = value;
    }

    /**
     * Gets the value of the storedValueResponse property.
     *
     * @return possible      object is     {@link StoredValueResponse }
     */
    public StoredValueResponse getStoredValueResponse() {
        return storedValueResponse;
    }

    /**
     * Sets the value of the storedValueResponse property.
     *
     * @param value allowed object is     {@link StoredValueResponse }
     */
    public void setStoredValueResponse(StoredValueResponse value) {
        this.storedValueResponse = value;
    }

    /**
     * Gets the value of the transactionStatusResponse property.
     *
     * @return possible      object is     {@link TransactionStatusResponse }
     */
    public TransactionStatusResponse getTransactionStatusResponse() {
        return transactionStatusResponse;
    }

    /**
     * Sets the value of the transactionStatusResponse property.
     *
     * @param value allowed object is     {@link TransactionStatusResponse }
     */
    public void setTransactionStatusResponse(TransactionStatusResponse value) {
        this.transactionStatusResponse = value;
    }

    /**
     * Gets the value of the transmitResponse property.
     *
     * @return possible      object is     {@link TransmitResponse }
     */
    public TransmitResponse getTransmitResponse() {
        return transmitResponse;
    }

    /**
     * Sets the value of the transmitResponse property.
     *
     * @param value allowed object is     {@link TransmitResponse }
     */
    public void setTransmitResponse(TransmitResponse value) {
        this.transmitResponse = value;
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
