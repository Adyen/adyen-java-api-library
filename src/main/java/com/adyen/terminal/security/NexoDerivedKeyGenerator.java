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

import com.adyen.model.terminal.security.NexoDerivedKey;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

import static com.adyen.model.terminal.security.NexoDerivedKey.NEXO_CIPHER_KEY_LENGTH;
import static com.adyen.model.terminal.security.NexoDerivedKey.NEXO_HMAC_KEY_LENGTH;
import static com.adyen.model.terminal.security.NexoDerivedKey.NEXO_IV_LENGTH;

final class NexoDerivedKeyGenerator {

    private NexoDerivedKeyGenerator() {
    }

    /**
     * Given a passphrase, compute 80 byte key of key material according to crypto.md
     */
    static NexoDerivedKey deriveKeyMaterial(String passphrase)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = "AdyenNexoV1Salt".getBytes();
        int iterations = 4000;

        PBEKeySpec spec = new PBEKeySpec(
                passphrase.toCharArray(), salt, iterations, (NEXO_CIPHER_KEY_LENGTH + NEXO_HMAC_KEY_LENGTH + NEXO_IV_LENGTH) * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] key = skf.generateSecret(spec).getEncoded();

        return readKeyData(key);
    }

    /**
     * Read a key material file of 80 bytes, splitting it in the hmacKey, cipherKey and iv
     */
    private static NexoDerivedKey readKeyData(byte[] key) {
        NexoDerivedKey nexoDerivedKey = new NexoDerivedKey();

        nexoDerivedKey.setHmacKey(Arrays.copyOfRange(key, 0, NEXO_HMAC_KEY_LENGTH));
        nexoDerivedKey.setCipherKey(Arrays.copyOfRange(key, NEXO_HMAC_KEY_LENGTH, NEXO_HMAC_KEY_LENGTH + NEXO_CIPHER_KEY_LENGTH));
        nexoDerivedKey.setIv(Arrays.copyOfRange(key, NEXO_HMAC_KEY_LENGTH + NEXO_CIPHER_KEY_LENGTH, NEXO_CIPHER_KEY_LENGTH + NEXO_HMAC_KEY_LENGTH + NEXO_IV_LENGTH));

        return nexoDerivedKey;
    }
}
