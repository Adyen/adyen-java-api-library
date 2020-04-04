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
package com.adyen.model.binlookup;

import java.util.Arrays;
import java.util.Objects;

import com.adyen.serializer.ByteArrayToStringAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * DSPublicKeyDetail
 */

public class DSPublicKeyDetail {

    @SerializedName("brand")
    private String brand = null;

    @SerializedName("directoryServerId")
    private String directoryServerId = null;

    @SerializedName("publicKey")
    @JsonAdapter(ByteArrayToStringAdapter.class)
    private byte[] publicKey = null;

    public DSPublicKeyDetail brand(String brand) {
        this.brand = brand;
        return this;
    }


    /**
     * Card brand.
     *
     * @return brand
     **/
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public DSPublicKeyDetail directoryServerId(String directoryServerId) {
        this.directoryServerId = directoryServerId;
        return this;
    }


    /**
     * Directory Server (DS) identifier.
     *
     * @return directoryServerId
     **/
    public String getDirectoryServerId() {
        return directoryServerId;
    }

    public void setDirectoryServerId(String directoryServerId) {
        this.directoryServerId = directoryServerId;
    }

    public DSPublicKeyDetail publicKey(byte[] publicKey) {
        this.publicKey = publicKey;
        return this;
    }


    /**
     * Public key. The 3D Secure 2 SDK encrypts the device information by using the DS public key.
     *
     * @return publicKey
     **/
    public byte[] getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(byte[] publicKey) {
        this.publicKey = publicKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DSPublicKeyDetail dsPublicKeyDetail = (DSPublicKeyDetail) o;
        return Objects.equals(this.brand, dsPublicKeyDetail.brand) && Objects.equals(this.directoryServerId, dsPublicKeyDetail.directoryServerId) && Arrays.equals(this.publicKey,
                dsPublicKeyDetail.publicKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, directoryServerId, publicKey);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DSPublicKeyDetail {\n");

        sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
        sb.append("    directoryServerId: ").append(toIndentedString(directoryServerId)).append("\n");
        sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
