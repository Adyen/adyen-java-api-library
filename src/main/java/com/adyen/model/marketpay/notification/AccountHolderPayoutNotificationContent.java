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

package com.adyen.model.marketpay.notification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.adyen.model.Amount;
import com.adyen.model.marketpay.BankAccountDetail;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import static com.adyen.util.Util.toIndentedString;

/**
 * AccountHolderPayoutNotificationContent
 */

public class AccountHolderPayoutNotificationContent {
    @SerializedName("accountCode")
    private String accountCode = null;

    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("amounts")
    private List<Amount> amounts = null;

    @SerializedName("bankAccountDetail")
    private BankAccountDetail bankAccountDetail = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("estimatedArrivalDate")
    private LocalDate estimatedArrivalDate = null;

    @SerializedName("invalidFields")
    private List<ErrorFieldType> invalidFields = null;

    @SerializedName("merchantReference")
    private String merchantReference = null;

    @SerializedName("originalPspReference")
    private String originalPspReference = null;

    @SerializedName("payoutAccountCountry")
    private String payoutAccountCountry = null;

    @SerializedName("payoutAccountNumber")
    private String payoutAccountNumber = null;

    @SerializedName("payoutBankName")
    private String payoutBankName = null;

    @SerializedName("payoutBranchCode")
    private String payoutBranchCode = null;

    @SerializedName("payoutReference")
    private Long payoutReference = null;

    /**
     * Speed with which payouts for this account are processed. Permitted values: &#x60;STANDARD&#x60;, &#x60;SAME_DAY&#x60;.
     */
    @JsonAdapter(PayoutSpeedEnum.Adapter.class)
    public enum PayoutSpeedEnum {
        INSTANT("INSTANT"),
        SAME_DAY("SAME_DAY"),
        STANDARD("STANDARD");

        private String value;

        PayoutSpeedEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static PayoutSpeedEnum fromValue(String text) {
            for (PayoutSpeedEnum b : PayoutSpeedEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<PayoutSpeedEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final PayoutSpeedEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public PayoutSpeedEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return PayoutSpeedEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("payoutSpeed")
    private PayoutSpeedEnum payoutSpeed = null;

    @SerializedName("status")
    private OperationStatus status = null;

    public AccountHolderPayoutNotificationContent accountCode(String accountCode) {
        this.accountCode = accountCode;
        return this;
    }

    /**
     * The code of the account from which the payout was made.
     *
     * @return accountCode
     **/
    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public AccountHolderPayoutNotificationContent accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * The code of the Account Holder to which the payout was made.
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public AccountHolderPayoutNotificationContent amounts(List<Amount> amounts) {
        this.amounts = amounts;
        return this;
    }

    public AccountHolderPayoutNotificationContent addAmountsItem(Amount amountsItem) {
        if (this.amounts == null) {
            this.amounts = new ArrayList<Amount>();
        }
        this.amounts.add(amountsItem);
        return this;
    }

    /**
     * The payout amounts (per currency).
     *
     * @return amounts
     **/
    public List<Amount> getAmounts() {
        return amounts;
    }

    public void setAmounts(List<Amount> amounts) {
        this.amounts = amounts;
    }

    public AccountHolderPayoutNotificationContent bankAccountDetail(BankAccountDetail bankAccountDetail) {
        this.bankAccountDetail = bankAccountDetail;
        return this;
    }

    /**
     * Get bankAccountDetail
     *
     * @return bankAccountDetail
     **/
    public BankAccountDetail getBankAccountDetail() {
        return bankAccountDetail;
    }

    public void setBankAccountDetail(BankAccountDetail bankAccountDetail) {
        this.bankAccountDetail = bankAccountDetail;
    }

    public AccountHolderPayoutNotificationContent description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the payout.
     *
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AccountHolderPayoutNotificationContent estimatedArrivalDate(LocalDate estimatedArrivalDate) {
        this.estimatedArrivalDate = estimatedArrivalDate;
        return this;
    }

    /**
     * Get estimatedArrivalDate
     *
     * @return estimatedArrivalDate
     **/
    public LocalDate getEstimatedArrivalDate() {
        return estimatedArrivalDate;
    }

    public void setEstimatedArrivalDate(LocalDate estimatedArrivalDate) {
        this.estimatedArrivalDate = estimatedArrivalDate;
    }

    public AccountHolderPayoutNotificationContent invalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
        return this;
    }

    public AccountHolderPayoutNotificationContent addInvalidFieldsItem(ErrorFieldType invalidFieldsItem) {
        if (this.invalidFields == null) {
            this.invalidFields = new ArrayList<ErrorFieldType>();
        }
        this.invalidFields.add(invalidFieldsItem);
        return this;
    }

    /**
     * Invalid fields list.
     *
     * @return invalidFields
     **/
    public List<ErrorFieldType> getInvalidFields() {
        return invalidFields;
    }

    public void setInvalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
    }

    public AccountHolderPayoutNotificationContent merchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
        return this;
    }

    /**
     * The merchant reference.
     *
     * @return merchantReference
     **/
    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }

    public AccountHolderPayoutNotificationContent originalPspReference(String originalPspReference) {
        this.originalPspReference = originalPspReference;
        return this;
    }

    /**
     * The PSP reference of the original payout.
     *
     * @return originalPspReference
     **/
    public String getOriginalPspReference() {
        return originalPspReference;
    }

    public void setOriginalPspReference(String originalPspReference) {
        this.originalPspReference = originalPspReference;
    }

    public AccountHolderPayoutNotificationContent payoutAccountCountry(String payoutAccountCountry) {
        this.payoutAccountCountry = payoutAccountCountry;
        return this;
    }

    /**
     * Payout account country.
     *
     * @return payoutAccountCountry
     **/
    public String getPayoutAccountCountry() {
        return payoutAccountCountry;
    }

    public void setPayoutAccountCountry(String payoutAccountCountry) {
        this.payoutAccountCountry = payoutAccountCountry;
    }

    public AccountHolderPayoutNotificationContent payoutAccountNumber(String payoutAccountNumber) {
        this.payoutAccountNumber = payoutAccountNumber;
        return this;
    }

    /**
     * Payout bank account number.
     *
     * @return payoutAccountNumber
     **/
    public String getPayoutAccountNumber() {
        return payoutAccountNumber;
    }

    public void setPayoutAccountNumber(String payoutAccountNumber) {
        this.payoutAccountNumber = payoutAccountNumber;
    }

    public AccountHolderPayoutNotificationContent payoutBankName(String payoutBankName) {
        this.payoutBankName = payoutBankName;
        return this;
    }

    /**
     * Payout bank name.
     *
     * @return payoutBankName
     **/
    public String getPayoutBankName() {
        return payoutBankName;
    }

    public void setPayoutBankName(String payoutBankName) {
        this.payoutBankName = payoutBankName;
    }

    public AccountHolderPayoutNotificationContent payoutBranchCode(String payoutBranchCode) {
        this.payoutBranchCode = payoutBranchCode;
        return this;
    }

    /**
     * Payout branch code.
     *
     * @return payoutBranchCode
     **/
    public String getPayoutBranchCode() {
        return payoutBranchCode;
    }

    public void setPayoutBranchCode(String payoutBranchCode) {
        this.payoutBranchCode = payoutBranchCode;
    }

    public AccountHolderPayoutNotificationContent payoutReference(Long payoutReference) {
        this.payoutReference = payoutReference;
        return this;
    }

    /**
     * Payout transaction id.
     *
     * @return payoutReference
     **/
    public Long getPayoutReference() {
        return payoutReference;
    }

    public void setPayoutReference(Long payoutReference) {
        this.payoutReference = payoutReference;
    }

    public AccountHolderPayoutNotificationContent payoutSpeed(PayoutSpeedEnum payoutSpeed) {
        this.payoutSpeed = payoutSpeed;
        return this;
    }

    /**
     * Speed with which payouts for this account are processed. Permitted values: &#x60;STANDARD&#x60;, &#x60;SAME_DAY&#x60;.
     *
     * @return payoutSpeed
     **/
    public PayoutSpeedEnum getPayoutSpeed() {
        return payoutSpeed;
    }

    public void setPayoutSpeed(PayoutSpeedEnum payoutSpeed) {
        this.payoutSpeed = payoutSpeed;
    }

    public AccountHolderPayoutNotificationContent status(OperationStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     **/
    public OperationStatus getStatus() {
        return status;
    }

    public void setStatus(OperationStatus status) {
        this.status = status;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountHolderPayoutNotificationContent accountHolderPayoutNotificationContent = (AccountHolderPayoutNotificationContent) o;
        return Objects.equals(this.accountCode, accountHolderPayoutNotificationContent.accountCode) &&
                Objects.equals(this.accountHolderCode, accountHolderPayoutNotificationContent.accountHolderCode) &&
                Objects.equals(this.amounts, accountHolderPayoutNotificationContent.amounts) &&
                Objects.equals(this.bankAccountDetail, accountHolderPayoutNotificationContent.bankAccountDetail) &&
                Objects.equals(this.description, accountHolderPayoutNotificationContent.description) &&
                Objects.equals(this.estimatedArrivalDate, accountHolderPayoutNotificationContent.estimatedArrivalDate) &&
                Objects.equals(this.invalidFields, accountHolderPayoutNotificationContent.invalidFields) &&
                Objects.equals(this.merchantReference, accountHolderPayoutNotificationContent.merchantReference) &&
                Objects.equals(this.originalPspReference, accountHolderPayoutNotificationContent.originalPspReference) &&
                Objects.equals(this.payoutAccountCountry, accountHolderPayoutNotificationContent.payoutAccountCountry) &&
                Objects.equals(this.payoutAccountNumber, accountHolderPayoutNotificationContent.payoutAccountNumber) &&
                Objects.equals(this.payoutBankName, accountHolderPayoutNotificationContent.payoutBankName) &&
                Objects.equals(this.payoutBranchCode, accountHolderPayoutNotificationContent.payoutBranchCode) &&
                Objects.equals(this.payoutReference, accountHolderPayoutNotificationContent.payoutReference) &&
                Objects.equals(this.payoutSpeed, accountHolderPayoutNotificationContent.payoutSpeed) &&
                Objects.equals(this.status, accountHolderPayoutNotificationContent.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountCode, accountHolderCode, amounts, bankAccountDetail, description, estimatedArrivalDate, invalidFields, merchantReference, originalPspReference, payoutAccountCountry, payoutAccountNumber, payoutBankName, payoutBranchCode, payoutReference, payoutSpeed, status);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountHolderPayoutNotificationContent {\n");

        sb.append("    accountCode: ").append(toIndentedString(accountCode)).append("\n");
        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    amounts: ").append(toIndentedString(amounts)).append("\n");
        sb.append("    bankAccountDetail: ").append(toIndentedString(bankAccountDetail)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    estimatedArrivalDate: ").append(toIndentedString(estimatedArrivalDate)).append("\n");
        sb.append("    invalidFields: ").append(toIndentedString(invalidFields)).append("\n");
        sb.append("    merchantReference: ").append(toIndentedString(merchantReference)).append("\n");
        sb.append("    originalPspReference: ").append(toIndentedString(originalPspReference)).append("\n");
        sb.append("    payoutAccountCountry: ").append(toIndentedString(payoutAccountCountry)).append("\n");
        sb.append("    payoutAccountNumber: ").append(toIndentedString(payoutAccountNumber)).append("\n");
        sb.append("    payoutBankName: ").append(toIndentedString(payoutBankName)).append("\n");
        sb.append("    payoutBranchCode: ").append(toIndentedString(payoutBranchCode)).append("\n");
        sb.append("    payoutReference: ").append(toIndentedString(payoutReference)).append("\n");
        sb.append("    payoutSpeed: ").append(toIndentedString(payoutSpeed)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
