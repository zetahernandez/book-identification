package com.book.identification.model;

import java.io.IOException;
import java.util.Collection;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class ArrayOfIdJsonSerializer extends JsonSerializer<Collection<EntityBase>> {

	@Override
	public void serialize(Collection<EntityBase> list, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		jgen.writeStartArray();
		for (EntityBase identificable : list) {
			jgen.writeNumber(identificable.getEntityId());
		}
		jgen.writeEndArray();
		  
	} 

}
