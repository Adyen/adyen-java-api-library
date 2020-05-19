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

import java.util.Objects;

import com.adyen.model.checkout.PaymentMethodDetails;
import com.google.gson.annotations.SerializedName;


/**
 * DokuDetails
 */

public class DokuDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String MANDIRI_VA = "doku_mandiri_va";
    public static final String CIMB_VA = "doku_cimb_va";
    public static final String DANAMON_VA = "doku_danamon_va";
    public static final String BNI_VA = "doku_bni_va";
    public static final String PERMATA_LITE_ATM = "doku_permata_lite_atm";
    public static final String PERMATA_ATM = "doku_permata_atm";
    public static final String BRI_VA = "doku_bri_va";
    public static final String BCA_VA = "doku_bca_va";
    public static final String ALFAMART = "doku_alfamart";
    public static final String INDOMARET = "doku_indomaret";
    public static final String SINARMAS_VA = "doku_sinarmas_va";

    @SerializedName("firstName")
    private String firstName = null;

    @SerializedName("lastName")
    private String lastName = null;

    @SerializedName("shopperEmail")
    private String shopperEmail = null;

    @SerializedName("type")
    private String type = null;

    public DokuDetails firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * The shopper&#x27;s first name.
     *
     * @return firstName
     **/
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public DokuDetails lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * The shopper&#x27;s last name.
     *
     * @return lastName
     **/
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DokuDetails shopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
        return this;
    }

    /**
     * The shopper&#x27;s email.
     *
     * @return shopperEmail
     **/
    public String getShopperEmail() {
        return shopperEmail;
    }

    public void setShopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
    }

    public DokuDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * **doku**
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
        DokuDetails dokuDetails = (DokuDetails) o;
        return Objects.equals(this.firstName, dokuDetails.firstName) &&
                Objects.equals(this.lastName, dokuDetails.lastName) &&
                Objects.equals(this.shopperEmail, dokuDetails.shopperEmail) &&
                Objects.equals(this.type, dokuDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, shopperEmail, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DokuDetails {\n");

        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    shopperEmail: ").append(toIndentedString(shopperEmail)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
