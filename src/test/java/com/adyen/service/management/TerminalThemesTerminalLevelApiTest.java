package com.adyen.service.management;

import static org.mockito.Mockito.verify;

import com.adyen.BaseTest;
import com.adyen.Client;
import com.adyen.constants.ApiConstants;
import org.junit.jupiter.api.Test;

public class TerminalThemesTerminalLevelApiTest extends BaseTest {

  private static final String TERMINAL_URL =
      "https://management-test.adyen.com/v"
          + TerminalThemesTerminalLevelApi.API_VERSION
          + "/terminals/AMS1-000150193300122";

  @Test
  public void applyTerminalThemeForTerminalTest() throws Exception {
    Client client = createMockClientFromResponse("");
    TerminalThemesTerminalLevelApi service = new TerminalThemesTerminalLevelApi(client);

    service.applyTerminalThemeForTerminal("AMS1-000150193300122", "THEM_001ABC");

    verify(client.getHttpClient())
        .request(
            TERMINAL_URL + "/terminalThemes/THEM_001ABC/apply",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  public void unapplyTerminalThemeForTerminalTest() throws Exception {
    Client client = createMockClientFromResponse("{\"status\":\"success\"}");
    TerminalThemesTerminalLevelApi service = new TerminalThemesTerminalLevelApi(client);

    service.unapplyTerminalThemeForTerminal("AMS1-000150193300122");

    verify(client.getHttpClient())
        .request(
            TERMINAL_URL + "/terminalThemes/unapply",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }
}
