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

import com.adyen.util.MaskUtil;
import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

public class StoredPaymentMethod {
    @SerializedName("brand")
    private String brand = null;

    @SerializedName("expiryMonth")
    private String expiryMonth = null;

    @SerializedName("expiryYear")
    private String expiryYear = null;

    @SerializedName("holderName")
    private String holderName = null;

    @SerializedName("iban")
    private String iban = null;

    @SerializedName("id")
    private String id = null;

    @SerializedName("lastFour")
    private String lastFour = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("networkTxReference")
    private String networkTxReference = null;

    @SerializedName("ownerName")
    private String ownerName = null;

    @SerializedName("shopperEmail")
    private String shopperEmail = null;

    @SerializedName("supportedShopperInteractions")
    private List<String> supportedShopperInteractions = null;

    @SerializedName("type")
    private String type = null;

    public StoredPaymentMethod brand(String brand) {
        this.brand = brand;
        return this;
    }

    /**
     * The brand of the card.
     * @return brand
     **/
    @Schema(description = "The brand of the card.")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public StoredPaymentMethod expiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
        return this;
    }

    /**
     * The month the card expires.
     * @return expiryMonth
     **/
    @Schema(description = "The month the card expires.")
    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public StoredPaymentMethod expiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
        return this;
    }

    /**
     * The last two digits of the year the card expires. For example, **22** for the year 2022.
     * @return expiryYear
     **/
    @Schema(description = "The last two digits of the year the card expires. For example, **22** for the year 2022.")
    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public StoredPaymentMethod holderName(String holderName) {
        this.holderName = holderName;
        return this;
    }

    /**
     * The unique payment method code.
     * @return holderName
     **/
    @Schema(description = "The unique payment method code.")
    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public StoredPaymentMethod iban(String iban) {
        this.iban = iban;
        return this;
    }

    /**
     * The IBAN of the bank account.
     * @return iban
     **/
    @Schema(description = "The IBAN of the bank account.")
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public StoredPaymentMethod id(String id) {
        this.id = id;
        return this;
    }

    /**
     * A unique identifier of this stored payment method.
     * @return id
     **/
    @Schema(description = "A unique identifier of this stored payment method.")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StoredPaymentMethod lastFour(String lastFour) {
        this.lastFour = lastFour;
        return this;
    }

    /**
     * The last four digits of the PAN.
     * @return lastFour
     **/
    @Schema(description = "The last four digits of the PAN.")
    public String getLastFour() {
        return lastFour;
    }

    public void setLastFour(String lastFour) {
        this.lastFour = lastFour;
    }

    public StoredPaymentMethod name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The display name of the stored payment method.
     * @return name
     **/
    @Schema(description = "The display name of the stored payment method.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StoredPaymentMethod networkTxReference(String networkTxReference) {
        this.networkTxReference = networkTxReference;
        return this;
    }

    /**
     * Returned in the response if you are not tokenizing with Adyen and are using the Merchant-initiated transactions (MIT) framework from Mastercard or Visa.  This contains either the Mastercard Trace ID or the Visa Transaction ID.
     * @return networkTxReference
     **/
    @Schema(description = "Returned in the response if you are not tokenizing with Adyen and are using the Merchant-initiated transactions (MIT) framework from Mastercard or Visa.  This contains either the Mastercard Trace ID or the Visa Transaction ID.")
    public String getNetworkTxReference() {
        return networkTxReference;
    }

    public void setNetworkTxReference(String networkTxReference) {
        this.networkTxReference = networkTxReference;
    }

    public StoredPaymentMethod ownerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    /**
     * The name of the bank account holder.
     * @return ownerName
     **/
    @Schema(description = "The name of the bank account holder.")
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public StoredPaymentMethod shopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
        return this;
    }

    /**
     * The shopper’s email address.
     * @return shopperEmail
     **/
    @Schema(description = "The shopper’s email address.")
    public String getShopperEmail() {
        return shopperEmail;
    }

    public void setShopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
    }

    public StoredPaymentMethod supportedShopperInteractions(List<String> supportedShopperInteractions) {
        this.supportedShopperInteractions = supportedShopperInteractions;
        return this;
    }

    public StoredPaymentMethod addSupportedShopperInteractionsItem(String supportedShopperInteractionsItem) {
        if (this.supportedShopperInteractions == null) {
            this.supportedShopperInteractions = new ArrayList<String>();
        }
        this.supportedShopperInteractions.add(supportedShopperInteractionsItem);
        return this;
    }

    /**
     * The supported shopper interactions for this stored payment method.
     * @return supportedShopperInteractions
     **/
    @Schema(description = "The supported shopper interactions for this stored payment method.")
    public List<String> getSupportedShopperInteractions() {
        return supportedShopperInteractions;
    }

    public void setSupportedShopperInteractions(List<String> supportedShopperInteractions) {
        this.supportedShopperInteractions = supportedShopperInteractions;
    }

    public StoredPaymentMethod type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The type of payment method.
     * @return type
     **/
    @Schema(description = "The type of payment method.")
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
        StoredPaymentMethod storedPaymentMethod = (StoredPaymentMethod) o;
        return Objects.equals(this.brand, storedPaymentMethod.brand) &&
                Objects.equals(this.expiryMonth, storedPaymentMethod.expiryMonth) &&
                Objects.equals(this.expiryYear, storedPaymentMethod.expiryYear) &&
                Objects.equals(this.holderName, storedPaymentMethod.holderName) &&
                Objects.equals(this.iban, storedPaymentMethod.iban) &&
                Objects.equals(this.id, storedPaymentMethod.id) &&
                Objects.equals(this.lastFour, storedPaymentMethod.lastFour) &&
                Objects.equals(this.name, storedPaymentMethod.name) &&
                Objects.equals(this.networkTxReference, storedPaymentMethod.networkTxReference) &&
                Objects.equals(this.ownerName, storedPaymentMethod.ownerName) &&
                Objects.equals(this.shopperEmail, storedPaymentMethod.shopperEmail) &&
                Objects.equals(this.supportedShopperInteractions, storedPaymentMethod.supportedShopperInteractions) &&
                Objects.equals(this.type, storedPaymentMethod.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, expiryMonth, expiryYear, holderName, iban, id, lastFour, name, networkTxReference, ownerName, shopperEmail, supportedShopperInteractions, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StoredPaymentMethod {\n");

        sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
        sb.append("    expiryMonth: ").append(toIndentedString(expiryMonth)).append("\n");
        sb.append("    expiryYear: ").append(toIndentedString(expiryYear)).append("\n");
        sb.append("    holderName: ").append(toIndentedString(holderName)).append("\n");
        sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    lastFour: ").append(toIndentedString(lastFour)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    networkTxReference: ").append(toIndentedString(networkTxReference)).append("\n");
        sb.append("    ownerName: ").append(toIndentedString(ownerName)).append("\n");
        sb.append("    shopperEmail: ").append(toIndentedString(shopperEmail)).append("\n");
        sb.append("    supportedShopperInteractions: ").append(toIndentedString(supportedShopperInteractions)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
