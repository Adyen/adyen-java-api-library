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
package com.adyen.model.binlookup;

import java.io.IOException;
import java.util.Objects;
import com.adyen.model.Amount;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * CostEstimateRequest
 */

public class CostEstimateRequest {

    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("assumptions")
    private CostEstimateAssumptions assumptions = null;

    @SerializedName("cardNumber")
    private String cardNumber = null;

    @SerializedName("encryptedCard")
    private String encryptedCard = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("merchantDetails")
    private MerchantDetails merchantDetails = null;

    @SerializedName("recurring")
    private Recurring recurring = null;

    @SerializedName("selectedRecurringDetailReference")
    private String selectedRecurringDetailReference = null;

    /**
     * Specifies the sales channel, through which the shopper gives their card details, and whether the shopper is a returning customer. For the web service API, Adyen assumes Ecommerce shopper
     * interaction by default.  This field has the following possible values: * &#x60;Ecommerce&#x60; - Online transactions where the cardholder is present (online). For better authorisation rates,
     * we recommend sending the card security code (CSC) along with the request. * &#x60;ContAuth&#x60; - Card on file and/or subscription transactions, where the card holder is known to the merchant
     * (returning customer). If the shopper is present (online), you can supply also the CSC to improve authorisation (one-click payment). * &#x60;Moto&#x60; - Mail-order and telephone-order
     * transactions where the shopper is in contact with the merchant via email or telephone. * &#x60;POS&#x60; - Point-of-sale transactions where the shopper is physically present to make a payment
     * using a secure payment terminal.
     */
    @JsonAdapter(ShopperInteractionEnum.Adapter.class)
    public enum ShopperInteractionEnum {
        ECOMMERCE("Ecommerce"),
        CONTAUTH("ContAuth"),
        MOTO("Moto"),
        POS("POS");

        private String value;

        ShopperInteractionEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static ShopperInteractionEnum fromValue(String text) {
            for (ShopperInteractionEnum b : ShopperInteractionEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<ShopperInteractionEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ShopperInteractionEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public ShopperInteractionEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return ShopperInteractionEnum.fromValue(String.valueOf(value));
            }
        }}

    @SerializedName("shopperInteraction")
    private ShopperInteractionEnum shopperInteraction = null;

    @SerializedName("shopperReference")
    private String shopperReference = null;

    public CostEstimateRequest amount(Amount amount) {
        this.amount = amount;
        return this;
    }


    /**
     * Get amount
     *
     * @return amount
     **/
    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public CostEstimateRequest assumptions(CostEstimateAssumptions assumptions) {
        this.assumptions = assumptions;
        return this;
    }


    /**
     * Get assumptions
     *
     * @return assumptions
     **/
    public CostEstimateAssumptions getAssumptions() {
        return assumptions;
    }

    public void setAssumptions(CostEstimateAssumptions assumptions) {
        this.assumptions = assumptions;
    }

    public CostEstimateRequest cardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }


    /**
     * The card number (4-19 characters) for PCI compliant use cases. Do not use any separators.  &gt; Either the &#x60;cardNumber&#x60; or &#x60;encryptedCard&#x60; field must be provided in a
     * payment request.
     *
     * @return cardNumber
     **/
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CostEstimateRequest encryptedCard(String encryptedCard) {
        this.encryptedCard = encryptedCard;
        return this;
    }


    /**
     * Encrypted data that stores card information for non PCI-compliant use cases. The encrypted data must be created with the Client-Side Encryption library and must contain at least the &#x60;
     * number&#x60; and &#x60;generationtime&#x60; fields.  &gt; Either the &#x60;cardNumber&#x60; or &#x60;encryptedCard&#x60; field must be provided in a payment request.
     *
     * @return encryptedCard
     **/
    public String getEncryptedCard() {
        return encryptedCard;
    }

    public void setEncryptedCard(String encryptedCard) {
        this.encryptedCard = encryptedCard;
    }

    public CostEstimateRequest merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }


    /**
     * The merchant account identifier you want to process the (transaction) request with.
     *
     * @return merchantAccount
     **/
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public CostEstimateRequest merchantDetails(MerchantDetails merchantDetails) {
        this.merchantDetails = merchantDetails;
        return this;
    }


    /**
     * Get merchantDetails
     *
     * @return merchantDetails
     **/
    public MerchantDetails getMerchantDetails() {
        return merchantDetails;
    }

    public void setMerchantDetails(MerchantDetails merchantDetails) {
        this.merchantDetails = merchantDetails;
    }

    public CostEstimateRequest recurring(Recurring recurring) {
        this.recurring = recurring;
        return this;
    }


    /**
     * Get recurring
     *
     * @return recurring
     **/
    public Recurring getRecurring() {
        return recurring;
    }

    public void setRecurring(Recurring recurring) {
        this.recurring = recurring;
    }

    public CostEstimateRequest selectedRecurringDetailReference(String selectedRecurringDetailReference) {
        this.selectedRecurringDetailReference = selectedRecurringDetailReference;
        return this;
    }


    /**
     * The &#x60;recurringDetailReference&#x60; you want to use for this cost estimate. The value &#x60;LATEST&#x60; can be used to select the most recently stored recurring detail.
     *
     * @return selectedRecurringDetailReference
     **/
    public String getSelectedRecurringDetailReference() {
        return selectedRecurringDetailReference;
    }

    public void setSelectedRecurringDetailReference(String selectedRecurringDetailReference) {
        this.selectedRecurringDetailReference = selectedRecurringDetailReference;
    }

    public CostEstimateRequest shopperInteraction(ShopperInteractionEnum shopperInteraction) {
        this.shopperInteraction = shopperInteraction;
        return this;
    }


    /**
     * Specifies the sales channel, through which the shopper gives their card details, and whether the shopper is a returning customer. For the web service API, Adyen assumes Ecommerce shopper
     * interaction by default.  This field has the following possible values: * &#x60;Ecommerce&#x60; - Online transactions where the cardholder is present (online). For better authorisation rates,
     * we recommend sending the card security code (CSC) along with the request. * &#x60;ContAuth&#x60; - Card on file and/or subscription transactions, where the card holder is known to the merchant
     * (returning customer). If the shopper is present (online), you can supply also the CSC to improve authorisation (one-click payment). * &#x60;Moto&#x60; - Mail-order and telephone-order
     * transactions where the shopper is in contact with the merchant via email or telephone. * &#x60;POS&#x60; - Point-of-sale transactions where the shopper is physically present to make a payment
     * using a secure payment terminal.
     *
     * @return shopperInteraction
     **/
    public ShopperInteractionEnum getShopperInteraction() {
        return shopperInteraction;
    }

    public void setShopperInteraction(ShopperInteractionEnum shopperInteraction) {
        this.shopperInteraction = shopperInteraction;
    }

    public CostEstimateRequest shopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
        return this;
    }


    /**
     * The shopper&#x27;s reference to uniquely identify this shopper (e.g. user ID or account ID). &gt; This field is required for recurring payments.
     *
     * @return shopperReference
     **/
    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CostEstimateRequest costEstimateRequest = (CostEstimateRequest) o;
        return Objects.equals(this.amount, costEstimateRequest.amount)
                && Objects.equals(this.assumptions, costEstimateRequest.assumptions)
                && Objects.equals(this.cardNumber,
                                  costEstimateRequest.cardNumber)
                && Objects.equals(this.encryptedCard, costEstimateRequest.encryptedCard)
                && Objects.equals(this.merchantAccount, costEstimateRequest.merchantAccount)
                && Objects.equals(this.merchantDetails,
                                  costEstimateRequest.merchantDetails)
                && Objects.equals(this.recurring, costEstimateRequest.recurring)
                && Objects.equals(this.selectedRecurringDetailReference, costEstimateRequest.selectedRecurringDetailReference)
                && Objects.equals(this.shopperInteraction, costEstimateRequest.shopperInteraction)
                && Objects.equals(this.shopperReference, costEstimateRequest.shopperReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, assumptions, cardNumber, encryptedCard, merchantAccount, merchantDetails, recurring, selectedRecurringDetailReference, shopperInteraction, shopperReference);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CostEstimateRequest {\n");

        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    assumptions: ").append(toIndentedString(assumptions)).append("\n");
        sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
        sb.append("    encryptedCard: ").append(toIndentedString(encryptedCard)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    merchantDetails: ").append(toIndentedString(merchantDetails)).append("\n");
        sb.append("    recurring: ").append(toIndentedString(recurring)).append("\n");
        sb.append("    selectedRecurringDetailReference: ").append(toIndentedString(selectedRecurringDetailReference)).append("\n");
        sb.append("    shopperInteraction: ").append(toIndentedString(shopperInteraction)).append("\n");
        sb.append("    shopperReference: ").append(toIndentedString(shopperReference)).append("\n");
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
