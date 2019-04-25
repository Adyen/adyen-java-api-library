
package com.adyen.model.nexo;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageHeader" type="{}MessageHeaderType"/>
 *         &lt;choice>
 *           &lt;element name="AbortRequest" type="{}AbortRequestType"/>
 *           &lt;element name="BalanceInquiryRequest" type="{}BalanceInquiryRequestType"/>
 *           &lt;element name="BatchRequest" type="{}BatchRequestType"/>
 *           &lt;element name="CardAcquisitionRequest" type="{}CardAcquisitionRequestType"/>
 *           &lt;element name="AdminRequest" type="{}AdminRequestType"/>
 *           &lt;element name="DiagnosisRequest" type="{}DiagnosisRequestType"/>
 *           &lt;element name="DisplayRequest" type="{}DisplayRequestType"/>
 *           &lt;element name="EnableServiceRequest" type="{}EnableServiceRequestType"/>
 *           &lt;element name="EventNotification" type="{}EventNotificationType"/>
 *           &lt;element name="GetTotalsRequest" type="{}GetTotalsRequestType"/>
 *           &lt;element name="InputRequest" type="{}InputRequestType"/>
 *           &lt;element name="InputUpdate" type="{}InputUpdateType"/>
 *           &lt;element name="LoginRequest" type="{}LoginRequestType"/>
 *           &lt;element name="LogoutRequest" type="{}LogoutRequestType"/>
 *           &lt;element name="LoyaltyRequest" type="{}LoyaltyRequestType"/>
 *           &lt;element name="PaymentRequest" type="{}PaymentRequestType"/>
 *           &lt;element name="PINRequest" type="{}PINRequestType"/>
 *           &lt;element name="PrintRequest" type="{}PrintRequestType"/>
 *           &lt;element name="CardReaderInitRequest" type="{}CardReaderInitRequestType"/>
 *           &lt;element name="CardReaderAPDURequest" type="{}CardReaderAPDURequestType"/>
 *           &lt;element name="CardReaderPowerOffRequest" type="{}CardReaderPowerOffRequestType"/>
 *           &lt;element name="ReconciliationRequest" type="{}ReconciliationRequestType"/>
 *           &lt;element name="ReversalRequest" type="{}ReversalRequestType"/>
 *           &lt;element name="SoundRequest" type="{}SoundRequestType"/>
 *           &lt;element name="StoredValueRequest" type="{}StoredValueRequestType"/>
 *           &lt;element name="TransactionStatusRequest" type="{}TransactionStatusRequestType"/>
 *           &lt;element name="TransmitRequest" type="{}TransmitRequestType"/>
 *         &lt;/choice>
 *         &lt;element name="SecurityTrailer" type="{}ContentInformationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
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

    @XmlElement(name = "MessageHeader", required = true)
    protected MessageHeaderType messageHeader;
    @XmlElement(name = "AbortRequest")
    protected AbortRequestType abortRequest;
    @XmlElement(name = "BalanceInquiryRequest")
    protected BalanceInquiryRequestType balanceInquiryRequest;
    @XmlElement(name = "BatchRequest")
    protected BatchRequestType batchRequest;
    @XmlElement(name = "CardAcquisitionRequest")
    protected CardAcquisitionRequestType cardAcquisitionRequest;
    @XmlElement(name = "AdminRequest")
    protected AdminRequestType adminRequest;
    @XmlElement(name = "DiagnosisRequest")
    protected DiagnosisRequestType diagnosisRequest;
    @XmlElement(name = "DisplayRequest")
    protected DisplayRequestType displayRequest;
    @XmlElement(name = "EnableServiceRequest")
    protected EnableServiceRequestType enableServiceRequest;
    @XmlElement(name = "EventNotification")
    protected EventNotificationType eventNotification;
    @XmlElement(name = "GetTotalsRequest")
    protected GetTotalsRequestType getTotalsRequest;
    @XmlElement(name = "InputRequest")
    protected InputRequestType inputRequest;
    @XmlElement(name = "InputUpdate")
    protected InputUpdateType inputUpdate;
    @XmlElement(name = "LoginRequest")
    protected LoginRequestType loginRequest;
    @XmlElement(name = "LogoutRequest")
    protected LogoutRequestType logoutRequest;
    @XmlElement(name = "LoyaltyRequest")
    protected LoyaltyRequestType loyaltyRequest;
    @XmlElement(name = "PaymentRequest")
    protected PaymentRequestType paymentRequest;
    @XmlElement(name = "PINRequest")
    protected PINRequestType pinRequest;
    @XmlElement(name = "PrintRequest")
    protected PrintRequestType printRequest;
    @XmlElement(name = "CardReaderInitRequest")
    protected CardReaderInitRequestType cardReaderInitRequest;
    @XmlElement(name = "CardReaderAPDURequest")
    protected CardReaderAPDURequestType cardReaderAPDURequest;
    @XmlElement(name = "CardReaderPowerOffRequest")
    protected CardReaderPowerOffRequestType cardReaderPowerOffRequest;
    @XmlElement(name = "ReconciliationRequest")
    protected ReconciliationRequestType reconciliationRequest;
    @XmlElement(name = "ReversalRequest")
    protected ReversalRequestType reversalRequest;
    @XmlElement(name = "SoundRequest")
    protected SoundRequestType soundRequest;
    @XmlElement(name = "StoredValueRequest")
    protected StoredValueRequestType storedValueRequest;
    @XmlElement(name = "TransactionStatusRequest")
    protected TransactionStatusRequestType transactionStatusRequest;
    @XmlElement(name = "TransmitRequest")
    protected TransmitRequestType transmitRequest;
    @XmlElement(name = "SecurityTrailer")
    protected ContentInformationType securityTrailer;

    /**
     * Gets the value of the messageHeader property.
     * 
     * @return
     *     possible object is
     *     {@link MessageHeaderType }
     *     
     */
    public MessageHeaderType getMessageHeader() {
        return messageHeader;
    }

    /**
     * Sets the value of the messageHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageHeaderType }
     *     
     */
    public void setMessageHeader(MessageHeaderType value) {
        this.messageHeader = value;
    }

    /**
     * Gets the value of the abortRequest property.
     * 
     * @return
     *     possible object is
     *     {@link AbortRequestType }
     *     
     */
    public AbortRequestType getAbortRequest() {
        return abortRequest;
    }

    /**
     * Sets the value of the abortRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link AbortRequestType }
     *     
     */
    public void setAbortRequest(AbortRequestType value) {
        this.abortRequest = value;
    }

    /**
     * Gets the value of the balanceInquiryRequest property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceInquiryRequestType }
     *     
     */
    public BalanceInquiryRequestType getBalanceInquiryRequest() {
        return balanceInquiryRequest;
    }

    /**
     * Sets the value of the balanceInquiryRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceInquiryRequestType }
     *     
     */
    public void setBalanceInquiryRequest(BalanceInquiryRequestType value) {
        this.balanceInquiryRequest = value;
    }

    /**
     * Gets the value of the batchRequest property.
     * 
     * @return
     *     possible object is
     *     {@link BatchRequestType }
     *     
     */
    public BatchRequestType getBatchRequest() {
        return batchRequest;
    }

    /**
     * Sets the value of the batchRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link BatchRequestType }
     *     
     */
    public void setBatchRequest(BatchRequestType value) {
        this.batchRequest = value;
    }

    /**
     * Gets the value of the cardAcquisitionRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CardAcquisitionRequestType }
     *     
     */
    public CardAcquisitionRequestType getCardAcquisitionRequest() {
        return cardAcquisitionRequest;
    }

    /**
     * Sets the value of the cardAcquisitionRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardAcquisitionRequestType }
     *     
     */
    public void setCardAcquisitionRequest(CardAcquisitionRequestType value) {
        this.cardAcquisitionRequest = value;
    }

    /**
     * Gets the value of the adminRequest property.
     * 
     * @return
     *     possible object is
     *     {@link AdminRequestType }
     *     
     */
    public AdminRequestType getAdminRequest() {
        return adminRequest;
    }

    /**
     * Sets the value of the adminRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdminRequestType }
     *     
     */
    public void setAdminRequest(AdminRequestType value) {
        this.adminRequest = value;
    }

    /**
     * Gets the value of the diagnosisRequest property.
     * 
     * @return
     *     possible object is
     *     {@link DiagnosisRequestType }
     *     
     */
    public DiagnosisRequestType getDiagnosisRequest() {
        return diagnosisRequest;
    }

    /**
     * Sets the value of the diagnosisRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiagnosisRequestType }
     *     
     */
    public void setDiagnosisRequest(DiagnosisRequestType value) {
        this.diagnosisRequest = value;
    }

    /**
     * Gets the value of the displayRequest property.
     * 
     * @return
     *     possible object is
     *     {@link DisplayRequestType }
     *     
     */
    public DisplayRequestType getDisplayRequest() {
        return displayRequest;
    }

    /**
     * Sets the value of the displayRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayRequestType }
     *     
     */
    public void setDisplayRequest(DisplayRequestType value) {
        this.displayRequest = value;
    }

    /**
     * Gets the value of the enableServiceRequest property.
     * 
     * @return
     *     possible object is
     *     {@link EnableServiceRequestType }
     *     
     */
    public EnableServiceRequestType getEnableServiceRequest() {
        return enableServiceRequest;
    }

    /**
     * Sets the value of the enableServiceRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnableServiceRequestType }
     *     
     */
    public void setEnableServiceRequest(EnableServiceRequestType value) {
        this.enableServiceRequest = value;
    }

    /**
     * Gets the value of the eventNotification property.
     * 
     * @return
     *     possible object is
     *     {@link EventNotificationType }
     *     
     */
    public EventNotificationType getEventNotification() {
        return eventNotification;
    }

    /**
     * Sets the value of the eventNotification property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventNotificationType }
     *     
     */
    public void setEventNotification(EventNotificationType value) {
        this.eventNotification = value;
    }

    /**
     * Gets the value of the getTotalsRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetTotalsRequestType }
     *     
     */
    public GetTotalsRequestType getGetTotalsRequest() {
        return getTotalsRequest;
    }

    /**
     * Sets the value of the getTotalsRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetTotalsRequestType }
     *     
     */
    public void setGetTotalsRequest(GetTotalsRequestType value) {
        this.getTotalsRequest = value;
    }

    /**
     * Gets the value of the inputRequest property.
     * 
     * @return
     *     possible object is
     *     {@link InputRequestType }
     *     
     */
    public InputRequestType getInputRequest() {
        return inputRequest;
    }

    /**
     * Sets the value of the inputRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link InputRequestType }
     *     
     */
    public void setInputRequest(InputRequestType value) {
        this.inputRequest = value;
    }

    /**
     * Gets the value of the inputUpdate property.
     * 
     * @return
     *     possible object is
     *     {@link InputUpdateType }
     *     
     */
    public InputUpdateType getInputUpdate() {
        return inputUpdate;
    }

    /**
     * Sets the value of the inputUpdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link InputUpdateType }
     *     
     */
    public void setInputUpdate(InputUpdateType value) {
        this.inputUpdate = value;
    }

    /**
     * Gets the value of the loginRequest property.
     * 
     * @return
     *     possible object is
     *     {@link LoginRequestType }
     *     
     */
    public LoginRequestType getLoginRequest() {
        return loginRequest;
    }

    /**
     * Sets the value of the loginRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoginRequestType }
     *     
     */
    public void setLoginRequest(LoginRequestType value) {
        this.loginRequest = value;
    }

    /**
     * Gets the value of the logoutRequest property.
     * 
     * @return
     *     possible object is
     *     {@link LogoutRequestType }
     *     
     */
    public LogoutRequestType getLogoutRequest() {
        return logoutRequest;
    }

    /**
     * Sets the value of the logoutRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogoutRequestType }
     *     
     */
    public void setLogoutRequest(LogoutRequestType value) {
        this.logoutRequest = value;
    }

    /**
     * Gets the value of the loyaltyRequest property.
     * 
     * @return
     *     possible object is
     *     {@link LoyaltyRequestType }
     *     
     */
    public LoyaltyRequestType getLoyaltyRequest() {
        return loyaltyRequest;
    }

    /**
     * Sets the value of the loyaltyRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoyaltyRequestType }
     *     
     */
    public void setLoyaltyRequest(LoyaltyRequestType value) {
        this.loyaltyRequest = value;
    }

    /**
     * Gets the value of the paymentRequest property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentRequestType }
     *     
     */
    public PaymentRequestType getPaymentRequest() {
        return paymentRequest;
    }

    /**
     * Sets the value of the paymentRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentRequestType }
     *     
     */
    public void setPaymentRequest(PaymentRequestType value) {
        this.paymentRequest = value;
    }

    /**
     * Gets the value of the pinRequest property.
     * 
     * @return
     *     possible object is
     *     {@link PINRequestType }
     *     
     */
    public PINRequestType getPINRequest() {
        return pinRequest;
    }

    /**
     * Sets the value of the pinRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link PINRequestType }
     *     
     */
    public void setPINRequest(PINRequestType value) {
        this.pinRequest = value;
    }

    /**
     * Gets the value of the printRequest property.
     * 
     * @return
     *     possible object is
     *     {@link PrintRequestType }
     *     
     */
    public PrintRequestType getPrintRequest() {
        return printRequest;
    }

    /**
     * Sets the value of the printRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrintRequestType }
     *     
     */
    public void setPrintRequest(PrintRequestType value) {
        this.printRequest = value;
    }

    /**
     * Gets the value of the cardReaderInitRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CardReaderInitRequestType }
     *     
     */
    public CardReaderInitRequestType getCardReaderInitRequest() {
        return cardReaderInitRequest;
    }

    /**
     * Sets the value of the cardReaderInitRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardReaderInitRequestType }
     *     
     */
    public void setCardReaderInitRequest(CardReaderInitRequestType value) {
        this.cardReaderInitRequest = value;
    }

    /**
     * Gets the value of the cardReaderAPDURequest property.
     * 
     * @return
     *     possible object is
     *     {@link CardReaderAPDURequestType }
     *     
     */
    public CardReaderAPDURequestType getCardReaderAPDURequest() {
        return cardReaderAPDURequest;
    }

    /**
     * Sets the value of the cardReaderAPDURequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardReaderAPDURequestType }
     *     
     */
    public void setCardReaderAPDURequest(CardReaderAPDURequestType value) {
        this.cardReaderAPDURequest = value;
    }

    /**
     * Gets the value of the cardReaderPowerOffRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CardReaderPowerOffRequestType }
     *     
     */
    public CardReaderPowerOffRequestType getCardReaderPowerOffRequest() {
        return cardReaderPowerOffRequest;
    }

    /**
     * Sets the value of the cardReaderPowerOffRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardReaderPowerOffRequestType }
     *     
     */
    public void setCardReaderPowerOffRequest(CardReaderPowerOffRequestType value) {
        this.cardReaderPowerOffRequest = value;
    }

    /**
     * Gets the value of the reconciliationRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ReconciliationRequestType }
     *     
     */
    public ReconciliationRequestType getReconciliationRequest() {
        return reconciliationRequest;
    }

    /**
     * Sets the value of the reconciliationRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReconciliationRequestType }
     *     
     */
    public void setReconciliationRequest(ReconciliationRequestType value) {
        this.reconciliationRequest = value;
    }

    /**
     * Gets the value of the reversalRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ReversalRequestType }
     *     
     */
    public ReversalRequestType getReversalRequest() {
        return reversalRequest;
    }

    /**
     * Sets the value of the reversalRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReversalRequestType }
     *     
     */
    public void setReversalRequest(ReversalRequestType value) {
        this.reversalRequest = value;
    }

    /**
     * Gets the value of the soundRequest property.
     * 
     * @return
     *     possible object is
     *     {@link SoundRequestType }
     *     
     */
    public SoundRequestType getSoundRequest() {
        return soundRequest;
    }

    /**
     * Sets the value of the soundRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoundRequestType }
     *     
     */
    public void setSoundRequest(SoundRequestType value) {
        this.soundRequest = value;
    }

    /**
     * Gets the value of the storedValueRequest property.
     * 
     * @return
     *     possible object is
     *     {@link StoredValueRequestType }
     *     
     */
    public StoredValueRequestType getStoredValueRequest() {
        return storedValueRequest;
    }

    /**
     * Sets the value of the storedValueRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link StoredValueRequestType }
     *     
     */
    public void setStoredValueRequest(StoredValueRequestType value) {
        this.storedValueRequest = value;
    }

    /**
     * Gets the value of the transactionStatusRequest property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionStatusRequestType }
     *     
     */
    public TransactionStatusRequestType getTransactionStatusRequest() {
        return transactionStatusRequest;
    }

    /**
     * Sets the value of the transactionStatusRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionStatusRequestType }
     *     
     */
    public void setTransactionStatusRequest(TransactionStatusRequestType value) {
        this.transactionStatusRequest = value;
    }

    /**
     * Gets the value of the transmitRequest property.
     * 
     * @return
     *     possible object is
     *     {@link TransmitRequestType }
     *     
     */
    public TransmitRequestType getTransmitRequest() {
        return transmitRequest;
    }

    /**
     * Sets the value of the transmitRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransmitRequestType }
     *     
     */
    public void setTransmitRequest(TransmitRequestType value) {
        this.transmitRequest = value;
    }

    /**
     * Gets the value of the securityTrailer property.
     * 
     * @return
     *     possible object is
     *     {@link ContentInformationType }
     *     
     */
    public ContentInformationType getSecurityTrailer() {
        return securityTrailer;
    }

    /**
     * Sets the value of the securityTrailer property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentInformationType }
     *     
     */
    public void setSecurityTrailer(ContentInformationType value) {
        this.securityTrailer = value;
    }

}
