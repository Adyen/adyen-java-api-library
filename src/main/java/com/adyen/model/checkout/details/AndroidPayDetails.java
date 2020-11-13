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
 * AndroidPayDetails
 */

public class AndroidPayDetails implements PaymentMethodDetails {
    public static final String ANDROIDPAY = "androidpay";
    @SerializedName("androidPayToken")
    private String androidPayToken = null;

    @SerializedName("type")
    private String type = ANDROIDPAY;

    public AndroidPayDetails androidPayToken(String androidPayToken) {
        this.androidPayToken = androidPayToken;
        return this;
    }

    /**
     * Get androidPayToken
     *
     * @return androidPayToken
     **/
    public String getAndroidPayToken() {
        return androidPayToken;
    }

    public void setAndroidPayToken(String androidPayToken) {
        this.androidPayToken = androidPayToken;
    }

    public AndroidPayDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The payment method type.
     *
     * @return type
     **/
    public String getType() {
        return type;
    }

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
        AndroidPayDetails androidPayDetails = (AndroidPayDetails) o;
        return Objects.equals(this.androidPayToken, androidPayDetails.androidPayToken) &&
                Objects.equals(this.type, androidPayDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(androidPayToken, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AndroidPayDetails {\n");

        sb.append("    androidPayToken: ").append(toIndentedString(androidPayToken)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
