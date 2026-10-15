package com.adyen.util;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class DateUtilTest {

  @Test
  public void shouldParseValidYmdDate() {
    assertNotNull(DateUtil.parseYmdDate("2026-02-28"));
  }

  @Test
  public void shouldReturnNullForImpossibleYmdDate() {
    assertNull(DateUtil.parseYmdDate("2026-02-30"));
  }

  @Test
  public void shouldReturnNullForYmdDateWithTrailingText() {
    assertNull(DateUtil.parseYmdDate("2026-02-28-extra"));
  }

  @Test
  public void shouldReturnNullForMonthOutsideValidRange() {
    assertNull(DateUtil.parseMYDate("13/2026"));
  }
}
