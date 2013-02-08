// Copyright 2013 fernando.hernandez

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

//   http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

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