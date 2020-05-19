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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.recurring;

import com.adyen.serializer.DateSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * Recurring
 */
public class Recurring {
    /**
     * how the recurring detail will be used, multiple values allowed as comma separated
     */
    public enum ContractEnum {
        @SerializedName("ONECLICK")
        ONECLICK("ONECLICK"),

        @SerializedName("ONECLICK,RECURRING")
        ONECLICK_RECURRING("ONECLICK,RECURRING"),

        @SerializedName("RECURRING")
        RECURRING("RECURRING"),

        @SerializedName("PAYOUT")
        PAYOUT("PAYOUT"),

        @SerializedName("ONECLICK,RECURRING,PAYOUT")
        ONECLICK_RECURRING_PAYOUT("ONECLICK,RECURRING,PAYOUT"),

        @SerializedName("ONECLICK,PAYOUT")
        ONECLICK_PAYOUT("ONECLICK,PAYOUT"),

        @SerializedName("RECURRING,PAYOUT")
        RECURRING_PAYOUT("RECURRING,PAYOUT"),

        @SerializedName("EXTERNAL")
        EXTERNAL("EXTERNAL");

        private String value;

        ContractEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("contract")
    private ContractEnum contract = null;

    @SerializedName("recurringDetailName")
    private String recurringDetailName = null;

    @SerializedName("recurringExpiry")
    @JsonAdapter(DateSerializer.class)
    private Date recurringExpiry = null;

    @SerializedName("recurringFrequency")
    private String recurringFrequency = null;

    /**
     * The name of the token service.
     */
    @JsonAdapter(TokenServiceEnum.Adapter.class)
    public enum TokenServiceEnum {
        VISATOKENSERVICE("VISATOKENSERVICE"),
        MCTOKENSERVICE("MCTOKENSERVICE");

        private String value;

        TokenServiceEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static TokenServiceEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }
        public static class Adapter extends TypeAdapter<TokenServiceEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TokenServiceEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TokenServiceEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return TokenServiceEnum.fromValue(String.valueOf(value));
            }
        }
    }
    @SerializedName("tokenService")
    private TokenServiceEnum tokenService = null;

    public Recurring contract(ContractEnum contract) {
        this.contract = contract;
        return this;
    }

    /**
     * how the recurring detail will be used, multiple values allowed as comma separated
     *
     * @return contract
     **/
    public ContractEnum getContract() {
        return contract;
    }

    public void setContract(ContractEnum contract) {
        this.contract = contract;
    }

    public Recurring recurringDetailName(String recurringDetailName) {
        this.recurringDetailName = recurringDetailName;
        return this;
    }

    /**
     * assign a descriptive name for this detail
     *
     * @return recurringDetailName
     **/
    public String getRecurringDetailName() {
        return recurringDetailName;
    }

    public void setRecurringDetailName(String recurringDetailName) {
        this.recurringDetailName = recurringDetailName;
    }

    public Date getRecurringExpiry() {
        return recurringExpiry;
    }

    public void setRecurringExpiry(Date recurringExpiry) {
        this.recurringExpiry = recurringExpiry;
    }

    public String getRecurringFrequency() {
        return recurringFrequency;
    }

    public void setRecurringFrequency(String recurringFrequency) {
        this.recurringFrequency = recurringFrequency;
    }

    public Recurring tokenService(TokenServiceEnum tokenService) {
        this.tokenService = tokenService;
        return this;
    }

    /**
     * The name of the token service.
     * @return tokenService
     **/
    public TokenServiceEnum getTokenService() {
        return tokenService;
    }

    public void setTokenService(TokenServiceEnum tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Recurring recurring = (Recurring) o;
        return Objects.equals(this.contract, recurring.contract)
                && Objects.equals(this.recurringDetailName, recurring.recurringDetailName)
                && Objects.equals(this.recurringExpiry, recurring.recurringExpiry)
                && Objects.equals(this.recurringFrequency, recurring.recurringFrequency)
                && Objects.equals(this.tokenService, recurring.tokenService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contract, recurringDetailName, recurringExpiry, recurringFrequency, tokenService);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Recurring {\n");
        sb.append("    contract: ").append(toIndentedString(contract)).append("\n");
        sb.append("    recurringDetailName: ").append(toIndentedString(recurringDetailName)).append("\n");
        sb.append("    recurringExpiry: ").append(toIndentedString(recurringExpiry)).append("\n");
        sb.append("    recurringFrequency: ").append(toIndentedString(recurringFrequency)).append("\n");
        sb.append("    tokenService: ").append(toIndentedString(tokenService)).append("\n");
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

