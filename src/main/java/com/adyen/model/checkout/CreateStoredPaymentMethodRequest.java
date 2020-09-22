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

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

import static com.adyen.util.Util.toIndentedString;


public class CreateStoredPaymentMethodRequest {
    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("shopperReference")
    private String shopperReference = null;

    @SerializedName("storingMethod")
    private StoringMethod storingMethod = null;

    public CreateStoredPaymentMethodRequest merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public CreateStoredPaymentMethodRequest shopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
        return this;
    }

    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    public CreateStoredPaymentMethodRequest storingMethod(StoringMethod storingMethod) {
        this.storingMethod = storingMethod;
        return this;
    }

    public StoringMethod getStoringMethod() {
        return storingMethod;
    }

    public void setStoringMethod(StoringMethod storingMethod) {
        this.storingMethod = storingMethod;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateStoredPaymentMethodRequest createStoredPaymentMethodRequest = (CreateStoredPaymentMethodRequest) o;
        return Objects.equals(this.merchantAccount, createStoredPaymentMethodRequest.merchantAccount) &&
                Objects.equals(this.shopperReference, createStoredPaymentMethodRequest.shopperReference) &&
                Objects.equals(this.storingMethod, createStoredPaymentMethodRequest.storingMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchantAccount, shopperReference, storingMethod);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateStoredPaymentMethodRequest {\n");

        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    shopperReference: ").append(toIndentedString(shopperReference)).append("\n");
        sb.append("    storingMethod: ").append(toIndentedString(storingMethod)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}