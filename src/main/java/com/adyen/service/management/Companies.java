package com.adyen.service.management;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.management.Company;
import com.adyen.model.management.CreateCompanyWebhookRequest;
import com.adyen.model.management.GenerateHmacKeyResponse;
import com.adyen.model.management.ListCompanyResponse;
import com.adyen.model.management.ListMerchantResponse;
import com.adyen.model.management.ListWebhooksResponse;
import com.adyen.model.management.Options;
import com.adyen.model.management.TestWebhookRequest;
import com.adyen.model.management.TestWebhookResponse;
import com.adyen.model.management.UpdateCompanyWebhookRequest;
import com.adyen.model.management.Webhook;
import com.adyen.service.Resource;
import com.adyen.service.exception.ApiException;
import com.adyen.util.Util;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Companies extends Service {
    private final Resource list;
    private final Resource retrieveCompany;
    private final Resource listMerchants;
    private final Resource listWebhooks;
    private final Resource retrieveWebhook;
    private final Resource createWebhook;
    private final Resource updateWebhook;
    private final Resource deleteWebhook;
    private final Resource testWebhook;
    private final Resource generateWebhookHmac;

    public Companies(Client client) {
        super(client);
        String baseEndpoint = String.format("%s/%s", client.getConfig().getManagementEndpoint(), Client.MANAGEMENT_API_VERSION);
        this.list = new Resource(this, baseEndpoint +
                String.format("/companies?%s", Util.getPaginationFragment()), null);
        this.retrieveCompany = new Resource(this, baseEndpoint +
                "/companies/{companyId}", null);
        this.listMerchants = new Resource(this, baseEndpoint +
                String.format("/companies/{companyId}/merchants?%s", Util.getPaginationFragment()), null);
        this.listWebhooks = new Resource(this, baseEndpoint +
                String.format("/companies/{companyId}/webhooks?%s", Util.getPaginationFragment()), null);
        this.retrieveWebhook = new Resource(this, baseEndpoint +
                "/companies/{companyId}/webhooks/{webhookId}", null);
        this.createWebhook = new Resource(this, baseEndpoint +
                "/companies/{companyId}/webhooks", null);
        this.updateWebhook = new Resource(this, baseEndpoint +
                "/companies/{companyId}/webhooks/{webhookId}", null);
        this.deleteWebhook = new Resource(this, baseEndpoint +
                "/companies/{companyId}/webhooks/{webhookId}", null);
        this.testWebhook = new Resource(this, baseEndpoint +
                "/companies/{companyId}/webhooks/{webhookId}/test", null);
        this.generateWebhookHmac = new Resource(this, baseEndpoint +
                "/companies/{companyId}/webhooks/{webhookId}/generateHmac", null);
    }

    public ListCompanyResponse list(Options options) throws IOException, ApiException {
        if (options == null) {
            options = new Options();
        }
        String jsonResult = this.list.request(null, null, ApiConstants.HttpMethod.GET, options.getOptionsMap());
        return GSON.fromJson(jsonResult, new TypeToken<ListCompanyResponse>() {
        }.getType());
    }

    public Company retrieveCompany(String companyId) throws IOException, ApiException {
        Map<String, String> params = Collections.singletonMap(ApiConstants.ManagementAPI.COMPANY_ID, companyId);
        String jsonResult = retrieveCompany.request(null, null, ApiConstants.HttpMethod.GET, params);
        return GSON.fromJson(jsonResult, new TypeToken<Company>() {
        }.getType());
    }

    public ListMerchantResponse listMerchants(String companyId, Options options) throws IOException, ApiException {
        if (options == null) {
            options = new Options();
        }

        Map<String, String> params = new HashMap<>(options.getOptionsMap());
        params.put(ApiConstants.ManagementAPI.COMPANY_ID, companyId);
        String jsonResult = listMerchants.request(null, null, ApiConstants.HttpMethod.GET, params);
        return GSON.fromJson(jsonResult, new TypeToken<ListMerchantResponse>() {
        }.getType());
    }

    public ListWebhooksResponse listWebhooks(String companyId, Options options) throws IOException, ApiException {
        if (options == null) {
            options = new Options();
        }

        Map<String, String> params = new HashMap<>(options.getOptionsMap());
        params.put(ApiConstants.ManagementAPI.COMPANY_ID, companyId);
        String jsonResult = listWebhooks.request(null, null, ApiConstants.HttpMethod.GET, params);
        return GSON.fromJson(jsonResult, new TypeToken<ListWebhooksResponse>() {
        }.getType());
    }

    public Webhook retrieveWebhook(String companyId, String webhookId) throws IOException, ApiException {
        Map<String, String> params = new HashMap<>();
        params.put(ApiConstants.ManagementAPI.COMPANY_ID, companyId);
        params.put(ApiConstants.ManagementAPI.WEBHOOK_ID, webhookId);
        String jsonResult = this.retrieveWebhook.request(null, null, ApiConstants.HttpMethod.GET, params);
        return GSON.fromJson(jsonResult, new TypeToken<Webhook>() {
        }.getType());
    }

    public Webhook createWebhook(String companyId, CreateCompanyWebhookRequest request) throws IOException, ApiException {
        Map<String, String> params = Collections.singletonMap(ApiConstants.ManagementAPI.COMPANY_ID, companyId);
        String jsonRequest = GSON.toJson(request);
        String jsonResult = this.createWebhook.request(jsonRequest, null, ApiConstants.HttpMethod.POST, params);
        return GSON.fromJson(jsonResult, new TypeToken<Webhook>() {
        }.getType());
    }

    public Webhook updateWebhook(String companyId, String webhookId, UpdateCompanyWebhookRequest request) throws IOException, ApiException {
        Map<String, String> params = new HashMap<>();
        params.put(ApiConstants.ManagementAPI.COMPANY_ID, companyId);
        params.put(ApiConstants.ManagementAPI.WEBHOOK_ID, webhookId);
        String jsonRequest = GSON.toJson(request);
        String jsonResult = this.updateWebhook.request(jsonRequest, null, ApiConstants.HttpMethod.PATCH, params);
        return GSON.fromJson(jsonResult, new TypeToken<Webhook>() {
        }.getType());
    }

    public void deleteWebhook(String companyId, String webhookId) throws IOException, ApiException {
        Map<String, String> params = new HashMap<>();
        params.put(ApiConstants.ManagementAPI.COMPANY_ID, companyId);
        params.put(ApiConstants.ManagementAPI.WEBHOOK_ID, webhookId);
        this.deleteWebhook.request(null, null, ApiConstants.HttpMethod.DELETE, params);
    }

    public TestWebhookResponse testWebhook(String companyId, String webhookId, TestWebhookRequest request) throws IOException, ApiException {
        Map<String, String> params = new HashMap<>();
        params.put(ApiConstants.ManagementAPI.COMPANY_ID, companyId);
        params.put(ApiConstants.ManagementAPI.WEBHOOK_ID, webhookId);
        String jsonRequest = GSON.toJson(request);
        String jsonResult = this.testWebhook.request(jsonRequest, null, ApiConstants.HttpMethod.POST, params);
        return GSON.fromJson(jsonResult, new TypeToken<TestWebhookResponse>() {
        }.getType());
    }

    public GenerateHmacKeyResponse generateWebhookHmac(String companyId, String webhookId) throws IOException, ApiException {
        Map<String, String> params = new HashMap<>();
        params.put(ApiConstants.ManagementAPI.COMPANY_ID, companyId);
        params.put(ApiConstants.ManagementAPI.WEBHOOK_ID, webhookId);
        String jsonResult = this.generateWebhookHmac.request(null, null, ApiConstants.HttpMethod.POST, params);
        return GSON.fromJson(jsonResult, new TypeToken<GenerateHmacKeyResponse>() {
        }.getType());
    }
}
