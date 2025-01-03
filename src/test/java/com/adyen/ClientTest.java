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
import com.adyen.enums.Region;
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

    private static Stream<Arguments> provideCloudTestEndpointTestCases() {
        return Stream.of(
            Arguments.of(null, Environment.TEST, "https://terminal-api-test.adyen.com"),
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
        testConfig.setTerminalApiRegion(region);
        Client testClient = new Client(testConfig);
        Assert.assertEquals(expectedEndpoint, testConfig.getTerminalApiCloudEndpoint());
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
        Config liveConfig = new Config();
        liveConfig.setEnvironment(Environment.LIVE);
        liveConfig.setTerminalApiRegion(region);
        Client liveClient = new Client(liveConfig);
        Assert.assertEquals(expectedEndpoint, liveConfig.getTerminalApiCloudEndpoint());
    }

    @Test
    public void testUnmappedIndiaRegionThrowsException() {
        Config config = new Config();
        config.setEnvironment(Environment.LIVE);
        config.setTerminalApiRegion(Region.IN);

        Assert.assertThrows(IllegalArgumentException.class,
                () -> new Client(config));
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
}
