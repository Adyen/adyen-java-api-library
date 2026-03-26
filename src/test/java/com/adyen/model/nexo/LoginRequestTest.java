package com.adyen.model.nexo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.adyen.terminal.serialization.TerminalAPIGsonBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class LoginRequestTest {

  @Test
  public void testShouldSerializeAndDeserializeFromMockFile() throws IOException {
    String mockJson = NexoTestUtils.readResource("mocks/terminal-api/login-request.json");
    Gson terminalApiGson = TerminalAPIGsonBuilder.create();

    LoginRequest deserializedLoginRequest = terminalApiGson.fromJson(mockJson, LoginRequest.class);
    assertEquals("2026-03-26T10:15:30Z", deserializedLoginRequest.getDateTime().toString());
    assertEquals("adyen", deserializedLoginRequest.getSaleSoftware().getManufacturerID());
    assertEquals("register-app", deserializedLoginRequest.getSaleSoftware().getApplicationName());
    assertEquals("1.0.0", deserializedLoginRequest.getSaleSoftware().getSoftwareVersion());
    assertEquals("cert-123", deserializedLoginRequest.getSaleSoftware().getCertificationCode());
    assertEquals(2, deserializedLoginRequest.getSaleTerminalData().getSaleCapabilities().size());
    assertEquals(
        SaleCapabilitiesType.CASHIER_DISPLAY,
        deserializedLoginRequest.getSaleTerminalData().getSaleCapabilities().get(0));
    assertEquals(
        SaleCapabilitiesType.CUSTOMER_DISPLAY,
        deserializedLoginRequest.getSaleTerminalData().getSaleCapabilities().get(1));
    assertEquals(
        TerminalEnvironmentType.ATTENDED,
        deserializedLoginRequest.getSaleTerminalData().getTerminalEnvironment());
    assertEquals("group-1", deserializedLoginRequest.getSaleTerminalData().getTotalsGroupID());
    assertTrue(deserializedLoginRequest.isTrainingModeFlag());
    assertEquals("en", deserializedLoginRequest.getOperatorLanguage());
    assertEquals("operator-1", deserializedLoginRequest.getOperatorID());
    assertEquals("shift-1", deserializedLoginRequest.getShiftNumber());
    assertEquals(TokenRequestedType.TRANSACTION, deserializedLoginRequest.getTokenRequestedType());
    assertEquals(2, deserializedLoginRequest.getCustomerOrderReq().size());
    assertEquals(CustomerOrderReqType.OPEN, deserializedLoginRequest.getCustomerOrderReq().get(0));
    assertEquals(
        CustomerOrderReqType.CLOSED, deserializedLoginRequest.getCustomerOrderReq().get(1));
    assertEquals("poi-serial-1", deserializedLoginRequest.getPOISerialNumber());

    String serializedJson = terminalApiGson.toJson(deserializedLoginRequest);

    JsonObject expectedJsonObject = JsonParser.parseString(mockJson).getAsJsonObject();
    JsonObject serializedJsonObject = JsonParser.parseString(serializedJson).getAsJsonObject();
    assertEquals(expectedJsonObject, serializedJsonObject);

    LoginRequest roundTripLoginRequest =
        terminalApiGson.fromJson(serializedJson, LoginRequest.class);
    assertEquals(
        deserializedLoginRequest.getDateTime().toString(),
        roundTripLoginRequest.getDateTime().toString());
    assertEquals(
        deserializedLoginRequest.getTokenRequestedType(),
        roundTripLoginRequest.getTokenRequestedType());
    assertEquals(
        deserializedLoginRequest.getCustomerOrderReq(),
        roundTripLoginRequest.getCustomerOrderReq());
    assertEquals(
        deserializedLoginRequest.getPOISerialNumber(), roundTripLoginRequest.getPOISerialNumber());
  }
}
