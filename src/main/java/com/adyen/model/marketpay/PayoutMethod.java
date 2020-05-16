
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
package com.adyen.model.marketpay;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/**
 * PayoutMethod
 */
public class PayoutMethod {
    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("payoutMethodCode")
    private String payoutMethodCode = null;

    /**
     * Gets or Sets payoutMethodType
     */
    @JsonAdapter(PayoutMethodTypeEnum.Adapter.class)
    public enum PayoutMethodTypeEnum {
        CARDTOKEN("CardToken");

        private String value;

        PayoutMethodTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static PayoutMethodTypeEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<PayoutMethodTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final PayoutMethodTypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public PayoutMethodTypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return PayoutMethodTypeEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("payoutMethodType")
    private PayoutMethodTypeEnum payoutMethodType = null;

    @SerializedName("recurringDetailReference")
    private String recurringDetailReference = null;

    @SerializedName("shopperReference")
    private String shopperReference = null;

    public PayoutMethod merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    /**
     * Get merchantAccount
     *
     * @return merchantAccount
     **/
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public PayoutMethod payoutMethodCode(String payoutMethodCode) {
        this.payoutMethodCode = payoutMethodCode;
        return this;
    }

    /**
     * Get payoutMethodCode
     *
     * @return payoutMethodCode
     **/
    public String getPayoutMethodCode() {
        return payoutMethodCode;
    }

    public void setPayoutMethodCode(String payoutMethodCode) {
        this.payoutMethodCode = payoutMethodCode;
    }

    public PayoutMethod payoutMethodType(PayoutMethodTypeEnum payoutMethodType) {
        this.payoutMethodType = payoutMethodType;
        return this;
    }

    /**
     * Get payoutMethodType
     *
     * @return payoutMethodType
     **/
    public PayoutMethodTypeEnum getPayoutMethodType() {
        return payoutMethodType;
    }

    public void setPayoutMethodType(PayoutMethodTypeEnum payoutMethodType) {
        this.payoutMethodType = payoutMethodType;
    }

    public PayoutMethod recurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
        return this;
    }

    /**
     * Get recurringDetailReference
     *
     * @return recurringDetailReference
     **/
    public String getRecurringDetailReference() {
        return recurringDetailReference;
    }

    public void setRecurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
    }

    public PayoutMethod shopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
        return this;
    }

    /**
     * Get shopperReference
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
        PayoutMethod payoutMethod = (PayoutMethod) o;
        return Objects.equals(this.merchantAccount, payoutMethod.merchantAccount) &&
                Objects.equals(this.payoutMethodCode, payoutMethod.payoutMethodCode) &&
                Objects.equals(this.payoutMethodType, payoutMethod.payoutMethodType) &&
                Objects.equals(this.recurringDetailReference, payoutMethod.recurringDetailReference) &&
                Objects.equals(this.shopperReference, payoutMethod.shopperReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchantAccount, payoutMethodCode, payoutMethodType, recurringDetailReference, shopperReference);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PayoutMethod {\n");

        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    payoutMethodCode: ").append(toIndentedString(payoutMethodCode)).append("\n");
        sb.append("    payoutMethodType: ").append(toIndentedString(payoutMethodType)).append("\n");
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
