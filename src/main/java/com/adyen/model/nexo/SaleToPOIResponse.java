
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
 *           &lt;element name="BalanceInquiryResponse" type="{}BalanceInquiryResponse"/>
 *           &lt;element name="BatchResponse" type="{}BatchResponse"/>
 *           &lt;element name="CardAcquisitionResponse" type="{}CardAcquisitionResponse"/>
 *           &lt;element name="AdminResponse" type="{}AdminResponse"/>
 *           &lt;element name="DiagnosisResponse" type="{}DiagnosisResponse"/>
 *           &lt;element name="DisplayResponse" type="{}DisplayResponse"/>
 *           &lt;element name="EnableServiceResponse" type="{}EnableServiceResponse"/>
 *           &lt;element name="GetTotalsResponse" type="{}GetTotalsResponse"/>
 *           &lt;element name="InputResponse" type="{}InputResponse"/>
 *           &lt;element name="LoginResponse" type="{}LoginResponse"/>
 *           &lt;element name="LogoutResponse" type="{}LogoutResponse"/>
 *           &lt;element name="LoyaltyResponse" type="{}LoyaltyResponse"/>
 *           &lt;element name="PaymentResponse" type="{}PaymentResponse"/>
 *           &lt;element name="PINResponse" type="{}PINResponse"/>
 *           &lt;element name="PrintResponse" type="{}PrintResponse"/>
 *           &lt;element name="CardReaderInitResponse" type="{}CardReaderInitResponse"/>
 *           &lt;element name="CardReaderAPDUResponse" type="{}CardReaderAPDUResponse"/>
 *           &lt;element name="CardReaderPowerOffResponse" type="{}CardReaderPowerOffResponse"/>
 *           &lt;element name="ReconciliationResponse" type="{}ReconciliationResponse"/>
 *           &lt;element name="ReversalResponse" type="{}ReversalResponse"/>
 *           &lt;element name="SoundResponse" type="{}SoundResponse"/>
 *           &lt;element name="StoredValueResponse" type="{}StoredValueResponse"/>
 *           &lt;element name="TransactionStatusResponse" type="{}TransactionStatusResponse"/>
 *           &lt;element name="TransmitResponse" type="{}TransmitResponse"/>
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

    @XmlElement(name = "MessageHeader", required = true)
    protected MessageHeader messageHeader;
    @XmlElement(name = "BalanceInquiryResponse")
    protected BalanceInquiryResponse balanceInquiryResponse;
    @XmlElement(name = "BatchResponse")
    protected BatchResponse batchResponse;
    @XmlElement(name = "CardAcquisitionResponse")
    protected CardAcquisitionResponse cardAcquisitionResponse;
    @XmlElement(name = "AdminResponse")
    protected AdminResponse adminResponse;
    @XmlElement(name = "DiagnosisResponse")
    protected DiagnosisResponse diagnosisResponse;
    @XmlElement(name = "DisplayResponse")
    protected DisplayResponse displayResponse;
    @XmlElement(name = "EnableServiceResponse")
    protected EnableServiceResponse enableServiceResponse;
    @XmlElement(name = "GetTotalsResponse")
    protected GetTotalsResponse getTotalsResponse;
    @XmlElement(name = "InputResponse")
    protected InputResponse inputResponse;
    @XmlElement(name = "LoginResponse")
    protected LoginResponse loginResponse;
    @XmlElement(name = "LogoutResponse")
    protected LogoutResponse logoutResponse;
    @XmlElement(name = "LoyaltyResponse")
    protected LoyaltyResponse loyaltyResponse;
    @XmlElement(name = "PaymentResponse")
    protected PaymentResponse paymentResponse;
    @XmlElement(name = "PINResponse")
    protected PINResponse pinResponse;
    @XmlElement(name = "PrintResponse")
    protected PrintResponse printResponse;
    @XmlElement(name = "CardReaderInitResponse")
    protected CardReaderInitResponse cardReaderInitResponse;
    @XmlElement(name = "CardReaderAPDUResponse")
    protected CardReaderAPDUResponse cardReaderAPDUResponse;
    @XmlElement(name = "CardReaderPowerOffResponse")
    protected CardReaderPowerOffResponse cardReaderPowerOffResponse;
    @XmlElement(name = "ReconciliationResponse")
    protected ReconciliationResponse reconciliationResponse;
    @XmlElement(name = "ReversalResponse")
    protected ReversalResponse reversalResponse;
    @XmlElement(name = "SoundResponse")
    protected SoundResponse soundResponse;
    @XmlElement(name = "StoredValueResponse")
    protected StoredValueResponse storedValueResponse;
    @XmlElement(name = "TransactionStatusResponse")
    protected TransactionStatusResponse transactionStatusResponse;
    @XmlElement(name = "TransmitResponse")
    protected TransmitResponse transmitResponse;
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
     * Gets the value of the balanceInquiryResponse property.
     *
     * @return
     *     possible object is
     *     {@link BalanceInquiryResponse }
     *
     */
    public BalanceInquiryResponse getBalanceInquiryResponse() {
        return balanceInquiryResponse;
    }

    /**
     * Sets the value of the balanceInquiryResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link BalanceInquiryResponse }
     *
     */
    public void setBalanceInquiryResponse(BalanceInquiryResponse value) {
        this.balanceInquiryResponse = value;
    }

    /**
     * Gets the value of the batchResponse property.
     *
     * @return
     *     possible object is
     *     {@link BatchResponse }
     *
     */
    public BatchResponse getBatchResponse() {
        return batchResponse;
    }

    /**
     * Sets the value of the batchResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link BatchResponse }
     *
     */
    public void setBatchResponse(BatchResponse value) {
        this.batchResponse = value;
    }

    /**
     * Gets the value of the cardAcquisitionResponse property.
     *
     * @return
     *     possible object is
     *     {@link CardAcquisitionResponse }
     *
     */
    public CardAcquisitionResponse getCardAcquisitionResponse() {
        return cardAcquisitionResponse;
    }

    /**
     * Sets the value of the cardAcquisitionResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link CardAcquisitionResponse }
     *
     */
    public void setCardAcquisitionResponse(CardAcquisitionResponse value) {
        this.cardAcquisitionResponse = value;
    }

    /**
     * Gets the value of the adminResponse property.
     *
     * @return
     *     possible object is
     *     {@link AdminResponse }
     *
     */
    public AdminResponse getAdminResponse() {
        return adminResponse;
    }

    /**
     * Sets the value of the adminResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link AdminResponse }
     *
     */
    public void setAdminResponse(AdminResponse value) {
        this.adminResponse = value;
    }

    /**
     * Gets the value of the diagnosisResponse property.
     *
     * @return
     *     possible object is
     *     {@link DiagnosisResponse }
     *
     */
    public DiagnosisResponse getDiagnosisResponse() {
        return diagnosisResponse;
    }

    /**
     * Sets the value of the diagnosisResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link DiagnosisResponse }
     *
     */
    public void setDiagnosisResponse(DiagnosisResponse value) {
        this.diagnosisResponse = value;
    }

    /**
     * Gets the value of the displayResponse property.
     *
     * @return
     *     possible object is
     *     {@link DisplayResponse }
     *
     */
    public DisplayResponse getDisplayResponse() {
        return displayResponse;
    }

    /**
     * Sets the value of the displayResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link DisplayResponse }
     *
     */
    public void setDisplayResponse(DisplayResponse value) {
        this.displayResponse = value;
    }

    /**
     * Gets the value of the enableServiceResponse property.
     *
     * @return
     *     possible object is
     *     {@link EnableServiceResponse }
     *
     */
    public EnableServiceResponse getEnableServiceResponse() {
        return enableServiceResponse;
    }

    /**
     * Sets the value of the enableServiceResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link EnableServiceResponse }
     *
     */
    public void setEnableServiceResponse(EnableServiceResponse value) {
        this.enableServiceResponse = value;
    }

    /**
     * Gets the value of the getTotalsResponse property.
     *
     * @return
     *     possible object is
     *     {@link GetTotalsResponse }
     *
     */
    public GetTotalsResponse getGetTotalsResponse() {
        return getTotalsResponse;
    }

    /**
     * Sets the value of the getTotalsResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link GetTotalsResponse }
     *
     */
    public void setGetTotalsResponse(GetTotalsResponse value) {
        this.getTotalsResponse = value;
    }

    /**
     * Gets the value of the inputResponse property.
     *
     * @return
     *     possible object is
     *     {@link InputResponse }
     *
     */
    public InputResponse getInputResponse() {
        return inputResponse;
    }

    /**
     * Sets the value of the inputResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link InputResponse }
     *
     */
    public void setInputResponse(InputResponse value) {
        this.inputResponse = value;
    }

    /**
     * Gets the value of the loginResponse property.
     *
     * @return
     *     possible object is
     *     {@link LoginResponse }
     *
     */
    public LoginResponse getLoginResponse() {
        return loginResponse;
    }

    /**
     * Sets the value of the loginResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link LoginResponse }
     *
     */
    public void setLoginResponse(LoginResponse value) {
        this.loginResponse = value;
    }

    /**
     * Gets the value of the logoutResponse property.
     *
     * @return
     *     possible object is
     *     {@link LogoutResponse }
     *
     */
    public LogoutResponse getLogoutResponse() {
        return logoutResponse;
    }

    /**
     * Sets the value of the logoutResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link LogoutResponse }
     *
     */
    public void setLogoutResponse(LogoutResponse value) {
        this.logoutResponse = value;
    }

    /**
     * Gets the value of the loyaltyResponse property.
     *
     * @return
     *     possible object is
     *     {@link LoyaltyResponse }
     *
     */
    public LoyaltyResponse getLoyaltyResponse() {
        return loyaltyResponse;
    }

    /**
     * Sets the value of the loyaltyResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link LoyaltyResponse }
     *
     */
    public void setLoyaltyResponse(LoyaltyResponse value) {
        this.loyaltyResponse = value;
    }

    /**
     * Gets the value of the paymentResponse property.
     *
     * @return
     *     possible object is
     *     {@link PaymentResponse }
     *
     */
    public PaymentResponse getPaymentResponse() {
        return paymentResponse;
    }

    /**
     * Sets the value of the paymentResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link PaymentResponse }
     *
     */
    public void setPaymentResponse(PaymentResponse value) {
        this.paymentResponse = value;
    }

    /**
     * Gets the value of the pinResponse property.
     *
     * @return
     *     possible object is
     *     {@link PINResponse }
     *
     */
    public PINResponse getPINResponse() {
        return pinResponse;
    }

    /**
     * Sets the value of the pinResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link PINResponse }
     *
     */
    public void setPINResponse(PINResponse value) {
        this.pinResponse = value;
    }

    /**
     * Gets the value of the printResponse property.
     *
     * @return
     *     possible object is
     *     {@link PrintResponse }
     *
     */
    public PrintResponse getPrintResponse() {
        return printResponse;
    }

    /**
     * Sets the value of the printResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link PrintResponse }
     *
     */
    public void setPrintResponse(PrintResponse value) {
        this.printResponse = value;
    }

    /**
     * Gets the value of the cardReaderInitResponse property.
     *
     * @return
     *     possible object is
     *     {@link CardReaderInitResponse }
     *
     */
    public CardReaderInitResponse getCardReaderInitResponse() {
        return cardReaderInitResponse;
    }

    /**
     * Sets the value of the cardReaderInitResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link CardReaderInitResponse }
     *
     */
    public void setCardReaderInitResponse(CardReaderInitResponse value) {
        this.cardReaderInitResponse = value;
    }

    /**
     * Gets the value of the cardReaderAPDUResponse property.
     *
     * @return
     *     possible object is
     *     {@link CardReaderAPDUResponse }
     *
     */
    public CardReaderAPDUResponse getCardReaderAPDUResponse() {
        return cardReaderAPDUResponse;
    }

    /**
     * Sets the value of the cardReaderAPDUResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link CardReaderAPDUResponse }
     *
     */
    public void setCardReaderAPDUResponse(CardReaderAPDUResponse value) {
        this.cardReaderAPDUResponse = value;
    }

    /**
     * Gets the value of the cardReaderPowerOffResponse property.
     *
     * @return
     *     possible object is
     *     {@link CardReaderPowerOffResponse }
     *
     */
    public CardReaderPowerOffResponse getCardReaderPowerOffResponse() {
        return cardReaderPowerOffResponse;
    }

    /**
     * Sets the value of the cardReaderPowerOffResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link CardReaderPowerOffResponse }
     *
     */
    public void setCardReaderPowerOffResponse(CardReaderPowerOffResponse value) {
        this.cardReaderPowerOffResponse = value;
    }

    /**
     * Gets the value of the reconciliationResponse property.
     *
     * @return
     *     possible object is
     *     {@link ReconciliationResponse }
     *
     */
    public ReconciliationResponse getReconciliationResponse() {
        return reconciliationResponse;
    }

    /**
     * Sets the value of the reconciliationResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link ReconciliationResponse }
     *
     */
    public void setReconciliationResponse(ReconciliationResponse value) {
        this.reconciliationResponse = value;
    }

    /**
     * Gets the value of the reversalResponse property.
     *
     * @return
     *     possible object is
     *     {@link ReversalResponse }
     *
     */
    public ReversalResponse getReversalResponse() {
        return reversalResponse;
    }

    /**
     * Sets the value of the reversalResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link ReversalResponse }
     *
     */
    public void setReversalResponse(ReversalResponse value) {
        this.reversalResponse = value;
    }

    /**
     * Gets the value of the soundResponse property.
     *
     * @return
     *     possible object is
     *     {@link SoundResponse }
     *
     */
    public SoundResponse getSoundResponse() {
        return soundResponse;
    }

    /**
     * Sets the value of the soundResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link SoundResponse }
     *
     */
    public void setSoundResponse(SoundResponse value) {
        this.soundResponse = value;
    }

    /**
     * Gets the value of the storedValueResponse property.
     *
     * @return
     *     possible object is
     *     {@link StoredValueResponse }
     *
     */
    public StoredValueResponse getStoredValueResponse() {
        return storedValueResponse;
    }

    /**
     * Sets the value of the storedValueResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link StoredValueResponse }
     *
     */
    public void setStoredValueResponse(StoredValueResponse value) {
        this.storedValueResponse = value;
    }

    /**
     * Gets the value of the transactionStatusResponse property.
     *
     * @return
     *     possible object is
     *     {@link TransactionStatusResponse }
     *
     */
    public TransactionStatusResponse getTransactionStatusResponse() {
        return transactionStatusResponse;
    }

    /**
     * Sets the value of the transactionStatusResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link TransactionStatusResponse }
     *
     */
    public void setTransactionStatusResponse(TransactionStatusResponse value) {
        this.transactionStatusResponse = value;
    }

    /**
     * Gets the value of the transmitResponse property.
     *
     * @return
     *     possible object is
     *     {@link TransmitResponse }
     *
     */
    public TransmitResponse getTransmitResponse() {
        return transmitResponse;
    }

    /**
     * Sets the value of the transmitResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link TransmitResponse }
     *
     */
    public void setTransmitResponse(TransmitResponse value) {
        this.transmitResponse = value;
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
