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

import java.util.HashMap;
import java.util.Map;

/**
 * AssignTerminalsResponse
 */

public class AssignTerminalsResponse {
    @SerializedName("results")
    private Map<String, String> results = new HashMap<String, String>();

    public AssignTerminalsResponse results(Map<String, String> results) {
        this.results = results;
        return this;
    }

    public AssignTerminalsResponse putResultsItem(String key, String resultsItem) {
        this.results.put(key, resultsItem);
        return this;
    }

    /**
     * Array that returns a list of the terminals, and for each terminal the result of assigning it to an account or store.  The results can be:    - &#x60;Done&#x60;: The terminal has been assigned.   - &#x60;AssignmentScheduled&#x60;: The terminal will be assigned asynschronously.   - &#x60;RemoveConfigScheduled&#x60;: The terminal was previously assigned and boarded. Wait for the terminal to synchronize with the Adyen platform. For more information, refer to [Reassigning boarded terminals](https://docs.adyen.com/point-of-sale/managing-terminals/assign-terminals#reassign-boarded-terminals).   - &#x60;Error&#x60;: There was an error when assigning the terminal.
     *
     * @return results
     **/
    public Map<String, String> getResults() {
        return results;
    }

    public void setResults(Map<String, String> results) {
        this.results = results;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AssignTerminalsResponse assignTerminalsResponse = (AssignTerminalsResponse) o;
        return Objects.equals(this.results, assignTerminalsResponse.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssignTerminalsResponse {\n");

        sb.append("    results: ").append(toIndentedString(results)).append("\n");
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
