package com.adyen.notification;

import com.adyen.model.acswebhooks.AuthenticationNotificationRequest;
import com.adyen.model.acswebhooks.RelayedAuthenticationRequest;
import com.adyen.model.configurationwebhooks.AccountHolderNotificationRequest;
import com.adyen.model.configurationwebhooks.BalanceAccountNotificationRequest;
import com.adyen.model.configurationwebhooks.CardOrderNotificationRequest;
import com.adyen.model.configurationwebhooks.PaymentNotificationRequest;
import com.adyen.model.configurationwebhooks.SweepConfigurationNotificationRequest;
import com.adyen.model.negativebalancewarningwebhooks.NegativeBalanceCompensationWarningNotificationRequest;
import com.adyen.model.reportwebhooks.ReportNotificationRequest;
import com.adyen.model.transferwebhooks.JSON;
import com.adyen.model.transferwebhooks.TransferNotificationRequest;
import com.adyen.model.transactionwebhooks.TransactionNotificationRequestV4;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * DEPRECATED
 *
 * Centralised handler for de-serialising all (Banking) webhook payloads.
 *
 * @deprecated Each webhook provides its own handler, for example use AcsWebhooksHandler to process AcsWebhooks events
 * Use the specific WebhookHandler implementation: AcsWebhooks, ReportWebhooksHandler, ConfigurationWebhooks,
 * TransferWebhooks, TransactionWebhooks, etc..
 */
@Deprecated (since = "v37.0.0", forRemoval = true)
public class BankingWebhookHandler {

    private static final Logger LOG = Logger.getLogger(BankingWebhookHandler.class.getName());

    private final String payload;

    @Deprecated (since = "v37.0.0", forRemoval = true)
    public BankingWebhookHandler(String payload) {
        this.payload = payload;
    }

    @Deprecated (since = "v37.0.0", forRemoval = true) // use AcsWebhooksHandler instead
    public Optional<AuthenticationNotificationRequest> getAuthenticationNotificationRequest() {
        return getOptionalField(AuthenticationNotificationRequest.class);
    }
    @Deprecated (since = "v37.0.0", forRemoval = true) // use AcsWebhooksHandler instead
    public Optional<RelayedAuthenticationRequest> getRelayedAuthenticationRequest() {
        return getOptionalField(RelayedAuthenticationRequest.class);
    }
    @Deprecated (since = "v37.0.0", forRemoval = true) // use ConfigurationWebhooksHandler instead
    public Optional<AccountHolderNotificationRequest> getAccountHolderNotificationRequest() {
        return getOptionalField(AccountHolderNotificationRequest.class);
    }

    @Deprecated (since = "v37.0.0", forRemoval = true) // use ConfigurationWebhooksHandler instead
    public Optional<BalanceAccountNotificationRequest> getBalanceAccountNotificationRequest() {
        return getOptionalField(BalanceAccountNotificationRequest.class);
    }

    @Deprecated (since = "v37.0.0", forRemoval = true) // use ConfigurationWebhooksHandler instead
    public Optional<CardOrderNotificationRequest> getCardOrderNotificationRequest() {
        return getOptionalField(CardOrderNotificationRequest.class);
    }

    @Deprecated (since = "v37.0.0", forRemoval = true) // use ConfigurationWebhooksHandler instead
    public Optional<PaymentNotificationRequest> getPaymentNotificationRequest() {
        return getOptionalField(PaymentNotificationRequest.class);
    }

    @Deprecated (since = "v37.0.0", forRemoval = true) // use ConfigurationWebhooksHandler instead
    public Optional<SweepConfigurationNotificationRequest> getSweepConfigurationNotificationRequest() {
        return getOptionalField(SweepConfigurationNotificationRequest.class);
    }

    @Deprecated (since = "v37.0.0", forRemoval = true) // use ReportWebhooksHandler instead
    public Optional<ReportNotificationRequest> getReportNotificationRequest() {
        return getOptionalField(ReportNotificationRequest.class);
    }

    @Deprecated (since = "v37.0.0", forRemoval = true) // use TransferWebhooksHandler instead
    public Optional<TransferNotificationRequest> getTransferNotificationRequest() {
        return getOptionalField(TransferNotificationRequest.class);
    }

    @Deprecated (since = "v37.0.0", forRemoval = true) // use TransactionWebhooksHandler instead
    public Optional<TransactionNotificationRequestV4> getTransactionNotificationRequest() {
        return getOptionalField(TransactionNotificationRequestV4.class);
    }

    @Deprecated (since = "v37.0.0", forRemoval = true) // use NegativeBalanceWarningWebhooksHandler instead
    public Optional<NegativeBalanceCompensationWarningNotificationRequest> getNegativeBalanceCompensationWarningNotificationRequest() {
        return getOptionalField(NegativeBalanceCompensationWarningNotificationRequest.class);
    }

    private <T> Optional<T> getOptionalField(Class<T> clazz) {
        try {
            T val = JSON.getMapper().readValue(payload, clazz);
            return Optional.ofNullable(val);
        } catch (Exception e) {
            // an error has occurred during deserialization (object not found, deserialization error)
            LOG.warning("Object not found or unexpected error trying to access:  " + clazz.getName());
            LOG.warning("Deserialization error: " + e.getMessage());
            return Optional.empty();
        }
    }
}
