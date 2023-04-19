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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.posterminalmanagement;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * FindTerminalRequest
 */

public class FindTerminalRequest {
    @SerializedName("terminal")
    private String terminal = null;

    public FindTerminalRequest terminal(String terminal) {
        this.terminal = terminal;
        return this;
    }

    /**
     * The unique terminal ID in the format &#x60;[Device model]-[Serial number]&#x60;.   For example, **V400m-324689776**.
     *
     * @return terminal
     **/
    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FindTerminalRequest findTerminalRequest = (FindTerminalRequest) o;
        return Objects.equals(this.terminal, findTerminalRequest.terminal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(terminal);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FindTerminalRequest {\n");

        sb.append("    terminal: ").append(toIndentedString(terminal)).append("\n");
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
