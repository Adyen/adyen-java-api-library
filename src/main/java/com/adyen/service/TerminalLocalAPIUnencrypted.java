package com.adyen.service;

import com.adyen.Client;
import com.adyen.Config;
import com.adyen.Service;
import com.adyen.enums.Environment;
import com.adyen.httpclient.TerminalLocalAPIHostnameVerifier;
import com.adyen.model.terminal.TerminalAPIRequest;
import com.adyen.model.terminal.TerminalAPIResponse;
import com.adyen.service.resource.terminal.local.LocalRequest;
import com.adyen.terminal.serialization.TerminalAPIGsonBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

/**
 * WARNING: This class is intended for TESTING purposes only.
 * It must not be used in production environments.
 * This implementation is used to test unencrypted traffic over a secure channel (TLSv1.2).
 * Be sure to remove the encryption key details on the Customer Area as it will not work with encryption key details set up.
 */
public class TerminalLocalAPIUnencrypted extends Service {

    private final LocalRequest localRequest;
    private final Gson terminalApiGson;

    public TerminalLocalAPIUnencrypted(Client client) {
        super(client);

        // Restrict to TEST environment only
        if (client.getConfig().getEnvironment() == Environment.LIVE) {
            throw new IllegalStateException("This class is intended for TEST environment only.");
        }

        System.out.println("[Warning] Using TerminalLocalAPIUnencrypted for testing unencrypted traffic.");

        terminalApiGson = TerminalAPIGsonBuilder.create();
        Config config = super.getClient().getConfig();
        config.setHostnameVerifier(new TerminalLocalAPIHostnameVerifier(Environment.TEST));

        if (config.getSSLContext() == null) {
            config.setSSLContext(createTestTrustSSLContext());
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
        String jsonRequest = terminalApiGson.toJson(terminalAPIRequest);

        String jsonResponse = localRequest.request(jsonRequest);

        if (jsonResponse == null || jsonResponse.isEmpty() || "ok".equals(jsonResponse)) {
            return null;
        }

        return terminalApiGson.fromJson(jsonResponse, new TypeToken<TerminalAPIResponse>() {
        }.getType());
    }

    /**
     * Creates an SSLContext that uses TLSv1.2 and trusts all certificates.
     * For TEST environment only.
     *
     * @return SSLContext configured for testing
     */
    private SSLContext createTestTrustSSLContext() {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
        };

        try {
            // Specify TLSv1.2 for secure testing
            SSLContext sc = SSLContext.getInstance("TLSv1.2");
            sc.init(null, trustAllCerts, new SecureRandom());
            return sc;
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new RuntimeException("Failed to create test SSL context with TLSv1.2", e);
        }
    }
}