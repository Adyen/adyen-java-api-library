package com.adyen.terminal.security;

import com.adyen.model.terminal.JSON;
import com.adyen.serializer.TerminalByteArraySerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Terminal API Secured Request
 */
@ApiModel(description = "TerminalAPISecuredRequest")
@JsonPropertyOrder({
        TerminalAPISecuredRequest.JSON_PROPERTY_TERMINAL_REQUEST
})
public class TerminalAPISecuredRequest {
    public static final String JSON_PROPERTY_TERMINAL_REQUEST = "SaleToPOIRequest";
    private SaleToPOISecuredMessage saleToPOIRequest;


    /**
     * Gets sale to POI request.
     *
     * @return the sale to POI request
     */
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_TERMINAL_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public SaleToPOISecuredMessage getSaleToPOIRequest() {
        return saleToPOIRequest;
    }

    /**
     * Sets sale to POI request.
     *
     * @param saleToPOIRequest the sale to POI request
     */
    @JsonProperty(JSON_PROPERTY_TERMINAL_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSaleToPOIRequest(SaleToPOISecuredMessage saleToPOIRequest) {
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
        TerminalAPISecuredRequest that = (TerminalAPISecuredRequest) o;
        return saleToPOIRequest.equals(that.saleToPOIRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleToPOIRequest);
    }

    @Override
    public String toString() {
        return "TerminalAPISecuredRequest{" +
                "saleToPOIRequest=" + saleToPOIRequest +
                '}';
    }

    /**
     * Create an instance of TerminalAPISecuredRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of TerminalAPISecuredRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to TerminalAPISecuredRequest
     */
    public static TerminalAPISecuredRequest fromJson(String jsonString) throws JsonProcessingException {
        return JSON.getMapper().readValue(jsonString, TerminalAPISecuredRequest.class);
    }

    /**
     * Convert an instance of TerminalAPISecuredRequest to an JSON string
     * WARNING: this serializer uses a custom byte array deserializer for encryption
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(byte[].class, new TerminalByteArraySerializer());

        return JSON.getMapper().registerModule(simpleModule).writeValueAsString(this);
    }
}
