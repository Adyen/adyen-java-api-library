package com.adyen.notification;

import com.adyen.model.acswebhooks.AuthenticationNotificationRequest;
import com.adyen.model.configurationwebhooks.AccountHolderNotificationRequest;
import com.adyen.model.configurationwebhooks.BalanceAccountNotificationRequest;
import com.adyen.model.configurationwebhooks.CardOrderNotificationRequest;
import com.adyen.model.configurationwebhooks.PaymentNotificationRequest;
import com.adyen.model.configurationwebhooks.SweepConfigurationNotificationRequest;
import com.adyen.model.reportwebhooks.ReportNotificationRequest;
import com.adyen.model.transferwebhooks.JSON;
import com.adyen.model.transferwebhooks.TransferNotificationRequest;
import com.adyen.model.transactionwebhooks.TransactionNotificationRequestV4;
import java.util.Optional;

public class BankingWebhookHandler {
    private final String payload;

    public BankingWebhookHandler(String payload) {
        this.payload = payload;
    }

    public Optional<AuthenticationNotificationRequest> getAuthenticationNotificationRequest() {
        return getOptionalField(AuthenticationNotificationRequest.class);
    }
    public Optional<AccountHolderNotificationRequest> getAccountHolderNotificationRequest() {
        return getOptionalField(AccountHolderNotificationRequest.class);
    }

    public Optional<BalanceAccountNotificationRequest> getBalanceAccountNotificationRequest() {
        return getOptionalField(BalanceAccountNotificationRequest.class);
    }

    public Optional<CardOrderNotificationRequest> getCardOrderNotificationRequest() {
        return getOptionalField(CardOrderNotificationRequest.class);
    }

    public Optional<PaymentNotificationRequest> getPaymentNotificationRequest() {
        return getOptionalField(PaymentNotificationRequest.class);
    }

    public Optional<SweepConfigurationNotificationRequest> getSweepConfigurationNotificationRequest() {
        return getOptionalField(SweepConfigurationNotificationRequest.class);
    }

    public Optional<ReportNotificationRequest> getReportNotificationRequest() {
        return getOptionalField(ReportNotificationRequest.class);
    }

    public Optional<TransferNotificationRequest> getTransferNotificationRequest() {
        return getOptionalField(TransferNotificationRequest.class);
    }

    public Optional<TransactionNotificationRequestV4> getTransactionNotificationRequest() {
        return getOptionalField(TransactionNotificationRequestV4.class);
    }

    private <T> Optional<T> getOptionalField(Class<T> clazz) {
        try {
            T val = JSON.getMapper().readValue(payload, clazz);
            return Optional.ofNullable(val);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
