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
import java.util.Map;
import java.util.Objects;

/**
 * CreateAccountRequest
 */
public class CreateAccountRequest {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("metadata")
    private Map<String, String> metadata = null;

    /**
     * The payout schedule of the prospective account. &gt;Permitted values: &#x60;DEFAULT&#x60;, &#x60;HOLD&#x60;, &#x60;DAILY&#x60;, &#x60;WEEKLY&#x60;, &#x60;MONTHLY&#x60;.
     */
    @JsonAdapter(PayoutScheduleEnum.Adapter.class)
    public enum PayoutScheduleEnum {
        BIWEEKLY_ON_1ST_AND_15TH_AT_MIDNIGHT("BIWEEKLY_ON_1ST_AND_15TH_AT_MIDNIGHT"),
        BIWEEKLY_ON_1ST_AND_15TH_AT_NOON("BIWEEKLY_ON_1ST_AND_15TH_AT_NOON"),
        DAILY("DAILY"),
        DAILY_6PM("DAILY_6PM"),
        DAILY_AU("DAILY_AU"),
        DAILY_EU("DAILY_EU"),
        DAILY_US("DAILY_US"),
        DEFAULT("DEFAULT"),
        EVERY_6_HOURS_FROM_MIDNIGHT("EVERY_6_HOURS_FROM_MIDNIGHT"),
        HOLD("HOLD"),
        MONTHLY("MONTHLY"),
        WEEKLY("WEEKLY"),
        WEEKLY_ON_TUE_FRI_MIDNIGHT("WEEKLY_ON_TUE_FRI_MIDNIGHT"),
        YEARLY("YEARLY");

        private String value;

        PayoutScheduleEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static PayoutScheduleEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<PayoutScheduleEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final PayoutScheduleEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public PayoutScheduleEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return PayoutScheduleEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("payoutSchedule")
    private PayoutScheduleEnum payoutSchedule = null;

    @SerializedName("payoutScheduleReason")
    private String payoutScheduleReason = null;

    public CreateAccountRequest accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * The code of Account Holder under which to create the account.
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public CreateAccountRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the account.
     *
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CreateAccountRequest metadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * A set of key and value pairs for general use by the merchant. The keys do not have specific names and may be used for storing miscellaneous data as desired. &gt; Note that during an update of metadata, the omission of existing key-value pairs will result in the deletion of those key-value pairs.
     *
     * @return metadata
     **/
    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public CreateAccountRequest payoutSchedule(PayoutScheduleEnum payoutSchedule) {
        this.payoutSchedule = payoutSchedule;
        return this;
    }

    /**
     * The payout schedule of the prospective account. &gt;Permitted values: &#x60;DEFAULT&#x60;, &#x60;HOLD&#x60;, &#x60;DAILY&#x60;, &#x60;WEEKLY&#x60;, &#x60;MONTHLY&#x60;.
     *
     * @return payoutSchedule
     **/
    public PayoutScheduleEnum getPayoutSchedule() {
        return payoutSchedule;
    }

    public void setPayoutSchedule(PayoutScheduleEnum payoutSchedule) {
        this.payoutSchedule = payoutSchedule;
    }

    public CreateAccountRequest payoutScheduleReason(String payoutScheduleReason) {
        this.payoutScheduleReason = payoutScheduleReason;
        return this;
    }

    /**
     * The reason for the payout schedule choice. &gt;Required if the payoutSchedule is &#x60;HOLD&#x60;.
     *
     * @return payoutScheduleReason
     **/
    public String getPayoutScheduleReason() {
        return payoutScheduleReason;
    }

    public void setPayoutScheduleReason(String payoutScheduleReason) {
        this.payoutScheduleReason = payoutScheduleReason;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateAccountRequest createAccountRequest = (CreateAccountRequest) o;
        return Objects.equals(this.accountHolderCode, createAccountRequest.accountHolderCode) &&
                Objects.equals(this.description, createAccountRequest.description) &&
                Objects.equals(this.metadata, createAccountRequest.metadata) &&
                Objects.equals(this.payoutSchedule, createAccountRequest.payoutSchedule) &&
                Objects.equals(this.payoutScheduleReason, createAccountRequest.payoutScheduleReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, description, metadata, payoutSchedule, payoutScheduleReason);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateAccountRequest {\n");

        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    payoutSchedule: ").append(toIndentedString(payoutSchedule)).append("\n");
        sb.append("    payoutScheduleReason: ").append(toIndentedString(payoutScheduleReason)).append("\n");
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
