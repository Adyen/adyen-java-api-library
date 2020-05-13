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

/**
 * SepaDirectDebitDetails
 */

public class SepaDirectDebitDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String SEPA_DIRECT_DEBIT = "sepadirectdebit";

    @SerializedName("iban")
    private String iban = null;

    @SerializedName("ownerName")
    private String ownerName = null;

    @SerializedName("type")
    private String type = SEPA_DIRECT_DEBIT;

    public SepaDirectDebitDetails iban(String iban) {
        this.iban = iban;
        return this;
    }

    /**
     * The International Bank Account Number (IBAN).
     *
     * @return iban
     **/
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public SepaDirectDebitDetails ownerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    /**
     * The name of the bank account holder.
     *
     * @return ownerName
     **/
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public SepaDirectDebitDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * **sepadirectdebit**
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
        SepaDirectDebitDetails sepaDirectDebitDetails = (SepaDirectDebitDetails) o;
        return Objects.equals(this.iban, sepaDirectDebitDetails.iban) &&
                Objects.equals(this.ownerName, sepaDirectDebitDetails.ownerName) &&
                Objects.equals(this.type, sepaDirectDebitDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, ownerName, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SepaDirectDebitDetails {\n");

        sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
        sb.append("    ownerName: ").append(toIndentedString(ownerName)).append("\n");
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
