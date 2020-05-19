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
 * Copyright (c) 2018 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model;

import com.adyen.serializer.DateSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * MerchantRiskIndicator
 */
public class MerchantRiskIndicator {

    @SerializedName("addressMatch")
    private Boolean addressMatch = null;

    /**
     * Indicator regarding the delivery address.
     */
    @JsonAdapter(DeliveryAddressIndicatorEnum.Adapter.class)
    public enum DeliveryAddressIndicatorEnum {

        DIGITALGOODS("digitalGoods"),
        GOODSNOTSHIPPED("goodsNotShipped"),
        OTHER("other"),
        SHIPTOBILLINGADDRESS("shipToBillingAddress"),
        SHIPTONEWADDRESS("shipToNewAddress"),
        SHIPTOSTORE("shipToStore"),
        SHIPTOVERIFIEDADDRESS("shipToVerifiedAddress");

        private String value;

        DeliveryAddressIndicatorEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static DeliveryAddressIndicatorEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<DeliveryAddressIndicatorEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final DeliveryAddressIndicatorEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public DeliveryAddressIndicatorEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return DeliveryAddressIndicatorEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("deliveryAddressIndicator")
    private DeliveryAddressIndicatorEnum deliveryAddressIndicator = null;

    @SerializedName("deliveryEmail")
    private String deliveryEmail = null;

    /**
     * The estimated delivery time for the shopper to receive the goods.
     */
    @JsonAdapter(DeliveryTimeframeEnum.Adapter.class)
    public enum DeliveryTimeframeEnum {

        ELECTRONICDELIVERY("electronicDelivery"),
        OVERNIGHTSHIPPING("overnightShipping"),
        SAMEDAYSHIPPING("sameDayShipping"),
        TWOORMOREDAYSSHIPPING("twoOrMoreDaysShipping");

        private String value;

        DeliveryTimeframeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static DeliveryTimeframeEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<DeliveryTimeframeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final DeliveryTimeframeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public DeliveryTimeframeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return DeliveryTimeframeEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("deliveryTimeframe")
    private DeliveryTimeframeEnum deliveryTimeframe = null;

    @SerializedName("giftCardAmount")
    private Amount giftCardAmount = null;

    @SerializedName("giftCardCount")
    private Integer giftCardCount = null;

    @SerializedName("preOrderDate")
    @JsonAdapter(DateSerializer.class)
    private Date preOrderDate = null;

    @SerializedName("preOrderPurchase")
    private Boolean preOrderPurchase = null;

    @SerializedName("reorderItems")
    private Boolean reorderItems = null;

    public MerchantRiskIndicator addressMatch(Boolean addressMatch) {
        this.addressMatch = addressMatch;
        return this;
    }


    public Boolean isAddressMatch() {
        return addressMatch;
    }

    public void setAddressMatch(Boolean addressMatch) {
        this.addressMatch = addressMatch;
    }

    public MerchantRiskIndicator deliveryAddressIndicator(DeliveryAddressIndicatorEnum deliveryAddressIndicator) {
        this.deliveryAddressIndicator = deliveryAddressIndicator;
        return this;
    }

    public DeliveryAddressIndicatorEnum getDeliveryAddressIndicator() {
        return deliveryAddressIndicator;
    }

    public void setDeliveryAddressIndicator(DeliveryAddressIndicatorEnum deliveryAddressIndicator) {
        this.deliveryAddressIndicator = deliveryAddressIndicator;
    }

    public MerchantRiskIndicator deliveryEmail(String deliveryEmail) {
        this.deliveryEmail = deliveryEmail;
        return this;
    }


    public String getDeliveryEmail() {
        return deliveryEmail;
    }

    public void setDeliveryEmail(String deliveryEmail) {
        this.deliveryEmail = deliveryEmail;
    }

    public MerchantRiskIndicator deliveryTimeframe(DeliveryTimeframeEnum deliveryTimeframe) {
        this.deliveryTimeframe = deliveryTimeframe;
        return this;
    }


    public DeliveryTimeframeEnum getDeliveryTimeframe() {
        return deliveryTimeframe;
    }

    public void setDeliveryTimeframe(DeliveryTimeframeEnum deliveryTimeframe) {
        this.deliveryTimeframe = deliveryTimeframe;
    }

    public MerchantRiskIndicator giftCardAmount(Amount giftCardAmount) {
        this.giftCardAmount = giftCardAmount;
        return this;
    }


    public Amount getGiftCardAmount() {
        return giftCardAmount;
    }

    public void setGiftCardAmount(Amount giftCardAmount) {
        this.giftCardAmount = giftCardAmount;
    }

    public MerchantRiskIndicator giftCardCount(Integer giftCardCount) {
        this.giftCardCount = giftCardCount;
        return this;
    }


    public Integer getGiftCardCount() {
        return giftCardCount;
    }

    public void setGiftCardCount(Integer giftCardCount) {
        this.giftCardCount = giftCardCount;
    }

    public MerchantRiskIndicator preOrderDate(Date preOrderDate) {
        this.preOrderDate = preOrderDate;
        return this;
    }

    public Date getPreOrderDate() {
        return preOrderDate;
    }

    public void setPreOrderDate(Date preOrderDate) {
        this.preOrderDate = preOrderDate;
    }

    public MerchantRiskIndicator preOrderPurchase(Boolean preOrderPurchase) {
        this.preOrderPurchase = preOrderPurchase;
        return this;
    }


    public Boolean isPreOrderPurchase() {
        return preOrderPurchase;
    }

    public void setPreOrderPurchase(Boolean preOrderPurchase) {
        this.preOrderPurchase = preOrderPurchase;
    }

    public MerchantRiskIndicator reorderItems(Boolean reorderItems) {
        this.reorderItems = reorderItems;
        return this;
    }


    public Boolean isReorderItems() {
        return reorderItems;
    }

    public void setReorderItems(Boolean reorderItems) {
        this.reorderItems = reorderItems;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MerchantRiskIndicator merchantRiskIndicator = (MerchantRiskIndicator) o;
        return Objects.equals(this.addressMatch, merchantRiskIndicator.addressMatch)
                && Objects.equals(this.deliveryAddressIndicator, merchantRiskIndicator.deliveryAddressIndicator)
                && Objects.equals(this.deliveryEmail,
                                  merchantRiskIndicator.deliveryEmail)
                && Objects.equals(this.deliveryTimeframe, merchantRiskIndicator.deliveryTimeframe)
                && Objects.equals(this.giftCardAmount,
                                  merchantRiskIndicator.giftCardAmount)
                && Objects.equals(this.giftCardCount, merchantRiskIndicator.giftCardCount)
                && Objects.equals(this.preOrderDate, merchantRiskIndicator.preOrderDate)
                && Objects.equals(this.preOrderPurchase, merchantRiskIndicator.preOrderPurchase)
                && Objects.equals(this.reorderItems, merchantRiskIndicator.reorderItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressMatch, deliveryAddressIndicator, deliveryEmail, deliveryTimeframe, giftCardAmount, giftCardCount, preOrderDate, preOrderPurchase, reorderItems);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MerchantRiskIndicator {\n");

        sb.append("    addressMatch: ").append(toIndentedString(addressMatch)).append("\n");
        sb.append("    deliveryAddressIndicator: ").append(toIndentedString(deliveryAddressIndicator)).append("\n");
        sb.append("    deliveryEmail: ").append(toIndentedString(deliveryEmail)).append("\n");
        sb.append("    deliveryTimeframe: ").append(toIndentedString(deliveryTimeframe)).append("\n");
        sb.append("    giftCardAmount: ").append(toIndentedString(giftCardAmount)).append("\n");
        sb.append("    giftCardCount: ").append(toIndentedString(giftCardCount)).append("\n");
        sb.append("    preOrderDate: ").append(toIndentedString(preOrderDate)).append("\n");
        sb.append("    preOrderPurchase: ").append(toIndentedString(preOrderPurchase)).append("\n");
        sb.append("    reorderItems: ").append(toIndentedString(reorderItems)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

