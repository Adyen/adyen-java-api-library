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
package com.adyen.model.recurring;

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * DisableRequest
 */
public class DisableRequest {
    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("shopperReference")
    private String shopperReference = null;

    @SerializedName("recurringDetailReference")
    private String recurringDetailReference = null;

    @SerializedName("contract")
    private String contract = null;

    public DisableRequest merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    /**
     * the merchant account which will be used for processing this request
     *
     * @return merchantAccount
     **/
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public DisableRequest shopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
        return this;
    }

    /**
     * a reference you use to uniquely identify the shopper (e.g. user ID or account ID)
     *
     * @return shopperReference
     **/
    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    public DisableRequest recurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
        return this;
    }

    /**
     * the recurring detail you wish to disable
     *
     * @return recurringDetailReference
     **/
    public String getRecurringDetailReference() {
        return recurringDetailReference;
    }

    public void setRecurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
    }

    public DisableRequest contract(String contract) {
        this.contract = contract;
        return this;
    }

    /**
     * specify the contract if you only want to disable a specific use
     *
     * @return contract
     **/
    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        DisableRequest disableRequest = (DisableRequest) o;
        return Objects.equals(this.merchantAccount, disableRequest.merchantAccount)
                && Objects.equals(this.shopperReference, disableRequest.shopperReference)
                && Objects.equals(this.recurringDetailReference, disableRequest.recurringDetailReference)
                && Objects.equals(this.contract, disableRequest.contract);
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchantAccount, shopperReference, recurringDetailReference, contract);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DisableRequest {").append(TextConstants.LINE_BREAK);

        sb.append("    merchantAccount: ").append(Util.toIndentedString(merchantAccount)).append(TextConstants.LINE_BREAK);
        sb.append("    shopperReference: ").append(Util.toIndentedString(shopperReference)).append(TextConstants.LINE_BREAK);
        sb.append("    recurringDetailReference: ").append(Util.toIndentedString(recurringDetailReference)).append(TextConstants.LINE_BREAK);
        sb.append("    contract: ").append(Util.toIndentedString(contract)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }

}

