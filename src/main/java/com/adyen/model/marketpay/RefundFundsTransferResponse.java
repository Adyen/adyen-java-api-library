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
 * RefundFundsTransferResponse
 */

public class RefundFundsTransferResponse {
    @SerializedName("invalidFields")
    private List<ErrorFieldType> invalidFields = null;

    @SerializedName("merchantReference")
    private String merchantReference = null;

    @SerializedName("message")
    private String message = null;

    @SerializedName("originalReference")
    private String originalReference = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("resultCode")
    private String resultCode = null;

    public RefundFundsTransferResponse invalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
        return this;
    }

    public RefundFundsTransferResponse addInvalidFieldsItem(ErrorFieldType invalidFieldsItem) {
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

    public RefundFundsTransferResponse merchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
        return this;
    }

    /**
     * The value supplied by the executing user when initiating the transfer refund; may be used to link multiple transactions.
     *
     * @return merchantReference
     **/
    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }

    public RefundFundsTransferResponse message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get message
     *
     * @return message
     **/
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RefundFundsTransferResponse originalReference(String originalReference) {
        this.originalReference = originalReference;
        return this;
    }

    /**
     * A PSP reference of the original fund transfer.
     *
     * @return originalReference
     **/
    public String getOriginalReference() {
        return originalReference;
    }

    public void setOriginalReference(String originalReference) {
        this.originalReference = originalReference;
    }

    public RefundFundsTransferResponse pspReference(String pspReference) {
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

    public RefundFundsTransferResponse resultCode(String resultCode) {
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
        RefundFundsTransferResponse refundFundsTransferResponse = (RefundFundsTransferResponse) o;
        return Objects.equals(this.invalidFields, refundFundsTransferResponse.invalidFields) &&
                Objects.equals(this.merchantReference, refundFundsTransferResponse.merchantReference) &&
                Objects.equals(this.message, refundFundsTransferResponse.message) &&
                Objects.equals(this.originalReference, refundFundsTransferResponse.originalReference) &&
                Objects.equals(this.pspReference, refundFundsTransferResponse.pspReference) &&
                Objects.equals(this.resultCode, refundFundsTransferResponse.resultCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invalidFields, merchantReference, message, originalReference, pspReference, resultCode);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RefundFundsTransferResponse {\n");

        sb.append("    invalidFields: ").append(toIndentedString(invalidFields)).append("\n");
        sb.append("    merchantReference: ").append(toIndentedString(merchantReference)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    originalReference: ").append(toIndentedString(originalReference)).append("\n");
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
