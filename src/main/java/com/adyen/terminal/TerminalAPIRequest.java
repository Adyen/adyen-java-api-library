package com.adyen.terminal;

import com.adyen.model.terminal.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Terminal API Request
 */
@ApiModel(description = "TerminalAPIRequest")
@JsonPropertyOrder({
        TerminalAPIRequest.JSON_PROPERTY_TERMINAL_REQUEST
})
public class TerminalAPIRequest {
    public static final String JSON_PROPERTY_TERMINAL_REQUEST = "SaleToPOIRequest";
    private SaleToPOIRequest saleToPOIRequest;

    /**
     * Gets sale to POI request.
     *
     * @return the sale to POI request
     */
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_TERMINAL_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public SaleToPOIRequest getSaleToPOIRequest() {
        return saleToPOIRequest;
    }

    /**
     * Sets sale to POI request.
     *
     * @param saleToPOIRequest the sale to POI request
     */
    @JsonProperty(JSON_PROPERTY_TERMINAL_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSaleToPOIRequest(SaleToPOIRequest saleToPOIRequest) {
        this.saleToPOIRequest = saleToPOIRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TerminalAPIRequest that = (TerminalAPIRequest) o;
        return saleToPOIRequest.equals(that.saleToPOIRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleToPOIRequest);
    }

    @Override
    public String toString() {
        String sb = "class TerminalAPIRequest {\n" +
                "    saleToPOIRequest: " + toIndentedString(saleToPOIRequest) + "\n" +
                "}";
        return sb;
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

    /**
     * Create an instance of TerminalAPIRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of TerminalAPIRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to TerminalAPIRequest
     */
    public static TerminalAPIRequest fromJson(String jsonString) throws JsonProcessingException {
        return JSON.getMapper().readValue(jsonString, TerminalAPIRequest.class);
    }

    /**
     * Convert an instance of TerminalAPIRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return JSON.getMapper().writeValueAsString(this);
    }
}
