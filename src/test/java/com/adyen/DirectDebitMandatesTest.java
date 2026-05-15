package com.adyen;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import com.adyen.constants.ApiConstants;
import com.adyen.model.balanceplatform.*;
import com.adyen.service.balanceplatform.DirectDebitMandatesApi;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class DirectDebitMandatesTest extends BaseTest {

  @Test
  public void getMandateByIdTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/Mandate.json");
    DirectDebitMandatesApi service = new DirectDebitMandatesApi(client);

    Mandate response = service.getMandateById("MNDT000000000000000000000001");

    assertNotNull(response);
    assertEquals("MNDT000000000000000000000001", response.getId());
    assertEquals("BA000000000000000000000001", response.getBalanceAccountId());
    assertEquals("PI000000000000000000000001", response.getPaymentInstrumentId());
    assertEquals(MandateStatus.APPROVED, response.getStatus());
    assertEquals(MandateType.BACS, response.getType());
    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/bcl/v2/mandates/MNDT000000000000000000000001",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            null);
  }

  @Test
  public void getMandateCounterpartyTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/Mandate.json");
    DirectDebitMandatesApi service = new DirectDebitMandatesApi(client);

    Mandate response = service.getMandateById("MNDT000000000000000000000001");

    assertNotNull(response.getCounterparty());
    assertNotNull(response.getCounterparty().getAccountHolder());
    assertEquals("Albert Klassens", response.getCounterparty().getAccountHolder().getFullName());

    MandateAccountIdentification accountIdentification =
        response.getCounterparty().getAccountIdentification();
    assertNotNull(accountIdentification);
    assertInstanceOf(UKLocalMandateAccountIdentification.class, accountIdentification);

    UKLocalMandateAccountIdentification ukIdentification =
        (UKLocalMandateAccountIdentification) accountIdentification;
    assertEquals("ukLocal", ukIdentification.getType());
    assertEquals("10809699", ukIdentification.getAccountNumber());
    assertEquals("405081", ukIdentification.getSortCode());
  }

  @Test
  public void getListOfMandatesTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/ListMandatesResponse.json");
    DirectDebitMandatesApi service = new DirectDebitMandatesApi(client);

    ListMandatesResponse response = service.getListOfMandates();

    assertNotNull(response);
    assertNotNull(response.getMandates());
    assertEquals(1, response.getMandates().size());
    assertEquals("MNDT000000000000000000000001", response.getMandates().get(0).getId());
    assertNotNull(response.getLink());
    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/bcl/v2/mandates",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            new HashMap<>());
  }

  @Test
  public void getListOfMandatesWithQueryParamsTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/ListMandatesResponse.json");
    DirectDebitMandatesApi service = new DirectDebitMandatesApi(client);

    ListMandatesResponse response =
        service.getListOfMandates(
            "BA000000000000000000000001", "PI000000000000000000000001", null, null);

    assertNotNull(response);
    assertEquals(1, response.getMandates().size());

    ArgumentCaptor<Map<String, String>> queryParamsCaptor = ArgumentCaptor.captor();
    verify(client.getHttpClient())
        .request(
            eq("https://balanceplatform-api-test.adyen.com/bcl/v2/mandates"),
            eq(null),
            eq(client.getConfig()),
            eq(false),
            eq(null),
            eq(ApiConstants.HttpMethod.GET),
            queryParamsCaptor.capture());

    Map<String, String> queryParams = queryParamsCaptor.getValue();
    assertEquals(2, queryParams.size());
    assertEquals("BA000000000000000000000001", queryParams.get("balanceAccountId"));
    assertEquals("PI000000000000000000000001", queryParams.get("paymentInstrumentId"));
  }

  @Test
  public void getListOfMandatesWithCursorTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/ListMandatesResponse.json");
    DirectDebitMandatesApi service = new DirectDebitMandatesApi(client);

    service.getListOfMandates(null, null, "nextCursor", null);

    ArgumentCaptor<Map<String, String>> queryParamsCaptor = ArgumentCaptor.captor();
    verify(client.getHttpClient())
        .request(
            eq("https://balanceplatform-api-test.adyen.com/bcl/v2/mandates"),
            eq(null),
            eq(client.getConfig()),
            eq(false),
            eq(null),
            eq(ApiConstants.HttpMethod.GET),
            queryParamsCaptor.capture());

    Map<String, String> queryParams = queryParamsCaptor.getValue();
    assertEquals(1, queryParams.size());
    assertEquals("nextCursor", queryParamsCaptor.getValue().get("cursor"));
  }

  @Test
  public void cancelMandateTest() throws Exception {
    Client client = createMockClientFromResponse("");
    DirectDebitMandatesApi service = new DirectDebitMandatesApi(client);

    service.cancelMandate("MNDT000000000000000000000001");

    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/bcl/v2/mandates/MNDT000000000000000000000001/cancel",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  public void updateMandateTest() throws Exception {
    Client client = createMockClientFromResponse("");
    DirectDebitMandatesApi service = new DirectDebitMandatesApi(client);

    MandateUpdate request = new MandateUpdate().paymentInstrumentId("PI000000000000000000000002");
    service.updateMandate("MNDT000000000000000000000001", request);

    ArgumentCaptor<String> requestBodyCaptor = ArgumentCaptor.forClass(String.class);
    verify(client.getHttpClient())
        .request(
            eq(
                "https://balanceplatform-api-test.adyen.com/bcl/v2/mandates/MNDT000000000000000000000001"),
            requestBodyCaptor.capture(),
            eq(client.getConfig()),
            eq(false),
            eq(null),
            eq(ApiConstants.HttpMethod.PATCH),
            eq(null));

    assertEquals(request.toJson(), requestBodyCaptor.getValue());
  }
}
