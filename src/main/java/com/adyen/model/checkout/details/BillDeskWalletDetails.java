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


import static com.adyen.util.Util.toIndentedString;

/**
 * BilldeskWalletDetails
 */

public class BillDeskWalletDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String BILLDESK_WALLET = "billdesk_wallet";

    @SerializedName("issuer")
    private String issuer = null;

    @SerializedName("type")
    private String type = BILLDESK_WALLET;

    public BillDeskWalletDetails issuer(String issuer) {
        this.issuer = issuer;
        return this;
    }

    /**
     * The issuer id of the shopper&#x27;s selected bank.
     *
     * @return issuer
     **/
    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public BillDeskWalletDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * **billdesk_wallet**
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
        BillDeskWalletDetails billdeskWalletDetails = (BillDeskWalletDetails) o;
        return Objects.equals(this.issuer, billdeskWalletDetails.issuer) &&
                Objects.equals(this.type, billdeskWalletDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issuer, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BilldeskWalletDetails {\n");

        sb.append("    issuer: ").append(toIndentedString(issuer)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
