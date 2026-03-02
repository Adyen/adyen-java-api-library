package com.adyen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import com.adyen.constants.ApiConstants;
import com.adyen.enums.Environment;
import com.adyen.model.openbanking.AccountVerificationCountry;
import com.adyen.model.openbanking.AccountVerificationReportResponse;
import com.adyen.model.openbanking.AccountVerificationRoutesRequest;
import com.adyen.model.openbanking.AccountVerificationRoutesResponse;
import com.adyen.service.openbanking.AccountVerificationApi;
import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;

public class OpenBankingTest extends BaseTest {

  @Test
  public void baseUrlOnTest() throws NoSuchFieldException, IllegalAccessException {
    Client client = new Client(new Config()
            .apiKey("test")
            .environment(Environment.TEST));

    AccountVerificationApi accountVerificationApi = new AccountVerificationApi(client);
    // get field by reflection (it is protected)
    Field baseURLField = AccountVerificationApi.class.getDeclaredField("baseURL");
    baseURLField.setAccessible(true);
    String baseURL = (String) baseURLField.get(accountVerificationApi);
    assertEquals("https://obgateway-test.adyen.com/obgateway/v1", baseURL);
  }

  @Test
  public void baseUrlOnLive() throws NoSuchFieldException, IllegalAccessException {
    Client client = new Client(new Config()
            .apiKey("test")
            .environment(Environment.LIVE));

    AccountVerificationApi accountVerificationApi = new AccountVerificationApi(client);
    // get field by reflection (it is protected)
    Field baseURLField = AccountVerificationApi.class.getDeclaredField("baseURL");
    baseURLField.setAccessible(true);
    String baseURL = (String) baseURLField.get(accountVerificationApi);
    assertEquals("https://obgateway-live.adyen.com/obgateway/v1", baseURL);
  }

  @Test
  public void createAccountVerificationRoutesTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/balancePlatform/AccountVerificationRoutesResponse.json");

    AccountVerificationApi service = new AccountVerificationApi(client);
    AccountVerificationRoutesRequest request =
        new AccountVerificationRoutesRequest()
            .redirectUrl("https://example.com/redirect")
            .country(AccountVerificationCountry.NL)
            .locale("en-US")
            .state("11a1e60a-18b0-4dda-9258-e0ae29e1e2a3");

    AccountVerificationRoutesResponse response = service.createAccountVerificationRoutes(request);

    assertNotNull(response);
    assertEquals(
        "https://obgateway.adyen.com/obgateway/provider/outgoing/tink/redirect/13ec4802-c987-4f8c-8909-9a75ff567256",
        response.getRoutes().get(0).getLink());
    assertEquals("Tink", response.getRoutes().get(0).getProvider().getName());

    verify(client.getHttpClient())
        .request(
            eq("https://obgateway-test.adyen.com/obgateway/v1/accountVerification/routes"),
            anyString(),
            eq(client.getConfig()),
            eq(false),
            eq(null),
            eq(ApiConstants.HttpMethod.POST),
            eq(null));
  }

  @Test
  public void getAccountVerificationReportTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/balancePlatform/AccountVerificationReportResponse.json");
    AccountVerificationApi service = new AccountVerificationApi(client);
    String code = "test_code_123";

    AccountVerificationReportResponse response = service.getAccountVerificationReport(code);

    assertNotNull(response);
    assertEquals("69ee9452ef824fe092f1417f37535755", response.getId());
    assertEquals(1, response.getAccounts().size());
    assertEquals("Tink Demo Bank", response.getAccounts().get(0).getBankName());

    verify(client.getHttpClient())
        .request(
            eq("https://obgateway-test.adyen.com/obgateway/v1/accountVerification/reports/" + code),
            eq(null),
            eq(client.getConfig()),
            eq(false),
            eq(null),
            eq(ApiConstants.HttpMethod.GET),
            eq(null));
  }
}
