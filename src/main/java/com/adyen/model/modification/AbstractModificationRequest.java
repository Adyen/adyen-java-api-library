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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.adyen.model.Split;
import com.adyen.model.additionalData.InvoiceLine;
import com.adyen.model.additionalData.SplitPayment;
import com.adyen.model.additionalData.SplitPaymentItem;
import com.adyen.model.applicationinfo.ApplicationInfo;
import com.google.gson.annotations.SerializedName;

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
    private ApplicationInfo applicationInfo;

    @SerializedName("splits")
    private List<Split> splits = null;

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

    public void setApplicationInfo(ApplicationInfo applicationInfo) {
        this.applicationInfo = applicationInfo;
    }

    public T applicationInfo(ApplicationInfo applicationInfo) {
        this.applicationInfo = applicationInfo;
        return (T) this;
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
     * get additionalData map Create the map if doesn't exists
     *
     * @return additional data
     */
    public Map<String, String> getOrCreateAdditionalData() {
        if (this.getAdditionalData() == null) {
            this.setAdditionalData(new HashMap<String, String>());
        }

        return this.getAdditionalData();
    }

    /**
     * Set invoiceLines in addtionalData
     * @param invoiceLines invoicelines
     * @return InvoiceLines
     */
    public T setInvoiceLines(List<InvoiceLine> invoiceLines) {

        Integer count = 1;
        for (InvoiceLine invoiceLine : invoiceLines) {

            StringBuilder sb = new StringBuilder();
            sb.append("openinvoicedata.line");
            sb.append(Integer.toString(count));
            String lineNumber = sb.toString();

            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".currencyCode").toString(), invoiceLine.getCurrencyCode());

            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".description").toString(), invoiceLine.getDescription());

            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".itemAmount").toString(), invoiceLine.getItemAmount().toString());

            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".itemVatAmount").toString(), invoiceLine.getItemVATAmount().toString());

            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".itemVatPercentage").toString(), invoiceLine.getItemVatPercentage().toString());

            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".numberOfItems").toString(), Integer.toString(invoiceLine.getNumberOfItems()));

            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".vatCategory").toString(), invoiceLine.getVatCategory().toString());

            // Addional field only for RatePay
            if (invoiceLine.getItemId() != null && ! invoiceLine.getItemId().isEmpty()) {
                this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".itemId").toString(), invoiceLine.getItemId());
            }

            count++;
        }

        this.getOrCreateAdditionalData().put("openinvoicedata.numberOfLines", Integer.toString(invoiceLines.size()));
        return (T) this;
    }

    public T setSplitPayment(SplitPayment splitPayment) {
        this.getOrCreateAdditionalData().put("split.api", splitPayment.getApi().toString());
        this.getOrCreateAdditionalData().put("split.totalAmount", splitPayment.getTotalAmount().toString());
        this.getOrCreateAdditionalData().put("split.currencyCode", splitPayment.getCurrencyCode());

        Integer count = 1;
        for (SplitPaymentItem splitPaymentItem : splitPayment.getSplitPaymentItems()) {

            StringBuilder sb = new StringBuilder();
            sb.append("split.item");
            sb.append(Integer.toString(count));
            String lineNumber = sb.toString();
            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".amount").toString(), splitPaymentItem.getAmount().toString());
            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".type").toString(), splitPaymentItem.getType());
            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".account").toString(), splitPaymentItem.getAccount());
            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".reference").toString(), splitPaymentItem.getReference());
            this.getOrCreateAdditionalData().put(new StringBuilder().append(lineNumber).append(".description").toString(), splitPaymentItem.getDescription());

            count++;
        }
        this.getOrCreateAdditionalData().put("split.nrOfItems", Integer.toString(splitPayment.getSplitPaymentItems().size()));

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
        return Objects.equals(this.reference, modificationRequest.reference)
                && Objects.equals(this.authorisationCode, modificationRequest.authorisationCode)
                && Objects.equals(this.originalReference,
                                  modificationRequest.originalReference)
                && Objects.equals(this.merchantAccount, modificationRequest.merchantAccount)
                && Objects.equals(this.applicationInfo, modificationRequest.applicationInfo)
                && Objects.equals(this.additionalData, modificationRequest.additionalData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, authorisationCode, originalReference, merchantAccount, additionalData, applicationInfo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    authorisationCode: ").append(toIndentedString(authorisationCode)).append("\n");
        sb.append("    originalReference: ").append(toIndentedString(originalReference)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    applicationInfo: ").append(toIndentedString(additionalData)).append("\n");
        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");

        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     *
     * @param o string
     * @return Indented string
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

