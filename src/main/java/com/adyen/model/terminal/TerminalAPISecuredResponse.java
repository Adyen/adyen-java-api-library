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

import com.adyen.model.terminal.security.SaleToPOISecuredMessage;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Terminal API Secured Response
 */
public class TerminalAPISecuredResponse {
    @SerializedName("SaleToPOIResponse")
    private SaleToPOISecuredMessage saleToPOIResponse;

    /**
     * Gets sale to POI response.
     *
     * @return the sale to POI response
     */
    public SaleToPOISecuredMessage getSaleToPOIResponse() {
        return saleToPOIResponse;
    }

    /**
     * Sets sale to POI response.
     *
     * @param saleToPOIResponse the sale to POI response
     */
    public void setSaleToPOIResponse(SaleToPOISecuredMessage saleToPOIResponse) {
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
        TerminalAPISecuredResponse that = (TerminalAPISecuredResponse) o;
        return Objects.equals(saleToPOIResponse, that.saleToPOIResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleToPOIResponse);
    }

    @Override
    public String toString() {
        return "TerminalAPISecuredResponse{" +
                "saleToPOIResponse=" + saleToPOIResponse +
                '}';
    }
}
