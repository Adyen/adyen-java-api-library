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
package com.adyen.model;

//import org.threeten.bp.OffsetDateTime;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import com.adyen.serializer.DateSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;


/**
 * AccountInfo
 */
public class AccountInfo {

    /**
     * Gets or Sets accountAgeIndicator
     */
    @JsonAdapter(AccountAgeIndicatorEnum.Adapter.class)
    public enum AccountAgeIndicatorEnum {

        FROM30TO60DAYS("from30To60Days"),
        LESSTHAN30DAYS("lessThan30Days"),
        MORETHAN60DAYS("moreThan60Days"),
        NOTAPPLICABLE("notApplicable"),
        THISTRANSACTION("thisTransaction");

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
            for (AccountAgeIndicatorEnum b : AccountAgeIndicatorEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
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
    @JsonAdapter(DateSerializer.class)
    private Date accountChangeDate = null;

    /**
     * Gets or Sets accountChangeIndicator
     */
    @JsonAdapter(AccountChangeIndicatorEnum.Adapter.class)
    public enum AccountChangeIndicatorEnum {

        FROM30TO60DAYS("from30To60Days"),
        LESSTHAN30DAYS("lessThan30Days"),
        MORETHAN60DAYS("moreThan60Days"),
        THISTRANSACTION("thisTransaction");

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
            for (AccountChangeIndicatorEnum b : AccountChangeIndicatorEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
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
    private Date accountCreationDate = null;

    @SerializedName("addCardAttemptsDay")
    private Integer addCardAttemptsDay = null;

    @SerializedName("deliveryAddressUsageDate")
    private Date deliveryAddressUsageDate = null;

    /**
     * Gets or Sets deliveryAddressUsageIndicator
     */
    @JsonAdapter(DeliveryAddressUsageIndicatorEnum.Adapter.class)
    public enum DeliveryAddressUsageIndicatorEnum {

        FROM30TO60DAYS("from30To60Days"),
        LESSTHAN30DAYS("lessThan30Days"),
        MORETHAN60DAYS("moreThan60Days"),
        THISTRANSACTION("thisTransaction");

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
            for (DeliveryAddressUsageIndicatorEnum b : DeliveryAddressUsageIndicatorEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
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
    @JsonAdapter(DateSerializer.class)
    private Date passwordChangeDate = null;

    /**
     * Gets or Sets passwordChangeIndicator
     */
    @JsonAdapter(PasswordChangeIndicatorEnum.Adapter.class)
    public enum PasswordChangeIndicatorEnum {

        FROM30TO60DAYS("from30To60Days"),
        LESSTHAN30DAYS("lessThan30Days"),
        MORETHAN60DAYS("moreThan60Days"),
        NOTAPPLICABLE("notApplicable"),
        THISTRANSACTION("thisTransaction");

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
            for (PasswordChangeIndicatorEnum b : PasswordChangeIndicatorEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
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
    @JsonAdapter(DateSerializer.class)
    private Date paymentAccountAge = null;

    /**
     * Gets or Sets paymentAccountIndicator
     */
    @JsonAdapter(PaymentAccountIndicatorEnum.Adapter.class)
    public enum PaymentAccountIndicatorEnum {

        FROM30TO60DAYS("from30To60Days"),
        LESSTHAN30DAYS("lessThan30Days"),
        MORETHAN60DAYS("moreThan60Days"),
        NOTAPPLICABLE("notApplicable"),
        THISTRANSACTION("thisTransaction");

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
            for (PaymentAccountIndicatorEnum b : PaymentAccountIndicatorEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
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

    public Date getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(Date accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public AccountInfo addCardAttemptsDay(Integer addCardAttemptsDay) {
        this.addCardAttemptsDay = addCardAttemptsDay;
        return this;
    }

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
        return Objects.hash(accountAgeIndicator, accountChangeDate, accountChangeIndicator, accountCreationDate, addCardAttemptsDay, deliveryAddressUsageDate, deliveryAddressUsageIndicator, homePhone, mobilePhone, passwordChangeDate, passwordChangeIndicator, pastTransactionsDay, pastTransactionsYear, paymentAccountAge, paymentAccountIndicator, purchasesLast6Months, suspiciousActivity, workPhone);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountInfo {\n");

        sb.append("    accountAgeIndicator: ").append(toIndentedString(accountAgeIndicator)).append("\n");
        sb.append("    accountChangeDate: ").append(toIndentedString(accountChangeDate)).append("\n");
        sb.append("    accountChangeIndicator: ").append(toIndentedString(accountChangeIndicator)).append("\n");
        sb.append("    accountCreationDate: ").append(toIndentedString(accountCreationDate)).append("\n");
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



