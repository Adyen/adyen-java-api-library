package com.adyen.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ByteArraySerializer extends StdSerializer<byte[]> {
    public ByteArraySerializer() {
        super(byte[].class);
    }

    @Override
    public void serialize(byte[] bytes, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String yourReadableString = new String(bytes);
        jsonGenerator.writeString(yourReadableString);
    }
}