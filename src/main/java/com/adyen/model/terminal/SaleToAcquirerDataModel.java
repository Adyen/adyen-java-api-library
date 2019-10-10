package com.adyen.model.terminal;

import java.util.Map;
import java.util.Objects;
import com.adyen.model.applicationinfo.ApplicationInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SaleToAcquirerDataModel {

    protected static final Gson PRETTY_PRINT_GSON = new GsonBuilder().setPrettyPrinting().create();
    protected ApplicationInfo applicationInfo;
    protected Map<String, String> additionalData;
    protected Map<String, String> keyValueData;
    protected Map<String, String> metaData;

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

    public String toJson() {
        return PRETTY_PRINT_GSON.toJson(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SaleToAcquirerDataModel that = (SaleToAcquirerDataModel) o;
        return additionalData.equals(that.additionalData) && applicationInfo.equals(that.applicationInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationInfo, additionalData);
    }
}
