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
package com.adyen.serializer;

import com.adyen.model.nexo.AuthenticationMethodType;
import com.adyen.terminal.serialization.XMLEnumTypeAdapter;
import com.google.gson.stream.JsonReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.StringReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class XMLEnumSerializerTest {

    @Test
    public void testAuthenticationMethodTypeMultipleValues() throws Exception {
        XMLEnumTypeAdapter<AuthenticationMethodType> adapter = new XMLEnumTypeAdapter<>(AuthenticationMethodType.class);

        String value1 = "\"OnlinePIN\"";
        JsonReader jsonReader1 = new JsonReader(new StringReader(value1));
        AuthenticationMethodType authenticationMethodType1 = adapter.read(jsonReader1);

        assertNotNull(authenticationMethodType1);
        assertEquals(AuthenticationMethodType.ON_LINE_PIN, authenticationMethodType1);

        String value2 = "\"OnLinePIN\"";
        JsonReader jsonReader2 = new JsonReader(new StringReader(value2));
        AuthenticationMethodType authenticationMethodType2 = adapter.read(jsonReader2);

        assertNotNull(authenticationMethodType2);
        assertEquals(AuthenticationMethodType.ON_LINE_PIN, authenticationMethodType2);
    }
}
