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
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * SamsungPayDetails
 */

public class SamsungPayDetails implements PaymentMethodDetails {
    /**
     * The funding source that should be used when multiple sources are available. For Brazilian combo cards, by default the funding source is credit. To use debit, set this value to **debit**.
     */
    @JsonAdapter(FundingSourceEnum.Adapter.class)
    public enum FundingSourceEnum {
        DEBIT("debit");

        private String value;

        FundingSourceEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static FundingSourceEnum fromValue(String input) {
            for (FundingSourceEnum b : FundingSourceEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<FundingSourceEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final FundingSourceEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public FundingSourceEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return FundingSourceEnum.fromValue((String)(value));
            }
        }
    }  @SerializedName("fundingSource")
    private FundingSourceEnum fundingSource = null;

    @SerializedName("recurringDetailReference")
    private String recurringDetailReference = null;

    @SerializedName("samsungPayToken")
    private String samsungPayToken = null;

    @SerializedName("storedPaymentMethodId")
    private String storedPaymentMethodId = null;

    /**
     * **samsungpay**
     */
    public final static String SAMSUNGPAY = "samsungpay";

    @SerializedName("type")
    private String type = SAMSUNGPAY;

    public SamsungPayDetails fundingSource(FundingSourceEnum fundingSource) {
        this.fundingSource = fundingSource;
        return this;
    }

    /**
     * The funding source that should be used when multiple sources are available. For Brazilian combo cards, by default the funding source is credit. To use debit, set this value to **debit**.
     * @return fundingSource
     **/
    @Schema(description = "The funding source that should be used when multiple sources are available. For Brazilian combo cards, by default the funding source is credit. To use debit, set this value to **debit**.")
    public FundingSourceEnum getFundingSource() {
        return fundingSource;
    }

    public void setFundingSource(FundingSourceEnum fundingSource) {
        this.fundingSource = fundingSource;
    }

    public SamsungPayDetails recurringDetailReference(String recurringDetailReference) {
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

    public SamsungPayDetails samsungPayToken(String samsungPayToken) {
        this.samsungPayToken = samsungPayToken;
        return this;
    }

    /**
     * The payload you received from the Samsung Pay SDK response.
     * @return samsungPayToken
     **/
    @Schema(required = true, description = "The payload you received from the Samsung Pay SDK response.")
    public String getSamsungPayToken() {
        return samsungPayToken;
    }

    public void setSamsungPayToken(String samsungPayToken) {
        this.samsungPayToken = samsungPayToken;
    }

    public SamsungPayDetails storedPaymentMethodId(String storedPaymentMethodId) {
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

    public SamsungPayDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * **samsungpay**
     * @return type
     **/
    @Schema(description = "**samsungpay**")
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
        SamsungPayDetails samsungPayDetails = (SamsungPayDetails) o;
        return Objects.equals(this.fundingSource, samsungPayDetails.fundingSource) &&
                Objects.equals(this.recurringDetailReference, samsungPayDetails.recurringDetailReference) &&
                Objects.equals(this.samsungPayToken, samsungPayDetails.samsungPayToken) &&
                Objects.equals(this.storedPaymentMethodId, samsungPayDetails.storedPaymentMethodId) &&
                Objects.equals(this.type, samsungPayDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fundingSource, recurringDetailReference, samsungPayToken, storedPaymentMethodId, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SamsungPayDetails {\n");

        sb.append("    fundingSource: ").append(toIndentedString(fundingSource)).append("\n");
        sb.append("    recurringDetailReference: ").append(toIndentedString(recurringDetailReference)).append("\n");
        sb.append("    samsungPayToken: ").append(toIndentedString(samsungPayToken)).append("\n");
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
