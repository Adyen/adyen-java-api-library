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
 * AmazonPayDetails
 */

public class AmazonPayDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String AMAZONPAY = "amazonpay";

    @SerializedName("amazonPayToken")
    private String amazonPayToken = null;

    @SerializedName("type")
    private String type = AMAZONPAY;

    public AmazonPayDetails amazonPayToken(String amazonPayToken) {
        this.amazonPayToken = amazonPayToken;
        return this;
    }

    /**
     * Get amazonPayToken
     *
     * @return amazonPayToken
     **/
    public String getAmazonPayToken() {
        return amazonPayToken;
    }

    public void setAmazonPayToken(String amazonPayToken) {
        this.amazonPayToken = amazonPayToken;
    }

    public AmazonPayDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * **amazonpay**
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
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AmazonPayDetails amazonPayDetails = (AmazonPayDetails) o;
        return Objects.equals(this.amazonPayToken, amazonPayDetails.amazonPayToken) &&
                Objects.equals(this.type, amazonPayDetails.type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AmazonPayDetails {\n");

        sb.append("    amazonPayToken: ").append(toIndentedString(amazonPayToken)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
