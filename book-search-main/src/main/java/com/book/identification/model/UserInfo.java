package com.book.identification.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;


/**
   * User specific information related to this volume. (e.g. page this user last read or whether they
   * purchased this book)
   */
@Entity
  public final class UserInfo extends EntityBase{

    /**
     * Whether or not this volume is currently in "my books."
     * The value may be {@code null}.
     */
    
    private Boolean isInMyBooks;

    /**
     * Whether or not this volume was pre-ordered by the authenticated user making the request. (In
     * LITE projection.)
     * The value may be {@code null}.
     */
    
    private Boolean isPreordered;

    /**
     * Whether or not this volume was purchased by the authenticated user making the request. (In LITE
     * projection.)
     * The value may be {@code null}.
     */
    
    private Boolean isPurchased;
    

    /**
     * This user's review of this volume, if one exists.
     * The value may be {@code null}.
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Review review;

    /**
     * Timestamp when this volume was last modified by a user action, such as a reading position
     * update, volume purchase or writing a review. (RFC 3339 UTC date-time format).
     * The value may be {@code null}.
     */
    

    /**
     * Whether or not this volume is currently in "my books."
     * The value returned may be {@code null}.
     */
    public Boolean getIsInMyBooks() {
      return isInMyBooks;
    }

    /**
     * Whether or not this volume is currently in "my books."
     * The value set may be {@code null}.
     */
    public void setIsInMyBooks(Boolean isInMyBooks) {
      this.isInMyBooks = isInMyBooks;
      
    }

    /**
     * Whether or not this volume was pre-ordered by the authenticated user making the request. (In
     * LITE projection.)
     * The value returned may be {@code null}.
     */
    public Boolean getIsPreordered() {
      return isPreordered;
    }

    /**
     * Whether or not this volume was pre-ordered by the authenticated user making the request. (In
     * LITE projection.)
     * The value set may be {@code null}.
     */
    public void setIsPreordered(Boolean isPreordered) {
      this.isPreordered = isPreordered;
      
    }

    /**
     * Whether or not this volume was purchased by the authenticated user making the request. (In LITE
     * projection.)
     * The value returned may be {@code null}.
     */
    public Boolean getIsPurchased() {
      return isPurchased;
    }

    /**
     * Whether or not this volume was purchased by the authenticated user making the request. (In LITE
     * projection.)
     * The value set may be {@code null}.
     */
    public void setIsPurchased(Boolean isPurchased) {
      this.isPurchased = isPurchased;
      
    }


    /**
     * This user's review of this volume, if one exists.
     * The value returned may be {@code null}.
     */
    public Review getReview() {
      return review;
    }

    /**
     * This user's review of this volume, if one exists.
     * The value set may be {@code null}.
     */
    public void setReview(Review review) {
      this.review = review;
      
    }

	@Override
	public String toString() {
		return "UserInfo [isInMyBooks=" + isInMyBooks + ", isPreordered="
				+ isPreordered + ", isPurchased=" + isPurchased + ", review="
				+ review + "]";
	}


  }