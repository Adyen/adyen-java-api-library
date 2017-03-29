package com.adyen.model.recurring;

import com.google.gson.annotations.SerializedName;

/**
 * Container for RecurringDetail
 */
public class RecurringDetailContainer {
    @SerializedName("RecurringDetail")
    private RecurringDetail recurringDetail = null;

    public RecurringDetail getRecurringDetail() {
        return recurringDetail;
    }

    public void setRecurringDetail(RecurringDetail recurringDetail) {
        this.recurringDetail = recurringDetail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RecurringDetailContainer {\n");

        sb.append("    recurringDetail: ").append(toIndentedString(recurringDetail)).append("\n");
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
