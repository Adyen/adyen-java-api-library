package com.adyen.model.checkout;


import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;

import java.io.IOException;

/**
 * SplitAmount
 */
public class SplitAmount {

    @SerializedName("currency")
    private String currency = null;

    @SerializedName("value")
    private Long value = null;

    public SplitAmount currency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public SplitAmount value(Long value) {
        this.value = value;
        return this;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SplitAmount splitAmount = (SplitAmount) o;
        return Objects.equals(this.currency, splitAmount.currency) &&
                Objects.equals(this.value, splitAmount.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SplitAmount {\n");

        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
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



