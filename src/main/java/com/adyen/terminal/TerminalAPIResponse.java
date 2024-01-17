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
 * Terminal API Response
 */
@ApiModel(description = "TerminalAPIResponse")
@JsonPropertyOrder({
        TerminalAPIResponse.JSON_PROPERTY_TERMINAL_RESPONSE,
        TerminalAPIResponse.JSON_PROPERTY_TERMINAL_REQUEST
})
public class TerminalAPIResponse {
    public static final String JSON_PROPERTY_TERMINAL_RESPONSE = "SaleToPOIResponse";
    private com.adyen.terminal.SaleToPOIResponse saleToPOIResponse;

    public static final String JSON_PROPERTY_TERMINAL_REQUEST = "SaleToPOIRequest";
    private com.adyen.terminal.SaleToPOIRequest saleToPOIRequest;

    /**
     * Gets sale to POI response.
     *
     * @return the sale to POI response
     */
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_TERMINAL_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public SaleToPOIResponse getSaleToPOIResponse() {
        return saleToPOIResponse;
    }

    /**
     * Sets sale to POI response.
     *
     * @param saleToPOIResponse the sale to POI response
     */
    @JsonProperty(JSON_PROPERTY_TERMINAL_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSaleToPOIResponse(SaleToPOIResponse saleToPOIResponse) {
        this.saleToPOIResponse = saleToPOIResponse;
    }

    /**
     * Gets sale to POI request.
     *
     * @return the sale to POI request
     */
    @ApiModelProperty(required = false, value = "")
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
        String sb = "class TerminalAPIRequest {\n" +
                "    saleToPOIResponse: " + toIndentedString(saleToPOIResponse) + "\n" +
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
     * Create an instance of TerminalAPIResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of TerminalAPIResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to TerminalAPIResponse
     */
    public static TerminalAPIResponse fromJson(String jsonString) throws JsonProcessingException {
        return JSON.getMapper().readValue(jsonString, TerminalAPIResponse.class);
    }

    /**
     * Convert an instance of TerminalAPIResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return JSON.getMapper().writeValueAsString(this);
    }
}
