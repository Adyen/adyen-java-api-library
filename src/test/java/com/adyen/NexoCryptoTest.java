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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.adyen.model.nexo.MessageHeader;
import com.adyen.model.terminal.TerminalAPIRequest;
import com.adyen.model.terminal.security.SaleToPOISecuredMessage;
import com.adyen.model.terminal.security.SecurityKey;
import com.adyen.security.NexoCrypto;
import com.adyen.security.exception.InvalidSecurityKeyException;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.datatype.DatatypeConfigurationException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests for Nexo encryption/decryption
 */
public class NexoCryptoTest extends BaseTest {

    private static SecurityKey testSecurityKey;

    @BeforeClass
    public static void setUp() {
        testSecurityKey = new SecurityKey();
        testSecurityKey.setKeyVersion(1);
        testSecurityKey.setAdyenCryptoVersion(1);
        testSecurityKey.setKeyIdentifier("CryptoKeyIdentifier12345");
        testSecurityKey.setPassphrase("p@ssw0rd123456");
    }

    @Test
    public void testEncryption() throws Exception {
        TerminalAPIRequest terminalAPIRequest = createTerminalAPIPaymentRequest();
        MessageHeader messageHeader = terminalAPIRequest.getSaleToPOIRequest().getMessageHeader();
        String requestJson = PRETTY_PRINT_GSON.toJson(terminalAPIRequest);

        NexoCrypto nexoCrypto = new NexoCrypto();

        SaleToPOISecuredMessage encryptedMessage = nexoCrypto.encrypt(requestJson, messageHeader, testSecurityKey);
        assertNotNull(encryptedMessage);
        assertNotNull(encryptedMessage.getNexoBlob());
        assertNotNull(encryptedMessage.getMessageHeader());
        assertNotNull(encryptedMessage.getSecurityTrailer());
    }

    @Test
    public void testDecryption() throws Exception {
        TerminalAPIRequest terminalAPIRequest = createTerminalAPIPaymentRequest();
        MessageHeader messageHeader = terminalAPIRequest.getSaleToPOIRequest().getMessageHeader();
        String requestJson = PRETTY_PRINT_GSON.toJson(terminalAPIRequest);

        NexoCrypto nexoCrypto = new NexoCrypto();

        SaleToPOISecuredMessage encryptedMessage = nexoCrypto.encrypt(requestJson, messageHeader, testSecurityKey);
        String decryptedMessage = nexoCrypto.decrypt(encryptedMessage, testSecurityKey);
        assertNotNull(decryptedMessage);
        assertEquals(requestJson, decryptedMessage);
    }

    @Test(expected = InvalidSecurityKeyException.class)
    public void testEncryptionWithInvalidSecurityKey() throws Exception {
        TerminalAPIRequest terminalAPIRequest = createTerminalAPIPaymentRequest();
        MessageHeader messageHeader = terminalAPIRequest.getSaleToPOIRequest().getMessageHeader();
        String requestJson = PRETTY_PRINT_GSON.toJson(terminalAPIRequest);

        new NexoCrypto().encrypt(requestJson, messageHeader, new SecurityKey());
    }
}
