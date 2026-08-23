package com.adyen.serializer;

import java.nio.charset.StandardCharsets;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.deser.std.StdDeserializer;

public class ByteArrayDeserializer extends StdDeserializer<byte[]> {
  public ByteArrayDeserializer() {
    super(byte[].class);
  }

  @Override
  public byte[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws JacksonException {
    return jsonParser.getValueAsString().getBytes(StandardCharsets.UTF_8);
  }
}
