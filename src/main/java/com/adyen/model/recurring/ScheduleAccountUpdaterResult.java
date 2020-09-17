/**
 * ######
 * ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 * ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 * ############   ############  #############   ############  #####  ######
 * ######
 * #############
 * ############
 * <p>
 * Adyen Java API Library
 * <p>
 * Copyright (c) 2020 q Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.recurring;

import java.util.Date;
import java.util.Objects;
import com.adyen.util.MaskUtil;
import com.google.gson.annotations.SerializedName;

import static com.adyen.util.Util.toIndentedString;

public class ScheduleAccountUpdaterResult {
    @SerializedName("accountUpdaterAction")
    private String accountUpdaterAction = null;

    @SerializedName("error")
    private Boolean error = null;

    @SerializedName("newAlias")
    private String newAlias = null;

    @SerializedName("newExpiryMonth")
    private String newExpiryMonth = null;

    @SerializedName("newExpiryYear")
    private String newExpiryYear = null;

    @SerializedName("processedDate")
    private Date processedDate = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("result")
    private String result = null;

    public ScheduleAccountUpdaterResult accountUpdaterAction(String accountUpdaterAction) {
        this.accountUpdaterAction = accountUpdaterAction;
        return this;
    }

    public String getAccountUpdaterAction() {
        return accountUpdaterAction;
    }

    public void setAccountUpdaterAction(String accountUpdaterAction) {
        this.accountUpdaterAction = accountUpdaterAction;
    }

    public ScheduleAccountUpdaterResult error(Boolean error) {
        this.error = error;
        return this;
    }

    public Boolean isError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public ScheduleAccountUpdaterResult newAlias(String newAlias) {
        this.newAlias = newAlias;
        return this;
    }

    public String getNewAlias() {
        return newAlias;
    }

    public void setNewAlias(String newAlias) {
        this.newAlias = newAlias;
    }

    public ScheduleAccountUpdaterResult newExpiryMonth(String newExpiryMonth) {
        this.newExpiryMonth = newExpiryMonth;
        return this;
    }

    public String getNewExpiryMonth() {
        return newExpiryMonth;
    }

    public void setNewExpiryMonth(String newExpiryMonth) {
        this.newExpiryMonth = newExpiryMonth;
    }

    public ScheduleAccountUpdaterResult newExpiryYear(String newExpiryYear) {
        this.newExpiryYear = newExpiryYear;
        return this;
    }

    public String getNewExpiryYear() {
        return newExpiryYear;
    }

    public void setNewExpiryYear(String newExpiryYear) {
        this.newExpiryYear = newExpiryYear;
    }

    public ScheduleAccountUpdaterResult processedDate(Date processedDate) {
        this.processedDate = processedDate;
        return this;
    }

    public Date getProcessedDate() {
        return processedDate;
    }

    public void setProcessedDate(Date processedDate) {
        this.processedDate = processedDate;
    }

    public ScheduleAccountUpdaterResult pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public ScheduleAccountUpdaterResult result(String result) {
        this.result = result;
        return this;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ScheduleAccountUpdaterResult scheduleAccountUpdaterResult = (ScheduleAccountUpdaterResult) o;
        return Objects.equals(this.accountUpdaterAction, scheduleAccountUpdaterResult.accountUpdaterAction) &&
                Objects.equals(this.error, scheduleAccountUpdaterResult.error) &&
                Objects.equals(this.newAlias, scheduleAccountUpdaterResult.newAlias) &&
                Objects.equals(this.newExpiryMonth, scheduleAccountUpdaterResult.newExpiryMonth) &&
                Objects.equals(this.newExpiryYear, scheduleAccountUpdaterResult.newExpiryYear) &&
                Objects.equals(this.processedDate, scheduleAccountUpdaterResult.processedDate) &&
                Objects.equals(this.pspReference, scheduleAccountUpdaterResult.pspReference) &&
                Objects.equals(this.result, scheduleAccountUpdaterResult.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountUpdaterAction, error, newAlias, newExpiryMonth, newExpiryYear, processedDate, pspReference, result);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ScheduleAccountUpdaterResult {\n");

        sb.append("    accountUpdaterAction: ").append(toIndentedString(accountUpdaterAction)).append("\n");
        sb.append("    error: ").append(toIndentedString(error)).append("\n");
        sb.append("    newAlias: ").append(toIndentedString(newAlias)).append("\n");
        sb.append("    newExpiryMonth: ").append(MaskUtil.mask(newExpiryMonth)).append("\n");
        sb.append("    newExpiryYear: ").append(MaskUtil.mask(newExpiryYear)).append("\n");
        sb.append("    processedDate: ").append(toIndentedString(processedDate)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    result: ").append(toIndentedString(result)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
