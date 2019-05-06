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
import com.adyen.model.terminal.TerminalAPIRequest;
import com.adyen.model.terminal.TerminalAPIResponse;
import com.adyen.model.terminal.TerminalAPISecuredRequest;
import com.adyen.model.terminal.security.SaleToPOISecuredMessage;
import com.adyen.model.terminal.security.SecurityKey;
import com.adyen.security.NexoCrypto;
import com.adyen.serializer.XMLGregorianCalendarSerializer;
import com.adyen.service.resource.terminal.local.LocalRequest;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.reflect.Field;

public class TerminalLocalAPI extends ApiKeyAuthenticatedService {

    private LocalRequest localRequest;

    private NexoCrypto nexoCrypto;
    private Gson terminalApiGson;

    public TerminalLocalAPI(Client client) {
        super(client);
        localRequest = new LocalRequest(this);
        nexoCrypto = new NexoCrypto();
        terminalApiGson = buildTerminalApiGson();
    }

    private Gson buildTerminalApiGson() {
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

        return gsonBuilder.create();
    }

    /**
     * POST /sync API call
     *
     * @param terminalAPIRequest TerminalAPIRequest
     * @return SaleToPOIResponse
     * @throws Exception exception
     */
    public TerminalAPIResponse request(TerminalAPIRequest terminalAPIRequest, SecurityKey securityKey) throws Exception {
        String jsonRequest = terminalApiGson.toJson(terminalAPIRequest);
        SaleToPOISecuredMessage saleToPOISecuredRequest = nexoCrypto.encrypt(jsonRequest, terminalAPIRequest.getSaleToPOIRequest().getMessageHeader(), securityKey);

        TerminalAPISecuredRequest securedPaymentRequest = new TerminalAPISecuredRequest();
        securedPaymentRequest.setSaleToPOIRequest(saleToPOISecuredRequest);
        String jsonEncryptedRequest = terminalApiGson.toJson(securedPaymentRequest);

        String jsonResponse = localRequest.request(jsonEncryptedRequest);

        SaleToPOISecuredMessage saleToPOISecuredResponse = terminalApiGson.fromJson(jsonResponse, new TypeToken<SaleToPOISecuredMessage>() {
        }.getType());
        String jsonDecryptedResponse = nexoCrypto.decrypt(saleToPOISecuredResponse, securityKey);
        TerminalAPIResponse response = terminalApiGson.fromJson(jsonDecryptedResponse, new TypeToken<TerminalAPIResponse>() {
        }.getType());

        return response;
    }
}
