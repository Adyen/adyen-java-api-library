package com.adyen.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeGMTSerializer implements JsonSerializer<Date> {

    // YYYY-MM-DDTHH:mm:ss.sssZ
    public static final String DATE_FORMAT = "YYYY-MM-DD'T'HH:mm:ss.sss'Z'";

    /**
     * Format to ISO 8601 format: YYYY-MM-DDTHH:mm:ss.sssZ
     *
     * @param date
     * @param typeOfSrc
     * @param context
     * @return
     */
    public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return new JsonPrimitive(formatter.format(date));
    }
}