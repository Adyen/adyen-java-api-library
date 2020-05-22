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

import com.adyen.constants.TextConstants;
import com.adyen.model.Address;
import com.adyen.model.Name;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * ShareholderContact
 */
public class ShareholderContact {
  @SerializedName("address")
  private Address address = null;

  @SerializedName("email")
  private String email = null;

  @SerializedName("fullPhoneNumber")
  private String fullPhoneNumber = null;

  @SerializedName("name")
  private Name name = null;

  @SerializedName("personalData")
  private PersonalData personalData = null;

  @SerializedName("phoneNumber")
  private PhoneNumber phoneNumber = null;

  @SerializedName("shareholderCode")
  private String shareholderCode = null;

  @SerializedName("shareholderReference")
  private String shareholderReference = null;

  @SerializedName("webAddress")
  private String webAddress = null;

  public ShareholderContact address(Address address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public ShareholderContact email(String email) {
    this.email = email;
    return this;
  }

   /**
   * The e-mail address of the contact.
   * @return email
  **/
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ShareholderContact fullPhoneNumber(String fullPhoneNumber) {
    this.fullPhoneNumber = fullPhoneNumber;
    return this;
  }

   /**
   * The phone number of the contact provided as a single string.  It will be handled as a landline phone. **Examples:** \&quot;0031 6 11 22 33 44\&quot;, \&quot;+316/1122-3344\&quot;, \&quot;(0031) 611223344\&quot;
   * @return fullPhoneNumber
  **/
  public String getFullPhoneNumber() {
    return fullPhoneNumber;
  }

  public void setFullPhoneNumber(String fullPhoneNumber) {
    this.fullPhoneNumber = fullPhoneNumber;
  }

  public ShareholderContact name(Name name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public ShareholderContact personalData(PersonalData personalData) {
    this.personalData = personalData;
    return this;
  }

   /**
   * Get personalData
   * @return personalData
  **/
  public PersonalData getPersonalData() {
    return personalData;
  }

  public void setPersonalData(PersonalData personalData) {
    this.personalData = personalData;
  }

  public ShareholderContact phoneNumber(PhoneNumber phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

   /**
   * Get phoneNumber
   * @return phoneNumber
  **/
  public PhoneNumber getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(PhoneNumber phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public ShareholderContact shareholderCode(String shareholderCode) {
    this.shareholderCode = shareholderCode;
    return this;
  }

   /**
   * The unique identifier (UUID) of the Shareholder. &gt;**If, during an Account Holder create or update request, this field is left blank (but other fields provided), a new Shareholder will be created with a procedurally-generated UUID.**  &gt;**If, during an Account Holder create request, a UUID is provided, the creation of the Shareholder will fail while the creation of the Account Holder will continue.**  &gt;**If, during an Account Holder update request, a UUID that is not correlated with an existing Shareholder is provided, the update of the Shareholder will fail.**  &gt;**If, during an Account Holder update request, a UUID that is correlated with an existing Shareholder is provided, the existing Shareholder will be updated.**
   * @return shareholderCode
  **/
  public String getShareholderCode() {
    return shareholderCode;
  }

  public void setShareholderCode(String shareholderCode) {
    this.shareholderCode = shareholderCode;
  }

  public ShareholderContact shareholderReference(String shareholderReference) {
    this.shareholderReference = shareholderReference;
    return this;
  }

   /**
   * Merchant reference to the Shareholder.
   * @return shareholderReference
  **/
  public String getShareholderReference() {
    return shareholderReference;
  }

  public void setShareholderReference(String shareholderReference) {
    this.shareholderReference = shareholderReference;
  }

  public ShareholderContact webAddress(String webAddress) {
    this.webAddress = webAddress;
    return this;
  }

   /**
   * The URL of the website of the contact.
   * @return webAddress
  **/
  public String getWebAddress() {
    return webAddress;
  }

  public void setWebAddress(String webAddress) {
    this.webAddress = webAddress;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (Objects.isNull(o) || getClass() != o.getClass()) {
      return false;
    }
    ShareholderContact shareholderContact = (ShareholderContact) o;
    return Objects.equals(this.address, shareholderContact.address) &&
        Objects.equals(this.email, shareholderContact.email) &&
        Objects.equals(this.fullPhoneNumber, shareholderContact.fullPhoneNumber) &&
        Objects.equals(this.name, shareholderContact.name) &&
        Objects.equals(this.personalData, shareholderContact.personalData) &&
        Objects.equals(this.phoneNumber, shareholderContact.phoneNumber) &&
        Objects.equals(this.shareholderCode, shareholderContact.shareholderCode) &&
        Objects.equals(this.shareholderReference, shareholderContact.shareholderReference) &&
        Objects.equals(this.webAddress, shareholderContact.webAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, email, fullPhoneNumber, name, personalData, phoneNumber, shareholderCode, shareholderReference, webAddress);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShareholderContact {").append(TextConstants.LINE_BREAK);

    sb.append("    address: ").append(toIndentedString(address)).append(TextConstants.LINE_BREAK);
    sb.append("    email: ").append(toIndentedString(email)).append(TextConstants.LINE_BREAK);
    sb.append("    fullPhoneNumber: ").append(toIndentedString(fullPhoneNumber)).append(TextConstants.LINE_BREAK);
    sb.append("    name: ").append(toIndentedString(name)).append(TextConstants.LINE_BREAK);
    sb.append("    personalData: ").append(toIndentedString(personalData)).append(TextConstants.LINE_BREAK);
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append(TextConstants.LINE_BREAK);
    sb.append("    shareholderCode: ").append(toIndentedString(shareholderCode)).append(TextConstants.LINE_BREAK);
    sb.append("    shareholderReference: ").append(toIndentedString(shareholderReference)).append(TextConstants.LINE_BREAK);
    sb.append("    webAddress: ").append(toIndentedString(webAddress)).append(TextConstants.LINE_BREAK);
    sb.append("}");
    return sb.toString();
  }
}
