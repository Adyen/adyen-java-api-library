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

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

public class PaginationLinks {
    @SerializedName("first")
    private LinksElement first = null;

    @SerializedName("last")
    private LinksElement last = null;

    @SerializedName("next")
    private LinksElement next = null;

    @SerializedName("prev")
    private LinksElement prev = null;

    @SerializedName("self")
    private LinksElement self = null;

    public PaginationLinks first(LinksElement first) {
        this.first = first;
        return this;
    }

    /**
     * Get first
     * @return first
     **/
    public LinksElement getFirst() {
        return first;
    }

    public void setFirst(LinksElement first) {
        this.first = first;
    }

    public PaginationLinks last(LinksElement last) {
        this.last = last;
        return this;
    }

    /**
     * Get last
     * @return last
     **/
    public LinksElement getLast() {
        return last;
    }

    public void setLast(LinksElement last) {
        this.last = last;
    }

    public PaginationLinks next(LinksElement next) {
        this.next = next;
        return this;
    }

    /**
     * Get next
     * @return next
     **/
    public LinksElement getNext() {
        return next;
    }

    public void setNext(LinksElement next) {
        this.next = next;
    }

    public PaginationLinks prev(LinksElement prev) {
        this.prev = prev;
        return this;
    }

    /**
     * Get prev
     * @return prev
     **/
    public LinksElement getPrev() {
        return prev;
    }

    public void setPrev(LinksElement prev) {
        this.prev = prev;
    }

    public PaginationLinks self(LinksElement self) {
        this.self = self;
        return this;
    }

    /**
     * Get self
     * @return self
     **/
    public LinksElement getSelf() {
        return self;
    }

    public void setSelf(LinksElement self) {
        this.self = self;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaginationLinks paginationLinks = (PaginationLinks) o;
        return Objects.equals(this.first, paginationLinks.first) &&
                Objects.equals(this.last, paginationLinks.last) &&
                Objects.equals(this.next, paginationLinks.next) &&
                Objects.equals(this.prev, paginationLinks.prev) &&
                Objects.equals(this.self, paginationLinks.self);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last, next, prev, self);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaginationLinks {\n");

        sb.append("    first: ").append(toIndentedString(first)).append("\n");
        sb.append("    last: ").append(toIndentedString(last)).append("\n");
        sb.append("    next: ").append(toIndentedString(next)).append("\n");
        sb.append("    prev: ").append(toIndentedString(prev)).append("\n");
        sb.append("    self: ").append(toIndentedString(self)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
