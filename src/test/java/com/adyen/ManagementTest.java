package com.adyen;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import com.adyen.constants.ApiConstants;
import com.adyen.enums.Environment;
import com.adyen.httpclient.HTTPClientException;
import com.adyen.model.management.*;
import com.adyen.service.exception.ApiException;
import com.adyen.service.management.*;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ManagementTest extends BaseTest {

  @Test
  public void baseUrlOnTest() throws NoSuchFieldException, IllegalAccessException {
    Client client = new Client(new Config().apiKey("test").environment(Environment.TEST));

    AccountMerchantLevelApi accountMerchantLevelApi = new AccountMerchantLevelApi(client);
    // get field by reflection (it is protected)
    Field baseURLField = AccountMerchantLevelApi.class.getDeclaredField("baseURL");
    baseURLField.setAccessible(true);
    String baseURL = (String) baseURLField.get(accountMerchantLevelApi);
    assertEquals(
        String.format("https://management-test.adyen.com/v%s", AccountMerchantLevelApi.API_VERSION),
        baseURL);
  }

  @Test
  public void baseUrlOnLive() throws NoSuchFieldException, IllegalAccessException {
    Client client = new Client(new Config().apiKey("test").environment(Environment.LIVE));

    AccountMerchantLevelApi accountMerchantLevelApi = new AccountMerchantLevelApi(client);
    // get field by reflection (it is protected)
    Field baseURLField = AccountMerchantLevelApi.class.getDeclaredField("baseURL");
    baseURLField.setAccessible(true);
    String baseURL = (String) baseURLField.get(accountMerchantLevelApi);
    assertEquals(
        String.format("https://management-live.adyen.com/v%s", AccountMerchantLevelApi.API_VERSION),
        baseURL);
  }

  @Test
  public void listMerchantAccounts() throws IOException, ApiException {
    Client client = createMockClientFromFile("mocks/management/list-merchants.json");
    AccountMerchantLevelApi service = new AccountMerchantLevelApi(client);

    ListMerchantResponse merchants = service.listMerchantAccounts();

    assertEquals(10, merchants.getData().size());
    assertEquals("Amsterdam", merchants.getData().get(0).getMerchantCity());
  }

  @Test
  public void listMerchantAccountsPaginated()
      throws IOException, ApiException, HTTPClientException {
    Client client = createMockClientFromFile("mocks/management/list-merchants.json");
    client.setEnvironment(Environment.TEST, "junit");
    Map<String, String> queryParams = Collections.singletonMap("pageSize", "25");
    AccountMerchantLevelApi service = new AccountMerchantLevelApi(client);

    service.listMerchantAccounts(null, 25, null);

    verify(client.getHttpClient())
        .request(
            String.format(
                "https://management-test.adyen.com/v%s/merchants",
                AccountMerchantLevelApi.API_VERSION),
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            queryParams);
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
    verify(client.getHttpClient())
        .request(
            String.format(
                "https://management-test.adyen.com/v%s/terminals/123ABC/terminalSettings",
                TerminalSettingsTerminalLevelApi.API_VERSION),
            "{\"receiptPrinting\":{\"shopperApproved\":true}}",
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.PATCH,
            null);
  }

  @Test
  public void createStore() throws IOException, ApiException, HTTPClientException {
    Client client = createMockClientFromFile("mocks/management/store.json");
    AccountStoreLevelApi service = new AccountStoreLevelApi(client);
    StoreCreationRequest request = new StoreCreationRequest();
    request.setDescription("City centre store");

    Store store = service.createStoreByMerchantId("YOUR_MERCHANT_ACCOUNT_ID", request);

    assertEquals("YOUR_STORE_ID", store.getId());
    verify(client.getHttpClient())
        .request(
            String.format(
                "https://management-test.adyen.com/v%s/merchants/YOUR_MERCHANT_ACCOUNT_ID/stores",
                AccountStoreLevelApi.API_VERSION),
            "{\"description\":\"City centre store\"}",
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  public void removeAllowedOrigin() throws IOException, ApiException, HTTPClientException {
    Client client = createMockClientFromFile("mocks/management/store.json");
    MyApiCredentialApi service = new MyApiCredentialApi(client);

    service.removeAllowedOrigin("ID");

    verify(client.getHttpClient())
        .request(
            String.format(
                "https://management-test.adyen.com/v%s/me/allowedOrigins/ID",
                MyApiCredentialApi.API_VERSION),
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.DELETE,
            null);
  }

  // Breaking change: PaymentMethodSetupInfo.carnet type changed from GenericPmWithTdiInfo to
  // CarnetInfo. Verifies the new type round-trips through serialization.
  @Test
  public void paymentMethodSetupInfoCarnetType() throws IOException {
    PaymentMethodSetupInfo request = new PaymentMethodSetupInfo();
    request.setType(PaymentMethodSetupInfo.TypeEnum.CARNET);
    request.setCarnet(new CarnetInfo().addMccAcronym(true));

    String json = request.toJson();
    PaymentMethodSetupInfo parsed = PaymentMethodSetupInfo.fromJson(json);

    CarnetInfo carnet = parsed.getCarnet();
    assertNotNull(carnet);
    assertTrue(carnet.getAddMccAcronym());
  }

  // Non-breaking: new DonationCampaignsApi service create endpoint.
  @Test
  public void createDonationCampaign() throws IOException, ApiException, HTTPClientException {
    Client client = createMockClientFromFile("mocks/management/donation-campaign.json");
    DonationCampaignsApi service = new DonationCampaignsApi(client);
    DonationCampaignRequest request =
        new DonationCampaignRequest().name("Clean water campaign").nonprofitCauseId("CAUSE123");

    DonationCampaign campaign = service.createDonationCampaign("YOUR_COMPANY_ID", request);

    assertEquals("DC123456789", campaign.getId());
    assertEquals("Clean water campaign", campaign.getName());
    assertEquals(DonationCampaignStatus.ACTIVE, campaign.getStatus());
    assertNotNull(campaign.getNonprofitCause());
    assertEquals("Water for All", campaign.getNonprofitCause().getNonprofitName());
    verify(client.getHttpClient())
        .request(
            String.format(
                "https://management-test.adyen.com/v%s/companies/YOUR_COMPANY_ID/campaignManagement",
                DonationCampaignsApi.API_VERSION),
            "{\"name\":\"Clean water campaign\",\"nonprofitCauseId\":\"CAUSE123\"}",
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  // Non-breaking: DonationCampaignsApi status transition; guards the enum path param that
  // previously failed to compile (CampaignStatusTransition put into a String path map).
  @Test
  public void updateDonationCampaignStatus() throws IOException, ApiException, HTTPClientException {
    Client client = createMockClientFromFile("mocks/management/donation-campaign.json");
    DonationCampaignsApi service = new DonationCampaignsApi(client);

    DonationCampaign campaign =
        service.updateDonationCampaignStatus(
            "YOUR_COMPANY_ID", "DC123456789", CampaignStatusTransition.ACTIVATE);

    assertEquals(DonationCampaignStatus.ACTIVE, campaign.getStatus());
    verify(client.getHttpClient())
        .request(
            String.format(
                "https://management-test.adyen.com/v%s/companies/YOUR_COMPANY_ID/campaignManagement/DC123456789/status/activate",
                DonationCampaignsApi.API_VERSION),
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  // Non-breaking: new PaymentMethod.associatedPaymentMethods field deserializes.
  @Test
  public void paymentMethodAssociatedPaymentMethods() throws IOException {
    String json =
        "{\"type\":\"visa\",\"associatedPaymentMethods\":"
            + "[{\"id\":\"PM123\",\"type\":\"cartebancaire\",\"enabled\":true}]}";

    PaymentMethod parsed = PaymentMethod.fromJson(json);

    assertNotNull(parsed.getAssociatedPaymentMethods());
    assertEquals(1, parsed.getAssociatedPaymentMethods().size());
    AssociatedPaymentMethod associated = parsed.getAssociatedPaymentMethods().get(0);
    assertEquals("PM123", associated.getId());
    assertEquals("cartebancaire", associated.getType());
    assertTrue(associated.getEnabled());
  }

  // Non-breaking: new Surcharge.disclosureOnPresentCard field round-trips.
  @Test
  public void surchargeDisclosureOnPresentCard() throws IOException {
    Surcharge surcharge = new Surcharge().disclosureOnPresentCard(true);

    Surcharge parsed = Surcharge.fromJson(surcharge.toJson());

    assertTrue(parsed.getDisclosureOnPresentCard());
  }

  // Non-breaking: new SplitConfigurationLogic.dcc field (SplitDcc) round-trips.
  @Test
  public void splitConfigurationLogicDcc() throws IOException {
    SplitConfigurationLogic logic =
        new SplitConfigurationLogic().dcc(new SplitDcc().accountHolderPercentage(50L));

    SplitConfigurationLogic parsed = SplitConfigurationLogic.fromJson(logic.toJson());

    assertNotNull(parsed.getDcc());
    assertEquals(Long.valueOf(50L), parsed.getDcc().getAccountHolderPercentage());
  }

  // Value rename: MealVoucherFRInfo.subTypes allowed value is mealVoucher_FR_endenred per the
  // Management v3 spec. Verifies the documented value round-trips.
  @Test
  public void mealVoucherFRInfoSubTypes() throws IOException {
    MealVoucherFRInfo info =
        new MealVoucherFRInfo()
            .conecsId("123456")
            .siret("12345678901234")
            .addSubTypesItem("mealVoucher_FR_endenred");

    MealVoucherFRInfo parsed = MealVoucherFRInfo.fromJson(info.toJson());

    assertNotNull(parsed.getSubTypes());
    assertEquals("mealVoucher_FR_endenred", parsed.getSubTypes().get(0));
  }

  @Test
  @Disabled("Integration test")
  public void me() throws IOException, ApiException {
    Client client = new Client(System.getenv("API_KEY"), Environment.TEST);
    MyApiCredentialApi service = new MyApiCredentialApi(client);

    MeApiCredential me = service.getApiCredentialDetails();

    assertTrue(me.getActive());
  }
}
