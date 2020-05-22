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

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * BankAccount
 */
public class BankAccount {
    @SerializedName("iban")
    private String iban = null;

    @SerializedName("ownerName")
    private String ownerName = null;

    @SerializedName("bankName")
    private String bankName = null;

    @SerializedName("taxId")
    private String taxId = null;

    @SerializedName("bankCity")
    private String bankCity = null;

    @SerializedName("countryCode")
    private String countryCode = null;

    @SerializedName("bankAccountNumber")
    private String bankAccountNumber = null;

    @SerializedName("bankLocationId")
    private String bankLocationId = null;

    @SerializedName("bic")
    private String bic = null;

    public BankAccount iban(String iban) {
        this.iban = iban;
        return this;
    }

    /**
     * the international bank account number
     *
     * @return iban
     **/
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public BankAccount ownerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    /**
     * the bank account holder name
     *
     * @return ownerName
     **/
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public BankAccount bankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    /**
     * the name of the bank
     *
     * @return bankName
     **/
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public BankAccount taxId(String taxId) {
        this.taxId = taxId;
        return this;
    }

    /**
     * the bank account holder TAX id
     *
     * @return taxId
     **/
    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public BankAccount bankCity(String bankCity) {
        this.bankCity = bankCity;
        return this;
    }

    /**
     * the bank city
     *
     * @return bankCity
     **/
    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    public BankAccount countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    /**
     * the two letter country code where the bank account is located (ISO 3166-1)
     *
     * @return countryCode
     **/
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public BankAccount bankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
        return this;
    }

    /**
     * the bank account number (without separators)
     *
     * @return bankAccountNumber
     **/
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public BankAccount bankLocationId(String bankLocationId) {
        this.bankLocationId = bankLocationId;
        return this;
    }

    /**
     * the bank transit routing number
     *
     * @return bankLocationId
     **/
    public String getBankLocationId() {
        return bankLocationId;
    }

    public void setBankLocationId(String bankLocationId) {
        this.bankLocationId = bankLocationId;
    }

    public BankAccount bic(String bic) {
        this.bic = bic;
        return this;
    }

    /**
     * the business identifier code
     *
     * @return bic
     **/
    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        BankAccount bankAccount = (BankAccount) o;
        return Objects.equals(this.iban, bankAccount.iban)
                && Objects.equals(this.ownerName, bankAccount.ownerName)
                && Objects.equals(this.bankName, bankAccount.bankName)
                && Objects.equals(this.taxId,
                                  bankAccount.taxId)
                && Objects.equals(this.bankCity, bankAccount.bankCity)
                && Objects.equals(this.countryCode, bankAccount.countryCode)
                && Objects.equals(this.bankAccountNumber, bankAccount.bankAccountNumber)
                && Objects.equals(this.bankLocationId, bankAccount.bankLocationId)
                && Objects.equals(this.bic, bankAccount.bic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, ownerName, bankName, taxId, bankCity, countryCode, bankAccountNumber, bankLocationId, bic);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BankAccount {").append(TextConstants.LINE_BREAK);

        sb.append("    iban: ").append(Util.toIndentedString(iban)).append(TextConstants.LINE_BREAK);
        sb.append("    ownerName: ").append(Util.toIndentedString(ownerName)).append(TextConstants.LINE_BREAK);
        sb.append("    bankName: ").append(Util.toIndentedString(bankName)).append(TextConstants.LINE_BREAK);
        sb.append("    taxId: ").append(Util.toIndentedString(taxId)).append(TextConstants.LINE_BREAK);
        sb.append("    bankCity: ").append(Util.toIndentedString(bankCity)).append(TextConstants.LINE_BREAK);
        sb.append("    countryCode: ").append(Util.toIndentedString(countryCode)).append(TextConstants.LINE_BREAK);
        sb.append("    bankAccountNumber: ").append(Util.toIndentedString(bankAccountNumber)).append(TextConstants.LINE_BREAK);
        sb.append("    bankLocationId: ").append(Util.toIndentedString(bankLocationId)).append(TextConstants.LINE_BREAK);
        sb.append("    bic: ").append(Util.toIndentedString(bic)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }

}

