package com.adyen;

import java.util.HashMap;

import javax.net.ssl.SSLContext;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

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
     4   Assert.assertEquals(Environment.LIVE, client.getConfig().getEnvironment());
    }

    @Test
    public void testGetCloudEndpointWithCustomEndpoint() {
        Config customConfig = new Config();
        customConfig.setEnvironment(Environment.LIVE);
        customConfig.setTerminalApiCloudEndpoint("https://terminal-api-live.adyen.com");
        Client testClient = new Client(customConfig);
        String result = testClient.getCloudEndpoint(null);
        Assert.assertEquals("https://terminal-api-live.adyen.com", result);
    }
    
    @Test
    public void testGetCloudEndpointForTestEnvironment() {
        Config testConfig = new Config();
        testConfig.setEnvironment(Environment.TEST);
        Client testClient = new Client(testConfig);
        String result = testClient.getCloudEndpoint(Region.EU);
        Assert.assertEquals("https://terminal-api-test.adyen.com", result);
    }
    
    @Test
    public void testGetCloudEndpointForLiveEnvironmentWithRegion() {
        Config liveConfig = new Config();
        liveConfig.setEnvironment(Environment.LIVE);
        Client liveClient = new Client(liveConfig);
        String result = liveClient.getCloudEndpoint(Region.AU);
        Assert.assertEquals("https://terminal-api-live-au.adyen.com", result); 
    }
    
    @Test
    public void testGetCloudEndpointForLiveEnvironmentWithDefaultRegion() {
        Config liveConfig = new Config();
        liveConfig.setEnvironment(Environment.LIVE);
        Client liveClient = new Client(liveConfig);
        String result = liveClient.getCloudEndpoint(null);
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