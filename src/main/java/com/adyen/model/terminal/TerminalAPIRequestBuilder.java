/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.terminal;

import com.adyen.model.nexo.AbortRequest;
import com.adyen.model.nexo.AdminRequest;
import com.adyen.model.nexo.BalanceInquiryRequest;
import com.adyen.model.nexo.BatchRequest;
import com.adyen.model.nexo.CardAcquisitionRequest;
import com.adyen.model.nexo.CardReaderAPDURequest;
import com.adyen.model.nexo.CardReaderInitRequest;
import com.adyen.model.nexo.CardReaderPowerOffRequest;
import com.adyen.model.nexo.ContentInformation;
import com.adyen.model.nexo.DiagnosisRequest;
import com.adyen.model.nexo.DisplayRequest;
import com.adyen.model.nexo.EnableServiceRequest;
import com.adyen.model.nexo.EventNotification;
import com.adyen.model.nexo.GetTotalsRequest;
import com.adyen.model.nexo.InputRequest;
import com.adyen.model.nexo.InputUpdate;
import com.adyen.model.nexo.LoginRequest;
import com.adyen.model.nexo.LogoutRequest;
import com.adyen.model.nexo.LoyaltyRequest;
import com.adyen.model.nexo.MessageCategoryType;
import com.adyen.model.nexo.MessageClassType;
import com.adyen.model.nexo.MessageHeader;
import com.adyen.model.nexo.MessageType;
import com.adyen.model.nexo.PINRequest;
import com.adyen.model.nexo.PaymentRequest;
import com.adyen.model.nexo.PrintRequest;
import com.adyen.model.nexo.ReconciliationRequest;
import com.adyen.model.nexo.ReversalRequest;
import com.adyen.model.nexo.SaleToPOIRequest;
import com.adyen.model.nexo.SoundRequest;
import com.adyen.model.nexo.StoredValueRequest;
import com.adyen.model.nexo.TransactionStatusRequest;
import com.adyen.model.nexo.TransmitRequest;

import static com.adyen.constants.ApiConstants.TerminalAPI.PROTOCOL_VERSION;

public final class TerminalAPIRequestBuilder {

    // MessageHeader
    private String saleId;
    private String serviceId;
    private String poiId;
    private MessageClassType messageClass;
    private MessageCategoryType messageCategory;

    // SaleToPOIRequest
    private AbortRequest abortRequest;
    private BalanceInquiryRequest balanceInquiryRequest;
    private BatchRequest batchRequest;
    private CardAcquisitionRequest cardAcquisitionRequest;
    private AdminRequest adminRequest;
    private DiagnosisRequest diagnosisRequest;
    private DisplayRequest displayRequest;
    private EnableServiceRequest enableServiceRequest;
    private EventNotification eventNotification;
    private GetTotalsRequest getTotalsRequest;
    private InputRequest inputRequest;
    private InputUpdate inputUpdate;
    private LoginRequest loginRequest;
    private LogoutRequest logoutRequest;
    private LoyaltyRequest loyaltyRequest;
    private PaymentRequest paymentRequest;
    private PINRequest pinRequest;
    private PrintRequest printRequest;
    private CardReaderInitRequest cardReaderInitRequest;
    private CardReaderAPDURequest cardReaderAPDURequest;
    private CardReaderPowerOffRequest cardReaderPowerOffRequest;
    private ReconciliationRequest reconciliationRequest;
    private ReversalRequest reversalRequest;
    private SoundRequest soundRequest;
    private StoredValueRequest storedValueRequest;
    private TransactionStatusRequest transactionStatusRequest;
    private TransmitRequest transmitRequest;
    private ContentInformation securityTrailer;

    public TerminalAPIRequestBuilder() {
    }

    public TerminalAPIRequestBuilder(String saleId, String serviceId, String poiId) {
        this.saleId = saleId;
        this.serviceId = serviceId;
        this.poiId = poiId;
    }

    public TerminalAPIRequestBuilder withSaleId(String saleId) {
        this.saleId = saleId;
        return this;
    }

    public TerminalAPIRequestBuilder withServiceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public TerminalAPIRequestBuilder withPoiId(String poiId) {
        this.poiId = poiId;
        return this;
    }

    public TerminalAPIRequestBuilder withAbortRequest(AbortRequest abortRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory =  MessageCategoryType.ABORT;
        this.abortRequest = abortRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withBalanceInquiryRequest(BalanceInquiryRequest balanceInquiryRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.BALANCE_INQUIRY;
        this.balanceInquiryRequest = balanceInquiryRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withBatchRequest(BatchRequest batchRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.BATCH;
        this.batchRequest = batchRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withCardAcquisitionRequest(CardAcquisitionRequest cardAcquisitionRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.CARD_ACQUISITION;
        this.cardAcquisitionRequest = cardAcquisitionRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withAdminRequest(AdminRequest adminRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.ADMIN;
        this.adminRequest = adminRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withDiagnosisRequest(DiagnosisRequest diagnosisRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.DIAGNOSIS;
        this.diagnosisRequest = diagnosisRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withDisplayRequest(DisplayRequest displayRequest) {
        this.messageClass = MessageClassType.DEVICE;
        this.messageCategory = MessageCategoryType.DISPLAY;
        this.displayRequest = displayRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withEnableServiceRequest(EnableServiceRequest enableServiceRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.ENABLE_SERVICE;
        this.enableServiceRequest = enableServiceRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withEventNotification(EventNotification eventNotification) {
        this.messageClass = MessageClassType.EVENT;
        this.messageCategory = MessageCategoryType.EVENT;
        this.eventNotification = eventNotification;
        return this;
    }

    public TerminalAPIRequestBuilder withGetTotalsRequest(GetTotalsRequest getTotalsRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.GET_TOTALS;
        this.getTotalsRequest = getTotalsRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withInputRequest(InputRequest inputRequest) {
        this.messageClass = MessageClassType.DEVICE;
        this.messageCategory = MessageCategoryType.INPUT;
        this.inputRequest = inputRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withInputUpdate(InputUpdate inputUpdate) {
        this.messageClass = MessageClassType.DEVICE;
        this.messageCategory = MessageCategoryType.INPUT_UPDATE;
        this.inputUpdate = inputUpdate;
        return this;
    }

    public TerminalAPIRequestBuilder withLoginRequest(LoginRequest loginRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.LOGIN;
        this.loginRequest = loginRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withLogoutRequest(LogoutRequest logoutRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.LOGOUT;
        this.logoutRequest = logoutRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withLoyaltyRequest(LoyaltyRequest loyaltyRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.LOYALTY;
        this.loyaltyRequest = loyaltyRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withPaymentRequest(PaymentRequest paymentRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.PAYMENT;
        this.paymentRequest = paymentRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withPinRequest(PINRequest pinRequest) {
        this.messageClass = MessageClassType.DEVICE;
        this.messageCategory = MessageCategoryType.PIN;
        this.pinRequest = pinRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withPrintRequest(PrintRequest printRequest) {
        this.messageClass = MessageClassType.DEVICE;
        this.messageCategory = MessageCategoryType.PRINT;
        this.printRequest = printRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withCardReaderInitRequest(CardReaderInitRequest cardReaderInitRequest) {
        this.messageClass = MessageClassType.DEVICE;
        this.messageCategory = MessageCategoryType.CARD_READER_INIT;
        this.cardReaderInitRequest = cardReaderInitRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withCardReaderAPDURequest(CardReaderAPDURequest cardReaderAPDURequest) {
        this.messageClass = MessageClassType.DEVICE;
        this.messageCategory = MessageCategoryType.CARD_READER_APDU;
        this.cardReaderAPDURequest = cardReaderAPDURequest;
        return this;
    }

    public TerminalAPIRequestBuilder withCardReaderPowerOffRequest(CardReaderPowerOffRequest cardReaderPowerOffRequest) {
        this.messageClass = MessageClassType.DEVICE;
        this.messageCategory = MessageCategoryType.CARD_READER_POWER_OFF;
        this.cardReaderPowerOffRequest = cardReaderPowerOffRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withReconciliationRequest(ReconciliationRequest reconciliationRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.RECONCILIATION;
        this.reconciliationRequest = reconciliationRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withReversalRequest(ReversalRequest reversalRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.REVERSAL;
        this.reversalRequest = reversalRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withSoundRequest(SoundRequest soundRequest) {
        this.messageClass = MessageClassType.DEVICE;
        this.messageCategory = MessageCategoryType.SOUND;
        this.soundRequest = soundRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withStoredValueRequest(StoredValueRequest storedValueRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.STORED_VALUE;
        this.storedValueRequest = storedValueRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withTransactionStatusRequest(TransactionStatusRequest transactionStatusRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.TRANSACTION_STATUS;
        this.transactionStatusRequest = transactionStatusRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withTransmitRequest(TransmitRequest transmitRequest) {
        this.messageClass = MessageClassType.DEVICE;
        this.messageCategory = MessageCategoryType.TRANSMIT;
        this.transmitRequest = transmitRequest;
        return this;
    }

    public TerminalAPIRequestBuilder withSecurityTrailer(ContentInformation securityTrailer) {
        this.securityTrailer = securityTrailer;
        return this;
    }

    public TerminalAPIRequest build() {
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setProtocolVersion(PROTOCOL_VERSION);
        messageHeader.setMessageType(MessageType.REQUEST);
        messageHeader.setMessageClass(messageClass);
        messageHeader.setMessageCategory(messageCategory);
        messageHeader.setSaleID(saleId);
        messageHeader.setServiceID(serviceId);
        messageHeader.setPOIID(poiId);

        SaleToPOIRequest saleToPOIRequest = new SaleToPOIRequest();
        saleToPOIRequest.setMessageHeader(messageHeader);
        saleToPOIRequest.setAbortRequest(abortRequest);
        saleToPOIRequest.setBalanceInquiryRequest(balanceInquiryRequest);
        saleToPOIRequest.setBatchRequest(batchRequest);
        saleToPOIRequest.setCardAcquisitionRequest(cardAcquisitionRequest);
        saleToPOIRequest.setAdminRequest(adminRequest);
        saleToPOIRequest.setDiagnosisRequest(diagnosisRequest);
        saleToPOIRequest.setDisplayRequest(displayRequest);
        saleToPOIRequest.setEnableServiceRequest(enableServiceRequest);
        saleToPOIRequest.setEventNotification(eventNotification);
        saleToPOIRequest.setGetTotalsRequest(getTotalsRequest);
        saleToPOIRequest.setInputRequest(inputRequest);
        saleToPOIRequest.setInputUpdate(inputUpdate);
        saleToPOIRequest.setLoginRequest(loginRequest);
        saleToPOIRequest.setLogoutRequest(logoutRequest);
        saleToPOIRequest.setLoyaltyRequest(loyaltyRequest);
        saleToPOIRequest.setPaymentRequest(paymentRequest);
        saleToPOIRequest.setPINRequest(pinRequest);
        saleToPOIRequest.setPrintRequest(printRequest);
        saleToPOIRequest.setCardReaderInitRequest(cardReaderInitRequest);
        saleToPOIRequest.setCardReaderAPDURequest(cardReaderAPDURequest);
        saleToPOIRequest.setCardReaderPowerOffRequest(cardReaderPowerOffRequest);
        saleToPOIRequest.setReconciliationRequest(reconciliationRequest);
        saleToPOIRequest.setReversalRequest(reversalRequest);
        saleToPOIRequest.setSoundRequest(soundRequest);
        saleToPOIRequest.setStoredValueRequest(storedValueRequest);
        saleToPOIRequest.setTransactionStatusRequest(transactionStatusRequest);
        saleToPOIRequest.setTransmitRequest(transmitRequest);
        saleToPOIRequest.setSecurityTrailer(securityTrailer);

        TerminalAPIRequest terminalAPIRequest = new TerminalAPIRequest();
        terminalAPIRequest.setSaleToPOIRequest(saleToPOIRequest);

        return terminalAPIRequest;
    }
}
