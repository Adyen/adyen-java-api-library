package com.adyen.util.tapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.junit.jupiter.api.Test;

/** Tests for {@link SaleToAcquirerDataParser}. */
public class SaleToAcquirerDataParserTest {

  @Test
  public void testParseBase64Json() {
    String json =
        "{\"shopperEmail\":\"test@example.com\",\"tenderOption\":\"AskGratuity\",\"currency\":\"EUR\"}";
    String base64 = Base64.getEncoder().encodeToString(json.getBytes(StandardCharsets.UTF_8));

    SaleToAcquirerData result = SaleToAcquirerDataParser.parse(base64);

    assertEquals("test@example.com", result.getShopperEmail());
    assertEquals("AskGratuity", result.getTenderOption());
    assertEquals("EUR", result.getCurrency());
  }

  @Test
  public void testParseKeyValuePairs() {
    String kvp = "shopperEmail=test@example.com&tenderOption=AskGratuity&currency=EUR";

    SaleToAcquirerData result = SaleToAcquirerDataParser.parse(kvp);

    assertEquals("test@example.com", result.getShopperEmail());
    assertEquals("AskGratuity", result.getTenderOption());
    assertEquals("EUR", result.getCurrency());
  }

  @Test
  public void testFromBase64() {
    String json = "{\"shopperReference\":\"ref123\",\"merchantAccount\":\"TestMerchant\"}";
    String base64 = Base64.getEncoder().encodeToString(json.getBytes(StandardCharsets.UTF_8));

    SaleToAcquirerData result = SaleToAcquirerDataParser.fromBase64(base64);

    assertEquals("ref123", result.getShopperReference());
    assertEquals("TestMerchant", result.getMerchantAccount());
  }

  @Test
  public void testFromBase64InvalidThrows() {
    assertThrows(
        IllegalStateException.class,
        () -> SaleToAcquirerDataParser.fromBase64("not-valid-base64!!"));
  }

  @Test
  public void testFromKeyValuePairsAllKnownFields() {
    String kvp =
        "shopperEmail=a@b.com"
            + "&shopperReference=ref1"
            + "&shopperStatement=stmt"
            + "&recurringContract=RECURRING"
            + "&recurringDetailName=detailName"
            + "&recurringTokenService=tokenSvc"
            + "&recurringProcessingModel=Subscription"
            + "&store=myStore"
            + "&merchantAccount=merchant"
            + "&currency=USD"
            + "&tenderOption=AskGratuity"
            + "&authorisationType=PreAuth"
            + "&ssc=sscVal"
            + "&redemptionType=redeemType";

    SaleToAcquirerData result = SaleToAcquirerDataParser.fromKeyValuePairs(kvp);

    assertEquals("a@b.com", result.getShopperEmail());
    assertEquals("ref1", result.getShopperReference());
    assertEquals("stmt", result.getShopperStatement());
    assertEquals("RECURRING", result.getRecurringContract());
    assertEquals("detailName", result.getRecurringDetailName());
    assertEquals("tokenSvc", result.getRecurringTokenService());
    assertEquals(
        SaleToAcquirerData.RecurringProcessingModel.SUBSCRIPTION,
        result.getRecurringProcessingModel());
    assertEquals("myStore", result.getStore());
    assertEquals("merchant", result.getMerchantAccount());
    assertEquals("USD", result.getCurrency());
    assertEquals("AskGratuity", result.getTenderOption());
    assertEquals("PreAuth", result.getAuthorisationType());
    assertEquals("sscVal", result.getSsc());
    assertEquals("redeemType", result.getRedemptionType());
  }

  @Test
  public void testFromKeyValuePairsMetadata() {
    String kvp = "metadata.key1=value1&metadata.key2=value2";

    SaleToAcquirerData result = SaleToAcquirerDataParser.fromKeyValuePairs(kvp);

    assertNotNull(result.getMetadata());
    assertEquals("value1", result.getMetadata().get("key1"));
    assertEquals("value2", result.getMetadata().get("key2"));
  }

  @Test
  public void testFromKeyValuePairsUnknownKeysGoToAdditionalData() {
    String kvp = "shopperEmail=a@b.com&unknownField=someValue";

    SaleToAcquirerData result = SaleToAcquirerDataParser.fromKeyValuePairs(kvp);

    assertEquals("a@b.com", result.getShopperEmail());
    assertNotNull(result.getAdditionalData());
    assertEquals("someValue", result.getAdditionalData().get("unknownField"));
  }

  @Test
  public void testFromKeyValuePairsUrlEncoded() {
    String kvp = "shopperEmail=test%40example.com&tenderOption=Ask%20Gratuity";

    SaleToAcquirerData result = SaleToAcquirerDataParser.fromKeyValuePairs(kvp);

    assertEquals("test@example.com", result.getShopperEmail());
    assertEquals("Ask Gratuity", result.getTenderOption());
  }

  @Test
  public void testFromKeyValuePairsMalformedPairsIgnored() {
    String kvp = "shopperEmail=a@b.com&malformed&=nokey&validkey=";

    SaleToAcquirerData result = SaleToAcquirerDataParser.fromKeyValuePairs(kvp);

    assertEquals("a@b.com", result.getShopperEmail());
    assertNull(result.getAdditionalData());
  }

  @Test
  public void testToBase64AndRoundTrip() {
    SaleToAcquirerData data = new SaleToAcquirerData();
    data.setShopperEmail("round@trip.com");
    data.setCurrency("GBP");

    String base64 = SaleToAcquirerDataParser.toBase64(data);
    SaleToAcquirerData restored = SaleToAcquirerDataParser.fromBase64(base64);

    assertEquals(data, restored);
  }

  @Test
  public void testToJson() {
    SaleToAcquirerData data = new SaleToAcquirerData();
    data.setShopperEmail("json@test.com");

    String json = SaleToAcquirerDataParser.toJson(data);

    assertTrue(json.contains("\"shopperEmail\":\"json@test.com\""));
  }
}
