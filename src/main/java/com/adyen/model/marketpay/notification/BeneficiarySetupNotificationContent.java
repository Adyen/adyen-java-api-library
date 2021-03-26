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

package com.adyen.model.marketpay.notification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import static com.adyen.util.Util.toIndentedString;

public class BeneficiarySetupNotificationContent {
    @SerializedName("destinationAccountCode")
    private String destinationAccountCode = null;

    @SerializedName("destinationAccountHolderCode")
    private String destinationAccountHolderCode = null;

    @SerializedName("invalidFields")
    private List<ErrorFieldType> invalidFields = null;

    @SerializedName("merchantReference")
    private String merchantReference = null;

    @SerializedName("sourceAccountCode")
    private String sourceAccountCode = null;

    @SerializedName("sourceAccountHolderCode")
    private String sourceAccountHolderCode = null;

    @SerializedName("transferDate")
    private Date transferDate = null;

    public BeneficiarySetupNotificationContent destinationAccountCode(String destinationAccountCode) {
        this.destinationAccountCode = destinationAccountCode;
        return this;
    }

    /**
     * The code of the beneficiary account.
     *
     * @return destinationAccountCode
     **/
    public String getDestinationAccountCode() {
        return destinationAccountCode;
    }

    public void setDestinationAccountCode(String destinationAccountCode) {
        this.destinationAccountCode = destinationAccountCode;
    }

    public BeneficiarySetupNotificationContent destinationAccountHolderCode(String destinationAccountHolderCode) {
        this.destinationAccountHolderCode = destinationAccountHolderCode;
        return this;
    }

    /**
     * The code of the beneficiary Account Holder.
     *
     * @return destinationAccountHolderCode
     **/
    public String getDestinationAccountHolderCode() {
        return destinationAccountHolderCode;
    }

    public void setDestinationAccountHolderCode(String destinationAccountHolderCode) {
        this.destinationAccountHolderCode = destinationAccountHolderCode;
    }

    public BeneficiarySetupNotificationContent invalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
        return this;
    }

    public BeneficiarySetupNotificationContent addInvalidFieldsItem(ErrorFieldType invalidFieldsItem) {
        if (this.invalidFields == null) {
            this.invalidFields = new ArrayList<ErrorFieldType>();
        }
        this.invalidFields.add(invalidFieldsItem);
        return this;
    }

    /**
     * A listing of the invalid fields which have caused the Setup Beneficiary request to fail. If this is empty, the Setup Beneficiary request has succeeded.
     *
     * @return invalidFields
     **/
    public List<ErrorFieldType> getInvalidFields() {
        return invalidFields;
    }

    public void setInvalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
    }

    public BeneficiarySetupNotificationContent merchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
        return this;
    }

    /**
     * The reference provided by the merchant.
     *
     * @return merchantReference
     **/
    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }

    public BeneficiarySetupNotificationContent sourceAccountCode(String sourceAccountCode) {
        this.sourceAccountCode = sourceAccountCode;
        return this;
    }

    /**
     * The code of the benefactor account.
     *
     * @return sourceAccountCode
     **/
    public String getSourceAccountCode() {
        return sourceAccountCode;
    }

    public void setSourceAccountCode(String sourceAccountCode) {
        this.sourceAccountCode = sourceAccountCode;
    }

    public BeneficiarySetupNotificationContent sourceAccountHolderCode(String sourceAccountHolderCode) {
        this.sourceAccountHolderCode = sourceAccountHolderCode;
        return this;
    }

    /**
     * The code of the benefactor Account Holder.
     *
     * @return sourceAccountHolderCode
     **/
    public String getSourceAccountHolderCode() {
        return sourceAccountHolderCode;
    }

    public void setSourceAccountHolderCode(String sourceAccountHolderCode) {
        this.sourceAccountHolderCode = sourceAccountHolderCode;
    }

    public BeneficiarySetupNotificationContent transferDate(Date transferDate) {
        this.transferDate = transferDate;
        return this;
    }

    /**
     * The date on which the beneficiary was set up and funds transferred from benefactor to beneficiary.
     *
     * @return transferDate
     **/
    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BeneficiarySetupNotificationContent beneficiarySetupNotificationContent = (BeneficiarySetupNotificationContent) o;
        return Objects.equals(this.destinationAccountCode, beneficiarySetupNotificationContent.destinationAccountCode) &&
                Objects.equals(this.destinationAccountHolderCode, beneficiarySetupNotificationContent.destinationAccountHolderCode) &&
                Objects.equals(this.invalidFields, beneficiarySetupNotificationContent.invalidFields) &&
                Objects.equals(this.merchantReference, beneficiarySetupNotificationContent.merchantReference) &&
                Objects.equals(this.sourceAccountCode, beneficiarySetupNotificationContent.sourceAccountCode) &&
                Objects.equals(this.sourceAccountHolderCode, beneficiarySetupNotificationContent.sourceAccountHolderCode) &&
                Objects.equals(this.transferDate, beneficiarySetupNotificationContent.transferDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinationAccountCode, destinationAccountHolderCode, invalidFields, merchantReference, sourceAccountCode, sourceAccountHolderCode, transferDate);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BeneficiarySetupNotificationContent {\n");

        sb.append("    destinationAccountCode: ").append(toIndentedString(destinationAccountCode)).append("\n");
        sb.append("    destinationAccountHolderCode: ").append(toIndentedString(destinationAccountHolderCode)).append("\n");
        sb.append("    invalidFields: ").append(toIndentedString(invalidFields)).append("\n");
        sb.append("    merchantReference: ").append(toIndentedString(merchantReference)).append("\n");
        sb.append("    sourceAccountCode: ").append(toIndentedString(sourceAccountCode)).append("\n");
        sb.append("    sourceAccountHolderCode: ").append(toIndentedString(sourceAccountHolderCode)).append("\n");
        sb.append("    transferDate: ").append(toIndentedString(transferDate)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
