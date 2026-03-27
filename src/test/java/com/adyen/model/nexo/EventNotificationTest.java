package com.adyen.model.nexo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.adyen.terminal.serialization.TerminalAPIGsonBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class EventNotificationTest {

  @Test
  public void testShouldSerializeAndDeserializeFromMockFile() throws IOException {
    String mockJson = NexoTestUtils.readResource("mocks/terminal-api/event-notification.json");
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    EventNotification deserializedEventNotification =
        terminalApiGson.fromJson(mockJson, EventNotification.class);
    assertEquals("2026-03-27T10:30:00Z", deserializedEventNotification.getTimeStamp().toString());
    assertEquals(
        EventToNotifyType.BEGIN_MAINTENANCE, deserializedEventNotification.getEventToNotify());
    assertEquals("Maintenance window started", deserializedEventNotification.getEventDetails());
    assertTrue(deserializedEventNotification.isMaintenanceRequiredFlag());
    assertEquals("en", deserializedEventNotification.getCustomerLanguage());
    assertNotNull(deserializedEventNotification.getDisplayOutput());
    assertEquals(
        DeviceType.CUSTOMER_DISPLAY, deserializedEventNotification.getDisplayOutput().getDevice());
    assertEquals(
        InfoQualifyType.DISPLAY, deserializedEventNotification.getDisplayOutput().getInfoQualify());
    assertEquals(
        "System maintenance in progress",
        deserializedEventNotification
            .getDisplayOutput()
            .getOutputContent()
            .getOutputText()
            .get(0)
            .getText());

    String serializedJson = terminalApiGson.toJson(deserializedEventNotification);

    JsonObject expectedJsonObject = JsonParser.parseString(mockJson).getAsJsonObject();
    JsonObject serializedJsonObject = JsonParser.parseString(serializedJson).getAsJsonObject();
    assertEquals(expectedJsonObject, serializedJsonObject);

    EventNotification roundTripEventNotification =
        terminalApiGson.fromJson(serializedJson, EventNotification.class);
    assertEquals(
        deserializedEventNotification.getTimeStamp().toString(),
        roundTripEventNotification.getTimeStamp().toString());
    assertEquals(
        deserializedEventNotification.getEventToNotify(),
        roundTripEventNotification.getEventToNotify());
    assertEquals(
        deserializedEventNotification.getEventDetails(),
        roundTripEventNotification.getEventDetails());
    assertEquals(
        deserializedEventNotification.isMaintenanceRequiredFlag(),
        roundTripEventNotification.isMaintenanceRequiredFlag());
  }

  @Test
  public void testDeserializationWithMissingRequiredFields() throws IOException {
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    // JSON missing TimeStamp (required field)
    String jsonMissingTimeStamp =
        NexoTestUtils.readResource("mocks/terminal-api/event-notification-missing-timestamp.json");

    EventNotification result1 =
        terminalApiGson.fromJson(jsonMissingTimeStamp, EventNotification.class);
    assertNotNull(result1, "Deserialization should succeed even with missing required field");
    assertNull(result1.getTimeStamp(), "TimeStamp should be null when missing from JSON");
    assertNotNull(result1.getEventToNotify(), "EventToNotify should be present");

    // JSON missing EventToNotify (required field)
    String jsonMissingEventToNotify =
        NexoTestUtils.readResource(
            "mocks/terminal-api/event-notification-missing-event-to-notify.json");

    EventNotification result2 =
        terminalApiGson.fromJson(jsonMissingEventToNotify, EventNotification.class);
    assertNotNull(result2, "Deserialization should succeed even with missing required field");
    assertNotNull(result2.getTimeStamp(), "TimeStamp should be present");
    assertNull(result2.getEventToNotify(), "EventToNotify should be null when missing from JSON");
  }

  @Test
  public void testSerializationWithNullRequiredFields() {
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    EventNotification notification = new EventNotification();
    notification.setEventDetails("Test event");
    // Not setting TimeStamp and EventToNotify (required fields)

    String serialized = terminalApiGson.toJson(notification);
    assertNotNull(serialized, "Serialization should succeed even with null required fields");

    // Verify it can be deserialized back
    EventNotification deserialized = terminalApiGson.fromJson(serialized, EventNotification.class);
    assertNotNull(deserialized);
    assertNull(deserialized.getTimeStamp(), "TimeStamp should remain null after round-trip");
    assertNull(
        deserialized.getEventToNotify(), "EventToNotify should remain null after round-trip");
  }
}
