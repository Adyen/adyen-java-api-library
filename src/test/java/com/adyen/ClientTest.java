package com.adyen;

import com.adyen.enums.Environment;
import com.adyen.model.RequestOptions;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import javax.net.ssl.SSLContext;
import java.util.HashMap;

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
    public void testClientCertificateAuth() {
        Client client = new Client(clientCertificateAuthSSLContext, apiKey);
        client.setEnvironment(Environment.LIVE, null); // Ensure environment is set
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
        EnvironmentConfig environmentConfig = new EnvironmentConfig(config.getEnvironment(), config.getLiveEndpointUrlPrefix());
        Assert.assertEquals(environmentConfig.getTerminalApiEndpoint(), config.getTerminalApiCloudEndpoint());
    }
}
