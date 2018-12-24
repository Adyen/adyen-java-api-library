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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 *
 */
package com.adyen.model;

import java.util.List;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * PaymentRequest3d
 */
public class PaymentRequest3d extends AbstractPaymentRequest {
    @SerializedName("md")
    private String md = null;

    @SerializedName("paResponse")
    private String paResponse = null;

    @SerializedName("accountInfo")
    private AccountInfo accountInfo = null;

    @SerializedName("merchantRiskIndicator")
    private MerchantRiskIndicator merchantRiskIndicator = null;

    @SerializedName("splits")
    private List<Split> splits = null;

    @SerializedName("trustedShopper")
    private Boolean trustedShopper = null;

    @SerializedName("threeDS2RequestData")
    private ThreeDS2RequestData threeDS2RequestData = null;


    public PaymentRequest3d set3DRequestData(String md, String paResponse) {
        return this.md(md).paResponse(paResponse);
    }

    public PaymentRequest3d md(String md) {
        this.md = md;
        return this;
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public MerchantRiskIndicator getMerchantRiskIndicator() {
        return merchantRiskIndicator;
    }

    public void setMerchantRiskIndicator(MerchantRiskIndicator merchantRiskIndicator) {
        this.merchantRiskIndicator = merchantRiskIndicator;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public Boolean getTrustedShopper() {
        return trustedShopper;
    }

    public void setTrustedShopper(Boolean trustedShopper) {
        this.trustedShopper = trustedShopper;
    }

    public ThreeDS2RequestData getThreeDS2RequestData() {
        return threeDS2RequestData;
    }

    public void setThreeDS2RequestData(ThreeDS2RequestData threeDS2RequestData) {
        this.threeDS2RequestData = threeDS2RequestData;
    }

    /**
     * Get md
     *
     * @return md
     **/
    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public PaymentRequest3d paResponse(String paResponse) {
        this.paResponse = paResponse;
        return this;
    }

    /**
     * Get paResponse
     *
     * @return paResponse
     **/
    public String getPaResponse() {
        return paResponse;
    }

    public void setPaResponse(String paResponse) {
        this.paResponse = paResponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentRequest3d paymentRequest3d = (PaymentRequest3d) o;
        return super.equals(paymentRequest3d) && Objects.equals(this.md, paymentRequest3d.md) && Objects.equals(this.paResponse, paymentRequest3d.paResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(md, paResponse, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentRequest3d {\n");

        sb.append(super.toString());
        sb.append("    md: ").append(toIndentedString(md)).append("\n");
        sb.append("    paResponse: ").append(toIndentedString(paResponse)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

