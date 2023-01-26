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


import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Objects;

public class SecurityTrailer {
    @SerializedName("AdyenCryptoVersion")
    private Integer adyenCryptoVersion;

    @SerializedName("KeyIdentifier")
    private String keyIdentifier;

    @SerializedName("KeyVersion")
    private Integer keyVersion;

    @SerializedName("Nonce")
    private byte[] nonce;

    @SerializedName("Hmac")
    private byte[] hmac;

    public Integer getAdyenCryptoVersion() {
        return adyenCryptoVersion;
    }

    public void setAdyenCryptoVersion(Integer adyenCryptoVersion) {
        this.adyenCryptoVersion = adyenCryptoVersion;
    }

    public String getKeyIdentifier() {
        return keyIdentifier;
    }

    public void setKeyIdentifier(String keyIdentifier) {
        this.keyIdentifier = keyIdentifier;
    }

    public Integer getKeyVersion() {
        return keyVersion;
    }

    public void setKeyVersion(Integer keyVersion) {
        this.keyVersion = keyVersion;
    }

    public byte[] getNonce() {
        return nonce;
    }

    public void setNonce(byte[] nonce) {
        this.nonce = nonce;
    }

    public byte[] getHmac() {
        return hmac;
    }

    public void setHmac(byte[] hmac) {
        this.hmac = hmac;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SecurityTrailer that = (SecurityTrailer) o;
        return adyenCryptoVersion.equals(that.adyenCryptoVersion) &&
                keyIdentifier.equals(that.keyIdentifier) &&
                keyVersion.equals(that.keyVersion) &&
                Arrays.equals(nonce, that.nonce) &&
                Arrays.equals(hmac, that.hmac);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(adyenCryptoVersion, keyIdentifier, keyVersion);
        result = 31 * result + Arrays.hashCode(nonce);
        result = 31 * result + Arrays.hashCode(hmac);
        return result;
    }

    @Override
    public String toString() {
        return "SecurityTrailer{" +
                "adyenCryptoVersion=" + adyenCryptoVersion +
                ", keyIdentifier='" + keyIdentifier + '\'' +
                ", keyVersion=" + keyVersion +
                ", nonce=" + Arrays.toString(nonce) +
                ", hmac=" + Arrays.toString(hmac) +
                '}';
    }
}
