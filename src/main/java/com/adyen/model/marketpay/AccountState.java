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

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * AccountState
 */
public class AccountState {
    @SerializedName("disableReason")
    private String disableReason = null;

    @SerializedName("allowProcessing")
    private Boolean allowProcessing = null;

    @SerializedName("stateDeadline")
    private Date stateDeadline = null;

    @SerializedName("allowPayout")
    private Boolean allowPayout = null;

    @SerializedName("stateLimit")
    private AccountStateLimit stateLimit = null;

    /**
     * account processing state
     */
    public enum StateTypeEnum {
        @SerializedName("LimitedPayout")
        LIMITEDPAYOUT("LimitedPayout"),

        @SerializedName("LimitedProcessing")
        LIMITEDPROCESSING("LimitedProcessing"),

        @SerializedName("LimitlessPayout")
        LIMITLESSPAYOUT("LimitlessPayout"),

        @SerializedName("LimitlessProcessing")
        LIMITLESSPROCESSING("LimitlessProcessing"),

        @SerializedName("Payout")
        PAYOUT("Payout"),

        @SerializedName("Processing")
        PROCESSING("Processing");

        @JsonValue
        private final String value;

        StateTypeEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("stateType")
    private StateTypeEnum stateType = null;

    @SerializedName("tierNumber")
    private Integer tierNumber = null;

    @SerializedName("disabled")
    private Boolean disabled = null;

    public AccountState disableReason(String disableReason) {
        this.disableReason = disableReason;
        return this;
    }

    /**
     * describes why the state has been disabled
     *
     * @return disableReason
     **/
    public String getDisableReason() {
        return disableReason;
    }

    public void setDisableReason(String disableReason) {
        this.disableReason = disableReason;
    }

    public AccountState allowProcessing(Boolean allowProcessing) {
        this.allowProcessing = allowProcessing;
        return this;
    }

    /**
     * indicates if account, having this state, is allowed to process transactions
     *
     * @return allowProcessing
     **/
    public Boolean getAllowProcessing() {
        return allowProcessing;
    }

    public void setAllowProcessing(Boolean allowProcessing) {
        this.allowProcessing = allowProcessing;
    }

    public AccountState stateDeadline(Date stateDeadline) {
        this.stateDeadline = stateDeadline;
        return this;
    }

    /**
     * date, till which the account holder is allowed to be in the current state
     *
     * @return stateDeadline
     **/
    public Date getStateDeadline() {
        return stateDeadline;
    }

    public void setStateDeadline(Date stateDeadline) {
        this.stateDeadline = stateDeadline;
    }

    public AccountState allowPayout(Boolean allowPayout) {
        this.allowPayout = allowPayout;
        return this;
    }

    /**
     * indicates if account, having this state, is allowed to receive payouts
     *
     * @return allowPayout
     **/
    public Boolean getAllowPayout() {
        return allowPayout;
    }

    public void setAllowPayout(Boolean allowPayout) {
        this.allowPayout = allowPayout;
    }

    public AccountState stateLimit(AccountStateLimit stateLimit) {
        this.stateLimit = stateLimit;
        return this;
    }

    /**
     * state limit
     *
     * @return stateLimit
     **/
    public AccountStateLimit getStateLimit() {
        return stateLimit;
    }

    public void setStateLimit(AccountStateLimit stateLimit) {
        this.stateLimit = stateLimit;
    }

    public AccountState stateType(StateTypeEnum stateType) {
        this.stateType = stateType;
        return this;
    }

    /**
     * account processing state
     *
     * @return stateType
     **/
    public StateTypeEnum getStateType() {
        return stateType;
    }

    public void setStateType(StateTypeEnum stateType) {
        this.stateType = stateType;
    }

    public AccountState tierNumber(Integer tierNumber) {
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

    public AccountState disabled(Boolean disabled) {
        this.disabled = disabled;
        return this;
    }

    /**
     * shows if the state is enabled / disabled
     *
     * @return disabled
     **/
    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountState accountState = (AccountState) o;
        return Objects.equals(this.disableReason, accountState.disableReason)
                && Objects.equals(this.allowProcessing, accountState.allowProcessing)
                && Objects.equals(this.stateDeadline,
                                  accountState.stateDeadline)
                && Objects.equals(this.allowPayout, accountState.allowPayout)
                && Objects.equals(this.stateLimit, accountState.stateLimit)
                && Objects.equals(this.stateType, accountState.stateType)
                && Objects.equals(this.tierNumber, accountState.tierNumber)
                && Objects.equals(this.disabled, accountState.disabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disableReason, allowProcessing, stateDeadline, allowPayout, stateLimit, stateType, tierNumber, disabled);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountState {\n");

        sb.append("    disableReason: ").append(toIndentedString(disableReason)).append("\n");
        sb.append("    allowProcessing: ").append(toIndentedString(allowProcessing)).append("\n");
        sb.append("    stateDeadline: ").append(toIndentedString(stateDeadline)).append("\n");
        sb.append("    allowPayout: ").append(toIndentedString(allowPayout)).append("\n");
        sb.append("    stateLimit: ").append(toIndentedString(stateLimit)).append("\n");
        sb.append("    stateType: ").append(toIndentedString(stateType)).append("\n");
        sb.append("    tierNumber: ").append(toIndentedString(tierNumber)).append("\n");
        sb.append("    disabled: ").append(toIndentedString(disabled)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}

