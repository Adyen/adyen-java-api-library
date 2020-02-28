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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.marketpay;

import com.adyen.model.Amount;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * AccountPayoutState
 */
public class AccountPayoutState {
    @SerializedName("allowPayout")
    private Boolean allowPayout = null;

    @SerializedName("disableReason")
    private String disableReason = null;

    @SerializedName("disabled")
    private Boolean disabled = null;

    @SerializedName("notAllowedReason")
    private String notAllowedReason = null;

    @SerializedName("payoutLimit")
    private Amount payoutLimit = null;

    @SerializedName("tierNumber")
    private Integer tierNumber = null;

    public AccountPayoutState allowPayout(Boolean allowPayout) {
        this.allowPayout = allowPayout;
        return this;
    }

    /**
     * Indicates whether payouts are allowed. This field is the overarching payout status, and is the aggregate of multiple conditions (e.g., KYC status, disabled flag, etc). If this field is false, no payouts will be permitted for any of the account holder&#x27;s accounts. If this field is true, payouts will be permitted for any of the account holder&#x27;s accounts.
     *
     * @return allowPayout
     **/
    public Boolean isAllowPayout() {
        return allowPayout;
    }

    public void setAllowPayout(Boolean allowPayout) {
        this.allowPayout = allowPayout;
    }

    public AccountPayoutState disableReason(String disableReason) {
        this.disableReason = disableReason;
        return this;
    }

    /**
     * The reason why payouts (to all of the account holder&#x27;s accounts) have been disabled (by the platform). If the &#x60;disabled&#x60; field is true, this field can be used to explain why.
     *
     * @return disableReason
     **/
    public String getDisableReason() {
        return disableReason;
    }

    public void setDisableReason(String disableReason) {
        this.disableReason = disableReason;
    }

    public AccountPayoutState disabled(Boolean disabled) {
        this.disabled = disabled;
        return this;
    }

    /**
     * Indicates whether payouts have been disabled (by the platform) for all of the account holder&#x27;s accounts. A platform may enable and disable this field at their discretion. If this field is true, &#x60;allowPayout&#x60; will be false and no payouts will be permitted for any of the account holder&#x27;s accounts. If this field is false, &#x60;allowPayout&#x60; may or may not be enabled, depending on other factors.
     *
     * @return disabled
     **/
    public Boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public AccountPayoutState notAllowedReason(String notAllowedReason) {
        this.notAllowedReason = notAllowedReason;
        return this;
    }

    /**
     * The reason why payouts (to all of the account holder&#x27;s accounts) have been disabled (by Adyen). If payouts have been disabled by Adyen, this field will explain why. If this field is blank, payouts have not been disabled by Adyen.
     *
     * @return notAllowedReason
     **/
    public String getNotAllowedReason() {
        return notAllowedReason;
    }

    public void setNotAllowedReason(String notAllowedReason) {
        this.notAllowedReason = notAllowedReason;
    }

    public AccountPayoutState payoutLimit(Amount payoutLimit) {
        this.payoutLimit = payoutLimit;
        return this;
    }

    /**
     * Get payoutLimit
     *
     * @return payoutLimit
     **/
    public Amount getPayoutLimit() {
        return payoutLimit;
    }

    public void setPayoutLimit(Amount payoutLimit) {
        this.payoutLimit = payoutLimit;
    }

    public AccountPayoutState tierNumber(Integer tierNumber) {
        this.tierNumber = tierNumber;
        return this;
    }

    /**
     * The payout tier that the account holder occupies.
     *
     * @return tierNumber
     **/
    public Integer getTierNumber() {
        return tierNumber;
    }

    public void setTierNumber(Integer tierNumber) {
        this.tierNumber = tierNumber;
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
        return Objects.equals(this.allowPayout, accountPayoutState.allowPayout) &&
                Objects.equals(this.disableReason, accountPayoutState.disableReason) &&
                Objects.equals(this.disabled, accountPayoutState.disabled) &&
                Objects.equals(this.notAllowedReason, accountPayoutState.notAllowedReason) &&
                Objects.equals(this.payoutLimit, accountPayoutState.payoutLimit) &&
                Objects.equals(this.tierNumber, accountPayoutState.tierNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowPayout, disableReason, disabled, notAllowedReason, payoutLimit, tierNumber);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountPayoutState {\n");

        sb.append("    allowPayout: ").append(toIndentedString(allowPayout)).append("\n");
        sb.append("    disableReason: ").append(toIndentedString(disableReason)).append("\n");
        sb.append("    disabled: ").append(toIndentedString(disabled)).append("\n");
        sb.append("    notAllowedReason: ").append(toIndentedString(notAllowedReason)).append("\n");
        sb.append("    payoutLimit: ").append(toIndentedString(payoutLimit)).append("\n");
        sb.append("    tierNumber: ").append(toIndentedString(tierNumber)).append("\n");
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
