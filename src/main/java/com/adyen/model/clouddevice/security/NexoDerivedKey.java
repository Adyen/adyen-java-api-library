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

package com.adyen.model.clouddevice.security;

import java.util.Arrays;

/**
 * A container for Nexo derived keys
 *
 * <p>Nexo derived keys is a 80 byte struct containing key data: a 32 byte cipher key, a 32 byte
 * HMAC key and a 16 byte initialization vector (IV). These 80 bytes are derived from a passphrase.
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NexoDerivedKey that = (NexoDerivedKey) o;
    return Arrays.equals(hmacKey, that.hmacKey)
        && Arrays.equals(cipherKey, that.cipherKey)
        && Arrays.equals(iv, that.iv);
  }

  @Override
  public int hashCode() {
    int result = Arrays.hashCode(hmacKey);
    result = 31 * result + Arrays.hashCode(cipherKey);
    result = 31 * result + Arrays.hashCode(iv);
    return result;
  }

  @Override
  public String toString() {
    return "NexoDerivedKey{"
        + "hmacKey="
        + Arrays.toString(hmacKey)
        + ", cipherKey="
        + Arrays.toString(cipherKey)
        + ", iv="
        + Arrays.toString(iv)
        + '}';
  }
}
