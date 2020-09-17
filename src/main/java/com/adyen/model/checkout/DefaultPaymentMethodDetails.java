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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

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
    @SerializedName("encryptedCardNumber")
    private String encryptedCardNumber;
    @SerializedName("encryptedExpiryMonth")
    private String encryptedExpiryMonth;
    @SerializedName("encryptedExpiryYear")
    private String encryptedExpiryYear;
    @SerializedName("encryptedSecurityCode")
    private String encryptedSecurityCode;
    /**
     * @deprecated This field is deprecated. Use {@link DefaultPaymentMethodDetails#storedPaymentMethodId } instead.
     */
    @Deprecated
    @SerializedName("recurringDetailReference")
    private String recurringDetailReference;
    @SerializedName("storedPaymentMethodId")
    private String storedPaymentMethodId;
    @SerializedName("storeDetails")
    private Boolean storeDetails;
    /**
     * @deprecated This field is deprecated and new field added {@link DefaultPaymentMethodDetails#issuer } which is  more generic for other payment methods.
     */
    @Deprecated
    @SerializedName("idealIssuer")
    private String idealIssuer;
    @SerializedName("issuer")
    private String issuer;
    @SerializedName("sepa.ownerName")
    @JsonProperty("sepa.ownerName")
    private String sepaOwnerName;
    @SerializedName("sepa.ibanNumber")
    @JsonProperty("sepa.ibanNumber")
    private String sepaIbanNumber;
    @SerializedName("applepay.token")
    @JsonProperty("applepay.token")
    private String applepayToken;
    @SerializedName("paywithgoogle.token")
    @JsonProperty("paywithgoogle.token")
    private String googlepayToken;
    @SerializedName("separateDeliveryAddress")
    private Boolean separateDeliveryAddress;
    @SerializedName("securityCode")
    private String securityCode;
    @SerializedName("brand")
    private String brand;
    @SerializedName("networkPaymentReference")
    private String networkPaymentReference;

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

    /**
     * @deprecated This field is deprecated. Use {@link DefaultPaymentMethodDetails#storedPaymentMethodId } instead.
     */
    @Deprecated
    public String getRecurringDetailReference() {
        return recurringDetailReference;
    }

    /**
     * @deprecated This field is deprecated. Use {@link DefaultPaymentMethodDetails#storedPaymentMethodId } instead.
     */
    @Deprecated
    public void setRecurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
    }

    /**
     * @deprecated This field is deprecated. Use {@link DefaultPaymentMethodDetails#storedPaymentMethodId } instead.
     */
    @Deprecated
    public DefaultPaymentMethodDetails recurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
        return this;
    }

    public String getStoredPaymentMethodId() {
        return storedPaymentMethodId;
    }

    public void setStoredPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
    }

    public DefaultPaymentMethodDetails storedPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
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

    /**
     * @deprecated This field is deprecated and new field added {@link DefaultPaymentMethodDetails#issuer } which is  more generic for other payment methods.
     */
    @Deprecated
    public String getIdealIssuer() {
        return idealIssuer;
    }

    /**
     * @deprecated This field is deprecated and new field added {@link DefaultPaymentMethodDetails#issuer } which is  more generic for other payment methods.
     */
    @Deprecated
    public void setIdealIssuer(String idealIssuer) {
        this.idealIssuer = idealIssuer;
    }

    /**
     * @deprecated This field is deprecated and new field added {@link DefaultPaymentMethodDetails#issuer } which is  more generic for other payment methods.
     */
    @Deprecated
    public DefaultPaymentMethodDetails idealIssuer(String idealIssuer) {
        this.idealIssuer = idealIssuer;
        return this;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public DefaultPaymentMethodDetails issuer(String issuer) {
        this.issuer = issuer;
        return this;
    }

    public String getSepaOwnerName() {
        return sepaOwnerName;
    }

    public void setSepaOwnerName(String sepaOwnerName) {
        this.sepaOwnerName = sepaOwnerName;
    }

    public String getSepaIbanNumber() {
        return sepaIbanNumber;
    }

    public void setSepaIbanNumber(String sepaIbanNumber) {
        this.sepaIbanNumber = sepaIbanNumber;
    }

    public String getApplepayToken() {
        return applepayToken;
    }

    public void setApplepayToken(String applepayToken) {
        this.applepayToken = applepayToken;
    }

    public String getGooglepayToken() {
        return googlepayToken;
    }

    public void setGooglepayToken(String googlepayToken) {
        this.googlepayToken = googlepayToken;
    }

    public Boolean getSeparateDeliveryAddress() {
        return separateDeliveryAddress;
    }

    public void setSeparateDeliveryAddress(Boolean separateDeliveryAddress) {
        this.separateDeliveryAddress = separateDeliveryAddress;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public DefaultPaymentMethodDetails securityCode(String securityCode) {
        this.securityCode = securityCode;
        return this;
    }

    public DefaultPaymentMethodDetails brand(String brand) {
        this.brand = brand;
        return this;
    }

    /**
     * Get brand
     *
     * @return brand
     **/
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public DefaultPaymentMethodDetails networkPaymentReference(String networkPaymentReference) {
        this.networkPaymentReference = networkPaymentReference;
        return this;
    }

    /**
     * Get networkPaymentReference
     *
     * @return networkPaymentReference
     **/
    public String getNetworkPaymentReference() {
        return networkPaymentReference;
    }

    public void setNetworkPaymentReference(String networkPaymentReference) {
        this.networkPaymentReference = networkPaymentReference;
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
                && Objects.equals(holderName, that.holderName)
                && Objects.equals(cvc, that.cvc)
                && Objects.equals(installmentConfigurationKey, that.installmentConfigurationKey)
                && Objects.equals(personalDetails, that.personalDetails)
                && Objects.equals(encryptedCardNumber, that.encryptedCardNumber)
                && Objects.equals(encryptedExpiryMonth, that.encryptedExpiryMonth)
                && Objects.equals(encryptedExpiryYear, that.encryptedExpiryYear)
                && Objects.equals(encryptedSecurityCode, that.encryptedSecurityCode)
                && Objects.equals(recurringDetailReference, that.recurringDetailReference)
                && Objects.equals(storedPaymentMethodId, that.storedPaymentMethodId)
                && Objects.equals(storeDetails, that.storeDetails)
                && Objects.equals(idealIssuer, that.idealIssuer)
                && Objects.equals(issuer, that.issuer)
                && Objects.equals(sepaIbanNumber, that.sepaIbanNumber)
                && Objects.equals(sepaOwnerName, that.sepaOwnerName)
                && Objects.equals(applepayToken, that.applepayToken)
                && Objects.equals(googlepayToken, that.googlepayToken)
                && Objects.equals(separateDeliveryAddress, that.separateDeliveryAddress)
                && Objects.equals(brand, that.brand)
                && Objects.equals(networkPaymentReference, that.networkPaymentReference)
                && Objects.equals(securityCode, that.securityCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, number, expiryMonth, expiryYear, holderName, cvc, installmentConfigurationKey,
                personalDetails, encryptedCardNumber, encryptedExpiryMonth, encryptedExpiryYear, encryptedSecurityCode,
                recurringDetailReference, storedPaymentMethodId, storeDetails, idealIssuer, issuer, sepaOwnerName,
                sepaIbanNumber, applepayToken, googlepayToken, separateDeliveryAddress, brand, networkPaymentReference, securityCode);
    }

    @Override
    public String toString() {
        return "DefaultPaymentMethodDetails{" +
                "type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", expiryMonth='" + expiryMonth + '\'' +
                ", expiryYear='" + expiryYear + '\'' +
                ", holderName='" + holderName + '\'' +
                ", cvc='" + cvc + '\'' +
                ", installmentConfigurationKey='" + installmentConfigurationKey + '\'' +
                ", personalDetails=" + personalDetails +
                ", encryptedCardNumber='" + encryptedCardNumber + '\'' +
                ", encryptedExpiryMonth='" + encryptedExpiryMonth + '\'' +
                ", encryptedExpiryYear='" + encryptedExpiryYear + '\'' +
                ", encryptedSecurityCode='" + encryptedSecurityCode + '\'' +
                ", recurringDetailReference='" + recurringDetailReference + '\'' +
                ", storedPaymentMethodId='" + storedPaymentMethodId + '\'' +
                ", storeDetails=" + storeDetails +
                ", idealIssuer='" + idealIssuer + '\'' +
                ", issuer='" + issuer + '\'' +
                ", sepaOwnerName='" + sepaOwnerName + '\'' +
                ", sepaIbanNumber='" + sepaIbanNumber + '\'' +
                ", applepayToken='" + applepayToken + '\'' +
                ", googlepayToken='" + googlepayToken + '\'' +
                ", separateDeliveryAddress='" + separateDeliveryAddress + '\'' +
                ", securityCode='" + securityCode + '\'' +
                ", brand='" + brand + '\'' +
                ", networkPaymentReference='" + networkPaymentReference + '\'' +
                '}';
    }
}



