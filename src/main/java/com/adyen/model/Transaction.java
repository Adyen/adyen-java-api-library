/**
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

import java.util.Date;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Transaction
 */
public class Transaction {
    @SerializedName("captureMerchantReference")
    private String captureMerchantReference = null;

    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("sourceAccountCode")
    private String sourceAccountCode = null;

    /**
     * The status of this transaction
     */
    public enum TransactionStatusEnum {
        @SerializedName("Chargeback")
        CHARGEBACK("Chargeback"),

        @SerializedName("ChargebackReceived")
        CHARGEBACKRECEIVED("ChargebackReceived"),

        @SerializedName("ChargebackReversed")
        CHARGEBACKREVERSED("ChargebackReversed"),

        @SerializedName("ChargebackReversedReceived")
        CHARGEBACKREVERSEDRECEIVED("ChargebackReversedReceived"),

        @SerializedName("CreditFailed")
        CREDITFAILED("CreditFailed"),

        @SerializedName("Credited")
        CREDITED("Credited"),

        @SerializedName("DebitFailed")
        DEBITFAILED("DebitFailed"),

        @SerializedName("DebitReversedReceived")
        DEBITREVERSEDRECEIVED("DebitReversedReceived"),

        @SerializedName("Debited")
        DEBITED("Debited"),

        @SerializedName("DebitedReversed")
        DEBITEDREVERSED("DebitedReversed"),

        @SerializedName("FundTransfer")
        FUNDTRANSFER("FundTransfer"),

        @SerializedName("Payout")
        PAYOUT("Payout"),

        @SerializedName("PayoutReversed")
        PAYOUTREVERSED("PayoutReversed"),

        @SerializedName("PendingCredit")
        PENDINGCREDIT("PendingCredit"),

        @SerializedName("PendingDebit")
        PENDINGDEBIT("PendingDebit"),

        @SerializedName("PendingFundTransfer")
        PENDINGFUNDTRANSFER("PendingFundTransfer");

        private String value;

        TransactionStatusEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("transactionStatus")
    private TransactionStatusEnum transactionStatus = null;

    @SerializedName("disputePspReference")
    private String disputePspReference = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("disputeReasonCode")
    private String disputeReasonCode = null;

    @SerializedName("creationDate")
    private Date creationDate = null;

    @SerializedName("destinationAccountCode")
    private String destinationAccountCode = null;

    @SerializedName("transferCode")
    private String transferCode = null;

    @SerializedName("bankAccountDetail")
    private BankAccountDetail bankAccountDetail = null;

    @SerializedName("capturePspReference")
    private String capturePspReference = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("merchantReference")
    private String merchantReference = null;

    public Transaction captureMerchantReference(String captureMerchantReference) {
        this.captureMerchantReference = captureMerchantReference;
        return this;
    }

    /**
     * Capture merchant reference
     *
     * @return captureMerchantReference
     **/
    public String getCaptureMerchantReference() {
        return captureMerchantReference;
    }

    public void setCaptureMerchantReference(String captureMerchantReference) {
        this.captureMerchantReference = captureMerchantReference;
    }

    public Transaction amount(Amount amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The amount of this transaction
     *
     * @return amount
     **/
    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public Transaction sourceAccountCode(String sourceAccountCode) {
        this.sourceAccountCode = sourceAccountCode;
        return this;
    }

    /**
     * The source account code, where the funds came from in case of an incoming (pending) fund transfer.
     *
     * @return sourceAccountCode
     **/
    public String getSourceAccountCode() {
        return sourceAccountCode;
    }

    public void setSourceAccountCode(String sourceAccountCode) {
        this.sourceAccountCode = sourceAccountCode;
    }

    public Transaction transactionStatus(TransactionStatusEnum transactionStatus) {
        this.transactionStatus = transactionStatus;
        return this;
    }

    /**
     * The status of this transaction
     *
     * @return transactionStatus
     **/
    public TransactionStatusEnum getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatusEnum transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Transaction disputePspReference(String disputePspReference) {
        this.disputePspReference = disputePspReference;
        return this;
    }

    /**
     * Dispute psp reference
     *
     * @return disputePspReference
     **/
    public String getDisputePspReference() {
        return disputePspReference;
    }

    public void setDisputePspReference(String disputePspReference) {
        this.disputePspReference = disputePspReference;
    }

    public Transaction description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description of the item, this is the reference and the description
     *
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Transaction disputeReasonCode(String disputeReasonCode) {
        this.disputeReasonCode = disputeReasonCode;
        return this;
    }

    /**
     * Dispute reason code
     *
     * @return disputeReasonCode
     **/
    public String getDisputeReasonCode() {
        return disputeReasonCode;
    }

    public void setDisputeReasonCode(String disputeReasonCode) {
        this.disputeReasonCode = disputeReasonCode;
    }

    public Transaction creationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    /**
     * The date this transaction was performed on
     *
     * @return creationDate
     **/
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Transaction destinationAccountCode(String destinationAccountCode) {
        this.destinationAccountCode = destinationAccountCode;
        return this;
    }

    /**
     * The destination account code, where the funds were sent to in case of an outgoing (pending) fund transfer.
     *
     * @return destinationAccountCode
     **/
    public String getDestinationAccountCode() {
        return destinationAccountCode;
    }

    public void setDestinationAccountCode(String destinationAccountCode) {
        this.destinationAccountCode = destinationAccountCode;
    }

    public Transaction transferCode(String transferCode) {
        this.transferCode = transferCode;
        return this;
    }

    /**
     * Used transfer code
     *
     * @return transferCode
     **/
    public String getTransferCode() {
        return transferCode;
    }

    public void setTransferCode(String transferCode) {
        this.transferCode = transferCode;
    }

    public Transaction bankAccountDetail(BankAccountDetail bankAccountDetail) {
        this.bankAccountDetail = bankAccountDetail;
        return this;
    }

    /**
     * The bank account details, where a payout was made to.
     *
     * @return bankAccountDetail
     **/
    public BankAccountDetail getBankAccountDetail() {
        return bankAccountDetail;
    }

    public void setBankAccountDetail(BankAccountDetail bankAccountDetail) {
        this.bankAccountDetail = bankAccountDetail;
    }

    public Transaction capturePspReference(String capturePspReference) {
        this.capturePspReference = capturePspReference;
        return this;
    }

    /**
     * Capture psp reference
     *
     * @return capturePspReference
     **/
    public String getCapturePspReference() {
        return capturePspReference;
    }

    public void setCapturePspReference(String capturePspReference) {
        this.capturePspReference = capturePspReference;
    }

    public Transaction pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * Payment psp reference
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public Transaction merchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
        return this;
    }

    /**
     * Payment merchant reference
     *
     * @return merchantReference
     **/
    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transaction transaction = (Transaction) o;
        return Objects.equals(this.captureMerchantReference, transaction.captureMerchantReference)
                && Objects.equals(this.amount, transaction.amount)
                && Objects.equals(this.sourceAccountCode,
                                  transaction.sourceAccountCode)
                && Objects.equals(this.transactionStatus, transaction.transactionStatus)
                && Objects.equals(this.disputePspReference, transaction.disputePspReference)
                && Objects.equals(this.description, transaction.description)
                && Objects.equals(this.disputeReasonCode, transaction.disputeReasonCode)
                && Objects.equals(this.creationDate, transaction.creationDate)
                && Objects.equals(this.destinationAccountCode, transaction.destinationAccountCode)
                && Objects.equals(this.transferCode, transaction.transferCode)
                && Objects.equals(this.bankAccountDetail, transaction.bankAccountDetail)
                && Objects.equals(this.capturePspReference, transaction.capturePspReference)
                && Objects.equals(this.pspReference, transaction.pspReference)
                && Objects.equals(this.merchantReference, transaction.merchantReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(captureMerchantReference,
                            amount,
                            sourceAccountCode,
                            transactionStatus,
                            disputePspReference,
                            description,
                            disputeReasonCode,
                            creationDate,
                            destinationAccountCode,
                            transferCode,
                            bankAccountDetail,
                            capturePspReference,
                            pspReference,
                            merchantReference);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Transaction {\n");

        sb.append("    captureMerchantReference: ").append(toIndentedString(captureMerchantReference)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    sourceAccountCode: ").append(toIndentedString(sourceAccountCode)).append("\n");
        sb.append("    transactionStatus: ").append(toIndentedString(transactionStatus)).append("\n");
        sb.append("    disputePspReference: ").append(toIndentedString(disputePspReference)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    disputeReasonCode: ").append(toIndentedString(disputeReasonCode)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    destinationAccountCode: ").append(toIndentedString(destinationAccountCode)).append("\n");
        sb.append("    transferCode: ").append(toIndentedString(transferCode)).append("\n");
        sb.append("    bankAccountDetail: ").append(toIndentedString(bankAccountDetail)).append("\n");
        sb.append("    capturePspReference: ").append(toIndentedString(capturePspReference)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    merchantReference: ").append(toIndentedString(merchantReference)).append("\n");
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

