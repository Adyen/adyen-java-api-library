package com.adyen;

import com.adyen.constants.ApiConstants;
import com.adyen.enums.Environment;
import com.adyen.httpclient.HTTPClientException;
import com.adyen.model.management.*;
import com.adyen.service.exception.ApiException;
import com.adyen.service.management.*;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class ManagementTest extends BaseTest {
    @Test
    public void listMerchantAccounts() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/management/list-merchants.json");
        AccountMerchantLevel service = new AccountMerchantLevel(client);

        ListMerchantResponse merchants = service.getMerchants(null);

        assertEquals(10, merchants.getData().size());
        assertEquals("Amsterdam", merchants.getData().get(0).getMerchantCity());
    }

    @Test
    public void listMerchantAccountsPaginated() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/management/list-merchants.json");
        client.setEnvironment(Environment.TEST, "junit");
        Map<String, String> queryParams = Collections.singletonMap("pageSize", "25");
        AccountMerchantLevel service = new AccountMerchantLevel(client);

        service.getMerchants(queryParams);

        verify(client.getHttpClient()).request(
                "https://management-test.adyen.com/v1/merchants",
                null,
                client.getConfig(),
                true,
                null,
                ApiConstants.HttpMethod.GET,
                queryParams
        );
    }

    @Test
    public void listCompanies() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/management/list-companies.json");
        AccountCompanyLevel service = new AccountCompanyLevel(client);

        ListCompanyResponse merchants = service.getCompanies(null);

        assertEquals(1, merchants.getData().size());
        assertEquals("YOUR_COMPANY_NAME", merchants.getData().get(0).getName());
    }

    @Test
    public void updateTerminalSettings() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/management/terminal-settings.json");
        TerminalSettingsTerminalLevel service = new TerminalSettingsTerminalLevel(client);
        TerminalSettings request = new TerminalSettings(); 
        request.setReceiptPrinting(new ReceiptPrinting().shopperApproved(true));
        
        TerminalSettings response = service.patchTerminalsTerminalIdTerminalSettings("123ABC", request);

        assertNotNull(response.getReceiptPrinting());
        assertNotNull(response.getReceiptPrinting().getShopperApproved());
        assertTrue(response.getReceiptPrinting().getShopperApproved());
        verify(client.getHttpClient()).request(
                "nullv1/terminals/123ABC/terminalSettings",
                "{\"receiptPrinting\":{\"shopperApproved\":true}}",
                client.getConfig(),
                true,
                null,
                ApiConstants.HttpMethod.PATCH,
                null
        );
    }
    
    @Test
    public void createStore() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/management/store.json");
        AccountStoreLevel service = new AccountStoreLevel(client);
        StoreCreationRequest request = new StoreCreationRequest();
        request.setDescription("City centre store");
        
        Store store = service.postMerchantsMerchantIdStores("YOUR_MERCHANT_ACCOUNT_ID", request);

        assertEquals("YOUR_STORE_ID", store.getId());
        verify(client.getHttpClient()).request(
                "nullv1/merchants/YOUR_MERCHANT_ACCOUNT_ID/stores",
                "{\"description\":\"City centre store\"}",
                client.getConfig(),
                true,
                null,
                ApiConstants.HttpMethod.POST,
                null
        );
    }
    
    @Test
    public void removeAllowedOrigin() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/management/store.json");
        MyApiCredential service = new MyApiCredential(client);

        service.deleteMeAllowedOriginsOriginId("DOEI");

        verify(client.getHttpClient()).request(
                "nullv1/me/allowedOrigins/DOEI",
                null,
                client.getConfig(),
                true,
                null,
                ApiConstants.HttpMethod.DELETE,
                null
        );
    }
    
    @Test
    @Ignore("Integration test")
    public void me() throws IOException, ApiException {
        Client client = new Client(System.getenv("API_KEY"), Environment.TEST);
        MyApiCredential service = new MyApiCredential(client);

        MeApiCredential me = service.getMe();
        
        assertTrue(me.getActive());
    }
}
