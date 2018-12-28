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

package com.adyen.model.checkout;

import java.util.Objects;
import com.adyen.model.Address;
import com.google.gson.annotations.SerializedName;

public class DefaultPaymentMethodDetails implements PaymentMethodDetails {
    @SerializedName("type")
    private String type;
    @SerializedName("number")
    private String number;
    @SerializedName("expiryMonth")
    private String expiryMonth;
    @SerializedName("expiryYear")
    private String expiryYear;
    @SerializedName("holderName")
    private String holderName;
    @SerializedName("cvc")
    private String cvc;
    @SerializedName("installmentConfigurationKey")
    private String installmentConfigurationKey;
    @SerializedName("personalDetails")
    private PersonalDetails personalDetails;
    @SerializedName("billingAddress")
    private Address billingAddress;
    @SerializedName("deliveryAddress")
    private Address deliveryAddress;
    @SerializedName("encryptedCardNumber")
    private String encryptedCardNumber;
    @SerializedName("encryptedExpiryMonth")
    private String encryptedExpiryMonth;
    @SerializedName("encryptedExpiryYear")
    private String encryptedExpiryYear;
    @SerializedName("encryptedSecurityCode")
    private String encryptedSecurityCode;
    @SerializedName("recurringDetailReference")
    private String recurringDetailReference;
    @SerializedName("storeDetails")
    private Boolean storeDetails;
    @SerializedName("idealIssuer")
    private String idealIssuer;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    public DefaultPaymentMethodDetails type(String type) {
        this.type = type;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public DefaultPaymentMethodDetails number(String number) {
        this.number = number;
        return this;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public DefaultPaymentMethodDetails expiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
        return this;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public DefaultPaymentMethodDetails expiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
        return this;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public DefaultPaymentMethodDetails holderName(String holderName) {
        this.holderName = holderName;
        return this;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public DefaultPaymentMethodDetails cvc(String cvc) {
        this.cvc = cvc;
        return this;
    }

    public String getInstallmentConfigurationKey() {
        return installmentConfigurationKey;
    }

    public void setInstallmentConfigurationKey(String installmentConfigurationKey) {
        this.installmentConfigurationKey = installmentConfigurationKey;
    }

    public DefaultPaymentMethodDetails installmentConfigurationKey(String installmentConfigurationKey) {
        this.installmentConfigurationKey = installmentConfigurationKey;
        return this;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public DefaultPaymentMethodDetails personalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
        return this;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public DefaultPaymentMethodDetails billingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public DefaultPaymentMethodDetails deliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }

    public String getEncryptedCardNumber() {
        return encryptedCardNumber;
    }

    public void setEncryptedCardNumber(String encryptedCardNumber) {
        this.encryptedCardNumber = encryptedCardNumber;
    }

    public DefaultPaymentMethodDetails encryptedCardNumber(String encryptedCardNumber) {
        this.encryptedCardNumber = encryptedCardNumber;
        return this;
    }

    public String getEncryptedExpiryMonth() {
        return encryptedExpiryMonth;
    }

    public void setEncryptedExpiryMonth(String encryptedExpiryMonth) {
        this.encryptedExpiryMonth = encryptedExpiryMonth;
    }

    public DefaultPaymentMethodDetails encryptedExpiryMonth(String encryptedExpiryMonth) {
        this.encryptedExpiryMonth = encryptedExpiryMonth;
        return this;
    }

    public String getEncryptedExpiryYear() {
        return encryptedExpiryYear;
    }

    public void setEncryptedExpiryYear(String encryptedExpiryYear) {
        this.encryptedExpiryYear = encryptedExpiryYear;
    }

    public DefaultPaymentMethodDetails encryptedExpiryYear(String encryptedExpiryYear) {
        this.encryptedExpiryYear = encryptedExpiryYear;
        return this;
    }

    public String getEncryptedSecurityCode() {
        return encryptedSecurityCode;
    }

    public void setEncryptedSecurityCode(String encryptedSecurityCode) {
        this.encryptedSecurityCode = encryptedSecurityCode;
    }

    public DefaultPaymentMethodDetails encryptedSecurityCode(String encryptedSecurityCode) {
        this.encryptedSecurityCode = encryptedSecurityCode;
        return this;
    }

    public String getRecurringDetailReference() {
        return recurringDetailReference;
    }

    public void setRecurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
    }

    public DefaultPaymentMethodDetails recurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
        return this;
    }

    public Boolean getStoreDetails() {
        return storeDetails;
    }

    public void setStoreDetails(Boolean storeDetails) {
        this.storeDetails = storeDetails;
    }

    public DefaultPaymentMethodDetails storeDetails(Boolean storeDetails) {
        this.storeDetails = storeDetails;
        return this;
    }

    public String getIdealIssuer() {
        return idealIssuer;
    }

    public void setIdealIssuer(String idealIssuer) {
        this.idealIssuer = idealIssuer;
    }

    public DefaultPaymentMethodDetails idealIssuer(String idealIssuer) {
        this.idealIssuer = idealIssuer;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DefaultPaymentMethodDetails that = (DefaultPaymentMethodDetails) o;
        return Objects.equals(type, that.type)
                && Objects.equals(number, that.number)
                && Objects.equals(expiryMonth, that.expiryMonth)
                && Objects.equals(expiryYear, that.expiryYear)
                && Objects.equals(holderName,
                                  that.holderName)
                && Objects.equals(cvc, that.cvc)
                && Objects.equals(installmentConfigurationKey, that.installmentConfigurationKey)
                && Objects.equals(personalDetails,
                                  that.personalDetails)
                && Objects.equals(billingAddress, that.billingAddress)
                && Objects.equals(deliveryAddress, that.deliveryAddress)
                && Objects.equals(encryptedCardNumber, that.encryptedCardNumber)
                && Objects.equals(encryptedExpiryMonth, that.encryptedExpiryMonth)
                && Objects.equals(encryptedExpiryYear, that.encryptedExpiryYear)
                && Objects.equals(encryptedSecurityCode, that.encryptedSecurityCode)
                && Objects.equals(recurringDetailReference, that.recurringDetailReference)
                && Objects.equals(storeDetails, that.storeDetails)
                && Objects.equals(idealIssuer, that.idealIssuer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type,
                            number,
                            expiryMonth,
                            expiryYear,
                            holderName,
                            cvc,
                            installmentConfigurationKey,
                            personalDetails,
                            billingAddress,
                            deliveryAddress,
                            encryptedCardNumber,
                            encryptedExpiryMonth,
                            encryptedExpiryYear,
                            encryptedSecurityCode,
                            recurringDetailReference,
                            storeDetails,
                            idealIssuer);
    }

    @Override
    public String toString() {
        return "DefaultPaymentMethodDetails{"
                + "type='"
                + type
                + '\''
                + ", expiryMonth='"
                + expiryMonth
                + '\''
                + ", expiryYear='"
                + expiryYear
                + '\''
                + ", holderName='"
                + holderName
                + '\''
                + ", installmentConfigurationKey='"
                + installmentConfigurationKey
                + '\''
                + ", personalDetails="
                + personalDetails
                + ", billingAddress="
                + billingAddress
                + ", deliveryAddress="
                + deliveryAddress
                + ", encryptedExpiryMonth='"
                + encryptedExpiryMonth
                + '\''
                + ", encryptedExpiryYear='"
                + encryptedExpiryYear
                + '\''
                + ", recurringDetailReference='"
                + recurringDetailReference
                + '\''
                + ", storeDetails="
                + storeDetails
                + ", idealIssuer="
                + idealIssuer
                + '}';
    }
}



