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
package com.adyen.model.terminal;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import java.util.Objects;

import java.util.Base64;
import com.adyen.model.applicationinfo.ApplicationInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class SaleToAcquirerData {

    private Map<String, String> metadata;
    private String shopperEmail;
    private String shopperReference;
    private String recurringContract;
    private String shopperStatement;
    private String recurringDetailName;
    private String recurringTokenService;
    private String store;
    private String merchantAccount;
    private String currency;
    private ApplicationInfo applicationInfo;
    private String tenderOption;
    private Map<String, String> additionalData;
    private String authorisationType;
    private String ssc;
    private RecurringProcessingModelEnum recurringProcessingModel;
    private String redemptionType;
    private static final Gson PRETTY_PRINT_GSON = new GsonBuilder().setPrettyPrinting().create();

    public SaleToAcquirerData() {
        applicationInfo = new ApplicationInfo();
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public String getShopperEmail() {
        return shopperEmail;
    }

    public void setShopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
    }

    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    public String getRecurringContract() {
        return recurringContract;
    }

    public void setRecurringContract(String recurringContract) {
        this.recurringContract = recurringContract;
    }

    public String getShopperStatement() {
        return shopperStatement;
    }

    public void setShopperStatement(String shopperStatement) {
        this.shopperStatement = shopperStatement;
    }

    public String getRecurringDetailName() {
        return recurringDetailName;
    }

    public void setRecurringDetailName(String recurringDetailName) {
        this.recurringDetailName = recurringDetailName;
    }

    public String getRecurringTokenService() {
        return recurringTokenService;
    }

    public void setRecurringTokenService(String recurringTokenService) {
        this.recurringTokenService = recurringTokenService;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public ApplicationInfo getApplicationInfo() {
        return applicationInfo;
    }

    public void setApplicationInfo(ApplicationInfo applicationInfo) {
        this.applicationInfo = applicationInfo;
    }

    public String getTenderOption() {
        return tenderOption;
    }

    public void setTenderOption(String tenderOption) {
        this.tenderOption = tenderOption;
    }

    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    public String getAuthorisationType() {
        return authorisationType;
    }

    public void setAuthorisationType(String authorisationType) {
        this.authorisationType = authorisationType;
    }
    

    /**
     * Defines a recurring payment type. Required when creating a token to store payment details or using stored payment details. 
     */
    public enum RecurringProcessingModelEnum {
        @SerializedName("Subscription") SUBSCRIPTION("Subscription"),

        @SerializedName("CardOnFile") CARD_ON_FILE("CardOnFile"),

        @SerializedName("UnscheduledCardOnFile") UNSCHEDULED_CARD_ON_FILE("UnscheduledCardOnFile");

        private String value;

        RecurringProcessingModelEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    public RecurringProcessingModelEnum getRecurringProcessingModel() {
        return this.recurringProcessingModel;
    }

    public void setRecurringProcessingModel(RecurringProcessingModelEnum recurringProcessingModel) {
        this.recurringProcessingModel = recurringProcessingModel;
    }

    public String getSsc() {
        return ssc;
    }
    public void setSsc(String ssc) {
        this.ssc = ssc;
    }

    public String getRedemptionType() {
        return redemptionType;
    }

    public void setRedemptionType(String redemptionType) {
        this.redemptionType = redemptionType;
    }

    public static Gson getPrettyPrintGson() {
        return PRETTY_PRINT_GSON;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SaleToAcquirerData that = (SaleToAcquirerData) o;
        return Objects.equals(metadata, that.metadata) &&
                Objects.equals(shopperEmail, that.shopperEmail) &&
                Objects.equals(shopperReference, that.shopperReference) &&
                Objects.equals(recurringContract, that.recurringContract) &&
                Objects.equals(shopperStatement, that.shopperStatement) &&
                Objects.equals(recurringDetailName, that.recurringDetailName) &&
                Objects.equals(recurringTokenService, that.recurringTokenService) &&
                Objects.equals(store, that.store) &&
                Objects.equals(merchantAccount, that.merchantAccount) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(applicationInfo, that.applicationInfo) &&
                Objects.equals(tenderOption, that.tenderOption) &&
                Objects.equals(additionalData, that.additionalData) &&
                Objects.equals(authorisationType, that.authorisationType) &&
                Objects.equals(ssc, that.ssc) &&
                Objects.equals(recurringProcessingModel, that.recurringProcessingModel) &&
                Objects.equals(redemptionType, that.redemptionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadata, shopperEmail, shopperReference, recurringContract, shopperStatement, recurringDetailName, recurringTokenService, store, merchantAccount, currency, applicationInfo, tenderOption, additionalData, authorisationType, ssc, recurringProcessingModel, redemptionType);
    }

    @Override
    public String toString() {
        return "SaleToAcquirerDataModel{" +
                "metadata=" + metadata +
                ", shopperEmail='" + shopperEmail + '\'' +
                ", shopperReference='" + shopperReference + '\'' +
                ", recurringContract='" + recurringContract + '\'' +
                ", shopperStatement='" + shopperStatement + '\'' +
                ", recurringDetailName='" + recurringDetailName + '\'' +
                ", recurringTokenService='" + recurringTokenService + '\'' +
                ", store='" + store + '\'' +
                ", merchantAccount='" + merchantAccount + '\'' +
                ", currency='" + currency + '\'' +
                ", applicationInfo=" + applicationInfo +
                ", tenderOption='" + tenderOption + '\'' +
                ", additionalData=" + additionalData +
                ", authorisationType=" + authorisationType +
                ", ssc='" + ssc + '\'' +
                ", recurringProcessingModel=" + recurringProcessingModel + '\'' +
                ", redemptionType=" + redemptionType +
                '}';
    }

    public String toBase64() {
        String json = PRETTY_PRINT_GSON.toJson(this);
        return new String(Base64.getEncoder().encode(json.getBytes()));
    }

    public static SaleToAcquirerData fromBase64(String base64) {
        byte[] decoded = Base64.getDecoder().decode(base64);
        try (Reader reader = new InputStreamReader(new ByteArrayInputStream(decoded))) {
            return PRETTY_PRINT_GSON.fromJson(reader, SaleToAcquirerData.class);
        }
        catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
