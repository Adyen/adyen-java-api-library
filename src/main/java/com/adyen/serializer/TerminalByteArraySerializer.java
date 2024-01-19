package com.adyen.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Base64;

public class TerminalByteArraySerializer extends StdSerializer<byte[]> {
    public TerminalByteArraySerializer() {
        super(byte[].class);
    }

    @Override
    public void serialize(byte[] bytes, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String yourReadableString = Base64.getEncoder().encodeToString(bytes);
        jsonGenerator.writeString(yourReadableString);
    }
}
