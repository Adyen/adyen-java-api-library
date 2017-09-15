/**
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * KYCCheckResult
 */
public class KYCCheckResult {
    @SerializedName("checkStatusData")
    private List<KYCCheckStatusData> checkStatusData = new ArrayList<KYCCheckStatusData>();

    public KYCCheckResult checkStatusData(List<KYCCheckStatusData> checkStatusData) {
        this.checkStatusData = checkStatusData;
        return this;
    }

    public KYCCheckResult addCheckStatusDataItem(KYCCheckStatusData checkStatusDataItem) {
        this.checkStatusData.add(checkStatusDataItem);
        return this;
    }

    /**
     * Get checkStatusData
     *
     * @return checkStatusData
     **/
    public List<KYCCheckStatusData> getCheckStatusData() {
        return checkStatusData;
    }

    public void setCheckStatusData(List<KYCCheckStatusData> checkStatusData) {
        this.checkStatusData = checkStatusData;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KYCCheckResult kyCCheckResult = (KYCCheckResult) o;
        return Objects.equals(this.checkStatusData, kyCCheckResult.checkStatusData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkStatusData);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KYCCheckResult {\n");

        sb.append("    checkStatusData: ").append(toIndentedString(checkStatusData)).append("\n");
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

