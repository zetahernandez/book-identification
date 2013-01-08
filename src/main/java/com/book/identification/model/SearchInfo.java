package com.book.identification.model;

import javax.persistence.Entity;


/**
   * Search result information related to this volume.
   */
@Entity
  public final class SearchInfo extends EntityBase{

    /**
     * A text snippet containing the search query.
     * The value may be {@code null}.
     */
    
    private String textSnippet;

    /**
     * A text snippet containing the search query.
     * The value returned may be {@code null}.
     */
    public String getTextSnippet() {
      return textSnippet;
    }

    /**
     * A text snippet containing the search query.
     * The value set may be {@code null}.
     */
    public void setTextSnippet(String textSnippet) {
      this.textSnippet = textSnippet;
      
    }

	@Override
	public String toString() {
		return "SearchInfo [textSnippet=" + textSnippet + "]";
	}

  }