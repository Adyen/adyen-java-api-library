package com.adyen.model;

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * ThreeDS2ResultRequest
 */
public class ThreeDS2ResultRequest {

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    public ThreeDS2ResultRequest merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }


    public String getMerchantAccount() {
        return merchantAccount;
    }
    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public ThreeDS2ResultRequest pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }


    public String getPspReference() {
        return pspReference;
    }
    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        ThreeDS2ResultRequest threeDS2ResultRequest = (ThreeDS2ResultRequest) o;
        return Objects.equals(this.merchantAccount, threeDS2ResultRequest.merchantAccount) &&
                Objects.equals(this.pspReference, threeDS2ResultRequest.pspReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchantAccount, pspReference);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ThreeDS2ResultRequest {").append(TextConstants.LINE_BREAK);

        sb.append("    merchantAccount: ").append(Util.toIndentedString(merchantAccount)).append(TextConstants.LINE_BREAK);
        sb.append("    pspReference: ").append(Util.toIndentedString(pspReference)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }




}



