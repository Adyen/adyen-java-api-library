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
package com.adyen.model.marketpay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.adyen.model.Address;
import com.google.gson.annotations.SerializedName;

/**
 * AccountHolderDetails
 */
public class AccountHolderDetails {
    @SerializedName("metadata")
    private Map<String, String> metadata = new HashMap<String, String>();

    @SerializedName("address")
    private Address address = null;

    @SerializedName("phoneNumber")
    private PhoneNumber phoneNumber = null;

    @SerializedName("bankAccountDetails")
    private List<BankAccountDetailContainer> bankAccountDetailContainers = null;

    private transient List<BankAccountDetail> bankAccountDetails = null;

    @SerializedName("individualDetails")
    private IndividualDetails individualDetails = null;

    @SerializedName("webAddress")
    private String webAddress = null;

    @SerializedName("merchantCategoryCode")
    private String merchantCategoryCode = null;

    @SerializedName("fullPhoneNumber")
    private String fullPhoneNumber = null;

    @SerializedName("businessDetails")
    private BusinessDetails businessDetails = null;

    @SerializedName("email")
    private String email = null;

    public AccountHolderDetails metadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }

    public AccountHolderDetails putMetadataItem(String key, String metadataItem) {
        this.metadata.put(key, metadataItem);
        return this;
    }

    /**
     * a map of key/value pairs of metadata sent by merchant
     *
     * @return metadata
     **/
    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public AccountHolderDetails address(Address address) {
        this.address = address;
        return this;
    }

    /**
     * account holder address
     *
     * @return address
     **/
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public AccountHolderDetails phoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * account holder phone number
     *
     * @return phoneNumber
     **/
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Populate the virtual bankAccountDetails to bypass the bankAccountDetailsContainer list
     *
     * @return bank account details
     */
    public List<BankAccountDetail> getBankAccountDetails() {
        if (bankAccountDetails == null) {
            bankAccountDetails = new ArrayList<BankAccountDetail>();

            if (bankAccountDetailContainers != null && ! bankAccountDetailContainers.isEmpty()) {
                for (BankAccountDetailContainer bankAccountDetailContainer : bankAccountDetailContainers) {
                    bankAccountDetails.add(bankAccountDetailContainer.getBankAccountDetail());
                }
            }
        }
        return bankAccountDetails;
    }

    /**
     * Creating a new bankAccountDetails list
     * @param bankAccountDetails  bank account details
     */
    public void setBankAccountDetails(List<BankAccountDetail> bankAccountDetails) {
        this.bankAccountDetails = bankAccountDetails;

        // set as well the container list this will be send in the API request
        this.bankAccountDetailContainers = new ArrayList<BankAccountDetailContainer>();
        for (BankAccountDetail bankAccountDetail : bankAccountDetails) {
            BankAccountDetailContainer bankAccountDetailContainer = new BankAccountDetailContainer(bankAccountDetail);
            this.bankAccountDetailContainers.add(bankAccountDetailContainer);
        }
    }

    /**
     * Add bankAccountDetail to the bankAccountDetailContainers and bankAccountDetails list
     *
     * @param bankAccountDetail BankAccountDetail
     * @return account holder details
     */
    public AccountHolderDetails addBankAccountDetail(BankAccountDetail bankAccountDetail) {
        BankAccountDetailContainer bankAccountDetailContainer = new BankAccountDetailContainer(bankAccountDetail);

        if (bankAccountDetailContainers == null) {
            bankAccountDetailContainers = new ArrayList<BankAccountDetailContainer>();
        }
        this.bankAccountDetailContainers.add(bankAccountDetailContainer);

        if (bankAccountDetails == null) {
            bankAccountDetails = new ArrayList<BankAccountDetail>();
        }
        this.bankAccountDetails.add(bankAccountDetail);

        return this;
    }

    public AccountHolderDetails individualDetails(IndividualDetails individualDetails) {
        this.individualDetails = individualDetails;
        return this;
    }

    /**
     * properties specific to Individual legal entities. Populated only if the account holder represents an Individual legal entity
     *
     * @return individualDetails
     **/
    public IndividualDetails getIndividualDetails() {
        return individualDetails;
    }

    public void setIndividualDetails(IndividualDetails individualDetails) {
        this.individualDetails = individualDetails;
    }

    public AccountHolderDetails webAddress(String webAddress) {
        this.webAddress = webAddress;
        return this;
    }

    /**
     * account holder URL
     *
     * @return webAddress
     **/
    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public AccountHolderDetails merchantCategoryCode(String merchantCategoryCode) {
        this.merchantCategoryCode = merchantCategoryCode;
        return this;
    }

    /**
     * merchant category code
     *
     * @return merchantCategoryCode
     **/
    public String getMerchantCategoryCode() {
        return merchantCategoryCode;
    }

    public void setMerchantCategoryCode(String merchantCategoryCode) {
        this.merchantCategoryCode = merchantCategoryCode;
    }

    public AccountHolderDetails fullPhoneNumber(String fullPhoneNumber) {
        this.fullPhoneNumber = fullPhoneNumber;
        return this;
    }

    /**
     * Get fullPhoneNumber
     *
     * @return fullPhoneNumber
     **/
    public String getFullPhoneNumber() {
        return fullPhoneNumber;
    }

    public void setFullPhoneNumber(String fullPhoneNumber) {
        this.fullPhoneNumber = fullPhoneNumber;
    }

    public AccountHolderDetails businessDetails(BusinessDetails businessDetails) {
        this.businessDetails = businessDetails;
        return this;
    }

    /**
     * properties specific to Business legal entities. Populated only if the account holder represents a Business legal entity
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
     * account holder email address
     *
     * @return email
     **/
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return Objects.equals(this.metadata, accountHolderDetails.metadata)
                && Objects.equals(this.address, accountHolderDetails.address)
                && Objects.equals(this.phoneNumber,
                                  accountHolderDetails.phoneNumber)
                && Objects.equals(this.bankAccountDetailContainers, accountHolderDetails.bankAccountDetailContainers)
                && Objects.equals(this.individualDetails, accountHolderDetails.individualDetails)
                && Objects.equals(this.webAddress, accountHolderDetails.webAddress)
                && Objects.equals(this.merchantCategoryCode, accountHolderDetails.merchantCategoryCode)
                && Objects.equals(this.fullPhoneNumber, accountHolderDetails.fullPhoneNumber)
                && Objects.equals(this.businessDetails, accountHolderDetails.businessDetails)
                && Objects.equals(this.email, accountHolderDetails.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadata, address, phoneNumber, bankAccountDetailContainers, individualDetails, webAddress, merchantCategoryCode, fullPhoneNumber, businessDetails, email);
    }


    @Override
    public String toString() {
        // Populate the bankAccountDetails list to provide back in the toString() method
        this.getBankAccountDetails();

        StringBuilder sb = new StringBuilder();
        sb.append("class AccountHolderDetails {\n");

        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
        sb.append("    bankAccountDetails: ").append(toIndentedString(bankAccountDetails)).append("\n");
        sb.append("    individualDetails: ").append(toIndentedString(individualDetails)).append("\n");
        sb.append("    webAddress: ").append(toIndentedString(webAddress)).append("\n");
        sb.append("    merchantCategoryCode: ").append(toIndentedString(merchantCategoryCode)).append("\n");
        sb.append("    fullPhoneNumber: ").append(toIndentedString(fullPhoneNumber)).append("\n");
        sb.append("    businessDetails: ").append(toIndentedString(businessDetails)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

