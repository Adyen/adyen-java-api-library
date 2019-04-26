
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
 *         &lt;element name="MessageHeader" type="{}MessageHeader"/>
 *         &lt;choice>
 *           &lt;element name="AbortRequest" type="{}AbortRequest"/>
 *           &lt;element name="BalanceInquiryRequest" type="{}BalanceInquiryRequest"/>
 *           &lt;element name="BatchRequest" type="{}BatchRequest"/>
 *           &lt;element name="CardAcquisitionRequest" type="{}CardAcquisitionRequest"/>
 *           &lt;element name="AdminRequest" type="{}AdminRequest"/>
 *           &lt;element name="DiagnosisRequest" type="{}DiagnosisRequest"/>
 *           &lt;element name="DisplayRequest" type="{}DisplayRequest"/>
 *           &lt;element name="EnableServiceRequest" type="{}EnableServiceRequest"/>
 *           &lt;element name="EventNotification" type="{}EventNotification"/>
 *           &lt;element name="GetTotalsRequest" type="{}GetTotalsRequest"/>
 *           &lt;element name="InputRequest" type="{}InputRequest"/>
 *           &lt;element name="InputUpdate" type="{}InputUpdate"/>
 *           &lt;element name="LoginRequest" type="{}LoginRequest"/>
 *           &lt;element name="LogoutRequest" type="{}LogoutRequest"/>
 *           &lt;element name="LoyaltyRequest" type="{}LoyaltyRequest"/>
 *           &lt;element name="PaymentRequest" type="{}PaymentRequest"/>
 *           &lt;element name="PINRequest" type="{}PINRequest"/>
 *           &lt;element name="PrintRequest" type="{}PrintRequest"/>
 *           &lt;element name="CardReaderInitRequest" type="{}CardReaderInitRequest"/>
 *           &lt;element name="CardReaderAPDURequest" type="{}CardReaderAPDURequest"/>
 *           &lt;element name="CardReaderPowerOffRequest" type="{}CardReaderPowerOffRequest"/>
 *           &lt;element name="ReconciliationRequest" type="{}ReconciliationRequest"/>
 *           &lt;element name="ReversalRequest" type="{}ReversalRequest"/>
 *           &lt;element name="SoundRequest" type="{}SoundRequest"/>
 *           &lt;element name="StoredValueRequest" type="{}StoredValueRequest"/>
 *           &lt;element name="TransactionStatusRequest" type="{}TransactionStatusRequest"/>
 *           &lt;element name="TransmitRequest" type="{}TransmitRequest"/>
 *         &lt;/choice>
 *         &lt;element name="SecurityTrailer" type="{}ContentInformation" minOccurs="0"/>
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
    protected MessageHeader messageHeader;
    @XmlElement(name = "AbortRequest")
    protected AbortRequest abortRequest;
    @XmlElement(name = "BalanceInquiryRequest")
    protected BalanceInquiryRequest balanceInquiryRequest;
    @XmlElement(name = "BatchRequest")
    protected BatchRequest batchRequest;
    @XmlElement(name = "CardAcquisitionRequest")
    protected CardAcquisitionRequest cardAcquisitionRequest;
    @XmlElement(name = "AdminRequest")
    protected AdminRequest adminRequest;
    @XmlElement(name = "DiagnosisRequest")
    protected DiagnosisRequest diagnosisRequest;
    @XmlElement(name = "DisplayRequest")
    protected DisplayRequest displayRequest;
    @XmlElement(name = "EnableServiceRequest")
    protected EnableServiceRequest enableServiceRequest;
    @XmlElement(name = "EventNotification")
    protected EventNotification eventNotification;
    @XmlElement(name = "GetTotalsRequest")
    protected GetTotalsRequest getTotalsRequest;
    @XmlElement(name = "InputRequest")
    protected InputRequest inputRequest;
    @XmlElement(name = "InputUpdate")
    protected InputUpdate inputUpdate;
    @XmlElement(name = "LoginRequest")
    protected LoginRequest loginRequest;
    @XmlElement(name = "LogoutRequest")
    protected LogoutRequest logoutRequest;
    @XmlElement(name = "LoyaltyRequest")
    protected LoyaltyRequest loyaltyRequest;
    @XmlElement(name = "PaymentRequest")
    protected PaymentRequest paymentRequest;
    @XmlElement(name = "PINRequest")
    protected PINRequest pinRequest;
    @XmlElement(name = "PrintRequest")
    protected PrintRequest printRequest;
    @XmlElement(name = "CardReaderInitRequest")
    protected CardReaderInitRequest cardReaderInitRequest;
    @XmlElement(name = "CardReaderAPDURequest")
    protected CardReaderAPDURequest cardReaderAPDURequest;
    @XmlElement(name = "CardReaderPowerOffRequest")
    protected CardReaderPowerOffRequest cardReaderPowerOffRequest;
    @XmlElement(name = "ReconciliationRequest")
    protected ReconciliationRequest reconciliationRequest;
    @XmlElement(name = "ReversalRequest")
    protected ReversalRequest reversalRequest;
    @XmlElement(name = "SoundRequest")
    protected SoundRequest soundRequest;
    @XmlElement(name = "StoredValueRequest")
    protected StoredValueRequest storedValueRequest;
    @XmlElement(name = "TransactionStatusRequest")
    protected TransactionStatusRequest transactionStatusRequest;
    @XmlElement(name = "TransmitRequest")
    protected TransmitRequest transmitRequest;
    @XmlElement(name = "SecurityTrailer")
    protected ContentInformation securityTrailer;

    /**
     * Gets the value of the messageHeader property.
     *
     * @return
     *     possible object is
     *     {@link MessageHeader }
     *
     */
    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    /**
     * Sets the value of the messageHeader property.
     *
     * @param value
     *     allowed object is
     *     {@link MessageHeader }
     *
     */
    public void setMessageHeader(MessageHeader value) {
        this.messageHeader = value;
    }

    /**
     * Gets the value of the abortRequest property.
     *
     * @return
     *     possible object is
     *     {@link AbortRequest }
     *
     */
    public AbortRequest getAbortRequest() {
        return abortRequest;
    }

    /**
     * Sets the value of the abortRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link AbortRequest }
     *
     */
    public void setAbortRequest(AbortRequest value) {
        this.abortRequest = value;
    }

    /**
     * Gets the value of the balanceInquiryRequest property.
     *
     * @return
     *     possible object is
     *     {@link BalanceInquiryRequest }
     *
     */
    public BalanceInquiryRequest getBalanceInquiryRequest() {
        return balanceInquiryRequest;
    }

    /**
     * Sets the value of the balanceInquiryRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link BalanceInquiryRequest }
     *
     */
    public void setBalanceInquiryRequest(BalanceInquiryRequest value) {
        this.balanceInquiryRequest = value;
    }

    /**
     * Gets the value of the batchRequest property.
     *
     * @return
     *     possible object is
     *     {@link BatchRequest }
     *
     */
    public BatchRequest getBatchRequest() {
        return batchRequest;
    }

    /**
     * Sets the value of the batchRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link BatchRequest }
     *
     */
    public void setBatchRequest(BatchRequest value) {
        this.batchRequest = value;
    }

    /**
     * Gets the value of the cardAcquisitionRequest property.
     *
     * @return
     *     possible object is
     *     {@link CardAcquisitionRequest }
     *
     */
    public CardAcquisitionRequest getCardAcquisitionRequest() {
        return cardAcquisitionRequest;
    }

    /**
     * Sets the value of the cardAcquisitionRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link CardAcquisitionRequest }
     *
     */
    public void setCardAcquisitionRequest(CardAcquisitionRequest value) {
        this.cardAcquisitionRequest = value;
    }

    /**
     * Gets the value of the adminRequest property.
     *
     * @return
     *     possible object is
     *     {@link AdminRequest }
     *
     */
    public AdminRequest getAdminRequest() {
        return adminRequest;
    }

    /**
     * Sets the value of the adminRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link AdminRequest }
     *
     */
    public void setAdminRequest(AdminRequest value) {
        this.adminRequest = value;
    }

    /**
     * Gets the value of the diagnosisRequest property.
     *
     * @return
     *     possible object is
     *     {@link DiagnosisRequest }
     *
     */
    public DiagnosisRequest getDiagnosisRequest() {
        return diagnosisRequest;
    }

    /**
     * Sets the value of the diagnosisRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link DiagnosisRequest }
     *
     */
    public void setDiagnosisRequest(DiagnosisRequest value) {
        this.diagnosisRequest = value;
    }

    /**
     * Gets the value of the displayRequest property.
     *
     * @return
     *     possible object is
     *     {@link DisplayRequest }
     *
     */
    public DisplayRequest getDisplayRequest() {
        return displayRequest;
    }

    /**
     * Sets the value of the displayRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link DisplayRequest }
     *
     */
    public void setDisplayRequest(DisplayRequest value) {
        this.displayRequest = value;
    }

    /**
     * Gets the value of the enableServiceRequest property.
     *
     * @return
     *     possible object is
     *     {@link EnableServiceRequest }
     *
     */
    public EnableServiceRequest getEnableServiceRequest() {
        return enableServiceRequest;
    }

    /**
     * Sets the value of the enableServiceRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link EnableServiceRequest }
     *
     */
    public void setEnableServiceRequest(EnableServiceRequest value) {
        this.enableServiceRequest = value;
    }

    /**
     * Gets the value of the eventNotification property.
     *
     * @return
     *     possible object is
     *     {@link EventNotification }
     *
     */
    public EventNotification getEventNotification() {
        return eventNotification;
    }

    /**
     * Sets the value of the eventNotification property.
     *
     * @param value
     *     allowed object is
     *     {@link EventNotification }
     *
     */
    public void setEventNotification(EventNotification value) {
        this.eventNotification = value;
    }

    /**
     * Gets the value of the getTotalsRequest property.
     *
     * @return
     *     possible object is
     *     {@link GetTotalsRequest }
     *
     */
    public GetTotalsRequest getGetTotalsRequest() {
        return getTotalsRequest;
    }

    /**
     * Sets the value of the getTotalsRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link GetTotalsRequest }
     *
     */
    public void setGetTotalsRequest(GetTotalsRequest value) {
        this.getTotalsRequest = value;
    }

    /**
     * Gets the value of the inputRequest property.
     *
     * @return
     *     possible object is
     *     {@link InputRequest }
     *
     */
    public InputRequest getInputRequest() {
        return inputRequest;
    }

    /**
     * Sets the value of the inputRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link InputRequest }
     *
     */
    public void setInputRequest(InputRequest value) {
        this.inputRequest = value;
    }

    /**
     * Gets the value of the inputUpdate property.
     *
     * @return
     *     possible object is
     *     {@link InputUpdate }
     *
     */
    public InputUpdate getInputUpdate() {
        return inputUpdate;
    }

    /**
     * Sets the value of the inputUpdate property.
     *
     * @param value
     *     allowed object is
     *     {@link InputUpdate }
     *
     */
    public void setInputUpdate(InputUpdate value) {
        this.inputUpdate = value;
    }

    /**
     * Gets the value of the loginRequest property.
     *
     * @return
     *     possible object is
     *     {@link LoginRequest }
     *
     */
    public LoginRequest getLoginRequest() {
        return loginRequest;
    }

    /**
     * Sets the value of the loginRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link LoginRequest }
     *
     */
    public void setLoginRequest(LoginRequest value) {
        this.loginRequest = value;
    }

    /**
     * Gets the value of the logoutRequest property.
     *
     * @return
     *     possible object is
     *     {@link LogoutRequest }
     *
     */
    public LogoutRequest getLogoutRequest() {
        return logoutRequest;
    }

    /**
     * Sets the value of the logoutRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link LogoutRequest }
     *
     */
    public void setLogoutRequest(LogoutRequest value) {
        this.logoutRequest = value;
    }

    /**
     * Gets the value of the loyaltyRequest property.
     *
     * @return
     *     possible object is
     *     {@link LoyaltyRequest }
     *
     */
    public LoyaltyRequest getLoyaltyRequest() {
        return loyaltyRequest;
    }

    /**
     * Sets the value of the loyaltyRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link LoyaltyRequest }
     *
     */
    public void setLoyaltyRequest(LoyaltyRequest value) {
        this.loyaltyRequest = value;
    }

    /**
     * Gets the value of the paymentRequest property.
     *
     * @return
     *     possible object is
     *     {@link PaymentRequest }
     *
     */
    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }

    /**
     * Sets the value of the paymentRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link PaymentRequest }
     *
     */
    public void setPaymentRequest(PaymentRequest value) {
        this.paymentRequest = value;
    }

    /**
     * Gets the value of the pinRequest property.
     *
     * @return
     *     possible object is
     *     {@link PINRequest }
     *
     */
    public PINRequest getPINRequest() {
        return pinRequest;
    }

    /**
     * Sets the value of the pinRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link PINRequest }
     *
     */
    public void setPINRequest(PINRequest value) {
        this.pinRequest = value;
    }

    /**
     * Gets the value of the printRequest property.
     *
     * @return
     *     possible object is
     *     {@link PrintRequest }
     *
     */
    public PrintRequest getPrintRequest() {
        return printRequest;
    }

    /**
     * Sets the value of the printRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link PrintRequest }
     *
     */
    public void setPrintRequest(PrintRequest value) {
        this.printRequest = value;
    }

    /**
     * Gets the value of the cardReaderInitRequest property.
     *
     * @return
     *     possible object is
     *     {@link CardReaderInitRequest }
     *
     */
    public CardReaderInitRequest getCardReaderInitRequest() {
        return cardReaderInitRequest;
    }

    /**
     * Sets the value of the cardReaderInitRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link CardReaderInitRequest }
     *
     */
    public void setCardReaderInitRequest(CardReaderInitRequest value) {
        this.cardReaderInitRequest = value;
    }

    /**
     * Gets the value of the cardReaderAPDURequest property.
     *
     * @return
     *     possible object is
     *     {@link CardReaderAPDURequest }
     *
     */
    public CardReaderAPDURequest getCardReaderAPDURequest() {
        return cardReaderAPDURequest;
    }

    /**
     * Sets the value of the cardReaderAPDURequest property.
     *
     * @param value
     *     allowed object is
     *     {@link CardReaderAPDURequest }
     *
     */
    public void setCardReaderAPDURequest(CardReaderAPDURequest value) {
        this.cardReaderAPDURequest = value;
    }

    /**
     * Gets the value of the cardReaderPowerOffRequest property.
     *
     * @return
     *     possible object is
     *     {@link CardReaderPowerOffRequest }
     *
     */
    public CardReaderPowerOffRequest getCardReaderPowerOffRequest() {
        return cardReaderPowerOffRequest;
    }

    /**
     * Sets the value of the cardReaderPowerOffRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link CardReaderPowerOffRequest }
     *
     */
    public void setCardReaderPowerOffRequest(CardReaderPowerOffRequest value) {
        this.cardReaderPowerOffRequest = value;
    }

    /**
     * Gets the value of the reconciliationRequest property.
     *
     * @return
     *     possible object is
     *     {@link ReconciliationRequest }
     *
     */
    public ReconciliationRequest getReconciliationRequest() {
        return reconciliationRequest;
    }

    /**
     * Sets the value of the reconciliationRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link ReconciliationRequest }
     *
     */
    public void setReconciliationRequest(ReconciliationRequest value) {
        this.reconciliationRequest = value;
    }

    /**
     * Gets the value of the reversalRequest property.
     *
     * @return
     *     possible object is
     *     {@link ReversalRequest }
     *
     */
    public ReversalRequest getReversalRequest() {
        return reversalRequest;
    }

    /**
     * Sets the value of the reversalRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link ReversalRequest }
     *
     */
    public void setReversalRequest(ReversalRequest value) {
        this.reversalRequest = value;
    }

    /**
     * Gets the value of the soundRequest property.
     *
     * @return
     *     possible object is
     *     {@link SoundRequest }
     *
     */
    public SoundRequest getSoundRequest() {
        return soundRequest;
    }

    /**
     * Sets the value of the soundRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link SoundRequest }
     *
     */
    public void setSoundRequest(SoundRequest value) {
        this.soundRequest = value;
    }

    /**
     * Gets the value of the storedValueRequest property.
     *
     * @return
     *     possible object is
     *     {@link StoredValueRequest }
     *
     */
    public StoredValueRequest getStoredValueRequest() {
        return storedValueRequest;
    }

    /**
     * Sets the value of the storedValueRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link StoredValueRequest }
     *
     */
    public void setStoredValueRequest(StoredValueRequest value) {
        this.storedValueRequest = value;
    }

    /**
     * Gets the value of the transactionStatusRequest property.
     *
     * @return
     *     possible object is
     *     {@link TransactionStatusRequest }
     *
     */
    public TransactionStatusRequest getTransactionStatusRequest() {
        return transactionStatusRequest;
    }

    /**
     * Sets the value of the transactionStatusRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link TransactionStatusRequest }
     *
     */
    public void setTransactionStatusRequest(TransactionStatusRequest value) {
        this.transactionStatusRequest = value;
    }

    /**
     * Gets the value of the transmitRequest property.
     *
     * @return
     *     possible object is
     *     {@link TransmitRequest }
     *
     */
    public TransmitRequest getTransmitRequest() {
        return transmitRequest;
    }

    /**
     * Sets the value of the transmitRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link TransmitRequest }
     *
     */
    public void setTransmitRequest(TransmitRequest value) {
        this.transmitRequest = value;
    }

    /**
     * Gets the value of the securityTrailer property.
     *
     * @return
     *     possible object is
     *     {@link ContentInformation }
     *
     */
    public ContentInformation getSecurityTrailer() {
        return securityTrailer;
    }

    /**
     * Sets the value of the securityTrailer property.
     *
     * @param value
     *     allowed object is
     *     {@link ContentInformation }
     *
     */
    public void setSecurityTrailer(ContentInformation value) {
        this.securityTrailer = value;
    }

}
