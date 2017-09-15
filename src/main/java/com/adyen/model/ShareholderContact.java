/**
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
package com.adyen.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * ShareholderContact
 */
public class ShareholderContact {
    @SerializedName("address")
    private Address address = null;

    @SerializedName("phoneNumber")
    private PhoneNumber phoneNumber = null;

    @SerializedName("webAddress")
    private String webAddress = null;

    @SerializedName("personalData")
    private PersonalData personalData = null;

    @SerializedName("name")
    private Name name = null;

    @SerializedName("fullPhoneNumber")
    private String fullPhoneNumber = null;

    @SerializedName("email")
    private String email = null;

    @SerializedName("shareholderCode")
    private String shareholderCode = null;

    public ShareholderContact address(Address address) {
        this.address = address;
        return this;
    }

    /**
     * address
     *
     * @return address
     **/
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ShareholderContact phoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * phone number
     *
     * @return phoneNumber
     **/
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ShareholderContact webAddress(String webAddress) {
        this.webAddress = webAddress;
        return this;
    }

    /**
     * URL
     *
     * @return webAddress
     **/
    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public ShareholderContact personalData(PersonalData personalData) {
        this.personalData = personalData;
        return this;
    }

    /**
     * personal data
     *
     * @return personalData
     **/
    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public ShareholderContact name(Name name) {
        this.name = name;
        return this;
    }

    /**
     * name
     *
     * @return name
     **/
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public ShareholderContact fullPhoneNumber(String fullPhoneNumber) {
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

    public ShareholderContact email(String email) {
        this.email = email;
        return this;
    }

    /**
     * email address
     *
     * @return email
     **/
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ShareholderContact shareholderCode(String shareholderCode) {
        this.shareholderCode = shareholderCode;
        return this;
    }

    /**
     * the shareholder code (generated on shareholder creation)
     *
     * @return shareholderCode
     **/
    public String getShareholderCode() {
        return shareholderCode;
    }

    public void setShareholderCode(String shareholderCode) {
        this.shareholderCode = shareholderCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShareholderContact shareholderContact = (ShareholderContact) o;
        return Objects.equals(this.address, shareholderContact.address)
                && Objects.equals(this.phoneNumber, shareholderContact.phoneNumber)
                && Objects.equals(this.webAddress,
                                  shareholderContact.webAddress)
                && Objects.equals(this.personalData, shareholderContact.personalData)
                && Objects.equals(this.name, shareholderContact.name)
                && Objects.equals(this.fullPhoneNumber, shareholderContact.fullPhoneNumber)
                && Objects.equals(this.email, shareholderContact.email)
                && Objects.equals(this.shareholderCode, shareholderContact.shareholderCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, phoneNumber, webAddress, personalData, name, fullPhoneNumber, email, shareholderCode);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ShareholderContact {\n");

        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
        sb.append("    webAddress: ").append(toIndentedString(webAddress)).append("\n");
        sb.append("    personalData: ").append(toIndentedString(personalData)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    fullPhoneNumber: ").append(toIndentedString(fullPhoneNumber)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    shareholderCode: ").append(toIndentedString(shareholderCode)).append("\n");
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

