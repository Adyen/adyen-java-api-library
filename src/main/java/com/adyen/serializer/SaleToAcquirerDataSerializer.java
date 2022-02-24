package com.adyen.serializer;

import com.adyen.model.terminal.SaleToAcquirerData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class SaleToAcquirerDataSerializer implements JsonSerializer<SaleToAcquirerData> {

    public JsonElement serialize(SaleToAcquirerData saleToAcquirerData, Type typeOfSrc, JsonSerializationContext context) {
        try {
            return new JsonPrimitive(saleToAcquirerData.toBase64());
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
