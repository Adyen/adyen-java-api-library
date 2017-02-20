package com.adyen.model.modification;

import com.adyen.Util.Util;
import com.adyen.model.Amount;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * CaptureRequests class
 */
public class CaptureRequest extends AbstractModificationRequest<CaptureRequest> {
    @SerializedName("modificationAmount")
    private Amount modificationAmount = null;

    public AbstractModificationRequest modificationAmount(Amount modificationAmount) {
        this.modificationAmount = modificationAmount;
        return this;
    }

    /**
     * the amount to capture/refund. Required for \"capture\"/\"refund\", not allowed for \"cancel\"
     *
     * @return modificationAmount
     **/
    public Amount getModificationAmount() {
        return modificationAmount;
    }

    public void setModificationAmount(Amount modificationAmount) {
        this.modificationAmount = modificationAmount;
    }

    //Shortcut for filling amount value + currency
    public CaptureRequest fillAmount(String amount, String currency) {
        Amount amountData = Util.createAmount(amount, currency);

        this.setModificationAmount(amountData);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CaptureRequest captureRequest = (CaptureRequest) o;
        return super.equals(captureRequest) &&
                Objects.equals(this.modificationAmount, captureRequest.modificationAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modificationAmount, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CaptureRequest {\n");

        sb.append(super.toString());
        sb.append("    modificationAmount: ").append(toIndentedString(modificationAmount)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
