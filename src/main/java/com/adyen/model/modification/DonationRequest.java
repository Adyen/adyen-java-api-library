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

package com.adyen.model.modification;

import com.adyen.constants.TextConstants;
import com.adyen.model.Amount;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;
/**
 * DonationRequest
 */

public class DonationRequest {
    @SerializedName("donationAccount")
    private String donationAccount = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("modificationAmount")
    private Amount modificationAmount = null;

    @SerializedName("originalReference")
    private String originalReference = null;

    @SerializedName("reference")
    private String reference = null;

    public DonationRequest donationAccount(String donationAccount) {
        this.donationAccount = donationAccount;
        return this;
    }

    /**
     * The Adyen account name of the charity.
     * @return donationAccount
     **/
    public String getDonationAccount() {
        return donationAccount;
    }

    public void setDonationAccount(String donationAccount) {
        this.donationAccount = donationAccount;
    }

    public DonationRequest merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    /**
     * The merchant account that is used to process the payment.
     * @return merchantAccount
     **/
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public DonationRequest modificationAmount(Amount modificationAmount) {
        this.modificationAmount = modificationAmount;
        return this;
    }

    /**
     * Get modificationAmount
     * @return modificationAmount
     **/
    public Amount getModificationAmount() {
        return modificationAmount;
    }

    public void setModificationAmount(Amount modificationAmount) {
        this.modificationAmount = modificationAmount;
    }

    public DonationRequest originalReference(String originalReference) {
        this.originalReference = originalReference;
        return this;
    }

    /**
     * The original pspReference of the payment to modify. This reference is returned in: * authorisation response * authorisation notification
     * @return originalReference
     **/
    public String getOriginalReference() {
        return originalReference;
    }

    public void setOriginalReference(String originalReference) {
        this.originalReference = originalReference;
    }

    public DonationRequest reference(String reference) {
        this.reference = reference;
        return this;
    }

    /**
     * Optionally, you can specify your reference for the payment modification. This reference is visible in Customer Area and in reports. Maximum length: 80 characters.
     * @return reference
     **/
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        DonationRequest donationRequest = (DonationRequest) o;
        return Objects.equals(this.donationAccount, donationRequest.donationAccount) &&
                Objects.equals(this.merchantAccount, donationRequest.merchantAccount) &&
                Objects.equals(this.modificationAmount, donationRequest.modificationAmount) &&
                Objects.equals(this.originalReference, donationRequest.originalReference) &&
                Objects.equals(this.reference, donationRequest.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(donationAccount, merchantAccount, modificationAmount, originalReference, reference);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DonationRequest {").append(TextConstants.LINE_BREAK);

        sb.append("    donationAccount: ").append(toIndentedString(donationAccount)).append(TextConstants.LINE_BREAK);
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append(TextConstants.LINE_BREAK);
        sb.append("    modificationAmount: ").append(toIndentedString(modificationAmount)).append(TextConstants.LINE_BREAK);
        sb.append("    originalReference: ").append(toIndentedString(originalReference)).append(TextConstants.LINE_BREAK);
        sb.append("    reference: ").append(toIndentedString(reference)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }



}
