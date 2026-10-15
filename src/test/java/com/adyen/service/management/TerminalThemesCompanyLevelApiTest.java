package com.adyen.service.management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

import com.adyen.BaseTest;
import com.adyen.Client;
import com.adyen.constants.ApiConstants;
import com.adyen.model.RequestOptions;
import com.adyen.model.management.CreateThemeRequest;
import com.adyen.model.management.CreateThemeResponse;
import com.adyen.model.management.ListThemesResponse;
import com.adyen.model.management.ThemeAsset;
import com.adyen.model.management.ThemeMode;
import com.adyen.model.management.ThemeUpdateRequest;
import com.adyen.model.management.ThemeWithAssetDetails;
import com.adyen.model.management.UpdateThemeResponse;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class TerminalThemesCompanyLevelApiTest extends BaseTest {

  private static final String COMPANY_URL =
      "https://management-test.adyen.com/v"
          + TerminalThemesCompanyLevelApi.API_VERSION
          + "/companies/YOUR_COMPANY_ID";

  @Test
  public void listTerminalThemesForCompanyTest() throws Exception {
    Client client = createMockClientFromFile("mocks/management/list-terminal-themes.json");
    TerminalThemesCompanyLevelApi service = new TerminalThemesCompanyLevelApi(client);

    ListThemesResponse response = service.listTerminalThemesForCompany("YOUR_COMPANY_ID");

    assertEquals(2, response.getData().size());
    assertEquals("THEM_001ABC", response.getData().get(0).getId());
    assertEquals(ThemeMode.DARK, response.getData().get(0).getMode());
    assertEquals(ThemeMode.LIGHT, response.getData().get(1).getMode());
    assertFalse(response.getHasNextPage());
    verify(client.getHttpClient())
        .request(
            COMPANY_URL + "/terminalThemes",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            Collections.emptyMap());
  }

  @Test
  public void listTerminalThemesForCompanyWithQueryParamsTest() throws Exception {
    Client client = createMockClientFromFile("mocks/management/list-terminal-themes.json");
    TerminalThemesCompanyLevelApi service = new TerminalThemesCompanyLevelApi(client);

    service.listTerminalThemesForCompany("YOUR_COMPANY_ID", 5, 2, "Brand", null);

    Map<String, String> queryParams = new HashMap<>();
    queryParams.put("pageSize", "5");
    queryParams.put("page", "2");
    queryParams.put("search", "Brand");
    verify(client.getHttpClient())
        .request(
            COMPANY_URL + "/terminalThemes",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            queryParams);
  }

  @Test
  public void createTerminalThemeForCompanyTest() throws Exception {
    Client client = createMockClientFromFile("mocks/management/terminal-theme.json");
    TerminalThemesCompanyLevelApi service = new TerminalThemesCompanyLevelApi(client);
    CreateThemeRequest request = new CreateThemeRequest().name("MyBrandTheme").mode(ThemeMode.DARK);

    CreateThemeResponse response =
        service.createTerminalThemeForCompany("YOUR_COMPANY_ID", request);

    assertEquals("THEM_001ABC", response.getId());
    assertEquals("MyBrandTheme", response.getName());
    assertEquals(ThemeMode.DARK, response.getMode());
    verify(client.getHttpClient())
        .request(
            COMPANY_URL + "/terminalThemes",
            "{\"mode\":\"dark\",\"name\":\"MyBrandTheme\"}",
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  public void createTerminalThemeForCompanyWithRequestOptionsTest() throws Exception {
    Client client = createMockClientFromFile("mocks/management/terminal-theme.json");
    TerminalThemesCompanyLevelApi service = new TerminalThemesCompanyLevelApi(client);
    CreateThemeRequest request = new CreateThemeRequest().name("MyBrandTheme").mode(ThemeMode.DARK);
    RequestOptions requestOptions =
        new RequestOptions().idempotencyKey("2b4f8c1e-7d3a-4e9b-a6c5-0f1e2d3c4b5a");

    service.createTerminalThemeForCompany("YOUR_COMPANY_ID", request, requestOptions);

    verify(client.getHttpClient())
        .request(
            COMPANY_URL + "/terminalThemes",
            "{\"mode\":\"dark\",\"name\":\"MyBrandTheme\"}",
            client.getConfig(),
            false,
            requestOptions,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  public void getTerminalThemeByIdForCompanyTest() throws Exception {
    Client client = createMockClientFromFile("mocks/management/terminal-theme-with-assets.json");
    TerminalThemesCompanyLevelApi service = new TerminalThemesCompanyLevelApi(client);

    ThemeWithAssetDetails response =
        service.getTerminalThemeByIdForCompany("YOUR_COMPANY_ID", "THEM_001ABC");

    assertEquals("THEM_001ABC", response.getId());
    assertEquals(2, response.getAssets().size());
    ThemeAsset asset = response.getAssets().get(0);
    assertEquals("homeScreen", asset.getType());
    assertEquals("AMS1", asset.getModel());
    assertEquals(
        "https://cdn.adyen.com/external/TestCompany/themeAssets/abc123.png?token=****************",
        asset.getUrl());
    verify(client.getHttpClient())
        .request(
            COMPANY_URL + "/terminalThemes/THEM_001ABC",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            null);
  }

  @Test
  public void updateTerminalThemeForCompanyTest() throws Exception {
    Client client =
        createMockClientFromResponse(
            "{\"id\":\"THEM_001ABC\",\"name\":\"ThemeLive\",\"mode\":\"light\"}");
    TerminalThemesCompanyLevelApi service = new TerminalThemesCompanyLevelApi(client);
    ThemeUpdateRequest request =
        new ThemeUpdateRequest().name("ThemeLive").mode(ThemeUpdateRequest.ModeEnum.LIGHT);

    UpdateThemeResponse response =
        service.updateTerminalThemeForCompany("YOUR_COMPANY_ID", "THEM_001ABC", request);

    assertEquals("ThemeLive", response.getName());
    assertEquals(ThemeMode.LIGHT, response.getMode());
    verify(client.getHttpClient())
        .request(
            COMPANY_URL + "/terminalThemes/THEM_001ABC",
            "{\"mode\":\"light\",\"name\":\"ThemeLive\"}",
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.PATCH,
            null);
  }

  @Test
  public void deleteTerminalThemeForCompanyTest() throws Exception {
    Client client = createMockClientFromResponse("");
    TerminalThemesCompanyLevelApi service = new TerminalThemesCompanyLevelApi(client);

    service.deleteTerminalThemeForCompany("YOUR_COMPANY_ID", "THEM_001ABC");

    verify(client.getHttpClient())
        .request(
            COMPANY_URL + "/terminalThemes/THEM_001ABC",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.DELETE,
            null);
  }

  @Test
  public void applyTerminalThemeForCompanyTest() throws Exception {
    Client client = createMockClientFromResponse("");
    TerminalThemesCompanyLevelApi service = new TerminalThemesCompanyLevelApi(client);

    service.applyTerminalThemeForCompany("YOUR_COMPANY_ID", "THEM_001ABC");

    verify(client.getHttpClient())
        .request(
            COMPANY_URL + "/terminalThemes/THEM_001ABC/apply",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  public void unapplyTerminalThemeForCompanyTest() throws Exception {
    Client client = createMockClientFromResponse("{\"status\":\"success\"}");
    TerminalThemesCompanyLevelApi service = new TerminalThemesCompanyLevelApi(client);

    service.unapplyTerminalThemeForCompany("YOUR_COMPANY_ID");

    verify(client.getHttpClient())
        .request(
            COMPANY_URL + "/terminalThemes/unapply",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  public void addTerminalThemeAssetForCompanyTest() throws Exception {
    Client client = createMockClientFromFile("mocks/management/terminal-theme-asset.json");
    TerminalThemesCompanyLevelApi service = new TerminalThemesCompanyLevelApi(client);
    File asset = new File("homeScreen.png");

    ThemeAsset response =
        service.addTerminalThemeAssetForCompany(
            "YOUR_COMPANY_ID", "THEM_001ABC", "homeScreen", "AMS1", asset);

    assertEquals("homeScreen", response.getType());
    assertEquals("AMS1", response.getModel());
    verify(client.getHttpClient())
        .requestMultipart(
            COMPANY_URL + "/terminalThemes/THEM_001ABC/assets",
            fileFormParams(asset),
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            assetQueryParams("homeScreen", "AMS1"));
  }

  @Test
  public void editTerminalThemeAssetForCompanyTest() throws Exception {
    Client client = createMockClientFromFile("mocks/management/terminal-theme-asset.json");
    TerminalThemesCompanyLevelApi service = new TerminalThemesCompanyLevelApi(client);
    File asset = new File("homeScreen.png");

    ThemeAsset response =
        service.editTerminalThemeAssetForCompany(
            "YOUR_COMPANY_ID", "THEM_001ABC", "homeScreen", "AMS1", asset);

    assertEquals("homeScreen", response.getType());
    verify(client.getHttpClient())
        .requestMultipart(
            COMPANY_URL + "/terminalThemes/THEM_001ABC/assets/replace",
            fileFormParams(asset),
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            assetQueryParams("homeScreen", "AMS1"));
  }

  @Test
  public void addTerminalThemeAssetForCompanyRequiresFileTest() {
    Client client = createMockClientFromFile("mocks/management/terminal-theme-asset.json");
    TerminalThemesCompanyLevelApi service = new TerminalThemesCompanyLevelApi(client);

    assertThrows(
        IllegalArgumentException.class,
        () ->
            service.addTerminalThemeAssetForCompany(
                "YOUR_COMPANY_ID", "THEM_001ABC", "homeScreen", "AMS1", null));
  }

  @Test
  public void deleteTerminalThemeAssetForCompanyTest() throws Exception {
    Client client = createMockClientFromResponse("");
    TerminalThemesCompanyLevelApi service = new TerminalThemesCompanyLevelApi(client);

    service.deleteTerminalThemeAssetForCompany("YOUR_COMPANY_ID", "THEM_001ABC", "logo", "All");

    verify(client.getHttpClient())
        .request(
            COMPANY_URL + "/terminalThemes/THEM_001ABC/assets",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.DELETE,
            assetQueryParams("logo", "All"));
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
