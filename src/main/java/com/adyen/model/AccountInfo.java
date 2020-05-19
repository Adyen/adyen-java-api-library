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
package com.adyen.model;

import com.adyen.serializer.DateTimeISO8601Serializer;
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
 * AccountInfo
 */
public class AccountInfo {

    /**
     * Indicator for the length of time since this shopper account was created in the merchant&#x27;s environment. Allowed values: * notApplicable * thisTransaction * lessThan30Days * from30To60Days * moreThan60Days
     */
    @JsonAdapter(AccountAgeIndicatorEnum.Adapter.class)
    public enum AccountAgeIndicatorEnum {
        NOTAPPLICABLE("notApplicable"),
        THISTRANSACTION("thisTransaction"),
        LESSTHAN30DAYS("lessThan30Days"),
        FROM30TO60DAYS("from30To60Days"),
        MORETHAN60DAYS("moreThan60Days");

        private String value;

        AccountAgeIndicatorEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static AccountAgeIndicatorEnum fromValue(String text) {
           return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<AccountAgeIndicatorEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final AccountAgeIndicatorEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public AccountAgeIndicatorEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return AccountAgeIndicatorEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("accountAgeIndicator")
    private AccountAgeIndicatorEnum accountAgeIndicator = null;

    @SerializedName("accountChangeDate")
    @JsonAdapter(DateTimeISO8601Serializer.class)
    private Date accountChangeDate = null;

    /**
     * Indicator for the length of time since the shopper&#x27;s account was last updated. Allowed values: * thisTransaction * lessThan30Days * from30To60Days * moreThan60Days
     */
    @JsonAdapter(AccountChangeIndicatorEnum.Adapter.class)
    public enum AccountChangeIndicatorEnum {
        THISTRANSACTION("thisTransaction"),
        LESSTHAN30DAYS("lessThan30Days"),
        FROM30TO60DAYS("from30To60Days"),
        MORETHAN60DAYS("moreThan60Days");

        private String value;

        AccountChangeIndicatorEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static AccountChangeIndicatorEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<AccountChangeIndicatorEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final AccountChangeIndicatorEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public AccountChangeIndicatorEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return AccountChangeIndicatorEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("accountChangeIndicator")
    private AccountChangeIndicatorEnum accountChangeIndicator = null;

    @SerializedName("accountCreationDate")
    @JsonAdapter(DateTimeISO8601Serializer.class)
    private Date accountCreationDate = null;

    /**
     * Indicates the type of account. For example, for a multi-account card product. Allowed values: * notApplicable * credit * debit
     */
    @JsonAdapter(AccountTypeEnum.Adapter.class)
    public enum AccountTypeEnum {
        NOTAPPLICABLE("notApplicable"),
        CREDIT("credit"),
        DEBIT("debit");

        private String value;

        AccountTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static AccountTypeEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<AccountTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final AccountTypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public AccountTypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return AccountTypeEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("accountType")
    private AccountTypeEnum accountType = null;

    @SerializedName("addCardAttemptsDay")
    private Integer addCardAttemptsDay = null;

    @SerializedName("deliveryAddressUsageDate")
    @JsonAdapter(DateTimeISO8601Serializer.class)
    private Date deliveryAddressUsageDate = null;

    /**
     * Indicator for the length of time since this delivery address was first used. Allowed values: * thisTransaction * lessThan30Days * from30To60Days * moreThan60Days
     */
    @JsonAdapter(DeliveryAddressUsageIndicatorEnum.Adapter.class)
    public enum DeliveryAddressUsageIndicatorEnum {
        THISTRANSACTION("thisTransaction"),
        LESSTHAN30DAYS("lessThan30Days"),
        FROM30TO60DAYS("from30To60Days"),
        MORETHAN60DAYS("moreThan60Days");

        private String value;

        DeliveryAddressUsageIndicatorEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static DeliveryAddressUsageIndicatorEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<DeliveryAddressUsageIndicatorEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final DeliveryAddressUsageIndicatorEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public DeliveryAddressUsageIndicatorEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return DeliveryAddressUsageIndicatorEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("deliveryAddressUsageIndicator")
    private DeliveryAddressUsageIndicatorEnum deliveryAddressUsageIndicator = null;

    @SerializedName("homePhone")
    private String homePhone = null;

    @SerializedName("mobilePhone")
    private String mobilePhone = null;

    @SerializedName("passwordChangeDate")
    @JsonAdapter(DateTimeISO8601Serializer.class)
    private Date passwordChangeDate = null;

    /**
     * Indicator when the shopper has changed their password. Allowed values: * notApplicable * thisTransaction * lessThan30Days * from30To60Days * moreThan60Days
     */
    @JsonAdapter(PasswordChangeIndicatorEnum.Adapter.class)
    public enum PasswordChangeIndicatorEnum {
        NOTAPPLICABLE("notApplicable"),
        THISTRANSACTION("thisTransaction"),
        LESSTHAN30DAYS("lessThan30Days"),
        FROM30TO60DAYS("from30To60Days"),
        MORETHAN60DAYS("moreThan60Days");

        private String value;

        PasswordChangeIndicatorEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static PasswordChangeIndicatorEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<PasswordChangeIndicatorEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final PasswordChangeIndicatorEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public PasswordChangeIndicatorEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return PasswordChangeIndicatorEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("passwordChangeIndicator")
    private PasswordChangeIndicatorEnum passwordChangeIndicator = null;

    @SerializedName("pastTransactionsDay")
    private Integer pastTransactionsDay = null;

    @SerializedName("pastTransactionsYear")
    private Integer pastTransactionsYear = null;

    @SerializedName("paymentAccountAge")
    @JsonAdapter(DateTimeISO8601Serializer.class)
    private Date paymentAccountAge = null;

    /**
     * Indicator for the length of time since this payment method was added to this shopper&#x27;s account. Allowed values: * notApplicable * thisTransaction * lessThan30Days * from30To60Days * moreThan60Days
     */
    @JsonAdapter(PaymentAccountIndicatorEnum.Adapter.class)
    public enum PaymentAccountIndicatorEnum {
        NOTAPPLICABLE("notApplicable"),
        THISTRANSACTION("thisTransaction"),
        LESSTHAN30DAYS("lessThan30Days"),
        FROM30TO60DAYS("from30To60Days"),
        MORETHAN60DAYS("moreThan60Days");

        private String value;

        PaymentAccountIndicatorEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static PaymentAccountIndicatorEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<PaymentAccountIndicatorEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final PaymentAccountIndicatorEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public PaymentAccountIndicatorEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return PaymentAccountIndicatorEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("paymentAccountIndicator")
    private PaymentAccountIndicatorEnum paymentAccountIndicator = null;

    @SerializedName("purchasesLast6Months")
    private Integer purchasesLast6Months = null;

    @SerializedName("suspiciousActivity")
    private Boolean suspiciousActivity = null;

    @SerializedName("workPhone")
    private String workPhone = null;


    public AccountInfo accountAgeIndicator(AccountAgeIndicatorEnum accountAgeIndicator) {
        this.accountAgeIndicator = accountAgeIndicator;
        return this;
    }

    /**
     * Indicator for the length of time since this shopper account was created in the merchant&#x27;s environment. Allowed values: * notApplicable * thisTransaction * lessThan30Days * from30To60Days * moreThan60Days
     *
     * @return accountAgeIndicator
     **/
    public AccountAgeIndicatorEnum getAccountAgeIndicator() {
        return accountAgeIndicator;
    }

    public void setAccountAgeIndicator(AccountAgeIndicatorEnum accountAgeIndicator) {
        this.accountAgeIndicator = accountAgeIndicator;
    }

    public AccountInfo accountChangeDate(Date accountChangeDate) {
        this.accountChangeDate = accountChangeDate;
        return this;
    }

    /**
     * Date when the shopper&#x27;s account was last changed.
     *
     * @return accountChangeDate
     **/
    public Date getAccountChangeDate() {
        return accountChangeDate;
    }

    public void setAccountChangeDate(Date accountChangeDate) {
        this.accountChangeDate = accountChangeDate;
    }

    public AccountInfo accountChangeIndicator(AccountChangeIndicatorEnum accountChangeIndicator) {
        this.accountChangeIndicator = accountChangeIndicator;
        return this;
    }

    /**
     * Indicator for the length of time since the shopper&#x27;s account was last updated. Allowed values: * thisTransaction * lessThan30Days * from30To60Days * moreThan60Days
     *
     * @return accountChangeIndicator
     **/
    public AccountChangeIndicatorEnum getAccountChangeIndicator() {
        return accountChangeIndicator;
    }

    public void setAccountChangeIndicator(AccountChangeIndicatorEnum accountChangeIndicator) {
        this.accountChangeIndicator = accountChangeIndicator;
    }

    public AccountInfo accountCreationDate(Date accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
        return this;
    }

    /**
     * Date when the shopper&#x27;s account was created.
     *
     * @return accountCreationDate
     **/
    public Date getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(Date accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public AccountInfo accountType(AccountTypeEnum accountType) {
        this.accountType = accountType;
        return this;
    }

    /**
     * Indicates the type of account. For example, for a multi-account card product. Allowed values: * notApplicable * credit * debit
     *
     * @return accountType
     **/
    public AccountTypeEnum getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountTypeEnum accountType) {
        this.accountType = accountType;
    }

    public AccountInfo addCardAttemptsDay(Integer addCardAttemptsDay) {
        this.addCardAttemptsDay = addCardAttemptsDay;
        return this;
    }

    /**
     * Number of attempts the shopper tried to add a card to their account in the last day.
     *
     * @return addCardAttemptsDay
     **/
    public Integer getAddCardAttemptsDay() {
        return addCardAttemptsDay;
    }

    public void setAddCardAttemptsDay(Integer addCardAttemptsDay) {
        this.addCardAttemptsDay = addCardAttemptsDay;
    }

    public AccountInfo deliveryAddressUsageDate(Date deliveryAddressUsageDate) {
        this.deliveryAddressUsageDate = deliveryAddressUsageDate;
        return this;
    }

    /**
     * Date the selected delivery address was first used.
     *
     * @return deliveryAddressUsageDate
     **/
    public Date getDeliveryAddressUsageDate() {
        return deliveryAddressUsageDate;
    }

    public void setDeliveryAddressUsageDate(Date deliveryAddressUsageDate) {
        this.deliveryAddressUsageDate = deliveryAddressUsageDate;
    }

    public AccountInfo deliveryAddressUsageIndicator(DeliveryAddressUsageIndicatorEnum deliveryAddressUsageIndicator) {
        this.deliveryAddressUsageIndicator = deliveryAddressUsageIndicator;
        return this;
    }

    /**
     * Indicator for the length of time since this delivery address was first used. Allowed values: * thisTransaction * lessThan30Days * from30To60Days * moreThan60Days
     *
     * @return deliveryAddressUsageIndicator
     **/
    public DeliveryAddressUsageIndicatorEnum getDeliveryAddressUsageIndicator() {
        return deliveryAddressUsageIndicator;
    }

    public void setDeliveryAddressUsageIndicator(DeliveryAddressUsageIndicatorEnum deliveryAddressUsageIndicator) {
        this.deliveryAddressUsageIndicator = deliveryAddressUsageIndicator;
    }

    public AccountInfo homePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    /**
     * Shopper&#x27;s home phone number (including the country code).
     *
     * @return homePhone
     **/
    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public AccountInfo mobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    /**
     * Shopper&#x27;s mobile phone number (including the country code).
     *
     * @return mobilePhone
     **/
    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public AccountInfo passwordChangeDate(Date passwordChangeDate) {
        this.passwordChangeDate = passwordChangeDate;
        return this;
    }

    /**
     * Date when the shopper last changed their password.
     *
     * @return passwordChangeDate
     **/
    public Date getPasswordChangeDate() {
        return passwordChangeDate;
    }

    public void setPasswordChangeDate(Date passwordChangeDate) {
        this.passwordChangeDate = passwordChangeDate;
    }

    public AccountInfo passwordChangeIndicator(PasswordChangeIndicatorEnum passwordChangeIndicator) {
        this.passwordChangeIndicator = passwordChangeIndicator;
        return this;
    }

    /**
     * Indicator when the shopper has changed their password. Allowed values: * notApplicable * thisTransaction * lessThan30Days * from30To60Days * moreThan60Days
     *
     * @return passwordChangeIndicator
     **/
    public PasswordChangeIndicatorEnum getPasswordChangeIndicator() {
        return passwordChangeIndicator;
    }

    public void setPasswordChangeIndicator(PasswordChangeIndicatorEnum passwordChangeIndicator) {
        this.passwordChangeIndicator = passwordChangeIndicator;
    }

    public AccountInfo pastTransactionsDay(Integer pastTransactionsDay) {
        this.pastTransactionsDay = pastTransactionsDay;
        return this;
    }

    /**
     * Number of all transactions (successful and abandoned) from this shopper in the past 24 hours.
     *
     * @return pastTransactionsDay
     **/
    public Integer getPastTransactionsDay() {
        return pastTransactionsDay;
    }

    public void setPastTransactionsDay(Integer pastTransactionsDay) {
        this.pastTransactionsDay = pastTransactionsDay;
    }

    public AccountInfo pastTransactionsYear(Integer pastTransactionsYear) {
        this.pastTransactionsYear = pastTransactionsYear;
        return this;
    }

    /**
     * Number of all transactions (successful and abandoned) from this shopper in the past year.
     *
     * @return pastTransactionsYear
     **/
    public Integer getPastTransactionsYear() {
        return pastTransactionsYear;
    }

    public void setPastTransactionsYear(Integer pastTransactionsYear) {
        this.pastTransactionsYear = pastTransactionsYear;
    }

    public AccountInfo paymentAccountAge(Date paymentAccountAge) {
        this.paymentAccountAge = paymentAccountAge;
        return this;
    }

    /**
     * Date this payment method was added to the shopper&#x27;s account.
     *
     * @return paymentAccountAge
     **/
    public Date getPaymentAccountAge() {
        return paymentAccountAge;
    }

    public void setPaymentAccountAge(Date paymentAccountAge) {
        this.paymentAccountAge = paymentAccountAge;
    }

    public AccountInfo paymentAccountIndicator(PaymentAccountIndicatorEnum paymentAccountIndicator) {
        this.paymentAccountIndicator = paymentAccountIndicator;
        return this;
    }

    /**
     * Indicator for the length of time since this payment method was added to this shopper&#x27;s account. Allowed values: * notApplicable * thisTransaction * lessThan30Days * from30To60Days * moreThan60Days
     *
     * @return paymentAccountIndicator
     **/
    public PaymentAccountIndicatorEnum getPaymentAccountIndicator() {
        return paymentAccountIndicator;
    }

    public void setPaymentAccountIndicator(PaymentAccountIndicatorEnum paymentAccountIndicator) {
        this.paymentAccountIndicator = paymentAccountIndicator;
    }

    public AccountInfo purchasesLast6Months(Integer purchasesLast6Months) {
        this.purchasesLast6Months = purchasesLast6Months;
        return this;
    }

    /**
     * Number of successful purchases in the last six months.
     *
     * @return purchasesLast6Months
     **/
    public Integer getPurchasesLast6Months() {
        return purchasesLast6Months;
    }

    public void setPurchasesLast6Months(Integer purchasesLast6Months) {
        this.purchasesLast6Months = purchasesLast6Months;
    }

    public AccountInfo suspiciousActivity(Boolean suspiciousActivity) {
        this.suspiciousActivity = suspiciousActivity;
        return this;
    }

    /**
     * Whether suspicious activity was recorded on this account.
     *
     * @return suspiciousActivity
     **/
    public Boolean isSuspiciousActivity() {
        return suspiciousActivity;
    }

    public void setSuspiciousActivity(Boolean suspiciousActivity) {
        this.suspiciousActivity = suspiciousActivity;
    }

    public AccountInfo workPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    /**
     * Shopper&#x27;s work phone number (including the country code).
     *
     * @return workPhone
     **/
    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountInfo accountInfo = (AccountInfo) o;
        return Objects.equals(this.accountAgeIndicator, accountInfo.accountAgeIndicator) &&
                Objects.equals(this.accountChangeDate, accountInfo.accountChangeDate) &&
                Objects.equals(this.accountChangeIndicator, accountInfo.accountChangeIndicator) &&
                Objects.equals(this.accountCreationDate, accountInfo.accountCreationDate) &&
                Objects.equals(this.accountType, accountInfo.accountType) &&
                Objects.equals(this.addCardAttemptsDay, accountInfo.addCardAttemptsDay) &&
                Objects.equals(this.deliveryAddressUsageDate, accountInfo.deliveryAddressUsageDate) &&
                Objects.equals(this.deliveryAddressUsageIndicator, accountInfo.deliveryAddressUsageIndicator) &&
                Objects.equals(this.homePhone, accountInfo.homePhone) &&
                Objects.equals(this.mobilePhone, accountInfo.mobilePhone) &&
                Objects.equals(this.passwordChangeDate, accountInfo.passwordChangeDate) &&
                Objects.equals(this.passwordChangeIndicator, accountInfo.passwordChangeIndicator) &&
                Objects.equals(this.pastTransactionsDay, accountInfo.pastTransactionsDay) &&
                Objects.equals(this.pastTransactionsYear, accountInfo.pastTransactionsYear) &&
                Objects.equals(this.paymentAccountAge, accountInfo.paymentAccountAge) &&
                Objects.equals(this.paymentAccountIndicator, accountInfo.paymentAccountIndicator) &&
                Objects.equals(this.purchasesLast6Months, accountInfo.purchasesLast6Months) &&
                Objects.equals(this.suspiciousActivity, accountInfo.suspiciousActivity) &&
                Objects.equals(this.workPhone, accountInfo.workPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountAgeIndicator, accountChangeDate, accountChangeIndicator, accountCreationDate, accountType, addCardAttemptsDay, deliveryAddressUsageDate, deliveryAddressUsageIndicator, homePhone, mobilePhone, passwordChangeDate, passwordChangeIndicator, pastTransactionsDay, pastTransactionsYear, paymentAccountAge, paymentAccountIndicator, purchasesLast6Months, suspiciousActivity, workPhone);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountInfo {\n");

        sb.append("    accountAgeIndicator: ").append(toIndentedString(accountAgeIndicator)).append("\n");
        sb.append("    accountChangeDate: ").append(toIndentedString(accountChangeDate)).append("\n");
        sb.append("    accountChangeIndicator: ").append(toIndentedString(accountChangeIndicator)).append("\n");
        sb.append("    accountCreationDate: ").append(toIndentedString(accountCreationDate)).append("\n");
        sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
        sb.append("    addCardAttemptsDay: ").append(toIndentedString(addCardAttemptsDay)).append("\n");
        sb.append("    deliveryAddressUsageDate: ").append(toIndentedString(deliveryAddressUsageDate)).append("\n");
        sb.append("    deliveryAddressUsageIndicator: ").append(toIndentedString(deliveryAddressUsageIndicator)).append("\n");
        sb.append("    homePhone: ").append(toIndentedString(homePhone)).append("\n");
        sb.append("    mobilePhone: ").append(toIndentedString(mobilePhone)).append("\n");
        sb.append("    passwordChangeDate: ").append(toIndentedString(passwordChangeDate)).append("\n");
        sb.append("    passwordChangeIndicator: ").append(toIndentedString(passwordChangeIndicator)).append("\n");
        sb.append("    pastTransactionsDay: ").append(toIndentedString(pastTransactionsDay)).append("\n");
        sb.append("    pastTransactionsYear: ").append(toIndentedString(pastTransactionsYear)).append("\n");
        sb.append("    paymentAccountAge: ").append(toIndentedString(paymentAccountAge)).append("\n");
        sb.append("    paymentAccountIndicator: ").append(toIndentedString(paymentAccountIndicator)).append("\n");
        sb.append("    purchasesLast6Months: ").append(toIndentedString(purchasesLast6Months)).append("\n");
        sb.append("    suspiciousActivity: ").append(toIndentedString(suspiciousActivity)).append("\n");
        sb.append("    workPhone: ").append(toIndentedString(workPhone)).append("\n");
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
