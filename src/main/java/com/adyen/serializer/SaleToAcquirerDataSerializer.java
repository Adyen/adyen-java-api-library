package com.adyen.serializer;

import java.lang.reflect.Type;

import com.adyen.model.terminal.SaleToAcquirerData;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class SaleToAcquirerDataSerializer implements
        JsonSerializer<SaleToAcquirerData>,
        JsonDeserializer<SaleToAcquirerData> {

    @Override
    public JsonElement serialize(SaleToAcquirerData saleToAcquirerData, Type typeOfSrc,
            JsonSerializationContext context) {
        return new JsonPrimitive(saleToAcquirerData.toBase64());
    }

    @Override
    public SaleToAcquirerData deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        return SaleToAcquirerData.fromBase64(json.getAsString());
    }
}
