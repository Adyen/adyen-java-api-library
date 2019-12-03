package com.adyen.serializer;

import com.adyen.model.terminal.SaleToAcquirerDataModel;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class SaleToAcquirerDataModelAdapterSerializer implements JsonSerializer<SaleToAcquirerDataModel> {

    public JsonElement serialize(SaleToAcquirerDataModel saleToAcquirerDataModel, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(saleToAcquirerDataModel.toBase64());
    }
}
