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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.management;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

public class Merchant {
    @SerializedName("_links")
    @JsonProperty("_links")
    private Links links = null;

    @SerializedName("captureDelay")
    private String captureDelay = null;

    @SerializedName("defaultShopperInteraction")
    private String defaultShopperInteraction = null;

    @SerializedName("id")
    private String id = null;

    @SerializedName("merchantCity")
    private String merchantCity = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("primarySettlementCurrency")
    private String primarySettlementCurrency = null;

    @SerializedName("shopWebAddress")
    private String shopWebAddress = null;

    @SerializedName("status")
    private String status = null;

    public Merchant links(Links links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     * @return links
     **/
    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Merchant captureDelay(String captureDelay) {
        this.captureDelay = captureDelay;
        return this;
    }

    /**
     * The capture delay option of the Merchant.
     * @return captureDelay
     **/
    public String getCaptureDelay() {
        return captureDelay;
    }

    public void setCaptureDelay(String captureDelay) {
        this.captureDelay = captureDelay;
    }

    public Merchant defaultShopperInteraction(String defaultShopperInteraction) {
        this.defaultShopperInteraction = defaultShopperInteraction;
        return this;
    }

    /**
     * The default shopper interaction of the Merchant.
     * @return defaultShopperInteraction
     **/
    public String getDefaultShopperInteraction() {
        return defaultShopperInteraction;
    }

    public void setDefaultShopperInteraction(String defaultShopperInteraction) {
        this.defaultShopperInteraction = defaultShopperInteraction;
    }

    public Merchant id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The id of the Merchant.
     * @return id
     **/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Merchant merchantCity(String merchantCity) {
        this.merchantCity = merchantCity;
        return this;
    }

    /**
     * City merchant operates from.
     * @return merchantCity
     **/
    public String getMerchantCity() {
        return merchantCity;
    }

    public void setMerchantCity(String merchantCity) {
        this.merchantCity = merchantCity;
    }

    public Merchant name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the Merchant.
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Merchant primarySettlementCurrency(String primarySettlementCurrency) {
        this.primarySettlementCurrency = primarySettlementCurrency;
        return this;
    }

    /**
     * Primary currency to settle payments.
     * @return primarySettlementCurrency
     **/
    public String getPrimarySettlementCurrency() {
        return primarySettlementCurrency;
    }

    public void setPrimarySettlementCurrency(String primarySettlementCurrency) {
        this.primarySettlementCurrency = primarySettlementCurrency;
    }

    public Merchant shopWebAddress(String shopWebAddress) {
        this.shopWebAddress = shopWebAddress;
        return this;
    }

    /**
     * URL pointing to online shop.
     * @return shopWebAddress
     **/
    public String getShopWebAddress() {
        return shopWebAddress;
    }

    public void setShopWebAddress(String shopWebAddress) {
        this.shopWebAddress = shopWebAddress;
    }

    public Merchant status(String status) {
        this.status = status;
        return this;
    }

    /**
     * The status of the Merchant account.
     * @return status
     **/
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Merchant merchant = (Merchant) o;
        return Objects.equals(this.links, merchant.links) &&
                Objects.equals(this.captureDelay, merchant.captureDelay) &&
                Objects.equals(this.defaultShopperInteraction, merchant.defaultShopperInteraction) &&
                Objects.equals(this.id, merchant.id) &&
                Objects.equals(this.merchantCity, merchant.merchantCity) &&
                Objects.equals(this.name, merchant.name) &&
                Objects.equals(this.primarySettlementCurrency, merchant.primarySettlementCurrency) &&
                Objects.equals(this.shopWebAddress, merchant.shopWebAddress) &&
                Objects.equals(this.status, merchant.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(links, captureDelay, defaultShopperInteraction, id, merchantCity, name, primarySettlementCurrency, shopWebAddress, status);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Merchant {\n");

        sb.append("    links: ").append(toIndentedString(links)).append("\n");
        sb.append("    captureDelay: ").append(toIndentedString(captureDelay)).append("\n");
        sb.append("    defaultShopperInteraction: ").append(toIndentedString(defaultShopperInteraction)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    merchantCity: ").append(toIndentedString(merchantCity)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    primarySettlementCurrency: ").append(toIndentedString(primarySettlementCurrency)).append("\n");
        sb.append("    shopWebAddress: ").append(toIndentedString(shopWebAddress)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
