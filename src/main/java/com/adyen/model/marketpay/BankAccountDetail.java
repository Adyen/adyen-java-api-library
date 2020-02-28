
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

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * BankAccountDetail
 */
public class BankAccountDetail {
    @SerializedName("accountNumber")
    private String accountNumber = null;

    @SerializedName("accountType")
    private String accountType = null;

    @SerializedName("bankAccountName")
    private String bankAccountName = null;

    @SerializedName("bankAccountReference")
    private String bankAccountReference = null;

    @SerializedName("bankAccountUUID")
    private String bankAccountUUID = null;

    @SerializedName("bankBicSwift")
    private String bankBicSwift = null;

    @SerializedName("bankCity")
    private String bankCity = null;

    @SerializedName("bankCode")
    private String bankCode = null;

    @SerializedName("bankName")
    private String bankName = null;

    @SerializedName("branchCode")
    private String branchCode = null;

    @SerializedName("checkCode")
    private String checkCode = null;

    @SerializedName("countryCode")
    private String countryCode = null;

    @SerializedName("currencyCode")
    private String currencyCode = null;

    @SerializedName("iban")
    private String iban = null;

    @SerializedName("ownerCity")
    private String ownerCity = null;

    @SerializedName("ownerCountryCode")
    private String ownerCountryCode = null;

    @SerializedName("ownerDateOfBirth")
    private String ownerDateOfBirth = null;

    @SerializedName("ownerHouseNumberOrName")
    private String ownerHouseNumberOrName = null;

    @SerializedName("ownerName")
    private String ownerName = null;

    @SerializedName("ownerNationality")
    private String ownerNationality = null;

    @SerializedName("ownerPostalCode")
    private String ownerPostalCode = null;

    @SerializedName("ownerState")
    private String ownerState = null;

    @SerializedName("ownerStreet")
    private String ownerStreet = null;

    @SerializedName("primaryAccount")
    private Boolean primaryAccount = null;

    @SerializedName("taxId")
    private String taxId = null;

    @SerializedName("urlForVerification")
    private String urlForVerification = null;

    public BankAccountDetail accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    /**
     * The bank account number (without separators). &gt;Refer to the [Onboarding and verification](https://docs.adyen.com/marketpay/onboarding-and-verification) section for details on field requirements.
     *
     * @return accountNumber
     **/
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankAccountDetail accountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    /**
     * The type of bank account. Only applicable to bank accounts held in the USA. The permitted values are: &#x60;checking&#x60;, &#x60;savings&#x60;.  &gt;Refer to the [Onboarding and verification](https://docs.adyen.com/marketpay/onboarding-and-verification) section for details on field requirements.
     *
     * @return accountType
     **/
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BankAccountDetail bankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
        return this;
    }

    /**
     * The name of the bank account.
     *
     * @return bankAccountName
     **/
    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public BankAccountDetail bankAccountReference(String bankAccountReference) {
        this.bankAccountReference = bankAccountReference;
        return this;
    }

    /**
     * Merchant reference to the bank account.
     *
     * @return bankAccountReference
     **/
    public String getBankAccountReference() {
        return bankAccountReference;
    }

    public void setBankAccountReference(String bankAccountReference) {
        this.bankAccountReference = bankAccountReference;
    }

    public BankAccountDetail bankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
        return this;
    }

    /**
     * The unique identifier (UUID) of the Bank Account. &gt;If, during an account holder create or update request, this field is left blank (but other fields provided), a new Bank Account will be created with a procedurally-generated UUID.  &gt;If, during an account holder create request, a UUID is provided, the creation of the Bank Account will fail while the creation of the account holder will continue.  &gt;If, during an account holder update request, a UUID that is not correlated with an existing Bank Account is provided, the update of the account holder will fail.  &gt;If, during an account holder update request, a UUID that is correlated with an existing Bank Account is provided, the existing Bank Account will be updated.
     *
     * @return bankAccountUUID
     **/
    public String getBankAccountUUID() {
        return bankAccountUUID;
    }

    public void setBankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
    }

    public BankAccountDetail bankBicSwift(String bankBicSwift) {
        this.bankBicSwift = bankBicSwift;
        return this;
    }

    /**
     * The bank identifier code. &gt;Refer to the [Onboarding and verification](https://docs.adyen.com/marketpay/onboarding-and-verification) section for details on field requirements.
     *
     * @return bankBicSwift
     **/
    public String getBankBicSwift() {
        return bankBicSwift;
    }

    public void setBankBicSwift(String bankBicSwift) {
        this.bankBicSwift = bankBicSwift;
    }

    public BankAccountDetail bankCity(String bankCity) {
        this.bankCity = bankCity;
        return this;
    }

    /**
     * The city in which the bank branch is located.  &gt;Refer to the [Onboarding and verification](https://docs.adyen.com/marketpay/onboarding-and-verification) section for details on field requirements.
     *
     * @return bankCity
     **/
    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    public BankAccountDetail bankCode(String bankCode) {
        this.bankCode = bankCode;
        return this;
    }

    /**
     * The bank code of the banking institution with which the bank account is registered.  &gt;Refer to the [Onboarding and verification](https://docs.adyen.com/marketpay/onboarding-and-verification) section for details on field requirements.
     *
     * @return bankCode
     **/
    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public BankAccountDetail bankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    /**
     * The name of the banking institution with which the bank account is held.  &gt;Refer to the [Onboarding and verification](https://docs.adyen.com/marketpay/onboarding-and-verification) section for details on field requirements.
     *
     * @return bankName
     **/
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public BankAccountDetail branchCode(String branchCode) {
        this.branchCode = branchCode;
        return this;
    }

    /**
     * The branch code of the branch under which the bank account is registered. The value to be specified in this parameter depends on the country of the bank account: * United States - Routing number * United Kingdom - Sort code * Germany - Bankleitzahl &gt;Refer to the [Onboarding and verification](https://docs.adyen.com/marketpay/onboarding-and-verification) section for details on field requirements.
     *
     * @return branchCode
     **/
    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public BankAccountDetail checkCode(String checkCode) {
        this.checkCode = checkCode;
        return this;
    }

    /**
     * The check code of the bank account.  &gt;Refer to the [Onboarding and verification](https://docs.adyen.com/marketpay/onboarding-and-verification) section for details on field requirements.
     *
     * @return checkCode
     **/
    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public BankAccountDetail countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    /**
     * The two-letter country code in which the bank account is registered. &gt;The permitted country codes are defined in ISO-3166-1 alpha-2 (e.g. &#x27;NL&#x27;).  &gt;Refer to the [Onboarding and verification](https://docs.adyen.com/marketpay/onboarding-and-verification) section for details on field requirements.
     *
     * @return countryCode
     **/
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public BankAccountDetail currencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    /**
     * The currency in which the bank account deals. &gt;The permitted currency codes are defined in ISO-4217 (e.g. &#x27;EUR&#x27;).  &gt;Refer to the [Onboarding and verification](https://docs.adyen.com/marketpay/onboarding-and-verification) section for details on field requirements.
     *
     * @return currencyCode
     **/
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BankAccountDetail iban(String iban) {
        this.iban = iban;
        return this;
    }

    /**
     * The international bank account number. &gt;The IBAN standard is defined in ISO-13616.  &gt;Refer to the [Onboarding and verification](https://docs.adyen.com/marketpay/onboarding-and-verification) section for details on field requirements.
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
     * The city of residence of the bank account owner. &gt;Refer to the [Onboarding and verification](https://docs.adyen.com/marketpay/onboarding-and-verification) section for details on field requirements.
     *
     * @return ownerCity
     **/
    public String getOwnerCity() {
        return ownerCity;
    }

    public void setOwnerCity(String ownerCity) {
        this.ownerCity = ownerCity;
    }

    public BankAccountDetail ownerCountryCode(String ownerCountryCode) {
        this.ownerCountryCode = ownerCountryCode;
        return this;
    }

    /**
     * The country code of the country of residence of the bank account owner. &gt;The permitted country codes are defined in ISO-3166-1 alpha-2 (e.g. &#x27;NL&#x27;).  &gt;Refer to the [Onboarding and verification](https://docs.adyen.com/marketpay/onboarding-and-verification) section for details on field requirements.
     *
     * @return ownerCountryCode
     **/
    public String getOwnerCountryCode() {
        return ownerCountryCode;
    }

    public void setOwnerCountryCode(String ownerCountryCode) {
        this.ownerCountryCode = ownerCountryCode;
    }

    public BankAccountDetail ownerDateOfBirth(String ownerDateOfBirth) {
        this.ownerDateOfBirth = ownerDateOfBirth;
        return this;
    }

    /**
     * The date of birth of the bank account owner.
     *
     * @return ownerDateOfBirth
     **/
    public String getOwnerDateOfBirth() {
        return ownerDateOfBirth;
    }

    public void setOwnerDateOfBirth(String ownerDateOfBirth) {
        this.ownerDateOfBirth = ownerDateOfBirth;
    }

    public BankAccountDetail ownerHouseNumberOrName(String ownerHouseNumberOrName) {
        this.ownerHouseNumberOrName = ownerHouseNumberOrName;
        return this;
    }

    /**
     * The house name or number of the residence of the bank account owner. &gt;Refer to the [Onboarding and verification](https://docs.adyen.com/marketpay/onboarding-and-verification) section for details on field requirements.
     *
     * @return ownerHouseNumberOrName
     **/
    public String getOwnerHouseNumberOrName() {
        return ownerHouseNumberOrName;
    }

    public void setOwnerHouseNumberOrName(String ownerHouseNumberOrName) {
        this.ownerHouseNumberOrName = ownerHouseNumberOrName;
    }

    public BankAccountDetail ownerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    /**
     * The name of the bank account owner. &gt;Refer to the [Onboarding and verification](https://docs.adyen.com/marketpay/onboarding-and-verification) section for details on field requirements.
     *
     * @return ownerName
     **/
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public BankAccountDetail ownerNationality(String ownerNationality) {
        this.ownerNationality = ownerNationality;
        return this;
    }

    /**
     * The country code of the country of nationality of the bank account owner. &gt;The permitted country codes are defined in ISO-3166-1 alpha-2 (e.g. &#x27;NL&#x27;).  &gt;Refer to the [Onboarding and verification](https://docs.adyen.com/marketpay/onboarding-and-verification) section for details on field requirements.
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
     * The postal code of the residence of the bank account owner. &gt;Refer to the [Onboarding and verification](https://docs.adyen.com/marketpay/onboarding-and-verification) section for details on field requirements.
     *
     * @return ownerPostalCode
     **/
    public String getOwnerPostalCode() {
        return ownerPostalCode;
    }

    public void setOwnerPostalCode(String ownerPostalCode) {
        this.ownerPostalCode = ownerPostalCode;
    }

    public BankAccountDetail ownerState(String ownerState) {
        this.ownerState = ownerState;
        return this;
    }

    /**
     * The state of residence of the bank account owner. &gt;Refer to the [Onboarding and verification](https://docs.adyen.com/marketpay/onboarding-and-verification) section for details on field requirements.
     *
     * @return ownerState
     **/
    public String getOwnerState() {
        return ownerState;
    }

    public void setOwnerState(String ownerState) {
        this.ownerState = ownerState;
    }

    public BankAccountDetail ownerStreet(String ownerStreet) {
        this.ownerStreet = ownerStreet;
        return this;
    }

    /**
     * The street name of the residence of the bank account owner. &gt;Refer to the [Onboarding and verification](https://docs.adyen.com/marketpay/onboarding-and-verification) section for details on field requirements.
     *
     * @return ownerStreet
     **/
    public String getOwnerStreet() {
        return ownerStreet;
    }

    public void setOwnerStreet(String ownerStreet) {
        this.ownerStreet = ownerStreet;
    }

    public BankAccountDetail primaryAccount(Boolean primaryAccount) {
        this.primaryAccount = primaryAccount;
        return this;
    }

    /**
     * If set to true, the bank account is a primary account.
     *
     * @return primaryAccount
     **/
    public Boolean isPrimaryAccount() {
        return primaryAccount;
    }

    public void setPrimaryAccount(Boolean primaryAccount) {
        this.primaryAccount = primaryAccount;
    }

    public BankAccountDetail taxId(String taxId) {
        this.taxId = taxId;
        return this;
    }

    /**
     * The tax ID number.  &gt;Refer to the [Onboarding and verification](https://docs.adyen.com/marketpay/onboarding-and-verification) section for details on field requirements.
     *
     * @return taxId
     **/
    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public BankAccountDetail urlForVerification(String urlForVerification) {
        this.urlForVerification = urlForVerification;
        return this;
    }

    /**
     * The URL to be used for bank account verification. This may be generated on bank account creation.  &gt;Refer to the [Onboarding and verification](https://docs.adyen.com/marketpay/onboarding-and-verification) section for details on field requirements.
     *
     * @return urlForVerification
     **/
    public String getUrlForVerification() {
        return urlForVerification;
    }

    public void setUrlForVerification(String urlForVerification) {
        this.urlForVerification = urlForVerification;
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
        return Objects.equals(this.accountNumber, bankAccountDetail.accountNumber) &&
                Objects.equals(this.accountType, bankAccountDetail.accountType) &&
                Objects.equals(this.bankAccountName, bankAccountDetail.bankAccountName) &&
                Objects.equals(this.bankAccountReference, bankAccountDetail.bankAccountReference) &&
                Objects.equals(this.bankAccountUUID, bankAccountDetail.bankAccountUUID) &&
                Objects.equals(this.bankBicSwift, bankAccountDetail.bankBicSwift) &&
                Objects.equals(this.bankCity, bankAccountDetail.bankCity) &&
                Objects.equals(this.bankCode, bankAccountDetail.bankCode) &&
                Objects.equals(this.bankName, bankAccountDetail.bankName) &&
                Objects.equals(this.branchCode, bankAccountDetail.branchCode) &&
                Objects.equals(this.checkCode, bankAccountDetail.checkCode) &&
                Objects.equals(this.countryCode, bankAccountDetail.countryCode) &&
                Objects.equals(this.currencyCode, bankAccountDetail.currencyCode) &&
                Objects.equals(this.iban, bankAccountDetail.iban) &&
                Objects.equals(this.ownerCity, bankAccountDetail.ownerCity) &&
                Objects.equals(this.ownerCountryCode, bankAccountDetail.ownerCountryCode) &&
                Objects.equals(this.ownerDateOfBirth, bankAccountDetail.ownerDateOfBirth) &&
                Objects.equals(this.ownerHouseNumberOrName, bankAccountDetail.ownerHouseNumberOrName) &&
                Objects.equals(this.ownerName, bankAccountDetail.ownerName) &&
                Objects.equals(this.ownerNationality, bankAccountDetail.ownerNationality) &&
                Objects.equals(this.ownerPostalCode, bankAccountDetail.ownerPostalCode) &&
                Objects.equals(this.ownerState, bankAccountDetail.ownerState) &&
                Objects.equals(this.ownerStreet, bankAccountDetail.ownerStreet) &&
                Objects.equals(this.primaryAccount, bankAccountDetail.primaryAccount) &&
                Objects.equals(this.taxId, bankAccountDetail.taxId) &&
                Objects.equals(this.urlForVerification, bankAccountDetail.urlForVerification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountType, bankAccountName, bankAccountReference, bankAccountUUID, bankBicSwift, bankCity, bankCode, bankName, branchCode, checkCode, countryCode, currencyCode, iban, ownerCity, ownerCountryCode, ownerDateOfBirth, ownerHouseNumberOrName, ownerName, ownerNationality, ownerPostalCode, ownerState, ownerStreet, primaryAccount, taxId, urlForVerification);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BankAccountDetail {\n");

        sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
        sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
        sb.append("    bankAccountName: ").append(toIndentedString(bankAccountName)).append("\n");
        sb.append("    bankAccountReference: ").append(toIndentedString(bankAccountReference)).append("\n");
        sb.append("    bankAccountUUID: ").append(toIndentedString(bankAccountUUID)).append("\n");
        sb.append("    bankBicSwift: ").append(toIndentedString(bankBicSwift)).append("\n");
        sb.append("    bankCity: ").append(toIndentedString(bankCity)).append("\n");
        sb.append("    bankCode: ").append(toIndentedString(bankCode)).append("\n");
        sb.append("    bankName: ").append(toIndentedString(bankName)).append("\n");
        sb.append("    branchCode: ").append(toIndentedString(branchCode)).append("\n");
        sb.append("    checkCode: ").append(toIndentedString(checkCode)).append("\n");
        sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
        sb.append("    currencyCode: ").append(toIndentedString(currencyCode)).append("\n");
        sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
        sb.append("    ownerCity: ").append(toIndentedString(ownerCity)).append("\n");
        sb.append("    ownerCountryCode: ").append(toIndentedString(ownerCountryCode)).append("\n");
        sb.append("    ownerDateOfBirth: ").append(toIndentedString(ownerDateOfBirth)).append("\n");
        sb.append("    ownerHouseNumberOrName: ").append(toIndentedString(ownerHouseNumberOrName)).append("\n");
        sb.append("    ownerName: ").append(toIndentedString(ownerName)).append("\n");
        sb.append("    ownerNationality: ").append(toIndentedString(ownerNationality)).append("\n");
        sb.append("    ownerPostalCode: ").append(toIndentedString(ownerPostalCode)).append("\n");
        sb.append("    ownerState: ").append(toIndentedString(ownerState)).append("\n");
        sb.append("    ownerStreet: ").append(toIndentedString(ownerStreet)).append("\n");
        sb.append("    primaryAccount: ").append(toIndentedString(primaryAccount)).append("\n");
        sb.append("    taxId: ").append(toIndentedString(taxId)).append("\n");
        sb.append("    urlForVerification: ").append(toIndentedString(urlForVerification)).append("\n");
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
