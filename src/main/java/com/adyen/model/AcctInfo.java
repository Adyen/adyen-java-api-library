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
 * Copyright (c) 2018 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.IOException;
import java.util.Objects;

public class AcctInfo {
    /**
     * Length of time that the cardholder has had the account with the 3DS Requestor.  Allowed values: * **01** — No account * **02** — Created during this transaction * **03** — Less than 30 days * **04** — 30–60 days * **05** — More than 60 days
     */
    @JsonAdapter(ChAccAgeIndEnum.Adapter.class)
    public enum ChAccAgeIndEnum {
        _01("01"),
        _02("02"),
        _03("03"),
        _04("04"),
        _05("05");

        private String value;

        ChAccAgeIndEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static ChAccAgeIndEnum fromValue(String input) {
            for (ChAccAgeIndEnum b : ChAccAgeIndEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<ChAccAgeIndEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ChAccAgeIndEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public ChAccAgeIndEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return ChAccAgeIndEnum.fromValue((String)(value));
            }
        }
    }  @SerializedName("chAccAgeInd")
    private ChAccAgeIndEnum chAccAgeInd = null;

    @SerializedName("chAccChange")
    private String chAccChange = null;

    /**
     * Length of time since the cardholder’s account information with the 3DS Requestor was last changed, including Billing or Shipping address, new payment account, or new user(s) added.  Allowed values: * **01** — Changed during this transaction * **02** — Less than 30 days * **03** — 30–60 days * **04** — More than 60 days
     */
    @JsonAdapter(ChAccChangeIndEnum.Adapter.class)
    public enum ChAccChangeIndEnum {
        _01("01"),
        _02("02"),
        _03("03"),
        _04("04");

        private String value;

        ChAccChangeIndEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static ChAccChangeIndEnum fromValue(String input) {
            for (ChAccChangeIndEnum b : ChAccChangeIndEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<ChAccChangeIndEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ChAccChangeIndEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public ChAccChangeIndEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return ChAccChangeIndEnum.fromValue((String)(value));
            }
        }
    }  @SerializedName("chAccChangeInd")
    private ChAccChangeIndEnum chAccChangeInd = null;

    @SerializedName("chAccPwChange")
    private String chAccPwChange = null;

    /**
     * Indicates the length of time since the cardholder’s account with the 3DS Requestor had a password change or account reset.  Allowed values: * **01** — No change * **02** — Changed during this transaction * **03** — Less than 30 days * **04** — 30–60 days * **05** — More than 60 days
     */
    @JsonAdapter(ChAccPwChangeIndEnum.Adapter.class)
    public enum ChAccPwChangeIndEnum {
        _01("01"),
        _02("02"),
        _03("03"),
        _04("04"),
        _05("05");

        private String value;

        ChAccPwChangeIndEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static ChAccPwChangeIndEnum fromValue(String input) {
            for (ChAccPwChangeIndEnum b : ChAccPwChangeIndEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<ChAccPwChangeIndEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ChAccPwChangeIndEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public ChAccPwChangeIndEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return ChAccPwChangeIndEnum.fromValue((String)(value));
            }
        }
    }  @SerializedName("chAccPwChangeInd")
    private ChAccPwChangeIndEnum chAccPwChangeInd = null;

    @SerializedName("chAccString")
    private String chAccString = null;

    @SerializedName("nbPurchaseAccount")
    private String nbPurchaseAccount = null;

    @SerializedName("paymentAccAge")
    private String paymentAccAge = null;

    /**
     * Indicates the length of time that the payment account was enrolled in the cardholder’s account with the 3DS Requestor.  Allowed values: * **01** — No account (guest checkout) * **02** — During this transaction * **03** — Less than 30 days * **04** — 30–60 days * **05** — More than 60 days
     */
    @JsonAdapter(PaymentAccIndEnum.Adapter.class)
    public enum PaymentAccIndEnum {
        _01("01"),
        _02("02"),
        _03("03"),
        _04("04"),
        _05("05");

        private String value;

        PaymentAccIndEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static PaymentAccIndEnum fromValue(String input) {
            for (PaymentAccIndEnum b : PaymentAccIndEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<PaymentAccIndEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final PaymentAccIndEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public PaymentAccIndEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return PaymentAccIndEnum.fromValue((String)(value));
            }
        }
    }  @SerializedName("paymentAccInd")
    private PaymentAccIndEnum paymentAccInd = null;

    @SerializedName("provisionAttemptsDay")
    private String provisionAttemptsDay = null;

    @SerializedName("shipAddressUsage")
    private String shipAddressUsage = null;

    /**
     * Indicates when the shipping address used for this transaction was first used with the 3DS Requestor.  Allowed values: * **01** — This transaction * **02** — Less than 30 days * **03** — 30–60 days * **04** — More than 60 days
     */
    @JsonAdapter(ShipAddressUsageIndEnum.Adapter.class)
    public enum ShipAddressUsageIndEnum {
        _01("01"),
        _02("02"),
        _03("03"),
        _04("04");

        private String value;

        ShipAddressUsageIndEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static ShipAddressUsageIndEnum fromValue(String input) {
            for (ShipAddressUsageIndEnum b : ShipAddressUsageIndEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<ShipAddressUsageIndEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ShipAddressUsageIndEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public ShipAddressUsageIndEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return ShipAddressUsageIndEnum.fromValue((String)(value));
            }
        }
    }  @SerializedName("shipAddressUsageInd")
    private ShipAddressUsageIndEnum shipAddressUsageInd = null;

    /**
     * Indicates if the Cardholder Name on the account is identical to the shipping Name used for this transaction.  Allowed values: * **01** — Account Name identical to shipping Name * **02** — Account Name different to shipping Name
     */
    @JsonAdapter(ShipNameIndicatorEnum.Adapter.class)
    public enum ShipNameIndicatorEnum {
        _01("01"),
        _02("02");

        private String value;

        ShipNameIndicatorEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static ShipNameIndicatorEnum fromValue(String input) {
            for (ShipNameIndicatorEnum b : ShipNameIndicatorEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<ShipNameIndicatorEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ShipNameIndicatorEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public ShipNameIndicatorEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return ShipNameIndicatorEnum.fromValue((String)(value));
            }
        }
    }  @SerializedName("shipNameIndicator")
    private ShipNameIndicatorEnum shipNameIndicator = null;

    /**
     * Indicates whether the 3DS Requestor has experienced suspicious activity (including previous fraud) on the cardholder account.  Allowed values: * **01** — No suspicious activity has been observed * **02** — Suspicious activity has been observed
     */
    @JsonAdapter(SuspiciousAccActivityEnum.Adapter.class)
    public enum SuspiciousAccActivityEnum {
        _01("01"),
        _02("02");

        private String value;

        SuspiciousAccActivityEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static SuspiciousAccActivityEnum fromValue(String input) {
            for (SuspiciousAccActivityEnum b : SuspiciousAccActivityEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<SuspiciousAccActivityEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final SuspiciousAccActivityEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public SuspiciousAccActivityEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return SuspiciousAccActivityEnum.fromValue((String)(value));
            }
        }
    }  @SerializedName("suspiciousAccActivity")
    private SuspiciousAccActivityEnum suspiciousAccActivity = null;

    @SerializedName("txnActivityDay")
    private String txnActivityDay = null;

    @SerializedName("txnActivityYear")
    private String txnActivityYear = null;

    public AcctInfo chAccAgeInd(ChAccAgeIndEnum chAccAgeInd) {
        this.chAccAgeInd = chAccAgeInd;
        return this;
    }

    /**
     * Length of time that the cardholder has had the account with the 3DS Requestor.  Allowed values: * **01** — No account * **02** — Created during this transaction * **03** — Less than 30 days * **04** — 30–60 days * **05** — More than 60 days
     * @return chAccAgeInd
     **/
    @Schema(description = "Length of time that the cardholder has had the account with the 3DS Requestor.  Allowed values: * **01** — No account * **02** — Created during this transaction * **03** — Less than 30 days * **04** — 30–60 days * **05** — More than 60 days")
    public ChAccAgeIndEnum getChAccAgeInd() {
        return chAccAgeInd;
    }

    public void setChAccAgeInd(ChAccAgeIndEnum chAccAgeInd) {
        this.chAccAgeInd = chAccAgeInd;
    }

    public AcctInfo chAccChange(String chAccChange) {
        this.chAccChange = chAccChange;
        return this;
    }

    /**
     * Date that the cardholder’s account with the 3DS Requestor was last changed, including Billing or Shipping address, new payment account, or new user(s) added.  Format: **YYYYMMDD**
     * @return chAccChange
     **/
    @Schema(description = "Date that the cardholder’s account with the 3DS Requestor was last changed, including Billing or Shipping address, new payment account, or new user(s) added.  Format: **YYYYMMDD**")
    public String getChAccChange() {
        return chAccChange;
    }

    public void setChAccChange(String chAccChange) {
        this.chAccChange = chAccChange;
    }

    public AcctInfo chAccChangeInd(ChAccChangeIndEnum chAccChangeInd) {
        this.chAccChangeInd = chAccChangeInd;
        return this;
    }

    /**
     * Length of time since the cardholder’s account information with the 3DS Requestor was last changed, including Billing or Shipping address, new payment account, or new user(s) added.  Allowed values: * **01** — Changed during this transaction * **02** — Less than 30 days * **03** — 30–60 days * **04** — More than 60 days
     * @return chAccChangeInd
     **/
    @Schema(description = "Length of time since the cardholder’s account information with the 3DS Requestor was last changed, including Billing or Shipping address, new payment account, or new user(s) added.  Allowed values: * **01** — Changed during this transaction * **02** — Less than 30 days * **03** — 30–60 days * **04** — More than 60 days")
    public ChAccChangeIndEnum getChAccChangeInd() {
        return chAccChangeInd;
    }

    public void setChAccChangeInd(ChAccChangeIndEnum chAccChangeInd) {
        this.chAccChangeInd = chAccChangeInd;
    }

    public AcctInfo chAccPwChange(String chAccPwChange) {
        this.chAccPwChange = chAccPwChange;
        return this;
    }

    /**
     * Date that cardholder’s account with the 3DS Requestor had a password change or account reset.  Format: **YYYYMMDD**
     * @return chAccPwChange
     **/
    @Schema(description = "Date that cardholder’s account with the 3DS Requestor had a password change or account reset.  Format: **YYYYMMDD**")
    public String getChAccPwChange() {
        return chAccPwChange;
    }

    public void setChAccPwChange(String chAccPwChange) {
        this.chAccPwChange = chAccPwChange;
    }

    public AcctInfo chAccPwChangeInd(ChAccPwChangeIndEnum chAccPwChangeInd) {
        this.chAccPwChangeInd = chAccPwChangeInd;
        return this;
    }

    /**
     * Indicates the length of time since the cardholder’s account with the 3DS Requestor had a password change or account reset.  Allowed values: * **01** — No change * **02** — Changed during this transaction * **03** — Less than 30 days * **04** — 30–60 days * **05** — More than 60 days
     * @return chAccPwChangeInd
     **/
    @Schema(description = "Indicates the length of time since the cardholder’s account with the 3DS Requestor had a password change or account reset.  Allowed values: * **01** — No change * **02** — Changed during this transaction * **03** — Less than 30 days * **04** — 30–60 days * **05** — More than 60 days")
    public ChAccPwChangeIndEnum getChAccPwChangeInd() {
        return chAccPwChangeInd;
    }

    public void setChAccPwChangeInd(ChAccPwChangeIndEnum chAccPwChangeInd) {
        this.chAccPwChangeInd = chAccPwChangeInd;
    }

    public AcctInfo chAccString(String chAccString) {
        this.chAccString = chAccString;
        return this;
    }

    /**
     * Date that the cardholder opened the account with the 3DS Requestor.  Format: **YYYYMMDD**
     * @return chAccString
     **/
    @Schema(description = "Date that the cardholder opened the account with the 3DS Requestor.  Format: **YYYYMMDD**")
    public String getChAccString() {
        return chAccString;
    }

    public void setChAccString(String chAccString) {
        this.chAccString = chAccString;
    }

    public AcctInfo nbPurchaseAccount(String nbPurchaseAccount) {
        this.nbPurchaseAccount = nbPurchaseAccount;
        return this;
    }

    /**
     * Number of purchases with this cardholder account during the previous six months. Max length: 4 characters.
     * @return nbPurchaseAccount
     **/
    @Schema(description = "Number of purchases with this cardholder account during the previous six months. Max length: 4 characters.")
    public String getNbPurchaseAccount() {
        return nbPurchaseAccount;
    }

    public void setNbPurchaseAccount(String nbPurchaseAccount) {
        this.nbPurchaseAccount = nbPurchaseAccount;
    }

    public AcctInfo paymentAccAge(String paymentAccAge) {
        this.paymentAccAge = paymentAccAge;
        return this;
    }

    /**
     * String that the payment account was enrolled in the cardholder’s account with the 3DS Requestor.  Format: **YYYYMMDD**
     * @return paymentAccAge
     **/
    @Schema(description = "String that the payment account was enrolled in the cardholder’s account with the 3DS Requestor.  Format: **YYYYMMDD**")
    public String getPaymentAccAge() {
        return paymentAccAge;
    }

    public void setPaymentAccAge(String paymentAccAge) {
        this.paymentAccAge = paymentAccAge;
    }

    public AcctInfo paymentAccInd(PaymentAccIndEnum paymentAccInd) {
        this.paymentAccInd = paymentAccInd;
        return this;
    }

    /**
     * Indicates the length of time that the payment account was enrolled in the cardholder’s account with the 3DS Requestor.  Allowed values: * **01** — No account (guest checkout) * **02** — During this transaction * **03** — Less than 30 days * **04** — 30–60 days * **05** — More than 60 days
     * @return paymentAccInd
     **/
    @Schema(description = "Indicates the length of time that the payment account was enrolled in the cardholder’s account with the 3DS Requestor.  Allowed values: * **01** — No account (guest checkout) * **02** — During this transaction * **03** — Less than 30 days * **04** — 30–60 days * **05** — More than 60 days")
    public PaymentAccIndEnum getPaymentAccInd() {
        return paymentAccInd;
    }

    public void setPaymentAccInd(PaymentAccIndEnum paymentAccInd) {
        this.paymentAccInd = paymentAccInd;
    }

    public AcctInfo provisionAttemptsDay(String provisionAttemptsDay) {
        this.provisionAttemptsDay = provisionAttemptsDay;
        return this;
    }

    /**
     * Number of Add Card attempts in the last 24 hours. Max length: 3 characters.
     * @return provisionAttemptsDay
     **/
    @Schema(description = "Number of Add Card attempts in the last 24 hours. Max length: 3 characters.")
    public String getProvisionAttemptsDay() {
        return provisionAttemptsDay;
    }

    public void setProvisionAttemptsDay(String provisionAttemptsDay) {
        this.provisionAttemptsDay = provisionAttemptsDay;
    }

    public AcctInfo shipAddressUsage(String shipAddressUsage) {
        this.shipAddressUsage = shipAddressUsage;
        return this;
    }

    /**
     * String when the shipping address used for this transaction was first used with the 3DS Requestor.  Format: **YYYYMMDD**
     * @return shipAddressUsage
     **/
    @Schema(description = "String when the shipping address used for this transaction was first used with the 3DS Requestor.  Format: **YYYYMMDD**")
    public String getShipAddressUsage() {
        return shipAddressUsage;
    }

    public void setShipAddressUsage(String shipAddressUsage) {
        this.shipAddressUsage = shipAddressUsage;
    }

    public AcctInfo shipAddressUsageInd(ShipAddressUsageIndEnum shipAddressUsageInd) {
        this.shipAddressUsageInd = shipAddressUsageInd;
        return this;
    }

    /**
     * Indicates when the shipping address used for this transaction was first used with the 3DS Requestor.  Allowed values: * **01** — This transaction * **02** — Less than 30 days * **03** — 30–60 days * **04** — More than 60 days
     * @return shipAddressUsageInd
     **/
    @Schema(description = "Indicates when the shipping address used for this transaction was first used with the 3DS Requestor.  Allowed values: * **01** — This transaction * **02** — Less than 30 days * **03** — 30–60 days * **04** — More than 60 days")
    public ShipAddressUsageIndEnum getShipAddressUsageInd() {
        return shipAddressUsageInd;
    }

    public void setShipAddressUsageInd(ShipAddressUsageIndEnum shipAddressUsageInd) {
        this.shipAddressUsageInd = shipAddressUsageInd;
    }

    public AcctInfo shipNameIndicator(ShipNameIndicatorEnum shipNameIndicator) {
        this.shipNameIndicator = shipNameIndicator;
        return this;
    }

    /**
     * Indicates if the Cardholder Name on the account is identical to the shipping Name used for this transaction.  Allowed values: * **01** — Account Name identical to shipping Name * **02** — Account Name different to shipping Name
     * @return shipNameIndicator
     **/
    @Schema(description = "Indicates if the Cardholder Name on the account is identical to the shipping Name used for this transaction.  Allowed values: * **01** — Account Name identical to shipping Name * **02** — Account Name different to shipping Name")
    public ShipNameIndicatorEnum getShipNameIndicator() {
        return shipNameIndicator;
    }

    public void setShipNameIndicator(ShipNameIndicatorEnum shipNameIndicator) {
        this.shipNameIndicator = shipNameIndicator;
    }

    public AcctInfo suspiciousAccActivity(SuspiciousAccActivityEnum suspiciousAccActivity) {
        this.suspiciousAccActivity = suspiciousAccActivity;
        return this;
    }

    /**
     * Indicates whether the 3DS Requestor has experienced suspicious activity (including previous fraud) on the cardholder account.  Allowed values: * **01** — No suspicious activity has been observed * **02** — Suspicious activity has been observed
     * @return suspiciousAccActivity
     **/
    @Schema(description = "Indicates whether the 3DS Requestor has experienced suspicious activity (including previous fraud) on the cardholder account.  Allowed values: * **01** — No suspicious activity has been observed * **02** — Suspicious activity has been observed")
    public SuspiciousAccActivityEnum getSuspiciousAccActivity() {
        return suspiciousAccActivity;
    }

    public void setSuspiciousAccActivity(SuspiciousAccActivityEnum suspiciousAccActivity) {
        this.suspiciousAccActivity = suspiciousAccActivity;
    }

    public AcctInfo txnActivityDay(String txnActivityDay) {
        this.txnActivityDay = txnActivityDay;
        return this;
    }

    /**
     * Number of transactions (successful and abandoned) for this cardholder account with the 3DS Requestor across all payment accounts in the previous 24 hours. Max length: 3 characters.
     * @return txnActivityDay
     **/
    @Schema(description = "Number of transactions (successful and abandoned) for this cardholder account with the 3DS Requestor across all payment accounts in the previous 24 hours. Max length: 3 characters.")
    public String getTxnActivityDay() {
        return txnActivityDay;
    }

    public void setTxnActivityDay(String txnActivityDay) {
        this.txnActivityDay = txnActivityDay;
    }

    public AcctInfo txnActivityYear(String txnActivityYear) {
        this.txnActivityYear = txnActivityYear;
        return this;
    }

    /**
     * Number of transactions (successful and abandoned) for this cardholder account with the 3DS Requestor across all payment accounts in the previous year. Max length: 3 characters.
     * @return txnActivityYear
     **/
    @Schema(description = "Number of transactions (successful and abandoned) for this cardholder account with the 3DS Requestor across all payment accounts in the previous year. Max length: 3 characters.")
    public String getTxnActivityYear() {
        return txnActivityYear;
    }

    public void setTxnActivityYear(String txnActivityYear) {
        this.txnActivityYear = txnActivityYear;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AcctInfo acctInfo = (AcctInfo) o;
        return Objects.equals(this.chAccAgeInd, acctInfo.chAccAgeInd) &&
                Objects.equals(this.chAccChange, acctInfo.chAccChange) &&
                Objects.equals(this.chAccChangeInd, acctInfo.chAccChangeInd) &&
                Objects.equals(this.chAccPwChange, acctInfo.chAccPwChange) &&
                Objects.equals(this.chAccPwChangeInd, acctInfo.chAccPwChangeInd) &&
                Objects.equals(this.chAccString, acctInfo.chAccString) &&
                Objects.equals(this.nbPurchaseAccount, acctInfo.nbPurchaseAccount) &&
                Objects.equals(this.paymentAccAge, acctInfo.paymentAccAge) &&
                Objects.equals(this.paymentAccInd, acctInfo.paymentAccInd) &&
                Objects.equals(this.provisionAttemptsDay, acctInfo.provisionAttemptsDay) &&
                Objects.equals(this.shipAddressUsage, acctInfo.shipAddressUsage) &&
                Objects.equals(this.shipAddressUsageInd, acctInfo.shipAddressUsageInd) &&
                Objects.equals(this.shipNameIndicator, acctInfo.shipNameIndicator) &&
                Objects.equals(this.suspiciousAccActivity, acctInfo.suspiciousAccActivity) &&
                Objects.equals(this.txnActivityDay, acctInfo.txnActivityDay) &&
                Objects.equals(this.txnActivityYear, acctInfo.txnActivityYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chAccAgeInd, chAccChange, chAccChangeInd, chAccPwChange, chAccPwChangeInd, chAccString, nbPurchaseAccount, paymentAccAge, paymentAccInd, provisionAttemptsDay, shipAddressUsage, shipAddressUsageInd, shipNameIndicator, suspiciousAccActivity, txnActivityDay, txnActivityYear);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AcctInfo {\n");

        sb.append("    chAccAgeInd: ").append(toIndentedString(chAccAgeInd)).append("\n");
        sb.append("    chAccChange: ").append(toIndentedString(chAccChange)).append("\n");
        sb.append("    chAccChangeInd: ").append(toIndentedString(chAccChangeInd)).append("\n");
        sb.append("    chAccPwChange: ").append(toIndentedString(chAccPwChange)).append("\n");
        sb.append("    chAccPwChangeInd: ").append(toIndentedString(chAccPwChangeInd)).append("\n");
        sb.append("    chAccString: ").append(toIndentedString(chAccString)).append("\n");
        sb.append("    nbPurchaseAccount: ").append(toIndentedString(nbPurchaseAccount)).append("\n");
        sb.append("    paymentAccAge: ").append(toIndentedString(paymentAccAge)).append("\n");
        sb.append("    paymentAccInd: ").append(toIndentedString(paymentAccInd)).append("\n");
        sb.append("    provisionAttemptsDay: ").append(toIndentedString(provisionAttemptsDay)).append("\n");
        sb.append("    shipAddressUsage: ").append(toIndentedString(shipAddressUsage)).append("\n");
        sb.append("    shipAddressUsageInd: ").append(toIndentedString(shipAddressUsageInd)).append("\n");
        sb.append("    shipNameIndicator: ").append(toIndentedString(shipNameIndicator)).append("\n");
        sb.append("    suspiciousAccActivity: ").append(toIndentedString(suspiciousAccActivity)).append("\n");
        sb.append("    txnActivityDay: ").append(toIndentedString(txnActivityDay)).append("\n");
        sb.append("    txnActivityYear: ").append(toIndentedString(txnActivityYear)).append("\n");
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

