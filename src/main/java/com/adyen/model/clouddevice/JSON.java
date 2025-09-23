package com.adyen.model.clouddevice;

import com.adyen.serializer.ByteArrayDeserializer;
import com.adyen.serializer.ByteArraySerializer;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.ws.rs.ext.ContextResolver;
import java.text.DateFormat;

public class JSON implements ContextResolver<ObjectMapper> {
	private static ObjectMapper mapper;

	private static final JSON json;

	static {
		json = new JSON();
	}

	private JSON() {
		mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.configure(MapperFeature.ALLOW_COERCION_OF_SCALARS, true);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, true);
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
		mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
		mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);

		mapper.registerModule(new JavaTimeModule());
		// Custom ByteSerializer
		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(byte[].class, new ByteArraySerializer());
		simpleModule.addDeserializer(byte[].class, new ByteArrayDeserializer());
		mapper.registerModule(simpleModule);
	}

	/**
	 * Set the date format for JSON (de)serialization with Date properties.
	 *
	 * @param dateFormat Date format
	 */
	public void setDateFormat(DateFormat dateFormat) {
		mapper.setDateFormat(dateFormat);
	}

	@Override
	public ObjectMapper getContext(Class<?> type) {
		return mapper;
	}

	/**
	 * Get the object mapper
	 *
	 * @return object mapper
	 */
	public static ObjectMapper getMapper() {
		return mapper;
	}

}
