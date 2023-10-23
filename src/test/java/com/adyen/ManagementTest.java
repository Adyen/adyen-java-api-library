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
        AccountMerchantLevelApi service = new AccountMerchantLevelApi(client);

        ListMerchantResponse merchants = service.listMerchantAccounts();

        assertEquals(10, merchants.getData().size());
        assertEquals("Amsterdam", merchants.getData().get(0).getMerchantCity());
    }

    @Test
    public void listMerchantAccountsPaginated() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/management/list-merchants.json");
        client.setEnvironment(Environment.TEST, "junit");
        Map<String, String> queryParams = Collections.singletonMap("pageSize", "25");
        AccountMerchantLevelApi service = new AccountMerchantLevelApi(client);

        service.listMerchantAccounts(null, 25, null);

        verify(client.getHttpClient()).request(
                "https://management-test.adyen.com/v3/merchants",
                null,
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.GET,
                queryParams
        );
    }

    @Test
    public void listCompanies() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/management/list-companies.json");
        AccountCompanyLevelApi service = new AccountCompanyLevelApi(client);

        ListCompanyResponse merchants = service.listCompanyAccounts();

        assertEquals(1, merchants.getData().size());
        assertEquals("YOUR_COMPANY_NAME", merchants.getData().get(0).getName());
    }

    @Test
    public void updateTerminalSettings() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/management/terminal-settings.json");
        TerminalSettingsTerminalLevelApi service = new TerminalSettingsTerminalLevelApi(client);
        TerminalSettings request = new TerminalSettings(); 
        request.setReceiptPrinting(new ReceiptPrinting().shopperApproved(true));
        
        TerminalSettings response = service.updateTerminalSettings("123ABC", request);

        assertNotNull(response.getReceiptPrinting());
        assertNotNull(response.getReceiptPrinting().getShopperApproved());
        assertTrue(response.getReceiptPrinting().getShopperApproved());
        verify(client.getHttpClient()).request(
                "https://management-test.adyen.com/v3/terminals/123ABC/terminalSettings",
                "{\"receiptPrinting\":{\"shopperApproved\":true}}",
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.PATCH,
                null
        );
    }
    
    @Test
    public void createStore() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/management/store.json");
        AccountStoreLevelApi service = new AccountStoreLevelApi(client);
        StoreCreationRequest request = new StoreCreationRequest();
        request.setDescription("City centre store");
        
        Store store = service.createStoreByMerchantId("YOUR_MERCHANT_ACCOUNT_ID", request);

        assertEquals("YOUR_STORE_ID", store.getId());
        verify(client.getHttpClient()).request(
                "https://management-test.adyen.com/v3/merchants/YOUR_MERCHANT_ACCOUNT_ID/stores",
                "{\"description\":\"City centre store\"}",
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.POST,
                null
        );
    }
    
    @Test
    public void removeAllowedOrigin() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/management/store.json");
        MyApiCredentialApi service = new MyApiCredentialApi(client);

        service.removeAllowedOrigin("ID");

        verify(client.getHttpClient()).request(
                "https://management-test.adyen.com/v3/me/allowedOrigins/ID",
                null,
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.DELETE,
                null
        );
    }
    
    @Test
    @Ignore("Integration test")
    public void me() throws IOException, ApiException {
        Client client = new Client(System.getenv("API_KEY"), Environment.TEST);
        MyApiCredentialApi service = new MyApiCredentialApi(client);

        MeApiCredential me = service.getApiCredentialDetails();
        
        assertTrue(me.getActive());
    }
}
