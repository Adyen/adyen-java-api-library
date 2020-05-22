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

package com.adyen.model.checkout;

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class StoredPaymentMethod {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("type")
    private String type;

    @SerializedName("brand")
    private String brand;

    @SerializedName("lastFour")
    private String lastFour;

    @SerializedName("expiryMonth")
    private String expiryMonth;

    @SerializedName("expiryYear")
    private String expiryYear;

    @SerializedName("holderName")
    private String holderName;

    @SerializedName("supportedShopperInteractions")
    private List<String> supportedShopperInteractions;

    //PayPal specific fields
    @SerializedName("shopperEmail")
    private String shopperEmail;

    /**
     * A unique identifier of this stored payment method.
     *
     * @return id
     **/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StoredPaymentMethod id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The display name of the stored payment method.
     *
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StoredPaymentMethod name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The type of payment method.
     *
     * @return type
     **/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public StoredPaymentMethod type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The brand of the card.
     *
     * @return brand
     **/
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public StoredPaymentMethod brand(String brand) {
        this.brand = brand;
        return this;
    }

    /**
     * The last four digits of the PAN.
     *
     * @return lastFour
     **/
    public String getLastFour() {
        return lastFour;
    }

    public void setLastFour(String lastFour) {
        this.lastFour = lastFour;
    }

    public StoredPaymentMethod lastFour(String lastFour) {
        this.lastFour = lastFour;
        return this;
    }

    /**
     * The month the card expires.
     *
     * @return expiryMonth
     **/
    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public StoredPaymentMethod expiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
        return this;
    }

    /**
     * The year the card expires.
     *
     * @return expiryYear
     **/
    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public StoredPaymentMethod expiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
        return this;
    }

    /**
     * The unique payment method code.
     *
     * @return holderName
     **/
    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public StoredPaymentMethod holderName(String holderName) {
        this.holderName = holderName;
        return this;
    }

    /**
     * The supported shopper interactions for this stored payment method.
     *
     * @return supportedShopperInteractions
     **/
    public List<String> getSupportedShopperInteractions() {
        return supportedShopperInteractions;
    }

    public void setSupportedShopperInteractions(List<String> supportedShopperInteractions) {
        this.supportedShopperInteractions = supportedShopperInteractions;
    }

    public StoredPaymentMethod supportedShopperInteractions(List<String> supportedShopperInteractions) {
        this.supportedShopperInteractions = supportedShopperInteractions;
        return this;
    }

    /**
     * The shopper’s email address.
     *
     * @return shopperEmail
     **/
    public String getShopperEmail() {
        return shopperEmail;
    }

    public void setShopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
    }

    public StoredPaymentMethod shopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        StoredPaymentMethod that = (StoredPaymentMethod) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(lastFour, that.lastFour) &&
                Objects.equals(expiryMonth, that.expiryMonth) &&
                Objects.equals(expiryYear, that.expiryYear) &&
                Objects.equals(holderName, that.holderName) &&
                Objects.equals(supportedShopperInteractions, that.supportedShopperInteractions) &&
                Objects.equals(shopperEmail, that.shopperEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, brand, lastFour, expiryMonth, expiryYear, holderName, supportedShopperInteractions, shopperEmail);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StoredPaymentMethod {").append(TextConstants.LINE_BREAK);

        sb.append("    id: ").append(Util.toIndentedString(id)).append(TextConstants.LINE_BREAK);
        sb.append("    name: ").append(Util.toIndentedString(name)).append(TextConstants.LINE_BREAK);
        sb.append("    type: ").append(Util.toIndentedString(type)).append(TextConstants.LINE_BREAK);
        sb.append("    brand: ").append(Util.toIndentedString(brand)).append(TextConstants.LINE_BREAK);
        sb.append("    lastFour: ").append(Util.toIndentedString(lastFour)).append(TextConstants.LINE_BREAK);
        sb.append("    expiryMonth: ").append(Util.toIndentedString(expiryMonth)).append(TextConstants.LINE_BREAK);
        sb.append("    expiryYear: ").append(Util.toIndentedString(expiryYear)).append(TextConstants.LINE_BREAK);
        sb.append("    holderName: ").append(Util.toIndentedString(holderName)).append(TextConstants.LINE_BREAK);
        sb.append("    supportedShopperInteractions: ").append(Util.toIndentedString(supportedShopperInteractions)).append(TextConstants.LINE_BREAK);
        sb.append("    shopperEmail: ").append(Util.toIndentedString(shopperEmail)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }

}
