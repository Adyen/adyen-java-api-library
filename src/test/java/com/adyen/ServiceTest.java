package com.adyen;

import static org.junit.jupiter.api.Assertions.*;

import com.adyen.enums.Environment;
import com.adyen.enums.Region;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

  @Test
  public void testDeviceApiLiveUrlDefaultRegion() {
    String testUrl = "https://device-api-test.adyen.com/device/v1";
    String expectedUrl = "https://device-api-live.adyen.com/device/v1";

    String actualUrl = service.createBaseURL(testUrl);
    assertEquals(expectedUrl, actualUrl);
  }

  @Test
  public void testDeviceApiLiveUrlEuRegion() {
    config.setTerminalApiRegion(Region.EU);
    String testUrl = "https://device-api-test.adyen.com/device/v1";
    String expectedUrl = "https://device-api-live.adyen.com/device/v1";

    String actualUrl = service.createBaseURL(testUrl);
    assertEquals(expectedUrl, actualUrl);
  }

  @Test
  public void testDeviceApiLiveUrlAuRegion() {
    config.setTerminalApiRegion(Region.AU);
    String testUrl = "https://device-api-test.adyen.com/device/v1";
    String expectedUrl = "https://device-api-live-au.adyen.com/device/v1";

    String actualUrl = service.createBaseURL(testUrl);
    assertEquals(expectedUrl, actualUrl);
  }

  @Test
  public void testDeviceApiLiveUrlUsRegion() {
    config.setTerminalApiRegion(Region.US);
    String testUrl = "https://device-api-test.adyen.com/device/v1";
    String expectedUrl = "https://device-api-live-us.adyen.com/device/v1";

    String actualUrl = service.createBaseURL(testUrl);
    assertEquals(expectedUrl, actualUrl);
  }

  @Test
  public void testDeviceApiLiveUrlApseRegion() {
    config.setTerminalApiRegion(Region.APSE);
    String testUrl = "https://device-api-test.adyen.com/device/v1";
    String expectedUrl = "https://device-api-live-apse.adyen.com/device/v1";

    String actualUrl = service.createBaseURL(testUrl);
    assertEquals(expectedUrl, actualUrl);
  }
}
