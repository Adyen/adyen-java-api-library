package com.adyen.model;

import java.util.HashMap;

public class RequestOptions {
    private String idempotencyKey;
    private String requestedVerificationCodeHeader;
    private HashMap<String, String> additionalServiceHeaders;
    public RequestOptions idempotencyKey(String idempotencyKey){
        this.idempotencyKey = idempotencyKey;
        return this;
    }
    public RequestOptions requestedVerificationCodeHeader(String requestedVerificationCodeHeader){
        this.requestedVerificationCodeHeader = requestedVerificationCodeHeader;
        return this;
    }
    public RequestOptions additionalServiceHeaders(HashMap<String, String> additionalServiceHeaders){
        this.additionalServiceHeaders = additionalServiceHeaders;
        return this;
    }
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public void setIdempotencyKey(String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    public String getRequestedVerificationCodeHeader() {
        return requestedVerificationCodeHeader;
    }

    public void setRequestedVerificationCodeHeader(String requestedVerificationCodeHeader) {
        this.requestedVerificationCodeHeader = requestedVerificationCodeHeader;
    }

    public HashMap<String, String> getAdditionalServiceHeaders() {
        return additionalServiceHeaders;
    }

    public void setAdditionalServiceHeaders(HashMap<String, String> additionalServiceHeaders) {
        this.additionalServiceHeaders = additionalServiceHeaders;
    }
    @Override
    public String toString() {
        return "RequestOptions{" +
                "idempotencyKey='" + idempotencyKey + '\'' +
                ", requestedVerificationCodeHeader='" + requestedVerificationCodeHeader + '\'' +
                ", additionalServiceHeaders=" + additionalServiceHeaders +
                '}';
    }
}
