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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.applicationinfo;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

public class MerchantDevice {

    @SerializedName("os")
    private String os = null;

    @SerializedName("osVersion")
    private String osVersion = null;

    @SerializedName("reference")
    private String reference = null;

    public MerchantDevice os(String os) {
        this.os = os;
        return this;
    }


    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public MerchantDevice osVersion(String osVersion) {
        this.osVersion = osVersion;
        return this;
    }


    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public MerchantDevice reference(String reference) {
        this.reference = reference;
        return this;
    }


    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MerchantDevice merchantDevice = (MerchantDevice) o;
        return Objects.equals(this.os, merchantDevice.os) && Objects.equals(this.osVersion, merchantDevice.osVersion) && Objects.equals(this.reference, merchantDevice.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(os, osVersion, reference);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MerchantDevice {\n");

        sb.append("    os: ").append(toIndentedString(os)).append("\n");
        sb.append("    osVersion: ").append(toIndentedString(osVersion)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("}");
        return sb.toString();
    }


}