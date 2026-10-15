package com.adyen.service.management;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import com.adyen.BaseTest;
import com.adyen.Client;
import com.adyen.constants.ApiConstants;
import com.adyen.model.management.CertificateSearchResponse;
import com.adyen.model.management.ClientCertificateRequest;
import com.adyen.model.management.ClientCertificateWithChain;
import org.junit.jupiter.api.Test;

public class ClientCertificatesCompanyLevelApiTest extends BaseTest {

  private static final String CERTIFICATES_URL =
      "https://management-test.adyen.com/v"
          + ClientCertificatesCompanyLevelApi.API_VERSION
          + "/companies/YOUR_COMPANY_ID/clientCertificates";

  @Test
  public void generateClientCertificateTest() throws Exception {
    Client client = createMockClientFromFile("mocks/management/client-certificate.json");
    ClientCertificatesCompanyLevelApi service = new ClientCertificatesCompanyLevelApi(client);
    ClientCertificateRequest request =
        new ClientCertificateRequest()
            .apiCredential("ws_356950@Company.TestCompany")
            .certificateSigningRequest("MIIBHzCBxwIBADBl");

    ClientCertificateWithChain response =
        service.generateClientCertificate("YOUR_COMPANY_ID", request);

    assertCertificate(response);
    verify(client.getHttpClient())
        .request(
            CERTIFICATES_URL,
            "{\"apiCredential\":\"ws_356950@Company.TestCompany\","
                + "\"certificateSigningRequest\":\"MIIBHzCBxwIBADBl\"}",
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  public void listClientCertificatesTest() throws Exception {
    Client client = createMockClientFromFile("mocks/management/list-client-certificates.json");
    ClientCertificatesCompanyLevelApi service = new ClientCertificatesCompanyLevelApi(client);

    CertificateSearchResponse response = service.listClientCertificates("YOUR_COMPANY_ID");

    assertEquals(1, response.getData().size());
    assertCertificate(response.getData().get(0));
    verify(client.getHttpClient())
        .request(
            CERTIFICATES_URL,
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            null);
  }

  @Test
  public void clientCertificateBytesRoundTripAsBase64Test() throws Exception {
    ClientCertificateWithChain certificate =
        new ClientCertificateWithChain()
            .leaf(new byte[] {1, 2, 3, 4})
            .addCaChainItem(new byte[] {5, 6, 7, 8});

    String json = certificate.toJson();
    ClientCertificateWithChain parsed = ClientCertificateWithChain.fromJson(json);

    assertEquals("{\"caChain\":[\"BQYHCA==\"],\"leaf\":\"AQIDBA==\"}", json);
    assertArrayEquals(new byte[] {1, 2, 3, 4}, parsed.getLeaf());
    assertArrayEquals(new byte[] {5, 6, 7, 8}, parsed.getCaChain().get(0));
  }

  // The mock encodes leaf as bytes 1-4 and the two chain entries as bytes 5-8 and 9-12.
  private static void assertCertificate(ClientCertificateWithChain certificate) {
    assertEquals("CERT4224Z223223261HZ5V4MTMZG34", certificate.getId());
    assertEquals("6f2a1b3c4d5e6f708192a3b4c5d6e7f8", certificate.getSerialNumber());
    assertEquals("CN=api-mtls-client,O=Adyen N.V.,C=NL", certificate.getSubjectDN());
    assertArrayEquals(new byte[] {1, 2, 3, 4}, certificate.getLeaf());
    assertEquals(2, certificate.getCaChain().size());
    assertArrayEquals(new byte[] {5, 6, 7, 8}, certificate.getCaChain().get(0));
    assertArrayEquals(new byte[] {9, 10, 11, 12}, certificate.getCaChain().get(1));
  }
}
