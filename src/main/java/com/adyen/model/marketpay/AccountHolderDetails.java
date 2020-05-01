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

import com.adyen.model.Address;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * AccountHolderDetails
 */
public class AccountHolderDetails {
    @SerializedName("address")
    private Address address = null;

    @SerializedName("bankAccountDetails")
    private List<BankAccountDetail> bankAccountDetails = null;

    @SerializedName("businessDetails")
    private BusinessDetails businessDetails = null;

    @SerializedName("email")
    private String email = null;

    @SerializedName("fullPhoneNumber")
    private String fullPhoneNumber = null;

    @SerializedName("individualDetails")
    private IndividualDetails individualDetails = null;

    @SerializedName("merchantCategoryCode")
    private String merchantCategoryCode = null;

    @SerializedName("metadata")
    private Map<String, String> metadata = null;

    @SerializedName("payoutMethods")
    private List<PayoutMethod> payoutMethods = null;

    @SerializedName("webAddress")
    private String webAddress = null;

    @SerializedName("phoneNumber")
    private PhoneNumber phoneNumber = null;

    public AccountHolderDetails address(Address address) {
        this.address = address;
        return this;
    }

    /**
     * Get address
     *
     * @return address
     **/
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public AccountHolderDetails bankAccountDetails(List<BankAccountDetail> bankAccountDetails) {
        this.bankAccountDetails = bankAccountDetails;
        return this;
    }

    public AccountHolderDetails addBankAccountDetailsItem(BankAccountDetail bankAccountDetailsItem) {
        if (this.bankAccountDetails == null) {
            this.bankAccountDetails = new ArrayList<>();
        }
        this.bankAccountDetails.add(bankAccountDetailsItem);
        return this;
    }

    /**
     * Each of the bank accounts associated with the account holder. &gt; Each array entry should represent one bank account. &gt; For comprehensive detail regarding the required &#x60;BankAccountDetail&#x60; fields, please refer to the [KYC Verification documentation](https://docs.adyen.com/marketpay/onboarding-and-verification/verification-checks).
     *
     * @return bankAccountDetails
     **/
    public List<BankAccountDetail> getBankAccountDetails() {
        return bankAccountDetails;
    }

    public void setBankAccountDetails(List<BankAccountDetail> bankAccountDetails) {
        this.bankAccountDetails = bankAccountDetails;
    }

    public AccountHolderDetails businessDetails(BusinessDetails businessDetails) {
        this.businessDetails = businessDetails;
        return this;
    }

    /**
     * Get businessDetails
     *
     * @return businessDetails
     **/
    public BusinessDetails getBusinessDetails() {
        return businessDetails;
    }

    public void setBusinessDetails(BusinessDetails businessDetails) {
        this.businessDetails = businessDetails;
    }

    public AccountHolderDetails email(String email) {
        this.email = email;
        return this;
    }

    /**
     * The email address of the account holder.
     *
     * @return email
     **/
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AccountHolderDetails fullPhoneNumber(String fullPhoneNumber) {
        this.fullPhoneNumber = fullPhoneNumber;
        return this;
    }

    /**
     * The phone number of the account holder provided as a single string. It will be handled as a landline phone. **Examples:** \&quot;0031 6 11 22 33 44\&quot;, \&quot;+316/1122-3344\&quot;, \&quot;(0031) 611223344\&quot;
     *
     * @return fullPhoneNumber
     **/
    public String getFullPhoneNumber() {
        return fullPhoneNumber;
    }

    public void setFullPhoneNumber(String fullPhoneNumber) {
        this.fullPhoneNumber = fullPhoneNumber;
    }

    public AccountHolderDetails individualDetails(IndividualDetails individualDetails) {
        this.individualDetails = individualDetails;
        return this;
    }

    /**
     * Get individualDetails
     *
     * @return individualDetails
     **/
    public IndividualDetails getIndividualDetails() {
        return individualDetails;
    }

    public void setIndividualDetails(IndividualDetails individualDetails) {
        this.individualDetails = individualDetails;
    }

    public AccountHolderDetails merchantCategoryCode(String merchantCategoryCode) {
        this.merchantCategoryCode = merchantCategoryCode;
        return this;
    }

    /**
     * The Merchant Category Code of the account holder. &gt; If not specified in the request, this will be derived from the platform account (which is configured by Adyen).
     *
     * @return merchantCategoryCode
     **/
    public String getMerchantCategoryCode() {
        return merchantCategoryCode;
    }

    public void setMerchantCategoryCode(String merchantCategoryCode) {
        this.merchantCategoryCode = merchantCategoryCode;
    }

    public AccountHolderDetails metadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * A set of key and value pairs for general use by the account holder or merchant. The keys do not have specific names and may be used for storing miscellaneous data as desired. &gt; The values being stored have a maximum length of eighty (80) characters and will be truncated if necessary. &gt; Note that during an update of metadata, the omission of existing key-value pairs will result in the deletion of those key-value pairs.
     *
     * @return metadata
     **/
    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public AccountHolderDetails payoutMethods(List<PayoutMethod> payoutMethods) {
        this.payoutMethods = payoutMethods;
        return this;
    }

    public AccountHolderDetails addPayoutMethodsItem(PayoutMethod payoutMethodsItem) {
        if (this.payoutMethods == null) {
            this.payoutMethods = new ArrayList<>();
        }
        this.payoutMethods.add(payoutMethodsItem);
        return this;
    }

    /**
     * Each of the card tokens associated with the account holder. &gt; Each array entry should represent one card token. &gt; For comprehensive detail regarding the required &#x60;CardToken&#x60; fields, please refer to the [KYC Verification documentation](https://docs.adyen.com/marketpay/onboarding-and-verification/verification-checks).
     *
     * @return payoutMethods
     **/
    public List<PayoutMethod> getPayoutMethods() {
        return payoutMethods;
    }

    public void setPayoutMethods(List<PayoutMethod> payoutMethods) {
        this.payoutMethods = payoutMethods;
    }

    public AccountHolderDetails webAddress(String webAddress) {
        this.webAddress = webAddress;
        return this;
    }

    /**
     * The URL of the website of the account holder.
     *
     * @return webAddress
     **/
    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    /**
     * The phone number of the account holder.
     * @return phoneNumber
     */
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountHolderDetails accountHolderDetails = (AccountHolderDetails) o;
        return Objects.equals(this.address, accountHolderDetails.address) &&
                Objects.equals(this.bankAccountDetails, accountHolderDetails.bankAccountDetails) &&
                Objects.equals(this.businessDetails, accountHolderDetails.businessDetails) &&
                Objects.equals(this.email, accountHolderDetails.email) &&
                Objects.equals(this.fullPhoneNumber, accountHolderDetails.fullPhoneNumber) &&
                Objects.equals(this.individualDetails, accountHolderDetails.individualDetails) &&
                Objects.equals(this.merchantCategoryCode, accountHolderDetails.merchantCategoryCode) &&
                Objects.equals(this.metadata, accountHolderDetails.metadata) &&
                Objects.equals(this.payoutMethods, accountHolderDetails.payoutMethods) &&
                Objects.equals(this.webAddress, accountHolderDetails.webAddress) &&
                Objects.equals(this.phoneNumber, accountHolderDetails.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, bankAccountDetails, businessDetails, email, fullPhoneNumber, individualDetails, merchantCategoryCode, metadata, payoutMethods, webAddress, phoneNumber);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountHolderDetails {\n");

        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    bankAccountDetails: ").append(toIndentedString(bankAccountDetails)).append("\n");
        sb.append("    businessDetails: ").append(toIndentedString(businessDetails)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    fullPhoneNumber: ").append(toIndentedString(fullPhoneNumber)).append("\n");
        sb.append("    individualDetails: ").append(toIndentedString(individualDetails)).append("\n");
        sb.append("    merchantCategoryCode: ").append(toIndentedString(merchantCategoryCode)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    payoutMethods: ").append(toIndentedString(payoutMethods)).append("\n");
        sb.append("    webAddress: ").append(toIndentedString(webAddress)).append("\n");
        sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
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
