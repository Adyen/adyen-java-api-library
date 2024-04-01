package com.adyen.model.payment;

import jakarta.ws.rs.core.GenericType;

import java.util.HashMap;
import java.util.Map;

public abstract class BankAccountIdentification extends AbstractOpenApiSchema {

    public Map<String, GenericType> schemas = new HashMap<String, GenericType>();

    public BankAccountIdentification(String schemaType, Boolean isNullable, Map<String, GenericType> schemas) {
        super(schemaType, isNullable);
        this.schemas = schemas;
    }

    @Override
    public Map<String, GenericType> getSchemas(){
        return this.schemas;
    }

}
