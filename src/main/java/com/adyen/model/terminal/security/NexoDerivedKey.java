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

package com.adyen.model.terminal.security;

/**
 * A container for Nexo derived keys
 *
 * Nexo derived keys is a 80 byte struct containing key data:
 * a 32 byte cipher key, a 32 byte HMAC key and a 16 byte initialization vector (IV).
 * These 80 bytes are derived from a passphrase.
 */
public class NexoDerivedKey {

    public static final int NEXO_HMAC_KEY_LENGTH = 32;
    public static final int NEXO_CIPHER_KEY_LENGTH = 32;
    public static final int NEXO_IV_LENGTH = 16;

    private byte[] hmacKey;
    private byte[] cipherKey;
    private byte[] iv;

    public NexoDerivedKey() {
        hmacKey = new byte[NEXO_HMAC_KEY_LENGTH];
        cipherKey = new byte[NEXO_CIPHER_KEY_LENGTH];
        iv = new byte[NEXO_IV_LENGTH];
    }

    public byte[] getHmacKey() {
        return hmacKey;
    }

    public void setHmacKey(byte[] hmacKey) {
        this.hmacKey = hmacKey;
    }

    public byte[] getCipherKey() {
        return cipherKey;
    }

    public void setCipherKey(byte[] cipherKey) {
        this.cipherKey = cipherKey;
    }

    public byte[] getIv() {
        return iv;
    }

    public void setIv(byte[] iv) {
        this.iv = iv;
    }
}
