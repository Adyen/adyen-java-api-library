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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.terminal;

import com.adyen.model.nexo.SaleToPOIRequest;
import com.adyen.model.nexo.SaleToPOIResponse;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Terminal API Response
 */
public class TerminalAPIResponse {
    @SerializedName("SaleToPOIResponse")
    private SaleToPOIResponse saleToPOIResponse;

    @SerializedName("SaleToPOIRequest")
    private SaleToPOIRequest saleToPOIRequest;

    /**
     * Gets sale to POI request.
     *
     * @return the sale to POI request
     */
    public SaleToPOIRequest getSaleToPOIRequest() {
        return saleToPOIRequest;
    }

    /**
     * Sets sale to POI request.
     *
     * @param saleToPOIRequest the sale to POI request
     */
    public void setSaleToPOIRequest(SaleToPOIRequest saleToPOIRequest) {
        this.saleToPOIRequest = saleToPOIRequest;
    }

    /**
     * Gets sale to POI response.
     *
     * @return the sale to POI response
     */
    public SaleToPOIResponse getSaleToPOIResponse() {
        return saleToPOIResponse;
    }

    /**
     * Sets sale to POI response.
     *
     * @param saleToPOIResponse the sale to POI response
     */
    public void setSaleToPOIResponse(SaleToPOIResponse saleToPOIResponse) {
        this.saleToPOIResponse = saleToPOIResponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TerminalAPIResponse response = (TerminalAPIResponse) o;
        return Objects.equals(saleToPOIResponse, response.saleToPOIResponse) &&
                Objects.equals(saleToPOIRequest, response.saleToPOIRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleToPOIResponse, saleToPOIRequest);
    }

    @Override
    public String toString() {
        return "TerminalAPIResponse{" +
                "saleToPOIResponse=" + saleToPOIResponse +
                ", saleToPOIRequest=" + saleToPOIRequest +
                '}';
    }
}
