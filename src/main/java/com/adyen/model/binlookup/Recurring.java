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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.binlookup;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Recurring
 */

public class Recurring {
    /**
     * The type of recurring contract to be used. Possible values: * &#x60;ONECLICK&#x60; – Payment details can be used to initiate a one-click payment, where the shopper enters the [card security
     * code (CVC/CVV)](https://docs.adyen.com/payment-glossary#cardsecuritycodecvccvvcid). * &#x60;RECURRING&#x60; – Payment details can be used without the card security code to initiate
     * [card-not-present transactions](https://docs.adyen.com/payment-glossary#cardnotpresentcnp). * &#x60;ONECLICK,RECURRING&#x60; – Payment details can be used regardless of whether the shopper is
     * on your site or not. * &#x60;PAYOUT&#x60; – Payment details can be used to [make a payout](https://docs.adyen.com/features/third-party-payouts).
     */
    @JsonAdapter(ContractEnum.Adapter.class)
    public enum ContractEnum {
        ONECLICK("ONECLICK"),
        RECURRING("RECURRING"),
        PAYOUT("PAYOUT");

        private String value;

        ContractEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static ContractEnum fromValue(String text) {
            for (ContractEnum b : ContractEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<ContractEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ContractEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public ContractEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return ContractEnum.fromValue(String.valueOf(value));
            }
        }}

    @SerializedName("contract")
    private ContractEnum contract = null;

    @SerializedName("recurringDetailName")
    private String recurringDetailName = null;

    @SerializedName("recurringExpiry")
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
            for (TokenServiceEnum b : TokenServiceEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
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
        }}

    @SerializedName("tokenService")
    private TokenServiceEnum tokenService = null;

    public Recurring contract(ContractEnum contract) {
        this.contract = contract;
        return this;
    }


    /**
     * The type of recurring contract to be used. Possible values: * &#x60;ONECLICK&#x60; – Payment details can be used to initiate a one-click payment, where the shopper enters the [card security
     * code (CVC/CVV)](https://docs.adyen.com/payment-glossary#cardsecuritycodecvccvvcid). * &#x60;RECURRING&#x60; – Payment details can be used without the card security code to initiate
     * [card-not-present transactions](https://docs.adyen.com/payment-glossary#cardnotpresentcnp). * &#x60;ONECLICK,RECURRING&#x60; – Payment details can be used regardless of whether the shopper is
     * on your site or not. * &#x60;PAYOUT&#x60; – Payment details can be used to [make a payout](https://docs.adyen.com/features/third-party-payouts).
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
     * A descriptive name for this detail.
     *
     * @return recurringDetailName
     **/
    public String getRecurringDetailName() {
        return recurringDetailName;
    }

    public void setRecurringDetailName(String recurringDetailName) {
        this.recurringDetailName = recurringDetailName;
    }

    public Recurring recurringExpiry(Date recurringExpiry) {
        this.recurringExpiry = recurringExpiry;
        return this;
    }


    /**
     * Date after which no further authorisations shall be performed. Only for 3D Secure 2.
     *
     * @return recurringExpiry
     **/
    public Date getRecurringExpiry() {
        return recurringExpiry;
    }

    public void setRecurringExpiry(Date recurringExpiry) {
        this.recurringExpiry = recurringExpiry;
    }

    public Recurring recurringFrequency(String recurringFrequency) {
        this.recurringFrequency = recurringFrequency;
        return this;
    }


    /**
     * Minimum number of days between authorisations. Only for 3D Secure 2.
     *
     * @return recurringFrequency
     **/
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
     *
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
                && Objects.equals(this.recurringExpiry,
                                  recurring.recurringExpiry)
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
