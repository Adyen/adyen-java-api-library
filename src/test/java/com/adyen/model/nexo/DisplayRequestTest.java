package com.adyen.model.nexo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.adyen.terminal.serialization.TerminalAPIGsonBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class DisplayRequestTest {

  @Test
  public void testShouldSerializeAndDeserializeFromMockFile() throws IOException {
    String mockJson = NexoTestUtils.readResource("mocks/terminal-api/display-request.json");
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    DisplayRequest deserializedDisplayRequest =
        terminalApiGson.fromJson(mockJson, DisplayRequest.class);
    assertEquals(1, deserializedDisplayRequest.getDisplayOutput().size());
    assertEquals(
        DeviceType.CUSTOMER_DISPLAY,
        deserializedDisplayRequest.getDisplayOutput().get(0).getDevice());
    assertEquals(
        InfoQualifyType.DISPLAY,
        deserializedDisplayRequest.getDisplayOutput().get(0).getInfoQualify());
    assertEquals(
        OutputFormatType.TEXT,
        deserializedDisplayRequest.getDisplayOutput().get(0).getOutputContent().getOutputFormat());
    assertEquals(
        "Please present card",
        deserializedDisplayRequest
            .getDisplayOutput()
            .get(0)
            .getOutputContent()
            .getOutputText()
            .get(0)
            .getText());

    String serializedJson = terminalApiGson.toJson(deserializedDisplayRequest);

    JsonObject expectedJsonObject = JsonParser.parseString(mockJson).getAsJsonObject();
    JsonObject serializedJsonObject = JsonParser.parseString(serializedJson).getAsJsonObject();
    assertEquals(expectedJsonObject, serializedJsonObject);

    DisplayRequest roundTripDisplayRequest =
        terminalApiGson.fromJson(serializedJson, DisplayRequest.class);
    assertEquals(
        "Please present card",
        roundTripDisplayRequest
            .getDisplayOutput()
            .get(0)
            .getOutputContent()
            .getOutputText()
            .get(0)
            .getText());
  }
}
