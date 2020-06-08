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
package com.adyen.model.storedvalue;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * StoredValueVoidRequest
 */

public class StoredValueVoidRequest {
    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("originalReference")
    private String originalReference = null;

    @SerializedName("reference")
    private String reference = null;

    @SerializedName("store")
    private String store = null;

    @SerializedName("tenderReference")
    private String tenderReference = null;

    @SerializedName("uniqueTerminalId")
    private String uniqueTerminalId = null;

    public StoredValueVoidRequest merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    /**
     * The merchant account identifier, with which you want to process the transaction.
     *
     * @return merchantAccount
     **/
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public StoredValueVoidRequest originalReference(String originalReference) {
        this.originalReference = originalReference;
        return this;
    }

    /**
     * The original pspReference of the payment to modify.
     *
     * @return originalReference
     **/
    public String getOriginalReference() {
        return originalReference;
    }

    public void setOriginalReference(String originalReference) {
        this.originalReference = originalReference;
    }

    public StoredValueVoidRequest reference(String reference) {
        this.reference = reference;
        return this;
    }

    /**
     * Optionally, you can specify your reference for the payment modification. This reference is visible in Customer Area and in reports. Maximum length: 80 characters.
     *
     * @return reference
     **/
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public StoredValueVoidRequest store(String store) {
        this.store = store;
        return this;
    }

    /**
     * The physical store, for which this payment is processed.
     *
     * @return store
     **/
    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public StoredValueVoidRequest tenderReference(String tenderReference) {
        this.tenderReference = tenderReference;
        return this;
    }

    /**
     * Get tenderReference
     *
     * @return tenderReference
     **/
    public String getTenderReference() {
        return tenderReference;
    }

    public void setTenderReference(String tenderReference) {
        this.tenderReference = tenderReference;
    }

    public StoredValueVoidRequest uniqueTerminalId(String uniqueTerminalId) {
        this.uniqueTerminalId = uniqueTerminalId;
        return this;
    }

    /**
     * Get uniqueTerminalId
     *
     * @return uniqueTerminalId
     **/
    public String getUniqueTerminalId() {
        return uniqueTerminalId;
    }

    public void setUniqueTerminalId(String uniqueTerminalId) {
        this.uniqueTerminalId = uniqueTerminalId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StoredValueVoidRequest storedValueVoidRequest = (StoredValueVoidRequest) o;
        return Objects.equals(this.merchantAccount, storedValueVoidRequest.merchantAccount) &&
                Objects.equals(this.originalReference, storedValueVoidRequest.originalReference) &&
                Objects.equals(this.reference, storedValueVoidRequest.reference) &&
                Objects.equals(this.store, storedValueVoidRequest.store) &&
                Objects.equals(this.tenderReference, storedValueVoidRequest.tenderReference) &&
                Objects.equals(this.uniqueTerminalId, storedValueVoidRequest.uniqueTerminalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchantAccount, originalReference, reference, store, tenderReference, uniqueTerminalId);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StoredValueVoidRequest {\n");

        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    originalReference: ").append(toIndentedString(originalReference)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    store: ").append(toIndentedString(store)).append("\n");
        sb.append("    tenderReference: ").append(toIndentedString(tenderReference)).append("\n");
        sb.append("    uniqueTerminalId: ").append(toIndentedString(uniqueTerminalId)).append("\n");
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
