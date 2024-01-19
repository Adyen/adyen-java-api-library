package com.adyen.terminal;

import com.adyen.model.terminal.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Objects;

/**
 * Connected Terminals Request
 */
public class ConnectedTerminalsRequest {

    private String merchantAccount;

    private String store;

    private String uniqueTerminalId;

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getUniqueTerminalId() {
        return uniqueTerminalId;
    }

    public void setUniqueTerminalId(String uniqueTerminalId) {
        this.uniqueTerminalId = uniqueTerminalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConnectedTerminalsRequest that = (ConnectedTerminalsRequest) o;
        return Objects.equals(merchantAccount, that.merchantAccount) &&
                Objects.equals(store, that.store) &&
                Objects.equals(uniqueTerminalId, that.uniqueTerminalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchantAccount, store, uniqueTerminalId);
    }

    @Override
    public String toString() {
        return "ConnectedTerminalsRequest{" +
                "merchantAccount='" + merchantAccount + '\'' +
                ", store='" + store + '\'' +
                ", uniqueTerminalId='" + uniqueTerminalId + '\'' +
                '}';
    }

    /**
     * Create an instance of ConnectedTerminalsRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ConnectedTerminalsRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to ConnectedTerminalsRequest
     */
    public static ConnectedTerminalsRequest fromJson(String jsonString) throws JsonProcessingException {
        return JSON.getMapper().readValue(jsonString, ConnectedTerminalsRequest.class);
    }

    /**
     * Convert an instance of ConnectedTerminalsRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return JSON.getMapper().writeValueAsString(this);
    }
}
