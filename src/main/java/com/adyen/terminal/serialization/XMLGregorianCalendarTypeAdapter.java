/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.terminal.serialization;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.reflect.Type;

public class XMLGregorianCalendarTypeAdapter implements JsonSerializer<XMLGregorianCalendar>, JsonDeserializer<XMLGregorianCalendar> {
    @Override
    public XMLGregorianCalendar deserialize(
            JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(jsonElement.getAsString());
        } catch (Exception e) {
            throw new JsonParseException(e);
        }
    }

    @Override
    public JsonElement serialize(XMLGregorianCalendar xmlGregorianCalendar, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(xmlGregorianCalendar.toString());
    }
}
