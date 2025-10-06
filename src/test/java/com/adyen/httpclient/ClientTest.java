package com.adyen.httpclient;

import static org.junit.Assert.*;

import com.adyen.BaseTest;
import com.adyen.Client;
import com.adyen.Config;
import com.adyen.constants.ApiConstants;
import com.adyen.enums.Environment;
import com.adyen.enums.Region;
import com.adyen.model.RequestOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import javax.net.ssl.SSLContext;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.core5.http.Header;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;

public class ClientTest extends BaseTest {

  @Mock private SSLContext clientCertificateAuthSSLContext;

  @Test
  public void testConfigTestClient() {
    Config config = new Config();
    config.setEnvironment(Environment.TEST);
    config.setApiKey("Your-X-API-KEY");
    Client client = new Client(config);
    assertEquals(Environment.TEST, client.getConfig().getEnvironment());
  }

  @Test
  public void testConfigLiveClient() {
    Config config =
        new Config()
            .environment(Environment.LIVE)
            .liveEndpointUrlPrefix("myCompany")
            .apiKey("Your-X-API-KEY");
    Client client = new Client(config);
    assertEquals(Environment.LIVE, client.getConfig().getEnvironment());
    assertEquals("myCompany", client.getConfig().getLiveEndpointUrlPrefix());
  }

  @Test
  public void testConstructorConfigLiveClient() {
    Client client = new Client("Your-X-API-KEY", Environment.LIVE, "myCompany");
    assertEquals(Environment.LIVE, client.getConfig().getEnvironment());
    assertEquals("myCompany", client.getConfig().getLiveEndpointUrlPrefix());
  }

  @Test
  public void testConfigLiveClientWithBasicAuth() {
    Client client = new Client("", "", Environment.LIVE, "myCompany");
    assertEquals(Environment.LIVE, client.getConfig().getEnvironment());
    assertEquals("myCompany", client.getConfig().getLiveEndpointUrlPrefix());
    assertNull(client.getConfig().getApiKey());
    assertNull(client.getConfig().getApplicationName());
  }

  @Test
  public void testConfigLiveClientWithBasicAuthAndApplication() {
    Client client = new Client("", "", Environment.LIVE, "myCompany", "myApplication");
    assertEquals(Environment.LIVE, client.getConfig().getEnvironment());
    assertEquals("myCompany", client.getConfig().getLiveEndpointUrlPrefix());
    assertEquals("myApplication", client.getConfig().getApplicationName());
    assertNull(client.getConfig().getApiKey());
  }

  private static Stream<Arguments> provideCloudTestEndpointTestCases() {
    return Stream.of(
        Arguments.of(null, Environment.TEST, "https://terminal-api-test.adyen.com"),
        Arguments.of(Region.EU, Environment.TEST, "https://terminal-api-test.adyen.com"),
        Arguments.of(Region.AU, Environment.TEST, "https://terminal-api-test.adyen.com"),
        Arguments.of(Region.US, Environment.TEST, "https://terminal-api-test.adyen.com"),
        Arguments.of(Region.APSE, Environment.TEST, "https://terminal-api-test.adyen.com"));
  }

  @ParameterizedTest
  @MethodSource("provideCloudTestEndpointTestCases")
  public void testGetCloudEndpointForTestEnvironment(
      Region region, Environment environment, String expectedEndpoint) {
    Config config =
        new Config().environment(environment).terminalApiRegion(region).apiKey("Your-X-API-KEY");
    Client client = new Client(config);

    assertEquals(expectedEndpoint, config.getTerminalApiCloudEndpoint());
  }

  private static Stream<Arguments> provideCloudLiveEndpointTestCases() {
    return Stream.of(
        Arguments.of(null, Environment.LIVE, "https://terminal-api-live.adyen.com"),
        Arguments.of(Region.EU, Environment.LIVE, "https://terminal-api-live.adyen.com"),
        Arguments.of(Region.AU, Environment.LIVE, "https://terminal-api-live-au.adyen.com"),
        Arguments.of(Region.US, Environment.LIVE, "https://terminal-api-live-us.adyen.com"),
        Arguments.of(Region.APSE, Environment.LIVE, "https://terminal-api-live-apse.adyen.com"));
  }

  @ParameterizedTest
  @MethodSource("provideCloudLiveEndpointTestCases")
  public void testGetCloudEndpointForLiveEnvironment(
      Region region, Environment environment, String expectedEndpoint) {
    Config config =
        new Config().environment(environment).terminalApiRegion(region).apiKey("Your-X-API-KEY");
    Client client = new Client(config);

    assertEquals(expectedEndpoint, config.getTerminalApiCloudEndpoint());
  }

  @Test
  public void testUnmappedIndiaRegionThrowsException() {
    Config config = new Config();
    config.setEnvironment(Environment.LIVE);
    config.setTerminalApiRegion(Region.IN);

    Assert.assertThrows(IllegalArgumentException.class, () -> new Client(config));
  }

  @Test
  public void testClientCertificateAuth() {
    Client client = new Client(clientCertificateAuthSSLContext, "Your-X-API-KEY");
    assertEquals(Environment.LIVE, client.getConfig().getEnvironment());
  }

  @Test
  public void testRequestOptionsBuilderPattern() {
    HashMap<String, String> map = new HashMap<>();
    map.put("thing", "thing");
    RequestOptions requestOptions =
        new RequestOptions()
            .idempotencyKey("idempotency")
            .requestedVerificationCodeHeader("headers")
            .additionalServiceHeaders(map);
    assertEquals(requestOptions.getAdditionalServiceHeaders(), map);
  }

  @Test
  public void testUserAgentWithApplicationName() throws Exception {

    AdyenHttpClient client = new AdyenHttpClient();
    HttpUriRequestBase requestWithAppName =
        client.createRequest(
            "https://chekout.adyen.com",
            "{}",
            new Config().applicationName("test-app"),
            true,
            null,
            ApiConstants.HttpMethod.POST,
            Map.of());

    Header userAgent = requestWithAppName.getFirstHeader("User-Agent");
    assertNotNull(userAgent);
    assertEquals("test-app " + Client.LIB_NAME + "/" + Client.LIB_VERSION, userAgent.getValue());
  }

  @Test
  public void testUserAgentWithoutApplicationName() throws Exception {

    AdyenHttpClient client = new AdyenHttpClient();
    HttpUriRequestBase requestWithoutAppName =
        client.createRequest(
            "https://chekout.adyen.com",
            "{}",
            new Config(),
            true,
            null,
            ApiConstants.HttpMethod.POST,
            Map.of());

    Header userAgent = requestWithoutAppName.getFirstHeader("User-Agent");
    assertNotNull(userAgent);
    assertEquals(Client.LIB_NAME + "/" + Client.LIB_VERSION, userAgent.getValue());
  }
}
