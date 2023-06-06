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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankingWebhookHandler {
    private static final Gson GSON = new Gson();
    private final Gson bankingGson;

    public BankingWebhookHandler() {

        GsonBuilder gsonBuilder = new GsonBuilder();
        this.bankingGson = gsonBuilder.create();
    }

    public List<Type> handleBankingWebhooks(String json) {

        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        JsonElement jsonType = jsonObject.get("type");
        String type = jsonType.getAsString();

        List<Type> objectList = new ArrayList<Type>();
        // Configuration Notification Webhooks
        if (Arrays.asList(AccountHolderNotificationRequest.TypeEnum.values()).toString().contains(type)) {
            objectList.add(AccountHolderNotificationRequest.class);
        }
        if (Arrays.asList(BalanceAccountNotificationRequest.TypeEnum.values()).toString().contains(type)) {
            objectList.add(BalanceAccountNotificationRequest.class);
        }
        if (Arrays.asList(CardOrderNotificationRequest.TypeEnum.values()).toString().contains(type)) {
            objectList.add(CardOrderNotificationRequest.class);
        }
        if (Arrays.asList(PaymentNotificationRequest.TypeEnum.values()).toString().contains(type)) {
            objectList.add(PaymentNotificationRequest.class);
        }
        if (Arrays.asList(SweepConfigurationNotificationRequest.TypeEnum.values()).toString().contains(type)) {
            objectList.add(SweepConfigurationNotificationRequest.class);
        }
        // Report Notification Webhooks
        if (Arrays.asList(ReportNotificationRequest.TypeEnum.values()).toString().contains(type)) {
            objectList.add(ReportNotificationRequest.class);
        }
        // Transfer Notification Webhooks
        if (Arrays.asList(TransferNotificationRequest.TypeEnum.values()).toString().contains(type)) {
            objectList.add(TransferNotificationRequest.class);
        }

        // Check if the passed webhook is valid
        if (objectList.size() != 1) {
            throw new IllegalArgumentException("Passed webhook json not valid");
        }
        return objectList;
    }

    public AccountHolderNotificationRequest getAccountHolderNotificationRequest(String json) {
        List<Type> typeList = handleBankingWebhooks(json);
        return bankingGson.fromJson(json, typeList.get(0));
    }

    public BalanceAccountNotificationRequest getBalanceAccountNotificationRequest(String json) {
        List<Type> typeList = handleBankingWebhooks(json);
        return bankingGson.fromJson(json, typeList.get(0));
    }

    public CardOrderNotificationRequest getCardOrderNotificationRequest(String json) {
        List<Type> typeList = handleBankingWebhooks(json);
        return bankingGson.fromJson(json, typeList.get(0));
    }

    public PaymentNotificationRequest getPaymentNotificationRequest(String json) {
        List<Type> typeList = handleBankingWebhooks(json);
        return bankingGson.fromJson(json, typeList.get(0));
    }

    public SweepConfigurationNotificationRequest getSweepConfigurationNotificationRequest(String json) {
        List<Type> typeList = handleBankingWebhooks(json);
        return bankingGson.fromJson(json, typeList.get(0));
    }

    public ReportNotificationRequest getReportNotificationRequest(String json) {
        List<Type> typeList = handleBankingWebhooks(json);
        return bankingGson.fromJson(json, typeList.get(0));
    }

    public TransferNotificationRequest getTransferNotificationRequest(String json) {
        List<Type> typeList = handleBankingWebhooks(json);
        return bankingGson.fromJson(json, typeList.get(0));
    }
}
