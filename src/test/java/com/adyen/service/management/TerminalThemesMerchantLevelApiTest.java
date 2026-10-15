package com.adyen.service.management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import com.adyen.BaseTest;
import com.adyen.Client;
import com.adyen.constants.ApiConstants;
import com.adyen.model.management.CreateThemeRequest;
import com.adyen.model.management.CreateThemeResponse;
import com.adyen.model.management.ListThemesResponse;
import com.adyen.model.management.ThemeAsset;
import com.adyen.model.management.ThemeMode;
import com.adyen.model.management.ThemeUpdateRequest;
import com.adyen.model.management.ThemeWithAssetDetails;
import com.adyen.model.management.UpdateThemeResponse;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class TerminalThemesMerchantLevelApiTest extends BaseTest {

  private static final String MERCHANT_URL =
      "https://management-test.adyen.com/v"
          + TerminalThemesMerchantLevelApi.API_VERSION
          + "/merchants/YOUR_MERCHANT_ACCOUNT_ID";

  @Test
  public void listTerminalThemesForMerchantTest() throws Exception {
    Client client = createMockClientFromFile("mocks/management/list-terminal-themes.json");
    TerminalThemesMerchantLevelApi service = new TerminalThemesMerchantLevelApi(client);

    ListThemesResponse response =
        service.listTerminalThemesForMerchant("YOUR_MERCHANT_ACCOUNT_ID", 10, 1, null, null);

    assertEquals(2, response.getData().size());
    assertEquals("BrandLight", response.getData().get(1).getName());
    Map<String, String> queryParams = new HashMap<>();
    queryParams.put("pageSize", "10");
    queryParams.put("page", "1");
    verify(client.getHttpClient())
        .request(
            MERCHANT_URL + "/terminalThemes",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            queryParams);
  }

  @Test
  public void createTerminalThemeForMerchantTest() throws Exception {
    Client client = createMockClientFromFile("mocks/management/terminal-theme.json");
    TerminalThemesMerchantLevelApi service = new TerminalThemesMerchantLevelApi(client);
    CreateThemeRequest request = new CreateThemeRequest().name("MyBrandTheme").mode(ThemeMode.DARK);

    CreateThemeResponse response =
        service.createTerminalThemeForMerchant("YOUR_MERCHANT_ACCOUNT_ID", request);

    assertEquals("THEM_001ABC", response.getId());
    verify(client.getHttpClient())
        .request(
            MERCHANT_URL + "/terminalThemes",
            "{\"mode\":\"dark\",\"name\":\"MyBrandTheme\"}",
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  public void getTerminalThemeByIdForMerchantTest() throws Exception {
    Client client = createMockClientFromFile("mocks/management/terminal-theme-with-assets.json");
    TerminalThemesMerchantLevelApi service = new TerminalThemesMerchantLevelApi(client);

    ThemeWithAssetDetails response =
        service.getTerminalThemeByIdForMerchant("YOUR_MERCHANT_ACCOUNT_ID", "THEM_001ABC");

    assertEquals("logo", response.getAssets().get(1).getType());
    assertEquals("All", response.getAssets().get(1).getModel());
    verify(client.getHttpClient())
        .request(
            MERCHANT_URL + "/terminalThemes/THEM_001ABC",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            null);
  }

  @Test
  public void updateTerminalThemeForMerchantTest() throws Exception {
    Client client = createMockClientFromFile("mocks/management/terminal-theme.json");
    TerminalThemesMerchantLevelApi service = new TerminalThemesMerchantLevelApi(client);
    ThemeUpdateRequest request = new ThemeUpdateRequest().mode(ThemeUpdateRequest.ModeEnum.DARK);

    UpdateThemeResponse response =
        service.updateTerminalThemeForMerchant("YOUR_MERCHANT_ACCOUNT_ID", "THEM_001ABC", request);

    assertEquals(ThemeMode.DARK, response.getMode());
    verify(client.getHttpClient())
        .request(
            MERCHANT_URL + "/terminalThemes/THEM_001ABC",
            "{\"mode\":\"dark\"}",
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.PATCH,
            null);
  }

  @Test
  public void deleteTerminalThemeForMerchantTest() throws Exception {
    Client client = createMockClientFromResponse("");
    TerminalThemesMerchantLevelApi service = new TerminalThemesMerchantLevelApi(client);

    service.deleteTerminalThemeForMerchant("YOUR_MERCHANT_ACCOUNT_ID", "THEM_001ABC");

    verify(client.getHttpClient())
        .request(
            MERCHANT_URL + "/terminalThemes/THEM_001ABC",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.DELETE,
            null);
  }

  @Test
  public void applyTerminalThemeForMerchantTest() throws Exception {
    Client client = createMockClientFromResponse("");
    TerminalThemesMerchantLevelApi service = new TerminalThemesMerchantLevelApi(client);

    service.applyTerminalThemeForMerchant("YOUR_MERCHANT_ACCOUNT_ID", "THEM_001ABC");

    verify(client.getHttpClient())
        .request(
            MERCHANT_URL + "/terminalThemes/THEM_001ABC/apply",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  public void unapplyTerminalThemeForMerchantTest() throws Exception {
    Client client = createMockClientFromResponse("{\"status\":\"success\"}");
    TerminalThemesMerchantLevelApi service = new TerminalThemesMerchantLevelApi(client);

    service.unapplyTerminalThemeForMerchant("YOUR_MERCHANT_ACCOUNT_ID");

    verify(client.getHttpClient())
        .request(
            MERCHANT_URL + "/terminalThemes/unapply",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  public void addTerminalThemeAssetForMerchantTest() throws Exception {
    Client client = createMockClientFromFile("mocks/management/terminal-theme-asset.json");
    TerminalThemesMerchantLevelApi service = new TerminalThemesMerchantLevelApi(client);
    File asset = new File("homeScreen.png");

    ThemeAsset response =
        service.addTerminalThemeAssetForMerchant(
            "YOUR_MERCHANT_ACCOUNT_ID", "THEM_001ABC", "homeScreen", "AMS1", asset);

    assertEquals("AMS1", response.getModel());
    verify(client.getHttpClient())
        .requestMultipart(
            MERCHANT_URL + "/terminalThemes/THEM_001ABC/assets",
            fileFormParams(asset),
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            assetQueryParams("homeScreen", "AMS1"));
  }

  @Test
  public void editTerminalThemeAssetForMerchantTest() throws Exception {
    Client client = createMockClientFromFile("mocks/management/terminal-theme-asset.json");
    TerminalThemesMerchantLevelApi service = new TerminalThemesMerchantLevelApi(client);
    File asset = new File("homeScreen.png");

    service.editTerminalThemeAssetForMerchant(
        "YOUR_MERCHANT_ACCOUNT_ID", "THEM_001ABC", "homeScreen", "AMS1", asset);

    verify(client.getHttpClient())
        .requestMultipart(
            MERCHANT_URL + "/terminalThemes/THEM_001ABC/assets/replace",
            fileFormParams(asset),
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            assetQueryParams("homeScreen", "AMS1"));
  }

  @Test
  public void deleteTerminalThemeAssetForMerchantTest() throws Exception {
    Client client = createMockClientFromResponse("");
    TerminalThemesMerchantLevelApi service = new TerminalThemesMerchantLevelApi(client);

    service.deleteTerminalThemeAssetForMerchant(
        "YOUR_MERCHANT_ACCOUNT_ID", "THEM_001ABC", "homeScreen", "AMS1");

    verify(client.getHttpClient())
        .request(
            MERCHANT_URL + "/terminalThemes/THEM_001ABC/assets",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.DELETE,
            assetQueryParams("homeScreen", "AMS1"));
  }

  private static Map<String, Object> fileFormParams(File file) {
    Map<String, Object> formParams = new LinkedHashMap<>();
    formParams.put("file", file);
    return formParams;
  }

  private static Map<String, String> assetQueryParams(String type, String model) {
    Map<String, String> queryParams = new HashMap<>();
    queryParams.put("type", type);
    queryParams.put("model", model);
    return queryParams;
  }
}
