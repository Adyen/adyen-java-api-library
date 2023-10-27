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

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.Base64;import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ByteArrayToStringAdapterTest {

    @Test
    public void testSerialize() {
        ByteArrayToStringAdapter adapter = new ByteArrayToStringAdapter();
        byte[] base64Bytes = Base64.getEncoder().encode("Bytes-To-Be-Encoded".getBytes());

        JsonElement serializedElement = adapter.serialize(base64Bytes, null, null);
        assertEquals("Qnl0ZXMtVG8tQmUtRW5jb2RlZA==", serializedElement.getAsString());
    }

    @Test
    public void testDeserialize() {
        ByteArrayToStringAdapter adapter = new ByteArrayToStringAdapter();
        byte[] base64Bytes = Base64.getEncoder().encode("Bytes-To-Be-Encoded".getBytes());

        JsonElement element = new JsonPrimitive("Qnl0ZXMtVG8tQmUtRW5jb2RlZA==");
        byte[] deserializedBytes = adapter.deserialize(element, null, null);

        assertArrayEquals(deserializedBytes, base64Bytes);
    }
}
