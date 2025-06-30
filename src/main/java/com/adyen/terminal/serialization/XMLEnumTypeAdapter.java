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

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Serializes and deserializes enums that use {@link XmlEnumValue} annotations for GSON.
 *
 * @param <T> The enum type.
 */
public class XMLEnumTypeAdapter<T> extends TypeAdapter<T> {

  private final Class clazz;

  /**
   * Instantiates a new {@link XMLEnumTypeAdapter}.
   *
   * @param clazz the enum class to be handled.
   */
  public XMLEnumTypeAdapter(Class clazz) {
    this.clazz = clazz;
  }

  /**
   * Writes the enum value to JSON, using the {@link XmlEnumValue} if present.
   *
   * @param out the GSON {@link JsonWriter} to write to.
   * @param value the enum constant to write to JSON.
   */
  @Override
  public void write(JsonWriter out, T value) throws IOException {
    if (value == null || !value.getClass().isEnum()) {
      out.nullValue();
      return;
    }

    Enum enumValue = (Enum) value;
    try {
      if (enumValue.getClass().getField(enumValue.name()).getAnnotation(XmlEnumValue.class)
          != null) {
        XmlEnumValue xmlEnumValue =
            enumValue.getClass().getField(enumValue.name()).getAnnotation(XmlEnumValue.class);
        out.value(xmlEnumValue.value());
      } else {
        out.value(enumValue.name());
      }
    } catch (Exception e) {
      throw new IOException(e);
    }
  }

  /**
   * Reads a string from JSON and converts it to an enum constant. It first attempts to use a static
   * {@code fromValue} method on the enum, then falls back to {@link Enum#valueOf(Class, String)}.
   * Returns {@code null} for unknown values.
   *
   * @param in the GSON {@link JsonReader} to read from.
   * @return The deserialized enum constant, or {@code null} if the value is unknown.
   * @throws IOException if an I/O error occurs.
   */
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
        enumObject = (T) Enum.valueOf((Class<Enum>) clazz, value);
      }
    } catch (IllegalArgumentException illegalArgumentException) {
      // Handling unknown value
      return null;
    } catch (Exception e) {
      throw new IOException(e);
    }

    return enumObject;
  }
}
