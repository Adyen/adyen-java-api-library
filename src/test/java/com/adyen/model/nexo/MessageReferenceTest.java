package com.adyen.model.nexo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.adyen.terminal.serialization.TerminalAPIGsonBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class MessageReferenceTest {

  @Test
  public void testShouldSerializeAndDeserializeFromMockFile() throws IOException {
    String mockJson = NexoTestUtils.readResource("mocks/terminal-api/message-reference.json");
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    MessageReference deserializedMessageReference =
        terminalApiGson.fromJson(mockJson, MessageReference.class);
    assertEquals(MessageCategoryType.PAYMENT, deserializedMessageReference.getMessageCategory());
    assertEquals("service-id", deserializedMessageReference.getServiceID());
    assertEquals("device-id", deserializedMessageReference.getDeviceID());
    assertEquals("sale-id", deserializedMessageReference.getSaleID());
    assertEquals("poi-id", deserializedMessageReference.getPOIID());

    String serializedJson = terminalApiGson.toJson(deserializedMessageReference);

    JsonObject expectedJsonObject = JsonParser.parseString(mockJson).getAsJsonObject();
    JsonObject serializedJsonObject = JsonParser.parseString(serializedJson).getAsJsonObject();
    assertEquals(expectedJsonObject, serializedJsonObject);

    MessageReference roundTripMessageReference =
        terminalApiGson.fromJson(serializedJson, MessageReference.class);
    assertEquals(
        deserializedMessageReference.getMessageCategory(),
        roundTripMessageReference.getMessageCategory());
    assertEquals(
        deserializedMessageReference.getServiceID(), roundTripMessageReference.getServiceID());
    assertEquals(
        deserializedMessageReference.getDeviceID(), roundTripMessageReference.getDeviceID());
    assertEquals(deserializedMessageReference.getSaleID(), roundTripMessageReference.getSaleID());
    assertEquals(deserializedMessageReference.getPOIID(), roundTripMessageReference.getPOIID());
  }
}
