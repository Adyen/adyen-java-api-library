/*
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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.binlookup;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ThreeDSAvailabilityResponse
 */
public class ThreeDSAvailabilityResponse {

    @SerializedName("binDetails")
    private BinDetail binDetails = null;

    @SerializedName("dsPublicKeys")
    private List<DSPublicKeyDetail> dsPublicKeys = null;

    @SerializedName("threeDS1Supported")
    private Boolean threeDS1Supported = null;

    @SerializedName("threeDS2CardRangeDetails")
    private List<ThreeDS2CardRangeDetail> threeDS2CardRangeDetails = null;

    @SerializedName("threeDS2supported")
    private Boolean threeDS2supported = null;

    public ThreeDSAvailabilityResponse binDetails(BinDetail binDetails) {
        this.binDetails = binDetails;
        return this;
    }

    /**
     * Get binDetails
     *
     * @return binDetails
     **/
    public BinDetail getBinDetails() {
        return binDetails;
    }

    public void setBinDetails(BinDetail binDetails) {
        this.binDetails = binDetails;
    }

    public ThreeDSAvailabilityResponse dsPublicKeys(List<DSPublicKeyDetail> dsPublicKeys) {
        this.dsPublicKeys = dsPublicKeys;
        return this;
    }

    public ThreeDSAvailabilityResponse addDsPublicKeysItem(DSPublicKeyDetail dsPublicKeysItem) {
        if (this.dsPublicKeys == null) {
            this.dsPublicKeys = new ArrayList<>();
        }
        this.dsPublicKeys.add(dsPublicKeysItem);
        return this;
    }

    /**
     * List of Directory Server (DS) public keys.
     *
     * @return dsPublicKeys
     **/
    public List<DSPublicKeyDetail> getDsPublicKeys() {
        return dsPublicKeys;
    }

    public void setDsPublicKeys(List<DSPublicKeyDetail> dsPublicKeys) {
        this.dsPublicKeys = dsPublicKeys;
    }

    public ThreeDSAvailabilityResponse threeDS1Supported(Boolean threeDS1Supported) {
        this.threeDS1Supported = threeDS1Supported;
        return this;
    }

    /**
     * Indicator if 3D Secure 1 is supported.
     *
     * @return threeDS1Supported
     **/
    public Boolean isThreeDS1Supported() {
        return threeDS1Supported;
    }

    public void setThreeDS1Supported(Boolean threeDS1Supported) {
        this.threeDS1Supported = threeDS1Supported;
    }

    public ThreeDSAvailabilityResponse threeDS2CardRangeDetails(List<ThreeDS2CardRangeDetail> threeDS2CardRangeDetails) {
        this.threeDS2CardRangeDetails = threeDS2CardRangeDetails;
        return this;
    }

    public ThreeDSAvailabilityResponse addThreeDS2CardRangeDetailsItem(ThreeDS2CardRangeDetail threeDS2CardRangeDetailsItem) {
        if (this.threeDS2CardRangeDetails == null) {
            this.threeDS2CardRangeDetails = new ArrayList<>();
        }
        this.threeDS2CardRangeDetails.add(threeDS2CardRangeDetailsItem);
        return this;
    }

    /**
     * List of brand and card range pairs.
     *
     * @return threeDS2CardRangeDetails
     **/
    public List<ThreeDS2CardRangeDetail> getThreeDS2CardRangeDetails() {
        return threeDS2CardRangeDetails;
    }

    public void setThreeDS2CardRangeDetails(List<ThreeDS2CardRangeDetail> threeDS2CardRangeDetails) {
        this.threeDS2CardRangeDetails = threeDS2CardRangeDetails;
    }

    public ThreeDSAvailabilityResponse threeDS2supported(Boolean threeDS2supported) {
        this.threeDS2supported = threeDS2supported;
        return this;
    }

    /**
     * Indicator if 3D Secure 2 is supported.
     *
     * @return threeDS2supported
     **/
    public Boolean isThreeDS2supported() {
        return threeDS2supported;
    }

    public void setThreeDS2supported(Boolean threeDS2supported) {
        this.threeDS2supported = threeDS2supported;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ThreeDSAvailabilityResponse threeDSAvailabilityResponse = (ThreeDSAvailabilityResponse) o;
        return Objects.equals(this.binDetails, threeDSAvailabilityResponse.binDetails) &&
                Objects.equals(this.dsPublicKeys, threeDSAvailabilityResponse.dsPublicKeys) &&
                Objects.equals(this.threeDS1Supported, threeDSAvailabilityResponse.threeDS1Supported) &&
                Objects.equals(this.threeDS2CardRangeDetails, threeDSAvailabilityResponse.threeDS2CardRangeDetails) &&
                Objects.equals(this.threeDS2supported, threeDSAvailabilityResponse.threeDS2supported);
    }

    @Override
    public int hashCode() {
        return Objects.hash(binDetails, dsPublicKeys, threeDS1Supported, threeDS2CardRangeDetails, threeDS2supported);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ThreeDSAvailabilityResponse {\n");
        sb.append("    binDetails: ").append(toIndentedString(binDetails)).append("\n");
        sb.append("    dsPublicKeys: ").append(toIndentedString(dsPublicKeys)).append("\n");
        sb.append("    threeDS1Supported: ").append(toIndentedString(threeDS1Supported)).append("\n");
        sb.append("    threeDS2CardRangeDetails: ").append(toIndentedString(threeDS2CardRangeDetails)).append("\n");
        sb.append("    threeDS2supported: ").append(toIndentedString(threeDS2supported)).append("\n");
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
