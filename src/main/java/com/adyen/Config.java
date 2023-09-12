package com.adyen;

import com.adyen.enums.Environment;
import com.adyen.util.CertificateUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class Config {
    protected String username;
    protected String password;
    protected Environment environment;

    /**
     * Application name: used as HTTP client User-Agent
     */
    protected String applicationName;
    protected String apiKey;
    protected int connectionTimeoutMillis;
    protected int readTimeoutMillis;

    //Terminal API Specific
    protected String terminalApiCloudEndpoint;
    protected String terminalApiLocalEndpoint;
    protected Certificate terminalCertificate;

    // Client certificate authentication
    protected KeyStore trustKeyStore;
    protected KeyStore clientKeyStore;
    protected String clientKeyStorePassword;
    protected String liveEndpointUrlPrefix;

    public Config() {
        // do nothing
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getTerminalApiCloudEndpoint() {
        return terminalApiCloudEndpoint;
    }

    public void setTerminalApiCloudEndpoint(String terminalApiCloudEndpoint) {
        this.terminalApiCloudEndpoint = terminalApiCloudEndpoint;
    }

    public String getTerminalApiLocalEndpoint() {
        return terminalApiLocalEndpoint;
    }

    public void setTerminalApiLocalEndpoint(String terminalApiLocalEndpoint) {
        this.terminalApiLocalEndpoint = terminalApiLocalEndpoint;
    }

    public int getConnectionTimeoutMillis() {
        return connectionTimeoutMillis;
    }

    public void setConnectionTimeoutMillis(int connectionTimeoutMillis) {
        this.connectionTimeoutMillis = connectionTimeoutMillis;
    }

    public int getReadTimeoutMillis() {
        return readTimeoutMillis;
    }

    public void setReadTimeoutMillis(int readTimeoutMillis) {
        this.readTimeoutMillis = readTimeoutMillis;
    }

    public Certificate getTerminalCertificate() {
        return terminalCertificate;
    }

    public void setTerminalCertificate(Certificate terminalCertificate) {
        this.terminalCertificate = terminalCertificate;
    }

    public void setTerminalCertificate(String terminalCertificatePath) throws FileNotFoundException, CertificateException {
        this.terminalCertificate = CertificateUtil.loadCertificate(terminalCertificatePath);
    }

    public void setTerminalCertificate(InputStream terminalCertificateStream) throws CertificateException {
        this.terminalCertificate = CertificateUtil.loadCertificate(terminalCertificateStream);
    }

       public KeyStore getTrustKeyStore() {
        return trustKeyStore;
    }

    public void setTrustKeyStore(KeyStore trustKeyStore) {
        this.trustKeyStore = trustKeyStore;
    }

    public void setTrustKeyStore(String trustKeyStorePath, String keyStoreType, String password) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        this.trustKeyStore = CertificateUtil.loadKeyStore(trustKeyStorePath, keyStoreType, password);
    }

    public KeyStore getClientKeyStore() {
        return clientKeyStore;
    }

    public void setClientKeyStore(KeyStore clientKeyStore) {
        this.clientKeyStore = clientKeyStore;
    }

    public void setClientKeyStore(String clientKeyStorePath, String keyStoreType, String clientKeyStorePassword) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        this.clientKeyStorePassword = clientKeyStorePassword;
        this.clientKeyStore = CertificateUtil.loadKeyStore(clientKeyStorePath, keyStoreType, clientKeyStorePassword);
    }

    public String getClientKeyStorePassword() {
        return clientKeyStorePassword;
    }

    public void setClientKeyStorePassword(String clientKeyStorePassword) {
        this.clientKeyStorePassword = clientKeyStorePassword;
    }

    public String getLiveEndpointUrlPrefix() {
        return this.liveEndpointUrlPrefix;
    }
    public void setLiveEndpointUrlPrefix(String liveEndpointUrlPrefix) {
        this.liveEndpointUrlPrefix = liveEndpointUrlPrefix;
    }
}
