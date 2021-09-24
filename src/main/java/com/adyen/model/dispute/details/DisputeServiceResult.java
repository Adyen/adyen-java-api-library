package com.adyen.model.dispute.details;

import static com.adyen.util.Util.toIndentedString;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

public class DisputeServiceResult {
    @SerializedName("success")
    private boolean success;
    @SerializedName("errorMessage")
    private String errorMessage;
    public boolean getSuccess() {
        return this.success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public String getErrorMessage() {
        return this.errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DisputeServiceResult disputeServiceResult = (DisputeServiceResult) o;
        return Objects.equals(this.success, disputeServiceResult.success) &&
                Objects.equals(this.errorMessage, disputeServiceResult.errorMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.success, this.errorMessage);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DisputeServiceResult {\n");
        sb.append("    success: ").append(toIndentedString(this.success)).append("\n");
        sb.append("    errorMessage: ").append(toIndentedString(this.errorMessage)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
