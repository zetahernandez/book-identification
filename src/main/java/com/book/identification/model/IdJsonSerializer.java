package com.book.identification.model;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class IdJsonSerializer extends JsonSerializer<EntityBase> {

	@Override
	public void serialize(EntityBase value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

			Long id = value.getEntityId();
			
	        jgen.writeNumber(id.longValue());
	}

}
