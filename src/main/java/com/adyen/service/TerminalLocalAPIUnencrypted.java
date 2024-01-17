package com.adyen.service;

import com.adyen.Client;
import com.adyen.Config;
import com.adyen.Service;
import com.adyen.enums.Environment;
import com.adyen.httpclient.TerminalLocalAPIHostnameVerifier;

import com.adyen.terminal.TerminalAPIRequest;
import com.adyen.terminal.TerminalAPIResponse;
import com.adyen.service.resource.terminal.local.LocalRequest;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * [UNENCRYPTED] Local Terminal Api.
 * Use this class (in TEST only) to experiment with the Local Terminal API separately
 * from the encryption implementation required for live payments.
 * <p>
 * Be sure to remove the encryption key details on the Customer Area as it will not work with encryption key details set up.
 */
public class TerminalLocalAPIUnencrypted extends Service {

    private final LocalRequest localRequest;

    public TerminalLocalAPIUnencrypted(Client client) {
        super(client);
        if (client.getConfig().getEnvironment() == Environment.LIVE) {
            throw new IllegalArgumentException("Cannot use this class in a Live environment");
        }
        Config config = super.getClient().getConfig();
        config.setHostnameVerifier(new TerminalLocalAPIHostnameVerifier(Environment.TEST));
        if (config.getSSLContext() == null) {
            config.setSSLContext(createTrustSSLContext());
            super.getClient().setConfig(config);
        }
        localRequest = new LocalRequest(this);
    }

    /**
     * Local Terminal API call
     *
     * @param terminalAPIRequest TerminalAPIRequest
     * @return TerminalAPIResponse
     * @throws Exception exception
     */
    public TerminalAPIResponse request(TerminalAPIRequest terminalAPIRequest) throws Exception {
        String jsonRequest = terminalAPIRequest.toJson();

        String jsonResponse = localRequest.request(jsonRequest);

        if (jsonResponse == null || jsonResponse.isEmpty() || "ok".equals(jsonResponse)) {
            return null;
        }

        return TerminalAPIResponse.fromJson(jsonResponse);
    }

    private SSLContext createTrustSSLContext() {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    @Override
                    public void checkClientTrusted(X509Certificate[] arg0, String arg1)
                            throws CertificateException {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] arg0, String arg1)
                            throws CertificateException {
                    }

                }
        };
        SSLContext sc = null;
        try {
            sc = SSLContext.getInstance("SSL");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            assert sc != null;
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return sc;
    }
}
