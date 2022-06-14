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
 * Copyright (c) 2022 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 *
 */

package com.adyen.model.checkout;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

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

    /**
     * The &#x60;crv&#x60; value as received from the 3D Secure 2 SDK.
     * @return crv
     **/
    @Schema(description = "The `crv` value as received from the 3D Secure 2 SDK.")
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

    /**
     * The &#x60;kty&#x60; value as received from the 3D Secure 2 SDK.
     * @return kty
     **/
    @Schema(description = "The `kty` value as received from the 3D Secure 2 SDK.")
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

    /**
     * The &#x60;x&#x60; value as received from the 3D Secure 2 SDK.
     * @return x
     **/
    @Schema(description = "The `x` value as received from the 3D Secure 2 SDK.")
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

    /**
     * The &#x60;y&#x60; value as received from the 3D Secure 2 SDK.
     * @return y
     **/
    @Schema(description = "The `y` value as received from the 3D Secure 2 SDK.")
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
