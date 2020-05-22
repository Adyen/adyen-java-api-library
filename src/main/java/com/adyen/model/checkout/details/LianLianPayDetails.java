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
 * LianLianPayDetails
 */

public class LianLianPayDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String EBANKING_ENTERPRISE = "lianlianpay_ebanking_enterprise";
    public static final String EBANKING_CREDIT = "lianlianpay_ebanking_credit";
    public static final String EBANKING_DEBIT = "lianlianpay_ebanking_debit";

    @SerializedName("telephoneNumber")
    private String telephoneNumber = null;

    @SerializedName("type")
    private String type = null;

    public LianLianPayDetails telephoneNumber(String telephoneNumber) {
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

    public LianLianPayDetails type(String type) {
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
        LianLianPayDetails lianLianPayDetails = (LianLianPayDetails) o;
        return Objects.equals(this.telephoneNumber, lianLianPayDetails.telephoneNumber) &&
                Objects.equals(this.type, lianLianPayDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telephoneNumber, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LianLianPayDetails {").append(TextConstants.LINE_BREAK);

        sb.append("    telephoneNumber: ").append(Util.toIndentedString(telephoneNumber)).append(TextConstants.LINE_BREAK);
        sb.append("    type: ").append(Util.toIndentedString(type)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }



}
