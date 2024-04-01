package com.adyen.model.legalentitymanagement;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class BankAccountInfoAccountIdentificationSerializer extends StdSerializer<BankAccountInfoAccountIdentification> {

    public BankAccountInfoAccountIdentificationSerializer(Class<BankAccountInfoAccountIdentification> t) {
        super(t);
    }

    public BankAccountInfoAccountIdentificationSerializer() {
        this(null);
    }

    @Override
    public void serialize(BankAccountInfoAccountIdentification value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeObject(value.getActualInstance());
    }
}
