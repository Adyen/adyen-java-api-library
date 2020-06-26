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

import com.google.gson.annotations.SerializedName;

import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * CardBin
 */

public class CardBin {

    @SerializedName("bin")
    private String bin = null;

    @SerializedName("commercial")
    private Boolean commercial = null;

    @SerializedName("fundingSource")
    private String fundingSource = null;

    @SerializedName("fundsAvailability")
    private String fundsAvailability = null;

    @SerializedName("issuingBank")
    private String issuingBank = null;

    @SerializedName("issuingCountry")
    private String issuingCountry = null;

    @SerializedName("issuingCurrency")
    private String issuingCurrency = null;

    @SerializedName("paymentMethod")
    private String paymentMethod = null;

    @SerializedName("payoutEligible")
    private String payoutEligible = null;

    @SerializedName("summary")
    private String summary = null;

    public CardBin bin(String bin) {
        this.bin = bin;
        return this;
    }


    /**
     * The first 6 digit of the card number. Enable this field via merchant account settings.
     *
     * @return bin
     **/
    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public CardBin commercial(Boolean commercial) {
        this.commercial = commercial;
        return this;
    }


    /**
     * If true, it indicates a commercial card. Enable this field via merchant account settings.
     *
     * @return commercial
     **/
    public Boolean isCommercial() {
        return commercial;
    }

    public void setCommercial(Boolean commercial) {
        this.commercial = commercial;
    }

    public CardBin fundingSource(String fundingSource) {
        this.fundingSource = fundingSource;
        return this;
    }


    /**
     * The card funding source. Valid values are: * CREDIT * DEBIT * PREPAID * PREPAID_RELOADABLE * DEFERRED_DEBIT * CHARGED &gt; Enable this field via merchant account settings.
     *
     * @return fundingSource
     **/
    public String getFundingSource() {
        return fundingSource;
    }

    public void setFundingSource(String fundingSource) {
        this.fundingSource = fundingSource;
    }

    public CardBin fundsAvailability(String fundsAvailability) {
        this.fundsAvailability = fundsAvailability;
        return this;
    }


    /**
     * Indicates availability of funds.  Visa: * \&quot;I\&quot; (fast funds are supported) * \&quot;N\&quot; (otherwise)  Mastercard: * \&quot;I\&quot; (product type is Prepaid or Debit, or issuing
     * country is in CEE/HGEM list) * \&quot;N\&quot; (otherwise) &gt; Returned when you verify a card BIN or estimate costs, and only if &#x60;payoutEligible&#x60; is different from \&quot;N\&quot;
     * or \&quot;U\&quot;.
     *
     * @return fundsAvailability
     **/
    public String getFundsAvailability() {
        return fundsAvailability;
    }

    public void setFundsAvailability(String fundsAvailability) {
        this.fundsAvailability = fundsAvailability;
    }

    public CardBin issuingBank(String issuingBank) {
        this.issuingBank = issuingBank;
        return this;
    }


    /**
     * The issuing bank of the card.
     *
     * @return issuingBank
     **/
    public String getIssuingBank() {
        return issuingBank;
    }

    public void setIssuingBank(String issuingBank) {
        this.issuingBank = issuingBank;
    }

    public CardBin issuingCountry(String issuingCountry) {
        this.issuingCountry = issuingCountry;
        return this;
    }


    /**
     * The country where the card was issued from.
     *
     * @return issuingCountry
     **/
    public String getIssuingCountry() {
        return issuingCountry;
    }

    public void setIssuingCountry(String issuingCountry) {
        this.issuingCountry = issuingCountry;
    }

    public CardBin issuingCurrency(String issuingCurrency) {
        this.issuingCurrency = issuingCurrency;
        return this;
    }


    /**
     * The currency of the card.
     *
     * @return issuingCurrency
     **/
    public String getIssuingCurrency() {
        return issuingCurrency;
    }

    public void setIssuingCurrency(String issuingCurrency) {
        this.issuingCurrency = issuingCurrency;
    }

    public CardBin paymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }


    /**
     * The payment method associated with the card (e.g. visa, mc, or amex).
     *
     * @return paymentMethod
     **/
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public CardBin payoutEligible(String payoutEligible) {
        this.payoutEligible = payoutEligible;
        return this;
    }


    /**
     * Indicates whether a payout is eligible or not for this card.  Visa: * \&quot;Y\&quot; * \&quot;N\&quot;  Mastercard: * \&quot;Y\&quot; (domestic and cross-border) * \&quot;D\&quot; (only
     * domestic) * \&quot;N\&quot; (no MoneySend) * \&quot;U\&quot; (unknown) &gt; Returned when you verify a card BIN or estimate costs, and only if &#x60;payoutEligible&#x60; is different from
     * \&quot;N\&quot; or \&quot;U\&quot;.
     *
     * @return payoutEligible
     **/
    public String getPayoutEligible() {
        return payoutEligible;
    }

    public void setPayoutEligible(String payoutEligible) {
        this.payoutEligible = payoutEligible;
    }

    public CardBin summary(String summary) {
        this.summary = summary;
        return this;
    }


    /**
     * The last four digits of the card number.
     *
     * @return summary
     **/
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CardBin cardBin = (CardBin) o;
        return Objects.equals(this.bin, cardBin.bin)
                && Objects.equals(this.commercial, cardBin.commercial)
                && Objects.equals(this.fundingSource, cardBin.fundingSource)
                && Objects.equals(this.fundsAvailability, cardBin.fundsAvailability)
                && Objects.equals(this.issuingBank, cardBin.issuingBank)
                && Objects.equals(this.issuingCountry, cardBin.issuingCountry)
                && Objects.equals(this.issuingCurrency, cardBin.issuingCurrency)
                && Objects.equals(this.paymentMethod, cardBin.paymentMethod)
                && Objects.equals(this.payoutEligible, cardBin.payoutEligible)
                && Objects.equals(this.summary, cardBin.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bin, commercial, fundingSource, fundsAvailability, issuingBank, issuingCountry, issuingCurrency, paymentMethod, payoutEligible, summary);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CardBin {\n");

        sb.append("    bin: ").append(toIndentedString(bin)).append("\n");
        sb.append("    commercial: ").append(toIndentedString(commercial)).append("\n");
        sb.append("    fundingSource: ").append(toIndentedString(fundingSource)).append("\n");
        sb.append("    fundsAvailability: ").append(toIndentedString(fundsAvailability)).append("\n");
        sb.append("    issuingBank: ").append(toIndentedString(issuingBank)).append("\n");
        sb.append("    issuingCountry: ").append(toIndentedString(issuingCountry)).append("\n");
        sb.append("    issuingCurrency: ").append(toIndentedString(issuingCurrency)).append("\n");
        sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
        sb.append("    payoutEligible: ").append(toIndentedString(payoutEligible)).append("\n");
        sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
        sb.append("}");
        return sb.toString();
    }



}
