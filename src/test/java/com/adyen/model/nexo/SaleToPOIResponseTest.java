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

public class SaleToPOIResponseTest {

  @Test
  public void testShouldDeserializeWithDiagnosisResponse() throws IOException {
    String mockJson =
        NexoTestUtils.readResource("mocks/terminal-api/sale-to-poi-response-diagnosis.json");
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    SaleToPOIResponse deserialized = terminalApiGson.fromJson(mockJson, SaleToPOIResponse.class);
    assertNotNull(deserialized.getMessageHeader());
    assertEquals("POSSystemID12345", deserialized.getMessageHeader().getSaleID());
    assertEquals(
        MessageCategoryType.DIAGNOSIS, deserialized.getMessageHeader().getMessageCategory());
    assertEquals(MessageType.RESPONSE, deserialized.getMessageHeader().getMessageType());
    assertNotNull(deserialized.getDiagnosisResponse());
    assertEquals(ResultType.SUCCESS, deserialized.getDiagnosisResponse().getResponse().getResult());
    assertEquals(2, deserialized.getDiagnosisResponse().getLoggedSaleID().size());
    assertEquals("sale-1", deserialized.getDiagnosisResponse().getLoggedSaleID().get(0));
    assertNotNull(deserialized.getDiagnosisResponse().getPOIStatus());
    assertNull(deserialized.getPaymentResponse());
    assertNull(deserialized.getDisplayResponse());
    assertNull(deserialized.getSecurityTrailer());

    String serializedJson = terminalApiGson.toJson(deserialized);
    JsonObject expectedJsonObject = JsonParser.parseString(mockJson).getAsJsonObject();
    JsonObject serializedJsonObject = JsonParser.parseString(serializedJson).getAsJsonObject();
    assertEquals(expectedJsonObject, serializedJsonObject);
  }

  @Test
  public void testShouldDeserializeWithDisplayResponse() throws IOException {
    String mockJson =
        NexoTestUtils.readResource("mocks/terminal-api/sale-to-poi-response-display.json");
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    SaleToPOIResponse deserialized = terminalApiGson.fromJson(mockJson, SaleToPOIResponse.class);
    assertNotNull(deserialized.getMessageHeader());
    assertEquals(MessageCategoryType.DISPLAY, deserialized.getMessageHeader().getMessageCategory());
    assertNotNull(deserialized.getDisplayResponse());
    assertEquals(1, deserialized.getDisplayResponse().getOutputResult().size());
    assertEquals(
        DeviceType.CASHIER_DISPLAY,
        deserialized.getDisplayResponse().getOutputResult().get(0).getDevice());
    assertEquals(
        ResultType.SUCCESS,
        deserialized.getDisplayResponse().getOutputResult().get(0).getResponse().getResult());
    assertNull(deserialized.getDiagnosisResponse());
    assertNull(deserialized.getPaymentResponse());

    String serializedJson = terminalApiGson.toJson(deserialized);
    JsonObject expectedJsonObject = JsonParser.parseString(mockJson).getAsJsonObject();
    JsonObject serializedJsonObject = JsonParser.parseString(serializedJson).getAsJsonObject();
    assertEquals(expectedJsonObject, serializedJsonObject);
  }

  @Test
  public void testShouldDeserializeWithTransactionStatusResponse() throws IOException {
    String mockJson =
        NexoTestUtils.readResource(
            "mocks/terminal-api/sale-to-poi-response-transaction-status.json");
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    SaleToPOIResponse deserialized = terminalApiGson.fromJson(mockJson, SaleToPOIResponse.class);
    assertNotNull(deserialized.getMessageHeader());
    assertEquals(
        MessageCategoryType.TRANSACTION_STATUS,
        deserialized.getMessageHeader().getMessageCategory());
    assertNotNull(deserialized.getTransactionStatusResponse());
    assertEquals(
        ResultType.SUCCESS, deserialized.getTransactionStatusResponse().getResponse().getResult());
    assertNotNull(deserialized.getTransactionStatusResponse().getMessageReference());
    assertEquals(
        MessageCategoryType.PAYMENT,
        deserialized.getTransactionStatusResponse().getMessageReference().getMessageCategory());
    assertNull(deserialized.getDiagnosisResponse());
    assertNull(deserialized.getPaymentResponse());

    String serializedJson = terminalApiGson.toJson(deserialized);
    JsonObject expectedJsonObject = JsonParser.parseString(mockJson).getAsJsonObject();
    JsonObject serializedJsonObject = JsonParser.parseString(serializedJson).getAsJsonObject();
    assertEquals(expectedJsonObject, serializedJsonObject);
  }

  @Test
  public void testDeserializationWithMissingRequiredField() throws IOException {
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    // JSON missing MessageHeader (required field)
    String jsonMissingHeader =
        NexoTestUtils.readResource(
            "mocks/terminal-api/sale-to-poi-response-missing-message-header.json");
    SaleToPOIResponse result = terminalApiGson.fromJson(jsonMissingHeader, SaleToPOIResponse.class);
    assertNotNull(result, "Deserialization should succeed even with missing required field");
    assertNull(result.getMessageHeader(), "MessageHeader should be null when missing from JSON");
    assertNotNull(result.getDiagnosisResponse(), "DiagnosisResponse should be present");
  }

  @Test
  public void testSerializationWithNullRequiredField() {
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    SaleToPOIResponse response = new SaleToPOIResponse();
    response.setDiagnosisResponse(new DiagnosisResponse());
    // Not setting MessageHeader (required field)

    String serialized = terminalApiGson.toJson(response);
    assertNotNull(serialized, "Serialization should succeed even with null required field");

    SaleToPOIResponse deserialized = terminalApiGson.fromJson(serialized, SaleToPOIResponse.class);
    assertNotNull(deserialized);
    assertNull(
        deserialized.getMessageHeader(), "MessageHeader should remain null after round-trip");
    assertNotNull(
        deserialized.getDiagnosisResponse(),
        "DiagnosisResponse should remain present after round-trip");
  }
}
