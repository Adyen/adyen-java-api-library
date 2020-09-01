package com.adyen.model.marketpay.notification;

import com.google.gson.annotations.SerializedName;
import com.adyen.model.marketpay.KYCCheckStatusData.CheckTypeEnum;

import java.util.Objects;

public class KYCCheckStatusData {

    @SerializedName("status")
    private String status = null;

    @SerializedName("type")
    private CheckTypeEnum type = null;

    @SerializedName("summary")
    private KYCCheckSummary statusSummary;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CheckTypeEnum getType() {
        return type;
    }

    public void setType(CheckTypeEnum type) {
        this.type = type;
    }

    public KYCCheckSummary getStatusSummary() {
        return statusSummary;
    }

    public void setStatusSummary(KYCCheckSummary statusSummary) {
        this.statusSummary = statusSummary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KYCCheckStatusData)) {
            return false;
        }
        KYCCheckStatusData that = (KYCCheckStatusData) o;
        return Objects.equals(getStatus(), that.getStatus()) &&
                getType() == that.getType() &&
                Objects.equals(getStatusSummary(), that.getStatusSummary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus(), getType(), getStatusSummary());
    }

    @Override
    public String toString() {
        return "KYCCheckStatusData{" +
                "status='" + status + '\'' +
                ", type=" + type +
                ", statusSummary=" + statusSummary +
                '}';
    }
}
