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

package com.adyen.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.reflect.Type;

public class XMLGregorianCalendarDeserializer implements JsonDeserializer<XMLGregorianCalendar> {
    @Override
    public XMLGregorianCalendar deserialize(
            JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(jsonElement.getAsString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

