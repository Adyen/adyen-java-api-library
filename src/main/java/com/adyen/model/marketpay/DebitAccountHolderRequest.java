package com.adyen.model.marketpay;

import static com.adyen.util.Util.toIndentedString;

import java.util.List;
import java.util.Objects;

import com.adyen.model.Amount;
import com.adyen.model.Split;
import com.google.gson.annotations.SerializedName;

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
        StringBuilder sb = new StringBuilder();
        sb.append("class DebitAccountHolderRequest {\n");
        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    bankAccountUUID: ").append(toIndentedString(bankAccountUUID)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
