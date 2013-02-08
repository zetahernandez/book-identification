package com.book.identification.model.collections;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.book.identification.model.Category;

@XmlRootElement
public class Categories {
	private List<Category> categories;
	
	@XmlElement(name="categories")
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
}
