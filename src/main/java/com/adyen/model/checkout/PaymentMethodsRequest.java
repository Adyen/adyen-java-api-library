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

package com.adyen.model.checkout;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import com.adyen.model.AccountInfo;
import com.adyen.model.Amount;
import com.adyen.model.MerchantRiskIndicator;
import com.adyen.model.Split;
import com.adyen.model.ThreeDS2RequestData;
import com.adyen.model.applicationinfo.ApplicationInfo;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * PaymentMethodsRequest
 */
public class PaymentMethodsRequest {

    @SerializedName("amount")
    private Amount amount = null;
    @SerializedName("channel")
    private ChannelEnum channel = null;
    @SerializedName("countryCode")
    private String countryCode = null;
    @SerializedName("merchantAccount")
    private String merchantAccount = null;
    @SerializedName("shopperLocale")
    private String shopperLocale = null;
    @SerializedName("shopperReference")
    private String shopperReference = null;
    @SerializedName("allowedPaymentMethods")
    private List<String> allowedPaymentMethods;
    @SerializedName("blockedPaymentMethods")
    private List<String> blockedPaymentMethods;
    @SerializedName("additionalData")
    private Object additionalData = null;

    @SerializedName("accountInfo")
    private AccountInfo accountInfo = null;

    @SerializedName("configId")
    private String configId = null;

    @SerializedName("merchantRiskIndicator")
    private MerchantRiskIndicator merchantRiskIndicator = null;

    @SerializedName("splits")
    private List<Split> splits = null;

    @SerializedName("threeDS2RequestData")
    private ThreeDS2RequestData threeDS2RequestData = null;

    @SerializedName("trustedShopper")
    private Boolean trustedShopper = null;

    @SerializedName("enableRealTimeUpdate")
    private Boolean enableRealTimeUpdate = null;

    @SerializedName("threeDSAuthenticationOnly")
    private Boolean threeDSAuthenticationOnly = null;

    @SerializedName("store")
    private String store = null;

    public Object getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Object additionalData) {
        this.additionalData = additionalData;
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public PaymentMethodsRequest amount(Amount amount) {
        this.amount = amount;
        return this;
    }

    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    public MerchantRiskIndicator getMerchantRiskIndicator() {
        return merchantRiskIndicator;
    }

    public void setMerchantRiskIndicator(MerchantRiskIndicator merchantRiskIndicator) {
        this.merchantRiskIndicator = merchantRiskIndicator;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public ThreeDS2RequestData getThreeDS2RequestData() {
        return threeDS2RequestData;
    }

    public void setThreeDS2RequestData(ThreeDS2RequestData threeDS2RequestData) {
        this.threeDS2RequestData = threeDS2RequestData;
    }

    public Boolean getTrustedShopper() {
        return trustedShopper;
    }

    public void setTrustedShopper(Boolean trustedShopper) {
        this.trustedShopper = trustedShopper;
    }

    /**
     * Get amount
     *
     * @return amount
     **/
    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public PaymentMethodsRequest channel(ChannelEnum channel) {
        this.channel = channel;
        return this;
    }

    /**
     * The platform where a payment transaction takes place. This field can be used for filtering out payment methods that are only available on specific platforms. Possible values: * iOS * Android *
     * Web
     *
     * @return channel
     **/
    public ChannelEnum getChannel() {
        return channel;
    }

    public void setChannel(ChannelEnum channel) {
        this.channel = channel;
    }

    public PaymentMethodsRequest countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    /**
     * The shopper&#x27;s country code.
     *
     * @return countryCode
     **/
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public PaymentMethodsRequest merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    /**
     * The merchant account identifier, with which you want to process the transaction.
     *
     * @return merchantAccount
     **/
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public PaymentMethodsRequest shopperLocale(String shopperLocale) {
        this.shopperLocale = shopperLocale;
        return this;
    }

    /**
     * The combination of a language code and a country code to specify the language to be used in the payment.
     *
     * @return shopperLocale
     **/
    public String getShopperLocale() {
        return shopperLocale;
    }

    public void setShopperLocale(String shopperLocale) {
        this.shopperLocale = shopperLocale;
    }

    public PaymentMethodsRequest shopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
        return this;
    }

    /**
     * The shopper&#x27;s reference to uniquely identify this shopper (e.g. user ID or account ID). &gt; This field is required for recurring payments.
     *
     * @return shopperReference
     **/
    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    public List<String> getAllowedPaymentMethods() {
        return allowedPaymentMethods;
    }

    public void setAllowedPaymentMethods(List<String> allowedPaymentMethods) {
        this.allowedPaymentMethods = allowedPaymentMethods;
    }

    public List<String> getBlockedPaymentMethods() {
        return blockedPaymentMethods;
    }

    public void setBlockedPaymentMethods(List<String> blockedPaymentMethods) {
        this.blockedPaymentMethods = blockedPaymentMethods;
    }

    public PaymentMethodsRequest enableRealTimeUpdate(Boolean enableRealTimeUpdate) {
        this.enableRealTimeUpdate = enableRealTimeUpdate;
        return this;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public PaymentMethodsRequest store(String store) {
        this.store = store;
        return this;
    }

    /**
     * Choose if a specific transaction should use the Real-time Account Updater, regardless of other settings.
     * @return enableRealTimeUpdate
     **/
    public Boolean isEnableRealTimeUpdate() {
        return enableRealTimeUpdate;
    }

    public void setEnableRealTimeUpdate(Boolean enableRealTimeUpdate) {
        this.enableRealTimeUpdate = enableRealTimeUpdate;
    }

    public PaymentMethodsRequest threeDSAuthenticationOnly(Boolean threeDSAuthenticationOnly) {
        this.threeDSAuthenticationOnly = threeDSAuthenticationOnly;
        return this;
    }

    /**
     * If set to true, you will only perform the [3D Secure 2 authentication](https://docs.adyen.com/checkout/3d-secure/native-3ds2/authentication-only), and not the payment authorisation.
     * @return threeDSAuthenticationOnly
     **/
    public Boolean isThreeDSAuthenticationOnly() {
        return threeDSAuthenticationOnly;
    }

    public void setThreeDSAuthenticationOnly(Boolean threeDSAuthenticationOnly) {
        this.threeDSAuthenticationOnly = threeDSAuthenticationOnly;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentMethodsRequest paymentMethodsRequest = (PaymentMethodsRequest) o;
        return Objects.equals(this.additionalData, paymentMethodsRequest.additionalData) &&
                Objects.equals(this.allowedPaymentMethods, paymentMethodsRequest.allowedPaymentMethods) &&
                Objects.equals(this.amount, paymentMethodsRequest.amount) &&
                Objects.equals(this.blockedPaymentMethods, paymentMethodsRequest.blockedPaymentMethods) &&
                Objects.equals(this.channel, paymentMethodsRequest.channel) &&
                Objects.equals(this.countryCode, paymentMethodsRequest.countryCode) &&
                Objects.equals(this.enableRealTimeUpdate, paymentMethodsRequest.enableRealTimeUpdate) &&
                Objects.equals(this.merchantAccount, paymentMethodsRequest.merchantAccount) &&
                Objects.equals(this.shopperLocale, paymentMethodsRequest.shopperLocale) &&
                Objects.equals(this.shopperReference, paymentMethodsRequest.shopperReference) &&
                Objects.equals(this.store, paymentMethodsRequest.store) &&
                Objects.equals(this.threeDSAuthenticationOnly, paymentMethodsRequest.threeDSAuthenticationOnly);

    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalData, allowedPaymentMethods, amount, blockedPaymentMethods, channel, countryCode, enableRealTimeUpdate, merchantAccount, shopperLocale, shopperReference, threeDSAuthenticationOnly, store);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentMethodsRequest {\n");

        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
        sb.append("    allowedPaymentMethods: ").append(toIndentedString(allowedPaymentMethods)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    blockedPaymentMethods: ").append(toIndentedString(blockedPaymentMethods)).append("\n");
        sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
        sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
        sb.append("    enableRealTimeUpdate: ").append(toIndentedString(enableRealTimeUpdate)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    shopperLocale: ").append(toIndentedString(shopperLocale)).append("\n");
        sb.append("    shopperReference: ").append(toIndentedString(shopperReference)).append("\n");
        sb.append("    threeDSAuthenticationOnly: ").append(toIndentedString(threeDSAuthenticationOnly)).append("\n");
        sb.append("    store: ").append(toIndentedString(store)).append("\n");
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

    /**
     * The platform where a payment transaction takes place. This field can be used for filtering out payment methods that are only available on specific platforms. Possible values: * iOS * Android *
     * Web
     */
    @JsonAdapter(ChannelEnum.Adapter.class)
    public enum ChannelEnum {

        IOS("iOS"),
        ANDROID("Android"),
        WEB("Web");

        private String value;

        ChannelEnum(String value) {
            this.value = value;
        }

        public static ChannelEnum fromValue(String text) {
            for (ChannelEnum b : ChannelEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static class Adapter extends TypeAdapter<ChannelEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ChannelEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public ChannelEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return ChannelEnum.fromValue(String.valueOf(value));
            }
        }
    }


}



