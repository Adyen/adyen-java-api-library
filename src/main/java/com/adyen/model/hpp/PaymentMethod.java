package com.adyen.model.hpp;

import com.adyen.Util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaymentMethod {
    @SerializedName("brandCode")
    private String brandCode = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("issuers")
    private List<Issuer> issuers;

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Issuer> getIssuers() {
        return issuers;
    }

    public void setIssuers(List<Issuer> issuers) {
        this.issuers = issuers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentMethod {\n");

        sb.append("    brandCode: ").append(Util.toIndentedString(brandCode)).append("\n");
        sb.append("    name: ").append(Util.toIndentedString(name)).append("\n");
        sb.append("    issuers: ").append(Util.toIndentedString(issuers)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
