package com.adyen.terminal.security;

import com.adyen.model.terminal.JSON;
import com.adyen.model.terminal.MessageHeader;
import com.adyen.model.terminal.SecurityTrailer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@ApiModel(description = "SaleToPOISecuredMessage")
@JsonPropertyOrder({
        SaleToPOISecuredMessage.JSON_PROPERTY_MESSAGE_HEADER,
        SaleToPOISecuredMessage.JSON_PROPERTY_NEXO_BLOB,
        SaleToPOISecuredMessage.JSON_PROPERTY_SECURITY_TRAILER
})
public class SaleToPOISecuredMessage {
    public static final String JSON_PROPERTY_MESSAGE_HEADER = "MessageHeader";
    private MessageHeader messageHeader;

    public static final String JSON_PROPERTY_NEXO_BLOB = "NexoBlob";
    private String nexoBlob;

    public static final String JSON_PROPERTY_SECURITY_TRAILER = "SecurityTrailer";
    private SecurityTrailer securityTrailer;

    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_MESSAGE_HEADER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE_HEADER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMessageHeader(MessageHeader messageHeader) {
        this.messageHeader = messageHeader;
    }

    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_NEXO_BLOB)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getNexoBlob() {
        return nexoBlob;
    }

    @JsonProperty(JSON_PROPERTY_NEXO_BLOB)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setNexoBlob(String nexoBlob) {
        this.nexoBlob = nexoBlob;
    }

    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_SECURITY_TRAILER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public SecurityTrailer getSecurityTrailer() {
        return securityTrailer;
    }

    @JsonProperty(JSON_PROPERTY_SECURITY_TRAILER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSecurityTrailer(SecurityTrailer securityTrailer) {
        this.securityTrailer = securityTrailer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SaleToPOISecuredMessage that = (SaleToPOISecuredMessage) o;
        return messageHeader.equals(that.messageHeader) &&
                nexoBlob.equals(that.nexoBlob) &&
                securityTrailer.equals(that.securityTrailer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageHeader, nexoBlob, securityTrailer);
    }

    @Override
    public String toString() {
        return "SaleToPOISecuredMessage{" +
                "messageHeader=" + messageHeader +
                ", nexoBlob='" + nexoBlob + '\'' +
                ", securityTrailer=" + securityTrailer +
                '}';
    }

    /**
     * Create an instance of SaleToPOISecuredMessage given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of SaleToPOISecuredMessage
     * @throws JsonProcessingException if the JSON string is invalid with respect to SaleToPOISecuredMessage
     */
    public static SaleToPOISecuredMessage fromJson(String jsonString) throws JsonProcessingException {
        return JSON.getMapper().readValue(jsonString, SaleToPOISecuredMessage.class);
    }

    /**
     * Convert an instance of SaleToPOISecuredMessage to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return JSON.getMapper().writeValueAsString(this);
    }
}
