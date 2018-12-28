package com.adyen.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * ThreeDS2ResultResponse
 */
public class ThreeDS2ResultResponse {

    @SerializedName("threeDS2Result")
    private ThreeDS2Result threeDS2Result = null;

    public ThreeDS2ResultResponse threeDS2Result(ThreeDS2Result threeDS2Result) {
        this.threeDS2Result = threeDS2Result;
        return this;
    }

    public ThreeDS2Result getThreeDS2Result() {
        return threeDS2Result;
    }

    public void setThreeDS2Result(ThreeDS2Result threeDS2Result) {
        this.threeDS2Result = threeDS2Result;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ThreeDS2ResultResponse threeDS2ResultResponse = (ThreeDS2ResultResponse) o;
        return Objects.equals(this.threeDS2Result, threeDS2ResultResponse.threeDS2Result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(threeDS2Result);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ThreeDS2ResultResponse {\n");

        sb.append("    threeDS2Result: ").append(toIndentedString(threeDS2Result)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
