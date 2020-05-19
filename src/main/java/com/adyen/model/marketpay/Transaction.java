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

import com.adyen.model.Amount;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * Transaction
 */
public class Transaction {
    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("bankAccountDetail")
    private BankAccountDetail bankAccountDetail = null;

    @SerializedName("captureMerchantReference")
    private String captureMerchantReference = null;

    @SerializedName("capturePspReference")
    private String capturePspReference = null;

    @SerializedName("creationDate")
    private Date creationDate = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("destinationAccountCode")
    private String destinationAccountCode = null;

    @SerializedName("disputePspReference")
    private String disputePspReference = null;

    @SerializedName("disputeReasonCode")
    private String disputeReasonCode = null;

    @SerializedName("merchantReference")
    private String merchantReference = null;

    @SerializedName("paymentPspReference")
    private String paymentPspReference = null;

    @SerializedName("payoutPspReference")
    private String payoutPspReference = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("sourceAccountCode")
    private String sourceAccountCode = null;

    /**
     * The status of the transaction. &gt;Permitted values: &#x60;PendingCredit&#x60;, &#x60;CreditFailed&#x60;, &#x60;Credited&#x60;, &#x60;Converted&#x60;, &#x60;PendingDebit&#x60;, &#x60;DebitFailed&#x60;, &#x60;Debited&#x60;, &#x60;DebitReversedReceived&#x60;, &#x60;DebitedReversed&#x60;, &#x60;ChargebackReceived&#x60;, &#x60;Chargeback&#x60;, &#x60;ChargebackReversedReceived&#x60;, &#x60;ChargebackReversed&#x60;, &#x60;Payout&#x60;, &#x60;PayoutReversed&#x60;, &#x60;FundTransfer&#x60;, &#x60;PendingFundTransfer&#x60;, &#x60;ManualCorrected&#x60;.
     */
    @JsonAdapter(TransactionStatusEnum.Adapter.class)
    public enum TransactionStatusEnum {
        CHARGEBACK("Chargeback"),
        CHARGEBACKCORRECTION("ChargebackCorrection"),
        CHARGEBACKCORRECTIONRECEIVED("ChargebackCorrectionReceived"),
        CHARGEBACKRECEIVED("ChargebackReceived"),
        CHARGEBACKREVERSED("ChargebackReversed"),
        CHARGEBACKREVERSEDRECEIVED("ChargebackReversedReceived"),
        CONVERTED("Converted"),
        CREDITFAILED("CreditFailed"),
        CREDITREVERSED("CreditReversed"),
        CREDITREVERSEDRECEIVED("CreditReversedReceived"),
        CREDITED("Credited"),
        DEBITFAILED("DebitFailed"),
        DEBITREVERSEDRECEIVED("DebitReversedReceived"),
        DEBITED("Debited"),
        DEBITEDREVERSED("DebitedReversed"),
        FUNDTRANSFER("FundTransfer"),
        FUNDTRANSFERREVERSED("FundTransferReversed"),
        MANUALCORRECTED("ManualCorrected"),
        PAYOUT("Payout"),
        PAYOUTREVERSED("PayoutReversed"),
        PENDINGCREDIT("PendingCredit"),
        PENDINGDEBIT("PendingDebit"),
        PENDINGFUNDTRANSFER("PendingFundTransfer"),
        SECONDCHARGEBACK("SecondChargeback"),
        SECONDCHARGEBACKRECEIVED("SecondChargebackReceived");

        private String value;

        TransactionStatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static TransactionStatusEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<TransactionStatusEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TransactionStatusEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TransactionStatusEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return TransactionStatusEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("transactionStatus")
    private TransactionStatusEnum transactionStatus = null;

    @SerializedName("transferCode")
    private String transferCode = null;

    public Transaction amount(Amount amount) {
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

    public Transaction bankAccountDetail(BankAccountDetail bankAccountDetail) {
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

    public Transaction captureMerchantReference(String captureMerchantReference) {
        this.captureMerchantReference = captureMerchantReference;
        return this;
    }

    /**
     * The merchant reference of a related capture.
     *
     * @return captureMerchantReference
     **/
    public String getCaptureMerchantReference() {
        return captureMerchantReference;
    }

    public void setCaptureMerchantReference(String captureMerchantReference) {
        this.captureMerchantReference = captureMerchantReference;
    }

    public Transaction capturePspReference(String capturePspReference) {
        this.capturePspReference = capturePspReference;
        return this;
    }

    /**
     * The psp reference of a related capture.
     *
     * @return capturePspReference
     **/
    public String getCapturePspReference() {
        return capturePspReference;
    }

    public void setCapturePspReference(String capturePspReference) {
        this.capturePspReference = capturePspReference;
    }

    public Transaction creationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    /**
     * The date on which the transaction was performed.
     *
     * @return creationDate
     **/
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Transaction description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the transaction.
     *
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Transaction destinationAccountCode(String destinationAccountCode) {
        this.destinationAccountCode = destinationAccountCode;
        return this;
    }

    /**
     * The code of the account to which funds were credited during an outgoing fund transfer.
     *
     * @return destinationAccountCode
     **/
    public String getDestinationAccountCode() {
        return destinationAccountCode;
    }

    public void setDestinationAccountCode(String destinationAccountCode) {
        this.destinationAccountCode = destinationAccountCode;
    }

    public Transaction disputePspReference(String disputePspReference) {
        this.disputePspReference = disputePspReference;
        return this;
    }

    /**
     * The psp reference of the related dispute.
     *
     * @return disputePspReference
     **/
    public String getDisputePspReference() {
        return disputePspReference;
    }

    public void setDisputePspReference(String disputePspReference) {
        this.disputePspReference = disputePspReference;
    }

    public Transaction disputeReasonCode(String disputeReasonCode) {
        this.disputeReasonCode = disputeReasonCode;
        return this;
    }

    /**
     * The reason code of a dispute.
     *
     * @return disputeReasonCode
     **/
    public String getDisputeReasonCode() {
        return disputeReasonCode;
    }

    public void setDisputeReasonCode(String disputeReasonCode) {
        this.disputeReasonCode = disputeReasonCode;
    }

    public Transaction merchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
        return this;
    }

    /**
     * The merchant reference of a transaction.
     *
     * @return merchantReference
     **/
    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }

    public Transaction paymentPspReference(String paymentPspReference) {
        this.paymentPspReference = paymentPspReference;
        return this;
    }

    /**
     * The psp reference of the related authorisation or transfer.
     *
     * @return paymentPspReference
     **/
    public String getPaymentPspReference() {
        return paymentPspReference;
    }

    public void setPaymentPspReference(String paymentPspReference) {
        this.paymentPspReference = paymentPspReference;
    }

    public Transaction payoutPspReference(String payoutPspReference) {
        this.payoutPspReference = payoutPspReference;
        return this;
    }

    /**
     * The psp reference of the related payout.
     *
     * @return payoutPspReference
     **/
    public String getPayoutPspReference() {
        return payoutPspReference;
    }

    public void setPayoutPspReference(String payoutPspReference) {
        this.payoutPspReference = payoutPspReference;
    }

    public Transaction pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * The psp reference of a transaction.
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public Transaction sourceAccountCode(String sourceAccountCode) {
        this.sourceAccountCode = sourceAccountCode;
        return this;
    }

    /**
     * The code of the account from which funds were debited during an incoming fund transfer.
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
     * The status of the transaction. &gt;Permitted values: &#x60;PendingCredit&#x60;, &#x60;CreditFailed&#x60;, &#x60;Credited&#x60;, &#x60;Converted&#x60;, &#x60;PendingDebit&#x60;, &#x60;DebitFailed&#x60;, &#x60;Debited&#x60;, &#x60;DebitReversedReceived&#x60;, &#x60;DebitedReversed&#x60;, &#x60;ChargebackReceived&#x60;, &#x60;Chargeback&#x60;, &#x60;ChargebackReversedReceived&#x60;, &#x60;ChargebackReversed&#x60;, &#x60;Payout&#x60;, &#x60;PayoutReversed&#x60;, &#x60;FundTransfer&#x60;, &#x60;PendingFundTransfer&#x60;, &#x60;ManualCorrected&#x60;.
     *
     * @return transactionStatus
     **/
    public TransactionStatusEnum getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatusEnum transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Transaction transferCode(String transferCode) {
        this.transferCode = transferCode;
        return this;
    }

    /**
     * The transfer code of the transaction.
     *
     * @return transferCode
     **/
    public String getTransferCode() {
        return transferCode;
    }

    public void setTransferCode(String transferCode) {
        this.transferCode = transferCode;
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
        return Objects.equals(this.amount, transaction.amount) &&
                Objects.equals(this.bankAccountDetail, transaction.bankAccountDetail) &&
                Objects.equals(this.captureMerchantReference, transaction.captureMerchantReference) &&
                Objects.equals(this.capturePspReference, transaction.capturePspReference) &&
                Objects.equals(this.creationDate, transaction.creationDate) &&
                Objects.equals(this.description, transaction.description) &&
                Objects.equals(this.destinationAccountCode, transaction.destinationAccountCode) &&
                Objects.equals(this.disputePspReference, transaction.disputePspReference) &&
                Objects.equals(this.disputeReasonCode, transaction.disputeReasonCode) &&
                Objects.equals(this.merchantReference, transaction.merchantReference) &&
                Objects.equals(this.paymentPspReference, transaction.paymentPspReference) &&
                Objects.equals(this.payoutPspReference, transaction.payoutPspReference) &&
                Objects.equals(this.pspReference, transaction.pspReference) &&
                Objects.equals(this.sourceAccountCode, transaction.sourceAccountCode) &&
                Objects.equals(this.transactionStatus, transaction.transactionStatus) &&
                Objects.equals(this.transferCode, transaction.transferCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, bankAccountDetail, captureMerchantReference, capturePspReference, creationDate, description, destinationAccountCode, disputePspReference, disputeReasonCode, merchantReference, paymentPspReference, payoutPspReference, pspReference, sourceAccountCode, transactionStatus, transferCode);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Transaction {\n");

        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    bankAccountDetail: ").append(toIndentedString(bankAccountDetail)).append("\n");
        sb.append("    captureMerchantReference: ").append(toIndentedString(captureMerchantReference)).append("\n");
        sb.append("    capturePspReference: ").append(toIndentedString(capturePspReference)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    destinationAccountCode: ").append(toIndentedString(destinationAccountCode)).append("\n");
        sb.append("    disputePspReference: ").append(toIndentedString(disputePspReference)).append("\n");
        sb.append("    disputeReasonCode: ").append(toIndentedString(disputeReasonCode)).append("\n");
        sb.append("    merchantReference: ").append(toIndentedString(merchantReference)).append("\n");
        sb.append("    paymentPspReference: ").append(toIndentedString(paymentPspReference)).append("\n");
        sb.append("    payoutPspReference: ").append(toIndentedString(payoutPspReference)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    sourceAccountCode: ").append(toIndentedString(sourceAccountCode)).append("\n");
        sb.append("    transactionStatus: ").append(toIndentedString(transactionStatus)).append("\n");
        sb.append("    transferCode: ").append(toIndentedString(transferCode)).append("\n");
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
