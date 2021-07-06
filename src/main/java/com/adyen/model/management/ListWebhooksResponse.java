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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.management;

import com.adyen.model.management.links.PaginationLinks;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

public class ListWebhooksResponse {
    @SerializedName("_links")
    @JsonProperty("_links")
    private PaginationLinks links = null;

    @SerializedName("data")
    private List<Webhook> data = null;

    @SerializedName("hasNext")
    private Boolean hasNext = null;

    @SerializedName("hasPrevious")
    private Boolean hasPrevious = null;

    @SerializedName("itemsTotal")
    private Integer itemsTotal = null;

    @SerializedName("pagesTotal")
    private Integer pagesTotal = null;

    public ListWebhooksResponse links(PaginationLinks links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     * @return links
     **/
    public PaginationLinks getLinks() {
        return links;
    }

    public void setLinks(PaginationLinks links) {
        this.links = links;
    }

    public ListWebhooksResponse data(List<Webhook> data) {
        this.data = data;
        return this;
    }

    public ListWebhooksResponse addDataItem(Webhook dataItem) {
        if (this.data == null) {
            this.data = new ArrayList<Webhook>();
        }
        this.data.add(dataItem);
        return this;
    }

    /**
     * The list of webhooks configured for this account.
     * @return data
     **/
    public List<Webhook> getData() {
        return data;
    }

    public void setData(List<Webhook> data) {
        this.data = data;
    }

    public ListWebhooksResponse hasNext(Boolean hasNext) {
        this.hasNext = hasNext;
        return this;
    }

    /**
     * Indicates if there are more items in the next page.
     * @return hasNext
     **/
    public Boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public ListWebhooksResponse hasPrevious(Boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
        return this;
    }

    /**
     * Indicates if there are more items in the previous page.
     * @return hasPrevious
     **/
    public Boolean isHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(Boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public ListWebhooksResponse itemsTotal(Integer itemsTotal) {
        this.itemsTotal = itemsTotal;
        return this;
    }

    /**
     * Total number of items.
     * @return itemsTotal
     **/
    public Integer getItemsTotal() {
        return itemsTotal;
    }

    public void setItemsTotal(Integer itemsTotal) {
        this.itemsTotal = itemsTotal;
    }

    public ListWebhooksResponse pagesTotal(Integer pagesTotal) {
        this.pagesTotal = pagesTotal;
        return this;
    }

    /**
     * Total number of pages.
     * @return pagesTotal
     **/
    public Integer getPagesTotal() {
        return pagesTotal;
    }

    public void setPagesTotal(Integer pagesTotal) {
        this.pagesTotal = pagesTotal;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListWebhooksResponse listWebhooksResponse = (ListWebhooksResponse) o;
        return Objects.equals(this.links, listWebhooksResponse.links) &&
                Objects.equals(this.data, listWebhooksResponse.data) &&
                Objects.equals(this.hasNext, listWebhooksResponse.hasNext) &&
                Objects.equals(this.hasPrevious, listWebhooksResponse.hasPrevious) &&
                Objects.equals(this.itemsTotal, listWebhooksResponse.itemsTotal) &&
                Objects.equals(this.pagesTotal, listWebhooksResponse.pagesTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(links, data, hasNext, hasPrevious, itemsTotal, pagesTotal);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListWebhooksResponse {\n");

        sb.append("    links: ").append(toIndentedString(links)).append("\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    hasNext: ").append(toIndentedString(hasNext)).append("\n");
        sb.append("    hasPrevious: ").append(toIndentedString(hasPrevious)).append("\n");
        sb.append("    itemsTotal: ").append(toIndentedString(itemsTotal)).append("\n");
        sb.append("    pagesTotal: ").append(toIndentedString(pagesTotal)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}

