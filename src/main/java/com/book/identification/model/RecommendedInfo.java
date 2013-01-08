package com.book.identification.model;

import javax.persistence.Entity;


/**
   * Recommendation related information for this volume.
   */
@Entity
  public final class RecommendedInfo extends EntityBase{

    /**
     * A text explaining why this volume is recommended.
     * The value may be {@code null}.
     */
    
    private String explanation;

    /**
     * A text explaining why this volume is recommended.
     * The value returned may be {@code null}.
     */
    public String getExplanation() {
      return explanation;
    }

    /**
     * A text explaining why this volume is recommended.
     * The value set may be {@code null}.
     */
    public void setExplanation(String explanation) {
      this.explanation = explanation;
      
    }

	@Override
	public String toString() {
		return "RecommendedInfo [explanation=" + explanation + "]";
	}

  }