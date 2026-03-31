package com.adyen;

import static org.junit.jupiter.api.Assertions.*;

import com.adyen.enums.Environment;
import com.adyen.enums.Region;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Tests for {@link Service#createBaseURL(String)}. */
public class ServiceTest extends BaseTest {

  private Config config;
  private Service service;

  @BeforeEach
  public void setUp() {
    config = new Config().environment(Environment.LIVE);
    Client client = new Client(config);
    service = new Service(client);
  }

  @Test
  public void testCreateBaseURLForTestEnvironment() {
    config.setEnvironment(Environment.TEST);
    String liveUrl = "https://balanceplatform-api-live.adyen.com/bcl/v2/balanceAccounts";
    String expectedUrl = "https://balanceplatform-api-test.adyen.com/bcl/v2/balanceAccounts";

    String actualUrl = service.createBaseURL(liveUrl);
    // verify Live url is converted to Test url
    assertEquals(expectedUrl, actualUrl);
  }

  @Test
  public void testCreateBaseURLForLiveEnvironment() {

    String testUrl = "https://balanceplatform-api-test.adyen.com/bcl/v2/balanceAccounts";
    String expectedUrl = "https://balanceplatform-api-live.adyen.com/bcl/v2/balanceAccounts";

    String actualUrl = service.createBaseURL(testUrl);
    // verify Test url is converted to Live url
    assertEquals(expectedUrl, actualUrl);
  }

  @Test
  public void testLivePalUrlWithPrefix() {

    config.setLiveEndpointUrlPrefix("123456789-company");
    String testUrl = "https://pal-test.adyen.com/pal/servlet/v52/initiate";
    String expectedUrl =
        "https://123456789-company-pal-live.adyenpayments.com/pal/servlet/v52/initiate";

    String actualUrl = service.createBaseURL(testUrl);
    assertEquals(expectedUrl, actualUrl);
  }

  @Test
  public void testLivePalUrlWithoutPrefix() {
    String testUrl = "https://pal-test.adyen.com/pal/servlet/v52/initiate";

    IllegalArgumentException e =
        assertThrows(IllegalArgumentException.class, () -> service.createBaseURL(testUrl));
    assertEquals("please provide a live url prefix in the client", e.getMessage());
  }

  @Test
  public void testLiveCheckoutUrlWithPrefix() {
    config.setLiveEndpointUrlPrefix("123456789-company");
    String testUrl = "https://checkout-test.adyen.com/v68/payments";
    String expectedUrl =
        "https://123456789-company-checkout-live.adyenpayments.com/checkout/v68/payments";

    String actualUrl = service.createBaseURL(testUrl);
    assertEquals(expectedUrl, actualUrl);
  }

  @Test
  public void testLiveCheckoutUrlWithoutPrefix() {
    String testUrl = "https://checkout-test.adyen.com/v68/payments";

    IllegalArgumentException e =
        assertThrows(IllegalArgumentException.class, () -> service.createBaseURL(testUrl));
    assertEquals("please provide a live url prefix in the client", e.getMessage());
  }

  @Test
  public void testLiveCheckoutPosSdkUrlWithPrefix() {
    config.setLiveEndpointUrlPrefix("123456789-company");
    String testUrl = "https://checkout-test.adyen.com/possdk/v68/sessions";
    String expectedUrl =
        "https://123456789-company-checkout-live.adyenpayments.com/possdk/v68/sessions";

    String actualUrl = service.createBaseURL(testUrl);
    assertEquals(expectedUrl, actualUrl);
  }

  @Test
  public void testSessionAuthenticationLiveUrl() {
    String testUrl = "https://test.adyen.com/authe/api/v1";
    String expectedUrl = "https://authe-live.adyen.com/authe/api/v1";

    String actualUrl = service.createBaseURL(testUrl);
    assertEquals(expectedUrl, actualUrl);
  }

  @Test
  public void testLiveRecurringUrlWithPrefix() {

    config.setLiveEndpointUrlPrefix("123456789-company");
    String testUrl = "https://paltokenization-test.adyen.com/paltokenization/servlet/Recurring/v68";
    String expectedUrl =
        "https://123456789-company-paltokenization-live.adyenpayments.com/paltokenization/servlet/Recurring/v68";

    String actualUrl = service.createBaseURL(testUrl);
    assertEquals(expectedUrl, actualUrl);
  }

  @Test
  public void testLiveRecurringUrlWithoutPrefix() {
    String testUrl = "https://paltokenization-test.adyen.com/paltokenization/servlet/Recurring/v68";

    IllegalArgumentException e =
        assertThrows(IllegalArgumentException.class, () -> service.createBaseURL(testUrl));
    assertEquals("please provide a live url prefix in the client", e.getMessage());
  }

  @Test
  public void testDeviceApiTestEnvironment() {
    config.setEnvironment(Environment.TEST);
    String testUrl = "https://device-api-test.adyen.com/device/v1";

    String actualUrl = service.createBaseURL(testUrl);
    assertEquals(testUrl, actualUrl);
  }

  static Stream<Arguments> deviceApiRegionToLiveUrl() {
    return Stream.of(
        Arguments.of(null, "https://device-api-live.adyen.com/device/v1"),
        Arguments.of(Region.EU, "https://device-api-live.adyen.com/device/v1"),
        Arguments.of(Region.AU, "https://device-api-live-au.adyen.com/device/v1"),
        Arguments.of(Region.US, "https://device-api-live-us.adyen.com/device/v1"),
        Arguments.of(Region.APSE, "https://device-api-live-apse.adyen.com/device/v1"));
  }

  @ParameterizedTest
  @MethodSource("deviceApiRegionToLiveUrl")
  public void testDeviceApiLiveUrlPerRegion(Region region, String expectedUrl) {
    config.setTerminalApiRegion(region);
    String testUrl = "https://device-api-test.adyen.com/device/v1";

    String actualUrl = service.createBaseURL(testUrl);
    assertEquals(expectedUrl, actualUrl);
  }

  @Test
  public void testDeviceApiCustomDomainFallsBackToGenericReplacement() {
    String testUrl = "https://my-proxy-test.example.com/device-api-v1/path";
    String expectedUrl = "https://my-proxy-live.example.com/device-api-v1/path";

    String actualUrl = service.createBaseURL(testUrl);
    assertEquals(expectedUrl, actualUrl);
  }
}
