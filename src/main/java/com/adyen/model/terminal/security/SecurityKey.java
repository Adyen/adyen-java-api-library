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

import java.util.Objects;

public class SecurityKey {
    @SerializedName("passphrase")
    private String passphrase;

    @SerializedName("keyIdentifier")
    private String keyIdentifier;

    @SerializedName("keyVersion")
    private Integer keyVersion;

    @SerializedName("adyenCryptoVersion")
    private Integer adyenCryptoVersion;

    public String getPassphrase() {
        return passphrase;
    }

    public void setPassphrase(String passphrase) {
        this.passphrase = passphrase;
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

    public Integer getAdyenCryptoVersion() {
        return adyenCryptoVersion;
    }

    public void setAdyenCryptoVersion(Integer adyenCryptoVersion) {
        this.adyenCryptoVersion = adyenCryptoVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SecurityKey that = (SecurityKey) o;
        return passphrase.equals(that.passphrase) &&
                keyIdentifier.equals(that.keyIdentifier) &&
                keyVersion.equals(that.keyVersion) &&
                adyenCryptoVersion.equals(that.adyenCryptoVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passphrase, keyIdentifier, keyVersion, adyenCryptoVersion);
    }

    @Override
    public String toString() {
        return "SecurityKey{" +
                "passphrase='" + passphrase + '\'' +
                ", keyIdentifier='" + keyIdentifier + '\'' +
                ", keyVersion=" + keyVersion +
                ", adyenCryptoVersion=" + adyenCryptoVersion +
                '}';
    }
}
