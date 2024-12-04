package com.adyen.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class JsonDateSerializer implements JsonSerializer<Date> {

    private String dateFormat; // Renamed to follow camelCase convention

    public JsonDateSerializer(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        return new JsonPrimitive(formatter.format(date));
    }
}
