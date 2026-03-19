package com.adyen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import com.adyen.constants.ApiConstants;
import com.adyen.enums.Environment;
import com.adyen.model.sessionauthentication.*;
import com.adyen.service.sessionauthentication.SessionAuthenticationApi;
import java.lang.reflect.Field;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class SessionAuthenticationTest extends BaseTest {

  @Test
  public void baseUrlOnTest() throws NoSuchFieldException, IllegalAccessException {
    Client client = new Client(new Config().apiKey("test").environment(Environment.TEST));

    SessionAuthenticationApi sessionAuthenticationApi = new SessionAuthenticationApi(client);
    // get field by reflection (it is protected)
    Field baseURLField = SessionAuthenticationApi.class.getDeclaredField("baseURL");
    baseURLField.setAccessible(true);
    String baseURL = (String) baseURLField.get(sessionAuthenticationApi);
    assertEquals(
        String.format("https://test.adyen.com/authe/api/v%s", SessionAuthenticationApi.API_VERSION),
        baseURL);
  }

  @Test
  public void baseUrlOnLive() throws NoSuchFieldException, IllegalAccessException {
    Client client = new Client(new Config().apiKey("test").environment(Environment.LIVE));

    SessionAuthenticationApi sessionAuthenticationApi = new SessionAuthenticationApi(client);
    // get field by reflection (it is protected)
    Field baseURLField = SessionAuthenticationApi.class.getDeclaredField("baseURL");
    baseURLField.setAccessible(true);
    String baseURL = (String) baseURLField.get(sessionAuthenticationApi);
    assertEquals(
        String.format(
            "https://authe-live.adyen.com/authe/api/v%s", SessionAuthenticationApi.API_VERSION),
        baseURL);
  }

  @Test
  public void createAuthenticationSessionTest() throws Exception {
    Client client =
        createMockClientFromFile(
            "mocks/sessionauthentication/response/SessionAuthenticationCreated.json");
    SessionAuthenticationApi sessionAuthenticationApi = new SessionAuthenticationApi(client);
    AuthenticationSessionRequest request =
        new AuthenticationSessionRequest()
            .allowOrigin("https://your-company.example.com")
            .product(ProductType.PLATFORM)
            .policy(
                new Policy()
                    .addResourcesItem(
                        new AccountHolderResource()
                            .accountHolderId("AH00000000000000000000001")
                            .type(ResourceType.ACCOUNTHOLDER))
                    .roles(
                        Set.of(
                            "Transactions Overview Component: View",
                            "Payouts Overview Component: View")));
    AuthenticationSessionResponse response =
        sessionAuthenticationApi.createAuthenticationSession(request);
    assertEquals("11a1e60a-18b0-4dda-9258-e0ae29e1e2a3", response.getId());

    verify(client.getHttpClient())
        .request(
            String.format(
                "https://test.adyen.com/authe/api/v%s/sessions",
                SessionAuthenticationApi.API_VERSION),
            request.toJson(),
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }
}
