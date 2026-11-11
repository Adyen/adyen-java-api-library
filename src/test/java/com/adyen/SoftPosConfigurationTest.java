package com.adyen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;

import com.adyen.constants.ApiConstants;
import com.adyen.model.softposconfiguration.CertificateLoadingRequest;
import com.adyen.model.softposconfiguration.CertificateLoadingResponse;
import com.adyen.model.softposconfiguration.JSON;
import com.adyen.model.softposconfiguration.SubMerchantData;
import com.adyen.service.softposconfiguration.SessionAuthenticationApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;

public class SoftPosConfigurationTest extends BaseTest {

  private static final String REQUEST_FILE =
      "mocks/softposconfiguration/certificate-loading-request.json";
  private static final String RESPONSE_FILE =
      "mocks/softposconfiguration/certificate-loading-response.json";

  @Test
  void testRequestSerialization() throws JsonProcessingException {
    assertJsonEquals(getFileContents(REQUEST_FILE), createRequest().toJson());
  }

  @Test
  void testRequestDeserialization() throws JsonProcessingException {
    CertificateLoadingRequest request =
        CertificateLoadingRequest.fromJson(getFileContents(REQUEST_FILE));

    assertNotNull(request);
    assertEquals("YOUR_MERCHANT_ACCOUNT", request.getMerchantAccount());
    assertEquals("test-setup-token", request.getSetupToken());
    assertEquals("YOUR_STORE", request.getStore());
    assertEquals(createSubMerchantData(), request.getSubMerchantData());
  }

  @Test
  void testResponseSerialization() throws JsonProcessingException {
    CertificateLoadingResponse response =
        new CertificateLoadingResponse()
            .id("test-session-id")
            .installationId("test-installation-id")
            .merchantAccount("YOUR_MERCHANT_ACCOUNT")
            .sdkData("test-sdk-data")
            .store("YOUR_STORE");

    assertJsonEquals(getFileContents(RESPONSE_FILE), response.toJson());
  }

  @Test
  void testResponseDeserialization() throws JsonProcessingException {
    assertResponse(CertificateLoadingResponse.fromJson(getFileContents(RESPONSE_FILE)));
  }

  @Test
  void testUnsetFieldsAreOmittedEvenWhenNullValuesAreEnabled() throws JsonProcessingException {
    assertJsonEquals("{}", new CertificateLoadingRequest().toJson());
    assertJsonEquals("{}", new CertificateLoadingResponse().toJson());
    assertJsonEquals("{}", new CertificateLoadingRequest().includeNullValues(true).toJson());
    assertJsonEquals("{}", new CertificateLoadingResponse().includeNullValues(true).toJson());
  }

  @Test
  void testExplicitNullFieldsAreOmittedByDefault() throws JsonProcessingException {
    CertificateLoadingRequest request =
        new CertificateLoadingRequest()
            .merchantAccount("YOUR_MERCHANT_ACCOUNT")
            .setupToken(null)
            .store(null)
            .subMerchantData(null);
    CertificateLoadingResponse response =
        new CertificateLoadingResponse()
            .id("test-session-id")
            .installationId(null)
            .merchantAccount(null)
            .sdkData(null)
            .store(null);

    assertJsonEquals("{\"merchantAccount\":\"YOUR_MERCHANT_ACCOUNT\"}", request.toJson());
    assertJsonEquals("{\"id\":\"test-session-id\"}", response.toJson());
  }

  @Test
  void testExplicitNullFieldsAreSerializedWhenEnabled() throws JsonProcessingException {
    CertificateLoadingRequest request =
        new CertificateLoadingRequest()
            .merchantAccount("YOUR_MERCHANT_ACCOUNT")
            .setupToken(null)
            .store(null)
            .subMerchantData(null)
            .includeNullValues(true);
    CertificateLoadingResponse response =
        new CertificateLoadingResponse()
            .id("test-session-id")
            .includeNullValues(true)
            .installationId(null)
            .merchantAccount(null)
            .sdkData(null)
            .store(null);

    assertJsonEquals(
        "{\"merchantAccount\":\"YOUR_MERCHANT_ACCOUNT\","
            + "\"setupToken\":null,\"store\":null,\"subMerchantData\":null}",
        request.toJson());
    assertJsonEquals(
        "{\"id\":\"test-session-id\",\"installationId\":null,"
            + "\"merchantAccount\":null,\"sdkData\":null,\"store\":null}",
        response.toJson());
  }

  @Test
  void testNestedNullFieldsAreControlledByNestedModel() throws JsonProcessingException {
    SubMerchantData subMerchantData = new SubMerchantData().id("test-sub-merchant-id").city(null);
    CertificateLoadingRequest request =
        new CertificateLoadingRequest().subMerchantData(subMerchantData).includeNullValues(true);

    assertJsonEquals("{\"subMerchantData\":{\"id\":\"test-sub-merchant-id\"}}", request.toJson());

    subMerchantData.includeNullValues(true);

    assertJsonEquals(
        "{\"subMerchantData\":{\"id\":\"test-sub-merchant-id\",\"city\":null}}", request.toJson());
  }

  @ParameterizedTest
  @ValueSource(
      strings = {
        "{}",
        "{\"merchantAccount\":null,\"setupToken\":null,\"store\":null,\"subMerchantData\":null}"
      })
  void testRequestDeserializationWithMissingOrNullFields(String json)
      throws JsonProcessingException {
    CertificateLoadingRequest request = CertificateLoadingRequest.fromJson(json);

    assertNotNull(request);
    assertNull(request.getMerchantAccount());
    assertNull(request.getSetupToken());
    assertNull(request.getStore());
    assertNull(request.getSubMerchantData());
  }

  @ParameterizedTest
  @ValueSource(
      strings = {
        "{}",
        "{\"id\":null,\"installationId\":null,\"merchantAccount\":null,\"sdkData\":null,\"store\":null}"
      })
  void testResponseDeserializationWithMissingOrNullFields(String json)
      throws JsonProcessingException {
    CertificateLoadingResponse response = CertificateLoadingResponse.fromJson(json);

    assertNotNull(response);
    assertNull(response.getId());
    assertNull(response.getInstallationId());
    assertNull(response.getMerchantAccount());
    assertNull(response.getSdkData());
    assertNull(response.getStore());
  }

  @Test
  void testIssueCertificates() throws Exception {
    Client client = createMockClientFromFile(RESPONSE_FILE);
    SessionAuthenticationApi api = new SessionAuthenticationApi(client);

    CertificateLoadingResponse response = api.issueCertificates(createRequest());

    assertResponse(response);
    ArgumentCaptor<String> bodyCaptor = ArgumentCaptor.forClass(String.class);
    verify(client.getHttpClient())
        .request(
            eq("https://softposconfig-test.adyen.com/softposconfig/v3/auth/certificate"),
            bodyCaptor.capture(),
            eq(client.getConfig()),
            eq(false),
            isNull(),
            eq(ApiConstants.HttpMethod.POST),
            isNull());
    assertJsonEquals(getFileContents(REQUEST_FILE), bodyCaptor.getValue());
  }

  private CertificateLoadingRequest createRequest() {
    return new CertificateLoadingRequest()
        .merchantAccount("YOUR_MERCHANT_ACCOUNT")
        .setupToken("test-setup-token")
        .store("YOUR_STORE")
        .subMerchantData(createSubMerchantData());
  }

  private SubMerchantData createSubMerchantData() {
    return new SubMerchantData()
        .city("Test City")
        .country("NL")
        .displayName("Test Shop")
        .email("shop@example.com")
        .id("test-sub-merchant-id")
        .mcc("5411")
        .name("Test Merchant")
        .phoneNumber("+31000000000")
        .postalCode("1000AA")
        .state("Test State")
        .street("Test Street 1")
        .taxId("test-tax-id");
  }

  private void assertResponse(CertificateLoadingResponse response) {
    assertNotNull(response);
    assertEquals("test-session-id", response.getId());
    assertEquals("test-installation-id", response.getInstallationId());
    assertEquals("YOUR_MERCHANT_ACCOUNT", response.getMerchantAccount());
    assertEquals("test-sdk-data", response.getSdkData());
    assertEquals("YOUR_STORE", response.getStore());
  }

  private void assertJsonEquals(String expected, String actual) throws JsonProcessingException {
    assertEquals(JSON.getMapper().readTree(expected), JSON.getMapper().readTree(actual));
  }
}
