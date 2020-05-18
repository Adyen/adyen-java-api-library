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
 *
 */
package com.adyen.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


/**
 * PaymentRequest3ds2
 */
public class PaymentRequest3ds2 extends AbstractPaymentRequest {

    @SerializedName("accountInfo")
    private AccountInfo accountInfo = null;

    @SerializedName("merchantRiskIndicator")
    private MerchantRiskIndicator merchantRiskIndicator = null;

    @SerializedName("splits")
    private List<Split> splits = null;

    @SerializedName("store")
    private String store = null;

    @SerializedName("threeDS2RequestData")
    private ThreeDS2RequestData threeDS2RequestData = null;

    @SerializedName("threeDS2Result")
    private ThreeDS2Result threeDS2Result = null;

    @SerializedName("threeDS2Token")
    private String threeDS2Token = null;

    @SerializedName("totalsGroup")
    private String totalsGroup = null;

    @SerializedName("trustedShopper")
    private Boolean trustedShopper = null;

    public PaymentRequest3ds2 accountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
        return this;
    }


    /**
     * Defines a recurring payment type. Allowed values: * &#x60;Subscription&#x60; – A transaction for a fixed or variable amount, which follows a fixed schedule. * &#x60;CardOnFile&#x60; – Card
     * details are stored to enable one-click or omnichannel journeys, or simply to streamline the checkout process. Any subscription not following a fixed schedule is also considered a card-on-file
     * transaction.
     */
    @JsonAdapter(RecurringProcessingModelEnum.Adapter.class)
    public enum RecurringProcessingModelEnum {

        CARDONFILE("CardOnFile"),
        SUBSCRIPTION("Subscription");

        private String value;

        RecurringProcessingModelEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static RecurringProcessingModelEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<RecurringProcessingModelEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final RecurringProcessingModelEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public RecurringProcessingModelEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return RecurringProcessingModelEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("recurringProcessingModel")
    private RecurringProcessingModelEnum recurringProcessingModel = null;

    /**
     * Specifies the sales channel, through which the shopper gives their card details, and whether the shopper is a returning customer. For the web service API, Adyen assumes Ecommerce shopper
     * interaction by default.  This field has the following possible values: * &#x60;Ecommerce&#x60; - Online transactions where the cardholder is present (online). For better authorisation rates, we
     * recommend sending the card security code (CSC) along with the request. * &#x60;ContAuth&#x60; - Card on file and/or subscription transactions, where the cardholder is known to the merchant
     * (returning customer). If the shopper is present (online), you can supply also the CSC to improve authorisation (one-click payment). * &#x60;Moto&#x60; - Mail-order and telephone-order
     * transactions where the shopper is in contact with the merchant via email or telephone. * &#x60;POS&#x60; - Point-of-sale transactions where the shopper is physically present to make a payment
     * using a secure payment terminal.
     */
    @JsonAdapter(ShopperInteractionEnum.Adapter.class)
    public enum ShopperInteractionEnum {

        ECOMMERCE("Ecommerce"),
        CONTAUTH("ContAuth"),
        MOTO("Moto"),
        POS("POS");

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
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
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


    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }


    public MerchantRiskIndicator getMerchantRiskIndicator() {
        return merchantRiskIndicator;
    }

    public void setMerchantRiskIndicator(MerchantRiskIndicator merchantRiskIndicator) {
        this.merchantRiskIndicator = merchantRiskIndicator;
    }


    public PaymentRequest3ds2 addSplitsItem(Split splitsItem) {

        if (this.splits == null) {
            this.splits = new ArrayList<>();
        }

        this.splits.add(splitsItem);
        return this;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public PaymentRequest3ds2 store(String store) {
        this.store = store;
        return this;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }


    public PaymentRequest3ds2 threeDS2RequestData(ThreeDS2RequestData threeDS2RequestData) {
        this.threeDS2RequestData = threeDS2RequestData;
        return this;
    }

    public ThreeDS2RequestData getThreeDS2RequestData() {
        return threeDS2RequestData;
    }

    public void setThreeDS2RequestData(ThreeDS2RequestData threeDS2RequestData) {
        this.threeDS2RequestData = threeDS2RequestData;
    }

    public PaymentRequest3ds2 threeDS2Result(ThreeDS2Result threeDS2Result) {
        this.threeDS2Result = threeDS2Result;
        return this;
    }

    public ThreeDS2Result getThreeDS2Result() {
        return threeDS2Result;
    }

    public void setThreeDS2Result(ThreeDS2Result threeDS2Result) {
        this.threeDS2Result = threeDS2Result;
    }

    public PaymentRequest3ds2 threeDS2Token(String threeDS2Token) {
        this.threeDS2Token = threeDS2Token;
        return this;
    }

    public String getThreeDS2Token() {
        return threeDS2Token;
    }

    public void setThreeDS2Token(String threeDS2Token) {
        this.threeDS2Token = threeDS2Token;
    }

    public PaymentRequest3ds2 totalsGroup(String totalsGroup) {
        this.totalsGroup = totalsGroup;
        return this;
    }

    public String getTotalsGroup() {
        return totalsGroup;
    }

    public void setTotalsGroup(String totalsGroup) {
        this.totalsGroup = totalsGroup;
    }

    public PaymentRequest3ds2 trustedShopper(Boolean trustedShopper) {
        this.trustedShopper = trustedShopper;
        return this;
    }


    public Boolean isTrustedShopper() {
        return trustedShopper;
    }

    public void setTrustedShopper(Boolean trustedShopper) {
        this.trustedShopper = trustedShopper;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentRequest3ds2 paymentRequest3ds2 = (PaymentRequest3ds2) o;
        return Objects.equals(this.accountInfo, paymentRequest3ds2.accountInfo)
                && Objects.equals(this.merchantRiskIndicator, paymentRequest3ds2.merchantRiskIndicator)

                && Objects.equals(this.recurringProcessingModel, paymentRequest3ds2.recurringProcessingModel)
                && Objects.equals(this.splits, paymentRequest3ds2.splits)
                && Objects.equals(this.store,
                                  paymentRequest3ds2.store)
                && Objects.equals(this.threeDS2RequestData, paymentRequest3ds2.threeDS2RequestData)
                && Objects.equals(this.threeDS2Result, paymentRequest3ds2.threeDS2Result)
                && Objects.equals(this.threeDS2Token, paymentRequest3ds2.threeDS2Token)
                && Objects.equals(this.totalsGroup, paymentRequest3ds2.totalsGroup)
                && Objects.equals(this.trustedShopper, paymentRequest3ds2.trustedShopper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountInfo, merchantRiskIndicator, recurringProcessingModel, splits, store,

                            threeDS2RequestData, threeDS2Result, threeDS2Token, totalsGroup, trustedShopper);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentRequest3ds2 {\n");
        sb.append("    accountInfo: ").append(toIndentedString(accountInfo)).append("\n");
        sb.append("    merchantRiskIndicator: ").append(toIndentedString(merchantRiskIndicator)).append("\n");
        sb.append("    recurringProcessingModel: ").append(toIndentedString(recurringProcessingModel)).append("\n");
        sb.append("    threeDS2RequestData: ").append(toIndentedString(threeDS2RequestData)).append("\n");
        sb.append("    threeDS2Result: ").append(toIndentedString(threeDS2Result)).append("\n");
        sb.append("    threeDS2Token: ").append(toIndentedString(threeDS2Token)).append("\n");
        sb.append("    totalsGroup: ").append(toIndentedString(totalsGroup)).append("\n");
        sb.append("    trustedShopper: ").append(toIndentedString(trustedShopper)).append("\n");
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



