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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.checkout;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Objects;

/**
 * Mandate
 */

public class Mandate {
    @SerializedName("amount")
    private String amount = null;

    /**
     * The limitation rule of the billing amount.  Possible values:  * **max**: The transaction amount can not exceed the &#x60;amount&#x60;.   * **exact**: The transaction amount should be the same as the &#x60;amount&#x60;.
     */
    @JsonAdapter(AmountRuleEnum.Adapter.class)
    public enum AmountRuleEnum {
        MAX("max"),
        EXACT("exact");

        @JsonValue
        private final String value;

        AmountRuleEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static AmountRuleEnum fromValue(String text) {
            for (AmountRuleEnum b : AmountRuleEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<AmountRuleEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final AmountRuleEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public AmountRuleEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return AmountRuleEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("amountRule")
    private AmountRuleEnum amountRule = null;

    /**
     * The rule to specify the period, within which the recurring debit can happen, relative to the mandate recurring date.  Possible values:   * **on**: On a specific date.   * **before**:  Before and on a specific date.   * **after**: On and after a specific date.
     */
    @JsonAdapter(BillingAttemptsRuleEnum.Adapter.class)
    public enum BillingAttemptsRuleEnum {
        ON("on"),
        BEFORE("before"),
        AFTER("after");

        @JsonValue
        private final String value;

        BillingAttemptsRuleEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static BillingAttemptsRuleEnum fromValue(String text) {
            for (BillingAttemptsRuleEnum b : BillingAttemptsRuleEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<BillingAttemptsRuleEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final BillingAttemptsRuleEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public BillingAttemptsRuleEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return BillingAttemptsRuleEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("billingAttemptsRule")
    private BillingAttemptsRuleEnum billingAttemptsRule = null;

    @SerializedName("billingDay")
    private String billingDay = null;

    @SerializedName("endsAt")
    private String endsAt = null;

    /**
     * The frequency with which a shopper should be charged.  Possible values: **daily**, **weekly**, **biWeekly**, **monthly**, **quarterly**, **halfYearly**, **yearly**.
     */
    @JsonAdapter(FrequencyEnum.Adapter.class)
    public enum FrequencyEnum {
        ADHOC("adhoc"),
        DAILY("daily"),
        WEEKLY("weekly"),
        BIWEEKLY("biWeekly"),
        MONTHLY("monthly"),
        QUARTERLY("quarterly"),
        HALFYEARLY("halfYearly"),
        YEARLY("yearly");

        @JsonValue
        private final String value;

        FrequencyEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static FrequencyEnum fromValue(String text) {
            for (FrequencyEnum b : FrequencyEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<FrequencyEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final FrequencyEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public FrequencyEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return FrequencyEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("frequency")
    private FrequencyEnum frequency = null;

    @SerializedName("remarks")
    private String remarks = null;

    @SerializedName("startsAt")
    private String startsAt = null;

    public Mandate amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The billing amount of the recurring transactions.
     *
     * @return amount
     **/
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Mandate amountRule(AmountRuleEnum amountRule) {
        this.amountRule = amountRule;
        return this;
    }

    /**
     * The limitation rule of the billing amount.  Possible values:  * **max**: The transaction amount can not exceed the &#x60;amount&#x60;.   * **exact**: The transaction amount should be the same as the &#x60;amount&#x60;.
     *
     * @return amountRule
     **/
    public AmountRuleEnum getAmountRule() {
        return amountRule;
    }

    public void setAmountRule(AmountRuleEnum amountRule) {
        this.amountRule = amountRule;
    }

    public Mandate billingAttemptsRule(BillingAttemptsRuleEnum billingAttemptsRule) {
        this.billingAttemptsRule = billingAttemptsRule;
        return this;
    }

    /**
     * The rule to specify the period, within which the recurring debit can happen, relative to the mandate recurring date.  Possible values:   * **on**: On a specific date.   * **before**:  Before and on a specific date.   * **after**: On and after a specific date.
     *
     * @return billingAttemptsRule
     **/
    public BillingAttemptsRuleEnum getBillingAttemptsRule() {
        return billingAttemptsRule;
    }

    public void setBillingAttemptsRule(BillingAttemptsRuleEnum billingAttemptsRule) {
        this.billingAttemptsRule = billingAttemptsRule;
    }

    public Mandate billingDay(String billingDay) {
        this.billingDay = billingDay;
        return this;
    }

    /**
     * The number of the day, on which the recurring debit can happen. Should be within the same calendar month as the mandate recurring date.  Possible values: 1-31 based on the &#x60;frequency&#x60;.
     *
     * @return billingDay
     **/
    public String getBillingDay() {
        return billingDay;
    }

    public void setBillingDay(String billingDay) {
        this.billingDay = billingDay;
    }

    public Mandate endsAt(String endsAt) {
        this.endsAt = endsAt;
        return this;
    }

    /**
     * End date of the billing plan, in YYYY-MM-DD format.
     *
     * @return endsAt
     **/
    public String getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(String endsAt) {
        this.endsAt = endsAt;
    }

    public Mandate frequency(FrequencyEnum frequency) {
        this.frequency = frequency;
        return this;
    }

    /**
     * The frequency with which a shopper should be charged.  Possible values: **daily**, **weekly**, **biWeekly**, **monthly**, **quarterly**, **halfYearly**, **yearly**.
     *
     * @return frequency
     **/
    public FrequencyEnum getFrequency() {
        return frequency;
    }

    public void setFrequency(FrequencyEnum frequency) {
        this.frequency = frequency;
    }

    public Mandate remarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    /**
     * The message shown by UPI to the shopper on the approval screen.
     *
     * @return remarks
     **/
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Mandate startsAt(String startsAt) {
        this.startsAt = startsAt;
        return this;
    }

    /**
     * Start date of the billing plan, in YYYY-MM-DD format. By default, the transaction date.
     *
     * @return startsAt
     **/
    public String getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(String startsAt) {
        this.startsAt = startsAt;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mandate mandate = (Mandate) o;
        return Objects.equals(this.amount, mandate.amount) &&
                Objects.equals(this.amountRule, mandate.amountRule) &&
                Objects.equals(this.billingAttemptsRule, mandate.billingAttemptsRule) &&
                Objects.equals(this.billingDay, mandate.billingDay) &&
                Objects.equals(this.endsAt, mandate.endsAt) &&
                Objects.equals(this.frequency, mandate.frequency) &&
                Objects.equals(this.remarks, mandate.remarks) &&
                Objects.equals(this.startsAt, mandate.startsAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, amountRule, billingAttemptsRule, billingDay, endsAt, frequency, remarks, startsAt);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Mandate {\n");

        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    amountRule: ").append(toIndentedString(amountRule)).append("\n");
        sb.append("    billingAttemptsRule: ").append(toIndentedString(billingAttemptsRule)).append("\n");
        sb.append("    billingDay: ").append(toIndentedString(billingDay)).append("\n");
        sb.append("    endsAt: ").append(toIndentedString(endsAt)).append("\n");
        sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
        sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
        sb.append("    startsAt: ").append(toIndentedString(startsAt)).append("\n");
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
