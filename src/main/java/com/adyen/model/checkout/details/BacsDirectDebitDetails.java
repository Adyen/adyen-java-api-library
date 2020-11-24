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
 * BacsDirectDebitDetails
 */
public class BacsDirectDebitDetails implements PaymentMethodDetails {

    public static final String DIRECTDEBIT_GB = "directdebit_GB";

    @SerializedName("bankAccountNumber")
    private String bankAccountNumber = null;

    @SerializedName("bankLocationId")
    private String bankLocationId = null;

    @SerializedName("holderName")
    private String holderName = null;

    @SerializedName("type")
    private String type = DIRECTDEBIT_GB;

    public BacsDirectDebitDetails bankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
        return this;
    }

    /**
     * The bank account number (without separators).
     *
     * @return bankAccountNumber
     **/
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public BacsDirectDebitDetails bankLocationId(String bankLocationId) {
        this.bankLocationId = bankLocationId;
        return this;
    }

    /**
     * The bank routing number of the account.
     *
     * @return bankLocationId
     **/
    public String getBankLocationId() {
        return bankLocationId;
    }

    public void setBankLocationId(String bankLocationId) {
        this.bankLocationId = bankLocationId;
    }

    public BacsDirectDebitDetails holderName(String holderName) {
        this.holderName = holderName;
        return this;
    }

    /**
     * The name of the bank account holder.
     *
     * @return holderName
     **/
    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public BacsDirectDebitDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * **directdebit_GB**
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
        BacsDirectDebitDetails bacsDirectDebitDetails = (BacsDirectDebitDetails) o;
        return Objects.equals(this.bankAccountNumber, bacsDirectDebitDetails.bankAccountNumber) &&
                Objects.equals(this.bankLocationId, bacsDirectDebitDetails.bankLocationId) &&
                Objects.equals(this.holderName, bacsDirectDebitDetails.holderName) &&
                Objects.equals(this.type, bacsDirectDebitDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankAccountNumber, bankLocationId, holderName, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BacsDirectDebitDetails {\n");

        sb.append("    bankAccountNumber: ").append(toIndentedString(bankAccountNumber)).append("\n");
        sb.append("    bankLocationId: ").append(toIndentedString(bankLocationId)).append("\n");
        sb.append("    holderName: ").append(toIndentedString(holderName)).append("\n");
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
