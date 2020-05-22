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
package com.adyen.model.recurring;

import com.adyen.constants.TextConstants;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * DisableResult
 */
public class DisableResult {
    @SerializedName("response")
    private String response = null;

    @SerializedName("details")
    private List<RecurringDetail> details = new ArrayList<>();

    public DisableResult response(String response) {
        this.response = response;
        return this;
    }

    /**
     * Depending on whether a specific recurring detail was in the request, result is either [detail-successfully-disabled] or [all-details-successfully-disabled]
     *
     * @return response
     **/
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public DisableResult details(List<RecurringDetail> details) {
        this.details = details;
        return this;
    }

    public DisableResult addDetailsItem(RecurringDetail detailsItem) {
        this.details.add(detailsItem);
        return this;
    }

    /**
     * a list of one or more recurring payment details that were disabled
     *
     * @return details
     **/
    public List<RecurringDetail> getDetails() {
        return details;
    }

    public void setDetails(List<RecurringDetail> details) {
        this.details = details;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        DisableResult disableResult = (DisableResult) o;
        return Objects.equals(this.response, disableResult.response) && Objects.equals(this.details, disableResult.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(response, details);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DisableResult {").append(TextConstants.LINE_BREAK);

        sb.append("    response: ").append(toIndentedString(response)).append(TextConstants.LINE_BREAK);
        sb.append("    details: ").append(toIndentedString(details)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }



}

