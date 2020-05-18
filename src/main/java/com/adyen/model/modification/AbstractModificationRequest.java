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
package com.adyen.model.modification;

import com.adyen.model.Split;
import com.adyen.model.ThreeDSecureData;
import com.adyen.model.additionalData.InvoiceLine;
import com.adyen.model.additionalData.SplitPayment;
import com.adyen.model.additionalData.SplitPaymentItem;
import com.adyen.model.applicationinfo.ApplicationInfo;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Abstract class for modification requests
 */
public class AbstractModificationRequest<T extends AbstractModificationRequest<T>> {
    @SerializedName("reference")
    private String reference = null;

    @SerializedName("authorisationCode")
    private String authorisationCode = null;

    @SerializedName("originalReference")
    private String originalReference = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("additionalData")
    private Map<String, String> additionalData = null;

    @SerializedName("applicationInfo")
    private final ApplicationInfo applicationInfo;

    @SerializedName("splits")
    private List<Split> splits = null;

    @SerializedName("mpiData")
    private ThreeDSecureData mpiData = null;

    @SerializedName("originalMerchantReference")
    private String originalMerchantReference = null;

    @SerializedName("tenderReference")
    private String tenderReference = null;

    @SerializedName("uniqueTerminalId")
    private String uniqueTerminalId = null;

    public AbstractModificationRequest() {
        applicationInfo = new ApplicationInfo();
    }

    public T reference(String reference) {
        this.reference = reference;
        return (T) this;
    }

    /**
     * the reference assigned to this modification
     *
     * @return reference
     **/
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public T authorisationCode(String authorisationCode) {
        this.authorisationCode = authorisationCode;
        return (T) this;
    }

    /**
     * the authorisation code of the payment (only required for the \"authoriseReferral\" method)
     *
     * @return authorisationCode
     **/
    public String getAuthorisationCode() {
        return authorisationCode;
    }

    public void setAuthorisationCode(String authorisationCode) {
        this.authorisationCode = authorisationCode;
    }

    public T originalReference(String originalReference) {
        this.originalReference = originalReference;
        return (T) this;
    }

    /**
     * the pspreference of the payment to modify
     *
     * @return originalReference
     **/
    public String getOriginalReference() {
        return originalReference;
    }

    public void setOriginalReference(String originalReference) {
        this.originalReference = originalReference;
    }

    public T merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return (T) this;
    }

    /**
     * the merchant account which will be used to process the payment
     *
     * @return merchantAccount
     **/
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public ApplicationInfo getApplicationInfo() {
        return applicationInfo;
    }

    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
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

    public T originalMerchantReference(String originalMerchantReference) {
        this.originalMerchantReference = originalMerchantReference;
        return (T) this;
    }

    /**
     * The original merchant reference to cancel.
     * @return originalMerchantReference
     **/
    public String getOriginalMerchantReference() {
        return originalMerchantReference;
    }

    public void setOriginalMerchantReference(String originalMerchantReference) {
        this.originalMerchantReference = originalMerchantReference;
    }

    public T tenderReference(String tenderReference) {
        this.tenderReference = tenderReference;
        return (T) this;
    }

    /**
     * The transaction reference provided by the PED. For point-of-sale integrations only.
     * @return tenderReference
     **/
    public String getTenderReference() {
        return tenderReference;
    }

    public void setTenderReference(String tenderReference) {
        this.tenderReference = tenderReference;
    }

    public T uniqueTerminalId(String uniqueTerminalId) {
        this.uniqueTerminalId = uniqueTerminalId;
        return (T) this;
    }

    /**
     * Unique terminal ID for the PED that originally processed the request. For point-of-sale integrations only.
     * @return uniqueTerminalId
     **/
    public String getUniqueTerminalId() {
        return uniqueTerminalId;
    }

    public void setUniqueTerminalId(String uniqueTerminalId) {
        this.uniqueTerminalId = uniqueTerminalId;
    }


    /**
     * get additionalData map Create the map if doesn't exists
     *
     * @return additional data
     */
    public Map<String, String> getOrCreateAdditionalData() {
        if (getAdditionalData() == null) {
            setAdditionalData(new HashMap<>());
        }

        return getAdditionalData();
    }

    /**
     * Set invoiceLines in addtionalData
     * @param invoiceLines invoicelines
     * @return InvoiceLines
     */
    public T setInvoiceLines(List<InvoiceLine> invoiceLines) {

        int count = 1;
        for (InvoiceLine invoiceLine : invoiceLines) {

            String lineNumber = "openinvoicedata.line" + count;

            getOrCreateAdditionalData().put(lineNumber + ".currencyCode", invoiceLine.getCurrencyCode());
            getOrCreateAdditionalData().put(lineNumber + ".description", invoiceLine.getDescription());
            getOrCreateAdditionalData().put(lineNumber + ".itemAmount", invoiceLine.getItemAmount().toString());
            getOrCreateAdditionalData().put(lineNumber + ".itemVatAmount", invoiceLine.getItemVATAmount().toString());
            getOrCreateAdditionalData().put(lineNumber + ".itemVatPercentage", invoiceLine.getItemVatPercentage().toString());
            getOrCreateAdditionalData().put(lineNumber + ".numberOfItems", Integer.toString(invoiceLine.getNumberOfItems()));
            getOrCreateAdditionalData().put(lineNumber + ".vatCategory", invoiceLine.getVatCategory().toString());

            // Addional field only for RatePay
            if (invoiceLine.getItemId() != null && ! invoiceLine.getItemId().isEmpty()) {
                getOrCreateAdditionalData().put(lineNumber + ".itemId", invoiceLine.getItemId());
            }

            count++;
        }

        getOrCreateAdditionalData().put("openinvoicedata.numberOfLines", Integer.toString(invoiceLines.size()));
        return (T) this;
    }

    public T setSplitPayment(SplitPayment splitPayment) {
        getOrCreateAdditionalData().put("split.api", splitPayment.getApi().toString());
        getOrCreateAdditionalData().put("split.totalAmount", splitPayment.getTotalAmount().toString());
        getOrCreateAdditionalData().put("split.currencyCode", splitPayment.getCurrencyCode());

        int count = 1;
        for (SplitPaymentItem splitPaymentItem : splitPayment.getSplitPaymentItems()) {

            String lineNumber = "split.item" + count;
            getOrCreateAdditionalData().put(lineNumber + ".amount", splitPaymentItem.getAmount().toString());
            getOrCreateAdditionalData().put(lineNumber + ".type", splitPaymentItem.getType());
            getOrCreateAdditionalData().put(lineNumber + ".account", splitPaymentItem.getAccount());
            getOrCreateAdditionalData().put(lineNumber + ".reference", splitPaymentItem.getReference());
            getOrCreateAdditionalData().put(lineNumber + ".description", splitPaymentItem.getDescription());

            count++;
        }
        getOrCreateAdditionalData().put("split.nrOfItems", Integer.toString(splitPayment.getSplitPaymentItems().size()));

        return (T) this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractModificationRequest modificationRequest = (AbstractModificationRequest) o;
        return Objects.equals(reference, modificationRequest.reference)
                && Objects.equals(authorisationCode, modificationRequest.authorisationCode)
                && Objects.equals(originalReference,
                                  modificationRequest.originalReference)
                && Objects.equals(merchantAccount, modificationRequest.merchantAccount)
                && Objects.equals(applicationInfo, modificationRequest.applicationInfo)
                && Objects.equals(additionalData, modificationRequest.additionalData)
                && Objects.equals(mpiData, modificationRequest.mpiData)
                && Objects.equals(originalMerchantReference, modificationRequest.originalMerchantReference)
                && Objects.equals(tenderReference, modificationRequest.tenderReference)
                && Objects.equals(uniqueTerminalId, modificationRequest.uniqueTerminalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, authorisationCode, originalReference, merchantAccount, additionalData, applicationInfo, mpiData, originalMerchantReference, tenderReference, uniqueTerminalId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    authorisationCode: ").append(toIndentedString(authorisationCode)).append("\n");
        sb.append("    originalReference: ").append(toIndentedString(originalReference)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    applicationInfo: ").append(toIndentedString(applicationInfo)).append("\n");
        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
        sb.append("    mpiData: ").append(toIndentedString(mpiData)).append("\n");
        sb.append("    originalMerchantReference: ").append(toIndentedString(originalMerchantReference)).append("\n");
        sb.append("    tenderReference: ").append(toIndentedString(tenderReference)).append("\n");
        sb.append("    uniqueTerminalId: ").append(toIndentedString(uniqueTerminalId)).append("\n");

        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     *
     * @param o string
     * @return Indented string
     */
    private static String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
