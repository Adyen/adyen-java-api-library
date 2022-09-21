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
 * Copyright (c) 2022 Adyen N.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.checkout.details;

import java.util.Objects;
import com.adyen.model.checkout.PaymentMethodDetails;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;

public class CardDetails implements PaymentMethodDetails {

    /**
     * Possible types
     */

    public static final String SCHEME = "scheme";
    public static final String NETWORKTOKEN = "networkToken";
    public static final String GIFTCARD = "giftcard";
    public static final String ALLIANCEDATA = "alliancedata";
    public static final String CARD = "card";

    @SerializedName("brand")
    private String brand = null;

    @SerializedName("cvc")
    private String cvc = null;

    @SerializedName("encryptedCardNumber")
    private String encryptedCardNumber = null;

    @SerializedName("encryptedExpiryMonth")
    private String encryptedExpiryMonth = null;

    @SerializedName("encryptedExpiryYear")
    private String encryptedExpiryYear = null;

    @SerializedName("encryptedSecurityCode")
    private String encryptedSecurityCode = null;

    @SerializedName("expiryMonth")
    private String expiryMonth = null;

    @SerializedName("expiryYear")
    private String expiryYear = null;

    /**
     * The funding source that should be used when multiple sources are available. For Brazilian combo cards, by default the funding source is credit. To use debit, set this value to **debit**.
     */
    @JsonAdapter(FundingSourceEnum.Adapter.class)
    public enum FundingSourceEnum {
        DEBIT("debit");

        @JsonValue
        private String value;

        FundingSourceEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static FundingSourceEnum fromValue(String input) {
            for (FundingSourceEnum b : FundingSourceEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<FundingSourceEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final FundingSourceEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public FundingSourceEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return FundingSourceEnum.fromValue((String) (value));
            }
        }
    }  @SerializedName("fundingSource")
    private FundingSourceEnum fundingSource = null;

    @SerializedName("holderName")
    private String holderName = null;

    @SerializedName("networkPaymentReference")
    private String networkPaymentReference = null;

    @SerializedName("number")
    private String number = null;

    @SerializedName("recurringDetailReference")
    private String recurringDetailReference = null;

    @SerializedName("shopperNotificationReference")
    private String shopperNotificationReference = null;

    @SerializedName("storedPaymentMethodId")
    private String storedPaymentMethodId = null;

    @SerializedName("threeDS2SdkVersion")
    private String threeDS2SdkVersion = null;

    /**
     * Default payment method details. Common for scheme payment methods, and for simple payment method details.
     */
    @SerializedName("type")
    private String type = null;

    public CardDetails brand(String brand) {
        this.brand = brand;
        return this;
    }

    /**
     * Secondary brand of the card. For example: **plastix**, **hmclub**.
     * @return brand
     **/
    @Schema(description = "Secondary brand of the card. For example: **plastix**, **hmclub**.")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public CardDetails cvc(String cvc) {
        this.cvc = cvc;
        return this;
    }

    /**
     * The card verification code. Only collect raw card data if you are [fully PCI compliant](https://docs.adyen.com/development-resources/pci-dss-compliance-guide).
     * @return cvc
     **/
    @Schema(description = "The card verification code. Only collect raw card data if you are [fully PCI compliant](https://docs.adyen.com/development-resources/pci-dss-compliance-guide).")
    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public CardDetails encryptedCardNumber(String encryptedCardNumber) {
        this.encryptedCardNumber = encryptedCardNumber;
        return this;
    }

    /**
     * The encrypted card number.
     * @return encryptedCardNumber
     **/
    @Schema(required = true, description = "The encrypted card number.")
    public String getEncryptedCardNumber() {
        return encryptedCardNumber;
    }

    public void setEncryptedCardNumber(String encryptedCardNumber) {
        this.encryptedCardNumber = encryptedCardNumber;
    }

    public CardDetails encryptedExpiryMonth(String encryptedExpiryMonth) {
        this.encryptedExpiryMonth = encryptedExpiryMonth;
        return this;
    }

    /**
     * The encrypted card expiry month.
     * @return encryptedExpiryMonth
     **/
    @Schema(required = true, description = "The encrypted card expiry month.")
    public String getEncryptedExpiryMonth() {
        return encryptedExpiryMonth;
    }

    public void setEncryptedExpiryMonth(String encryptedExpiryMonth) {
        this.encryptedExpiryMonth = encryptedExpiryMonth;
    }

    public CardDetails encryptedExpiryYear(String encryptedExpiryYear) {
        this.encryptedExpiryYear = encryptedExpiryYear;
        return this;
    }

    /**
     * The encrypted card expiry year.
     * @return encryptedExpiryYear
     **/
    @Schema(required = true, description = "The encrypted card expiry year.")
    public String getEncryptedExpiryYear() {
        return encryptedExpiryYear;
    }

    public void setEncryptedExpiryYear(String encryptedExpiryYear) {
        this.encryptedExpiryYear = encryptedExpiryYear;
    }

    public CardDetails encryptedSecurityCode(String encryptedSecurityCode) {
        this.encryptedSecurityCode = encryptedSecurityCode;
        return this;
    }

    /**
     * The encrypted card verification code.
     * @return encryptedSecurityCode
     **/
    @Schema(description = "The encrypted card verification code.")
    public String getEncryptedSecurityCode() {
        return encryptedSecurityCode;
    }

    public void setEncryptedSecurityCode(String encryptedSecurityCode) {
        this.encryptedSecurityCode = encryptedSecurityCode;
    }

    public CardDetails expiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
        return this;
    }

    /**
     * The card expiry month. Only collect raw card data if you are [fully PCI compliant](https://docs.adyen.com/development-resources/pci-dss-compliance-guide).
     * @return expiryMonth
     **/
    @Schema(description = "The card expiry month. Only collect raw card data if you are [fully PCI compliant](https://docs.adyen.com/development-resources/pci-dss-compliance-guide).")
    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public CardDetails expiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
        return this;
    }

    /**
     * The card expiry year. Only collect raw card data if you are [fully PCI compliant](https://docs.adyen.com/development-resources/pci-dss-compliance-guide).
     * @return expiryYear
     **/
    @Schema(description = "The card expiry year. Only collect raw card data if you are [fully PCI compliant](https://docs.adyen.com/development-resources/pci-dss-compliance-guide).")
    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public CardDetails fundingSource(FundingSourceEnum fundingSource) {
        this.fundingSource = fundingSource;
        return this;
    }

    /**
     * The funding source that should be used when multiple sources are available. For Brazilian combo cards, by default the funding source is credit. To use debit, set this value to **debit**.
     * @return fundingSource
     **/
    @Schema(description = "The funding source that should be used when multiple sources are available. For Brazilian combo cards, by default the funding source is credit. To use debit, set this value to **debit**.")
    public FundingSourceEnum getFundingSource() {
        return fundingSource;
    }

    public void setFundingSource(FundingSourceEnum fundingSource) {
        this.fundingSource = fundingSource;
    }

    public CardDetails holderName(String holderName) {
        this.holderName = holderName;
        return this;
    }

    /**
     * The name of the card holder.
     * @return holderName
     **/
    @Schema(description = "The name of the card holder.")
    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public CardDetails networkPaymentReference(String networkPaymentReference) {
        this.networkPaymentReference = networkPaymentReference;
        return this;
    }

    /**
     * The network token reference. This is the [&#x60;networkTxReference&#x60;](https://docs.adyen.com/api-explorer/#/CheckoutService/latest/post/payments__resParam_additionalData-ResponseAdditionalDataCommon-networkTxReference) from the response to the first payment.
     * @return networkPaymentReference
     **/
    @Schema(description = "The network token reference. This is the [`networkTxReference`](https://docs.adyen.com/api-explorer/#/CheckoutService/latest/post/payments__resParam_additionalData-ResponseAdditionalDataCommon-networkTxReference) from the response to the first payment.")
    public String getNetworkPaymentReference() {
        return networkPaymentReference;
    }

    public void setNetworkPaymentReference(String networkPaymentReference) {
        this.networkPaymentReference = networkPaymentReference;
    }

    public CardDetails number(String number) {
        this.number = number;
        return this;
    }

    /**
     * The card number. Only collect raw card data if you are [fully PCI compliant](https://docs.adyen.com/development-resources/pci-dss-compliance-guide).
     * @return number
     **/
    @Schema(description = "The card number. Only collect raw card data if you are [fully PCI compliant](https://docs.adyen.com/development-resources/pci-dss-compliance-guide).")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CardDetails recurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
        return this;
    }

    /**
     * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the token.
     * @return recurringDetailReference
     **/
    @Schema(description = "This is the `recurringDetailReference` returned in the response when you created the token.")
    public String getRecurringDetailReference() {
        return recurringDetailReference;
    }

    public void setRecurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
    }

    public CardDetails shopperNotificationReference(String shopperNotificationReference) {
        this.shopperNotificationReference = shopperNotificationReference;
        return this;
    }

    /**
     * The &#x60;shopperNotificationReference&#x60; returned in the response when you requested to notify the shopper. Used only for recurring payments in India.
     * @return shopperNotificationReference
     **/
    @Schema(description = "The `shopperNotificationReference` returned in the response when you requested to notify the shopper. Used only for recurring payments in India.")
    public String getShopperNotificationReference() {
        return shopperNotificationReference;
    }

    public void setShopperNotificationReference(String shopperNotificationReference) {
        this.shopperNotificationReference = shopperNotificationReference;
    }

    public CardDetails storedPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
        return this;
    }

    /**
     * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the token.
     * @return storedPaymentMethodId
     **/
    @Schema(description = "This is the `recurringDetailReference` returned in the response when you created the token.")
    public String getStoredPaymentMethodId() {
        return storedPaymentMethodId;
    }

    public void setStoredPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
    }

    public CardDetails threeDS2SdkVersion(String threeDS2SdkVersion) {
        this.threeDS2SdkVersion = threeDS2SdkVersion;
        return this;
    }

    /**
     * Version of the 3D Secure 2 mobile SDK.
     * @return threeDS2SdkVersion
     **/
    @Schema(description = "Version of the 3D Secure 2 mobile SDK.")
    public String getThreeDS2SdkVersion() {
        return threeDS2SdkVersion;
    }

    public void setThreeDS2SdkVersion(String threeDS2SdkVersion) {
        this.threeDS2SdkVersion = threeDS2SdkVersion;
    }

    public CardDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Default payment method details. Common for scheme payment methods, and for simple payment method details.
     * @return type
     **/
    @Schema(description = "Default payment method details. Common for scheme payment methods, and for simple payment method details.")
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
        CardDetails cardDetails = (CardDetails) o;
        return Objects.equals(this.brand, cardDetails.brand) &&
                Objects.equals(this.cvc, cardDetails.cvc) &&
                Objects.equals(this.encryptedCardNumber, cardDetails.encryptedCardNumber) &&
                Objects.equals(this.encryptedExpiryMonth, cardDetails.encryptedExpiryMonth) &&
                Objects.equals(this.encryptedExpiryYear, cardDetails.encryptedExpiryYear) &&
                Objects.equals(this.encryptedSecurityCode, cardDetails.encryptedSecurityCode) &&
                Objects.equals(this.expiryMonth, cardDetails.expiryMonth) &&
                Objects.equals(this.expiryYear, cardDetails.expiryYear) &&
                Objects.equals(this.fundingSource, cardDetails.fundingSource) &&
                Objects.equals(this.holderName, cardDetails.holderName) &&
                Objects.equals(this.networkPaymentReference, cardDetails.networkPaymentReference) &&
                Objects.equals(this.number, cardDetails.number) &&
                Objects.equals(this.recurringDetailReference, cardDetails.recurringDetailReference) &&
                Objects.equals(this.shopperNotificationReference, cardDetails.shopperNotificationReference) &&
                Objects.equals(this.storedPaymentMethodId, cardDetails.storedPaymentMethodId) &&
                Objects.equals(this.threeDS2SdkVersion, cardDetails.threeDS2SdkVersion) &&
                Objects.equals(this.type, cardDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, cvc, encryptedCardNumber, encryptedExpiryMonth, encryptedExpiryYear, encryptedSecurityCode, expiryMonth, expiryYear, fundingSource, holderName, networkPaymentReference, number, recurringDetailReference, shopperNotificationReference, storedPaymentMethodId, threeDS2SdkVersion, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CardDetails {\n");

        sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
        sb.append("    cvc: ").append(toIndentedString(cvc)).append("\n");
        sb.append("    encryptedCardNumber: ").append(toIndentedString(encryptedCardNumber)).append("\n");
        sb.append("    encryptedExpiryMonth: ").append(toIndentedString(encryptedExpiryMonth)).append("\n");
        sb.append("    encryptedExpiryYear: ").append(toIndentedString(encryptedExpiryYear)).append("\n");
        sb.append("    encryptedSecurityCode: ").append(toIndentedString(encryptedSecurityCode)).append("\n");
        sb.append("    expiryMonth: ").append(toIndentedString(expiryMonth)).append("\n");
        sb.append("    expiryYear: ").append(toIndentedString(expiryYear)).append("\n");
        sb.append("    fundingSource: ").append(toIndentedString(fundingSource)).append("\n");
        sb.append("    holderName: ").append(toIndentedString(holderName)).append("\n");
        sb.append("    networkPaymentReference: ").append(toIndentedString(networkPaymentReference)).append("\n");
        sb.append("    number: ").append(toIndentedString(number)).append("\n");
        sb.append("    recurringDetailReference: ").append(toIndentedString(recurringDetailReference)).append("\n");
        sb.append("    shopperNotificationReference: ").append(toIndentedString(shopperNotificationReference)).append("\n");
        sb.append("    storedPaymentMethodId: ").append(toIndentedString(storedPaymentMethodId)).append("\n");
        sb.append("    threeDS2SdkVersion: ").append(toIndentedString(threeDS2SdkVersion)).append("\n");
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
