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
import com.adyen.terminal.security.NexoCrypto;
import com.adyen.terminal.security.exception.NexoCryptoException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

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

        NexoCrypto nexoCrypto = new NexoCrypto(testSecurityKey);

        SaleToPOISecuredMessage encryptedMessage = nexoCrypto.encrypt(requestJson, messageHeader);
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

        NexoCrypto nexoCrypto = new NexoCrypto(testSecurityKey);

        SaleToPOISecuredMessage encryptedMessage = nexoCrypto.encrypt(requestJson, messageHeader);
        String decryptedMessage = nexoCrypto.decrypt(encryptedMessage);
        assertNotNull(decryptedMessage);
        assertEquals(requestJson, decryptedMessage);
    }

    @Test(expected = NexoCryptoException.class)
    public void testEncryptionWithInvalidSecurityKey() throws Exception {
        new NexoCrypto(new SecurityKey());
    }

    @Test(expected = NexoCryptoException.class)
    public void testDecryptionWithInvalidHmac() throws Exception {
        TerminalAPIRequest terminalAPIRequest = createTerminalAPIPaymentRequest();
        MessageHeader messageHeader = terminalAPIRequest.getSaleToPOIRequest().getMessageHeader();
        String requestJson = PRETTY_PRINT_GSON.toJson(terminalAPIRequest);

        NexoCrypto nexoCrypto = new NexoCrypto(testSecurityKey);

        SaleToPOISecuredMessage encryptedMessage = nexoCrypto.encrypt(requestJson, messageHeader);

        byte[] modifiedHmac = new byte[32];
        new Random().nextBytes(modifiedHmac);
        encryptedMessage.getSecurityTrailer().setHmac(modifiedHmac);

        nexoCrypto.decrypt(encryptedMessage);
    }
}
