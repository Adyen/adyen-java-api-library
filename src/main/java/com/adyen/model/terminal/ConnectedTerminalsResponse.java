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

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Connected Terminals Response
 */
public class ConnectedTerminalsResponse {

    @SerializedName("uniqueTerminalIds")
    private List<String> uniqueTerminalIds;

    public List<String> getUniqueTerminalIds() {
        return uniqueTerminalIds;
    }

    public void setUniqueTerminalIds(List<String> uniqueTerminalIds) {
        this.uniqueTerminalIds = uniqueTerminalIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConnectedTerminalsResponse that = (ConnectedTerminalsResponse) o;
        return Objects.equals(uniqueTerminalIds, that.uniqueTerminalIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueTerminalIds);
    }

    @Override
    public String toString() {
        return "ConnectedTerminalsResponse{" +
                "uniqueTerminalIds=" + uniqueTerminalIds +
                '}';
    }
}
