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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.checkout;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

public class StoringMethod {
    @SerializedName("pushAccountReceipt")
    private String pushAccountReceipt = null;

    @SerializedName("shopperIP")
    private String shopperIP = null;

    @SerializedName("type")
    private String type = null;

    public StoringMethod pushAccountReceipt(String pushAccountReceipt) {
        this.pushAccountReceipt = pushAccountReceipt;
        return this;
    }

    public String getPushAccountReceipt() {
        return pushAccountReceipt;
    }

    public void setPushAccountReceipt(String pushAccountReceipt) {
        this.pushAccountReceipt = pushAccountReceipt;
    }

    public StoringMethod shopperIP(String shopperIP) {
        this.shopperIP = shopperIP;
        return this;
    }

    public String getShopperIP() {
        return shopperIP;
    }

    public void setShopperIP(String shopperIP) {
        this.shopperIP = shopperIP;
    }

    public StoringMethod type(String type) {
        this.type = type;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StoringMethod storingMethod = (StoringMethod) o;
        return Objects.equals(this.pushAccountReceipt, storingMethod.pushAccountReceipt) &&
                Objects.equals(this.shopperIP, storingMethod.shopperIP) &&
                Objects.equals(this.type, storingMethod.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pushAccountReceipt, shopperIP, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StoringMethod {\n");

        sb.append("    pushAccountReceipt: ").append(toIndentedString(pushAccountReceipt)).append("\n");
        sb.append("    shopperIP: ").append(toIndentedString(shopperIP)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}