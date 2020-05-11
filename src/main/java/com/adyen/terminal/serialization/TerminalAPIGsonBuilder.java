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

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.datatype.XMLGregorianCalendar;

public final class TerminalAPIGsonBuilder {

    private TerminalAPIGsonBuilder() {
    }

    public static Gson create() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        FieldNamingStrategy fieldNamingStrategy = field -> {
            if (field.getAnnotation(XmlElement.class) != null) {
                XmlElement xmlElement = field.getAnnotation(XmlElement.class);
                return xmlElement.name();
            } else if (field.getAnnotation(XmlAttribute.class) != null) {
                XmlAttribute xmlAttribute = field.getAnnotation(XmlAttribute.class);
                return xmlAttribute.name();
            } else if (field.getAnnotation(XmlRootElement.class) != null) {
                XmlRootElement xmlRootElement = field.getAnnotation(XmlRootElement.class);
                return xmlRootElement.name();
            }
            return field.getName();
        };
        gsonBuilder.setFieldNamingStrategy(fieldNamingStrategy);
        gsonBuilder.registerTypeHierarchyAdapter(byte[].class, new ByteArrayToBase64TypeAdapter());
        gsonBuilder.registerTypeHierarchyAdapter(XMLGregorianCalendar.class, new XMLGregorianCalendarTypeAdapter());
        gsonBuilder.registerTypeAdapterFactory(new XMLEnumAdapterFactory());
        gsonBuilder.disableHtmlEscaping();

        return gsonBuilder.create();
    }
}
