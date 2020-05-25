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

package com.adyen.model.checkout.details;

import com.adyen.model.checkout.PaymentMethodDetails;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.constants.TextConstants.LINE_BREAK;
import static com.adyen.util.Util.toIndentedString;

/**
 * DragonpayDetails
 */

public class DragonpayDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String EBANKING = "dragonpay_ebanking";
    public static final String OTC_BANKING = "dragonpay_otc_banking";
    public static final String OTC_NON_BANKING = "dragonpay_otc_non_banking";
    public static final String OTC_PHILIPPINES = "dragonpay_otc_philippines";

    @SerializedName("issuer")
    private String issuer = null;

    @SerializedName("shopperEmail")
    private String shopperEmail = null;

    @SerializedName("type")
    private String type = null;

    public DragonpayDetails issuer(String issuer) {
        this.issuer = issuer;
        return this;
    }

    /**
     * The Dragonpay issuer value of the shopper&#x27;s selected bank. Set this to an **id** of a Dragonpay issuer to preselect it.
     *
     * @return issuer
     **/
    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public DragonpayDetails shopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
        return this;
    }

    /**
     * The shopper’s email address.
     *
     * @return shopperEmail
     **/
    public String getShopperEmail() {
        return shopperEmail;
    }

    public void setShopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
    }

    public DragonpayDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DragonpayDetails dragonpayDetails = (DragonpayDetails) o;
        return Objects.equals(this.issuer, dragonpayDetails.issuer) &&
                Objects.equals(this.shopperEmail, dragonpayDetails.shopperEmail) &&
                Objects.equals(this.type, dragonpayDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issuer, shopperEmail, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DragonpayDetails {").append(LINE_BREAK);

        sb.append("    issuer: ").append(toIndentedString(issuer)).append(LINE_BREAK);
        sb.append("    shopperEmail: ").append(toIndentedString(shopperEmail)).append(LINE_BREAK);
        sb.append("    type: ").append(toIndentedString(type)).append(LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }

}
