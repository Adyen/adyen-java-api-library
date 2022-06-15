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

import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * UpdateAccountHolderStateRequest
 */
public class UpdateAccountHolderStateRequest {
    @SerializedName("reason")
    private String reason = null;

    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("disable")
    private Boolean disable = null;

    /**
     * state to be updated
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

    public UpdateAccountHolderStateRequest reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Update state reason. Must be specified if the state is being disabled
     *
     * @return reason
     **/
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public UpdateAccountHolderStateRequest accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * account holder whose state has to be updated
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public UpdateAccountHolderStateRequest disable(Boolean disable) {
        this.disable = disable;
        return this;
    }

    /**
     * enable / disable the state
     *
     * @return disable
     **/
    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public UpdateAccountHolderStateRequest stateType(StateTypeEnum stateType) {
        this.stateType = stateType;
        return this;
    }

    /**
     * state to be updated
     *
     * @return stateType
     **/
    public StateTypeEnum getStateType() {
        return stateType;
    }

    public void setStateType(StateTypeEnum stateType) {
        this.stateType = stateType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateAccountHolderStateRequest updateAccountHolderStateRequest = (UpdateAccountHolderStateRequest) o;
        return Objects.equals(this.reason, updateAccountHolderStateRequest.reason)
                && Objects.equals(this.accountHolderCode, updateAccountHolderStateRequest.accountHolderCode)
                && Objects.equals(this.disable, updateAccountHolderStateRequest.disable)
                && Objects.equals(this.stateType, updateAccountHolderStateRequest.stateType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reason, accountHolderCode, disable, stateType);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateAccountHolderStateRequest {\n");

        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    disable: ").append(toIndentedString(disable)).append("\n");
        sb.append("    stateType: ").append(toIndentedString(stateType)).append("\n");
        sb.append("}");
        return sb.toString();
    }



}

