package com.adyen.model;

public class RequestOptions {

    private String idempotencyKey;
    private String requestedVerificationCodeHeader;

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

}
