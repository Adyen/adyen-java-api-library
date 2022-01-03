package com.adyen.model.marketpay;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class DebitAccountHolderResponse {
    @SerializedName("accountHolderCode")
    private String accountHolderCode;

    @SerializedName("bankAccountUUID")
    private String bankAccountUUID;

    @SerializedName("invalidFields")
    private List<ErrorFieldType> invalidFields = null;

    @SerializedName("merchantReferences")
    private String[] merchantReferences;

    @SerializedName("pspReference")
    private String pspReference;

    @SerializedName("resultCode")
    private String resultCode;

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
     * List of the reference values from the split array in the request.
     *
     * @return merchantReferences
     **/
    public String[] getMerchantReferences() {
        return merchantReferences;
    }

    public void setMerchantReference(String[] merchantReferences) {
        this.merchantReferences = merchantReferences;
    }

    /**
     * The reference of a request.  Can be used to uniquely identify the request.
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    /**
     * The result code.
     *
     * @return resultCode
     **/
    public String getResultCode() {
        return resultCode;
    }
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
}
