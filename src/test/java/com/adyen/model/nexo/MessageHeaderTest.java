package com.adyen.model.nexo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.adyen.terminal.serialization.TerminalAPIGsonBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class MessageHeaderTest {

  @Test
  public void testShouldSerializeAndDeserializeFromMockFile() throws IOException {
    String mockJson = NexoTestUtils.readResource("mocks/terminal-api/message-header.json");
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    MessageHeader deserializedMessageHeader =
        terminalApiGson.fromJson(mockJson, MessageHeader.class);
    String serializedJson = terminalApiGson.toJson(deserializedMessageHeader);

    JsonObject expectedJsonObject = JsonParser.parseString(mockJson).getAsJsonObject();
    JsonObject serializedJsonObject = JsonParser.parseString(serializedJson).getAsJsonObject();
    assertEquals(expectedJsonObject, serializedJsonObject);

    MessageHeader roundTripMessageHeader =
        terminalApiGson.fromJson(serializedJson, MessageHeader.class);
    assertEquals(
        deserializedMessageHeader.getProtocolVersion(),
        roundTripMessageHeader.getProtocolVersion());
    assertEquals(
        deserializedMessageHeader.getMessageClass(), roundTripMessageHeader.getMessageClass());
    assertEquals(
        deserializedMessageHeader.getMessageCategory(),
        roundTripMessageHeader.getMessageCategory());
    assertEquals(
        deserializedMessageHeader.getMessageType(), roundTripMessageHeader.getMessageType());
    assertEquals(deserializedMessageHeader.getServiceID(), roundTripMessageHeader.getServiceID());
    assertEquals(deserializedMessageHeader.getDeviceID(), roundTripMessageHeader.getDeviceID());
    assertEquals(deserializedMessageHeader.getSaleID(), roundTripMessageHeader.getSaleID());
    assertEquals(deserializedMessageHeader.getPOIID(), roundTripMessageHeader.getPOIID());
  }
}
