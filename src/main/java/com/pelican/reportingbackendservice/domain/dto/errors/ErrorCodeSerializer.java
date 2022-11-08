package com.pelican.reportingbackendservice.domain.dto.errors;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ErrorCodeSerializer extends JsonSerializer<ErrorCode> {

	@Override
	public void serialize(ErrorCode value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeNumber(value.getCode());
	}

}
