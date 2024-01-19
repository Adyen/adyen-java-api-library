package com.adyen.terminal;

import com.adyen.model.terminal.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Objects;

/**
 * Connected Terminals Response
 */
public class ConnectedTerminalsResponse {

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

    /**
     * Create an instance of ConnectedTerminalsResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ConnectedTerminalsResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to ConnectedTerminalsResponse
     */
    public static ConnectedTerminalsResponse fromJson(String jsonString) throws JsonProcessingException {
        return JSON.getMapper().readValue(jsonString, ConnectedTerminalsResponse.class);
    }

    /**
     * Convert an instance of ConnectedTerminalsResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return JSON.getMapper().writeValueAsString(this);
    }
}
