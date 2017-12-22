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
 */
package com.adyen.model.marketpay;

import java.util.Objects;
import com.adyen.model.Amount;
import com.google.gson.annotations.SerializedName;

/**
 * AccountPayoutState
 */
public class AccountPayoutState {
    @SerializedName("disableReason")
    private String disableReason = null;

    @SerializedName("allowPayout")
    private Boolean allowPayout = null;

    @SerializedName("tierNumber")
    private Integer tierNumber = null;

    @SerializedName("disabled")
    private Boolean disabled = null;

    @SerializedName("payoutLimit")
    private Amount payoutLimit = null;

    public AccountPayoutState disableReason(String disableReason) {
        this.disableReason = disableReason;
        return this;
    }

    /**
     * if the payout has been disabled for all the virtual accounts, shows the disable reason
     *
     * @return disableReason
     **/
    public String getDisableReason() {
        return disableReason;
    }

    public void setDisableReason(String disableReason) {
        this.disableReason = disableReason;
    }

    public AccountPayoutState allowPayout(Boolean allowPayout) {
        this.allowPayout = allowPayout;
        return this;
    }

    /**
     * shows if the payout is allowed
     *
     * @return allowPayout
     **/
    public Boolean getAllowPayout() {
        return allowPayout;
    }

    public void setAllowPayout(Boolean allowPayout) {
        this.allowPayout = allowPayout;
    }

    public AccountPayoutState tierNumber(Integer tierNumber) {
        this.tierNumber = tierNumber;
        return this;
    }

    /**
     * the tier in which the accountholder currently resides
     *
     * @return tierNumber
     **/
    public Integer getTierNumber() {
        return tierNumber;
    }

    public void setTierNumber(Integer tierNumber) {
        this.tierNumber = tierNumber;
    }

    public AccountPayoutState disabled(Boolean disabled) {
        this.disabled = disabled;
        return this;
    }

    /**
     * shows if the payout schedule has been disabled for all the virtual accounts
     *
     * @return disabled
     **/
    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public AccountPayoutState payoutLimit(Amount payoutLimit) {
        this.payoutLimit = payoutLimit;
        return this;
    }

    /**
     * payout limit (specified if the payout is allowed and the payout is limited)
     *
     * @return payoutLimit
     **/
    public Amount getPayoutLimit() {
        return payoutLimit;
    }

    public void setPayoutLimit(Amount payoutLimit) {
        this.payoutLimit = payoutLimit;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountPayoutState accountPayoutState = (AccountPayoutState) o;
        return Objects.equals(this.disableReason, accountPayoutState.disableReason)
                && Objects.equals(this.allowPayout, accountPayoutState.allowPayout)
                && Objects.equals(this.tierNumber,
                                  accountPayoutState.tierNumber)
                && Objects.equals(this.disabled, accountPayoutState.disabled)
                && Objects.equals(this.payoutLimit, accountPayoutState.payoutLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disableReason, allowPayout, tierNumber, disabled, payoutLimit);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountPayoutState {\n");

        sb.append("    disableReason: ").append(toIndentedString(disableReason)).append("\n");
        sb.append("    allowPayout: ").append(toIndentedString(allowPayout)).append("\n");
        sb.append("    tierNumber: ").append(toIndentedString(tierNumber)).append("\n");
        sb.append("    disabled: ").append(toIndentedString(disabled)).append("\n");
        sb.append("    payoutLimit: ").append(toIndentedString(payoutLimit)).append("\n");
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

