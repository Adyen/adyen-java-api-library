package com.adyen.builders.terminal;

import com.adyen.model.nexo.MessageCategoryType;
import com.adyen.model.nexo.MessageClassType;
import com.adyen.model.nexo.MessageHeader;
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
import com.adyen.model.terminal.TerminalAPIRequest;

import static com.adyen.constants.ApiConstants.TerminalAPI.PROTOCOL_VERSION;

public class MessageBuilder {

    // MessageHeader
    private final MessageHeader messageHeader;
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

    public MessageBuilder(String saleId, String serviceId, String poiId) {
        messageHeader = new MessageHeader();
        messageHeader.setProtocolVersion(PROTOCOL_VERSION);
        messageHeader.setMessageType(MessageType.REQUEST);
        messageHeader.setSaleID(saleId);
        messageHeader.setServiceID(serviceId);
        messageHeader.setPOIID(poiId);
    }

    public void withAbortRequest(AbortRequest abortRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.ABORT;
        this.abortRequest = abortRequest;
    }

    public void withBalanceInquiryRequest(BalanceInquiryRequest balanceInquiryRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.BALANCE_INQUIRY;
        this.balanceInquiryRequest = balanceInquiryRequest;
    }

    public void withBatchRequest(BatchRequest batchRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.BATCH;
        this.batchRequest = batchRequest;
    }

    public void withCardAcquisitionRequest(CardAcquisitionRequest cardAcquisitionRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.CARD_ACQUISITION;
        this.cardAcquisitionRequest = cardAcquisitionRequest;
    }

    public void withAdminRequest(AdminRequest adminRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.ADMIN;
        this.adminRequest = adminRequest;
    }

    public void withDiagnosisRequest(DiagnosisRequest diagnosisRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.DIAGNOSIS;
        this.diagnosisRequest = diagnosisRequest;

    }

    public void withDisplayRequest(DisplayRequest displayRequest) {
        this.messageClass = MessageClassType.DEVICE;
        this.messageCategory = MessageCategoryType.DISPLAY;
        this.displayRequest = displayRequest;

    }

    public void withEnableServiceRequest(EnableServiceRequest enableServiceRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.ENABLE_SERVICE;
        this.enableServiceRequest = enableServiceRequest;

    }

    public void withEventNotification(EventNotification eventNotification) {
        this.messageClass = MessageClassType.EVENT;
        this.messageCategory = MessageCategoryType.EVENT;
        this.eventNotification = eventNotification;

    }

    public void withGetTotalsRequest(GetTotalsRequest getTotalsRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.GET_TOTALS;
        this.getTotalsRequest = getTotalsRequest;

    }

    public void withInputRequest(InputRequest inputRequest) {
        this.messageClass = MessageClassType.DEVICE;
        this.messageCategory = MessageCategoryType.INPUT;
        this.inputRequest = inputRequest;

    }

    public void withInputUpdate(InputUpdate inputUpdate) {
        this.messageClass = MessageClassType.DEVICE;
        this.messageCategory = MessageCategoryType.INPUT_UPDATE;
        this.inputUpdate = inputUpdate;

    }

    public void withLoginRequest(LoginRequest loginRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.LOGIN;
        this.loginRequest = loginRequest;

    }

    public void withLogoutRequest(LogoutRequest logoutRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.LOGOUT;
        this.logoutRequest = logoutRequest;

    }

    public void withLoyaltyRequest(LoyaltyRequest loyaltyRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.LOYALTY;
        this.loyaltyRequest = loyaltyRequest;

    }

    public void withPaymentRequest(PaymentRequest paymentRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.PAYMENT;
        this.paymentRequest = paymentRequest;

    }

    public void withPINRequest(PINRequest pinRequest) {
        this.messageClass = MessageClassType.DEVICE;
        this.messageCategory = MessageCategoryType.PIN;
        this.pinRequest = pinRequest;
    }

    public void withPrintRequest(PrintRequest printRequest) {
        this.messageClass = MessageClassType.DEVICE;
        this.messageCategory = MessageCategoryType.PRINT;
        this.printRequest = printRequest;

    }

    public void withCardReaderInitRequest(CardReaderInitRequest cardReaderInitRequest) {
        this.messageClass = MessageClassType.DEVICE;
        this.messageCategory = MessageCategoryType.CARD_READER_INIT;
        this.cardReaderInitRequest = cardReaderInitRequest;

    }

    public void withCardReaderAPDURequest(CardReaderAPDURequest cardReaderAPDURequest) {
        this.messageClass = MessageClassType.DEVICE;
        this.messageCategory = MessageCategoryType.CARD_READER_APDU;
        this.cardReaderAPDURequest = cardReaderAPDURequest;

    }

    public void withCardReaderPowerOffRequest(CardReaderPowerOffRequest cardReaderPowerOffRequest) {
        this.messageClass = MessageClassType.DEVICE;
        this.messageCategory = MessageCategoryType.CARD_READER_POWER_OFF;
        this.cardReaderPowerOffRequest = cardReaderPowerOffRequest;

    }

    public void withReconciliationRequest(ReconciliationRequest reconciliationRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.RECONCILIATION;
        this.reconciliationRequest = reconciliationRequest;

    }

    public void withReversalRequest(ReversalRequest reversalRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.REVERSAL;
        this.reversalRequest = reversalRequest;

    }

    public void withSoundRequest(SoundRequest soundRequest) {
        this.messageClass = MessageClassType.DEVICE;
        this.messageCategory = MessageCategoryType.SOUND;
        this.soundRequest = soundRequest;

    }

    public void withStoredValueRequest(StoredValueRequest storedValueRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.STORED_VALUE;
        this.storedValueRequest = storedValueRequest;

    }

    public void withTransactionStatusRequest(TransactionStatusRequest transactionStatusRequest) {
        this.messageClass = MessageClassType.SERVICE;
        this.messageCategory = MessageCategoryType.TRANSACTION_STATUS;
        this.transactionStatusRequest = transactionStatusRequest;

    }

    public void withTransmitRequest(TransmitRequest transmitRequest) {
        this.messageClass = MessageClassType.DEVICE;
        this.messageCategory = MessageCategoryType.TRANSMIT;
        this.transmitRequest = transmitRequest;

    }

    public void withSecurityTrailer(ContentInformation securityTrailer) {
        this.securityTrailer = securityTrailer;

    }

    public TerminalAPIRequest build() {
        messageHeader.setMessageClass(messageClass);
        messageHeader.setMessageCategory(messageCategory);

        SaleToPOIRequest saleToPOIRequest = new SaleToPOIRequest();
        saleToPOIRequest.setMessageHeader(messageHeader);
        saleToPOIRequest.setSecurityTrailer(securityTrailer);

        if (messageCategory != null) {
            switch (messageCategory) {
                case PAYMENT:
                    saleToPOIRequest.setPaymentRequest(paymentRequest);
                    break;
                case TRANSACTION_STATUS:
                    saleToPOIRequest.setTransactionStatusRequest(transactionStatusRequest);
                    break;
                case ABORT:
                    saleToPOIRequest.setAbortRequest(abortRequest);
                    break;
                case REVERSAL:
                    saleToPOIRequest.setReversalRequest(reversalRequest);
                    break;
                case CARD_ACQUISITION:
                    saleToPOIRequest.setCardAcquisitionRequest(cardAcquisitionRequest);
                    break;
                case BALANCE_INQUIRY:
                    saleToPOIRequest.setBalanceInquiryRequest(balanceInquiryRequest);
                    break;
                case BATCH:
                    saleToPOIRequest.setBatchRequest(batchRequest);
                    break;
                case ADMIN:
                    saleToPOIRequest.setAdminRequest(adminRequest);
                    break;
                case DIAGNOSIS:
                    saleToPOIRequest.setDiagnosisRequest(diagnosisRequest);
                    break;
                case DISPLAY:
                    saleToPOIRequest.setDisplayRequest(displayRequest);
                    break;
                case EVENT:
                    saleToPOIRequest.setEventNotification(eventNotification);
                    break;
                case ENABLE_SERVICE:
                    saleToPOIRequest.setEnableServiceRequest(enableServiceRequest);
                    break;
                case GET_TOTALS:
                    saleToPOIRequest.setGetTotalsRequest(getTotalsRequest);
                    break;
                case INPUT:
                    saleToPOIRequest.setInputRequest(inputRequest);
                    break;
                case INPUT_UPDATE:
                    saleToPOIRequest.setInputUpdate(inputUpdate);
                    break;
                case LOGIN:
                    saleToPOIRequest.setLoginRequest(loginRequest);
                    break;
                case LOGOUT:
                    saleToPOIRequest.setLogoutRequest(logoutRequest);
                    break;
                case LOYALTY:
                    saleToPOIRequest.setLoyaltyRequest(loyaltyRequest);
                    break;
                case PIN:
                    saleToPOIRequest.setPINRequest(pinRequest);
                    break;
                case PRINT:
                    saleToPOIRequest.setPrintRequest(printRequest);
                    break;
                case CARD_READER_INIT:
                    saleToPOIRequest.setCardReaderInitRequest(cardReaderInitRequest);
                    break;
                case CARD_READER_APDU:
                    saleToPOIRequest.setCardReaderAPDURequest(cardReaderAPDURequest);
                    break;
                case CARD_READER_POWER_OFF:
                    saleToPOIRequest.setCardReaderPowerOffRequest(cardReaderPowerOffRequest);
                    break;
                case RECONCILIATION:
                    saleToPOIRequest.setReconciliationRequest(reconciliationRequest);
                    break;
                case SOUND:
                    saleToPOIRequest.setSoundRequest(soundRequest);
                    break;
                case STORED_VALUE:
                    saleToPOIRequest.setStoredValueRequest(storedValueRequest);
                    break;
                case TRANSMIT:
                    saleToPOIRequest.setTransmitRequest(transmitRequest);
                    break;
                default:
                    break;
            }
        }

        TerminalAPIRequest terminalAPIRequest = new TerminalAPIRequest();
        terminalAPIRequest.setSaleToPOIRequest(saleToPOIRequest);

        return terminalAPIRequest;
    }


}
