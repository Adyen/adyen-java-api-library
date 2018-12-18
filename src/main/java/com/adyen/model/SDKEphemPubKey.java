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
package com.adyen.model;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/**
 * SDKEphemPubKey
 */
public class SDKEphemPubKey {

    @SerializedName("crv")
    private String crv = null;

    @SerializedName("kty")
    private String kty = null;

    @SerializedName("x")
    private String x = null;

    @SerializedName("y")
    private String y = null;

    public SDKEphemPubKey crv(String crv) {
        this.crv = crv;
        return this;
    }

    public String getCrv() {
        return crv;
    }

    public void setCrv(String crv) {
        this.crv = crv;
    }

    public SDKEphemPubKey kty(String kty) {
        this.kty = kty;
        return this;
    }

    public String getKty() {
        return kty;
    }

    public void setKty(String kty) {
        this.kty = kty;
    }

    public SDKEphemPubKey x(String x) {
        this.x = x;
        return this;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public SDKEphemPubKey y(String y) {
        this.y = y;
        return this;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SDKEphemPubKey sdKEphemPubKey = (SDKEphemPubKey) o;
        return Objects.equals(this.crv, sdKEphemPubKey.crv) &&
                Objects.equals(this.kty, sdKEphemPubKey.kty) &&
                Objects.equals(this.x, sdKEphemPubKey.x) &&
                Objects.equals(this.y, sdKEphemPubKey.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crv, kty, x, y);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SDKEphemPubKey {\n");

        sb.append("    crv: ").append(toIndentedString(crv)).append("\n");
        sb.append("    kty: ").append(toIndentedString(kty)).append("\n");
        sb.append("    x: ").append(toIndentedString(x)).append("\n");
        sb.append("    y: ").append(toIndentedString(y)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}



