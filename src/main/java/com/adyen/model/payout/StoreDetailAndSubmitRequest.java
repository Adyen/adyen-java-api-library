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
package com.adyen.model.payout;

import com.adyen.constants.TextConstants;
import com.adyen.model.Address;
import com.adyen.model.Amount;
import com.adyen.model.BankAccount;
import com.adyen.model.Card;
import com.adyen.model.Name;
import com.adyen.model.recurring.Recurring;
import com.adyen.serializer.DateSerializer;
import com.adyen.util.Util;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Map;

/**
 * StoreDetailsAndSubmitRequest
 */
public class StoreDetailAndSubmitRequest {
    @SerializedName("additionalData")
    private Map<String, String> additionalData = null;

    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("bank")
    private BankAccount bank = null;

    @SerializedName("card")
    private Card card = null;

    @SerializedName("billingAddress")
    private Address billingAddress = null;

    @SerializedName("dateOfBirth")
    @JsonAdapter(DateSerializer.class)
    private Date dateOfBirth = null;

    @SerializedName("entityType")
    private String entityType = null;

    @SerializedName("fraudOffset")
    private Integer fraudOffset = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("nationality")
    private String nationality = null;

    @SerializedName("recurring")
    private Recurring recurring;

    @SerializedName("selectedBrand")
    private String selectedBrand = null;

    @SerializedName("shopperEmail")
    private String shopperEmail = null;

    @SerializedName("reference")
    private String reference = null;

    @SerializedName("shopperName")
    private Name shopperName = null;

    @SerializedName("shopperReference")
    private String shopperReference = null;

    @SerializedName("shopperStatement")
    private String shopperStatement = null;

    @SerializedName("socialSecurityNumber")
    private String socialSecurityNumber = null;

    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public BankAccount getBank() {
        return bank;
    }

    public void setBank(BankAccount bank) {
        this.bank = bank;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Integer getFraudOffset() {
        return fraudOffset;
    }

    public void setFraudOffset(Integer fraudOffset) {
        this.fraudOffset = fraudOffset;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getSelectedBrand() {
        return selectedBrand;
    }

    public void setSelectedBrand(String selectedBrand) {
        this.selectedBrand = selectedBrand;
    }

    public String getShopperEmail() {
        return shopperEmail;
    }

    public void setShopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Name getShopperName() {
        return shopperName;
    }

    public void setShopperName(Name shopperName) {
        this.shopperName = shopperName;
    }

    public String getShopperStatement() {
        return shopperStatement;
    }

    public void setShopperStatement(String shopperStatement) {
        this.shopperStatement = shopperStatement;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public StoreDetailAndSubmitRequest merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    /**
     * the merchant account which will be used for processing this request
     *
     * @return merchantAccount
     **/
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public StoreDetailAndSubmitRequest shopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
        return this;
    }

    /**
     * a reference you use to uniquely identify the shopper (e.g. user ID or account ID)
     *
     * @return shopperReference
     **/
    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    public StoreDetailAndSubmitRequest recurring(Recurring recurring) {
        this.recurring = recurring;
        return this;
    }

    /**
     * the type of recurring contract to be used.
     *
     * @return recurring
     **/
    public Recurring getRecurring() {
        return recurring;
    }

    public void setRecurring(Recurring recurring) {
        this.recurring = recurring;
    }

    public StoreDetailAndSubmitRequest() {
        Recurring recurring = new Recurring();
        recurring.setContract(Recurring.ContractEnum.PAYOUT);
        this.recurring = recurring;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StoreDetailsAndSubmitRequest {").append(TextConstants.LINE_BREAK);
        sb.append("    merchantAccount: ").append(Util.toIndentedString(merchantAccount)).append(TextConstants.LINE_BREAK);
        sb.append("    shopperReference: ").append(Util.toIndentedString(shopperReference)).append(TextConstants.LINE_BREAK);
        sb.append("    recurring: ").append(Util.toIndentedString(recurring)).append(TextConstants.LINE_BREAK);
        sb.append("    additionalData: ").append(Util.toIndentedString(additionalData)).append(TextConstants.LINE_BREAK);
        sb.append("    amount: ").append(Util.toIndentedString(amount)).append(TextConstants.LINE_BREAK);
        sb.append("    card: ").append(Util.toIndentedString(card)).append(TextConstants.LINE_BREAK);
        sb.append("    billingAddress: ").append(Util.toIndentedString(billingAddress)).append(TextConstants.LINE_BREAK);
        sb.append("    dateOfBirth: ").append(Util.toIndentedString(dateOfBirth)).append(TextConstants.LINE_BREAK);
        sb.append("    entityType: ").append(Util.toIndentedString(entityType)).append(TextConstants.LINE_BREAK);
        sb.append("    fraudOffset: ").append(Util.toIndentedString(fraudOffset)).append(TextConstants.LINE_BREAK);
        sb.append("    nationality: ").append(Util.toIndentedString(nationality)).append(TextConstants.LINE_BREAK);
        sb.append("    selectedBrand: ").append(Util.toIndentedString(selectedBrand)).append(TextConstants.LINE_BREAK);
        sb.append("    shopperEmail: ").append(Util.toIndentedString(shopperEmail)).append(TextConstants.LINE_BREAK);
        sb.append("    shopperStatement: ").append(Util.toIndentedString(shopperStatement)).append(TextConstants.LINE_BREAK);
        sb.append("    shopperName: ").append(Util.toIndentedString(shopperName)).append(TextConstants.LINE_BREAK);
        sb.append("    reference: ").append(Util.toIndentedString(reference)).append(TextConstants.LINE_BREAK);
        sb.append("    socialSecurityNumber: ").append(Util.toIndentedString(socialSecurityNumber)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }
}
