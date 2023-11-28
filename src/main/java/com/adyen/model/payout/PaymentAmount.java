package com.adyen.model.payout;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@ApiModel(description = "Payment Amount")
public class PaymentAmount {
    public static final String JSON_PROPERTY_CURRENCY = "currency";
    private String currency;
    public static final String JSON_PROPERTY_VALUE = "value";
    private Long value;
    public PaymentAmount() {
    }
    public PaymentAmount currency(String currency) {
        this.currency = currency;
        return this;
    }
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_CURRENCY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getCurrency() {
        return currency;
    }
    @JsonProperty(JSON_PROPERTY_CURRENCY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public PaymentAmount value(Long value) {
        this.value = value;
        return this;
    }
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Long getValue() {
        return value;
    }
    @JsonProperty(JSON_PROPERTY_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setValue(Long value) {
        this.value = value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentAmount paymentAmount = (PaymentAmount) o;
        return Objects.equals(this.currency, paymentAmount.currency) &&
                Objects.equals(this.value, paymentAmount.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(currency, value);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentAmount {\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("}");
        return sb.toString();
    }
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
