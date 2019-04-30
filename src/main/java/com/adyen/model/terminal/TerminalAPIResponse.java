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

import com.adyen.model.nexo.SaleToPOIResponse;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Terminal API Response
 */
public class TerminalAPIResponse {
    @SerializedName("SaleToPOIResponse")
    private SaleToPOIResponse saleToPOIResponse;

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
        TerminalAPIResponse that = (TerminalAPIResponse) o;
        return Objects.equals(saleToPOIResponse, that.saleToPOIResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleToPOIResponse);
    }

    @Override
    public String toString() {
        return "TerminalAPIResponse{" +
                "saleToPOIResponse=" + saleToPOIResponse +
                '}';
    }
}
