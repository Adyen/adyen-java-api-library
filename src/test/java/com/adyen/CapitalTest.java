package com.adyen;

import com.adyen.constants.ApiConstants;
import com.adyen.model.capital.CapitalGrant;
import com.adyen.model.capital.CapitalGrantInfo;
import com.adyen.service.CapitalApi;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class CapitalTest extends BaseTest {

    @Test
    public void TestGetCapitalAccounts() throws Exception {
        Client client = createMockClientFromFile("mocks/capital/get-capital-account.json");
        CapitalApi service = new CapitalApi(client);
        com.adyen.model.capital.CapitalGrants response = service.getCapitalAccount();
        assertEquals(response.getGrants().get(0).getGrantOfferId(), "string");
        verify(client.getHttpClient()).request(
                "https://balanceplatform-api-test.adyen.com/btl/v3/grants",
                null,
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.GET,
                new HashMap<>()
        );
    }

    @Test
    public void TestRequestGrant() throws Exception {
        Client client = createMockClientFromFile("mocks/capital/request-grant.json");
        CapitalApi service = new CapitalApi(client);
        CapitalGrant response = service.requestGrantPayout(new CapitalGrantInfo());
        assertEquals(response.getGrantAccountId(), "CG00000000000000000000001");
        verify(client.getHttpClient()).request(
                "https://balanceplatform-api-test.adyen.com/btl/v3/grants",
                "{}",
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.POST,
                null
        );
    }
}
