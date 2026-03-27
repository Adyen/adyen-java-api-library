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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.datatype.XMLGregorianCalendar;

public final class TerminalAPIGsonBuilder {

    private TerminalAPIGsonBuilder() {
        // not meant to be initialized
    }

    public static Gson create() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeHierarchyAdapter(byte[].class, new ByteArrayToBase64TypeAdapter());
        gsonBuilder.registerTypeHierarchyAdapter(
                XMLGregorianCalendar.class, new XMLGregorianCalendarTypeAdapter());
        gsonBuilder.registerTypeAdapterFactory(new XMLEnumAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new AuthenticatedDataTypeAdapterFactory());
        gsonBuilder.disableHtmlEscaping();

        return gsonBuilder.create();
    }
}
