package com.adyen.model.marketpay;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

public class DebitAccountHolderRequest {
    @SerializedName("accountHolderCode")
    private String accountHolderCode;

    @SerializedName("bankAccountUUID")
    private String bankAccountUUID;

    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("description")
    private String description;

    @SerializedName("merchantAccount")
    private String merchantAccount;

    @SerializedName("splits")
    private List<Split> splits = null;

    public DebitAccountHolderRequest(String accountHolderCode, String bankAccountUUID, String merchantAccount, List<Split> splits) {
        this.accountHolderCode = accountHolderCode;
        this.bankAccountUUID = bankAccountUUID;
        this.merchantAccount = merchantAccount;
        this.splits = splits;
    }
    public String getAccountHolderCode() {
        return accountHolderCode;
    }
    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }
    public String getBankAccountUUID() {
        return bankAccountUUID;
    }
    public void setBankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getMerchantAccount() {
        return merchantAccount;
    }
    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }
    public List<Split> getSplits() {
        return splits;
    }
    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DebitAccountHolderRequest debitAccountHolderRequest = (DebitAccountHolderRequest) o;
        return Objects.equals(this.accountHolderCode, debitAccountHolderRequest.accountHolderCode)
                && Objects.equals(this.amount, debitAccountHolderRequest.amount)
                && Objects.equals(this.bankAccountUUID,
                                  debitAccountHolderRequest.bankAccountUUID)
                && Objects.equals(this.merchantAccount, debitAccountHolderRequest.merchantAccount)
                && Objects.equals(this.splits, debitAccountHolderRequest.splits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, amount, bankAccountUUID, merchantAccount, splits);
    }

    @Override
    public String toString() {
        String sb = "class DebitAccountHolderRequest {\n" +
                "    accountHolderCode: " + toIndentedString(accountHolderCode) + "\n" +
                "    amount: " + toIndentedString(amount) + "\n" +
                "    bankAccountUUID: " + toIndentedString(bankAccountUUID) + "\n" +
                "    merchantAccount: " + toIndentedString(merchantAccount) + "\n" +
                "    description: " + toIndentedString(description) + "\n" +
                "}";
        return sb;
    }
}
