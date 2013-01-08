package com.book.identification.model;

import javax.persistence.Entity;

/**
 * Author of this review.
 */
@Entity
public final class Author extends EntityBase {

	/**
	 * Name of this person. The value may be {@code null}.
	 */

	private String displayName;

	/**
	 * Name of this person. The value returned may be {@code null}.
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Name of this person. The value set may be {@code null}.
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;

	}

	@Override
	public String toString() {
		return "Author [displayName=" + displayName + "]";
	}

}