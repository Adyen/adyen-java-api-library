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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ModelSerializationTest {

    Gson gson = new Gson();
    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Validate that all the enum fields get serialized to same value using GSON and Jackson
     */
    @Test
    @Ignore("Models should use only one serialization library")
    public void testEnumSerializationInGsonAndJacksonShouldBeSame() throws IOException, ClassNotFoundException {
        List<Class<?>> enums = ReflectionUtil.getEnumClasses("com.adyen.model").stream()
                .flatMap(aClass -> Arrays.stream(aClass.getEnumConstants()))
                .filter(anEnum -> !isValidSerialization(anEnum))
                .map(Object::getClass)
                .distinct()
                .peek(anEnum -> System.out.println(anEnum + " has difference between GSON and Jackson serialization"))
                .collect(Collectors.toList());

        Assert.assertTrue("Differences found between GSON and Jackson serialization(maybe @JsonValue missing on enums value", enums.isEmpty());
    }

    private boolean isValidSerialization(Object object) {
        try {
            return gson.toJson(object).equals(objectMapper.writeValueAsString(object));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Validate that all the class fields (except enums) which have @SerializedName annotation and different names must have @JsonProperty annotation as well
     */
    @Test
    public void testFieldNameShouldBeSameForGSONAndJackson() throws IOException, ClassNotFoundException {
        Set<Field> fieldsWithoutAnnotation = ReflectionUtil.getFieldsWithAnnotation("com.adyen.model", SerializedName.class).stream()
                .filter(field -> !field.isEnumConstant())
                .filter(this::hasDifferentNameInAnnotation)
                .filter(field -> !hasValidSerializationConfig(field))
                .peek(field -> System.out.println(field + " does not contain @JsonProperty or has a different value than @SerializedName"))
                .collect(Collectors.toSet());

        Assert.assertTrue("Fields without @JsonProperty found", fieldsWithoutAnnotation.isEmpty());
    }

    /**
     * Check if the field has valid @JsonProperty and @SerializedName annotation with same values
     *
     * @param field A class field
     * @return true if annotations are present and value is same, otherwise false
     */
    private boolean hasValidSerializationConfig(Field field) {
        JsonProperty jacksonAnnotation = field.getAnnotation(JsonProperty.class);
        SerializedName gsonAnnotation = field.getAnnotation(SerializedName.class);
        return jacksonAnnotation != null && gsonAnnotation != null && jacksonAnnotation.value().equals(gsonAnnotation.value());
    }

    /**
     * Checks if the field has different name than defined in @SerializedName
     *
     * @param field A class field
     * @return true if the field name is different than @SerializedName, otherwise false
     */
    private boolean hasDifferentNameInAnnotation(Field field) {
        SerializedName annotation = field.getAnnotation(SerializedName.class);
        return !field.getName().equals(annotation.value());
    }
}
