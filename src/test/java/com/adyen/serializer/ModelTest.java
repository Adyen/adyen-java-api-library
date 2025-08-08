package com.adyen.serializer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.adyen.model.checkout.CardDetails;
import com.adyen.model.checkout.CheckoutPaymentMethod;
import com.adyen.model.checkout.CreateCheckoutSessionResponse;
import com.adyen.model.checkout.StoredPaymentMethodDetails;
import com.adyen.model.legalentitymanagement.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.time.Month;
import java.time.ZoneId;
import org.junit.Test;

/** Test model serialization (toJson) and deserialization (fromJson) */
public class ModelTest {

  @Test
  public void testFromJsonLegalEntity() throws JsonProcessingException {
    String json =
        "{\n"
            + "  \"id\": \"LE3227C223222B5BPCMFXD2XG\",\n"
            + "  \"reference\": \"YOUR_REFERENCE_12345\",\n"
            + "  \"type\": \"individual\",\n"
            + "  \"individual\": {\n"
            + "    \"name\": {\n"
            + "      \"firstName\": \"Jane\",\n"
            + "      \"lastName\": \"Doe\"\n"
            + "    },\n"
            + "    \"residentialAddress\": {\n"
            + "      \"country\": \"NL\",\n"
            + "      \"city\": \"Amsterdam\"\n"
            + "    }\n"
            + "  },\n"
            + "  \"capabilities\": {\n"
            + "    \"issueCard\": {\n"
            + "      \"allowed\": true,\n"
            + "      \"requested\": true\n"
            + "    }\n"
            + "  }\n"
            + "}";

    LegalEntity legalEntity = LegalEntity.fromJson(json);

    assertNotNull(legalEntity);
    assertEquals("LE3227C223222B5BPCMFXD2XG", legalEntity.getId());
    assertEquals("YOUR_REFERENCE_12345", legalEntity.getReference());

    assertEquals(LegalEntity.TypeEnum.INDIVIDUAL, legalEntity.getType());
    assertNotNull(legalEntity.getIndividual());

    assertNotNull(legalEntity.getCapabilities());
    assertTrue(legalEntity.getCapabilities().containsKey("issueCard"));
    assertNotNull(legalEntity.getCapabilities().get("issueCard"));
  }

  @Test
  public void testFromJsonLegalEntityWithInvalidEnum() throws JsonProcessingException {
    String json =
        "{\n"
            + "  \"id\": \"LE3227C223222B5BPCMFXD2XG\",\n"
            + "  \"reference\": \"YOUR_REFERENCE_12345\",\n"
            + "  \"type\": \"UNKNOWN\",\n"
            + "  \"individual\": {\n"
            + "    \"name\": {\n"
            + "      \"firstName\": \"Jane\",\n"
            + "      \"lastName\": \"Doe\"\n"
            + "    },\n"
            + "    \"residentialAddress\": {\n"
            + "      \"country\": \"NL\",\n"
            + "      \"city\": \"Amsterdam\"\n"
            + "    }\n"
            + "  },\n"
            + "  \"capabilities\": {\n"
            + "    \"issueCard\": {\n"
            + "      \"allowed\": true,\n"
            + "      \"requested\": true\n"
            + "    }\n"
            + "  }\n"
            + "}";

    LegalEntity legalEntity = LegalEntity.fromJson(json);

    assertNotNull(legalEntity);
    assertEquals("LE3227C223222B5BPCMFXD2XG", legalEntity.getId());
    assertEquals("YOUR_REFERENCE_12345", legalEntity.getReference());
    // type is null since enum value is invalid
    assertNull(legalEntity.getType());
  }

  @Test
  public void testToJsonLegalEntity() throws JsonProcessingException {
    LegalEntity legalEntity =
        new LegalEntity()
            .reference("YOUR_REFERENCE_12345")
            .type(LegalEntity.TypeEnum.INDIVIDUAL)
            .individual(
                new Individual()
                    .name(new Name().firstName("Jane").lastName("Doe"))
                    .residentialAddress(new Address().country("NL").city("Amsterdam")))
            .putCapabilitiesItem(
                "issueCard",
                new LegalEntityCapability()
                    .allowedSettings(
                        new CapabilitySettings()
                            .addFundingSourceItem(CapabilitySettings.FundingSourceEnum.CREDIT)));

    String deserialized = legalEntity.toJson();

    String expected =
        "{\"capabilities\":{\"issueCard\":{\"allowedSettings\":{\"fundingSource\":[\"credit\"]}}},\"individual\":{\"name\":{\"firstName\":\"Jane\",\"lastName\":\"Doe\"},\"residentialAddress\":{\"city\":\"Amsterdam\",\"country\":\"NL\"}},\"reference\":\"YOUR_REFERENCE_12345\",\"type\":\"individual\"}";

    assertEquals(expected, deserialized);
  }

  @Test
  public void testFromJsonCreateCheckoutSessionResponse() throws JsonProcessingException {
    String json =
        "{\n"
            + "  \"amount\": {\n"
            + "    \"currency\": \"EUR\",\n"
            + "    \"value\": 1000\n"
            + "  },\n"
            + "  \"countryCode\": \"NL\",\n"
            + "  \"expiresAt\": \"2022-01-11T13:53:18+01:00\",\n"
            + "  \"id\": \"CS451F2AB1ED897A94\",\n"
            + "  \"merchantAccount\": \"YOUR_MERCHANT_ACCOUNT\",\n"
            + "  \"reference\": \"YOUR_PAYMENT_REFERENCE\",\n"
            + "  \"url\": \"https://checkout-test.adyen.com/checkout/sessions/CS_1234567890ABCDEF\",\n"
            + "  \"sessionData\": \"Ab02b4c0!BQABAgBfYI29...\"\n"
            + "}";

    CreateCheckoutSessionResponse response = CreateCheckoutSessionResponse.fromJson(json);

    assertNotNull(response);
    assertEquals("CS451F2AB1ED897A94", response.getId());
    assertEquals("YOUR_PAYMENT_REFERENCE", response.getReference());
    assertEquals(
        "https://checkout-test.adyen.com/checkout/sessions/CS_1234567890ABCDEF", response.getUrl());

    assertNotNull(response.getAmount());
    assertEquals("EUR", response.getAmount().getCurrency());
    assertEquals(1000L, response.getAmount().getValue().longValue());

    assertEquals("2022-01-11T13:53:18+01:00", response.getExpiresAt().toString());
    assertEquals(2022, response.getExpiresAt().getYear());
    assertEquals(Month.JANUARY, response.getExpiresAt().getMonth());
    assertEquals(ZoneId.of("+01:00"), response.getExpiresAt().toZonedDateTime().getZone());
  }

  @Test
  public void testFromJsonCheckoutPaymentMethodBcmc() throws Exception {
    String json =
        "{\n"
            + "  \"type\": \"bcmc\",\n"
            + "  \"holderName\": \"Ms Smith\",\n"
            + "  \"encryptedCardNumber\": \"...\",\n"
            + "  \"encryptedExpiryMonth\": \"...\",\n"
            + "  \"encryptedExpiryYear\": \"...\",\n"
            + "  \"brand\": \"bcmc\",\n"
            + "  \"checkoutAttemptId\": \"...\"\n"
            + "}";

    CheckoutPaymentMethod paymentMethod = CheckoutPaymentMethod.fromJson(json);

    assertNotNull(paymentMethod);

    CardDetails cardDetails = paymentMethod.getCardDetails();
    assertNotNull(cardDetails);

    assertEquals(CardDetails.TypeEnum.BCMC, cardDetails.getType());
    assertEquals("bcmc", cardDetails.getBrand());
    assertEquals("Ms Smith", cardDetails.getHolderName());
  }

  @Test
  public void testFromJsonCheckoutPaymentMethodBcmcMobile() throws Exception {
    String json =
        "{\n"
            + " \"type\":\"bcmc_mobile\",\n"
            + " \"storedPaymentMethodId\":\"7219687191761347\"\n"
            + "}";

    CheckoutPaymentMethod paymentMethod = CheckoutPaymentMethod.fromJson(json);
    assertNotNull(paymentMethod);

    StoredPaymentMethodDetails storedPaymentMethodDetails =
        paymentMethod.getStoredPaymentMethodDetails();
    assertNotNull(storedPaymentMethodDetails);

    assertEquals(
        StoredPaymentMethodDetails.TypeEnum.BCMC_MOBILE, storedPaymentMethodDetails.getType());
    assertEquals("7219687191761347", storedPaymentMethodDetails.getStoredPaymentMethodId());
  }
}
