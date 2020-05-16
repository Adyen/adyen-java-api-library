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
 * GooglePayDetails
 */

public class GooglePayDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String GOOGLEPAY = "paywithgoogle";

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

    @SerializedName("googlePayCardNetwork")
    private String googlePayCardNetwork = null;

    @SerializedName("googlePayToken")
    private String googlePayToken = null;

    @SerializedName("type")
    private String type = GOOGLEPAY;

    public GooglePayDetails fundingSource(FundingSourceEnum fundingSource) {
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

    public GooglePayDetails googlePayCardNetwork(String googlePayCardNetwork) {
        this.googlePayCardNetwork = googlePayCardNetwork;
        return this;
    }

    /**
     * Get googlePayCardNetwork
     *
     * @return googlePayCardNetwork
     **/
    public String getGooglePayCardNetwork() {
        return googlePayCardNetwork;
    }

    public void setGooglePayCardNetwork(String googlePayCardNetwork) {
        this.googlePayCardNetwork = googlePayCardNetwork;
    }

    public GooglePayDetails googlePayToken(String googlePayToken) {
        this.googlePayToken = googlePayToken;
        return this;
    }

    /**
     * Get googlePayToken
     *
     * @return googlePayToken
     **/
    public String getGooglePayToken() {
        return googlePayToken;
    }

    public void setGooglePayToken(String googlePayToken) {
        this.googlePayToken = googlePayToken;
    }

    public GooglePayDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * **paywithgoogle**
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
        GooglePayDetails googlePayDetails = (GooglePayDetails) o;
        return Objects.equals(this.fundingSource, googlePayDetails.fundingSource) &&
                Objects.equals(this.googlePayCardNetwork, googlePayDetails.googlePayCardNetwork) &&
                Objects.equals(this.googlePayToken, googlePayDetails.googlePayToken) &&
                Objects.equals(this.type, googlePayDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fundingSource, googlePayCardNetwork, googlePayToken, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GooglePayDetails {\n");

        sb.append("    fundingSource: ").append(toIndentedString(fundingSource)).append("\n");
        sb.append("    googlePayCardNetwork: ").append(toIndentedString(googlePayCardNetwork)).append("\n");
        sb.append("    googlePayToken: ").append(toIndentedString(googlePayToken)).append("\n");
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
