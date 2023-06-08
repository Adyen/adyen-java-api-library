package com.adyen.notification;

import com.adyen.model.configurationwebhooks.AccountHolderNotificationRequest;
import com.adyen.model.configurationwebhooks.BalanceAccountNotificationRequest;
import com.adyen.model.configurationwebhooks.CardOrderNotificationRequest;
import com.adyen.model.configurationwebhooks.PaymentNotificationRequest;
import com.adyen.model.configurationwebhooks.SweepConfigurationNotificationRequest;
import com.adyen.model.reportwebhooks.ReportNotificationRequest;
import com.adyen.model.transferwebhooks.TransferNotificationRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Optional;

public class BankingWebhookHandler {
    private static final Gson GSON = new Gson();
    private final Gson bankingGson;
    private String payload;

    public BankingWebhookHandler(String payload) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        this.bankingGson = gsonBuilder.create();
        this.payload = payload;
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

    private <T> Optional<T> getOptionalField(Class<T> clazz) {
        try {
            T val = bankingGson.fromJson(this.payload, clazz);
            return Optional.ofNullable(val);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
