package com.book.identification.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/*
 * Copyright 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * Warning! This file is generated. Modify at your own risk.
 */

/**
 * Model definition for Review.
 * 
 * <p>
 * This is the Java data model class that specifies how to parse/serialize into
 * the JSON that is transmitted over HTTP when working with the Books API. For a
 * detailed explanation see: <a
 * href="http://code.google.com/p/google-api-java-client/wiki/Json"
 * >http://code.google.com/p/google-api-java-client/wiki/Json</a>
 * </p>
 * 
 * <p>
 * Upgrade warning: starting with version 1.12 {@code getResponseHeaders()} is
 * removed, instead use
 * {@link com.google.api.client.http.json.JsonHttpRequest#getLastResponseHeaders()}
 * </p>
 * 
 * @author Google, Inc.
 */
@Entity
public final class Review extends EntityBase {

	/**
	 * Author of this review. The value may be {@code null}.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Author author;

	/**
	 * Review text. The value may be {@code null}.
	 */

	private String content;

	/**
	 * Date of this review. The value may be {@code null}.
	 */

	private String date;

	/**
	 * URL for the full review text, for reviews gathered from the web. The
	 * value may be {@code null}.
	 */

	private String fullTextUrl;

	/**
	 * Resource type for a review. The value may be {@code null}.
	 */

	private String kind;

	/**
	 * Star rating for this review. Possible values are ONE, TWO, THREE, FOUR,
	 * FIVE or NOT_RATED. The value may be {@code null}.
	 */

	private String rating;

	/**
	 * Information regarding the source of this review, when the review is not
	 * from a Google Books user. The value may be {@code null}.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Source source;

	/**
	 * Title for this review. The value may be {@code null}.
	 */

	private String title;

	/**
	 * Source type for this review. Possible values are EDITORIAL, WEB_USER or
	 * GOOGLE_USER. The value may be {@code null}.
	 */

	private String type;

	/**
	 * Volume that this review is for. The value may be {@code null}.
	 */

	private String volumeId;

	/**
	 * Author of this review. The value returned may be {@code null}.
	 */
	public Author getAuthor() {
		return author;
	}

	/**
	 * Author of this review. The value set may be {@code null}.
	 */
	public void setAuthor(Author author) {
		this.author = author;

	}

	/**
	 * Review text. The value returned may be {@code null}.
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Review text. The value set may be {@code null}.
	 */
	public void setContent(String content) {
		this.content = content;

	}

	/**
	 * Date of this review. The value returned may be {@code null}.
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Date of this review. The value set may be {@code null}.
	 */
	public void setDate(String date) {
		this.date = date;

	}

	/**
	 * URL for the full review text, for reviews gathered from the web. The
	 * value returned may be {@code null}.
	 */
	public String getFullTextUrl() {
		return fullTextUrl;
	}

	/**
	 * URL for the full review text, for reviews gathered from the web. The
	 * value set may be {@code null}.
	 */
	public void setFullTextUrl(String fullTextUrl) {
		this.fullTextUrl = fullTextUrl;

	}

	/**
	 * Resource type for a review. The value returned may be {@code null}.
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * Resource type for a review. The value set may be {@code null}.
	 */
	public void setKind(String kind) {
		this.kind = kind;

	}

	/**
	 * Star rating for this review. Possible values are ONE, TWO, THREE, FOUR,
	 * FIVE or NOT_RATED. The value returned may be {@code null}.
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * Star rating for this review. Possible values are ONE, TWO, THREE, FOUR,
	 * FIVE or NOT_RATED. The value set may be {@code null}.
	 */
	public void setRating(String rating) {
		this.rating = rating;

	}

	/**
	 * Information regarding the source of this review, when the review is not
	 * from a Google Books user. The value returned may be {@code null}.
	 */
	public Source getSource() {
		return source;
	}

	/**
	 * Information regarding the source of this review, when the review is not
	 * from a Google Books user. The value set may be {@code null}.
	 */
	public void setSource(Source source) {
		this.source = source;

	}

	/**
	 * Title for this review. The value returned may be {@code null}.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Title for this review. The value set may be {@code null}.
	 */
	public void setTitle(String title) {
		this.title = title;

	}

	/**
	 * Source type for this review. Possible values are EDITORIAL, WEB_USER or
	 * GOOGLE_USER. The value returned may be {@code null}.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Source type for this review. Possible values are EDITORIAL, WEB_USER or
	 * GOOGLE_USER. The value set may be {@code null}.
	 */
	public void setType(String type) {
		this.type = type;

	}

	/**
	 * Volume that this review is for. The value returned may be {@code null}.
	 */
	public String getVolumeId() {
		return volumeId;
	}

	/**
	 * Volume that this review is for. The value set may be {@code null}.
	 */
	public void setVolumeId(String volumeId) {
		this.volumeId = volumeId;

	}

	@Override
	public String toString() {
		return "Review [author=" + author + ", content=" + content + ", date="
				+ date + ", fullTextUrl=" + fullTextUrl + ", kind=" + kind
				+ ", rating=" + rating + ", source=" + source + ", title="
				+ title + ", type=" + type + ", volumeId=" + volumeId + "]";
	}

}
