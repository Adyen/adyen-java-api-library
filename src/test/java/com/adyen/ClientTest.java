package com.adyen;

import java.util.HashMap;
import java.util.stream.Stream;

import javax.net.ssl.SSLContext;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.adyen.enums.Environment;
import com.adyen.enums.Regions.Region;
import com.adyen.model.RequestOptions;

public class ClientTest {

    @Mock
    private SSLContext clientCertificateAuthSSLContext;

    @Mock
    private String apiKey;

    
    @Test
    public void testConfigTestClient() {
        Config config = new Config();
        config.setEnvironment(Environment.TEST);
        config.setApiKey(apiKey);
        Client client = new Client(config);
        
        Assert.assertEquals(Environment.TEST, client.getConfig().getEnvironment());
    }
    
    @Test
    public void testConfigLiveClient() {
        Config config = new Config();
        config.setEnvironment(Environment.LIVE);
        config.setLiveEndpointUrlPrefix("prefix");
        config.setApiKey(apiKey);
        Client client = new Client(config);
        Assert.assertEquals(Environment.LIVE, client.getConfig().getEnvironment());
    }
    
    @Test
    public void testGetCloudEndpointWithCustomEndpoint() {
        Config customConfig = new Config();
        customConfig.setEnvironment(Environment.LIVE);
        customConfig.setTerminalApiCloudEndpoint("https://terminal-api-live.adyen.com");
        Client testClient = new Client(customConfig);
        String result = testClient.getCloudEndpoint(null, Environment.LIVE);
        Assert.assertEquals("https://terminal-api-live.adyen.com", result);
    }
    
    private static Stream<Arguments> provideCloudTestEndpointTestCases() {
        return Stream.of(
            Arguments.of(Region.EU, Environment.TEST, "https://terminal-api-test.adyen.com"),
            Arguments.of(Region.AU, Environment.TEST, "https://terminal-api-test.adyen.com"),
            Arguments.of(Region.US, Environment.TEST, "https://terminal-api-test.adyen.com"),
            Arguments.of(Region.APSE, Environment.TEST, "https://terminal-api-test.adyen.com")
        );
    }

    @ParameterizedTest
    @MethodSource("provideCloudTestEndpointTestCases")
    public void testGetCloudEndpointForTestEnvironment(Region region, Environment environment, String expectedEndpoint) {
        Config testConfig = new Config();
        testConfig.setEnvironment(Environment.TEST);
        Client testClient = new Client(testConfig);

        // call the method and assert the result
        String result = testClient.getCloudEndpoint(region, testConfig.getEnvironment());
        Assert.assertEquals("Unexpected endpoint for region: " + region, expectedEndpoint, result);
    }

    private static Stream<Arguments> provideCloudLiveEndpointTestCases() {
        return Stream.of(
            Arguments.of(null, Environment.LIVE, "https://terminal-api-live.adyen.com"),
            Arguments.of(Region.EU, Environment.LIVE, "https://terminal-api-live.adyen.com"),
            Arguments.of(Region.AU, Environment.LIVE, "https://terminal-api-live-au.adyen.com"),
            Arguments.of(Region.US, Environment.LIVE, "https://terminal-api-live-us.adyen.com"),
            Arguments.of(Region.APSE, Environment.LIVE, "https://terminal-api-live-apse.adyen.com")
        );
    }

    @ParameterizedTest
    @MethodSource("provideCloudLiveEndpointTestCases")
    public void testGetCloudEndpointForLiveEnvironment(Region region, Environment environment, String expectedEndpoint) {
        // Create a Config object for the LIVE environment
        Config liveConfig = new Config();
        liveConfig.setEnvironment(Environment.LIVE);
        Client liveClient = new Client(liveConfig);
        
        // call the method and assert the result
        String result = liveClient.getCloudEndpoint(region, liveConfig.getEnvironment());
        Assert.assertEquals("Unexpected endpoint for region: " + region, expectedEndpoint, result);
    }
    
    @Test
    public void testGetCloudEndpointForLiveEnvironmentWithDefaultRegion() {
        Config liveConfig = new Config();
        liveConfig.setEnvironment(Environment.LIVE);
        Client liveClient = new Client(liveConfig);
        String result = liveClient.getCloudEndpoint(null, Environment.LIVE);
        Assert.assertEquals("https://terminal-api-live.adyen.com", result);
    }

    @Test
    public void testClientCertificateAuth() {
        Client client = new Client(clientCertificateAuthSSLContext, apiKey);
        Assert.assertEquals(Environment.LIVE, client.getConfig().getEnvironment());
    }

    @Test
    public void testRequestOptionsBuilderPattern() {
        HashMap<String, String> map = new HashMap<>();
        map.put("thing", "thing");
        RequestOptions requestOptions = new RequestOptions()
                .idempotencyKey("idempotency")
                .requestedVerificationCodeHeader("headers")
                .additionalServiceHeaders(map);
        Assert.assertEquals(requestOptions.getAdditionalServiceHeaders(), map);
    }

    private void assertCommonEndpoints(Config config) {
        Assert.assertEquals(Client.TERMINAL_API_ENDPOINT_LIVE, config.getTerminalApiCloudEndpoint());
    }
}