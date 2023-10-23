package com.adyen.httpclient;

import com.adyen.enums.Environment;
import com.adyen.terminal.security.TerminalCommonNameValidator;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import java.security.cert.X509Certificate;

public final class TerminalLocalAPIHostnameVerifier implements HostnameVerifier {
    private final Environment environment;

    public TerminalLocalAPIHostnameVerifier(Environment environment) {
        this.environment = environment;
    }

    @Override
    public boolean verify(String hostname, SSLSession session) {
        try {
            if (session.getPeerCertificates() != null && session.getPeerCertificates().length > 0) {
                // Assume the first certificate is the leaf, since chain will be ordered, according to Java documentation:
                // https://docs.oracle.com/javase/7/docs/api/javax/net/ssl/SSLSession.html#getPeerCertificates()
                X509Certificate certificate = (X509Certificate) session.getPeerCertificates()[0];
                return TerminalCommonNameValidator.validateCertificate(certificate, environment);
            }
            return false;
        } catch (SSLPeerUnverifiedException e) {
            e.printStackTrace();
            return false;
        }
    }
}
