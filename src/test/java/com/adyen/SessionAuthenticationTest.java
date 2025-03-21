package com.adyen;

import com.adyen.constants.ApiConstants;
import com.adyen.model.sessionauthentication.*;
import com.adyen.service.sessionauthentication.SessionAuthenticationApi;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class SessionAuthenticationTest extends BaseTest {

    @Test
    public void createAuthenticationSessionTest() throws Exception {
        Client client = createMockClientFromFile("mocks/sessionauthentication/response/SessionAuthenticationCreated.json");
        SessionAuthenticationApi sessionAuthenticationApi = new SessionAuthenticationApi(client);
        AuthenticationSessionRequest request = new AuthenticationSessionRequest()
                .allowOrigin("https://your-company.example.com")
                .product(ProductType.PLATFORM)
                .policy(new Policy()
                        .addResourcesItem(new AccountHolderResource()
                                .accountHolderId("AH00000000000000000000001")
                                .type(ResourceType.ACCOUNTHOLDER)
                        )
                        .roles(Set.of("Transactions Overview Component: View", "Payouts Overview Component: View")));
        AuthenticationSessionResponse response = sessionAuthenticationApi.createAuthenticationSession(request);
        assertEquals("11a1e60a-18b0-4dda-9258-e0ae29e1e2a3", response.getId());


        verify(client.getHttpClient()).request(
                "https://test.adyen.com/authe/api/v1/sessions",
                request.toJson(),
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.POST,
                null
        );
    }

}