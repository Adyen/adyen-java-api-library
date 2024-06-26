/*
 * Transfer webhooks
 *
 * The version of the OpenAPI document: 4
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.adyen.model.transferwebhooks;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.adyen.model.transferwebhooks.ConfirmationTrackingData;
import com.adyen.model.transferwebhooks.EstimationTrackingData;
import com.adyen.model.transferwebhooks.InternalReviewTrackingData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.core.type.TypeReference;

import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;


@JsonDeserialize(using = TransferEventTrackingData.TransferEventTrackingDataDeserializer.class)
@JsonSerialize(using = TransferEventTrackingData.TransferEventTrackingDataSerializer.class)
public class TransferEventTrackingData extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(TransferEventTrackingData.class.getName());

    public static class TransferEventTrackingDataSerializer extends StdSerializer<TransferEventTrackingData> {
        public TransferEventTrackingDataSerializer(Class<TransferEventTrackingData> t) {
            super(t);
        }

        public TransferEventTrackingDataSerializer() {
            this(null);
        }

        @Override
        public void serialize(TransferEventTrackingData value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class TransferEventTrackingDataDeserializer extends StdDeserializer<TransferEventTrackingData> {
        public TransferEventTrackingDataDeserializer() {
            this(TransferEventTrackingData.class);
        }

        public TransferEventTrackingDataDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public TransferEventTrackingData deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();
            Object deserialized = null;
            boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
            int match = 0;
            JsonToken token = tree.traverse(jp.getCodec()).nextToken();

            // deserialize ConfirmationTrackingData
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (ConfirmationTrackingData.class.equals(Integer.class) || ConfirmationTrackingData.class.equals(Long.class) || ConfirmationTrackingData.class.equals(Float.class) || ConfirmationTrackingData.class.equals(Double.class) || ConfirmationTrackingData.class.equals(Boolean.class) || ConfirmationTrackingData.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((ConfirmationTrackingData.class.equals(Integer.class) || ConfirmationTrackingData.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((ConfirmationTrackingData.class.equals(Float.class) || ConfirmationTrackingData.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (ConfirmationTrackingData.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (ConfirmationTrackingData.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                // Checks if the unique type of the oneOf json matches any of the object TypeEnum values
                boolean typeMatch = Arrays.stream(ConfirmationTrackingData.TypeEnum.values()).anyMatch((t) -> t.getValue().contains(tree.findValue("type").asText()));
                if (attemptParsing || typeMatch) {
                    // Strict deserialization for oneOf models
                    deserialized = JSON.getMapper().readValue(tree.toString(), ConfirmationTrackingData.class);
                    // typeMatch should enforce proper deserialization
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'ConfirmationTrackingData'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'ConfirmationTrackingData'", e);
            }


            // deserialize EstimationTrackingData
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (EstimationTrackingData.class.equals(Integer.class) || EstimationTrackingData.class.equals(Long.class) || EstimationTrackingData.class.equals(Float.class) || EstimationTrackingData.class.equals(Double.class) || EstimationTrackingData.class.equals(Boolean.class) || EstimationTrackingData.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((EstimationTrackingData.class.equals(Integer.class) || EstimationTrackingData.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((EstimationTrackingData.class.equals(Float.class) || EstimationTrackingData.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (EstimationTrackingData.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (EstimationTrackingData.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                // Checks if the unique type of the oneOf json matches any of the object TypeEnum values
                boolean typeMatch = Arrays.stream(EstimationTrackingData.TypeEnum.values()).anyMatch((t) -> t.getValue().contains(tree.findValue("type").asText()));
                if (attemptParsing || typeMatch) {
                    // Strict deserialization for oneOf models
                    deserialized = JSON.getMapper().readValue(tree.toString(), EstimationTrackingData.class);
                    // typeMatch should enforce proper deserialization
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'EstimationTrackingData'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'EstimationTrackingData'", e);
            }


            // deserialize InternalReviewTrackingData
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (InternalReviewTrackingData.class.equals(Integer.class) || InternalReviewTrackingData.class.equals(Long.class) || InternalReviewTrackingData.class.equals(Float.class) || InternalReviewTrackingData.class.equals(Double.class) || InternalReviewTrackingData.class.equals(Boolean.class) || InternalReviewTrackingData.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((InternalReviewTrackingData.class.equals(Integer.class) || InternalReviewTrackingData.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((InternalReviewTrackingData.class.equals(Float.class) || InternalReviewTrackingData.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (InternalReviewTrackingData.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (InternalReviewTrackingData.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                // Checks if the unique type of the oneOf json matches any of the object TypeEnum values
                boolean typeMatch = Arrays.stream(InternalReviewTrackingData.TypeEnum.values()).anyMatch((t) -> t.getValue().contains(tree.findValue("type").asText()));
                if (attemptParsing || typeMatch) {
                    // Strict deserialization for oneOf models
                    deserialized = JSON.getMapper().readValue(tree.toString(), InternalReviewTrackingData.class);
                    // typeMatch should enforce proper deserialization
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'InternalReviewTrackingData'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'InternalReviewTrackingData'", e);
            }

            // Throw error if there is no match
            if (match == 0) {
                throw new IOException(String.format("Failed deserialization for TransferEventTrackingData: %d classes match result, expected 1", match));
            }
            // Log warning if there is more than one match
            if (match > 1) {
                log.log(Level.WARNING, String.format("Warning, indecisive deserialization for TransferEventTrackingData: %d classes match result, expected 1", match));
            }

            TransferEventTrackingData ret = new TransferEventTrackingData();
            ret.setActualInstance(deserialized);
            return ret;
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public TransferEventTrackingData getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "TransferEventTrackingData cannot be null");
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, GenericType> schemas = new HashMap<String, GenericType>();

    public TransferEventTrackingData() {
        super("oneOf", Boolean.FALSE);
    }

    public TransferEventTrackingData(ConfirmationTrackingData o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public TransferEventTrackingData(EstimationTrackingData o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public TransferEventTrackingData(InternalReviewTrackingData o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("ConfirmationTrackingData", new GenericType<ConfirmationTrackingData>() {
        });
        schemas.put("EstimationTrackingData", new GenericType<EstimationTrackingData>() {
        });
        schemas.put("InternalReviewTrackingData", new GenericType<InternalReviewTrackingData>() {
        });
        JSON.registerDescendants(TransferEventTrackingData.class, Collections.unmodifiableMap(schemas));
    }

    @Override
    public Map<String, GenericType> getSchemas() {
        return TransferEventTrackingData.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check
     * the instance parameter is valid against the oneOf child schemas:
     * ConfirmationTrackingData, EstimationTrackingData, InternalReviewTrackingData
     *
     * It could be an instance of the 'oneOf' schemas.
     * The oneOf child schemas may themselves be a composed schema (allOf, anyOf, oneOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(ConfirmationTrackingData.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(EstimationTrackingData.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(InternalReviewTrackingData.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be ConfirmationTrackingData, EstimationTrackingData, InternalReviewTrackingData");
    }

    /**
     * Get the actual instance, which can be the following:
     * ConfirmationTrackingData, EstimationTrackingData, InternalReviewTrackingData
     *
     * @return The actual instance (ConfirmationTrackingData, EstimationTrackingData, InternalReviewTrackingData)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `ConfirmationTrackingData`. If the actual instance is not `ConfirmationTrackingData`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `ConfirmationTrackingData`
     * @throws ClassCastException if the instance is not `ConfirmationTrackingData`
     */
    public ConfirmationTrackingData getConfirmationTrackingData() throws ClassCastException {
        return (ConfirmationTrackingData)super.getActualInstance();
    }

    /**
     * Get the actual instance of `EstimationTrackingData`. If the actual instance is not `EstimationTrackingData`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `EstimationTrackingData`
     * @throws ClassCastException if the instance is not `EstimationTrackingData`
     */
    public EstimationTrackingData getEstimationTrackingData() throws ClassCastException {
        return (EstimationTrackingData)super.getActualInstance();
    }

    /**
     * Get the actual instance of `InternalReviewTrackingData`. If the actual instance is not `InternalReviewTrackingData`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `InternalReviewTrackingData`
     * @throws ClassCastException if the instance is not `InternalReviewTrackingData`
     */
    public InternalReviewTrackingData getInternalReviewTrackingData() throws ClassCastException {
        return (InternalReviewTrackingData)super.getActualInstance();
    }

    /**
    * Create an instance of TransferEventTrackingData given an JSON string
    *
    * @param jsonString JSON string
    * @return An instance of TransferEventTrackingData
    * @throws IOException if the JSON string is invalid with respect to TransferEventTrackingData
    */
    public static TransferEventTrackingData fromJson(String jsonString) throws IOException {
        return JSON.getMapper().readValue(jsonString, TransferEventTrackingData.class);
    }

    /**
    * Convert an instance of TransferEventTrackingData to an JSON string
    *
    * @return JSON string
    */
    public String toJson() throws JsonProcessingException {
        return JSON.getMapper().writeValueAsString(this);
    }
}

