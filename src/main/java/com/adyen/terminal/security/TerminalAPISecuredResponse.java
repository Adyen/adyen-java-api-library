package com.adyen.terminal.security;

import com.adyen.model.terminal.JSON;
import com.adyen.serializer.TerminalByteArrayDeserializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Terminal API Secured Response
 */
@ApiModel(description = "TerminalAPISecuredResponse")
@JsonPropertyOrder({
        TerminalAPISecuredResponse.JSON_PROPERTY_TERMINAL_RESPONSE
})
public class TerminalAPISecuredResponse {
    public static final String JSON_PROPERTY_TERMINAL_RESPONSE = "SaleToPOIResponse";
    private SaleToPOISecuredMessage saleToPOIResponse;

    /**
     * Gets sale to POI response.
     *
     * @return the sale to POI response
     */
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_TERMINAL_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public SaleToPOISecuredMessage getSaleToPOIResponse() {
        return saleToPOIResponse;
    }

    /**
     * Sets sale to POI response.
     *
     * @param saleToPOIResponse the sale to POI response
     */
    @JsonProperty(JSON_PROPERTY_TERMINAL_RESPONSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
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


    /**
     * Create an instance of TerminalAPISecuredResponse given an JSON string
     *
     * WARNING: this deserializer uses a custom byte array deserializer for encryption
     *
     * @param jsonString JSON string
     * @return An instance of TerminalAPISecuredResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to TerminalAPISecuredResponse
     */
    public static TerminalAPISecuredResponse fromJson(String jsonString) throws JsonProcessingException {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(byte[].class, new TerminalByteArrayDeserializer());
        return JSON.getMapper().registerModule(simpleModule).readValue(jsonString, TerminalAPISecuredResponse.class);
    }

    /**
     * Convert an instance of TerminalAPISecuredResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return JSON.getMapper().writeValueAsString(this);
    }
}
