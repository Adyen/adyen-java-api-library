package com.adyen.model.applicationinfo;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

import static com.adyen.Client.LIB_NAME;
import static com.adyen.Client.LIB_VERSION;

public class AdyenLibraryInfo {
    @SerializedName("name")
    private String name;

    @SerializedName("version")
    private String version;

    public AdyenLibraryInfo() {
        this.name = LIB_NAME;
        this.version = LIB_VERSION;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AdyenLibraryInfo that = (AdyenLibraryInfo) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, version);
    }

    @Override
    public String toString() {
        return "AdyenLibraryInfo{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
