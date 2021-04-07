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

package com.adyen.model.marketpay;

import com.adyen.model.Address;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

public class StoreDetail {
    @SerializedName("address")
    private Address address = null;

    @SerializedName("fullPhoneNumber")
    private String fullPhoneNumber = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("merchantCategoryCode")
    private String merchantCategoryCode = null;

    @SerializedName("phoneNumber")
    private PhoneNumber phoneNumber = null;

    @JsonAdapter(ShopperInteractionEnum.Adapter.class)
    public enum ShopperInteractionEnum {
        ECOMMERCE("Ecommerce"),
        POS("POS");

        @JsonValue
        private String value;

        ShopperInteractionEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static ShopperInteractionEnum fromValue(String text) {
            for (ShopperInteractionEnum b : ShopperInteractionEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<ShopperInteractionEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ShopperInteractionEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public ShopperInteractionEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return ShopperInteractionEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("shopperInteraction")
    private ShopperInteractionEnum shopperInteraction = null;

    @SerializedName("splitConfigurationUUID")
    private String splitConfigurationUUID = null;

    @JsonAdapter(StatusEnum.Adapter.class)
    public enum StatusEnum {
        ACTIVE("Active"),
        CLOSED("Closed"),
        INACTIVE("Inactive"),
        INACTIVEWITHMODIFICATIONS("InactiveWithModifications"),
        PENDING("Pending");

        @JsonValue
        private String value;

        StatusEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static StatusEnum fromValue(String text) {
            for (StatusEnum b : StatusEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<StatusEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public StatusEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return StatusEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("status")
    private StatusEnum status = null;

    @SerializedName("store")
    private String store = null;

    @SerializedName("storeName")
    private String storeName = null;

    @SerializedName("storeReference")
    private String storeReference = null;

    @SerializedName("virtualAccount")
    private String virtualAccount = null;

    @SerializedName("webAddress")
    private String webAddress = null;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFullPhoneNumber() {
        return fullPhoneNumber;
    }

    public void setFullPhoneNumber(String fullPhoneNumber) {
        this.fullPhoneNumber = fullPhoneNumber;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public String getMerchantCategoryCode() {
        return merchantCategoryCode;
    }

    public void setMerchantCategoryCode(String merchantCategoryCode) {
        this.merchantCategoryCode = merchantCategoryCode;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ShopperInteractionEnum getShopperInteraction() {
        return shopperInteraction;
    }

    public void setShopperInteraction(ShopperInteractionEnum shopperInteraction) {
        this.shopperInteraction = shopperInteraction;
    }

    public String getSplitConfigurationUUID() {
        return splitConfigurationUUID;
    }

    public void setSplitConfigurationUUID(String splitConfigurationUUID) {
        this.splitConfigurationUUID = splitConfigurationUUID;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreReference() {
        return storeReference;
    }

    public void setStoreReference(String storeReference) {
        this.storeReference = storeReference;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StoreDetail storeDetail = (StoreDetail) o;
        return Objects.equals(this.address, storeDetail.address) &&
                Objects.equals(this.fullPhoneNumber, storeDetail.fullPhoneNumber) &&
                Objects.equals(this.merchantAccount, storeDetail.merchantAccount) &&
                Objects.equals(this.merchantCategoryCode, storeDetail.merchantCategoryCode) &&
                Objects.equals(this.phoneNumber, storeDetail.phoneNumber) &&
                Objects.equals(this.shopperInteraction, storeDetail.shopperInteraction) &&
                Objects.equals(this.splitConfigurationUUID, storeDetail.splitConfigurationUUID) &&
                Objects.equals(this.status, storeDetail.status) &&
                Objects.equals(this.store, storeDetail.store) &&
                Objects.equals(this.storeName, storeDetail.storeName) &&
                Objects.equals(this.storeReference, storeDetail.storeReference) &&
                Objects.equals(this.virtualAccount, storeDetail.virtualAccount) &&
                Objects.equals(this.webAddress, storeDetail.webAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, fullPhoneNumber, merchantAccount, merchantCategoryCode, phoneNumber, shopperInteraction, splitConfigurationUUID, status, store, storeName, storeReference, virtualAccount, webAddress);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StoreDetail {\n");

        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    fullPhoneNumber: ").append(toIndentedString(fullPhoneNumber)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    merchantCategoryCode: ").append(toIndentedString(merchantCategoryCode)).append("\n");
        sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
        sb.append("    shopperInteraction: ").append(toIndentedString(shopperInteraction)).append("\n");
        sb.append("    splitConfigurationUUID: ").append(toIndentedString(splitConfigurationUUID)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    store: ").append(toIndentedString(store)).append("\n");
        sb.append("    storeName: ").append(toIndentedString(storeName)).append("\n");
        sb.append("    storeReference: ").append(toIndentedString(storeReference)).append("\n");
        sb.append("    virtualAccount: ").append(toIndentedString(virtualAccount)).append("\n");
        sb.append("    webAddress: ").append(toIndentedString(webAddress)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
