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
 * Copyright (c) 2022 Adyen B.V.
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

public class StoredPaymentMethodDetails  implements PaymentMethodDetails {
    @SerializedName("recurringDetailReference")
    private String recurringDetailReference = null;

    @SerializedName("storedPaymentMethodId")
    private String storedPaymentMethodId = null;

    /**
     * payment method type values.
     */
    public final String BCMC_MOBILE = "bcmc_mobile";
    public final String BCMC_MOBILE_QR = "bcmc_mobile_QR";
    public final String BCMC_MOBILE_APP = "bcmc_mobile_app";
    public final String MOMO_WALLET = "momo_wallet";
    public final String MOMO_WALLET_APP = "momo_wallet_app";
    public final String PAYMAYA_WALLET = "paymaya_wallet";
    public final String GRABPAY_SG = "grabpay_SG";
    public final String GRABPAY_MY = "grabpay_MY";
    public final String GRABPAY_TH = "grabpay_TH";
    public final String GRABPAY_ID = "grabpay_ID";
    public final String GRABPAY_VN = "grabpay_VN";
    public final String GRABPAY_PH = "grabpay_PH";
    public final String OXXO = "oxxo";
    public final String GCASH = "gcash";
    public final String KAKAOPAY = "kakaopay";
    public final String TRUEMONEY = "truemoney";

    @SerializedName("type")
    private String type = null;

    public StoredPaymentMethodDetails recurringDetailReference(String recurringDetailReference) {
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

    public StoredPaymentMethodDetails storedPaymentMethodId(String storedPaymentMethodId) {
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

    public StoredPaymentMethodDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The payment method type.
     * @return type
     **/
    @Schema(description = "The payment method type.")
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
        StoredPaymentMethodDetails storedPaymentMethodDetails = (StoredPaymentMethodDetails) o;
        return Objects.equals(this.recurringDetailReference, storedPaymentMethodDetails.recurringDetailReference) &&
                Objects.equals(this.storedPaymentMethodId, storedPaymentMethodDetails.storedPaymentMethodId) &&
                Objects.equals(this.type, storedPaymentMethodDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recurringDetailReference, storedPaymentMethodId, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StoredPaymentMethodDetails {\n");

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
