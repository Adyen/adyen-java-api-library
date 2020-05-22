/**
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
import com.google.gson.annotations.SerializedName;

import static com.adyen.util.Util.toIndentedString;

/**
 * RecurringDetailsRequest
 */
public class RecurringDetailsRequest {
    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("shopperReference")
    private String shopperReference = null;

    @SerializedName("recurring")
    private Recurring recurring = null;

    public RecurringDetailsRequest merchantAccount(String merchantAccount) {
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

    public RecurringDetailsRequest shopperReference(String shopperReference) {
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

    public RecurringDetailsRequest recurring(Recurring recurring) {
        this.recurring = recurring;
        return this;
    }

    /**
     * the type of recurring contract to be used.
     *
     * @return recurring
     **/
    public Recurring getRecurring() {
        return recurring;
    }

    public void setRecurring(Recurring recurring) {
        this.recurring = recurring;
    }

    public RecurringDetailsRequest selectRecurringContract() {
        Recurring recurring = new Recurring();
        recurring.contract(Recurring.ContractEnum.RECURRING);
        setRecurring(recurring);

        return this;
    }

    public RecurringDetailsRequest selectOneClickContract() {
        Recurring recurring = new Recurring();
        recurring.contract(Recurring.ContractEnum.ONECLICK);
        setRecurring(recurring);

        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RecurringDetailsRequest {").append(TextConstants.LINE_BREAK);

        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append(TextConstants.LINE_BREAK);
        sb.append("    shopperReference: ").append(toIndentedString(shopperReference)).append(TextConstants.LINE_BREAK);
        sb.append("    recurring: ").append(toIndentedString(recurring)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }


}

