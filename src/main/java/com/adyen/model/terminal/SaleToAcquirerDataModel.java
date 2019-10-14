package com.adyen.model.terminal;

import java.util.Map;
import java.util.Objects;
import org.apache.commons.codec.binary.Base64;
import com.adyen.model.applicationinfo.ApplicationInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SaleToAcquirerDataModel {

    protected static final Gson PRETTY_PRINT_GSON = new GsonBuilder().setPrettyPrinting().create();
    protected ApplicationInfo applicationInfo;
    protected Map<String, String> additionalData;
    protected Map<String, String> keyValueData;
    protected Map<String, String> metaData;
    protected String tenderOption;

    public SaleToAcquirerDataModel() {
        applicationInfo = new ApplicationInfo();
    }

    public ApplicationInfo getApplicationInfo() {
        return applicationInfo;
    }

    public void setApplicationInfo(ApplicationInfo applicationInfo) {
        this.applicationInfo = applicationInfo;
    }

    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    public Map<String, String> getKeyValueData() {
        return keyValueData;
    }

    public void setKeyValueData(Map<String, String> keyValueData) {
        this.keyValueData = keyValueData;
    }

    public Map<String, String> getMetaData() {
        return metaData;
    }

    public void setMetaData(Map<String, String> metaData) {
        this.metaData = metaData;
    }

    public String getTenderOption() {
        return tenderOption;
    }

    public void setTenderOption(String tenderOption) {
        this.tenderOption = tenderOption;
    }

    public String toBase64() {
        String json = PRETTY_PRINT_GSON.toJson(this);
        return new String(Base64.encodeBase64(json.getBytes()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SaleToAcquirerDataModel saleToAcquirerDataModel = (SaleToAcquirerDataModel) o;
        return Objects.equals(this.additionalData, saleToAcquirerDataModel.additionalData)
                && Objects.equals(this.applicationInfo, saleToAcquirerDataModel.applicationInfo)
                && Objects.equals(this.keyValueData, saleToAcquirerDataModel.keyValueData)
                && Objects.equals(this.metaData, saleToAcquirerDataModel.metaData)
                && Objects.equals(this.tenderOption, saleToAcquirerDataModel.tenderOption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationInfo, additionalData, keyValueData, metaData, tenderOption);
    }
}
