package com.adyen.model;

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

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
        if (Objects.isNull(o) || getClass() != o.getClass()) {
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
        sb.append("class ThreeDS2ResultResponse {").append(TextConstants.LINE_BREAK);

        sb.append("    threeDS2Result: ").append(Util.toIndentedString(threeDS2Result)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }
}
