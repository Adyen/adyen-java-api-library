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
package com.adyen.service;

import com.adyen.ApiKeyAuthenticatedService;
import com.adyen.Client;
import com.adyen.deserializer.XMLGregorianCalendarDeserializer;
import com.adyen.enums.adapter.XmlEnumAdapterFactory;
import com.adyen.model.nexo.SaleToPOIRequest;
import com.adyen.model.nexo.SaleToPOIResponse;
import com.adyen.serializer.XMLGregorianCalendarSerializer;
import com.adyen.service.resource.terminal.cloud.Async;
import com.adyen.service.resource.terminal.cloud.Sync;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.reflect.Field;

public class TerminalCloudAPI extends ApiKeyAuthenticatedService {

    private Async terminalApiAsync;
    private Sync terminalApiSync;

    public TerminalCloudAPI(Client client) {
        super(client);

        terminalApiAsync = new Async(this);
        terminalApiSync = new Sync(this);
    }

    /**
     * POST /async API call
     *
     * @param saleToPOIRequest SaleToPOIRequest
     * @return String
     * @throws Exception Exception
     */
    public String async(SaleToPOIRequest saleToPOIRequest) throws Exception {
        String jsonRequest = GSON.toJson(saleToPOIRequest);

        String response = terminalApiAsync.request(jsonRequest);
        return response;
    }

    /**
     * POST /sync API call
     *
     * @param saleToPOIRequest SaleToPOIRequest
     * @return SaleToPOIResponse
     * @throws Exception Exception
     */
    public SaleToPOIResponse sync(SaleToPOIRequest saleToPOIRequest) throws Exception {
        GsonBuilder gsonBuilder = new GsonBuilder();
        FieldNamingStrategy fieldNamingStrategy = new FieldNamingStrategy() {
            @Override
            public String translateName(Field field) {
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
            }
        };
        gsonBuilder.setFieldNamingStrategy(fieldNamingStrategy);
        gsonBuilder.registerTypeAdapterFactory(new XmlEnumAdapterFactory());
        gsonBuilder.registerTypeAdapter(XMLGregorianCalendar.class, new XMLGregorianCalendarSerializer());
        gsonBuilder.registerTypeAdapter(XMLGregorianCalendar.class, new XMLGregorianCalendarDeserializer());

        String jsonRequest = gsonBuilder.create().toJson(saleToPOIRequest);

        String jsonResponse = terminalApiSync.request(jsonRequest);

        SaleToPOIResponse saleToPOIResponse = gsonBuilder.create().fromJson(jsonResponse, new TypeToken<SaleToPOIResponse>() {
        }.getType());
        return saleToPOIResponse;
    }
}
