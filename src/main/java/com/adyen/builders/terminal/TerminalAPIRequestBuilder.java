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

package com.adyen.builders.terminal;

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
import com.adyen.model.nexo.PINRequest;
import com.adyen.model.nexo.PaymentRequest;
import com.adyen.model.nexo.PrintRequest;
import com.adyen.model.nexo.ReconciliationRequest;
import com.adyen.model.nexo.ReversalRequest;
import com.adyen.model.nexo.SoundRequest;
import com.adyen.model.nexo.StoredValueRequest;
import com.adyen.model.nexo.TransactionStatusRequest;
import com.adyen.model.nexo.TransmitRequest;
import com.adyen.model.terminal.TerminalAPIRequest;

public final class TerminalAPIRequestBuilder {


    private final MessageBuilder messageBuilder;

    public TerminalAPIRequestBuilder(String saleId, String serviceId, String poiId) {
        messageBuilder = new MessageBuilder(saleId, serviceId, poiId);
    }

    public TerminalAPIRequestBuilder withAbortRequest(AbortRequest abortRequest) {
        messageBuilder.withAbortRequest(abortRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withBalanceInquiryRequest(BalanceInquiryRequest balanceInquiryRequest) {
        messageBuilder.withBalanceInquiryRequest(balanceInquiryRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withBatchRequest(BatchRequest batchRequest) {
        messageBuilder.withBatchRequest(batchRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withCardAcquisitionRequest(CardAcquisitionRequest cardAcquisitionRequest) {
        messageBuilder.withCardAcquisitionRequest(cardAcquisitionRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withAdminRequest(AdminRequest adminRequest) {
        messageBuilder.withAdminRequest(adminRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withDiagnosisRequest(DiagnosisRequest diagnosisRequest) {
        messageBuilder.withDiagnosisRequest(diagnosisRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withDisplayRequest(DisplayRequest displayRequest) {
        messageBuilder.withDisplayRequest(displayRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withEnableServiceRequest(EnableServiceRequest enableServiceRequest) {
        messageBuilder.withEnableServiceRequest(enableServiceRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withEventNotification(EventNotification eventNotification) {
        messageBuilder.withEventNotification(eventNotification);
        return this;
    }

    public TerminalAPIRequestBuilder withGetTotalsRequest(GetTotalsRequest getTotalsRequest) {
        messageBuilder.withGetTotalsRequest(getTotalsRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withInputRequest(InputRequest inputRequest) {
        messageBuilder.withInputRequest(inputRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withInputUpdate(InputUpdate inputUpdate) {
        messageBuilder.withInputUpdate(inputUpdate);
        return this;
    }

    public TerminalAPIRequestBuilder withLoginRequest(LoginRequest loginRequest) {
        messageBuilder.withLoginRequest(loginRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withLogoutRequest(LogoutRequest logoutRequest) {
        messageBuilder.withLogoutRequest(logoutRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withLoyaltyRequest(LoyaltyRequest loyaltyRequest) {
        messageBuilder.withLoyaltyRequest(loyaltyRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withPaymentRequest(PaymentRequest paymentRequest) {
        messageBuilder.withPaymentRequest(paymentRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withPINRequest(PINRequest pinRequest) {
        messageBuilder.withPINRequest(pinRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withPrintRequest(PrintRequest printRequest) {
        messageBuilder.withPrintRequest(printRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withCardReaderInitRequest(CardReaderInitRequest cardReaderInitRequest) {
        messageBuilder.withCardReaderInitRequest(cardReaderInitRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withCardReaderAPDURequest(CardReaderAPDURequest cardReaderAPDURequest) {
        messageBuilder.withCardReaderAPDURequest(cardReaderAPDURequest);
        return this;
    }

    public TerminalAPIRequestBuilder withCardReaderPowerOffRequest(CardReaderPowerOffRequest cardReaderPowerOffRequest) {
        messageBuilder.withCardReaderPowerOffRequest(cardReaderPowerOffRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withReconciliationRequest(ReconciliationRequest reconciliationRequest) {
        messageBuilder.withReconciliationRequest(reconciliationRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withReversalRequest(ReversalRequest reversalRequest) {
        messageBuilder.withReversalRequest(reversalRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withSoundRequest(SoundRequest soundRequest) {
        messageBuilder.withSoundRequest(soundRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withStoredValueRequest(StoredValueRequest storedValueRequest) {
        messageBuilder.withStoredValueRequest(storedValueRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withTransactionStatusRequest(TransactionStatusRequest transactionStatusRequest) {
        messageBuilder.withTransactionStatusRequest(transactionStatusRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withTransmitRequest(TransmitRequest transmitRequest) {
        messageBuilder.withTransmitRequest(transmitRequest);
        return this;
    }

    public TerminalAPIRequestBuilder withSecurityTrailer(ContentInformation securityTrailer) {
        messageBuilder.withSecurityTrailer(securityTrailer);
        return this;
    }

    public TerminalAPIRequest build() {
        return messageBuilder.build();
    }

}
