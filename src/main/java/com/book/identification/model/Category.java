package com.book.identification.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.IndexColumn;

@Entity
public class Category extends EntityBase {
	
	@IndexColumn(name="categoryNameIndex")
	@JoinColumn(unique=true,nullable=false)
	private String category;
	
	@OneToMany(fetch= FetchType.LAZY)
	@JsonSerialize(using=ArrayOfIdJsonSerializer.class)
	private Set<Category> subCategories;
	
	@ManyToOne(optional=true,cascade=CascadeType.ALL)
	@JoinColumn(nullable=true)
	@JsonSerialize(using=IdJsonSerializer.class)
	private Category parent;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public Set<Category> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(Set<Category> subCategories) {
		this.subCategories = subCategories;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

}
