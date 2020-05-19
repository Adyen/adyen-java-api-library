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

package com.adyen.model.marketpay;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/**
 * PerformVerificationRequest
 */
public class PerformVerificationRequest {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    /**
     * The state required for the account holder. &gt; Permitted values: &#x60;Processing&#x60;, &#x60;Payout&#x60;.
     */
    @JsonAdapter(AccountStateTypeEnum.Adapter.class)
    public enum AccountStateTypeEnum {
        LIMITEDPAYOUT("LimitedPayout"),
        LIMITEDPROCESSING("LimitedProcessing"),
        LIMITLESSPAYOUT("LimitlessPayout"),
        LIMITLESSPROCESSING("LimitlessProcessing"),
        PAYOUT("Payout"),
        PROCESSING("Processing");

        private String value;

        AccountStateTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static AccountStateTypeEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<AccountStateTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final AccountStateTypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public AccountStateTypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return AccountStateTypeEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("accountStateType")
    private AccountStateTypeEnum accountStateType = null;

    @SerializedName("tier")
    private Integer tier = null;

    public PerformVerificationRequest accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * The code of the account holder to verify.
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public PerformVerificationRequest accountStateType(AccountStateTypeEnum accountStateType) {
        this.accountStateType = accountStateType;
        return this;
    }

    /**
     * The state required for the account holder. &gt; Permitted values: &#x60;Processing&#x60;, &#x60;Payout&#x60;.
     *
     * @return accountStateType
     **/
    public AccountStateTypeEnum getAccountStateType() {
        return accountStateType;
    }

    public void setAccountStateType(AccountStateTypeEnum accountStateType) {
        this.accountStateType = accountStateType;
    }

    public PerformVerificationRequest tier(Integer tier) {
        this.tier = tier;
        return this;
    }

    /**
     * The tier required for the account holder.
     *
     * @return tier
     **/
    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PerformVerificationRequest performVerificationRequest = (PerformVerificationRequest) o;
        return Objects.equals(this.accountHolderCode, performVerificationRequest.accountHolderCode) &&
                Objects.equals(this.accountStateType, performVerificationRequest.accountStateType) &&
                Objects.equals(this.tier, performVerificationRequest.tier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, accountStateType, tier);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PerformVerificationRequest {\n");

        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    accountStateType: ").append(toIndentedString(accountStateType)).append("\n");
        sb.append("    tier: ").append(toIndentedString(tier)).append("\n");
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
