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
package com.adyen.model.marketpay;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * BankAccountDetail
 */
public class BankAccountDetail {
    @SerializedName("ownerNationality")
    private String ownerNationality = null;

    @SerializedName("ownerPostalCode")
    private String ownerPostalCode = null;

    @SerializedName("ownerCountryCode")
    private String ownerCountryCode = null;

    @SerializedName("bankName")
    private String bankName = null;

    @SerializedName("ownerState")
    private String ownerState = null;

    @SerializedName("bankAccountUUID")
    private String bankAccountUUID = null;

    @SerializedName("ownerName")
    private String ownerName = null;

    @SerializedName("bankBicSwift")
    private String bankBicSwift = null;

    @SerializedName("ownerDateOfBirth")
    private String ownerDateOfBirth = null;

    @SerializedName("countryCode")
    private String countryCode = null;

    @SerializedName("ownerStreet")
    private String ownerStreet = null;

    @SerializedName("bankAccountName")
    private String bankAccountName = null;

    @SerializedName("ownerHouseNumberOrName")
    private String ownerHouseNumberOrName = null;

    @SerializedName("bankCode")
    private String bankCode = null;

    @SerializedName("accountType")
    private String accountType = null;

    @SerializedName("accountNumber")
    private String accountNumber = null;

    @SerializedName("primaryAccount")
    private Boolean primaryAccount = null;

    @SerializedName("bankCity")
    private String bankCity = null;

    @SerializedName("checkCode")
    private String checkCode = null;

    @SerializedName("branchCode")
    private String branchCode = null;

    @SerializedName("taxId")
    private String taxId = null;

    @SerializedName("iban")
    private String iban = null;

    @SerializedName("ownerCity")
    private String ownerCity = null;

    @SerializedName("urlForVerification")
    private String urlForVerification = null;

    @SerializedName("currencyCode")
    private String currencyCode = null;

    public BankAccountDetail ownerNationality(String ownerNationality) {
        this.ownerNationality = ownerNationality;
        return this;
    }

    /**
     * the bank account holder nationality
     *
     * @return ownerNationality
     **/
    public String getOwnerNationality() {
        return ownerNationality;
    }

    public void setOwnerNationality(String ownerNationality) {
        this.ownerNationality = ownerNationality;
    }

    public BankAccountDetail ownerPostalCode(String ownerPostalCode) {
        this.ownerPostalCode = ownerPostalCode;
        return this;
    }

    /**
     * the bank account holder postal code
     *
     * @return ownerPostalCode
     **/
    public String getOwnerPostalCode() {
        return ownerPostalCode;
    }

    public void setOwnerPostalCode(String ownerPostalCode) {
        this.ownerPostalCode = ownerPostalCode;
    }

    public BankAccountDetail ownerCountryCode(String ownerCountryCode) {
        this.ownerCountryCode = ownerCountryCode;
        return this;
    }

    /**
     * the bank account holder two letter country code (ISO 3166-1)
     *
     * @return ownerCountryCode
     **/
    public String getOwnerCountryCode() {
        return ownerCountryCode;
    }

    public void setOwnerCountryCode(String ownerCountryCode) {
        this.ownerCountryCode = ownerCountryCode;
    }

    public BankAccountDetail bankName(String bankName) {
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

    public BankAccountDetail ownerState(String ownerState) {
        this.ownerState = ownerState;
        return this;
    }

    /**
     * the bank account holder state
     *
     * @return ownerState
     **/
    public String getOwnerState() {
        return ownerState;
    }

    public void setOwnerState(String ownerState) {
        this.ownerState = ownerState;
    }

    public BankAccountDetail bankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
        return this;
    }

    /**
     * the bank account unique identifier, generated on bank account creation
     *
     * @return bankAccountUUID
     **/
    public String getBankAccountUUID() {
        return bankAccountUUID;
    }

    public void setBankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
    }

    public BankAccountDetail ownerName(String ownerName) {
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

    public BankAccountDetail bankBicSwift(String bankBicSwift) {
        this.bankBicSwift = bankBicSwift;
        return this;
    }

    /**
     * the bank identifier code
     *
     * @return bankBicSwift
     **/
    public String getBankBicSwift() {
        return bankBicSwift;
    }

    public void setBankBicSwift(String bankBicSwift) {
        this.bankBicSwift = bankBicSwift;
    }

    public BankAccountDetail ownerDateOfBirth(String ownerDateOfBirth) {
        this.ownerDateOfBirth = ownerDateOfBirth;
        return this;
    }

    /**
     * the bank account holder date of birth
     *
     * @return ownerDateOfBirth
     **/
    public String getOwnerDateOfBirth() {
        return ownerDateOfBirth;
    }

    public void setOwnerDateOfBirth(String ownerDateOfBirth) {
        this.ownerDateOfBirth = ownerDateOfBirth;
    }

    public BankAccountDetail countryCode(String countryCode) {
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

    public BankAccountDetail ownerStreet(String ownerStreet) {
        this.ownerStreet = ownerStreet;
        return this;
    }

    /**
     * the bank account holder street name
     *
     * @return ownerStreet
     **/
    public String getOwnerStreet() {
        return ownerStreet;
    }

    public void setOwnerStreet(String ownerStreet) {
        this.ownerStreet = ownerStreet;
    }

    public BankAccountDetail bankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
        return this;
    }

    /**
     * the name of the bank account
     *
     * @return bankAccountName
     **/
    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public BankAccountDetail ownerHouseNumberOrName(String ownerHouseNumberOrName) {
        this.ownerHouseNumberOrName = ownerHouseNumberOrName;
        return this;
    }

    /**
     * the bank account holder house name or number
     *
     * @return ownerHouseNumberOrName
     **/
    public String getOwnerHouseNumberOrName() {
        return ownerHouseNumberOrName;
    }

    public void setOwnerHouseNumberOrName(String ownerHouseNumberOrName) {
        this.ownerHouseNumberOrName = ownerHouseNumberOrName;
    }

    public BankAccountDetail bankCode(String bankCode) {
        this.bankCode = bankCode;
        return this;
    }

    /**
     * the bank code
     *
     * @return bankCode
     **/
    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public BankAccountDetail accountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    /**
     * The type of payout account
     *
     * @return accountType
     **/
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BankAccountDetail accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    /**
     * the bank account number (without separators)
     *
     * @return accountNumber
     **/
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankAccountDetail primaryAccount(Boolean primaryAccount) {
        this.primaryAccount = primaryAccount;
        return this;
    }

    /**
     * indicates if current bank account is a primary account
     *
     * @return primaryAccount
     **/
    public Boolean getPrimaryAccount() {
        return primaryAccount;
    }

    public void setPrimaryAccount(Boolean primaryAccount) {
        this.primaryAccount = primaryAccount;
    }

    public BankAccountDetail bankCity(String bankCity) {
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

    public BankAccountDetail checkCode(String checkCode) {
        this.checkCode = checkCode;
        return this;
    }

    /**
     * the check code
     *
     * @return checkCode
     **/
    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public BankAccountDetail branchCode(String branchCode) {
        this.branchCode = branchCode;
        return this;
    }

    /**
     * the branch code
     *
     * @return branchCode
     **/
    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public BankAccountDetail taxId(String taxId) {
        this.taxId = taxId;
        return this;
    }

    /**
     * the tax identification number, mandatory only for BR and MX
     *
     * @return taxId
     **/
    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public BankAccountDetail iban(String iban) {
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

    public BankAccountDetail ownerCity(String ownerCity) {
        this.ownerCity = ownerCity;
        return this;
    }

    /**
     * the bank account holder city
     *
     * @return ownerCity
     **/
    public String getOwnerCity() {
        return ownerCity;
    }

    public void setOwnerCity(String ownerCity) {
        this.ownerCity = ownerCity;
    }

    public BankAccountDetail urlForVerification(String urlForVerification) {
        this.urlForVerification = urlForVerification;
        return this;
    }

    /**
     * URL to be used for bank account verification, generated on bank account creation
     *
     * @return urlForVerification
     **/
    public String getUrlForVerification() {
        return urlForVerification;
    }

    public void setUrlForVerification(String urlForVerification) {
        this.urlForVerification = urlForVerification;
    }

    public BankAccountDetail currencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    /**
     * the bank account currency
     *
     * @return currencyCode
     **/
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankAccountDetail bankAccountDetail = (BankAccountDetail) o;
        return Objects.equals(this.ownerNationality, bankAccountDetail.ownerNationality)
                && Objects.equals(this.ownerPostalCode, bankAccountDetail.ownerPostalCode)
                && Objects.equals(this.ownerCountryCode, bankAccountDetail.ownerCountryCode)
                && Objects.equals(this.bankName, bankAccountDetail.bankName)
                && Objects.equals(this.ownerState, bankAccountDetail.ownerState)
                && Objects.equals(this.bankAccountUUID, bankAccountDetail.bankAccountUUID)
                && Objects.equals(this.ownerName, bankAccountDetail.ownerName)
                && Objects.equals(this.bankBicSwift, bankAccountDetail.bankBicSwift)
                && Objects.equals(this.ownerDateOfBirth, bankAccountDetail.ownerDateOfBirth)
                && Objects.equals(this.countryCode, bankAccountDetail.countryCode)
                && Objects.equals(this.ownerStreet, bankAccountDetail.ownerStreet)
                && Objects.equals(this.bankAccountName, bankAccountDetail.bankAccountName)
                && Objects.equals(this.ownerHouseNumberOrName, bankAccountDetail.ownerHouseNumberOrName)
                && Objects.equals(this.bankCode, bankAccountDetail.bankCode)
                && Objects.equals(this.accountType, bankAccountDetail.accountType)
                && Objects.equals(this.accountNumber, bankAccountDetail.accountNumber)
                && Objects.equals(this.primaryAccount, bankAccountDetail.primaryAccount)
                && Objects.equals(this.bankCity, bankAccountDetail.bankCity)
                && Objects.equals(this.checkCode, bankAccountDetail.checkCode)
                && Objects.equals(this.branchCode, bankAccountDetail.branchCode)
                && Objects.equals(this.taxId, bankAccountDetail.taxId)
                && Objects.equals(this.iban, bankAccountDetail.iban)
                && Objects.equals(this.ownerCity, bankAccountDetail.ownerCity)
                && Objects.equals(this.urlForVerification, bankAccountDetail.urlForVerification)
                && Objects.equals(this.currencyCode, bankAccountDetail.currencyCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerNationality,
                            ownerPostalCode,
                            ownerCountryCode,
                            bankName,
                            ownerState,
                            bankAccountUUID,
                            ownerName,
                            bankBicSwift,
                            ownerDateOfBirth,
                            countryCode,
                            ownerStreet,
                            bankAccountName,
                            ownerHouseNumberOrName,
                            bankCode,
                            accountType,
                            accountNumber,
                            primaryAccount,
                            bankCity,
                            checkCode,
                            branchCode,
                            taxId,
                            iban,
                            ownerCity,
                            urlForVerification,
                            currencyCode);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BankAccountDetail {\n");

        sb.append("    ownerNationality: ").append(toIndentedString(ownerNationality)).append("\n");
        sb.append("    ownerPostalCode: ").append(toIndentedString(ownerPostalCode)).append("\n");
        sb.append("    ownerCountryCode: ").append(toIndentedString(ownerCountryCode)).append("\n");
        sb.append("    bankName: ").append(toIndentedString(bankName)).append("\n");
        sb.append("    ownerState: ").append(toIndentedString(ownerState)).append("\n");
        sb.append("    bankAccountUUID: ").append(toIndentedString(bankAccountUUID)).append("\n");
        sb.append("    ownerName: ").append(toIndentedString(ownerName)).append("\n");
        sb.append("    bankBicSwift: ").append(toIndentedString(bankBicSwift)).append("\n");
        sb.append("    ownerDateOfBirth: ").append(toIndentedString(ownerDateOfBirth)).append("\n");
        sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
        sb.append("    ownerStreet: ").append(toIndentedString(ownerStreet)).append("\n");
        sb.append("    bankAccountName: ").append(toIndentedString(bankAccountName)).append("\n");
        sb.append("    ownerHouseNumberOrName: ").append(toIndentedString(ownerHouseNumberOrName)).append("\n");
        sb.append("    bankCode: ").append(toIndentedString(bankCode)).append("\n");
        sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
        sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
        sb.append("    primaryAccount: ").append(toIndentedString(primaryAccount)).append("\n");
        sb.append("    bankCity: ").append(toIndentedString(bankCity)).append("\n");
        sb.append("    checkCode: ").append(toIndentedString(checkCode)).append("\n");
        sb.append("    branchCode: ").append(toIndentedString(branchCode)).append("\n");
        sb.append("    taxId: ").append(toIndentedString(taxId)).append("\n");
        sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
        sb.append("    ownerCity: ").append(toIndentedString(ownerCity)).append("\n");
        sb.append("    urlForVerification: ").append(toIndentedString(urlForVerification)).append("\n");
        sb.append("    currencyCode: ").append(toIndentedString(currencyCode)).append("\n");
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

