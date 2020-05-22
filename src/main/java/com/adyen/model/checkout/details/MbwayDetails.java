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

import com.adyen.constants.TextConstants;
import com.adyen.model.checkout.PaymentMethodDetails;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * MbwayDetails
 */

public class MbwayDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String MBWAY = "mbway";

    @SerializedName("shopperEmail")
    private String shopperEmail = null;

    @SerializedName("telephoneNumber")
    private String telephoneNumber = null;

    @SerializedName("type")
    private String type = MBWAY;

    public MbwayDetails shopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
        return this;
    }

    /**
     * Get shopperEmail
     *
     * @return shopperEmail
     **/
    public String getShopperEmail() {
        return shopperEmail;
    }

    public void setShopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
    }

    public MbwayDetails telephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    /**
     * Get telephoneNumber
     *
     * @return telephoneNumber
     **/
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public MbwayDetails type(String type) {
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
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        MbwayDetails mbwayDetails = (MbwayDetails) o;
        return Objects.equals(this.shopperEmail, mbwayDetails.shopperEmail) &&
                Objects.equals(this.telephoneNumber, mbwayDetails.telephoneNumber) &&
                Objects.equals(this.type, mbwayDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopperEmail, telephoneNumber, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MbwayDetails {").append(TextConstants.LINE_BREAK);

        sb.append("    shopperEmail: ").append(Util.toIndentedString(shopperEmail)).append(TextConstants.LINE_BREAK);
        sb.append("    telephoneNumber: ").append(Util.toIndentedString(telephoneNumber)).append(TextConstants.LINE_BREAK);
        sb.append("    type: ").append(Util.toIndentedString(type)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }



}
