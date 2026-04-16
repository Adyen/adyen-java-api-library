package com.adyen.util.tapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.adyen.model.tapi.SaleData;
import java.util.Optional;
import org.junit.jupiter.api.Test;

/** Tests for {@link SaleDataHelper}. */
public class SaleDataHelperTest {

  @Test
  public void testShouldDecodeSaleToAcquirerData() {
    SaleToAcquirerData original = new SaleToAcquirerData();
    original.setMerchantAccount("TestMerchant");
    original.setStore("TestStore");
    String base64 = SaleToAcquirerDataParser.toBase64(original);

    SaleData saleData = new SaleData().saleToAcquirerData(base64);
    SaleDataHelper helper = new SaleDataHelper(saleData);

    Optional<SaleToAcquirerData> result = helper.getSaleToAcquirerData();
    assertTrue(result.isPresent(), "SaleToAcquirerData should be present");
    assertEquals("TestMerchant", result.get().getMerchantAccount());
    assertEquals("TestStore", result.get().getStore());
  }

  @Test
  public void testShouldDecodeRecurringProcessingModel() {
    SaleToAcquirerData original = new SaleToAcquirerData();
    original.setRecurringProcessingModel(SaleToAcquirerData.RecurringProcessingModel.CARD_ON_FILE);
    String base64 = SaleToAcquirerDataParser.toBase64(original);

    SaleDataHelper helper = new SaleDataHelper(new SaleData().saleToAcquirerData(base64));

    Optional<SaleToAcquirerData> result = helper.getSaleToAcquirerData();
    assertTrue(result.isPresent());
    assertEquals(
        SaleToAcquirerData.RecurringProcessingModel.CARD_ON_FILE,
        result.get().getRecurringProcessingModel());
  }

  @Test
  public void testShouldThrowOnNullSaleData() {
    assertThrows(NullPointerException.class, () -> new SaleDataHelper(null));
  }

  @Test
  public void testShouldSkipEmptyValuesInKeyValuePairs() {
    // key= (empty value) should be silently skipped
    String kvString = "store=myStore&emptyKey=&merchantAccount=myMerchant";
    SaleDataHelper helper = new SaleDataHelper(new SaleData().saleToAcquirerData(kvString));

    Optional<SaleToAcquirerData> result = helper.getSaleToAcquirerData();
    assertTrue(result.isPresent());
    assertEquals("myStore", result.get().getStore());
    assertEquals("myMerchant", result.get().getMerchantAccount());
    assertFalse(
        result.get().getAdditionalData() != null
            && result.get().getAdditionalData().containsKey("emptyKey"),
        "Empty-value key should be skipped");
  }

  @Test
  public void testShouldReturnEmptyWhenFieldIsNull() {
    SaleData saleData = new SaleData();
    SaleDataHelper helper = new SaleDataHelper(saleData);

    assertFalse(helper.getSaleToAcquirerData().isPresent(), "Should be empty when field is null");
  }

  @Test
  public void testShouldReturnEmptyWhenFieldIsBlank() {
    SaleData saleData = new SaleData().saleToAcquirerData("   ");
    SaleDataHelper helper = new SaleDataHelper(saleData);

    assertFalse(helper.getSaleToAcquirerData().isPresent(), "Should be empty when field is blank");
  }

  @Test
  public void testShouldParseInvalidBase64AsKeyValuePairs() {
    // Not valid Base64, but valid as key-value pairs — should fall back to key-value parsing
    SaleData saleData =
        new SaleData().saleToAcquirerData("store=myStore&merchantAccount=myMerchant");
    SaleDataHelper helper = new SaleDataHelper(saleData);

    Optional<SaleToAcquirerData> result = helper.getSaleToAcquirerData();
    assertTrue(result.isPresent(), "Should parse as key-value pairs when not valid Base64");
    assertEquals("myStore", result.get().getStore());
    assertEquals("myMerchant", result.get().getMerchantAccount());
  }

  @Test
  public void testShouldParseKeyValuePairFormat() {
    String kvString =
        "shopperEmail=S.Hopper%40example.com&shopperReference=CUST01_34582"
            + "&shopperStatement=Book+shop&tenderOption=ReceiptHandler,AskGratuity"
            + "&metadata.employeeNumber=1";

    SaleData saleData = new SaleData().saleToAcquirerData(kvString);
    SaleDataHelper helper = new SaleDataHelper(saleData);

    Optional<SaleToAcquirerData> result = helper.getSaleToAcquirerData();
    assertTrue(result.isPresent(), "SaleToAcquirerData should be present for key-value format");
    assertEquals("S.Hopper@example.com", result.get().getShopperEmail());
    assertEquals("CUST01_34582", result.get().getShopperReference());
    assertEquals("Book shop", result.get().getShopperStatement());
    assertEquals("ReceiptHandler,AskGratuity", result.get().getTenderOption());
    assertEquals("1", result.get().getMetadata().get("employeeNumber"));
  }

  @Test
  public void testShouldParseKeyValuePairWithAdditionalData() {
    String kvString = "merchantAccount=TestMerchant&store=TestStore&customKey=customValue";

    SaleData saleData = new SaleData().saleToAcquirerData(kvString);
    SaleDataHelper helper = new SaleDataHelper(saleData);

    Optional<SaleToAcquirerData> result = helper.getSaleToAcquirerData();
    assertTrue(result.isPresent());
    assertEquals("TestMerchant", result.get().getMerchantAccount());
    assertEquals("TestStore", result.get().getStore());
    assertEquals("customValue", result.get().getAdditionalData().get("customKey"));
  }
}
