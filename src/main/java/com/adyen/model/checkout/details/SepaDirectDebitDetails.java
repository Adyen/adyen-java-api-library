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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.IOException;
import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * SepaDirectDebitDetails
 */

public class SepaDirectDebitDetails implements PaymentMethodDetails {
    @SerializedName("iban")
    private String iban = null;

    @SerializedName("ownerName")
    private String ownerName = null;

    @SerializedName("recurringDetailReference")
    private String recurringDetailReference = null;

    @SerializedName("storedPaymentMethodId")
    private String storedPaymentMethodId = null;

    /**
     * **sepadirectdebit**
     */
    public final static String SEPADIRECTDEBIT ="sepadirectdebit";
    public final static String SEPADIRECTDEBIT_AMAZONPAY = "sepadirectdebit_amazonpay";

    @SerializedName("type")
    private String type = null;

    public SepaDirectDebitDetails iban(String iban) {
        this.iban = iban;
        return this;
    }

    /**
     * The International Bank Account Number (IBAN).
     * @return iban
     **/
    @Schema(required = true, description = "The International Bank Account Number (IBAN).")
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
     * @return ownerName
     **/
    @Schema(required = true, description = "The name of the bank account holder.")
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public SepaDirectDebitDetails recurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
        return this;
    }

    /**
     * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the token.
     * @return recurringDetailReference
     **/
    @Schema(description = "This is the `recurringDetailReference` returned in the response when you created the token.")
    public String getRecurringDetailReference() {
        return recurringDetailReference;
    }

    public void setRecurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
    }

    public SepaDirectDebitDetails storedPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
        return this;
    }

    /**
     * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the token.
     * @return storedPaymentMethodId
     **/
    @Schema(description = "This is the `recurringDetailReference` returned in the response when you created the token.")
    public String getStoredPaymentMethodId() {
        return storedPaymentMethodId;
    }

    public void setStoredPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
    }

    public SepaDirectDebitDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * **sepadirectdebit**
     * @return type
     **/
    @Schema(description = "**sepadirectdebit**")
    public String getType() {
        return type;
    }

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
        SepaDirectDebitDetails sepaDirectDebitDetails = (SepaDirectDebitDetails) o;
        return Objects.equals(this.iban, sepaDirectDebitDetails.iban) &&
                Objects.equals(this.ownerName, sepaDirectDebitDetails.ownerName) &&
                Objects.equals(this.recurringDetailReference, sepaDirectDebitDetails.recurringDetailReference) &&
                Objects.equals(this.storedPaymentMethodId, sepaDirectDebitDetails.storedPaymentMethodId) &&
                Objects.equals(this.type, sepaDirectDebitDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, ownerName, recurringDetailReference, storedPaymentMethodId, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SepaDirectDebitDetails {\n");

        sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
        sb.append("    ownerName: ").append(toIndentedString(ownerName)).append("\n");
        sb.append("    recurringDetailReference: ").append(toIndentedString(recurringDetailReference)).append("\n");
        sb.append("    storedPaymentMethodId: ").append(toIndentedString(storedPaymentMethodId)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
