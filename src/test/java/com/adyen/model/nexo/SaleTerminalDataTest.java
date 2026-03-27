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

public class SaleTerminalDataTest {

  @Test
  public void testShouldSerializeAndDeserializeListField() throws IOException {
    String mockJson = NexoTestUtils.readResource("mocks/terminal-api/sale-terminal-data.json");
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    SaleTerminalData deserialized = terminalApiGson.fromJson(mockJson, SaleTerminalData.class);
    assertNotNull(deserialized.getSaleCapabilities());
    assertEquals(3, deserialized.getSaleCapabilities().size());
    assertEquals(SaleCapabilitiesType.CASHIER_STATUS, deserialized.getSaleCapabilities().get(0));
    assertEquals(SaleCapabilitiesType.CASHIER_DISPLAY, deserialized.getSaleCapabilities().get(1));
    assertEquals(SaleCapabilitiesType.CUSTOMER_DISPLAY, deserialized.getSaleCapabilities().get(2));
    assertNotNull(deserialized.getSaleProfile());
    assertEquals(TerminalEnvironmentType.ATTENDED, deserialized.getTerminalEnvironment());
    assertEquals("group-1", deserialized.getTotalsGroupID());

    String serializedJson = terminalApiGson.toJson(deserialized);
    JsonObject expectedJsonObject = JsonParser.parseString(mockJson).getAsJsonObject();
    JsonObject serializedJsonObject = JsonParser.parseString(serializedJson).getAsJsonObject();
    assertEquals(expectedJsonObject, serializedJsonObject);
  }

  @Test
  public void testShouldSerializeAndDeserializeEmptyList() throws IOException {
    String mockJson =
        NexoTestUtils.readResource("mocks/terminal-api/sale-terminal-data-empty-capabilities.json");
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    SaleTerminalData deserialized = terminalApiGson.fromJson(mockJson, SaleTerminalData.class);
    assertNotNull(deserialized.getSaleCapabilities());
    assertEquals(0, deserialized.getSaleCapabilities().size());
    assertEquals(TerminalEnvironmentType.ATTENDED, deserialized.getTerminalEnvironment());
    assertNull(deserialized.getSaleProfile());
    assertNull(deserialized.getTotalsGroupID());

    String serializedJson = terminalApiGson.toJson(deserialized);
    JsonObject expectedJsonObject = JsonParser.parseString(mockJson).getAsJsonObject();
    JsonObject serializedJsonObject = JsonParser.parseString(serializedJson).getAsJsonObject();
    assertEquals(expectedJsonObject, serializedJsonObject);
  }
}
