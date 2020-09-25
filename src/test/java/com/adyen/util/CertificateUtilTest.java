/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class CertificateUtilTest {

    @Test
    public void testErrorLoadingCertificateFromPath() {
        Assert.assertThrows(FileNotFoundException.class, () -> CertificateUtil.loadCertificate(""));
    }

    @Test
    public void testLoadCertificateFromPath() throws FileNotFoundException, CertificateException {
        String path = getClass().getClassLoader().getResource("adyen-terminalfleet-test.pem").getPath();
        Certificate certificate = CertificateUtil.loadCertificate(path);

        Assert.assertNotNull(certificate);
    }

    @Test
    public void testLoadCertificateFromInputStream() throws CertificateException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("adyen-terminalfleet-test.pem");
        Certificate certificate = CertificateUtil.loadCertificate(stream);

        Assert.assertNotNull(certificate);
    }
}