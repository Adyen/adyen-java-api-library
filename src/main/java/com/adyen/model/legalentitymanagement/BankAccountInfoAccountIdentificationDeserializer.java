package com.adyen.model.legalentitymanagement;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankAccountInfoAccountIdentificationDeserializer extends StdDeserializer<BankAccountInfoAccountIdentification> {

    private static final Logger log = Logger.getLogger(BankAccountInfoAccountIdentification.class.getName());
    public BankAccountInfoAccountIdentificationDeserializer() {
        this(BankAccountInfoAccountIdentification.class);
    }

    public BankAccountInfoAccountIdentificationDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public BankAccountInfoAccountIdentification deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode tree = jp.readValueAsTree();
        Object deserialized = null;
        boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
        int match = 0;
        JsonToken token = tree.traverse(jp.getCodec()).nextToken();

        // deserialize AULocalAccountIdentification
        try {
            boolean attemptParsing = true;
            // ensure that we respect type coercion as set on the client ObjectMapper
            if (AULocalAccountIdentification.class.equals(Integer.class) || AULocalAccountIdentification.class.equals(Long.class) || AULocalAccountIdentification.class.equals(Float.class) || AULocalAccountIdentification.class.equals(Double.class) || AULocalAccountIdentification.class.equals(Boolean.class) || AULocalAccountIdentification.class.equals(String.class)) {
                attemptParsing = typeCoercion;
                if (!attemptParsing) {
                    attemptParsing |= ((AULocalAccountIdentification.class.equals(Integer.class) || AULocalAccountIdentification.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                    attemptParsing |= ((AULocalAccountIdentification.class.equals(Float.class) || AULocalAccountIdentification.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                    attemptParsing |= (AULocalAccountIdentification.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                    attemptParsing |= (AULocalAccountIdentification.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                }
            }
            // Checks if the unique type of the oneOf json matches any of the object TypeEnum values
            boolean typeMatch = Arrays.stream(AULocalAccountIdentification.TypeEnum.values()).anyMatch((t) -> t.getValue().contains(tree.findValue("type").asText()));
            if (attemptParsing || typeMatch) {
                // Strict deserialization for oneOf models
                deserialized = JSON.getMapper().readValue(tree.toString(), AULocalAccountIdentification.class);
                // typeMatch should enforce proper deserialization
                match++;
                log.log(Level.FINER, "Input data matches schema 'AULocalAccountIdentification'");
            }
        } catch (Exception e) {
            // deserialization failed, continue
            log.log(Level.FINER, "Input data does not match schema 'AULocalAccountIdentification'", e);
        }


        // deserialize CALocalAccountIdentification
        try {
            boolean attemptParsing = true;
            // ensure that we respect type coercion as set on the client ObjectMapper
            if (CALocalAccountIdentification.class.equals(Integer.class) || CALocalAccountIdentification.class.equals(Long.class) || CALocalAccountIdentification.class.equals(Float.class) || CALocalAccountIdentification.class.equals(Double.class) || CALocalAccountIdentification.class.equals(Boolean.class) || CALocalAccountIdentification.class.equals(String.class)) {
                attemptParsing = typeCoercion;
                if (!attemptParsing) {
                    attemptParsing |= ((CALocalAccountIdentification.class.equals(Integer.class) || CALocalAccountIdentification.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                    attemptParsing |= ((CALocalAccountIdentification.class.equals(Float.class) || CALocalAccountIdentification.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                    attemptParsing |= (CALocalAccountIdentification.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                    attemptParsing |= (CALocalAccountIdentification.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                }
            }
            // Checks if the unique type of the oneOf json matches any of the object TypeEnum values
            boolean typeMatch = Arrays.stream(CALocalAccountIdentification.TypeEnum.values()).anyMatch((t) -> t.getValue().contains(tree.findValue("type").asText()));
            if (attemptParsing || typeMatch) {
                // Strict deserialization for oneOf models
                deserialized = JSON.getMapper().readValue(tree.toString(), CALocalAccountIdentification.class);
                // typeMatch should enforce proper deserialization
                match++;
                log.log(Level.FINER, "Input data matches schema 'CALocalAccountIdentification'");
            }
        } catch (Exception e) {
            // deserialization failed, continue
            log.log(Level.FINER, "Input data does not match schema 'CALocalAccountIdentification'", e);
        }


        // deserialize CZLocalAccountIdentification
        try {
            boolean attemptParsing = true;
            // ensure that we respect type coercion as set on the client ObjectMapper
            if (CZLocalAccountIdentification.class.equals(Integer.class) || CZLocalAccountIdentification.class.equals(Long.class) || CZLocalAccountIdentification.class.equals(Float.class) || CZLocalAccountIdentification.class.equals(Double.class) || CZLocalAccountIdentification.class.equals(Boolean.class) || CZLocalAccountIdentification.class.equals(String.class)) {
                attemptParsing = typeCoercion;
                if (!attemptParsing) {
                    attemptParsing |= ((CZLocalAccountIdentification.class.equals(Integer.class) || CZLocalAccountIdentification.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                    attemptParsing |= ((CZLocalAccountIdentification.class.equals(Float.class) || CZLocalAccountIdentification.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                    attemptParsing |= (CZLocalAccountIdentification.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                    attemptParsing |= (CZLocalAccountIdentification.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                }
            }
            // Checks if the unique type of the oneOf json matches any of the object TypeEnum values
            boolean typeMatch = Arrays.stream(CZLocalAccountIdentification.TypeEnum.values()).anyMatch((t) -> t.getValue().contains(tree.findValue("type").asText()));
            if (attemptParsing || typeMatch) {
                // Strict deserialization for oneOf models
                deserialized = JSON.getMapper().readValue(tree.toString(), CZLocalAccountIdentification.class);
                // typeMatch should enforce proper deserialization
                match++;
                log.log(Level.FINER, "Input data matches schema 'CZLocalAccountIdentification'");
            }
        } catch (Exception e) {
            // deserialization failed, continue
            log.log(Level.FINER, "Input data does not match schema 'CZLocalAccountIdentification'", e);
        }


        // deserialize DKLocalAccountIdentification
        try {
            boolean attemptParsing = true;
            // ensure that we respect type coercion as set on the client ObjectMapper
            if (DKLocalAccountIdentification.class.equals(Integer.class) || DKLocalAccountIdentification.class.equals(Long.class) || DKLocalAccountIdentification.class.equals(Float.class) || DKLocalAccountIdentification.class.equals(Double.class) || DKLocalAccountIdentification.class.equals(Boolean.class) || DKLocalAccountIdentification.class.equals(String.class)) {
                attemptParsing = typeCoercion;
                if (!attemptParsing) {
                    attemptParsing |= ((DKLocalAccountIdentification.class.equals(Integer.class) || DKLocalAccountIdentification.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                    attemptParsing |= ((DKLocalAccountIdentification.class.equals(Float.class) || DKLocalAccountIdentification.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                    attemptParsing |= (DKLocalAccountIdentification.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                    attemptParsing |= (DKLocalAccountIdentification.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                }
            }
            // Checks if the unique type of the oneOf json matches any of the object TypeEnum values
            boolean typeMatch = Arrays.stream(DKLocalAccountIdentification.TypeEnum.values()).anyMatch((t) -> t.getValue().contains(tree.findValue("type").asText()));
            if (attemptParsing || typeMatch) {
                // Strict deserialization for oneOf models
                deserialized = JSON.getMapper().readValue(tree.toString(), DKLocalAccountIdentification.class);
                // typeMatch should enforce proper deserialization
                match++;
                log.log(Level.FINER, "Input data matches schema 'DKLocalAccountIdentification'");
            }
        } catch (Exception e) {
            // deserialization failed, continue
            log.log(Level.FINER, "Input data does not match schema 'DKLocalAccountIdentification'", e);
        }


        // deserialize HKLocalAccountIdentification
        try {
            boolean attemptParsing = true;
            // ensure that we respect type coercion as set on the client ObjectMapper
            if (HKLocalAccountIdentification.class.equals(Integer.class) || HKLocalAccountIdentification.class.equals(Long.class) || HKLocalAccountIdentification.class.equals(Float.class) || HKLocalAccountIdentification.class.equals(Double.class) || HKLocalAccountIdentification.class.equals(Boolean.class) || HKLocalAccountIdentification.class.equals(String.class)) {
                attemptParsing = typeCoercion;
                if (!attemptParsing) {
                    attemptParsing |= ((HKLocalAccountIdentification.class.equals(Integer.class) || HKLocalAccountIdentification.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                    attemptParsing |= ((HKLocalAccountIdentification.class.equals(Float.class) || HKLocalAccountIdentification.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                    attemptParsing |= (HKLocalAccountIdentification.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                    attemptParsing |= (HKLocalAccountIdentification.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                }
            }
            // Checks if the unique type of the oneOf json matches any of the object TypeEnum values
            boolean typeMatch = Arrays.stream(HKLocalAccountIdentification.TypeEnum.values()).anyMatch((t) -> t.getValue().contains(tree.findValue("type").asText()));
            if (attemptParsing || typeMatch) {
                // Strict deserialization for oneOf models
                deserialized = JSON.getMapper().readValue(tree.toString(), HKLocalAccountIdentification.class);
                // typeMatch should enforce proper deserialization
                match++;
                log.log(Level.FINER, "Input data matches schema 'HKLocalAccountIdentification'");
            }
        } catch (Exception e) {
            // deserialization failed, continue
            log.log(Level.FINER, "Input data does not match schema 'HKLocalAccountIdentification'", e);
        }


        // deserialize HULocalAccountIdentification
        try {
            boolean attemptParsing = true;
            // ensure that we respect type coercion as set on the client ObjectMapper
            if (HULocalAccountIdentification.class.equals(Integer.class) || HULocalAccountIdentification.class.equals(Long.class) || HULocalAccountIdentification.class.equals(Float.class) || HULocalAccountIdentification.class.equals(Double.class) || HULocalAccountIdentification.class.equals(Boolean.class) || HULocalAccountIdentification.class.equals(String.class)) {
                attemptParsing = typeCoercion;
                if (!attemptParsing) {
                    attemptParsing |= ((HULocalAccountIdentification.class.equals(Integer.class) || HULocalAccountIdentification.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                    attemptParsing |= ((HULocalAccountIdentification.class.equals(Float.class) || HULocalAccountIdentification.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                    attemptParsing |= (HULocalAccountIdentification.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                    attemptParsing |= (HULocalAccountIdentification.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                }
            }
            // Checks if the unique type of the oneOf json matches any of the object TypeEnum values
            boolean typeMatch = Arrays.stream(HULocalAccountIdentification.TypeEnum.values()).anyMatch((t) -> t.getValue().contains(tree.findValue("type").asText()));
            if (attemptParsing || typeMatch) {
                // Strict deserialization for oneOf models
                deserialized = JSON.getMapper().readValue(tree.toString(), HULocalAccountIdentification.class);
                // typeMatch should enforce proper deserialization
                match++;
                log.log(Level.FINER, "Input data matches schema 'HULocalAccountIdentification'");
            }
        } catch (Exception e) {
            // deserialization failed, continue
            log.log(Level.FINER, "Input data does not match schema 'HULocalAccountIdentification'", e);
        }


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


        // deserialize NOLocalAccountIdentification
        try {
            boolean attemptParsing = true;
            // ensure that we respect type coercion as set on the client ObjectMapper
            if (NOLocalAccountIdentification.class.equals(Integer.class) || NOLocalAccountIdentification.class.equals(Long.class) || NOLocalAccountIdentification.class.equals(Float.class) || NOLocalAccountIdentification.class.equals(Double.class) || NOLocalAccountIdentification.class.equals(Boolean.class) || NOLocalAccountIdentification.class.equals(String.class)) {
                attemptParsing = typeCoercion;
                if (!attemptParsing) {
                    attemptParsing |= ((NOLocalAccountIdentification.class.equals(Integer.class) || NOLocalAccountIdentification.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                    attemptParsing |= ((NOLocalAccountIdentification.class.equals(Float.class) || NOLocalAccountIdentification.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                    attemptParsing |= (NOLocalAccountIdentification.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                    attemptParsing |= (NOLocalAccountIdentification.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                }
            }
            // Checks if the unique type of the oneOf json matches any of the object TypeEnum values
            boolean typeMatch = Arrays.stream(NOLocalAccountIdentification.TypeEnum.values()).anyMatch((t) -> t.getValue().contains(tree.findValue("type").asText()));
            if (attemptParsing || typeMatch) {
                // Strict deserialization for oneOf models
                deserialized = JSON.getMapper().readValue(tree.toString(), NOLocalAccountIdentification.class);
                // typeMatch should enforce proper deserialization
                match++;
                log.log(Level.FINER, "Input data matches schema 'NOLocalAccountIdentification'");
            }
        } catch (Exception e) {
            // deserialization failed, continue
            log.log(Level.FINER, "Input data does not match schema 'NOLocalAccountIdentification'", e);
        }


        // deserialize NZLocalAccountIdentification
        try {
            boolean attemptParsing = true;
            // ensure that we respect type coercion as set on the client ObjectMapper
            if (NZLocalAccountIdentification.class.equals(Integer.class) || NZLocalAccountIdentification.class.equals(Long.class) || NZLocalAccountIdentification.class.equals(Float.class) || NZLocalAccountIdentification.class.equals(Double.class) || NZLocalAccountIdentification.class.equals(Boolean.class) || NZLocalAccountIdentification.class.equals(String.class)) {
                attemptParsing = typeCoercion;
                if (!attemptParsing) {
                    attemptParsing |= ((NZLocalAccountIdentification.class.equals(Integer.class) || NZLocalAccountIdentification.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                    attemptParsing |= ((NZLocalAccountIdentification.class.equals(Float.class) || NZLocalAccountIdentification.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                    attemptParsing |= (NZLocalAccountIdentification.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                    attemptParsing |= (NZLocalAccountIdentification.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                }
            }
            // Checks if the unique type of the oneOf json matches any of the object TypeEnum values
            boolean typeMatch = Arrays.stream(NZLocalAccountIdentification.TypeEnum.values()).anyMatch((t) -> t.getValue().contains(tree.findValue("type").asText()));
            if (attemptParsing || typeMatch) {
                // Strict deserialization for oneOf models
                deserialized = JSON.getMapper().readValue(tree.toString(), NZLocalAccountIdentification.class);
                // typeMatch should enforce proper deserialization
                match++;
                log.log(Level.FINER, "Input data matches schema 'NZLocalAccountIdentification'");
            }
        } catch (Exception e) {
            // deserialization failed, continue
            log.log(Level.FINER, "Input data does not match schema 'NZLocalAccountIdentification'", e);
        }


        // deserialize NumberAndBicAccountIdentification
        try {
            boolean attemptParsing = true;
            // ensure that we respect type coercion as set on the client ObjectMapper
            if (NumberAndBicAccountIdentification.class.equals(Integer.class) || NumberAndBicAccountIdentification.class.equals(Long.class) || NumberAndBicAccountIdentification.class.equals(Float.class) || NumberAndBicAccountIdentification.class.equals(Double.class) || NumberAndBicAccountIdentification.class.equals(Boolean.class) || NumberAndBicAccountIdentification.class.equals(String.class)) {
                attemptParsing = typeCoercion;
                if (!attemptParsing) {
                    attemptParsing |= ((NumberAndBicAccountIdentification.class.equals(Integer.class) || NumberAndBicAccountIdentification.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                    attemptParsing |= ((NumberAndBicAccountIdentification.class.equals(Float.class) || NumberAndBicAccountIdentification.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                    attemptParsing |= (NumberAndBicAccountIdentification.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                    attemptParsing |= (NumberAndBicAccountIdentification.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                }
            }
            // Checks if the unique type of the oneOf json matches any of the object TypeEnum values
            boolean typeMatch = Arrays.stream(NumberAndBicAccountIdentification.TypeEnum.values()).anyMatch((t) -> t.getValue().contains(tree.findValue("type").asText()));
            if (attemptParsing || typeMatch) {
                // Strict deserialization for oneOf models
                deserialized = JSON.getMapper().readValue(tree.toString(), NumberAndBicAccountIdentification.class);
                // typeMatch should enforce proper deserialization
                match++;
                log.log(Level.FINER, "Input data matches schema 'NumberAndBicAccountIdentification'");
            }
        } catch (Exception e) {
            // deserialization failed, continue
            log.log(Level.FINER, "Input data does not match schema 'NumberAndBicAccountIdentification'", e);
        }


        // deserialize PLLocalAccountIdentification
        try {
            boolean attemptParsing = true;
            // ensure that we respect type coercion as set on the client ObjectMapper
            if (PLLocalAccountIdentification.class.equals(Integer.class) || PLLocalAccountIdentification.class.equals(Long.class) || PLLocalAccountIdentification.class.equals(Float.class) || PLLocalAccountIdentification.class.equals(Double.class) || PLLocalAccountIdentification.class.equals(Boolean.class) || PLLocalAccountIdentification.class.equals(String.class)) {
                attemptParsing = typeCoercion;
                if (!attemptParsing) {
                    attemptParsing |= ((PLLocalAccountIdentification.class.equals(Integer.class) || PLLocalAccountIdentification.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                    attemptParsing |= ((PLLocalAccountIdentification.class.equals(Float.class) || PLLocalAccountIdentification.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                    attemptParsing |= (PLLocalAccountIdentification.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                    attemptParsing |= (PLLocalAccountIdentification.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                }
            }
            // Checks if the unique type of the oneOf json matches any of the object TypeEnum values
            boolean typeMatch = Arrays.stream(PLLocalAccountIdentification.TypeEnum.values()).anyMatch((t) -> t.getValue().contains(tree.findValue("type").asText()));
            if (attemptParsing || typeMatch) {
                // Strict deserialization for oneOf models
                deserialized = JSON.getMapper().readValue(tree.toString(), PLLocalAccountIdentification.class);
                // typeMatch should enforce proper deserialization
                match++;
                log.log(Level.FINER, "Input data matches schema 'PLLocalAccountIdentification'");
            }
        } catch (Exception e) {
            // deserialization failed, continue
            log.log(Level.FINER, "Input data does not match schema 'PLLocalAccountIdentification'", e);
        }


        // deserialize SELocalAccountIdentification
        try {
            boolean attemptParsing = true;
            // ensure that we respect type coercion as set on the client ObjectMapper
            if (SELocalAccountIdentification.class.equals(Integer.class) || SELocalAccountIdentification.class.equals(Long.class) || SELocalAccountIdentification.class.equals(Float.class) || SELocalAccountIdentification.class.equals(Double.class) || SELocalAccountIdentification.class.equals(Boolean.class) || SELocalAccountIdentification.class.equals(String.class)) {
                attemptParsing = typeCoercion;
                if (!attemptParsing) {
                    attemptParsing |= ((SELocalAccountIdentification.class.equals(Integer.class) || SELocalAccountIdentification.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                    attemptParsing |= ((SELocalAccountIdentification.class.equals(Float.class) || SELocalAccountIdentification.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                    attemptParsing |= (SELocalAccountIdentification.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                    attemptParsing |= (SELocalAccountIdentification.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                }
            }
            // Checks if the unique type of the oneOf json matches any of the object TypeEnum values
            boolean typeMatch = Arrays.stream(SELocalAccountIdentification.TypeEnum.values()).anyMatch((t) -> t.getValue().contains(tree.findValue("type").asText()));
            if (attemptParsing || typeMatch) {
                // Strict deserialization for oneOf models
                deserialized = JSON.getMapper().readValue(tree.toString(), SELocalAccountIdentification.class);
                // typeMatch should enforce proper deserialization
                match++;
                log.log(Level.FINER, "Input data matches schema 'SELocalAccountIdentification'");
            }
        } catch (Exception e) {
            // deserialization failed, continue
            log.log(Level.FINER, "Input data does not match schema 'SELocalAccountIdentification'", e);
        }


        // deserialize SGLocalAccountIdentification
        try {
            boolean attemptParsing = true;
            // ensure that we respect type coercion as set on the client ObjectMapper
            if (SGLocalAccountIdentification.class.equals(Integer.class) || SGLocalAccountIdentification.class.equals(Long.class) || SGLocalAccountIdentification.class.equals(Float.class) || SGLocalAccountIdentification.class.equals(Double.class) || SGLocalAccountIdentification.class.equals(Boolean.class) || SGLocalAccountIdentification.class.equals(String.class)) {
                attemptParsing = typeCoercion;
                if (!attemptParsing) {
                    attemptParsing |= ((SGLocalAccountIdentification.class.equals(Integer.class) || SGLocalAccountIdentification.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                    attemptParsing |= ((SGLocalAccountIdentification.class.equals(Float.class) || SGLocalAccountIdentification.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                    attemptParsing |= (SGLocalAccountIdentification.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                    attemptParsing |= (SGLocalAccountIdentification.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                }
            }
            // Checks if the unique type of the oneOf json matches any of the object TypeEnum values
            boolean typeMatch = Arrays.stream(SGLocalAccountIdentification.TypeEnum.values()).anyMatch((t) -> t.getValue().contains(tree.findValue("type").asText()));
            if (attemptParsing || typeMatch) {
                // Strict deserialization for oneOf models
                deserialized = JSON.getMapper().readValue(tree.toString(), SGLocalAccountIdentification.class);
                // typeMatch should enforce proper deserialization
                match++;
                log.log(Level.FINER, "Input data matches schema 'SGLocalAccountIdentification'");
            }
        } catch (Exception e) {
            // deserialization failed, continue
            log.log(Level.FINER, "Input data does not match schema 'SGLocalAccountIdentification'", e);
        }


        // deserialize UKLocalAccountIdentification
        try {
            boolean attemptParsing = true;
            // ensure that we respect type coercion as set on the client ObjectMapper
            if (UKLocalAccountIdentification.class.equals(Integer.class) || UKLocalAccountIdentification.class.equals(Long.class) || UKLocalAccountIdentification.class.equals(Float.class) || UKLocalAccountIdentification.class.equals(Double.class) || UKLocalAccountIdentification.class.equals(Boolean.class) || UKLocalAccountIdentification.class.equals(String.class)) {
                attemptParsing = typeCoercion;
                if (!attemptParsing) {
                    attemptParsing |= ((UKLocalAccountIdentification.class.equals(Integer.class) || UKLocalAccountIdentification.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                    attemptParsing |= ((UKLocalAccountIdentification.class.equals(Float.class) || UKLocalAccountIdentification.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                    attemptParsing |= (UKLocalAccountIdentification.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                    attemptParsing |= (UKLocalAccountIdentification.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                }
            }
            // Checks if the unique type of the oneOf json matches any of the object TypeEnum values
            boolean typeMatch = Arrays.stream(UKLocalAccountIdentification.TypeEnum.values()).anyMatch((t) -> t.getValue().contains(tree.findValue("type").asText()));
            if (attemptParsing || typeMatch) {
                // Strict deserialization for oneOf models
                deserialized = JSON.getMapper().readValue(tree.toString(), UKLocalAccountIdentification.class);
                // typeMatch should enforce proper deserialization
                match++;
                log.log(Level.FINER, "Input data matches schema 'UKLocalAccountIdentification'");
            }
        } catch (Exception e) {
            // deserialization failed, continue
            log.log(Level.FINER, "Input data does not match schema 'UKLocalAccountIdentification'", e);
        }


        // deserialize USLocalAccountIdentification
        try {
            boolean attemptParsing = true;
            // ensure that we respect type coercion as set on the client ObjectMapper
            if (USLocalAccountIdentification.class.equals(Integer.class) || USLocalAccountIdentification.class.equals(Long.class) || USLocalAccountIdentification.class.equals(Float.class) || USLocalAccountIdentification.class.equals(Double.class) || USLocalAccountIdentification.class.equals(Boolean.class) || USLocalAccountIdentification.class.equals(String.class)) {
                attemptParsing = typeCoercion;
                if (!attemptParsing) {
                    attemptParsing |= ((USLocalAccountIdentification.class.equals(Integer.class) || USLocalAccountIdentification.class.equals(Long.class)) && token == JsonToken.VALUE_NUMBER_INT);
                    attemptParsing |= ((USLocalAccountIdentification.class.equals(Float.class) || USLocalAccountIdentification.class.equals(Double.class)) && token == JsonToken.VALUE_NUMBER_FLOAT);
                    attemptParsing |= (USLocalAccountIdentification.class.equals(Boolean.class) && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
                    attemptParsing |= (USLocalAccountIdentification.class.equals(String.class) && token == JsonToken.VALUE_STRING);
                }
            }
            // Checks if the unique type of the oneOf json matches any of the object TypeEnum values
            boolean typeMatch = Arrays.stream(USLocalAccountIdentification.TypeEnum.values()).anyMatch((t) -> t.getValue().contains(tree.findValue("type").asText()));
            if (attemptParsing || typeMatch) {
                // Strict deserialization for oneOf models
                deserialized = JSON.getMapper().readValue(tree.toString(), USLocalAccountIdentification.class);
                // typeMatch should enforce proper deserialization
                match++;
                log.log(Level.FINER, "Input data matches schema 'USLocalAccountIdentification'");
            }
        } catch (Exception e) {
            // deserialization failed, continue
            log.log(Level.FINER, "Input data does not match schema 'USLocalAccountIdentification'", e);
        }

        // Throw error if there is no match
        if (match == 0) {
            throw new IOException(String.format("Failed deserialization for BankAccountInfoAccountIdentification: %d classes match result, expected 1", match));
        }
        // Log warning if there is more than one match
        if (match > 1) {
            log.log(Level.WARNING, String.format("Warning, indecisive deserialization for BankAccountInfoAccountIdentification: %d classes match result, expected 1", match));
        }

        BankAccountInfoAccountIdentification ret = new BankAccountInfoAccountIdentification();
        ret.setActualInstance(deserialized);
        return ret;
    }

    /**
     * Handle deserialization of the 'null' value.
     */
    @Override
    public BankAccountInfoAccountIdentification getNullValue(DeserializationContext ctxt) throws JsonMappingException {
        throw new JsonMappingException(ctxt.getParser(), "BankAccountInfoAccountIdentification cannot be null");
    }
}
