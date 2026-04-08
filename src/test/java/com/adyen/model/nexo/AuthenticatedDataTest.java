package com.adyen.model.nexo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.adyen.terminal.serialization.TerminalAPIGsonBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class AuthenticatedDataTest {

  @Test
  public void testShouldSerializeAndDeserializeKeyTransportFromMockFile() throws IOException {
    String mockJson =
        NexoTestUtils.readResource("mocks/terminal-api/authenticated-data-key-transport.json");
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    AuthenticatedData deserializedAuthenticatedData =
        terminalApiGson.fromJson(mockJson, AuthenticatedData.class);
    assertEquals(1, deserializedAuthenticatedData.getKeyTransportOrKEK().size());
    assertInstanceOf(
        KeyTransport.class,
        deserializedAuthenticatedData.getKeyTransportOrKEK().get(0),
        "Should deserialize as KeyTransport");

    KeyTransport keyTransport =
        (KeyTransport) deserializedAuthenticatedData.getKeyTransportOrKEK().get(0);
    assertNotNull(keyTransport.getRecipientIdentifier());
    assertEquals(
        AlgorithmType.RSA_ENCRYPTION, keyTransport.getKeyEncryptionAlgorithm().getAlgorithm());

    String serializedJson = terminalApiGson.toJson(deserializedAuthenticatedData);
    JsonObject expectedJsonObject = JsonParser.parseString(mockJson).getAsJsonObject();
    JsonObject serializedJsonObject = JsonParser.parseString(serializedJson).getAsJsonObject();
    assertEquals(expectedJsonObject, serializedJsonObject);
  }

  @Test
  public void testShouldSerializeAndDeserializeKekFromMockFile() throws IOException {
    String mockJson = NexoTestUtils.readResource("mocks/terminal-api/authenticated-data-kek.json");
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    AuthenticatedData deserializedAuthenticatedData =
        terminalApiGson.fromJson(mockJson, AuthenticatedData.class);
    assertEquals(1, deserializedAuthenticatedData.getKeyTransportOrKEK().size());
    assertInstanceOf(
        KEK.class,
        deserializedAuthenticatedData.getKeyTransportOrKEK().get(0),
        "Should deserialize as KEK");

    KEK kek = (KEK) deserializedAuthenticatedData.getKeyTransportOrKEK().get(0);
    assertNotNull(kek.getKEKIdentifier());
    assertEquals("kid-1", kek.getKEKIdentifier().getKeyIdentifier());
    assertEquals(AlgorithmType.DES_EDE_3_CBC, kek.getKeyEncryptionAlgorithm().getAlgorithm());

    String serializedJson = terminalApiGson.toJson(deserializedAuthenticatedData);
    JsonObject expectedJsonObject = JsonParser.parseString(mockJson).getAsJsonObject();
    JsonObject serializedJsonObject = JsonParser.parseString(serializedJson).getAsJsonObject();
    assertEquals(expectedJsonObject, serializedJsonObject);
  }

  @Test
  public void testDeserializationWithMissingRequiredFields() throws IOException {
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    // JSON missing MACAlgorithm (required field)
    String jsonMissingMacAlgorithm =
        NexoTestUtils.readResource(
            "mocks/terminal-api/authenticated-data-missing-mac-algorithm.json");
    AuthenticatedData result1 =
        terminalApiGson.fromJson(jsonMissingMacAlgorithm, AuthenticatedData.class);
    assertNotNull(result1, "Deserialization should succeed even with missing required field");
    assertNull(result1.getMACAlgorithm(), "MACAlgorithm should be null when missing from JSON");
    assertNotNull(result1.getEncapsulatedContent(), "EncapsulatedContent should be present");
    assertNotNull(result1.getMAC(), "MAC should be present");

    // JSON missing EncapsulatedContent (required field)
    String jsonMissingEncapsulatedContent =
        NexoTestUtils.readResource(
            "mocks/terminal-api/authenticated-data-missing-encapsulated-content.json");
    AuthenticatedData result2 =
        terminalApiGson.fromJson(jsonMissingEncapsulatedContent, AuthenticatedData.class);
    assertNotNull(result2, "Deserialization should succeed even with missing required field");
    assertNotNull(result2.getMACAlgorithm(), "MACAlgorithm should be present");
    assertNull(
        result2.getEncapsulatedContent(),
        "EncapsulatedContent should be null when missing from JSON");
    assertNotNull(result2.getMAC(), "MAC should be present");

    // JSON missing MAC (required field)
    String jsonMissingMac =
        NexoTestUtils.readResource("mocks/terminal-api/authenticated-data-missing-mac.json");
    AuthenticatedData result3 = terminalApiGson.fromJson(jsonMissingMac, AuthenticatedData.class);
    assertNotNull(result3, "Deserialization should succeed even with missing required field");
    assertNotNull(result3.getMACAlgorithm(), "MACAlgorithm should be present");
    assertNotNull(result3.getEncapsulatedContent(), "EncapsulatedContent should be present");
    assertNull(result3.getMAC(), "MAC should be null when missing from JSON");
  }

  @Test
  public void testSerializationWithNullRequiredFields() {
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    AuthenticatedData authenticatedData = new AuthenticatedData();
    authenticatedData.setVersion(VersionType.V_0);
    // Not setting MACAlgorithm, EncapsulatedContent, MAC (required fields)

    String serialized = terminalApiGson.toJson(authenticatedData);
    assertNotNull(serialized, "Serialization should succeed even with null required fields");

    AuthenticatedData deserialized = terminalApiGson.fromJson(serialized, AuthenticatedData.class);
    assertNotNull(deserialized);
    assertNull(deserialized.getMACAlgorithm(), "MACAlgorithm should remain null after round-trip");
    assertNull(
        deserialized.getEncapsulatedContent(),
        "EncapsulatedContent should remain null after round-trip");
    assertNull(deserialized.getMAC(), "MAC should remain null after round-trip");
  }

  @Test
  public void testDeserializationIsCaseSensitive() throws IOException {
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    String wrongCaseJson =
        NexoTestUtils.readResource("mocks/terminal-api/authenticated-data-wrong-case.json");

    AuthenticatedData result = terminalApiGson.fromJson(wrongCaseJson, AuthenticatedData.class);
    assertNotNull(
        result, "Deserialization should succeed but fields with wrong casing should not be mapped");
    assertNull(
        result.getMACAlgorithm(), "MACAlgorithm should be null when JSON key has wrong casing");
    assertNull(
        result.getEncapsulatedContent(),
        "EncapsulatedContent should be null when JSON key has wrong casing");
    assertNull(result.getMAC(), "MAC should be null when JSON key has wrong casing");
    assertTrue(
        result.getKeyTransportOrKEK().isEmpty(),
        "KeyTransportOrKEK should be null when JSON key has wrong casing");
    assertEquals(
        VersionType.V_0,
        result.getVersion(),
        "Version should fall back to default v0 when JSON key has wrong casing");
  }

  @Test
  public void testDeserializationWithMissingNonRequiredField() throws IOException {
    String mockJson =
        NexoTestUtils.readResource("mocks/terminal-api/authenticated-data-missing-version.json");
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    AuthenticatedData deserializedAuthenticatedData =
        terminalApiGson.fromJson(mockJson, AuthenticatedData.class);
    assertNotNull(deserializedAuthenticatedData);
    assertEquals(VersionType.V_0, deserializedAuthenticatedData.getVersion());
    assertEquals(1, deserializedAuthenticatedData.getKeyTransportOrKEK().size());

    String serializedJson = terminalApiGson.toJson(deserializedAuthenticatedData);
    JsonObject expectedJsonObject = JsonParser.parseString(mockJson).getAsJsonObject();
    JsonObject serializedJsonObject = JsonParser.parseString(serializedJson).getAsJsonObject();
    assertEquals(expectedJsonObject, serializedJsonObject);
  }
}
