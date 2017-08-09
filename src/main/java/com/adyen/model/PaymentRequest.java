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

import java.util.List;
import java.util.Objects;
import com.adyen.Util.Util;
import com.adyen.constants.ApiConstants;
import com.adyen.model.additionalData.InvoiceLine;
import com.google.gson.annotations.SerializedName;

/**
 * PaymentRequest
 */
public class PaymentRequest extends AbstractPaymentRequest<PaymentRequest> {
    private static final String ADDITIONAL_DATA = "/authorise-3d-adyen-response";

    @SerializedName("card")
    private Card card = null;

    @SerializedName("mpiData")
    private ThreeDSecureData mpiData = null;

    @SerializedName("bankAccount")
    private BankAccount bankAccount = null;

    private List<InvoiceLine> invoiceLines = null;

    public PaymentRequest setAmountData(String amount, String currency) {
        Amount amountData = Util.createAmount(amount, currency);
        this.setAmount(amountData);
        return this;
    }

    public PaymentRequest setCSEToken(String cseToken) {
        getOrCreateAdditionalData().put(ApiConstants.AdditionalData.Card.Encrypted.JSON, cseToken);
        return this;
    }

    public PaymentRequest setCardData(String cardNumber, String cardHolder, String expiryMonth, String expiryYear, String cvc) {
        Card card = new Card();
        card.setExpiryMonth(expiryMonth);
        card.setExpiryYear(expiryYear);
        card.setHolderName(cardHolder);
        card.setNumber(cardNumber);
        card.setCvc(cvc);

        this.setCard(card);
        return this;
    }

    public PaymentRequest setPaymentToken(String paymentToken) {
        getOrCreateAdditionalData().put(ApiConstants.AdditionalData.PAYMENT_TOKEN, paymentToken);
        return this;
    }

    /**
     * Set invoiceLines in addtionalData
     */
    public PaymentRequest setInvoiceLines(List<InvoiceLine> invoiceLines) {

        Integer count = 1;
        for (InvoiceLine invoiceLine : invoiceLines) {

            StringBuilder sb = new StringBuilder();
            sb.append("openinvoicedata.line");
            sb.append(Integer.toString(count));
            String lineNumber = sb.toString();

            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".currencyCode").toString(), invoiceLine.getCurrencyCode());

            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".description").toString(), invoiceLine.getDescription());

            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".itemAmount").toString(), invoiceLine.getItemAmount().toString());

            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".itemVatAmount").toString(), invoiceLine.getItemVATAmount().toString());

            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".itemVatPercentage").toString(), invoiceLine.getItemVatPercentage().toString());

            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".numberOfItems").toString(), Integer.toString(invoiceLine.getNumberOfItems()));

            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".vatCategory").toString(), invoiceLine.getVatCategory().toString());

            // Addional field only for RatePay
            if (invoiceLine.getItemId() != null && ! invoiceLine.getItemId().isEmpty()) {
                this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".itemId").toString(), invoiceLine.getItemId());
            }

            count++;
        }

        this.getOrCreateAdditionalData().put("openinvoicedata.numberOfLines", Integer.toString(invoiceLines.size()));
        return this;
    }

    public PaymentRequest card(Card card) {
        this.card = card;
        return this;
    }

    /**
     * a representation of a (credit or debit) card
     *
     * @return card
     **/

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public PaymentRequest mpiData(ThreeDSecureData mpiData) {
        this.mpiData = mpiData;
        return this;
    }

    /**
     * authentication data produced by an MPI (MasterCard SecureCode or Verified By Visa)
     *
     * @return mpiData
     **/

    public ThreeDSecureData getMpiData() {
        return mpiData;
    }

    public void setMpiData(ThreeDSecureData mpiData) {
        this.mpiData = mpiData;
    }

    public PaymentRequest bankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    /**
     * a representation of a bank account
     *
     * @return bankAccount
     **/
    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentRequest paymentRequest = (PaymentRequest) o;
        return super.equals(paymentRequest) && Objects.equals(this.card, paymentRequest.card) && Objects.equals(this.mpiData, paymentRequest.mpiData) && Objects.equals(this.bankAccount,
                                                                                                                                                                        paymentRequest.bankAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(card, mpiData, bankAccount, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentRequest {\n");

        sb.append(super.toString());
        sb.append("    card: ").append(toIndentedString(card)).append("\n");
        sb.append("    mpiData: ").append(toIndentedString(mpiData)).append("\n");
        sb.append("    bankAccount: ").append(toIndentedString(bankAccount)).append("\n");
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

