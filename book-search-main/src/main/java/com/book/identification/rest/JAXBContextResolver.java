package com.book.identification.rest;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;

import com.book.identification.model.Category;
import com.book.identification.model.ImageLinks;
import com.book.identification.model.IndustryIdentifiers;
import com.book.identification.model.Volume;
import com.book.identification.model.VolumeInfo;
import com.book.identification.model.collections.Categories;
import com.book.identification.model.collections.Volumes;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;

@Provider
public class JAXBContextResolver implements ContextResolver<JAXBContext> {

	private JAXBContext contextDefault;

	private Class<?>[] types = { Volume.class, Category.class,
			VolumeInfo.class, ImageLinks.class, IndustryIdentifiers.class,  Volumes.class,Categories.class};

	public JAXBContextResolver() throws Exception {
		this.contextDefault = new JSONJAXBContext(JSONConfiguration.natural()
				.rootUnwrapping(true).build(), types);
	}

	public JAXBContext getContext(Class<?> objectType) {
			return contextDefault;
	}
}