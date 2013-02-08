package com.book.identification.model;

import javax.persistence.Entity;


/**
   * Information regarding the source of this review, when the review is not from a Google Books user.
   */
@Entity
  public final class Source extends EntityBase{

    /**
     * Name of the source.
     * The value may be {@code null}.
     */
  
    private String description;

    /**
     * Extra text about the source of the review.
     * The value may be {@code null}.
     */
  
    private String extraDescription;

    /**
     * URL of the source of the review.
     * The value may be {@code null}.
     */
  
    private String url;

    /**
     * Name of the source.
     * The value returned may be {@code null}.
     */
    public String getDescription() {
      return description;
    }

    /**
     * Name of the source.
     * The value set may be {@code null}.
     */
    public void setDescription(String description) {
      this.description = description;
      
    }

    /**
     * Extra text about the source of the review.
     * The value returned may be {@code null}.
     */
    public String getExtraDescription() {
      return extraDescription;
    }

    /**
     * Extra text about the source of the review.
     * The value set may be {@code null}.
     */
    public void setExtraDescription(String extraDescription) {
      this.extraDescription = extraDescription;
      
    }

    /**
     * URL of the source of the review.
     * The value returned may be {@code null}.
     */
    public String getUrl() {
      return url;
    }

    /**
     * URL of the source of the review.
     * The value set may be {@code null}.
     */
    public void setUrl(String url) {
      this.url = url;
      
    }

	@Override
	public String toString() {
		return "Source [description=" + description + ", extraDescription="
				+ extraDescription + ", url=" + url + "]";
	}

  }