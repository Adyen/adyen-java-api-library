package com.adyen.serializer;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DateTimeISO8601SerializerTest
{
    private static TimeZone defaultTZ = TimeZone.getDefault();

    @AfterClass
    public static void tearDown() {
        TimeZone.setDefault(defaultTZ);
    }

   @Test
    public void testSerialize()  {
        DateTimeISO8601Serializer dateTimeISO8601Serializer = new DateTimeISO8601Serializer();
        Date date = new Date();
        date.setTime(1503580067000L);
        TimeZone.setDefault(TimeZone.getTimeZone("EET"));

        assertEquals("2017-08-24T16:07:47+03:00", dateTimeISO8601Serializer.serialize(date, null, null).getAsString());
    }
}