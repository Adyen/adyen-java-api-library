package com.adyen.model.nexo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.Optional;
import org.junit.Test;

/** Tests for {@link PredefinedContentHelper}. */
public class PredefinedContentHelperTest {

  @Test
  public void testShouldExtractValidEvent() {
    String referenceId =
        "TransactionID=oLkO001517998574000&TimeStamp=2018-02-07T10%3a16%3a14.000Z&event=PIN_ENTERED";
    PredefinedContentHelper helper = new PredefinedContentHelper(referenceId);

    Optional<PredefinedContentHelper.DisplayNotificationEvent> event = helper.getEvent();
    assertTrue("Event should be present", event.isPresent());
    assertEquals(PredefinedContentHelper.DisplayNotificationEvent.PIN_ENTERED, event.get());
  }

  @Test
  public void testShouldReturnEmptyForInvalidEvent() {
    PredefinedContentHelper helper = new PredefinedContentHelper("event=INVALID_EVENT");

    assertFalse("Event should not be present for invalid value", helper.getEvent().isPresent());
  }

  @Test
  public void testShouldExtractTransactionId() {
    PredefinedContentHelper helper =
        new PredefinedContentHelper(
            "TransactionID=12345&TimeStamp=2018-02-07T10%3a16%3a14.000Z&event=PIN_ENTERED");

    Optional<String> transactionId = helper.getTransactionId();
    assertTrue("TransactionID should be present", transactionId.isPresent());
    assertEquals("12345", transactionId.get());
  }

  @Test
  public void testShouldExtractTimeStamp() {
    PredefinedContentHelper helper = new PredefinedContentHelper("TimeStamp=2024-07-11T12:00:00Z");

    Optional<String> timeStamp = helper.getTimeStamp();
    assertTrue("TimeStamp should be present", timeStamp.isPresent());
    assertEquals("2024-07-11T12:00:00Z", timeStamp.get());
  }

  @Test
  public void testShouldExtractArbitraryKey() {
    PredefinedContentHelper helper = new PredefinedContentHelper("foo=bar&baz=qux");

    Optional<String> foo = helper.get("foo");
    assertTrue("Value for 'foo' should be present", foo.isPresent());
    assertEquals("bar", foo.get());

    Optional<String> baz = helper.get("baz");
    assertTrue("Value for 'baz' should be present", baz.isPresent());
    assertEquals("qux", baz.get());

    assertFalse("Value for 'missing' should not be present", helper.get("missing").isPresent());
  }

  @Test
  public void testShouldConvertParamsToMap() {
    PredefinedContentHelper helper = new PredefinedContentHelper("a=1&b=2&event=WAIT_FOR_PIN");

    Map<String, String> map = helper.toMap();
    assertEquals(3, map.size());
    assertEquals("1", map.get("a"));
    assertEquals("2", map.get("b"));
    assertEquals("WAIT_FOR_PIN", map.get("event"));
  }

  @Test
  public void testShouldHandleEmptyReferenceId() {
    PredefinedContentHelper helper = new PredefinedContentHelper("");

    assertFalse(helper.getEvent().isPresent());
    assertFalse(helper.getTransactionId().isPresent());
    assertFalse(helper.getTimeStamp().isPresent());
    assertTrue(helper.toMap().isEmpty());
  }

  @Test
  public void testShouldHandleNullReferenceId() {
    PredefinedContentHelper helper = new PredefinedContentHelper(null);

    assertFalse(helper.getEvent().isPresent());
    assertFalse(helper.getTransactionId().isPresent());
    assertFalse(helper.getTimeStamp().isPresent());
    assertTrue(helper.toMap().isEmpty());
  }
}
