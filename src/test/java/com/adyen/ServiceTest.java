package com.adyen;

import com.adyen.enums.Environment;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests for {@link Service#createBaseURL(String)}.
 */
public class ServiceTest extends BaseTest {

    private Config config;
    private Service service;

    @Before
    public void setUp() {
        config = new Config()
                .environment(Environment.LIVE);
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
        String expectedUrl = "https://123456789-company-pal-live.adyenpayments.com/pal/servlet/v52/initiate";

        String actualUrl = service.createBaseURL(testUrl);
        assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void testLivePalUrlWithoutPrefix() {
        String testUrl = "https://pal-test.adyen.com/pal/servlet/v52/initiate";
        try {
            service.createBaseURL(testUrl);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("please provide a live url prefix in the client", e.getMessage());
        }
    }

    @Test
    public void testLiveCheckoutUrlWithPrefix() {
        config.setLiveEndpointUrlPrefix("123456789-company");
        String testUrl = "https://checkout-test.adyen.com/v68/payments";
        String expectedUrl = "https://123456789-company-checkout-live.adyenpayments.com/checkout/v68/payments";

        String actualUrl = service.createBaseURL(testUrl);
        assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void testLiveCheckoutUrlWithoutPrefix() {
        String testUrl = "https://checkout-test.adyen.com/v68/payments";
        try {
            service.createBaseURL(testUrl);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("please provide a live url prefix in the client", e.getMessage());
        }
    }

    @Test
    public void testLiveCheckoutPosSdkUrlWithPrefix() {
        config.setLiveEndpointUrlPrefix("123456789-company");
        String testUrl = "https://checkout-test.adyen.com/possdk/v68/sessions";
        String expectedUrl = "https://123456789-company-checkout-live.adyenpayments.com/possdk/v68/sessions";

        String actualUrl = service.createBaseURL(testUrl);
        assertEquals(expectedUrl, actualUrl);
    }
}