package com.adyen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import com.adyen.constants.ApiConstants;
import com.adyen.enums.Environment;
import com.adyen.httpclient.HTTPClientException;
import com.adyen.model.balancecontrol.BalanceTransferRequest;
import com.adyen.model.balancecontrol.BalanceTransferResponse;
import com.adyen.service.balancecontrol.BalanceControlApi;
import com.adyen.service.exception.ApiException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;

public class BalanceControlTest extends BaseTest {

  @Test
  public void baseUrlOnTest() throws NoSuchFieldException, IllegalAccessException {
    Client client = new Client(new Config()
            .apiKey("test")
            .environment(Environment.TEST)
            .liveEndpointUrlPrefix("myCompany"));

    BalanceControlApi balanceControlApi = new BalanceControlApi(client);
    // get field by reflection (it is protected)
    Field baseURLField = BalanceControlApi.class.getDeclaredField("baseURL");
    baseURLField.setAccessible(true);
    String baseURL = (String) baseURLField.get(balanceControlApi);
    assertEquals("https://pal-test.adyen.com/pal/servlet/BalanceControl/v1", baseURL);
  }

  @Test
  public void baseUrlOnLive() throws NoSuchFieldException, IllegalAccessException {
    Client client = new Client(new Config()
            .apiKey("test")
            .environment(Environment.LIVE)
            .liveEndpointUrlPrefix("myCompany"));

    BalanceControlApi balanceControlApi = new BalanceControlApi(client);
    // get field by reflection (it is protected)
    Field baseURLField = BalanceControlApi.class.getDeclaredField("baseURL");
    baseURLField.setAccessible(true);
    String baseURL = (String) baseURLField.get(balanceControlApi);
    assertEquals("https://myCompany-pal-live.adyenpayments.com/pal/servlet/BalanceControl/v1", baseURL);
  }

  @Test
  public void TestBalanceControlApi() throws IOException, ApiException, HTTPClientException {
    Client client = createMockClientFromFile("mocks/smallendpoints/balance-control.json");
    BalanceControlApi service = new BalanceControlApi(client);
    BalanceTransferResponse response = service.balanceTransfer(new BalanceTransferRequest());

    verify(client.getHttpClient())
        .request(
            "https://pal-test.adyen.com/pal/servlet/BalanceControl/v1/balanceTransfer",
            "{}",
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
    assertEquals(response.getStatus(), BalanceTransferResponse.StatusEnum.TRANSFERRED);
    assertEquals(response.getCreatedAt(), OffsetDateTime.parse("2022-01-24T14:59:11+01:00"));
  }
}
