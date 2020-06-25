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

import com.adyen.model.Amount;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * AccountProcessingState
 */
public class AccountProcessingState {
    @SerializedName("disableReason")
    private String disableReason = null;

    @SerializedName("processedTo")
    private Amount processedTo = null;

    @SerializedName("processedFrom")
    private Amount processedFrom = null;

    @SerializedName("tierNumber")
    private Integer tierNumber = null;

    @SerializedName("disabled")
    private Boolean disabled = null;

    public AccountProcessingState disableReason(String disableReason) {
        this.disableReason = disableReason;
        return this;
    }

    /**
     * if the processing has been disabled for all the virtual accounts, shows the disable reason
     *
     * @return disableReason
     **/
    public String getDisableReason() {
        return disableReason;
    }

    public void setDisableReason(String disableReason) {
        this.disableReason = disableReason;
    }

    public AccountProcessingState processedTo(Amount processedTo) {
        this.processedTo = processedTo;
        return this;
    }

    /**
     * account holder has processed an amount, less than processedTo amount
     *
     * @return processedTo
     **/
    public Amount getProcessedTo() {
        return processedTo;
    }

    public void setProcessedTo(Amount processedTo) {
        this.processedTo = processedTo;
    }

    public AccountProcessingState processedFrom(Amount processedFrom) {
        this.processedFrom = processedFrom;
        return this;
    }

    /**
     * account holder has processed an amount, equal or more than processedFrom amount
     *
     * @return processedFrom
     **/
    public Amount getProcessedFrom() {
        return processedFrom;
    }

    public void setProcessedFrom(Amount processedFrom) {
        this.processedFrom = processedFrom;
    }

    public AccountProcessingState tierNumber(Integer tierNumber) {
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

    public AccountProcessingState disabled(Boolean disabled) {
        this.disabled = disabled;
        return this;
    }

    /**
     * shows if the processing has been disabled for all the virtual accounts
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
        AccountProcessingState accountProcessingState = (AccountProcessingState) o;
        return Objects.equals(this.disableReason, accountProcessingState.disableReason)
                && Objects.equals(this.processedTo, accountProcessingState.processedTo)
                && Objects.equals(this.processedFrom,
                                  accountProcessingState.processedFrom)
                && Objects.equals(this.tierNumber, accountProcessingState.tierNumber)
                && Objects.equals(this.disabled, accountProcessingState.disabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disableReason, processedTo, processedFrom, tierNumber, disabled);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountProcessingState {\n");

        sb.append("    disableReason: ").append(toIndentedString(disableReason)).append("\n");
        sb.append("    processedTo: ").append(toIndentedString(processedTo)).append("\n");
        sb.append("    processedFrom: ").append(toIndentedString(processedFrom)).append("\n");
        sb.append("    tierNumber: ").append(toIndentedString(tierNumber)).append("\n");
        sb.append("    disabled: ").append(toIndentedString(disabled)).append("\n");
        sb.append("}");
        return sb.toString();
    }



}

