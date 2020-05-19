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
package com.adyen.model.recurring;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * RecurringDetailsResult
 */
public class RecurringDetailsResult {
    @SerializedName("creationDate")
    private Date creationDate = null;

    @SerializedName("shopperReference")
    private String shopperReference = null;

    @SerializedName("details")
    private List<RecurringDetailContainer> details = new ArrayList<>();

    @SerializedName("lastKnownShopperEmail")
    private String lastKnownShopperEmail = null;

    @SerializedName("invalidOneclickContracts")
    private String invalidOneClickContracts = null;

    public RecurringDetailsResult creationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    /**
     * the creation date when the shopper record was created
     *
     * @return creationDate
     **/
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public RecurringDetailsResult shopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
        return this;
    }

    /**
     * the reference you use to uniquely identify the shopper (e.g. user ID or account ID)
     *
     * @return shopperReference
     **/
    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    public RecurringDetailsResult details(List<RecurringDetailContainer> details) {
        this.details = details;
        return this;
    }

    public RecurringDetailsResult addDetailsItem(RecurringDetailContainer detailsItem) {
        this.details.add(detailsItem);
        return this;
    }

    /**
     * a list of one or more recurring payment details
     *
     * @return details
     **/
    public List<RecurringDetailContainer> getDetails() {
        return details;
    }

    public void setDetails(List<RecurringDetailContainer> details) {
        this.details = details;
    }

    public RecurringDetailsResult lastKnownShopperEmail(String lastKnownShopperEmail) {
        this.lastKnownShopperEmail = lastKnownShopperEmail;
        return this;
    }

    /**
     * the most recent email for this shopper (if available)
     *
     * @return lastKnownShopperEmail
     **/
    public String getLastKnownShopperEmail() {
        return lastKnownShopperEmail;
    }

    public void setLastKnownShopperEmail(String lastKnownShopperEmail) {
        this.lastKnownShopperEmail = lastKnownShopperEmail;
    }

    public RecurringDetailsResult invalidOneClickContracts(String invalidOneClickContracts) {
        this.invalidOneClickContracts = invalidOneClickContracts;
        return this;
    }

    public String getInvalidOneClickContracts() {
        return invalidOneClickContracts;
    }

    public void setInvalidOneClickContracts(String invalidOneClickContracts) {
        this.invalidOneClickContracts = invalidOneClickContracts;
    }

    /**
     * Return RecurringDetails
     *
     * @return RecurringDetails
     */
    public List<RecurringDetail> getRecurringDetails() {
        return details.stream().map(s -> s.getRecurringDetail()).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RecurringDetailsResult recurringDetailsResult = (RecurringDetailsResult) o;
        return Objects.equals(this.creationDate, recurringDetailsResult.creationDate) &&
                Objects.equals(this.shopperReference, recurringDetailsResult.shopperReference) &&
                Objects.equals(this.details, recurringDetailsResult.details) &&
                Objects.equals(this.lastKnownShopperEmail, recurringDetailsResult.lastKnownShopperEmail) &&
                Objects.equals(this.invalidOneClickContracts, recurringDetailsResult.invalidOneClickContracts);

    }

    @Override
    public int hashCode() {
        return Objects.hash(creationDate, shopperReference, details, lastKnownShopperEmail);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RecurringDetailsResult {\n");

        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    shopperReference: ").append(toIndentedString(shopperReference)).append("\n");
        sb.append("    details: ").append(toIndentedString(details)).append("\n");
        sb.append("    lastKnownShopperEmail: ").append(toIndentedString(lastKnownShopperEmail)).append("\n");
        sb.append("    invalidOneClickContracts: ").append(toIndentedString(invalidOneClickContracts)).append("\n");
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

