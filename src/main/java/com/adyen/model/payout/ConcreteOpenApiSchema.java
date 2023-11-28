package com.adyen.model.payout;

import java.util.Map;
import jakarta.ws.rs.core.GenericType;

public class ConcreteOpenApiSchema extends AbstractOpenApiSchema {
    private Object actualInstance;
    public ConcreteOpenApiSchema(Object actualInstance, String schemaType, Boolean isNullable) {
        super(schemaType, isNullable);
        this.actualInstance = actualInstance;
    }
    @Override
    public Map<String, GenericType> getSchemas() {
        return null;
    }
    @Override
    public Object getActualInstance() {
        return actualInstance;
    }
}