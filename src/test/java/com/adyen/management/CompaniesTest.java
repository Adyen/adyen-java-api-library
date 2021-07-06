package com.adyen.management;

import com.adyen.BaseTest;
import com.adyen.Client;
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
import com.adyen.service.exception.ApiException;
import com.adyen.service.management.Companies;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CompaniesTest extends BaseTest {
    @Test
    public void listCompaniesSuccess() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/management/companies/list-companies-response.json");
        Companies companies = new Companies(client);
        ListCompanyResponse response = companies.list(new Options(1, 10));
        assertEquals(1, response.getData().size());
        assertEquals("https://management-test.adyen.com/v1/companies?pageNumber=1&pageSize=10", response.getLinks().getFirst().getHref());
        assertEquals("https://management-test.adyen.com/v1/companies?pageNumber=1&pageSize=10", response.getLinks().getLast().getHref());
        assertEquals("FakeCompany", response.getData().get(0).getId());
        assertEquals("Active", response.getData().get(0).getStatus());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany", response.getData().get(0).getLinks().getSelf().getHref());
        assertEquals("default", response.getData().get(0).getDataCenters().get(0).getName());
    }

    @Test
    public void retrieveCompanyByIdSuccess() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/management/companies/retrieve-company-response.json");
        Companies companies = new Companies(client);
        Company company = companies.retrieveCompany("FakeCompany");
        assertEquals("FakeCompany", company.getId());
        assertEquals("Active", company.getStatus());
        assertEquals("default",  company.getDataCenters().get(0).getName());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany", company.getLinks().getSelf().getHref());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany/users", company.getLinks().getUsers().getHref());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany/webhooks", company.getLinks().getWebhooks().getHref());
    }

    @Test
    public void listCompanyMerchantsSuccess() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/management/companies/list-company-merchants-response.json");
        Companies companies = new Companies(client);
        ListMerchantResponse response = companies.listMerchants("FakeCompany", new Options());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany/merchants?pageNumber=1&pageSize=10",
                response.getLinks().getFirst().getHref());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany/merchants?pageNumber=2&pageSize=10",
                response.getLinks().getLast().getHref());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany/merchants?pageNumber=2&pageSize=10",
                response.getLinks().getNext().getHref());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany/merchants?pageNumber=1&pageSize=10",
                response.getLinks().getSelf().getHref());
        assertEquals(new Integer(19), response.getItemsTotal());
        assertEquals(new Integer(2), response.getPagesTotal());
        assertEquals("Invoice1Merchant", response.getData().get(0).getId());
        assertEquals("Active", response.getData().get(0).getStatus());
    }

    @Test
    public void listCompanyWebhooksSuccess() throws ApiException, IOException {
        Client client = createMockClientFromFile("mocks/management/companies/list-companies-webhooks-response.json");
        Companies companies = new Companies(client);
        ListWebhooksResponse response = companies.listWebhooks("FakeCompany", new Options());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany/webhooks?pageNumber=1&pageSize=30",
                response.getLinks().getFirst().getHref());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany/webhooks?pageNumber=1&pageSize=30",
                response.getLinks().getLast().getHref());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany/webhooks?pageNumber=1&pageSize=30",
                response.getLinks().getSelf().getHref());
        assertEquals(new Integer(11), response.getItemsTotal());
        assertEquals(new Integer(1), response.getPagesTotal());
        assertEquals("S2-504B3E24", response.getData().get(0).getId());
        assertEquals("standard", response.getData().get(0).getType());
        assertEquals("http://example-1.com", response.getData().get(0).getUrl());
        assertEquals("Standard Notification for FakeCompany - 1622123155874", response.getData().get(0).getDescription());
        assertEquals(Webhook.CommunicationFormatEnum.JSON, response.getData().get(0).getCommunicationFormat());
        assertEquals(Webhook.SslVersionEnum.TLSV1_2, response.getData().get(0).getSslVersion());
    }

    @Test
    public void retrieveCompanyWebhookSuccess() throws ApiException, IOException {
        Client client = createMockClientFromFile("mocks/management/companies/retrieve-webhook-response.json");
        Companies companies = new Companies(client);
        Webhook webhook = companies.retrieveWebhook("FakeCompany", "S2-504B3E24");
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany/webhooks/S2-504B3E24",
                webhook.getLinks().getSelf().getHref());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany",
                webhook.getLinks().getCompany().getHref());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany/webhooks/S2-504B3E24/generateHmac",
                webhook.getLinks().getGenerateHmac().getHref());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany/webhooks/S2-504B3E24/test",
                webhook.getLinks().getTestWebhook().getHref());
        assertEquals("S2-504B3E24", webhook.getId());
        assertEquals("standard", webhook.getType());
        assertEquals("http://example-1.com", webhook.getUrl());
        assertEquals(Webhook.SslVersionEnum.TLSV1_2, webhook.getSslVersion());
        assertEquals(Webhook.CommunicationFormatEnum.JSON, webhook.getCommunicationFormat());
    }

    @Test
    public void createCompanyWebhookSuccess() throws ApiException, IOException {
        Client client = createMockClientFromFile("mocks/management/companies/create-webhook-response.json");
        Companies companies = new Companies(client);
        Webhook webhook = companies.createWebhook("FakeCompany", new CreateCompanyWebhookRequest());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany/webhooks/S2-7125452F",
                webhook.getLinks().getSelf().getHref());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany",
                webhook.getLinks().getCompany().getHref());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany/webhooks/S2-7125452F/generateHmac",
                webhook.getLinks().getGenerateHmac().getHref());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany/webhooks/S2-7125452F/test",
                webhook.getLinks().getTestWebhook().getHref());
        assertEquals("S2-7125452F", webhook.getId());
        assertEquals("standard", webhook.getType());
        assertEquals("https://example.com", webhook.getUrl());
        assertEquals(Webhook.SslVersionEnum.TLSV1_2, webhook.getSslVersion());
        assertEquals(Webhook.CommunicationFormatEnum.JSON, webhook.getCommunicationFormat());
    }

    @Test
    public void updateCompanyWebhookSuccess() throws ApiException, IOException {
        Client client = createMockClientFromFile("mocks/management/companies/update-webhook-response.json");
        Companies companies = new Companies(client);
        Webhook webhook = companies.updateWebhook("FakeCompany", "S2-7125452F", new UpdateCompanyWebhookRequest());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany/webhooks/S2-7125452F",
                webhook.getLinks().getSelf().getHref());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany",
                webhook.getLinks().getCompany().getHref());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany/webhooks/S2-7125452F/generateHmac",
                webhook.getLinks().getGenerateHmac().getHref());
        assertEquals("https://management-test.adyen.com/v1/companies/FakeCompany/webhooks/S2-7125452F/test",
                webhook.getLinks().getTestWebhook().getHref());
        assertEquals("S2-7125452F", webhook.getId());
        assertEquals("standard", webhook.getType());
        assertEquals("http://example-update.com", webhook.getUrl());
        assertEquals(Webhook.SslVersionEnum.TLSV1_2, webhook.getSslVersion());
        assertEquals(Webhook.CommunicationFormatEnum.JSON, webhook.getCommunicationFormat());
    }

    @Test
    public void testCompanyWebhookSuccess() throws ApiException, IOException {
        Client client = createMockClientFromFile("mocks/management/companies/test-webhook-response.json");
        Companies companies = new Companies(client);
        TestWebhookResponse response = companies.testWebhook("FakeCompany", "S2-7125452F", new TestWebhookRequest());
        assertEquals("Invoice1Merchant", response.getData().get(0).getMerchantId());
        assertEquals("[accepted]", response.getData().get(0).getOutput());
        assertEquals("200", response.getData().get(0).getResponseCode());
        assertEquals("259 ms", response.getData().get(0).getResponseTime());
        assertEquals("success", response.getData().get(0).getStatus());
    }

    @Test
    public void testGenerateWebhookHmacSuccess() throws ApiException, IOException {
        Client client = createMockClientFromFile("mocks/management/companies/generate-hmac-response.json");
        Companies companies = new Companies(client);
        GenerateHmacKeyResponse response = companies.generateWebhookHmac("FakeCompany", "S2-A858DE45F56D9BC9");
        assertEquals("D33D971ECE0EE8127185621F0E0E6C934B7390CFA2E3A78E7565B9F1F87E1F70", response.getHmacKey());

    }



}
