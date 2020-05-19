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
package com.adyen.model.recurring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.adyen.model.Address;
import com.adyen.model.BankAccount;
import com.adyen.model.Card;
import com.adyen.model.ELV;
import com.adyen.model.Name;
import com.adyen.model.TokenDetails;
import com.google.gson.annotations.SerializedName;

/**
 * RecurringDetail
 */
public class RecurringDetail {
    @SerializedName("name")
    private String name = null;

    @SerializedName("creationDate")
    private Date creationDate = null;

    @SerializedName("card")
    private Card card = null;

    @SerializedName("elv")
    private ELV elv = null;

    @SerializedName("billingAddress")
    private Address billingAddress = null;

    @SerializedName("additionalData")
    private Map<String, String> additionalData = null;

    @SerializedName("shopperName")
    private Name shopperName = null;

    @SerializedName("socialSecurityNumber")
    private String socialSecurityNumber = null;

    @SerializedName("recurringDetailReference")
    private String recurringDetailReference = null;

    @SerializedName("bank")
    private BankAccount bank = null;

    @SerializedName("alias")
    private String alias = null;

    @SerializedName("aliasType")
    private String aliasType = null;

    @SerializedName("tokenDetails")
    private TokenDetails tokenDetails = null;

    @SerializedName("variant")
    private String variant = null;

    @SerializedName("paymentMethodVariant")
    private String paymentMethodVariant = null;

    @SerializedName("firstPspReference")
    private String firstPspReference = null;

    @SerializedName("contractTypes")
    private List<String> contractTypes = new ArrayList<>();

    @SerializedName("acquirer")
    private String acquirer = null;

    @SerializedName("acquirerAccount")
    private String acquirerAccount = null;

    public RecurringDetail name(String name) {
        this.name = name;
        return this;
    }

    /**
     * An optional descriptive name for this recurring detail
     *
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RecurringDetail creationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    /**
     * Get creationDate
     *
     * @return creationDate
     **/
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public RecurringDetail card(Card card) {
        this.card = card;
        return this;
    }

    /**
     * Get card
     *
     * @return card
     **/
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public RecurringDetail elv(ELV elv) {
        this.elv = elv;
        return this;
    }

    /**
     * Get elv
     *
     * @return elv
     **/
    public ELV getElv() {
        return elv;
    }

    public void setElv(ELV elv) {
        this.elv = elv;
    }

    public RecurringDetail billingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    /**
     * Get billingAddress
     *
     * @return billingAddress
     **/
    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    public RecurringDetail shopperName(Name shopperName) {
        this.shopperName = shopperName;
        return this;
    }

    /**
     * Get shopperName
     *
     * @return shopperName
     **/
    public Name getShopperName() {
        return shopperName;
    }

    public void setShopperName(Name shopperName) {
        this.shopperName = shopperName;
    }

    public RecurringDetail socialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
        return this;
    }

    /**
     * Get socialSecurityNumber
     *
     * @return socialSecurityNumber
     **/
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public RecurringDetail recurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
        return this;
    }

    /**
     * The reference that uniquely identifies the recurring detail
     *
     * @return recurringDetailReference
     **/
    public String getRecurringDetailReference() {
        return recurringDetailReference;
    }

    public void setRecurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
    }

    public RecurringDetail bank(BankAccount bank) {
        this.bank = bank;
        return this;
    }

    /**
     * Get bank
     *
     * @return bank
     **/
    public BankAccount getBank() {
        return bank;
    }

    public void setBank(BankAccount bank) {
        this.bank = bank;
    }

    public RecurringDetail alias(String alias) {
        this.alias = alias;
        return this;
    }

    /**
     * Get alias
     *
     * @return alias
     **/
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public RecurringDetail aliasType(String aliasType) {
        this.aliasType = aliasType;
        return this;
    }

    /**
     * Get aliasType
     *
     * @return aliasType
     **/
    public String getAliasType() {
        return aliasType;
    }

    public void setAliasType(String aliasType) {
        this.aliasType = aliasType;
    }

    public RecurringDetail tokenDetails(TokenDetails tokenDetails) {
        this.tokenDetails = tokenDetails;
        return this;
    }

    /**
     * Get tokenDetails
     *
     * @return tokenDetails
     **/
    public TokenDetails getTokenDetails() {
        return tokenDetails;
    }

    public void setTokenDetails(TokenDetails tokenDetails) {
        this.tokenDetails = tokenDetails;
    }

    public RecurringDetail variant(String variant) {
        this.variant = variant;
        return this;
    }

    /**
     * Get variant
     *
     * @return variant
     **/
    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public RecurringDetail paymentMethodVariant(String paymentMethodVariant) {
        this.paymentMethodVariant = paymentMethodVariant;
        return this;
    }

    /**
     * Get paymentMethodVariant
     *
     * @return paymentMethodVariant
     **/
    public String getPaymentMethodVariant() {
        return paymentMethodVariant;
    }

    public void setPaymentMethodVariant(String paymentMethodVariant) {
        this.paymentMethodVariant = paymentMethodVariant;
    }

    public RecurringDetail firstPspReference(String firstPspReference) {
        this.firstPspReference = firstPspReference;
        return this;
    }

    /**
     * Get firstPspReference
     *
     * @return firstPspReference
     **/
    public String getFirstPspReference() {
        return firstPspReference;
    }

    public void setFirstPspReference(String firstPspReference) {
        this.firstPspReference = firstPspReference;
    }

    public RecurringDetail contractTypes(List<String> contractTypes) {
        this.contractTypes = contractTypes;
        return this;
    }

    public RecurringDetail addContractTypesItem(String contractTypesItem) {
        this.contractTypes.add(contractTypesItem);
        return this;
    }

    /**
     * Get contractTypes
     *
     * @return contractTypes
     **/
    public List<String> getContractTypes() {
        return contractTypes;
    }

    public void setContractTypes(List<String> contractTypes) {
        this.contractTypes = contractTypes;
    }

    public RecurringDetail acquirer(String acquirer) {
        this.acquirer = acquirer;
        return this;
    }

    /**
     * Get acquirer
     *
     * @return acquirer
     **/
    public String getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(String acquirer) {
        this.acquirer = acquirer;
    }

    public RecurringDetail acquirerAccount(String acquirerAccount) {
        this.acquirerAccount = acquirerAccount;
        return this;
    }

    /**
     * Get acquirerAccount
     *
     * @return acquirerAccount
     **/
    public String getAcquirerAccount() {
        return acquirerAccount;
    }

    public void setAcquirerAccount(String acquirerAccount) {
        this.acquirerAccount = acquirerAccount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RecurringDetail {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    card: ").append(toIndentedString(card)).append("\n");
        sb.append("    elv: ").append(toIndentedString(elv)).append("\n");
        sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
        sb.append("    shopperName: ").append(toIndentedString(shopperName)).append("\n");
        sb.append("    socialSecurityNumber: ").append(toIndentedString(socialSecurityNumber)).append("\n");
        sb.append("    recurringDetailReference: ").append(toIndentedString(recurringDetailReference)).append("\n");
        sb.append("    bank: ").append(toIndentedString(bank)).append("\n");
        sb.append("    alias: ").append(toIndentedString(alias)).append("\n");
        sb.append("    aliasType: ").append(toIndentedString(aliasType)).append("\n");
        sb.append("    tokenDetails: ").append(toIndentedString(tokenDetails)).append("\n");
        sb.append("    variant: ").append(toIndentedString(variant)).append("\n");
        sb.append("    paymentMethodVariant: ").append(toIndentedString(paymentMethodVariant)).append("\n");
        sb.append("    firstPspReference: ").append(toIndentedString(firstPspReference)).append("\n");
        sb.append("    contractTypes: ").append(toIndentedString(contractTypes)).append("\n");
        sb.append("    acquirer: ").append(toIndentedString(acquirer)).append("\n");
        sb.append("    acquirerAccount: ").append(toIndentedString(acquirerAccount)).append("\n");
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

