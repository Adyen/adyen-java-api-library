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

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/**
 * VisaCheckoutDetails
 */

public class VisaCheckoutDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String VISA_CHECKOUT = "visacheckout";

    /**
     * Gets or Sets fundingSource
     */
    @JsonAdapter(FundingSourceEnum.Adapter.class)
    public enum FundingSourceEnum {
        CREDIT("credit"),
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

        public static FundingSourceEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<FundingSourceEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final FundingSourceEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public FundingSourceEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return FundingSourceEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("fundingSource")
    private FundingSourceEnum fundingSource = null;

    @SerializedName("type")
    private String type = VISA_CHECKOUT;

    @SerializedName("visaCheckoutCallId")
    private String visaCheckoutCallId = null;

    public VisaCheckoutDetails fundingSource(FundingSourceEnum fundingSource) {
        this.fundingSource = fundingSource;
        return this;
    }

    /**
     * Get fundingSource
     *
     * @return fundingSource
     **/
    public FundingSourceEnum getFundingSource() {
        return fundingSource;
    }

    public void setFundingSource(FundingSourceEnum fundingSource) {
        this.fundingSource = fundingSource;
    }

    public VisaCheckoutDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * **visacheckout**
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

    public VisaCheckoutDetails visaCheckoutCallId(String visaCheckoutCallId) {
        this.visaCheckoutCallId = visaCheckoutCallId;
        return this;
    }

    /**
     * Get visaCheckoutCallId
     *
     * @return visaCheckoutCallId
     **/
    public String getVisaCheckoutCallId() {
        return visaCheckoutCallId;
    }

    public void setVisaCheckoutCallId(String visaCheckoutCallId) {
        this.visaCheckoutCallId = visaCheckoutCallId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VisaCheckoutDetails visaCheckoutDetails = (VisaCheckoutDetails) o;
        return Objects.equals(this.fundingSource, visaCheckoutDetails.fundingSource) &&
                Objects.equals(this.type, visaCheckoutDetails.type) &&
                Objects.equals(this.visaCheckoutCallId, visaCheckoutDetails.visaCheckoutCallId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fundingSource, type, visaCheckoutCallId);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VisaCheckoutDetails {\n");

        sb.append("    fundingSource: ").append(toIndentedString(fundingSource)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    visaCheckoutCallId: ").append(toIndentedString(visaCheckoutCallId)).append("\n");
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
