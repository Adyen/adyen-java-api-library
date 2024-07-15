package com.adyen.service.balanceplatform;

import com.adyen.model.RequestOptions;

public class PaymentInstrumentsRequest {
    private String id;
    private Integer offset;
    private Integer limit;
    private String status;
    private RequestOptions requestOptions;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RequestOptions getRequestOptions() {
        return requestOptions;
    }

    public void setRequestOptions(RequestOptions requestOptions) {
        this.requestOptions = requestOptions;
    }
}
