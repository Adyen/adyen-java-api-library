package com.adyen.model.nexo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.adyen.terminal.serialization.TerminalAPIGsonBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class AbortRequestTest {

  @Test
  public void testShouldSerializeAndDeserializeFromMockFile() throws IOException {
    String mockJson = NexoTestUtils.readResource("mocks/terminal-api/abort-request.json");
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    AbortRequest deserializedAbortRequest = terminalApiGson.fromJson(mockJson, AbortRequest.class);
    assertEquals("cancelled-by-shopper", deserializedAbortRequest.getAbortReason());
    assertEquals(
        MessageCategoryType.PAYMENT,
        deserializedAbortRequest.getMessageReference().getMessageCategory());
    assertEquals("service-id", deserializedAbortRequest.getMessageReference().getServiceID());
    assertEquals("device-id", deserializedAbortRequest.getMessageReference().getDeviceID());
    assertEquals("sale-id", deserializedAbortRequest.getMessageReference().getSaleID());
    assertEquals("poi-id", deserializedAbortRequest.getMessageReference().getPOIID());
    assertEquals(
        "Abort requested",
        deserializedAbortRequest
            .getDisplayOutput()
            .getOutputContent()
            .getOutputText()
            .get(0)
            .getText());
    assertEquals(
        DeviceType.CUSTOMER_DISPLAY, deserializedAbortRequest.getDisplayOutput().getDevice());
    assertEquals(
        InfoQualifyType.ERROR, deserializedAbortRequest.getDisplayOutput().getInfoQualify());
    assertEquals(
        OutputFormatType.TEXT,
        deserializedAbortRequest.getDisplayOutput().getOutputContent().getOutputFormat());

    String serializedJson = terminalApiGson.toJson(deserializedAbortRequest);

    JsonObject expectedJsonObject = JsonParser.parseString(mockJson).getAsJsonObject();
    JsonObject serializedJsonObject = JsonParser.parseString(serializedJson).getAsJsonObject();
    assertEquals(expectedJsonObject, serializedJsonObject);

    AbortRequest roundTripAbortRequest =
        terminalApiGson.fromJson(serializedJson, AbortRequest.class);
    assertEquals(deserializedAbortRequest.getAbortReason(), roundTripAbortRequest.getAbortReason());
    assertEquals(
        deserializedAbortRequest.getMessageReference().getServiceID(),
        roundTripAbortRequest.getMessageReference().getServiceID());
    assertEquals(
        deserializedAbortRequest.getMessageReference().getDeviceID(),
        roundTripAbortRequest.getMessageReference().getDeviceID());
    assertEquals(
        deserializedAbortRequest.getMessageReference().getSaleID(),
        roundTripAbortRequest.getMessageReference().getSaleID());
    assertEquals(
        deserializedAbortRequest.getMessageReference().getPOIID(),
        roundTripAbortRequest.getMessageReference().getPOIID());
    assertEquals(
        deserializedAbortRequest.getDisplayOutput().getInfoQualify(),
        roundTripAbortRequest.getDisplayOutput().getInfoQualify());
  }

  @Test
  public void testDeserializationWithMissingRequiredFields() throws IOException {
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    // JSON missing MessageReference (required field)
    String jsonMissingMessageReference =
        NexoTestUtils.readResource(
            "mocks/terminal-api/abort-request-missing-message-reference.json");

    AbortRequest result1 =
        terminalApiGson.fromJson(jsonMissingMessageReference, AbortRequest.class);
    assertNotNull(result1, "Deserialization should succeed even with missing required field");
    assertNull(
        result1.getMessageReference(), "MessageReference should be null when missing from JSON");
    assertNotNull(result1.getAbortReason(), "AbortReason should be present");

    // JSON missing AbortReason (required field)
    String jsonMissingAbortReason =
        NexoTestUtils.readResource("mocks/terminal-api/abort-request-missing-abort-reason.json");

    AbortRequest result2 = terminalApiGson.fromJson(jsonMissingAbortReason, AbortRequest.class);
    assertNotNull(result2, "Deserialization should succeed even with missing required field");
    assertNotNull(result2.getMessageReference(), "MessageReference should be present");
    assertNull(result2.getAbortReason(), "AbortReason should be null when missing from JSON");
  }

  @Test
  public void testSerializationWithNullRequiredFields() {
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    AbortRequest request = new AbortRequest();
    request.setAbortReason("cancelled-by-shopper");
    // Not setting MessageReference (required field)

    String serialized = terminalApiGson.toJson(request);
    assertNotNull(serialized, "Serialization should succeed even with null required field");

    // Verify it can be deserialized back
    AbortRequest deserialized = terminalApiGson.fromJson(serialized, AbortRequest.class);
    assertNotNull(deserialized);
    assertNull(
        deserialized.getMessageReference(), "MessageReference should remain null after round-trip");
  }
}
