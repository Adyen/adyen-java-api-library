package com.adyen.service.management;

import static org.mockito.Mockito.verify;

import com.adyen.BaseTest;
import com.adyen.Client;
import com.adyen.constants.ApiConstants;
import org.junit.jupiter.api.Test;

public class TerminalThemesStoreLevelApiTest extends BaseTest {

  private static final String STORE_URL =
      "https://management-test.adyen.com/v"
          + TerminalThemesStoreLevelApi.API_VERSION
          + "/stores/YOUR_STORE_ID";

  @Test
  public void applyTerminalThemeForStoreTest() throws Exception {
    Client client = createMockClientFromResponse("");
    TerminalThemesStoreLevelApi service = new TerminalThemesStoreLevelApi(client);

    service.applyTerminalThemeForStore("YOUR_STORE_ID", "THEM_001ABC");

    verify(client.getHttpClient())
        .request(
            STORE_URL + "/terminalThemes/THEM_001ABC/apply",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  public void unapplyTerminalThemeForStoreTest() throws Exception {
    Client client = createMockClientFromResponse("{\"status\":\"success\"}");
    TerminalThemesStoreLevelApi service = new TerminalThemesStoreLevelApi(client);

    service.unapplyTerminalThemeForStore("YOUR_STORE_ID");

    verify(client.getHttpClient())
        .request(
            STORE_URL + "/terminalThemes/unapply",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }
}
