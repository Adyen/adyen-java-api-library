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
package com.adyen.model.checkout;

import com.adyen.util.MaskUtil;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;


public class StoredPaymentMethodResource {

    @SerializedName("brand")
    private String brand = null;

    @SerializedName("expiryMonth")
    private String expiryMonth = null;

    @SerializedName("expiryYear")
    private String expiryYear = null;

    @SerializedName("id")
    private String id = null;

    @SerializedName("lastFour")
    private String lastFour = null;

    @SerializedName("shopperReference")
    private String shopperReference = null;

    @SerializedName("storingMethodType")
    private String storingMethodType = null;

    @SerializedName("supportedShopperInteractions")
    private List<String> supportedShopperInteractions = null;

    @SerializedName("type")
    private String type = null;

    public StoredPaymentMethodResource brand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public StoredPaymentMethodResource expiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
        return this;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public StoredPaymentMethodResource expiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
        return this;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public StoredPaymentMethodResource id(String id) {
        this.id = id;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StoredPaymentMethodResource lastFour(String lastFour) {
        this.lastFour = lastFour;
        return this;
    }

    public String getLastFour() {
        return lastFour;
    }

    public void setLastFour(String lastFour) {
        this.lastFour = lastFour;
    }

    public StoredPaymentMethodResource shopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
        return this;
    }

    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    public StoredPaymentMethodResource storingMethodType(String storingMethodType) {
        this.storingMethodType = storingMethodType;
        return this;
    }

    public String getStoringMethodType() {
        return storingMethodType;
    }

    public void setStoringMethodType(String storingMethodType) {
        this.storingMethodType = storingMethodType;
    }

    public StoredPaymentMethodResource supportedShopperInteractions(List<String> supportedShopperInteractions) {
        this.supportedShopperInteractions = supportedShopperInteractions;
        return this;
    }

    public StoredPaymentMethodResource addSupportedShopperInteractionsItem(String supportedShopperInteractionsItem) {
        if (this.supportedShopperInteractions == null) {
            this.supportedShopperInteractions = new ArrayList<>();
        }
        this.supportedShopperInteractions.add(supportedShopperInteractionsItem);
        return this;
    }

    public List<String> getSupportedShopperInteractions() {
        return supportedShopperInteractions;
    }

    public void setSupportedShopperInteractions(List<String> supportedShopperInteractions) {
        this.supportedShopperInteractions = supportedShopperInteractions;
    }

    public StoredPaymentMethodResource type(String type) {
        this.type = type;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StoredPaymentMethodResource storedPaymentMethodResource = (StoredPaymentMethodResource) o;
        return Objects.equals(this.brand, storedPaymentMethodResource.brand) &&
                Objects.equals(this.expiryMonth, storedPaymentMethodResource.expiryMonth) &&
                Objects.equals(this.expiryYear, storedPaymentMethodResource.expiryYear) &&
                Objects.equals(this.id, storedPaymentMethodResource.id) &&
                Objects.equals(this.lastFour, storedPaymentMethodResource.lastFour) &&
                Objects.equals(this.shopperReference, storedPaymentMethodResource.shopperReference) &&
                Objects.equals(this.storingMethodType, storedPaymentMethodResource.storingMethodType) &&
                Objects.equals(this.supportedShopperInteractions, storedPaymentMethodResource.supportedShopperInteractions) &&
                Objects.equals(this.type, storedPaymentMethodResource.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, expiryMonth, expiryYear, id, lastFour, shopperReference, storingMethodType, supportedShopperInteractions, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StoredPaymentMethodResource {\n");

        sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
        sb.append("    expiryMonth: ").append(MaskUtil.mask(expiryMonth)).append("\n");
        sb.append("    expiryYear: ").append(MaskUtil.mask(expiryYear)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    lastFour: ").append(toIndentedString(lastFour)).append("\n");
        sb.append("    shopperReference: ").append(toIndentedString(shopperReference)).append("\n");
        sb.append("    storingMethodType: ").append(toIndentedString(storingMethodType)).append("\n");
        sb.append("    supportedShopperInteractions: ").append(toIndentedString(supportedShopperInteractions)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
