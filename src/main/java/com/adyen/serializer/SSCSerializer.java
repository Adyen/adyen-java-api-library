package com.adyen.serializer;

import com.adyen.model.nexo.SSC;
import com.google.gson.*;

import java.lang.reflect.Type;

public class SSCSerializer implements JsonSerializer<SSC>, JsonDeserializer<SSC> {

    public JsonElement serialize(SSC sscSerializeObject, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(sscSerializeObject.toBase64());
    }

    public SSC deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        SSC sscDeserializeObject = new SSC();
        return sscDeserializeObject.fromBase64(json.getAsString().getBytes());
    }
}

