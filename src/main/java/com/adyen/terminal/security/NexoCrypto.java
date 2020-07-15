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

package com.adyen.terminal.security;

import com.adyen.model.nexo.MessageHeader;
import com.adyen.model.terminal.security.NexoDerivedKey;
import com.adyen.model.terminal.security.SaleToPOISecuredMessage;
import com.adyen.model.terminal.security.SecurityKey;
import com.adyen.model.terminal.security.SecurityTrailer;
import com.adyen.terminal.security.exception.NexoCryptoException;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import static com.adyen.model.terminal.security.NexoDerivedKey.NEXO_IV_LENGTH;

public class NexoCrypto {

    public SaleToPOISecuredMessage encrypt(
            String saleToPoiMessageJson, MessageHeader messageHeader, SecurityKey securityKey) throws Exception {
        validateSecurityKey(securityKey);

        NexoDerivedKey derivedKey = NexoDerivedKeyGenerator.deriveKeyMaterial(securityKey.getPassphrase());
        byte[] saleToPoiMessageByteArray = saleToPoiMessageJson.getBytes(StandardCharsets.US_ASCII);
        byte[] ivNonce = generateRandomIvNonce();
        byte[] encryptedSaleToPoiMessage = crypt(saleToPoiMessageByteArray, derivedKey, ivNonce, Cipher.ENCRYPT_MODE);
        byte[] encryptedSaleToPoiMessageHmac = hmac(saleToPoiMessageByteArray, derivedKey);

        SecurityTrailer securityTrailer = new SecurityTrailer();
        securityTrailer.setKeyVersion(securityKey.getKeyVersion());
        securityTrailer.setKeyIdentifier(securityKey.getKeyIdentifier());
        securityTrailer.setHmac(encryptedSaleToPoiMessageHmac);
        securityTrailer.setNonce(ivNonce);
        securityTrailer.setAdyenCryptoVersion(securityKey.getAdyenCryptoVersion());

        SaleToPOISecuredMessage saleToPoiSecuredMessage = new SaleToPOISecuredMessage();
        saleToPoiSecuredMessage.setMessageHeader(messageHeader);
        saleToPoiSecuredMessage.setNexoBlob(new String(Base64.encodeBase64(encryptedSaleToPoiMessage)));
        saleToPoiSecuredMessage.setSecurityTrailer(securityTrailer);

        return saleToPoiSecuredMessage;
    }

    public String decrypt(SaleToPOISecuredMessage saleToPoiSecuredMessage, SecurityKey securityKey) throws Exception {
        validateSecurityKey(securityKey);

        byte[] encryptedSaleToPoiMessageByteArray = Base64.decodeBase64(saleToPoiSecuredMessage.getNexoBlob().getBytes());
        NexoDerivedKey derivedKey = NexoDerivedKeyGenerator.deriveKeyMaterial(securityKey.getPassphrase());
        byte[] ivNonce = saleToPoiSecuredMessage.getSecurityTrailer().getNonce();
        byte[] decryptedSaleToPoiMessageByteArray = crypt(encryptedSaleToPoiMessageByteArray, derivedKey, ivNonce, Cipher.DECRYPT_MODE);

        byte[] receivedHmac = saleToPoiSecuredMessage.getSecurityTrailer().getHmac();
        validateHmac(receivedHmac, decryptedSaleToPoiMessageByteArray, derivedKey);

        return new String(decryptedSaleToPoiMessageByteArray, StandardCharsets.UTF_8);
    }

    private void validateSecurityKey(SecurityKey securityKey) throws NexoCryptoException {
        if (securityKey == null
                || securityKey.getPassphrase() == null
                || securityKey.getPassphrase().isEmpty()
                || securityKey.getKeyIdentifier() == null
                || securityKey.getKeyVersion() == null
                || securityKey.getAdyenCryptoVersion() == null) {
            throw new NexoCryptoException("Invalid Security Key");
        }
    }

    /**
     * Encrypt or decrypt data given a iv modifier and using the specified key
     * <p>
     * The actual iv is computed by taking the iv from the key material and xoring it with ivmod
     */
    private byte[] crypt(byte[] bytes, NexoDerivedKey dk, byte[] ivNonce, int mode)
            throws NoSuchAlgorithmException, NoSuchPaddingException,
            IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(dk.getCipherKey(), "AES");

        // xor dk.iv and the iv modifier
        byte[] iv = dk.getIv();
        byte[] actualIV = new byte[NEXO_IV_LENGTH];
        for (int i = 0; i < NEXO_IV_LENGTH; i++) {
            actualIV[i] = (byte) (iv[i] ^ ivNonce[i]);
        }

        IvParameterSpec ivParameterSpec = new IvParameterSpec(actualIV);
        cipher.init(mode, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bytes);
    }

    /**
     * Compute a hmac using the hmacKey
     */
    private byte[] hmac(byte[] bytes, NexoDerivedKey derivedKey) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec s = new SecretKeySpec(derivedKey.getHmacKey(), "HmacSHA256");

        mac.init(s);
        return mac.doFinal(bytes);
    }

    /**
     * Validate the hmac from a received message
     */
    private void validateHmac(byte[] receivedHmac, byte[] decryptedMessage, NexoDerivedKey derivedKey) throws NexoCryptoException, InvalidKeyException, NoSuchAlgorithmException {
        byte[] hmac = hmac(decryptedMessage, derivedKey);

        boolean valid = true;
        if (receivedHmac.length != hmac.length) {
            valid = false;
        }
        for (int i = 0; i < hmac.length && valid; i++) {
            if (receivedHmac[i] != hmac[i]) {
                valid = false;
                break;
            }
        }

        if (!valid) {
            throw new NexoCryptoException("Hmac validation failed");
        }
    }

    /**
     * Generate a random iv nonce
     */
    private byte[] generateRandomIvNonce() {
        byte[] ivNonce = new byte[NEXO_IV_LENGTH];
        new Random().nextBytes(ivNonce);
        return ivNonce;
    }
}
