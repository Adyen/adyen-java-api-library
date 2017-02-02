package com.adyen.model.hpp;

import com.adyen.Util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DirectoryLookupResult {
    @SerializedName("paymentMethods")
    private List<PaymentMethod> paymentMethods;

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DirectoryLookupResult {\n");

        sb.append("    paymentMethods: ").append(Util.toIndentedString(paymentMethods)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
