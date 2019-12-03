package com.adyen.model.terminal;

import com.adyen.model.applicationinfo.ApplicationInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.codec.binary.Base64;

import java.util.Map;
import java.util.Objects;

public class SaleToAcquirerDataModel {

    protected Map<String, String> metadata;
    protected String shopperEmail;
    protected String shopperReference;
    protected String recurringContract;
    protected String shopperStatement;
    protected String recurringDetailName;
    protected String recurringTokenService;
    protected String store;
    protected String merchantAccount;
    protected String currency;
    protected ApplicationInfo applicationInfo;
    protected String tenderOption;
    protected Map<String, String> additionalData;
    protected static final Gson PRETTY_PRINT_GSON = new GsonBuilder().setPrettyPrinting().create();

    public SaleToAcquirerDataModel() {
        if (this.applicationInfo == null) {
            this.applicationInfo = new ApplicationInfo();
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleToAcquirerDataModel that = (SaleToAcquirerDataModel) o;
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
                Objects.equals(additionalData, that.additionalData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadata, shopperEmail, shopperReference, recurringContract, shopperStatement, recurringDetailName, recurringTokenService, store, merchantAccount, currency, applicationInfo, tenderOption, additionalData);
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
                '}';
    }

    public String toBase64() {
        String json = PRETTY_PRINT_GSON.toJson(this);
        return new String(Base64.encodeBase64(json.getBytes()));
    }
}
