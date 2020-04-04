
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

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PayoutAccountHolderResponse
 */

public class PayoutAccountHolderResponse {
    @SerializedName("bankAccountUUID")
    private String bankAccountUUID = null;

    @SerializedName("invalidFields")
    private List<ErrorFieldType> invalidFields = null;

    @SerializedName("merchantReference")
    private String merchantReference = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("resultCode")
    private String resultCode = null;

    public PayoutAccountHolderResponse bankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
        return this;
    }

    /**
     * The unique ID of the Bank Account to which the payout was made.
     *
     * @return bankAccountUUID
     **/
    public String getBankAccountUUID() {
        return bankAccountUUID;
    }

    public void setBankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
    }

    public PayoutAccountHolderResponse invalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
        return this;
    }

    public PayoutAccountHolderResponse addInvalidFieldsItem(ErrorFieldType invalidFieldsItem) {
        if (this.invalidFields == null) {
            this.invalidFields = new ArrayList<>();
        }
        this.invalidFields.add(invalidFieldsItem);
        return this;
    }

    /**
     * Contains field validation errors that would prevent requests from being processed.
     *
     * @return invalidFields
     **/
    public List<ErrorFieldType> getInvalidFields() {
        return invalidFields;
    }

    public void setInvalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
    }

    public PayoutAccountHolderResponse merchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
        return this;
    }

    /**
     * The value supplied by the executing user when initiating the transfer; may be used to link multiple transactions.
     *
     * @return merchantReference
     **/
    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }

    public PayoutAccountHolderResponse pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
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

    public PayoutAccountHolderResponse resultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PayoutAccountHolderResponse payoutAccountHolderResponse = (PayoutAccountHolderResponse) o;
        return Objects.equals(this.bankAccountUUID, payoutAccountHolderResponse.bankAccountUUID) &&
                Objects.equals(this.invalidFields, payoutAccountHolderResponse.invalidFields) &&
                Objects.equals(this.merchantReference, payoutAccountHolderResponse.merchantReference) &&
                Objects.equals(this.pspReference, payoutAccountHolderResponse.pspReference) &&
                Objects.equals(this.resultCode, payoutAccountHolderResponse.resultCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankAccountUUID, invalidFields, merchantReference, pspReference, resultCode);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PayoutAccountHolderResponse {\n");

        sb.append("    bankAccountUUID: ").append(toIndentedString(bankAccountUUID)).append("\n");
        sb.append("    invalidFields: ").append(toIndentedString(invalidFields)).append("\n");
        sb.append("    merchantReference: ").append(toIndentedString(merchantReference)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
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
