package com.adyen;

import com.adyen.enums.Environment;
import com.adyen.enums.Region;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.security.KeyStore;

public class ClientTest {

    @Mock
    private KeyStore trustStore;

    @Mock
    private KeyStore clientKeyStore;

    @Mock
    private String clientKeyStorePassword;

    @Mock
    private String apiKey;

    @Test
    public void testClientCertificateAuth() {
        Client client = new Client(trustStore, clientKeyStore, clientKeyStorePassword, apiKey, null);

        Assert.assertEquals(Environment.LIVE, client.getConfig().getEnvironment());
        Assert.assertEquals("https://checkoutcert-live-eu.adyen.com/checkout", client.getConfig().getCheckoutEndpoint());
        assertCommonEndpoints(client.getConfig());
    }

    @Test
    public void testClientCertificateAuth_AU() {
        Client client = new Client(trustStore, clientKeyStore, clientKeyStorePassword, apiKey, Region.AU);

        Assert.assertEquals(Environment.LIVE, client.getConfig().getEnvironment());
        Assert.assertEquals("https://checkoutcert-live-au.adyen.com/checkout", client.getConfig().getCheckoutEndpoint());
        assertCommonEndpoints(client.getConfig());
    }

    @Test
    public void testClientCertificateAuth_US() {
        Client client = new Client(trustStore, clientKeyStore, clientKeyStorePassword, apiKey, Region.US);

        Assert.assertEquals(Environment.LIVE, client.getConfig().getEnvironment());
        Assert.assertEquals("https://checkoutcert-live-us.adyen.com/checkout", client.getConfig().getCheckoutEndpoint());
        assertCommonEndpoints(client.getConfig());
    }

    private void assertCommonEndpoints(Config config) {
        Assert.assertEquals(Client.ENDPOINT_CERT_LIVE, config.getEndpoint());
        Assert.assertEquals(Client.MARKETPAY_ENDPOINT_LIVE, config.getMarketPayEndpoint());
        Assert.assertEquals(Client.HPP_LIVE, config.getHppEndpoint());
        Assert.assertEquals(Client.TERMINAL_API_ENDPOINT_LIVE, config.getTerminalApiCloudEndpoint());
        Assert.assertEquals(Client.POS_TERMINAL_MANAGEMENT_ENDPOINT_LIVE, config.getPosTerminalManagementApiEndpoint());
        Assert.assertEquals(Client.DATA_PROTECTION_ENDPOINT_LIVE, config.getDataProtectionEndpoint());
    }
}