package com.adyen.model.checkout.details;

import com.adyen.model.checkout.PaymentMethodDetails;
import com.google.gson.annotations.SerializedName;

public class SwishPaymentMethodDetails implements PaymentMethodDetails {


    public static final String SWISH = "swish";

    @SerializedName("type")
    private String type = SWISH;


    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }
}
