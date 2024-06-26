/*
 * Configuration webhooks
 *
 * The version of the OpenAPI document: 2
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.adyen.model.configurationwebhooks;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.adyen.model.configurationwebhooks.IbanAccountIdentification;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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


@JsonDeserialize(using = PaymentInstrumentAdditionalBankAccountIdentificationsInner.PaymentInstrumentAdditionalBankAccountIdentificationsInnerDeserializer.class)
@JsonSerialize(using = PaymentInstrumentAdditionalBankAccountIdentificationsInner.PaymentInstrumentAdditionalBankAccountIdentificationsInnerSerializer.class)
public class PaymentInstrumentAdditionalBankAccountIdentificationsInner extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(PaymentInstrumentAdditionalBankAccountIdentificationsInner.class.getName());

    public static class PaymentInstrumentAdditionalBankAccountIdentificationsInnerSerializer extends StdSerializer<PaymentInstrumentAdditionalBankAccountIdentificationsInner> {
        public PaymentInstrumentAdditionalBankAccountIdentificationsInnerSerializer(Class<PaymentInstrumentAdditionalBankAccountIdentificationsInner> t) {
            super(t);
        }

        public PaymentInstrumentAdditionalBankAccountIdentificationsInnerSerializer() {
            this(null);
        }

        @Override
        public void serialize(PaymentInstrumentAdditionalBankAccountIdentificationsInner value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class PaymentInstrumentAdditionalBankAccountIdentificationsInnerDeserializer extends StdDeserializer<PaymentInstrumentAdditionalBankAccountIdentificationsInner> {
        public PaymentInstrumentAdditionalBankAccountIdentificationsInnerDeserializer() {
            this(PaymentInstrumentAdditionalBankAccountIdentificationsInner.class);
        }

        public PaymentInstrumentAdditionalBankAccountIdentificationsInnerDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public PaymentInstrumentAdditionalBankAccountIdentificationsInner deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();
            Object deserialized = null;
            boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
            int match = 0;
            JsonToken token = tree.traverse(jp.getCodec()).nextToken();

            // deserialize IbanAccountIdentification
            try {
                boolean attemptParsing = true;
                // ensure that we respect type coercion as set on the client ObjectMapper
                if (IbanAccountIdentification.class.equals(Integer.class) || IbanAccountIdentification.class.equals(Long.class) || IbanAccountIdentification.class.equals(Float.class) || IbanAccountIdentification.class.equals(Double.class) || IbanAccountIdentification.class.equals(Boolean.class) || IbanAccountIdentification.class.equals(String.class)) {
                    attemptParsing = typeCoercion;
                    if (!attemptParsing) {
                        attemptParsing |= ((IbanAccountIdentification.class.equals(Integer.class) || IbanAccountIdentification.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                        attemptParsing |= ((IbanAccountIdentification.class.equals(Float.class) || IbanAccountIdentification.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                        attemptParsing |= (IbanAccountIdentification.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                        attemptParsing |= (IbanAccountIdentification.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                    }
                }
                // Checks if the unique type of the oneOf json matches any of the object TypeEnum values
                boolean typeMatch = Arrays.stream(IbanAccountIdentification.TypeEnum.values()).anyMatch((t) -> t.getValue().contains(tree.findValue("type").asText()));
                if (attemptParsing || typeMatch) {
                    // Strict deserialization for oneOf models
                    deserialized = JSON.getMapper().readValue(tree.toString(), IbanAccountIdentification.class);
                    // typeMatch should enforce proper deserialization
                    match++;
                    log.log(Level.FINER, "Input data matches schema 'IbanAccountIdentification'");
                }
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'IbanAccountIdentification'", e);
            }

            // Throw error if there is no match
            if (match == 0) {
                throw new IOException(String.format("Failed deserialization for PaymentInstrumentAdditionalBankAccountIdentificationsInner: %d classes match result, expected 1", match));
            }
            // Log warning if there is more than one match
            if (match > 1) {
                log.log(Level.WARNING, String.format("Warning, indecisive deserialization for PaymentInstrumentAdditionalBankAccountIdentificationsInner: %d classes match result, expected 1", match));
            }

            PaymentInstrumentAdditionalBankAccountIdentificationsInner ret = new PaymentInstrumentAdditionalBankAccountIdentificationsInner();
            ret.setActualInstance(deserialized);
            return ret;
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public PaymentInstrumentAdditionalBankAccountIdentificationsInner getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "PaymentInstrumentAdditionalBankAccountIdentificationsInner cannot be null");
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, GenericType> schemas = new HashMap<String, GenericType>();

    public PaymentInstrumentAdditionalBankAccountIdentificationsInner() {
        super("oneOf", Boolean.FALSE);
    }

    public PaymentInstrumentAdditionalBankAccountIdentificationsInner(IbanAccountIdentification o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("IbanAccountIdentification", new GenericType<IbanAccountIdentification>() {
        });
        JSON.registerDescendants(PaymentInstrumentAdditionalBankAccountIdentificationsInner.class, Collections.unmodifiableMap(schemas));
    }

    @Override
    public Map<String, GenericType> getSchemas() {
        return PaymentInstrumentAdditionalBankAccountIdentificationsInner.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check
     * the instance parameter is valid against the oneOf child schemas:
     * IbanAccountIdentification
     *
     * It could be an instance of the 'oneOf' schemas.
     * The oneOf child schemas may themselves be a composed schema (allOf, anyOf, oneOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(IbanAccountIdentification.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be IbanAccountIdentification");
    }

    /**
     * Get the actual instance, which can be the following:
     * IbanAccountIdentification
     *
     * @return The actual instance (IbanAccountIdentification)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `IbanAccountIdentification`. If the actual instance is not `IbanAccountIdentification`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `IbanAccountIdentification`
     * @throws ClassCastException if the instance is not `IbanAccountIdentification`
     */
    public IbanAccountIdentification getIbanAccountIdentification() throws ClassCastException {
        return (IbanAccountIdentification)super.getActualInstance();
    }

    /**
    * Create an instance of PaymentInstrumentAdditionalBankAccountIdentificationsInner given an JSON string
    *
    * @param jsonString JSON string
    * @return An instance of PaymentInstrumentAdditionalBankAccountIdentificationsInner
    * @throws IOException if the JSON string is invalid with respect to PaymentInstrumentAdditionalBankAccountIdentificationsInner
    */
    public static PaymentInstrumentAdditionalBankAccountIdentificationsInner fromJson(String jsonString) throws IOException {
        return JSON.getMapper().readValue(jsonString, PaymentInstrumentAdditionalBankAccountIdentificationsInner.class);
    }

    /**
    * Convert an instance of PaymentInstrumentAdditionalBankAccountIdentificationsInner to an JSON string
    *
    * @return JSON string
    */
    public String toJson() throws JsonProcessingException {
        return JSON.getMapper().writeValueAsString(this);
    }
}

