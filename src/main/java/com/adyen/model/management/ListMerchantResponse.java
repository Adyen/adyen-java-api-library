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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

public class ListMerchantResponse {
    @SerializedName("_links")
    @JsonProperty("_links")
    private PaginationLinks links = null;

    @SerializedName("data")
    private List<Merchant> data = null;

    @SerializedName("hasNext")
    private Boolean hasNext = null;

    @SerializedName("hasPrevious")
    private Boolean hasPrevious = null;

    @SerializedName("itemsTotal")
    private Integer itemsTotal = null;

    @SerializedName("pagesTotal")
    private Integer pagesTotal = null;

    public ListMerchantResponse links(PaginationLinks links) {
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

    public ListMerchantResponse data(List<Merchant> data) {
        this.data = data;
        return this;
    }

    public ListMerchantResponse addDataItem(Merchant dataItem) {
        if (this.data == null) {
            this.data = new ArrayList<Merchant>();
        }
        this.data.add(dataItem);
        return this;
    }

    /**
     * The list of merchants.
     * @return data
     **/
    public List<Merchant> getData() {
        return data;
    }

    public void setData(List<Merchant> data) {
        this.data = data;
    }

    public ListMerchantResponse hasNext(Boolean hasNext) {
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

    public ListMerchantResponse hasPrevious(Boolean hasPrevious) {
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

    public ListMerchantResponse itemsTotal(Integer itemsTotal) {
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

    public ListMerchantResponse pagesTotal(Integer pagesTotal) {
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
        ListMerchantResponse listMerchantResponse = (ListMerchantResponse) o;
        return Objects.equals(this.links, listMerchantResponse.links) &&
                Objects.equals(this.data, listMerchantResponse.data) &&
                Objects.equals(this.hasNext, listMerchantResponse.hasNext) &&
                Objects.equals(this.hasPrevious, listMerchantResponse.hasPrevious) &&
                Objects.equals(this.itemsTotal, listMerchantResponse.itemsTotal) &&
                Objects.equals(this.pagesTotal, listMerchantResponse.pagesTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(links, data, hasNext, hasPrevious, itemsTotal, pagesTotal);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListMerchantResponse {\n");

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
