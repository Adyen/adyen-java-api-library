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
 * KYCShareholderCheckResult
 */
public class KYCShareholderCheckResult {
    @SerializedName("checkStatusData")
    private List<KYCCheckStatusData> checkStatusData = new ArrayList<KYCCheckStatusData>();

    @SerializedName("shareholderCode")
    private String shareholderCode = null;

    public KYCShareholderCheckResult checkStatusData(List<KYCCheckStatusData> checkStatusData) {
        this.checkStatusData = checkStatusData;
        return this;
    }

    public KYCShareholderCheckResult addCheckStatusDataItem(KYCCheckStatusData checkStatusDataItem) {
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

    public KYCShareholderCheckResult shareholderCode(String shareholderCode) {
        this.shareholderCode = shareholderCode;
        return this;
    }

    /**
     * Get shareholderCode
     *
     * @return shareholderCode
     **/
    public String getShareholderCode() {
        return shareholderCode;
    }

    public void setShareholderCode(String shareholderCode) {
        this.shareholderCode = shareholderCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KYCShareholderCheckResult kyCShareholderCheckResult = (KYCShareholderCheckResult) o;
        return Objects.equals(this.checkStatusData, kyCShareholderCheckResult.checkStatusData) && Objects.equals(this.shareholderCode, kyCShareholderCheckResult.shareholderCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkStatusData, shareholderCode);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KYCShareholderCheckResult {\n");

        sb.append("    checkStatusData: ").append(toIndentedString(checkStatusData)).append("\n");
        sb.append("    shareholderCode: ").append(toIndentedString(shareholderCode)).append("\n");
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

