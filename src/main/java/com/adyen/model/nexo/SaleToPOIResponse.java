
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
 *           &lt;element name="BalanceInquiryResponse" type="{}BalanceInquiryResponseType"/>
 *           &lt;element name="BatchResponse" type="{}BatchResponseType"/>
 *           &lt;element name="CardAcquisitionResponse" type="{}CardAcquisitionResponseType"/>
 *           &lt;element name="AdminResponse" type="{}AdminResponseType"/>
 *           &lt;element name="DiagnosisResponse" type="{}DiagnosisResponseType"/>
 *           &lt;element name="DisplayResponse" type="{}DisplayResponseType"/>
 *           &lt;element name="EnableServiceResponse" type="{}EnableServiceResponseType"/>
 *           &lt;element name="GetTotalsResponse" type="{}GetTotalsResponseType"/>
 *           &lt;element name="InputResponse" type="{}InputResponseType"/>
 *           &lt;element name="LoginResponse" type="{}LoginResponseType"/>
 *           &lt;element name="LogoutResponse" type="{}LogoutResponseType"/>
 *           &lt;element name="LoyaltyResponse" type="{}LoyaltyResponseType"/>
 *           &lt;element name="PaymentResponse" type="{}PaymentResponseType"/>
 *           &lt;element name="PINResponse" type="{}PINResponseType"/>
 *           &lt;element name="PrintResponse" type="{}PrintResponseType"/>
 *           &lt;element name="CardReaderInitResponse" type="{}CardReaderInitResponseType"/>
 *           &lt;element name="CardReaderAPDUResponse" type="{}CardReaderAPDUResponseType"/>
 *           &lt;element name="CardReaderPowerOffResponse" type="{}CardReaderPowerOffResponseType"/>
 *           &lt;element name="ReconciliationResponse" type="{}ReconciliationResponseType"/>
 *           &lt;element name="ReversalResponse" type="{}ReversalResponseType"/>
 *           &lt;element name="SoundResponse" type="{}SoundResponseType"/>
 *           &lt;element name="StoredValueResponse" type="{}StoredValueResponseType"/>
 *           &lt;element name="TransactionStatusResponse" type="{}TransactionStatusResponseType"/>
 *           &lt;element name="TransmitResponse" type="{}TransmitResponseType"/>
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
    protected MessageHeaderType messageHeader;
    @XmlElement(name = "BalanceInquiryResponse")
    protected BalanceInquiryResponseType balanceInquiryResponse;
    @XmlElement(name = "BatchResponse")
    protected BatchResponseType batchResponse;
    @XmlElement(name = "CardAcquisitionResponse")
    protected CardAcquisitionResponseType cardAcquisitionResponse;
    @XmlElement(name = "AdminResponse")
    protected AdminResponseType adminResponse;
    @XmlElement(name = "DiagnosisResponse")
    protected DiagnosisResponseType diagnosisResponse;
    @XmlElement(name = "DisplayResponse")
    protected DisplayResponseType displayResponse;
    @XmlElement(name = "EnableServiceResponse")
    protected EnableServiceResponseType enableServiceResponse;
    @XmlElement(name = "GetTotalsResponse")
    protected GetTotalsResponseType getTotalsResponse;
    @XmlElement(name = "InputResponse")
    protected InputResponseType inputResponse;
    @XmlElement(name = "LoginResponse")
    protected LoginResponseType loginResponse;
    @XmlElement(name = "LogoutResponse")
    protected LogoutResponseType logoutResponse;
    @XmlElement(name = "LoyaltyResponse")
    protected LoyaltyResponseType loyaltyResponse;
    @XmlElement(name = "PaymentResponse")
    protected PaymentResponseType paymentResponse;
    @XmlElement(name = "PINResponse")
    protected PINResponseType pinResponse;
    @XmlElement(name = "PrintResponse")
    protected PrintResponseType printResponse;
    @XmlElement(name = "CardReaderInitResponse")
    protected CardReaderInitResponseType cardReaderInitResponse;
    @XmlElement(name = "CardReaderAPDUResponse")
    protected CardReaderAPDUResponseType cardReaderAPDUResponse;
    @XmlElement(name = "CardReaderPowerOffResponse")
    protected CardReaderPowerOffResponseType cardReaderPowerOffResponse;
    @XmlElement(name = "ReconciliationResponse")
    protected ReconciliationResponseType reconciliationResponse;
    @XmlElement(name = "ReversalResponse")
    protected ReversalResponseType reversalResponse;
    @XmlElement(name = "SoundResponse")
    protected SoundResponseType soundResponse;
    @XmlElement(name = "StoredValueResponse")
    protected StoredValueResponseType storedValueResponse;
    @XmlElement(name = "TransactionStatusResponse")
    protected TransactionStatusResponseType transactionStatusResponse;
    @XmlElement(name = "TransmitResponse")
    protected TransmitResponseType transmitResponse;
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
     * Gets the value of the balanceInquiryResponse property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceInquiryResponseType }
     *     
     */
    public BalanceInquiryResponseType getBalanceInquiryResponse() {
        return balanceInquiryResponse;
    }

    /**
     * Sets the value of the balanceInquiryResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceInquiryResponseType }
     *     
     */
    public void setBalanceInquiryResponse(BalanceInquiryResponseType value) {
        this.balanceInquiryResponse = value;
    }

    /**
     * Gets the value of the batchResponse property.
     * 
     * @return
     *     possible object is
     *     {@link BatchResponseType }
     *     
     */
    public BatchResponseType getBatchResponse() {
        return batchResponse;
    }

    /**
     * Sets the value of the batchResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link BatchResponseType }
     *     
     */
    public void setBatchResponse(BatchResponseType value) {
        this.batchResponse = value;
    }

    /**
     * Gets the value of the cardAcquisitionResponse property.
     * 
     * @return
     *     possible object is
     *     {@link CardAcquisitionResponseType }
     *     
     */
    public CardAcquisitionResponseType getCardAcquisitionResponse() {
        return cardAcquisitionResponse;
    }

    /**
     * Sets the value of the cardAcquisitionResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardAcquisitionResponseType }
     *     
     */
    public void setCardAcquisitionResponse(CardAcquisitionResponseType value) {
        this.cardAcquisitionResponse = value;
    }

    /**
     * Gets the value of the adminResponse property.
     * 
     * @return
     *     possible object is
     *     {@link AdminResponseType }
     *     
     */
    public AdminResponseType getAdminResponse() {
        return adminResponse;
    }

    /**
     * Sets the value of the adminResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdminResponseType }
     *     
     */
    public void setAdminResponse(AdminResponseType value) {
        this.adminResponse = value;
    }

    /**
     * Gets the value of the diagnosisResponse property.
     * 
     * @return
     *     possible object is
     *     {@link DiagnosisResponseType }
     *     
     */
    public DiagnosisResponseType getDiagnosisResponse() {
        return diagnosisResponse;
    }

    /**
     * Sets the value of the diagnosisResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiagnosisResponseType }
     *     
     */
    public void setDiagnosisResponse(DiagnosisResponseType value) {
        this.diagnosisResponse = value;
    }

    /**
     * Gets the value of the displayResponse property.
     * 
     * @return
     *     possible object is
     *     {@link DisplayResponseType }
     *     
     */
    public DisplayResponseType getDisplayResponse() {
        return displayResponse;
    }

    /**
     * Sets the value of the displayResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayResponseType }
     *     
     */
    public void setDisplayResponse(DisplayResponseType value) {
        this.displayResponse = value;
    }

    /**
     * Gets the value of the enableServiceResponse property.
     * 
     * @return
     *     possible object is
     *     {@link EnableServiceResponseType }
     *     
     */
    public EnableServiceResponseType getEnableServiceResponse() {
        return enableServiceResponse;
    }

    /**
     * Sets the value of the enableServiceResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnableServiceResponseType }
     *     
     */
    public void setEnableServiceResponse(EnableServiceResponseType value) {
        this.enableServiceResponse = value;
    }

    /**
     * Gets the value of the getTotalsResponse property.
     * 
     * @return
     *     possible object is
     *     {@link GetTotalsResponseType }
     *     
     */
    public GetTotalsResponseType getGetTotalsResponse() {
        return getTotalsResponse;
    }

    /**
     * Sets the value of the getTotalsResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetTotalsResponseType }
     *     
     */
    public void setGetTotalsResponse(GetTotalsResponseType value) {
        this.getTotalsResponse = value;
    }

    /**
     * Gets the value of the inputResponse property.
     * 
     * @return
     *     possible object is
     *     {@link InputResponseType }
     *     
     */
    public InputResponseType getInputResponse() {
        return inputResponse;
    }

    /**
     * Sets the value of the inputResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link InputResponseType }
     *     
     */
    public void setInputResponse(InputResponseType value) {
        this.inputResponse = value;
    }

    /**
     * Gets the value of the loginResponse property.
     * 
     * @return
     *     possible object is
     *     {@link LoginResponseType }
     *     
     */
    public LoginResponseType getLoginResponse() {
        return loginResponse;
    }

    /**
     * Sets the value of the loginResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoginResponseType }
     *     
     */
    public void setLoginResponse(LoginResponseType value) {
        this.loginResponse = value;
    }

    /**
     * Gets the value of the logoutResponse property.
     * 
     * @return
     *     possible object is
     *     {@link LogoutResponseType }
     *     
     */
    public LogoutResponseType getLogoutResponse() {
        return logoutResponse;
    }

    /**
     * Sets the value of the logoutResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogoutResponseType }
     *     
     */
    public void setLogoutResponse(LogoutResponseType value) {
        this.logoutResponse = value;
    }

    /**
     * Gets the value of the loyaltyResponse property.
     * 
     * @return
     *     possible object is
     *     {@link LoyaltyResponseType }
     *     
     */
    public LoyaltyResponseType getLoyaltyResponse() {
        return loyaltyResponse;
    }

    /**
     * Sets the value of the loyaltyResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoyaltyResponseType }
     *     
     */
    public void setLoyaltyResponse(LoyaltyResponseType value) {
        this.loyaltyResponse = value;
    }

    /**
     * Gets the value of the paymentResponse property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentResponseType }
     *     
     */
    public PaymentResponseType getPaymentResponse() {
        return paymentResponse;
    }

    /**
     * Sets the value of the paymentResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentResponseType }
     *     
     */
    public void setPaymentResponse(PaymentResponseType value) {
        this.paymentResponse = value;
    }

    /**
     * Gets the value of the pinResponse property.
     * 
     * @return
     *     possible object is
     *     {@link PINResponseType }
     *     
     */
    public PINResponseType getPINResponse() {
        return pinResponse;
    }

    /**
     * Sets the value of the pinResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link PINResponseType }
     *     
     */
    public void setPINResponse(PINResponseType value) {
        this.pinResponse = value;
    }

    /**
     * Gets the value of the printResponse property.
     * 
     * @return
     *     possible object is
     *     {@link PrintResponseType }
     *     
     */
    public PrintResponseType getPrintResponse() {
        return printResponse;
    }

    /**
     * Sets the value of the printResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrintResponseType }
     *     
     */
    public void setPrintResponse(PrintResponseType value) {
        this.printResponse = value;
    }

    /**
     * Gets the value of the cardReaderInitResponse property.
     * 
     * @return
     *     possible object is
     *     {@link CardReaderInitResponseType }
     *     
     */
    public CardReaderInitResponseType getCardReaderInitResponse() {
        return cardReaderInitResponse;
    }

    /**
     * Sets the value of the cardReaderInitResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardReaderInitResponseType }
     *     
     */
    public void setCardReaderInitResponse(CardReaderInitResponseType value) {
        this.cardReaderInitResponse = value;
    }

    /**
     * Gets the value of the cardReaderAPDUResponse property.
     * 
     * @return
     *     possible object is
     *     {@link CardReaderAPDUResponseType }
     *     
     */
    public CardReaderAPDUResponseType getCardReaderAPDUResponse() {
        return cardReaderAPDUResponse;
    }

    /**
     * Sets the value of the cardReaderAPDUResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardReaderAPDUResponseType }
     *     
     */
    public void setCardReaderAPDUResponse(CardReaderAPDUResponseType value) {
        this.cardReaderAPDUResponse = value;
    }

    /**
     * Gets the value of the cardReaderPowerOffResponse property.
     * 
     * @return
     *     possible object is
     *     {@link CardReaderPowerOffResponseType }
     *     
     */
    public CardReaderPowerOffResponseType getCardReaderPowerOffResponse() {
        return cardReaderPowerOffResponse;
    }

    /**
     * Sets the value of the cardReaderPowerOffResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardReaderPowerOffResponseType }
     *     
     */
    public void setCardReaderPowerOffResponse(CardReaderPowerOffResponseType value) {
        this.cardReaderPowerOffResponse = value;
    }

    /**
     * Gets the value of the reconciliationResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ReconciliationResponseType }
     *     
     */
    public ReconciliationResponseType getReconciliationResponse() {
        return reconciliationResponse;
    }

    /**
     * Sets the value of the reconciliationResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReconciliationResponseType }
     *     
     */
    public void setReconciliationResponse(ReconciliationResponseType value) {
        this.reconciliationResponse = value;
    }

    /**
     * Gets the value of the reversalResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ReversalResponseType }
     *     
     */
    public ReversalResponseType getReversalResponse() {
        return reversalResponse;
    }

    /**
     * Sets the value of the reversalResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReversalResponseType }
     *     
     */
    public void setReversalResponse(ReversalResponseType value) {
        this.reversalResponse = value;
    }

    /**
     * Gets the value of the soundResponse property.
     * 
     * @return
     *     possible object is
     *     {@link SoundResponseType }
     *     
     */
    public SoundResponseType getSoundResponse() {
        return soundResponse;
    }

    /**
     * Sets the value of the soundResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoundResponseType }
     *     
     */
    public void setSoundResponse(SoundResponseType value) {
        this.soundResponse = value;
    }

    /**
     * Gets the value of the storedValueResponse property.
     * 
     * @return
     *     possible object is
     *     {@link StoredValueResponseType }
     *     
     */
    public StoredValueResponseType getStoredValueResponse() {
        return storedValueResponse;
    }

    /**
     * Sets the value of the storedValueResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link StoredValueResponseType }
     *     
     */
    public void setStoredValueResponse(StoredValueResponseType value) {
        this.storedValueResponse = value;
    }

    /**
     * Gets the value of the transactionStatusResponse property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionStatusResponseType }
     *     
     */
    public TransactionStatusResponseType getTransactionStatusResponse() {
        return transactionStatusResponse;
    }

    /**
     * Sets the value of the transactionStatusResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionStatusResponseType }
     *     
     */
    public void setTransactionStatusResponse(TransactionStatusResponseType value) {
        this.transactionStatusResponse = value;
    }

    /**
     * Gets the value of the transmitResponse property.
     * 
     * @return
     *     possible object is
     *     {@link TransmitResponseType }
     *     
     */
    public TransmitResponseType getTransmitResponse() {
        return transmitResponse;
    }

    /**
     * Sets the value of the transmitResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransmitResponseType }
     *     
     */
    public void setTransmitResponse(TransmitResponseType value) {
        this.transmitResponse = value;
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
