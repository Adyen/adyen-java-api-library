package com.adyen.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class TerminalByteArrayDeserializer extends StdDeserializer<byte[]> {
    public TerminalByteArrayDeserializer() {
        super(byte[].class);
    }

    @Override
    public byte[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return Base64.getDecoder().decode(jsonParser.getValueAsString().getBytes(StandardCharsets.UTF_8));
    }
}