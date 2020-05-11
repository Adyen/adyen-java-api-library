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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.binlookup;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * ThreeDSAvailabilityRequest
 */

public class ThreeDSAvailabilityRequest {

    @SerializedName("additionalData")
    private Object additionalData = null;

    @SerializedName("brands")
    private List<String> brands = new ArrayList<>();

    @SerializedName("cardNumber")
    private String cardNumber = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("recurringDetailReference")
    private String recurringDetailReference = null;

    @SerializedName("shopperReference")
    private String shopperReference = null;

    public ThreeDSAvailabilityRequest additionalData(Object additionalData) {
        this.additionalData = additionalData;
        return this;
    }


    /**
     * This field contains additional data, which may be required for a particular request.  The &#x60;additionalData&#x60; object consists of entries, each of which includes the key and value. For
     * more information on possible key-value pairs, refer to the [additionalData section](https://docs.adyen.com/api-reference/payments-api#paymentrequestadditionaldata).
     *
     * @return additionalData
     **/
    public Object getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Object additionalData) {
        this.additionalData = additionalData;
    }

    public ThreeDSAvailabilityRequest brands(List<String> brands) {
        this.brands = brands;
        return this;
    }

    public ThreeDSAvailabilityRequest addBrandsItem(String brandsItem) {
        this.brands.add(brandsItem);
        return this;
    }

    /**
     * List of brands.
     *
     * @return brands
     **/
    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    public ThreeDSAvailabilityRequest cardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }


    /**
     * Card number or BIN.
     *
     * @return cardNumber
     **/
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public ThreeDSAvailabilityRequest merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }


    /**
     * The merchant account identifier.
     *
     * @return merchantAccount
     **/
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public ThreeDSAvailabilityRequest recurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
        return this;
    }


    /**
     * A recurring detail reference corresponding to a card.
     *
     * @return recurringDetailReference
     **/
    public String getRecurringDetailReference() {
        return recurringDetailReference;
    }

    public void setRecurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
    }

    public ThreeDSAvailabilityRequest shopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
        return this;
    }


    /**
     * The shopper&#x27;s reference to uniquely identify this shopper (e.g. user ID or account ID).
     *
     * @return shopperReference
     **/
    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ThreeDSAvailabilityRequest threeDSAvailabilityRequest = (ThreeDSAvailabilityRequest) o;
        return Objects.equals(this.additionalData, threeDSAvailabilityRequest.additionalData)
                && Objects.equals(this.brands, threeDSAvailabilityRequest.brands)
                && Objects.equals(this.cardNumber,
                                  threeDSAvailabilityRequest.cardNumber)
                && Objects.equals(this.merchantAccount, threeDSAvailabilityRequest.merchantAccount)
                && Objects.equals(this.recurringDetailReference, threeDSAvailabilityRequest.recurringDetailReference)
                && Objects.equals(this.shopperReference, threeDSAvailabilityRequest.shopperReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalData, brands, cardNumber, merchantAccount, recurringDetailReference, shopperReference);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ThreeDSAvailabilityRequest {\n");

        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
        sb.append("    brands: ").append(toIndentedString(brands)).append("\n");
        sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    recurringDetailReference: ").append(toIndentedString(recurringDetailReference)).append("\n");
        sb.append("    shopperReference: ").append(toIndentedString(shopperReference)).append("\n");
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
