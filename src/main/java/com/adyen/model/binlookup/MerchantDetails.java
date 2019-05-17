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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.binlookup;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * MerchantDetails
 */

public class MerchantDetails {

    @SerializedName("countryCode")
    private String countryCode = null;

    @SerializedName("enrolledIn3DSecure")
    private Boolean enrolledIn3DSecure = null;

    @SerializedName("mcc")
    private String mcc = null;

    public MerchantDetails countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }


    /**
     * 2-letter ISO 3166 country code of the card acceptor location. &gt; This parameter is required for the merchants who don&#x27;t use Adyen as the payment authorisation gateway.
     *
     * @return countryCode
     **/
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public MerchantDetails enrolledIn3DSecure(Boolean enrolledIn3DSecure) {
        this.enrolledIn3DSecure = enrolledIn3DSecure;
        return this;
    }


    /**
     * If true, indicates that the merchant is enrolled in 3D Secure for the card network.
     *
     * @return enrolledIn3DSecure
     **/
    public Boolean isEnrolledIn3DSecure() {
        return enrolledIn3DSecure;
    }

    public void setEnrolledIn3DSecure(Boolean enrolledIn3DSecure) {
        this.enrolledIn3DSecure = enrolledIn3DSecure;
    }

    public MerchantDetails mcc(String mcc) {
        this.mcc = mcc;
        return this;
    }


    /**
     * The merchant category code (MCC) is a four-digit number which relates to a particular market segment. This code reflects the predominant activity that is conducted by the merchant.  The list
     * of MCCs can be found [here](https://en.wikipedia.org/wiki/Merchant_category_code).
     *
     * @return mcc
     **/
    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MerchantDetails merchantDetails = (MerchantDetails) o;
        return Objects.equals(this.countryCode, merchantDetails.countryCode) && Objects.equals(this.enrolledIn3DSecure, merchantDetails.enrolledIn3DSecure) && Objects.equals(this.mcc,
                                                                                                                                                                              merchantDetails.mcc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, enrolledIn3DSecure, mcc);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MerchantDetails {\n");

        sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
        sb.append("    enrolledIn3DSecure: ").append(toIndentedString(enrolledIn3DSecure)).append("\n");
        sb.append("    mcc: ").append(toIndentedString(mcc)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
