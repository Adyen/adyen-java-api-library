package com.adyen.serializer;

import java.nio.charset.StandardCharsets;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ser.std.StdSerializer;

public class ByteArraySerializer extends StdSerializer<byte[]> {
  public ByteArraySerializer() {
    super(byte[].class);
  }

  @Override
  public void serialize(
      byte[] bytes, JsonGenerator jsonGenerator, SerializationContext serializationContext)
      throws JacksonException {
    String yourReadableString = new String(bytes, StandardCharsets.UTF_8);
    jsonGenerator.writeString(yourReadableString);
  }
}
