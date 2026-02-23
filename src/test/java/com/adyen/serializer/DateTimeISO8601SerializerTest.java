package com.adyen.serializer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.TimeZone;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DateTimeISO8601SerializerTest {
  private static final TimeZone defaultTZ = TimeZone.getDefault();

  @AfterAll
  public static void tearDown() {
    TimeZone.setDefault(defaultTZ);
  }

  @Test
  public void testSerialize() {
    DateTimeISO8601Serializer dateTimeISO8601Serializer = new DateTimeISO8601Serializer();
    Date date = new Date();
    date.setTime(1503580067000L);
    TimeZone.setDefault(TimeZone.getTimeZone("EET"));

    assertEquals(
        "2017-08-24T16:07:47+03:00",
        dateTimeISO8601Serializer.serialize(date, null, null).getAsString());
  }
}
