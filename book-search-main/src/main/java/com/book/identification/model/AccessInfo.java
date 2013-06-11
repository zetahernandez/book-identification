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

package com.book.identification.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Any information about a volume related to reading or obtaining that volume
 * text. This information can depend on country (books may be public domain in
 * one country but not in another, e.g.).
 */
@Entity
public final class AccessInfo extends EntityBase {

	/**
	 * Combines the access and viewability of this volume into a single status
	 * field for this user. Values can be FULL_PURCHASED, FULL_PUBLIC_DOMAIN,
	 * SAMPLE or NONE. (In LITE projection.) The value may be {@code null}.
	 */

	private String accessViewStatus;

	/**
	 * The two-letter ISO_3166-1 country code for which this access information
	 * is valid. (In LITE projection.) The value may be {@code null}.
	 */

	private String country;

	/**
	 * Information about a volume's download license access restrictions. The
	 * value may be {@code null}.
	 */

	/**
	 * Whether this volume can be embedded in a viewport using the Embedded
	 * Viewer API. The value may be {@code null}.
	 */

	private Boolean embeddable;

	/**
	 * Information about epub content. (In LITE projection.) The value may be
	 * {@code null}.
	 */
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Epub epub;

	/**
	 * Information about pdf content. (In LITE projection.) The value may be
	 * {@code null}.
	 */
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Pdf pdf;

	/**
	 * Whether or not this book is public domain in the country listed above.
	 * The value may be {@code null}.
	 */

	private Boolean publicDomain;

	/**
	 * Whether text-to-speech is permitted for this volume. Values can be
	 * ALLOWED, ALLOWED_FOR_ACCESSIBILITY, or NOT_ALLOWED. The value may be
	 * {@code null}.
	 */

	private String textToSpeechPermission;

	/**
	 * For ordered but not yet processed orders, we give a URL that can be used
	 * to go to the appropriate Google Wallet page. The value may be
	 * {@code null}.
	 */

	private String viewOrderUrl;

	/**
	 * The read access of a volume. Possible values are PARTIAL, ALL_PAGES,
	 * NO_PAGES or UNKNOWN. This value depends on the country listed above. A
	 * value of PARTIAL means that the publisher has allowed some portion of the
	 * volume to be viewed publicly, without purchase. This can apply to eBooks
	 * as well as non-eBooks. Public domain books will always have a value of
	 * ALL_PAGES. The value may be {@code null}.
	 */

	private String viewability;

	/**
	 * URL to read this volume on the Google Books site. Link will not allow
	 * users to read non- viewable volumes. The value may be {@code null}.
	 */

	private String webReaderLink;

	/**
	 * Combines the access and viewability of this volume into a single status
	 * field for this user. Values can be FULL_PURCHASED, FULL_PUBLIC_DOMAIN,
	 * SAMPLE or NONE. (In LITE projection.) The value returned may be
	 * {@code null}.
	 */
	public String getAccessViewStatus() {
		return accessViewStatus;
	}

	/**
	 * Combines the access and viewability of this volume into a single status
	 * field for this user. Values can be FULL_PURCHASED, FULL_PUBLIC_DOMAIN,
	 * SAMPLE or NONE. (In LITE projection.) The value set may be {@code null}.
	 */
	public void setAccessViewStatus(String accessViewStatus) {
		this.accessViewStatus = accessViewStatus;
	}

	/**
	 * The two-letter ISO_3166-1 country code for which this access information
	 * is valid. (In LITE projection.) The value returned may be {@code null}.
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * The two-letter ISO_3166-1 country code for which this access information
	 * is valid. (In LITE projection.) The value set may be {@code null}.
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Whether this volume can be embedded in a viewport using the Embedded
	 * Viewer API. The value returned may be {@code null}.
	 */
	public Boolean getEmbeddable() {
		return embeddable;
	}

	/**
	 * Whether this volume can be embedded in a viewport using the Embedded
	 * Viewer API. The value set may be {@code null}.
	 */
	public void setEmbeddable(Boolean embeddable) {
		this.embeddable = embeddable;
	}

	/**
	 * Information about epub content. (In LITE projection.) The value returned
	 * may be {@code null}.
	 */
	public Epub getEpub() {
		return epub;
	}

	/**
	 * Information about epub content. (In LITE projection.) The value set may
	 * be {@code null}.
	 */
	public void setEpub(Epub epub) {
		this.epub = epub;
	}

	/**
	 * Information about pdf content. (In LITE projection.) The value returned
	 * may be {@code null}.
	 */
	public Pdf getPdf() {
		return pdf;
	}

	/**
	 * Information about pdf content. (In LITE projection.) The value set may be
	 * {@code null}.
	 */
	public void setPdf(Pdf pdf) {
		this.pdf = pdf;
	}

	/**
	 * Whether or not this book is public domain in the country listed above.
	 * The value returned may be {@code null}.
	 */
	public Boolean getPublicDomain() {
		return publicDomain;
	}

	/**
	 * Whether or not this book is public domain in the country listed above.
	 * The value set may be {@code null}.
	 */
	public void setPublicDomain(Boolean publicDomain) {
		this.publicDomain = publicDomain;
	}

	/**
	 * Whether text-to-speech is permitted for this volume. Values can be
	 * ALLOWED, ALLOWED_FOR_ACCESSIBILITY, or NOT_ALLOWED. The value returned
	 * may be {@code null}.
	 */
	public String getTextToSpeechPermission() {
		return textToSpeechPermission;
	}

	/**
	 * Whether text-to-speech is permitted for this volume. Values can be
	 * ALLOWED, ALLOWED_FOR_ACCESSIBILITY, or NOT_ALLOWED. The value set may be
	 * {@code null}.
	 */
	public void setTextToSpeechPermission(String textToSpeechPermission) {
		this.textToSpeechPermission = textToSpeechPermission;
	}

	/**
	 * For ordered but not yet processed orders, we give a URL that can be used
	 * to go to the appropriate Google Wallet page. The value returned may be
	 * {@code null}.
	 */
	public String getViewOrderUrl() {
		return viewOrderUrl;
	}

	/**
	 * For ordered but not yet processed orders, we give a URL that can be used
	 * to go to the appropriate Google Wallet page. The value set may be
	 * {@code null}.
	 */
	public void setViewOrderUrl(String viewOrderUrl) {
		this.viewOrderUrl = viewOrderUrl;
	}

	/**
	 * The read access of a volume. Possible values are PARTIAL, ALL_PAGES,
	 * NO_PAGES or UNKNOWN. This value depends on the country listed above. A
	 * value of PARTIAL means that the publisher has allowed some portion of the
	 * volume to be viewed publicly, without purchase. This can apply to eBooks
	 * as well as non-eBooks. Public domain books will always have a value of
	 * ALL_PAGES. The value returned may be {@code null}.
	 */
	public String getViewability() {
		return viewability;
	}

	/**
	 * The read access of a volume. Possible values are PARTIAL, ALL_PAGES,
	 * NO_PAGES or UNKNOWN. This value depends on the country listed above. A
	 * value of PARTIAL means that the publisher has allowed some portion of the
	 * volume to be viewed publicly, without purchase. This can apply to eBooks
	 * as well as non-eBooks. Public domain books will always have a value of
	 * ALL_PAGES. The value set may be {@code null}.
	 */
	public void setViewability(String viewability) {
		this.viewability = viewability;
	}

	/**
	 * URL to read this volume on the Google Books site. Link will not allow
	 * users to read non- viewable volumes. The value returned may be
	 * {@code null}.
	 */
	public String getWebReaderLink() {
		return webReaderLink;
	}

	/**
	 * URL to read this volume on the Google Books site. Link will not allow
	 * users to read non- viewable volumes. The value set may be {@code null}.
	 */
	public void setWebReaderLink(String webReaderLink) {
		this.webReaderLink = webReaderLink;
	}

	@Override
	public String toString() {
		return "AccessInfo [accessViewStatus=" + accessViewStatus
				+ ", country=" + country + ", embeddable=" + embeddable
				+ ", epub=" + epub + ", pdf=" + pdf + ", publicDomain="
				+ publicDomain + ", textToSpeechPermission="
				+ textToSpeechPermission + ", viewOrderUrl=" + viewOrderUrl
				+ ", viewability=" + viewability + ", webReaderLink="
				+ webReaderLink + "]";
	}
	
}