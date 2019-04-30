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

package com.adyen.enums.adapter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import javax.xml.bind.annotation.XmlEnumValue;
import java.io.IOException;
import java.lang.reflect.Method;

public class XmlEnumAdapterFactory implements TypeAdapterFactory {
    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> type) {
        Class<? super T> rawType = type.getRawType();
        if (rawType.isEnum()) {
            return new XmlEnumTypeAdapter<>(rawType);
        }
        return null;
    }

    public class XmlEnumTypeAdapter<T> extends TypeAdapter<T> {

        Class clazz;

        XmlEnumTypeAdapter(Class clazz) {
            this.clazz = clazz;
        }

        @Override
        public void write(JsonWriter out, T value) throws IOException {
            if (value == null || !value.getClass().isEnum()) {
                out.nullValue();
                return;
            }

            Enum enumValue = (Enum) value;
            try {
                if (enumValue.getClass().getField(enumValue.name()).getAnnotation(XmlEnumValue.class) != null) {
                    XmlEnumValue xmlEnumValue = enumValue.getClass().getField(enumValue.name()).getAnnotation(XmlEnumValue.class);
                    out.value(xmlEnumValue.value());
                } else {
                    out.value(enumValue.name());
                }
            } catch (Exception e) {
                throw new IOException(e);
            }
        }

        public T read(JsonReader in) throws IOException {
            JsonToken token = in.peek();
            if (token == JsonToken.NULL) {
                in.nextNull();
                return null;
            }

            String value = in.nextString();
            T enumObject = null;
            try {
                Method[] methods = clazz.getMethods();
                for (Method m : methods) {
                    if ("fromValue".equals(m.getName())) {
                        enumObject = (T) m.invoke(null, value);
                    }
                }

                if (enumObject == null) {
                    enumObject = (T) Enum.valueOf(Enum.class, value);
                }
            } catch (Exception e) {
                throw new IOException(e);
            }

            return enumObject;
        }
    }
}